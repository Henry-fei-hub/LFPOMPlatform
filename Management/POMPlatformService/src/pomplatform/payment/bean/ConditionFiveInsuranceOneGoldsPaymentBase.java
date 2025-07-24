package pomplatform.payment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionFiveInsuranceOneGoldsPaymentBase extends GenericCondition{

	public ConditionFiveInsuranceOneGoldsPaymentBase(){
		setParameterCount(6);
	}

	public String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( String value ) {
		this.__employee_no = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( Integer value ) {
		this.__company_id = value;
	}

	public Integer getYear() {
		return this.__year;
	}

	public void setYear( Integer value ) {
		this.__year = value;
	}

	public Integer getStartMonth() {
		return this.__start_month;
	}

	public void setStartMonth( Integer value ) {
		this.__start_month = value;
	}

	public Integer getEndMonth() {
		return this.__end_month;
	}

	public void setEndMonth( Integer value ) {
		this.__end_month = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getStartMonth() != null) sb.append(__wrapNumber(1, "startMonth", getStartMonth()));
		if(getEndMonth() != null) sb.append(__wrapNumber(1, "endMonth", getEndMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("startMonth")) != null) setStartMonth(__getInt(val)); 
		if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val)); 
	}

	private String __employee_no = null;
	private Integer __employee_id = null;
	private Integer __company_id = null;
	private Integer __year = null;
	private Integer __start_month = null;
	private Integer __end_month = null;
}

