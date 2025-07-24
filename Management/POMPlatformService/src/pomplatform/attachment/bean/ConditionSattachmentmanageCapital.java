package pomplatform.attachment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSattachmentmanageCapital extends GenericCondition{

	public ConditionSattachmentmanageCapital(){
		setParameterCount(13);
	}

	public java.lang.String getAttachmentCode() {
		return this.__attachment_code == null ? null : (this.__attachment_code.indexOf("%") >= 0 ? this.__attachment_code : "%"+this.__attachment_code+"%");
	}

	public void setAttachmentCode( java.lang.String value ) {
		this.__attachment_code = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name == null ? null : (this.__attachment_name.indexOf("%") >= 0 ? this.__attachment_name : "%"+this.__attachment_name+"%");
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.String getAttachmentAddress() {
		return this.__attachment_address == null ? null : (this.__attachment_address.indexOf("%") >= 0 ? this.__attachment_address : "%"+this.__attachment_address+"%");
	}

	public void setAttachmentAddress( java.lang.String value ) {
		this.__attachment_address = value;
	}

	public java.lang.String getPerfessionRemark() {
		return this.__perfession_remark == null ? null : (this.__perfession_remark.indexOf("%") >= 0 ? this.__perfession_remark : "%"+this.__perfession_remark+"%");
	}

	public void setPerfessionRemark( java.lang.String value ) {
		this.__perfession_remark = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getPaymentSure() {
		return this.__payment_sure;
	}

	public void setPaymentSure( java.lang.Boolean value ) {
		this.__payment_sure = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getAttachmentManageId() {
		return this.__attachment_manage_id;
	}

	public void setAttachmentManageId( java.lang.Integer value ) {
		this.__attachment_manage_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getSuperProjectManageId() {
		return this.__super_project_manage_id;
	}

	public void setSuperProjectManageId( java.lang.Integer value ) {
		this.__super_project_manage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAttachmentCode() != null) sb.append(__wrapString(1, "attachmentCode", getAttachmentCode()));
		if(getAttachmentName() != null) sb.append(__wrapString(1, "attachmentName", getAttachmentName()));
		if(getAttachmentAddress() != null) sb.append(__wrapString(1, "attachmentAddress", getAttachmentAddress()));
		if(getPerfessionRemark() != null) sb.append(__wrapString(1, "perfessionRemark", getPerfessionRemark()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getPaymentSure() != null) sb.append(__wrapBoolean(1, "paymentSure", getPaymentSure()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(1, "deleteFlag", getDeleteFlag()));
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(1, "attachmentManageId", getAttachmentManageId()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(1, "projectManageId", getProjectManageId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getSuperProjectManageId() != null) sb.append(__wrapNumber(1, "superProjectManageId", getSuperProjectManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("attachmentCode")) != null) setAttachmentCode(__getString(val));
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("attachmentAddress")) != null) setAttachmentAddress(__getString(val));
		if((val = values.get("perfessionRemark")) != null) setPerfessionRemark(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("paymentSure")) != null) setPaymentSure(__getBoolean(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("superProjectManageId")) != null) setSuperProjectManageId(__getInt(val)); 
	}

	private java.lang.String __attachment_code = null;
	private java.lang.String __attachment_name = null;
	private java.lang.String __attachment_address = null;
	private java.lang.String __perfession_remark = null;
	private java.lang.String __remark = null;
	private java.lang.Boolean __payment_sure = null;
	private java.lang.Integer __operate_employee_id = null;
	private java.lang.Integer __delete_flag = null;
	private java.lang.Integer __attachment_manage_id = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __project_manage_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __super_project_manage_id = null;
}

