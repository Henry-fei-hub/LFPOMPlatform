package pomplatform.preProjects.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetContractCodeNum extends GenericBase implements BaseFactory<BaseGetContractCodeNum>, Comparable<BaseGetContractCodeNum> 
{


	public static BaseGetContractCodeNum newInstance(){
		return new BaseGetContractCodeNum();
	}

	@Override
	public BaseGetContractCodeNum make(){
		BaseGetContractCodeNum b = new BaseGetContractCodeNum();
		return b;
	}

	public final static java.lang.String CS_NUM = "num" ;

	public final static java.lang.String ALL_CAPTIONS = "流水号";

	public java.lang.Integer getNum() {
		return this.__num;
	}

	public void setNum( java.lang.Integer value ) {
		this.__num = value;
	}

	public void cloneCopy(BaseGetContractCodeNum __bean){
		__bean.setNum(getNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getNum() == null ? "" : getNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetContractCodeNum o) {
		return __num == null ? -1 : __num.compareTo(o.getNum());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetContractCodeNum o = (BaseGetContractCodeNum)obj;
		if(!Objects.equals(this.__num, o.getNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getNum() != null) sb.append(__wrapNumber(count++, "num", getNum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("num")) != null) setNum(__getInt(val)); 
	}

	protected java.lang.Integer  __num ;
}
