package pomplatform.checking.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeecheckinoutStatusCount extends GenericBase implements BaseFactory<BaseEmployeecheckinoutStatusCount>, Comparable<BaseEmployeecheckinoutStatusCount> 
{


	public static BaseEmployeecheckinoutStatusCount newInstance(){
		return new BaseEmployeecheckinoutStatusCount();
	}

	@Override
	public BaseEmployeecheckinoutStatusCount make(){
		BaseEmployeecheckinoutStatusCount b = new BaseEmployeecheckinoutStatusCount();
		return b;
	}

	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_NUM = "num" ;

	public final static java.lang.String ALL_CAPTIONS = "考勤状态,人数";

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getNum() {
		return this.__num;
	}

	public void setNum( java.lang.Integer value ) {
		this.__num = value;
	}

	public void cloneCopy(BaseEmployeecheckinoutStatusCount __bean){
		__bean.setStatus(getStatus());
		__bean.setNum(getNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_22", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeecheckinoutStatusCount o) {
		return __status == null ? -1 : __status.compareTo(o.getStatus());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeecheckinoutStatusCount o = (BaseEmployeecheckinoutStatusCount)obj;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("num")) != null) setNum(__getInt(val)); 
	}

	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __num ;
}
