package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseTravelReimbursementLinkProject extends GenericBase implements BaseFactory<BaseTravelReimbursementLinkProject>, Comparable<BaseTravelReimbursementLinkProject> 
{


	public static BaseTravelReimbursementLinkProject newInstance(){
		return new BaseTravelReimbursementLinkProject();
	}

	@Override
	public BaseTravelReimbursementLinkProject make(){
		BaseTravelReimbursementLinkProject b = new BaseTravelReimbursementLinkProject();
		return b;
	}

	public final static java.lang.String CS_TRAVEL_REIMBURSEMENT_LINK_PROJECT_ID = "travel_reimbursement_link_project_id" ;
	public final static java.lang.String CS_TRAVEL_REIMBURSEMENT_ID = "travel_reimbursement_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_INPUT_TAX = "input_tax" ;
	public final static java.lang.String CS_FINAL_AMOUNT = "final_amount" ;
	public final static java.lang.String CS_IS_PERSONAL_FEE = "is_personal_fee" ;
	public final static java.lang.String CS_INPUT_TAX_REBATE = "input_tax_rebate" ;
	public final static java.lang.String CS_HAVE_ELECTRONIC_INVOICE = "have_electronic_invoice" ;
	public final static java.lang.String CS_INVOICE_LINK_KEY = "invoice_link_key" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,差旅报销详情编码,项目,订单编号,业务部门,费用,进项税,成本,是否个人承担费用,进项税转出金额,有无电子发票  1 无 2有,发票关联key 用于发票信息关联";

	public java.lang.Integer getTravelReimbursementLinkProjectId() {
		return this.__travel_reimbursement_link_project_id;
	}

	public void setTravelReimbursementLinkProjectId( java.lang.Integer value ) {
		this.__travel_reimbursement_link_project_id = value;
	}

	public java.lang.Integer getTravelReimbursementId() {
		return this.__travel_reimbursement_id;
	}

	public void setTravelReimbursementId( java.lang.Integer value ) {
		this.__travel_reimbursement_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public java.lang.Boolean getIsPersonalFee() {
		return this.__is_personal_fee;
	}

	public void setIsPersonalFee( java.lang.Boolean value ) {
		this.__is_personal_fee = value;
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

	public void cloneCopy(BaseTravelReimbursementLinkProject __bean){
		__bean.setTravelReimbursementLinkProjectId(getTravelReimbursementLinkProjectId());
		__bean.setTravelReimbursementId(getTravelReimbursementId());
		__bean.setProjectId(getProjectId());
		__bean.setContractCode(getContractCode());
		__bean.setPlateId(getPlateId());
		__bean.setAmount(getAmount());
		__bean.setInputTax(getInputTax());
		__bean.setFinalAmount(getFinalAmount());
		__bean.setIsPersonalFee(getIsPersonalFee());
		__bean.setInputTaxRebate(getInputTaxRebate());
		__bean.setHaveElectronicInvoice(getHaveElectronicInvoice());
		__bean.setInvoiceLinkKey(getInvoiceLinkKey());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getTravelReimbursementLinkProjectId() == null ? "" : getTravelReimbursementLinkProjectId());
		sb.append(",");
		sb.append(getTravelReimbursementId() == null ? "" : getTravelReimbursementId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		sb.append(getIsPersonalFee() == null ? "" : getIsPersonalFee());
		sb.append(",");
		sb.append(getInputTaxRebate() == null ? "" : getInputTaxRebate());
		sb.append(",");
		sb.append(getHaveElectronicInvoice() == null ? "" : getHaveElectronicInvoice());
		sb.append(",");
		sb.append(getInvoiceLinkKey() == null ? "" : getInvoiceLinkKey());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTravelReimbursementLinkProject o) {
		return __travel_reimbursement_link_project_id == null ? -1 : __travel_reimbursement_link_project_id.compareTo(o.getTravelReimbursementLinkProjectId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__travel_reimbursement_link_project_id);
		hash = 97 * hash + Objects.hashCode(this.__travel_reimbursement_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__input_tax);
		hash = 97 * hash + Objects.hashCode(this.__final_amount);
		hash = 97 * hash + Objects.hashCode(this.__is_personal_fee);
		hash = 97 * hash + Objects.hashCode(this.__input_tax_rebate);
		hash = 97 * hash + Objects.hashCode(this.__have_electronic_invoice);
		hash = 97 * hash + Objects.hashCode(this.__invoice_link_key);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTravelReimbursementLinkProject o = (BaseTravelReimbursementLinkProject)obj;
		if(!Objects.equals(this.__travel_reimbursement_link_project_id, o.getTravelReimbursementLinkProjectId())) return false;
		if(!Objects.equals(this.__travel_reimbursement_id, o.getTravelReimbursementId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__input_tax, o.getInputTax())) return false;
		if(!Objects.equals(this.__final_amount, o.getFinalAmount())) return false;
		if(!Objects.equals(this.__is_personal_fee, o.getIsPersonalFee())) return false;
		if(!Objects.equals(this.__input_tax_rebate, o.getInputTaxRebate())) return false;
		if(!Objects.equals(this.__have_electronic_invoice, o.getHaveElectronicInvoice())) return false;
		if(!Objects.equals(this.__invoice_link_key, o.getInvoiceLinkKey())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTravelReimbursementLinkProjectId() != null) sb.append(__wrapNumber(count++, "travelReimbursementLinkProjectId", getTravelReimbursementLinkProjectId()));
		if(getTravelReimbursementId() != null) sb.append(__wrapNumber(count++, "travelReimbursementId", getTravelReimbursementId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getInputTax() != null) sb.append(__wrapDecimal(count++, "inputTax", getInputTax()));
		if(getFinalAmount() != null) sb.append(__wrapDecimal(count++, "finalAmount", getFinalAmount()));
		if(getIsPersonalFee() != null) sb.append(__wrapBoolean(count++, "isPersonalFee", getIsPersonalFee()));
		if(getInputTaxRebate() != null) sb.append(__wrapDecimal(count++, "inputTaxRebate", getInputTaxRebate()));
		if(getHaveElectronicInvoice() != null) sb.append(__wrapNumber(count++, "haveElectronicInvoice", getHaveElectronicInvoice()));
		if(getInvoiceLinkKey() != null) sb.append(__wrapNumber(count++, "invoiceLinkKey", getInvoiceLinkKey()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getTravelReimbursementLinkProjectId() != null) res.put("travelReimbursementLinkProjectId", getTravelReimbursementLinkProjectId());
		if(getTravelReimbursementId() != null) res.put("travelReimbursementId", getTravelReimbursementId());
		if(getProjectId() != null) res.put("projectId", getProjectId());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getAmount() != null) res.put("amount", getAmount());
		if(getInputTax() != null) res.put("inputTax", getInputTax());
		if(getFinalAmount() != null) res.put("finalAmount", getFinalAmount());
		if(getIsPersonalFee() != null) res.put("isPersonalFee", getIsPersonalFee());
		if(getInputTaxRebate() != null) res.put("inputTaxRebate", getInputTaxRebate());
		if(getHaveElectronicInvoice() != null) res.put("haveElectronicInvoice", getHaveElectronicInvoice());
		if(getInvoiceLinkKey() != null) res.put("invoiceLinkKey", getInvoiceLinkKey());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("travelReimbursementLinkProjectId")) != null) setTravelReimbursementLinkProjectId(__getInt(val)); 
		if((val = values.get("travelReimbursementId")) != null) setTravelReimbursementId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("inputTax")) != null) setInputTax(__getDecimal(val));  
		if((val = values.get("finalAmount")) != null) setFinalAmount(__getDecimal(val));  
		if((val = values.get("isPersonalFee")) != null) setIsPersonalFee(__getBoolean(val));
		if((val = values.get("inputTaxRebate")) != null) setInputTaxRebate(__getDecimal(val));  
		if((val = values.get("haveElectronicInvoice")) != null) setHaveElectronicInvoice(__getInt(val)); 
		if((val = values.get("invoiceLinkKey")) != null) setInvoiceLinkKey(__getInt(val)); 
	}

	protected java.lang.Integer  __travel_reimbursement_link_project_id ;
	protected java.lang.Integer  __travel_reimbursement_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __amount ;
	protected java.math.BigDecimal  __input_tax ;
	protected java.math.BigDecimal  __final_amount ;
	protected java.lang.Boolean  __is_personal_fee ;
	protected java.math.BigDecimal  __input_tax_rebate ;
	protected java.lang.Integer  __have_electronic_invoice ;
	protected java.lang.Integer  __invoice_link_key ;
}
