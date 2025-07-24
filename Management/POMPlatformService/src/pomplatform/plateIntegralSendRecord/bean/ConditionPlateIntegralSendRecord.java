package pomplatform.plateIntegralSendRecord.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPlateIntegralSendRecord extends GenericCondition{

	public ConditionPlateIntegralSendRecord(){
		setParameterCount(5);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.util.Date getStartdate() {
		return this.__startdate;
	}

	public void setStartdate( java.util.Date value ) {
		this.__startdate = value;
	}

	public java.util.Date getEnddate() {
		return this.__enddate;
	}

	public void setEnddate( java.util.Date value ) {
		this.__enddate = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getStartdate() != null) sb.append(__wrapDate(1, "startdate", getStartdate()));
		if(getEnddate() != null) sb.append(__wrapDate(1, "enddate", getEnddate()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("startdate")) != null) setStartdate(__getDate(val)); 
		if((val = values.get("enddate")) != null) setEnddate(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
	}

	private java.lang.Integer __plate_id = null;
	private java.util.Date __startdate = null;
	private java.util.Date __enddate = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __employee_no = null;
}

