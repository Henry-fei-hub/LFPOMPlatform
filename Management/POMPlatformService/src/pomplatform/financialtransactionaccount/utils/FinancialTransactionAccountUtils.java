package pomplatform.financialtransactionaccount.utils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.pomplatform.db.bean.BaseFinancialTransactionAccount;
import com.pomplatform.db.bean.BaseFinancialTransactionAccountLinkEntity;
import com.pomplatform.db.bean.BaseFinancialTransactionDetail;
import com.pomplatform.db.dao.FinancialTransactionAccount;
import com.pomplatform.db.dao.FinancialTransactionAccountLinkEntity;
import com.pomplatform.db.dao.FinancialTransactionDetail;
import com.pomplatform.db.dao.ReceiveUnitManage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.system.dao.Employee;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.exchangerate.utils.ExchangeRateUtils;
import pomplatform.financialtransactionaccount.bean.BaseBorrowMoneyTrans;
import pomplatform.financialtransactionaccount.bean.BaseEmployeeRepaymentTrans;
import pomplatform.financialtransactionaccount.bean.BaseNormalReimbursementTrans;
import pomplatform.financialtransactionaccount.bean.BasePayMoneyManageTrans;
import pomplatform.financialtransactionaccount.bean.BaseReceiveUnitRepaymentTrans;
import pomplatform.financialtransactionaccount.bean.BaseTravelReimbursementTrans;
import pomplatform.financialtransactionaccount.bean.ConditionBorrowMoneyTrans;
import pomplatform.financialtransactionaccount.bean.ConditionEmployeeRepaymentTrans;
import pomplatform.financialtransactionaccount.bean.ConditionNormalReimbursementTrans;
import pomplatform.financialtransactionaccount.bean.ConditionPayMoneyManageTrans;
import pomplatform.financialtransactionaccount.bean.ConditionReceiveUnitRepaymentTrans;
import pomplatform.financialtransactionaccount.bean.ConditionTravelReimbursementTrans;
import pomplatform.financialtransactionaccount.query.QueryBorrowMoneyTrans;
import pomplatform.financialtransactionaccount.query.QueryEmployeeRepaymentTrans;
import pomplatform.financialtransactionaccount.query.QueryNormalReimbursementTrans;
import pomplatform.financialtransactionaccount.query.QueryPayMoneyManageTrans;
import pomplatform.financialtransactionaccount.query.QueryReceiveUnitRepaymentTrans;
import pomplatform.financialtransactionaccount.query.QueryTravelReimbursementTrans;

public class FinancialTransactionAccountUtils {
	/**
	 * 账户类型：职员
	 */
	public static final int ACCOUNT_TYPE_EMPLOYEE = 1;
	/**
	 * 账户类型：收款单位
	 */
	public static final int ACCOUNT_TYPE_RECEIVE_UNIT = 2;
	/**
     * 账户状态：活动
     */
    public static final int ACCOUNT_STATUS_ACTIVE = 1;
    /**
     * 账户状态：冻结
     */
    public static final int ACCOUNT_STATUS_FROZEN = 2;
    /**
     * 账户状态：销户
     */
    public static final int ACCOUNT_STATUS_DESTORY = 3;
	
    /**
     * 创建财务往来账户
     * @param accountType	必填项：账户类型
     * @param financeNo		财务编号
     * @param accountName	账户名称
     * @param entryId		必填项：实体ID（职员、收款单位）
     */
    public static Integer createAccount(Integer accountType, String financeNo, String accountName, Integer entryId) {
    	return createAccount(accountType, financeNo, accountName, entryId, null, null, null);
    }
    
