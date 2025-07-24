package pomplatform.check.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetPersonnelProcessId extends GenericBase implements BaseFactory<BaseGetPersonnelProcessId>, Comparable<BaseGetPersonnelProcessId> 
{


	public static BaseGetPersonnelProcessId newInstance(){
		return new BaseGetPersonnelProcessId();
	}

	@Override
	public BaseGetPersonnelProcessId make(){
		BaseGetPersonnelProcessId b = new BaseGetPersonnelProcessId();
		return b;
	}

	public final static java.lang.String CS_PROCESS_ID = "process_id" ;
	public final static java.lang.String CS_PROCESS_INSTANCE_ID = "process_instance_id" ;

	public final static java.lang.String ALL_CAPTIONS = "流程编码,主键编码";

	public java.lang.Integer getProcessId() {
		return this.__process_id;
	}

	public void setProcessId( java.lang.Integer value ) {
		this.__process_id = value;
	}

	public java.lang.Integer getProcessInstanceId() {
		return this.__process_instance_id;
	}

	public void setProcessInstanceId( java.lang.Integer value ) {
		this.__process_instance_id = value;
	}

	public void cloneCopy(BaseGetPersonnelProcessId __bean){
		__bean.setProcessId(getProcessId());
		__bean.setProcessInstanceId(getProcessInstanceId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessId() == null ? "" : getProcessId());
		sb.append(",");
		String strProcessInstanceId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getProcessInstanceId()));
		sb.append(strProcessInstanceId == null ? "" : strProcessInstanceId);
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetPersonnelProcessId o) {
		return __process_instance_id == null ? -1 : __process_instance_id.compareTo(o.getProcessInstanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_id);
		hash = 97 * hash + Objects.hashCode(this.__process_instance_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetPersonnelProcessId o = (BaseGetPersonnelProcessId)obj;
		if(!Objects.equals(this.__process_id, o.getProcessId())) return false;
		if(!Objects.equals(this.__process_instance_id, o.getProcessInstanceId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessId() != null) sb.append(__wrapNumber(count++, "processId", getProcessId()));
		if(getProcessInstanceId() != null) sb.append(__wrapNumber(count++, "processInstanceId", getProcessInstanceId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processId")) != null) setProcessId(__getInt(val)); 
		if((val = values.get("processInstanceId")) != null) setProcessInstanceId(__getInt(val)); 
	}

	protected java.lang.Integer  __process_id ;
	protected java.lang.Integer  __process_instance_id ;
}
