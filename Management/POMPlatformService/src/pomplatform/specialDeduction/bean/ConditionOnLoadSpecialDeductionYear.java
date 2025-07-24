package pomplatform.specialDeduction.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadSpecialDeductionYear extends GenericCondition{

	public ConditionOnLoadSpecialDeductionYear(){
		setParameterCount(8);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getYear() {
		return this.__year;
	}

	public void setYear( java.lang.String value ) {
		this.__year = value;
	}

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
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

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getEndMonth() {
		return this.__end_month;
	}

	public void setEndMonth( java.lang.Integer value ) {
		this.__end_month = value;
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapString(1, "year", getYear()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(1, "isEnable", getIsEnable()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getEndMonth() != null) sb.append(__wrapNumber(1, "endMonth", getEndMonth()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(1, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getString(val));
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val)); 
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.String __year = null;
	private java.lang.Boolean __is_enable = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __end_month = null;
	private java.lang.Integer __special_deduction_type_id = null;
}

