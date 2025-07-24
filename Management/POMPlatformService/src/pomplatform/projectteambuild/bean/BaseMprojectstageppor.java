package pomplatform.projectteambuild.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojectstageppor extends GenericBase implements BaseFactory<BaseMprojectstageppor>, Comparable<BaseMprojectstageppor> 
{


	public static BaseMprojectstageppor newInstance(){
		return new BaseMprojectstageppor();
	}

	@Override
	public BaseMprojectstageppor make(){
		BaseMprojectstageppor b = new BaseMprojectstageppor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_STAGE_ID = "project_stage_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static java.lang.String CS_STAGE_NAME = "stage_name" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "项目阶段代码,项目名称,阶段代码,占比(%),项目积分,阶段名称,剩余积分";

	public java.lang.Integer getProjectStageId() {
		return this.__project_stage_id;
	}

	public void setProjectStageId( java.lang.Integer value ) {
		this.__project_stage_id = value;
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

	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral( java.math.BigDecimal value ) {
		this.__left_integral = value;
	}

	public void cloneCopy(BaseMprojectstageppor __bean){
		__bean.setProjectStageId(getProjectStageId());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setPercent(getPercent());
		__bean.setProjectAmount(getProjectAmount());
		__bean.setStageName(getStageName());
		__bean.setLeftIntegral(getLeftIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectStageId() == null ? "" : getProjectStageId());
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
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprojectstageppor o) {
		return __project_stage_id == null ? -1 : __project_stage_id.compareTo(o.getProjectStageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_stage_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		hash = 97 * hash + Objects.hashCode(this.__stage_name);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojectstageppor o = (BaseMprojectstageppor)obj;
		if(!Objects.equals(this.__project_stage_id, o.getProjectStageId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__stage_name, o.getStageName())) return false;
		if(!Objects.equals(this.__left_integral, o.getLeftIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectStageId() != null) sb.append(__wrapNumber(count++, "projectStageId", getProjectStageId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getPercent() != null) sb.append(__wrapNumber(count++, "percent", getPercent()));
		if(getProjectAmount() != null) sb.append(__wrapDecimal(count++, "projectAmount", getProjectAmount()));
		if(getStageName() != null) sb.append(__wrapString(count++, "stageName", getStageName()));
		if(getLeftIntegral() != null) sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectStageId")) != null) setProjectStageId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getInt(val)); 
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val));  
		if((val = values.get("stageName")) != null) setStageName(__getString(val));
		if((val = values.get("leftIntegral")) != null) setLeftIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_stage_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __percent ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.lang.String  __stage_name ;
	protected java.math.BigDecimal  __left_integral ;
}
