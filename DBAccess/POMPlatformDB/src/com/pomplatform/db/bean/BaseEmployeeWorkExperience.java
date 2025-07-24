package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeWorkExperience extends GenericBase implements BaseFactory<BaseEmployeeWorkExperience>, Comparable<BaseEmployeeWorkExperience> 
{


	public static BaseEmployeeWorkExperience newInstance(){
		return new BaseEmployeeWorkExperience();
	}

	@Override
	public BaseEmployeeWorkExperience make(){
		BaseEmployeeWorkExperience b = new BaseEmployeeWorkExperience();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_WORK_EXPERIENCE_ID = "employee_work_experience_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_WORK_PLACE = "work_place" ;
	public final static java.lang.String CS_WORKEX_START_DATE = "workex_start_date" ;
	public final static java.lang.String CS_WORKEX_END_DATE = "workex_end_date" ;
	public final static java.lang.String CS_POSITION = "position" ;
	public final static java.lang.String CS_REASON_OF_LEAVING = "reason_of_leaving" ;
	public final static java.lang.String CS_IS_FOREIGN_COMPANY = "is_foreign_company" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,工作单位,开始日期,结束日期,职位,离职原因,外资企业（含港澳台）";

	public java.lang.Integer getEmployeeWorkExperienceId() {
		return this.__employee_work_experience_id;
	}

	public void setEmployeeWorkExperienceId( java.lang.Integer value ) {
		this.__employee_work_experience_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getWorkPlace() {
		return this.__work_place;
	}

	public void setWorkPlace( java.lang.String value ) {
		this.__work_place = value;
	}

	public java.util.Date getWorkexStartDate() {
		return this.__workex_start_date;
	}

	public void setWorkexStartDate( java.util.Date value ) {
		this.__workex_start_date = value;
	}

	public java.util.Date getWorkexEndDate() {
		return this.__workex_end_date;
	}

	public void setWorkexEndDate( java.util.Date value ) {
		this.__workex_end_date = value;
	}

	public java.lang.String getPosition() {
		return this.__position;
	}

	public void setPosition( java.lang.String value ) {
		this.__position = value;
	}

	public java.lang.String getReasonOfLeaving() {
		return this.__reason_of_leaving;
	}

	public void setReasonOfLeaving( java.lang.String value ) {
		this.__reason_of_leaving = value;
	}

	public java.lang.Boolean getIsForeignCompany() {
		return this.__is_foreign_company;
	}

	public void setIsForeignCompany( java.lang.Boolean value ) {
		this.__is_foreign_company = value;
	}

	public void cloneCopy(BaseEmployeeWorkExperience __bean){
		__bean.setEmployeeWorkExperienceId(getEmployeeWorkExperienceId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setWorkPlace(getWorkPlace());
		__bean.setWorkexStartDate(getWorkexStartDate());
		__bean.setWorkexEndDate(getWorkexEndDate());
		__bean.setPosition(getPosition());
		__bean.setReasonOfLeaving(getReasonOfLeaving());
		__bean.setIsForeignCompany(getIsForeignCompany());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeWorkExperienceId() == null ? "" : getEmployeeWorkExperienceId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getWorkPlace() == null ? "" : getWorkPlace());
		sb.append(",");
		sb.append(getWorkexStartDate() == null ? "" : sdf.format(getWorkexStartDate()));
		sb.append(",");
		sb.append(getWorkexEndDate() == null ? "" : sdf.format(getWorkexEndDate()));
		sb.append(",");
		sb.append(getPosition() == null ? "" : getPosition());
		sb.append(",");
		sb.append(getReasonOfLeaving() == null ? "" : getReasonOfLeaving());
		sb.append(",");
		sb.append(getIsForeignCompany() == null ? "" : getIsForeignCompany());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeWorkExperience o) {
		return __employee_work_experience_id == null ? -1 : __employee_work_experience_id.compareTo(o.getEmployeeWorkExperienceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_work_experience_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__work_place);
		hash = 97 * hash + Objects.hashCode(this.__workex_start_date);
		hash = 97 * hash + Objects.hashCode(this.__workex_end_date);
		hash = 97 * hash + Objects.hashCode(this.__position);
		hash = 97 * hash + Objects.hashCode(this.__reason_of_leaving);
		hash = 97 * hash + Objects.hashCode(this.__is_foreign_company);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeWorkExperience o = (BaseEmployeeWorkExperience)obj;
		if(!Objects.equals(this.__employee_work_experience_id, o.getEmployeeWorkExperienceId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__work_place, o.getWorkPlace())) return false;
		if(!Objects.equals(this.__workex_start_date, o.getWorkexStartDate())) return false;
		if(!Objects.equals(this.__workex_end_date, o.getWorkexEndDate())) return false;
		if(!Objects.equals(this.__position, o.getPosition())) return false;
		if(!Objects.equals(this.__reason_of_leaving, o.getReasonOfLeaving())) return false;
		if(!Objects.equals(this.__is_foreign_company, o.getIsForeignCompany())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeWorkExperienceId() != null) sb.append(__wrapNumber(count++, "employeeWorkExperienceId", getEmployeeWorkExperienceId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getWorkPlace() != null) sb.append(__wrapString(count++, "workPlace", getWorkPlace()));
		if(getWorkexStartDate() != null) sb.append(__wrapDate(count++, "workexStartDate", getWorkexStartDate()));
		if(getWorkexEndDate() != null) sb.append(__wrapDate(count++, "workexEndDate", getWorkexEndDate()));
		if(getPosition() != null) sb.append(__wrapString(count++, "position", getPosition()));
		if(getReasonOfLeaving() != null) sb.append(__wrapString(count++, "reasonOfLeaving", getReasonOfLeaving()));
		if(getIsForeignCompany() != null) sb.append(__wrapBoolean(count++, "isForeignCompany", getIsForeignCompany()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeWorkExperienceId")) != null) setEmployeeWorkExperienceId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("workPlace")) != null) setWorkPlace(__getString(val));
		if((val = values.get("workexStartDate")) != null) setWorkexStartDate(__getDate(val)); 
		if((val = values.get("workexEndDate")) != null) setWorkexEndDate(__getDate(val)); 
		if((val = values.get("position")) != null) setPosition(__getString(val));
		if((val = values.get("reasonOfLeaving")) != null) setReasonOfLeaving(__getString(val));
		if((val = values.get("isForeignCompany")) != null) setIsForeignCompany(__getBoolean(val));
	}

	protected java.lang.Integer  __employee_work_experience_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __work_place ;
	protected java.util.Date  __workex_start_date ;
	protected java.util.Date  __workex_end_date ;
	protected java.lang.String  __position ;
	protected java.lang.String  __reason_of_leaving ;
	protected java.lang.Boolean  __is_foreign_company ;
}
