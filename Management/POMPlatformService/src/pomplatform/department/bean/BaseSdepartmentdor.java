package pomplatform.department.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSdepartmentdor extends GenericBase implements BaseFactory<BaseSdepartmentdor>, Comparable<BaseSdepartmentdor> 
{


	public static BaseSdepartmentdor newInstance(){
		return new BaseSdepartmentdor();
	}

	@Override
	public BaseSdepartmentdor make(){
		BaseSdepartmentdor b = new BaseSdepartmentdor();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_DEPARTMENT_NAME = "department_name" ;
	public final static java.lang.String CS_ABBREVIATION = "abbreviation" ;
	public final static java.lang.String CS_MANAGER_ID = "manager_id" ;
	public final static java.lang.String CS_MANAGER_NAME = "manager_name" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;

	public final static java.lang.String ALL_CAPTIONS = "部门编码,部门名称,部门名称缩写,部门负责编码,部门负责人姓名,上级部门,是否有效";

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getDepartmentName() {
		return this.__department_name;
	}

	public void setDepartmentName( java.lang.String value ) {
		this.__department_name = value;
	}

	public java.lang.String getAbbreviation() {
		return this.__abbreviation;
	}

	public void setAbbreviation( java.lang.String value ) {
		this.__abbreviation = value;
	}

	public java.lang.Integer getManagerId() {
		return this.__manager_id;
	}

	public void setManagerId( java.lang.Integer value ) {
		this.__manager_id = value;
	}

	public java.lang.String getManagerName() {
		return this.__manager_name;
	}

	public void setManagerName( java.lang.String value ) {
		this.__manager_name = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public void cloneCopy(BaseSdepartmentdor __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setDepartmentName(getDepartmentName());
		__bean.setAbbreviation(getAbbreviation());
		__bean.setManagerId(getManagerId());
		__bean.setManagerName(getManagerName());
		__bean.setParentId(getParentId());
		__bean.setEnabled(getEnabled());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		sb.append(",");
		sb.append(getAbbreviation() == null ? "" : getAbbreviation());
		sb.append(",");
		String strManagerId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getManagerId()));
		sb.append(strManagerId == null ? "" : strManagerId);
		sb.append(",");
		sb.append(getManagerName() == null ? "" : getManagerName());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSdepartmentdor o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__abbreviation);
		hash = 97 * hash + Objects.hashCode(this.__manager_id);
		hash = 97 * hash + Objects.hashCode(this.__manager_name);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSdepartmentdor o = (BaseSdepartmentdor)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__abbreviation, o.getAbbreviation())) return false;
		if(!Objects.equals(this.__manager_id, o.getManagerId())) return false;
		if(!Objects.equals(this.__manager_name, o.getManagerName())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getAbbreviation() != null) sb.append(__wrapString(count++, "abbreviation", getAbbreviation()));
		if(getManagerId() != null) sb.append(__wrapNumber(count++, "managerId", getManagerId()));
		if(getManagerName() != null) sb.append(__wrapString(count++, "managerName", getManagerName()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("abbreviation")) != null) setAbbreviation(__getString(val));
		if((val = values.get("managerId")) != null) setManagerId(__getInt(val)); 
		if((val = values.get("managerName")) != null) setManagerName(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
	}

	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __department_name ;
	protected java.lang.String  __abbreviation ;
	protected java.lang.Integer  __manager_id ;
	protected java.lang.String  __manager_name ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Boolean  __enabled ;
}
