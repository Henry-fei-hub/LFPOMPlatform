package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseMainProjectEmployee extends GenericBase implements BaseFactory<BaseMainProjectEmployee>, Comparable<BaseMainProjectEmployee> 
{


	public static BaseMainProjectEmployee newInstance(){
		return new BaseMainProjectEmployee();
	}

	@Override
	public BaseMainProjectEmployee make(){
		BaseMainProjectEmployee b = new BaseMainProjectEmployee();
		return b;
	}

	public final static java.lang.String CS_MAIN_PROJECT_EMPLOYEE_ID = "main_project_employee_id" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_RELATION = "relation" ;
	public final static java.lang.String CS_PRE_PROJECT_ID = "pre_project_id" ;
	public final static java.lang.String CS_MAIN_AND_ASSISTANCE = "main_and_assistance" ;
	public final static java.lang.String CS_IS_PLATE_MANAGER = "is_plate_manager" ;

	public final static java.lang.String ALL_CAPTIONS = "编码,主项目编码,员工编码,员工和主项目的关系    1项目营销专员   2项目营销团队负责人   3项目经理   4项目主管领导,前期项目id,主要跟进人或协助跟进人（1主要跟进人，2协助跟进人）,是否事业部负责人";

	public java.lang.Integer getMainProjectEmployeeId() {
		return this.__main_project_employee_id;
	}

	public void setMainProjectEmployeeId( java.lang.Integer value ) {
		this.__main_project_employee_id = value;
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

	public java.lang.Integer getRelation() {
		return this.__relation;
	}

	public void setRelation( java.lang.Integer value ) {
		this.__relation = value;
	}

	public java.lang.Integer getPreProjectId() {
		return this.__pre_project_id;
	}

	public void setPreProjectId( java.lang.Integer value ) {
		this.__pre_project_id = value;
	}

	public java.lang.Integer getMainAndAssistance() {
		return this.__main_and_assistance;
	}

	public void setMainAndAssistance( java.lang.Integer value ) {
		this.__main_and_assistance = value;
	}

	public java.lang.Boolean getIsPlateManager() {
		return this.__is_plate_manager;
	}

	public void setIsPlateManager( java.lang.Boolean value ) {
		this.__is_plate_manager = value;
	}

	public void cloneCopy(BaseMainProjectEmployee __bean){
		__bean.setMainProjectEmployeeId(getMainProjectEmployeeId());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setRelation(getRelation());
		__bean.setPreProjectId(getPreProjectId());
		__bean.setMainAndAssistance(getMainAndAssistance());
		__bean.setIsPlateManager(getIsPlateManager());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMainProjectEmployeeId() == null ? "" : getMainProjectEmployeeId());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getRelation() == null ? "" : getRelation());
		sb.append(",");
		sb.append(getPreProjectId() == null ? "" : getPreProjectId());
		sb.append(",");
		sb.append(getMainAndAssistance() == null ? "" : getMainAndAssistance());
		sb.append(",");
		sb.append(getIsPlateManager() == null ? "" : getIsPlateManager());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMainProjectEmployee o) {
		return __main_project_employee_id == null ? -1 : __main_project_employee_id.compareTo(o.getMainProjectEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__main_project_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__relation);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_id);
		hash = 97 * hash + Objects.hashCode(this.__main_and_assistance);
		hash = 97 * hash + Objects.hashCode(this.__is_plate_manager);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMainProjectEmployee o = (BaseMainProjectEmployee)obj;
		if(!Objects.equals(this.__main_project_employee_id, o.getMainProjectEmployeeId())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__relation, o.getRelation())) return false;
		if(!Objects.equals(this.__pre_project_id, o.getPreProjectId())) return false;
		if(!Objects.equals(this.__main_and_assistance, o.getMainAndAssistance())) return false;
		if(!Objects.equals(this.__is_plate_manager, o.getIsPlateManager())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMainProjectEmployeeId() != null) sb.append(__wrapNumber(count++, "mainProjectEmployeeId", getMainProjectEmployeeId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getRelation() != null) sb.append(__wrapNumber(count++, "relation", getRelation()));
		if(getPreProjectId() != null) sb.append(__wrapNumber(count++, "preProjectId", getPreProjectId()));
		if(getMainAndAssistance() != null) sb.append(__wrapNumber(count++, "mainAndAssistance", getMainAndAssistance()));
		if(getIsPlateManager() != null) sb.append(__wrapBoolean(count++, "isPlateManager", getIsPlateManager()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("mainProjectEmployeeId")) != null) setMainProjectEmployeeId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("relation")) != null) setRelation(__getInt(val)); 
		if((val = values.get("preProjectId")) != null) setPreProjectId(__getInt(val)); 
		if((val = values.get("mainAndAssistance")) != null) setMainAndAssistance(__getInt(val)); 
		if((val = values.get("isPlateManager")) != null) setIsPlateManager(__getBoolean(val));
	}

	protected java.lang.Integer  __main_project_employee_id ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __relation ;
	protected java.lang.Integer  __pre_project_id ;
	protected java.lang.Integer  __main_and_assistance ;
	protected java.lang.Boolean  __is_plate_manager ;
}
