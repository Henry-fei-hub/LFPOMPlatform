package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectTransition extends GenericBase implements BaseFactory<BaseProjectTransition>, Comparable<BaseProjectTransition> 
{


	public static BaseProjectTransition newInstance(){
		return new BaseProjectTransition();
	}

	@Override
	public BaseProjectTransition make(){
		BaseProjectTransition b = new BaseProjectTransition();
		return b;
	}

	public final static java.lang.String CS_PROJECT_TRANSITION_ID = "project_transition_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PROJECT_MANAGE_ID = "project_manage_id" ;
	public final static java.lang.String CS_IS_OR_NOT = "is_or_not" ;
	public final static java.lang.String CS_INITIATE_DESIGN = "initiate_design" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "id,项目id,核算比例（%）,专业负责人,是否审批,方案主创,状态   0 无意义 ，1 待审批   2 已驳回   3 已完成,操作人id,创建时间";

	public java.lang.Integer getProjectTransitionId() {
		return this.__project_transition_id;
	}

	public void setProjectTransitionId( java.lang.Integer value ) {
		this.__project_transition_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Boolean getIsOrNot() {
		return this.__is_or_not;
	}

	public void setIsOrNot( java.lang.Boolean value ) {
		this.__is_or_not = value;
	}

	public java.lang.Integer getInitiateDesign() {
		return this.__initiate_design;
	}

	public void setInitiateDesign( java.lang.Integer value ) {
		this.__initiate_design = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
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

	public void cloneCopy(BaseProjectTransition __bean){
		__bean.setProjectTransitionId(getProjectTransitionId());
		__bean.setProjectId(getProjectId());
		__bean.setPercent(getPercent());
		__bean.setProjectManageId(getProjectManageId());
		__bean.setIsOrNot(getIsOrNot());
		__bean.setInitiateDesign(getInitiateDesign());
		__bean.setStatus(getStatus());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectTransitionId() == null ? "" : getProjectTransitionId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getProjectManageId() == null ? "" : getProjectManageId());
		sb.append(",");
		sb.append(getIsOrNot() == null ? "" : getIsOrNot());
		sb.append(",");
		sb.append(getInitiateDesign() == null ? "" : getInitiateDesign());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectTransition o) {
		return __project_transition_id == null ? -1 : __project_transition_id.compareTo(o.getProjectTransitionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_transition_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__is_or_not);
		hash = 97 * hash + Objects.hashCode(this.__initiate_design);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectTransition o = (BaseProjectTransition)obj;
		if(!Objects.equals(this.__project_transition_id, o.getProjectTransitionId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__project_manage_id, o.getProjectManageId())) return false;
		if(!Objects.equals(this.__is_or_not, o.getIsOrNot())) return false;
		if(!Objects.equals(this.__initiate_design, o.getInitiateDesign())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectTransitionId() != null) sb.append(__wrapNumber(count++, "projectTransitionId", getProjectTransitionId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(count++, "projectManageId", getProjectManageId()));
		if(getIsOrNot() != null) sb.append(__wrapBoolean(count++, "isOrNot", getIsOrNot()));
		if(getInitiateDesign() != null) sb.append(__wrapNumber(count++, "initiateDesign", getInitiateDesign()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectTransitionId() != null) res.put("projectTransitionId", getProjectTransitionId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getPercent() != null) res.put("percent", getPercent());
		if(getProjectManageId() != null) res.put("projectManageId", getProjectManageId());
		if(getIsOrNot() != null) res.put("isOrNot", getIsOrNot());
		if(getInitiateDesign() != null) res.put("initiateDesign", getInitiateDesign());
		if(getStatus() != null) res.put("status", getStatus());
		if(getOperator() != null) res.put("operator", getOperator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectTransitionId")) != null) setProjectTransitionId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("isOrNot")) != null) setIsOrNot(__getBoolean(val));
		if((val = values.get("initiateDesign")) != null) setInitiateDesign(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __project_transition_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __percent ;
	protected java.lang.Integer  __project_manage_id ;
	protected java.lang.Boolean  __is_or_not ;
	protected java.lang.Integer  __initiate_design ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
}
