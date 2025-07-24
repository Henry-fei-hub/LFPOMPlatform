package pomplatform.ManageProjectByProject.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionManageProjectByProject extends GenericCondition{

	public ConditionManageProjectByProject(){
		setParameterCount(4);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getRecordYear() {
		return this.__record_year;
	}

	public void setRecordYear( java.lang.Integer value ) {
		this.__record_year = value;
	}

	public java.lang.Integer getRecordMonth() {
		return this.__record_month;
	}

	public void setRecordMonth( java.lang.Integer value ) {
		this.__record_month = value;
	}

	public java.lang.String getManageProjectName() {
		return this.__manage_project_name == null ? null : (this.__manage_project_name.indexOf("%") >= 0 ? this.__manage_project_name : "%"+this.__manage_project_name+"%");
	}

	public void setManageProjectName( java.lang.String value ) {
		this.__manage_project_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getRecordYear() != null) sb.append(__wrapNumber(1, "recordYear", getRecordYear()));
		if(getRecordMonth() != null) sb.append(__wrapNumber(1, "recordMonth", getRecordMonth()));
		if(getManageProjectName() != null) sb.append(__wrapString(1, "manageProjectName", getManageProjectName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("recordYear")) != null) setRecordYear(__getInt(val)); 
		if((val = values.get("recordMonth")) != null) setRecordMonth(__getInt(val)); 
		if((val = values.get("manageProjectName")) != null) setManageProjectName(__getString(val));
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __record_year = null;
	private java.lang.Integer __record_month = null;
	private java.lang.String __manage_project_name = null;
}

