package pomplatform.financialStatements.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseCardManage;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.CardManage;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.financialStatements.bean.BaseFinancialBankAccountBalance;
import pomplatform.financialStatements.bean.BaseFinancialBankAccountInternalPayment;
import pomplatform.financialStatements.bean.BaseFinancialBankAccountPayment;
import pomplatform.financialStatements.bean.BaseFinancialBankAccountReceivables;
import pomplatform.financialStatements.bean.BaseFinancialCapitalAnalysis;
import pomplatform.financialStatements.bean.BaseFinancialCapitals;
import pomplatform.financialStatements.bean.BaseFinancialCompanyBalance;
import pomplatform.financialStatements.bean.BaseFinancialContractMoney;
import pomplatform.financialStatements.bean.BaseFinancialEmpAndPayMoney;
import pomplatform.financialStatements.bean.BaseFinancialInternalPayment;
import pomplatform.financialStatements.bean.BaseFinancialSubjectMoney;
import pomplatform.financialStatements.bean.ConditionFinancialBankAccountBalance;
import pomplatform.financialStatements.bean.ConditionFinancialBankAccountInternalPayment;
import pomplatform.financialStatements.bean.ConditionFinancialBankAccountPayment;
import pomplatform.financialStatements.bean.ConditionFinancialBankAccountReceivables;
import pomplatform.financialStatements.bean.ConditionFinancialCapitals;
import pomplatform.financialStatements.bean.ConditionFinancialCompanyBalance;
import pomplatform.financialStatements.bean.ConditionFinancialContractMoney;
import pomplatform.financialStatements.bean.ConditionFinancialEmpAndPayMoney;
import pomplatform.financialStatements.bean.ConditionFinancialInternalPayment;
import pomplatform.financialStatements.bean.ConditionFinancialSubjectMoney;
import pomplatform.financialStatements.query.QueryFinancialBankAccountBalance;
import pomplatform.financialStatements.query.QueryFinancialBankAccountInternalPayment;
import pomplatform.financialStatements.query.QueryFinancialBankAccountPayment;
import pomplatform.financialStatements.query.QueryFinancialBankAccountReceivables;
import pomplatform.financialStatements.query.QueryFinancialCapitals;
import pomplatform.financialStatements.query.QueryFinancialCompanyBalance;
import pomplatform.financialStatements.query.QueryFinancialContractMoney;
import pomplatform.financialStatements.query.QueryFinancialEmpAndPayMoney;
import pomplatform.financialStatements.query.QueryFinancialInternalPayment;
import pomplatform.financialStatements.query.QueryFinancialSubjectMoney;

public class FinancicalCapitalAnalysisProcess implements GenericProcessor{
	
