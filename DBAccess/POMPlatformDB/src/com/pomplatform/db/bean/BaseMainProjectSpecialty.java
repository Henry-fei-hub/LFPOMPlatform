package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMainProjectSpecialty extends GenericBase implements BaseFactory<BaseMainProjectSpecialty>, Comparable<BaseMainProjectSpecialty> 
{


	public static BaseMainProjectSpecialty newInstance(){
		return new BaseMainProjectSpecialty();
	}

	@Override
	public BaseMainProjectSpecialty make(){
		BaseMainProjectSpecialty b = new BaseMainProjectSpecialty();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_SPECIALTY_ID = "main_project_specialty_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_SPECIALTY_ID = "specialty_id" ;
	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_REGISTRATION_SEAL_EMPLOYEE_ID = "registration_seal_employee_id" ;
	public final static java.lang.String CS_IS_OUTSOURCING = "is_outsourcing" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,前期项目id,专业,前期项目id,注册盖章人员,是否外包";

	public java.lang.Integer getMainProjectSpecialtyId() {
		return this.__main_project_specialty_id;
	}

	public void setMainProjectSpecialtyId( java.lang.Integer value ) {
		this.__main_project_specialty_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getSpecialtyId() {
		return this.__specialty_id;
	}

	public void setSpecialtyId( java.lang.Integer value ) {
		this.__specialty_id = value;
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.Integer getRegistrationSealEmployeeId() {
		return this.__registration_seal_employee_id;
	}

	public void setRegistrationSealEmployeeId( java.lang.Integer value ) {
		this.__registration_seal_employee_id = value;
	}

	public java.lang.Boolean getIsOutsourcing() {
		return this.__is_outsourcing;
	}

	public void setIsOutsourcing( java.lang.Boolean value ) {
		this.__is_outsourcing = value;
	}

	public void cloneCopy(BaseMainProjectSpecialty __bean){
		__bean.setMainProjectSpecialtyId(getMainProjectSpecialtyId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setSpecialtyId(getSpecialtyId());
		__bean.setPreProjectId(getPreProjectId());
		__bean.setRegistrationSealEmployeeId(getRegistrationSealEmployeeId());
		__bean.setIsOutsourcing(getIsOutsourcing());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectSpecialtyId() == null ? "" : getMainProjectSpecialtyId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getSpecialtyId() == null ? "" : getSpecialtyId());
		sb.append(",");
		sb.append(getPreProjectId() == null ? "" : getPreProjectId());
		sb.append(",");
		sb.append(getRegistrationSealEmployeeId() == null ? "" : getRegistrationSealEmployeeId());
		sb.append(",");
		sb.append(getIsOutsourcing() == null ? "" : getIsOutsourcing());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMainProjectSpecialty o) {
		return __main_project_specialty_id == null ? -1 : __main_project_specialty_id.compareTo(o.getMainProjectSpecialtyId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_specialty_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__specialty_id);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__registration_seal_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__is_outsourcing);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMainProjectSpecialty o = (BaseMainProjectSpecialty)obj;
		if(!Objects.equals(this.__main_project_specialty_id, o.getMainProjectSpecialtyId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__specialty_id, o.getSpecialtyId())) return false;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__registration_seal_employee_id, o.getRegistrationSealEmployeeId())) return false;
		if(!Objects.equals(this.__is_outsourcing, o.getIsOutsourcing())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectSpecialtyId() != null) sb.append(__wrapNumber(count++, "mainProjectSpecialtyId", getMainProjectSpecialtyId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getSpecialtyId() != null) sb.append(__wrapNumber(count++, "specialtyId", getSpecialtyId()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getRegistrationSealEmployeeId() != null) sb.append(__wrapNumber(count++, "registrationSealEmployeeId", getRegistrationSealEmployeeId()));
		if(getIsOutsourcing() != null) sb.append(__wrapBoolean(count++, "isOutsourcing", getIsOutsourcing()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMainProjectSpecialtyId() != null) res.put("mainProjectSpecialtyId", getMainProjectSpecialtyId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getSpecialtyId() != null) res.put("specialtyId", getSpecialtyId());
		if(getPreProjectId() != null) res.put("preProjectId", getPreProjectId());
		if(getRegistrationSealEmployeeId() != null) res.put("registrationSealEmployeeId", getRegistrationSealEmployeeId());
		if(getIsOutsourcing() != null) res.put("isOutsourcing", getIsOutsourcing());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectSpecialtyId")) != null) setMainProjectSpecialtyId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("specialtyId")) != null) setSpecialtyId(__getInt(val)); 
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("registrationSealEmployeeId")) != null) setRegistrationSealEmployeeId(__getInt(val)); 
		if((val = values.get("isOutsourcing")) != null) setIsOutsourcing(__getBoolean(val));
	}

	protected java.lang.Integer  __main_project_specialty_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __specialty_id ;
	protected java.lang.Integer  __pre_project_id ;
	protected java.lang.Integer  __registration_seal_employee_id ;
	protected java.lang.Boolean  __is_outsourcing ;
}
