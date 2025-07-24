package pomplatform.outQuotations.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnLoadAttentionListOfOutQuotations extends GenericCondition{

	public ConditionOnLoadAttentionListOfOutQuotations(){
		setParameterCount(10);
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
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

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.lang.String getQuotationNumber() {
		return this.__quotation_number == null ? null : (this.__quotation_number.indexOf("%") >= 0 ? this.__quotation_number : "%"+this.__quotation_number+"%");
	}

	public void setQuotationNumber( java.lang.String value ) {
		this.__quotation_number = value;
	}

	public java.lang.String getQuotationName() {
		return this.__quotation_name == null ? null : (this.__quotation_name.indexOf("%") >= 0 ? this.__quotation_name : "%"+this.__quotation_name+"%");
	}

	public void setQuotationName( java.lang.String value ) {
		this.__quotation_name = value;
	}

	public java.lang.String getInfoCode() {
		return this.__info_code == null ? null : (this.__info_code.indexOf("%") >= 0 ? this.__info_code : "%"+this.__info_code+"%");
	}

	public void setInfoCode( java.lang.String value ) {
		this.__info_code = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.Integer getQuotationStatus() {
		return this.__quotation_status;
	}

	public void setQuotationStatus( java.lang.Integer value ) {
		this.__quotation_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getOutQuotationId() != null) sb.append(__wrapNumber(1, "outQuotationId", getOutQuotationId()));
		if(getQuotationNumber() != null) sb.append(__wrapString(1, "quotationNumber", getQuotationNumber()));
		if(getQuotationName() != null) sb.append(__wrapString(1, "quotationName", getQuotationName()));
		if(getInfoCode() != null) sb.append(__wrapString(1, "infoCode", getInfoCode()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getQuotationStatus() != null) sb.append(__wrapNumber(1, "quotationStatus", getQuotationStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("quotationNumber")) != null) setQuotationNumber(__getString(val));
		if((val = values.get("quotationName")) != null) setQuotationName(__getString(val));
		if((val = values.get("infoCode")) != null) setInfoCode(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("quotationStatus")) != null) setQuotationStatus(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getStatus() != null) res.add("status");
		if(getEmployeeId() != null) res.add("employeeId");
		if(getEmployeeName() != null) res.add("employeeName");
		if(getEmployeeNo() != null) res.add("employeeNo");
		if(getOutQuotationId() != null) res.add("outQuotationId");
		if(getQuotationNumber() != null) res.add("quotationNumber");
		if(getQuotationName() != null) res.add("quotationName");
		if(getInfoCode() != null) res.add("infoCode");
		if(getProjectCode() != null) res.add("projectCode");
		if(getQuotationStatus() != null) res.add("quotationStatus");
		return res;
	}

	private java.lang.Integer __status = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __employee_name = null;
	private java.lang.String __employee_no = null;
	private java.lang.Integer __out_quotation_id = null;
	private java.lang.String __quotation_number = null;
	private java.lang.String __quotation_name = null;
	private java.lang.String __info_code = null;
	private java.lang.String __project_code = null;
	private java.lang.Integer __quotation_status = null;
}

