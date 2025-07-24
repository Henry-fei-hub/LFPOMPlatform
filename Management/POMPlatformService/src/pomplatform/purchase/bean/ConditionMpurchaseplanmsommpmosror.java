package pomplatform.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMpurchaseplanmsommpmosror extends GenericCondition{

	public ConditionMpurchaseplanmsommpmosror(){
		setParameterCount(17);
	}

	public java.lang.Integer getToPersonnelBusinessId() {
		return this.__to_personnel_business_id;
	}

	public void setToPersonnelBusinessId( java.lang.Integer value ) {
		this.__to_personnel_business_id = value;
	}

	public java.lang.Integer getDealStatus() {
		return this.__deal_status;
	}

	public void setDealStatus( java.lang.Integer value ) {
		this.__deal_status = value;
	}

	public java.lang.Integer getPurchaseContractId() {
		return this.__purchase_contract_id;
	}

	public void setPurchaseContractId( java.lang.Integer value ) {
		this.__purchase_contract_id = value;
	}

	public java.lang.Boolean getIsComplete() {
		return this.__is_complete;
	}

	public void setIsComplete( java.lang.Boolean value ) {
		this.__is_complete = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.util.Date getMinPurchaseDate() {
		return this.__min_purchase_date;
	}

	public void setMinPurchaseDate( java.util.Date value ) {
		this.__min_purchase_date = value;
	}

	public java.util.Date getMaxPurchaseDate() {
		return this.__max_purchase_date;
	}

	public void setMaxPurchaseDate( java.util.Date value ) {
		this.__max_purchase_date = value;
	}

	public java.lang.Integer getPersonInCharge() {
		return this.__person_in_charge;
	}

	public void setPersonInCharge( java.lang.Integer value ) {
		this.__person_in_charge = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getOriPersonnelBusinessId() {
		return this.__ori_personnel_business_id;
	}

	public void setOriPersonnelBusinessId( java.lang.Integer value ) {
		this.__ori_personnel_business_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getToPersonnelBusinessId() != null) sb.append(__wrapNumber(1, "toPersonnelBusinessId", getToPersonnelBusinessId()));
		if(getDealStatus() != null) sb.append(__wrapNumber(1, "dealStatus", getDealStatus()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(1, "purchaseContractId", getPurchaseContractId()));
		if(getIsComplete() != null) sb.append(__wrapBoolean(1, "isComplete", getIsComplete()));
		if(getOperatorId() != null) sb.append(__wrapNumber(1, "operatorId", getOperatorId()));
		if(getMinPurchaseDate() != null) sb.append(__wrapDate(1, "minPurchaseDate", getMinPurchaseDate()));
		if(getMaxPurchaseDate() != null) sb.append(__wrapDate(1, "maxPurchaseDate", getMaxPurchaseDate()));
		if(getPersonInCharge() != null) sb.append(__wrapNumber(1, "personInCharge", getPersonInCharge()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(1, "mainProjectId", getMainProjectId()));
		if(getOriPersonnelBusinessId() != null) sb.append(__wrapNumber(1, "oriPersonnelBusinessId", getOriPersonnelBusinessId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(1, "supplierId", getSupplierId()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getSupplierName() != null) sb.append(__wrapString(1, "supplierName", getSupplierName()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getContractName() != null) sb.append(__wrapString(1, "contractName", getContractName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("toPersonnelBusinessId")) != null) setToPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("dealStatus")) != null) setDealStatus(__getInt(val)); 
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("isComplete")) != null) setIsComplete(__getBoolean(val));
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("minPurchaseDate")) != null) setMinPurchaseDate(__getDate(val)); 
		if((val = values.get("maxPurchaseDate")) != null) setMaxPurchaseDate(__getDate(val)); 
		if((val = values.get("personInCharge")) != null) setPersonInCharge(__getInt(val)); 
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("oriPersonnelBusinessId")) != null) setOriPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("contractName")) != null) setContractName(__getString(val));
	}

	private java.lang.Integer __to_personnel_business_id = null;
	private java.lang.Integer __deal_status = null;
	private java.lang.Integer __purchase_contract_id = null;
	private java.lang.Boolean __is_complete = null;
	private java.lang.Integer __operator_id = null;
	private java.util.Date __min_purchase_date = null;
	private java.util.Date __max_purchase_date = null;
	private java.lang.Integer __person_in_charge = null;
	private java.lang.Integer __main_project_id = null;
	private java.lang.Integer __ori_personnel_business_id = null;
	private java.lang.Integer __supplier_id = null;
	private java.lang.String __remark = null;
	private java.lang.String __project_name = null;
	private java.lang.String __project_code = null;
	private java.lang.String __supplier_name = null;
	private java.lang.String __contract_code = null;
	private java.lang.String __contract_name = null;
}

