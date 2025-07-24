package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeTechnicalTitle extends GenericBase implements BaseFactory<BaseEmployeeTechnicalTitle>, Comparable<BaseEmployeeTechnicalTitle> 
{


	public static BaseEmployeeTechnicalTitle newInstance(){
		return new BaseEmployeeTechnicalTitle();
	}

	@Override
	public BaseEmployeeTechnicalTitle make(){
		BaseEmployeeTechnicalTitle b = new BaseEmployeeTechnicalTitle();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_TECHNICAL_TITLE_ID = "employee_technical_title_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_TECHNICAL_TITLES = "technical_titles" ;
	public final static java.lang.String CS_TECHNICAL_SPECIALTY = "technical_specialty" ;
	public final static java.lang.String CS_TECHNICAL_LEVEL = "technical_level" ;
	public final static java.lang.String CS_ASSESSMENT_TIME = "assessment_time" ;
	public final static java.lang.String CS_ATTACHMENT = "attachment" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,职称,专业,级别,评定时间,附件";

	public java.lang.Integer getEmployeeTechnicalTitleId() {
		return this.__employee_technical_title_id;
	}

	public void setEmployeeTechnicalTitleId( java.lang.Integer value ) {
		this.__employee_technical_title_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getTechnicalTitles() {
		return this.__technical_titles;
	}

	public void setTechnicalTitles( java.lang.String value ) {
		this.__technical_titles = value;
	}

	public java.lang.String getTechnicalSpecialty() {
		return this.__technical_specialty;
	}

	public void setTechnicalSpecialty( java.lang.String value ) {
		this.__technical_specialty = value;
	}

	public java.lang.String getTechnicalLevel() {
		return this.__technical_level;
	}

	public void setTechnicalLevel( java.lang.String value ) {
		this.__technical_level = value;
	}

	public java.util.Date getAssessmentTime() {
		return this.__assessment_time;
	}

	public void setAssessmentTime( java.util.Date value ) {
		this.__assessment_time = value;
	}

	public java.lang.String getAttachment() {
		return this.__attachment;
	}

	public void setAttachment( java.lang.String value ) {
		this.__attachment = value;
	}

	public void cloneCopy(BaseEmployeeTechnicalTitle __bean){
		__bean.setEmployeeTechnicalTitleId(getEmployeeTechnicalTitleId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setTechnicalTitles(getTechnicalTitles());
		__bean.setTechnicalSpecialty(getTechnicalSpecialty());
		__bean.setTechnicalLevel(getTechnicalLevel());
		__bean.setAssessmentTime(getAssessmentTime());
		__bean.setAttachment(getAttachment());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeTechnicalTitleId() == null ? "" : getEmployeeTechnicalTitleId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getTechnicalTitles() == null ? "" : getTechnicalTitles());
		sb.append(",");
		sb.append(getTechnicalSpecialty() == null ? "" : getTechnicalSpecialty());
		sb.append(",");
		sb.append(getTechnicalLevel() == null ? "" : getTechnicalLevel());
		sb.append(",");
		sb.append(getAssessmentTime() == null ? "" : sdf.format(getAssessmentTime()));
		sb.append(",");
		sb.append(getAttachment() == null ? "" : getAttachment());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeTechnicalTitle o) {
		return __employee_technical_title_id == null ? -1 : __employee_technical_title_id.compareTo(o.getEmployeeTechnicalTitleId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_technical_title_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__technical_titles);
		hash = 97 * hash + Objects.hashCode(this.__technical_specialty);
		hash = 97 * hash + Objects.hashCode(this.__technical_level);
		hash = 97 * hash + Objects.hashCode(this.__assessment_time);
		hash = 97 * hash + Objects.hashCode(this.__attachment);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeTechnicalTitle o = (BaseEmployeeTechnicalTitle)obj;
		if(!Objects.equals(this.__employee_technical_title_id, o.getEmployeeTechnicalTitleId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__technical_titles, o.getTechnicalTitles())) return false;
		if(!Objects.equals(this.__technical_specialty, o.getTechnicalSpecialty())) return false;
		if(!Objects.equals(this.__technical_level, o.getTechnicalLevel())) return false;
		if(!Objects.equals(this.__assessment_time, o.getAssessmentTime())) return false;
		if(!Objects.equals(this.__attachment, o.getAttachment())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeTechnicalTitleId() != null) sb.append(__wrapNumber(count++, "employeeTechnicalTitleId", getEmployeeTechnicalTitleId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getTechnicalTitles() != null) sb.append(__wrapString(count++, "technicalTitles", getTechnicalTitles()));
		if(getTechnicalSpecialty() != null) sb.append(__wrapString(count++, "technicalSpecialty", getTechnicalSpecialty()));
		if(getTechnicalLevel() != null) sb.append(__wrapString(count++, "technicalLevel", getTechnicalLevel()));
		if(getAssessmentTime() != null) sb.append(__wrapDate(count++, "assessmentTime", getAssessmentTime()));
		if(getAttachment() != null) sb.append(__wrapString(count++, "attachment", getAttachment()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeTechnicalTitleId")) != null) setEmployeeTechnicalTitleId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("technicalTitles")) != null) setTechnicalTitles(__getString(val));
		if((val = values.get("technicalSpecialty")) != null) setTechnicalSpecialty(__getString(val));
		if((val = values.get("technicalLevel")) != null) setTechnicalLevel(__getString(val));
		if((val = values.get("assessmentTime")) != null) setAssessmentTime(__getDate(val)); 
		if((val = values.get("attachment")) != null) setAttachment(__getString(val));
	}

	protected java.lang.Integer  __employee_technical_title_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __technical_titles ;
	protected java.lang.String  __technical_specialty ;
	protected java.lang.String  __technical_level ;
	protected java.util.Date  __assessment_time ;
	protected java.lang.String  __attachment ;
}
