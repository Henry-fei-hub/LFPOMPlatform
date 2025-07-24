package pomplatform.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSpurchasepaymentor extends GenericCondition{

	public ConditionSpurchasepaymentor(){
		setParameterCount(23);
	}

	public java.util.Date getMinRealPaymentDate() {
		return this.__min_real_payment_date;
	}

	public void setMinRealPaymentDate( java.util.Date value ) {
		this.__min_real_payment_date = value;
	}

	public java.util.Date getMaxRealPaymentDate() {
		return this.__max_real_payment_date;
	}

	public void setMaxRealPaymentDate( java.util.Date value ) {
		this.__max_real_payment_date = value;
	}

	public java.util.Date getMinCreateTime() {
		return this.__min_create_time;
	}

	public void setMinCreateTime( java.util.Date value ) {
		this.__min_create_time = value;
	}

	public java.util.Date getMaxCreateTime() {
		return this.__max_create_time;
	}

	public void setMaxCreateTime( java.util.Date value ) {
		this.__max_create_time = value;
	}

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
	}

	public java.lang.Integer getPurchasePaymentStatus() {
		return this.__purchase_payment_status;
	}

	public void setPurchasePaymentStatus( java.lang.Integer value ) {
		this.__purchase_payment_status = value;
	}

	public java.lang.Integer getPersonInCharge() {
		return this.__person_in_charge;
	}

	public void setPersonInCharge( java.lang.Integer value ) {
		this.__person_in_charge = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.lang.String getPaymentCondition() {
		return this.__payment_condition == null ? null : (this.__payment_condition.indexOf("%") >= 0 ? this.__payment_condition : "%"+this.__payment_condition+"%");
	}

	public void setPaymentCondition( java.lang.String value ) {
		this.__payment_condition = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getPaymentName() {
		return this.__payment_name == null ? null : (this.__payment_name.indexOf("%") >= 0 ? this.__payment_name : "%"+this.__payment_name+"%");
	}

	public void setPaymentName( java.lang.String value ) {
		this.__payment_name = value;
	}

	public java.util.Date getMinPaymentDate() {
		return this.__min_payment_date;
	}

	public void setMinPaymentDate( java.util.Date value ) {
		this.__min_payment_date = value;
	}

	public java.util.Date getMaxPaymentDate() {
		return this.__max_payment_date;
	}

	public void setMaxPaymentDate( java.util.Date value ) {
		this.__max_payment_date = value;
	}

	public java.lang.Integer getPurchasePaymentId() {
		return this.__purchase_payment_id;
	}

	public void setPurchasePaymentId( java.lang.Integer value ) {
		this.__purchase_payment_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code == null ? null : (this.__contract_code.indexOf("%") >= 0 ? this.__contract_code : "%"+this.__contract_code+"%");
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.String getContractName() {
		return this.__contract_name == null ? null : (this.__contract_name.indexOf("%") >= 0 ? this.__contract_name : "%"+this.__contract_name+"%");
	}

	public void setContractName( java.lang.String value ) {
		this.__contract_name = value;
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

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.String getSupplierName() {
		return this.__supplier_name == null ? null : (this.__supplier_name.indexOf("%") >= 0 ? this.__supplier_name : "%"+this.__supplier_name+"%");
	}

	public void setSupplierName( java.lang.String value ) {
		this.__supplier_name = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
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
		if(getMinRealPaymentDate() != null) sb.append(__wrapDate(1, "minRealPaymentDate", getMinRealPaymentDate()));
		if(getMaxRealPaymentDate() != null) sb.append(__wrapDate(1, "maxRealPaymentDate", getMaxRealPaymentDate()));
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(1, "purchaseContractId", getPurchaseContractId()));
		if(getPurchasePaymentStatus() != null) sb.append(__wrapNumber(1, "purchasePaymentStatus", getPurchasePaymentStatus()));
		if(getPersonInCharge() != null) sb.append(__wrapNumber(1, "personInCharge", getPersonInCharge()));
		if(getOperatorId() != null) sb.append(__wrapNumber(1, "operatorId", getOperatorId()));
		if(getPaymentCondition() != null) sb.append(__wrapString(1, "paymentCondition", getPaymentCondition()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getPaymentName() != null) sb.append(__wrapString(1, "paymentName", getPaymentName()));
		if(getMinPaymentDate() != null) sb.append(__wrapDate(1, "minPaymentDate", getMinPaymentDate()));
		if(getMaxPaymentDate() != null) sb.append(__wrapDate(1, "maxPaymentDate", getMaxPaymentDate()));
		if(getPurchasePaymentId() != null) sb.append(__wrapNumber(1, "purchasePaymentId", getPurchasePaymentId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(1, "personnelBusinessId", getPersonnelBusinessId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(1, "mainProjectId", getMainProjectId()));
		if(getSupplierName() != null) sb.append(__wrapString(1, "supplierName", getSupplierName()));
		if(getSupplierId() != null) sb.append(__wrapNumber(1, "supplierId", getSupplierId()));
		if(getMajorContactPerson() != null) sb.append(__wrapString(1, "majorContactPerson", getMajorContactPerson()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minRealPaymentDate")) != null) setMinRealPaymentDate(__getDate(val)); 
		if((val = values.get("maxRealPaymentDate")) != null) setMaxRealPaymentDate(__getDate(val)); 
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("purchasePaymentStatus")) != null) setPurchasePaymentStatus(__getInt(val)); 
		if((val = values.get("personInCharge")) != null) setPersonInCharge(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("paymentCondition")) != null) setPaymentCondition(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("paymentName")) != null) setPaymentName(__getString(val));
		if((val = values.get("minPaymentDate")) != null) setMinPaymentDate(__getDate(val)); 
		if((val = values.get("maxPaymentDate")) != null) setMaxPaymentDate(__getDate(val)); 
		if((val = values.get("purchasePaymentId")) != null) setPurchasePaymentId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("majorContactPerson")) != null) setMajorContactPerson(__getString(val));
	}

	private java.util.Date __min_real_payment_date = null;
	private java.util.Date __max_real_payment_date = null;
	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.lang.Integer __purchase_contract_id = null;
	private java.lang.Integer __purchase_payment_status = null;
	private java.lang.Integer __person_in_charge = null;
	private java.lang.Integer __operator_id = null;
	private java.lang.String __payment_condition = null;
	private java.lang.String __remark = null;
	private java.lang.String __payment_name = null;
	private java.util.Date __min_payment_date = null;
	private java.util.Date __max_payment_date = null;
	private java.lang.Integer __purchase_payment_id = null;
	private java.lang.Integer __personnel_business_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
	private java.lang.String __project_name = null;
	private java.lang.String __project_code = null;
	private java.lang.Integer __main_project_id = null;
	private java.lang.String __supplier_name = null;
	private java.lang.Integer __supplier_id = null;
	private java.lang.String __major_contact_person = null;
}

