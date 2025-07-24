package pomplatform.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetPurchaseProductAndSumData extends GenericCondition{

	public ConditionGetPurchaseProductAndSumData(){
		setParameterCount(6);
	}

	public java.lang.Integer getPurchaseProductDetailId() {
		return this.__purchase_product_detail_id;
	}

	public void setPurchaseProductDetailId( java.lang.Integer value ) {
		this.__purchase_product_detail_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.Integer getProductId() {
		return this.__product_id;
	}

	public void setProductId( java.lang.Integer value ) {
		this.__product_id = value;
	}

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPurchaseProductDetailId() != null) sb.append(__wrapNumber(1, "purchaseProductDetailId", getPurchaseProductDetailId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(1, "personnelBusinessId", getPersonnelBusinessId()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(1, "mainProjectId", getMainProjectId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(1, "supplierId", getSupplierId()));
		if(getProductId() != null) sb.append(__wrapNumber(1, "productId", getProductId()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(1, "purchaseContractId", getPurchaseContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("purchaseProductDetailId")) != null) setPurchaseProductDetailId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("productId")) != null) setProductId(__getInt(val)); 
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
	}

	private java.lang.Integer __purchase_product_detail_id = null;
	private java.lang.Integer __personnel_business_id = null;
	private java.lang.Integer __main_project_id = null;
	private java.lang.Integer __supplier_id = null;
	private java.lang.Integer __product_id = null;
	private java.lang.Integer __purchase_contract_id = null;
}

