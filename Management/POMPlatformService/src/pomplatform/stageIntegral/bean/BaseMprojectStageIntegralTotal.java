package pomplatform.stageIntegral.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojectStageIntegralTotal extends GenericBase implements BaseFactory<BaseMprojectStageIntegralTotal>, Comparable<BaseMprojectStageIntegralTotal> 
{


	public static BaseMprojectStageIntegralTotal newInstance(){
		return new BaseMprojectStageIntegralTotal();
	}

	@Override
	public BaseMprojectStageIntegralTotal make(){
		BaseMprojectStageIntegralTotal b = new BaseMprojectStageIntegralTotal();
		return b;
	}

	public final static java.lang.String CS_PROJECT_STAGE_RECORD_ID = "project_stage_record_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_STAGE_INTEGRAL = "stage_integral" ;
	public final static java.lang.String CS_STAGE_SURE_INTEGRAL = "stage_sure_integral" ;
	public final static java.lang.String CS_PROJECT_INTEGRAL = "project_integral" ;
	public final static java.lang.String CS_PROJECT_SURE_INTEGRAL = "project_sure_integral" ;
	public final static java.lang.String CS_STAGE_FINAL_INTEGRAL = "stage_final_integral" ;
	public final static java.lang.String CS_PROJECT_FINAL_INTEGRAL = "project_final_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目,项目阶段,阶段积分,已确认阶段积分,项目积分,已确认项目积分,未确认阶段积分,未确认项目积分";

	public java.lang.Integer getProjectStageRecordId() {
		return this.__project_stage_record_id;
	}

	public void setProjectStageRecordId( java.lang.Integer value ) {
		this.__project_stage_record_id = value;
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

	public java.lang.String getStageIntegral() {
		return this.__stage_integral;
	}

	public void setStageIntegral( java.lang.String value ) {
		this.__stage_integral = value;
	}

	public java.math.BigDecimal getStageSureIntegral() {
		return this.__stage_sure_integral;
	}

	public void setStageSureIntegral( java.math.BigDecimal value ) {
		this.__stage_sure_integral = value;
	}

	public java.math.BigDecimal getProjectIntegral() {
		return this.__project_integral;
	}

	public void setProjectIntegral( java.math.BigDecimal value ) {
		this.__project_integral = value;
	}

	public java.math.BigDecimal getProjectSureIntegral() {
		return this.__project_sure_integral;
	}

	public void setProjectSureIntegral( java.math.BigDecimal value ) {
		this.__project_sure_integral = value;
	}

	public java.math.BigDecimal getStageFinalIntegral() {
		return this.__stage_final_integral;
	}

	public void setStageFinalIntegral( java.math.BigDecimal value ) {
		this.__stage_final_integral = value;
	}

	public java.math.BigDecimal getProjectFinalIntegral() {
		return this.__project_final_integral;
	}

	public void setProjectFinalIntegral( java.math.BigDecimal value ) {
		this.__project_final_integral = value;
	}

	public void cloneCopy(BaseMprojectStageIntegralTotal __bean){
		__bean.setProjectStageRecordId(getProjectStageRecordId());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setStageIntegral(getStageIntegral());
		__bean.setStageSureIntegral(getStageSureIntegral());
		__bean.setProjectIntegral(getProjectIntegral());
		__bean.setProjectSureIntegral(getProjectSureIntegral());
		__bean.setStageFinalIntegral(getStageFinalIntegral());
		__bean.setProjectFinalIntegral(getProjectFinalIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectStageRecordId() == null ? "" : getProjectStageRecordId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getStageIntegral() == null ? "" : getStageIntegral());
		sb.append(",");
		sb.append(getStageSureIntegral() == null ? "" : getStageSureIntegral());
		sb.append(",");
		sb.append(getProjectIntegral() == null ? "" : getProjectIntegral());
		sb.append(",");
		sb.append(getProjectSureIntegral() == null ? "" : getProjectSureIntegral());
		sb.append(",");
		sb.append(getStageFinalIntegral() == null ? "" : getStageFinalIntegral());
		sb.append(",");
		sb.append(getProjectFinalIntegral() == null ? "" : getProjectFinalIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprojectStageIntegralTotal o) {
		return __project_stage_record_id == null ? -1 : __project_stage_record_id.compareTo(o.getProjectStageRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_stage_record_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_integral);
		hash = 97 * hash + Objects.hashCode(this.__stage_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__stage_final_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_final_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojectStageIntegralTotal o = (BaseMprojectStageIntegralTotal)obj;
		if(!Objects.equals(this.__project_stage_record_id, o.getProjectStageRecordId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__stage_integral, o.getStageIntegral())) return false;
		if(!Objects.equals(this.__stage_sure_integral, o.getStageSureIntegral())) return false;
		if(!Objects.equals(this.__project_integral, o.getProjectIntegral())) return false;
		if(!Objects.equals(this.__project_sure_integral, o.getProjectSureIntegral())) return false;
		if(!Objects.equals(this.__stage_final_integral, o.getStageFinalIntegral())) return false;
		if(!Objects.equals(this.__project_final_integral, o.getProjectFinalIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectStageRecordId() != null) sb.append(__wrapNumber(count++, "projectStageRecordId", getProjectStageRecordId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getStageIntegral() != null) sb.append(__wrapString(count++, "stageIntegral", getStageIntegral()));
		if(getStageSureIntegral() != null) sb.append(__wrapDecimal(count++, "stageSureIntegral", getStageSureIntegral()));
		if(getProjectIntegral() != null) sb.append(__wrapDecimal(count++, "projectIntegral", getProjectIntegral()));
		if(getProjectSureIntegral() != null) sb.append(__wrapDecimal(count++, "projectSureIntegral", getProjectSureIntegral()));
		if(getStageFinalIntegral() != null) sb.append(__wrapDecimal(count++, "stageFinalIntegral", getStageFinalIntegral()));
		if(getProjectFinalIntegral() != null) sb.append(__wrapDecimal(count++, "projectFinalIntegral", getProjectFinalIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectStageRecordId")) != null) setProjectStageRecordId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("stageIntegral")) != null) setStageIntegral(__getString(val));
		if((val = values.get("stageSureIntegral")) != null) setStageSureIntegral(__getDecimal(val));  
		if((val = values.get("projectIntegral")) != null) setProjectIntegral(__getDecimal(val));  
		if((val = values.get("projectSureIntegral")) != null) setProjectSureIntegral(__getDecimal(val));  
		if((val = values.get("stageFinalIntegral")) != null) setStageFinalIntegral(__getDecimal(val));  
		if((val = values.get("projectFinalIntegral")) != null) setProjectFinalIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_stage_record_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.String  __stage_integral ;
	protected java.math.BigDecimal  __stage_sure_integral ;
	protected java.math.BigDecimal  __project_integral ;
	protected java.math.BigDecimal  __project_sure_integral ;
	protected java.math.BigDecimal  __stage_final_integral ;
	protected java.math.BigDecimal  __project_final_integral ;
}
