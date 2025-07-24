package pomplatform.areas.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSareaaaor extends GenericBase implements BaseFactory<BaseSareaaaor>, Comparable<BaseSareaaaor> 
{


	public static BaseSareaaaor newInstance(){
		return new BaseSareaaaor();
	}

	@Override
	public BaseSareaaaor make(){
		BaseSareaaaor b = new BaseSareaaaor();
		return b;
	}

	public final static java.lang.String CS_AREA_ID = "area_id" ;
	public final static java.lang.String CS_AREA_NAME = "area_name" ;
	public final static java.lang.String CS_AREA_NAME_EN = "area_name_en" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_ALL_NAME = "all_name" ;
	public final static java.lang.String CS_AREA_LEVEL = "area_level" ;

	public final static java.lang.String ALL_CAPTIONS = "区域,区域名称,区域英文名称,父级编码,区域全名,等级";

	public java.lang.Integer getAreaId() {
		return this.__area_id;
	}

	public void setAreaId( java.lang.Integer value ) {
		this.__area_id = value;
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

	public void cloneCopy(BaseSareaaaor __bean){
		__bean.setAreaId(getAreaId());
		__bean.setAreaName(getAreaName());
		__bean.setAreaNameEn(getAreaNameEn());
		__bean.setParentId(getParentId());
		__bean.setAllName(getAllName());
		__bean.setAreaLevel(getAreaLevel());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAreaId() == null ? "" : getAreaId());
		sb.append(",");
		sb.append(getAreaName() == null ? "" : getAreaName());
		sb.append(",");
		sb.append(getAreaNameEn() == null ? "" : getAreaNameEn());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("project_types", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getAllName() == null ? "" : getAllName());
		sb.append(",");
		sb.append(getAreaLevel() == null ? "" : getAreaLevel());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSareaaaor o) {
		return __area_id == null ? -1 : __area_id.compareTo(o.getAreaId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__area_id);
		hash = 97 * hash + Objects.hashCode(this.__area_name);
		hash = 97 * hash + Objects.hashCode(this.__area_name_en);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__all_name);
		hash = 97 * hash + Objects.hashCode(this.__area_level);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSareaaaor o = (BaseSareaaaor)obj;
		if(!Objects.equals(this.__area_id, o.getAreaId())) return false;
		if(!Objects.equals(this.__area_name, o.getAreaName())) return false;
		if(!Objects.equals(this.__area_name_en, o.getAreaNameEn())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__all_name, o.getAllName())) return false;
		if(!Objects.equals(this.__area_level, o.getAreaLevel())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAreaId() != null) sb.append(__wrapNumber(count++, "areaId", getAreaId()));
		if(getAreaName() != null) sb.append(__wrapString(count++, "areaName", getAreaName()));
		if(getAreaNameEn() != null) sb.append(__wrapString(count++, "areaNameEn", getAreaNameEn()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getAllName() != null) sb.append(__wrapString(count++, "allName", getAllName()));
		if(getAreaLevel() != null) sb.append(__wrapNumber(count++, "areaLevel", getAreaLevel()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("areaId")) != null) setAreaId(__getInt(val)); 
		if((val = values.get("areaName")) != null) setAreaName(__getString(val));
		if((val = values.get("areaNameEn")) != null) setAreaNameEn(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("allName")) != null) setAllName(__getString(val));
		if((val = values.get("areaLevel")) != null) setAreaLevel(__getInt(val)); 
	}

	protected java.lang.Integer  __area_id ;
	protected java.lang.String  __area_name ;
	protected java.lang.String  __area_name_en ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __all_name ;
	protected java.lang.Integer  __area_level ;
}
