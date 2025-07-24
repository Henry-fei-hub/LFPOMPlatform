package pomplatform.revenueStatistical.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionRevenueStatisticalOfRevenue extends GenericCondition{

	public ConditionRevenueStatisticalOfRevenue(){
		setParameterCount(10);
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getPlateManagerId() {
		return this.__plate_manager_id;
	}

	public void setPlateManagerId( java.lang.Integer value ) {
		this.__plate_manager_id = value;
	}

	public java.lang.Integer getDepartmentManagerId() {
		return this.__department_manager_id;
	}

	public void setDepartmentManagerId( java.lang.Integer value ) {
		this.__department_manager_id = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.String getSheetName() {
		return this.__sheet_name == null ? null : (this.__sheet_name.indexOf("%") >= 0 ? this.__sheet_name : "%"+this.__sheet_name+"%");
	}

	public void setSheetName( java.lang.String value ) {
		this.__sheet_name = value;
	}

	public java.lang.String getSheetCode() {
		return this.__sheet_code == null ? null : (this.__sheet_code.indexOf("%") >= 0 ? this.__sheet_code : "%"+this.__sheet_code+"%");
	}

	public void setSheetCode( java.lang.String value ) {
		this.__sheet_code = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(1, "plateManagerId", getPlateManagerId()));
		if(getDepartmentManagerId() != null) sb.append(__wrapNumber(1, "departmentManagerId", getDepartmentManagerId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(1, "projectManageId", getProjectManageId()));
		if(getSheetName() != null) sb.append(__wrapString(1, "sheetName", getSheetName()));
		if(getSheetCode() != null) sb.append(__wrapString(1, "sheetCode", getSheetCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateManagerId")) != null) setPlateManagerId(__getInt(val)); 
		if((val = values.get("departmentManagerId")) != null) setDepartmentManagerId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("sheetName")) != null) setSheetName(__getString(val));
		if((val = values.get("sheetCode")) != null) setSheetCode(__getString(val));
	}

	private java.util.Date __end_date = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __plate_manager_id = null;
	private java.lang.Integer __department_manager_id = null;
	private java.lang.Integer __project_manage_id = null;
	private java.lang.String __sheet_name = null;
	private java.lang.String __sheet_code = null;
}

