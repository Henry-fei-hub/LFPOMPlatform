package pomplatform.sPlateSalaryAdvanceEachMonthRecord.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSPlateSalaryAdvanceEachMonthRecord extends GenericBase implements BaseFactory<BaseSPlateSalaryAdvanceEachMonthRecord>, Comparable<BaseSPlateSalaryAdvanceEachMonthRecord> 
{


	public static BaseSPlateSalaryAdvanceEachMonthRecord newInstance(){
		return new BaseSPlateSalaryAdvanceEachMonthRecord();
	}

	@Override
	public BaseSPlateSalaryAdvanceEachMonthRecord make(){
		BaseSPlateSalaryAdvanceEachMonthRecord b = new BaseSPlateSalaryAdvanceEachMonthRecord();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_RECORD_YEAR = "record_year" ;
	public final static java.lang.String CS_RECORD_MONTH = "record_month" ;
	public final static java.lang.String CS_SALARY_RETURN = "salary_return" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,月份,积分补贴";

	public java.lang.String getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.String value ) {
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

	public java.math.BigDecimal getSalaryReturn() {
		return this.__salary_return;
	}

	public void setSalaryReturn( java.math.BigDecimal value ) {
		this.__salary_return = value;
	}

	public void cloneCopy(BaseSPlateSalaryAdvanceEachMonthRecord __bean){
		__bean.setPlateId(getPlateId());
		__bean.setRecordYear(getRecordYear());
		__bean.setRecordMonth(getRecordMonth());
		__bean.setSalaryReturn(getSalaryReturn());
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
		sb.append(getSalaryReturn() == null ? "" : getSalaryReturn());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSPlateSalaryAdvanceEachMonthRecord o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__record_year);
		hash = 97 * hash + Objects.hashCode(this.__record_month);
		hash = 97 * hash + Objects.hashCode(this.__salary_return);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSPlateSalaryAdvanceEachMonthRecord o = (BaseSPlateSalaryAdvanceEachMonthRecord)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__record_year, o.getRecordYear())) return false;
		if(!Objects.equals(this.__record_month, o.getRecordMonth())) return false;
		if(!Objects.equals(this.__salary_return, o.getSalaryReturn())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapString(count++, "plateId", getPlateId()));
		if(getRecordYear() != null) sb.append(__wrapNumber(count++, "recordYear", getRecordYear()));
		if(getRecordMonth() != null) sb.append(__wrapNumber(count++, "recordMonth", getRecordMonth()));
		if(getSalaryReturn() != null) sb.append(__wrapDecimal(count++, "salaryReturn", getSalaryReturn()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getString(val));
		if((val = values.get("recordYear")) != null) setRecordYear(__getInt(val)); 
		if((val = values.get("recordMonth")) != null) setRecordMonth(__getInt(val)); 
		if((val = values.get("salaryReturn")) != null) setSalaryReturn(__getDecimal(val));  
	}

	protected java.lang.String  __plate_id ;
	protected java.lang.Integer  __record_year ;
	protected java.lang.Integer  __record_month ;
	protected java.math.BigDecimal  __salary_return ;
}
