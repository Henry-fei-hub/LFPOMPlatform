package pomplatform.companyarea.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCompanyarea extends GenericBase implements BaseFactory<BaseCompanyarea>, Comparable<BaseCompanyarea> 
{


	public static BaseCompanyarea newInstance(){
		return new BaseCompanyarea();
	}

	@Override
	public BaseCompanyarea make(){
		BaseCompanyarea b = new BaseCompanyarea();
		return b;
	}

	public final static java.lang.String CS_COMPANY_AREA_ID = "company_area_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_AREA_ID = "area_id" ;
	public final static java.lang.String CS_COMPANY_NAME = "company_name" ;
	public final static java.lang.String CS_COMPANY_CODE = "company_code" ;
	public final static java.lang.String CS_IS_ENABLED = "is_enabled" ;
	public final static java.lang.String CS_COMPANY_NO = "company_no" ;
	public final static java.lang.String CS_COMPANY_NAME_SIMPLE = "company_name_simple" ;
	public final static java.lang.String CS_AREA_NAME = "area_name" ;
	public final static java.lang.String CS_AREA_NAME_EN = "area_name_en" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_ALL_NAME = "all_name" ;
	public final static java.lang.String CS_AREA_LEVEL = "area_level" ;
	public final static java.lang.String CS_REGION = "region" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,公司,区域,公司名称,公司代码,是否启用,公司编号,公司简称,区域名称,区域英文名称,父级编码,区域全名,等级(1一线，2二线，3三线),区域";

	public java.lang.Integer getCompanyAreaId() {
		return this.__company_area_id;
	}

	public void setCompanyAreaId( java.lang.Integer value ) {
		this.__company_area_id = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getAreaId() {
		return this.__area_id;
	}

	public void setAreaId( java.lang.Integer value ) {
		this.__area_id = value;
	}

	public java.lang.String getCompanyName() {
		return this.__company_name;
	}

	public void setCompanyName( java.lang.String value ) {
		this.__company_name = value;
	}

	public java.lang.String getCompanyCode() {
		return this.__company_code;
	}

	public void setCompanyCode( java.lang.String value ) {
		this.__company_code = value;
	}

	public java.lang.Boolean getIsEnabled() {
		return this.__is_enabled;
	}

	public void setIsEnabled( java.lang.Boolean value ) {
		this.__is_enabled = value;
	}

	public java.lang.String getCompanyNo() {
		return this.__company_no;
	}

	public void setCompanyNo( java.lang.String value ) {
		this.__company_no = value;
	}

	public java.lang.String getCompanyNameSimple() {
		return this.__company_name_simple;
	}

	public void setCompanyNameSimple( java.lang.String value ) {
		this.__company_name_simple = value;
	}

	public java.lang.String getAreaName() {
		return this.__area_name;
	}

	public void setAreaName( java.lang.String value ) {
		this.__area_name = value;
	}

	public java.lang.String getAreaNameEn() {
		return this.__area_name_en;
	}

	public void setAreaNameEn( java.lang.String value ) {
		this.__area_name_en = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.String getAllName() {
		return this.__all_name;
	}

	public void setAllName( java.lang.String value ) {
		this.__all_name = value;
	}

	public java.lang.Integer getAreaLevel() {
		return this.__area_level;
	}

	public void setAreaLevel( java.lang.Integer value ) {
		this.__area_level = value;
	}

	public java.lang.Integer getRegion() {
		return this.__region;
	}

	public void setRegion( java.lang.Integer value ) {
		this.__region = value;
	}

	public void cloneCopy(BaseCompanyarea __bean){
		__bean.setCompanyAreaId(getCompanyAreaId());
		__bean.setCompanyId(getCompanyId());
		__bean.setAreaId(getAreaId());
		__bean.setCompanyName(getCompanyName());
		__bean.setCompanyCode(getCompanyCode());
		__bean.setIsEnabled(getIsEnabled());
		__bean.setCompanyNo(getCompanyNo());
		__bean.setCompanyNameSimple(getCompanyNameSimple());
		__bean.setAreaName(getAreaName());
		__bean.setAreaNameEn(getAreaNameEn());
		__bean.setParentId(getParentId());
		__bean.setAllName(getAllName());
		__bean.setAreaLevel(getAreaLevel());
		__bean.setRegion(getRegion());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCompanyAreaId() == null ? "" : getCompanyAreaId());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getAreaId() == null ? "" : getAreaId());
		sb.append(",");
		sb.append(getCompanyName() == null ? "" : getCompanyName());
		sb.append(",");
		sb.append(getCompanyCode() == null ? "" : getCompanyCode());
		sb.append(",");
		sb.append(getIsEnabled() == null ? "" : getIsEnabled());
		sb.append(",");
		sb.append(getCompanyNo() == null ? "" : getCompanyNo());
		sb.append(",");
		sb.append(getCompanyNameSimple() == null ? "" : getCompanyNameSimple());
		sb.append(",");
		sb.append(getAreaName() == null ? "" : getAreaName());
		sb.append(",");
		sb.append(getAreaNameEn() == null ? "" : getAreaNameEn());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getAllName() == null ? "" : getAllName());
		sb.append(",");
		sb.append(getAreaLevel() == null ? "" : getAreaLevel());
		sb.append(",");
		sb.append(getRegion() == null ? "" : getRegion());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCompanyarea o) {
		return __company_area_id == null ? -1 : __company_area_id.compareTo(o.getCompanyAreaId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__company_area_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__area_id);
		hash = 97 * hash + Objects.hashCode(this.__company_name);
		hash = 97 * hash + Objects.hashCode(this.__company_code);
		hash = 97 * hash + Objects.hashCode(this.__is_enabled);
		hash = 97 * hash + Objects.hashCode(this.__company_no);
		hash = 97 * hash + Objects.hashCode(this.__company_name_simple);
		hash = 97 * hash + Objects.hashCode(this.__area_name);
		hash = 97 * hash + Objects.hashCode(this.__area_name_en);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__all_name);
		hash = 97 * hash + Objects.hashCode(this.__area_level);
		hash = 97 * hash + Objects.hashCode(this.__region);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCompanyarea o = (BaseCompanyarea)obj;
		if(!Objects.equals(this.__company_area_id, o.getCompanyAreaId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__area_id, o.getAreaId())) return false;
		if(!Objects.equals(this.__company_name, o.getCompanyName())) return false;
		if(!Objects.equals(this.__company_code, o.getCompanyCode())) return false;
		if(!Objects.equals(this.__is_enabled, o.getIsEnabled())) return false;
		if(!Objects.equals(this.__company_no, o.getCompanyNo())) return false;
		if(!Objects.equals(this.__company_name_simple, o.getCompanyNameSimple())) return false;
		if(!Objects.equals(this.__area_name, o.getAreaName())) return false;
		if(!Objects.equals(this.__area_name_en, o.getAreaNameEn())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__all_name, o.getAllName())) return false;
		if(!Objects.equals(this.__area_level, o.getAreaLevel())) return false;
		if(!Objects.equals(this.__region, o.getRegion())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCompanyAreaId() != null) sb.append(__wrapNumber(count++, "companyAreaId", getCompanyAreaId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getAreaId() != null) sb.append(__wrapNumber(count++, "areaId", getAreaId()));
		if(getCompanyName() != null) sb.append(__wrapString(count++, "companyName", getCompanyName()));
		if(getCompanyCode() != null) sb.append(__wrapString(count++, "companyCode", getCompanyCode()));
		if(getIsEnabled() != null) sb.append(__wrapBoolean(count++, "isEnabled", getIsEnabled()));
		if(getCompanyNo() != null) sb.append(__wrapString(count++, "companyNo", getCompanyNo()));
		if(getCompanyNameSimple() != null) sb.append(__wrapString(count++, "companyNameSimple", getCompanyNameSimple()));
		if(getAreaName() != null) sb.append(__wrapString(count++, "areaName", getAreaName()));
		if(getAreaNameEn() != null) sb.append(__wrapString(count++, "areaNameEn", getAreaNameEn()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getAllName() != null) sb.append(__wrapString(count++, "allName", getAllName()));
		if(getAreaLevel() != null) sb.append(__wrapNumber(count++, "areaLevel", getAreaLevel()));
		if(getRegion() != null) sb.append(__wrapNumber(count++, "region", getRegion()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("companyAreaId")) != null) setCompanyAreaId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("areaId")) != null) setAreaId(__getInt(val)); 
		if((val = values.get("companyName")) != null) setCompanyName(__getString(val));
		if((val = values.get("companyCode")) != null) setCompanyCode(__getString(val));
		if((val = values.get("isEnabled")) != null) setIsEnabled(__getBoolean(val));
		if((val = values.get("companyNo")) != null) setCompanyNo(__getString(val));
		if((val = values.get("companyNameSimple")) != null) setCompanyNameSimple(__getString(val));
		if((val = values.get("areaName")) != null) setAreaName(__getString(val));
		if((val = values.get("areaNameEn")) != null) setAreaNameEn(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("allName")) != null) setAllName(__getString(val));
		if((val = values.get("areaLevel")) != null) setAreaLevel(__getInt(val)); 
		if((val = values.get("region")) != null) setRegion(__getInt(val)); 
	}

	protected java.lang.Integer  __company_area_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __area_id ;
	protected java.lang.String  __company_name ;
	protected java.lang.String  __company_code ;
	protected java.lang.Boolean  __is_enabled ;
	protected java.lang.String  __company_no ;
	protected java.lang.String  __company_name_simple ;
	protected java.lang.String  __area_name ;
	protected java.lang.String  __area_name_en ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __all_name ;
	protected java.lang.Integer  __area_level ;
	protected java.lang.Integer  __region ;
}