	private final static int currentPage = 0;
	private final static int pageLines = 1;

	
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
				case "analysisCapitals":
					return analysisCapitals(result);
				case "analysisBankaccount":
					return analysisBankaccount(result);
			}
		}
		return null;
	}
	
	public String analysisBankaccount(Map<String, Object> params) throws Exception{
		int status = 1;
		BaseCollection<BaseFinancialCapitalAnalysis> bc = new BaseCollection<>();
		int companyId = BaseHelpUtils.getIntValue(params, "companyId");
		//获取该公司下的所有银行账号
		CardManage cmDao = new CardManage();
		cmDao.setConditionObjectType("=", 2);
		cmDao.setConditionObjectId("=", companyId);
		List<BaseCardManage> cmList = cmDao.conditionalLoad();
		if(cmList.size() > 0){
			Date beginDate = null == params.get("beginDate") ? null : new Date(Long.parseLong(params.get("beginDate").toString()));
			Date endDate = null == params.get("endDate") ? null : new Date(Long.parseLong(params.get("endDate").toString()));
			//查询出账号余额
			QueryFinancialBankAccountBalance fbabDao = new QueryFinancialBankAccountBalance();
			fbabDao.setCurrentPage(currentPage);
			fbabDao.setPageLines(pageLines);
			ConditionFinancialBankAccountBalance fbabCondition = new ConditionFinancialBankAccountBalance();
			fbabCondition.setMinHappenDate(beginDate);
			fbabCondition.setSelfName(companyId);
			BaseCollection<BaseFinancialBankAccountBalance> fbabResult = fbabDao.executeQuery(null, fbabCondition);
			List<BaseFinancialBankAccountBalance> fbabList = fbabResult.getCollections();
			
			//查询账号收款
			QueryFinancialBankAccountReceivables fbarDao = new QueryFinancialBankAccountReceivables();
			fbarDao.setCurrentPage(currentPage);
			fbarDao.setPageLines(pageLines);
			ConditionFinancialBankAccountReceivables fbarCondition = new ConditionFinancialBankAccountReceivables();
			fbarCondition.setSelfName(companyId);
			fbarCondition.setMinHappenDate(beginDate);
			fbarCondition.setMaxHappenDate(endDate);
			BaseCollection<BaseFinancialBankAccountReceivables> fbarResult = fbarDao.executeQuery(null, fbarCondition);
			List<BaseFinancialBankAccountReceivables> fbarList = fbarResult.getCollections();
			
			//查询账号付款
			QueryFinancialBankAccountPayment fbapDao = new QueryFinancialBankAccountPayment();
			fbapDao.setCurrentPage(currentPage);
			fbapDao.setPageLines(pageLines);
			ConditionFinancialBankAccountPayment fbapCondition = new ConditionFinancialBankAccountPayment();
			fbapCondition.setCompanyId(companyId);
			fbapCondition.setMinUpdateTime(beginDate);
			fbapCondition.setMaxUpdateTime(endDate);
			BaseCollection<BaseFinancialBankAccountPayment> fbapResult = fbapDao.executeQuery(null, fbapCondition);
			List<BaseFinancialBankAccountPayment> fbapList = fbapResult.getCollections();
			
			//内部往来银行账号付款
			QueryFinancialBankAccountInternalPayment fbaiDao = new QueryFinancialBankAccountInternalPayment();
			fbaiDao.setCurrentPage(currentPage);
			fbaiDao.setPageLines(pageLines);
			ConditionFinancialBankAccountInternalPayment fbaiCondition = new ConditionFinancialBankAccountInternalPayment();
			fbaiCondition.setObjectId(companyId);
			fbaiCondition.setMinHappenDate(beginDate);
			fbaiCondition.setMaxHappenDate(endDate);
			BaseCollection<BaseFinancialBankAccountInternalPayment> fbaiResult = fbaiDao.executeQuery(null, fbaiCondition);
			List<BaseFinancialBankAccountInternalPayment> fbaiList = fbaiResult.getCollections();
			
			List<BaseFinancialCapitalAnalysis> list = new ArrayList<>();
			for (BaseCardManage baseCardManage : cmList) {
				String bankAccount = baseCardManage.getBankAccount();
				BaseFinancialCapitalAnalysis tmpBean = new BaseFinancialCapitalAnalysis();
				//期初与期末
				BigDecimal initialBalance = BigDecimal.ZERO; //期初余额
				BigDecimal closingBalance = BigDecimal.ZERO; //期末余额
				//收款
				BigDecimal contractMoney = BigDecimal.ZERO; //合同款项
				BigDecimal rentReceivables = BigDecimal.ZERO; //房屋收款
				BigDecimal financingReceivables = BigDecimal.ZERO; //融资收款
				BigDecimal employeeRepayment = BigDecimal.ZERO; //员工还款
				BigDecimal preCollection = BigDecimal.ZERO; //预收款
				BigDecimal otherReceivables = BigDecimal.ZERO; //其它收款
				BigDecimal internalCollection = BigDecimal.ZERO; //内部收款
				//付款
				BigDecimal salary = BigDecimal.ZERO; //薪酬
				BigDecimal projectReimbursement = BigDecimal.ZERO; //项目报销
				BigDecimal rentPayment = BigDecimal.ZERO; //房租付款
				BigDecimal assetPurchase = BigDecimal.ZERO; //资产采购
				BigDecimal financingPayment = BigDecimal.ZERO; //融资付款
				BigDecimal employeeLoan = BigDecimal.ZERO; //员工借款
				BigDecimal prePayment = BigDecimal.ZERO; //预付款
				BigDecimal otherPayment = BigDecimal.ZERO; //其它付款
				BigDecimal internalPayment = BigDecimal.ZERO; //内部付款
				
				//统计期初余额
				for (BaseFinancialBankAccountBalance baseFinancialBankAccountBalance : fbabList) {
					if(baseFinancialBankAccountBalance.getSelfBankAccount().equals(bankAccount)){
						initialBalance = baseFinancialBankAccountBalance.getBeforeMoney();
						break;
					}
				}
				//按收款类型统计收款
				for (BaseFinancialBankAccountReceivables baseFinancialBankAccountReceivables : fbarList) {
					if(null != baseFinancialBankAccountReceivables.getAmount()){
						if(baseFinancialBankAccountReceivables.getSelfBankAccount().equals(bankAccount)){
							switch (baseFinancialBankAccountReceivables.getMoneyAttribute()) {
							case 1: //合同款
								contractMoney = contractMoney.add(baseFinancialBankAccountReceivables.getAmount());
								break;
							case 2: //房租
								rentReceivables = rentReceivables.add(baseFinancialBankAccountReceivables.getAmount());			
								break;
							case 3: //员工还款
								employeeRepayment = employeeRepayment.add(baseFinancialBankAccountReceivables.getAmount());
								break;
							case 4: //预收款
								preCollection = preCollection.add(baseFinancialBankAccountReceivables.getAmount());
								break;
							case 5://其它收款
							case 7:
							case 8:
								otherReceivables = otherReceivables.add(baseFinancialBankAccountReceivables.getAmount());
								break;
							case 6://内部往来收款	
								internalCollection = internalCollection.add(baseFinancialBankAccountReceivables.getAmount());
								break;
							default:
								break;
							}
						}
					}
				}
				//付款资金统计
				for (BaseFinancialBankAccountPayment baseFinancialBankAccountPayment : fbapList) {
					if(null != baseFinancialBankAccountPayment.getAmount()){
						if(baseFinancialBankAccountPayment.getOtherBankAccount().equals(bankAccount)){
							switch (baseFinancialBankAccountPayment.getType()) {
							case 1: //项目付款
								projectReimbursement = projectReimbursement.add(baseFinancialBankAccountPayment.getAmount());
								break;
							case 2: //借款
								employeeLoan = employeeLoan.add(baseFinancialBankAccountPayment.getAmount());
								break;
							case 3: //预付
								prePayment = prePayment.add(baseFinancialBankAccountPayment.getAmount());
								break;
							case 4: //其它
								otherPayment = otherPayment.add(baseFinancialBankAccountPayment.getAmount());
								break;
							default:
								break;
							}
						}
					}
				}
				//内部往来付款
				for (BaseFinancialBankAccountInternalPayment baseFinancialBankAccountInternalPayment : fbaiList) {
					if(null != baseFinancialBankAccountInternalPayment.getAmount()){
						if(baseFinancialBankAccountInternalPayment.getOtherBankAccount().equals(bankAccount)){
							internalPayment = internalPayment.add(baseFinancialBankAccountInternalPayment.getAmount());
							break;
						}
					}
				}
				
				//所有的收款
				BigDecimal allReceivables = contractMoney.add(rentReceivables).add(financingReceivables)
						.add(employeeRepayment).add(preCollection).add(otherReceivables).add(internalCollection);
				//所有的付款
				BigDecimal allPayment = salary.add(projectReimbursement).add(rentPayment).add(assetPurchase)
						.add(financingPayment).add(employeeLoan).add(prePayment).add(otherPayment).add(internalPayment);
				
				closingBalance = initialBalance.add(allReceivables.subtract(allPayment));
				
				tmpBean.setBankAccount(bankAccount);
				//设置期初与期末
				tmpBean.setInitialBalance(initialBalance);
				tmpBean.setClosingBalance(closingBalance);
				//设置收款金额
				tmpBean.setContractMoney(contractMoney);
				tmpBean.setRentReceivables(rentReceivables);
				tmpBean.setFinancingReceivables(financingReceivables);
				tmpBean.setEmployeeRepayment(employeeRepayment);
				tmpBean.setPreCollection(preCollection);
				tmpBean.setOtherReceivables(otherReceivables);
				tmpBean.setInternalCollection(internalCollection);
				//设置付款金额
				tmpBean.setSalary(salary);
				tmpBean.setProjectReimbursement(projectReimbursement);
				tmpBean.setRentPayment(rentPayment);
				tmpBean.setAssetPurchase(assetPurchase);
				tmpBean.setFinancingPayment(financingPayment);
				tmpBean.setEmployeeLoan(employeeLoan);
				tmpBean.setPrePayment(prePayment);
				tmpBean.setOtherPayment(otherPayment);
				tmpBean.setInternalPayment(internalPayment);
				list.add(tmpBean);
				bc.setCollections(list);
			}
		}
		return bc.toJSON(status, null);
	}
	
	/**
	 * 
	 * @Title: analysisCapitals 
	 * @Description: 归属公司方面的银行账号统计
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	public String analysisCapitals(Map<String, Object> params) throws Exception{
		int status  = 1;
		BaseCollection<BaseFinancialCapitalAnalysis> bc = new BaseCollection<>();
		String companyIds = BaseHelpUtils.getStringValue(params, "companyIds");
		if(BaseHelpUtils.isNullOrEmpty(companyIds)){
			SystemDictionary dao = new SystemDictionary();
			dao.setConditionDicTypeId("=", 26);
			List<BaseSystemDictionary> list = dao.conditionalLoad();
			if(list.size() > 0){
				for (int i = 0; i < list.size(); i++) {
					if(i != 0){
						companyIds += ",";
					}
					companyIds += list.get(i).getDicTypeValueId();
				}
			}
		}
		if(!BaseHelpUtils.isNullOrEmpty(companyIds)){
			Date beginDate = null == params.get("beginDate") ? null : new Date(Long.parseLong(params.get("beginDate").toString()));
			Date endDate = null == params.get("endDate") ? null : new Date(Long.parseLong(params.get("endDate").toString()));
			//财务收款数据
			QueryFinancialCapitals fcDao = new QueryFinancialCapitals();
			fcDao.setCurrentPage(currentPage);
			fcDao.setPageLines(pageLines);
			KeyValuePair []  kvArra = new KeyValuePair[1];
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("replace");
			kv.setValue(companyIds);
			kvArra[0] = kv;
			ConditionFinancialCapitals fcCondition = new ConditionFinancialCapitals();
			fcCondition.setMinHappenDate(beginDate);
			fcCondition.setMaxHappenDate(endDate);
			BaseCollection<BaseFinancialCapitals> fcResult = fcDao.executeQuery( kvArra, fcCondition);
			List<BaseFinancialCapitals> fcList = fcResult.getCollections();
			
			//公司账户余额查询
			QueryFinancialCompanyBalance fcbDao = new QueryFinancialCompanyBalance();
			fcbDao.setCurrentPage(currentPage);
			fcbDao.setPageLines(pageLines);
			ConditionFinancialCompanyBalance fcbCondition = new ConditionFinancialCompanyBalance();
			fcbCondition.setMinHappenDate(beginDate);
			BaseCollection<BaseFinancialCompanyBalance> fcbResult = fcbDao.executeQuery( kvArra, fcbCondition);
			List<BaseFinancialCompanyBalance> fcbList = fcbResult.getCollections();
			
			//归属公司项目报销款
			QueryFinancialContractMoney fcmDao = new QueryFinancialContractMoney();
			fcmDao.setCurrentPage(currentPage);
			fcmDao.setPageLines(pageLines);
			ConditionFinancialContractMoney fcmCondition = new ConditionFinancialContractMoney();
			fcmCondition.setMinUpdateTime(beginDate);
			fcmCondition.setMaxUpdateTime(endDate);
			BaseCollection<BaseFinancialContractMoney> fcmResult = fcmDao.executeQuery(kvArra, fcmCondition);
			List<BaseFinancialContractMoney> fcmList = fcmResult.getCollections();
			
			//员工借款与预付款
			QueryFinancialEmpAndPayMoney fepmDao = new QueryFinancialEmpAndPayMoney();
			fepmDao.setCurrentPage(currentPage);
			fepmDao.setPageLines(pageLines);
			ConditionFinancialEmpAndPayMoney fepmDaoCondition = new ConditionFinancialEmpAndPayMoney();
			fepmDaoCondition.setMinUpdateTime(beginDate);
			fepmDaoCondition.setMaxUpdateTime(endDate);
			BaseCollection<BaseFinancialEmpAndPayMoney> fepmResult = fepmDao.executeQuery(kvArra, fepmDaoCondition);
			List<BaseFinancialEmpAndPayMoney> fepmList = fepmResult.getCollections();
			
			//员工科目款
			QueryFinancialSubjectMoney dao = new QueryFinancialSubjectMoney();
			dao.setCurrentPage(currentPage);
			dao.setPageLines(pageLines);
			ConditionFinancialSubjectMoney fsmCondition = new ConditionFinancialSubjectMoney();
			fsmCondition.setMinUpdateTime(beginDate);
			fsmCondition.setMaxUpdateTime(endDate);
			BaseCollection<BaseFinancialSubjectMoney> fsmResult = dao.executeQuery(kvArra, fsmCondition);
			List<BaseFinancialSubjectMoney> fsmList = fsmResult.getCollections();
			
			//内部付款
			QueryFinancialInternalPayment fipDao = new QueryFinancialInternalPayment();
			fipDao.setCurrentPage(currentPage);
			fipDao.setPageLines(pageLines);
			ConditionFinancialInternalPayment fipCondition = new ConditionFinancialInternalPayment();
			fipCondition.setMinHappenDate(beginDate);
			fipCondition.setMaxHappenDate(endDate);
			BaseCollection<BaseFinancialInternalPayment> fipResult = fipDao.executeQuery( kvArra, fipCondition);
			List<BaseFinancialInternalPayment> fipList = fipResult.getCollections();
			
			String [] idsArra = companyIds.split(",");
			List<BaseFinancialCapitalAnalysis> list = new ArrayList<>();
			for (String string : idsArra) {
				int companyId = Integer.parseInt(string.trim());
				BaseFinancialCapitalAnalysis tmpBean = new BaseFinancialCapitalAnalysis();
				tmpBean.setCompanyId(companyId);
				//根据归属公司统计需要数据
				//期初与期末
				BigDecimal initialBalance = BigDecimal.ZERO; //期初余额
				BigDecimal closingBalance = BigDecimal.ZERO; //期末余额
				//收款
				BigDecimal contractMoney = BigDecimal.ZERO; //合同款项
				BigDecimal rentReceivables = BigDecimal.ZERO; //房屋收款
				BigDecimal financingReceivables = BigDecimal.ZERO; //融资收款
				BigDecimal employeeRepayment = BigDecimal.ZERO; //员工还款
				BigDecimal preCollection = BigDecimal.ZERO; //预收款
				BigDecimal otherReceivables = BigDecimal.ZERO; //其它收款
				BigDecimal internalCollection = BigDecimal.ZERO; //内部收款
				//付款
				BigDecimal salary = BigDecimal.ZERO; //薪酬
				BigDecimal projectReimbursement = BigDecimal.ZERO; //项目报销
				BigDecimal rentPayment = BigDecimal.ZERO; //房租付款
				BigDecimal assetPurchase = BigDecimal.ZERO; //资产采购
				BigDecimal financingPayment = BigDecimal.ZERO; //融资付款
				BigDecimal employeeLoan = BigDecimal.ZERO; //员工借款
				BigDecimal prePayment = BigDecimal.ZERO; //预付款
				BigDecimal otherPayment = BigDecimal.ZERO; //其它付款
				BigDecimal internalPayment = BigDecimal.ZERO; //内部付款
				
				//统计期初余额
				for (BaseFinancialCompanyBalance baseFinancialCompanyBalance : fcbList) {
					if(companyId == baseFinancialCompanyBalance.getSelfName()){
						initialBalance = baseFinancialCompanyBalance.getBeforeMoney();
						break;
					}
				}
				//按收款类型统计收款
				for (BaseFinancialCapitals baseFinancialCapitals : fcList) {
					if(null != baseFinancialCapitals.getAmount()){
						if(companyId == baseFinancialCapitals.getSelfName()){
							switch (baseFinancialCapitals.getMoneyAttribute()) {
							case 1: //合同款
								contractMoney = contractMoney.add(baseFinancialCapitals.getAmount());
								break;
							case 2: //房租
								rentReceivables = rentReceivables.add(baseFinancialCapitals.getAmount());			
								break;
							case 3: //员工还款
								employeeRepayment = employeeRepayment.add(baseFinancialCapitals.getAmount());
								break;
							case 4: //预收款
								preCollection = preCollection.add(baseFinancialCapitals.getAmount());
								break;
							case 5://其它收款
							case 7:
							case 8:
								otherReceivables = otherReceivables.add(baseFinancialCapitals.getAmount());
								break;
							case 6://内部往来收款	
								internalCollection = internalCollection.add(baseFinancialCapitals.getAmount());
							default:
								break;
							}
						}
					}
				}
				//项目报销款
				for (BaseFinancialContractMoney baseFinancialContractMoney : fcmList) {
					if(null != baseFinancialContractMoney.getAmount()){
						if(companyId == baseFinancialContractMoney.getCompanyId()){
							projectReimbursement = projectReimbursement.add(baseFinancialContractMoney.getAmount());
						}
					}
				}
				//员工借款与预付款
				for (BaseFinancialEmpAndPayMoney baseFinancialEmpAndPayMoney : fepmList) {
					if(null != baseFinancialEmpAndPayMoney.getAmount()){
						if(companyId == baseFinancialEmpAndPayMoney.getCompanyId()){
							if(baseFinancialEmpAndPayMoney.getProcessTypeId() == 6){//员工借款
								employeeLoan = employeeLoan.add(baseFinancialEmpAndPayMoney.getAmount());
							}else{
								prePayment = prePayment.add(baseFinancialEmpAndPayMoney.getAmount());
							}
						}
					}
				}
				//员工科目款
				for (BaseFinancialSubjectMoney baseFinancialSubjectMoney : fsmList) {
					if(null != baseFinancialSubjectMoney.getAmount()){
						if(companyId == baseFinancialSubjectMoney.getCompanyId()){
							otherPayment = otherPayment.add(baseFinancialSubjectMoney.getAmount());
						}
					}
				}
				//统计内部付款
				for (BaseFinancialInternalPayment baseFinancialInternalPayment : fipList) {
					if(null != baseFinancialInternalPayment.getAmount()){
						if(companyId == baseFinancialInternalPayment.getDicTypeValueId()){
							internalPayment = internalPayment.add(baseFinancialInternalPayment.getAmount());
							break;
						}
					}
				}
				
				//所有的收款
				BigDecimal allReceivables = contractMoney.add(rentReceivables).add(financingReceivables)
						.add(employeeRepayment).add(preCollection).add(otherReceivables).add(internalCollection);
				//所有的付款
				BigDecimal allPayment = salary.add(projectReimbursement).add(rentPayment).add(assetPurchase)
						.add(financingPayment).add(employeeLoan).add(prePayment).add(otherPayment).add(internalPayment);
				
				closingBalance = initialBalance.add(allReceivables.subtract(allPayment));
				
				//设置期初与期末
				tmpBean.setInitialBalance(initialBalance);
				tmpBean.setClosingBalance(closingBalance);
				//设置收款金额
				tmpBean.setContractMoney(contractMoney);
				tmpBean.setRentReceivables(rentReceivables);
				tmpBean.setFinancingReceivables(financingReceivables);
				tmpBean.setEmployeeRepayment(employeeRepayment);
				tmpBean.setPreCollection(preCollection);
				tmpBean.setOtherReceivables(otherReceivables);
				tmpBean.setInternalCollection(internalCollection);
				//设置付款金额
				tmpBean.setSalary(salary);
				tmpBean.setProjectReimbursement(projectReimbursement);
				tmpBean.setRentPayment(rentPayment);
				tmpBean.setAssetPurchase(assetPurchase);
				tmpBean.setFinancingPayment(financingPayment);
				tmpBean.setEmployeeLoan(employeeLoan);
				tmpBean.setPrePayment(prePayment);
				tmpBean.setOtherPayment(otherPayment);
				tmpBean.setInternalPayment(internalPayment);
				list.add(tmpBean);
				
			}
			bc.setCollections(list);
		}else{
			status = -1;
		}
		return bc.toJSON(status, null);
	}

	public static void main(String[] args) throws Exception {
		FinancicalCapitalAnalysisProcess f = new FinancicalCapitalAnalysisProcess();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("companyId", "0");
//		params.put("beginDate", new Date());
//		params.put("endDate", new Date());
		String aa = f.analysisBankaccount(params);
		System.out.println(aa);
	}
}
