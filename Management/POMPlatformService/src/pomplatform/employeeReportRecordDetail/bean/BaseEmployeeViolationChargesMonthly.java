package pomplatform.employeeReportRecordDetail.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeViolationChargesMonthly extends GenericBase implements BaseFactory<BaseEmployeeViolationChargesMonthly>, Comparable<BaseEmployeeViolationChargesMonthly> 
{


	public static BaseEmployeeViolationChargesMonthly newInstance(){
		return new BaseEmployeeViolationChargesMonthly();
	}

	@Override
	public BaseEmployeeViolationChargesMonthly make(){
		BaseEmployeeViolationChargesMonthly b = new BaseEmployeeViolationChargesMonthly();
		return b;
	}

	public final static java.lang.String CS_VIOLATION_YEAR = "violation_year" ;
	public final static java.lang.String CS_VIOLATION_MONTH = "violation_month" ;
	public final static java.lang.String CS_VIOLATION_CHARGES = "violation_charges" ;

	public final static java.lang.String ALL_CAPTIONS = "年份,月份,项目违规金";

	public java.lang.Integer getViolationYear() {
		return this.__violation_year;
	}

	public void setViolationYear( java.lang.Integer value ) {
		this.__violation_year = value;
	}

	public java.lang.Integer getViolationMonth() {
		return this.__violation_month;
	}

	public void setViolationMonth( java.lang.Integer value ) {
		this.__violation_month = value;
	}

	public java.math.BigDecimal getViolationCharges() {
		return this.__violation_charges;
	}

	public void setViolationCharges( java.math.BigDecimal value ) {
		this.__violation_charges = value;
	}

	public void cloneCopy(BaseEmployeeViolationChargesMonthly __bean){
		__bean.setViolationYear(getViolationYear());
		__bean.setViolationMonth(getViolationMonth());
		__bean.setViolationCharges(getViolationCharges());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getViolationYear() == null ? "" : getViolationYear());
		sb.append(",");
		sb.append(getViolationMonth() == null ? "" : getViolationMonth());
		sb.append(",");
		sb.append(getViolationCharges() == null ? "" : getViolationCharges());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeViolationChargesMonthly o) {
		return __violation_year == null ? -1 : __violation_year.compareTo(o.getViolationYear());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__violation_year);
		hash = 97 * hash + Objects.hashCode(this.__violation_month);
		hash = 97 * hash + Objects.hashCode(this.__violation_charges);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeViolationChargesMonthly o = (BaseEmployeeViolationChargesMonthly)obj;
		if(!Objects.equals(this.__violation_year, o.getViolationYear())) return false;
		if(!Objects.equals(this.__violation_month, o.getViolationMonth())) return false;
		if(!Objects.equals(this.__violation_charges, o.getViolationCharges())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getViolationYear() != null) sb.append(__wrapNumber(count++, "violationYear", getViolationYear()));
		if(getViolationMonth() != null) sb.append(__wrapNumber(count++, "violationMonth", getViolationMonth()));
		if(getViolationCharges() != null) sb.append(__wrapDecimal(count++, "violationCharges", getViolationCharges()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("violationYear")) != null) setViolationYear(__getInt(val));
		if((val = values.get("violationMonth")) != null) setViolationMonth(__getInt(val)); 
		if((val = values.get("violationCharges")) != null) setViolationCharges(__getDecimal(val));  
	}

	protected java.lang.Integer  __violation_year ;
	protected java.lang.Integer  __violation_month ;
	protected java.math.BigDecimal  __violation_charges ;
}
