package pomplatform.reimbursement.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetReimbursementCost extends GenericBase implements BaseFactory<BaseGetReimbursementCost>, Comparable<BaseGetReimbursementCost> 
{


	public static BaseGetReimbursementCost newInstance(){
		return new BaseGetReimbursementCost();
	}

	@Override
	public BaseGetReimbursementCost make(){
		BaseGetReimbursementCost b = new BaseGetReimbursementCost();
		return b;
	}

	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_COST_DATE = "cost_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_LINKED_ID = "linked_id" ;
	public final static java.lang.String CS_COST = "cost" ;
	public final static java.lang.String CS_CURRENCY = "currency" ;

	public final static java.lang.String ALL_CAPTIONS = "流程编码,主键编码,流程类型,业务编码,创建人,完成时间,备注,,成本,货币种类  0人民币   1港币   2美元";

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

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCostDate() {
		return this.__cost_date;
	}

	public void setCostDate( java.util.Date value ) {
		this.__cost_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getLinkedId() {
		return this.__linked_id;
	}

	public void setLinkedId( java.lang.Integer value ) {
		this.__linked_id = value;
	}

	public java.math.BigDecimal getCost() {
		return this.__cost;
	}

	public void setCost( java.math.BigDecimal value ) {
		this.__cost = value;
	}

	public java.lang.Integer getCurrency() {
		return this.__currency;
	}

	public void setCurrency( java.lang.Integer value ) {
		this.__currency = value;
	}

	public void cloneCopy(BaseGetReimbursementCost __bean){
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCostDate(getCostDate());
		__bean.setRemark(getRemark());
		__bean.setLinkedId(getLinkedId());
		__bean.setCost(getCost());
		__bean.setCurrency(getCurrency());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strBusinessId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getBusinessId()));
		sb.append(strBusinessId == null ? "" : strBusinessId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getCostDate() == null ? "" : sdf.format(getCostDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getLinkedId() == null ? "" : getLinkedId());
		sb.append(",");
		sb.append(getCost() == null ? "" : getCost());
		sb.append(",");
		String strCurrency = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_40", String.valueOf(getCurrency()));
		sb.append(strCurrency == null ? "" : strCurrency);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetReimbursementCost o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__cost_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__linked_id);
		hash = 97 * hash + Objects.hashCode(this.__cost);
		hash = 97 * hash + Objects.hashCode(this.__currency);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetReimbursementCost o = (BaseGetReimbursementCost)obj;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__cost_date, o.getCostDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__linked_id, o.getLinkedId())) return false;
		if(!Objects.equals(this.__cost, o.getCost())) return false;
		if(!Objects.equals(this.__currency, o.getCurrency())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCostDate() != null) sb.append(__wrapDate(count++, "costDate", getCostDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getLinkedId() != null) sb.append(__wrapNumber(count++, "linkedId", getLinkedId()));
		if(getCost() != null) sb.append(__wrapDecimal(count++, "cost", getCost()));
		if(getCurrency() != null) sb.append(__wrapNumber(count++, "currency", getCurrency()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("costDate")) != null) setCostDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("linkedId")) != null) setLinkedId(__getInt(val)); 
		if((val = values.get("cost")) != null) setCost(__getDecimal(val));  
		if((val = values.get("currency")) != null) setCurrency(__getInt(val)); 
	}

	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __cost_date ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __linked_id ;
	protected java.math.BigDecimal  __cost ;
	protected java.lang.Integer  __currency ;
}
