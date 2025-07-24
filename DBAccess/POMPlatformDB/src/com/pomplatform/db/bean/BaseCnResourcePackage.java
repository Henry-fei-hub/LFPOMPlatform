package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCnResourcePackage extends GenericBase implements BaseFactory<BaseCnResourcePackage>, Comparable<BaseCnResourcePackage> 
{


	public static BaseCnResourcePackage newInstance(){
		return new BaseCnResourcePackage();
	}

	@Override
	public BaseCnResourcePackage make(){
		BaseCnResourcePackage b = new BaseCnResourcePackage();
		return b;
	}

	public final static java.lang.String CS_RESOURCE_PACKAGE_ID = "resource_package_id" ;
	public final static java.lang.String CS_PACKAGE_NAME = "package_name" ;
	public final static java.lang.String CS_PACKAGE_CODE = "package_code" ;
	public final static java.lang.String CS_CREATOR = "creator" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_DELETE_FLAG = "delete_flag" ;
	public final static java.lang.String CS_ORGANIZATION_ID = "organization_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,包名称(预留),包编号(预留),创建人,创建时间,删除标志 0 未删除 1已删除,组织机构代码";

	public java.lang.Integer getResourcePackageId() {
		return this.__resource_package_id;
	}

	public void setResourcePackageId( java.lang.Integer value ) {
		this.__resource_package_id = value;
	}

	public java.lang.String getPackageName() {
		return this.__package_name;
	}

	public void setPackageName( java.lang.String value ) {
		this.__package_name = value;
	}

	public java.lang.String getPackageCode() {
		return this.__package_code;
	}

	public void setPackageCode( java.lang.String value ) {
		this.__package_code = value;
	}

	public java.lang.Integer getCreator() {
		return this.__creator;
	}

	public void setCreator( java.lang.Integer value ) {
		this.__creator = value;
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

	public java.lang.Integer getOrganizationId() {
		return this.__organization_id;
	}

	public void setOrganizationId( java.lang.Integer value ) {
		this.__organization_id = value;
	}

	public void cloneCopy(BaseCnResourcePackage __bean){
		__bean.setResourcePackageId(getResourcePackageId());
		__bean.setPackageName(getPackageName());
		__bean.setPackageCode(getPackageCode());
		__bean.setCreator(getCreator());
		__bean.setCreateTime(getCreateTime());
		__bean.setDeleteFlag(getDeleteFlag());
		__bean.setOrganizationId(getOrganizationId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getResourcePackageId() == null ? "" : getResourcePackageId());
		sb.append(",");
		sb.append(getPackageName() == null ? "" : getPackageName());
		sb.append(",");
		sb.append(getPackageCode() == null ? "" : getPackageCode());
		sb.append(",");
		sb.append(getCreator() == null ? "" : getCreator());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getDeleteFlag() == null ? "" : getDeleteFlag());
		sb.append(",");
		sb.append(getOrganizationId() == null ? "" : getOrganizationId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCnResourcePackage o) {
		return __resource_package_id == null ? -1 : __resource_package_id.compareTo(o.getResourcePackageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__resource_package_id);
		hash = 97 * hash + Objects.hashCode(this.__package_name);
		hash = 97 * hash + Objects.hashCode(this.__package_code);
		hash = 97 * hash + Objects.hashCode(this.__creator);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__delete_flag);
		hash = 97 * hash + Objects.hashCode(this.__organization_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCnResourcePackage o = (BaseCnResourcePackage)obj;
		if(!Objects.equals(this.__resource_package_id, o.getResourcePackageId())) return false;
		if(!Objects.equals(this.__package_name, o.getPackageName())) return false;
		if(!Objects.equals(this.__package_code, o.getPackageCode())) return false;
		if(!Objects.equals(this.__creator, o.getCreator())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__delete_flag, o.getDeleteFlag())) return false;
		if(!Objects.equals(this.__organization_id, o.getOrganizationId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getResourcePackageId() != null) sb.append(__wrapNumber(count++, "resourcePackageId", getResourcePackageId()));
		if(getPackageName() != null) sb.append(__wrapString(count++, "packageName", getPackageName()));
		if(getPackageCode() != null) sb.append(__wrapString(count++, "packageCode", getPackageCode()));
		if(getCreator() != null) sb.append(__wrapNumber(count++, "creator", getCreator()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(count++, "deleteFlag", getDeleteFlag()));
		if(getOrganizationId() != null) sb.append(__wrapNumber(count++, "organizationId", getOrganizationId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getResourcePackageId() != null) res.put("resourcePackageId", getResourcePackageId());
		if(getPackageName() != null) res.put("packageName", getPackageName());
		if(getPackageCode() != null) res.put("packageCode", getPackageCode());
		if(getCreator() != null) res.put("creator", getCreator());
		if(getCreateTime() != null) res.put("createTime", getCreateTime());
		if(getDeleteFlag() != null) res.put("deleteFlag", getDeleteFlag());
		if(getOrganizationId() != null) res.put("organizationId", getOrganizationId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("resourcePackageId")) != null) setResourcePackageId(__getInt(val)); 
		if((val = values.get("packageName")) != null) setPackageName(__getString(val));
		if((val = values.get("packageCode")) != null) setPackageCode(__getString(val));
		if((val = values.get("creator")) != null) setCreator(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("organizationId")) != null) setOrganizationId(__getInt(val)); 
	}

	protected java.lang.Integer  __resource_package_id ;
	protected java.lang.String  __package_name ;
	protected java.lang.String  __package_code ;
	protected java.lang.Integer  __creator ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __delete_flag ;
	protected java.lang.Integer  __organization_id ;
}
