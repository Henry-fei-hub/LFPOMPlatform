package pomplatform.capitaldistribution.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSumCapitalDistribution extends GenericBase implements BaseFactory<BaseSumCapitalDistribution>, Comparable<BaseSumCapitalDistribution> 
{


	public static BaseSumCapitalDistribution newInstance(){
		return new BaseSumCapitalDistribution();
	}

	@Override
	public BaseSumCapitalDistribution make(){
		BaseSumCapitalDistribution b = new BaseSumCapitalDistribution();
		return b;
	}

	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "回款分配总额";

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseSumCapitalDistribution __bean){
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSumCapitalDistribution o) {
		return __amount == null ? -1 : __amount.compareTo(o.getAmount());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSumCapitalDistribution o = (BaseSumCapitalDistribution)obj;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __amount ;
}
