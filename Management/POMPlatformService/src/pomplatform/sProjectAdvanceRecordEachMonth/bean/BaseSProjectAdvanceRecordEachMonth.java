package pomplatform.sProjectAdvanceRecordEachMonth.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSProjectAdvanceRecordEachMonth extends GenericBase implements BaseFactory<BaseSProjectAdvanceRecordEachMonth>, Comparable<BaseSProjectAdvanceRecordEachMonth> 
{


	public static BaseSProjectAdvanceRecordEachMonth newInstance(){
		return new BaseSProjectAdvanceRecordEachMonth();
	}

	@Override
	public BaseSProjectAdvanceRecordEachMonth make(){
		BaseSProjectAdvanceRecordEachMonth b = new BaseSProjectAdvanceRecordEachMonth();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_ADVANCE_YEAR = "advance_year" ;
	public final static java.lang.String CS_ADVANCE_MONTH = "advance_month" ;
	public final static java.lang.String CS_ADVANCE_INTEGRAL = "advance_integral" ;
	public final static java.lang.String CS_LEFT_INTEGRAL = "left_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,月份,补贴积分,剩余积分";

	public java.lang.String getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.String value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getAdvanceYear() {
		return this.__advance_year;
	}

	public void setAdvanceYear( java.lang.Integer value ) {
		this.__advance_year = value;
	}

	public java.lang.Integer getAdvanceMonth() {
		return this.__advance_month;
	}

	public void setAdvanceMonth( java.lang.Integer value ) {
		this.__advance_month = value;
	}

	public java.math.BigDecimal getAdvanceIntegral() {
		return this.__advance_integral;
	}

	public void setAdvanceIntegral( java.math.BigDecimal value ) {
		this.__advance_integral = value;
	}

	public java.math.BigDecimal getLeftIntegral() {
		return this.__left_integral;
	}

	public void setLeftIntegral( java.math.BigDecimal value ) {
		this.__left_integral = value;
	}

	public void cloneCopy(BaseSProjectAdvanceRecordEachMonth __bean){
		__bean.setPlateId(getPlateId());
		__bean.setAdvanceYear(getAdvanceYear());
		__bean.setAdvanceMonth(getAdvanceMonth());
		__bean.setAdvanceIntegral(getAdvanceIntegral());
		__bean.setLeftIntegral(getLeftIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getAdvanceYear() == null ? "" : getAdvanceYear());
		sb.append(",");
		sb.append(getAdvanceMonth() == null ? "" : getAdvanceMonth());
		sb.append(",");
		sb.append(getAdvanceIntegral() == null ? "" : getAdvanceIntegral());
		sb.append(",");
		sb.append(getLeftIntegral() == null ? "" : getLeftIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSProjectAdvanceRecordEachMonth o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__advance_year);
		hash = 97 * hash + Objects.hashCode(this.__advance_month);
		hash = 97 * hash + Objects.hashCode(this.__advance_integral);
		hash = 97 * hash + Objects.hashCode(this.__left_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSProjectAdvanceRecordEachMonth o = (BaseSProjectAdvanceRecordEachMonth)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__advance_year, o.getAdvanceYear())) return false;
		if(!Objects.equals(this.__advance_month, o.getAdvanceMonth())) return false;
		if(!Objects.equals(this.__advance_integral, o.getAdvanceIntegral())) return false;
		if(!Objects.equals(this.__left_integral, o.getLeftIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapString(count++, "plateId", getPlateId()));
		if(getAdvanceYear() != null) sb.append(__wrapNumber(count++, "advanceYear", getAdvanceYear()));
		if(getAdvanceMonth() != null) sb.append(__wrapNumber(count++, "advanceMonth", getAdvanceMonth()));
		if(getAdvanceIntegral() != null) sb.append(__wrapDecimal(count++, "advanceIntegral", getAdvanceIntegral()));
		if(getLeftIntegral() != null) sb.append(__wrapDecimal(count++, "leftIntegral", getLeftIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getString(val));
		if((val = values.get("advanceYear")) != null) setAdvanceYear(__getInt(val)); 
		if((val = values.get("advanceMonth")) != null) setAdvanceMonth(__getInt(val)); 
		if((val = values.get("advanceIntegral")) != null) setAdvanceIntegral(__getDecimal(val));  
		if((val = values.get("leftIntegral")) != null) setLeftIntegral(__getDecimal(val));  
	}

	protected java.lang.String  __plate_id ;
	protected java.lang.Integer  __advance_year ;
	protected java.lang.Integer  __advance_month ;
	protected java.math.BigDecimal  __advance_integral ;
	protected java.math.BigDecimal  __left_integral ;
}
