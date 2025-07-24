package pomplatform.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPurchaseContractWithPp extends GenericCondition{

	public ConditionPurchaseContractWithPp(){
		setParameterCount(16);
	}

	public java.util.Date getMinContractDate() {
		return this.__min_contract_date;
	}

	public void setMinContractDate( java.util.Date value ) {
		this.__min_contract_date = value;
	}

	public java.util.Date getMaxContractDate() {
		return this.__max_contract_date;
	}

	public void setMaxContractDate( java.util.Date value ) {
		this.__max_contract_date = value;
	}

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
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

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getAfterSaleRequirements() {
		return this.__after_sale_requirements;
	}

	public void setAfterSaleRequirements( java.lang.String value ) {
		this.__after_sale_requirements = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getQualityAssurance() {
		return this.__quality_assurance == null ? null : (this.__quality_assurance.indexOf("%") >= 0 ? this.__quality_assurance : "%"+this.__quality_assurance+"%");
	}

	public void setQualityAssurance( java.lang.String value ) {
		this.__quality_assurance = value;
	}

	public java.lang.String getTermOfPayment() {
		return this.__term_of_payment == null ? null : (this.__term_of_payment.indexOf("%") >= 0 ? this.__term_of_payment : "%"+this.__term_of_payment+"%");
	}

	public void setTermOfPayment( java.lang.String value ) {
		this.__term_of_payment = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getSupplierName() {
		return this.__supplier_name == null ? null : (this.__supplier_name.indexOf("%") >= 0 ? this.__supplier_name : "%"+this.__supplier_name+"%");
	}

	public void setSupplierName( java.lang.String value ) {
		this.__supplier_name = value;
	}

	public java.lang.String getMajorContactPerson() {
		return this.__major_contact_person == null ? null : (this.__major_contact_person.indexOf("%") >= 0 ? this.__major_contact_person : "%"+this.__major_contact_person+"%");
	}

	public void setMajorContactPerson( java.lang.String value ) {
		this.__major_contact_person = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinContractDate() != null) sb.append(__wrapDate(1, "minContractDate", getMinContractDate()));
		if(getMaxContractDate() != null) sb.append(__wrapDate(1, "maxContractDate", getMaxContractDate()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(1, "purchaseContractId", getPurchaseContractId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(1, "supplierId", getSupplierId()));
		if(getPurchasePerson() != null) sb.append(__wrapNumber(1, "purchasePerson", getPurchasePerson()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(1, "mainProjectId", getMainProjectId()));
		if(getAfterSaleRequirements() != null) sb.append(__wrapString(1, "afterSaleRequirements", getAfterSaleRequirements()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(1, "personnelBusinessId", getPersonnelBusinessId()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getQualityAssurance() != null) sb.append(__wrapString(1, "qualityAssurance", getQualityAssurance()));
		if(getTermOfPayment() != null) sb.append(__wrapString(1, "termOfPayment", getTermOfPayment()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getSupplierName() != null) sb.append(__wrapString(1, "supplierName", getSupplierName()));
		if(getMajorContactPerson() != null) sb.append(__wrapString(1, "majorContactPerson", getMajorContactPerson()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minContractDate")) != null) setMinContractDate(__getDate(val)); 
		if((val = values.get("maxContractDate")) != null) setMaxContractDate(__getDate(val)); 
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("purchasePerson")) != null) setPurchasePerson(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("afterSaleRequirements")) != null) setAfterSaleRequirements(__getString(val));
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("qualityAssurance")) != null) setQualityAssurance(__getString(val));
		if((val = values.get("termOfPayment")) != null) setTermOfPayment(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("majorContactPerson")) != null) setMajorContactPerson(__getString(val));
	}

	private java.util.Date __min_contract_date = null;
	private java.util.Date __max_contract_date = null;
	private java.lang.Integer __purchase_contract_id = null;
	private java.lang.Integer __supplier_id = null;
	private java.lang.Integer __purchase_person = null;
	private java.lang.Integer __main_project_id = null;
	private java.lang.String __after_sale_requirements = null;
	private java.lang.Integer __personnel_business_id = null;
	private java.lang.String __contract_name = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __quality_assurance = null;
	private java.lang.String __term_of_payment = null;
	private java.lang.String __project_name = null;
	private java.lang.String __project_code = null;
	private java.lang.String __supplier_name = null;
	private java.lang.String __major_contact_person = null;
}

