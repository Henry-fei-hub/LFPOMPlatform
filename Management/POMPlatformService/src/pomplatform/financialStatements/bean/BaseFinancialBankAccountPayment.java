package pomplatform.financialStatements.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFinancialBankAccountPayment extends GenericBase implements BaseFactory<BaseFinancialBankAccountPayment>, Comparable<BaseFinancialBankAccountPayment> 
{


	public static BaseFinancialBankAccountPayment newInstance(){
		return new BaseFinancialBankAccountPayment();
	}

	@Override
	public BaseFinancialBankAccountPayment make(){
		BaseFinancialBankAccountPayment b = new BaseFinancialBankAccountPayment();
		return b;
	}

	public final static java.lang.String CS_OTHER_NAME = "other_name" ;
	public final static java.lang.String CS_OTHER_BANK_ACCOUNT = "other_bank_account" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;
	public final static java.lang.String CS_TYPE = "type" ;

	public final static java.lang.String ALL_CAPTIONS = "付款人  system_dictionary_69,银行账号(付款方),总金额,类型1项目 2借款 3预付 4 其它";

	public java.lang.Integer getOtherName() {
		return this.__other_name;
	}

	public void setOtherName( java.lang.Integer value ) {
		this.__other_name = value;
	}

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

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public void cloneCopy(BaseFinancialBankAccountPayment __bean){
		__bean.setOtherName(getOtherName());
		__bean.setOtherBankAccount(getOtherBankAccount());
		__bean.setAmount(getAmount());
		__bean.setType(getType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOtherName() == null ? "" : getOtherName());
		sb.append(",");
		sb.append(getOtherBankAccount() == null ? "" : getOtherBankAccount());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialBankAccountPayment o) {
		return __other_name == null ? -1 : __other_name.compareTo(o.getOtherName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__other_name);
		hash = 97 * hash + Objects.hashCode(this.__other_bank_account);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		hash = 97 * hash + Objects.hashCode(this.__type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialBankAccountPayment o = (BaseFinancialBankAccountPayment)obj;
		if(!Objects.equals(this.__other_name, o.getOtherName())) return false;
		if(!Objects.equals(this.__other_bank_account, o.getOtherBankAccount())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOtherName() != null) sb.append(__wrapNumber(count++, "otherName", getOtherName()));
		if(getOtherBankAccount() != null) sb.append(__wrapString(count++, "otherBankAccount", getOtherBankAccount()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("otherName")) != null) setOtherName(__getInt(val)); 
		if((val = values.get("otherBankAccount")) != null) setOtherBankAccount(__getString(val));
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
		if((val = values.get("type")) != null) setType(__getInt(val)); 
	}

	protected java.lang.Integer  __other_name ;
	protected java.lang.String  __other_bank_account ;
	protected java.math.BigDecimal  __amount ;
	protected java.lang.Integer  __type ;
}
