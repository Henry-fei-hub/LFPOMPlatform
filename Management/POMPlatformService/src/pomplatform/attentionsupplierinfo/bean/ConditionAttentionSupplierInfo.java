package pomplatform.attentionsupplierinfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAttentionSupplierInfo extends GenericCondition{

	public ConditionAttentionSupplierInfo(){
		setParameterCount(8);
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

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getSupplierName() {
		return this.__supplier_name == null ? null : (this.__supplier_name.indexOf("%") >= 0 ? this.__supplier_name : "%"+this.__supplier_name+"%");
	}

	public void setSupplierName( java.lang.String value ) {
		this.__supplier_name = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTimeStart() {
		return this.__operate_time_start;
	}

	public void setOperateTimeStart( java.util.Date value ) {
		this.__operate_time_start = value;
	}

	public java.util.Date getOperateTimeEnd() {
		return this.__operate_time_end;
	}

	public void setOperateTimeEnd( java.util.Date value ) {
		this.__operate_time_end = value;
	}

	public java.lang.Integer getAreasExpertise() {
		return this.__areas_expertise;
	}

	public void setAreasExpertise( java.lang.Integer value ) {
		this.__areas_expertise = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getSupplierName() != null) sb.append(__wrapString(1, "supplierName", getSupplierName()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTimeStart() != null) sb.append(__wrapDate(1, "operateTimeStart", getOperateTimeStart()));
		if(getOperateTimeEnd() != null) sb.append(__wrapDate(1, "operateTimeEnd", getOperateTimeEnd()));
		if(getAreasExpertise() != null) sb.append(__wrapNumber(1, "areasExpertise", getAreasExpertise()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTimeStart")) != null) setOperateTimeStart(__getDate(val)); 
		if((val = values.get("operateTimeEnd")) != null) setOperateTimeEnd(__getDate(val)); 
		if((val = values.get("areasExpertise")) != null) setAreasExpertise(__getInt(val)); 
	}

	private java.lang.Integer __status = null;
	private java.lang.Integer __process_type = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __supplier_name = null;
	private java.lang.Integer __operate_employee_id = null;
	private java.util.Date __operate_time_start = null;
	private java.util.Date __operate_time_end = null;
	private java.lang.Integer __areas_expertise = null;
}

