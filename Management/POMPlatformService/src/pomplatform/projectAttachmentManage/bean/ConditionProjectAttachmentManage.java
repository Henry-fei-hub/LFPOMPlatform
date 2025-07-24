package pomplatform.projectAttachmentManage.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionProjectAttachmentManage extends GenericCondition{

	public ConditionProjectAttachmentManage(){
		setParameterCount(4);
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.Boolean getIsQualified() {
		return this.__is_qualified;
	}

	public void setIsQualified( java.lang.Boolean value ) {
		this.__is_qualified = value;
	}
	
	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getIsQualified() != null) sb.append(__wrapBoolean(1, "isQualified", getIsQualified()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("isQualified")) != null) setIsQualified(__getBoolean(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
	}

	private java.lang.String __contract_code = null;
	private java.lang.String __project_name = null;
	private java.lang.Boolean __is_qualified = null;
	private java.lang.Integer __plate_id = null;
}