    /**
     * 创建财务往来账户
     * @param accountType	必填项：账户类型
     * @param financeNo		财务编号
     * @param accountName	账户名称
     * @param entryId		必填项：实体ID（职员、收款单位）
     * @param remark		备注
     * @param reimbursable	能否报销
     * @param accountStatus	账户状态
     * @return
     */
	public static Integer createAccount(Integer accountType, String financeNo, String accountName, Integer entryId, String remark, Boolean reimbursable, Integer accountStatus){
		if(null == accountType || null == entryId) {
			return null;
		}
		try {
			//如果账户名称为空，则根据账户类型和实体ID，找到实体的名称作为账户名称
			if(BaseHelpUtils.isNullOrEmpty(accountName)) {
				switch(accountType) {
				case ACCOUNT_TYPE_EMPLOYEE:
					Employee eDao = new Employee();
					eDao.unsetSelectFlags();
					eDao.setSelectEmployeeName(true);
					eDao.setEmployeeId(entryId);
					if(eDao.load()) {
						accountName = eDao.getEmployeeName();
					}
					break;
				case ACCOUNT_TYPE_RECEIVE_UNIT:
					ReceiveUnitManage unitDao = new ReceiveUnitManage();
					unitDao.unsetSelectFlags();
					unitDao.setSelectReceiveUnit(true);
					unitDao.setReceiveUnitManageId(entryId);
					if(unitDao.load()) {
						accountName = unitDao.getReceiveUnit();
					}
					break;
				default:
					break;
				}
			}
			FinancialTransactionAccount accountDao = new FinancialTransactionAccount();
			FinancialTransactionAccountLinkEntity linkDao = new FinancialTransactionAccountLinkEntity();
			if(!BaseHelpUtils.isNullOrEmpty(accountName)) {
				accountDao.setConditionAccountType("=", accountType);
				accountDao.setConditionAccountName("=", accountName);
				BaseFinancialTransactionAccount accountBean = accountDao.executeQueryOneRow();
				if(null != accountBean) {
					//该实体的财务往来账户已存在
					linkDao.setConditionFinancialTransactionAccountId("=", accountBean.getFinancialTransactionAccountId());
					linkDao.setConditionEntityId("=", entryId);
					if(linkDao.countRows() == 0) {
						//如果财务往来账户与该实体没有关联上，则添加关联
						linkDao.clear();
						linkDao.setFinancialTransactionAccountId(accountBean.getFinancialTransactionAccountId());
						linkDao.setAccountType(accountType);
						linkDao.setEntityId(entryId);
						linkDao.save();
					}
					//返回财务往来账户ID
					return accountBean.getFinancialTransactionAccountId();
				}
			}
			accountDao.clear();
			linkDao.clear();
			accountDao.setAccountType(accountType);
			accountDao.setFinanceNo(financeNo);
			accountDao.setAccountName(accountName);
			accountDao.setRemark(remark);
			if(null == reimbursable) {
				accountDao.setReimbursable(true);
			}else {
				accountDao.setReimbursable(reimbursable);
			}
			if(null == accountStatus) {
				accountDao.setAccountStatus(ACCOUNT_STATUS_ACTIVE);
			}else {
				accountDao.setAccountStatus(accountStatus);
			}
			accountDao.save();
			Integer accountId = accountDao.getFinancialTransactionAccountId();
			//将实体和财务的往来账户关联起来
			linkDao.setFinancialTransactionAccountId(accountId);
			linkDao.setAccountType(accountType);
			linkDao.setEntityId(entryId);
			linkDao.save();
			return accountId;
		} catch (SQLException e) {
			return null;
		}
	}
	
	/**
	 * 修改财务往来账户的主体信息
	 * @param bean
	 * @return
	 */
	public static boolean updateAccount(BaseFinancialTransactionAccount bean) {
		try {
			if(null == bean || null == bean.getFinancialTransactionAccountId()) {
				return false;
			}
			FinancialTransactionAccount dao = new FinancialTransactionAccount();
			dao.setPrimaryKeyFromBase(bean);
			if(!dao.load()) {
				return false;
			}
			dao.clearModifiedFlags();
			dao.setDataFromBase(bean);
			dao.update();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	/**
	 * 根据账户类型和实体ID(职员、收款单位)来获取其财务往来账号的ID
	 * @param accountType	必填项：账户类型
	 * @param entryId		必填项：实体ID
	 * @return
	 */
	public static Integer getAccountId(Integer accountType, Integer entryId) {
		if(null == accountType || null == entryId) {
			return null;
		}
		try {
			FinancialTransactionAccountLinkEntity linkDao = new FinancialTransactionAccountLinkEntity();
			linkDao.setConditionAccountType("=", accountType);
			linkDao.setConditionEntityId("=", entryId);
			BaseFinancialTransactionAccountLinkEntity linkBean = linkDao.executeQueryOneRow();
			if(null == linkBean) {
				return createAccount(accountType, null, null, entryId);
			}else {
				return linkBean.getFinancialTransactionAccountId();
			}
		}catch(SQLException e) {
			return null;
		}
	}
	
	public static BaseFinancialTransactionDetail generateTransDetailBean(String json, Integer transAccountId, Integer operatorAccountId, BigDecimal amount, boolean isDebit, BigDecimal rate, boolean isCompleted) throws Exception {
		BaseFinancialTransactionDetail bean = new BaseFinancialTransactionDetail();
		bean.setDataFromJSON(json);
		bean.setFinancialTransactionAccountId(transAccountId);
		bean.setOperatorAccountId(operatorAccountId);
		bean.setCreateTime(new Date());
		bean.setIsCompleted(isCompleted);
		if(null != bean.getSummary() && bean.getSummary().length() > 1024) {
			bean.setSummary(bean.getSummary().substring(0, 1024));
		}
		if(isDebit) {
			bean.setOriginalDebit(amount);
			bean.setOriginalCredit(BigDecimal.ZERO);
		}else {
			bean.setOriginalDebit(BigDecimal.ZERO);
			bean.setOriginalCredit(amount);
		}
		if(null != rate) {
			bean.setExchangeRate(rate);
			if(isDebit) {
				bean.setStandardDebit(amount.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP));
				bean.setStandardCredit(BigDecimal.ZERO);
			}else {
				bean.setStandardDebit(BigDecimal.ZERO);
				bean.setStandardCredit(amount.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP));
			}
		}else {
			bean.setStandardDebit(BigDecimal.ZERO);
			bean.setStandardCredit(BigDecimal.ZERO);
		}
		return bean;
	}
	
