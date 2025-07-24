package pomplatform.sProjectSettlementDetailEachMonth.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSProjectSettlementDetailEachMonth extends GenericBase implements BaseFactory<BaseSProjectSettlementDetailEachMonth>, Comparable<BaseSProjectSettlementDetailEachMonth> 
{


	public static BaseSProjectSettlementDetailEachMonth newInstance(){
		return new BaseSProjectSettlementDetailEachMonth();
	}

	@Override
	public BaseSProjectSettlementDetailEachMonth make(){
		BaseSProjectSettlementDetailEachMonth b = new BaseSProjectSettlementDetailEachMonth();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SETTLEMENT_YEAR = "settlement_year" ;
	public final static java.lang.String CS_SETTLEMENT_MONTH = "settlement_month" ;
	public final static java.lang.String CS_REAL_AMOUNT = "real_amount" ;

	public final static java.lang.String ALL_CAPTIONS = "姓名,年份,月份,确认积分";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getSettlementYear() {
		return this.__settlement_year;
	}

	public void setSettlementYear( java.lang.Integer value ) {
		this.__settlement_year = value;
	}

	public java.lang.Integer getSettlementMonth() {
		return this.__settlement_month;
	}

	public void setSettlementMonth( java.lang.Integer value ) {
		this.__settlement_month = value;
	}

	public java.math.BigDecimal getRealAmount() {
		return this.__real_amount;
	}

	public void setRealAmount( java.math.BigDecimal value ) {
		this.__real_amount = value;
	}

	public void cloneCopy(BaseSProjectSettlementDetailEachMonth __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSettlementYear(getSettlementYear());
		__bean.setSettlementMonth(getSettlementMonth());
		__bean.setRealAmount(getRealAmount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getSettlementYear() == null ? "" : getSettlementYear());
		sb.append(",");
		sb.append(getSettlementMonth() == null ? "" : getSettlementMonth());
		sb.append(",");
		sb.append(getRealAmount() == null ? "" : getRealAmount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSProjectSettlementDetailEachMonth o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__settlement_year);
		hash = 97 * hash + Objects.hashCode(this.__settlement_month);
		hash = 97 * hash + Objects.hashCode(this.__real_amount);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSProjectSettlementDetailEachMonth o = (BaseSProjectSettlementDetailEachMonth)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__settlement_year, o.getSettlementYear())) return false;
		if(!Objects.equals(this.__settlement_month, o.getSettlementMonth())) return false;
		if(!Objects.equals(this.__real_amount, o.getRealAmount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSettlementYear() != null) sb.append(__wrapNumber(count++, "settlementYear", getSettlementYear()));
		if(getSettlementMonth() != null) sb.append(__wrapNumber(count++, "settlementMonth", getSettlementMonth()));
		if(getRealAmount() != null) sb.append(__wrapDecimal(count++, "realAmount", getRealAmount()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("settlementYear")) != null) setSettlementYear(__getInt(val)); 
		if((val = values.get("settlementMonth")) != null) setSettlementMonth(__getInt(val)); 
		if((val = values.get("realAmount")) != null) setRealAmount(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __settlement_year ;
	protected java.lang.Integer  __settlement_month ;
	protected java.math.BigDecimal  __real_amount ;
}
