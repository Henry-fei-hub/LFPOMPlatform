package pomplatform.purchase.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnStorageData extends GenericCondition{

	public ConditionOnStorageData(){
		setParameterCount(7);
	}

	public java.lang.String getStorageCode() {
		return this.__storage_code == null ? null : (this.__storage_code.indexOf("%") >= 0 ? this.__storage_code : "%"+this.__storage_code+"%");
	}

	public void setStorageCode( java.lang.String value ) {
		this.__storage_code = value;
	}

	public java.lang.String getStorageName() {
		return this.__storage_name == null ? null : (this.__storage_name.indexOf("%") >= 0 ? this.__storage_name : "%"+this.__storage_name+"%");
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

	public java.lang.Integer getStorageAreaId() {
		return this.__storage_area_id;
	}

	public void setStorageAreaId( java.lang.Integer value ) {
		this.__storage_area_id = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStorageCode() != null) sb.append(__wrapString(1, "storageCode", getStorageCode()));
		if(getStorageName() != null) sb.append(__wrapString(1, "storageName", getStorageName()));
		if(getStorageType() != null) sb.append(__wrapNumber(1, "storageType", getStorageType()));
		if(getStorageAreaId() != null) sb.append(__wrapNumber(1, "storageAreaId", getStorageAreaId()));
		if(getCountry() != null) sb.append(__wrapNumber(1, "country", getCountry()));
		if(getProvince() != null) sb.append(__wrapNumber(1, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapNumber(1, "city", getCity()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("storageCode")) != null) setStorageCode(__getString(val));
		if((val = values.get("storageName")) != null) setStorageName(__getString(val));
		if((val = values.get("storageType")) != null) setStorageType(__getInt(val)); 
		if((val = values.get("storageAreaId")) != null) setStorageAreaId(__getInt(val)); 
		if((val = values.get("country")) != null) setCountry(__getInt(val)); 
		if((val = values.get("province")) != null) setProvince(__getInt(val)); 
		if((val = values.get("city")) != null) setCity(__getInt(val)); 
	}

	private java.lang.String __storage_code = null;
	private java.lang.String __storage_name = null;
	private java.lang.Integer __storage_type = null;
	private java.lang.Integer __storage_area_id = null;
	private java.lang.Integer __country = null;
	private java.lang.Integer __province = null;
	private java.lang.Integer __city = null;
}

