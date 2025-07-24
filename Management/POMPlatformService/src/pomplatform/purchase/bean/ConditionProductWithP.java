package pomplatform.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionProductWithP extends GenericCondition{

	public ConditionProductWithP(){
		setParameterCount(11);
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

	public java.lang.String getProductModel() {
		return this.__product_model == null ? null : (this.__product_model.indexOf("%") >= 0 ? this.__product_model : "%"+this.__product_model+"%");
	}

	public void setProductModel( java.lang.String value ) {
		this.__product_model = value;
	}

	public java.lang.String getProductSpecification() {
		return this.__product_specification == null ? null : (this.__product_specification.indexOf("%") >= 0 ? this.__product_specification : "%"+this.__product_specification+"%");
	}

	public void setProductSpecification( java.lang.String value ) {
		this.__product_specification = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getProductId() {
		return this.__product_id;
	}

	public void setProductId( java.lang.Integer value ) {
		this.__product_id = value;
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

	public java.lang.Boolean getIsEnabled() {
		return this.__is_enabled;
	}

	public void setIsEnabled( java.lang.Boolean value ) {
		this.__is_enabled = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getProductModel() != null) sb.append(__wrapString(1, "productModel", getProductModel()));
		if(getProductSpecification() != null) sb.append(__wrapString(1, "productSpecification", getProductSpecification()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getProductId() != null) sb.append(__wrapNumber(1, "productId", getProductId()));
		if(getCategoryId() != null) sb.append(__wrapNumber(1, "categoryId", getCategoryId()));
		if(getProductType() != null) sb.append(__wrapNumber(1, "productType", getProductType()));
		if(getIsEnabled() != null) sb.append(__wrapBoolean(1, "isEnabled", getIsEnabled()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(1, "createEmployeeId", getCreateEmployeeId()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(1, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("productModel")) != null) setProductModel(__getString(val));
		if((val = values.get("productSpecification")) != null) setProductSpecification(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("productId")) != null) setProductId(__getInt(val)); 
		if((val = values.get("categoryId")) != null) setCategoryId(__getInt(val)); 
		if((val = values.get("productType")) != null) setProductType(__getInt(val)); 
		if((val = values.get("isEnabled")) != null) setIsEnabled(__getBoolean(val));
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.lang.String __product_model = null;
	private java.lang.String __product_specification = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __product_id = null;
	private java.lang.Integer __category_id = null;
	private java.lang.Integer __product_type = null;
	private java.lang.Boolean __is_enabled = null;
	private java.lang.Integer __create_employee_id = null;
	private java.lang.Integer __delete_flag = null;
}

