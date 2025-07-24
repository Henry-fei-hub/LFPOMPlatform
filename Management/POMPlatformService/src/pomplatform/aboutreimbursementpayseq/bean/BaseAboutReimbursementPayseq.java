package pomplatform.aboutreimbursementpayseq.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAboutReimbursementPayseq extends GenericBase implements BaseFactory<BaseAboutReimbursementPayseq>, Comparable<BaseAboutReimbursementPayseq> 
{


	public static BaseAboutReimbursementPayseq newInstance(){
		return new BaseAboutReimbursementPayseq();
	}

	@Override
	public BaseAboutReimbursementPayseq make(){
		BaseAboutReimbursementPayseq b = new BaseAboutReimbursementPayseq();
		return b;
	}

	public final static java.lang.String CS_BUDGET_ATTACHMENT_ID = "budget_attachment_id" ;
	public final static java.lang.String CS_BUDGET_MANAGEMENT_ID = "budget_management_id" ;
	public final static java.lang.String CS_FILE_ID = "file_id" ;
	public final static java.lang.String CS_ATTACHMENT_NAME = "attachment_name" ;
	public final static java.lang.String CS_UPLOAD_EMPLOYEE_ID = "upload_employee_id" ;
	public final static java.lang.String CS_UPLOAD_TIME = "upload_time" ;
	public final static java.lang.String CS_UPLOAD_REMARK = "upload_remark" ;
	public final static java.lang.String CS_PAY_AMOUNT = "pay_amount" ;
	public final static java.lang.String CS_REIMBURSEMENT_AMOUNT = "reimbursement_amount" ;
	public final static java.lang.String CS_REVERSE_AMOUNT = "reverse_amount" ;
	public final static java.lang.String CS_RETURN_AMOUNT = "return_amount" ;
	public final static java.lang.String CS_BUDGET_CONTRACT_AMOUNT = "budget_contract_amount" ;
	public final static java.lang.String CS_BUDGET_CONTRACT_AMOUNT_USE = "budget_contract_amount_use" ;
	public final static java.lang.String CS_BUDGET_CONTRACT_AMOUNT_REST = "budget_contract_amount_rest" ;
	public final static java.lang.String CS_RECEIVE_UNIT_MANAGE_ID = "receive_unit_manage_id" ;
	public final static java.lang.String CS_FILE_URL = "file_url" ;
	public final static java.lang.String CS_BDD_TYPE = "bdd_type" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PAY_PERCENT = "pay_percent" ;

	public final static java.lang.String ALL_CAPTIONS = "主键id,预算管理id,附件编码,附件名称,上传人员,上传时间,附件备注,付款序列金额,报销金额,冲账金额,还款金额,合同金额,合同已付款金额,剩余合同金额,供应商,文件路径,预算类别,项目id,付款比例";

	public java.lang.Integer getBudgetAttachmentId() {
		return this.__budget_attachment_id;
	}

	public void setBudgetAttachmentId( java.lang.Integer value ) {
		this.__budget_attachment_id = value;
	}

	public java.lang.Integer getBudgetManagementId() {
		return this.__budget_management_id;
	}

	public void setBudgetManagementId( java.lang.Integer value ) {
		this.__budget_management_id = value;
	}

	public java.lang.Integer getFileId() {
		return this.__file_id;
	}

	public void setFileId( java.lang.Integer value ) {
		this.__file_id = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name;
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.Integer getUploadEmployeeId() {
		return this.__upload_employee_id;
	}

	public void setUploadEmployeeId( java.lang.Integer value ) {
		this.__upload_employee_id = value;
	}

	public java.util.Date getUploadTime() {
		return this.__upload_time;
	}

	public void setUploadTime( java.util.Date value ) {
		this.__upload_time = value;
	}

	public java.lang.String getUploadRemark() {
		return this.__upload_remark;
	}

	public void setUploadRemark( java.lang.String value ) {
		this.__upload_remark = value;
	}

	public java.math.BigDecimal getPayAmount() {
		return this.__pay_amount;
	}

	public void setPayAmount( java.math.BigDecimal value ) {
		this.__pay_amount = value;
	}

	public java.math.BigDecimal getReimbursementAmount() {
		return this.__reimbursement_amount;
	}

	public void setReimbursementAmount( java.math.BigDecimal value ) {
		this.__reimbursement_amount = value;
	}

	public java.math.BigDecimal getReverseAmount() {
		return this.__reverse_amount;
	}

	public void setReverseAmount( java.math.BigDecimal value ) {
		this.__reverse_amount = value;
	}

	public java.math.BigDecimal getReturnAmount() {
		return this.__return_amount;
	}

	public void setReturnAmount( java.math.BigDecimal value ) {
		this.__return_amount = value;
	}

	public java.math.BigDecimal getBudgetContractAmount() {
		return this.__budget_contract_amount;
	}

	public void setBudgetContractAmount( java.math.BigDecimal value ) {
		this.__budget_contract_amount = value;
	}

	public java.math.BigDecimal getBudgetContractAmountUse() {
		return this.__budget_contract_amount_use;
	}

	public void setBudgetContractAmountUse( java.math.BigDecimal value ) {
		this.__budget_contract_amount_use = value;
	}

	public java.math.BigDecimal getBudgetContractAmountRest() {
		return this.__budget_contract_amount_rest;
	}

	public void setBudgetContractAmountRest( java.math.BigDecimal value ) {
		this.__budget_contract_amount_rest = value;
	}

	public java.lang.Integer getReceiveUnitManageId() {
		return this.__receive_unit_manage_id;
	}

	public void setReceiveUnitManageId( java.lang.Integer value ) {
		this.__receive_unit_manage_id = value;
	}

	public java.lang.String getFileUrl() {
		return this.__file_url;
	}

	public void setFileUrl( java.lang.String value ) {
		this.__file_url = value;
	}

	public java.lang.String getBddType() {
		return this.__bdd_type;
	}

	public void setBddType( java.lang.String value ) {
		this.__bdd_type = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getPayPercent() {
		return this.__pay_percent;
	}

	public void setPayPercent( java.lang.String value ) {
		this.__pay_percent = value;
	}

	public void cloneCopy(BaseAboutReimbursementPayseq __bean){
		__bean.setBudgetAttachmentId(getBudgetAttachmentId());
		__bean.setBudgetManagementId(getBudgetManagementId());
		__bean.setFileId(getFileId());
		__bean.setAttachmentName(getAttachmentName());
		__bean.setUploadEmployeeId(getUploadEmployeeId());
		__bean.setUploadTime(getUploadTime());
		__bean.setUploadRemark(getUploadRemark());
		__bean.setPayAmount(getPayAmount());
		__bean.setReimbursementAmount(getReimbursementAmount());
		__bean.setReverseAmount(getReverseAmount());
		__bean.setReturnAmount(getReturnAmount());
		__bean.setBudgetContractAmount(getBudgetContractAmount());
		__bean.setBudgetContractAmountUse(getBudgetContractAmountUse());
		__bean.setBudgetContractAmountRest(getBudgetContractAmountRest());
		__bean.setReceiveUnitManageId(getReceiveUnitManageId());
		__bean.setFileUrl(getFileUrl());
		__bean.setBddType(getBddType());
		__bean.setProjectId(getProjectId());
		__bean.setPayPercent(getPayPercent());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBudgetAttachmentId() == null ? "" : getBudgetAttachmentId());
		sb.append(",");
		sb.append(getBudgetManagementId() == null ? "" : getBudgetManagementId());
		sb.append(",");
		sb.append(getFileId() == null ? "" : getFileId());
		sb.append(",");
		sb.append(getAttachmentName() == null ? "" : getAttachmentName());
		sb.append(",");
		sb.append(getUploadEmployeeId() == null ? "" : getUploadEmployeeId());
		sb.append(",");
		sb.append(getUploadTime() == null ? "" : sdf.format(getUploadTime()));
		sb.append(",");
		sb.append(getUploadRemark() == null ? "" : getUploadRemark());
		sb.append(",");
		sb.append(getPayAmount() == null ? "" : getPayAmount());
		sb.append(",");
		sb.append(getReimbursementAmount() == null ? "" : getReimbursementAmount());
		sb.append(",");
		sb.append(getReverseAmount() == null ? "" : getReverseAmount());
		sb.append(",");
		sb.append(getReturnAmount() == null ? "" : getReturnAmount());
		sb.append(",");
		sb.append(getBudgetContractAmount() == null ? "" : getBudgetContractAmount());
		sb.append(",");
		sb.append(getBudgetContractAmountUse() == null ? "" : getBudgetContractAmountUse());
		sb.append(",");
		sb.append(getBudgetContractAmountRest() == null ? "" : getBudgetContractAmountRest());
		sb.append(",");
		sb.append(getReceiveUnitManageId() == null ? "" : getReceiveUnitManageId());
		sb.append(",");
		sb.append(getFileUrl() == null ? "" : getFileUrl());
		sb.append(",");
		sb.append(getBddType() == null ? "" : getBddType());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getPayPercent() == null ? "" : getPayPercent());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAboutReimbursementPayseq o) {
		return __budget_attachment_id == null ? -1 : __budget_attachment_id.compareTo(o.getBudgetAttachmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__budget_attachment_id);
		hash = 97 * hash + Objects.hashCode(this.__budget_management_id);
		hash = 97 * hash + Objects.hashCode(this.__file_id);
		hash = 97 * hash + Objects.hashCode(this.__attachment_name);
		hash = 97 * hash + Objects.hashCode(this.__upload_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__upload_time);
		hash = 97 * hash + Objects.hashCode(this.__upload_remark);
		hash = 97 * hash + Objects.hashCode(this.__pay_amount);
		hash = 97 * hash + Objects.hashCode(this.__reimbursement_amount);
		hash = 97 * hash + Objects.hashCode(this.__reverse_amount);
		hash = 97 * hash + Objects.hashCode(this.__return_amount);
		hash = 97 * hash + Objects.hashCode(this.__budget_contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__budget_contract_amount_use);
		hash = 97 * hash + Objects.hashCode(this.__budget_contract_amount_rest);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__file_url);
		hash = 97 * hash + Objects.hashCode(this.__bdd_type);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__pay_percent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAboutReimbursementPayseq o = (BaseAboutReimbursementPayseq)obj;
		if(!Objects.equals(this.__budget_attachment_id, o.getBudgetAttachmentId())) return false;
		if(!Objects.equals(this.__budget_management_id, o.getBudgetManagementId())) return false;
		if(!Objects.equals(this.__file_id, o.getFileId())) return false;
		if(!Objects.equals(this.__attachment_name, o.getAttachmentName())) return false;
		if(!Objects.equals(this.__upload_employee_id, o.getUploadEmployeeId())) return false;
		if(!Objects.equals(this.__upload_time, o.getUploadTime())) return false;
		if(!Objects.equals(this.__upload_remark, o.getUploadRemark())) return false;
		if(!Objects.equals(this.__pay_amount, o.getPayAmount())) return false;
		if(!Objects.equals(this.__reimbursement_amount, o.getReimbursementAmount())) return false;
		if(!Objects.equals(this.__reverse_amount, o.getReverseAmount())) return false;
		if(!Objects.equals(this.__return_amount, o.getReturnAmount())) return false;
		if(!Objects.equals(this.__budget_contract_amount, o.getBudgetContractAmount())) return false;
		if(!Objects.equals(this.__budget_contract_amount_use, o.getBudgetContractAmountUse())) return false;
		if(!Objects.equals(this.__budget_contract_amount_rest, o.getBudgetContractAmountRest())) return false;
		if(!Objects.equals(this.__receive_unit_manage_id, o.getReceiveUnitManageId())) return false;
		if(!Objects.equals(this.__file_url, o.getFileUrl())) return false;
		if(!Objects.equals(this.__bdd_type, o.getBddType())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__pay_percent, o.getPayPercent())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBudgetAttachmentId() != null) sb.append(__wrapNumber(count++, "budgetAttachmentId", getBudgetAttachmentId()));
		if(getBudgetManagementId() != null) sb.append(__wrapNumber(count++, "budgetManagementId", getBudgetManagementId()));
		if(getFileId() != null) sb.append(__wrapNumber(count++, "fileId", getFileId()));
		if(getAttachmentName() != null) sb.append(__wrapString(count++, "attachmentName", getAttachmentName()));
		if(getUploadEmployeeId() != null) sb.append(__wrapNumber(count++, "uploadEmployeeId", getUploadEmployeeId()));
		if(getUploadTime() != null) sb.append(__wrapDate(count++, "uploadTime", getUploadTime()));
		if(getUploadRemark() != null) sb.append(__wrapString(count++, "uploadRemark", getUploadRemark()));
		if(getPayAmount() != null) sb.append(__wrapDecimal(count++, "payAmount", getPayAmount()));
		if(getReimbursementAmount() != null) sb.append(__wrapDecimal(count++, "reimbursementAmount", getReimbursementAmount()));
		if(getReverseAmount() != null) sb.append(__wrapDecimal(count++, "reverseAmount", getReverseAmount()));
		if(getReturnAmount() != null) sb.append(__wrapDecimal(count++, "returnAmount", getReturnAmount()));
		if(getBudgetContractAmount() != null) sb.append(__wrapDecimal(count++, "budgetContractAmount", getBudgetContractAmount()));
		if(getBudgetContractAmountUse() != null) sb.append(__wrapDecimal(count++, "budgetContractAmountUse", getBudgetContractAmountUse()));
		if(getBudgetContractAmountRest() != null) sb.append(__wrapDecimal(count++, "budgetContractAmountRest", getBudgetContractAmountRest()));
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(count++, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getFileUrl() != null) sb.append(__wrapString(count++, "fileUrl", getFileUrl()));
		if(getBddType() != null) sb.append(__wrapString(count++, "bddType", getBddType()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPayPercent() != null) sb.append(__wrapString(count++, "payPercent", getPayPercent()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("budgetAttachmentId")) != null) setBudgetAttachmentId(__getInt(val)); 
		if((val = values.get("budgetManagementId")) != null) setBudgetManagementId(__getInt(val)); 
		if((val = values.get("fileId")) != null) setFileId(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("uploadEmployeeId")) != null) setUploadEmployeeId(__getInt(val)); 
		if((val = values.get("uploadTime")) != null) setUploadTime(__getDate(val)); 
		if((val = values.get("uploadRemark")) != null) setUploadRemark(__getString(val));
		if((val = values.get("payAmount")) != null) setPayAmount(__getDecimal(val));  
		if((val = values.get("reimbursementAmount")) != null) setReimbursementAmount(__getDecimal(val));  
		if((val = values.get("reverseAmount")) != null) setReverseAmount(__getDecimal(val));  
		if((val = values.get("returnAmount")) != null) setReturnAmount(__getDecimal(val));  
		if((val = values.get("budgetContractAmount")) != null) setBudgetContractAmount(__getDecimal(val));  
		if((val = values.get("budgetContractAmountUse")) != null) setBudgetContractAmountUse(__getDecimal(val));  
		if((val = values.get("budgetContractAmountRest")) != null) setBudgetContractAmountRest(__getDecimal(val));  
		if((val = values.get("receiveUnitManageId")) != null) setReceiveUnitManageId(__getInt(val)); 
		if((val = values.get("fileUrl")) != null) setFileUrl(__getString(val));
		if((val = values.get("bddType")) != null) setBddType(__getString(val));
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("payPercent")) != null) setPayPercent(__getString(val));
	}

	protected java.lang.Integer  __budget_attachment_id ;
	protected java.lang.Integer  __budget_management_id ;
	protected java.lang.Integer  __file_id ;
	protected java.lang.String  __attachment_name ;
	protected java.lang.Integer  __upload_employee_id ;
	protected java.util.Date  __upload_time ;
	protected java.lang.String  __upload_remark ;
	protected java.math.BigDecimal  __pay_amount ;
	protected java.math.BigDecimal  __reimbursement_amount ;
	protected java.math.BigDecimal  __reverse_amount ;
	protected java.math.BigDecimal  __return_amount ;
	protected java.math.BigDecimal  __budget_contract_amount ;
	protected java.math.BigDecimal  __budget_contract_amount_use ;
	protected java.math.BigDecimal  __budget_contract_amount_rest ;
	protected java.lang.Integer  __receive_unit_manage_id ;
	protected java.lang.String  __file_url ;
	protected java.lang.String  __bdd_type ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __pay_percent ;
}