	public static void updateTransDetails(BaseFinancialTransactionDetail originalBean, String json, Integer transAccountId, Integer operatorAccountId, BigDecimal amount, boolean isDebit, BigDecimal rate, boolean isCompleted) throws Exception {
		if(null == originalBean) {
			return;
		}
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		if(null == amount || amount.compareTo(BigDecimal.ZERO) == 0) {
			dao.setPrimaryKeyFromBase(originalBean);
			dao.delete();
		}else {
			dao.setDataFromBase(originalBean);
			dao.clearModifiedFlags();
			BaseFinancialTransactionDetail bean = new BaseFinancialTransactionDetail();
			bean.setDataFromJSON(json);
			bean.setFinancialTransactionAccountId(transAccountId);
			bean.setOperatorAccountId(operatorAccountId);
			bean.setIsCompleted(isCompleted);
			if(null != bean.getSummary() && bean.getSummary().length() > 1024) {
				bean.setSummary(bean.getSummary().substring(0, 1024));
			}
			if(isDebit) {
				bean.setOriginalDebit(amount);
				bean.setOriginalCredit(BigDecimal.ZERO);
			}else {
				bean.setOriginalDebit(BigDecimal.ZERO);
				bean.setOriginalCredit(amount);
			}
			if(null != rate) {
				bean.setExchangeRate(rate);
				if(isDebit) {
					bean.setStandardDebit(amount.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP));
					bean.setStandardCredit(BigDecimal.ZERO);
				}else {
					bean.setStandardDebit(BigDecimal.ZERO);
					bean.setStandardCredit(amount.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP));
				}
			}else {
				bean.setStandardDebit(BigDecimal.ZERO);
				bean.setStandardCredit(BigDecimal.ZERO);
			}
			dao.setDataFromBase(bean);
			dao.update();
		}
	}
	
	/**
	 * 插入往来明细
	 * @throws SQLException 
	 */
	public static void saveFinancialTransactionDetails(Integer processType, Integer businessId) throws Exception {
		//摘要：报销编号 + 部门 + 员工 + 备注
		//日期为报销发起的日期
		//汇率问题
		if(null == processType || null == businessId) {
			return;
		}
		List<BaseFinancialTransactionDetail> list = new ArrayList<>();
		boolean isCompleted = false;
		switch (processType) {
		case StaticUtils.PROCESS_TYPE_2:
		case StaticUtils.PROCESS_TYPE_3:
		case StaticUtils.PROCESS_TYPE_8:
		case StaticUtils.PROCESS_TYPE_10:
			//日常报销
			ConditionNormalReimbursementTrans normalCondition = new ConditionNormalReimbursementTrans();
			normalCondition.setProcessType(processType);
			normalCondition.setBusinessId(businessId);
			QueryNormalReimbursementTrans normalQuery = new QueryNormalReimbursementTrans();
			BaseCollection<BaseNormalReimbursementTrans> normalBC = normalQuery.executeQuery(null, normalCondition);
			if(null != normalBC && null != normalBC.getCollections() && !normalBC.getCollections().isEmpty()) {
				for(BaseNormalReimbursementTrans normalBean : normalBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(normalBean.getPayFor(), normalBean.getEmployeeOrCompanyId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, normalBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(normalBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(normalBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != normalBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(normalBean.getCurrencyType(), normalBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(normalBean.getCurrencyType(), normalBean.getRecordDate());
					}
					if(Objects.equals(normalBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					if(!isNullOrZero(normalBean.getBalanceAmount())) {
						list.add(generateTransDetailBean(normalBean.toJSON(), transAccountId, operatorAccountId, normalBean.getBalanceAmount(), false, rate, isCompleted));
					}
					if(Objects.equals(normalBean.getPayFor(), StaticUtils.PAY_FOR_COMPANY) && !isNullOrZero(normalBean.getPayMoney())) {
						list.add(generateTransDetailBean(normalBean.toJSON(), transAccountId, operatorAccountId, normalBean.getPayMoney(), true, rate, isCompleted));
						list.add(generateTransDetailBean(normalBean.toJSON(), transAccountId, operatorAccountId, normalBean.getPayMoney(), false, rate, isCompleted));
					}
				}
			}
			break;
		case StaticUtils.PROCESS_TYPE_4:
		case StaticUtils.PROCESS_TYPE_5:
		case StaticUtils.PROCESS_TYPE_9:
			//差旅报销
			ConditionTravelReimbursementTrans travelCondition = new ConditionTravelReimbursementTrans();
			travelCondition.setProcessType(processType);
			travelCondition.setBusinessId(businessId);
			QueryTravelReimbursementTrans travelQuery = new QueryTravelReimbursementTrans();
			BaseCollection<BaseTravelReimbursementTrans> travelBC = travelQuery.executeQuery(null, travelCondition);
			if(null != travelBC && null != travelBC.getCollections() && !travelBC.getCollections().isEmpty()) {
				for(BaseTravelReimbursementTrans travelBean : travelBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(travelBean.getPayFor(), travelBean.getEmployeeOrCompanyId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, travelBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(travelBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(travelBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != travelBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(travelBean.getCurrencyType(), travelBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(travelBean.getCurrencyType(), travelBean.getRecordDate());
					}
					if(Objects.equals(travelBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					if(!isNullOrZero(travelBean.getBalanceAmount())) {
						list.add(generateTransDetailBean(travelBean.toJSON(), transAccountId, operatorAccountId, travelBean.getBalanceAmount(), false, rate, isCompleted));
					}
					if(Objects.equals(travelBean.getPayFor(), StaticUtils.PAY_FOR_COMPANY) && !isNullOrZero(travelBean.getPayMoney())) {
						list.add(generateTransDetailBean(travelBean.toJSON(), transAccountId, operatorAccountId, travelBean.getPayMoney(), true, rate, isCompleted));
						list.add(generateTransDetailBean(travelBean.toJSON(), transAccountId, operatorAccountId, travelBean.getPayMoney(), false, rate, isCompleted));
					}
				}
			}
			break;
		case StaticUtils.PROCESS_TYPE_6:
			//借款申请
			ConditionBorrowMoneyTrans borrowCondition = new ConditionBorrowMoneyTrans();
			borrowCondition.setProcessType(processType);
			borrowCondition.setBusinessId(businessId);
			QueryBorrowMoneyTrans borrowQuery = new QueryBorrowMoneyTrans();
			BaseCollection<BaseBorrowMoneyTrans> borrowBC = borrowQuery.executeQuery(null, borrowCondition);
			if(null != borrowBC && null != borrowBC.getCollections() && !borrowBC.getCollections().isEmpty()) {
				for(BaseBorrowMoneyTrans borrowBean : borrowBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(borrowBean.getPayFor(), borrowBean.getEmployeeOrCompanyId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, borrowBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(borrowBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(borrowBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != borrowBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(borrowBean.getCurrencyType(), borrowBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(borrowBean.getCurrencyType(), borrowBean.getRecordDate());
					}
					if(Objects.equals(borrowBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					if(null != borrowBean.getPayMoney() && borrowBean.getPayMoney().compareTo(BigDecimal.ZERO) != 0) {
						list.add(generateTransDetailBean(borrowBean.toJSON(), transAccountId, operatorAccountId, borrowBean.getPayMoney(), true, rate, isCompleted));
					}
				}
			}
			break;
		case StaticUtils.PROCESS_TYPE_7:
			//预付款申请
			ConditionPayMoneyManageTrans payCondition = new ConditionPayMoneyManageTrans();
			payCondition.setProcessType(processType);
			payCondition.setBusinessId(businessId);
			QueryPayMoneyManageTrans payQuery = new QueryPayMoneyManageTrans();
			BaseCollection<BasePayMoneyManageTrans> payBC = payQuery.executeQuery(null, payCondition);
			if(null != payBC && null != payBC.getCollections() && !payBC.getCollections().isEmpty()) {
				for(BasePayMoneyManageTrans payBean : payBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(payBean.getPayFor(), payBean.getEmployeeOrCompanyId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, payBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(payBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(payBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != payBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(payBean.getCurrencyType(), payBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(payBean.getCurrencyType(), payBean.getRecordDate());
					}
					if(Objects.equals(payBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					if(null != payBean.getPayMoney() && payBean.getPayMoney().compareTo(BigDecimal.ZERO) != 0) {
						list.add(generateTransDetailBean(payBean.toJSON(), transAccountId, operatorAccountId, payBean.getPayMoney(), true, rate, isCompleted));
					}
				}
			}
			break;
		case StaticUtils.PROCESS_TYPE_28:
			//员工还款申请
			ConditionEmployeeRepaymentTrans ertCondition = new ConditionEmployeeRepaymentTrans();
			ertCondition.setProcessType(processType);
			ertCondition.setBusinessId(businessId);
			QueryEmployeeRepaymentTrans ertQuery = new QueryEmployeeRepaymentTrans();
			BaseCollection<BaseEmployeeRepaymentTrans> ertBC = ertQuery.executeQuery(null, ertCondition);
			if(null != ertBC && null != ertBC.getCollections() && !ertBC.getCollections().isEmpty()) {
				for(BaseEmployeeRepaymentTrans ertBean : ertBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, ertBean.getParentId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, ertBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(ertBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(ertBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != ertBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(ertBean.getCurrencyType(), ertBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(ertBean.getCurrencyType(), ertBean.getRecordDate());
					}
					if(Objects.equals(ertBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					if(null != ertBean.getOriginalCredit() && ertBean.getOriginalCredit().compareTo(BigDecimal.ZERO) != 0) {
						list.add(generateTransDetailBean(ertBean.toJSON(), transAccountId, operatorAccountId, ertBean.getOriginalCredit(), false, rate, isCompleted));
					}
				}
			}
			break;
		case StaticUtils.PROCESS_TYPE_41:
			//外部公司还款申请
			ConditionReceiveUnitRepaymentTrans rurtCondition = new ConditionReceiveUnitRepaymentTrans();
			rurtCondition.setProcessType(processType);
			rurtCondition.setBusinessId(businessId);
			QueryReceiveUnitRepaymentTrans rurtQuery = new QueryReceiveUnitRepaymentTrans();
			BaseCollection<BaseReceiveUnitRepaymentTrans> rurtBC = rurtQuery.executeQuery(null, rurtCondition);
			if(null != rurtBC && null != rurtBC.getCollections() && !rurtBC.getCollections().isEmpty()) {
				for(BaseReceiveUnitRepaymentTrans rurtBean : rurtBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(ACCOUNT_TYPE_RECEIVE_UNIT, rurtBean.getParentId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, rurtBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(rurtBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(rurtBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != rurtBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(rurtBean.getCurrencyType(), rurtBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(rurtBean.getCurrencyType(), rurtBean.getRecordDate());
					}
					if(Objects.equals(rurtBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					if(null != rurtBean.getOriginalCredit() && rurtBean.getOriginalCredit().compareTo(BigDecimal.ZERO) != 0) {
						list.add(generateTransDetailBean(rurtBean.toJSON(), transAccountId, operatorAccountId, rurtBean.getOriginalCredit(), false, rate, isCompleted));
					}
				}
			}
			break;
		default:
			break;
		}
		if(!list.isEmpty()) {
			FinancialTransactionDetail dao = new FinancialTransactionDetail();
			dao.save(list);
		}
	}
	
	/**
	 * 删除汇总明细数据（直接删除，主要是用于流程中的单子，不使用逻辑删除，是因为有可能后续在流程中修改数据后，又需要生成汇总明细）
	 * @param processType
	 * @param businessId
	 * @throws Exception
	 */
	public static void deleteTransDetails(Integer processType, Integer businessId) throws Exception{
		if(null == processType || null == businessId) {
			return;
		}
		FinancialTransactionDetail dao = new FinancialTransactionDetail();
		dao.setConditionProcessType("=", processType);
		dao.setConditionBusinessId("=", businessId);
		dao.conditionalDelete();
	}
	
	/**
	 * 更新汇总明细数据
	 * @param processType
	 * @param businessId
	 * @throws Exception
	 */
	public static void updateFinancialTransactionDetails(Integer processType, Integer businessId) throws Exception {
		//摘要：报销编号 + 部门 + 员工 + 备注
		//日期为报销发起的日期
		//汇率问题
		if(null == processType || null == businessId) {
			return;
		}
		FinancialTransactionDetail ftdDao = new FinancialTransactionDetail();
		ftdDao.setConditionProcessType("=", processType);
		ftdDao.setConditionBusinessId("=", businessId);
		ftdDao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseFinancialTransactionDetail> originalList = ftdDao.conditionalLoad();
		List<BaseFinancialTransactionDetail> needToAddList = new ArrayList<>();
		boolean isCompleted = false;
		switch (processType) {
		case StaticUtils.PROCESS_TYPE_2:
		case StaticUtils.PROCESS_TYPE_3:
		case StaticUtils.PROCESS_TYPE_8:
		case StaticUtils.PROCESS_TYPE_10:
			//日常报销
			ConditionNormalReimbursementTrans normalCondition = new ConditionNormalReimbursementTrans();
			normalCondition.setProcessType(processType);
			normalCondition.setBusinessId(businessId);
			QueryNormalReimbursementTrans normalQuery = new QueryNormalReimbursementTrans();
			BaseCollection<BaseNormalReimbursementTrans> normalBC = normalQuery.executeQuery(null, normalCondition);
			if(null != normalBC && null != normalBC.getCollections() && !normalBC.getCollections().isEmpty()) {
				for(BaseNormalReimbursementTrans normalBean : normalBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(normalBean.getPayFor(), normalBean.getEmployeeOrCompanyId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, normalBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(normalBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(normalBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != normalBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(normalBean.getCurrencyType(), normalBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(normalBean.getCurrencyType(), normalBean.getRecordDate());
					}
					if(Objects.equals(normalBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					boolean found = false;
					for(BaseFinancialTransactionDetail obj : originalList) {
						if(Objects.equals(obj.getProcessBillListId(), normalBean.getProcessBillListId())) {
							if(!isNullOrZero(normalBean.getBalanceAmount()) && !isNullOrZero(obj.getStandardCredit())) {
								found = true;
								updateTransDetails(obj, normalBean.toJSON(), transAccountId, operatorAccountId, normalBean.getBalanceAmount(), false, rate, isCompleted);
							}else if(Objects.equals(normalBean.getPayFor(), StaticUtils.PAY_FOR_COMPANY) && !isNullOrZero(normalBean.getPayMoney())) {
								found = true;
								if(!isNullOrZero(obj.getStandardDebit())) {
									updateTransDetails(obj, normalBean.toJSON(), transAccountId, operatorAccountId, normalBean.getPayMoney(), true, rate, isCompleted);
								}else if(!isNullOrZero(obj.getStandardCredit())) {
									updateTransDetails(obj, normalBean.toJSON(), transAccountId, operatorAccountId, normalBean.getPayMoney(), false, rate, isCompleted);
								}
							}
							if(found) {
								break;
							}
						}
					}
					if(!found) {
						if(null != normalBean.getBalanceAmount() && normalBean.getBalanceAmount().compareTo(BigDecimal.ZERO) != 0) {
							needToAddList.add(generateTransDetailBean(normalBean.toJSON(), transAccountId, operatorAccountId, normalBean.getBalanceAmount(), false, rate, isCompleted));
						}
						if(Objects.equals(normalBean.getPayFor(), StaticUtils.PAY_FOR_COMPANY) && !isNullOrZero(normalBean.getPayMoney())) {
							needToAddList.add(generateTransDetailBean(normalBean.toJSON(), transAccountId, operatorAccountId, normalBean.getPayMoney(), true, rate, isCompleted));
							needToAddList.add(generateTransDetailBean(normalBean.toJSON(), transAccountId, operatorAccountId, normalBean.getPayMoney(), false, rate, isCompleted));
						}
					}
				}
				for(BaseFinancialTransactionDetail obj : originalList) {
					boolean found = false;
					for(BaseNormalReimbursementTrans normalBean : normalBC.getCollections()) {
						if(Objects.equals(obj.getProcessBillListId(), normalBean.getProcessBillListId())) {
							if(!isNullOrZero(normalBean.getBalanceAmount()) && !isNullOrZero(obj.getStandardCredit())) {
								found = true;
							}else if(Objects.equals(normalBean.getPayFor(), StaticUtils.PAY_FOR_COMPANY) && !isNullOrZero(normalBean.getPayMoney())) {
								found = true;
							}
							if(found) {
								break;
							}
						}
					}
					if(!found) {
						ftdDao.setPrimaryKeyFromBase(obj);
						ftdDao.delete();
					}
				}
			}else {
				deleteTransDetails(processType, businessId);
			}
			break;
		case StaticUtils.PROCESS_TYPE_4:
		case StaticUtils.PROCESS_TYPE_5:
		case StaticUtils.PROCESS_TYPE_9:
			//差旅报销
			ConditionTravelReimbursementTrans travelCondition = new ConditionTravelReimbursementTrans();
			travelCondition.setProcessType(processType);
			travelCondition.setBusinessId(businessId);
			QueryTravelReimbursementTrans travelQuery = new QueryTravelReimbursementTrans();
			BaseCollection<BaseTravelReimbursementTrans> travelBC = travelQuery.executeQuery(null, travelCondition);
			if(null != travelBC && null != travelBC.getCollections() && !travelBC.getCollections().isEmpty()) {
				for(BaseTravelReimbursementTrans travelBean : travelBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(travelBean.getPayFor(), travelBean.getEmployeeOrCompanyId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, travelBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(travelBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(travelBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != travelBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(travelBean.getCurrencyType(), travelBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(travelBean.getCurrencyType(), travelBean.getRecordDate());
					}
					if(Objects.equals(travelBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					boolean found = false;
					for(BaseFinancialTransactionDetail obj : originalList) {
						if(Objects.equals(obj.getProcessBillListId(), travelBean.getProcessBillListId())) {
							if(!isNullOrZero(travelBean.getBalanceAmount()) && !isNullOrZero(obj.getStandardCredit())) {
								found = true;
								updateTransDetails(obj, travelBean.toJSON(), transAccountId, operatorAccountId, travelBean.getBalanceAmount(), false, rate, isCompleted);
							}else if(Objects.equals(travelBean.getPayFor(), StaticUtils.PAY_FOR_COMPANY) && !isNullOrZero(travelBean.getPayMoney())) {
								found = true;
								if(!isNullOrZero(obj.getStandardDebit())) {
									updateTransDetails(obj, travelBean.toJSON(), transAccountId, operatorAccountId, travelBean.getPayMoney(), true, rate, isCompleted);
								}else if(!isNullOrZero(obj.getStandardCredit())) {
									updateTransDetails(obj, travelBean.toJSON(), transAccountId, operatorAccountId, travelBean.getPayMoney(), false, rate, isCompleted);
								}
							}
							if(found) {
								break;
							}
						}
					}
					if(!found) {
						if(null != travelBean.getBalanceAmount() && travelBean.getBalanceAmount().compareTo(BigDecimal.ZERO) != 0) {
							needToAddList.add(generateTransDetailBean(travelBean.toJSON(), transAccountId, operatorAccountId, travelBean.getBalanceAmount(), false, rate, isCompleted));
						}
						if(Objects.equals(travelBean.getPayFor(), StaticUtils.PAY_FOR_COMPANY) && !isNullOrZero(travelBean.getPayMoney())) {
							needToAddList.add(generateTransDetailBean(travelBean.toJSON(), transAccountId, operatorAccountId, travelBean.getPayMoney(), true, rate, isCompleted));
							needToAddList.add(generateTransDetailBean(travelBean.toJSON(), transAccountId, operatorAccountId, travelBean.getPayMoney(), false, rate, isCompleted));
						}
					}
				}
				for(BaseFinancialTransactionDetail obj : originalList) {
					boolean found = false;
					for(BaseTravelReimbursementTrans travelBean : travelBC.getCollections()) {
						if(Objects.equals(obj.getProcessBillListId(), travelBean.getProcessBillListId())) {
							if(!isNullOrZero(travelBean.getBalanceAmount()) && !isNullOrZero(obj.getStandardCredit())) {
								found = true;
							}else if(Objects.equals(travelBean.getPayFor(), StaticUtils.PAY_FOR_COMPANY) && !isNullOrZero(travelBean.getPayMoney())) {
								found = true;
							}
							if(found) {
								break;
							}
						}
					}
					if(!found) {
						ftdDao.setPrimaryKeyFromBase(obj);
						ftdDao.delete();
					}
				}
			}else {
				deleteTransDetails(processType, businessId);
			}
			break;
		case StaticUtils.PROCESS_TYPE_6:
			//借款申请
			ConditionBorrowMoneyTrans borrowCondition = new ConditionBorrowMoneyTrans();
			borrowCondition.setProcessType(processType);
			borrowCondition.setBusinessId(businessId);
			QueryBorrowMoneyTrans borrowQuery = new QueryBorrowMoneyTrans();
			BaseCollection<BaseBorrowMoneyTrans> borrowBC = borrowQuery.executeQuery(null, borrowCondition);
			if(null != borrowBC && null != borrowBC.getCollections() && !borrowBC.getCollections().isEmpty()) {
				for(BaseBorrowMoneyTrans borrowBean : borrowBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(borrowBean.getPayFor(), borrowBean.getEmployeeOrCompanyId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, borrowBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(borrowBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(borrowBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != borrowBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(borrowBean.getCurrencyType(), borrowBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(borrowBean.getCurrencyType(), borrowBean.getRecordDate());
					}
					if(Objects.equals(borrowBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					boolean found = false;
					for(BaseFinancialTransactionDetail obj : originalList) {
						if(Objects.equals(obj.getProcessBillListId(), borrowBean.getProcessBillListId())) {
							found = true;
							updateTransDetails(obj, borrowBean.toJSON(), transAccountId, operatorAccountId, borrowBean.getPayMoney(), true, rate, isCompleted);
							break;
						}
					}
					if(!found) {
						if(null != borrowBean.getPayMoney() && borrowBean.getPayMoney().compareTo(BigDecimal.ZERO) != 0) {
							needToAddList.add(generateTransDetailBean(borrowBean.toJSON(), transAccountId, operatorAccountId, borrowBean.getPayMoney(), true, rate, isCompleted));
						}
					}
				}
				for(BaseFinancialTransactionDetail obj : originalList) {
					boolean found = false;
					for(BaseBorrowMoneyTrans borrowBean : borrowBC.getCollections()) {
						if(Objects.equals(obj.getProcessBillListId(), borrowBean.getProcessBillListId())) {
							found = true;
							break;
						}
					}
					if(!found) {
						ftdDao.setPrimaryKeyFromBase(obj);
						ftdDao.delete();
					}
				}
			}else {
				deleteTransDetails(processType, businessId);
			}
			break;
		case StaticUtils.PROCESS_TYPE_7:
			//预付款申请
			ConditionPayMoneyManageTrans payCondition = new ConditionPayMoneyManageTrans();
			payCondition.setProcessType(processType);
			payCondition.setBusinessId(businessId);
			QueryPayMoneyManageTrans payQuery = new QueryPayMoneyManageTrans();
			BaseCollection<BasePayMoneyManageTrans> payBC = payQuery.executeQuery(null, payCondition);
			if(null != payBC && null != payBC.getCollections() && !payBC.getCollections().isEmpty()) {
				for(BasePayMoneyManageTrans payBean : payBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(payBean.getPayFor(), payBean.getEmployeeOrCompanyId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, payBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(payBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(payBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != payBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(payBean.getCurrencyType(), payBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(payBean.getCurrencyType(), payBean.getRecordDate());
					}
					if(Objects.equals(payBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					boolean found = false;
					for(BaseFinancialTransactionDetail obj : originalList) {
						if(Objects.equals(obj.getProcessBillListId(), payBean.getProcessBillListId())) {
							found = true;
							updateTransDetails(obj, payBean.toJSON(), transAccountId, operatorAccountId, payBean.getPayMoney(), true, rate, isCompleted);
							break;
						}
					}
					if(!found) {
						if(null != payBean.getPayMoney() && payBean.getPayMoney().compareTo(BigDecimal.ZERO) != 0) {
							needToAddList.add(generateTransDetailBean(payBean.toJSON(), transAccountId, operatorAccountId, payBean.getPayMoney(), true, rate, isCompleted));
						}
					}
				}
				for(BaseFinancialTransactionDetail obj : originalList) {
					boolean found = false;
					for(BasePayMoneyManageTrans payBean : payBC.getCollections()) {
						if(Objects.equals(obj.getProcessBillListId(), payBean.getProcessBillListId())) {
							found = true;
							break;
						}
					}
					if(!found) {
						ftdDao.setPrimaryKeyFromBase(obj);
						ftdDao.delete();
					}
				}
			}else {
				deleteTransDetails(processType, businessId);
			}
			break;
		case StaticUtils.PROCESS_TYPE_28:
			//员工还款申请
			ConditionEmployeeRepaymentTrans ertCondition = new ConditionEmployeeRepaymentTrans();
			ertCondition.setProcessType(processType);
			ertCondition.setBusinessId(businessId);
			QueryEmployeeRepaymentTrans ertQuery = new QueryEmployeeRepaymentTrans();
			BaseCollection<BaseEmployeeRepaymentTrans> ertBC = ertQuery.executeQuery(null, ertCondition);
			if(null != ertBC && null != ertBC.getCollections() && !ertBC.getCollections().isEmpty()) {
				for(BaseEmployeeRepaymentTrans ertBean : ertBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, ertBean.getParentId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, ertBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(ertBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(ertBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != ertBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(ertBean.getCurrencyType(), ertBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(ertBean.getCurrencyType(), ertBean.getRecordDate());
					}
					if(Objects.equals(ertBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					//员工还款申请只有一条记录，所以只需要update即可
					updateTransDetails(originalList.get(0), ertBean.toJSON(), transAccountId, operatorAccountId, ertBean.getOriginalCredit(), false, rate, isCompleted);
				}
			}else {
				deleteTransDetails(processType, businessId);
			}
			break;
		case StaticUtils.PROCESS_TYPE_41:
			//外部公司还款申请
			ConditionReceiveUnitRepaymentTrans rurtCondition = new ConditionReceiveUnitRepaymentTrans();
			rurtCondition.setProcessType(processType);
			rurtCondition.setBusinessId(businessId);
			QueryReceiveUnitRepaymentTrans rurtQuery = new QueryReceiveUnitRepaymentTrans();
			BaseCollection<BaseReceiveUnitRepaymentTrans> rurtBC = rurtQuery.executeQuery(null, rurtCondition);
			if(null != rurtBC && null != rurtBC.getCollections() && !rurtBC.getCollections().isEmpty()) {
				for(BaseReceiveUnitRepaymentTrans rurtBean : rurtBC.getCollections()) {
					//获取实际发生借贷的账户ID
					Integer transAccountId = getAccountId(ACCOUNT_TYPE_RECEIVE_UNIT, rurtBean.getParentId());
					if(null == transAccountId) {
						continue;
					}
					//获取经手人账户ID
					Integer operatorAccountId = getAccountId(ACCOUNT_TYPE_EMPLOYEE, rurtBean.getDrafter());
					if(null == operatorAccountId) {
						continue;
					}
					BigDecimal rate = null;
					if(Objects.equals(rurtBean.getCurrencyType(), StaticUtils.CURRENCY_0)) {
						rate = BigDecimal.ONE;
					}else if(Objects.equals(rurtBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED) && null != rurtBean.getCompleteTime()) {
						//如果货币类型不是人民币，流程已完成，且完成时间不为空，则需要获取完成时间所在月份的汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(rurtBean.getCurrencyType(), rurtBean.getCompleteTime());
					}else {
						//如果货币类型不是人民币，且流程未完成，则以创建时间去获取汇率
						rate = ExchangeRateUtils.getExchangeRateByDate(rurtBean.getCurrencyType(), rurtBean.getRecordDate());
					}
					if(Objects.equals(rurtBean.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
						isCompleted = true;
					}
					//外部公司还款申请只有一条记录，所以只需要update即可
					updateTransDetails(originalList.get(0), rurtBean.toJSON(), transAccountId, operatorAccountId, rurtBean.getOriginalCredit(), false, rate, isCompleted);
				}
			}
			break;
		default:
			break;
		}
		if(!needToAddList.isEmpty()) {
			ftdDao.clear();
			ftdDao.save(needToAddList);
		}
	}
	
	public static boolean isNullOrZero(BigDecimal number) {
		if(null == number || number.compareTo(BigDecimal.ZERO) == 0) {
			return true;
		}
		return false;
		
	}
}
