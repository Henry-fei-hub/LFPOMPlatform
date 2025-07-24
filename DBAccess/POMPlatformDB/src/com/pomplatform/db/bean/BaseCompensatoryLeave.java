package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCompensatoryLeave extends GenericBase implements BaseFactory<BaseCompensatoryLeave>, Comparable<BaseCompensatoryLeave> 
{


	public static BaseCompensatoryLeave newInstance(){
		return new BaseCompensatoryLeave();
	}

	@Override
	public BaseCompensatoryLeave make(){
		BaseCompensatoryLeave b = new BaseCompensatoryLeave();
		return b;
	}

	public final static java.lang.String CS_COMPENSATORY_LEAVE_ID = "compensatory_leave_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_TOTAL_COMPENSATORY_LEAVE = "total_compensatory_leave" ;

	public final static java.lang.String ALL_CAPTIONS = ",调休人员id,调休年份,调休月份,流程状态,流程主表id,调休试用总小时数";

	public java.lang.Integer getCompensatoryLeaveId() {
		return this.__compensatory_leave_id;
	}

	public void setCompensatoryLeaveId( java.lang.Integer value ) {
		this.__compensatory_leave_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.math.BigDecimal getTotalCompensatoryLeave() {
		return this.__total_compensatory_leave;
	}

	public void setTotalCompensatoryLeave( java.math.BigDecimal value ) {
		this.__total_compensatory_leave = value;
	}

	public void cloneCopy(BaseCompensatoryLeave __bean){
		__bean.setCompensatoryLeaveId(getCompensatoryLeaveId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setStatus(getStatus());
		__bean.setBusinessId(getBusinessId());
		__bean.setTotalCompensatoryLeave(getTotalCompensatoryLeave());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompensatoryLeaveId() == null ? "" : getCompensatoryLeaveId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getTotalCompensatoryLeave() == null ? "" : getTotalCompensatoryLeave());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompensatoryLeave o) {
		return __compensatory_leave_id == null ? -1 : __compensatory_leave_id.compareTo(o.getCompensatoryLeaveId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__compensatory_leave_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__total_compensatory_leave);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompensatoryLeave o = (BaseCompensatoryLeave)obj;
		if(!Objects.equals(this.__compensatory_leave_id, o.getCompensatoryLeaveId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__total_compensatory_leave, o.getTotalCompensatoryLeave())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompensatoryLeaveId() != null) sb.append(__wrapNumber(count++, "compensatoryLeaveId", getCompensatoryLeaveId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getTotalCompensatoryLeave() != null) sb.append(__wrapDecimal(count++, "totalCompensatoryLeave", getTotalCompensatoryLeave()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCompensatoryLeaveId() != null) res.put("compensatoryLeaveId", getCompensatoryLeaveId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getStatus() != null) res.put("status", getStatus());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getTotalCompensatoryLeave() != null) res.put("totalCompensatoryLeave", getTotalCompensatoryLeave());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("compensatoryLeaveId")) != null) setCompensatoryLeaveId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("totalCompensatoryLeave")) != null) setTotalCompensatoryLeave(__getDecimal(val));  
	}

	protected java.lang.Integer  __compensatory_leave_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __business_id ;
	protected java.math.BigDecimal  __total_compensatory_leave ;
}
