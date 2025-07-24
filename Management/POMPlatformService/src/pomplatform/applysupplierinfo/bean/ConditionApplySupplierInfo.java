package pomplatform.applysupplierinfo.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionApplySupplierInfo extends GenericCondition{

	public ConditionApplySupplierInfo(){
		setParameterCount(7);
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getSupplierName() {
		return this.__supplier_name == null ? null : (this.__supplier_name.indexOf("%") >= 0 ? this.__supplier_name : "%"+this.__supplier_name+"%");
	}

	public void setSupplierName( java.lang.String value ) {
		this.__supplier_name = value;
	}

	public java.util.Date getCreateTimeStart() {
		return this.__create_time_start;
	}

	public void setCreateTimeStart( java.util.Date value ) {
		this.__create_time_start = value;
	}

	public java.util.Date getCreateTimeEnd() {
		return this.__create_time_end;
	}

	public void setCreateTimeEnd( java.util.Date value ) {
		this.__create_time_end = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
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
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getSupplierName() != null) sb.append(__wrapString(1, "supplierName", getSupplierName()));
		if(getCreateTimeStart() != null) sb.append(__wrapDate(1, "createTimeStart", getCreateTimeStart()));
		if(getCreateTimeEnd() != null) sb.append(__wrapDate(1, "createTimeEnd", getCreateTimeEnd()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		if(getAreasExpertise() != null) sb.append(__wrapNumber(1, "areasExpertise", getAreasExpertise()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("createTimeStart")) != null) setCreateTimeStart(__getDate(val)); 
		if((val = values.get("createTimeEnd")) != null) setCreateTimeEnd(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("areasExpertise")) != null) setAreasExpertise(__getInt(val)); 
	}

	private java.lang.Integer __process_type = null;
	private java.lang.String __supplier_name = null;
	private java.util.Date __create_time_start = null;
	private java.util.Date __create_time_end = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __operate_employee_id = null;
	private java.lang.Integer __areas_expertise = null;
}

