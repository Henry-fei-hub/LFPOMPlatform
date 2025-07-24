package pomplatform.payment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionResidualwageData extends GenericCondition{

	public ConditionResidualwageData(){
		setParameterCount(5);
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

	public java.lang.Integer getCompanyid() {
		return this.__companyid;
	}

	public void setCompanyid( java.lang.Integer value ) {
		this.__companyid = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getCompanyid() != null) sb.append(__wrapNumber(1, "companyid", getCompanyid()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("companyid")) != null) setCompanyid(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
	}

	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __companyid = null;
	private java.lang.String __employee_no = null;
	private java.lang.String __employee_name = null;
}

