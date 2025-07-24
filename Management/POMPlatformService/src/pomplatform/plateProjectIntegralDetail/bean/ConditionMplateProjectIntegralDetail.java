package pomplatform.plateProjectIntegralDetail.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMplateProjectIntegralDetail extends GenericCondition{

	public ConditionMplateProjectIntegralDetail(){
		setParameterCount(5);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getSubContractCode() {
		return this.__sub_contract_code == null ? null : (this.__sub_contract_code.indexOf("%") >= 0 ? this.__sub_contract_code : "%"+this.__sub_contract_code+"%");
	}

	public void setSubContractCode( java.lang.String value ) {
		this.__sub_contract_code = value;
	}

	public java.lang.String getSubContractName() {
		return this.__sub_contract_name == null ? null : (this.__sub_contract_name.indexOf("%") >= 0 ? this.__sub_contract_name : "%"+this.__sub_contract_name+"%");
	}

	public void setSubContractName( java.lang.String value ) {
		this.__sub_contract_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getSubContractCode() != null) sb.append(__wrapString(1, "subContractCode", getSubContractCode()));
		if(getSubContractName() != null) sb.append(__wrapString(1, "subContractName", getSubContractName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("subContractCode")) != null) setSubContractCode(__getString(val));
		if((val = values.get("subContractName")) != null) setSubContractName(__getString(val));
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.String __project_code = null;
	private java.lang.String __project_name = null;
	private java.lang.String __sub_contract_code = null;
	private java.lang.String __sub_contract_name = null;
}

