package pomplatform.financialStatements.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseFinancialInternalPayment extends GenericBase implements BaseFactory<BaseFinancialInternalPayment>, Comparable<BaseFinancialInternalPayment> 
{


	public static BaseFinancialInternalPayment newInstance(){
		return new BaseFinancialInternalPayment();
	}

	@Override
	public BaseFinancialInternalPayment make(){
		BaseFinancialInternalPayment b = new BaseFinancialInternalPayment();
		return b;
	}

	public final static java.lang.String CS_DIC_TYPE_VALUE_ID = "dic_type_value_id" ;
	public final static java.lang.String CS_AMOUNT = "amount" ;

	public final static java.lang.String ALL_CAPTIONS = "数据编码,金额";

	public java.lang.Integer getDicTypeValueId() {
		return this.__dic_type_value_id;
	}

	public void setDicTypeValueId( java.lang.Integer value ) {
		this.__dic_type_value_id = value;
	}

	public java.math.BigDecimal getAmount() {
		return this.__amount;
	}

	public void setAmount( java.math.BigDecimal value ) {
		this.__amount = value;
	}

	public void cloneCopy(BaseFinancialInternalPayment __bean){
		__bean.setDicTypeValueId(getDicTypeValueId());
		__bean.setAmount(getAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDicTypeValueId() == null ? "" : getDicTypeValueId());
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseFinancialInternalPayment o) {
		return __dic_type_value_id == null ? -1 : __dic_type_value_id.compareTo(o.getDicTypeValueId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__dic_type_value_id);
		hash = 97 * hash + Objects.hashCode(this.__amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseFinancialInternalPayment o = (BaseFinancialInternalPayment)obj;
		if(!Objects.equals(this.__dic_type_value_id, o.getDicTypeValueId())) return false;
		if(!Objects.equals(this.__amount, o.getAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDicTypeValueId() != null) sb.append(__wrapNumber(count++, "dicTypeValueId", getDicTypeValueId()));
		if(getAmount() != null) sb.append(__wrapDecimal(count++, "amount", getAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("dicTypeValueId")) != null) setDicTypeValueId(__getInt(val)); 
		if((val = values.get("amount")) != null) setAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __dic_type_value_id ;
	protected java.math.BigDecimal  __amount ;
}
