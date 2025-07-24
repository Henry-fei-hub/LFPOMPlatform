package pomplatform.sprocessbilllistpppor.handler;

import java.io.File;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCardManage;
import com.pomplatform.db.bean.BaseEmployeeFundIssuance;
import com.pomplatform.db.bean.BaseEmployeeFundIssuanceDetail;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.dao.Bank;
import com.pomplatform.db.dao.CardManage;
import com.pomplatform.db.dao.EmployeeFundIssuance;
import com.pomplatform.db.dao.EmployeeFundIssuanceDetail;
import com.pomplatform.db.dao.K3Code;
import com.pomplatform.db.dao.ProcessBillList;
import com.pomplatform.db.dao.ReceiveUnitManage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.Employee;
import pomplatform.common.utils.StaticUtils;
import pomplatform.domain.bean.BaseSemployeepdror;
import pomplatform.payment.bean.BaseOnSalaryAnnualBonusByCompany;
import pomplatform.payment.bean.BaseOnSalaryBonusTotalData;
import pomplatform.payment.bean.BaseOnSalaryReportByCompany;
import pomplatform.reimbursementpackage.business.ReimbursementPackageProcessor;
import pomplatform.sinvoiceitior.bean.CustomBaseIddStrVal;

public class CustomSprocessbilllistppporProcess implements GenericProcessor, GenericDownloadProcessor {
	
	private static final Logger __logger = Logger.getLogger(CustomSprocessbilllistppporProcess.class);
	
	private final static String GET_RECEIVE_UNIT_INFO_BY_ID = "getReceiveUnitInfoById";//根据主键获取收款单位信息
	
	private final static String ADD_RECEIVE_UNIT_INFO = "addReceiveUnitInfo";//添加收款单位数据
	
	private final static String GET_RECEIVE_UNIT_LIST = "getReceiveUnitList";//获取收款单位列表数据
	
	private final static String GET_EMPLOYEE_BANK_INFO_BY_ID = "getEmployeeBankInfoById";//根绝员工Id获取员工银行信息
	
	private final static String GET_BILL_LIST_BY_BUSINESSID_PROCESSTYPE = "getBillListByBusinessidProcesstype";
	
	private final static String GET_BANK_ADDRESS_BY_COMPANY = "getBankAddressByCompany";//根据公司查看单位办卡地址
	
	private final static String GET_BANKCARD_BY_CMP_AND_ADDRESS = "getBankcardByCmpAndAddress";//根据公司与办卡地址查询银行账号
	
	private final static String CHECK_RECEIVE_UNIT_INFO = "checkReceiveUnitInfo";//检测添加收款单位时是否存在重复添加
	
	private final static String GET_RECEIVE_UNIT_INFO_BY_NAME = "getReceiveUnitInfoByName";//根据名称获取收款单位信息
	
	private final static String GET_RECEIVE_NAME_UNIT_LIST = "getReceiveUnitNameList";//获取收款单位列表数据
	
	private final static String GET_SALARY_RECEIVE_UNIT_MANAGES = "getSalaryReceiveUnitManages";//获取工资发放的收款单位数据
	
	private final static String GET_SALARY_BONUS_RECEIVE_UNIT_MANAGES = "getSalaryBonusReceiveUnitManages";//获取奖金发放的收款单位数据
	
	private final static String GET_SALARY_ANNUAL_BONUS_RECEIVE_UNIT_MANAGES = "getSalaryAnnualBonusReceiveUnitManages";//获取年终奖金发放的收款单位数据
	
