package pomplatform.customer.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadCustomerData extends GenericCondition{

	public ConditionOnLoadCustomerData(){
		setParameterCount(13);
	}

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name == null ? null : (this.__customer_name.indexOf("%") >= 0 ? this.__customer_name : "%"+this.__customer_name+"%");
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getCompanyAddress() {
		return this.__company_address == null ? null : (this.__company_address.indexOf("%") >= 0 ? this.__company_address : "%"+this.__company_address+"%");
	}

	public void setCompanyAddress( java.lang.String value ) {
		this.__company_address = value;
	}

	public java.lang.Integer getCustomerType() {
		return this.__customer_type;
	}

	public void setCustomerType( java.lang.Integer value ) {
		this.__customer_type = value;
	}

	public java.lang.Integer getCustomerLevel() {
		return this.__customer_level;
	}

	public void setCustomerLevel( java.lang.Integer value ) {
		this.__customer_level = value;
	}

	public java.lang.Integer getReportEmployeeId() {
		return this.__report_employee_id;
	}

	public void setReportEmployeeId( java.lang.Integer value ) {
		this.__report_employee_id = value;
	}

	public java.lang.Boolean getIsSure() {
		return this.__is_sure;
	}

	public void setIsSure( java.lang.Boolean value ) {
		this.__is_sure = value;
	}

	public java.lang.Boolean getIsWarehous() {
		return this.__is_warehous;
	}

	public void setIsWarehous( java.lang.Boolean value ) {
		this.__is_warehous = value;
	}

	public java.lang.Boolean getIsApplyQuote() {
		return this.__is_apply_quote;
	}

	public void setIsApplyQuote( java.lang.Boolean value ) {
		this.__is_apply_quote = value;
	}

	public java.lang.String getCompanyProvince() {
		return this.__company_province;
	}

	public void setCompanyProvince( java.lang.String value ) {
		this.__company_province = value;
	}

	public java.lang.String getCompanyCity() {
		return this.__company_city;
	}

	public void setCompanyCity( java.lang.String value ) {
		this.__company_city = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCustomerId() != null) sb.append(__wrapNumber(1, "customerId", getCustomerId()));
		if(getCustomerName() != null) sb.append(__wrapString(1, "customerName", getCustomerName()));
		if(getCompanyAddress() != null) sb.append(__wrapString(1, "companyAddress", getCompanyAddress()));
		if(getCustomerType() != null) sb.append(__wrapNumber(1, "customerType", getCustomerType()));
		if(getCustomerLevel() != null) sb.append(__wrapNumber(1, "customerLevel", getCustomerLevel()));
		if(getReportEmployeeId() != null) sb.append(__wrapNumber(1, "reportEmployeeId", getReportEmployeeId()));
		if(getIsSure() != null) sb.append(__wrapBoolean(1, "isSure", getIsSure()));
		if(getIsWarehous() != null) sb.append(__wrapBoolean(1, "isWarehous", getIsWarehous()));
		if(getIsApplyQuote() != null) sb.append(__wrapBoolean(1, "isApplyQuote", getIsApplyQuote()));
		if(getCompanyProvince() != null) sb.append(__wrapString(1, "companyProvince", getCompanyProvince()));
		if(getCompanyCity() != null) sb.append(__wrapString(1, "companyCity", getCompanyCity()));
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("companyAddress")) != null) setCompanyAddress(__getString(val));
		if((val = values.get("customerType")) != null) setCustomerType(__getInt(val)); 
		if((val = values.get("customerLevel")) != null) setCustomerLevel(__getInt(val)); 
		if((val = values.get("reportEmployeeId")) != null) setReportEmployeeId(__getInt(val)); 
		if((val = values.get("isSure")) != null) setIsSure(__getBoolean(val));
		if((val = values.get("isWarehous")) != null) setIsWarehous(__getBoolean(val));
		if((val = values.get("isApplyQuote")) != null) setIsApplyQuote(__getBoolean(val));
		if((val = values.get("companyProvince")) != null) setCompanyProvince(__getString(val));
		if((val = values.get("companyCity")) != null) setCompanyCity(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
	}

	private java.lang.Integer __customer_id = null;
	private java.lang.String __customer_name = null;
	private java.lang.String __company_address = null;
	private java.lang.Integer __customer_type = null;
	private java.lang.Integer __customer_level = null;
	private java.lang.Integer __report_employee_id = null;
	private java.lang.Boolean __is_sure = null;
	private java.lang.Boolean __is_warehous = null;
	private java.lang.Boolean __is_apply_quote = null;
	private java.lang.String __company_province = null;
	private java.lang.String __company_city = null;
	private java.lang.Integer __parent_id = null;
	private java.lang.Integer __type = null;
}

