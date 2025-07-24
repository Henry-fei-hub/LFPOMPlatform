package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseInputTaxInvoiceLinkFinance extends GenericBase implements BaseFactory<BaseInputTaxInvoiceLinkFinance>, Comparable<BaseInputTaxInvoiceLinkFinance> 
{


	public static BaseInputTaxInvoiceLinkFinance newInstance(){
		return new BaseInputTaxInvoiceLinkFinance();
	}

	@Override
	public BaseInputTaxInvoiceLinkFinance make(){
		BaseInputTaxInvoiceLinkFinance b = new BaseInputTaxInvoiceLinkFinance();
		return b;
	}

	public final static java.lang.String CS_INPUT_TAX_INVOICE_LINK_FINANCE_ID = "input_tax_invoice_link_finance_id" ;
	public final static java.lang.String CS_ADD_TYPE = "add_type" ;
	public final static java.lang.String CS_INVOICE_TYPE = "invoice_type" ;
	public final static java.lang.String CS_INVOICE_CODE = "invoice_code" ;
	public final static java.lang.String CS_INVOICE_NUMBER = "invoice_number" ;
	public final static java.lang.String CS_INVOICE_DATE = "invoice_date" ;
	public final static java.lang.String CS_INVOICE_AMOUNT = "invoice_amount" ;
	public final static java.lang.String CS_TAX_RATE = "tax_rate" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_OTHER_REMARK = "other_remark" ;
	public final static java.lang.String CS_RANDOM_CODE = "random_code" ;
	public final static java.lang.String CS_TAX_AMOUNT = "tax_amount" ;
	public final static java.lang.String CS_CODE = "code" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = ",添加类型 1手动添加  2二维码添加,发票类型 1专票，2普票 ，3代开,发票代码(10位 每次批量录入是一样),发票号码(8位),开票日期,开票金额(如 100),税率(如 6%),流程业务主键,流程类型,流程实例主键,,创建时间,删除状态  0未删除  1被删除,备注,其他备注,发票二维码随机字符串,税额,报销编号,归属公司";

	public java.lang.Integer getInputTaxInvoiceLinkFinanceId() {
		return this.__input_tax_invoice_link_finance_id;
	}

	public void setInputTaxInvoiceLinkFinanceId( java.lang.Integer value ) {
		this.__input_tax_invoice_link_finance_id = value;
	}

	public java.lang.Integer getAddType() {
		return this.__add_type;
	}

	public void setAddType( java.lang.Integer value ) {
		this.__add_type = value;
	}

	public java.lang.Integer getInvoiceType() {
		return this.__invoice_type;
	}

	public void setInvoiceType( java.lang.Integer value ) {
		this.__invoice_type = value;
	}

	public java.lang.String getInvoiceCode() {
		return this.__invoice_code;
	}

	public void setInvoiceCode( java.lang.String value ) {
		this.__invoice_code = value;
	}

	public java.lang.String getInvoiceNumber() {
		return this.__invoice_number;
	}

	public void setInvoiceNumber( java.lang.String value ) {
		this.__invoice_number = value;
	}

	public java.util.Date getInvoiceDate() {
		return this.__invoice_date;
	}

	public void setInvoiceDate( java.util.Date value ) {
		this.__invoice_date = value;
	}

	public java.math.BigDecimal getInvoiceAmount() {
		return this.__invoice_amount;
	}

	public void setInvoiceAmount( java.math.BigDecimal value ) {
		this.__invoice_amount = value;
	}

	public java.math.BigDecimal getTaxRate() {
		return this.__tax_rate;
	}

	public void setTaxRate( java.math.BigDecimal value ) {
		this.__tax_rate = value;
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

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getOtherRemark() {
		return this.__other_remark;
	}

	public void setOtherRemark( java.lang.String value ) {
		this.__other_remark = value;
	}

	public java.lang.String getRandomCode() {
		return this.__random_code;
	}

	public void setRandomCode( java.lang.String value ) {
		this.__random_code = value;
	}

	public java.math.BigDecimal getTaxAmount() {
		return this.__tax_amount;
	}

	public void setTaxAmount( java.math.BigDecimal value ) {
		this.__tax_amount = value;
	}

	public java.lang.String getCode() {
		return this.__code;
	}

	public void setCode( java.lang.String value ) {
		this.__code = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public void cloneCopy(BaseInputTaxInvoiceLinkFinance __bean){
		__bean.setInputTaxInvoiceLinkFinanceId(getInputTaxInvoiceLinkFinanceId());
		__bean.setAddType(getAddType());
		__bean.setInvoiceType(getInvoiceType());
		__bean.setInvoiceCode(getInvoiceCode());
		__bean.setInvoiceNumber(getInvoiceNumber());
		__bean.setInvoiceDate(getInvoiceDate());
		__bean.setInvoiceAmount(getInvoiceAmount());
		__bean.setTaxRate(getTaxRate());
		__bean.setBusinessId(getBusinessId());
		__bean.setProcessType(getProcessType());
		__bean.setProcessInstanceId(getProcessInstanceId());
		__bean.setOperator(getOperator());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setRemark(getRemark());
		__bean.setOtherRemark(getOtherRemark());
		__bean.setRandomCode(getRandomCode());
		__bean.setTaxAmount(getTaxAmount());
		__bean.setCode(getCode());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getInputTaxInvoiceLinkFinanceId() == null ? "" : getInputTaxInvoiceLinkFinanceId());
		sb.append(",");
		sb.append(getAddType() == null ? "" : getAddType());
		sb.append(",");
		sb.append(getInvoiceType() == null ? "" : getInvoiceType());
		sb.append(",");
		sb.append(getInvoiceCode() == null ? "" : getInvoiceCode());
		sb.append(",");
		sb.append(getInvoiceNumber() == null ? "" : getInvoiceNumber());
		sb.append(",");
		sb.append(getInvoiceDate() == null ? "" : sdf.format(getInvoiceDate()));
		sb.append(",");
		sb.append(getInvoiceAmount() == null ? "" : getInvoiceAmount());
		sb.append(",");
		sb.append(getTaxRate() == null ? "" : getTaxRate());
		sb.append(",");
		sb.append(getBusinessId() == null ? "" : getBusinessId());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getProcessInstanceId() == null ? "" : getProcessInstanceId());
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getOtherRemark() == null ? "" : getOtherRemark());
		sb.append(",");
		sb.append(getRandomCode() == null ? "" : getRandomCode());
		sb.append(",");
		sb.append(getTaxAmount() == null ? "" : getTaxAmount());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseInputTaxInvoiceLinkFinance o) {
		return __input_tax_invoice_link_finance_id == null ? -1 : __input_tax_invoice_link_finance_id.compareTo(o.getInputTaxInvoiceLinkFinanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__input_tax_invoice_link_finance_id);
		hash = 97 * hash + Objects.hashCode(this.__add_type);
		hash = 97 * hash + Objects.hashCode(this.__invoice_type);
		hash = 97 * hash + Objects.hashCode(this.__invoice_code);
		hash = 97 * hash + Objects.hashCode(this.__invoice_number);
		hash = 97 * hash + Objects.hashCode(this.__invoice_date);
		hash = 97 * hash + Objects.hashCode(this.__invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__tax_rate);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__other_remark);
		hash = 97 * hash + Objects.hashCode(this.__random_code);
		hash = 97 * hash + Objects.hashCode(this.__tax_amount);
		hash = 97 * hash + Objects.hashCode(this.__code);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseInputTaxInvoiceLinkFinance o = (BaseInputTaxInvoiceLinkFinance)obj;
		if(!Objects.equals(this.__input_tax_invoice_link_finance_id, o.getInputTaxInvoiceLinkFinanceId())) return false;
		if(!Objects.equals(this.__add_type, o.getAddType())) return false;
		if(!Objects.equals(this.__invoice_type, o.getInvoiceType())) return false;
		if(!Objects.equals(this.__invoice_code, o.getInvoiceCode())) return false;
		if(!Objects.equals(this.__invoice_number, o.getInvoiceNumber())) return false;
		if(!Objects.equals(this.__invoice_date, o.getInvoiceDate())) return false;
		if(!Objects.equals(this.__invoice_amount, o.getInvoiceAmount())) return false;
		if(!Objects.equals(this.__tax_rate, o.getTaxRate())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__other_remark, o.getOtherRemark())) return false;
		if(!Objects.equals(this.__random_code, o.getRandomCode())) return false;
		if(!Objects.equals(this.__tax_amount, o.getTaxAmount())) return false;
		if(!Objects.equals(this.__code, o.getCode())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getInputTaxInvoiceLinkFinanceId() != null) sb.append(__wrapNumber(count++, "inputTaxInvoiceLinkFinanceId", getInputTaxInvoiceLinkFinanceId()));
		if(getAddType() != null) sb.append(__wrapNumber(count++, "addType", getAddType()));
		if(getInvoiceType() != null) sb.append(__wrapNumber(count++, "invoiceType", getInvoiceType()));
		if(getInvoiceCode() != null) sb.append(__wrapString(count++, "invoiceCode", getInvoiceCode()));
		if(getInvoiceNumber() != null) sb.append(__wrapString(count++, "invoiceNumber", getInvoiceNumber()));
		if(getInvoiceDate() != null) sb.append(__wrapDate(count++, "invoiceDate", getInvoiceDate()));
		if(getInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "invoiceAmount", getInvoiceAmount()));
		if(getTaxRate() != null) sb.append(__wrapDecimal(count++, "taxRate", getTaxRate()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getOtherRemark() != null) sb.append(__wrapString(count++, "otherRemark", getOtherRemark()));
		if(getRandomCode() != null) sb.append(__wrapString(count++, "randomCode", getRandomCode()));
		if(getTaxAmount() != null) sb.append(__wrapDecimal(count++, "taxAmount", getTaxAmount()));
		if(getCode() != null) sb.append(__wrapString(count++, "code", getCode()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("inputTaxInvoiceLinkFinanceId")) != null) setInputTaxInvoiceLinkFinanceId(__getInt(val)); 
		if((val = values.get("addType")) != null) setAddType(__getInt(val)); 
		if((val = values.get("invoiceType")) != null) setInvoiceType(__getInt(val)); 
		if((val = values.get("invoiceCode")) != null) setInvoiceCode(__getString(val));
		if((val = values.get("invoiceNumber")) != null) setInvoiceNumber(__getString(val));
		if((val = values.get("invoiceDate")) != null) setInvoiceDate(__getDate(val)); 
		if((val = values.get("invoiceAmount")) != null) setInvoiceAmount(__getDecimal(val));  
		if((val = values.get("taxRate")) != null) setTaxRate(__getDecimal(val));  
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("otherRemark")) != null) setOtherRemark(__getString(val));
		if((val = values.get("randomCode")) != null) setRandomCode(__getString(val));
		if((val = values.get("taxAmount")) != null) setTaxAmount(__getDecimal(val));  
		if((val = values.get("code")) != null) setCode(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	protected java.lang.Integer  __input_tax_invoice_link_finance_id ;
	protected java.lang.Integer  __add_type ;
	protected java.lang.Integer  __invoice_type ;
	protected java.lang.String  __invoice_code ;
	protected java.lang.String  __invoice_number ;
	protected java.util.Date  __invoice_date ;
	protected java.math.BigDecimal  __invoice_amount ;
	protected java.math.BigDecimal  __tax_rate ;
	protected java.lang.Integer  __business_id ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.Integer  __process_instance_id ;
	protected java.lang.Integer  __operator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __other_remark ;
	protected java.lang.String  __random_code ;
	protected java.math.BigDecimal  __tax_amount ;
	protected java.lang.String  __code ;
	protected java.lang.Integer  __company_id ;
}
