package pomplatform.budgetendcode.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseBudgetEndCode extends GenericBase implements BaseFactory<BaseBudgetEndCode>, Comparable<BaseBudgetEndCode> 
{


	public static BaseBudgetEndCode newInstance(){
		return new BaseBudgetEndCode();
	}

	@Override
	public BaseBudgetEndCode make(){
		BaseBudgetEndCode b = new BaseBudgetEndCode();
		return b;
	}

	public final static java.lang.String CS_END_NUMBER = "end_number" ;

	public final static java.lang.String ALL_CAPTIONS = "";

	public java.lang.Long getEndNumber() {
		return this.__end_number;
	}

	public void setEndNumber( java.lang.Long value ) {
		this.__end_number = value;
	}

	public void cloneCopy(BaseBudgetEndCode __bean){
		__bean.setEndNumber(getEndNumber());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEndNumber() == null ? "" : getEndNumber());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseBudgetEndCode o) {
		return __end_number == null ? -1 : __end_number.compareTo(o.getEndNumber());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__end_number);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseBudgetEndCode o = (BaseBudgetEndCode)obj;
		if(!Objects.equals(this.__end_number, o.getEndNumber())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEndNumber() != null) sb.append(__wrapNumber(count++, "endNumber", getEndNumber()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("endNumber")) != null) setEndNumber(__getLong(val)); 
	}

	protected java.lang.Long  __end_number ;
}
