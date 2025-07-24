package pomplatform.workflow.operation.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadApplyListOfCostAllocation extends GenericBase implements BaseFactory<BaseOnLoadApplyListOfCostAllocation>, Comparable<BaseOnLoadApplyListOfCostAllocation> 
{


	public static BaseOnLoadApplyListOfCostAllocation newInstance(){
		return new BaseOnLoadApplyListOfCostAllocation();
	}

	@Override
	public BaseOnLoadApplyListOfCostAllocation make(){
		BaseOnLoadApplyListOfCostAllocation b = new BaseOnLoadApplyListOfCostAllocation();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_COST_TYPE = "cost_type" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_COST = "cost" ;
	public final static java.lang.String CS_DRAFTER = "drafter" ;
	public final static java.lang.String CS_REASON = "reason" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,流程类型,业务编码,业务名称,流程编码,活动实列编码,流程状态,创建时间,完成时间,原成本类型,编号,名称,成本,起草人,申请缘由";

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
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

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceActivityId() {
		return this.__process_instance_activity_id;
	}

	public void setProcessInstanceActivityId( java.lang.Integer value ) {
		this.__process_instance_activity_id = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getCostType() {
		return this.__cost_type;
	}

	public void setCostType( java.lang.Integer value ) {
		this.__cost_type = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.math.BigDecimal getCost() {
		return this.__cost;
	}

	public void setCost( java.math.BigDecimal value ) {
		this.__cost = value;
	}

	public java.lang.Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( java.lang.Integer value ) {
		this.__drafter = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public void cloneCopy(BaseOnLoadApplyListOfCostAllocation __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCreateTime(getCreateTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setCostType(getCostType());
		__bean.setCode(getCode());
		__bean.setName(getName());
		__bean.setCost(getCost());
		__bean.setDrafter(getDrafter());
		__bean.setReason(getReason());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		String strProcessStatus = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getProcessStatus()));
		sb.append(strProcessStatus == null ? "" : strProcessStatus);
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		String strCostType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_9", String.valueOf(getCostType()));
		sb.append(strCostType == null ? "" : strCostType);
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getCost() == null ? "" : getCost());
		sb.append(",");
		String strDrafter = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getDrafter()));
		sb.append(strDrafter == null ? "" : strDrafter);
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadApplyListOfCostAllocation o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_activity_id);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__cost_type);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadApplyListOfCostAllocation o = (BaseOnLoadApplyListOfCostAllocation)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__cost_type, o.getCostType())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceActivityId() != null) sb.append(__wrapNumber(count++, "processInstanceActivityId", getProcessInstanceActivityId()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getCostType() != null) sb.append(__wrapNumber(count++, "costType", getCostType()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceActivityId")) != null) setProcessInstanceActivityId(__getInt(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("costType")) != null) setCostType(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("reason")) != null) setReason(__getString(val));
	}

	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.lang.Integer  __process_status ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __cost_type ;
	protected java.lang.String  __code ;
	protected java.lang.String  __name ;
	protected java.math.BigDecimal  __cost ;
	protected java.lang.Integer  __drafter ;
	protected java.lang.String  __reason ;
}
