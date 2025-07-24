package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseTravelReimbursementLinkDepartment extends GenericBase implements BaseFactory<BaseTravelReimbursementLinkDepartment>, Comparable<BaseTravelReimbursementLinkDepartment> 
{


	public static BaseTravelReimbursementLinkDepartment newInstance(){
		return new BaseTravelReimbursementLinkDepartment();
	}

	@Override
	public BaseTravelReimbursementLinkDepartment make(){
		BaseTravelReimbursementLinkDepartment b = new BaseTravelReimbursementLinkDepartment();
		return b;
	}

	public final static java.lang.String CS_TRAVEL_REIMBURSEMENT_LINK_DEPARTMENT_ID = "travel_reimbursement_link_department_id" ;
	public final static java.lang.String CS_TRAVEL_REIMBURSEMENT_ID = "travel_reimbursement_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_INPUT_TAX = "input_tax" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_INPUT_TAX_REBATE = "input_tax_rebate" ;
	public final static java.lang.String CS_HAVE_ELECTRONIC_INVOICE = "have_electronic_invoice" ;
	public final static java.lang.String CS_INVOICE_LINK_KEY = "invoice_link_key" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,差旅报销详情编码,部门,费用,进项税,成本,进项税转出,有无电子发票  1 无 2有,发票关联key 用于发票信息关联";

	public java.lang.Integer getTravelReimbursementLinkDepartmentId() {
		return this.__travel_reimbursement_link_department_id;
	}

	public void setTravelReimbursementLinkDepartmentId( java.lang.Integer value ) {
		this.__travel_reimbursement_link_department_id = value;
	}

	public java.lang.Integer getTravelReimbursementId() {
		return this.__travel_reimbursement_id;
	}

	public void setTravelReimbursementId( java.lang.Integer value ) {
		this.__travel_reimbursement_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public java.math.BigDecimal getInputTax() {
		return this.__input_tax;
	}

	public void setInputTax( java.math.BigDecimal value ) {
		this.__input_tax = value;
	}

	public java.math.BigDecimal getFinalAmount() {
		return this.__final_amount;
	}

	public void setFinalAmount( java.math.BigDecimal value ) {
		this.__final_amount = value;
	}

	public java.math.BigDecimal getInputTaxRebate() {
		return this.__input_tax_rebate;
	}

	public void setInputTaxRebate( java.math.BigDecimal value ) {
		this.__input_tax_rebate = value;
	}

	public java.lang.Integer getHaveElectronicInvoice() {
		return this.__have_electronic_invoice;
	}

	public void setHaveElectronicInvoice( java.lang.Integer value ) {
		this.__have_electronic_invoice = value;
	}

	public java.lang.Integer getInvoiceLinkKey() {
		return this.__invoice_link_key;
	}

	public void setInvoiceLinkKey( java.lang.Integer value ) {
		this.__invoice_link_key = value;
	}

	public void cloneCopy(BaseTravelReimbursementLinkDepartment __bean){
		__bean.setTravelReimbursementLinkDepartmentId(getTravelReimbursementLinkDepartmentId());
		__bean.setTravelReimbursementId(getTravelReimbursementId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setAmount(getAmount());
		__bean.setInputTax(getInputTax());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setInputTaxRebate(getInputTaxRebate());
		__bean.setHaveElectronicInvoice(getHaveElectronicInvoice());
		__bean.setInvoiceLinkKey(getInvoiceLinkKey());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getTravelReimbursementLinkDepartmentId() == null ? "" : getTravelReimbursementLinkDepartmentId());
		sb.append(",");
		sb.append(getTravelReimbursementId() == null ? "" : getTravelReimbursementId());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		sb.append(getInputTaxRebate() == null ? "" : getInputTaxRebate());
		sb.append(",");
		sb.append(getHaveElectronicInvoice() == null ? "" : getHaveElectronicInvoice());
		sb.append(",");
		sb.append(getInvoiceLinkKey() == null ? "" : getInvoiceLinkKey());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTravelReimbursementLinkDepartment o) {
		return __travel_reimbursement_link_department_id == null ? -1 : __travel_reimbursement_link_department_id.compareTo(o.getTravelReimbursementLinkDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__travel_reimbursement_link_department_id);
		hash = 97 * hash + Objects.hashCode(this.__travel_reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__input_tax_rebate);
		hash = 97 * hash + Objects.hashCode(this.__have_electronic_invoice);
		hash = 97 * hash + Objects.hashCode(this.__invoice_link_key);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTravelReimbursementLinkDepartment o = (BaseTravelReimbursementLinkDepartment)obj;
		if(!Objects.equals(this.__travel_reimbursement_link_department_id, o.getTravelReimbursementLinkDepartmentId())) return false;
		if(!Objects.equals(this.__travel_reimbursement_id, o.getTravelReimbursementId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__input_tax_rebate, o.getInputTaxRebate())) return false;
		if(!Objects.equals(this.__have_electronic_invoice, o.getHaveElectronicInvoice())) return false;
		if(!Objects.equals(this.__invoice_link_key, o.getInvoiceLinkKey())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTravelReimbursementLinkDepartmentId() != null) sb.append(__wrapNumber(count++, "travelReimbursementLinkDepartmentId", getTravelReimbursementLinkDepartmentId()));
		if(getTravelReimbursementId() != null) sb.append(__wrapNumber(count++, "travelReimbursementId", getTravelReimbursementId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getInputTax() != null) sb.append(__wrapDecimal(count++, "inputTax", getInputTax()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getInputTaxRebate() != null) sb.append(__wrapDecimal(count++, "inputTaxRebate", getInputTaxRebate()));
		if(getHaveElectronicInvoice() != null) sb.append(__wrapNumber(count++, "haveElectronicInvoice", getHaveElectronicInvoice()));
		if(getInvoiceLinkKey() != null) sb.append(__wrapNumber(count++, "invoiceLinkKey", getInvoiceLinkKey()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getTravelReimbursementLinkDepartmentId() != null) res.put("travelReimbursementLinkDepartmentId", getTravelReimbursementLinkDepartmentId());
		if(getTravelReimbursementId() != null) res.put("travelReimbursementId", getTravelReimbursementId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getInputTax() != null) res.put("inputTax", getInputTax());
		if(getFinalAmount() != null) res.put("finalAmount", getFinalAmount());
		if(getInputTaxRebate() != null) res.put("inputTaxRebate", getInputTaxRebate());
		if(getHaveElectronicInvoice() != null) res.put("haveElectronicInvoice", getHaveElectronicInvoice());
		if(getInvoiceLinkKey() != null) res.put("invoiceLinkKey", getInvoiceLinkKey());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("travelReimbursementLinkDepartmentId")) != null) setTravelReimbursementLinkDepartmentId(__getInt(val)); 
		if((val = values.get("travelReimbursementId")) != null) setTravelReimbursementId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("inputTax")) != null) setInputTax(__getDecimal(val));  
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("inputTaxRebate")) != null) setInputTaxRebate(__getDecimal(val));  
		if((val = values.get("haveElectronicInvoice")) != null) setHaveElectronicInvoice(__getInt(val)); 
		if((val = values.get("invoiceLinkKey")) != null) setInvoiceLinkKey(__getInt(val)); 
	}

	protected java.lang.Integer  __travel_reimbursement_link_department_id ;
	protected java.lang.Integer  __travel_reimbursement_id ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.math.BigDecimal  __input_tax_rebate ;
	protected java.lang.Integer  __have_electronic_invoice ;
	protected java.lang.Integer  __invoice_link_key ;
}
