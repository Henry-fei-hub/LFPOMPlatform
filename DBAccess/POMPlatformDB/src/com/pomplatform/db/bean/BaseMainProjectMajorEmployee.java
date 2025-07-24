package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseMainProjectMajorEmployee extends GenericBase implements BaseFactory<BaseMainProjectMajorEmployee>, Comparable<BaseMainProjectMajorEmployee> 
{


	public static BaseMainProjectMajorEmployee newInstance(){
		return new BaseMainProjectMajorEmployee();
	}

	@Override
	public BaseMainProjectMajorEmployee make(){
		BaseMainProjectMajorEmployee b = new BaseMainProjectMajorEmployee();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_MAJOR_EMPLOYEE_ID = "main_project_major_employee_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SPECIALTY_ID = "specialty_id" ;
	public final static java.lang.String CS_RELATION = "relation" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_STAMP_HOLDER = "stamp_holder" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,大项目主键,人员编码,专业,1专业负责人 2设计人 3制图人 4校对人 5质量管理员 6审核人 7审定人,操作人,创建时间,印章持有人(盖章人)";

	public java.lang.Integer getMainProjectMajorEmployeeId() {
		return this.__main_project_major_employee_id;
	}

	public void setMainProjectMajorEmployeeId( java.lang.Integer value ) {
		this.__main_project_major_employee_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getSpecialtyId() {
		return this.__specialty_id;
	}

	public void setSpecialtyId( java.lang.Integer value ) {
		this.__specialty_id = value;
	}

	public java.lang.Integer getRelation() {
		return this.__relation;
	}

	public void setRelation( java.lang.Integer value ) {
		this.__relation = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getStampHolder() {
		return this.__stamp_holder;
	}

	public void setStampHolder( java.lang.Integer value ) {
		this.__stamp_holder = value;
	}

	public void cloneCopy(BaseMainProjectMajorEmployee __bean){
		__bean.setMainProjectMajorEmployeeId(getMainProjectMajorEmployeeId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSpecialtyId(getSpecialtyId());
		__bean.setRelation(getRelation());
		__bean.setOperatorId(getOperatorId());
		__bean.setCreateTime(getCreateTime());
		__bean.setStampHolder(getStampHolder());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectMajorEmployeeId() == null ? "" : getMainProjectMajorEmployeeId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getSpecialtyId() == null ? "" : getSpecialtyId());
		sb.append(",");
		sb.append(getRelation() == null ? "" : getRelation());
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getStampHolder() == null ? "" : getStampHolder());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMainProjectMajorEmployee o) {
		return __main_project_major_employee_id == null ? -1 : __main_project_major_employee_id.compareTo(o.getMainProjectMajorEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_major_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__specialty_id);
		hash = 97 * hash + Objects.hashCode(this.__relation);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__stamp_holder);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMainProjectMajorEmployee o = (BaseMainProjectMajorEmployee)obj;
		if(!Objects.equals(this.__main_project_major_employee_id, o.getMainProjectMajorEmployeeId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__specialty_id, o.getSpecialtyId())) return false;
		if(!Objects.equals(this.__relation, o.getRelation())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__stamp_holder, o.getStampHolder())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectMajorEmployeeId() != null) sb.append(__wrapNumber(count++, "mainProjectMajorEmployeeId", getMainProjectMajorEmployeeId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSpecialtyId() != null) sb.append(__wrapNumber(count++, "specialtyId", getSpecialtyId()));
		if(getRelation() != null) sb.append(__wrapNumber(count++, "relation", getRelation()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getStampHolder() != null) sb.append(__wrapNumber(count++, "stampHolder", getStampHolder()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMainProjectMajorEmployeeId() != null) res.put("mainProjectMajorEmployeeId", getMainProjectMajorEmployeeId());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getSpecialtyId() != null) res.put("specialtyId", getSpecialtyId());
		if(getRelation() != null) res.put("relation", getRelation());
		if(getOperatorId() != null) res.put("operatorId", getOperatorId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getStampHolder() != null) res.put("stampHolder", getStampHolder());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectMajorEmployeeId")) != null) setMainProjectMajorEmployeeId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("specialtyId")) != null) setSpecialtyId(__getInt(val)); 
		if((val = values.get("relation")) != null) setRelation(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("stampHolder")) != null) setStampHolder(__getInt(val)); 
	}

	protected java.lang.Integer  __main_project_major_employee_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __specialty_id ;
	protected java.lang.Integer  __relation ;
	protected java.lang.Integer  __operator_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __stamp_holder ;
}
