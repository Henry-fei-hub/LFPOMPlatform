package pomplatform.trainingmanagement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionTrainingmanagement extends GenericCondition{

	public ConditionTrainingmanagement(){
		setParameterCount(10);
	}

	public java.lang.Integer getTrainingManagementId() {
		return this.__training_management_id;
	}

	public void setTrainingManagementId( java.lang.Integer value ) {
		this.__training_management_id = value;
	}

	public java.lang.String getSubject() {
		return this.__subject == null ? null : (this.__subject.indexOf("%") >= 0 ? this.__subject : "%"+this.__subject+"%");
	}

	public void setSubject( java.lang.String value ) {
		this.__subject = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getCreatePersonId() {
		return this.__create_person_id;
	}

	public void setCreatePersonId( java.lang.Integer value ) {
		this.__create_person_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getCourseScore() {
		return this.__course_score;
	}

	public void setCourseScore( java.lang.Integer value ) {
		this.__course_score = value;
	}

	public java.lang.String getCompere() {
		return this.__compere == null ? null : (this.__compere.indexOf("%") >= 0 ? this.__compere : "%"+this.__compere+"%");
	}

	public void setCompere( java.lang.String value ) {
		this.__compere = value;
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

	public java.util.Date getStartTime() {
		return this.__start_time;
	}

	public void setStartTime( java.util.Date value ) {
		this.__start_time = value;
	}

	public java.util.Date getEndTime() {
		return this.__end_time;
	}

	public void setEndTime( java.util.Date value ) {
		this.__end_time = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTrainingManagementId() != null) sb.append(__wrapNumber(1, "trainingManagementId", getTrainingManagementId()));
		if(getSubject() != null) sb.append(__wrapString(1, "subject", getSubject()));
		if(getCreateTime() != null) sb.append(__wrapDate(1, "createTime", getCreateTime()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getCreatePersonId() != null) sb.append(__wrapNumber(1, "createPersonId", getCreatePersonId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getCourseScore() != null) sb.append(__wrapNumber(1, "courseScore", getCourseScore()));
		if(getCompere() != null) sb.append(__wrapString(1, "compere", getCompere()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getStartTime() != null) sb.append(__wrapDate(1, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(1, "endTime", getEndTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("trainingManagementId")) != null) setTrainingManagementId(__getInt(val)); 
		if((val = values.get("subject")) != null) setSubject(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("createPersonId")) != null) setCreatePersonId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("courseScore")) != null) setCourseScore(__getInt(val)); 
		if((val = values.get("compere")) != null) setCompere(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val));
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val));
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val));
	}

	private java.lang.Integer __training_management_id = null;
	private java.lang.String __subject = null;
	private java.util.Date __create_time = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __create_person_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __course_score = null;
	private java.lang.String __compere = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.util.Date __start_time = null;
	private java.util.Date __end_time = null;
}

