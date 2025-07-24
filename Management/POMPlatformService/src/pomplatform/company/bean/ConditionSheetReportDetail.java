package pomplatform.company.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSheetReportDetail extends GenericCondition{

	public ConditionSheetReportDetail(){
		setParameterCount(7);
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

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getSubContractCode() {
		return this.__sub_contract_code == null ? null : (this.__sub_contract_code.indexOf("%") >= 0 ? this.__sub_contract_code : "%"+this.__sub_contract_code+"%");
	}

	public void setSubContractCode( java.lang.String value ) {
		this.__sub_contract_code = value;
	}

	public java.lang.String getSubContractName() {
		return this.__sub_contract_name == null ? null : (this.__sub_contract_name.indexOf("%") >= 0 ? this.__sub_contract_name : "%"+this.__sub_contract_name+"%");
	}

	public void setSubContractName( java.lang.String value ) {
		this.__sub_contract_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getBusinessType() != null) sb.append(__wrapNumber(1, "businessType", getBusinessType()));
		if(getProjectType() != null) sb.append(__wrapNumber(1, "projectType", getProjectType()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getSubContractCode() != null) sb.append(__wrapString(1, "subContractCode", getSubContractCode()));
		if(getSubContractName() != null) sb.append(__wrapString(1, "subContractName", getSubContractName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("subContractCode")) != null) setSubContractCode(__getString(val));
		if((val = values.get("subContractName")) != null) setSubContractName(__getString(val));
	}

	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __business_type = null;
	private java.lang.Integer __project_type = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __sub_contract_code = null;
	private java.lang.String __sub_contract_name = null;
}

