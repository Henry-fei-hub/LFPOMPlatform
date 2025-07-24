package pomplatform.financialtransactionaccount.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseTransDetailNeedToUpdateRate extends GenericBase implements BaseFactory<BaseTransDetailNeedToUpdateRate>, Comparable<BaseTransDetailNeedToUpdateRate> 
{


	public static BaseTransDetailNeedToUpdateRate newInstance(){
		return new BaseTransDetailNeedToUpdateRate();
	}

	@Override
	public BaseTransDetailNeedToUpdateRate make(){
		BaseTransDetailNeedToUpdateRate b = new BaseTransDetailNeedToUpdateRate();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_TRANSACTION_DETAIL_ID = "financial_transaction_detail_id" ;
	public final static java.lang.String CS_ORIGINAL_DEBIT = "original_debit" ;
	public final static java.lang.String CS_ORIGINAL_CREDIT = "original_credit" ;
	public final static java.lang.String CS_CURRENCY_TYPE = "currency_type" ;
	public final static java.lang.String CS_COMPLETE_TIME = "complete_time" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,原币借,原币贷,货币种类 system_dictionary_40,完成时间";

	public java.lang.Integer getFinancialTransactionDetailId() {
		return this.__financial_transaction_detail_id;
	}

	public void setFinancialTransactionDetailId( java.lang.Integer value ) {
		this.__financial_transaction_detail_id = value;
	}

	public java.math.BigDecimal getOriginalDebit() {
		return this.__original_debit;
	}

	public void setOriginalDebit( java.math.BigDecimal value ) {
		this.__original_debit = value;
	}

	public java.math.BigDecimal getOriginalCredit() {
		return this.__original_credit;
	}

	public void setOriginalCredit( java.math.BigDecimal value ) {
		this.__original_credit = value;
	}

	public java.lang.Integer getCurrencyType() {
		return this.__currency_type;
	}

	public void setCurrencyType( java.lang.Integer value ) {
		this.__currency_type = value;
	}

	public java.util.Date getCompleteTime() {
		return this.__complete_time;
	}

	public void setCompleteTime( java.util.Date value ) {
		this.__complete_time = value;
	}

	public void cloneCopy(BaseTransDetailNeedToUpdateRate __bean){
		__bean.setFinancialTransactionDetailId(getFinancialTransactionDetailId());
		__bean.setOriginalDebit(getOriginalDebit());
		__bean.setOriginalCredit(getOriginalCredit());
		__bean.setCurrencyType(getCurrencyType());
		__bean.setCompleteTime(getCompleteTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialTransactionDetailId() == null ? "" : getFinancialTransactionDetailId());
		sb.append(",");
		sb.append(getOriginalDebit() == null ? "" : getOriginalDebit());
		sb.append(",");
		sb.append(getOriginalCredit() == null ? "" : getOriginalCredit());
		sb.append(",");
		sb.append(getCurrencyType() == null ? "" : getCurrencyType());
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTransDetailNeedToUpdateRate o) {
		return __financial_transaction_detail_id == null ? -1 : __financial_transaction_detail_id.compareTo(o.getFinancialTransactionDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__original_debit);
		hash = 97 * hash + Objects.hashCode(this.__original_credit);
		hash = 97 * hash + Objects.hashCode(this.__currency_type);
		hash = 97 * hash + Objects.hashCode(this.__complete_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTransDetailNeedToUpdateRate o = (BaseTransDetailNeedToUpdateRate)obj;
		if(!Objects.equals(this.__financial_transaction_detail_id, o.getFinancialTransactionDetailId())) return false;
		if(!Objects.equals(this.__original_debit, o.getOriginalDebit())) return false;
		if(!Objects.equals(this.__original_credit, o.getOriginalCredit())) return false;
		if(!Objects.equals(this.__currency_type, o.getCurrencyType())) return false;
		if(!Objects.equals(this.__complete_time, o.getCompleteTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialTransactionDetailId() != null) sb.append(__wrapNumber(count++, "financialTransactionDetailId", getFinancialTransactionDetailId()));
		if(getOriginalDebit() != null) sb.append(__wrapDecimal(count++, "originalDebit", getOriginalDebit()));
		if(getOriginalCredit() != null) sb.append(__wrapDecimal(count++, "originalCredit", getOriginalCredit()));
		if(getCurrencyType() != null) sb.append(__wrapNumber(count++, "currencyType", getCurrencyType()));
		if(getCompleteTime() != null) sb.append(__wrapDate(count++, "completeTime", getCompleteTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialTransactionDetailId() != null) res.put("financialTransactionDetailId", getFinancialTransactionDetailId());
		if(getOriginalDebit() != null) res.put("originalDebit", getOriginalDebit());
		if(getOriginalCredit() != null) res.put("originalCredit", getOriginalCredit());
		if(getCurrencyType() != null) res.put("currencyType", getCurrencyType());
		if(getCompleteTime() != null) res.put("completeTime", getCompleteTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialTransactionDetailId")) != null) setFinancialTransactionDetailId(__getInt(val)); 
		if((val = values.get("originalDebit")) != null) setOriginalDebit(__getDecimal(val));  
		if((val = values.get("originalCredit")) != null) setOriginalCredit(__getDecimal(val));  
		if((val = values.get("currencyType")) != null) setCurrencyType(__getInt(val)); 
		if((val = values.get("completeTime")) != null) setCompleteTime(__getDate(val)); 
	}

	protected java.lang.Integer  __financial_transaction_detail_id ;
	protected java.math.BigDecimal  __original_debit ;
	protected java.math.BigDecimal  __original_credit ;
	protected java.lang.Integer  __currency_type ;
	protected java.util.Date  __complete_time ;
}
