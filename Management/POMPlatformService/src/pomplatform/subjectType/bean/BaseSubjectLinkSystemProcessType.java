package pomplatform.subjectType.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSubjectLinkSystemProcessType extends GenericBase implements BaseFactory<BaseSubjectLinkSystemProcessType>, Comparable<BaseSubjectLinkSystemProcessType> 
{


	public static BaseSubjectLinkSystemProcessType newInstance(){
		return new BaseSubjectLinkSystemProcessType();
	}

	@Override
	public BaseSubjectLinkSystemProcessType make(){
		BaseSubjectLinkSystemProcessType b = new BaseSubjectLinkSystemProcessType();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE_ID = "process_type_id" ;
	public final static java.lang.String CS_PROCESS_TYPE_NAME = "process_type_name" ;
	public final static java.lang.String CS_PARENT_PROCESS_TYPE_ID = "parent_process_type_id" ;
	public final static java.lang.String CS_HAS_SELECTED = "has_selected" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类别编码,流程类型名称,父级类型,是否选中";

	public java.lang.Integer getProcessTypeId() {
		return this.__process_type_id;
	}

	public void setProcessTypeId( java.lang.Integer value ) {
		this.__process_type_id = value;
	}

	public java.lang.String getProcessTypeName() {
		return this.__process_type_name;
	}

	public void setProcessTypeName( java.lang.String value ) {
		this.__process_type_name = value;
	}

	public java.lang.Integer getParentProcessTypeId() {
		return this.__parent_process_type_id;
	}

	public void setParentProcessTypeId( java.lang.Integer value ) {
		this.__parent_process_type_id = value;
	}

	public java.lang.Boolean getHasSelected() {
		return this.__has_selected;
	}

	public void setHasSelected( java.lang.Boolean value ) {
		this.__has_selected = value;
	}

	public void cloneCopy(BaseSubjectLinkSystemProcessType __bean){
		__bean.setProcessTypeId(getProcessTypeId());
		__bean.setProcessTypeName(getProcessTypeName());
		__bean.setParentProcessTypeId(getParentProcessTypeId());
		__bean.setHasSelected(getHasSelected());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessTypeId() == null ? "" : getProcessTypeId());
		sb.append(",");
		sb.append(getProcessTypeName() == null ? "" : getProcessTypeName());
		sb.append(",");
		sb.append(getParentProcessTypeId() == null ? "" : getParentProcessTypeId());
		sb.append(",");
		sb.append(getHasSelected() == null ? "" : getHasSelected());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSubjectLinkSystemProcessType o) {
		return __process_type_id == null ? -1 : __process_type_id.compareTo(o.getProcessTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type_name);
		hash = 97 * hash + Objects.hashCode(this.__parent_process_type_id);
		hash = 97 * hash + Objects.hashCode(this.__has_selected);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSubjectLinkSystemProcessType o = (BaseSubjectLinkSystemProcessType)obj;
		if(!Objects.equals(this.__process_type_id, o.getProcessTypeId())) return false;
		if(!Objects.equals(this.__process_type_name, o.getProcessTypeName())) return false;
		if(!Objects.equals(this.__parent_process_type_id, o.getParentProcessTypeId())) return false;
		if(!Objects.equals(this.__has_selected, o.getHasSelected())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessTypeId() != null) sb.append(__wrapNumber(count++, "processTypeId", getProcessTypeId()));
		if(getProcessTypeName() != null) sb.append(__wrapString(count++, "processTypeName", getProcessTypeName()));
		if(getParentProcessTypeId() != null) sb.append(__wrapNumber(count++, "parentProcessTypeId", getParentProcessTypeId()));
		if(getHasSelected() != null) sb.append(__wrapBoolean(count++, "hasSelected", getHasSelected()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processTypeId")) != null) setProcessTypeId(__getInt(val)); 
		if((val = values.get("processTypeName")) != null) setProcessTypeName(__getString(val));
		if((val = values.get("parentProcessTypeId")) != null) setParentProcessTypeId(__getInt(val)); 
		if((val = values.get("hasSelected")) != null) setHasSelected(__getBoolean(val));
	}

	protected java.lang.Integer  __process_type_id ;
	protected java.lang.String  __process_type_name ;
	protected java.lang.Integer  __parent_process_type_id ;
	protected java.lang.Boolean  __has_selected ;
}
