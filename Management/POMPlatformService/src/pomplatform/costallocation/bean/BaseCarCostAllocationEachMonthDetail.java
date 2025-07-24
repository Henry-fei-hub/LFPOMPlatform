package pomplatform.costallocation.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCarCostAllocationEachMonthDetail extends GenericBase implements BaseFactory<BaseCarCostAllocationEachMonthDetail>, Comparable<BaseCarCostAllocationEachMonthDetail> 
{


	public static BaseCarCostAllocationEachMonthDetail newInstance(){
		return new BaseCarCostAllocationEachMonthDetail();
	}

	@Override
	public BaseCarCostAllocationEachMonthDetail make(){
		BaseCarCostAllocationEachMonthDetail b = new BaseCarCostAllocationEachMonthDetail();
		return b;
	}

	public final static java.lang.String CS_DRAFTER = "drafter" ;
	public final static java.lang.String CS_PROJECT_CODE = "project_code" ;
	public final static java.lang.String CS_START_DATE_DETAIL = "start_date_detail" ;
	public final static java.lang.String CS_ID = "id" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_COST_ALLOCATION = "cost_allocation" ;

	public final static java.lang.String ALL_CAPTIONS = "申请人,目的地,用车类型,编号,费用承担主体,出行时间,用车成本";

	public java.lang.Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( java.lang.Integer value ) {
		this.__drafter = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getStartDateDetail() {
		return this.__start_date_detail;
	}

	public void setStartDateDetail( java.lang.Integer value ) {
		this.__start_date_detail = value;
	}

	public java.lang.Integer getId() {
		return this.__id;
	}

	public void setId( java.lang.Integer value ) {
		this.__id = value;
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

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.math.BigDecimal getCostAllocation() {
		return this.__cost_allocation;
	}

	public void setCostAllocation( java.math.BigDecimal value ) {
		this.__cost_allocation = value;
	}

	public java.lang.Integer getProcessId() {
		return __process_id;
	}

	public void setProcessId(java.lang.Integer process_id) {
		this.__process_id = process_id;
	}

	public java.lang.Integer getProcessInstanceId() {
		return __process_instance_id;
	}

	public void setProcessInstanceId(java.lang.Integer process_instance_id) {
		this.__process_instance_id = process_instance_id;
	}

	public java.lang.Integer getProcessType() {
		return __process_type;
	}

	public void setProcessType(java.lang.Integer process_type) {
		this.__process_type = process_type;
	}

	public java.lang.Integer getBusinessId() {
		return __business_id;
	}

	public void setBusinessId(java.lang.Integer business_id) {
		this.__business_id = business_id;
	}

	public void cloneCopy(BaseCarCostAllocationEachMonthDetail __bean){
		__bean.setDrafter(getDrafter());
		__bean.setProjectCode(getProjectCode());
		__bean.setStartDateDetail(getStartDateDetail());
		__bean.setId(getId());
		__bean.setCode(getCode());
		__bean.setName(getName());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setCostAllocation(getCostAllocation());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
	}

	public java.lang.String toCSVString() {

		StringBuilder sb = new StringBuilder();
		String strDrafter = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getDrafter()));
		sb.append(strDrafter == null ? "" : strDrafter);
		sb.append(",");
		sb.append(getProjectCode() == null ? "" : getProjectCode());
		sb.append(",");
		String strStartDateDetail = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_119", String.valueOf(getStartDateDetail()));
		sb.append(strStartDateDetail == null ? "" : strStartDateDetail);
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : DATE_SDF.format(getCompleteTime()));
		sb.append(",");
		sb.append(getCostAllocation() == null ? "" : getCostAllocation());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCarCostAllocationEachMonthDetail o) {
		return __drafter == null ? -1 : __drafter.compareTo(o.getDrafter());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__drafter);
		hash = 97 * hash + Objects.hashCode(this.__project_code);
		hash = 97 * hash + Objects.hashCode(this.__start_date_detail);
		hash = 97 * hash + Objects.hashCode(this.__id);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__cost_allocation);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCarCostAllocationEachMonthDetail o = (BaseCarCostAllocationEachMonthDetail)obj;
		if(!Objects.equals(this.__drafter, o.getDrafter())) return false;
		if(!Objects.equals(this.__project_code, o.getProjectCode())) return false;
		if(!Objects.equals(this.__start_date_detail, o.getStartDateDetail())) return false;
		if(!Objects.equals(this.__id, o.getId())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__cost_allocation, o.getCostAllocation())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDrafter() != null) sb.append(__wrapNumber(count++, "drafter", getDrafter()));
		if(getProjectCode() != null) sb.append(__wrapString(count++, "projectCode", getProjectCode()));
		if(getStartDateDetail() != null) sb.append(__wrapNumber(count++, "startDateDetail", getStartDateDetail()));
		if(getId() != null) sb.append(__wrapNumber(count++, "id", getId()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getCostAllocation() != null) sb.append(__wrapDecimal(count++, "costAllocation", getCostAllocation()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("startDateDetail")) != null) setStartDateDetail(__getInt(val)); 
		if((val = values.get("id")) != null) setId(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("costAllocation")) != null) setCostAllocation(__getDecimal(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
	}

	protected java.lang.Integer  __drafter ;
	protected java.lang.String  __project_code ;
	protected java.lang.Integer  __start_date_detail ;
	protected java.lang.Integer  __id ;
	protected java.lang.String  __code ;
	protected java.lang.String  __name ;
	protected java.util.Date  __complete_time ;
	protected java.math.BigDecimal  __cost_allocation ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
}
