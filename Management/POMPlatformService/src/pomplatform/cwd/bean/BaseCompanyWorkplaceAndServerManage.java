package pomplatform.cwd.bean;

import java.util.Map;
import java.util.Objects;

import com.pomplatform.db.bean.BaseCompanyWorkplaceServer;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseCompanyWorkplaceAndServerManage extends GenericBase implements BaseFactory<BaseCompanyWorkplaceAndServerManage>, Comparable<BaseCompanyWorkplaceAndServerManage> 
{


	public static BaseCompanyWorkplaceAndServerManage newInstance(){
		return new BaseCompanyWorkplaceAndServerManage();
	}

	@Override
	public BaseCompanyWorkplaceAndServerManage make(){
		BaseCompanyWorkplaceAndServerManage b = new BaseCompanyWorkplaceAndServerManage();
		return b;
	}

	public final static java.lang.String CS_COMPANY_WORKPLACE_ID = "company_workplace_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_WORKPLACE_NAME = "workplace_name" ;
	public final static java.lang.String CS_COUNTRY_ID = "country_id" ;
	public final static java.lang.String CS_PROVINCE_ID = "province_id" ;
	public final static java.lang.String CS_CITY_ID = "city_id" ;
	public final static java.lang.String CS_WORKPLACE_DIR = "workplace_dir" ;
	public final static java.lang.String CS_WORKPLACE_TYPE = "workplace_type" ;
	public final static java.lang.String CS_HAS_INIT = "has_init" ;
	public final static java.lang.String CS_ACTIVE = "active" ;

	public final static java.lang.String ALL_CAPTIONS = "工作场所编码,公司,工作场所名称,国家,省份,城市,工作目录,工作场所类型 1其他（家里/出差） 2二级存储服务器,是否初始化完成,是否有效";

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

	public java.lang.Boolean getActive() {
		return this.__active;
	}

	public void setActive( java.lang.Boolean value ) {
		this.__active = value;
	}

	public java.util.List<BaseCompanyWorkplaceServer> getDetailCompanyWorkplaceServer() {
		return this.__detailCompanyWorkplaceServer;
	}

	public void setDetailCompanyWorkplaceServer( java.util.List<BaseCompanyWorkplaceServer> value ) {
		this.__detailCompanyWorkplaceServer = value;
	}

	public void cloneCopy(BaseCompanyWorkplaceAndServerManage __bean){
		__bean.setCompanyWorkplaceId(getCompanyWorkplaceId());
		__bean.setCompanyId(getCompanyId());
		__bean.setWorkplaceName(getWorkplaceName());
		__bean.setCountryId(getCountryId());
		__bean.setProvinceId(getProvinceId());
		__bean.setCityId(getCityId());
		__bean.setWorkplaceDir(getWorkplaceDir());
		__bean.setWorkplaceType(getWorkplaceType());
		__bean.setHasInit(getHasInit());
		__bean.setActive(getActive());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyWorkplaceId() == null ? "" : getCompanyWorkplaceId());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getWorkplaceName() == null ? "" : getWorkplaceName());
		sb.append(",");
		sb.append(getCountryId() == null ? "" : getCountryId());
		sb.append(",");
		String strProvinceId = delicacy.system.executor.SelectValueCache.getSelectValue("provinces", String.valueOf(getProvinceId()));
		sb.append(strProvinceId == null ? "" : strProvinceId);
		sb.append(",");
		sb.append(getCityId() == null ? "" : getCityId());
		sb.append(",");
		sb.append(getWorkplaceDir() == null ? "" : getWorkplaceDir());
		sb.append(",");
		sb.append(getWorkplaceType() == null ? "" : getWorkplaceType());
		sb.append(",");
		sb.append(getHasInit() == null ? "" : getHasInit());
		sb.append(",");
		sb.append(getActive() == null ? "" : getActive());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompanyWorkplaceAndServerManage o) {
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
		hash = 97 * hash + Objects.hashCode(this.__workplace_dir);
		hash = 97 * hash + Objects.hashCode(this.__workplace_type);
		hash = 97 * hash + Objects.hashCode(this.__has_init);
		hash = 97 * hash + Objects.hashCode(this.__active);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompanyWorkplaceAndServerManage o = (BaseCompanyWorkplaceAndServerManage)obj;
		if(!Objects.equals(this.__company_workplace_id, o.getCompanyWorkplaceId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__workplace_name, o.getWorkplaceName())) return false;
		if(!Objects.equals(this.__country_id, o.getCountryId())) return false;
		if(!Objects.equals(this.__province_id, o.getProvinceId())) return false;
		if(!Objects.equals(this.__city_id, o.getCityId())) return false;
		if(!Objects.equals(this.__workplace_dir, o.getWorkplaceDir())) return false;
		if(!Objects.equals(this.__workplace_type, o.getWorkplaceType())) return false;
		if(!Objects.equals(this.__has_init, o.getHasInit())) return false;
		if(!Objects.equals(this.__active, o.getActive())) return false;
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
		if(getWorkplaceDir() != null) sb.append(__wrapString(count++, "workplaceDir", getWorkplaceDir()));
		if(getWorkplaceType() != null) sb.append(__wrapNumber(count++, "workplaceType", getWorkplaceType()));
		if(getHasInit() != null) sb.append(__wrapBoolean(count++, "hasInit", getHasInit()));
		if(getActive() != null) sb.append(__wrapBoolean(count++, "active", getActive()));
		if(getDetailCompanyWorkplaceServer() != null)  sb.append(__wrapList(count++, "detailCompanyWorkplaceServer", getDetailCompanyWorkplaceServer()));
		return sb.toString();
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
		if((val = values.get("workplaceDir")) != null) setWorkplaceDir(__getString(val));
		if((val = values.get("workplaceType")) != null) setWorkplaceType(__getInt(val)); 
		if((val = values.get("hasInit")) != null) setHasInit(__getBoolean(val));
		if((val = values.get("active")) != null) setActive(__getBoolean(val));
		if((val = values.get("detailCompanyWorkplaceServer")) != null) setDetailCompanyWorkplaceServer(__getList(val, BaseCompanyWorkplaceServer.newInstance()));
	}

	protected java.lang.Integer  __company_workplace_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.String  __workplace_name ;
	protected java.lang.Integer  __country_id ;
	protected java.lang.Integer  __province_id ;
	protected java.lang.Integer  __city_id ;
	protected java.lang.String  __workplace_dir ;
	protected java.lang.Integer  __workplace_type ;
	protected java.lang.Boolean  __has_init ;
	protected java.lang.Boolean  __active ;
	protected java.util.List<BaseCompanyWorkplaceServer> __detailCompanyWorkplaceServer = null;
}
