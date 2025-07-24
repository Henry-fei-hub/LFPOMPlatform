package pomplatform.newOutdesignconsiderationor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSoutdesignconsiderationor extends GenericBase implements BaseFactory<BaseSoutdesignconsiderationor>, Comparable<BaseSoutdesignconsiderationor> 
{


	public static BaseSoutdesignconsiderationor newInstance(){
		return new BaseSoutdesignconsiderationor();
	}

	@Override
	public BaseSoutdesignconsiderationor make(){
		BaseSoutdesignconsiderationor b = new BaseSoutdesignconsiderationor();
		return b;
	}

	public final static java.lang.String CS_OUT_QUOTATION_ID = "out_quotation_id" ;
	public final static java.lang.String CS_MONEY_SUM = "money_sum" ;
	public final static java.lang.String CS_INTERIOR_MONEY_SUM = "interior_money_sum" ;

	public final static java.lang.String ALL_CAPTIONS = "报价单表编码,小计 设计面积总金额,内部设计面积总金额";

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	public java.math.BigDecimal getMoneySum() {
		return this.__money_sum;
	}

	public void setMoneySum( java.math.BigDecimal value ) {
		this.__money_sum = value;
	}

	public java.math.BigDecimal getInteriorMoneySum() {
		return this.__interior_money_sum;
	}

	public void setInteriorMoneySum( java.math.BigDecimal value ) {
		this.__interior_money_sum = value;
	}

	public void cloneCopy(BaseSoutdesignconsiderationor __bean){
		__bean.setOutQuotationId(getOutQuotationId());
		__bean.setMoneySum(getMoneySum());
		__bean.setInteriorMoneySum(getInteriorMoneySum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOutQuotationId() == null ? "" : getOutQuotationId());
		sb.append(",");
		sb.append(getMoneySum() == null ? "" : getMoneySum());
		sb.append(",");
		sb.append(getInteriorMoneySum() == null ? "" : getInteriorMoneySum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSoutdesignconsiderationor o) {
		return __out_quotation_id == null ? -1 : __out_quotation_id.compareTo(o.getOutQuotationId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__out_quotation_id);
		hash = 97 * hash + Objects.hashCode(this.__money_sum);
		hash = 97 * hash + Objects.hashCode(this.__interior_money_sum);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSoutdesignconsiderationor o = (BaseSoutdesignconsiderationor)obj;
		if(!Objects.equals(this.__out_quotation_id, o.getOutQuotationId())) return false;
		if(!Objects.equals(this.__money_sum, o.getMoneySum())) return false;
		if(!Objects.equals(this.__interior_money_sum, o.getInteriorMoneySum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOutQuotationId() != null) sb.append(__wrapNumber(count++, "outQuotationId", getOutQuotationId()));
		if(getMoneySum() != null) sb.append(__wrapDecimal(count++, "moneySum", getMoneySum()));
		if(getInteriorMoneySum() != null) sb.append(__wrapDecimal(count++, "interiorMoneySum", getInteriorMoneySum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
		if((val = values.get("moneySum")) != null) setMoneySum(__getDecimal(val));  
		if((val = values.get("interiorMoneySum")) != null) setInteriorMoneySum(__getDecimal(val));  
	}

	protected java.lang.Integer  __out_quotation_id ;
	protected java.math.BigDecimal  __money_sum ;
	protected java.math.BigDecimal  __interior_money_sum ;
}
