package pomplatform.specialDeduction.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnCheckSpecialDeduction extends GenericBase implements BaseFactory<BaseOnCheckSpecialDeduction>, Comparable<BaseOnCheckSpecialDeduction> 
{


	public static BaseOnCheckSpecialDeduction newInstance(){
		return new BaseOnCheckSpecialDeduction();
	}

	@Override
	public BaseOnCheckSpecialDeduction make(){
		BaseOnCheckSpecialDeduction b = new BaseOnCheckSpecialDeduction();
		return b;
	}

	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ACTIVITY_ID = "process_instance_activity_id" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_OTHER_OPERATION = "other_operation" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_SPECIAL_DEDUCTION_TYPE_ID = "special_deduction_type_id" ;
	public final static java.lang.String CS_CREATE_DATE = "create_date" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,流程类型,业务编码,业务名称,流程编码,活动实列编码,流程状态 0 发起中  1,创建人,创建时间,完成时间,删除状态  0未删除    1已删除,流程走完之后，是否执行了其他操作   0未执行   1已执行,金额(基数),专项类型,创建时间,有效开始时间,有效结束时间";

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

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getOtherOperation() {
		return this.__other_operation;
	}

	public void setOtherOperation( java.lang.Integer value ) {
		this.__other_operation = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	public java.util.Date getCreateDate() {
		return this.__create_date;
	}

	public void setCreateDate( java.util.Date value ) {
		this.__create_date = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public void cloneCopy(BaseOnCheckSpecialDeduction __bean){
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setBusinessName(getBusinessName());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceActivityId(getProcessInstanceActivityId());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setOtherOperation(getOtherOperation());
		__bean.setAmount(getAmount());
		__bean.setSpecialDeductionTypeId(getSpecialDeductionTypeId());
		__bean.setCreateDate(getCreateDate());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceActivityId() == null ? "" : getProcessInstanceActivityId());
		sb.append(",");
		sb.append(getProcessStatus() == null ? "" : getProcessStatus());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getOtherOperation() == null ? "" : getOtherOperation());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getSpecialDeductionTypeId() == null ? "" : getSpecialDeductionTypeId());
		sb.append(",");
		sb.append(getCreateDate() == null ? "" : sdf.format(getCreateDate()));
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnCheckSpecialDeduction o) {
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
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__other_operation);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__special_deduction_type_id);
		hash = 97 * hash + Objects.hashCode(this.__create_date);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnCheckSpecialDeduction o = (BaseOnCheckSpecialDeduction)obj;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_activity_id, o.getProcessInstanceActivityId())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__other_operation, o.getOtherOperation())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__special_deduction_type_id, o.getSpecialDeductionTypeId())) return false;
		if(!Objects.equals(this.__create_date, o.getCreateDate())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
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
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getOtherOperation() != null) sb.append(__wrapNumber(count++, "otherOperation", getOtherOperation()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(count++, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		if(getCreateDate() != null) sb.append(__wrapDate(count++, "createDate", getCreateDate()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getProcessInstanceId() != null) res.put("processInstanceId", getProcessInstanceId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getBusinessName() != null) res.put("businessName", getBusinessName());
		if(getProcessId() != null) res.put("processId", getProcessId());
		if(getProcessInstanceActivityId() != null) res.put("processInstanceActivityId", getProcessInstanceActivityId());
		if(getProcessStatus() != null) res.put("processStatus", getProcessStatus());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getOtherOperation() != null) res.put("otherOperation", getOtherOperation());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getSpecialDeductionTypeId() != null) res.put("specialDeductionTypeId", getSpecialDeductionTypeId());
		if(getCreateDate() != null) res.put("createDate", getCreateDate());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		return res;
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
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("otherOperation")) != null) setOtherOperation(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
		if((val = values.get("createDate")) != null) setCreateDate(__getDate(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
	}

	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.String  __business_name ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_activity_id ;
	protected java.lang.Integer  __process_status ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __other_operation ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __special_deduction_type_id ;
	protected java.util.Date  __create_date ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
}
