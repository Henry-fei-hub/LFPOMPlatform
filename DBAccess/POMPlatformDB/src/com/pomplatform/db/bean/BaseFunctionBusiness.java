package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseFunctionBusiness extends GenericBase implements BaseFactory<BaseFunctionBusiness>, Comparable<BaseFunctionBusiness> 
{


	public static BaseFunctionBusiness newInstance(){
		return new BaseFunctionBusiness();
	}

	@Override
	public BaseFunctionBusiness make(){
		BaseFunctionBusiness b = new BaseFunctionBusiness();
		return b;
	}

	public final static java.lang.String CS_FUNCTION_BUSINESS_ID = "function_business_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_FUNCTION_ID = "function_id" ;
	public final static java.lang.String CS_FUNCTION_TYPE = "function_type" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_DAYS = "days" ;
	public final static java.lang.String CS_IS_COMPLETED = "is_completed" ;
	public final static java.lang.String CS_IS_FOREVER = "is_forever" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,主表编码,人员id,权限id,权限类型（1,erp权限,2,CWD权限),申请时间,结束时间,申请天数,流程是否完成,是否永久有效";

	public java.lang.Integer getFunctionBusinessId() {
		return this.__function_business_id;
	}

	public void setFunctionBusinessId( java.lang.Integer value ) {
		this.__function_business_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getFunctionId() {
		return this.__function_id;
	}

	public void setFunctionId( java.lang.Integer value ) {
		this.__function_id = value;
	}

	public java.lang.Integer getFunctionType() {
		return this.__function_type;
	}

	public void setFunctionType( java.lang.Integer value ) {
		this.__function_type = value;
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

	public java.math.BigDecimal getDays() {
		return this.__days;
	}

	public void setDays( java.math.BigDecimal value ) {
		this.__days = value;
	}

	public java.lang.Boolean getIsCompleted() {
		return this.__is_completed;
	}

	public void setIsCompleted( java.lang.Boolean value ) {
		this.__is_completed = value;
	}

	public java.lang.Boolean getIsForever() {
		return this.__is_forever;
	}

	public void setIsForever( java.lang.Boolean value ) {
		this.__is_forever = value;
	}

	public void cloneCopy(BaseFunctionBusiness __bean){
		__bean.setFunctionBusinessId(getFunctionBusinessId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setFunctionId(getFunctionId());
		__bean.setFunctionType(getFunctionType());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setDays(getDays());
		__bean.setIsCompleted(getIsCompleted());
		__bean.setIsForever(getIsForever());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFunctionBusinessId() == null ? "" : getFunctionBusinessId());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getFunctionId() == null ? "" : getFunctionId());
		sb.append(",");
		sb.append(getFunctionType() == null ? "" : getFunctionType());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getDays() == null ? "" : getDays());
		sb.append(",");
		sb.append(getIsCompleted() == null ? "" : getIsCompleted());
		sb.append(",");
		sb.append(getIsForever() == null ? "" : getIsForever());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFunctionBusiness o) {
		return __function_business_id == null ? -1 : __function_business_id.compareTo(o.getFunctionBusinessId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__function_business_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__function_id);
		hash = 97 * hash + Objects.hashCode(this.__function_type);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__is_completed);
		hash = 97 * hash + Objects.hashCode(this.__is_forever);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFunctionBusiness o = (BaseFunctionBusiness)obj;
		if(!Objects.equals(this.__function_business_id, o.getFunctionBusinessId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__function_id, o.getFunctionId())) return false;
		if(!Objects.equals(this.__function_type, o.getFunctionType())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__is_completed, o.getIsCompleted())) return false;
		if(!Objects.equals(this.__is_forever, o.getIsForever())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFunctionBusinessId() != null) sb.append(__wrapNumber(count++, "functionBusinessId", getFunctionBusinessId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getFunctionId() != null) sb.append(__wrapNumber(count++, "functionId", getFunctionId()));
		if(getFunctionType() != null) sb.append(__wrapNumber(count++, "functionType", getFunctionType()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getDays() != null) sb.append(__wrapDecimal(count++, "days", getDays()));
		if(getIsCompleted() != null) sb.append(__wrapBoolean(count++, "isCompleted", getIsCompleted()));
		if(getIsForever() != null) sb.append(__wrapBoolean(count++, "isForever", getIsForever()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFunctionBusinessId() != null) res.put("functionBusinessId", getFunctionBusinessId());
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getFunctionId() != null) res.put("functionId", getFunctionId());
		if(getFunctionType() != null) res.put("functionType", getFunctionType());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getDays() != null) res.put("days", getDays());
		if(getIsCompleted() != null) res.put("isCompleted", getIsCompleted());
		if(getIsForever() != null) res.put("isForever", getIsForever());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("functionBusinessId")) != null) setFunctionBusinessId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("functionId")) != null) setFunctionId(__getInt(val)); 
		if((val = values.get("functionType")) != null) setFunctionType(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("days")) != null) setDays(__getDecimal(val));  
		if((val = values.get("isCompleted")) != null) setIsCompleted(__getBoolean(val));
		if((val = values.get("isForever")) != null) setIsForever(__getBoolean(val));
	}

	protected java.lang.Integer  __function_business_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __function_id ;
	protected java.lang.Integer  __function_type ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.math.BigDecimal  __days ;
	protected java.lang.Boolean  __is_completed ;
	protected java.lang.Boolean  __is_forever ;
}
