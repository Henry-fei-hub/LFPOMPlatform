package pomplatform.groupOutdesignconsiderationior.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGroupOutdesignconsiderationior extends GenericCondition{

	public ConditionGroupOutdesignconsiderationior(){
		setParameterCount(3);
	}

	public java.lang.String getInfoCode() {
		return this.__info_code;
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.Integer getQuotationStatus() {
		return this.__quotation_status;
	}

	public void setQuotationStatus( java.lang.Integer value ) {
		this.__quotation_status = value;
	}
	
	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}


	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getQuotationStatus() != null) sb.append(__wrapNumber(1, "quotationStatus", getQuotationStatus()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("quotationStatus")) != null) setQuotationStatus(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
	}

	private java.lang.String __info_code = null;
	private java.lang.Integer __quotation_status = null;
	private java.lang.String __project_code = null;
}

