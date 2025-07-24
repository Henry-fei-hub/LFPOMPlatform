package pomplatform.cost.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSprojectcostpor extends GenericBase implements BaseFactory<BaseSprojectcostpor>, Comparable<BaseSprojectcostpor> 
{


	public static BaseSprojectcostpor newInstance(){
		return new BaseSprojectcostpor();
	}

	@Override
	public BaseSprojectcostpor make(){
		BaseSprojectcostpor b = new BaseSprojectcostpor();
		return b;
	}

	public final static java.lang.String CS_COST_MONEY = "cost_money" ;

	public final static java.lang.String ALL_CAPTIONS = "";

	public java.math.BigDecimal getCostMoney() {
		return this.__cost_money;
	}

	public void setCostMoney( java.math.BigDecimal value ) {
		this.__cost_money = value;
	}

	public void cloneCopy(BaseSprojectcostpor __bean){
		__bean.setCostMoney(getCostMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCostMoney() == null ? "" : getCostMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSprojectcostpor o) {
		return __cost_money == null ? -1 : __cost_money.compareTo(o.getCostMoney());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__cost_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSprojectcostpor o = (BaseSprojectcostpor)obj;
		if(!Objects.equals(this.__cost_money, o.getCostMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCostMoney() != null) sb.append(__wrapDecimal(count++, "costMoney", getCostMoney()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("costMoney")) != null) setCostMoney(__getDecimal(val));  
	}

	protected java.math.BigDecimal  __cost_money ;
}