	@SuppressWarnings("unchecked")
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
				case GET_RECEIVE_UNIT_INFO_BY_ID:
					return getReceiveUnitInfoById(result);
				case ADD_RECEIVE_UNIT_INFO:
					return addReceiveUnitInfo(result);
				case GET_RECEIVE_UNIT_LIST:
					return getReceiveUnitList(result);
				case GET_EMPLOYEE_BANK_INFO_BY_ID:	
					return getEmployeeBankInfoById(result);
				case GET_BILL_LIST_BY_BUSINESSID_PROCESSTYPE:
					return getBillListByBusinessidProcesstype(result);
				case GET_BANK_ADDRESS_BY_COMPANY:
					return getBankAddressByCompany(result);
				case GET_BANKCARD_BY_CMP_AND_ADDRESS:
					return getBankcardByCmpAndAddress(result);
				case CHECK_RECEIVE_UNIT_INFO:
					return checkReceiveUnitInfo(result);
				case GET_RECEIVE_UNIT_INFO_BY_NAME:
					return getReceiveUnitInfoByName(result);
				case GET_RECEIVE_NAME_UNIT_LIST:
					return getReceiveUnitNameList(result);
				case GET_SALARY_RECEIVE_UNIT_MANAGES:
					return getSalaryReceiveUnitManages(result);
				case GET_SALARY_BONUS_RECEIVE_UNIT_MANAGES:
					return getSalaryBonusReceiveUnitManages(result);
				case GET_SALARY_ANNUAL_BONUS_RECEIVE_UNIT_MANAGES:
					return getSalaryAnnualBonusReceiveUnitManages(result);
			}
		}
		return null;
	}
	
	/**
	 * 寻找跟年终奖有关的收款单位数据生成账单流水
	 * @param result
	 * @return
	 * @throws Exception
	 */
	private String getSalaryAnnualBonusReceiveUnitManages(Map<String, Object> result) throws Exception{
		int status = 1;
		String errorMsg = null;
		BaseOnSalaryAnnualBonusByCompany bean = new BaseOnSalaryAnnualBonusByCompany();
		bean.setDataFromMap(result);
		BaseCollection<BaseProcessBillList> bc = new BaseCollection<>();
		if(null != bean.getCompanyId()){
			
			ReceiveUnitManage dao = new ReceiveUnitManage();
			dao.setConditionReceiveUnitType("=", 1);
			List<BaseReceiveUnitManage> ruList = dao.conditionalLoad();
			List<BaseProcessBillList> pbList = new ArrayList<>();
			for (BaseReceiveUnitManage baseReceiveUnitManage : ruList) {
				if(null != baseReceiveUnitManage.getSalaryType()){
					if(null != baseReceiveUnitManage.getCompanyId()){
						String [] companyIds = baseReceiveUnitManage.getCompanyId().split(",");
						boolean flag = false;
						for (String string : companyIds) {
							if(string.equals(bean.getCompanyId().toString())){
								flag = true;
								break;
							}
						}
						if(flag){
							BaseProcessBillList tmpBean = new BaseProcessBillList();
							tmpBean.setPayeeName(baseReceiveUnitManage.getReceiveUnit());
							tmpBean.setSelfBankAccount(baseReceiveUnitManage.getBankAccount());
							tmpBean.setSelfBankName(baseReceiveUnitManage.getBankName());
							tmpBean.setPayFor(2);
							tmpBean.setEmployeeOrCompanyId(baseReceiveUnitManage.getReceiveUnitManageId());
							tmpBean.setRemark("应纳个税");
							tmpBean.setBalanceAmount(bean.getShouldTax());
							tmpBean.setCompanyId(bean.getCompanyId());
							tmpBean.setYear(bean.getYear());
							tmpBean.setPayType(3);
							pbList.add(tmpBean);
						}
					}else{
						BaseProcessBillList tmpBean = new BaseProcessBillList();
						tmpBean.setPayeeName(baseReceiveUnitManage.getReceiveUnit());
						tmpBean.setSelfBankAccount(baseReceiveUnitManage.getBankAccount());
						tmpBean.setSelfBankName(baseReceiveUnitManage.getBankName());
						tmpBean.setPayFor(2);
						tmpBean.setEmployeeOrCompanyId(baseReceiveUnitManage.getReceiveUnitManageId());
						tmpBean.setCompanyId(bean.getCompanyId());
						tmpBean.setYear(bean.getYear());
						tmpBean.setPayType(3);
						if(baseReceiveUnitManage.getSalaryType() == 1){//实付奖金
							tmpBean.setPayMoney(bean.getFactBonus());
							tmpBean.setRemark("实付奖金");
							pbList.add(tmpBean);
						}
					}
				}
			}
			if(pbList.size() > 0){
				bc.setCollections(pbList);
			}else{
				status = -1;
				errorMsg = "没有找所需要的收款单位";
			}
		}
		return bc.toJSON(status, errorMsg);
	} 
	
	/**
	 * 获取薪资发放所需要的收款单位
	 * @param result
	 * @return
	 * @throws Exception
	 */
	private String getSalaryBonusReceiveUnitManages(Map<String, Object> result) throws Exception{
		int status = 1;
		String errorMsg = null;
		BaseOnSalaryBonusTotalData bean = new BaseOnSalaryBonusTotalData();
		bean.setDataFromMap(result);
		BaseCollection<BaseProcessBillList> bc = new BaseCollection<>();
		if(null != bean.getCompanyId()){
			
			ReceiveUnitManage dao = new ReceiveUnitManage();
			dao.setConditionReceiveUnitType("=", 1);
			List<BaseReceiveUnitManage> ruList = dao.conditionalLoad();
			List<BaseProcessBillList> pbList = new ArrayList<>();
			int personnelBusinessId = BaseHelpUtils.getIntValue(result, "personnelBusinessId");
			for (BaseReceiveUnitManage baseReceiveUnitManage : ruList) {
				if(null != baseReceiveUnitManage.getSalaryType()){
					if(null != baseReceiveUnitManage.getCompanyId()){
						String [] companyIds = baseReceiveUnitManage.getCompanyId().split(",");
						boolean flag = false;
						for (String string : companyIds) {
							if(string.equals(bean.getCompanyId().toString())){
								flag = true;
								break;
							}
						}
						if(flag){
							BaseProcessBillList tmpBean = new BaseProcessBillList();
							tmpBean.setPayeeName(baseReceiveUnitManage.getReceiveUnit());
							tmpBean.setSelfBankAccount(baseReceiveUnitManage.getBankAccount());
							tmpBean.setSelfBankName(baseReceiveUnitManage.getBankName());
							tmpBean.setPayFor(2);
							tmpBean.setEmployeeOrCompanyId(baseReceiveUnitManage.getReceiveUnitManageId());
							tmpBean.setRemark("应纳个税");
							tmpBean.setBalanceAmount(bean.getShouldTax());
							tmpBean.setCompanyId(bean.getCompanyId());
							tmpBean.setYear(bean.getYear());
							tmpBean.setMonth(bean.getMonth());
							tmpBean.setPersonnelBusinessId(personnelBusinessId);
							tmpBean.setPayType(2);
							pbList.add(tmpBean);
						}
					}else{
						// 奖金区分募投项目后 要进行收款分拆
						continue;
//						BaseProcessBillList tmpBean = new BaseProcessBillList();
//						tmpBean.setPayeeName(baseReceiveUnitManage.getReceiveUnit());
//						tmpBean.setSelfBankAccount(baseReceiveUnitManage.getBankAccount());
//						tmpBean.setSelfBankName(baseReceiveUnitManage.getBankName());
//						tmpBean.setPayFor(2);
//						tmpBean.setEmployeeOrCompanyId(baseReceiveUnitManage.getReceiveUnitManageId());
//						tmpBean.setCompanyId(bean.getCompanyId());
//						tmpBean.setYear(bean.getYear());
//						tmpBean.setMonth(bean.getMonth());
//						tmpBean.setPersonnelBusinessId(personnelBusinessId);
//						tmpBean.setPayType(2);
//						if(baseReceiveUnitManage.getSalaryType() == 1){//实付工资
//							tmpBean.setPayMoney(bean.getFactBonus());
//							tmpBean.setRemark("实付奖金");
//							pbList.add(tmpBean);
//						}
					}
				}
			}
			// 获取跟奖金相关的账单流水
			List<BaseProcessBillList> faPjList = getProcessBillListByPayInfo(bean.getCompanyId(), bean.getYear(), bean.getMonth(), 2, personnelBusinessId);
			if(faPjList.size() > 0) {
				pbList.addAll(faPjList);
			}
			if(pbList.size() > 0){
				bc.setCollections(pbList);
			}else{
				status = -1;
				errorMsg = "没有找所需要的收款单位";
			}
		}
		return bc.toJSON(status, errorMsg);
	} 
	
	private List<BaseProcessBillList> getProcessBillListByPayInfo(int companyId, int year, int month, int fundType, Integer personnelBusinessId) throws SQLException{
		List<BaseProcessBillList> list = new ArrayList<>();
		EmployeeFundIssuance efiDao = new EmployeeFundIssuance();
		efiDao.setConditionYear("=", year);
		efiDao.setConditionMonth("=", month);
		efiDao.setConditionCompanyId("=", companyId);
		efiDao.setConditionFundType("=", fundType);
		if(null != personnelBusinessId && personnelBusinessId > 0) {
			efiDao.setConditionPersonelBusinessId("=", personnelBusinessId);
		}
		List<BaseEmployeeFundIssuance> efiList = efiDao.conditionalLoad();
		ReceiveUnitManage rumDao = new ReceiveUnitManage();
		Employee eDao = new Employee();
		EmployeeFundIssuanceDetail efiDetailDao = new EmployeeFundIssuanceDetail();
		CardManage cmDao = new CardManage();
		Bank bDao = new Bank();
		for (BaseEmployeeFundIssuance baseEmployeeFundIssuance : efiList) {
			rumDao.clear();
			
			efiDetailDao.clear();
			
			rumDao.setConditionFundraisingProjectTypeId("=", baseEmployeeFundIssuance.getFundrasingTypeId());
			if(null == rumDao.executeQueryOneRow()) {
				continue;
			}
			// 如果有付款金额则处理跟募投项目有关数据
			if(null != baseEmployeeFundIssuance.getPayMoney() && baseEmployeeFundIssuance.getPayMoney().compareTo(BigDecimal.ZERO) > 0) {
				BaseProcessBillList tmpBean = new BaseProcessBillList();
				// 处理跟募投项目有关数据
				tmpBean.setYear(year);
				tmpBean.setPayType(fundType);
				tmpBean.setMonth(month);
				tmpBean.setCompanyId(companyId);
				tmpBean.setRemark("实付工资");
				tmpBean.setPayeeName(rumDao.getReceiveUnit());
				tmpBean.setSelfBankAccount(rumDao.getBankAccount());
				tmpBean.setSelfBankName(rumDao.getBankName());
				tmpBean.setPayFor(2);
				tmpBean.setEmployeeOrCompanyId(rumDao.getReceiveUnitManageId());
				tmpBean.setPayMoney(baseEmployeeFundIssuance.getPayMoney());
				tmpBean.setEmployeeFundIssuanceId(baseEmployeeFundIssuance.getEmployeeFundIssuanceId());
				tmpBean.setFundraisingProjectTypeId(baseEmployeeFundIssuance.getFundrasingTypeId());
				list.add(tmpBean);
			}
			// 处理有冲账的数据
			if(null != baseEmployeeFundIssuance.getAmountOfCredit() && baseEmployeeFundIssuance.getAmountOfCredit().compareTo(BigDecimal.ZERO) > 0) {
				efiDetailDao.setConditionAmountOfCredit(">", BigDecimal.ZERO);
				efiDetailDao.setConditionEmployeeFundIssuanceId("=", baseEmployeeFundIssuance.getEmployeeFundIssuanceId());
				List<BaseEmployeeFundIssuanceDetail> efiDetailList = efiDetailDao.conditionalLoad();
				if(efiDetailList.size() > 0) {
					for (BaseEmployeeFundIssuanceDetail baseEmployeeFundIssuanceDetail : efiDetailList) {
						eDao.clear();
						eDao.setEmployeeId(baseEmployeeFundIssuanceDetail.getEmployeeId());
						if(eDao.load()) {
							cmDao.clear();
							cmDao.setConditionObjectId("=", eDao.getEmployeeId());
							cmDao.setConditionObjectType("=", 1);
							cmDao.setConditionTruePayment("=", true);
							cmDao.setConditionDefaultCard("=", true);
							cmDao.setConditionEnabled("=", true);
							if(null != cmDao.executeQueryOneRow()) {
								bDao.clear();
								bDao.setBankId(cmDao.getBankId());
								BaseProcessBillList tmpDetailBean = new BaseProcessBillList();
								tmpDetailBean.setYear(year);
								tmpDetailBean.setPayType(fundType);
								tmpDetailBean.setMonth(month);
								tmpDetailBean.setCompanyId(companyId);
								tmpDetailBean.setRemark("薪资冲账");
								tmpDetailBean.setPayeeName(eDao.getEmployeeName());
								tmpDetailBean.setSelfBankAccount(cmDao.getBankAccount());
								tmpDetailBean.setPayFor(1);
								tmpDetailBean.setEmployeeOrCompanyId(eDao.getEmployeeId());
								tmpDetailBean.setBalanceAmount(baseEmployeeFundIssuanceDetail.getAmountOfCredit());
								tmpDetailBean.setEmployeeFundIssuanceId(baseEmployeeFundIssuance.getEmployeeFundIssuanceId());
								tmpDetailBean.setFundraisingProjectTypeId(baseEmployeeFundIssuance.getFundrasingTypeId());
								if(bDao.load()) {
									tmpDetailBean.setSelfBankName(bDao.getBankName());
								}
								list.add(tmpDetailBean);
							}
							
						}
					}
				}
			}
		}
		return list;
		
	}
	
	/**
	 * 获取薪资发放所需要的收款单位
	 * @param result
	 * @return
	 * @throws Exception
	 */
	private String getSalaryReceiveUnitManages(Map<String, Object> result) throws Exception{
		int status = 1;
		String errorMsg = null;
		BaseOnSalaryReportByCompany bean = new BaseOnSalaryReportByCompany();
		bean.setDataFromMap(result);
		BaseCollection<BaseProcessBillList> bc = new BaseCollection<>();
		if(null != bean.getCompanyId()){
			
			ReceiveUnitManage dao = new ReceiveUnitManage();
			dao.setConditionReceiveUnitType("=", 1);
			List<BaseReceiveUnitManage> ruList = dao.conditionalLoad();
			List<BaseProcessBillList> pbList = new ArrayList<>();
			for (BaseReceiveUnitManage baseReceiveUnitManage : ruList) {
				if(null != baseReceiveUnitManage.getSalaryType()){
					if(null != baseReceiveUnitManage.getCompanyId()){
						String [] companyIds = baseReceiveUnitManage.getCompanyId().split(",");
						boolean flag = false;
						for (String string : companyIds) {
							if(string.equals(bean.getCompanyId().toString())){
								flag = true;
								break;
							}
						}
						if(flag){
							BaseProcessBillList tmpBean = new BaseProcessBillList();
							tmpBean.setPayeeName(baseReceiveUnitManage.getReceiveUnit());
							tmpBean.setSelfBankAccount(baseReceiveUnitManage.getBankAccount());
							tmpBean.setSelfBankName(baseReceiveUnitManage.getBankName());
							tmpBean.setPayFor(2);
							tmpBean.setEmployeeOrCompanyId(baseReceiveUnitManage.getReceiveUnitManageId());
							tmpBean.setRemark("应纳个税");
							tmpBean.setBalanceAmount(bean.getShouldTax());
							tmpBean.setCompanyId(bean.getCompanyId());
							tmpBean.setYear(bean.getYear());
							tmpBean.setMonth(bean.getMonth());
							tmpBean.setPayType(1);
							pbList.add(tmpBean);
						}
					}else{
						// 工资分募投项目后 原有实付工资进行募投分拆  所以去除实付工资判断
						if(baseReceiveUnitManage.getSalaryType() != 1) {
							BaseProcessBillList tmpBean = new BaseProcessBillList();
							tmpBean.setPayeeName(baseReceiveUnitManage.getReceiveUnit());
							tmpBean.setSelfBankAccount(baseReceiveUnitManage.getBankAccount());
							tmpBean.setSelfBankName(baseReceiveUnitManage.getBankName());
							tmpBean.setPayFor(2);
							tmpBean.setEmployeeOrCompanyId(baseReceiveUnitManage.getReceiveUnitManageId());
							tmpBean.setCompanyId(bean.getCompanyId());
							tmpBean.setYear(bean.getYear());
							tmpBean.setMonth(bean.getMonth());
							tmpBean.setPayType(1);
							if(baseReceiveUnitManage.getSalaryType() == 1){//实付工资  ：原有逻辑 现修改 去除实付工资
								tmpBean.setPayMoney(bean.getFactSalary());
								tmpBean.setRemark("实付工资");
							}else if(baseReceiveUnitManage.getSalaryType() == 2){//个人社保
								tmpBean.setBalanceAmount(bean.getTotalInsurance());
								tmpBean.setRemark("个人社保");
							}else if(baseReceiveUnitManage.getSalaryType() == 3){//个人公积金
								tmpBean.setBalanceAmount(bean.getTotalFund());
								tmpBean.setRemark("个人公积金");
							}
							pbList.add(tmpBean);
						}
					}
				}
			}
			List<BaseProcessBillList> faPjList = getProcessBillListByPayInfo(bean.getCompanyId(), bean.getYear(), bean.getMonth(), 1, null);
			if(faPjList.size() > 0) {
				pbList.addAll(faPjList);
			}
			if(pbList.size() > 0){
				bc.setCollections(pbList);
			}else{
				status = -1;
				errorMsg = "没有找所需要的收款单位";
			}
		}
		return bc.toJSON(status, errorMsg);
	} 
	
	/**
	 * 
	 * @Title: checkReceiveUnitInfo 
	 * @Description: 验证收款单位能否继续添加 
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String checkReceiveUnitInfo(Map<String, Object> result) throws Exception{
		int status = 1;
		String errorMsg = null;
				
		String receiveUnit = BaseHelpUtils.getStringValue(result, "receiveUnit");
		String bankAccount = BaseHelpUtils.getStringValue(result, "bankAccount");
		
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setConditionBankAccount("=", bankAccount);
		if(dao.countRows() <= 0){
			dao.clear();
			dao.setConditionReceiveUnit("=", receiveUnit);
			if(dao.countRows() > 0){
				status = -2;
				errorMsg = "此收款单位名称下,已经存在[" + dao.countRows()+ "]个银行账号信息,还需要添加吗？";
			}
		}else{
			status = -1;
			errorMsg = "此银行账号信息已经存在,不准许添加";
		}
		
		BaseCollection<CustomBaseIddStrVal> cl = new BaseCollection<>();
		return cl.toJSON(status, errorMsg);
	}
	
	/**
	 * 
	 * @Title: getBankcardByCmpAndAddress 
	 * @Description: 根据公司与办卡地址查询银行账号
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getBankcardByCmpAndAddress(Map<String, Object> result) throws Exception{
		String bankAddress = BaseHelpUtils.getStringValue(result, "bankAddress").trim();
		int companyId = BaseHelpUtils.getIntValue(result, "objectId");
		int objectType = BaseHelpUtils.getIntValue(result, "objectType");
		CardManage dao = new CardManage();
		dao.setConditionBankAddress("=", bankAddress);
		dao.setConditionObjectId("=", companyId);
		dao.setConditionObjectType("=", objectType);
		dao.unsetSelectFlags();
		dao.setSelectBankAccount(true);
		List<BaseCardManage> list = dao.conditionalLoad();
		List<CustomBaseIddStrVal> dataList = new ArrayList<>();
		for (BaseCardManage baseCardManage : list) {
			CustomBaseIddStrVal tmpBean = new CustomBaseIddStrVal();
			tmpBean.setIdd(baseCardManage.getBankAccount());
			tmpBean.setVal(baseCardManage.getBankAccount());
			dataList.add(tmpBean);
		}
		BaseCollection<CustomBaseIddStrVal> cl = new BaseCollection<>();
		cl.setCollections(dataList);
		return cl.toJSON(1, "");
	}
	
	/**
	 * 
	 * @Title: getBankAddressByCompany 
	 * @Description: 根据公司查看单位办卡地址
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getBankAddressByCompany(Map<String, Object> result) throws Exception{
		int objectId = BaseHelpUtils.getIntValue(result, "objectId");
		int objectType = BaseHelpUtils.getIntValue(result, "objectType");
		CardManage dao = new CardManage();
		dao.setConditionObjectId("=", objectId);
		dao.setConditionObjectType("=", objectType);
		dao.unsetSelectFlags();
		dao.setSelectBankAddress(true);
		List<BaseCardManage> list = dao.conditionalLoad();
		List<CustomBaseIddStrVal> dataList = new ArrayList<>();
		for (BaseCardManage baseCardManage : list) {
			CustomBaseIddStrVal tmpBean = new CustomBaseIddStrVal();
			tmpBean.setIdd(baseCardManage.getBankAddress());
			tmpBean.setVal(baseCardManage.getBankAddress());
			dataList.add(tmpBean);
		}
		BaseCollection<CustomBaseIddStrVal> cl = new BaseCollection<>();
		cl.setCollections(dataList);
		return cl.toJSON(1, "");
	}
	
	/**
	 * 
	 * @Title: getBillListByBusinessidProcesstype 
	 * @Description: 查询出跟流程相关的账单流水数据
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getBillListByBusinessidProcesstype(Map<String, Object> result) throws Exception{
		int businessId = BaseHelpUtils.getIntValue(result, "businessId");
		int processType = BaseHelpUtils.getIntValue(result, "processType");
		ProcessBillList dao = new ProcessBillList();
		dao.setConditionBusinessId("=", businessId);
		dao.setConditionProcessType("=", processType);
		List<BaseProcessBillList> list = dao.conditionalLoad();
		BaseCollection<BaseProcessBillList> bc = new BaseCollection<>();
		bc.setCollections(list);
		return bc.toJSON(1, null);
	}
	
	/**
	 * 
	 * @Title: getEmployeeBankInfoById 
	 * @Description: 根据主键获取员工信息
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getEmployeeBankInfoById(Map<String, Object> result) throws Exception{
		Integer employeeId = BaseHelpUtils.getIntValue(result, "employeeId");
		CardManage carDao = new CardManage();
		carDao.setConditionObjectType("=", 1);
		carDao.setConditionObjectId("=", employeeId);
		carDao.setConditionEnabled("=", true);
		//加载默认卡
		carDao.setConditionDefaultCard("=",true);
		List<BaseCardManage> list = carDao.conditionalLoad();
		BaseCollection<BaseCardManage> cl = new BaseCollection<>();
		cl.setCollections(list);
		return cl.toJSON(1, "");
	}
	
	/**
	 * 
	 * @Title: addReceiveUnitInfo 
	 * @Description: 新增收款单位信息并返回ID信息
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String addReceiveUnitInfo(Map<String, Object> result) throws Exception{
		ReceiveUnitManage dao = new ReceiveUnitManage();
		BaseReceiveUnitManage baseReceiveUnitManage = new BaseReceiveUnitManage();
		baseReceiveUnitManage.setDataFromMap(result);
		dao.setDataFromBase(baseReceiveUnitManage);
		dao.setOperateTime(new Date());
		ThreadConnection.beginTransaction();
		dao.save();
		K3Code k3CodeDao = new K3Code();
		k3CodeDao.setType(StaticUtils.K3_CODE_TYPE_8);// 收款单位
		k3CodeDao.setBusinessId(dao.getReceiveUnitManageId());
		k3CodeDao.save();
		ThreadConnection.commit();
		return dao.getReceiveUnitManageId().toString();
	}
	 
	/**
	 * 
	 * @Title: getReceiveUnitInfoById 
	 * @Description: 获取收款单位
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getReceiveUnitInfoById(Map<String, Object> result) throws Exception{
		int receiveUnitManageId = BaseHelpUtils.getIntValue(result, "receiveUnitManageId");
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setConditionReceiveUnitManageId("=", receiveUnitManageId);
		List<BaseReceiveUnitManage> list = dao.conditionalLoad();
		BaseCollection<BaseReceiveUnitManage> cl = new BaseCollection<>();
		cl.setCollections(list);
		return cl.toJSON(1, "");
	}
	
	/**
	 * 
	 * @Title: getReceiveUnitInfoByName 
	 * @Description: 根据名称获取收款信息
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getReceiveUnitInfoByName(Map<String, Object> result) throws Exception{
		String receiveUnit = BaseHelpUtils.getStringValue(result, "receiveUnit");
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setConditionReceiveUnit("=", receiveUnit);
		List<BaseReceiveUnitManage> list = dao.conditionalLoad();
		BaseCollection<BaseReceiveUnitManage> cl = new BaseCollection<>();
		cl.setCollections(list);
		return cl.toJSON(1, "");
	}
	
	/**
	 * 
	 * @Title: getReceiveUnitList 
	 * @Description: 获取收款单位列表数据
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getReceiveUnitList(Map<String, Object> result) throws Exception{
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.unsetSelectFlags();
		dao.setSelectReceiveUnitManageId(true);
		dao.setSelectReceiveUnit(true);
		List<BaseReceiveUnitManage> list = dao.conditionalLoad(" order by receive_unit");
		List<BaseSemployeepdror> dataList = new ArrayList<>();
		for (BaseReceiveUnitManage baseReceiveUnitManage : list) {
			BaseSemployeepdror tmpBean = new BaseSemployeepdror();
			tmpBean.setIdd(baseReceiveUnitManage.getReceiveUnitManageId());
			tmpBean.setVal(baseReceiveUnitManage.getReceiveUnit());
			dataList.add(tmpBean);
		}
		BaseCollection<BaseSemployeepdror> cl = new BaseCollection<>();
		cl.setCollections(dataList);
		return cl.toJSON();
	}
	
	private String getReceiveUnitNameList(Map<String, Object> result) throws Exception{
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.unsetSelectFlags();
		dao.setSelectReceiveUnitManageId(true);
		dao.setSelectReceiveUnit(true);
		List<BaseReceiveUnitManage> list = dao.conditionalLoad(" order by receive_unit");
		List<CustomBaseIddStrVal> dataList = new ArrayList<>();
		for (BaseReceiveUnitManage baseReceiveUnitManage : list) {
			CustomBaseIddStrVal tmpBean = new CustomBaseIddStrVal();
			tmpBean.setIdd(baseReceiveUnitManage.getReceiveUnit());
			tmpBean.setVal(baseReceiveUnitManage.getReceiveUnit());
			if(!BaseHelpUtils.isNullOrEmpty(baseReceiveUnitManage.getReceiveUnit())){
				dataList.add(tmpBean);
			}
		}
		BaseCollection<CustomBaseIddStrVal> cl = new BaseCollection<>();
		cl.setCollections(dataList);
		return cl.toJSON();
	}
	
	/**
	 * 
	 * @Title: deleteAndSaveDetailTables 
	 * @Description: 删除与新增与流程相关的账单流水
	 * @param @param params
	 * @param @throws Exception   
	 * @return void   
	 * @throws
	 */
	public static void deleteAndSaveDetailTables(Map<String, Object> params) throws Exception{
		int businessId = BaseHelpUtils.getIntValue(params, "businessId");
		int processType = BaseHelpUtils.getIntValue(params, "processType");
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");
		List<BaseProcessBillList> billList = new ArrayList<>();
		ProcessBillList dao = new ProcessBillList();
		if(null != params.get("detailProcessBillListApply")){
			List<Map> list = (List<Map>) params.get("detailProcessBillListApply");
//			if(!list.isEmpty()){
				for (Map map : list) {
					BaseProcessBillList tmpBean =new BaseProcessBillList();
					tmpBean.setDataFromMap(map);
					tmpBean.setProcessType(processType);
					tmpBean.setBusinessId(businessId);
					tmpBean.setOperator(employeeId);
					billList.add(tmpBean);
				}
				
				dao.setConditionBusinessId("=", businessId);
				dao.setConditionProcessType("=", processType);
				if(dao.countRows() > 0){
					// instantiate  DAO
					ProcessBillList baseprocessbilllist = new ProcessBillList();
					// load the original details.
					List<BaseProcessBillList> originalbaseprocessbilllist = dao.conditionalLoad(null);
					// if current detail is not empty.
					if(!billList.isEmpty()) {
						// need to delete list.
						List<BaseProcessBillList> needToDeleteProcessBillList = new ArrayList<>();
						// need to add list.
						List<BaseProcessBillList> needToAddProcessBillList = new ArrayList<>();
						// find the record that exists in the original list and update.
						for(BaseProcessBillList __baseprocessbilllist : billList ) {
							// set the relative field.
//							__baseprocessbilllist.setProjectNormalReimbursementId( getProjectNormalReimbursementId());
							// set find flag
							boolean foundProcessBillList = false;
							// find the original list.
							for(BaseProcessBillList __originalbaseprocessbilllist : originalbaseprocessbilllist) {
								// if found the original record
								if(__baseprocessbilllist.compareTo(__originalbaseprocessbilllist) == 0) {
									// set found flag to true
									foundProcessBillList = true;
									// update the record.
									// clear DAO's data
									baseprocessbilllist.clearCurrentData();
									// set original data into DAO
									baseprocessbilllist.setDataFromBase(__originalbaseprocessbilllist);
									// clear DAO modification flag, just like the is loaded from DB
									baseprocessbilllist.clearModifiedFlags();
									// set current data into DAO
									baseprocessbilllist.setDataFromBase(__baseprocessbilllist);
									// execute update
									baseprocessbilllist.update();
									break;
								}
							}
							// if not found, then add it to need-to-add list
							if(!foundProcessBillList) needToAddProcessBillList.add(__baseprocessbilllist);
						}
						// find the records that exists in the original list and not in the current list.
						for(BaseProcessBillList __originalbaseprocessbilllist : originalbaseprocessbilllist) {
							boolean foundProcessBillList = false;
							for(BaseProcessBillList __baseprocessbilllist : billList ) {
								if(__baseprocessbilllist.compareTo(__originalbaseprocessbilllist) == 0) {
									foundProcessBillList = true;
									break;
							}
							}
							if(!foundProcessBillList) needToDeleteProcessBillList.add(__originalbaseprocessbilllist);
						}
						// process need-to-add list
						for(BaseProcessBillList __baseprocessbilllist : needToAddProcessBillList ) {
							baseprocessbilllist.setPrimaryKeyFromBase(__baseprocessbilllist);
							// if the primay key is null, then insert into DB
							if(baseprocessbilllist.isPrimaryKeyNull()) { baseprocessbilllist.clearCurrentData(); baseprocessbilllist.setDataFromBase(__baseprocessbilllist); baseprocessbilllist.save(); }
							// otherwise load and update
							else { if(baseprocessbilllist.load()) { baseprocessbilllist.setDataFromBase(__baseprocessbilllist); baseprocessbilllist.update(); } else { baseprocessbilllist.clearCurrentData(); baseprocessbilllist.setDataFromBase(__baseprocessbilllist); baseprocessbilllist.save(); } }
						}
						// process need-to-delete list
						for(BaseProcessBillList __baseprocessbilllist : needToDeleteProcessBillList ) {
							deleteFromProcessBillList(__baseprocessbilllist, baseprocessbilllist);
						}
					} else {
						// if current list is empty, then delete all original list.
						for(BaseProcessBillList __baseprocessbilllist : originalbaseprocessbilllist ) {
							deleteFromProcessBillList(__baseprocessbilllist, baseprocessbilllist);
						}
					}
				} else {
					dao.save(billList);
				}
//			}else{
//				throw new Exception("没有添加账单流水");
//			}
		}
		
	}
	
	private static void deleteFromProcessBillList(BaseProcessBillList bean, ProcessBillList dao) throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.setProcessBillListId(null);
		dao.delete();
	}
	
	/**
	 * 
	 * @Title: passProcessBillList 
	 * @Description: 修改流水状态   改为已经完成   同时，如果有冲账信息的，保存冲账记录
	 * @param @param params
	 * @param @throws Exception   
	 * @return void   
	 * @throws
	 */
	public static void passProcessBillList(Map<String, Object> params) throws Exception{
		int businessId = BaseHelpUtils.getIntValue(params, "businessId");
		int processType = BaseHelpUtils.getIntValue(params, "processType");
		if(businessId > 0 && processType > 0){
			ProcessBillList dao = new ProcessBillList();
			dao.setConditionBusinessId("=", businessId);
			dao.setConditionProcessType("=", processType);
			dao.setIsComplete(true);
			dao.conditionalUpdate();
			ReimbursementPackageProcessor rpp= new ReimbursementPackageProcessor();
			rpp.strikeABalance(processType, businessId);
		}
	}
	
	
	//导出控制 *****************************************
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
}


