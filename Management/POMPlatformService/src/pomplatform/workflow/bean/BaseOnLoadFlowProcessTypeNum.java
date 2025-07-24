package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadFlowProcessTypeNum extends GenericBase implements BaseFactory<BaseOnLoadFlowProcessTypeNum>, Comparable<BaseOnLoadFlowProcessTypeNum> 
{


	public static BaseOnLoadFlowProcessTypeNum newInstance(){
		return new BaseOnLoadFlowProcessTypeNum();
	}

	@Override
	public BaseOnLoadFlowProcessTypeNum make(){
		BaseOnLoadFlowProcessTypeNum b = new BaseOnLoadFlowProcessTypeNum();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_RUN_COUNT = "run_count" ;
	public final static java.lang.String CS_FINISH_COUNT = "finish_count" ;
	public final static java.lang.String CS_BACK_COUNT = "back_count" ;
	public final static java.lang.String CS_TYPE_FLAG = "type_flag" ;
	public final static java.lang.String CS_PROCESS_TYPE_NAME = "process_type_name" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类型,,,,,流程类型名称";

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Long getRunCount() {
		return this.__run_count;
	}

	public void setRunCount( java.lang.Long value ) {
		this.__run_count = value;
	}

	public java.lang.Long getFinishCount() {
		return this.__finish_count;
	}

	public void setFinishCount( java.lang.Long value ) {
		this.__finish_count = value;
	}

	public java.lang.Long getBackCount() {
		return this.__back_count;
	}

	public void setBackCount( java.lang.Long value ) {
		this.__back_count = value;
	}

	public java.lang.Integer getTypeFlag() {
		return this.__type_flag;
	}

	public void setTypeFlag( java.lang.Integer value ) {
		this.__type_flag = value;
	}

	public java.lang.String getProcessTypeName() {
		return this.__process_type_name;
	}

	public void setProcessTypeName( java.lang.String value ) {
		this.__process_type_name = value;
	}

	public void cloneCopy(BaseOnLoadFlowProcessTypeNum __bean){
		__bean.setProcessType(getProcessType());
		__bean.setRunCount(getRunCount());
		__bean.setFinishCount(getFinishCount());
		__bean.setBackCount(getBackCount());
		__bean.setTypeFlag(getTypeFlag());
		__bean.setProcessTypeName(getProcessTypeName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getRunCount() == null ? "" : getRunCount());
		sb.append(",");
		sb.append(getFinishCount() == null ? "" : getFinishCount());
		sb.append(",");
		sb.append(getBackCount() == null ? "" : getBackCount());
		sb.append(",");
		sb.append(getTypeFlag() == null ? "" : getTypeFlag());
		sb.append(",");
		sb.append(getProcessTypeName() == null ? "" : getProcessTypeName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadFlowProcessTypeNum o) {
		return __process_type == null ? -1 : __process_type.compareTo(o.getProcessType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__run_count);
		hash = 97 * hash + Objects.hashCode(this.__finish_count);
		hash = 97 * hash + Objects.hashCode(this.__back_count);
		hash = 97 * hash + Objects.hashCode(this.__type_flag);
		hash = 97 * hash + Objects.hashCode(this.__process_type_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadFlowProcessTypeNum o = (BaseOnLoadFlowProcessTypeNum)obj;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__run_count, o.getRunCount())) return false;
		if(!Objects.equals(this.__finish_count, o.getFinishCount())) return false;
		if(!Objects.equals(this.__back_count, o.getBackCount())) return false;
		if(!Objects.equals(this.__type_flag, o.getTypeFlag())) return false;
		if(!Objects.equals(this.__process_type_name, o.getProcessTypeName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getRunCount() != null) sb.append(__wrapNumber(count++, "runCount", getRunCount()));
		if(getFinishCount() != null) sb.append(__wrapNumber(count++, "finishCount", getFinishCount()));
		if(getBackCount() != null) sb.append(__wrapNumber(count++, "backCount", getBackCount()));
		if(getTypeFlag() != null) sb.append(__wrapNumber(count++, "typeFlag", getTypeFlag()));
		if(getProcessTypeName() != null) sb.append(__wrapString(count++, "processTypeName", getProcessTypeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("runCount")) != null) setRunCount(__getLong(val)); 
		if((val = values.get("finishCount")) != null) setFinishCount(__getLong(val)); 
		if((val = values.get("backCount")) != null) setBackCount(__getLong(val)); 
		if((val = values.get("typeFlag")) != null) setTypeFlag(__getInt(val)); 
		if((val = values.get("processTypeName")) != null) setProcessTypeName(__getString(val));
	}

	protected java.lang.Integer  __process_type ;
	protected java.lang.Long  __run_count ;
	protected java.lang.Long  __finish_count ;
	protected java.lang.Long  __back_count ;
	protected java.lang.Integer  __type_flag ;
	protected java.lang.String  __process_type_name ;
}
