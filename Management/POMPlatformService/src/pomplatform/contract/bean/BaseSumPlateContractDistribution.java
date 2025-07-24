package pomplatform.contract.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSumPlateContractDistribution extends GenericBase implements BaseFactory<BaseSumPlateContractDistribution>, Comparable<BaseSumPlateContractDistribution> 
{


	public static BaseSumPlateContractDistribution newInstance(){
		return new BaseSumPlateContractDistribution();
	}

	@Override
	public BaseSumPlateContractDistribution make(){
		BaseSumPlateContractDistribution b = new BaseSumPlateContractDistribution();
		return b;
	}

	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "提成";

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseSumPlateContractDistribution __bean){
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSumPlateContractDistribution o) {
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
		final BaseSumPlateContractDistribution o = (BaseSumPlateContractDistribution)obj;
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
