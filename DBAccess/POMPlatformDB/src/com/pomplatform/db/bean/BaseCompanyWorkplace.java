package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCompanyWorkplace extends GenericBase implements BaseFactory<BaseCompanyWorkplace>, Comparable<BaseCompanyWorkplace> 
{


	public static BaseCompanyWorkplace newInstance(){
		return new BaseCompanyWorkplace();
	}

	@Override
	public BaseCompanyWorkplace make(){
		BaseCompanyWorkplace b = new BaseCompanyWorkplace();
		return b;
	}

	public final static java.lang.String CS_COMPANY_WORKPLACE_ID = "company_workplace_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_WORKPLACE_NAME = "workplace_name" ;
	public final static java.lang.String CS_COUNTRY_ID = "country_id" ;
	public final static java.lang.String CS_PROVINCE_ID = "province_id" ;
	public final static java.lang.String CS_CITY_ID = "city_id" ;
	public final static java.lang.String CS_ACTIVE = "active" ;
	public final static java.lang.String CS_WORKPLACE_DIR = "workplace_dir" ;
	public final static java.lang.String CS_WORKPLACE_TYPE = "workplace_type" ;
	public final static java.lang.String CS_HAS_INIT = "has_init" ;
	public final static java.lang.String CS_BACKUP_DIR = "backup_dir" ;

	public final static java.lang.String ALL_CAPTIONS = "工作场所编码,公司代码,工作场所名称,国家代码,省代码,城市代码,是否有效,工作目录,工作场所类型 1其他（家里/出差） 2二级存储服务器,是否初始化完成,文件备份根目录";

	public java.lang.Integer getCompanyWorkplaceId() {
		return this.__company_workplace_id;
	}

	public void setCompanyWorkplaceId( java.lang.Integer value ) {
		this.__company_workplace_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.String getWorkplaceName() {
		return this.__workplace_name;
	}

	public void setWorkplaceName( java.lang.String value ) {
		this.__workplace_name = value;
	}

	public java.lang.Integer getCountryId() {
		return this.__country_id;
	}

	public void setCountryId( java.lang.Integer value ) {
		this.__country_id = value;
	}

	public java.lang.Integer getProvinceId() {
		return this.__province_id;
	}

	public void setProvinceId( java.lang.Integer value ) {
		this.__province_id = value;
	}

	public java.lang.Integer getCityId() {
		return this.__city_id;
	}

	public void setCityId( java.lang.Integer value ) {
		this.__city_id = value;
	}

	public java.lang.Boolean getActive() {
		return this.__active;
	}

	public void setActive( java.lang.Boolean value ) {
		this.__active = value;
	}

	public java.lang.String getWorkplaceDir() {
		return this.__workplace_dir;
	}

	public void setWorkplaceDir( java.lang.String value ) {
		this.__workplace_dir = value;
	}

	public java.lang.Integer getWorkplaceType() {
		return this.__workplace_type;
	}

	public void setWorkplaceType( java.lang.Integer value ) {
		this.__workplace_type = value;
	}

	public java.lang.Boolean getHasInit() {
		return this.__has_init;
	}

	public void setHasInit( java.lang.Boolean value ) {
		this.__has_init = value;
	}

	public java.lang.String getBackupDir() {
		return this.__backup_dir;
	}

	public void setBackupDir( java.lang.String value ) {
		this.__backup_dir = value;
	}

	public void cloneCopy(BaseCompanyWorkplace __bean){
		__bean.setCompanyWorkplaceId(getCompanyWorkplaceId());
		__bean.setCompanyId(getCompanyId());
		__bean.setWorkplaceName(getWorkplaceName());
		__bean.setCountryId(getCountryId());
		__bean.setProvinceId(getProvinceId());
		__bean.setCityId(getCityId());
		__bean.setActive(getActive());
		__bean.setWorkplaceDir(getWorkplaceDir());
		__bean.setWorkplaceType(getWorkplaceType());
		__bean.setHasInit(getHasInit());
		__bean.setBackupDir(getBackupDir());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyWorkplaceId() == null ? "" : getCompanyWorkplaceId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getWorkplaceName() == null ? "" : getWorkplaceName());
		sb.append(",");
		sb.append(getCountryId() == null ? "" : getCountryId());
		sb.append(",");
		sb.append(getProvinceId() == null ? "" : getProvinceId());
		sb.append(",");
		sb.append(getCityId() == null ? "" : getCityId());
		sb.append(",");
		sb.append(getActive() == null ? "" : getActive());
		sb.append(",");
		sb.append(getWorkplaceDir() == null ? "" : getWorkplaceDir());
		sb.append(",");
		sb.append(getWorkplaceType() == null ? "" : getWorkplaceType());
		sb.append(",");
		sb.append(getHasInit() == null ? "" : getHasInit());
		sb.append(",");
		sb.append(getBackupDir() == null ? "" : getBackupDir());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompanyWorkplace o) {
		return __company_workplace_id == null ? -1 : __company_workplace_id.compareTo(o.getCompanyWorkplaceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_workplace_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__workplace_name);
		hash = 97 * hash + Objects.hashCode(this.__country_id);
		hash = 97 * hash + Objects.hashCode(this.__province_id);
		hash = 97 * hash + Objects.hashCode(this.__city_id);
		hash = 97 * hash + Objects.hashCode(this.__active);
		hash = 97 * hash + Objects.hashCode(this.__workplace_dir);
		hash = 97 * hash + Objects.hashCode(this.__workplace_type);
		hash = 97 * hash + Objects.hashCode(this.__has_init);
		hash = 97 * hash + Objects.hashCode(this.__backup_dir);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompanyWorkplace o = (BaseCompanyWorkplace)obj;
		if(!Objects.equals(this.__company_workplace_id, o.getCompanyWorkplaceId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__workplace_name, o.getWorkplaceName())) return false;
		if(!Objects.equals(this.__country_id, o.getCountryId())) return false;
		if(!Objects.equals(this.__province_id, o.getProvinceId())) return false;
		if(!Objects.equals(this.__city_id, o.getCityId())) return false;
		if(!Objects.equals(this.__active, o.getActive())) return false;
		if(!Objects.equals(this.__workplace_dir, o.getWorkplaceDir())) return false;
		if(!Objects.equals(this.__workplace_type, o.getWorkplaceType())) return false;
		if(!Objects.equals(this.__has_init, o.getHasInit())) return false;
		if(!Objects.equals(this.__backup_dir, o.getBackupDir())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyWorkplaceId() != null) sb.append(__wrapNumber(count++, "companyWorkplaceId", getCompanyWorkplaceId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getWorkplaceName() != null) sb.append(__wrapString(count++, "workplaceName", getWorkplaceName()));
		if(getCountryId() != null) sb.append(__wrapNumber(count++, "countryId", getCountryId()));
		if(getProvinceId() != null) sb.append(__wrapNumber(count++, "provinceId", getProvinceId()));
		if(getCityId() != null) sb.append(__wrapNumber(count++, "cityId", getCityId()));
		if(getActive() != null) sb.append(__wrapBoolean(count++, "active", getActive()));
		if(getWorkplaceDir() != null) sb.append(__wrapString(count++, "workplaceDir", getWorkplaceDir()));
		if(getWorkplaceType() != null) sb.append(__wrapNumber(count++, "workplaceType", getWorkplaceType()));
		if(getHasInit() != null) sb.append(__wrapBoolean(count++, "hasInit", getHasInit()));
		if(getBackupDir() != null) sb.append(__wrapString(count++, "backupDir", getBackupDir()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCompanyWorkplaceId() != null) res.put("companyWorkplaceId", getCompanyWorkplaceId());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getWorkplaceName() != null) res.put("workplaceName", getWorkplaceName());
		if(getCountryId() != null) res.put("countryId", getCountryId());
		if(getProvinceId() != null) res.put("provinceId", getProvinceId());
		if(getCityId() != null) res.put("cityId", getCityId());
		if(getActive() != null) res.put("active", getActive());
		if(getWorkplaceDir() != null) res.put("workplaceDir", getWorkplaceDir());
		if(getWorkplaceType() != null) res.put("workplaceType", getWorkplaceType());
		if(getHasInit() != null) res.put("hasInit", getHasInit());
		if(getBackupDir() != null) res.put("backupDir", getBackupDir());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyWorkplaceId")) != null) setCompanyWorkplaceId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("workplaceName")) != null) setWorkplaceName(__getString(val));
		if((val = values.get("countryId")) != null) setCountryId(__getInt(val)); 
		if((val = values.get("provinceId")) != null) setProvinceId(__getInt(val)); 
		if((val = values.get("cityId")) != null) setCityId(__getInt(val)); 
		if((val = values.get("active")) != null) setActive(__getBoolean(val));
		if((val = values.get("workplaceDir")) != null) setWorkplaceDir(__getString(val));
		if((val = values.get("workplaceType")) != null) setWorkplaceType(__getInt(val)); 
		if((val = values.get("hasInit")) != null) setHasInit(__getBoolean(val));
		if((val = values.get("backupDir")) != null) setBackupDir(__getString(val));
	}

	protected java.lang.Integer  __company_workplace_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __workplace_name ;
	protected java.lang.Integer  __country_id ;
	protected java.lang.Integer  __province_id ;
	protected java.lang.Integer  __city_id ;
	protected java.lang.Boolean  __active ;
	protected java.lang.String  __workplace_dir ;
	protected java.lang.Integer  __workplace_type ;
	protected java.lang.Boolean  __has_init ;
	protected java.lang.String  __backup_dir ;
}
