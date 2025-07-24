package pomplatform.updatedata.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseProjectSettlement extends GenericBase implements BaseFactory<BaseProjectSettlement>, Comparable<BaseProjectSettlement> 
{


	public static BaseProjectSettlement newInstance(){
		return new BaseProjectSettlement();
	}

	@Override
	public BaseProjectSettlement make(){
		BaseProjectSettlement b = new BaseProjectSettlement();
		return b;
	}

	public final static java.lang.String CS_SETTLEMENT = "settlement" ;
	public final static java.lang.String CS_SETTLEMENT_DATE = "settlement_date" ;

	public final static java.lang.String ALL_CAPTIONS = "确认积分,结算日期";

	public java.math.BigDecimal getSettlement() {
		return this.__settlement;
	}

	public void setSettlement( java.math.BigDecimal value ) {
		this.__settlement = value;
	}

	public java.util.Date getSettlementDate() {
		return this.__settlement_date;
	}

	public void setSettlementDate( java.util.Date value ) {
		this.__settlement_date = value;
	}

	public void cloneCopy(BaseProjectSettlement __bean){
		__bean.setSettlement(getSettlement());
		__bean.setSettlementDate(getSettlementDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSettlement() == null ? "" : getSettlement());
		sb.append(",");
		sb.append(getSettlementDate() == null ? "" : sdf.format(getSettlementDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectSettlement o) {
		return __settlement == null ? -1 : __settlement.compareTo(o.getSettlement());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__settlement);
		hash = 97 * hash + Objects.hashCode(this.__settlement_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectSettlement o = (BaseProjectSettlement)obj;
		if(!Objects.equals(this.__settlement, o.getSettlement())) return false;
		if(!Objects.equals(this.__settlement_date, o.getSettlementDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSettlement() != null) sb.append(__wrapDecimal(count++, "settlement", getSettlement()));
		if(getSettlementDate() != null) sb.append(__wrapDate(count++, "settlementDate", getSettlementDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("settlement")) != null) setSettlement(__getDecimal(val));  
		if((val = values.get("settlementDate")) != null) setSettlementDate(__getDate(val)); 
	}

	protected java.math.BigDecimal  __settlement ;
	protected java.util.Date  __settlement_date ;
}
