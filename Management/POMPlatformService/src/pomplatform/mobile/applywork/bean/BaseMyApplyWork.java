package pomplatform.mobile.applywork.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMyApplyWork extends GenericBase implements BaseFactory<BaseMyApplyWork>, Comparable<BaseMyApplyWork> 
{


	public static BaseMyApplyWork newInstance(){
		return new BaseMyApplyWork();
	}

	@Override
	public BaseMyApplyWork make(){
		BaseMyApplyWork b = new BaseMyApplyWork();
		return b;
	}

	public final static java.lang.String CS_PROCESS_TYPE = "process_type" ;
	public final static java.lang.String CS_NUM = "num" ;

	public final static java.lang.String ALL_CAPTIONS = "流程类型,";

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.Long getNum() {
		return this.__num;
	}

	public void setNum( java.lang.Long value ) {
		this.__num = value;
	}

	public void cloneCopy(BaseMyApplyWork __bean){
		__bean.setProcessType(getProcessType());
		__bean.setNum(getNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProcessType() == null ? "" : getProcessType());
		sb.append(",");
		sb.append(getNum() == null ? "" : getNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMyApplyWork o) {
		return __process_type == null ? -1 : __process_type.compareTo(o.getProcessType());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__process_type);
		hash = 97 * hash + Objects.hashCode(this.__num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMyApplyWork o = (BaseMyApplyWork)obj;
		if(!Objects.equals(this.__process_type, o.getProcessType())) return false;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProcessType() != null) sb.append(__wrapNumber(count++, "processType", getProcessType()));
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("num")) != null) setNum(__getLong(val)); 
	}

	protected java.lang.Integer  __process_type ;
	protected java.lang.Long  __num ;
}
