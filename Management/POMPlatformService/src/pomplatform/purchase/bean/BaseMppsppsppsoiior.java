package pomplatform.purchase.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMppsppsppsoiior extends GenericBase implements BaseFactory<BaseMppsppsppsoiior>, Comparable<BaseMppsppsppsoiior> 
{


	public static BaseMppsppsppsoiior newInstance(){
		return new BaseMppsppsppsoiior();
	}

	@Override
	public BaseMppsppsppsoiior make(){
		BaseMppsppsppsoiior b = new BaseMppsppsppsoiior();
		return b;
	}

	public final static java.lang.String CS_PRODUCT_STORAGE_ID = "product_storage_id" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_PURCHASE_CONTRACT_ID = "purchase_contract_id" ;
	public final static java.lang.String CS_PRODUCT_ID = "product_id" ;
	public final static java.lang.String CS_STORAGE_ID = "storage_id" ;
	public final static java.lang.String CS_OPERATE_TYPE = "operate_type" ;
	public final static java.lang.String CS_IN_OUT_TYPE = "in_out_type" ;
	public final static java.lang.String CS_PRODUCT_NUMBER = "product_number" ;
	public final static java.lang.String CS_PRODUCT_PRICE = "product_price" ;
	public final static java.lang.String CS_TOTAL_PRICE = "total_price" ;
	public final static java.lang.String CS_TAX_POINTS = "tax_points" ;
	public final static java.lang.String CS_TAX_PRICE = "tax_price" ;
	public final static java.lang.String CS_FINAL_PRICE = "final_price" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_IS_COMPLETE = "is_complete" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PRODUCT_MODEL = "product_model" ;
	public final static java.lang.String CS_PRODUCT_NAME = "product_name" ;
	public final static java.lang.String CS_PRODUCT_SKINS_SIZE = "product_skins_size" ;
	public final static java.lang.String CS_CATEGORY_ID = "category_id" ;
	public final static java.lang.String CS_PRODUCT_TYPE = "product_type" ;
	public final static java.lang.String CS_PRODUCT_UNIT = "product_unit" ;
	public final static java.lang.String CS_PRODUCT_SPECIFICATION = "product_specification" ;
	public final static java.lang.String CS_STORAGE_CODE = "storage_code" ;
	public final static java.lang.String CS_STORAGE_NAME = "storage_name" ;
	public final static java.lang.String CS_STORAGE_TYPE = "storage_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务表id,供应商id,采购合同id,产品id,仓库id,操作类型(对应字典表system_dictionary_210),出入库类型1入库；2出库,产品数量,产品单价,产品总价,含税点,税费,含税总金额,创建人,创建时间,是否完成,备注,产品型号,产品名称,产品外观尺寸,产品类别id,产品类型,产品单位,产品规格,仓库编号,仓库名称,仓库类型(对应字典表system_dictionary_209)";

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

	public java.lang.Integer getProductNumber() {
		return this.__product_number;
	}

	public void setProductNumber( java.lang.Integer value ) {
		this.__product_number = value;
	}

	public java.math.BigDecimal getProductPrice() {
		return this.__product_price;
	}

	public void setProductPrice( java.math.BigDecimal value ) {
		this.__product_price = value;
	}

	public java.math.BigDecimal getTotalPrice() {
		return this.__total_price;
	}

	public void setTotalPrice( java.math.BigDecimal value ) {
		this.__total_price = value;
	}

	public java.math.BigDecimal getTaxPoints() {
		return this.__tax_points;
	}

	public void setTaxPoints( java.math.BigDecimal value ) {
		this.__tax_points = value;
	}

	public java.math.BigDecimal getTaxPrice() {
		return this.__tax_price;
	}

	public void setTaxPrice( java.math.BigDecimal value ) {
		this.__tax_price = value;
	}

	public java.math.BigDecimal getFinalPrice() {
		return this.__final_price;
	}

	public void setFinalPrice( java.math.BigDecimal value ) {
		this.__final_price = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Boolean getIsComplete() {
		return this.__is_complete;
	}

	public void setIsComplete( java.lang.Boolean value ) {
		this.__is_complete = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getProductModel() {
		return this.__product_model;
	}

	public void setProductModel( java.lang.String value ) {
		this.__product_model = value;
	}

	public java.lang.String getProductName() {
		return this.__product_name;
	}

	public void setProductName( java.lang.String value ) {
		this.__product_name = value;
	}

	public java.lang.String getProductSkinsSize() {
		return this.__product_skins_size;
	}

	public void setProductSkinsSize( java.lang.String value ) {
		this.__product_skins_size = value;
	}

	public java.lang.Integer getCategoryId() {
		return this.__category_id;
	}

	public void setCategoryId( java.lang.Integer value ) {
		this.__category_id = value;
	}

	public java.lang.Integer getProductType() {
		return this.__product_type;
	}

	public void setProductType( java.lang.Integer value ) {
		this.__product_type = value;
	}

	public java.lang.String getProductUnit() {
		return this.__product_unit;
	}

	public void setProductUnit( java.lang.String value ) {
		this.__product_unit = value;
	}

	public java.lang.String getProductSpecification() {
		return this.__product_specification;
	}

	public void setProductSpecification( java.lang.String value ) {
		this.__product_specification = value;
	}

	public java.lang.String getStorageCode() {
		return this.__storage_code;
	}

	public void setStorageCode( java.lang.String value ) {
		this.__storage_code = value;
	}

	public java.lang.String getStorageName() {
		return this.__storage_name;
	}

	public void setStorageName( java.lang.String value ) {
		this.__storage_name = value;
	}

	public java.lang.Integer getStorageType() {
		return this.__storage_type;
	}

	public void setStorageType( java.lang.Integer value ) {
		this.__storage_type = value;
	}

	public void cloneCopy(BaseMppsppsppsoiior __bean){
		__bean.setProductStorageId(getProductStorageId());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setSupplierId(getSupplierId());
		__bean.setPurchaseContractId(getPurchaseContractId());
		__bean.setProductId(getProductId());
		__bean.setStorageId(getStorageId());
		__bean.setOperateType(getOperateType());
		__bean.setInOutType(getInOutType());
		__bean.setProductNumber(getProductNumber());
		__bean.setProductPrice(getProductPrice());
		__bean.setTotalPrice(getTotalPrice());
		__bean.setTaxPoints(getTaxPoints());
		__bean.setTaxPrice(getTaxPrice());
		__bean.setFinalPrice(getFinalPrice());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setIsComplete(getIsComplete());
		__bean.setRemark(getRemark());
		__bean.setProductModel(getProductModel());
		__bean.setProductName(getProductName());
		__bean.setProductSkinsSize(getProductSkinsSize());
		__bean.setCategoryId(getCategoryId());
		__bean.setProductType(getProductType());
		__bean.setProductUnit(getProductUnit());
		__bean.setProductSpecification(getProductSpecification());
		__bean.setStorageCode(getStorageCode());
		__bean.setStorageName(getStorageName());
		__bean.setStorageType(getStorageType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProductStorageId() == null ? "" : getProductStorageId());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getPurchaseContractId() == null ? "" : getPurchaseContractId());
		sb.append(",");
		sb.append(getProductId() == null ? "" : getProductId());
		sb.append(",");
		sb.append(getStorageId() == null ? "" : getStorageId());
		sb.append(",");
		sb.append(getOperateType() == null ? "" : getOperateType());
		sb.append(",");
		sb.append(getInOutType() == null ? "" : getInOutType());
		sb.append(",");
		sb.append(getProductNumber() == null ? "" : getProductNumber());
		sb.append(",");
		sb.append(getProductPrice() == null ? "" : getProductPrice());
		sb.append(",");
		sb.append(getTotalPrice() == null ? "" : getTotalPrice());
		sb.append(",");
		sb.append(getTaxPoints() == null ? "" : getTaxPoints());
		sb.append(",");
		sb.append(getTaxPrice() == null ? "" : getTaxPrice());
		sb.append(",");
		sb.append(getFinalPrice() == null ? "" : getFinalPrice());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getIsComplete() == null ? "" : getIsComplete());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getProductModel() == null ? "" : getProductModel());
		sb.append(",");
		sb.append(getProductName() == null ? "" : getProductName());
		sb.append(",");
		sb.append(getProductSkinsSize() == null ? "" : getProductSkinsSize());
		sb.append(",");
		sb.append(getCategoryId() == null ? "" : getCategoryId());
		sb.append(",");
		sb.append(getProductType() == null ? "" : getProductType());
		sb.append(",");
		sb.append(getProductUnit() == null ? "" : getProductUnit());
		sb.append(",");
		sb.append(getProductSpecification() == null ? "" : getProductSpecification());
		sb.append(",");
		sb.append(getStorageCode() == null ? "" : getStorageCode());
		sb.append(",");
		sb.append(getStorageName() == null ? "" : getStorageName());
		sb.append(",");
		sb.append(getStorageType() == null ? "" : getStorageType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMppsppsppsoiior o) {
		return __product_storage_id == null ? -1 : __product_storage_id.compareTo(o.getProductStorageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__product_storage_id);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__purchase_contract_id);
		hash = 97 * hash + Objects.hashCode(this.__product_id);
		hash = 97 * hash + Objects.hashCode(this.__storage_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_type);
		hash = 97 * hash + Objects.hashCode(this.__in_out_type);
		hash = 97 * hash + Objects.hashCode(this.__product_number);
		hash = 97 * hash + Objects.hashCode(this.__product_price);
		hash = 97 * hash + Objects.hashCode(this.__total_price);
		hash = 97 * hash + Objects.hashCode(this.__tax_points);
		hash = 97 * hash + Objects.hashCode(this.__tax_price);
		hash = 97 * hash + Objects.hashCode(this.__final_price);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__is_complete);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__product_model);
		hash = 97 * hash + Objects.hashCode(this.__product_name);
		hash = 97 * hash + Objects.hashCode(this.__product_skins_size);
		hash = 97 * hash + Objects.hashCode(this.__category_id);
		hash = 97 * hash + Objects.hashCode(this.__product_type);
		hash = 97 * hash + Objects.hashCode(this.__product_unit);
		hash = 97 * hash + Objects.hashCode(this.__product_specification);
		hash = 97 * hash + Objects.hashCode(this.__storage_code);
		hash = 97 * hash + Objects.hashCode(this.__storage_name);
		hash = 97 * hash + Objects.hashCode(this.__storage_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMppsppsppsoiior o = (BaseMppsppsppsoiior)obj;
		if(!Objects.equals(this.__product_storage_id, o.getProductStorageId())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__purchase_contract_id, o.getPurchaseContractId())) return false;
		if(!Objects.equals(this.__product_id, o.getProductId())) return false;
		if(!Objects.equals(this.__storage_id, o.getStorageId())) return false;
		if(!Objects.equals(this.__operate_type, o.getOperateType())) return false;
		if(!Objects.equals(this.__in_out_type, o.getInOutType())) return false;
		if(!Objects.equals(this.__product_number, o.getProductNumber())) return false;
		if(!Objects.equals(this.__product_price, o.getProductPrice())) return false;
		if(!Objects.equals(this.__total_price, o.getTotalPrice())) return false;
		if(!Objects.equals(this.__tax_points, o.getTaxPoints())) return false;
		if(!Objects.equals(this.__tax_price, o.getTaxPrice())) return false;
		if(!Objects.equals(this.__final_price, o.getFinalPrice())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__is_complete, o.getIsComplete())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__product_model, o.getProductModel())) return false;
		if(!Objects.equals(this.__product_name, o.getProductName())) return false;
		if(!Objects.equals(this.__product_skins_size, o.getProductSkinsSize())) return false;
		if(!Objects.equals(this.__category_id, o.getCategoryId())) return false;
		if(!Objects.equals(this.__product_type, o.getProductType())) return false;
		if(!Objects.equals(this.__product_unit, o.getProductUnit())) return false;
		if(!Objects.equals(this.__product_specification, o.getProductSpecification())) return false;
		if(!Objects.equals(this.__storage_code, o.getStorageCode())) return false;
		if(!Objects.equals(this.__storage_name, o.getStorageName())) return false;
		if(!Objects.equals(this.__storage_type, o.getStorageType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProductStorageId() != null) sb.append(__wrapNumber(count++, "productStorageId", getProductStorageId()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getPurchaseContractId() != null) sb.append(__wrapNumber(count++, "purchaseContractId", getPurchaseContractId()));
		if(getProductId() != null) sb.append(__wrapNumber(count++, "productId", getProductId()));
		if(getStorageId() != null) sb.append(__wrapNumber(count++, "storageId", getStorageId()));
		if(getOperateType() != null) sb.append(__wrapNumber(count++, "operateType", getOperateType()));
		if(getInOutType() != null) sb.append(__wrapNumber(count++, "inOutType", getInOutType()));
		if(getProductNumber() != null) sb.append(__wrapNumber(count++, "productNumber", getProductNumber()));
		if(getProductPrice() != null) sb.append(__wrapDecimal(count++, "productPrice", getProductPrice()));
		if(getTotalPrice() != null) sb.append(__wrapDecimal(count++, "totalPrice", getTotalPrice()));
		if(getTaxPoints() != null) sb.append(__wrapDecimal(count++, "taxPoints", getTaxPoints()));
		if(getTaxPrice() != null) sb.append(__wrapDecimal(count++, "taxPrice", getTaxPrice()));
		if(getFinalPrice() != null) sb.append(__wrapDecimal(count++, "finalPrice", getFinalPrice()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getIsComplete() != null) sb.append(__wrapBoolean(count++, "isComplete", getIsComplete()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProductModel() != null) sb.append(__wrapString(count++, "productModel", getProductModel()));
		if(getProductName() != null) sb.append(__wrapString(count++, "productName", getProductName()));
		if(getProductSkinsSize() != null) sb.append(__wrapString(count++, "productSkinsSize", getProductSkinsSize()));
		if(getCategoryId() != null) sb.append(__wrapNumber(count++, "categoryId", getCategoryId()));
		if(getProductType() != null) sb.append(__wrapNumber(count++, "productType", getProductType()));
		if(getProductUnit() != null) sb.append(__wrapString(count++, "productUnit", getProductUnit()));
		if(getProductSpecification() != null) sb.append(__wrapString(count++, "productSpecification", getProductSpecification()));
		if(getStorageCode() != null) sb.append(__wrapString(count++, "storageCode", getStorageCode()));
		if(getStorageName() != null) sb.append(__wrapString(count++, "storageName", getStorageName()));
		if(getStorageType() != null) sb.append(__wrapNumber(count++, "storageType", getStorageType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("productStorageId")) != null) setProductStorageId(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("purchaseContractId")) != null) setPurchaseContractId(__getInt(val)); 
		if((val = values.get("productId")) != null) setProductId(__getInt(val)); 
		if((val = values.get("storageId")) != null) setStorageId(__getInt(val)); 
		if((val = values.get("operateType")) != null) setOperateType(__getInt(val)); 
		if((val = values.get("inOutType")) != null) setInOutType(__getInt(val)); 
		if((val = values.get("productNumber")) != null) setProductNumber(__getInt(val)); 
		if((val = values.get("productPrice")) != null) setProductPrice(__getDecimal(val));  
		if((val = values.get("totalPrice")) != null) setTotalPrice(__getDecimal(val));  
		if((val = values.get("taxPoints")) != null) setTaxPoints(__getDecimal(val));  
		if((val = values.get("taxPrice")) != null) setTaxPrice(__getDecimal(val));  
		if((val = values.get("finalPrice")) != null) setFinalPrice(__getDecimal(val));  
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("isComplete")) != null) setIsComplete(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("productModel")) != null) setProductModel(__getString(val));
		if((val = values.get("productName")) != null) setProductName(__getString(val));
		if((val = values.get("productSkinsSize")) != null) setProductSkinsSize(__getString(val));
		if((val = values.get("categoryId")) != null) setCategoryId(__getInt(val)); 
		if((val = values.get("productType")) != null) setProductType(__getInt(val)); 
		if((val = values.get("productUnit")) != null) setProductUnit(__getString(val));
		if((val = values.get("productSpecification")) != null) setProductSpecification(__getString(val));
		if((val = values.get("storageCode")) != null) setStorageCode(__getString(val));
		if((val = values.get("storageName")) != null) setStorageName(__getString(val));
		if((val = values.get("storageType")) != null) setStorageType(__getInt(val)); 
	}

	protected java.lang.Integer  __product_storage_id ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.Integer  __purchase_contract_id ;
	protected java.lang.Integer  __product_id ;
	protected java.lang.Integer  __storage_id ;
	protected java.lang.Integer  __operate_type ;
	protected java.lang.Integer  __in_out_type ;
	protected java.lang.Integer  __product_number ;
	protected java.math.BigDecimal  __product_price ;
	protected java.math.BigDecimal  __total_price ;
	protected java.math.BigDecimal  __tax_points ;
	protected java.math.BigDecimal  __tax_price ;
	protected java.math.BigDecimal  __final_price ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Boolean  __is_complete ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __product_model ;
	protected java.lang.String  __product_name ;
	protected java.lang.String  __product_skins_size ;
	protected java.lang.Integer  __category_id ;
	protected java.lang.Integer  __product_type ;
	protected java.lang.String  __product_unit ;
	protected java.lang.String  __product_specification ;
	protected java.lang.String  __storage_code ;
	protected java.lang.String  __storage_name ;
	protected java.lang.Integer  __storage_type ;
}
