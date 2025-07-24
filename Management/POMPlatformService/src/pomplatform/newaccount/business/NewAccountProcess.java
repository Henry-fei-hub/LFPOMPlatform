package pomplatform.newaccount.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseNewAccount;
import com.pomplatform.db.bean.BaseNewAccountTransation;
import com.pomplatform.db.dao.NewAccount;
import com.pomplatform.db.dao.NewAccountTransation;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class NewAccountProcess implements GenericProcessor {
	private static final Logger __logger = Logger.getLogger("");
	
	private final static SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");
	
	//价格审核的方法
	private final static String PRICEAUDITACCOUNT = "priceAuditAccount";
	
	//项目结算的方法
	private final static String  INTEGRALSETTLE = "integralSettle";
	
	//项目修改方法
	private final static String MODIFYPROJECT = "modifyProject";
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "optType");
		
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case PRICEAUDITACCOUNT:
				return priceAuditAccount(result);
			case INTEGRALSETTLE:
				return integralSettle(result);
			case MODIFYPROJECT:
				return modifyProject(result);
			}
		}
		return null;
	}
	/**
	 * 项目修改的方法
	 * @param result
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 */
	@SuppressWarnings("unused")
	private String modifyProject(Map<String, Object> result) throws SQLException, ParseException {
		int accountTypeCreate = BaseHelpUtils.getIntValue(result, "accountTypeCreate");
		int accountTypeUpdate = BaseHelpUtils.getIntValue(result, "accountTypeUpdate");
		String runningAccount = SDF.format(new Date());
		String orderId = BaseHelpUtils.getStringValue(result, "orderId");
		String balance = BaseHelpUtils.getStringValue(result, "balance");
		int projectId = BaseHelpUtils.getIntValue(result, "projectId");
		//分配的积分
		String originalCurrencyDebit = BaseHelpUtils.getStringValue(result,"originalCurrencyDebit");
		//预留积分
		String reserveIntegral = BaseHelpUtils.getStringValue(result, "reserveIntegral");
		String projectCode  = BaseHelpUtils.getStringValue(result, "projectCode");
		//业务部门ID
		int plateId = BaseHelpUtils.getIntValue(result, "plateId");
		int operator = BaseHelpUtils.getIntValue(result, "operator");
		Map<String, Object> param1 = new HashMap<>();
		param1.put("accountType", accountTypeCreate);
		param1.put("ownerId", plateId);
		param1.put("orderId", orderId);
		BaseNewAccount baseNewAccount = selectProjectteam(param1);
		//账户不存的情况
		if (baseNewAccount == null) {
			ThreadConnection.beginTransaction();
			Map<String, Object> param2 = new HashMap<>();
			param2.put("accountTypeCreate", 3);
			param2.put("accountName", "项目组账户");
			param2.put("ownerId", plateId);
			param2.put("status", 1);
			param2.put("balance", balance);
			param2.put("operator", operator);
			param2.put("balance", balance);
			param2.put("orderId", orderId);
			//创建项目组账户
			BaseNewAccount bean = createNewAccount(param2);
			if(BaseHelpUtils.isNullOrEmpty(bean)){
				throw new SQLException("操作异常：创建账户失败");
			}
			int accountId = bean.getAccountId();
			String accountCode = bean.getAccountCode();
			Map<String, Object> param3 = new HashMap<>();
			param3.put("accountId", accountId);
			param3.put("accountCode", accountCode);
			param3.put("originalCurrencyDebit", originalCurrencyDebit);
			param3.put("originalCurrencyLoan", 0);
			param3.put("exchangeRate", 1);
			param3.put("itemCategory", 4);
			param3.put("operator", operator);
			param3.put("mainProjectCode", projectId);
			param3.put("plateId", plateId);
			param3.put("runningAccount", runningAccount);
			//创建账户的流水
			createAccountTransation(param3);
			Map<String, Object> param5 = new HashMap<>();
			param5.put("orderId", orderId);
			param5.put("accountTypeUpdate", 2);
			param5.put("balance", balance);
			param5.put("type", 1);
			//更新订单余额
			BaseNewAccount baseNewAccount2 = updateNewAccount(param5);
			//更新余额的流水
			System.out.println("accoutn-=----------------------"+baseNewAccount2);
			if (baseNewAccount2 == null) {
				throw new SQLException("操作异常：更新账户失败");
			}
			Map<String, Object> param4 = new HashMap<>();
			param4.put("accountId", baseNewAccount2.getAccountId());
			param4.put("accountCode", baseNewAccount2.getAccountCode());
			param4.put("originalCurrencyDebit", 0);
			param4.put("originalCurrencyLoan", balance);
			param4.put("exchangeRate", 1);
			param4.put("itemCategory", 4);
			param4.put("mainProjectCode", projectId);
			param4.put("operator", operator);
			param4.put("plateId", plateId);
			param4.put("runningAccount", runningAccount);
			createAccountTransation(param4);
			ThreadConnection.commit();
		}
		else{//账户存在
			//账户原本余额
			BigDecimal originalBalance = baseNewAccount.getBalance();
			//本次输入的金额与原本金额的差值
			BigDecimal differenceValue = new BigDecimal(balance).subtract(originalBalance); 
			int i=differenceValue.compareTo(BigDecimal.ZERO); 
			if (i > 0) {
				//更新订单账户的余额
				Map<String, Object> params1 = new HashMap<>();
				params1.put("orderId", orderId);
				params1.put("accountTypeUpdate", 2);
				params1.put("balance", differenceValue);
				params1.put("type", 1);
				BaseNewAccount baseNewAccount2 = updateNewAccount(params1);
				//创建更新订单账户的流水
				if (baseNewAccount2 == null) {
					throw new SQLException("操作失败：更新账户的金额失败");
				}
				Map<String, Object> param2 = new HashMap<>();
				param2.put("accountId", baseNewAccount2.getAccountId());
				param2.put("accountCode", baseNewAccount2.getAccountCode());
				param2.put("originalCurrencyDebit", differenceValue);
				param2.put("originalCurrencyLoan", 0);
				param2.put("itemCategory", 3);
				param2.put("mainProjectCode", projectId);
				param2.put("operator", operator);
				param2.put("plateId", plateId);
				param2.put("runningAccount", runningAccount);
				createAccountTransation(param2);
				//更新项目组账户的余额
				Map<String , Object> params3 = new HashMap<>();
				params3.put("accountCode", baseNewAccount.getAccountCode());
				params3.put("accountTypeUpdate", 3);
				params3.put("balance", differenceValue);
				params3.put("type", 0);
				BaseNewAccount baseNewAccount3 = updateNewAccount(params3);
				//创建更新项目组账户的余额的流水
				Map<String, Object> param4 = new HashMap<>();
				param4.put("accountId", baseNewAccount3.getAccountId());
				param4.put("accountCode", baseNewAccount3.getAccountCode());
				param4.put("originalCurrencyDebit", 0);
				param4.put("originalCurrencyLoan", differenceValue);
				param4.put("itemCategory", 3);
				param4.put("mainProjectCode", projectId);
				param4.put("operator", operator);
				param4.put("plateId", plateId);
				param4.put("runningAccount", runningAccount);
				createAccountTransation(param4);
			}
			if (i < 0) {
				BigDecimal differenceValue1 = originalBalance.subtract(new BigDecimal(balance));
				//更新订单账户的余额
				Map<String, Object> params1 = new HashMap<>();
				params1.put("orderId", orderId);
				params1.put("accountTypeUpdate", 2);
				params1.put("balance", differenceValue1);
				params1.put("type", 0);
				BaseNewAccount baseNewAccount2 = updateNewAccount(params1);
				//创建更新订单账户的流水
				if (baseNewAccount2 == null) {
					throw new SQLException("操作失败：更新账户的金额失败");
				}
				Map<String, Object> param2 = new HashMap<>();
				param2.put("accountId", baseNewAccount2.getAccountId());
				param2.put("accountCode", baseNewAccount2.getAccountCode());
				param2.put("originalCurrencyDebit", 0);
				param2.put("originalCurrencyLoan", differenceValue1);
				param2.put("itemCategory", 3);
				param2.put("mainProjectCode", projectId);
				param2.put("plateId", plateId);
				param2.put("runningAccount", runningAccount);
				createAccountTransation(param2);
				//更新项目组账户的余额
				Map<String , Object> params3 = new HashMap<>();
				params3.put("accountCode", baseNewAccount.getAccountCode());
				params3.put("accountTypeUpdate", 3);
				params3.put("balance", differenceValue1);
				params3.put("type", 1);
				BaseNewAccount baseNewAccount3 = updateNewAccount(params3);
				//创建更新项目组账户的余额的流水
				Map<String, Object> param4 = new HashMap<>();
				param4.put("accountId", baseNewAccount3.getAccountId());
				param4.put("accountCode", baseNewAccount3.getAccountCode());
				param4.put("originalCurrencyDebit", differenceValue1);
				param4.put("originalCurrencyLoan", 0);
				param4.put("itemCategory", 3);
				param4.put("mainProjectCode", projectId);
				param4.put("plateId", plateId);
				param4.put("runningAccount", runningAccount);
				createAccountTransation(param4);
			}
		}
		return null;
	}

	/**
	 * 项目结算的方法
	 * @param result
	 * @return
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	@SuppressWarnings("unused")
	private String integralSettle(Map<String, Object> result) throws SQLException, ParseException {
		String runningAccount = SDF.format(new Date());
		List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("list");
		for (Map<String, Object> e : list) {
			int accountTypeCreate = 4;
			int accountTypeUpdate = 3;
			int ownerId = BaseHelpUtils.getIntValue(e, "employeeId");
			int employeeId = BaseHelpUtils.getIntValue(e, "employeeId");
			String orderId = BaseHelpUtils.getStringValue(e, "sheetCode");
			BigDecimal balance = BaseHelpUtils.getBigDecimalValue(e.get("realIntegral"));
			BigDecimal originalCurrencyDebit = BaseHelpUtils.getBigDecimalValue(e.get("realIntegral"));
			int operator = BaseHelpUtils.getIntValue(e, "operator");
			int projectId = BaseHelpUtils.getIntValue(e, "projectId");
			// 查询是否存在个人账户
			Map<String, Object> param1 = new HashMap<>();
			param1.put("ownerId", ownerId);
			param1.put("accountType", 4);
			param1.put("balance", balance);
			BaseNewAccount baseNewAccount = selectPersonAccount(param1);
			// 个人账户存在，直接更新账户余额并记录流水
			if (baseNewAccount != null) {
				// 更新个人账户
				String accountCode = baseNewAccount.getAccountCode();
				param1.put("accountCode", accountCode);
				BaseNewAccount baseNewAccount3 = updateNewAccount(param1);
				//更新个人账户的流水
				if (baseNewAccount3 != null) {
					int accountId = baseNewAccount3.getAccountId();
					Map<String, Object> param2 = new HashMap<>();
					param2.put("accountId", accountId);
					param2.put("accountCode", accountCode);
					param2.put("originalCurrencyDebit", 0);
					param2.put("originalCurrencyLoan", balance);
					param2.put("operator", operator);
					param2.put("exchangeRate", 1);
					param2.put("itemCategory", 5);
					param2.put("mainProjectCode", projectId);
					param2.put("employeeId", employeeId);
					param2.put("runningAccount", runningAccount);
					createAccountTransation(param2);
				}
				// 更新项目组账户
				Map<String, Object> param2 = new HashMap<>();
				param2.put("accountTypeUpdate", accountTypeUpdate);
				param2.put("orderId", orderId);
				param2.put("balance", balance);
				param2.put("type", 1);
				BaseNewAccount baseNewAccount2 = updateNewAccount(param2);
				// 创建项目组账户流水
				if (baseNewAccount2 != null) {
					int accountId = baseNewAccount2.getAccountId();
					String accountCode3 = baseNewAccount2.getAccountCode();
					Map<String, Object> param3 = new HashMap<>();
					param3.put("accountId", accountId);
					param3.put("accountCode", accountCode3);
					param3.put("originalCurrencyDebit", balance);
					param3.put("originalCurrencyLoan", 0);
					param3.put("operator", operator);
					param3.put("exchangeRate", 1);
					param3.put("itemCategory", 5);
					param3.put("mainProjectCode", projectId);
					param3.put("runningAccount", runningAccount);
					createAccountTransation(param3);
				}
			}
			// 个人账户不存在，创建账户并且记录流水
			else {
				ThreadConnection.beginTransaction();
				Map<String,Object> param = new HashMap<>();
				param.put("accountTypeCreate", accountTypeCreate);
				param.put("accountTypeUpdate", accountTypeUpdate);
				param.put("ownerId", ownerId);
				param.put("accountName", "个人账户");
				param.put("operator", operator);
				param.put("balance", balance);
				param.put("originalCurrencyDebit", originalCurrencyDebit);
				// 创建账户
				BaseNewAccount bean = createNewAccount(param);
				if (BaseHelpUtils.isNullOrEmpty(bean)) {
					throw new SQLException("操作异常：创建账户失败");
				}
				int accountId = bean.getAccountId();
				String accountCode = bean.getAccountCode();
				Map<String,Object> param4 = new HashMap<>();
				param4.put("accountId", accountId);
				param4.put("accountCode", accountCode);
				param4.put("originalCurrencyDebit", 0);
				param4.put("originalCurrencyLoan", balance);
				param4.put("exchangeRate", 1);
				param4.put("itemCategory", 5);
				param4.put("mainProjectCode", projectId);
				param4.put("employeeId", employeeId);
				param4.put("runningAccount", runningAccount);
				// 创建流水
				createAccountTransation(param4);
				__logger.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&"+accountTypeUpdate + "---" + orderId);
				// 更新项目组余额
				Map<String, Object> param2 = new HashMap<>();
				param2.put("accountTypeUpdate", accountTypeUpdate);
				param2.put("orderId", orderId);
				param2.put("balance", balance);
				param2.put("type", 1);
				BaseNewAccount baseNewAccount2 = updateNewAccount(param2);
				if (baseNewAccount2 == null) {
					throw new SQLException("操作错误：更新账户失败");
				}
				Map<String,Object> param5 = new HashMap<>();
				int accountId2 = baseNewAccount2.getAccountId();
				String accountCode2 = baseNewAccount2.getAccountCode();
				param5.put("accountId", accountId2);
				param5.put("accountCode", accountCode2);
				param5.put("originalCurrencyDebit", balance);
				param5.put("originalCurrencyLoan", 0);
				param5.put("exchangeRate", 1);
				param5.put("itemCategory", 5);
				param5.put("mainProjectCode", projectId);
				param5.put("runningAccount", runningAccount);
				//更新项目组的账户的流水
				createAccountTransation(param5);
				// //创建项目组账户流水
				// if (status != null) {
				// String accountCode2 = status;
				// Map<String, Object> param3 = new HashMap<>();
				// param3.put("accountCode", accountCode2);
				// param3.put("type", 1);
				// param3.put("originalCurrencyBorrow", balance);
				// }
				ThreadConnection.commit();
			}
		}
		return null;
	}


	/**
	 * 价格审核的方法
	 * @param result
	 * @return
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	private String priceAuditAccount(Map<String, Object> result) throws SQLException, ParseException {
		String runningAccount = SDF.format(new Date());
		List<Map<String, Object>> list = (List<Map<String, Object>>) result.get("list");
		int operator = BaseHelpUtils.getIntValue(result, "operator");
		for (Map<String, Object> map : list) {
			//订单编号
			String orderId = BaseHelpUtils.getStringValue(map, "subContractCode");
			//订单账户
			String accountType = "2";
			//账户名称
			String accountName = "订单账户";
			//账户的从属者(取出承接的部门)
			int ownerId = BaseHelpUtils.getIntValue(map, "departmentId");
			//账户的余额
			String balance = BaseHelpUtils.getStringValue(map, "sheetIntegral");
			Map<String, Object> params = new HashMap<>();
			params.put("accountTypeCreate", accountType);
			params.put("accountName", accountName);
			params.put("ownerId", ownerId);
			params.put("balance", balance);
			params.put("operator", operator);
			params.put("orderId", orderId);
			params.put("operator", operator);
			String type = "1";
			params.put("type", type);
			
			ThreadConnection.beginTransaction();
			//创建账户
			BaseNewAccount bean = createNewAccount(params);
			if(BaseHelpUtils.isNullOrEmpty(bean)){
				throw new SQLException("操作异常：创建账户失败");
			}
			int accountId = bean.getAccountId();
			String accountCode2 = bean.getAccountCode();
			Map<String, Object> params2 = new HashMap<>();
			params2.put("accountId", accountId);
			params2.put("accountCode", accountCode2);
			params2.put("originalCurrencyDebit", 0);
			params2.put("originalCurrencyLoan", balance);
			params2.put("exchangeRate", 1);
			params2.put("itemCategory", 2);
			params2.put("operator", operator);
			params2.put("plateId", ownerId);
			params2.put("runningAccount", runningAccount);
			//创建订单账户的流水
			createAccountTransation(params2);
			
			Map<String , Object> params4 = new HashMap<>();
			params4.put("accountCode", 1);
			params4.put("balance", balance);
			params4.put("type", 1);
			//更新余额
			BaseNewAccount baseNewAccount3 = updateNewAccount(params4);
			//创建更新余额的流水
			if (baseNewAccount3 == null) {
				throw new SQLException("操作错误：更新账户余额失败");
			}
			Map<String, Object> params3 = new HashMap<>();
			int accountId2 = baseNewAccount3.getAccountId();
			String accountCode = baseNewAccount3.getAccountCode();
			params3.put("accountId", accountId2);
			params3.put("accountCode", accountCode);
			params3.put("originalCurrencyDebit", balance);
			params3.put("originalCurrencyLoan", 0);
			params3.put("operator", operator);
			params3.put("exchangeRate", 1);
			params3.put("itemCategory", 2);
			params3.put("runningAccount", runningAccount);
			createAccountTransation(params3);
			ThreadConnection.commit();
		}
		return null;
	}


	/**
	 * 冻结账户
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	@SuppressWarnings("unused")
	private String freezeAccount(Map<String, Object> result) throws SQLException {
		
		return null;
	}
	
	/**
	 * 查询项目组账户是否存在
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	@SuppressWarnings("unused")
	private BaseNewAccount selectProjectteam(Map<String, Object> params ) throws SQLException{
		String orderId = BaseHelpUtils.getStringValue(params, "orderId");
		int accountType = 3 ;
		int ownerId = BaseHelpUtils.getIntValue(params, "ownerId");
		BaseNewAccount baseNewAccount = new BaseNewAccount();
		if (!BaseHelpUtils.isNullOrEmpty(orderId) && !BaseHelpUtils.isNullOrEmpty(accountType) && !BaseHelpUtils.isNullOrEmpty(ownerId)) {
			NewAccount dAccount = new NewAccount();
			dAccount.setConditionOrderId("=", orderId);
			dAccount.setConditionAccountType("=", accountType);
			dAccount.setConditionOwnerId("=", ownerId);
			baseNewAccount = dAccount.executeQueryOneRow();
			return baseNewAccount;
		}
		return null;
	}
	
	/**
	 * 查询个人账户是否存在
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	@SuppressWarnings("unused")
	private BaseNewAccount selectPersonAccount(Map<String, Object> params) throws SQLException{
		int employeeId = BaseHelpUtils.getIntValue(params, "ownerId");
		int accountType = BaseHelpUtils.getIntValue(params, "accountType");
		BaseNewAccount baseNewAccount = new BaseNewAccount();
		if (!BaseHelpUtils.isNullOrEmpty(employeeId) && !BaseHelpUtils.isNullOrEmpty(accountType)) {
			NewAccount dAccount = new NewAccount();
			dAccount.setConditionAccountType("=", accountType);
			dAccount.setConditionOwnerId("=", employeeId);
			baseNewAccount = dAccount.executeQueryOneRow();
		}
		return baseNewAccount;
	}

	/**
	 * 创建账户公用方法接口
	 * @param result
	 * @return
	 * @throws SQLException
	 */
	private BaseNewAccount createNewAccount(Map<String, Object> result) throws SQLException {
		BaseNewAccount bean = new BaseNewAccount();
		//获取账户类型
		int accountType = BaseHelpUtils.getIntValue(result, "accountTypeCreate");
		if (accountType <= 0) {
			throw new SQLException("创建账户异常：账户获取类型获取错误");
		}
		bean.setAccountType(accountType);
		//获取账户拥有者ID
		int ownerId = BaseHelpUtils.getIntValue(result, "ownerId");
		if(ownerId <= 0){
			throw new SQLException("创建账户异常：账户获取拥有者获取错误");
		}
		bean.setOwnerId(ownerId);
		//获取订单编号
		String orderId = BaseHelpUtils.getStringValue(result, "orderId");
		if (!BaseHelpUtils.isNullOrEmpty(orderId)) {
			bean.setOrderId(orderId);
		}
		//获取账户余额
		BigDecimal balance = BaseHelpUtils.getBigDecimalValue(result.get("balance"));
		bean.setBalance(balance);
		//获取账户名
		String accountName = BaseHelpUtils.getStringValue(result, "accountName");
		if (!BaseHelpUtils.isNullOrEmpty(accountName)) {
			bean.setAccountName(accountName);
		}
		//获取冻结余额
		BigDecimal freezingBalance = BaseHelpUtils.getBigDecimalValue(result.get("freezingBalance"));
		bean.setFreezingBalance(freezingBalance);
		//获取操作者
		int operator = BaseHelpUtils.getIntValue(result, "operator");
		if(operator > 0){
			bean.setOperator(operator);
		}
		Date currentDate = new Date();
		bean.setCreateTime(currentDate);
		bean.setStatus(1);
		String accountCode = SDF.format(currentDate) + Math.random() * (9999);
		String accountCode1 = accountCode.split(".")[0]; 
		bean.setAccountCode(accountCode1);
		NewAccount dao = new NewAccount();
		dao.setDataFromBase(bean);
		dao.save();
		return dao.generateBase();
	}
	
	/**
	 * 更新账户公用方法接口
	 * @param result
	 * @throws SQLException
	 */
	private BaseNewAccount updateNewAccount(Map<String, Object> result) throws SQLException {
		//获取账户编码
		String accountCode = BaseHelpUtils.getStringValue(result, "accountCode");
		if(!BaseHelpUtils.isNullOrEmpty(accountCode)){
			NewAccount dAccount = new NewAccount();
			dAccount.setConditionAccountCode("=",accountCode);
			BaseNewAccount baseNewAccount = dAccount.executeQueryOneRow();
			if(BaseHelpUtils.isNullOrEmpty(accountCode)){
				throw new SQLException("更新账户异常：加载账户失败");
			}
			//获取类型
			int type = BaseHelpUtils.getIntValue(result, "type");
			BigDecimal balance = BaseHelpUtils.getBigDecimalValue(result.get("balance"));
			if (balance.compareTo(BigDecimal.ZERO) > 0) {//支出
				if (type == 1) {
					BigDecimal originalBalance = baseNewAccount.getBalance();
					BigDecimal currentBalance = originalBalance.subtract(balance);
					baseNewAccount.setBalance(currentBalance);
				}else if(type == 0) {//收入
					BigDecimal originalBalance = baseNewAccount.getBalance();
					BigDecimal currentBalance = originalBalance.add(balance);
					baseNewAccount.setBalance(currentBalance);
				}
			}
			dAccount.setDataFromBase(baseNewAccount);
			dAccount.conditionalUpdate();
			return dAccount.generateBase();
			
		}
		//获取账户的订单Id和所属者Id以及账户的类型
		int accountType = BaseHelpUtils.getIntValue(result, "accountTypeUpdate");
		String 	orderId = BaseHelpUtils.getStringValue(result, "orderId");
		int ownerId = BaseHelpUtils.getIntValue(result, "ownerId");
		if (!(BaseHelpUtils.isNullOrEmpty(accountType) && BaseHelpUtils.isNullOrEmpty(orderId) && BaseHelpUtils.isNullOrEmpty(ownerId))) {
				NewAccount dAccount = new NewAccount();
				if (accountType != 0) {
					dAccount.setConditionAccountType("=",accountType);
				}
				if (!BaseHelpUtils.isNullOrEmpty(orderId)) {
					dAccount.setConditionOrderId("=",orderId);
				}
//				if (ownerId != 0) {
//					dAccount.setConditionOwnerId("=", ownerId);
//				}
				BaseNewAccount baseNewAccount = dAccount.executeQueryOneRow();
				int type = BaseHelpUtils.getIntValue(result, "type");
				BigDecimal balance = BaseHelpUtils.getBigDecimalValue(result.get("balance"));
				if (balance.compareTo(BigDecimal.ZERO) > 0) {//支出
					if (type == 1) {
						BigDecimal originalBalance = baseNewAccount.getBalance();
						BigDecimal currentBalance = originalBalance.subtract(balance);
						baseNewAccount.setBalance(currentBalance);
					}else if(type == 0) {//收入
						BigDecimal originalBalance = baseNewAccount.getBalance();
						BigDecimal currentBalance = originalBalance.add(balance);
						baseNewAccount.setBalance(currentBalance);
					}
				}
				dAccount.setDataFromBase(baseNewAccount);
				dAccount.conditionalUpdate();
				return dAccount.generateBase();
		}
		return null;
	}
	
	/**
	 * 创建账户流水公用方法接口
	 * @param result
	 * @return
	 * @throws SQLException
	 * @throws ParseException 
	 */
	private void createAccountTransation(Map<String, Object> result) throws SQLException, ParseException {
		BaseNewAccountTransation bean = new BaseNewAccountTransation();
		//获取账户id
		int accountId = BaseHelpUtils.getIntValue(result, "accountId");
		if (accountId <= 0) {
			throw new SQLException("创建流水异常：获取账户ID失败");
		}
		bean.setAccountId(accountId);
		//获取原币借
		BigDecimal originalCurrencyDebit = BaseHelpUtils.getBigDecimalValue(result.get("originalCurrencyDebit"));
		bean.setOriginalCurrencyDebit(originalCurrencyDebit);
		//获取原币贷
		BigDecimal originalCurrencyLoan = BaseHelpUtils.getBigDecimalValue(result.get("originalCurrencyLoan"));
		bean.setOriginalCurrencyLoan(originalCurrencyLoan);
		//计算本位币借
		BigDecimal standardMoneyDebit = originalCurrencyDebit.multiply(new BigDecimal("1"));
		bean.setStandardMoneyDebit(standardMoneyDebit);
		//计算本位币贷
		BigDecimal standardMoneyLoan = originalCurrencyLoan.multiply(new BigDecimal("1"));
		bean.setStandardMoneyLoan(standardMoneyLoan);
		//设置汇率
		bean.setExchangeRate(new BigDecimal("1"));
		//获取事项类别
		int itemCategory = BaseHelpUtils.getIntValue(result, "itemCategory");
		bean.setItemCategory(itemCategory);
		//获取主项目ID
		String mainProjectCode = BaseHelpUtils.getStringValue(result, "mainProjectCode");
		if (!BaseHelpUtils.isNullOrEmpty(mainProjectCode)) {
			bean.setMainProjectCode(mainProjectCode);
		}
		//获取合同id
		int contractId = BaseHelpUtils.getIntValue(result, "contractId");
		if (contractId > 0) {
			bean.setContractId(contractId);
		}
		//获取部门id
		int departmentId = BaseHelpUtils.getIntValue(result, "departmentId");
		bean.setDepartmentId(departmentId);
		//获取业务部门
		int plateId = BaseHelpUtils.getIntValue(result, "plateId");
		if (plateId > 0) {
			bean.setPlateId(plateId);
		}
		//获取员工id
		int employeeId = BaseHelpUtils.getIntValue(result,"employeeId");
		if (employeeId > 0) {
			bean.setEmployeeId(employeeId);
		}
		Date currentDate = new Date();
		bean.setRecordDate(currentDate);
		String affiliationDate = BaseHelpUtils.getStringValue(result, "affiliationDate");
		if (!BaseHelpUtils.isNullOrEmpty(affiliationDate)) {
			java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
			Date date =  formatter.parse(affiliationDate);
			bean.setAffiliationDate(date);
		}
		//获取备注信息
		String remark = BaseHelpUtils.getStringValue(result, "remark");
		if (!BaseHelpUtils.isNullOrEmpty(remark)) {
			bean.setRemark(remark);
		}
		//获取流水号信息
		String runningAccount = BaseHelpUtils.getStringValue(result, "runningAccount");
		if (!BaseHelpUtils.isNullOrEmpty(runningAccount)) {
			bean.setRunningAccount(runningAccount);
		}
		//获取账号
		String accountCode = BaseHelpUtils.getStringValue(result, "accountCode");
		if (!BaseHelpUtils.isNullOrEmpty(accountCode)) {
			bean.setAccountCode(accountCode);
		}
		if(!BaseHelpUtils.isNullOrEmpty(bean)){
			NewAccountTransation dao = new NewAccountTransation();
			dao.setDataFromBase(bean);
			dao.save();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		NewAccount newAccount = new NewAccount();
		newAccount.setAccountCode("1");
		newAccount.setAccountType(1);
		newAccount.setAccountName("合同账户");
		newAccount.setOwnerId(1);
		newAccount.setBalance(new BigDecimal("100000000"));
		newAccount.save();
//		NewAccountProcess aNewAccountProcess = new NewAccountProcess();
//		Map<String, Object> params = new HashMap<>();
//		params.put("optType", "priceAuditAccount");
//		params.put("orderId", 1);
//		params.put("accountType", 2);
//		params.put("type", 1);
//		params.put("ownerId", 1);
//		params.put("balance", 333);
//		params.put("operator", 1);
//		List<Map<String, Object>> list = new ArrayList<>();
//		list.add(params);
//		Map<String, Object> params2 = new HashMap<>();
//		params2.put("list", list);
//		
////		String ss = "{\"optType\": \"priceAuditAccount\",\"orderId\":1,\"accountType\":2,\"type\":1,\"ownerId\":1,\"balance\":333,\"operator\":1}";
//		System.out.println(aNewAccountProcess.execute(params2.toString(),null));
	}

}
