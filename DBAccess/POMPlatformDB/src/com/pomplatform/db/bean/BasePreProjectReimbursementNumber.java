package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePreProjectReimbursementNumber extends GenericBase implements BaseFactory<BasePreProjectReimbursementNumber>, Comparable<BasePreProjectReimbursementNumber> 
{


	public static BasePreProjectReimbursementNumber newInstance(){
		return new BasePreProjectReimbursementNumber();
	}

	@Override
	public BasePreProjectReimbursementNumber make(){
		BasePreProjectReimbursementNumber b = new BasePreProjectReimbursementNumber();
		return b;
	}

	public final static java.lang.String CS_PRE_PROJECT_REIMBURSEMENT_NUMBER_ID = "pre_project_reimbursement_number_id" ;
	public final static java.lang.String CS_CUSTOM_NUMBER = "custom_number" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_PROJECT_MANAGER = "project_manager" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PRE_PROJECT_TYPE = "pre_project_type" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PRE_BUSINESS_TYPE = "pre_business_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,前期项目信息编号,前期项目id,项目经理(用来指定这个项目的项目经理),操作人,创建时间,备注,项目类别,业务部门,业务类别";

	public java.lang.Integer getPreProjectReimbursementNumberId() {
		return this.__pre_project_reimbursement_number_id;
	}

	public void setPreProjectReimbursementNumberId( java.lang.Integer value ) {
		this.__pre_project_reimbursement_number_id = value;
	}

	public java.lang.String getCustomNumber() {
		return this.__custom_number;
	}

	public void setCustomNumber( java.lang.String value ) {
		this.__custom_number = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getProjectManager() {
		return this.__project_manager;
	}

	public void setProjectManager( java.lang.Integer value ) {
		this.__project_manager = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getPreProjectType() {
		return this.__pre_project_type;
	}

	public void setPreProjectType( java.lang.Integer value ) {
		this.__pre_project_type = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getPreBusinessType() {
		return this.__pre_business_type;
	}

	public void setPreBusinessType( java.lang.Integer value ) {
		this.__pre_business_type = value;
	}

	public void cloneCopy(BasePreProjectReimbursementNumber __bean){
		__bean.setPreProjectReimbursementNumberId(getPreProjectReimbursementNumberId());
		__bean.setCustomNumber(getCustomNumber());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setProjectManager(getProjectManager());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
		__bean.setPreProjectType(getPreProjectType());
		__bean.setPlateId(getPlateId());
		__bean.setPreBusinessType(getPreBusinessType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPreProjectReimbursementNumberId() == null ? "" : getPreProjectReimbursementNumberId());
		sb.append(",");
		sb.append(getCustomNumber() == null ? "" : getCustomNumber());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		String strProjectManager = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getProjectManager()));
		sb.append(strProjectManager == null ? "" : strProjectManager);
		sb.append(",");
		String strOperator = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperator()));
		sb.append(strOperator == null ? "" : strOperator);
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getPreProjectType() == null ? "" : getPreProjectType());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getPreBusinessType() == null ? "" : getPreBusinessType());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePreProjectReimbursementNumber o) {
		return __pre_project_reimbursement_number_id == null ? -1 : __pre_project_reimbursement_number_id.compareTo(o.getPreProjectReimbursementNumberId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__pre_project_reimbursement_number_id);
		hash = 97 * hash + Objects.hashCode(this.__custom_number);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manager);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__pre_project_type);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__pre_business_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePreProjectReimbursementNumber o = (BasePreProjectReimbursementNumber)obj;
		if(!Objects.equals(this.__pre_project_reimbursement_number_id, o.getPreProjectReimbursementNumberId())) return false;
		if(!Objects.equals(this.__custom_number, o.getCustomNumber())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__project_manager, o.getProjectManager())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__pre_project_type, o.getPreProjectType())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__pre_business_type, o.getPreBusinessType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPreProjectReimbursementNumberId() != null) sb.append(__wrapNumber(count++, "preProjectReimbursementNumberId", getPreProjectReimbursementNumberId()));
		if(getCustomNumber() != null) sb.append(__wrapString(count++, "customNumber", getCustomNumber()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getProjectManager() != null) sb.append(__wrapNumber(count++, "projectManager", getProjectManager()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getPreProjectType() != null) sb.append(__wrapNumber(count++, "preProjectType", getPreProjectType()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPreBusinessType() != null) sb.append(__wrapNumber(count++, "preBusinessType", getPreBusinessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("preProjectReimbursementNumberId")) != null) setPreProjectReimbursementNumberId(__getInt(val)); 
		if((val = values.get("customNumber")) != null) setCustomNumber(__getString(val));
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("projectManager")) != null) setProjectManager(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("preProjectType")) != null) setPreProjectType(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("preBusinessType")) != null) setPreBusinessType(__getInt(val)); 
	}

	protected java.lang.Integer  __pre_project_reimbursement_number_id ;
	protected java.lang.String  __custom_number ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __project_manager ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __pre_project_type ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __pre_business_type ;
}
