package pomplatform.mcecscreeor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcecscreeor extends GenericCondition{

	public ConditionMcecscreeor(){
		setParameterCount(8);
	}

	public java.util.Date getMinCreateTime() {
		return this.__min_create_time;
	}

	public void setMinCreateTime( java.util.Date value ) {
		this.__min_create_time = value;
	}

	public java.util.Date getMaxCreateTime() {
		return this.__max_create_time;
	}

	public void setMaxCreateTime( java.util.Date value ) {
		this.__max_create_time = value;
	}

	public java.lang.Integer getContractCodeId() {
		return this.__contract_code_id;
	}

	public void setContractCodeId( java.lang.Integer value ) {
		this.__contract_code_id = value;
	}

	public java.lang.Integer getSignCompany() {
		return this.__sign_company;
	}

	public void setSignCompany( java.lang.Integer value ) {
		this.__sign_company = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getContractCodeId() != null) sb.append(__wrapNumber(1, "contractCodeId", getContractCodeId()));
		if(getSignCompany() != null) sb.append(__wrapNumber(1, "signCompany", getSignCompany()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("contractCodeId")) != null) setContractCodeId(__getInt(val)); 
		if((val = values.get("signCompany")) != null) setSignCompany(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
	}

	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.lang.Integer __contract_code_id = null;
	private java.lang.Integer __sign_company = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __employee_name = null;
}

