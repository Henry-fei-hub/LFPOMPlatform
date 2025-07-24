package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportCostDetail extends GenericBase implements BaseFactory<BaseReportCostDetail>, Comparable<BaseReportCostDetail> 
{


	public static BaseReportCostDetail newInstance(){
		return new BaseReportCostDetail();
	}

	@Override
	public BaseReportCostDetail make(){
		BaseReportCostDetail b = new BaseReportCostDetail();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_FEE_TYPE = "fee_type" ;
	public final static java.lang.String CS_BEAR_FEE_ID = "bear_fee_id" ;
	public final static java.lang.String CS_BEAR_FEE_CODE = "bear_fee_code" ;
	public final static java.lang.String CS_BEAR_FEE_NAME = "bear_fee_name" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_PROCESS_STATUS = "process_status" ;
	public final static java.lang.String CS_COST_STATUS = "cost_status" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_INPUT_TAX = "input_tax" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;
	public final static java.lang.String CS_SUB_TABLE_ID = "sub_table_id" ;
	public final static java.lang.String CS_TITLE = "title" ;

//	public final static java.lang.String ALL_CAPTIONS = "流程类型,业务编码,流程编码,流程编码,费用类型,,编号,费用承担主体,报销编号,申请人,申请时间,流程状态,结算状态,报销金额,进项税,成本,业务部门,完成时间,子表ID";
	public final static java.lang.String ALL_CAPTIONS = "流程类型,报销编号,主题,费用类型,编号,费用承担主体,业务部门,申请人,报销金额,进项税,成本,流程状态,结算状态,申请时间,完成时间";
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

	public java.lang.Integer getFeeType() {
		return this.__fee_type;
	}

	public void setFeeType( java.lang.Integer value ) {
		this.__fee_type = value;
	}

	public java.lang.Integer getBearFeeId() {
		return this.__bear_fee_id;
	}

	public void setBearFeeId( java.lang.Integer value ) {
		this.__bear_fee_id = value;
	}

	public java.lang.String getBearFeeCode() {
		return this.__bear_fee_code;
	}

	public void setBearFeeCode( java.lang.String value ) {
		this.__bear_fee_code = value;
	}

	public java.lang.String getBearFeeName() {
		return this.__bear_fee_name;
	}

	public void setBearFeeName( java.lang.String value ) {
		this.__bear_fee_name = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
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

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	public java.lang.Integer getCostStatus() {
		return this.__cost_status;
	}

	public void setCostStatus( java.lang.Integer value ) {
		this.__cost_status = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getInputTax() {
		return this.__input_tax;
	}

	public void setInputTax( java.math.BigDecimal value ) {
		this.__input_tax = value;
	}

	public java.math.BigDecimal getFinalAmount() {
		return this.__final_amount;
	}

	public void setFinalAmount( java.math.BigDecimal value ) {
		this.__final_amount = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public java.lang.Integer getSubTableId() {
		return this.__sub_table_id;
	}

	public void setSubTableId( java.lang.Integer value ) {
		this.__sub_table_id = value;
	}

	public java.lang.String getTitle() {
		return __title;
	}

	public void setTitle(java.lang.String title) {
		this.__title = title;
	}

	public void cloneCopy(BaseReportCostDetail __bean){
		__bean.setProcessType(getProcessType());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setFeeType(getFeeType());
		__bean.setBearFeeId(getBearFeeId());
		__bean.setBearFeeCode(getBearFeeCode());
		__bean.setBearFeeName(getBearFeeName());
		__bean.setCode(getCode());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setProcessStatus(getProcessStatus());
		__bean.setCostStatus(getCostStatus());
		__bean.setAmount(getAmount());
		__bean.setInputTax(getInputTax());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setPlateId(getPlateId());
		__bean.setCompleteTime(getCompleteTime());
		__bean.setSubTableId(getSubTableId());
		__bean.setTitle(getTitle());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getTitle() == null ? "" : getTitle());
		sb.append(",");
		String strFeeType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_121", String.valueOf(getFeeType()));
		sb.append(strFeeType == null ? "" : strFeeType);
		sb.append(",");
		sb.append(getBearFeeCode() == null ? "" : getBearFeeCode());
		sb.append(",");
		sb.append(getBearFeeName() == null ? "" : getBearFeeName());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		String strProcessStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_120", String.valueOf(getProcessStatus()));
		sb.append(strProcessStatus == null ? "" : strProcessStatus);
		sb.append(",");
		String strCostStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_16", String.valueOf(getCostStatus()));
		sb.append(strCostStatus == null ? "" : strCostStatus);
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportCostDetail o) {
		return __process_type == null ? -1 : __process_type.compareTo(o.getProcessType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__fee_type);
		hash = 97 * hash + Objects.hashCode(this.__bear_fee_id);
		hash = 97 * hash + Objects.hashCode(this.__bear_fee_code);
		hash = 97 * hash + Objects.hashCode(this.__bear_fee_name);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__process_status);
		hash = 97 * hash + Objects.hashCode(this.__cost_status);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		hash = 97 * hash + Objects.hashCode(this.__sub_table_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportCostDetail o = (BaseReportCostDetail)obj;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__fee_type, o.getFeeType())) return false;
		if(!Objects.equals(this.__bear_fee_id, o.getBearFeeId())) return false;
		if(!Objects.equals(this.__bear_fee_code, o.getBearFeeCode())) return false;
		if(!Objects.equals(this.__bear_fee_name, o.getBearFeeName())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__process_status, o.getProcessStatus())) return false;
		if(!Objects.equals(this.__cost_status, o.getCostStatus())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		if(!Objects.equals(this.__sub_table_id, o.getSubTableId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getFeeType() != null) sb.append(__wrapNumber(count++, "feeType", getFeeType()));
		if(getBearFeeId() != null) sb.append(__wrapNumber(count++, "bearFeeId", getBearFeeId()));
		if(getBearFeeCode() != null) sb.append(__wrapString(count++, "bearFeeCode", getBearFeeCode()));
		if(getBearFeeName() != null) sb.append(__wrapString(count++, "bearFeeName", getBearFeeName()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(count++, "processStatus", getProcessStatus()));
		if(getCostStatus() != null) sb.append(__wrapNumber(count++, "costStatus", getCostStatus()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getInputTax() != null) sb.append(__wrapDecimal(count++, "inputTax", getInputTax()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		if(getSubTableId() != null) sb.append(__wrapNumber(count++, "subTableId", getSubTableId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("feeType")) != null) setFeeType(__getInt(val)); 
		if((val = values.get("bearFeeId")) != null) setBearFeeId(__getInt(val)); 
		if((val = values.get("bearFeeCode")) != null) setBearFeeCode(__getString(val));
		if((val = values.get("bearFeeName")) != null) setBearFeeName(__getString(val));
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
		if((val = values.get("costStatus")) != null) setCostStatus(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("inputTax")) != null) setInputTax(__getDecimal(val));  
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
		if((val = values.get("subTableId")) != null) setSubTableId(__getInt(val)); 
	}

	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __fee_type ;
	protected java.lang.Integer  __bear_fee_id ;
	protected java.lang.String  __bear_fee_code ;
	protected java.lang.String  __bear_fee_name ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __process_status ;
	protected java.lang.Integer  __cost_status ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.lang.Integer  __plate_id ;
	protected java.util.Date  __complete_time ;
	protected java.lang.Integer  __sub_table_id ;
	protected java.lang.String  __title ;
}
