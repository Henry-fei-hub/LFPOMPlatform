package pomplatform.OnRevenue.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAccountWeightOfRevenue extends GenericBase implements BaseFactory<BaseAccountWeightOfRevenue>, Comparable<BaseAccountWeightOfRevenue> 
{


	public static BaseAccountWeightOfRevenue newInstance(){
		return new BaseAccountWeightOfRevenue();
	}

	@Override
	public BaseAccountWeightOfRevenue make(){
		BaseAccountWeightOfRevenue b = new BaseAccountWeightOfRevenue();
		return b;
	}

	public final static java.lang.String CS_BUSINESS_STATE_RECORD_ID = "business_state_record_id" ;
	public final static java.lang.String CS_ACCOUNT_WEIGHT_RECORD_ID = "account_weight_record_id" ;
	public final static java.lang.String CS_TYPE_ID = "type_id" ;
	public final static java.lang.String CS_SETTLEMENT_LEVEL = "settlement_level" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_TYPE_NAME = "type_name" ;
	public final static java.lang.String CS_ASSIGN_INTEGRAL = "assign_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_FINISH_PERCENT = "finish_percent" ;
	public final static java.lang.String CS_FINISH_WEIGHT_PERCENT = "finish_weight_percent" ;
	public final static java.lang.String CS_HAS_ATTACHMENT = "has_attachment" ;
	public final static java.lang.String CS_ATTACHMENT_PERCENT = "attachment_percent" ;

	public final static java.lang.String ALL_CAPTIONS = "业态ID,业态类型ID,类型编码,计算级别(即计算优先级),权重比例,类型名称,阶段分配积分,阶段确认积分,阶段完工比,阶段权重完工比,是否有附件,附件完工比";

	public java.lang.Integer getBusinessStateRecordId() {
		return this.__business_state_record_id;
	}

	public void setBusinessStateRecordId( java.lang.Integer value ) {
		this.__business_state_record_id = value;
	}

	public java.lang.Integer getAccountWeightRecordId() {
		return this.__account_weight_record_id;
	}

	public void setAccountWeightRecordId( java.lang.Integer value ) {
		this.__account_weight_record_id = value;
	}

	public java.lang.Integer getTypeId() {
		return this.__type_id;
	}

	public void setTypeId( java.lang.Integer value ) {
		this.__type_id = value;
	}

	public java.lang.Integer getSettlementLevel() {
		return this.__settlement_level;
	}

	public void setSettlementLevel( java.lang.Integer value ) {
		this.__settlement_level = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.lang.String getTypeName() {
		return this.__type_name;
	}

	public void setTypeName( java.lang.String value ) {
		this.__type_name = value;
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

	public java.math.BigDecimal getFinishWeightPercent() {
		return this.__finish_weight_percent;
	}

	public void setFinishWeightPercent( java.math.BigDecimal value ) {
		this.__finish_weight_percent = value;
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

	public void cloneCopy(BaseAccountWeightOfRevenue __bean){
		__bean.setBusinessStateRecordId(getBusinessStateRecordId());
		__bean.setAccountWeightRecordId(getAccountWeightRecordId());
		__bean.setTypeId(getTypeId());
		__bean.setSettlementLevel(getSettlementLevel());
		__bean.setPercent(getPercent());
		__bean.setTypeName(getTypeName());
		__bean.setAssignIntegral(getAssignIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setFinishPercent(getFinishPercent());
		__bean.setFinishWeightPercent(getFinishWeightPercent());
		__bean.setHasAttachment(getHasAttachment());
		__bean.setAttachmentPercent(getAttachmentPercent());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBusinessStateRecordId() == null ? "" : getBusinessStateRecordId());
		sb.append(",");
		sb.append(getAccountWeightRecordId() == null ? "" : getAccountWeightRecordId());
		sb.append(",");
		sb.append(getTypeId() == null ? "" : getTypeId());
		sb.append(",");
		sb.append(getSettlementLevel() == null ? "" : getSettlementLevel());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getTypeName() == null ? "" : getTypeName());
		sb.append(",");
		sb.append(getAssignIntegral() == null ? "" : getAssignIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getFinishPercent() == null ? "" : getFinishPercent());
		sb.append(",");
		sb.append(getFinishWeightPercent() == null ? "" : getFinishWeightPercent());
		sb.append(",");
		sb.append(getHasAttachment() == null ? "" : getHasAttachment());
		sb.append(",");
		sb.append(getAttachmentPercent() == null ? "" : getAttachmentPercent());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAccountWeightOfRevenue o) {
		return __account_weight_record_id == null ? -1 : __account_weight_record_id.compareTo(o.getAccountWeightRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__business_state_record_id);
		hash = 97 * hash + Objects.hashCode(this.__account_weight_record_id);
		hash = 97 * hash + Objects.hashCode(this.__type_id);
		hash = 97 * hash + Objects.hashCode(this.__settlement_level);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__type_name);
		hash = 97 * hash + Objects.hashCode(this.__assign_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__finish_percent);
		hash = 97 * hash + Objects.hashCode(this.__finish_weight_percent);
		hash = 97 * hash + Objects.hashCode(this.__has_attachment);
		hash = 97 * hash + Objects.hashCode(this.__attachment_percent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAccountWeightOfRevenue o = (BaseAccountWeightOfRevenue)obj;
		if(!Objects.equals(this.__business_state_record_id, o.getBusinessStateRecordId())) return false;
		if(!Objects.equals(this.__account_weight_record_id, o.getAccountWeightRecordId())) return false;
		if(!Objects.equals(this.__type_id, o.getTypeId())) return false;
		if(!Objects.equals(this.__settlement_level, o.getSettlementLevel())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__type_name, o.getTypeName())) return false;
		if(!Objects.equals(this.__assign_integral, o.getAssignIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__finish_percent, o.getFinishPercent())) return false;
		if(!Objects.equals(this.__finish_weight_percent, o.getFinishWeightPercent())) return false;
		if(!Objects.equals(this.__has_attachment, o.getHasAttachment())) return false;
		if(!Objects.equals(this.__attachment_percent, o.getAttachmentPercent())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBusinessStateRecordId() != null) sb.append(__wrapNumber(count++, "businessStateRecordId", getBusinessStateRecordId()));
		if(getAccountWeightRecordId() != null) sb.append(__wrapNumber(count++, "accountWeightRecordId", getAccountWeightRecordId()));
		if(getTypeId() != null) sb.append(__wrapNumber(count++, "typeId", getTypeId()));
		if(getSettlementLevel() != null) sb.append(__wrapNumber(count++, "settlementLevel", getSettlementLevel()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getTypeName() != null) sb.append(__wrapString(count++, "typeName", getTypeName()));
		if(getAssignIntegral() != null) sb.append(__wrapDecimal(count++, "assignIntegral", getAssignIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getFinishPercent() != null) sb.append(__wrapDecimal(count++, "finishPercent", getFinishPercent()));
		if(getFinishWeightPercent() != null) sb.append(__wrapDecimal(count++, "finishWeightPercent", getFinishWeightPercent()));
		if(getHasAttachment() != null) sb.append(__wrapNumber(count++, "hasAttachment", getHasAttachment()));
		if(getAttachmentPercent() != null) sb.append(__wrapDecimal(count++, "attachmentPercent", getAttachmentPercent()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("businessStateRecordId")) != null) setBusinessStateRecordId(__getInt(val)); 
		if((val = values.get("accountWeightRecordId")) != null) setAccountWeightRecordId(__getInt(val)); 
		if((val = values.get("typeId")) != null) setTypeId(__getInt(val)); 
		if((val = values.get("settlementLevel")) != null) setSettlementLevel(__getInt(val)); 
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("typeName")) != null) setTypeName(__getString(val));
		if((val = values.get("assignIntegral")) != null) setAssignIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("finishPercent")) != null) setFinishPercent(__getDecimal(val));  
		if((val = values.get("finishWeightPercent")) != null) setFinishWeightPercent(__getDecimal(val));  
		if((val = values.get("hasAttachment")) != null) setHasAttachment(__getInt(val)); 
		if((val = values.get("attachmentPercent")) != null) setAttachmentPercent(__getDecimal(val));  
	}

	protected java.lang.Integer  __business_state_record_id ;
	protected java.lang.Integer  __account_weight_record_id ;
	protected java.lang.Integer  __type_id ;
	protected java.lang.Integer  __settlement_level ;
	protected java.math.BigDecimal  __percent ;
	protected java.lang.String  __type_name ;
	protected java.math.BigDecimal  __assign_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __finish_percent ;
	protected java.math.BigDecimal  __finish_weight_percent ;
	protected java.lang.Integer  __has_attachment ;
	protected java.math.BigDecimal  __attachment_percent ;
}
