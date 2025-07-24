package pomplatform.employeeAward.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCountEmployeeIntegralBusinessStatus extends GenericBase implements BaseFactory<BaseCountEmployeeIntegralBusinessStatus>, Comparable<BaseCountEmployeeIntegralBusinessStatus> 
{


	public static BaseCountEmployeeIntegralBusinessStatus newInstance(){
		return new BaseCountEmployeeIntegralBusinessStatus();
	}

	@Override
	public BaseCountEmployeeIntegralBusinessStatus make(){
		BaseCountEmployeeIntegralBusinessStatus b = new BaseCountEmployeeIntegralBusinessStatus();
		return b;
	}

	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_COUNT_NUM = "count_num" ;

	public final static java.lang.String ALL_CAPTIONS = "状态,数量";

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Long getCountNum() {
		return this.__count_num;
	}

	public void setCountNum( java.lang.Long value ) {
		this.__count_num = value;
	}

	public void cloneCopy(BaseCountEmployeeIntegralBusinessStatus __bean){
		__bean.setStatus(getStatus());
		__bean.setCountNum(getCountNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_61", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getCountNum() == null ? "" : getCountNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCountEmployeeIntegralBusinessStatus o) {
		return __status == null ? -1 : __status.compareTo(o.getStatus());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__count_num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCountEmployeeIntegralBusinessStatus o = (BaseCountEmployeeIntegralBusinessStatus)obj;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__count_num, o.getCountNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getCountNum() != null) sb.append(__wrapNumber(count++, "countNum", getCountNum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("countNum")) != null) setCountNum(__getLong(val)); 
	}

	protected java.lang.Integer  __status ;
	protected java.lang.Long  __count_num ;
}
