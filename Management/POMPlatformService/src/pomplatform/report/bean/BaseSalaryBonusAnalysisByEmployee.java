package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSalaryBonusAnalysisByEmployee extends GenericBase implements BaseFactory<BaseSalaryBonusAnalysisByEmployee>, Comparable<BaseSalaryBonusAnalysisByEmployee> 
{


	public static BaseSalaryBonusAnalysisByEmployee newInstance(){
		return new BaseSalaryBonusAnalysisByEmployee();
	}

	@Override
	public BaseSalaryBonusAnalysisByEmployee make(){
		BaseSalaryBonusAnalysisByEmployee b = new BaseSalaryBonusAnalysisByEmployee();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_FIRST_QUARTER = "first_quarter" ;
	public final static java.lang.String CS_FIRST_PAY_INTEGRAL = "first_pay_integral" ;
	public final static java.lang.String CS_ONE = "one" ;
	public final static java.lang.String CS_SECOND_QUARTER = "second_quarter" ;
	public final static java.lang.String CS_SECOND_PAY_INTEGRAL = "second_pay_integral" ;
	public final static java.lang.String CS_TWO = "two" ;
	public final static java.lang.String CS_THIRD_QUARTER = "third_quarter" ;
	public final static java.lang.String CS_THIRD_PAY_INTEGRAL = "third_pay_integral" ;
	public final static java.lang.String CS_THREE = "three" ;
	public final static java.lang.String CS_FOURTH_QUARTER = "fourth_quarter" ;
	public final static java.lang.String CS_FOURTH_PAY_INTEGRAL = "fourth_pay_integral" ;
	public final static java.lang.String CS_FOUR = "four" ;

	public final static java.lang.String ALL_CAPTIONS = "员工id,年份,第一季度奖金,第一季度薪酬,,,,,,,,,,";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.math.BigDecimal getFirstQuarter() {
		return this.__first_quarter;
	}

	public void setFirstQuarter( java.math.BigDecimal value ) {
		this.__first_quarter = value;
	}

	public java.math.BigDecimal getFirstPayIntegral() {
		return this.__first_pay_integral;
	}

	public void setFirstPayIntegral( java.math.BigDecimal value ) {
		this.__first_pay_integral = value;
	}

	public java.math.BigDecimal getOne() {
		return this.__one;
	}

	public void setOne( java.math.BigDecimal value ) {
		this.__one = value;
	}

	public java.math.BigDecimal getSecondQuarter() {
		return this.__second_quarter;
	}

	public void setSecondQuarter( java.math.BigDecimal value ) {
		this.__second_quarter = value;
	}

	public java.math.BigDecimal getSecondPayIntegral() {
		return this.__second_pay_integral;
	}

	public void setSecondPayIntegral( java.math.BigDecimal value ) {
		this.__second_pay_integral = value;
	}

	public java.math.BigDecimal getTwo() {
		return this.__two;
	}

	public void setTwo( java.math.BigDecimal value ) {
		this.__two = value;
	}

	public java.math.BigDecimal getThirdQuarter() {
		return this.__third_quarter;
	}

	public void setThirdQuarter( java.math.BigDecimal value ) {
		this.__third_quarter = value;
	}

	public java.math.BigDecimal getThirdPayIntegral() {
		return this.__third_pay_integral;
	}

	public void setThirdPayIntegral( java.math.BigDecimal value ) {
		this.__third_pay_integral = value;
	}

	public java.math.BigDecimal getThree() {
		return this.__three;
	}

	public void setThree( java.math.BigDecimal value ) {
		this.__three = value;
	}

	public java.math.BigDecimal getFourthQuarter() {
		return this.__fourth_quarter;
	}

	public void setFourthQuarter( java.math.BigDecimal value ) {
		this.__fourth_quarter = value;
	}

	public java.math.BigDecimal getFourthPayIntegral() {
		return this.__fourth_pay_integral;
	}

	public void setFourthPayIntegral( java.math.BigDecimal value ) {
		this.__fourth_pay_integral = value;
	}

	public java.math.BigDecimal getFour() {
		return this.__four;
	}

	public void setFour( java.math.BigDecimal value ) {
		this.__four = value;
	}

	public void cloneCopy(BaseSalaryBonusAnalysisByEmployee __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setFirstQuarter(getFirstQuarter());
		__bean.setFirstPayIntegral(getFirstPayIntegral());
		__bean.setOne(getOne());
		__bean.setSecondQuarter(getSecondQuarter());
		__bean.setSecondPayIntegral(getSecondPayIntegral());
		__bean.setTwo(getTwo());
		__bean.setThirdQuarter(getThirdQuarter());
		__bean.setThirdPayIntegral(getThirdPayIntegral());
		__bean.setThree(getThree());
		__bean.setFourthQuarter(getFourthQuarter());
		__bean.setFourthPayIntegral(getFourthPayIntegral());
		__bean.setFour(getFour());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getFirstQuarter() == null ? "" : getFirstQuarter());
		sb.append(",");
		sb.append(getFirstPayIntegral() == null ? "" : getFirstPayIntegral());
		sb.append(",");
		sb.append(getOne() == null ? "" : getOne());
		sb.append(",");
		sb.append(getSecondQuarter() == null ? "" : getSecondQuarter());
		sb.append(",");
		sb.append(getSecondPayIntegral() == null ? "" : getSecondPayIntegral());
		sb.append(",");
		sb.append(getTwo() == null ? "" : getTwo());
		sb.append(",");
		sb.append(getThirdQuarter() == null ? "" : getThirdQuarter());
		sb.append(",");
		sb.append(getThirdPayIntegral() == null ? "" : getThirdPayIntegral());
		sb.append(",");
		sb.append(getThree() == null ? "" : getThree());
		sb.append(",");
		sb.append(getFourthQuarter() == null ? "" : getFourthQuarter());
		sb.append(",");
		sb.append(getFourthPayIntegral() == null ? "" : getFourthPayIntegral());
		sb.append(",");
		sb.append(getFour() == null ? "" : getFour());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryBonusAnalysisByEmployee o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__first_quarter);
		hash = 97 * hash + Objects.hashCode(this.__first_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__one);
		hash = 97 * hash + Objects.hashCode(this.__second_quarter);
		hash = 97 * hash + Objects.hashCode(this.__second_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__two);
		hash = 97 * hash + Objects.hashCode(this.__third_quarter);
		hash = 97 * hash + Objects.hashCode(this.__third_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__three);
		hash = 97 * hash + Objects.hashCode(this.__fourth_quarter);
		hash = 97 * hash + Objects.hashCode(this.__fourth_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__four);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryBonusAnalysisByEmployee o = (BaseSalaryBonusAnalysisByEmployee)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__first_quarter, o.getFirstQuarter())) return false;
		if(!Objects.equals(this.__first_pay_integral, o.getFirstPayIntegral())) return false;
		if(!Objects.equals(this.__one, o.getOne())) return false;
		if(!Objects.equals(this.__second_quarter, o.getSecondQuarter())) return false;
		if(!Objects.equals(this.__second_pay_integral, o.getSecondPayIntegral())) return false;
		if(!Objects.equals(this.__two, o.getTwo())) return false;
		if(!Objects.equals(this.__third_quarter, o.getThirdQuarter())) return false;
		if(!Objects.equals(this.__third_pay_integral, o.getThirdPayIntegral())) return false;
		if(!Objects.equals(this.__three, o.getThree())) return false;
		if(!Objects.equals(this.__fourth_quarter, o.getFourthQuarter())) return false;
		if(!Objects.equals(this.__fourth_pay_integral, o.getFourthPayIntegral())) return false;
		if(!Objects.equals(this.__four, o.getFour())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getFirstQuarter() != null) sb.append(__wrapDecimal(count++, "firstQuarter", getFirstQuarter()));
		if(getFirstPayIntegral() != null) sb.append(__wrapDecimal(count++, "firstPayIntegral", getFirstPayIntegral()));
		if(getOne() != null) sb.append(__wrapDecimal(count++, "one", getOne()));
		if(getSecondQuarter() != null) sb.append(__wrapDecimal(count++, "secondQuarter", getSecondQuarter()));
		if(getSecondPayIntegral() != null) sb.append(__wrapDecimal(count++, "secondPayIntegral", getSecondPayIntegral()));
		if(getTwo() != null) sb.append(__wrapDecimal(count++, "two", getTwo()));
		if(getThirdQuarter() != null) sb.append(__wrapDecimal(count++, "thirdQuarter", getThirdQuarter()));
		if(getThirdPayIntegral() != null) sb.append(__wrapDecimal(count++, "thirdPayIntegral", getThirdPayIntegral()));
		if(getThree() != null) sb.append(__wrapDecimal(count++, "three", getThree()));
		if(getFourthQuarter() != null) sb.append(__wrapDecimal(count++, "fourthQuarter", getFourthQuarter()));
		if(getFourthPayIntegral() != null) sb.append(__wrapDecimal(count++, "fourthPayIntegral", getFourthPayIntegral()));
		if(getFour() != null) sb.append(__wrapDecimal(count++, "four", getFour()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getYear() != null) res.put("year", getYear());
		if(getFirstQuarter() != null) res.put("firstQuarter", getFirstQuarter());
		if(getFirstPayIntegral() != null) res.put("firstPayIntegral", getFirstPayIntegral());
		if(getOne() != null) res.put("one", getOne());
		if(getSecondQuarter() != null) res.put("secondQuarter", getSecondQuarter());
		if(getSecondPayIntegral() != null) res.put("secondPayIntegral", getSecondPayIntegral());
		if(getTwo() != null) res.put("two", getTwo());
		if(getThirdQuarter() != null) res.put("thirdQuarter", getThirdQuarter());
		if(getThirdPayIntegral() != null) res.put("thirdPayIntegral", getThirdPayIntegral());
		if(getThree() != null) res.put("three", getThree());
		if(getFourthQuarter() != null) res.put("fourthQuarter", getFourthQuarter());
		if(getFourthPayIntegral() != null) res.put("fourthPayIntegral", getFourthPayIntegral());
		if(getFour() != null) res.put("four", getFour());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("firstQuarter")) != null) setFirstQuarter(__getDecimal(val));  
		if((val = values.get("firstPayIntegral")) != null) setFirstPayIntegral(__getDecimal(val));  
		if((val = values.get("one")) != null) setOne(__getDecimal(val));  
		if((val = values.get("secondQuarter")) != null) setSecondQuarter(__getDecimal(val));  
		if((val = values.get("secondPayIntegral")) != null) setSecondPayIntegral(__getDecimal(val));  
		if((val = values.get("two")) != null) setTwo(__getDecimal(val));  
		if((val = values.get("thirdQuarter")) != null) setThirdQuarter(__getDecimal(val));  
		if((val = values.get("thirdPayIntegral")) != null) setThirdPayIntegral(__getDecimal(val));  
		if((val = values.get("three")) != null) setThree(__getDecimal(val));  
		if((val = values.get("fourthQuarter")) != null) setFourthQuarter(__getDecimal(val));  
		if((val = values.get("fourthPayIntegral")) != null) setFourthPayIntegral(__getDecimal(val));  
		if((val = values.get("four")) != null) setFour(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __first_quarter ;
	protected java.math.BigDecimal  __first_pay_integral ;
	protected java.math.BigDecimal  __one ;
	protected java.math.BigDecimal  __second_quarter ;
	protected java.math.BigDecimal  __second_pay_integral ;
	protected java.math.BigDecimal  __two ;
	protected java.math.BigDecimal  __third_quarter ;
	protected java.math.BigDecimal  __third_pay_integral ;
	protected java.math.BigDecimal  __three ;
	protected java.math.BigDecimal  __fourth_quarter ;
	protected java.math.BigDecimal  __fourth_pay_integral ;
	protected java.math.BigDecimal  __four ;
}
