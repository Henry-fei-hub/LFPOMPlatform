package pomplatform.reimbursement.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.pomplatform.db.bean.BaseCardManage;
import com.pomplatform.db.bean.BaseK3Code;
import com.pomplatform.db.bean.BaseK3Voucher;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.bean.BaseReimbursementPackage;
import com.pomplatform.db.bean.BaseReimbursementPackageDetail;
import com.pomplatform.db.bean.BaseReimbursementPackageSummary;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.CardManage;
import com.pomplatform.db.dao.Customer;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.K3Code;
import com.pomplatform.db.dao.K3Voucher;
import com.pomplatform.db.dao.ProcessBillList;
import com.pomplatform.db.dao.ReceiveUnitManage;
import com.pomplatform.db.dao.ReimbursementPackage;
import com.pomplatform.db.dao.ReimbursementPackageDetail;
import com.pomplatform.db.dao.ReimbursementPackageSummary;
import com.pomplatform.db.dao.SubjectType;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.system.dao.Employee;
import pomplatform.common.utils.StaticUtils;
import pomplatform.k3voucher.bean.BaseGetCompanyBankAccountK3Code;
import pomplatform.k3voucher.bean.ConditionGetCompanyBankAccountK3Code;
import pomplatform.k3voucher.query.QueryGetCompanyBankAccountK3Code;
import pomplatform.payment.bean.BaseFiveinsuranceSummary;
import pomplatform.payment.bean.ConditionFiveinsuranceSummary;
import pomplatform.payment.query.QueryFiveinsuranceSummary;
import pomplatform.reimbursement.bean.BaseBorrowMoneyRemarkAndAmount;
import pomplatform.reimbursement.bean.BaseCommonNormalRemarkAndAmount;
import pomplatform.reimbursement.bean.BaseCommonTravelRemarkAndAmount;
import pomplatform.reimbursement.bean.BaseNormalReimbursementSummary;
import pomplatform.reimbursement.bean.BasePayMoneyRemarkAndAmount;
import pomplatform.reimbursement.bean.BasePreProjectNormalRemarkAndAmount;
import pomplatform.reimbursement.bean.BasePreProjectTravelRemarkAndAmount;
import pomplatform.reimbursement.bean.BaseProjectNormalRemarkAndAmount;
import pomplatform.reimbursement.bean.BaseProjectTravelRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionBorrowMoneyRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionCommonNormalRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionCommonTravelRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionNormalReimbursementSummary;
import pomplatform.reimbursement.bean.ConditionPayMoneyRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionPreProjectNormalRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionPreProjectTravelRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionProjectNormalRemarkAndAmount;
import pomplatform.reimbursement.bean.ConditionProjectTravelRemarkAndAmount;
import pomplatform.reimbursement.query.QueryBorrowMoneyRemarkAndAmount;
import pomplatform.reimbursement.query.QueryCommonNormalRemarkAndAmount;
import pomplatform.reimbursement.query.QueryCommonTravelRemarkAndAmount;
import pomplatform.reimbursement.query.QueryNormalReimbursementSummary;
import pomplatform.reimbursement.query.QueryPayMoneyRemarkAndAmount;
import pomplatform.reimbursement.query.QueryPreProjectNormalRemarkAndAmount;
import pomplatform.reimbursement.query.QueryPreProjectTravelRemarkAndAmount;
import pomplatform.reimbursement.query.QueryProjectNormalRemarkAndAmount;
import pomplatform.reimbursement.query.QueryProjectTravelRemarkAndAmount;

