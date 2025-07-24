package pomplatform.projectReportRecordDetail.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSearchProjectCostSum extends GenericBase implements BaseFactory<BaseSearchProjectCostSum>, Comparable<BaseSearchProjectCostSum> 
{


	public static BaseSearchProjectCostSum newInstance(){
		return new BaseSearchProjectCostSum();
	}

	@Override
	public BaseSearchProjectCostSum make(){
		BaseSearchProjectCostSum b = new BaseSearchProjectCostSum();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_COST_TYPE = "cost_type" ;
	public final static java.lang.String CS_COST_DATE = "cost_date" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;

	public final static java.lang.String ALL_CAPTIONS = "经办人,金额,费用类型,日期,流程类型编码,业务编码,流程定义编码,流程实例编码";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.lang.Integer getCostType() {
		return this.__cost_type;
	}

	public void setCostType( java.lang.Integer value ) {
		this.__cost_type = value;
	}

	public java.util.Date getCostDate() {
		return this.__cost_date;
	}

	public void setCostDate( java.util.Date value ) {
		this.__cost_date = value;
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

	public void cloneCopy(BaseSearchProjectCostSum __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAmount(getAmount());
		__bean.setCostType(getCostType());
		__bean.setCostDate(getCostDate());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getCostType() == null ? "" : getCostType());
		sb.append(",");
		sb.append(getCostDate() == null ? "" : sdf.format(getCostDate()));
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		String strProcessInstanceId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getProcessInstanceId()));
		sb.append(strProcessInstanceId == null ? "" : strProcessInstanceId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSearchProjectCostSum o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__cost_type);
		hash = 97 * hash + Objects.hashCode(this.__cost_date);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSearchProjectCostSum o = (BaseSearchProjectCostSum)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__cost_type, o.getCostType())) return false;
		if(!Objects.equals(this.__cost_date, o.getCostDate())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getCostType() != null) sb.append(__wrapNumber(count++, "costType", getCostType()));
		if(getCostDate() != null) sb.append(__wrapDate(count++, "costDate", getCostDate()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("costType")) != null) setCostType(__getInt(val)); 
		if((val = values.get("costDate")) != null) setCostDate(__getDate(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __cost_type ;
	protected java.util.Date  __cost_date ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
}
