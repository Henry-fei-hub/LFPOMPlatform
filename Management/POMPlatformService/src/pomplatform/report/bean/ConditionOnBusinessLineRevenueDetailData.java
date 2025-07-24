package pomplatform.report.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnBusinessLineRevenueDetailData extends GenericCondition{

	public ConditionOnBusinessLineRevenueDetailData(){
		setParameterCount(5);
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getBusinessLine() {
		return this.__business_line;
	}

	public void setBusinessLine( java.lang.Integer value ) {
		this.__business_line = value;
	}

	public java.lang.String getSheetCode() {
		return this.__sheet_code == null ? null : (this.__sheet_code.indexOf("%") >= 0 ? this.__sheet_code : "%"+this.__sheet_code+"%");
	}

	public void setSheetCode( java.lang.String value ) {
		this.__sheet_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getBusinessLine() != null) sb.append(__wrapNumber(1, "businessLine", getBusinessLine()));
		if(getSheetCode() != null) sb.append(__wrapString(1, "sheetCode", getSheetCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("businessLine")) != null) setBusinessLine(__getInt(val)); 
		if((val = values.get("sheetCode")) != null) setSheetCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
	}

	private java.lang.Integer __year = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __business_line = null;
	private java.lang.String __sheet_code = null;
	private java.lang.String __project_name = null;
}

