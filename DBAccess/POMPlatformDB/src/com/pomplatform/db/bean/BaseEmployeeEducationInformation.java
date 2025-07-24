package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeEducationInformation extends GenericBase implements BaseFactory<BaseEmployeeEducationInformation>, Comparable<BaseEmployeeEducationInformation> 
{


	public static BaseEmployeeEducationInformation newInstance(){
		return new BaseEmployeeEducationInformation();
	}

	@Override
	public BaseEmployeeEducationInformation make(){
		BaseEmployeeEducationInformation b = new BaseEmployeeEducationInformation();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_EDUCATION_INFORMATION_ID = "employee_education_information_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_GRADUATED_SCHOOL = "graduated_school" ;
	public final static java.lang.String CS_SPECIALTY = "specialty" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_EDUCATION = "education" ;
	public final static java.lang.String CS_DEGREE = "degree" ;
	public final static java.lang.String CS_LEARNING_WAY = "learning_way" ;
	public final static java.lang.String CS_ATTACHMENT = "attachment" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,毕业院校,所学专业,开始日期,结束日期,学历,学位,学习形式,附件";

	public java.lang.Integer getEmployeeEducationInformationId() {
		return this.__employee_education_information_id;
	}

	public void setEmployeeEducationInformationId( java.lang.Integer value ) {
		this.__employee_education_information_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getGraduatedSchool() {
		return this.__graduated_school;
	}

	public void setGraduatedSchool( java.lang.String value ) {
		this.__graduated_school = value;
	}

	public java.lang.String getSpecialty() {
		return this.__specialty;
	}

	public void setSpecialty( java.lang.String value ) {
		this.__specialty = value;
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

	public java.lang.Integer getEducation() {
		return this.__education;
	}

	public void setEducation( java.lang.Integer value ) {
		this.__education = value;
	}

	public java.lang.Integer getDegree() {
		return this.__degree;
	}

	public void setDegree( java.lang.Integer value ) {
		this.__degree = value;
	}

	public java.lang.Integer getLearningWay() {
		return this.__learning_way;
	}

	public void setLearningWay( java.lang.Integer value ) {
		this.__learning_way = value;
	}

	public java.lang.String getAttachment() {
		return this.__attachment;
	}

	public void setAttachment( java.lang.String value ) {
		this.__attachment = value;
	}

	public void cloneCopy(BaseEmployeeEducationInformation __bean){
		__bean.setEmployeeEducationInformationId(getEmployeeEducationInformationId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setGraduatedSchool(getGraduatedSchool());
		__bean.setSpecialty(getSpecialty());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setEducation(getEducation());
		__bean.setDegree(getDegree());
		__bean.setLearningWay(getLearningWay());
		__bean.setAttachment(getAttachment());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeEducationInformationId() == null ? "" : getEmployeeEducationInformationId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getGraduatedSchool() == null ? "" : getGraduatedSchool());
		sb.append(",");
		sb.append(getSpecialty() == null ? "" : getSpecialty());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getEducation() == null ? "" : getEducation());
		sb.append(",");
		sb.append(getDegree() == null ? "" : getDegree());
		sb.append(",");
		sb.append(getLearningWay() == null ? "" : getLearningWay());
		sb.append(",");
		sb.append(getAttachment() == null ? "" : getAttachment());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeEducationInformation o) {
		return __employee_education_information_id == null ? -1 : __employee_education_information_id.compareTo(o.getEmployeeEducationInformationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_education_information_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__graduated_school);
		hash = 97 * hash + Objects.hashCode(this.__specialty);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__education);
		hash = 97 * hash + Objects.hashCode(this.__degree);
		hash = 97 * hash + Objects.hashCode(this.__learning_way);
		hash = 97 * hash + Objects.hashCode(this.__attachment);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeEducationInformation o = (BaseEmployeeEducationInformation)obj;
		if(!Objects.equals(this.__employee_education_information_id, o.getEmployeeEducationInformationId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__graduated_school, o.getGraduatedSchool())) return false;
		if(!Objects.equals(this.__specialty, o.getSpecialty())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__education, o.getEducation())) return false;
		if(!Objects.equals(this.__degree, o.getDegree())) return false;
		if(!Objects.equals(this.__learning_way, o.getLearningWay())) return false;
		if(!Objects.equals(this.__attachment, o.getAttachment())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeEducationInformationId() != null) sb.append(__wrapNumber(count++, "employeeEducationInformationId", getEmployeeEducationInformationId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getGraduatedSchool() != null) sb.append(__wrapString(count++, "graduatedSchool", getGraduatedSchool()));
		if(getSpecialty() != null) sb.append(__wrapString(count++, "specialty", getSpecialty()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getEducation() != null) sb.append(__wrapNumber(count++, "education", getEducation()));
		if(getDegree() != null) sb.append(__wrapNumber(count++, "degree", getDegree()));
		if(getLearningWay() != null) sb.append(__wrapNumber(count++, "learningWay", getLearningWay()));
		if(getAttachment() != null) sb.append(__wrapString(count++, "attachment", getAttachment()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeEducationInformationId")) != null) setEmployeeEducationInformationId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("graduatedSchool")) != null) setGraduatedSchool(__getString(val));
		if((val = values.get("specialty")) != null) setSpecialty(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("education")) != null) setEducation(__getInt(val)); 
		if((val = values.get("degree")) != null) setDegree(__getInt(val)); 
		if((val = values.get("learningWay")) != null) setLearningWay(__getInt(val)); 
		if((val = values.get("attachment")) != null) setAttachment(__getString(val));
	}

	protected java.lang.Integer  __employee_education_information_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __graduated_school ;
	protected java.lang.String  __specialty ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.Integer  __education ;
	protected java.lang.Integer  __degree ;
	protected java.lang.Integer  __learning_way ;
	protected java.lang.String  __attachment ;
}
