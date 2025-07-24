package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeViolationCharge extends GenericBase implements BaseFactory<BaseEmployeeViolationCharge>, Comparable<BaseEmployeeViolationCharge> 
{


	public static BaseEmployeeViolationCharge newInstance(){
		return new BaseEmployeeViolationCharge();
	}

	@Override
	public BaseEmployeeViolationCharge make(){
		BaseEmployeeViolationCharge b = new BaseEmployeeViolationCharge();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_VIOLATION_CHARGES_ID = "employee_violation_charges_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_VIOLATION_CHARGES = "violation_charges" ;
	public final static java.lang.String CS_VIOLATION_DATE = "violation_date" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_STATUS = "status" ;

	public final static java.lang.String ALL_CAPTIONS = ",员工,业务部门,项目违规金,违规日期,操作者,操作时间,备注,状态(1待处理,2已同意,3已拒绝)";

	public java.lang.Integer getEmployeeViolationChargesId() {
		return this.__employee_violation_charges_id;
	}

	public void setEmployeeViolationChargesId( java.lang.Integer value ) {
		this.__employee_violation_charges_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getViolationCharges() {
		return this.__violation_charges;
	}

	public void setViolationCharges( java.math.BigDecimal value ) {
		this.__violation_charges = value;
	}

	public java.util.Date getViolationDate() {
		return this.__violation_date;
	}

	public void setViolationDate( java.util.Date value ) {
		this.__violation_date = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public void cloneCopy(BaseEmployeeViolationCharge __bean){
		__bean.setEmployeeViolationChargesId(getEmployeeViolationChargesId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPlateId(getPlateId());
		__bean.setViolationCharges(getViolationCharges());
		__bean.setViolationDate(getViolationDate());
		__bean.setOperator(getOperator());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setStatus(getStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeViolationChargesId() == null ? "" : getEmployeeViolationChargesId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getViolationCharges() == null ? "" : getViolationCharges());
		sb.append(",");
		sb.append(getViolationDate() == null ? "" : sdf.format(getViolationDate()));
		sb.append(",");
		String strOperator = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary", String.valueOf(getOperator()));
		sb.append(strOperator == null ? "" : strOperator);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_61", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeViolationCharge o) {
		return __employee_violation_charges_id == null ? -1 : __employee_violation_charges_id.compareTo(o.getEmployeeViolationChargesId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_violation_charges_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__violation_charges);
		hash = 97 * hash + Objects.hashCode(this.__violation_date);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeViolationCharge o = (BaseEmployeeViolationCharge)obj;
		if(!Objects.equals(this.__employee_violation_charges_id, o.getEmployeeViolationChargesId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__violation_charges, o.getViolationCharges())) return false;
		if(!Objects.equals(this.__violation_date, o.getViolationDate())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeViolationChargesId() != null) sb.append(__wrapNumber(count++, "employeeViolationChargesId", getEmployeeViolationChargesId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getViolationCharges() != null) sb.append(__wrapDecimal(count++, "violationCharges", getViolationCharges()));
		if(getViolationDate() != null) sb.append(__wrapDate(count++, "violationDate", getViolationDate()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeViolationChargesId")) != null) setEmployeeViolationChargesId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("violationCharges")) != null) setViolationCharges(__getDecimal(val));  
		if((val = values.get("violationDate")) != null) setViolationDate(__getDate(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_violation_charges_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __violation_charges ;
	protected java.util.Date  __violation_date ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __status ;
}
