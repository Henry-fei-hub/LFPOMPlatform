package pomplatform.purchase.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnStorageData extends GenericBase implements BaseFactory<BaseOnStorageData>, Comparable<BaseOnStorageData> 
{


	public static BaseOnStorageData newInstance(){
		return new BaseOnStorageData();
	}

	@Override
	public BaseOnStorageData make(){
		BaseOnStorageData b = new BaseOnStorageData();
		return b;
	}

	public final static java.lang.String CS_STORAGE_ID = "storage_id" ;
	public final static java.lang.String CS_STORAGE_CODE = "storage_code" ;
	public final static java.lang.String CS_STORAGE_NAME = "storage_name" ;
	public final static java.lang.String CS_STORAGE_TYPE = "storage_type" ;
	public final static java.lang.String CS_STORAGE_AREA_ID = "storage_area_id" ;
	public final static java.lang.String CS_COUNTRY = "country" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_CONTACT_EMPLOYEE_ID = "contact_employee_id" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_IS_ENABLED = "is_enabled" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,仓库编号,仓库名称,仓库类型(对应字典表system_dictionary_209),地区编码,所在国家,所在省份,所在城市,详细地址,联系人,联系电话,父级id,创建人,创建时间,是否可用,备注";

	public java.lang.Integer getStorageId() {
		return this.__storage_id;
	}

	public void setStorageId( java.lang.Integer value ) {
		this.__storage_id = value;
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

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.lang.Integer getContactEmployeeId() {
		return this.__contact_employee_id;
	}

	public void setContactEmployeeId( java.lang.Integer value ) {
		this.__contact_employee_id = value;
	}

	public java.lang.String getContactPhone() {
		return this.__contact_phone;
	}

	public void setContactPhone( java.lang.String value ) {
		this.__contact_phone = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
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

	public java.lang.Boolean getIsEnabled() {
		return this.__is_enabled;
	}

	public void setIsEnabled( java.lang.Boolean value ) {
		this.__is_enabled = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseOnStorageData __bean){
		__bean.setStorageId(getStorageId());
		__bean.setStorageCode(getStorageCode());
		__bean.setStorageName(getStorageName());
		__bean.setStorageType(getStorageType());
		__bean.setStorageAreaId(getStorageAreaId());
		__bean.setCountry(getCountry());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setAddress(getAddress());
		__bean.setContactEmployeeId(getContactEmployeeId());
		__bean.setContactPhone(getContactPhone());
		__bean.setParentId(getParentId());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setIsEnabled(getIsEnabled());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getStorageId() == null ? "" : getStorageId());
		sb.append(",");
		sb.append(getStorageCode() == null ? "" : getStorageCode());
		sb.append(",");
		sb.append(getStorageName() == null ? "" : getStorageName());
		sb.append(",");
		String strStorageType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_209", String.valueOf(getStorageType()));
		sb.append(strStorageType == null ? "" : strStorageType);
		sb.append(",");
		String strStorageAreaId = delicacy.system.executor.SelectValueCache.getSelectValue("storage_areas", String.valueOf(getStorageAreaId()));
		sb.append(strStorageAreaId == null ? "" : strStorageAreaId);
		sb.append(",");
		String strCountry = delicacy.system.executor.SelectValueCache.getSelectValue("countries", String.valueOf(getCountry()));
		sb.append(strCountry == null ? "" : strCountry);
		sb.append(",");
		String strProvince = delicacy.system.executor.SelectValueCache.getSelectValue("areas", String.valueOf(getProvince()));
		sb.append(strProvince == null ? "" : strProvince);
		sb.append(",");
		String strCity = delicacy.system.executor.SelectValueCache.getSelectValue("areas", String.valueOf(getCity()));
		sb.append(strCity == null ? "" : strCity);
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getContactEmployeeId() == null ? "" : getContactEmployeeId());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getIsEnabled() == null ? "" : getIsEnabled());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnStorageData o) {
		return __storage_id == null ? -1 : __storage_id.compareTo(o.getStorageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__storage_id);
		hash = 97 * hash + Objects.hashCode(this.__storage_code);
		hash = 97 * hash + Objects.hashCode(this.__storage_name);
		hash = 97 * hash + Objects.hashCode(this.__storage_type);
		hash = 97 * hash + Objects.hashCode(this.__storage_area_id);
		hash = 97 * hash + Objects.hashCode(this.__country);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__contact_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__is_enabled);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnStorageData o = (BaseOnStorageData)obj;
		if(!Objects.equals(this.__storage_id, o.getStorageId())) return false;
		if(!Objects.equals(this.__storage_code, o.getStorageCode())) return false;
		if(!Objects.equals(this.__storage_name, o.getStorageName())) return false;
		if(!Objects.equals(this.__storage_type, o.getStorageType())) return false;
		if(!Objects.equals(this.__storage_area_id, o.getStorageAreaId())) return false;
		if(!Objects.equals(this.__country, o.getCountry())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__contact_employee_id, o.getContactEmployeeId())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__is_enabled, o.getIsEnabled())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStorageId() != null) sb.append(__wrapNumber(count++, "storageId", getStorageId()));
		if(getStorageCode() != null) sb.append(__wrapString(count++, "storageCode", getStorageCode()));
		if(getStorageName() != null) sb.append(__wrapString(count++, "storageName", getStorageName()));
		if(getStorageType() != null) sb.append(__wrapNumber(count++, "storageType", getStorageType()));
		if(getStorageAreaId() != null) sb.append(__wrapNumber(count++, "storageAreaId", getStorageAreaId()));
		if(getCountry() != null) sb.append(__wrapNumber(count++, "country", getCountry()));
		if(getProvince() != null) sb.append(__wrapNumber(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapNumber(count++, "city", getCity()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getContactEmployeeId() != null) sb.append(__wrapNumber(count++, "contactEmployeeId", getContactEmployeeId()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getIsEnabled() != null) sb.append(__wrapBoolean(count++, "isEnabled", getIsEnabled()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("storageId")) != null) setStorageId(__getInt(val)); 
		if((val = values.get("storageCode")) != null) setStorageCode(__getString(val));
		if((val = values.get("storageName")) != null) setStorageName(__getString(val));
		if((val = values.get("storageType")) != null) setStorageType(__getInt(val)); 
		if((val = values.get("storageAreaId")) != null) setStorageAreaId(__getInt(val)); 
		if((val = values.get("country")) != null) setCountry(__getInt(val)); 
		if((val = values.get("province")) != null) setProvince(__getInt(val)); 
		if((val = values.get("city")) != null) setCity(__getInt(val)); 
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("contactEmployeeId")) != null) setContactEmployeeId(__getInt(val)); 
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("isEnabled")) != null) setIsEnabled(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __storage_id ;
	protected java.lang.String  __storage_code ;
	protected java.lang.String  __storage_name ;
	protected java.lang.Integer  __storage_type ;
	protected java.lang.Integer  __storage_area_id ;
	protected java.lang.Integer  __country ;
	protected java.lang.Integer  __province ;
	protected java.lang.Integer  __city ;
	protected java.lang.String  __address ;
	protected java.lang.Integer  __contact_employee_id ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.Boolean  __is_enabled ;
	protected java.lang.String  __remark ;
}
