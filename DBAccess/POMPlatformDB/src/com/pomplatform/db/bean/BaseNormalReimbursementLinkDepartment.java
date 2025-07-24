package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseNormalReimbursementLinkDepartment extends GenericBase implements BaseFactory<BaseNormalReimbursementLinkDepartment>, Comparable<BaseNormalReimbursementLinkDepartment> 
{


	public static BaseNormalReimbursementLinkDepartment newInstance(){
		return new BaseNormalReimbursementLinkDepartment();
	}

	@Override
	public BaseNormalReimbursementLinkDepartment make(){
		BaseNormalReimbursementLinkDepartment b = new BaseNormalReimbursementLinkDepartment();
		return b;
	}

	public final static java.lang.String CS_NORMAL_REIMBURSEMENT_LINK_DEPARTMENT_ID = "normal_reimbursement_link_department_id" ;
	public final static java.lang.String CS_PROJECT_NORMAL_REIMBURSEMENT_ID = "project_normal_reimbursement_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_INPUT_TAX = "input_tax" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_MAIN_ITEM_ID = "main_item_id" ;
	public final static java.lang.String CS_SUB_ITEM_ID = "sub_item_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_INPUT_TAX_REBATE = "input_tax_rebate" ;
	public final static java.lang.String CS_HAVE_ELECTRONIC_INVOICE = "have_electronic_invoice" ;
	public final static java.lang.String CS_INVOICE_LINK_KEY = "invoice_link_key" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,日常报销编码,部门,费用,进项税,成本,一级报销科目,二级报销科目,备注,进项税转出,有无电子发票  1 无 2有,发票关联key 用于发票信息关联";

	public java.lang.Integer getNormalReimbursementLinkDepartmentId() {
		return this.__normal_reimbursement_link_department_id;
	}

	public void setNormalReimbursementLinkDepartmentId( java.lang.Integer value ) {
		this.__normal_reimbursement_link_department_id = value;
	}

	public java.lang.Integer getProjectNormalReimbursementId() {
		return this.__project_normal_reimbursement_id;
	}

	public void setProjectNormalReimbursementId( java.lang.Integer value ) {
		this.__project_normal_reimbursement_id = value;
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

	public java.lang.Integer getMainItemId() {
		return this.__main_item_id;
	}

	public void setMainItemId( java.lang.Integer value ) {
		this.__main_item_id = value;
	}

	public java.lang.Integer getSubItemId() {
		return this.__sub_item_id;
	}

	public void setSubItemId( java.lang.Integer value ) {
		this.__sub_item_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
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

	public void cloneCopy(BaseNormalReimbursementLinkDepartment __bean){
		__bean.setNormalReimbursementLinkDepartmentId(getNormalReimbursementLinkDepartmentId());
		__bean.setProjectNormalReimbursementId(getProjectNormalReimbursementId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setAmount(getAmount());
		__bean.setInputTax(getInputTax());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setMainItemId(getMainItemId());
		__bean.setSubItemId(getSubItemId());
		__bean.setRemark(getRemark());
		__bean.setInputTaxRebate(getInputTaxRebate());
		__bean.setHaveElectronicInvoice(getHaveElectronicInvoice());
		__bean.setInvoiceLinkKey(getInvoiceLinkKey());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getNormalReimbursementLinkDepartmentId() == null ? "" : getNormalReimbursementLinkDepartmentId());
		sb.append(",");
		sb.append(getProjectNormalReimbursementId() == null ? "" : getProjectNormalReimbursementId());
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
		sb.append(getMainItemId() == null ? "" : getMainItemId());
		sb.append(",");
		sb.append(getSubItemId() == null ? "" : getSubItemId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getInputTaxRebate() == null ? "" : getInputTaxRebate());
		sb.append(",");
		sb.append(getHaveElectronicInvoice() == null ? "" : getHaveElectronicInvoice());
		sb.append(",");
		sb.append(getInvoiceLinkKey() == null ? "" : getInvoiceLinkKey());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseNormalReimbursementLinkDepartment o) {
		return __normal_reimbursement_link_department_id == null ? -1 : __normal_reimbursement_link_department_id.compareTo(o.getNormalReimbursementLinkDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__normal_reimbursement_link_department_id);
		hash = 97 * hash + Objects.hashCode(this.__project_normal_reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__main_item_id);
		hash = 97 * hash + Objects.hashCode(this.__sub_item_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__input_tax_rebate);
		hash = 97 * hash + Objects.hashCode(this.__have_electronic_invoice);
		hash = 97 * hash + Objects.hashCode(this.__invoice_link_key);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseNormalReimbursementLinkDepartment o = (BaseNormalReimbursementLinkDepartment)obj;
		if(!Objects.equals(this.__normal_reimbursement_link_department_id, o.getNormalReimbursementLinkDepartmentId())) return false;
		if(!Objects.equals(this.__project_normal_reimbursement_id, o.getProjectNormalReimbursementId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__main_item_id, o.getMainItemId())) return false;
		if(!Objects.equals(this.__sub_item_id, o.getSubItemId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__input_tax_rebate, o.getInputTaxRebate())) return false;
		if(!Objects.equals(this.__have_electronic_invoice, o.getHaveElectronicInvoice())) return false;
		if(!Objects.equals(this.__invoice_link_key, o.getInvoiceLinkKey())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getNormalReimbursementLinkDepartmentId() != null) sb.append(__wrapNumber(count++, "normalReimbursementLinkDepartmentId", getNormalReimbursementLinkDepartmentId()));
		if(getProjectNormalReimbursementId() != null) sb.append(__wrapNumber(count++, "projectNormalReimbursementId", getProjectNormalReimbursementId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getInputTax() != null) sb.append(__wrapDecimal(count++, "inputTax", getInputTax()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getMainItemId() != null) sb.append(__wrapNumber(count++, "mainItemId", getMainItemId()));
		if(getSubItemId() != null) sb.append(__wrapNumber(count++, "subItemId", getSubItemId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getInputTaxRebate() != null) sb.append(__wrapDecimal(count++, "inputTaxRebate", getInputTaxRebate()));
		if(getHaveElectronicInvoice() != null) sb.append(__wrapNumber(count++, "haveElectronicInvoice", getHaveElectronicInvoice()));
		if(getInvoiceLinkKey() != null) sb.append(__wrapNumber(count++, "invoiceLinkKey", getInvoiceLinkKey()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getNormalReimbursementLinkDepartmentId() != null) res.put("normalReimbursementLinkDepartmentId", getNormalReimbursementLinkDepartmentId());
		if(getProjectNormalReimbursementId() != null) res.put("projectNormalReimbursementId", getProjectNormalReimbursementId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getInputTax() != null) res.put("inputTax", getInputTax());
		if(getFinalAmount() != null) res.put("finalAmount", getFinalAmount());
		if(getMainItemId() != null) res.put("mainItemId", getMainItemId());
		if(getSubItemId() != null) res.put("subItemId", getSubItemId());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getInputTaxRebate() != null) res.put("inputTaxRebate", getInputTaxRebate());
		if(getHaveElectronicInvoice() != null) res.put("haveElectronicInvoice", getHaveElectronicInvoice());
		if(getInvoiceLinkKey() != null) res.put("invoiceLinkKey", getInvoiceLinkKey());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("normalReimbursementLinkDepartmentId")) != null) setNormalReimbursementLinkDepartmentId(__getInt(val)); 
		if((val = values.get("projectNormalReimbursementId")) != null) setProjectNormalReimbursementId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("inputTax")) != null) setInputTax(__getDecimal(val));  
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("mainItemId")) != null) setMainItemId(__getInt(val)); 
		if((val = values.get("subItemId")) != null) setSubItemId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("inputTaxRebate")) != null) setInputTaxRebate(__getDecimal(val));  
		if((val = values.get("haveElectronicInvoice")) != null) setHaveElectronicInvoice(__getInt(val)); 
		if((val = values.get("invoiceLinkKey")) != null) setInvoiceLinkKey(__getInt(val)); 
	}

	protected java.lang.Integer  __normal_reimbursement_link_department_id ;
	protected java.lang.Integer  __project_normal_reimbursement_id ;
	protected java.lang.Integer  __department_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.lang.Integer  __main_item_id ;
	protected java.lang.Integer  __sub_item_id ;
	protected java.lang.String  __remark ;
	protected java.math.BigDecimal  __input_tax_rebate ;
	protected java.lang.Integer  __have_electronic_invoice ;
	protected java.lang.Integer  __invoice_link_key ;
}
