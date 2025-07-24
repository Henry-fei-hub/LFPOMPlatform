package pomplatform.project.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadProjectStageSettlement2 extends GenericBase implements BaseFactory<BaseOnLoadProjectStageSettlement2>, Comparable<BaseOnLoadProjectStageSettlement2> 
{


	public static BaseOnLoadProjectStageSettlement2 newInstance(){
		return new BaseOnLoadProjectStageSettlement2();
	}

	@Override
	public BaseOnLoadProjectStageSettlement2 make(){
		BaseOnLoadProjectStageSettlement2 b = new BaseOnLoadProjectStageSettlement2();
		return b;
	}

	public final static java.lang.String CS_PROJECT_STAGE_ID = "project_stage_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PROJECT_AMOUNT = "project_amount" ;
	public final static java.lang.String CS_STAGE_NAME = "stage_name" ;
	public final static java.lang.String CS_SETTLEMENT_INTEGRAL = "settlement_integral" ;
	public final static java.lang.String CS_ATTACHMENT_NUM = "attachment_num" ;
	public final static java.lang.String CS_SETTLEMENT_NUM = "settlement_num" ;
	public final static java.lang.String CS_STAGE_PLAN_INTEGRAL = "stage_plan_integral" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PROJECT_TEMPLATE_ID = "project_template_id" ;

	public final static java.lang.String ALL_CAPTIONS = "项目阶段代码,项目代码,阶段id,占比(%),项目积分,阶段名称,,,,,结算原因,项目阶段模板id （project_templates）";

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

	public java.math.BigDecimal getSettlementIntegral() {
		return this.__settlement_integral;
	}

	public void setSettlementIntegral( java.math.BigDecimal value ) {
		this.__settlement_integral = value;
	}

	public java.lang.Long getAttachmentNum() {
		return this.__attachment_num;
	}

	public void setAttachmentNum( java.lang.Long value ) {
		this.__attachment_num = value;
	}

	public java.lang.Long getSettlementNum() {
		return this.__settlement_num;
	}

	public void setSettlementNum( java.lang.Long value ) {
		this.__settlement_num = value;
	}

	public java.math.BigDecimal getStagePlanIntegral() {
		return this.__stage_plan_integral;
	}

	public void setStagePlanIntegral( java.math.BigDecimal value ) {
		this.__stage_plan_integral = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getProjectTemplateId() {
		return this.__project_template_id;
	}

	public void setProjectTemplateId( java.lang.Integer value ) {
		this.__project_template_id = value;
	}

	public void cloneCopy(BaseOnLoadProjectStageSettlement2 __bean){
		__bean.setProjectStageId(getProjectStageId());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setPercent(getPercent());
		__bean.setProjectAmount(getProjectAmount());
		__bean.setStageName(getStageName());
		__bean.setSettlementIntegral(getSettlementIntegral());
		__bean.setAttachmentNum(getAttachmentNum());
		__bean.setSettlementNum(getSettlementNum());
		__bean.setStagePlanIntegral(getStagePlanIntegral());
		__bean.setRemark(getRemark());
		__bean.setProjectTemplateId(getProjectTemplateId());
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
		sb.append(getSettlementIntegral() == null ? "" : getSettlementIntegral());
		sb.append(",");
		sb.append(getAttachmentNum() == null ? "" : getAttachmentNum());
		sb.append(",");
		sb.append(getSettlementNum() == null ? "" : getSettlementNum());
		sb.append(",");
		sb.append(getStagePlanIntegral() == null ? "" : getStagePlanIntegral());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getProjectTemplateId() == null ? "" : getProjectTemplateId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadProjectStageSettlement2 o) {
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
		hash = 97 * hash + Objects.hashCode(this.__settlement_integral);
		hash = 97 * hash + Objects.hashCode(this.__attachment_num);
		hash = 97 * hash + Objects.hashCode(this.__settlement_num);
		hash = 97 * hash + Objects.hashCode(this.__stage_plan_integral);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__project_template_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadProjectStageSettlement2 o = (BaseOnLoadProjectStageSettlement2)obj;
		if(!Objects.equals(this.__project_stage_id, o.getProjectStageId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__project_amount, o.getProjectAmount())) return false;
		if(!Objects.equals(this.__stage_name, o.getStageName())) return false;
		if(!Objects.equals(this.__settlement_integral, o.getSettlementIntegral())) return false;
		if(!Objects.equals(this.__attachment_num, o.getAttachmentNum())) return false;
		if(!Objects.equals(this.__settlement_num, o.getSettlementNum())) return false;
		if(!Objects.equals(this.__stage_plan_integral, o.getStagePlanIntegral())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__project_template_id, o.getProjectTemplateId())) return false;
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
		if(getSettlementIntegral() != null) sb.append(__wrapDecimal(count++, "settlementIntegral", getSettlementIntegral()));
		if(getAttachmentNum() != null) sb.append(__wrapNumber(count++, "attachmentNum", getAttachmentNum()));
		if(getSettlementNum() != null) sb.append(__wrapNumber(count++, "settlementNum", getSettlementNum()));
		if(getStagePlanIntegral() != null) sb.append(__wrapDecimal(count++, "stagePlanIntegral", getStagePlanIntegral()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProjectTemplateId() != null) sb.append(__wrapNumber(count++, "projectTemplateId", getProjectTemplateId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProjectStageId() != null) res.put("projectStageId", getProjectStageId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getStageId() != null) res.put("stageId", getStageId());
		if(getPercent() != null) res.put("percent", getPercent());
		if(getProjectAmount() != null) res.put("projectAmount", getProjectAmount());
		if(getStageName() != null) res.put("stageName", getStageName());
		if(getSettlementIntegral() != null) res.put("settlementIntegral", getSettlementIntegral());
		if(getAttachmentNum() != null) res.put("attachmentNum", getAttachmentNum());
		if(getSettlementNum() != null) res.put("settlementNum", getSettlementNum());
		if(getStagePlanIntegral() != null) res.put("stagePlanIntegral", getStagePlanIntegral());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getProjectTemplateId() != null) res.put("projectTemplateId", getProjectTemplateId());
		return res;
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
		if((val = values.get("settlementIntegral")) != null) setSettlementIntegral(__getDecimal(val));  
		if((val = values.get("attachmentNum")) != null) setAttachmentNum(__getLong(val)); 
		if((val = values.get("settlementNum")) != null) setSettlementNum(__getLong(val)); 
		if((val = values.get("stagePlanIntegral")) != null) setStagePlanIntegral(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("projectTemplateId")) != null) setProjectTemplateId(__getInt(val)); 
	}

	protected java.lang.Integer  __project_stage_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __percent ;
	protected java.math.BigDecimal  __project_amount ;
	protected java.lang.String  __stage_name ;
	protected java.math.BigDecimal  __settlement_integral ;
	protected java.lang.Long  __attachment_num ;
	protected java.lang.Long  __settlement_num ;
	protected java.math.BigDecimal  __stage_plan_integral ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __project_template_id ;
}
