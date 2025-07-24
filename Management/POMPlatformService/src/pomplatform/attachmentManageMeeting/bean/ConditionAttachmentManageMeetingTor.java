package pomplatform.attachmentManageMeeting.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAttachmentManageMeetingTor extends GenericCondition{

	public ConditionAttachmentManageMeetingTor(){
		setParameterCount(11);
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getAttachmentName() {
		return this.__attachment_name == null ? null : (this.__attachment_name.indexOf("%") >= 0 ? this.__attachment_name : "%"+this.__attachment_name+"%");
	}

	public void setAttachmentName( java.lang.String value ) {
		this.__attachment_name = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getMettingStatus() {
		return this.__metting_status;
	}

	public void setMettingStatus( java.lang.Integer value ) {
		this.__metting_status = value;
	}

	public java.lang.Integer getOperatorStatus() {
		return this.__operator_status;
	}

	public void setOperatorStatus( java.lang.Integer value ) {
		this.__operator_status = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getWorkNum() {
		return this.__work_num;
	}

	public void setWorkNum( java.lang.Integer value ) {
		this.__work_num = value;
	}

	public java.lang.Integer getAttachmentManageId() {
		return this.__attachment_manage_id;
	}

	public void setAttachmentManageId( java.lang.Integer value ) {
		this.__attachment_manage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectManageId() != null) sb.append(__wrapNumber(1, "projectManageId", getProjectManageId()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getAttachmentName() != null) sb.append(__wrapString(1, "attachmentName", getAttachmentName()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getMettingStatus() != null) sb.append(__wrapNumber(1, "mettingStatus", getMettingStatus()));
		if(getOperatorStatus() != null) sb.append(__wrapNumber(1, "operatorStatus", getOperatorStatus()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getWorkNum() != null) sb.append(__wrapNumber(1, "workNum", getWorkNum()));
		if(getAttachmentManageId() != null) sb.append(__wrapNumber(1, "attachmentManageId", getAttachmentManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("attachmentName")) != null) setAttachmentName(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("mettingStatus")) != null) setMettingStatus(__getInt(val)); 
		if((val = values.get("operatorStatus")) != null) setOperatorStatus(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("workNum")) != null) setWorkNum(__getInt(val)); 
		if((val = values.get("attachmentManageId")) != null) setAttachmentManageId(__getInt(val)); 
	}

	private java.lang.Integer __project_manage_id = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.String __attachment_name = null;
	private java.lang.String __contract_name = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __metting_status = null;
	private java.lang.Integer __operator_status = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __work_num = null;
	private java.lang.Integer __attachment_manage_id = null;
}

