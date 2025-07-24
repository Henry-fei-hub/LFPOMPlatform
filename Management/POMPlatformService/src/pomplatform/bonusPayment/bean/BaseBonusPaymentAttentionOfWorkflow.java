package pomplatform.bonusPayment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseBonusPaymentAttentionOfWorkflow extends GenericBase implements BaseFactory<BaseBonusPaymentAttentionOfWorkflow>, Comparable<BaseBonusPaymentAttentionOfWorkflow> 
{


	public static BaseBonusPaymentAttentionOfWorkflow newInstance(){
		return new BaseBonusPaymentAttentionOfWorkflow();
	}

	@Override
	public BaseBonusPaymentAttentionOfWorkflow make(){
		BaseBonusPaymentAttentionOfWorkflow b = new BaseBonusPaymentAttentionOfWorkflow();
		return b;
	}

	public final static java.lang.String CS_SYSTEM_PROCESS_ATTENTION_ID = "system_process_attention_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ACTIVITY_ID = "process_activity_id" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_BACK_VIEW_NAME = "back_view_name" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_ID = "instance_activity_id" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_CREATE_TIME = "instance_activity_create_time" ;
	public final static java.lang.String CS_INSTANCE_ACTIVITY_START_TIME = "instance_activity_start_time" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_PROCESS_COMMENT = "process_comment" ;
	public final static java.lang.String CS_BONUS_PAYMENT_RECORD_ID = "bonus_payment_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PAY_INTEGRAL = "pay_integral" ;
	public final static java.lang.String CS_PAY_DATE = "pay_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_APPLICANT = "applicant" ;
	public final static java.lang.String CS_APPLY_TIME = "apply_time" ;
	public final static java.lang.String CS_STATE = "state" ;
	public final static java.lang.String CS_AUDITOR = "auditor" ;
	public final static java.lang.String CS_AUDITING_TIME = "auditing_time" ;
	public final static java.lang.String CS_OPINION = "opinion" ;
	public final static java.lang.String CS_IS_LEVEL_TWO = "is_level_two" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,业务名称,活动编码,流程编码,流程实列编码,返回数据集,流程实例节点编码,流程实例节点创建时间,流程实例节点开始处于活动时间,状态,流程类型,操作时间,提交意见,主键编码,业务部门,发放积分,发放年月,备注,申请人,申请时间,审核状态  0未审核   1审核通过    2审核不通过,审核人,审核时间,审核意见,是否二级部门提交的";

	public java.lang.Integer getSystemProcessAttentionId() {
		return this.__system_process_attention_id;
	}

	public void setSystemProcessAttentionId( java.lang.Integer value ) {
		this.__system_process_attention_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.lang.Integer getProcessActivityId() {
		return this.__process_activity_id;
	}

	public void setProcessActivityId( java.lang.Integer value ) {
		this.__process_activity_id = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.String getBackViewName() {
		return this.__back_view_name;
	}

	public void setBackViewName( java.lang.String value ) {
		this.__back_view_name = value;
	}

	public java.lang.Integer getInstanceActivityId() {
		return this.__instance_activity_id;
	}

	public void setInstanceActivityId( java.lang.Integer value ) {
		this.__instance_activity_id = value;
	}

	public java.util.Date getInstanceActivityCreateTime() {
		return this.__instance_activity_create_time;
	}

	public void setInstanceActivityCreateTime( java.util.Date value ) {
		this.__instance_activity_create_time = value;
	}

	public java.util.Date getInstanceActivityStartTime() {
		return this.__instance_activity_start_time;
	}

	public void setInstanceActivityStartTime( java.util.Date value ) {
		this.__instance_activity_start_time = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getProcessComment() {
		return this.__process_comment;
	}

	public void setProcessComment( java.lang.String value ) {
		this.__process_comment = value;
	}

	public java.lang.Integer getBonusPaymentRecordId() {
		return this.__bonus_payment_record_id;
	}

	public void setBonusPaymentRecordId( java.lang.Integer value ) {
		this.__bonus_payment_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getPayIntegral() {
		return this.__pay_integral;
	}

	public void setPayIntegral( java.math.BigDecimal value ) {
		this.__pay_integral = value;
	}

	public java.util.Date getPayDate() {
		return this.__pay_date;
	}

	public void setPayDate( java.util.Date value ) {
		this.__pay_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getApplicant() {
		return this.__applicant;
	}

	public void setApplicant( java.lang.Integer value ) {
		this.__applicant = value;
	}

	public java.util.Date getApplyTime() {
		return this.__apply_time;
	}

	public void setApplyTime( java.util.Date value ) {
		this.__apply_time = value;
	}

	public java.lang.Integer getState() {
		return this.__state;
	}

	public void setState( java.lang.Integer value ) {
		this.__state = value;
	}

	public java.lang.Integer getAuditor() {
		return this.__auditor;
	}

	public void setAuditor( java.lang.Integer value ) {
		this.__auditor = value;
	}

	public java.util.Date getAuditingTime() {
		return this.__auditing_time;
	}

	public void setAuditingTime( java.util.Date value ) {
		this.__auditing_time = value;
	}

	public java.lang.String getOpinion() {
		return this.__opinion;
	}

	public void setOpinion( java.lang.String value ) {
		this.__opinion = value;
	}

	public java.lang.Boolean getIsLevelTwo() {
		return this.__is_level_two;
	}

	public void setIsLevelTwo( java.lang.Boolean value ) {
		this.__is_level_two = value;
	}

	public void cloneCopy(BaseBonusPaymentAttentionOfWorkflow __bean){
		__bean.setSystemProcessAttentionId(getSystemProcessAttentionId());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessActivityId(getProcessActivityId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setBackViewName(getBackViewName());
		__bean.setInstanceActivityId(getInstanceActivityId());
		__bean.setInstanceActivityCreateTime(getInstanceActivityCreateTime());
		__bean.setInstanceActivityStartTime(getInstanceActivityStartTime());
		__bean.setStatus(getStatus());
		__bean.setProcessType(getProcessType());
		__bean.setOperateTime(getOperateTime());
		__bean.setProcessComment(getProcessComment());
		__bean.setBonusPaymentRecordId(getBonusPaymentRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setPayIntegral(getPayIntegral());
		__bean.setPayDate(getPayDate());
		__bean.setRemark(getRemark());
		__bean.setApplicant(getApplicant());
		__bean.setApplyTime(getApplyTime());
		__bean.setState(getState());
		__bean.setAuditor(getAuditor());
		__bean.setAuditingTime(getAuditingTime());
		__bean.setOpinion(getOpinion());
		__bean.setIsLevelTwo(getIsLevelTwo());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSystemProcessAttentionId() == null ? "" : getSystemProcessAttentionId());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessActivityId() == null ? "" : getProcessActivityId());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getBackViewName() == null ? "" : getBackViewName());
		sb.append(",");
		sb.append(getInstanceActivityId() == null ? "" : getInstanceActivityId());
		sb.append(",");
		sb.append(getInstanceActivityCreateTime() == null ? "" : sdf.format(getInstanceActivityCreateTime()));
		sb.append(",");
		sb.append(getInstanceActivityStartTime() == null ? "" : sdf.format(getInstanceActivityStartTime()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getProcessComment() == null ? "" : getProcessComment());
		sb.append(",");
		sb.append(getBonusPaymentRecordId() == null ? "" : getBonusPaymentRecordId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getPayIntegral() == null ? "" : getPayIntegral());
		sb.append(",");
		sb.append(getPayDate() == null ? "" : sdf.format(getPayDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getApplicant() == null ? "" : getApplicant());
		sb.append(",");
		sb.append(getApplyTime() == null ? "" : sdf.format(getApplyTime()));
		sb.append(",");
		sb.append(getState() == null ? "" : getState());
		sb.append(",");
		sb.append(getAuditor() == null ? "" : getAuditor());
		sb.append(",");
		sb.append(getAuditingTime() == null ? "" : sdf.format(getAuditingTime()));
		sb.append(",");
		sb.append(getOpinion() == null ? "" : getOpinion());
		sb.append(",");
		sb.append(getIsLevelTwo() == null ? "" : getIsLevelTwo());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBonusPaymentAttentionOfWorkflow o) {
		return __system_process_attention_id == null ? -1 : __system_process_attention_id.compareTo(o.getSystemProcessAttentionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__system_process_attention_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__back_view_name);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_create_time);
		hash = 97 * hash + Objects.hashCode(this.__instance_activity_start_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__process_comment);
		hash = 97 * hash + Objects.hashCode(this.__bonus_payment_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__pay_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__applicant);
		hash = 97 * hash + Objects.hashCode(this.__apply_time);
		hash = 97 * hash + Objects.hashCode(this.__state);
		hash = 97 * hash + Objects.hashCode(this.__auditor);
		hash = 97 * hash + Objects.hashCode(this.__auditing_time);
		hash = 97 * hash + Objects.hashCode(this.__opinion);
		hash = 97 * hash + Objects.hashCode(this.__is_level_two);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBonusPaymentAttentionOfWorkflow o = (BaseBonusPaymentAttentionOfWorkflow)obj;
		if(!Objects.equals(this.__system_process_attention_id, o.getSystemProcessAttentionId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_activity_id, o.getProcessActivityId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__back_view_name, o.getBackViewName())) return false;
		if(!Objects.equals(this.__instance_activity_id, o.getInstanceActivityId())) return false;
		if(!Objects.equals(this.__instance_activity_create_time, o.getInstanceActivityCreateTime())) return false;
		if(!Objects.equals(this.__instance_activity_start_time, o.getInstanceActivityStartTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__process_comment, o.getProcessComment())) return false;
		if(!Objects.equals(this.__bonus_payment_record_id, o.getBonusPaymentRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__pay_integral, o.getPayIntegral())) return false;
		if(!Objects.equals(this.__pay_date, o.getPayDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__applicant, o.getApplicant())) return false;
		if(!Objects.equals(this.__apply_time, o.getApplyTime())) return false;
		if(!Objects.equals(this.__state, o.getState())) return false;
		if(!Objects.equals(this.__auditor, o.getAuditor())) return false;
		if(!Objects.equals(this.__auditing_time, o.getAuditingTime())) return false;
		if(!Objects.equals(this.__opinion, o.getOpinion())) return false;
		if(!Objects.equals(this.__is_level_two, o.getIsLevelTwo())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSystemProcessAttentionId() != null) sb.append(__wrapNumber(count++, "systemProcessAttentionId", getSystemProcessAttentionId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessActivityId() != null) sb.append(__wrapNumber(count++, "processActivityId", getProcessActivityId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getBackViewName() != null) sb.append(__wrapString(count++, "backViewName", getBackViewName()));
		if(getInstanceActivityId() != null) sb.append(__wrapNumber(count++, "instanceActivityId", getInstanceActivityId()));
		if(getInstanceActivityCreateTime() != null) sb.append(__wrapDate(count++, "instanceActivityCreateTime", getInstanceActivityCreateTime()));
		if(getInstanceActivityStartTime() != null) sb.append(__wrapDate(count++, "instanceActivityStartTime", getInstanceActivityStartTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getProcessComment() != null) sb.append(__wrapString(count++, "processComment", getProcessComment()));
		if(getBonusPaymentRecordId() != null) sb.append(__wrapNumber(count++, "bonusPaymentRecordId", getBonusPaymentRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPayIntegral() != null) sb.append(__wrapDecimal(count++, "payIntegral", getPayIntegral()));
		if(getPayDate() != null) sb.append(__wrapDate(count++, "payDate", getPayDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getApplicant() != null) sb.append(__wrapNumber(count++, "applicant", getApplicant()));
		if(getApplyTime() != null) sb.append(__wrapDate(count++, "applyTime", getApplyTime()));
		if(getState() != null) sb.append(__wrapNumber(count++, "state", getState()));
		if(getAuditor() != null) sb.append(__wrapNumber(count++, "auditor", getAuditor()));
		if(getAuditingTime() != null) sb.append(__wrapDate(count++, "auditingTime", getAuditingTime()));
		if(getOpinion() != null) sb.append(__wrapString(count++, "opinion", getOpinion()));
		if(getIsLevelTwo() != null) sb.append(__wrapBoolean(count++, "isLevelTwo", getIsLevelTwo()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSystemProcessAttentionId() != null) res.put("systemProcessAttentionId", getSystemProcessAttentionId());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getProcessActivityId() != null) res.put("processActivityId", getProcessActivityId());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getBackViewName() != null) res.put("backViewName", getBackViewName());
		if(getInstanceActivityId() != null) res.put("instanceActivityId", getInstanceActivityId());
		if(getInstanceActivityCreateTime() != null) res.put("instanceActivityCreateTime", getInstanceActivityCreateTime());
		if(getInstanceActivityStartTime() != null) res.put("instanceActivityStartTime", getInstanceActivityStartTime());
		if(getStatus() != null) res.put("status", getStatus());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getProcessComment() != null) res.put("processComment", getProcessComment());
		if(getBonusPaymentRecordId() != null) res.put("bonusPaymentRecordId", getBonusPaymentRecordId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getPayIntegral() != null) res.put("payIntegral", getPayIntegral());
		if(getPayDate() != null) res.put("payDate", getPayDate());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getApplicant() != null) res.put("applicant", getApplicant());
		if(getApplyTime() != null) res.put("applyTime", getApplyTime());
		if(getState() != null) res.put("state", getState());
		if(getAuditor() != null) res.put("auditor", getAuditor());
		if(getAuditingTime() != null) res.put("auditingTime", getAuditingTime());
		if(getOpinion() != null) res.put("opinion", getOpinion());
		if(getIsLevelTwo() != null) res.put("isLevelTwo", getIsLevelTwo());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("systemProcessAttentionId")) != null) setSystemProcessAttentionId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processActivityId")) != null) setProcessActivityId(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("backViewName")) != null) setBackViewName(__getString(val));
		if((val = values.get("instanceActivityId")) != null) setInstanceActivityId(__getInt(val)); 
		if((val = values.get("instanceActivityCreateTime")) != null) setInstanceActivityCreateTime(__getDate(val)); 
		if((val = values.get("instanceActivityStartTime")) != null) setInstanceActivityStartTime(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("processComment")) != null) setProcessComment(__getString(val));
		if((val = values.get("bonusPaymentRecordId")) != null) setBonusPaymentRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("payIntegral")) != null) setPayIntegral(__getDecimal(val));  
		if((val = values.get("payDate")) != null) setPayDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("applicant")) != null) setApplicant(__getInt(val)); 
		if((val = values.get("applyTime")) != null) setApplyTime(__getDate(val)); 
		if((val = values.get("state")) != null) setState(__getInt(val)); 
		if((val = values.get("auditor")) != null) setAuditor(__getInt(val)); 
		if((val = values.get("auditingTime")) != null) setAuditingTime(__getDate(val)); 
		if((val = values.get("opinion")) != null) setOpinion(__getString(val));
		if((val = values.get("isLevelTwo")) != null) setIsLevelTwo(__getBoolean(val));
	}

	protected java.lang.Integer  __system_process_attention_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_activity_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.String  __back_view_name ;
	protected java.lang.Integer  __instance_activity_id ;
	protected java.util.Date  __instance_activity_create_time ;
	protected java.util.Date  __instance_activity_start_time ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __process_type ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __process_comment ;
	protected java.lang.Integer  __bonus_payment_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __pay_integral ;
	protected java.util.Date  __pay_date ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __applicant ;
	protected java.util.Date  __apply_time ;
	protected java.lang.Integer  __state ;
	protected java.lang.Integer  __auditor ;
	protected java.util.Date  __auditing_time ;
	protected java.lang.String  __opinion ;
	protected java.lang.Boolean  __is_level_two ;
}
