package pomplatform.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMppsppsppsoiior extends GenericCondition{

	public ConditionMppsppsppsoiior(){
		setParameterCount(9);
	}

	public java.lang.Integer getProductStorageId() {
		return this.__product_storage_id;
	}

	public void setProductStorageId( java.lang.Integer value ) {
		this.__product_storage_id = value;
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
	}

	public java.lang.Integer getProductId() {
		return this.__product_id;
	}

	public void setProductId( java.lang.Integer value ) {
		this.__product_id = value;
	}

	public java.lang.Integer getStorageId() {
		return this.__storage_id;
	}

	public void setStorageId( java.lang.Integer value ) {
		this.__storage_id = value;
	}

	public java.lang.Integer getOperateType() {
		return this.__operate_type;
	}

	public void setOperateType( java.lang.Integer value ) {
		this.__operate_type = value;
	}

	public java.lang.Integer getInOutType() {
		return this.__in_out_type;
	}

	public void setInOutType( java.lang.Integer value ) {
		this.__in_out_type = value;
	}

	public java.lang.Boolean getIsComplete() {
		return this.__is_complete;
	}

	public void setIsComplete( java.lang.Boolean value ) {
		this.__is_complete = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProductStorageId() != null) sb.append(__wrapNumber(1, "productStorageId", getProductStorageId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(1, "personnelBusinessId", getPersonnelBusinessId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(1, "supplierId", getSupplierId()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(1, "purchaseContractId", getPurchaseContractId()));
		if(getProductId() != null) sb.append(__wrapNumber(1, "productId", getProductId()));
		if(getStorageId() != null) sb.append(__wrapNumber(1, "storageId", getStorageId()));
		if(getOperateType() != null) sb.append(__wrapNumber(1, "operateType", getOperateType()));
		if(getInOutType() != null) sb.append(__wrapNumber(1, "inOutType", getInOutType()));
		if(getIsComplete() != null) sb.append(__wrapBoolean(1, "isComplete", getIsComplete()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("productStorageId")) != null) setProductStorageId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("productId")) != null) setProductId(__getInt(val)); 
		if((val = values.get("storageId")) != null) setStorageId(__getInt(val)); 
		if((val = values.get("operateType")) != null) setOperateType(__getInt(val)); 
		if((val = values.get("inOutType")) != null) setInOutType(__getInt(val)); 
		if((val = values.get("isComplete")) != null) setIsComplete(__getBoolean(val));
	}

	private java.lang.Integer __product_storage_id = null;
	private java.lang.Integer __personnel_business_id = null;
	private java.lang.Integer __supplier_id = null;
	private java.lang.Integer __purchase_contract_id = null;
	private java.lang.Integer __product_id = null;
	private java.lang.Integer __storage_id = null;
	private java.lang.Integer __operate_type = null;
	private java.lang.Integer __in_out_type = null;
	private java.lang.Boolean __is_complete = null;
}

