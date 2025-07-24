package pomplatform.OnRevenue.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSheetStageFinishPercentOfRevenue extends GenericBase implements BaseFactory<BaseSheetStageFinishPercentOfRevenue>, Comparable<BaseSheetStageFinishPercentOfRevenue> 
{


	public static BaseSheetStageFinishPercentOfRevenue newInstance(){
		return new BaseSheetStageFinishPercentOfRevenue();
	}

	@Override
	public BaseSheetStageFinishPercentOfRevenue make(){
		BaseSheetStageFinishPercentOfRevenue b = new BaseSheetStageFinishPercentOfRevenue();
		return b;
	}

	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_ASSIGN_INTEGRAL = "assign_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_FINISH_PERCENT = "finish_percent" ;
	public final static java.lang.String CS_HAS_ATTACHMENT = "has_attachment" ;
	public final static java.lang.String CS_ATTACHMENT_PERCENT = "attachment_percent" ;

	public final static java.lang.String ALL_CAPTIONS = "项目编码,项目阶段,占比(%),阶段分配积分,阶段确认积分,阶段完工比,是否有附件,附件完工比";

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

	public java.math.BigDecimal getAssignIntegral() {
		return this.__assign_integral;
	}

	public void setAssignIntegral( java.math.BigDecimal value ) {
		this.__assign_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getFinishPercent() {
		return this.__finish_percent;
	}

	public void setFinishPercent( java.math.BigDecimal value ) {
		this.__finish_percent = value;
	}

	public java.lang.Integer getHasAttachment() {
		return this.__has_attachment;
	}

	public void setHasAttachment( java.lang.Integer value ) {
		this.__has_attachment = value;
	}

	public java.math.BigDecimal getAttachmentPercent() {
		return this.__attachment_percent;
	}

	public void setAttachmentPercent( java.math.BigDecimal value ) {
		this.__attachment_percent = value;
	}

	public void cloneCopy(BaseSheetStageFinishPercentOfRevenue __bean){
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setPercent(getPercent());
		__bean.setAssignIntegral(getAssignIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setFinishPercent(getFinishPercent());
		__bean.setHasAttachment(getHasAttachment());
		__bean.setAttachmentPercent(getAttachmentPercent());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getAssignIntegral() == null ? "" : getAssignIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getFinishPercent() == null ? "" : getFinishPercent());
		sb.append(",");
		sb.append(getHasAttachment() == null ? "" : getHasAttachment());
		sb.append(",");
		sb.append(getAttachmentPercent() == null ? "" : getAttachmentPercent());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSheetStageFinishPercentOfRevenue o) {
		return __project_id == null ? -1 : __project_id.compareTo(o.getProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__assign_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__has_attachment);
		hash = 97 * hash + Objects.hashCode(this.__attachment_percent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSheetStageFinishPercentOfRevenue o = (BaseSheetStageFinishPercentOfRevenue)obj;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__assign_integral, o.getAssignIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__finish_percent, o.getFinishPercent())) return false;
		if(!Objects.equals(this.__has_attachment, o.getHasAttachment())) return false;
		if(!Objects.equals(this.__attachment_percent, o.getAttachmentPercent())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getPercent() != null) sb.append(__wrapNumber(count++, "percent", getPercent()));
		if(getAssignIntegral() != null) sb.append(__wrapDecimal(count++, "assignIntegral", getAssignIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getFinishPercent() != null) sb.append(__wrapDecimal(count++, "finishPercent", getFinishPercent()));
		if(getHasAttachment() != null) sb.append(__wrapNumber(count++, "hasAttachment", getHasAttachment()));
		if(getAttachmentPercent() != null) sb.append(__wrapDecimal(count++, "attachmentPercent", getAttachmentPercent()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getInt(val)); 
		if((val = values.get("assignIntegral")) != null) setAssignIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("finishPercent")) != null) setFinishPercent(__getDecimal(val));  
		if((val = values.get("hasAttachment")) != null) setHasAttachment(__getInt(val)); 
		if((val = values.get("attachmentPercent")) != null) setAttachmentPercent(__getDecimal(val));  
	}

	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __percent ;
	protected java.math.BigDecimal  __assign_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __finish_percent ;
	protected java.lang.Integer  __has_attachment ;
	protected java.math.BigDecimal  __attachment_percent ;
}
