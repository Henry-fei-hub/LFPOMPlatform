package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetProcessByTypeAndDepartment extends GenericBase implements BaseFactory<BaseGetProcessByTypeAndDepartment>, Comparable<BaseGetProcessByTypeAndDepartment> 
{


	public static BaseGetProcessByTypeAndDepartment newInstance(){
		return new BaseGetProcessByTypeAndDepartment();
	}

	@Override
	public BaseGetProcessByTypeAndDepartment make(){
		BaseGetProcessByTypeAndDepartment b = new BaseGetProcessByTypeAndDepartment();
		return b;
	}

	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_TYPE_ID = "process_type_id" ;
	public final static java.lang.String CS_PROCESS_NAME = "process_name" ;
	public final static java.lang.String CS_COUNTERSIGN = "countersign" ;
	public final static java.lang.String CS_DESCRIPTION = "description" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,流程类型编码,流程名称,是否会签,描述";

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessTypeId() {
		return this.__process_type_id;
	}

	public void setProcessTypeId( java.lang.Integer value ) {
		this.__process_type_id = value;
	}

	public java.lang.String getProcessName() {
		return this.__process_name;
	}

	public void setProcessName( java.lang.String value ) {
		this.__process_name = value;
	}

	public java.lang.Boolean getCountersign() {
		return this.__countersign;
	}

	public void setCountersign( java.lang.Boolean value ) {
		this.__countersign = value;
	}

	public java.lang.String getDescription() {
		return this.__description;
	}

	public void setDescription( java.lang.String value ) {
		this.__description = value;
	}

	public void cloneCopy(BaseGetProcessByTypeAndDepartment __bean){
		__bean.setProcessId(getProcessId());
		__bean.setProcessTypeId(getProcessTypeId());
		__bean.setProcessName(getProcessName());
		__bean.setCountersign(getCountersign());
		__bean.setDescription(getDescription());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		sb.append(getProcessTypeId() == null ? "" : getProcessTypeId());
		sb.append(",");
		sb.append(getProcessName() == null ? "" : getProcessName());
		sb.append(",");
		sb.append(getCountersign() == null ? "" : getCountersign());
		sb.append(",");
		sb.append(getDescription() == null ? "" : getDescription());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetProcessByTypeAndDepartment o) {
		return __process_id == null ? -1 : __process_id.compareTo(o.getProcessId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_type_id);
		hash = 97 * hash + Objects.hashCode(this.__process_name);
		hash = 97 * hash + Objects.hashCode(this.__countersign);
		hash = 97 * hash + Objects.hashCode(this.__description);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetProcessByTypeAndDepartment o = (BaseGetProcessByTypeAndDepartment)obj;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_type_id, o.getProcessTypeId())) return false;
		if(!Objects.equals(this.__process_name, o.getProcessName())) return false;
		if(!Objects.equals(this.__countersign, o.getCountersign())) return false;
		if(!Objects.equals(this.__description, o.getDescription())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessTypeId() != null) sb.append(__wrapNumber(count++, "processTypeId", getProcessTypeId()));
		if(getProcessName() != null) sb.append(__wrapString(count++, "processName", getProcessName()));
		if(getCountersign() != null) sb.append(__wrapBoolean(count++, "countersign", getCountersign()));
		if(getDescription() != null) sb.append(__wrapString(count++, "description", getDescription()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processTypeId")) != null) setProcessTypeId(__getInt(val)); 
		if((val = values.get("processName")) != null) setProcessName(__getString(val));
		if((val = values.get("countersign")) != null) setCountersign(__getBoolean(val));
		if((val = values.get("description")) != null) setDescription(__getString(val));
	}

	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_type_id ;
	protected java.lang.String  __process_name ;
	protected java.lang.Boolean  __countersign ;
	protected java.lang.String  __description ;
}
