package pomplatform.employeeAward.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnEmployeeIntegralBusiness extends GenericCondition{

	public ConditionOnEmployeeIntegralBusiness(){
		setParameterCount(5);
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

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getBusinessTypeName() {
		return this.__business_type_name == null ? null : (this.__business_type_name.indexOf("%") >= 0 ? this.__business_type_name : "%"+this.__business_type_name+"%");
	}

	public void setBusinessTypeName( java.lang.String value ) {
		this.__business_type_name = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}
	
	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getBusinessTypeName() != null) sb.append(__wrapString(1, "businessTypeName", getBusinessTypeName()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("businessTypeName")) != null) setBusinessTypeName(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __status = null;
	private java.lang.String __business_type_name = null;
	private java.lang.Integer __employee_id = null;
}

