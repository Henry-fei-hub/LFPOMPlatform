package pomplatform.bonusPayment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasebonusSummaryDetail extends GenericBase implements BaseFactory<BasebonusSummaryDetail>, Comparable<BasebonusSummaryDetail> 
{


	public static BasebonusSummaryDetail newInstance(){
		return new BasebonusSummaryDetail();
	}

	@Override
	public BasebonusSummaryDetail make(){
		BasebonusSummaryDetail b = new BasebonusSummaryDetail();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_DEPARTMENT_NAME = "department_name" ;
	public final static java.lang.String CS_FIRST_PAY_INTEGRAL = "first_pay_integral" ;
	public final static java.lang.String CS_SECOND_PAY_INTEGRAL = "second_pay_integral" ;
	public final static java.lang.String CS_THIRD_PAY_INTEGRAL = "third_pay_integral" ;
	public final static java.lang.String CS_FOURTH_PAY_INTEGRAL = "fourth_pay_integral" ;
	public final static java.lang.String CS_TOTAL_PAY_INTEGRAL = "total_pay_integral" ;
	public final static java.lang.String CS_YEAR = "year" ;

	public final static java.lang.String ALL_CAPTIONS = "部门名称,年份,第一季度,第二季度,第三季度,第四季度,合计";

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getDepartmentName() {
		return this.__department_name;
	}

	public void setDepartmentName( java.lang.String value ) {
		this.__department_name = value;
	}

	public java.math.BigDecimal getFirstPayIntegral() {
		return this.__first_pay_integral;
	}

	public void setFirstPayIntegral( java.math.BigDecimal value ) {
		this.__first_pay_integral = value;
	}

	public java.math.BigDecimal getSecondPayIntegral() {
		return this.__second_pay_integral;
	}

	public void setSecondPayIntegral( java.math.BigDecimal value ) {
		this.__second_pay_integral = value;
	}

	public java.math.BigDecimal getThirdPayIntegral() {
		return this.__third_pay_integral;
	}

	public void setThirdPayIntegral( java.math.BigDecimal value ) {
		this.__third_pay_integral = value;
	}

	public java.math.BigDecimal getFourthPayIntegral() {
		return this.__fourth_pay_integral;
	}

	public void setFourthPayIntegral( java.math.BigDecimal value ) {
		this.__fourth_pay_integral = value;
	}

	public java.math.BigDecimal getTotalPayIntegral() {
		return this.__total_pay_integral;
	}

	public void setTotalPayIntegral( java.math.BigDecimal value ) {
		this.__total_pay_integral = value;
	}

	public java.lang.String getYear() {
		return this.__year;
	}

	public void setYear( java.lang.String value ) {
		this.__year = value;
	}

	public void cloneCopy(BasebonusSummaryDetail __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setDepartmentName(getDepartmentName());
		__bean.setFirstPayIntegral(getFirstPayIntegral());
		__bean.setSecondPayIntegral(getSecondPayIntegral());
		__bean.setThirdPayIntegral(getThirdPayIntegral());
		__bean.setFourthPayIntegral(getFourthPayIntegral());
		__bean.setTotalPayIntegral(getTotalPayIntegral());
		__bean.setYear(getYear());
	}

	public java.lang.String toCSVString() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		/*sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");*/
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getFirstPayIntegral() == null ? "" : getFirstPayIntegral());
		sb.append(",");
		sb.append(getSecondPayIntegral() == null ? "" : getSecondPayIntegral());
		sb.append(",");
		sb.append(getThirdPayIntegral() == null ? "" : getThirdPayIntegral());
		sb.append(",");
		sb.append(getFourthPayIntegral() == null ? "" : getFourthPayIntegral());
		sb.append(",");
		sb.append(getTotalPayIntegral() == null ? "" : getTotalPayIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BasebonusSummaryDetail o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__first_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__second_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__third_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__fourth_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__total_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__year);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasebonusSummaryDetail o = (BasebonusSummaryDetail)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__first_pay_integral, o.getFirstPayIntegral())) return false;
		if(!Objects.equals(this.__second_pay_integral, o.getSecondPayIntegral())) return false;
		if(!Objects.equals(this.__third_pay_integral, o.getThirdPayIntegral())) return false;
		if(!Objects.equals(this.__fourth_pay_integral, o.getFourthPayIntegral())) return false;
		if(!Objects.equals(this.__total_pay_integral, o.getTotalPayIntegral())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getFirstPayIntegral() != null) sb.append(__wrapDecimal(count++, "firstPayIntegral", getFirstPayIntegral()));
		if(getSecondPayIntegral() != null) sb.append(__wrapDecimal(count++, "secondPayIntegral", getSecondPayIntegral()));
		if(getThirdPayIntegral() != null) sb.append(__wrapDecimal(count++, "thirdPayIntegral", getThirdPayIntegral()));
		if(getFourthPayIntegral() != null) sb.append(__wrapDecimal(count++, "fourthPayIntegral", getFourthPayIntegral()));
		if(getTotalPayIntegral() != null) sb.append(__wrapDecimal(count++, "totalPayIntegral", getTotalPayIntegral()));
		if(getYear() != null) sb.append(__wrapString(count++, "year", getYear()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getDepartmentName() != null) res.put("departmentName", getDepartmentName());
		if(getFirstPayIntegral() != null) res.put("firstPayIntegral", getFirstPayIntegral());
		if(getSecondPayIntegral() != null) res.put("secondPayIntegral", getSecondPayIntegral());
		if(getThirdPayIntegral() != null) res.put("thirdPayIntegral", getThirdPayIntegral());
		if(getFourthPayIntegral() != null) res.put("fourthPayIntegral", getFourthPayIntegral());
		if(getTotalPayIntegral() != null) res.put("totalPayIntegral", getTotalPayIntegral());
		if(getYear() != null) res.put("year", getYear());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("firstPayIntegral")) != null) setFirstPayIntegral(__getDecimal(val));  
		if((val = values.get("secondPayIntegral")) != null) setSecondPayIntegral(__getDecimal(val));  
		if((val = values.get("thirdPayIntegral")) != null) setThirdPayIntegral(__getDecimal(val));  
		if((val = values.get("fourthPayIntegral")) != null) setFourthPayIntegral(__getDecimal(val));  
		if((val = values.get("totalPayIntegral")) != null) setTotalPayIntegral(__getDecimal(val));  
		if((val = values.get("year")) != null) setYear(__getString(val));
	}

	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __department_name ;
	protected java.math.BigDecimal  __first_pay_integral ;
	protected java.math.BigDecimal  __second_pay_integral ;
	protected java.math.BigDecimal  __third_pay_integral ;
	protected java.math.BigDecimal  __fourth_pay_integral ;
	protected java.math.BigDecimal  __total_pay_integral ;
	protected java.lang.String  __year ;
}
