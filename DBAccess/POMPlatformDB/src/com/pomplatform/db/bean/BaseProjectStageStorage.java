package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectStageStorage extends GenericBase implements BaseFactory<BaseProjectStageStorage>, Comparable<BaseProjectStageStorage> 
{


	public static BaseProjectStageStorage newInstance(){
		return new BaseProjectStageStorage();
	}

	@Override
	public BaseProjectStageStorage make(){
		BaseProjectStageStorage b = new BaseProjectStageStorage();
		return b;
	}

	public final static java.lang.String CS_PROJECT_STAGE_STORAGE_ID = "project_stage_storage_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static java.lang.String CS_STAGE_NAME = "stage_name" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_RIGINAL_PLAN = "riginal_plan" ;
	public final static java.lang.String CS_PROJECT_CONFIRM_AMOUNT = "project_confirm_amount" ;
	public final static java.lang.String CS_TAB_AMOUNT = "tab_amount" ;
	public final static java.lang.String CS_PROJECT_TEMPLATE_ID = "project_template_id" ;

	public final static java.lang.String ALL_CAPTIONS = "id,项目编码,阶段代码,占比(%),项目积分,阶段名称,备注,是否原策划阶段 0是  1否,已确认积分,是否跨阶段 0是  1否,项目阶段模板id （project_templates）";

	public java.lang.Integer getProjectStageStorageId() {
		return this.__project_stage_storage_id;
	}

	public void setProjectStageStorageId( java.lang.Integer value ) {
		this.__project_stage_storage_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.lang.Integer getPercent() {
		return this.__percent;
	}

	public void setPercent( java.lang.Integer value ) {
		this.__percent = value;
	}

	public java.math.BigDecimal getProjectAmount() {
		return this.__project_amount;
	}

	public void setProjectAmount( java.math.BigDecimal value ) {
		this.__project_amount = value;
	}

	public java.lang.String getStageName() {
		return this.__stage_name;
	}

	public void setStageName( java.lang.String value ) {
		this.__stage_name = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getRiginalPlan() {
		return this.__riginal_plan;
	}

	public void setRiginalPlan( java.lang.Integer value ) {
		this.__riginal_plan = value;
	}

	public java.math.BigDecimal getProjectConfirmAmount() {
		return this.__project_confirm_amount;
	}

	public void setProjectConfirmAmount( java.math.BigDecimal value ) {
		this.__project_confirm_amount = value;
	}

	public java.lang.Integer getTabAmount() {
		return this.__tab_amount;
	}

	public void setTabAmount( java.lang.Integer value ) {
		this.__tab_amount = value;
	}

	public java.lang.Integer getProjectTemplateId() {
		return this.__project_template_id;
	}

	public void setProjectTemplateId( java.lang.Integer value ) {
		this.__project_template_id = value;
	}

	public void cloneCopy(BaseProjectStageStorage __bean){
		__bean.setProjectStageStorageId(getProjectStageStorageId());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setPercent(getPercent());
		__bean.setProjectAmount(getProjectAmount());
		__bean.setStageName(getStageName());
		__bean.setRemark(getRemark());
		__bean.setRiginalPlan(getRiginalPlan());
		__bean.setProjectConfirmAmount(getProjectConfirmAmount());
		__bean.setTabAmount(getTabAmount());
		__bean.setProjectTemplateId(getProjectTemplateId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectStageStorageId() == null ? "" : getProjectStageStorageId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getProjectAmount() == null ? "" : getProjectAmount());
		sb.append(",");
		sb.append(getStageName() == null ? "" : getStageName());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getRiginalPlan() == null ? "" : getRiginalPlan());
		sb.append(",");
		sb.append(getProjectConfirmAmount() == null ? "" : getProjectConfirmAmount());
		sb.append(",");
		sb.append(getTabAmount() == null ? "" : getTabAmount());
		sb.append(",");
		sb.append(getProjectTemplateId() == null ? "" : getProjectTemplateId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectStageStorage o) {
		return __project_stage_storage_id == null ? -1 : __project_stage_storage_id.compareTo(o.getProjectStageStorageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_stage_storage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		hash = 97 * hash + Objects.hashCode(this.__stage_name);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__riginal_plan);
		hash = 97 * hash + Objects.hashCode(this.__project_confirm_amount);
		hash = 97 * hash + Objects.hashCode(this.__tab_amount);
		hash = 97 * hash + Objects.hashCode(this.__project_template_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectStageStorage o = (BaseProjectStageStorage)obj;
		if(!Objects.equals(this.__project_stage_storage_id, o.getProjectStageStorageId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__stage_name, o.getStageName())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__riginal_plan, o.getRiginalPlan())) return false;
		if(!Objects.equals(this.__project_confirm_amount, o.getProjectConfirmAmount())) return false;
		if(!Objects.equals(this.__tab_amount, o.getTabAmount())) return false;
		if(!Objects.equals(this.__project_template_id, o.getProjectTemplateId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectStageStorageId() != null) sb.append(__wrapNumber(count++, "projectStageStorageId", getProjectStageStorageId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getPercent() != null) sb.append(__wrapNumber(count++, "percent", getPercent()));
		if(getProjectAmount() != null) sb.append(__wrapDecimal(count++, "projectAmount", getProjectAmount()));
		if(getStageName() != null) sb.append(__wrapString(count++, "stageName", getStageName()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getRiginalPlan() != null) sb.append(__wrapNumber(count++, "riginalPlan", getRiginalPlan()));
		if(getProjectConfirmAmount() != null) sb.append(__wrapDecimal(count++, "projectConfirmAmount", getProjectConfirmAmount()));
		if(getTabAmount() != null) sb.append(__wrapNumber(count++, "tabAmount", getTabAmount()));
		if(getProjectTemplateId() != null) sb.append(__wrapNumber(count++, "projectTemplateId", getProjectTemplateId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectStageStorageId")) != null) setProjectStageStorageId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getInt(val)); 
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val));  
		if((val = values.get("stageName")) != null) setStageName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("riginalPlan")) != null) setRiginalPlan(__getInt(val)); 
		if((val = values.get("projectConfirmAmount")) != null) setProjectConfirmAmount(__getDecimal(val));  
		if((val = values.get("tabAmount")) != null) setTabAmount(__getInt(val)); 
		if((val = values.get("projectTemplateId")) != null) setProjectTemplateId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_stage_storage_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __percent ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.lang.String  __stage_name ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __riginal_plan ;
	protected java.math.BigDecimal  __project_confirm_amount ;
	protected java.lang.Integer  __tab_amount ;
	protected java.lang.Integer  __project_template_id ;
}
