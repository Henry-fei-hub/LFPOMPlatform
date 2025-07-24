package pomplatform.department.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadDepartmentByParentId extends GenericBase implements BaseFactory<BaseOnLoadDepartmentByParentId>, Comparable<BaseOnLoadDepartmentByParentId> 
{


	public static BaseOnLoadDepartmentByParentId newInstance(){
		return new BaseOnLoadDepartmentByParentId();
	}

	@Override
	public BaseOnLoadDepartmentByParentId make(){
		BaseOnLoadDepartmentByParentId b = new BaseOnLoadDepartmentByParentId();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_DEPARTMENT_NAME = "department_name" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;

	public final static java.lang.String ALL_CAPTIONS = "部门编码,部门名称,上级部门";

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

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public void cloneCopy(BaseOnLoadDepartmentByParentId __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setDepartmentName(getDepartmentName());
		__bean.setParentId(getParentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadDepartmentByParentId o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadDepartmentByParentId o = (BaseOnLoadDepartmentByParentId)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getDepartmentName() != null) res.put("departmentName", getDepartmentName());
		if(getParentId() != null) res.put("parentId", getParentId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
	}

	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __department_name ;
	protected java.lang.Integer  __parent_id ;
}
