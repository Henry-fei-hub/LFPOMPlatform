package pomplatform.receiveunit.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMreceiveunitmanagepsrbbor extends GenericBase implements BaseFactory<BaseMreceiveunitmanagepsrbbor>, Comparable<BaseMreceiveunitmanagepsrbbor> 
{


	public static BaseMreceiveunitmanagepsrbbor newInstance(){
		return new BaseMreceiveunitmanagepsrbbor();
	}

	@Override
	public BaseMreceiveunitmanagepsrbbor make(){
		BaseMreceiveunitmanagepsrbbor b = new BaseMreceiveunitmanagepsrbbor();
		return b;
	}

	public final static java.lang.String CS_RECEIVE_UNIT = "receive_unit" ;
	public final static java.lang.String CS_PAY_MONEY = "pay_money" ;
	public final static java.lang.String CS_BALANCE_AMOUNT = "balance_amount" ;
	public final static java.lang.String CS_INITIAL_BALANCE = "initial_balance" ;
	public final static java.lang.String CS_BALANCE = "balance" ;

	public final static java.lang.String ALL_CAPTIONS = "收款单位,付款金额,差额金额,初始金额,余额";

	public java.lang.String getReceiveUnit() {
		return this.__receive_unit;
	}

	public void setReceiveUnit( java.lang.String value ) {
		this.__receive_unit = value;
	}

	public java.math.BigDecimal getPayMoney() {
		return this.__pay_money;
	}

	public void setPayMoney( java.math.BigDecimal value ) {
		this.__pay_money = value;
	}

	public java.math.BigDecimal getBalanceAmount() {
		return this.__balance_amount;
	}

	public void setBalanceAmount( java.math.BigDecimal value ) {
		this.__balance_amount = value;
	}

	public java.math.BigDecimal getInitialBalance() {
		return this.__initial_balance;
	}

	public void setInitialBalance( java.math.BigDecimal value ) {
		this.__initial_balance = value;
	}

	public java.math.BigDecimal getBalance() {
		return this.__balance;
	}

	public void setBalance( java.math.BigDecimal value ) {
		this.__balance = value;
	}

	public void cloneCopy(BaseMreceiveunitmanagepsrbbor __bean){
		__bean.setReceiveUnit(getReceiveUnit());
		__bean.setPayMoney(getPayMoney());
		__bean.setBalanceAmount(getBalanceAmount());
		__bean.setInitialBalance(getInitialBalance());
		__bean.setBalance(getBalance());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReceiveUnit() == null ? "" : getReceiveUnit());
		sb.append(",");
		sb.append(getPayMoney() == null ? "" : getPayMoney());
		sb.append(",");
		sb.append(getBalanceAmount() == null ? "" : getBalanceAmount());
		sb.append(",");
		sb.append(getInitialBalance() == null ? "" : getInitialBalance());
		sb.append(",");
		sb.append(getBalance() == null ? "" : getBalance());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMreceiveunitmanagepsrbbor o) {
		return __receive_unit == null ? -1 : __receive_unit.compareTo(o.getReceiveUnit());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__receive_unit);
		hash = 97 * hash + Objects.hashCode(this.__pay_money);
		hash = 97 * hash + Objects.hashCode(this.__balance_amount);
		hash = 97 * hash + Objects.hashCode(this.__initial_balance);
		hash = 97 * hash + Objects.hashCode(this.__balance);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMreceiveunitmanagepsrbbor o = (BaseMreceiveunitmanagepsrbbor)obj;
		if(!Objects.equals(this.__receive_unit, o.getReceiveUnit())) return false;
		if(!Objects.equals(this.__pay_money, o.getPayMoney())) return false;
		if(!Objects.equals(this.__balance_amount, o.getBalanceAmount())) return false;
		if(!Objects.equals(this.__initial_balance, o.getInitialBalance())) return false;
		if(!Objects.equals(this.__balance, o.getBalance())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReceiveUnit() != null) sb.append(__wrapString(count++, "receiveUnit", getReceiveUnit()));
		if(getPayMoney() != null) sb.append(__wrapDecimal(count++, "payMoney", getPayMoney()));
		if(getBalanceAmount() != null) sb.append(__wrapDecimal(count++, "balanceAmount", getBalanceAmount()));
		if(getInitialBalance() != null) sb.append(__wrapDecimal(count++, "initialBalance", getInitialBalance()));
		if(getBalance() != null) sb.append(__wrapDecimal(count++, "balance", getBalance()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("receiveUnit")) != null) setReceiveUnit(__getString(val));
		if((val = values.get("payMoney")) != null) setPayMoney(__getDecimal(val));  
		if((val = values.get("balanceAmount")) != null) setBalanceAmount(__getDecimal(val));  
		if((val = values.get("initialBalance")) != null) setInitialBalance(__getDecimal(val));  
		if((val = values.get("balance")) != null) setBalance(__getDecimal(val));  
	}

	protected java.lang.String  __receive_unit ;
	protected java.math.BigDecimal  __pay_money ;
	protected java.math.BigDecimal  __balance_amount ;
	protected java.math.BigDecimal  __initial_balance ;
	protected java.math.BigDecimal  __balance ;
}
