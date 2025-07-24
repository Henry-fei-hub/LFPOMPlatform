package pomplatform.workflow.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeStuff extends GenericBase implements BaseFactory<BaseEmployeeStuff>, Comparable<BaseEmployeeStuff> 
{


	public static BaseEmployeeStuff newInstance(){
		return new BaseEmployeeStuff();
	}

	@Override
	public BaseEmployeeStuff make(){
		BaseEmployeeStuff b = new BaseEmployeeStuff();
		return b;
	}

	public final static java.lang.String CS_ACTIVITY_TYPE = "activity_type" ;
	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;

	public final static java.lang.String ALL_CAPTIONS = "节点类型,流程类型,业务名称";

	public java.lang.Integer getActivityType() {
		return this.__activity_type;
	}

	public void setActivityType( java.lang.Integer value ) {
		this.__activity_type = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public void cloneCopy(BaseEmployeeStuff __bean){
		__bean.setActivityType(getActivityType());
		__bean.setProcessType(getProcessType());
		__bean.setBusinessName(getBusinessName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getActivityType() == null ? "" : getActivityType());
		sb.append(",");
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeStuff o) {
		return __activity_type == null ? -1 : __activity_type.compareTo(o.getActivityType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__activity_type);
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeStuff o = (BaseEmployeeStuff)obj;
		if(!Objects.equals(this.__activity_type, o.getActivityType())) return false;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getActivityType() != null) sb.append(__wrapNumber(count++, "activityType", getActivityType()));
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("activityType")) != null) setActivityType(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
	}

	protected java.lang.Integer  __activity_type ;
	protected java.lang.Integer  __process_type ;
	protected java.lang.String  __business_name ;
}
