package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePurchaseContract extends GenericBase implements BaseFactory<BasePurchaseContract>, Comparable<BasePurchaseContract> 
{


	public static BasePurchaseContract newInstance(){
		return new BasePurchaseContract();
	}

	@Override
	public BasePurchaseContract make(){
		BasePurchaseContract b = new BasePurchaseContract();
		return b;
	}

	public final static java.lang.String CS_PURCHASE_CONTRACT_ID = "purchase_contract_id" ;
	public final static java.lang.String CS_CONTRACT_NAME = "contract_name" ;
	public final static java.lang.String CS_CONTRACT_CODE = "contract_code" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_PURCHASE_PERSON = "purchase_person" ;
	public final static java.lang.String CS_CONTRACT_AMOUNT = "contract_amount" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_PROJECT_NAME = "project_name" ;
	public final static java.lang.String CS_QUALITY_ASSURANCE = "quality_assurance" ;
	public final static java.lang.String CS_CONTRACT_DATE = "contract_date" ;
	public final static java.lang.String CS_TERM_OF_PAYMENT = "term_of_payment" ;
	public final static java.lang.String CS_AFTER_SALE_REQUIREMENTS = "after_sale_requirements" ;
	public final static java.lang.String CS_AMOUNT_PAID = "amount_paid" ;
	public final static java.lang.String CS_AMOUNT_UNPAID = "amount_unpaid" ;
	public final static java.lang.String CS_HAVE_INVOICE_AMOUNT = "have_invoice_amount" ;
	public final static java.lang.String CS_LACK_INVOICE_AMOUNT = "lack_invoice_amount" ;
	public final static java.lang.String CS_CONTRACT_ATTACHMENT = "contract_attachment" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,合同名称,合同编号,供应商编码,订购人,合同金额,项目,项目名称,质保,合同签订日期,付款条件,售后要求,已付金额,未付金额,已开票金额,未开票金额,合同附近-扫描件(关联file_manage),流程业务表主键,创建时间";

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name;
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.Integer getPurchasePerson() {
		return this.__purchase_person;
	}

	public void setPurchasePerson( java.lang.Integer value ) {
		this.__purchase_person = value;
	}

	public java.math.BigDecimal getContractAmount() {
		return this.__contract_amount;
	}

	public void setContractAmount( java.math.BigDecimal value ) {
		this.__contract_amount = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name;
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getQualityAssurance() {
		return this.__quality_assurance;
	}

	public void setQualityAssurance( java.lang.String value ) {
		this.__quality_assurance = value;
	}

	public java.util.Date getContractDate() {
		return this.__contract_date;
	}

	public void setContractDate( java.util.Date value ) {
		this.__contract_date = value;
	}

	public java.lang.String getTermOfPayment() {
		return this.__term_of_payment;
	}

	public void setTermOfPayment( java.lang.String value ) {
		this.__term_of_payment = value;
	}

	public java.lang.String getAfterSaleRequirements() {
		return this.__after_sale_requirements;
	}

	public void setAfterSaleRequirements( java.lang.String value ) {
		this.__after_sale_requirements = value;
	}

	public java.math.BigDecimal getAmountPaid() {
		return this.__amount_paid;
	}

	public void setAmountPaid( java.math.BigDecimal value ) {
		this.__amount_paid = value;
	}

	public java.math.BigDecimal getAmountUnpaid() {
		return this.__amount_unpaid;
	}

	public void setAmountUnpaid( java.math.BigDecimal value ) {
		this.__amount_unpaid = value;
	}

	public java.math.BigDecimal getHaveInvoiceAmount() {
		return this.__have_invoice_amount;
	}

	public void setHaveInvoiceAmount( java.math.BigDecimal value ) {
		this.__have_invoice_amount = value;
	}

	public java.math.BigDecimal getLackInvoiceAmount() {
		return this.__lack_invoice_amount;
	}

	public void setLackInvoiceAmount( java.math.BigDecimal value ) {
		this.__lack_invoice_amount = value;
	}

	public java.lang.Integer getContractAttachment() {
		return this.__contract_attachment;
	}

	public void setContractAttachment( java.lang.Integer value ) {
		this.__contract_attachment = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public void cloneCopy(BasePurchaseContract __bean){
		__bean.setPurchaseContractId(getPurchaseContractId());
		__bean.setContractName(getContractName());
		__bean.setContractCode(getContractCode());
		__bean.setSupplierId(getSupplierId());
		__bean.setPurchasePerson(getPurchasePerson());
		__bean.setContractAmount(getContractAmount());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setProjectName(getProjectName());
		__bean.setQualityAssurance(getQualityAssurance());
		__bean.setContractDate(getContractDate());
		__bean.setTermOfPayment(getTermOfPayment());
		__bean.setAfterSaleRequirements(getAfterSaleRequirements());
		__bean.setAmountPaid(getAmountPaid());
		__bean.setAmountUnpaid(getAmountUnpaid());
		__bean.setHaveInvoiceAmount(getHaveInvoiceAmount());
		__bean.setLackInvoiceAmount(getLackInvoiceAmount());
		__bean.setContractAttachment(getContractAttachment());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setCreateTime(getCreateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPurchaseContractId() == null ? "" : getPurchaseContractId());
		sb.append(",");
		sb.append(getContractName() == null ? "" : getContractName());
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getPurchasePerson() == null ? "" : getPurchasePerson());
		sb.append(",");
		sb.append(getContractAmount() == null ? "" : getContractAmount());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		sb.append(getQualityAssurance() == null ? "" : getQualityAssurance());
		sb.append(",");
		sb.append(getContractDate() == null ? "" : sdf.format(getContractDate()));
		sb.append(",");
		sb.append(getTermOfPayment() == null ? "" : getTermOfPayment());
		sb.append(",");
		sb.append(getAfterSaleRequirements() == null ? "" : getAfterSaleRequirements());
		sb.append(",");
		sb.append(getAmountPaid() == null ? "" : getAmountPaid());
		sb.append(",");
		sb.append(getAmountUnpaid() == null ? "" : getAmountUnpaid());
		sb.append(",");
		sb.append(getHaveInvoiceAmount() == null ? "" : getHaveInvoiceAmount());
		sb.append(",");
		sb.append(getLackInvoiceAmount() == null ? "" : getLackInvoiceAmount());
		sb.append(",");
		sb.append(getContractAttachment() == null ? "" : getContractAttachment());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BasePurchaseContract o) {
		return __purchase_contract_id == null ? -1 : __purchase_contract_id.compareTo(o.getPurchaseContractId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__purchase_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_name);
		hash = 97 * hash + Objects.hashCode(this.__contract_code);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__purchase_person);
		hash = 97 * hash + Objects.hashCode(this.__contract_amount);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__project_name);
		hash = 97 * hash + Objects.hashCode(this.__quality_assurance);
		hash = 97 * hash + Objects.hashCode(this.__contract_date);
		hash = 97 * hash + Objects.hashCode(this.__term_of_payment);
		hash = 97 * hash + Objects.hashCode(this.__after_sale_requirements);
		hash = 97 * hash + Objects.hashCode(this.__amount_paid);
		hash = 97 * hash + Objects.hashCode(this.__amount_unpaid);
		hash = 97 * hash + Objects.hashCode(this.__have_invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__lack_invoice_amount);
		hash = 97 * hash + Objects.hashCode(this.__contract_attachment);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePurchaseContract o = (BasePurchaseContract)obj;
		if(!Objects.equals(this.__purchase_contract_id, o.getPurchaseContractId())) return false;
		if(!Objects.equals(this.__contract_name, o.getContractName())) return false;
		if(!Objects.equals(this.__contract_code, o.getContractCode())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__purchase_person, o.getPurchasePerson())) return false;
		if(!Objects.equals(this.__contract_amount, o.getContractAmount())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__project_name, o.getProjectName())) return false;
		if(!Objects.equals(this.__quality_assurance, o.getQualityAssurance())) return false;
		if(!Objects.equals(this.__contract_date, o.getContractDate())) return false;
		if(!Objects.equals(this.__term_of_payment, o.getTermOfPayment())) return false;
		if(!Objects.equals(this.__after_sale_requirements, o.getAfterSaleRequirements())) return false;
		if(!Objects.equals(this.__amount_paid, o.getAmountPaid())) return false;
		if(!Objects.equals(this.__amount_unpaid, o.getAmountUnpaid())) return false;
		if(!Objects.equals(this.__have_invoice_amount, o.getHaveInvoiceAmount())) return false;
		if(!Objects.equals(this.__lack_invoice_amount, o.getLackInvoiceAmount())) return false;
		if(!Objects.equals(this.__contract_attachment, o.getContractAttachment())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(count++, "purchaseContractId", getPurchaseContractId()));
		if(getContractName() != null) sb.append(__wrapString(count++, "contractName", getContractName()));
		if(getContractCode() != null) sb.append(__wrapString(count++, "contractCode", getContractCode()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getPurchasePerson() != null) sb.append(__wrapNumber(count++, "purchasePerson", getPurchasePerson()));
		if(getContractAmount() != null) sb.append(__wrapDecimal(count++, "contractAmount", getContractAmount()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getProjectName() != null) sb.append(__wrapString(count++, "projectName", getProjectName()));
		if(getQualityAssurance() != null) sb.append(__wrapString(count++, "qualityAssurance", getQualityAssurance()));
		if(getContractDate() != null) sb.append(__wrapDate(count++, "contractDate", getContractDate()));
		if(getTermOfPayment() != null) sb.append(__wrapString(count++, "termOfPayment", getTermOfPayment()));
		if(getAfterSaleRequirements() != null) sb.append(__wrapString(count++, "afterSaleRequirements", getAfterSaleRequirements()));
		if(getAmountPaid() != null) sb.append(__wrapDecimal(count++, "amountPaid", getAmountPaid()));
		if(getAmountUnpaid() != null) sb.append(__wrapDecimal(count++, "amountUnpaid", getAmountUnpaid()));
		if(getHaveInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "haveInvoiceAmount", getHaveInvoiceAmount()));
		if(getLackInvoiceAmount() != null) sb.append(__wrapDecimal(count++, "lackInvoiceAmount", getLackInvoiceAmount()));
		if(getContractAttachment() != null) sb.append(__wrapNumber(count++, "contractAttachment", getContractAttachment()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPurchaseContractId() != null) res.put("purchaseContractId", getPurchaseContractId());
		if(getContractName() != null) res.put("contractName", getContractName());
		if(getContractCode() != null) res.put("contractCode", getContractCode());
		if(getSupplierId() != null) res.put("supplierId", getSupplierId());
		if(getPurchasePerson() != null) res.put("purchasePerson", getPurchasePerson());
		if(getContractAmount() != null) res.put("contractAmount", getContractAmount());
		if(getMainProjectId() != null) res.put("mainProjectId", getMainProjectId());
		if(getProjectName() != null) res.put("projectName", getProjectName());
		if(getQualityAssurance() != null) res.put("qualityAssurance", getQualityAssurance());
		if(getContractDate() != null) res.put("contractDate", getContractDate());
		if(getTermOfPayment() != null) res.put("termOfPayment", getTermOfPayment());
		if(getAfterSaleRequirements() != null) res.put("afterSaleRequirements", getAfterSaleRequirements());
		if(getAmountPaid() != null) res.put("amountPaid", getAmountPaid());
		if(getAmountUnpaid() != null) res.put("amountUnpaid", getAmountUnpaid());
		if(getHaveInvoiceAmount() != null) res.put("haveInvoiceAmount", getHaveInvoiceAmount());
		if(getLackInvoiceAmount() != null) res.put("lackInvoiceAmount", getLackInvoiceAmount());
		if(getContractAttachment() != null) res.put("contractAttachment", getContractAttachment());
		if(getPersonnelBusinessId() != null) res.put("personnelBusinessId", getPersonnelBusinessId());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("purchasePerson")) != null) setPurchasePerson(__getInt(val)); 
		if((val = values.get("contractAmount")) != null) setContractAmount(__getDecimal(val));  
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("qualityAssurance")) != null) setQualityAssurance(__getString(val));
		if((val = values.get("contractDate")) != null) setContractDate(__getDate(val)); 
		if((val = values.get("termOfPayment")) != null) setTermOfPayment(__getString(val));
		if((val = values.get("afterSaleRequirements")) != null) setAfterSaleRequirements(__getString(val));
		if((val = values.get("amountPaid")) != null) setAmountPaid(__getDecimal(val));  
		if((val = values.get("amountUnpaid")) != null) setAmountUnpaid(__getDecimal(val));  
		if((val = values.get("haveInvoiceAmount")) != null) setHaveInvoiceAmount(__getDecimal(val));  
		if((val = values.get("lackInvoiceAmount")) != null) setLackInvoiceAmount(__getDecimal(val));  
		if((val = values.get("contractAttachment")) != null) setContractAttachment(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __purchase_contract_id ;
	protected java.lang.String  __contract_name ;
	protected java.lang.String  __contract_code ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.Integer  __purchase_person ;
	protected java.math.BigDecimal  __contract_amount ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.String  __project_name ;
	protected java.lang.String  __quality_assurance ;
	protected java.util.Date  __contract_date ;
	protected java.lang.String  __term_of_payment ;
	protected java.lang.String  __after_sale_requirements ;
	protected java.math.BigDecimal  __amount_paid ;
	protected java.math.BigDecimal  __amount_unpaid ;
	protected java.math.BigDecimal  __have_invoice_amount ;
	protected java.math.BigDecimal  __lack_invoice_amount ;
	protected java.lang.Integer  __contract_attachment ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.util.Date  __create_time ;
}
