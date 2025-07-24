package pomplatform.employee.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeFinancialTransSum extends GenericBase implements BaseFactory<BaseEmployeeFinancialTransSum>, Comparable<BaseEmployeeFinancialTransSum> 
{


	public static BaseEmployeeFinancialTransSum newInstance(){
		return new BaseEmployeeFinancialTransSum();
	}

	@Override
	public BaseEmployeeFinancialTransSum make(){
		BaseEmployeeFinancialTransSum b = new BaseEmployeeFinancialTransSum();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_TRANSACTION_ACCOUNT_ID = "financial_transaction_account_id" ;
	public final static java.lang.String CS_STANDARD_DEBIT = "standard_debit" ;
	public final static java.lang.String CS_STANDARD_CREDIT = "standard_credit" ;
	public final static java.lang.String CS_BORROW_LIMIT = "borrow_limit" ;

	public final static java.lang.String ALL_CAPTIONS = "财务往来账户编码,本币借,本币贷,借款额度";

	public java.lang.Integer getFinancialTransactionAccountId() {
		return this.__financial_transaction_account_id;
	}

	public void setFinancialTransactionAccountId( java.lang.Integer value ) {
		this.__financial_transaction_account_id = value;
	}

	public java.math.BigDecimal getStandardDebit() {
		return this.__standard_debit;
	}

	public void setStandardDebit( java.math.BigDecimal value ) {
		this.__standard_debit = value;
	}

	public java.math.BigDecimal getStandardCredit() {
		return this.__standard_credit;
	}

	public void setStandardCredit( java.math.BigDecimal value ) {
		this.__standard_credit = value;
	}

	public java.math.BigDecimal getBorrowLimit() {
		return this.__borrow_limit;
	}

	public void setBorrowLimit( java.math.BigDecimal value ) {
		this.__borrow_limit = value;
	}

	public void cloneCopy(BaseEmployeeFinancialTransSum __bean){
		__bean.setFinancialTransactionAccountId(getFinancialTransactionAccountId());
		__bean.setStandardDebit(getStandardDebit());
		__bean.setStandardCredit(getStandardCredit());
		__bean.setBorrowLimit(getBorrowLimit());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialTransactionAccountId() == null ? "" : getFinancialTransactionAccountId());
		sb.append(",");
		sb.append(getStandardDebit() == null ? "" : getStandardDebit());
		sb.append(",");
		sb.append(getStandardCredit() == null ? "" : getStandardCredit());
		sb.append(",");
		sb.append(getBorrowLimit() == null ? "" : getBorrowLimit());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeFinancialTransSum o) {
		return __financial_transaction_account_id == null ? -1 : __financial_transaction_account_id.compareTo(o.getFinancialTransactionAccountId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_account_id);
		hash = 97 * hash + Objects.hashCode(this.__standard_debit);
		hash = 97 * hash + Objects.hashCode(this.__standard_credit);
		hash = 97 * hash + Objects.hashCode(this.__borrow_limit);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeFinancialTransSum o = (BaseEmployeeFinancialTransSum)obj;
		if(!Objects.equals(this.__financial_transaction_account_id, o.getFinancialTransactionAccountId())) return false;
		if(!Objects.equals(this.__standard_debit, o.getStandardDebit())) return false;
		if(!Objects.equals(this.__standard_credit, o.getStandardCredit())) return false;
		if(!Objects.equals(this.__borrow_limit, o.getBorrowLimit())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialTransactionAccountId() != null) sb.append(__wrapNumber(count++, "financialTransactionAccountId", getFinancialTransactionAccountId()));
		if(getStandardDebit() != null) sb.append(__wrapDecimal(count++, "standardDebit", getStandardDebit()));
		if(getStandardCredit() != null) sb.append(__wrapDecimal(count++, "standardCredit", getStandardCredit()));
		if(getBorrowLimit() != null) sb.append(__wrapDecimal(count++, "borrowLimit", getBorrowLimit()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialTransactionAccountId() != null) res.put("financialTransactionAccountId", getFinancialTransactionAccountId());
		if(getStandardDebit() != null) res.put("standardDebit", getStandardDebit());
		if(getStandardCredit() != null) res.put("standardCredit", getStandardCredit());
		if(getBorrowLimit() != null) res.put("borrowLimit", getBorrowLimit());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialTransactionAccountId")) != null) setFinancialTransactionAccountId(__getInt(val)); 
		if((val = values.get("standardDebit")) != null) setStandardDebit(__getDecimal(val));  
		if((val = values.get("standardCredit")) != null) setStandardCredit(__getDecimal(val));  
		if((val = values.get("borrowLimit")) != null) setBorrowLimit(__getDecimal(val));  
	}

	protected java.lang.Integer  __financial_transaction_account_id ;
	protected java.math.BigDecimal  __standard_debit ;
	protected java.math.BigDecimal  __standard_credit ;
	protected java.math.BigDecimal  __borrow_limit ;
}
