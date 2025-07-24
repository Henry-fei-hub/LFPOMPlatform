package pomplatform.project.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionOnDevelopProject extends GenericCondition{

	public ConditionOnDevelopProject(){
		setParameterCount(7);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getSheetCode() {
		return this.__sheet_code == null ? null : (this.__sheet_code.indexOf("%") >= 0 ? this.__sheet_code : "%"+this.__sheet_code+"%");
	}

	public void setSheetCode( java.lang.String value ) {
		this.__sheet_code = value;
	}

	public java.lang.String getSheetName() {
		return this.__sheet_name == null ? null : (this.__sheet_name.indexOf("%") >= 0 ? this.__sheet_name : "%"+this.__sheet_name+"%");
	}

	public void setSheetName( java.lang.String value ) {
		this.__sheet_name = value;
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
	
	public java.lang.Integer getProjectFlag() {
		return this.__project_flag;
	}

	public void setProjectFlag( java.lang.Integer value ) {
		this.__project_flag = value;
	}
	
	public java.lang.Integer getProjectSetupFlag() {
		return this.__project_setup_flag;
	}

	public void setProjectSetupFlag( java.lang.Integer value ) {
		this.__project_setup_flag = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getSheetCode() != null) sb.append(__wrapString(1, "sheetCode", getSheetCode()));
		if(getSheetName() != null) sb.append(__wrapString(1, "sheetName", getSheetName()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getProjectFlag() != null) sb.append(__wrapNumber(1, "projectFlag", getProjectFlag()));
		if(getProjectSetupFlag() != null) sb.append(__wrapNumber(1, "projectSetupFlag", getProjectSetupFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("sheetCode")) != null) setSheetCode(__getString(val));
		if((val = values.get("sheetName")) != null) setSheetName(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("projectFlag")) != null) setProjectFlag(__getInt(val)); 
		if((val = values.get("projectSetupFlag")) != null) setProjectSetupFlag(__getInt(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.String __sheet_code = null;
	private java.lang.String __sheet_name = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __project_flag = null;
	private java.lang.Integer __project_setup_flag = null;
}

