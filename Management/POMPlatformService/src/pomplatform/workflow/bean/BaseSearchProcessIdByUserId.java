package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSearchProcessIdByUserId extends GenericBase implements BaseFactory<BaseSearchProcessIdByUserId>, Comparable<BaseSearchProcessIdByUserId> 
{


	public static BaseSearchProcessIdByUserId newInstance(){
		return new BaseSearchProcessIdByUserId();
	}

	@Override
	public BaseSearchProcessIdByUserId make(){
		BaseSearchProcessIdByUserId b = new BaseSearchProcessIdByUserId();
		return b;
	}

	public final static java.lang.String CS_PROCESS_EXECUTE_NAME = "process_execute_name" ;
	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_ICON = "icon" ;
	public final static java.lang.String CS_PARENT_PROCESS_TYPE_ID = "parent_process_type_id" ;

	public final static java.lang.String ALL_CAPTIONS = "流程处理程序名,流程编码,图标路径,父级类型";

	public java.lang.String getProcessExecuteName() {
		return this.__process_execute_name;
	}

	public void setProcessExecuteName( java.lang.String value ) {
		this.__process_execute_name = value;
	}

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.String getIcon() {
		return this.__icon;
	}

	public void setIcon( java.lang.String value ) {
		this.__icon = value;
	}
	
	public java.lang.Integer getParentProcessTypeId() {
		return this.__parent_process_type_id;
	}

	public void setParentProcessTypeId( java.lang.Integer value ) {
		this.__parent_process_type_id = value;
	}

	public void cloneCopy(BaseSearchProcessIdByUserId __bean){
		__bean.setProcessExecuteName(getProcessExecuteName());
		__bean.setProcessId(getProcessId());
		__bean.setIcon(getIcon());
		__bean.setParentProcessTypeId(getParentProcessTypeId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessExecuteName() == null ? "" : getProcessExecuteName());
		sb.append(",");
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getIcon() == null ? "" : getIcon());
		sb.append(",");
		sb.append(getParentProcessTypeId() == null ? "" : getParentProcessTypeId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSearchProcessIdByUserId o) {
		return __process_execute_name == null ? -1 : __process_execute_name.compareTo(o.getProcessExecuteName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_execute_name);
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__icon);
		hash = 97 * hash + Objects.hashCode(this.__parent_process_type_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSearchProcessIdByUserId o = (BaseSearchProcessIdByUserId)obj;
		if(!Objects.equals(this.__process_execute_name, o.getProcessExecuteName())) return false;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__icon, o.getIcon())) return false;
		if(!Objects.equals(this.__parent_process_type_id, o.getParentProcessTypeId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessExecuteName() != null) sb.append(__wrapString(count++, "processExecuteName", getProcessExecuteName()));
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getIcon() != null) sb.append(__wrapString(count++, "icon", getIcon()));
		if(getParentProcessTypeId() != null) sb.append(__wrapNumber(count++, "parentProcessTypeId", getParentProcessTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processExecuteName")) != null) setProcessExecuteName(__getString(val));
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("icon")) != null) setIcon(__getString(val));
		if((val = values.get("parentProcessTypeId")) != null) setParentProcessTypeId(__getInt(val)); 
	}

	protected java.lang.String  __process_execute_name ;
	protected java.lang.Integer  __process_id ;
	protected java.lang.String  __icon ;
	protected java.lang.Integer  __parent_process_type_id ;
}
