package pomplatform.projectStageTemplate.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectstagetemplatepor extends GenericBase implements BaseFactory<BaseSprojectstagetemplatepor>, Comparable<BaseSprojectstagetemplatepor> 
{


	public static BaseSprojectstagetemplatepor newInstance(){
		return new BaseSprojectstagetemplatepor();
	}

	@Override
	public BaseSprojectstagetemplatepor make(){
		BaseSprojectstagetemplatepor b = new BaseSprojectstagetemplatepor();
		return b;
	}

	public final static java.lang.String CS_PROJECT_STAGE_TEMPLATE_ID = "project_stage_template_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_STAGE_NAME = "stage_name" ;
	public final static java.lang.String CS_PROJECT_TEMPLATE_NAME = "project_template_name" ;
	public final static java.lang.String CS_PROJECT_TEMPLATE_ID = "project_template_id" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "项目阶段代码,阶段代码,占比(%),阶段名称,项目阶段模板名称,项目模板id （project_templates）,";

	public java.lang.Integer getProjectStageTemplateId() {
		return this.__project_stage_template_id;
	}

	public void setProjectStageTemplateId( java.lang.Integer value ) {
		this.__project_stage_template_id = value;
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

	public java.lang.String getStageName() {
		return this.__stage_name;
	}

	public void setStageName( java.lang.String value ) {
		this.__stage_name = value;
	}

	public java.lang.String getProjectTemplateName() {
		return this.__project_template_name;
	}

	public void setProjectTemplateName( java.lang.String value ) {
		this.__project_template_name = value;
	}

	public java.lang.Integer getProjectTemplateId() {
		return this.__project_template_id;
	}

	public void setProjectTemplateId( java.lang.Integer value ) {
		this.__project_template_id = value;
	}

	public java.math.BigDecimal getProjectAmount() {
		return this.__project_amount;
	}

	public void setProjectAmount( java.math.BigDecimal value ) {
		this.__project_amount = value;
	}

	public void cloneCopy(BaseSprojectstagetemplatepor __bean){
		__bean.setProjectStageTemplateId(getProjectStageTemplateId());
		__bean.setStageId(getStageId());
		__bean.setPercent(getPercent());
		__bean.setStageName(getStageName());
		__bean.setProjectTemplateName(getProjectTemplateName());
		__bean.setProjectTemplateId(getProjectTemplateId());
		__bean.setProjectAmount(getProjectAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectStageTemplateId() == null ? "" : getProjectStageTemplateId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getStageName() == null ? "" : getStageName());
		sb.append(",");
		sb.append(getProjectTemplateName() == null ? "" : getProjectTemplateName());
		sb.append(",");
		sb.append(getProjectTemplateId() == null ? "" : getProjectTemplateId());
		sb.append(",");
		sb.append(getProjectAmount() == null ? "" : getProjectAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectstagetemplatepor o) {
		return __project_stage_template_id == null ? -1 : __project_stage_template_id.compareTo(o.getProjectStageTemplateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_stage_template_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__stage_name);
		hash = 97 * hash + Objects.hashCode(this.__project_template_name);
		hash = 97 * hash + Objects.hashCode(this.__project_template_id);
		hash = 97 * hash + Objects.hashCode(this.__project_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectstagetemplatepor o = (BaseSprojectstagetemplatepor)obj;
		if(!Objects.equals(this.__project_stage_template_id, o.getProjectStageTemplateId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__stage_name, o.getStageName())) return false;
		if(!Objects.equals(this.__project_template_name, o.getProjectTemplateName())) return false;
		if(!Objects.equals(this.__project_template_id, o.getProjectTemplateId())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectStageTemplateId() != null) sb.append(__wrapNumber(count++, "projectStageTemplateId", getProjectStageTemplateId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getPercent() != null) sb.append(__wrapNumber(count++, "percent", getPercent()));
		if(getStageName() != null) sb.append(__wrapString(count++, "stageName", getStageName()));
		if(getProjectTemplateName() != null) sb.append(__wrapString(count++, "projectTemplateName", getProjectTemplateName()));
		if(getProjectTemplateId() != null) sb.append(__wrapNumber(count++, "projectTemplateId", getProjectTemplateId()));
		if(getProjectAmount() != null) sb.append(__wrapNumber(count++, "projectAmount", getProjectAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectStageTemplateId")) != null) setProjectStageTemplateId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getInt(val)); 
		if((val = values.get("stageName")) != null) setStageName(__getString(val));
		if((val = values.get("projectTemplateName")) != null) setProjectTemplateName(__getString(val));
		if((val = values.get("projectTemplateId")) != null) setProjectTemplateId(__getInt(val)); 
		if((val = values.get("projectAmount")) != null) setProjectAmount(__getDecimal(val)); 
	}

	protected java.lang.Integer  __project_stage_template_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __percent ;
	protected java.lang.String  __stage_name ;
	protected java.lang.String  __project_template_name ;
	protected java.lang.Integer  __project_template_id ;
	protected java.math.BigDecimal  __project_amount ;
}
