package pomplatform.PlateProjectAccountRecordByMonth.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePlateProjectAccountRecordByMonth extends GenericBase implements BaseFactory<BasePlateProjectAccountRecordByMonth>, Comparable<BasePlateProjectAccountRecordByMonth> 
{


	public static BasePlateProjectAccountRecordByMonth newInstance(){
		return new BasePlateProjectAccountRecordByMonth();
	}

	@Override
	public BasePlateProjectAccountRecordByMonth make(){
		BasePlateProjectAccountRecordByMonth b = new BasePlateProjectAccountRecordByMonth();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_RECORD_YEAR = "record_year" ;
	public final static java.lang.String CS_RECORD_MONTH = "record_month" ;
	public final static java.lang.String CS_ACCOUNT_INTEGRAL = "account_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,月份,结算积分";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getRecordYear() {
		return this.__record_year;
	}

	public void setRecordYear( java.lang.Integer value ) {
		this.__record_year = value;
	}

	public java.lang.Integer getRecordMonth() {
		return this.__record_month;
	}

	public void setRecordMonth( java.lang.Integer value ) {
		this.__record_month = value;
	}

	public java.math.BigDecimal getAccountIntegral() {
		return this.__account_integral;
	}

	public void setAccountIntegral( java.math.BigDecimal value ) {
		this.__account_integral = value;
	}

	public void cloneCopy(BasePlateProjectAccountRecordByMonth __bean){
		__bean.setPlateId(getPlateId());
		__bean.setRecordYear(getRecordYear());
		__bean.setRecordMonth(getRecordMonth());
		__bean.setAccountIntegral(getAccountIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getRecordYear() == null ? "" : getRecordYear());
		sb.append(",");
		sb.append(getRecordMonth() == null ? "" : getRecordMonth());
		sb.append(",");
		sb.append(getAccountIntegral() == null ? "" : getAccountIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateProjectAccountRecordByMonth o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__record_year);
		hash = 97 * hash + Objects.hashCode(this.__record_month);
		hash = 97 * hash + Objects.hashCode(this.__account_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateProjectAccountRecordByMonth o = (BasePlateProjectAccountRecordByMonth)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__record_year, o.getRecordYear())) return false;
		if(!Objects.equals(this.__record_month, o.getRecordMonth())) return false;
		if(!Objects.equals(this.__account_integral, o.getAccountIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getRecordYear() != null) sb.append(__wrapNumber(count++, "recordYear", getRecordYear()));
		if(getRecordMonth() != null) sb.append(__wrapNumber(count++, "recordMonth", getRecordMonth()));
		if(getAccountIntegral() != null) sb.append(__wrapDecimal(count++, "accountIntegral", getAccountIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("recordYear")) != null) setRecordYear(__getInt(val)); 
		if((val = values.get("recordMonth")) != null) setRecordMonth(__getInt(val)); 
		if((val = values.get("accountIntegral")) != null) setAccountIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __record_year ;
	protected java.lang.Integer  __record_month ;
	protected java.math.BigDecimal  __account_integral ;
}
