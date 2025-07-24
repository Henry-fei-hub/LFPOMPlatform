package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePayMoneyManage extends GenericBase implements BaseFactory<BasePayMoneyManage>, Comparable<BasePayMoneyManage> 
{


	public static BasePayMoneyManage newInstance(){
		return new BasePayMoneyManage();
	}

	@Override
	public BasePayMoneyManage make(){
		BasePayMoneyManage b = new BasePayMoneyManage();
		return b;
	}

	public final static java.lang.String CS_PAY_MONEY_MANAGE_ID = "pay_money_manage_id" ;
	public final static java.lang.String CS_RECEIVE_UNIT = "receive_unit" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;
	public final static java.lang.String CS_TITLE_NAME = "title_name" ;
	public final static java.lang.String CS_PAY_AMOUNT = "pay_amount" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ATTACHMENT_FILE = "attachment_file" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_BE_PACKED = "be_packed" ;
	public final static java.lang.String CS_VOUCHER_NO = "voucher_no" ;
	public final static java.lang.String CS_POSTING_DATE = "posting_date" ;
	public final static java.lang.String CS_CURRENCY = "currency" ;
	public final static java.lang.String CS_EXCHANGE_RATE = "exchange_rate" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PAYMENT_SEQUENCE_ID = "payment_sequence_id" ;
	public final static java.lang.String CS_BUDGET_MANAGEMENT_ID = "budget_management_id" ;
	public final static java.lang.String CS_BUDGET_ATTACHMENT_ID = "budget_attachment_id" ;
	public final static java.lang.String CS_ATTACHMENT_ID = "attachment_id" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static java.lang.String CS_USE_OF_FUND = "use_of_fund" ;
	public final static java.lang.String CS_RELATED_TO_CONTRACT = "related_to_contract" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_RECEIVE_UNIT_ID = "receive_unit_id" ;
	public final static java.lang.String CS_PURCHASER_DEPARTMENT = "purchaser_department" ;
	public final static java.lang.String CS_PURCHASER = "purchaser" ;
	public final static java.lang.String CS_PURCHASING_CATEGORY = "purchasing_category" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,收款单位,银行账号,开户行,主题名称,,申请人,部门编码,附件,付款原因,操作人,操作时间,归属公司,编号,删除状态  0未删除    1已删除,true是),是否被打包,凭证号,入账日期,货币种类  0人民币   1港币   2美元,汇率,项目编码,付款序列编码,预算管理编码,预算附件编码,附件编码,附件名称,资金用途1普通 2投资理财,与合同或协议有关,合同金额,供应商,采购人归属部门,采购人,采购类别";

	public java.lang.Integer getPayMoneyManageId() {
		return this.__pay_money_manage_id;
	}

	public void setPayMoneyManageId( java.lang.Integer value ) {
		this.__pay_money_manage_id = value;
	}

	public java.lang.String getReceiveUnit() {
		return this.__receive_unit;
	}

	public void setReceiveUnit( java.lang.String value ) {
		this.__receive_unit = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getTitleName() {
		return this.__title_name;
	}

	public void setTitleName( java.lang.String value ) {
		this.__title_name = value;
	}

	public java.math.BigDecimal getPayAmount() {
		return this.__pay_amount;
	}

	public void setPayAmount( java.math.BigDecimal value ) {
		this.__pay_amount = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getAttachmentFile() {
		return this.__attachment_file;
	}

	public void setAttachmentFile( java.lang.String value ) {
		this.__attachment_file = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.Boolean getBePacked() {
		return this.__be_packed;
	}

	public void setBePacked( java.lang.Boolean value ) {
		this.__be_packed = value;
	}

	public java.lang.String getVoucherNo() {
		return this.__voucher_no;
	}

	public void setVoucherNo( java.lang.String value ) {
		this.__voucher_no = value;
	}

	public java.util.Date getPostingDate() {
		return this.__posting_date;
	}

	public void setPostingDate( java.util.Date value ) {
		this.__posting_date = value;
	}

	public java.lang.Integer getCurrency() {
		return this.__currency;
	}

	public void setCurrency( java.lang.Integer value ) {
		this.__currency = value;
	}

	public java.math.BigDecimal getExchangeRate() {
		return this.__exchange_rate;
	}

	public void setExchangeRate( java.math.BigDecimal value ) {
		this.__exchange_rate = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPaymentSequenceId() {
		return this.__payment_sequence_id;
	}

	public void setPaymentSequenceId( java.lang.Integer value ) {
		this.__payment_sequence_id = value;
	}

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.Integer getBudgetAttachmentId() {
		return this.__budget_attachment_id;
	}

	public void setBudgetAttachmentId( java.lang.Integer value ) {
		this.__budget_attachment_id = value;
	}

	public java.lang.Integer getAttachmentId() {
		return this.__attachment_id;
	}

	public void setAttachmentId( java.lang.Integer value ) {
		this.__attachment_id = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.Integer getUseOfFund() {
		return this.__use_of_fund;
	}

	public void setUseOfFund( java.lang.Integer value ) {
		this.__use_of_fund = value;
	}

	public java.lang.Boolean getRelatedToContract() {
		return this.__related_to_contract;
	}

	public void setRelatedToContract( java.lang.Boolean value ) {
		this.__related_to_contract = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.lang.Integer getReceiveUnitId() {
		return this.__receive_unit_id;
	}

	public void setReceiveUnitId( java.lang.Integer value ) {
		this.__receive_unit_id = value;
	}

	public java.lang.Integer getPurchaserDepartment() {
		return this.__purchaser_department;
	}

	public void setPurchaserDepartment( java.lang.Integer value ) {
		this.__purchaser_department = value;
	}

	public java.lang.Integer getPurchaser() {
		return this.__purchaser;
	}

	public void setPurchaser( java.lang.Integer value ) {
		this.__purchaser = value;
	}

	public java.lang.String getPurchasingCategory() {
		return this.__purchasing_category;
	}

	public void setPurchasingCategory( java.lang.String value ) {
		this.__purchasing_category = value;
	}

	public void cloneCopy(BasePayMoneyManage __bean){
		__bean.setPayMoneyManageId(getPayMoneyManageId());
		__bean.setReceiveUnit(getReceiveUnit());
		__bean.setBankAccount(getBankAccount());
		__bean.setBankName(getBankName());
		__bean.setTitleName(getTitleName());
		__bean.setPayAmount(getPayAmount());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setAttachmentFile(getAttachmentFile());
		__bean.setReason(getReason());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setCompanyId(getCompanyId());
		__bean.setCode(getCode());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setBePacked(getBePacked());
		__bean.setVoucherNo(getVoucherNo());
		__bean.setPostingDate(getPostingDate());
		__bean.setCurrency(getCurrency());
		__bean.setExchangeRate(getExchangeRate());
		__bean.setProjectId(getProjectId());
		__bean.setPaymentSequenceId(getPaymentSequenceId());
		__bean.setBudgetManagementId(getBudgetManagementId());
		__bean.setBudgetAttachmentId(getBudgetAttachmentId());
		__bean.setAttachmentId(getAttachmentId());
		__bean.setAttachmentName(getAttachmentName());
		__bean.setUseOfFund(getUseOfFund());
		__bean.setRelatedToContract(getRelatedToContract());
		__bean.setContractAmount(getContractAmount());
		__bean.setReceiveUnitId(getReceiveUnitId());
		__bean.setPurchaserDepartment(getPurchaserDepartment());
		__bean.setPurchaser(getPurchaser());
		__bean.setPurchasingCategory(getPurchasingCategory());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPayMoneyManageId() == null ? "" : getPayMoneyManageId());
		sb.append(",");
		sb.append(getReceiveUnit() == null ? "" : getReceiveUnit());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		sb.append(",");
		sb.append(getTitleName() == null ? "" : getTitleName());
		sb.append(",");
		sb.append(getPayAmount() == null ? "" : getPayAmount());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getAttachmentFile() == null ? "" : getAttachmentFile());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		String strOperateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperateEmployeeId()));
		sb.append(strOperateEmployeeId == null ? "" : strOperateEmployeeId);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		sb.append(",");
		sb.append(getBePacked() == null ? "" : getBePacked());
		sb.append(",");
		sb.append(getVoucherNo() == null ? "" : getVoucherNo());
		sb.append(",");
		sb.append(getPostingDate() == null ? "" : sdf.format(getPostingDate()));
		sb.append(",");
		String strCurrency = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_40", String.valueOf(getCurrency()));
		sb.append(strCurrency == null ? "" : strCurrency);
		sb.append(",");
		sb.append(getExchangeRate() == null ? "" : getExchangeRate());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getPaymentSequenceId() == null ? "" : getPaymentSequenceId());
		sb.append(",");
		sb.append(getBudgetManagementId() == null ? "" : getBudgetManagementId());
		sb.append(",");
		sb.append(getBudgetAttachmentId() == null ? "" : getBudgetAttachmentId());
		sb.append(",");
		sb.append(getAttachmentId() == null ? "" : getAttachmentId());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		sb.append(",");
		sb.append(getUseOfFund() == null ? "" : getUseOfFund());
		sb.append(",");
		sb.append(getRelatedToContract() == null ? "" : getRelatedToContract());
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getReceiveUnitId() == null ? "" : getReceiveUnitId());
		sb.append(",");
		sb.append(getPurchaserDepartment() == null ? "" : getPurchaserDepartment());
		sb.append(",");
		sb.append(getPurchaser() == null ? "" : getPurchaser());
		sb.append(",");
		sb.append(getPurchasingCategory() == null ? "" : getPurchasingCategory());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePayMoneyManage o) {
		return __pay_money_manage_id == null ? -1 : __pay_money_manage_id.compareTo(o.getPayMoneyManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pay_money_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		hash = 97 * hash + Objects.hashCode(this.__title_name);
		hash = 97 * hash + Objects.hashCode(this.__pay_amount);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_file);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__be_packed);
		hash = 97 * hash + Objects.hashCode(this.__voucher_no);
		hash = 97 * hash + Objects.hashCode(this.__posting_date);
		hash = 97 * hash + Objects.hashCode(this.__currency);
		hash = 97 * hash + Objects.hashCode(this.__exchange_rate);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__payment_sequence_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_management_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		hash = 97 * hash + Objects.hashCode(this.__use_of_fund);
		hash = 97 * hash + Objects.hashCode(this.__related_to_contract);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_id);
		hash = 97 * hash + Objects.hashCode(this.__purchaser_department);
		hash = 97 * hash + Objects.hashCode(this.__purchaser);
		hash = 97 * hash + Objects.hashCode(this.__purchasing_category);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePayMoneyManage o = (BasePayMoneyManage)obj;
		if(!Objects.equals(this.__pay_money_manage_id, o.getPayMoneyManageId())) return false;
		if(!Objects.equals(this.__receive_unit, o.getReceiveUnit())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		if(!Objects.equals(this.__title_name, o.getTitleName())) return false;
		if(!Objects.equals(this.__pay_amount, o.getPayAmount())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__attachment_file, o.getAttachmentFile())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__be_packed, o.getBePacked())) return false;
		if(!Objects.equals(this.__voucher_no, o.getVoucherNo())) return false;
		if(!Objects.equals(this.__posting_date, o.getPostingDate())) return false;
		if(!Objects.equals(this.__currency, o.getCurrency())) return false;
		if(!Objects.equals(this.__exchange_rate, o.getExchangeRate())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__payment_sequence_id, o.getPaymentSequenceId())) return false;
		if(!Objects.equals(this.__budget_management_id, o.getBudgetManagementId())) return false;
		if(!Objects.equals(this.__budget_attachment_id, o.getBudgetAttachmentId())) return false;
		if(!Objects.equals(this.__attachment_id, o.getAttachmentId())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		if(!Objects.equals(this.__use_of_fund, o.getUseOfFund())) return false;
		if(!Objects.equals(this.__related_to_contract, o.getRelatedToContract())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__receive_unit_id, o.getReceiveUnitId())) return false;
		if(!Objects.equals(this.__purchaser_department, o.getPurchaserDepartment())) return false;
		if(!Objects.equals(this.__purchaser, o.getPurchaser())) return false;
		if(!Objects.equals(this.__purchasing_category, o.getPurchasingCategory())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPayMoneyManageId() != null) sb.append(__wrapNumber(count++, "payMoneyManageId", getPayMoneyManageId()));
		if(getReceiveUnit() != null) sb.append(__wrapString(count++, "receiveUnit", getReceiveUnit()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		if(getTitleName() != null) sb.append(__wrapString(count++, "titleName", getTitleName()));
		if(getPayAmount() != null) sb.append(__wrapDecimal(count++, "payAmount", getPayAmount()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getAttachmentFile() != null) sb.append(__wrapString(count++, "attachmentFile", getAttachmentFile()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getBePacked() != null) sb.append(__wrapBoolean(count++, "bePacked", getBePacked()));
		if(getVoucherNo() != null) sb.append(__wrapString(count++, "voucherNo", getVoucherNo()));
		if(getPostingDate() != null) sb.append(__wrapDate(count++, "postingDate", getPostingDate()));
		if(getCurrency() != null) sb.append(__wrapNumber(count++, "currency", getCurrency()));
		if(getExchangeRate() != null) sb.append(__wrapDecimal(count++, "exchangeRate", getExchangeRate()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPaymentSequenceId() != null) sb.append(__wrapNumber(count++, "paymentSequenceId", getPaymentSequenceId()));
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(count++, "budgetManagementId", getBudgetManagementId()));
		if(getBudgetAttachmentId() != null) sb.append(__wrapNumber(count++, "budgetAttachmentId", getBudgetAttachmentId()));
		if(getAttachmentId() != null) sb.append(__wrapNumber(count++, "attachmentId", getAttachmentId()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		if(getUseOfFund() != null) sb.append(__wrapNumber(count++, "useOfFund", getUseOfFund()));
		if(getRelatedToContract() != null) sb.append(__wrapBoolean(count++, "relatedToContract", getRelatedToContract()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getReceiveUnitId() != null) sb.append(__wrapNumber(count++, "receiveUnitId", getReceiveUnitId()));
		if(getPurchaserDepartment() != null) sb.append(__wrapNumber(count++, "purchaserDepartment", getPurchaserDepartment()));
		if(getPurchaser() != null) sb.append(__wrapNumber(count++, "purchaser", getPurchaser()));
		if(getPurchasingCategory() != null) sb.append(__wrapString(count++, "purchasingCategory", getPurchasingCategory()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPayMoneyManageId() != null) res.put("payMoneyManageId", getPayMoneyManageId());
		if(getReceiveUnit() != null) res.put("receiveUnit", getReceiveUnit());
		if(getBankAccount() != null) res.put("bankAccount", getBankAccount());
		if(getBankName() != null) res.put("bankName", getBankName());
		if(getTitleName() != null) res.put("titleName", getTitleName());
		if(getPayAmount() != null) res.put("payAmount", getPayAmount());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getAttachmentFile() != null) res.put("attachmentFile", getAttachmentFile());
		if(getReason() != null) res.put("reason", getReason());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getCode() != null) res.put("code", getCode());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getIsCompleted() != null) res.put("isCompleted", getIsCompleted());
		if(getBePacked() != null) res.put("bePacked", getBePacked());
		if(getVoucherNo() != null) res.put("voucherNo", getVoucherNo());
		if(getPostingDate() != null) res.put("postingDate", getPostingDate());
		if(getCurrency() != null) res.put("currency", getCurrency());
		if(getExchangeRate() != null) res.put("exchangeRate", getExchangeRate());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getPaymentSequenceId() != null) res.put("paymentSequenceId", getPaymentSequenceId());
		if(getBudgetManagementId() != null) res.put("budgetManagementId", getBudgetManagementId());
		if(getBudgetAttachmentId() != null) res.put("budgetAttachmentId", getBudgetAttachmentId());
		if(getAttachmentId() != null) res.put("attachmentId", getAttachmentId());
		if(getAttachmentName() != null) res.put("attachmentName", getAttachmentName());
		if(getUseOfFund() != null) res.put("useOfFund", getUseOfFund());
		if(getRelatedToContract() != null) res.put("relatedToContract", getRelatedToContract());
		if(getContractAmount() != null) res.put("contractAmount", getContractAmount());
		if(getReceiveUnitId() != null) res.put("receiveUnitId", getReceiveUnitId());
		if(getPurchaserDepartment() != null) res.put("purchaserDepartment", getPurchaserDepartment());
		if(getPurchaser() != null) res.put("purchaser", getPurchaser());
		if(getPurchasingCategory() != null) res.put("purchasingCategory", getPurchasingCategory());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("payMoneyManageId")) != null) setPayMoneyManageId(__getInt(val)); 
		if((val = values.get("receiveUnit")) != null) setReceiveUnit(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("titleName")) != null) setTitleName(__getString(val));
		if((val = values.get("payAmount")) != null) setPayAmount(__getDecimal(val));  
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("attachmentFile")) != null) setAttachmentFile(__getString(val));
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("bePacked")) != null) setBePacked(__getBoolean(val));
		if((val = values.get("voucherNo")) != null) setVoucherNo(__getString(val));
		if((val = values.get("postingDate")) != null) setPostingDate(__getDate(val)); 
		if((val = values.get("currency")) != null) setCurrency(__getInt(val)); 
		if((val = values.get("exchangeRate")) != null) setExchangeRate(__getDecimal(val));  
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("paymentSequenceId")) != null) setPaymentSequenceId(__getInt(val)); 
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("budgetAttachmentId")) != null) setBudgetAttachmentId(__getInt(val)); 
		if((val = values.get("attachmentId")) != null) setAttachmentId(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("useOfFund")) != null) setUseOfFund(__getInt(val)); 
		if((val = values.get("relatedToContract")) != null) setRelatedToContract(__getBoolean(val));
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("receiveUnitId")) != null) setReceiveUnitId(__getInt(val)); 
		if((val = values.get("purchaserDepartment")) != null) setPurchaserDepartment(__getInt(val)); 
		if((val = values.get("purchaser")) != null) setPurchaser(__getInt(val)); 
		if((val = values.get("purchasingCategory")) != null) setPurchasingCategory(__getString(val));
	}

	protected java.lang.Integer  __pay_money_manage_id ;
	protected java.lang.String  __receive_unit ;
	protected java.lang.String  __bank_account ;
	protected java.lang.String  __bank_name ;
	protected java.lang.String  __title_name ;
	protected java.math.BigDecimal  __pay_amount ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __attachment_file ;
	protected java.lang.String  __reason ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Boolean  __is_completed ;
	protected java.lang.Boolean  __be_packed ;
	protected java.lang.String  __voucher_no ;
	protected java.util.Date  __posting_date ;
	protected java.lang.Integer  __currency ;
	protected java.math.BigDecimal  __exchange_rate ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __payment_sequence_id ;
	protected java.lang.Integer  __budget_management_id ;
	protected java.lang.Integer  __budget_attachment_id ;
	protected java.lang.Integer  __attachment_id ;
	protected java.lang.String  __attachment_name ;
	protected java.lang.Integer  __use_of_fund ;
	protected java.lang.Boolean  __related_to_contract ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.lang.Integer  __receive_unit_id ;
	protected java.lang.Integer  __purchaser_department ;
	protected java.lang.Integer  __purchaser ;
	protected java.lang.String  __purchasing_category ;
}
