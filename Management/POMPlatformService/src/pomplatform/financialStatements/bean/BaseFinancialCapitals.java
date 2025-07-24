package pomplatform.financialStatements.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFinancialCapitals extends GenericBase implements BaseFactory<BaseFinancialCapitals>, Comparable<BaseFinancialCapitals> 
{


	public static BaseFinancialCapitals newInstance(){
		return new BaseFinancialCapitals();
	}

	@Override
	public BaseFinancialCapitals make(){
		BaseFinancialCapitals b = new BaseFinancialCapitals();
		return b;
	}

	public final static java.lang.String CS_SELF_NAME = "self_name" ;
	public final static java.lang.String CS_MONEY_ATTRIBUTE = "money_attribute" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "内部公司(收款方),款项属性,";

	public java.lang.Integer getSelfName() {
		return this.__self_name;
	}

	public void setSelfName( java.lang.Integer value ) {
		this.__self_name = value;
	}

	public java.lang.Integer getMoneyAttribute() {
		return this.__money_attribute;
	}

	public void setMoneyAttribute( java.lang.Integer value ) {
		this.__money_attribute = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseFinancialCapitals __bean){
		__bean.setSelfName(getSelfName());
		__bean.setMoneyAttribute(getMoneyAttribute());
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSelfName() == null ? "" : getSelfName());
		sb.append(",");
		sb.append(getMoneyAttribute() == null ? "" : getMoneyAttribute());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialCapitals o) {
		return __self_name == null ? -1 : __self_name.compareTo(o.getSelfName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__self_name);
		hash = 97 * hash + Objects.hashCode(this.__money_attribute);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialCapitals o = (BaseFinancialCapitals)obj;
		if(!Objects.equals(this.__self_name, o.getSelfName())) return false;
		if(!Objects.equals(this.__money_attribute, o.getMoneyAttribute())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSelfName() != null) sb.append(__wrapNumber(count++, "selfName", getSelfName()));
		if(getMoneyAttribute() != null) sb.append(__wrapNumber(count++, "moneyAttribute", getMoneyAttribute()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
		if((val = values.get("moneyAttribute")) != null) setMoneyAttribute(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __self_name ;
	protected java.lang.Integer  __money_attribute ;
	protected java.math.BigDecimal  __amount ;
}
