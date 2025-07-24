package pomplatform.financialStatements.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFinancialBankAccountInternalPayment extends GenericBase implements BaseFactory<BaseFinancialBankAccountInternalPayment>, Comparable<BaseFinancialBankAccountInternalPayment> 
{


	public static BaseFinancialBankAccountInternalPayment newInstance(){
		return new BaseFinancialBankAccountInternalPayment();
	}

	@Override
	public BaseFinancialBankAccountInternalPayment make(){
		BaseFinancialBankAccountInternalPayment b = new BaseFinancialBankAccountInternalPayment();
		return b;
	}

	public final static java.lang.String CS_OTHER_BANK_ACCOUNT = "other_bank_account" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "银行账号(付款方),";

	public java.lang.String getOtherBankAccount() {
		return this.__other_bank_account;
	}

	public void setOtherBankAccount( java.lang.String value ) {
		this.__other_bank_account = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseFinancialBankAccountInternalPayment __bean){
		__bean.setOtherBankAccount(getOtherBankAccount());
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOtherBankAccount() == null ? "" : getOtherBankAccount());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialBankAccountInternalPayment o) {
		return __other_bank_account == null ? -1 : __other_bank_account.compareTo(o.getOtherBankAccount());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__other_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialBankAccountInternalPayment o = (BaseFinancialBankAccountInternalPayment)obj;
		if(!Objects.equals(this.__other_bank_account, o.getOtherBankAccount())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOtherBankAccount() != null) sb.append(__wrapString(count++, "otherBankAccount", getOtherBankAccount()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
	}

	protected java.lang.String  __other_bank_account ;
	protected java.math.BigDecimal  __amount ;
}
