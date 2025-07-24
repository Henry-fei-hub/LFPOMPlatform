package pomplatform.subjectType.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSubjectTypeLinkDepartment extends GenericBase implements BaseFactory<BaseSubjectTypeLinkDepartment>, Comparable<BaseSubjectTypeLinkDepartment> 
{


	public static BaseSubjectTypeLinkDepartment newInstance(){
		return new BaseSubjectTypeLinkDepartment();
	}

	@Override
	public BaseSubjectTypeLinkDepartment make(){
		BaseSubjectTypeLinkDepartment b = new BaseSubjectTypeLinkDepartment();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_DEPARTMENT_NAME = "department_name" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_HAS_SELECTED = "has_selected" ;

	public final static java.lang.String ALL_CAPTIONS = "部门编码,部门名称,上级部门,是否选中";

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

	public java.lang.Boolean getHasSelected() {
		return this.__has_selected;
	}

	public void setHasSelected( java.lang.Boolean value ) {
		this.__has_selected = value;
	}

	public void cloneCopy(BaseSubjectTypeLinkDepartment __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setDepartmentName(getDepartmentName());
		__bean.setParentId(getParentId());
		__bean.setHasSelected(getHasSelected());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getHasSelected() == null ? "" : getHasSelected());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSubjectTypeLinkDepartment o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__has_selected);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSubjectTypeLinkDepartment o = (BaseSubjectTypeLinkDepartment)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__has_selected, o.getHasSelected())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getHasSelected() != null) sb.append(__wrapBoolean(count++, "hasSelected", getHasSelected()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("hasSelected")) != null) setHasSelected(__getBoolean(val));
	}

	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __department_name ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Boolean  __has_selected ;
}
