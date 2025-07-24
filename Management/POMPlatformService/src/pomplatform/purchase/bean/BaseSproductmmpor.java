package pomplatform.purchase.bean;

import java.util.Map;
import java.util.Objects;

import com.pomplatform.db.bean.BaseProductAttribute;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSproductmmpor extends GenericBase implements BaseFactory<BaseSproductmmpor>, Comparable<BaseSproductmmpor> 
{


	public static BaseSproductmmpor newInstance(){
		return new BaseSproductmmpor();
	}

	@Override
	public BaseSproductmmpor make(){
		BaseSproductmmpor b = new BaseSproductmmpor();
		return b;
	}

	public final static java.lang.String CS_PRODUCT_ID = "product_id" ;
	public final static java.lang.String CS_CATEGORY_ID = "category_id" ;
	public final static java.lang.String CS_PRODUCT_NAME = "product_name" ;
	public final static java.lang.String CS_PRODUCT_TYPE = "product_type" ;
	public final static java.lang.String CS_PRODUCT_MODEL = "product_model" ;
	public final static java.lang.String CS_PRODUCT_SPECIFICATION = "product_specification" ;
	public final static java.lang.String CS_PRODUCT_SKINS_SIZE = "product_skins_size" ;
	public final static java.lang.String CS_IS_ENABLED = "is_enabled" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_PROJECT_UNIT = "product_unit" ;
	

	public final static java.lang.String ALL_CAPTIONS = "主键编码,产品类别id,产品名称,产品类型,产品型号,产品规格,产品外观尺寸,是否可用,创建人,创建时间,删除标志 0未删除  1已删除,备注";

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

	public java.lang.String getProductName() {
		return this.__product_name;
	}

	public void setProductName( java.lang.String value ) {
		this.__product_name = value;
	}

	public java.lang.Integer getProductType() {
		return this.__product_type;
	}

	public void setProductType( java.lang.Integer value ) {
		this.__product_type = value;
	}

	public java.lang.String getProductModel() {
		return this.__product_model;
	}

	public void setProductModel( java.lang.String value ) {
		this.__product_model = value;
	}

	public java.lang.String getProductSpecification() {
		return this.__product_specification;
	}

	public void setProductSpecification( java.lang.String value ) {
		this.__product_specification = value;
	}

	public java.lang.String getProductSkinsSize() {
		return this.__product_skins_size;
	}

	public void setProductSkinsSize( java.lang.String value ) {
		this.__product_skins_size = value;
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

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}
	
	public java.lang.String getProductUnit() {
		return this.__product_unit;
	}

	public void setProductUnit( java.lang.String value ) {
		this.__product_unit = value;
	}

	public java.util.List<BaseProductAttribute> getDetailProductAttribute() {
		return this.__detailProductAttribute;
	}

	public void setDetailProductAttribute( java.util.List<BaseProductAttribute> value ) {
		this.__detailProductAttribute = value;
	}

	public void cloneCopy(BaseSproductmmpor __bean){
		__bean.setProductId(getProductId());
		__bean.setCategoryId(getCategoryId());
		__bean.setProductName(getProductName());
		__bean.setProductType(getProductType());
		__bean.setProductModel(getProductModel());
		__bean.setProductSpecification(getProductSpecification());
		__bean.setProductSkinsSize(getProductSkinsSize());
		__bean.setIsEnabled(getIsEnabled());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setRemark(getRemark());
		__bean.setProductUnit(getProductUnit());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProductId() == null ? "" : getProductId());
		sb.append(",");
		sb.append(getCategoryId() == null ? "" : getCategoryId());
		sb.append(",");
		sb.append(getProductName() == null ? "" : getProductName());
		sb.append(",");
		sb.append(getProductType() == null ? "" : getProductType());
		sb.append(",");
		sb.append(getProductModel() == null ? "" : getProductModel());
		sb.append(",");
		sb.append(getProductSpecification() == null ? "" : getProductSpecification());
		sb.append(",");
		sb.append(getProductSkinsSize() == null ? "" : getProductSkinsSize());
		sb.append(",");
		sb.append(getIsEnabled() == null ? "" : getIsEnabled());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSproductmmpor o) {
		return __product_id == null ? -1 : __product_id.compareTo(o.getProductId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__product_id);
		hash = 97 * hash + Objects.hashCode(this.__category_id);
		hash = 97 * hash + Objects.hashCode(this.__product_name);
		hash = 97 * hash + Objects.hashCode(this.__product_type);
		hash = 97 * hash + Objects.hashCode(this.__product_model);
		hash = 97 * hash + Objects.hashCode(this.__product_specification);
		hash = 97 * hash + Objects.hashCode(this.__product_skins_size);
		hash = 97 * hash + Objects.hashCode(this.__is_enabled);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__product_unit);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSproductmmpor o = (BaseSproductmmpor)obj;
		if(!Objects.equals(this.__product_id, o.getProductId())) return false;
		if(!Objects.equals(this.__category_id, o.getCategoryId())) return false;
		if(!Objects.equals(this.__product_name, o.getProductName())) return false;
		if(!Objects.equals(this.__product_type, o.getProductType())) return false;
		if(!Objects.equals(this.__product_model, o.getProductModel())) return false;
		if(!Objects.equals(this.__product_specification, o.getProductSpecification())) return false;
		if(!Objects.equals(this.__product_skins_size, o.getProductSkinsSize())) return false;
		if(!Objects.equals(this.__is_enabled, o.getIsEnabled())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__product_unit, o.getProductUnit())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProductId() != null) sb.append(__wrapNumber(count++, "productId", getProductId()));
		if(getCategoryId() != null) sb.append(__wrapNumber(count++, "categoryId", getCategoryId()));
		if(getProductName() != null) sb.append(__wrapString(count++, "productName", getProductName()));
		if(getProductType() != null) sb.append(__wrapNumber(count++, "productType", getProductType()));
		if(getProductModel() != null) sb.append(__wrapString(count++, "productModel", getProductModel()));
		if(getProductSpecification() != null) sb.append(__wrapString(count++, "productSpecification", getProductSpecification()));
		if(getProductSkinsSize() != null) sb.append(__wrapString(count++, "productSkinsSize", getProductSkinsSize()));
		if(getIsEnabled() != null) sb.append(__wrapBoolean(count++, "isEnabled", getIsEnabled()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getProductUnit() != null) sb.append(__wrapString(count++, "productUnit", getProductUnit()));
		if(getDetailProductAttribute() != null)  sb.append(__wrapList(count++, "detailProductAttribute", getDetailProductAttribute()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("productId")) != null) setProductId(__getInt(val)); 
		if((val = values.get("categoryId")) != null) setCategoryId(__getInt(val)); 
		if((val = values.get("productName")) != null) setProductName(__getString(val));
		if((val = values.get("productType")) != null) setProductType(__getInt(val)); 
		if((val = values.get("productModel")) != null) setProductModel(__getString(val));
		if((val = values.get("productSpecification")) != null) setProductSpecification(__getString(val));
		if((val = values.get("productSkinsSize")) != null) setProductSkinsSize(__getString(val));
		if((val = values.get("isEnabled")) != null) setIsEnabled(__getBoolean(val));
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("productUnit")) != null) setProductUnit(__getString(val));
		if((val = values.get("detailProductAttribute")) != null) setDetailProductAttribute(__getList(val, BaseProductAttribute.newInstance()));
	}

	protected java.lang.Integer  __product_id ;
	protected java.lang.Integer  __category_id ;
	protected java.lang.String  __product_name ;
	protected java.lang.Integer  __product_type ;
	protected java.lang.String  __product_model ;
	protected java.lang.String  __product_specification ;
	protected java.lang.String  __product_skins_size ;
	protected java.lang.Boolean  __is_enabled ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __product_unit ;
	protected java.util.List<BaseProductAttribute> __detailProductAttribute = null;
}
