package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseInputTaxRecord extends GenericBase implements BaseFactory<BaseInputTaxRecord>, Comparable<BaseInputTaxRecord> 
{


	public static BaseInputTaxRecord newInstance(){
		return new BaseInputTaxRecord();
	}

	@Override
	public BaseInputTaxRecord make(){
		BaseInputTaxRecord b = new BaseInputTaxRecord();
		return b;
	}

	public final static java.lang.String CS_INPUT_TAX_RECORD_ID = "input_tax_record_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_INPUT_TAX = "input_tax" ;
	public final static java.lang.String CS_INVOICE_END_NUMBER = "invoice_end_number" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_OVER_TIME = "over_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务编码,流程类型,报销编号,进项税金额,发票号码后四位,操作人,操作时间,流程结束时间";

	public java.lang.Integer getInputTaxRecordId() {
		return this.__input_tax_record_id;
	}

	public void setInputTaxRecordId( java.lang.Integer value ) {
		this.__input_tax_record_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.math.BigDecimal getInputTax() {
		return this.__input_tax;
	}

	public void setInputTax( java.math.BigDecimal value ) {
		this.__input_tax = value;
	}

	public java.lang.String getInvoiceEndNumber() {
		return this.__invoice_end_number;
	}

	public void setInvoiceEndNumber( java.lang.String value ) {
		this.__invoice_end_number = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.util.Date getOverTime() {
		return this.__over_time;
	}

	public void setOverTime( java.util.Date value ) {
		this.__over_time = value;
	}

	public void cloneCopy(BaseInputTaxRecord __bean){
		__bean.setInputTaxRecordId(getInputTaxRecordId());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessType(getProcessType());
		__bean.setCode(getCode());
		__bean.setInputTax(getInputTax());
		__bean.setInvoiceEndNumber(getInvoiceEndNumber());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setOverTime(getOverTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInputTaxRecordId() == null ? "" : getInputTaxRecordId());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
		sb.append(",");
		sb.append(getInvoiceEndNumber() == null ? "" : getInvoiceEndNumber());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getOverTime() == null ? "" : sdf.format(getOverTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInputTaxRecord o) {
		return __input_tax_record_id == null ? -1 : __input_tax_record_id.compareTo(o.getInputTaxRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__input_tax_record_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__invoice_end_number);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__over_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInputTaxRecord o = (BaseInputTaxRecord)obj;
		if(!Objects.equals(this.__input_tax_record_id, o.getInputTaxRecordId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__invoice_end_number, o.getInvoiceEndNumber())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__over_time, o.getOverTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInputTaxRecordId() != null) sb.append(__wrapNumber(count++, "inputTaxRecordId", getInputTaxRecordId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getInputTax() != null) sb.append(__wrapDecimal(count++, "inputTax", getInputTax()));
		if(getInvoiceEndNumber() != null) sb.append(__wrapString(count++, "invoiceEndNumber", getInvoiceEndNumber()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getOverTime() != null) sb.append(__wrapDate(count++, "overTime", getOverTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getInputTaxRecordId() != null) res.put("inputTaxRecordId", getInputTaxRecordId());
		if(getBusinessId() != null) res.put("businessId", getBusinessId());
		if(getProcessType() != null) res.put("processType", getProcessType());
		if(getCode() != null) res.put("code", getCode());
		if(getInputTax() != null) res.put("inputTax", getInputTax());
		if(getInvoiceEndNumber() != null) res.put("invoiceEndNumber", getInvoiceEndNumber());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getOverTime() != null) res.put("overTime", getOverTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("inputTaxRecordId")) != null) setInputTaxRecordId(__getInt(val)); 
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("inputTax")) != null) setInputTax(__getDecimal(val));  
		if((val = values.get("invoiceEndNumber")) != null) setInvoiceEndNumber(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("overTime")) != null) setOverTime(__getDate(val)); 
	}

	protected java.lang.Integer  __input_tax_record_id ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.String  __code ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.lang.String  __invoice_end_number ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.util.Date  __over_time ;
}
