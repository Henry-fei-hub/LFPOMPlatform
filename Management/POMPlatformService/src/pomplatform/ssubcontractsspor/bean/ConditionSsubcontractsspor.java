package pomplatform.ssubcontractsspor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSsubcontractsspor extends GenericCondition{

	public ConditionSsubcontractsspor(){
		setParameterCount(10);
	}

	public java.lang.Integer getSubContractId() {
		return this.__sub_contract_id;
	}

	public void setSubContractId( java.lang.Integer value ) {
		this.__sub_contract_id = value;
	}

	public java.lang.String getSubContractCode() {
		return this.__sub_contract_code == null ? null : (this.__sub_contract_code.indexOf("%") >= 0 ? this.__sub_contract_code : "%"+this.__sub_contract_code+"%");
	}

	public void setSubContractCode( java.lang.String value ) {
		this.__sub_contract_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getSubContractName() {
		return this.__sub_contract_name == null ? null : (this.__sub_contract_name.indexOf("%") >= 0 ? this.__sub_contract_name : "%"+this.__sub_contract_name+"%");
	}

	public void setSubContractName( java.lang.String value ) {
		this.__sub_contract_name = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code == null ? null : (this.__info_code.indexOf("%") >= 0 ? this.__info_code : "%"+this.__info_code+"%");
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSubContractId() != null) sb.append(__wrapNumber(1, "subContractId", getSubContractId()));
		if(getSubContractCode() != null) sb.append(__wrapString(1, "subContractCode", getSubContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getSubContractName() != null) sb.append(__wrapString(1, "subContractName", getSubContractName()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(1, "businessType", getBusinessType()));
		if(getProjectType() != null) sb.append(__wrapNumber(1, "projectType", getProjectType()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("subContractId")) != null) setSubContractId(__getInt(val)); 
		if((val = values.get("subContractCode")) != null) setSubContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("subContractName")) != null) setSubContractName(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.lang.Integer __sub_contract_id = null;
	private java.lang.String __sub_contract_code = null;
	private java.lang.String __project_code = null;
	private java.lang.String __sub_contract_name = null;
	private java.lang.String __info_code = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __parent_id = null;
	private java.lang.Integer __business_type = null;
	private java.lang.Integer __project_type = null;
	private java.lang.Integer __department_id = null;
}

