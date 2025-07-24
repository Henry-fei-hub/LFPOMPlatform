package pomplatform.salary.bean;

import delicacy.common.GenericCondition;

import java.util.Map;

public class ConditionCalculateAnnualLeave extends GenericCondition{

	public ConditionCalculateAnnualLeave(){
		setParameterCount(6);
	}

	public String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( Integer value ) {
		this.__department_id = value;
	}

	public Double getCurrentRemainingAmountAnnual() {
		return this.__current_remaining_amount_annual;
	}

	public void setCurrentRemainingAmountAnnual( Double value ) {
		this.__current_remaining_amount_annual = value;
	}

	public Double getCurrentRemainingAmountWealfare() {
		return this.__current_remaining_amount_wealfare;
	}

	public void setCurrentRemainingAmountWealfare( Double value ) {
		this.__current_remaining_amount_wealfare = value;
	}

	public Double getLastRemainingAmountAnnual() {
		return this.__last_remaining_amount_annual;
	}

	public void setLastRemainingAmountAnnual( Double value ) {
		this.__last_remaining_amount_annual = value;
	}

	public Double getLastRemainingAmountWealfare() {
		return this.__last_remaining_amount_wealfare;
	}

	public void setLastRemainingAmountWealfare( Double value ) {
		this.__last_remaining_amount_wealfare = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getCurrentRemainingAmountAnnual() != null) sb.append(__wrapNumber(1, "currentRemainingAmountAnnual", getCurrentRemainingAmountAnnual()));
		if(getCurrentRemainingAmountWealfare() != null) sb.append(__wrapNumber(1, "currentRemainingAmountWealfare", getCurrentRemainingAmountWealfare()));
		if(getLastRemainingAmountAnnual() != null) sb.append(__wrapNumber(1, "lastRemainingAmountAnnual", getLastRemainingAmountAnnual()));
		if(getLastRemainingAmountWealfare() != null) sb.append(__wrapNumber(1, "lastRemainingAmountWealfare", getLastRemainingAmountWealfare()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val));
		if((val = values.get("currentRemainingAmountAnnual")) != null) setCurrentRemainingAmountAnnual(__getDouble(val));
		if((val = values.get("currentRemainingAmountWealfare")) != null) setCurrentRemainingAmountWealfare(__getDouble(val));
		if((val = values.get("lastRemainingAmountAnnual")) != null) setLastRemainingAmountAnnual(__getDouble(val));
		if((val = values.get("lastRemainingAmountWealfare")) != null) setLastRemainingAmountWealfare(__getDouble(val));
	}

	private String __employee_name = null;
	private Integer __department_id = null;
	private Double __current_remaining_amount_annual = null;
	private Double __current_remaining_amount_wealfare = null;
	private Double __last_remaining_amount_annual = null;
	private Double __last_remaining_amount_wealfare = null;
}

