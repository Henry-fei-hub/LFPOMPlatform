package pomplatform.sumDesignconsideration.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSumDesignconsideration extends GenericBase implements BaseFactory<BaseSumDesignconsideration>, Comparable<BaseSumDesignconsideration> 
{


	public static BaseSumDesignconsideration newInstance(){
		return new BaseSumDesignconsideration();
	}

	@Override
	public BaseSumDesignconsideration make(){
		BaseSumDesignconsideration b = new BaseSumDesignconsideration();
		return b;
	}

	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_INTERIOR_MONEY_SUM = "interior_money_sum" ;
	public final static java.lang.String CS_SPLIT_PRICE = "split_price" ;

	public final static java.lang.String ALL_CAPTIONS = "小计 设计面积总金额,内部设计面积总金额,拆分价总金额";

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.math.BigDecimal getInteriorMoneySum() {
		return this.__interior_money_sum;
	}

	public void setInteriorMoneySum( java.math.BigDecimal value ) {
		this.__interior_money_sum = value;
	}

	public java.math.BigDecimal getSplitPrice() {
		return this.__split_price;
	}

	public void setSplitPrice( java.math.BigDecimal value ) {
		this.__split_price = value;
	}

	public void cloneCopy(BaseSumDesignconsideration __bean){
		__bean.setMoneySum(getMoneySum());
		__bean.setInteriorMoneySum(getInteriorMoneySum());
		__bean.setSplitPrice(getSplitPrice());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getInteriorMoneySum() == null ? "" : getInteriorMoneySum());
		sb.append(",");
		sb.append(getSplitPrice() == null ? "" : getSplitPrice());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSumDesignconsideration o) {
		return __money_sum == null ? -1 : __money_sum.compareTo(o.getMoneySum());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__interior_money_sum);
		hash = 97 * hash + Objects.hashCode(this.__split_price);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSumDesignconsideration o = (BaseSumDesignconsideration)obj;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__interior_money_sum, o.getInteriorMoneySum())) return false;
		if(!Objects.equals(this.__split_price, o.getSplitPrice())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getInteriorMoneySum() != null) sb.append(__wrapDecimal(count++, "interiorMoneySum", getInteriorMoneySum()));
		if(getSplitPrice() != null) sb.append(__wrapDecimal(count++, "splitPrice", getSplitPrice()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("interiorMoneySum")) != null) setInteriorMoneySum(__getDecimal(val));  
		if((val = values.get("splitPrice")) != null) setSplitPrice(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __money_sum ;
	protected java.math.BigDecimal  __interior_money_sum ;
	protected java.math.BigDecimal  __split_price ;
}
