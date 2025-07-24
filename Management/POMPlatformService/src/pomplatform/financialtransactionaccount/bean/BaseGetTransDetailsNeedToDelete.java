package pomplatform.financialtransactionaccount.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetTransDetailsNeedToDelete extends GenericBase implements BaseFactory<BaseGetTransDetailsNeedToDelete>, Comparable<BaseGetTransDetailsNeedToDelete> 
{


	public static BaseGetTransDetailsNeedToDelete newInstance(){
		return new BaseGetTransDetailsNeedToDelete();
	}

	@Override
	public BaseGetTransDetailsNeedToDelete make(){
		BaseGetTransDetailsNeedToDelete b = new BaseGetTransDetailsNeedToDelete();
		return b;
	}

	public final static java.lang.String CS_FINANCIAL_TRANSACTION_DETAIL_ID = "financial_transaction_detail_id" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码";

	public java.lang.Integer getFinancialTransactionDetailId() {
		return this.__financial_transaction_detail_id;
	}

	public void setFinancialTransactionDetailId( java.lang.Integer value ) {
		this.__financial_transaction_detail_id = value;
	}

	public void cloneCopy(BaseGetTransDetailsNeedToDelete __bean){
		__bean.setFinancialTransactionDetailId(getFinancialTransactionDetailId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getFinancialTransactionDetailId() == null ? "" : getFinancialTransactionDetailId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetTransDetailsNeedToDelete o) {
		return __financial_transaction_detail_id == null ? -1 : __financial_transaction_detail_id.compareTo(o.getFinancialTransactionDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__financial_transaction_detail_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetTransDetailsNeedToDelete o = (BaseGetTransDetailsNeedToDelete)obj;
		if(!Objects.equals(this.__financial_transaction_detail_id, o.getFinancialTransactionDetailId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFinancialTransactionDetailId() != null) sb.append(__wrapNumber(count++, "financialTransactionDetailId", getFinancialTransactionDetailId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getFinancialTransactionDetailId() != null) res.put("financialTransactionDetailId", getFinancialTransactionDetailId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("financialTransactionDetailId")) != null) setFinancialTransactionDetailId(__getInt(val)); 
	}

	protected java.lang.Integer  __financial_transaction_detail_id ;
}
