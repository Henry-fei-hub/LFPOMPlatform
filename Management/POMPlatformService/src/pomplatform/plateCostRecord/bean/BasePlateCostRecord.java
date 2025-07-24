package pomplatform.plateCostRecord.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePlateCostRecord extends GenericBase implements BaseFactory<BasePlateCostRecord>, Comparable<BasePlateCostRecord> 
{


	public static BasePlateCostRecord newInstance(){
		return new BasePlateCostRecord();
	}

	@Override
	public BasePlateCostRecord make(){
		BasePlateCostRecord b = new BasePlateCostRecord();
		return b;
	}

	public final static java.lang.String CS_PLATE_COST_RECORD_ID = "plate_cost_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_COST_INTEGRAL = "cost_integral" ;
	public final static java.lang.String CS_SALARY_INTEGRAL = "salary_integral" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_IS_SETTLEMENT = "is_settlement" ;
	public final static java.lang.String CS_COST_DATE = "cost_date" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,板块,运营成本,人工成本,备注,是否结算,日期,流程类型编码,业务编码,流程定义编码,流程实例编码";

	public java.lang.Integer getPlateCostRecordId() {
		return this.__plate_cost_record_id;
	}

	public void setPlateCostRecordId( java.lang.Integer value ) {
		this.__plate_cost_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getCostIntegral() {
		return this.__cost_integral;
	}

	public void setCostIntegral( java.math.BigDecimal value ) {
		this.__cost_integral = value;
	}

	public java.math.BigDecimal getSalaryIntegral() {
		return this.__salary_integral;
	}

	public void setSalaryIntegral( java.math.BigDecimal value ) {
		this.__salary_integral = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Boolean getIsSettlement() {
		return this.__is_settlement;
	}

	public void setIsSettlement( java.lang.Boolean value ) {
		this.__is_settlement = value;
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

	public void cloneCopy(BasePlateCostRecord __bean){
		__bean.setPlateCostRecordId(getPlateCostRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setCostIntegral(getCostIntegral());
		__bean.setSalaryIntegral(getSalaryIntegral());
		__bean.setRemark(getRemark());
		__bean.setIsSettlement(getIsSettlement());
		__bean.setCostDate(getCostDate());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateCostRecordId() == null ? "" : getPlateCostRecordId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getCostIntegral() == null ? "" : getCostIntegral());
		sb.append(",");
		sb.append(getSalaryIntegral() == null ? "" : getSalaryIntegral());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getIsSettlement() == null ? "" : getIsSettlement());
		sb.append(",");
		sb.append(getCostDate() == null ? "" : sdf.format(getCostDate()));
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateCostRecord o) {
		return __plate_cost_record_id == null ? -1 : __plate_cost_record_id.compareTo(o.getPlateCostRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_cost_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__cost_integral);
		hash = 97 * hash + Objects.hashCode(this.__salary_integral);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__is_settlement);
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
		final BasePlateCostRecord o = (BasePlateCostRecord)obj;
		if(!Objects.equals(this.__plate_cost_record_id, o.getPlateCostRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__cost_integral, o.getCostIntegral())) return false;
		if(!Objects.equals(this.__salary_integral, o.getSalaryIntegral())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__is_settlement, o.getIsSettlement())) return false;
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
		if(getPlateCostRecordId() != null) sb.append(__wrapNumber(count++, "plateCostRecordId", getPlateCostRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getCostIntegral() != null) sb.append(__wrapDecimal(count++, "costIntegral", getCostIntegral()));
		if(getSalaryIntegral() != null) sb.append(__wrapDecimal(count++, "salaryIntegral", getSalaryIntegral()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getIsSettlement() != null) sb.append(__wrapBoolean(count++, "isSettlement", getIsSettlement()));
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
		if((val = values.get("plateCostRecordId")) != null) setPlateCostRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("costIntegral")) != null) setCostIntegral(__getDecimal(val));  
		if((val = values.get("salaryIntegral")) != null) setSalaryIntegral(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("isSettlement")) != null) setIsSettlement(__getBoolean(val));
		if((val = values.get("costDate")) != null) setCostDate(__getDate(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
	}

	protected java.lang.Integer  __plate_cost_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __cost_integral ;
	protected java.math.BigDecimal  __salary_integral ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __is_settlement ;
	protected java.util.Date  __cost_date ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
}
