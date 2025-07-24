package pomplatform.hr.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionEmployeeContractAttachment extends GenericCondition{

	public ConditionEmployeeContractAttachment(){
		setParameterCount(9);
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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getContractType() {
		return this.__contract_type;
	}

	public void setContractType( java.lang.Integer value ) {
		this.__contract_type = value;
	}

	public java.lang.Integer getSignType() {
		return this.__sign_type;
	}

	public void setSignType( java.lang.Integer value ) {
		this.__sign_type = value;
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

	public java.lang.Integer getWillEnd() {
		return this.__will_end;
	}

	public void setWillEnd( java.lang.Integer value ) {
		this.__will_end = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getContractType() != null) sb.append(__wrapNumber(1, "contractType", getContractType()));
		if(getSignType() != null) sb.append(__wrapNumber(1, "signType", getSignType()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getWillEnd() != null) sb.append(__wrapNumber(1, "willEnd", getWillEnd()));
		if(getWillEnd() != null) sb.append(__wrapNumber(1, "companyId", getWillEnd()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("contractType")) != null) setContractType(__getInt(val)); 
		if((val = values.get("signType")) != null) setSignType(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("willEnd")) != null) setWillEnd(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val));
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __contract_type = null;
	private java.lang.Integer __sign_type = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __will_end = null;
	private java.lang.Integer __company_id = null;
}

