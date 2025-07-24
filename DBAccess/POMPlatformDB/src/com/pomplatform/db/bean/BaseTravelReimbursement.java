package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseTravelReimbursement extends GenericBase implements BaseFactory<BaseTravelReimbursement>, Comparable<BaseTravelReimbursement> 
{


	public static BaseTravelReimbursement newInstance(){
		return new BaseTravelReimbursement();
	}

	@Override
	public BaseTravelReimbursement make(){
		BaseTravelReimbursement b = new BaseTravelReimbursement();
		return b;
	}

	public final static java.lang.String CS_TRAVEL_REIMBURSEMENT_ID = "travel_reimbursement_id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_TITLE = "title" ;
	public final static java.lang.String CS_APPLICANT = "applicant" ;
	public final static java.lang.String CS_DRAFTER = "drafter" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_REIMBURSEMENT_TIME = "reimbursement_time" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_STRIKE_A_BALANCE = "strike_a_balance" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_APPLY_TIME = "apply_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_ATTACHMENT = "attachment" ;
	public final static java.lang.String CS_ATTACHMENT_NUMBER = "attachment_number" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_IS_PROJECT = "is_project" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_CURRENCY = "currency" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_BE_PACKED = "be_packed" ;
	public final static java.lang.String CS_VOUCHER_NO = "voucher_no" ;
	public final static java.lang.String CS_POSTING_DATE = "posting_date" ;
	public final static java.lang.String CS_EXCHANGE_RATE = "exchange_rate" ;
	public final static java.lang.String CS_PAYMENT_SEQUENCE_ID = "payment_sequence_id" ;
	public final static java.lang.String CS_BUDGET_MANAGEMENT_ID = "budget_management_id" ;
	public final static java.lang.String CS_BUDGET_ATTACHMENT_ID = "budget_attachment_id" ;
	public final static java.lang.String CS_WHITE_STRIP = "white_strip" ;
	public final static java.lang.String CS_ATTACHMENT_ID = "attachment_id" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static java.lang.String CS_RELATED_TO_CONTRACT = "related_to_contract" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_RECEIVE_UNIT_ID = "receive_unit_id" ;
	public final static java.lang.String CS_PURCHASER_DEPARTMENT = "purchaser_department" ;
	public final static java.lang.String CS_PURCHASER = "purchaser" ;
	public final static java.lang.String CS_PURCHASING_CATEGORY = "purchasing_category" ;

	public final static java.lang.String ALL_CAPTIONS = "差旅报销编码,报销编号,流程编码,主题,申请人,起草人,报销部门,报销时间,出差开始日期,出差结束日期,报销金额,是否冲账,报销事由,申请时间,完成时间,附件,附件数量,状态,归属公司,是否是项目上的报销，默认false,删除状态  0未删除    1已删除,货币种类  0人民币   1港币   2美元,报销单是否完成,是否被打包,凭证号,入账日期,汇率,付款序列编码,预算管理编码,预算附件编码,白条金额,附件编码,附件名称,与合同或协议有关,合同金额,供应商,采购人归属部门,采购人,采购类别";

	public java.lang.Integer getTravelReimbursementId() {
		return this.__travel_reimbursement_id;
	}

	public void setTravelReimbursementId( java.lang.Integer value ) {
		this.__travel_reimbursement_id = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.String getTitle() {
		return this.__title;
	}

	public void setTitle( java.lang.String value ) {
		this.__title = value;
	}

	public java.lang.Integer getApplicant() {
		return this.__applicant;
	}

	public void setApplicant( java.lang.Integer value ) {
		this.__applicant = value;
	}

	public java.lang.Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( java.lang.Integer value ) {
		this.__drafter = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.util.Date getReimbursementTime() {
		return this.__reimbursement_time;
	}

	public void setReimbursementTime( java.util.Date value ) {
		this.__reimbursement_time = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Boolean getStrikeABalance() {
		return this.__strike_a_balance;
	}

	public void setStrikeABalance( java.lang.Boolean value ) {
		this.__strike_a_balance = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getApplyTime() {
		return this.__apply_time;
	}

	public void setApplyTime( java.util.Date value ) {
		this.__apply_time = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.String getAttachment() {
		return this.__attachment;
	}

	public void setAttachment( java.lang.String value ) {
		this.__attachment = value;
	}

	public java.lang.Integer getAttachmentNumber() {
		return this.__attachment_number;
	}

	public void setAttachmentNumber( java.lang.Integer value ) {
		this.__attachment_number = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Boolean getIsProject() {
		return this.__is_project;
	}

	public void setIsProject( java.lang.Boolean value ) {
		this.__is_project = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getCurrency() {
		return this.__currency;
	}

	public void setCurrency( java.lang.Integer value ) {
		this.__currency = value;
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

	public java.math.BigDecimal getExchangeRate() {
		return this.__exchange_rate;
	}

	public void setExchangeRate( java.math.BigDecimal value ) {
		this.__exchange_rate = value;
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

	public java.math.BigDecimal getWhiteStrip() {
		return this.__white_strip;
	}

	public void setWhiteStrip( java.math.BigDecimal value ) {
		this.__white_strip = value;
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

	public void cloneCopy(BaseTravelReimbursement __bean){
		__bean.setTravelReimbursementId(getTravelReimbursementId());
		__bean.setCode(getCode());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setTitle(getTitle());
		__bean.setApplicant(getApplicant());
		__bean.setDrafter(getDrafter());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setReimbursementTime(getReimbursementTime());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setAmount(getAmount());
		__bean.setStrikeABalance(getStrikeABalance());
		__bean.setRemark(getRemark());
		__bean.setApplyTime(getApplyTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setAttachment(getAttachment());
		__bean.setAttachmentNumber(getAttachmentNumber());
		__bean.setStatus(getStatus());
		__bean.setCompanyId(getCompanyId());
		__bean.setIsProject(getIsProject());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setCurrency(getCurrency());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setBePacked(getBePacked());
		__bean.setVoucherNo(getVoucherNo());
		__bean.setPostingDate(getPostingDate());
		__bean.setExchangeRate(getExchangeRate());
		__bean.setPaymentSequenceId(getPaymentSequenceId());
		__bean.setBudgetManagementId(getBudgetManagementId());
		__bean.setBudgetAttachmentId(getBudgetAttachmentId());
		__bean.setWhiteStrip(getWhiteStrip());
		__bean.setAttachmentId(getAttachmentId());
		__bean.setAttachmentName(getAttachmentName());
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
		sb.append(getTravelReimbursementId() == null ? "" : getTravelReimbursementId());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getTitle() == null ? "" : getTitle());
		sb.append(",");
		String strApplicant = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getApplicant()));
		sb.append(strApplicant == null ? "" : strApplicant);
		sb.append(",");
		String strDrafter = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getDrafter()));
		sb.append(strDrafter == null ? "" : strDrafter);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getReimbursementTime() == null ? "" : sdf.format(getReimbursementTime()));
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getStrikeABalance() == null ? "" : getStrikeABalance());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getApplyTime() == null ? "" : sdf.format(getApplyTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getAttachment() == null ? "" : getAttachment());
		sb.append(",");
		sb.append(getAttachmentNumber() == null ? "" : getAttachmentNumber());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_161", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getIsProject() == null ? "" : getIsProject());
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		String strCurrency = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_40", String.valueOf(getCurrency()));
		sb.append(strCurrency == null ? "" : strCurrency);
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		sb.append(",");
		sb.append(getBePacked() == null ? "" : getBePacked());
		sb.append(",");
		sb.append(getVoucherNo() == null ? "" : getVoucherNo());
		sb.append(",");
		sb.append(getPostingDate() == null ? "" : sdf.format(getPostingDate()));
		sb.append(",");
		sb.append(getExchangeRate() == null ? "" : getExchangeRate());
		sb.append(",");
		sb.append(getPaymentSequenceId() == null ? "" : getPaymentSequenceId());
		sb.append(",");
		sb.append(getBudgetManagementId() == null ? "" : getBudgetManagementId());
		sb.append(",");
		sb.append(getBudgetAttachmentId() == null ? "" : getBudgetAttachmentId());
		sb.append(",");
		sb.append(getWhiteStrip() == null ? "" : getWhiteStrip());
		sb.append(",");
		sb.append(getAttachmentId() == null ? "" : getAttachmentId());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
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
	public int compareTo(BaseTravelReimbursement o) {
		return __travel_reimbursement_id == null ? -1 : __travel_reimbursement_id.compareTo(o.getTravelReimbursementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__travel_reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__title);
		hash = 97 * hash + Objects.hashCode(this.__applicant);
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_time);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__strike_a_balance);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__apply_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__attachment);
		hash = 97 * hash + Objects.hashCode(this.__attachment_number);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__is_project);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__currency);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__be_packed);
		hash = 97 * hash + Objects.hashCode(this.__voucher_no);
		hash = 97 * hash + Objects.hashCode(this.__posting_date);
		hash = 97 * hash + Objects.hashCode(this.__exchange_rate);
		hash = 97 * hash + Objects.hashCode(this.__payment_sequence_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_management_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__white_strip);
		hash = 97 * hash + Objects.hashCode(this.__attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
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
		final BaseTravelReimbursement o = (BaseTravelReimbursement)obj;
		if(!Objects.equals(this.__travel_reimbursement_id, o.getTravelReimbursementId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__title, o.getTitle())) return false;
		if(!Objects.equals(this.__applicant, o.getApplicant())) return false;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__reimbursement_time, o.getReimbursementTime())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__strike_a_balance, o.getStrikeABalance())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__apply_time, o.getApplyTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__attachment, o.getAttachment())) return false;
		if(!Objects.equals(this.__attachment_number, o.getAttachmentNumber())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__is_project, o.getIsProject())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__currency, o.getCurrency())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__be_packed, o.getBePacked())) return false;
		if(!Objects.equals(this.__voucher_no, o.getVoucherNo())) return false;
		if(!Objects.equals(this.__posting_date, o.getPostingDate())) return false;
		if(!Objects.equals(this.__exchange_rate, o.getExchangeRate())) return false;
		if(!Objects.equals(this.__payment_sequence_id, o.getPaymentSequenceId())) return false;
		if(!Objects.equals(this.__budget_management_id, o.getBudgetManagementId())) return false;
		if(!Objects.equals(this.__budget_attachment_id, o.getBudgetAttachmentId())) return false;
		if(!Objects.equals(this.__white_strip, o.getWhiteStrip())) return false;
		if(!Objects.equals(this.__attachment_id, o.getAttachmentId())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
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
		if(getTravelReimbursementId() != null) sb.append(__wrapNumber(count++, "travelReimbursementId", getTravelReimbursementId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getTitle() != null) sb.append(__wrapString(count++, "title", getTitle()));
		if(getApplicant() != null) sb.append(__wrapNumber(count++, "applicant", getApplicant()));
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getReimbursementTime() != null) sb.append(__wrapDate(count++, "reimbursementTime", getReimbursementTime()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getStrikeABalance() != null) sb.append(__wrapBoolean(count++, "strikeABalance", getStrikeABalance()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getApplyTime() != null) sb.append(__wrapDate(count++, "applyTime", getApplyTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getAttachment() != null) sb.append(__wrapString(count++, "attachment", getAttachment()));
		if(getAttachmentNumber() != null) sb.append(__wrapNumber(count++, "attachmentNumber", getAttachmentNumber()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getIsProject() != null) sb.append(__wrapBoolean(count++, "isProject", getIsProject()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getCurrency() != null) sb.append(__wrapNumber(count++, "currency", getCurrency()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getBePacked() != null) sb.append(__wrapBoolean(count++, "bePacked", getBePacked()));
		if(getVoucherNo() != null) sb.append(__wrapString(count++, "voucherNo", getVoucherNo()));
		if(getPostingDate() != null) sb.append(__wrapDate(count++, "postingDate", getPostingDate()));
		if(getExchangeRate() != null) sb.append(__wrapDecimal(count++, "exchangeRate", getExchangeRate()));
		if(getPaymentSequenceId() != null) sb.append(__wrapNumber(count++, "paymentSequenceId", getPaymentSequenceId()));
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(count++, "budgetManagementId", getBudgetManagementId()));
		if(getBudgetAttachmentId() != null) sb.append(__wrapNumber(count++, "budgetAttachmentId", getBudgetAttachmentId()));
		if(getWhiteStrip() != null) sb.append(__wrapDecimal(count++, "whiteStrip", getWhiteStrip()));
		if(getAttachmentId() != null) sb.append(__wrapNumber(count++, "attachmentId", getAttachmentId()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
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
		if(getTravelReimbursementId() != null) res.put("travelReimbursementId", getTravelReimbursementId());
		if(getCode() != null) res.put("code", getCode());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getTitle() != null) res.put("title", getTitle());
		if(getApplicant() != null) res.put("applicant", getApplicant());
		if(getDrafter() != null) res.put("drafter", getDrafter());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getReimbursementTime() != null) res.put("reimbursementTime", getReimbursementTime());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getStrikeABalance() != null) res.put("strikeABalance", getStrikeABalance());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getApplyTime() != null) res.put("applyTime", getApplyTime());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		if(getAttachment() != null) res.put("attachment", getAttachment());
		if(getAttachmentNumber() != null) res.put("attachmentNumber", getAttachmentNumber());
		if(getStatus() != null) res.put("status", getStatus());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getIsProject() != null) res.put("isProject", getIsProject());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getCurrency() != null) res.put("currency", getCurrency());
		if(getIsCompleted() != null) res.put("isCompleted", getIsCompleted());
		if(getBePacked() != null) res.put("bePacked", getBePacked());
		if(getVoucherNo() != null) res.put("voucherNo", getVoucherNo());
		if(getPostingDate() != null) res.put("postingDate", getPostingDate());
		if(getExchangeRate() != null) res.put("exchangeRate", getExchangeRate());
		if(getPaymentSequenceId() != null) res.put("paymentSequenceId", getPaymentSequenceId());
		if(getBudgetManagementId() != null) res.put("budgetManagementId", getBudgetManagementId());
		if(getBudgetAttachmentId() != null) res.put("budgetAttachmentId", getBudgetAttachmentId());
		if(getWhiteStrip() != null) res.put("whiteStrip", getWhiteStrip());
		if(getAttachmentId() != null) res.put("attachmentId", getAttachmentId());
		if(getAttachmentName() != null) res.put("attachmentName", getAttachmentName());
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
		if((val = values.get("travelReimbursementId")) != null) setTravelReimbursementId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("title")) != null) setTitle(__getString(val));
		if((val = values.get("applicant")) != null) setApplicant(__getInt(val)); 
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("reimbursementTime")) != null) setReimbursementTime(__getDate(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("strikeABalance")) != null) setStrikeABalance(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("applyTime")) != null) setApplyTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("attachment")) != null) setAttachment(__getString(val));
		if((val = values.get("attachmentNumber")) != null) setAttachmentNumber(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("isProject")) != null) setIsProject(__getBoolean(val));
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("currency")) != null) setCurrency(__getInt(val)); 
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("bePacked")) != null) setBePacked(__getBoolean(val));
		if((val = values.get("voucherNo")) != null) setVoucherNo(__getString(val));
		if((val = values.get("postingDate")) != null) setPostingDate(__getDate(val)); 
		if((val = values.get("exchangeRate")) != null) setExchangeRate(__getDecimal(val));  
		if((val = values.get("paymentSequenceId")) != null) setPaymentSequenceId(__getInt(val)); 
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("budgetAttachmentId")) != null) setBudgetAttachmentId(__getInt(val)); 
		if((val = values.get("whiteStrip")) != null) setWhiteStrip(__getDecimal(val));  
		if((val = values.get("attachmentId")) != null) setAttachmentId(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("relatedToContract")) != null) setRelatedToContract(__getBoolean(val));
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("receiveUnitId")) != null) setReceiveUnitId(__getInt(val)); 
		if((val = values.get("purchaserDepartment")) != null) setPurchaserDepartment(__getInt(val)); 
		if((val = values.get("purchaser")) != null) setPurchaser(__getInt(val)); 
		if((val = values.get("purchasingCategory")) != null) setPurchasingCategory(__getString(val));
	}

	protected java.lang.Integer  __travel_reimbursement_id ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.String  __title ;
	protected java.lang.Integer  __applicant ;
	protected java.lang.Integer  __drafter ;
	protected java.lang.Integer  __department_id ;
	protected java.util.Date  __reimbursement_time ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Boolean  __strike_a_balance ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __apply_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.String  __attachment ;
	protected java.lang.Integer  __attachment_number ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Boolean  __is_project ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __currency ;
	protected java.lang.Boolean  __is_completed ;
	protected java.lang.Boolean  __be_packed ;
	protected java.lang.String  __voucher_no ;
	protected java.util.Date  __posting_date ;
	protected java.math.BigDecimal  __exchange_rate ;
	protected java.lang.Integer  __payment_sequence_id ;
	protected java.lang.Integer  __budget_management_id ;
	protected java.lang.Integer  __budget_attachment_id ;
	protected java.math.BigDecimal  __white_strip ;
	protected java.lang.Integer  __attachment_id ;
	protected java.lang.String  __attachment_name ;
	protected java.lang.Boolean  __related_to_contract ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.lang.Integer  __receive_unit_id ;
	protected java.lang.Integer  __purchaser_department ;
	protected java.lang.Integer  __purchaser ;
	protected java.lang.String  __purchasing_category ;
}
