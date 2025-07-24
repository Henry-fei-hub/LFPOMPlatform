package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectpbpor extends GenericCondition{

	public ConditionSprojectpbpor(){
		setParameterCount(9);
	}
	
	public java.lang.Integer getProjectFlag() {
		return this.__project_flag;
	}

	public void setProjectFlag( java.lang.Integer value ) {
		this.__project_flag = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getBusinessLine() {
		return this.__business_line;
	}

	public void setBusinessLine( java.lang.Integer value ) {
		this.__business_line = value;
	}

	public java.lang.Integer getPricingType() {
		return this.__pricing_type;
	}

	public void setPricingType( java.lang.Integer value ) {
		this.__pricing_type = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
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

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}
	
	public java.lang.Boolean getIsHasPrice() {
		return this.__is_has_price;
	}

	public void setIsHasPrice( java.lang.Boolean value ) {
		this.__is_has_price = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectType() != null) sb.append(__wrapNumber(1, "projectType", getProjectType()));
		if(getBusinessLine() != null) sb.append(__wrapNumber(1, "businessLine", getBusinessLine()));
		if(getPricingType() != null) sb.append(__wrapNumber(1, "pricingType", getPricingType()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getIsHasPrice() != null) sb.append(__wrapBoolean(1, "isHasPrice", getIsHasPrice()));
		if(getProjectFlag() != null) sb.append(__wrapNumber(1, "projectFlag", getProjectFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("businessLine")) != null) setBusinessLine(__getInt(val)); 
		if((val = values.get("pricingType")) != null) setPricingType(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("isHasPrice")) != null) setIsHasPrice(__getBoolean(val)); 
		if((val = values.get("projectFlag")) != null) setProjectFlag(__getInt(val)); 
	}

	private java.lang.Integer __project_type = null;
	private java.lang.Integer __business_line = null;
	private java.lang.Integer __pricing_type = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __project_code = null;
	private java.lang.String __project_name = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Boolean __is_has_price = null;
	private java.lang.Integer __project_flag = null;
}

