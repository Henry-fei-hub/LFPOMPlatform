package pomplatform.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadSupplierData extends GenericCondition{

	public ConditionOnLoadSupplierData(){
		setParameterCount(10);
	}

	public java.lang.String getSupplierCode() {
		return this.__supplier_code == null ? null : (this.__supplier_code.indexOf("%") >= 0 ? this.__supplier_code : "%"+this.__supplier_code+"%");
	}

	public void setSupplierCode( java.lang.String value ) {
		this.__supplier_code = value;
	}

	public java.lang.String getSupplierName() {
		return this.__supplier_name == null ? null : (this.__supplier_name.indexOf("%") >= 0 ? this.__supplier_name : "%"+this.__supplier_name+"%");
	}

	public void setSupplierName( java.lang.String value ) {
		this.__supplier_name = value;
	}

	public java.lang.Integer getSupplierType() {
		return this.__supplier_type;
	}

	public void setSupplierType( java.lang.Integer value ) {
		this.__supplier_type = value;
	}

	public java.lang.Integer getSupplierLevel() {
		return this.__supplier_level;
	}

	public void setSupplierLevel( java.lang.Integer value ) {
		this.__supplier_level = value;
	}

	public java.lang.Integer getLogisticsType() {
		return this.__logistics_type;
	}

	public void setLogisticsType( java.lang.Integer value ) {
		this.__logistics_type = value;
	}

	public java.lang.String getMajorContactPerson() {
		return this.__major_contact_person == null ? null : (this.__major_contact_person.indexOf("%") >= 0 ? this.__major_contact_person : "%"+this.__major_contact_person+"%");
	}

	public void setMajorContactPerson( java.lang.String value ) {
		this.__major_contact_person = value;
	}

	public java.lang.Integer getCountry() {
		return this.__country;
	}

	public void setCountry( java.lang.Integer value ) {
		this.__country = value;
	}

	public java.lang.Integer getProvince() {
		return this.__province;
	}

	public void setProvince( java.lang.Integer value ) {
		this.__province = value;
	}

	public java.lang.Integer getCity() {
		return this.__city;
	}

	public void setCity( java.lang.Integer value ) {
		this.__city = value;
	}

	public java.lang.String getAddress() {
		return this.__address == null ? null : (this.__address.indexOf("%") >= 0 ? this.__address : "%"+this.__address+"%");
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSupplierCode() != null) sb.append(__wrapString(1, "supplierCode", getSupplierCode()));
		if(getSupplierName() != null) sb.append(__wrapString(1, "supplierName", getSupplierName()));
		if(getSupplierType() != null) sb.append(__wrapNumber(1, "supplierType", getSupplierType()));
		if(getSupplierLevel() != null) sb.append(__wrapNumber(1, "supplierLevel", getSupplierLevel()));
		if(getLogisticsType() != null) sb.append(__wrapNumber(1, "logisticsType", getLogisticsType()));
		if(getMajorContactPerson() != null) sb.append(__wrapString(1, "majorContactPerson", getMajorContactPerson()));
		if(getCountry() != null) sb.append(__wrapNumber(1, "country", getCountry()));
		if(getProvince() != null) sb.append(__wrapNumber(1, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapNumber(1, "city", getCity()));
		if(getAddress() != null) sb.append(__wrapString(1, "address", getAddress()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("supplierCode")) != null) setSupplierCode(__getString(val));
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("supplierType")) != null) setSupplierType(__getInt(val)); 
		if((val = values.get("supplierLevel")) != null) setSupplierLevel(__getInt(val)); 
		if((val = values.get("logisticsType")) != null) setLogisticsType(__getInt(val)); 
		if((val = values.get("majorContactPerson")) != null) setMajorContactPerson(__getString(val));
		if((val = values.get("country")) != null) setCountry(__getInt(val)); 
		if((val = values.get("province")) != null) setProvince(__getInt(val)); 
		if((val = values.get("city")) != null) setCity(__getInt(val)); 
		if((val = values.get("address")) != null) setAddress(__getString(val));
	}

	private java.lang.String __supplier_code = null;
	private java.lang.String __supplier_name = null;
	private java.lang.Integer __supplier_type = null;
	private java.lang.Integer __supplier_level = null;
	private java.lang.Integer __logistics_type = null;
	private java.lang.String __major_contact_person = null;
	private java.lang.Integer __country = null;
	private java.lang.Integer __province = null;
	private java.lang.Integer __city = null;
	private java.lang.String __address = null;
}

