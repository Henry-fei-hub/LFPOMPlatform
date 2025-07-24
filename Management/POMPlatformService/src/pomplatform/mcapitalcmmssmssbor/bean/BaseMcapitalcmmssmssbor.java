package pomplatform.mcapitalcmmssmssbor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMcapitalcmmssmssbor extends GenericBase implements BaseFactory<BaseMcapitalcmmssmssbor>, Comparable<BaseMcapitalcmmssmssbor> 
{


	public static BaseMcapitalcmmssmssbor newInstance(){
		return new BaseMcapitalcmmssmssbor();
	}

	@Override
	public BaseMcapitalcmmssmssbor make(){
		BaseMcapitalcmmssmssbor b = new BaseMcapitalcmmssmssbor();
		return b;
	}

	public final static java.lang.String CS_SELF_NAME = "self_name" ;
	public final static java.lang.String CS_BANK_ADDRESS = "bank_address" ;
	public final static java.lang.String CS_SELF_BANK_ACCOUNT = "self_bank_account" ;
	public final static java.lang.String CS_BEFORE_MONEY = "before_money" ;
	public final static java.lang.String CS_BORROW_MONEY = "borrow_money" ;
	public final static java.lang.String CS_LOAN_MONEY = "loan_money" ;
	public final static java.lang.String CS_BALANCE = "balance" ;
	public final static java.lang.String CS_CURRENCY_TYPE = "currency_type" ;

	public final static java.lang.String ALL_CAPTIONS = "内部公司,银行名称,银行账号,期初余额,本期收入,本期支出,本期余额,货币类型";

	public java.lang.Integer getSelfName() {
		return this.__self_name;
	}

	public void setSelfName( java.lang.Integer value ) {
		this.__self_name = value;
	}

	public java.lang.String getBankAddress() {
		return this.__bank_address;
	}

	public void setBankAddress( java.lang.String value ) {
		this.__bank_address = value;
	}

	public java.lang.String getSelfBankAccount() {
		return this.__self_bank_account;
	}

	public void setSelfBankAccount( java.lang.String value ) {
		this.__self_bank_account = value;
	}

	public java.math.BigDecimal getBeforeMoney() {
		return this.__before_money;
	}

	public void setBeforeMoney( java.math.BigDecimal value ) {
		this.__before_money = value;
	}

	public java.math.BigDecimal getBorrowMoney() {
		return this.__borrow_money;
	}

	public void setBorrowMoney( java.math.BigDecimal value ) {
		this.__borrow_money = value;
	}

	public java.math.BigDecimal getLoanMoney() {
		return this.__loan_money;
	}

	public void setLoanMoney( java.math.BigDecimal value ) {
		this.__loan_money = value;
	}

	public java.math.BigDecimal getBalance() {
		return this.__balance;
	}

	public void setBalance( java.math.BigDecimal value ) {
		this.__balance = value;
	}
	
	public java.lang.Integer getCurrencyType() {
		return this.__currency_type;
	}

	public void setCurrencyType( java.lang.Integer value ) {
		this.__currency_type = value;
	}

	public void cloneCopy(BaseMcapitalcmmssmssbor __bean){
		__bean.setSelfName(getSelfName());
		__bean.setBankAddress(getBankAddress());
		__bean.setSelfBankAccount(getSelfBankAccount());
		__bean.setBeforeMoney(getBeforeMoney());
		__bean.setBorrowMoney(getBorrowMoney());
		__bean.setLoanMoney(getLoanMoney());
		__bean.setBalance(getBalance());
		__bean.setCurrencyType(getCurrencyType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSelfName() == null ? "" : getSelfName());
		sb.append(",");
		sb.append(getBankAddress() == null ? "" : getBankAddress());
		sb.append(",");
		sb.append(getSelfBankAccount() == null ? "" : getSelfBankAccount());
		sb.append(",");
		sb.append(getBeforeMoney() == null ? "" : getBeforeMoney());
		sb.append(",");
		sb.append(getBorrowMoney() == null ? "" : getBorrowMoney());
		sb.append(",");
		sb.append(getLoanMoney() == null ? "" : getLoanMoney());
		sb.append(",");
		sb.append(getBalance() == null ? "" : getBalance());
		sb.append(",");
		sb.append(getCurrencyType() == null ? "" : getCurrencyType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMcapitalcmmssmssbor o) {
		return __self_name == null ? -1 : __self_name.compareTo(o.getSelfName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__self_name);
		hash = 97 * hash + Objects.hashCode(this.__bank_address);
		hash = 97 * hash + Objects.hashCode(this.__self_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__before_money);
		hash = 97 * hash + Objects.hashCode(this.__borrow_money);
		hash = 97 * hash + Objects.hashCode(this.__loan_money);
		hash = 97 * hash + Objects.hashCode(this.__balance);
		hash = 97 * hash + Objects.hashCode(this.__currency_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMcapitalcmmssmssbor o = (BaseMcapitalcmmssmssbor)obj;
		if(!Objects.equals(this.__self_name, o.getSelfName())) return false;
		if(!Objects.equals(this.__bank_address, o.getBankAddress())) return false;
		if(!Objects.equals(this.__self_bank_account, o.getSelfBankAccount())) return false;
		if(!Objects.equals(this.__before_money, o.getBeforeMoney())) return false;
		if(!Objects.equals(this.__borrow_money, o.getBorrowMoney())) return false;
		if(!Objects.equals(this.__loan_money, o.getLoanMoney())) return false;
		if(!Objects.equals(this.__balance, o.getBalance())) return false;
		if(!Objects.equals(this.__currency_type, o.getCurrencyType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSelfName() != null) sb.append(__wrapNumber(count++, "selfName", getSelfName()));
		if(getBankAddress() != null) sb.append(__wrapString(count++, "bankAddress", getBankAddress()));
		if(getSelfBankAccount() != null) sb.append(__wrapString(count++, "selfBankAccount", getSelfBankAccount()));
		if(getBeforeMoney() != null) sb.append(__wrapDecimal(count++, "beforeMoney", getBeforeMoney()));
		if(getBorrowMoney() != null) sb.append(__wrapDecimal(count++, "borrowMoney", getBorrowMoney()));
		if(getLoanMoney() != null) sb.append(__wrapDecimal(count++, "loanMoney", getLoanMoney()));
		if(getBalance() != null) sb.append(__wrapDecimal(count++, "balance", getBalance()));
		if(getCurrencyType() != null) sb.append(__wrapNumber(count++, "currencyType", getCurrencyType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("selfName")) != null) setSelfName(__getInt(val)); 
		if((val = values.get("bankAddress")) != null) setBankAddress(__getString(val));
		if((val = values.get("selfBankAccount")) != null) setSelfBankAccount(__getString(val));
		if((val = values.get("beforeMoney")) != null) setBeforeMoney(__getDecimal(val));  
		if((val = values.get("borrowMoney")) != null) setBorrowMoney(__getDecimal(val));  
		if((val = values.get("loanMoney")) != null) setLoanMoney(__getDecimal(val));  
		if((val = values.get("balance")) != null) setBalance(__getDecimal(val));  
		if((val = values.get("currencyType")) != null) setCurrencyType(__getInt(val)); 
	}

	protected java.lang.Integer  __self_name ;
	protected java.lang.String  __bank_address ;
	protected java.lang.String  __self_bank_account ;
	protected java.math.BigDecimal  __before_money ;
	protected java.math.BigDecimal  __borrow_money ;
	protected java.math.BigDecimal  __loan_money ;
	protected java.math.BigDecimal  __balance ;
	protected java.lang.Integer __currency_type;
		
}