public class VoucherUtil {
	public static final String SALARY_RECEIVE_UNIT_NAME = "代发业务（工资）";
	public static final String PERSONAL_INCOME_TAX = "个人所得税";
	public static final String HOUSING_FUND = "住房公积金";
	/**
	 * 银行卡类型是公司的银行卡
	 */
	public static final int CARD_MANAGE_TYPE_COMPANY = 2;
	
	
	public static void main(String[] args) {
		try{
			Object[] ids = {4689};
			VoucherUtil.newCreateVoucher(ids);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<BaseReceiveUnitManage> newCreateVoucher(Object[] ids) throws Exception{
		Date date = new Date();
		ReimbursementPackage rp = new ReimbursementPackage();
		rp.addCondition(BaseReimbursementPackage.CS_REIMBURSEMENT_PACKAGE_ID, "in", ids);
		rp.setConditionIsCompleted("=", true);
		List<BaseReimbursementPackage> list = rp.conditionalLoad();
		if (null == list || list.isEmpty()) {
			return null;
		}
		List<BaseReceiveUnitManage> returnList = new ArrayList<>();
		for (BaseReimbursementPackage obj : list) {
			K3Voucher dao = new K3Voucher();
			dao.setConditionReimbursementPackageCode("=", obj.getCode());
			if(dao.countRows() > 0){
				continue;//已有凭证，不再生成
			}
			Date vestingDate = null;
			if(obj.getIsOnlinePay() && null != obj.getPayTime()) {
				vestingDate = obj.getPayTime();
			}else if(!obj.getIsOnlinePay() && obj.getIsCompleted()) {
				vestingDate = obj.getUpdateTime();
			}
			dao.clear();
			BaseK3Voucher bb = dao.executeQueryOneRow(String.format(" %1$s = %2$s and %3$s = %4$s order by %5$s desc", BaseK3Voucher.CS_VOUCHER_YEAR, DateUtil.getYear(vestingDate), BaseK3Voucher.CS_VOUCHER_MONTH, DateUtil.getMonth(vestingDate), BaseK3Voucher.CS_SEQUENCE_NUMBER));
			int sequenceNumber = 1;
			if (null != bb) {
				sequenceNumber = BaseHelpUtils.getIntValue(bb.getSequenceNumber()) + 1;
			}
			Map<Integer, BaseK3Voucher> map = new HashMap<>();
			Map<Integer, BaseK3Voucher> insuranceMap = new HashMap<>();
			BaseK3Voucher k3 = new BaseK3Voucher();
			k3.setReimbursementPackageCode(obj.getCode());
			k3.setReimbursementPackageId(obj.getReimbursementPackageId());
			k3.setSequenceNumber(sequenceNumber);
			k3.setCompanyId(obj.getCompanyId());
			k3.setCreateTime(date);
			k3.setVestingDate(vestingDate);
			k3.setVoucherYear(DateUtil.getYear(vestingDate));
			k3.setVoucherMonth(DateUtil.getMonth(vestingDate));
			//付款信息
			ReimbursementPackageSummary summaryDao = new ReimbursementPackageSummary();
			summaryDao.setConditionReimbursementPackageId("=", obj.getReimbursementPackageId());
			List<BaseReimbursementPackageSummary> summaryList = summaryDao.conditionalLoad("order by " + BaseReimbursementPackageSummary.CS_PAY_FOR);
			int customVoucherType = 1;//普通的报销凭证
			if(summaryList.size() >= 2) {
				for(BaseReimbursementPackageSummary summary : summaryList) {
					if(Objects.equals(summary.getPayeeName(), SALARY_RECEIVE_UNIT_NAME)) {
						if(summaryList.size() == 2) {
							customVoucherType = 2;//需要生成项目奖/年终奖的凭证
						}else {
							customVoucherType = 3;//生成工资发放的凭证
						}
						break;
					}
				}
			}
			switch(customVoucherType) {
			case 1:
				//凭证类型：报销
				k3.setVoucherType(StaticUtils.VOUCHER_TYPE_1);
				returnList = createReimbursementVoucher(obj, k3, map, summaryList, vestingDate);
				break;
			case 2:
				//凭证类型：奖金
				k3.setVoucherType(StaticUtils.VOUCHER_TYPE_8);
				returnList = createBonusVoucher(k3, map, summaryList);
				break;
			case 3:
				//凭证类型：工资
				k3.setVoucherType(StaticUtils.VOUCHER_TYPE_7);
				returnList = createSalaryVoucher(k3, map, summaryList, insuranceMap);
				break;
			default:
				//凭证类型有误，直接退出
				return null;
			}
			if(null == returnList || returnList.isEmpty()) {
				List<BaseK3Voucher> saveList = new ArrayList<>();
				for (Integer key : map.keySet()) {
					saveList.add(map.get(key));
				}
				if(!insuranceMap.isEmpty()) {
					for (Integer key : insuranceMap.keySet()) {
						saveList.add(insuranceMap.get(key));
					}
				}
				dao.save(saveList);
			}
		}
		if(returnList.isEmpty()) {
			return null;
		}else {
			return returnList;
		}
	}
	
	/**
	 * 生成普通的报销凭证
	 * @param packageObj	汇总单数据
	 * @param k3	本张凭证的基础信息
	 * @param map	用来存放生成的凭证数据
	 * @param summaryList	汇总单的汇总数据
	 * @param vestingDate	凭证的归属日期
	 * @return
	 */
	public static List<BaseReceiveUnitManage> createReimbursementVoucher(BaseReimbursementPackage packageObj, BaseK3Voucher k3, Map<Integer, BaseK3Voucher> map, List<BaseReimbursementPackageSummary> summaryList, Date vestingDate) throws Exception{
		List<BaseReceiveUnitManage> returnList = new ArrayList<>();//用来存放生成凭证过程中的错误信息
		int internalSequenceNumber = 0;
		boolean internalContact = false;
		ReimbursementPackageDetail detailDao = new ReimbursementPackageDetail();
		detailDao.setConditionReimbursementPackageId("=", packageObj.getReimbursementPackageId());
		detailDao.setConditionProcessTypeId("!=", StaticUtils.PROCESS_TYPE_7);
		if(detailDao.countRows() == 0) {
			for(BaseReimbursementPackageSummary summary : summaryList) {
				CardManage cmDao = new CardManage();
				cmDao.setConditionBankAccount("=", summary.getSelfBankAccount());
				cmDao.setConditionObjectType("=", CARD_MANAGE_TYPE_COMPANY);
				BaseCardManage cmBean = cmDao.executeQueryOneRow();
				if(null != cmBean)
					internalContact = true;
				break;
			}
		}
		if(internalContact) {
			//生成内部往来的凭证
			Set<Integer> companySet = new HashSet<>();
			Set<String> bankAccountSet = new HashSet<>();
			for(BaseReimbursementPackageSummary summary : summaryList) {
				bankAccountSet.add(summary.getSelfBankAccount());
				bankAccountSet.add(summary.getOtherBankAccount());
			}
			StringBuilder bankAccountStr = new StringBuilder();
			for(String account : bankAccountSet) {
				if(bankAccountStr.length() > 0) {
					bankAccountStr.append(",");
				}
				bankAccountStr.append("'").append(account).append("'");
			}
			//获取本汇总单所有涉及到公司银行账号的K3代码
			ConditionGetCompanyBankAccountK3Code CBAKCondition = new ConditionGetCompanyBankAccountK3Code();
			KeyValuePair keyValue = new KeyValuePair();
			keyValue.setKey("and b.bank_account = ?");
			keyValue.setValue(String.format("and b.bank_account = ? and b.bank_account in (%1$s)", bankAccountStr.toString()));
			KeyValuePair[] keyValues = {keyValue};
			QueryGetCompanyBankAccountK3Code CBAKQuery = new QueryGetCompanyBankAccountK3Code();
			BaseCollection<BaseGetCompanyBankAccountK3Code> CBAKCollection = CBAKQuery.executeQuery(keyValues, CBAKCondition);
			//存储银行账号的K3代码
			Map<String, BaseGetCompanyBankAccountK3Code> bankK3CodeMap = new HashMap<>(); 
			if(null == CBAKCollection || null == CBAKCollection.getCollections() || CBAKCollection.getCollections().isEmpty()) {
				throw new Exception("没有获取到公司银行账号的K3代码");
			}
			for(BaseGetCompanyBankAccountK3Code bean : CBAKCollection.getCollections()) {
				bankK3CodeMap.put(bean.getBankAccount(), bean);
				companySet.add(bean.getObjectId());
			}
			K3Code codeDao = new K3Code();
			codeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_2);
			codeDao.addCondition(BaseK3Code.CS_BUSINESS_ID, "in", companySet.toArray());
			List<BaseK3Code> companyCodeList = codeDao.conditionalLoad();
			//存储公司的机构K3代码
			Map<Integer, BaseK3Code> companyCodeMap = new HashMap<>();
			for(BaseK3Code bean : companyCodeList) {
				companyCodeMap.put(bean.getBusinessId(), bean);
			}
			//获取“内部往来-资金往来”的K3代码
			BaseK3Code internalContactK3Code = getK3Code(StaticUtils.K3_CODE_TYPE_0, StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_27, null, null, returnList);
			if(null == internalContactK3Code) {
				throw new Exception("无法获取“内部往来-资金往来”的K3代码");
			}
			k3.setRemark("往来款");
			k3.setSimplifyRemark(k3.getRemark());
			for(BaseReimbursementPackageSummary summary : summaryList) {
				BaseGetCompanyBankAccountK3Code CBAKBean = bankK3CodeMap.get(summary.getSelfBankAccount());
				if(null == CBAKBean) {
					throw new Exception(String.format("无法获取公司的银行账户[%1$s]K3代码", summary.getSelfBankAccount()));
				}
				if(Objects.equals(summary.getOtherName(), CBAKBean.getObjectId())) {
					//同个公司，不同账户之间进行转账
					BaseK3Voucher debitVoucher = new BaseK3Voucher();
					k3.cloneCopy(debitVoucher);
					debitVoucher.setCodeType(CBAKBean.getType());
					debitVoucher.setCodeId(CBAKBean.getK3CodeId());
					debitVoucher.setCode(CBAKBean.getK3Code());
					debitVoucher.setName(CBAKBean.getK3Name());
					debitVoucher.setDebitSide(summary.getPaymentAmount());
					debitVoucher.setInternalSequenceNumber(internalSequenceNumber);
					map.put(internalSequenceNumber++, debitVoucher);
					BaseGetCompanyBankAccountK3Code CBAKBean2 = bankK3CodeMap.get(summary.getOtherBankAccount());
					if(null == CBAKBean2) {
						throw new Exception(String.format("无法获取公司的银行账户[%1$s]K3代码", summary.getOtherBankAccount()));
					}
					BaseK3Voucher creditVoucher = new BaseK3Voucher();
					k3.cloneCopy(creditVoucher);
					creditVoucher.setCodeType(CBAKBean2.getType());
					creditVoucher.setCodeId(CBAKBean2.getK3CodeId());
					creditVoucher.setCode(CBAKBean2.getK3Code());
					creditVoucher.setName(CBAKBean2.getK3Name());
					creditVoucher.setCreditSide(summary.getPaymentAmount());
					creditVoucher.setInternalSequenceNumber(internalSequenceNumber);
					map.put(internalSequenceNumber++, creditVoucher);
				}else {
					//不同公司之间进行转账
					BaseK3Voucher debitVoucher = new BaseK3Voucher();
					k3.cloneCopy(debitVoucher);
					debitVoucher.setCodeType(internalContactK3Code.getType());
					debitVoucher.setCodeId(internalContactK3Code.getK3CodeId());
					debitVoucher.setCode(internalContactK3Code.getK3Code());
					debitVoucher.setName(internalContactK3Code.getK3Name());
					BaseK3Code companyCode = companyCodeMap.get(CBAKBean.getObjectId());
					if(null == companyCode) {
						throw new Exception("无法获取公司的分支机构K3代码");
					}
					debitVoucher.setSecondaryCodeType(companyCode.getType());
					debitVoucher.setSecondaryCodeId(companyCode.getK3CodeId());
					debitVoucher.setSecondaryCode(companyCode.getK3Code());
					debitVoucher.setSecondaryName(companyCode.getK3Name());
					debitVoucher.setDebitSide(summary.getPaymentAmount());
					debitVoucher.setInternalSequenceNumber(internalSequenceNumber);
					map.put(internalSequenceNumber++, debitVoucher);
					BaseGetCompanyBankAccountK3Code CBAKBean2 = bankK3CodeMap.get(summary.getOtherBankAccount());
					if(null == CBAKBean2) {
						throw new Exception(String.format("无法获取公司的银行账户[%1$s]K3代码", summary.getOtherBankAccount()));
					}
					BaseK3Voucher creditVoucher = new BaseK3Voucher();
					k3.cloneCopy(creditVoucher);
					creditVoucher.setCodeType(CBAKBean2.getType());
					creditVoucher.setCodeId(CBAKBean2.getK3CodeId());
					creditVoucher.setCode(CBAKBean2.getK3Code());
					creditVoucher.setName(CBAKBean2.getK3Name());
					creditVoucher.setCreditSide(summary.getPaymentAmount());
					creditVoucher.setInternalSequenceNumber(internalSequenceNumber);
					map.put(internalSequenceNumber++, creditVoucher);
				}
			}
		}else {
			SimpleDateFormat payFormat = new SimpleDateFormat("yy.MM.dd");
			K3Code k3CodeDao = new K3Code();
			k3CodeDao.setConditionType("=", StaticUtils.K3_CODE_TYPE_0);
			List<BaseK3Code> k3CodeList = k3CodeDao.conditionalLoad(BaseK3Code.CS_BUSINESS_ID + String.format(" in (%1$s, %2$s)", StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_8, StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_9));
			BaseK3Code k3CodeType0BusinessId8 = null;//进项税额K3代码
			BaseK3Code k3CodeType0BusinessId9 = null;//进项税转出金额K3代码
			detailDao.clear();
			detailDao.setConditionReimbursementPackageId("=", packageObj.getReimbursementPackageId());
			List<BaseReimbursementPackageDetail> detailList = detailDao.conditionalLoad("order by " + BaseReimbursementPackageDetail.CS_CODE);
			if (null != detailList && !detailList.isEmpty()) {
				String code = "";
				for(BaseK3Code k3CodeBean : k3CodeList) {
					if(Objects.equals(k3CodeBean.getBusinessId(), StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_8)) {
						k3CodeType0BusinessId8 = k3CodeBean;
					}
					if(Objects.equals(k3CodeBean.getBusinessId(), StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_9)) {
						k3CodeType0BusinessId9 = k3CodeBean;
					}
				}
				for (BaseReimbursementPackageDetail detail : detailList) {
					if(code.equals(detail.getCode()) && !detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_6)){
						continue;
					}
					code = detail.getCode();
					BaseK3Voucher k3Temp = new BaseK3Voucher();
					k3.cloneCopy(k3Temp);
					k3Temp.setProcessId(detail.getProcessId());
					k3Temp.setProcessType(detail.getProcessTypeId());
					k3Temp.setProcessInstanceId(detail.getProcessInstanceId());
					k3Temp.setBusinessId(detail.getBusinessId());
					k3Temp.setInternalSequenceNumber(internalSequenceNumber);
					if (detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_7)) {
						// 预付款
						// 取得科目代码
						ReceiveUnitManage rumDao = new ReceiveUnitManage();
						rumDao.setReceiveUnitManageId(detail.getEmployeeOrCompanyId());
						rumDao.unsetSelectFlags();
						rumDao.setSelectVoucherType(true);
						rumDao.setSelectReceiveUnit(true);
						rumDao.setSelectBankAccount(true);
						if(!rumDao.load()) {
							returnList.add(generateBaseReceiveUnitManage(null, null, null, null, null, String.format("找不到收款单位[ID:%1$s]的信息", detail.getEmployeeOrCompanyId())));
							continue;
						}
						if(null == rumDao.getVoucherType()) {
							returnList.add(generateBaseReceiveUnitManage(null, null, null, null, null, String.format("收款单位[%1$s]，账号[%2$s]没有设置凭证类型", rumDao.getReceiveUnit(), rumDao.getBankAccount())));
							continue;
						}
						BaseK3Code code1 = getK3Code(StaticUtils.K3_CODE_TYPE_6, detail.getProcessTypeId(), null, rumDao.getVoucherType(), returnList);
						k3Temp.setCodeType(StaticUtils.K3_CODE_TYPE_6);
						if(null != code1) {
							k3Temp.setCodeId(code1.getK3CodeId());
							k3Temp.setCode(code1.getK3Code());
							k3Temp.setName(code1.getK3Name());
						}
						// 取得公司K3代码
						BaseK3Code code2 = getK3Code(StaticUtils.K3_CODE_TYPE_8, detail.getEmployeeOrCompanyId(), null, null, returnList);
						k3Temp.setSecondaryCodeType(StaticUtils.K3_CODE_TYPE_8);
						if(null != code2) {
							k3Temp.setSecondaryCodeId(code2.getK3CodeId());
							k3Temp.setSecondaryCode(code2.getK3Code());
							if(code2.getK3Name().indexOf("---") >= 0) {
								String[] codes = code2.getK3Name().split("---");
								k3Temp.setSecondaryName(codes[codes.length - 1]);
							}else {
								k3Temp.setSecondaryName(code2.getK3Name());
							}
						}
						ConditionPayMoneyRemarkAndAmount condition = new ConditionPayMoneyRemarkAndAmount();
						condition.setBusinessId(detail.getBusinessId());
						QueryPayMoneyRemarkAndAmount query = new QueryPayMoneyRemarkAndAmount();
						BaseCollection<BasePayMoneyRemarkAndAmount> bc = query.executeQuery(null, condition);
						if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
							BasePayMoneyRemarkAndAmount ra = bc.getCollections().get(0);
							String remark = formatRemark(ra.getRemark());
							k3Temp.setRemark(remark);
							if (remark.length() > 100) {
								k3Temp.setSimplifyRemark(remark.substring(0, 100));
							} else {
								k3Temp.setSimplifyRemark(remark);
							}
							k3Temp.setDebitSide(ra.getPayMoney());
						}
						map.put(internalSequenceNumber, k3Temp);
						internalSequenceNumber++;
					} else if (detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_6)) {
						// 借款
						// 取得科目代码
						BaseK3Code code1 = getK3Code(StaticUtils.K3_CODE_TYPE_6, detail.getProcessTypeId(), null, null, returnList);
						k3Temp.setCodeType(StaticUtils.K3_CODE_TYPE_6);
						if(null != code1) {
							k3Temp.setCodeId(code1.getK3CodeId());
							k3Temp.setCode(code1.getK3Code());
							k3Temp.setName(code1.getK3Name());
						}
						// 取得员工K3代码
						BaseK3Code code2 = getK3Code(StaticUtils.K3_CODE_TYPE_1, detail.getEmployeeOrCompanyId(), null, null, returnList);
						k3Temp.setSecondaryCodeType(StaticUtils.K3_CODE_TYPE_1);
						if(null != code2) {
							k3Temp.setSecondaryCodeId(code2.getK3CodeId());
							k3Temp.setSecondaryCode(code2.getK3Code());
							if(code2.getK3Name().indexOf("---") >= 0) {
								String[] codes = code2.getK3Name().split("---");
								k3Temp.setSecondaryName(codes[codes.length - 1]);
							}else {
								k3Temp.setSecondaryName(code2.getK3Name());
							}
						}
						ConditionBorrowMoneyRemarkAndAmount condition = new ConditionBorrowMoneyRemarkAndAmount();
						condition.setBusinessId(detail.getBusinessId());
						QueryBorrowMoneyRemarkAndAmount query = new QueryBorrowMoneyRemarkAndAmount();
						BaseCollection<BaseBorrowMoneyRemarkAndAmount> bc = query.executeQuery(null, condition);
						if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
							List<BaseBorrowMoneyRemarkAndAmount> raList = bc.getCollections();
							for(BaseBorrowMoneyRemarkAndAmount ra : raList){
								if(!ra.getEmployeeOrCompanyId().equals(detail.getEmployeeOrCompanyId())){
									continue;
								}
								String remark = formatRemark(ra.getRemark());
								k3Temp.setRemark(remark);
								if (remark.length() > 100) {
									k3Temp.setSimplifyRemark(remark.substring(0, 100));
								} else {
									k3Temp.setSimplifyRemark(remark);
								}
								k3Temp.setDebitSide(ra.getPayMoney());
							}
						}
						map.put(internalSequenceNumber, k3Temp);
						internalSequenceNumber++;
					} else if (detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_4)
							|| detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_5)
							|| detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_9)) {
						// 差旅报销（普通、项目、前期项目）
						String remark = null;
						String simplifyRemark = null;
						// 取得科目代码
						if(!detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_5)){
							BaseK3Code code1 = getK3Code(StaticUtils.K3_CODE_TYPE_6, detail.getProcessTypeId(), null, null, returnList);
							k3Temp.setCodeType(StaticUtils.K3_CODE_TYPE_6);
							if(null != code1) {
								k3Temp.setCodeId(code1.getK3CodeId());
								k3Temp.setCode(code1.getK3Code());
								k3Temp.setName(code1.getK3Name());
							}
						}
						BigDecimal inputTax = BigDecimal.ZERO;
						BigDecimal inputTaxRebate = BigDecimal.ZERO;
						if (detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_4)) {
							// 项目差旅报销的借方数据
							ConditionProjectTravelRemarkAndAmount condition = new ConditionProjectTravelRemarkAndAmount();
							condition.setBusinessId(detail.getBusinessId());
							QueryProjectTravelRemarkAndAmount query = new QueryProjectTravelRemarkAndAmount();
							BaseCollection<BaseProjectTravelRemarkAndAmount> bc = query.executeQuery(null,
									condition);
							if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
								for (BaseProjectTravelRemarkAndAmount pt : bc.getCollections()) {
									if (k3Temp.getInternalSequenceNumber().equals(internalSequenceNumber)) {
										remark = formatRemark(pt.getRemark());
										if (remark.length() > 100) {
											simplifyRemark = remark.substring(0, 100);
										} else {
											simplifyRemark = remark;
										}
									}
									BaseK3Voucher bean = new BaseK3Voucher();
									k3Temp.cloneCopy(bean);
									bean.setInternalSequenceNumber(internalSequenceNumber);
									bean.setProjectId(pt.getProjectId());
									bean.setDebitSide(pt.getFinalAmount());
									bean.setRemark(remark);
									bean.setSimplifyRemark(simplifyRemark);
									if (null != pt.getInputTax()) {
										inputTax = inputTax.add(pt.getInputTax());
									}
									if (null != pt.getInputTaxRebate()) {
										inputTaxRebate = inputTaxRebate.add(pt.getInputTaxRebate());
									}
									map.put(internalSequenceNumber, bean);
									internalSequenceNumber++;
								}
							}
						} else if (detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_5)) {
							// 普通差旅报销的借方数据
							ConditionCommonTravelRemarkAndAmount condition = new ConditionCommonTravelRemarkAndAmount();
							condition.setBusinessId(detail.getBusinessId());
							QueryCommonTravelRemarkAndAmount query = new QueryCommonTravelRemarkAndAmount();
							BaseCollection<BaseCommonTravelRemarkAndAmount> bc = query.executeQuery(null,
									condition);
							if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
								for (BaseCommonTravelRemarkAndAmount pt : bc.getCollections()) {
									BaseK3Code code1 = getK3Code(StaticUtils.K3_CODE_TYPE_4, StaticUtils.TRAVEL_FEE, pt.getDepartmentId(), null, returnList);
									k3Temp.setCodeType(StaticUtils.K3_CODE_TYPE_4);
									if(null != code1) {
										k3Temp.setCodeId(code1.getK3CodeId());
										k3Temp.setCode(code1.getK3Code());
										k3Temp.setName(code1.getK3Name());
									}
									if (k3Temp.getInternalSequenceNumber().equals(internalSequenceNumber)) {
										remark = formatRemark(pt.getRemark());
										if (remark.length() > 100) {
											simplifyRemark = remark.substring(0, 100);
										} else {
											simplifyRemark = remark;
										}
									}
									BaseK3Voucher bean = new BaseK3Voucher();
									k3Temp.cloneCopy(bean);
									bean.setInternalSequenceNumber(internalSequenceNumber);
									bean.setDebitSide(pt.getFinalAmount());
									bean.setRemark(remark);
									bean.setSimplifyRemark(simplifyRemark);
									if (null != pt.getInputTax()) {
										inputTax = inputTax.add(pt.getInputTax());
									}
									if (null != pt.getInputTaxRebate()) {
										inputTaxRebate = inputTaxRebate.add(pt.getInputTaxRebate());
									}
									map.put(internalSequenceNumber, bean);
									internalSequenceNumber++;
								}
							}
						} else if (detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_9)) {
							// 前期项目差旅报销的借方数据
							ConditionPreProjectTravelRemarkAndAmount condition = new ConditionPreProjectTravelRemarkAndAmount();
							condition.setBusinessId(detail.getBusinessId());
							QueryPreProjectTravelRemarkAndAmount query = new QueryPreProjectTravelRemarkAndAmount();
							BaseCollection<BasePreProjectTravelRemarkAndAmount> bc = query.executeQuery(null,
									condition);
							if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
								for (BasePreProjectTravelRemarkAndAmount pt : bc.getCollections()) {
									if (k3Temp.getInternalSequenceNumber().equals(internalSequenceNumber)) {
										remark = formatRemark(pt.getRemark());
										if (remark.length() > 100) {
											simplifyRemark = remark.substring(0, 100);
										} else {
											simplifyRemark = remark;
										}
									}
									BaseK3Voucher bean = new BaseK3Voucher();
									k3Temp.cloneCopy(bean);
									bean.setInternalSequenceNumber(internalSequenceNumber);
									bean.setProjectId(pt.getMainProjectId());
									bean.setDebitSide(pt.getFinalAmount());
									bean.setRemark(remark);
									bean.setSimplifyRemark(simplifyRemark);
									if (null != pt.getInputTax()) {
										inputTax = inputTax.add(pt.getInputTax());
									}
									if (null != pt.getInputTaxRebate()) {
										inputTaxRebate = inputTaxRebate.add(pt.getInputTaxRebate());
									}
									map.put(internalSequenceNumber, bean);
									internalSequenceNumber++;
								}
							}
						}
						internalSequenceNumber = commonData(internalSequenceNumber, map, k3, detail, remark,
								simplifyRemark, inputTax, inputTaxRebate, k3CodeType0BusinessId8, k3CodeType0BusinessId9, returnList);
					} else if (detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_2) || detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_8)) {
						// 日常报销（项目、前期项目）
						String remark = null;
						String simplifyRemark = null;
						ConditionNormalReimbursementSummary summaryCondition = new ConditionNormalReimbursementSummary();
						summaryCondition.setProjectNormalReimbursementId(detail.getBusinessId());
						QueryNormalReimbursementSummary summaryQuery = new QueryNormalReimbursementSummary();
						BaseCollection<BaseNormalReimbursementSummary> summaryBC = summaryQuery.executeQuery(null, summaryCondition);
						if(null != summaryBC && null != summaryBC.getCollections() && !summaryBC.getCollections().isEmpty()) {
							remark = formatRemark(BaseHelpUtils.getString(summaryBC.getCollections().get(0).getRemark()));
							if(remark.length() > 100) {
								simplifyRemark = remark.substring(0, 100);
							}else {
								simplifyRemark = remark;
							}
						}
						BigDecimal inputTax = BigDecimal.ZERO;
						BigDecimal inputTaxRebate = BigDecimal.ZERO;
						// 借方数据
						if(detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_2)){
							//项目日常报销
							ConditionProjectNormalRemarkAndAmount condition = new ConditionProjectNormalRemarkAndAmount();
							condition.setBusinessId(detail.getBusinessId());
							QueryProjectNormalRemarkAndAmount query = new QueryProjectNormalRemarkAndAmount();
							BaseCollection<BaseProjectNormalRemarkAndAmount> bc = query.executeQuery(null, condition);
							if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
								for(BaseProjectNormalRemarkAndAmount bpnr : bc.getCollections()){
									BaseK3Voucher bean = new BaseK3Voucher();
									k3.cloneCopy(bean);
									bean.setRemark(formatRemark(bpnr.getRemark()));
									if (bean.getRemark().length() > 100) {
										bean.setSimplifyRemark(bean.getRemark().substring(0, 100));
									} else {
										bean.setSimplifyRemark(bean.getRemark());
									}
									bean.setProcessId(detail.getProcessId());
									bean.setProcessType(detail.getProcessTypeId());
									bean.setProcessInstanceId(detail.getProcessInstanceId());
									bean.setBusinessId(detail.getBusinessId());
									//获取科目代码；此处可能还要加上部门的科目代码
									Integer businessId = bpnr.getSubItemId();
									if(null == bpnr.getSubItemId() || (null != bpnr.getSubItemId() && bpnr.getSubItemId().equals(0))){
										businessId = bpnr.getMainItemId();
									}
									bean.setCodeType(StaticUtils.K3_CODE_TYPE_4);
									BaseK3Code code1 = getK3Code(StaticUtils.K3_CODE_TYPE_4, businessId, null, StaticUtils.DEPARTMENT_TYPE_2, returnList);
									if(null != code1){
										bean.setCodeId(code1.getK3CodeId());
										bean.setCode(code1.getK3Code());
										bean.setName(code1.getK3Name());
									}
									if(null != bpnr.getInputTax()){
										inputTax = inputTax.add(bpnr.getInputTax());
										bean.setInputTax(bpnr.getInputTax());
									}
									if(null != bpnr.getInputTaxRebate()){
										inputTaxRebate = inputTaxRebate.add(bpnr.getInputTaxRebate());
										bean.setInputTaxRebate(bpnr.getInputTaxRebate());
									}
									bean.setAmountOfReimbursement(bpnr.getAmount());
									bean.setDebitSide(bpnr.getAmount().subtract(BaseHelpUtils.getBigDecimalValue(bpnr.getInputTax())).add(BaseHelpUtils.getBigDecimalValue(bpnr.getInputTaxRebate())));
									bean.setInternalSequenceNumber(internalSequenceNumber);
									map.put(internalSequenceNumber, bean);
									internalSequenceNumber++;
								}
							}
						}else{
							//前期项目日常报销
							ConditionPreProjectNormalRemarkAndAmount condition = new ConditionPreProjectNormalRemarkAndAmount();
							condition.setBusinessId(detail.getBusinessId());
							QueryPreProjectNormalRemarkAndAmount query = new QueryPreProjectNormalRemarkAndAmount();
							BaseCollection<BasePreProjectNormalRemarkAndAmount> bc = query.executeQuery(null, condition);
							if (null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
								for(BasePreProjectNormalRemarkAndAmount bpnr : bc.getCollections()){
									BaseK3Voucher bean = new BaseK3Voucher();
									k3.cloneCopy(bean);
									bean.setRemark(formatRemark(bpnr.getRemark()));
									if (bean.getRemark().length() > 100) {
										bean.setSimplifyRemark(bean.getRemark().substring(0, 100));
									} else {
										bean.setSimplifyRemark(bean.getRemark());
									}
									bean.setProcessId(detail.getProcessId());
									bean.setProcessType(detail.getProcessTypeId());
									bean.setProcessInstanceId(detail.getProcessInstanceId());
									bean.setBusinessId(detail.getBusinessId());
									Integer businessId = bpnr.getSubItemId();
									if(null == bpnr.getSubItemId() || (null != bpnr.getSubItemId() && bpnr.getSubItemId().equals(0))){
										businessId = bpnr.getMainItemId();
									}
									bean.setCodeType(StaticUtils.K3_CODE_TYPE_4);
									BaseK3Code code1 = getK3Code(StaticUtils.K3_CODE_TYPE_4, businessId, null, StaticUtils.DEPARTMENT_TYPE_0, returnList);
									if(null != code1){
										bean.setCodeId(code1.getK3CodeId());
										bean.setCode(code1.getK3Code());
										bean.setName(code1.getK3Name());
									}
									if(null != bpnr.getInputTax()){
										inputTax = inputTax.add(bpnr.getInputTax());
										bean.setInputTax(bpnr.getInputTax());
									}
									if(null != bpnr.getInputTaxRebate()){
										inputTaxRebate = inputTaxRebate.add(bpnr.getInputTaxRebate());
										bean.setInputTaxRebate(bpnr.getInputTaxRebate());
									}
									bean.setAmountOfReimbursement(bpnr.getAmount());
									bean.setDebitSide(bpnr.getAmount().subtract(BaseHelpUtils.getBigDecimalValue(bpnr.getInputTax())).add(BaseHelpUtils.getBigDecimalValue(bpnr.getInputTaxRebate())));
									bean.setInternalSequenceNumber(internalSequenceNumber);
									map.put(internalSequenceNumber, bean);
									internalSequenceNumber++;
								}
							}
						}
						internalSequenceNumber = commonData(internalSequenceNumber, map, k3, detail, remark,
								simplifyRemark, inputTax, inputTaxRebate, k3CodeType0BusinessId8, k3CodeType0BusinessId9, returnList);
					} else if(detail.getProcessTypeId().equals(StaticUtils.PROCESS_TYPE_3)){
						//普通日常报销
						BigDecimal inputTax = BigDecimal.ZERO;
						BigDecimal inputTaxRebate = BigDecimal.ZERO;
						ConditionCommonNormalRemarkAndAmount condition = new ConditionCommonNormalRemarkAndAmount();
						condition.setBusinessId(detail.getBusinessId());
						QueryCommonNormalRemarkAndAmount query = new QueryCommonNormalRemarkAndAmount();
						BaseCollection<BaseCommonNormalRemarkAndAmount> bc = query.executeQuery(null, condition);
						List<BaseCommonNormalRemarkAndAmount> normalDepartmentList = bc.getCollections();
						String remark = null;
						String simplifyRemark = null;
						ConditionNormalReimbursementSummary summaryCondition = new ConditionNormalReimbursementSummary();
						summaryCondition.setProjectNormalReimbursementId(detail.getBusinessId());
						QueryNormalReimbursementSummary summaryQuery = new QueryNormalReimbursementSummary();
						BaseCollection<BaseNormalReimbursementSummary> summaryBC = summaryQuery.executeQuery(null, summaryCondition);
						if(null != summaryBC && null != summaryBC.getCollections() && !summaryBC.getCollections().isEmpty()) {
							remark = formatRemark(BaseHelpUtils.getString(summaryBC.getCollections().get(0).getRemark()));
							if(remark.length() > 100) {
								simplifyRemark = remark.substring(0, 100);
							}else {
								simplifyRemark = remark;
							}
						}
						if(null != normalDepartmentList && !normalDepartmentList.isEmpty()){
							for(BaseCommonNormalRemarkAndAmount department : normalDepartmentList){
								Integer businessId = null;
								if(null == department.getSubItemId() || (null != department.getSubItemId() && department.getSubItemId().equals(0))){
									businessId = department.getMainItemId();
								}else {
									businessId = department.getSubItemId();
								}
								BaseK3Voucher bean = new BaseK3Voucher();
								k3.cloneCopy(bean);
								bean.setRemark(formatRemark(department.getRemark()));
								if (bean.getRemark().length() > 100) {
									bean.setSimplifyRemark(bean.getRemark().substring(0, 100));
								} else {
									bean.setSimplifyRemark(bean.getRemark());
								}
								bean.setProcessId(detail.getProcessId());
								bean.setProcessType(detail.getProcessTypeId());
								bean.setProcessInstanceId(detail.getProcessInstanceId());
								bean.setBusinessId(detail.getBusinessId());
								//获取科目代码；此处可能还要加上部门的科目代码
								bean.setCodeType(StaticUtils.K3_CODE_TYPE_4);
								BaseK3Code code1 = getK3Code(StaticUtils.K3_CODE_TYPE_4, businessId, department.getDepartmentId(), null, returnList);
								if(null != code1){
									bean.setCodeId(code1.getK3CodeId());
									bean.setCode(code1.getK3Code());
									bean.setName(code1.getK3Name());
								}
								bean.setAmountOfReimbursement(department.getAmount());
								if(null != department.getInputTax()){
									inputTax = inputTax.add(department.getInputTax());
									bean.setInputTax(department.getInputTax());
								}
								if(null != department.getInputTaxRebate()){
									inputTaxRebate = inputTaxRebate.add(department.getInputTaxRebate());
									bean.setInputTaxRebate(department.getInputTaxRebate());
								}
								bean.setDebitSide(department.getFinalAmount());
								bean.setInternalSequenceNumber(internalSequenceNumber);
								map.put(internalSequenceNumber, bean);
								internalSequenceNumber++;
							}
						}
						internalSequenceNumber = commonData(internalSequenceNumber, map, k3Temp, detail, remark, simplifyRemark, inputTax, inputTaxRebate, k3CodeType0BusinessId8, k3CodeType0BusinessId9, returnList);
					}
				}
			}
			//付款信息
			Map<String, BaseK3Voucher> employeeVoucherMap = new HashMap<>();
			for(BaseReimbursementPackageSummary summary : summaryList){
				if(null == summary.getPayFor()){
					throw new Exception("收款对象为空");
				}else if(null == summary.getOtherBankAccount()){
					throw new Exception("付款信息中没有付款银行账号");
				}else{
					BaseK3Voucher bean = new BaseK3Voucher();
					k3.cloneCopy(bean);
					if(summary.getPayFor().equals(StaticUtils.PAY_FOR_PERSON)){
						//收款对象为个人,需要按付款银行账号汇总成一条数据
						if(employeeVoucherMap.containsKey(summary.getOtherBankAccount())) {
							bean = employeeVoucherMap.get(summary.getOtherBankAccount());
							bean.setCreditSide(bean.getCreditSide().add(summary.getPaymentAmount()));
							employeeVoucherMap.put(summary.getOtherBankAccount(), bean);
							continue;
						}else {
							bean.setCreditSide(null == summary.getPaymentAmount() ? BigDecimal.ZERO : summary.getPaymentAmount());
							bean.setRemark(String.format("%1$s-员工报销款", null == vestingDate ? "" : payFormat.format(vestingDate)));
							bean.setSimplifyRemark(bean.getRemark());
						}
					}else if(summary.getPayFor().equals(StaticUtils.PAY_FOR_COMPANY)){
						//收款对象为单位
						bean.setCreditSide(summary.getPaymentAmount());
						bean.setSelfBankAccount(summary.getSelfBankAccount());
						String remark = String.format("%1$s-支付-%2$s", null == vestingDate ? "" : payFormat.format(vestingDate), summary.getPayeeName());
						bean.setRemark(remark);
						bean.setSimplifyRemark(remark);
					}else{
						throw new Exception("收款对象无法确定是个人还是公司");
					}
					//获取科目代码
					CardManage cardDao = new CardManage();
					cardDao.setConditionBankAccount("=", summary.getOtherBankAccount());
					cardDao.setConditionObjectType("=", 2);//单位银行卡
					cardDao.unsetSelectFlags();
					cardDao.setSelectCardManageId(true);
					List<BaseCardManage> cardList = cardDao.conditionalLoad();
					if(null != cardList && cardList.size() == 1){
						BaseK3Code code = getK3Code(StaticUtils.K3_CODE_TYPE_5, cardList.get(0).getCardManageId(), null, null, returnList);
						bean.setCodeType(StaticUtils.K3_CODE_TYPE_5);
						if(null != code) {
							bean.setCodeId(code.getK3CodeId());
							bean.setCode(code.getK3Code());
							bean.setName(code.getK3Name());
						}
					}else{
						throw new Exception("付款信息处无法找到合适的科目代码");
					}
					bean.setOtherBankAccount(summary.getOtherBankAccount());
					if(summary.getPayFor().equals(StaticUtils.PAY_FOR_PERSON)){
						employeeVoucherMap.put(summary.getOtherBankAccount(), bean);
					}
					if(summary.getPayFor().equals(StaticUtils.PAY_FOR_COMPANY)){
						bean.setInternalSequenceNumber(internalSequenceNumber);
						map.put(internalSequenceNumber, bean);
						internalSequenceNumber++;
					}
				}
			}
			if(!employeeVoucherMap.isEmpty()) {
				for(String key : employeeVoucherMap.keySet()) {
					BaseK3Voucher bean = employeeVoucherMap.get(key);
					bean.setInternalSequenceNumber(internalSequenceNumber);
					map.put(internalSequenceNumber++, bean);
				}
			}
		}
		return returnList;
	}

	/**
	 * 根据普通日常报销生成奖金凭证
	 * @param k3
	 * @param map
	 * @param summaryList
	 * @return
	 * @throws Exception
	 */
	public static List<BaseReceiveUnitManage> createBonusVoucher(BaseK3Voucher k3, Map<Integer, BaseK3Voucher> map, List<BaseReimbursementPackageSummary> summaryList) throws Exception{
		ReimbursementPackageDetail detailDao = new ReimbursementPackageDetail();
		detailDao.setConditionReimbursementPackageId("=", summaryList.get(0).getReimbursementPackageId());
		BaseReimbursementPackageDetail detailBean = detailDao.executeQueryOneRow();
		k3.setProcessId(detailBean.getProcessId());
		k3.setProcessType(detailBean.getProcessTypeId());
		k3.setBusinessId(detailBean.getBusinessId());
		k3.setProcessInstanceId(detailBean.getProcessInstanceId());
		k3.setRemark("发放项目奖金");
		k3.setSimplifyRemark("发放项目奖金");
		int internalSequenceNumber = 0;
		BaseK3Voucher k3Voucher1 = new BaseK3Voucher();
		BaseK3Voucher k3Voucher2 = new BaseK3Voucher();
		BaseK3Voucher k3Voucher3 = new BaseK3Voucher();
		k3.cloneCopy(k3Voucher1);
		k3.cloneCopy(k3Voucher2);
		k3.cloneCopy(k3Voucher3);
		K3Code codeDao = new K3Code();
		codeDao.setConditionType("=", 0);
		Integer[] businessIds = {StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_22, StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_24};
		codeDao.addCondition(BaseK3Code.CS_BUSINESS_ID, "in", (Object[])businessIds);
		List<BaseK3Code> codeList = codeDao.conditionalLoad();
		if(codeList.size() != 2) {
			throw new Exception("奖金的科目代码缺失");
		}
		for(BaseK3Code codeBean : codeList) {
			if(Objects.equals(codeBean.getBusinessId(), StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_22)) {
				k3Voucher1.setCodeId(codeBean.getK3CodeId());
				k3Voucher1.setCodeType(codeBean.getType());
				k3Voucher1.setCode(codeBean.getK3Code());
				k3Voucher1.setName(codeBean.getK3Name());
			}else if(Objects.equals(codeBean.getBusinessId(), StaticUtils.K3_CODE_TYPE_0_BUSINESS_ID_24)) {
				k3Voucher3.setCodeId(codeBean.getK3CodeId());
				k3Voucher3.setCodeType(codeBean.getType());
				k3Voucher3.setCode(codeBean.getK3Code());
				k3Voucher3.setName(codeBean.getK3Name());
			}
		}
		BigDecimal sum = BigDecimal.ZERO;
		for(BaseReimbursementPackageSummary summary : summaryList) {
			sum = sum.add(summary.getAmount());
			if(summary.getPayeeName().indexOf(SALARY_RECEIVE_UNIT_NAME) >= 0) {
				CardManage cardDao = new CardManage();
				cardDao.setConditionBankAccount("=", summary.getOtherBankAccount());
				cardDao.setConditionObjectType("=", 2);//单位银行卡
				cardDao.unsetSelectFlags();
				cardDao.setSelectCardManageId(true);
				List<BaseCardManage> cardList = cardDao.conditionalLoad();
				if(null != cardList && cardList.size() == 1){
					BaseK3Code code = getK3Code(StaticUtils.K3_CODE_TYPE_5, cardList.get(0).getCardManageId(), null, null, null);
					k3Voucher2.setCodeType(StaticUtils.K3_CODE_TYPE_5);
					if(null != code) {
						k3Voucher2.setCodeId(code.getK3CodeId());
						k3Voucher2.setCode(code.getK3Code());
						k3Voucher2.setName(code.getK3Name());
					}
				}else{
					throw new Exception("付款信息处无法找到合适的科目代码");
				}
				k3Voucher2.setCreditSide(summary.getAmount());
				k3Voucher2.setOtherBankAccount(summary.getOtherBankAccount());
			}else if(summary.getPayeeName().indexOf(PERSONAL_INCOME_TAX) >= 0) {
				k3Voucher3.setCreditSide(summary.getAmount());
				k3Voucher3.setOtherBankAccount(summary.getOtherBankAccount());
			}
		}
		k3Voucher1.setDebitSide(sum);
		k3Voucher1.setInternalSequenceNumber(internalSequenceNumber);
		map.put(internalSequenceNumber++, k3Voucher1);
		k3Voucher2.setInternalSequenceNumber(internalSequenceNumber);
		map.put(internalSequenceNumber++, k3Voucher2);
		k3Voucher3.setInternalSequenceNumber(internalSequenceNumber);
		map.put(internalSequenceNumber, k3Voucher3);
		return null;
	}

	/**
	 * 根据普通日常报销生成工资凭证
	 * @param k3
	 * @param map
	 * @param summaryList
	 * @return
	 * @throws Exception
	 */
	public static List<BaseReceiveUnitManage> createSalaryVoucher(BaseK3Voucher k3, Map<Integer, BaseK3Voucher> map, List<BaseReimbursementPackageSummary> summaryList, Map<Integer, BaseK3Voucher> insuranceMap) throws Exception{
		List<BaseReceiveUnitManage> returnList = new ArrayList<>();
		ReimbursementPackageDetail detailDao = new ReimbursementPackageDetail();
		detailDao.setConditionReimbursementPackageId("=", summaryList.get(0).getReimbursementPackageId());
		BaseReimbursementPackageDetail detailBean = detailDao.executeQueryOneRow();
		k3.setProcessId(detailBean.getProcessId());
		k3.setProcessType(detailBean.getProcessTypeId());
		k3.setBusinessId(detailBean.getBusinessId());
		k3.setProcessInstanceId(detailBean.getProcessInstanceId());
		int internalSequenceNumber = 0;
		ConditionCommonNormalRemarkAndAmount condition = new ConditionCommonNormalRemarkAndAmount();
		condition.setBusinessId(detailBean.getBusinessId());
		QueryCommonNormalRemarkAndAmount query = new QueryCommonNormalRemarkAndAmount();
		BaseCollection<BaseCommonNormalRemarkAndAmount> bc = query.executeQuery(null, condition);
		List<BaseCommonNormalRemarkAndAmount> normalDepartmentList = bc.getCollections();
		String remark = null;
		String simplifyRemark = null;
		BaseK3Code bankCode = null;
		if(null != normalDepartmentList && !normalDepartmentList.isEmpty()){
			for(BaseCommonNormalRemarkAndAmount department : normalDepartmentList){
				if(department.getFinalAmount().compareTo(BigDecimal.ZERO) == 0) {
					continue;
				}
				Integer businessId = null;
				if(null == department.getSubItemId() || (null != department.getSubItemId() && department.getSubItemId().equals(0))){
					businessId = department.getMainItemId();
				}else {
					businessId = department.getSubItemId();
				}
				if (null == remark) {
					remark = department.getRemark();
					if (remark.length() > 100) {
						simplifyRemark = remark.substring(0, 100);
					} else {
						simplifyRemark = remark;
					}
					k3.setRemark(remark);
					k3.setSimplifyRemark(simplifyRemark);
				}
				BaseK3Voucher bean = new BaseK3Voucher();
				k3.cloneCopy(bean);
				//获取科目代码；此处可能还要加上部门的科目代码
				bean.setCodeType(StaticUtils.K3_CODE_TYPE_4);
				BaseK3Code code1 = getK3Code(StaticUtils.K3_CODE_TYPE_4, businessId, null, null, returnList);
				if(null != code1){
					bean.setCodeId(code1.getK3CodeId());
					bean.setCode(code1.getK3Code());
					bean.setName(code1.getK3Name());
				}
				bean.setAmountOfReimbursement(department.getAmount());
				bean.setDebitSide(department.getFinalAmount());
				bean.setInternalSequenceNumber(internalSequenceNumber);
				map.put(internalSequenceNumber, bean);
				internalSequenceNumber++;
			}
		}
		ProcessBillList billDao = new ProcessBillList();
		billDao.setConditionProcessType("=", detailBean.getProcessTypeId());
		billDao.setConditionBusinessId("=", detailBean.getBusinessId());
		List<BaseProcessBillList> billList = billDao.conditionalLoad();
		for(BaseProcessBillList billBean : billList) {
			if(!billBean.getPayFor().equals(StaticUtils.PAY_FOR_COMPANY)) {
				continue;
			}
			if(billBean.getPayeeName().indexOf(SALARY_RECEIVE_UNIT_NAME) >= 0) {
				//获取付款给代发业务（工资）的银行账号的科目代码
				CardManage cardDao = new CardManage();
				cardDao.setConditionBankAccount("=", billBean.getOtherBankAccount());
				cardDao.setConditionObjectType("=", 2);//单位银行卡
				cardDao.unsetSelectFlags();
				cardDao.setSelectCardManageId(true);
				List<BaseCardManage> cardList = cardDao.conditionalLoad();
				if(null != cardList && cardList.size() == 1){
					BaseK3Code code = getK3Code(StaticUtils.K3_CODE_TYPE_5, cardList.get(0).getCardManageId(), null, null, returnList);
					BaseK3Voucher bean = new BaseK3Voucher();
					k3.cloneCopy(bean);
					bean.setCodeType(StaticUtils.K3_CODE_TYPE_5);
					if(null != code) {
						if(null == bankCode) {
							bankCode = new BaseK3Code();
							code.cloneCopy(bankCode);
						}
						bean.setCodeId(code.getK3CodeId());
						bean.setCode(code.getK3Code());
						bean.setName(code.getK3Name());
					}
					int num = 0;
					if(null != billBean.getPayMoney() && billBean.getPayMoney().compareTo(BigDecimal.ZERO) != 0) {
						num++;
						//代发业务（工资）的付款金额放在贷方
						bean.setCreditSide(billBean.getPayMoney());
						bean.setOtherBankAccount(billBean.getOtherBankAccount());
						bean.setInternalSequenceNumber(internalSequenceNumber);
						map.put(internalSequenceNumber, bean);
						internalSequenceNumber++;
					}
					if(null != billBean.getBalanceAmount() && billBean.getBalanceAmount().compareTo(BigDecimal.ZERO) != 0) {
						//代发业务（工资）的冲账金额相反数放在借方
						BaseK3Voucher bean2;
						if(num > 0) {
							bean2 = new BaseK3Voucher();
							bean.cloneCopy(bean2);
						}else {
							bean2 = bean;
						}
						bean2.setDebitSide(billBean.getBalanceAmount().negate());
						bean2.setInternalSequenceNumber(internalSequenceNumber);
						map.put(internalSequenceNumber, bean2);
						internalSequenceNumber++;
					}
				}else{
					throw new Exception("付款信息处无法找到合适的科目代码");
				}
			}else if(billBean.getPayeeName().indexOf(PERSONAL_INCOME_TAX) >= 0 || billBean.getPayeeName().indexOf(HOUSING_FUND) >= 0) {
				//个人所得税、住房公积金
				if(billBean.getBalanceAmount().compareTo(BigDecimal.ZERO) == 0)
					continue;
				BaseK3Voucher bean = new BaseK3Voucher();
				k3.cloneCopy(bean);
				BaseK3Code code;
				if(billBean.getPayeeName().indexOf(PERSONAL_INCOME_TAX) >= 0) {
					//个人所得税
					code = getK3Code(StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_3, null, null, returnList);
				}else {
					//住房公积金
					code = getK3Code(StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_9, null, null, returnList);
				}
				bean.setCodeType(StaticUtils.K3_CODE_TYPE_12);
				if(null != code) {
					bean.setCodeId(code.getK3CodeId());
					bean.setCode(code.getK3Code());
					bean.setName(code.getK3Name());
				}
				bean.setCreditSide(billBean.getBalanceAmount());
				bean.setOtherBankAccount(billBean.getOtherBankAccount());
				bean.setInternalSequenceNumber(internalSequenceNumber);
				map.put(internalSequenceNumber, bean);
				internalSequenceNumber++;
			}
		}
		ConditionFiveinsuranceSummary conditionFIS = new ConditionFiveinsuranceSummary();
		conditionFIS.setCompanyId(k3.getCompanyId());
		Date vestingDate = k3.getVestingDate();
		int month = DateUtil.getMonth(vestingDate);
		int year = DateUtil.getYear(vestingDate);
		if(month == 1) {
			month = 12;
			year--;
		}else {
			month--;
		}
		conditionFIS.setYear(year);
		conditionFIS.setStartMonth(month);
		conditionFIS.setEndMonth(month);
		QueryFiveinsuranceSummary queryFIS = new QueryFiveinsuranceSummary();
		BaseCollection<BaseFiveinsuranceSummary> collectionFIS = queryFIS.executeQuery(null, conditionFIS);
		if(null != collectionFIS && null != collectionFIS.getCollections() && !collectionFIS.getCollections().isEmpty()) {
			BaseFiveinsuranceSummary FISBean = collectionFIS.getCollections().get(0);
			BaseK3Voucher insuranceVoucher = null;
			if(null != bankCode) {
				//如果没有银行的K3代码，则不执行下面的五险一金凭证生成
				int insuranceNumber = 0;
				insuranceVoucher = new BaseK3Voucher();
				k3.cloneCopy(insuranceVoucher);
				insuranceVoucher.setSequenceNumber(BaseHelpUtils.getIntValue(insuranceVoucher.getSequenceNumber()) + 1);
				insuranceVoucher.setVoucherType(StaticUtils.VOUCHER_TYPE_6);
				insuranceVoucher.setRemark(String.format("缴纳%1$s月份社保", month));
				insuranceVoucher.setSimplifyRemark(insuranceVoucher.getRemark());
				BigDecimal insuranceAmount = BigDecimal.ZERO; 
				if(null != FISBean.getUnitPension() && FISBean.getUnitPension().compareTo(BigDecimal.ZERO) != 0) {
					//五险一金凭证：养老保险【公司交】
					insuranceAmount = insuranceAmount.add(FISBean.getUnitPension());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_11, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_1, null, null, FISBean.getUnitPension(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getUnitMedicalInsurance() && FISBean.getUnitMedicalInsurance().compareTo(BigDecimal.ZERO) != 0) {
					//五险一金凭证：医疗保险【公司交】
					insuranceAmount = insuranceAmount.add(FISBean.getUnitMedicalInsurance());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_11, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_2, null, null, FISBean.getUnitMedicalInsurance(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getUnitLargeMedicalInsurance() && FISBean.getUnitLargeMedicalInsurance().compareTo(BigDecimal.ZERO) != 0) {
					//五险一金凭证：大额医疗保险【公司交】
					insuranceAmount = insuranceAmount.add(FISBean.getUnitLargeMedicalInsurance());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_11, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_2, null, null, FISBean.getUnitLargeMedicalInsurance(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getUnitInjuryInsurance() && FISBean.getUnitInjuryInsurance().compareTo(BigDecimal.ZERO) != 0) {
					//五险一金凭证：工伤保险【公司交】
					insuranceAmount = insuranceAmount.add(FISBean.getUnitInjuryInsurance());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_11, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_4, null, null, FISBean.getUnitInjuryInsurance(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getUnitUnemploymentInsurance() && FISBean.getUnitUnemploymentInsurance().compareTo(BigDecimal.ZERO) != 0) {
					//五险一金凭证：失业保险【公司交】
					insuranceAmount = insuranceAmount.add(FISBean.getUnitUnemploymentInsurance());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_11, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_3, null, null, FISBean.getUnitUnemploymentInsurance(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getUnitGiveBirthInsurance() && FISBean.getUnitGiveBirthInsurance().compareTo(BigDecimal.ZERO) != 0) {
					//五险一金凭证：生育保险【公司交】
					insuranceAmount = insuranceAmount.add(FISBean.getUnitGiveBirthInsurance());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_11, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_5, null, null, FISBean.getUnitGiveBirthInsurance(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getPersonalPension() && FISBean.getPersonalPension().compareTo(BigDecimal.ZERO) != 0) {
					//工资凭证：个人养老保险
					createCommonVoucher(internalSequenceNumber, map, k3, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_4, null, null, FISBean.getPersonalPension(), false, returnList);
					internalSequenceNumber++;
					//五险一金凭证：个人养老保险
					insuranceAmount = insuranceAmount.add(FISBean.getPersonalPension());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_4, null, null, FISBean.getPersonalPension(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getPersonalMedicalInsurance() && FISBean.getPersonalMedicalInsurance().compareTo(BigDecimal.ZERO) != 0) {
					//工资：个人医疗保险
					createCommonVoucher(internalSequenceNumber, map, k3, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_5, null, null, FISBean.getPersonalMedicalInsurance(), false, returnList);
					internalSequenceNumber++;
					//五险一金凭证：个人医疗保险
					insuranceAmount = insuranceAmount.add(FISBean.getPersonalMedicalInsurance());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_5, null, null, FISBean.getPersonalMedicalInsurance(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getPersonalLargeMedicalInsurance() && FISBean.getPersonalLargeMedicalInsurance().compareTo(BigDecimal.ZERO) != 0) {
					//工资：个人大额医疗保险
					createCommonVoucher(internalSequenceNumber, map, k3, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_5, null, null, FISBean.getPersonalLargeMedicalInsurance(), false, returnList);
					internalSequenceNumber++;
					//五险一金凭证：个人大额医疗保险
					insuranceAmount = insuranceAmount.add(FISBean.getPersonalLargeMedicalInsurance());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_5, null, null, FISBean.getPersonalLargeMedicalInsurance(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getPersonalSeriousIllInsurance() && FISBean.getPersonalSeriousIllInsurance().compareTo(BigDecimal.ZERO) != 0) {
					//工资：个人大病保险
					createCommonVoucher(internalSequenceNumber, map, k3, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_7, null, null, FISBean.getPersonalSeriousIllInsurance(), false, returnList);
					internalSequenceNumber++;
					//五险一金凭证：个人大病保险
					insuranceAmount = insuranceAmount.add(FISBean.getPersonalSeriousIllInsurance());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_7, null, null, FISBean.getPersonalSeriousIllInsurance(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getPersonalUnemploymentInsurance() && FISBean.getPersonalUnemploymentInsurance().compareTo(BigDecimal.ZERO) != 0) {
					//工资：个人失业保险
					createCommonVoucher(internalSequenceNumber, map, k3, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_6, null, null, FISBean.getPersonalUnemploymentInsurance(), false, returnList);
					internalSequenceNumber++;
					//五险一金凭证：个人失业保险
					insuranceAmount = insuranceAmount.add(FISBean.getPersonalUnemploymentInsurance());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_6, null, null, FISBean.getPersonalUnemploymentInsurance(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getPersonalHeating() && FISBean.getPersonalHeating().compareTo(BigDecimal.ZERO) != 0) {
					//工资：个人采暖
					createCommonVoucher(internalSequenceNumber, map, k3, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_8, null, null, FISBean.getPersonalHeating(), false, returnList);
					internalSequenceNumber++;
					//五险一金凭证：个人采暖
					insuranceAmount = insuranceAmount.add(FISBean.getPersonalHeating());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_8, null, null, FISBean.getPersonalHeating(), true, returnList);
					insuranceNumber++;
				}
				//五险一金凭证的五险贷方数据
				BaseK3Voucher insuranceBean = new BaseK3Voucher();
				insuranceVoucher.cloneCopy(insuranceBean);
				insuranceBean.setCodeType(bankCode.getType());
				insuranceBean.setCodeId(bankCode.getK3CodeId());
				insuranceBean.setCode(bankCode.getK3Code());
				insuranceBean.setName(bankCode.getK3Name());
				insuranceBean.setCreditSide(insuranceAmount);
				insuranceBean.setInternalSequenceNumber(insuranceNumber);
				insuranceMap.put(insuranceNumber++, insuranceBean);
				insuranceVoucher.setRemark(String.format("缴纳%1$s月份公积金", month));
				insuranceVoucher.setSimplifyRemark(insuranceVoucher.getRemark());
				BigDecimal housingFundAmount = BigDecimal.ZERO;
				if(null != FISBean.getUnitTotalFund() && FISBean.getUnitTotalFund().compareTo(BigDecimal.ZERO) != 0) {
					//五险一金凭证：公积金【公司交】
					housingFundAmount = housingFundAmount.add(FISBean.getUnitTotalFund());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_11, StaticUtils.K3_CODE_TYPE_11_BUSINESS_ID_7, null, null, FISBean.getUnitTotalFund(), true, returnList);
					insuranceNumber++;
				}
				if(null != FISBean.getPersonalTotalFund() && FISBean.getPersonalTotalFund().compareTo(BigDecimal.ZERO) != 0) {
					//五险一金凭证：公积金【公司交】
					housingFundAmount = housingFundAmount.add(FISBean.getPersonalTotalFund());
					createCommonVoucher(insuranceNumber, insuranceMap, insuranceVoucher, StaticUtils.K3_CODE_TYPE_12, StaticUtils.K3_CODE_TYPE_12_BUSINESS_ID_9, null, null, FISBean.getPersonalTotalFund(), true, returnList);
					insuranceNumber++;
				}
				//五险一金凭证的住房公积金贷方数据
				BaseK3Voucher housingFundBean = new BaseK3Voucher();
				insuranceBean.cloneCopy(housingFundBean);
				housingFundBean.setCreditSide(housingFundAmount);
				housingFundBean.setInternalSequenceNumber(insuranceNumber);
				housingFundBean.setRemark(insuranceVoucher.getRemark());
				housingFundBean.setSimplifyRemark(housingFundBean.getRemark());
				map.put(insuranceNumber++, housingFundBean);
			}
		}
		return returnList;
	}

	public static List<BaseReceiveUnitManage> createCommonVoucher(int internalSequenceNumber, Map<Integer, BaseK3Voucher> map, BaseK3Voucher k3, Integer type, Integer businessId, Integer departmentId, Integer departmentType, BigDecimal amount, boolean isDebit, List<BaseReceiveUnitManage> returnList) throws Exception{
		BaseK3Code code = getK3Code(type, businessId, departmentId, departmentType, returnList);
		BaseK3Voucher bean = new BaseK3Voucher();
		k3.cloneCopy(bean);
		bean.setCodeType(type);
		if(null != code) {
			bean.setCodeId(code.getK3CodeId());
			bean.setCode(code.getK3Code());
			bean.setName(code.getK3Name());
		}
		if(isDebit) {
			bean.setDebitSide(amount);
		}else {
			bean.setCreditSide(amount);
		}
		bean.setInternalSequenceNumber(internalSequenceNumber);
		map.put(internalSequenceNumber, bean);
		return returnList;
	}
	
	public static int commonData(int internalSequenceNumber, Map<Integer, BaseK3Voucher> map, BaseK3Voucher k3,
			BaseReimbursementPackageDetail detail, String remark, String simplifyRemark, BigDecimal inputTax, BigDecimal inputTaxRebate,
			BaseK3Code k3CodeType0BusinessId8, BaseK3Code k3CodeType0BusinessId9, List<BaseReceiveUnitManage> returnList)
			throws SQLException, Exception {
		if(null != inputTax && inputTax.compareTo(BigDecimal.ZERO) != 0 && null != k3CodeType0BusinessId8){
			// 进项税
			BaseK3Voucher inputTaxBean = new BaseK3Voucher();
			k3.cloneCopy(inputTaxBean);
			inputTaxBean.setProcessId(detail.getProcessId());
			inputTaxBean.setProcessType(detail.getProcessTypeId());
			inputTaxBean.setProcessInstanceId(detail.getProcessInstanceId());
			inputTaxBean.setBusinessId(detail.getBusinessId());
			inputTaxBean.setCodeType(k3CodeType0BusinessId8.getType());
			inputTaxBean.setCodeId(k3CodeType0BusinessId8.getK3CodeId());
			inputTaxBean.setCode(k3CodeType0BusinessId8.getK3Code());
			inputTaxBean.setName(k3CodeType0BusinessId8.getK3Name());
			inputTaxBean.setInternalSequenceNumber(internalSequenceNumber);
			inputTaxBean.setRemark(remark);
			inputTaxBean.setSimplifyRemark(simplifyRemark);
			inputTaxBean.setDebitSide(inputTax);
			map.put(internalSequenceNumber, inputTaxBean);
			internalSequenceNumber++;
		}
		if(null != inputTaxRebate && inputTaxRebate.compareTo(BigDecimal.ZERO) != 0 && null != k3CodeType0BusinessId9){
			// 进项税转出金额
			BaseK3Voucher inputTaxRebateBean = new BaseK3Voucher();
			k3.cloneCopy(inputTaxRebateBean);
			inputTaxRebateBean.setProcessId(detail.getProcessId());
			inputTaxRebateBean.setProcessType(detail.getProcessTypeId());
			inputTaxRebateBean.setProcessInstanceId(detail.getProcessInstanceId());
			inputTaxRebateBean.setBusinessId(detail.getBusinessId());
			inputTaxRebateBean.setCodeType(k3CodeType0BusinessId9.getType());
			inputTaxRebateBean.setCodeId(k3CodeType0BusinessId9.getK3CodeId());
			inputTaxRebateBean.setCode(k3CodeType0BusinessId9.getK3Code());
			inputTaxRebateBean.setName(k3CodeType0BusinessId9.getK3Name());
			inputTaxRebateBean.setInternalSequenceNumber(internalSequenceNumber);
			inputTaxRebateBean.setRemark(remark);
			inputTaxRebateBean.setSimplifyRemark(simplifyRemark);
			inputTaxRebateBean.setCreditSide(inputTaxRebate);
			map.put(internalSequenceNumber, inputTaxRebateBean);
			internalSequenceNumber++;
		}
		// 往来借方和贷方
		ProcessBillList pb = new ProcessBillList();
		pb.setConditionBusinessId("=", detail.getBusinessId());
		pb.setConditionProcessType("=", detail.getProcessTypeId());
		pb.unsetSelectFlags();
		pb.setSelectPayFor(true);
		pb.setSelectEmployeeOrCompanyId(true);
		pb.setSelectPayMoney(true);
		pb.setSelectBalanceAmount(true);
		List<BaseProcessBillList> pbList = pb.conditionalLoad();
		if(null != pbList && !pbList.isEmpty()){
			for(BaseProcessBillList pbBean : pbList){
				if(null == pbBean.getPayFor()){
					throw new Exception("收款对象为空");
				}else if(pbBean.getPayFor().equals(StaticUtils.PAY_FOR_PERSON)){
					//当收款对象为个人，且冲账金额为0时，不需要记录往来借贷信息
					if(null == pbBean.getBalanceAmount() || (null != pbBean.getBalanceAmount() && pbBean.getBalanceAmount().compareTo(BigDecimal.ZERO) == 0)){
						continue;
					}
					BaseK3Voucher debitBean = new BaseK3Voucher();//借方
					BaseK3Voucher creditBean = new BaseK3Voucher();//贷方
					k3.cloneCopy(debitBean);
					debitBean.setProcessId(detail.getProcessId());
					debitBean.setProcessType(detail.getProcessTypeId());
					debitBean.setProcessInstanceId(detail.getProcessInstanceId());
					debitBean.setBusinessId(detail.getBusinessId());
					//科目代码
					BaseK3Code code3 = getK3Code(StaticUtils.K3_CODE_TYPE_7, pbBean.getPayFor(), null, null, returnList);
					debitBean.setCodeType(StaticUtils.K3_CODE_TYPE_7);
					if(null != code3) {
						debitBean.setCodeId(code3.getK3CodeId());
						debitBean.setCode(code3.getK3Code());
						debitBean.setName(code3.getK3Name());
					}
					//辅助核算科目代码
					BaseK3Code code4 = getK3Code(StaticUtils.K3_CODE_TYPE_1, pbBean.getEmployeeOrCompanyId(), null, null, returnList);
					debitBean.setSecondaryCodeType(StaticUtils.K3_CODE_TYPE_1);
					if(null != code4) {
						debitBean.setSecondaryCodeId(code4.getK3CodeId());
						debitBean.setSecondaryCode(code4.getK3Code());
						if(null != code4.getK3Name() && code4.getK3Name().indexOf("---") >= 0) {
							String[] k3NameArr = code4.getK3Name().split("---");
							debitBean.setSecondaryName(k3NameArr[k3NameArr.length - 1]);
						}else {
							debitBean.setSecondaryName(code4.getK3Name());
						}
					}
					debitBean.setRemark(remark);
					debitBean.setSimplifyRemark(simplifyRemark);
					debitBean.cloneCopy(creditBean);
					//冲账的时候，先贷总额
					creditBean.setInternalSequenceNumber(internalSequenceNumber);
					creditBean.setCreditSide(pbBean.getPayMoney().add(pbBean.getBalanceAmount()));
					map.put(internalSequenceNumber, creditBean);
					internalSequenceNumber++;
					//再借付款金额
					debitBean.setDebitSide(null == pbBean.getPayMoney() ? BigDecimal.ZERO : pbBean.getPayMoney());
					if(debitBean.getDebitSide().compareTo(BigDecimal.ZERO) != 0){
						debitBean.setInternalSequenceNumber(internalSequenceNumber);
						map.put(internalSequenceNumber, debitBean);
						internalSequenceNumber++;
					}
				}else if(pbBean.getPayFor().equals(StaticUtils.PAY_FOR_COMPANY)){
					BaseK3Voucher debitBean = new BaseK3Voucher();//借方
					BaseK3Voucher creditBean = new BaseK3Voucher();//贷方
					k3.cloneCopy(debitBean);
					debitBean.setProcessId(detail.getProcessId());
					debitBean.setProcessType(detail.getProcessTypeId());
					debitBean.setProcessInstanceId(detail.getProcessInstanceId());
					debitBean.setBusinessId(detail.getBusinessId());
					//根据收款单位的ID，来获取该收款单位的凭证是预付账款、应付账款还是其他应收
					ReceiveUnitManage rumDao = new ReceiveUnitManage();
					rumDao.setReceiveUnitManageId(pbBean.getEmployeeOrCompanyId());
					rumDao.unsetSelectFlags();
					rumDao.setSelectVoucherType(true);
					rumDao.setSelectReceiveUnit(true);
					rumDao.setSelectBankAccount(true);
					if(!rumDao.load()) {
						returnList.add(generateBaseReceiveUnitManage(null, null, null, null, null, String.format("找不到收款单位[ID:%1$s]的信息", pbBean.getEmployeeOrCompanyId())));
						continue;
					}
					if(null == rumDao.getVoucherType()) {
						returnList.add(generateBaseReceiveUnitManage(null, null, null, null, null, String.format("收款单位[%1$s]，账号[%2$s]没有设置凭证类型", rumDao.getReceiveUnit(), rumDao.getBankAccount())));
						continue;
					}
					//科目代码
					BaseK3Code code3 = getK3Code(StaticUtils.K3_CODE_TYPE_7, pbBean.getPayFor(), null, rumDao.getVoucherType(), returnList);
					debitBean.setCodeType(StaticUtils.K3_CODE_TYPE_7);
					if(null != code3) {
						debitBean.setCodeId(code3.getK3CodeId());
						debitBean.setCode(code3.getK3Code());
						debitBean.setName(code3.getK3Name());
					}
					//辅助核算科目代码
					BaseK3Code code4 = getK3Code(StaticUtils.K3_CODE_TYPE_8, pbBean.getEmployeeOrCompanyId(), null, null, returnList);
					debitBean.setSecondaryCodeType(StaticUtils.K3_CODE_TYPE_8);
					if(null != code4) {
						debitBean.setSecondaryCodeId(code4.getK3CodeId());
						debitBean.setSecondaryCode(code4.getK3Code());
						if(null != code4.getK3Name() && code4.getK3Name().indexOf("---") >= 0) {
							String[] k3NameArr = code4.getK3Name().split("---");
							debitBean.setSecondaryName(k3NameArr[k3NameArr.length - 1]);
						}else {
							debitBean.setSecondaryName(code4.getK3Name());
						}
					}
					debitBean.setRemark(remark);
					debitBean.setSimplifyRemark(simplifyRemark);
					debitBean.cloneCopy(creditBean);
					debitBean.setDebitSide(null == pbBean.getPayMoney() ? BigDecimal.ZERO : pbBean.getPayMoney());
					if(debitBean.getDebitSide().compareTo(BigDecimal.ZERO) != 0){
						debitBean.setInternalSequenceNumber(internalSequenceNumber);
						map.put(internalSequenceNumber, debitBean);
						internalSequenceNumber++;
					}
					creditBean.setInternalSequenceNumber(internalSequenceNumber);
					creditBean.setCreditSide(debitBean.getDebitSide().add(null == pbBean.getBalanceAmount() ? BigDecimal.ZERO : pbBean.getBalanceAmount()));
					map.put(internalSequenceNumber, creditBean);
					internalSequenceNumber++;
				}else{
					throw new Exception("收款对象无法确定是个人还是公司");
				}
			}
		}
		return internalSequenceNumber;
	}

	public static BaseK3Code getK3Code(Integer type, Integer businessId, Integer departmentId, Integer departmentType, List<BaseReceiveUnitManage> returnList) throws Exception {
		if (null != type || null != businessId || null != departmentId) {
			if(null == returnList) {
				returnList = new ArrayList<>();
			}
			Integer k3CodeId = null;
			K3Code codeDao = new K3Code();
			if (null != type) {
				codeDao.setConditionType("=", type);
			}
			if (null != businessId) {
				codeDao.setConditionBusinessId("=", businessId);
			}
			String additionalCondition = null;
			if (null != departmentId) {
				Department dao = new Department();
				dao.setDepartmentId(departmentId);
				dao.unsetSelectFlags();
				dao.setSelectDepartmentType(true);
				if(dao.load()){
					codeDao.setConditionDepartmentType("=", dao.getDepartmentType());
					departmentType = dao.getDepartmentType();
				}
			}else if(null != departmentType){
				codeDao.setConditionDepartmentType("=", departmentType);
			}else {
				additionalCondition = String.format("%1$s is null", BaseK3Code.CS_DEPARTMENT_TYPE);
			}
			List<BaseK3Code> codeList = codeDao.conditionalLoad(additionalCondition);
			String errorMsg = null;
			if (null != codeList && !codeList.isEmpty()) {
				if (codeList.size() > 1) {
					errorMsg = "类型：#type#； 对象：#business#找到了多条对应的科目代码";
				} else {
					BaseK3Code code = codeList.get(0);
					if(null == code.getK3Code()){
						k3CodeId = code.getK3CodeId();
						errorMsg = "类型：#type#； 对象：#business#没有K3科目代码，请在k3代码维护页面完善数据";
					}else{
						return code;
					}
				}
			} else {
				if(null != type && null != businessId) {
					codeDao.clear();
					codeDao.setType(type);
					codeDao.setBusinessId(businessId);
					codeDao.setDepartmentType(departmentType);
					codeDao.save();
					k3CodeId = codeDao.getK3CodeId();
					errorMsg = "类型：#type#； 对象：#business#刚新增了K3记录，请在k3代码维护页面完善数据";
				}
			}
			if(null != errorMsg){
				switch(type){
				case StaticUtils.K3_CODE_TYPE_1:
					errorMsg = errorMsg.replace("#type#", "员工");
					if(null != businessId) {
						Employee eDao = new Employee();
						eDao.setEmployeeId(businessId);
						eDao.unsetSelectFlags();
						eDao.setSelectEmployeeName(true);
						eDao.setSelectEmployeeNo(true);
						if(eDao.load()){
							errorMsg = errorMsg.replace("#business#", eDao.getEmployeeNo() + "--" + eDao.getEmployeeName());
							returnList.add(generateBaseReceiveUnitManage(k3CodeId, type, businessId, eDao.getEmployeeName(), null, errorMsg));
						}
					}
					break;
				case StaticUtils.K3_CODE_TYPE_2:
					errorMsg = errorMsg.replace("#type#", "公司");
					if(null != businessId) {
						SystemDictionary sdDao = new SystemDictionary();
						sdDao.setConditionDicTypeId("=", 26);
						sdDao.setConditionDicTypeValueId("=", businessId);
						sdDao.unsetSelectFlags();
						sdDao.setSelectDicTypeValue(true);
						BaseSystemDictionary bsd = sdDao.executeQueryOneRow();
						if(null != bsd && BaseHelpUtils.isNullOrEmpty(bsd.getDicTypeValue())){
							errorMsg = errorMsg.replace("#business#", bsd.getDicTypeValue());
							returnList.add(generateBaseReceiveUnitManage(k3CodeId, type, businessId, bsd.getDicTypeValue(), null, errorMsg));
						}
					}
					break;
				case StaticUtils.K3_CODE_TYPE_3:
					errorMsg = errorMsg.replace("#type#", "部门");
					if(null != businessId) {
						Department dDao = new Department();
						dDao.setDepartmentId(businessId);
						dDao.unsetSelectFlags();
						dDao.setSelectDepartmentName(true);
						if(dDao.load()){
							errorMsg = errorMsg.replace("#business#", dDao.getDepartmentName());
							returnList.add(generateBaseReceiveUnitManage(k3CodeId, type, businessId, dDao.getDepartmentName(), null, errorMsg));
						}
					}
					break;
				case StaticUtils.K3_CODE_TYPE_4:
					errorMsg = errorMsg.replace("#type#", "科目");
					if(null != businessId) {
						SubjectType stDao = new SubjectType();
						stDao.setSubjectTypeId(businessId);
						stDao.unsetSelectFlags();
						stDao.setSelectSubjectName(true);
						if(stDao.load()){
							errorMsg = errorMsg.replace("#business#", stDao.getSubjectName());
							returnList.add(generateBaseReceiveUnitManage(k3CodeId, type, businessId, stDao.getSubjectName(), BaseHelpUtils.getString(departmentType), errorMsg));
						}
					}
					break;
				case StaticUtils.K3_CODE_TYPE_5:
					errorMsg = errorMsg.replace("#type#", "银行账号");
					if(null != businessId) {
						CardManage cmDao = new CardManage();
						cmDao.setCardManageId(businessId);
						cmDao.unsetSelectFlags();
						cmDao.setSelectBankAccount(true);
						cmDao.setSelectBankAddress(true);
						if(cmDao.load()){
							errorMsg = errorMsg.replace("#business#", cmDao.getBankAccount() + "--" + cmDao.getBankAddress());
							returnList.add(generateBaseReceiveUnitManage(k3CodeId, type, businessId, cmDao.getBankAddress(), cmDao.getBankAccount(), errorMsg));
						}
					}
					break;
				case StaticUtils.K3_CODE_TYPE_6:
					errorMsg = errorMsg.replace("#type#", "流程类型");
					returnList.add(generateBaseReceiveUnitManage(k3CodeId, type, businessId, null, null, errorMsg));
					break;
				case StaticUtils.K3_CODE_TYPE_7:
					errorMsg = errorMsg.replace("#type#", "收款方类型");
					returnList.add(generateBaseReceiveUnitManage(k3CodeId, type, businessId, null, null, errorMsg));
					break;
				case StaticUtils.K3_CODE_TYPE_8:
					errorMsg = errorMsg.replace("#type#", "收款单位");
					if(null != businessId) {
						ReceiveUnitManage rumDao = new ReceiveUnitManage();
						rumDao.setReceiveUnitManageId(businessId);
						rumDao.unsetSelectFlags();
						rumDao.setSelectBankAccount(true);
						rumDao.setSelectBankName(true);
						if(rumDao.load()){
							errorMsg = errorMsg.replace("#business#", rumDao.getBankAccount() + "--" + rumDao.getBankName());
							returnList.add(generateBaseReceiveUnitManage(k3CodeId, type, businessId, rumDao.getBankName(), rumDao.getBankAccount(), errorMsg));
						}
					}
					break;
				case StaticUtils.K3_CODE_TYPE_9:
					errorMsg = errorMsg.replace("#type#", "客户");
					if(null != businessId) {
						Customer cDao = new Customer();
						cDao.setCustomerId(businessId);
						cDao.unsetSelectFlags();
						cDao.setSelectCustomerName(true);
						if(cDao.load()){
							errorMsg = errorMsg.replace("#business#", cDao.getCustomerName());
							returnList.add(generateBaseReceiveUnitManage(k3CodeId, type, businessId, cDao.getCustomerName(), null, errorMsg));
						}
					}
					break;
				default:
					break;
				}
				if(errorMsg.contains("#business#")){
					errorMsg = errorMsg.replace("#business#", String.format("[ID:%1$s]", businessId));
					returnList.add(generateBaseReceiveUnitManage(k3CodeId, type, businessId, null, null, errorMsg));
				}
			}
		}else {
			returnList.add(generateBaseReceiveUnitManage(null, null, null, null, null, String.format("type:%1$s; businessId:%2$s; departmentId:%3$s; 条件不全，找不到科目代码", type, businessId, departmentId)));
		}
		return null;
	}
	
	public static BaseReceiveUnitManage generateBaseReceiveUnitManage(Integer k3CodeId, Integer type, Integer businessId, String name, String bankAccount, String remark) {
		BaseReceiveUnitManage bean = new BaseReceiveUnitManage();
		bean.setReceiveUnitManageId(k3CodeId);
		bean.setReceiveUnitType(type);
		bean.setBankId(businessId);
		bean.setReceiveUnit(name);
		bean.setBankAccount(bankAccount);
		bean.setReceiveUnitAddress(remark);
		return bean;
	}
	
	public static String formatRemark(String remark) {
		if(BaseHelpUtils.isNullOrEmpty(remark)) {
			return "";
		}
		return remark.replaceAll("\r", "").replaceAll("\n", "").replaceAll(",", "，");
	}
}
