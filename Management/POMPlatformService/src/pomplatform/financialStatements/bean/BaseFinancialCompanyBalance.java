package pomplatform.financialStatements.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFinancialCompanyBalance extends GenericBase implements BaseFactory<BaseFinancialCompanyBalance>, Comparable<BaseFinancialCompanyBalance> 
{


	public static BaseFinancialCompanyBalance newInstance(){
		return new BaseFinancialCompanyBalance();
	}

	@Override
	public BaseFinancialCompanyBalance make(){
		BaseFinancialCompanyBalance b = new BaseFinancialCompanyBalance();
		return b;
	}

	public final static java.lang.String CS_BEFORE_MONEY = "before_money" ;
	public final static java.lang.String CS_SELF_NAME = "self_name" ;

	public final static java.lang.String ALL_CAPTIONS = "余额,内部公司(收款方)";

	public java.math.BigDecimal getBeforeMoney() {
		return this.__before_money;
	}

	public void setBeforeMoney( java.math.BigDecimal value ) {
		this.__before_money = value;
	}

	public java.lang.Integer getSelfName() {
		return this.__self_name;
	}

	public void setSelfName( java.lang.Integer value ) {
		this.__self_name = value;
	}

	public void cloneCopy(BaseFinancialCompanyBalance __bean){
		__bean.setBeforeMoney(getBeforeMoney());
		__bean.setSelfName(getSelfName());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBeforeMoney() == null ? "" : getBeforeMoney());
		sb.append(",");
		sb.append(getSelfName() == null ? "" : getSelfName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialCompanyBalance o) {
		return __before_money == null ? -1 : __before_money.compareTo(o.getBeforeMoney());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__before_money);
		hash = 97 * hash + Objects.hashCode(this.__self_name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialCompanyBalance o = (BaseFinancialCompanyBalance)obj;
		if(!Objects.equals(this.__before_money, o.getBeforeMoney())) return false;
		if(!Objects.equals(this.__self_name, o.getSelfName())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBeforeMoney() != null) sb.append(__wrapDecimal(count++, "beforeMoney", getBeforeMoney()));
		if(getSelfName() != null) sb.append(__wrapNumber(count++, "selfName", getSelfName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("beforeMoney")) != null) setBeforeMoney(__getDecimal(val));  
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
	}

	protected java.math.BigDecimal  __before_money ;
	protected java.lang.Integer  __self_name ;
}
