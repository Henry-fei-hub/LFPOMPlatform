package pomplatform.report.bean;

import java.util.Map;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePerCapitaSalaryAnalysis extends GenericBase implements BaseFactory<BasePerCapitaSalaryAnalysis>, Comparable<BasePerCapitaSalaryAnalysis> 
{


	public static BasePerCapitaSalaryAnalysis newInstance(){
		return new BasePerCapitaSalaryAnalysis();
	}

	@Override
	public BasePerCapitaSalaryAnalysis make(){
		BasePerCapitaSalaryAnalysis b = new BasePerCapitaSalaryAnalysis();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_FIRST_QUARTER = "first_quarter" ;
	public final static java.lang.String CS_FIRST_PAY_INTEGRAL = "first_pay_integral" ;
	public final static java.lang.String CS_ONE = "one" ;
	public final static java.lang.String CS_ONE_AVERAGE = "one_average" ;
	public final static java.lang.String CS_ONE_AVERAGE_NUM = "one_average_num" ;
	public final static java.lang.String CS_SECOND_QUARTER = "second_quarter" ;
	public final static java.lang.String CS_SECOND_PAY_INTEGRAL = "second_pay_integral" ;
	public final static java.lang.String CS_TWO = "two" ;
	public final static java.lang.String CS_TWO_AVERAGE = "two_average" ;
	public final static java.lang.String CS_TWO_AVERAGE_NUM = "two_average_num" ;
	public final static java.lang.String CS_THIRD_QUARTER = "third_quarter" ;
	public final static java.lang.String CS_THIRD_PAY_INTEGRAL = "third_pay_integral" ;
	public final static java.lang.String CS_THREE = "three" ;
	public final static java.lang.String CS_THREE_AVERAGE = "three_average" ;
	public final static java.lang.String CS_THREE_AVERAGE_NUM = "three_average_num" ;
	public final static java.lang.String CS_FOURTH_QUARTER = "fourth_quarter" ;
	public final static java.lang.String CS_FOURTH_PAY_INTEGRAL = "fourth_pay_integral" ;
	public final static java.lang.String CS_FOUR = "four" ;
	public final static java.lang.String CS_FOUR_AVERAGE = "four_average" ;
	public final static java.lang.String CS_FOUR_AVERAGE_NUM = "four_average_num" ;
	public final static java.lang.String CS_TOTAL_QUARTER = "total_quarter" ;
	public final static java.lang.String CS_TOTAL_PAY_QUARTER = "total_pay_quarter" ;
	public final static java.lang.String CS_FIVE = "five" ;
	public final static java.lang.String CS_FIVE_AVERAGE = "five_average" ;
	public final static java.lang.String CS_FIVE_AVERAGE_NUM = "five_average_num" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,第一季度薪酬,第一季度奖金,第一季度总收入,第一季度平均人数,第一季度人均薪酬,第二季度薪酬,第二季度奖金,第二季度总收入,第二季度平均人数,第二季度人均薪酬,第三季度薪酬,第三季度奖金,第三季度总收入,第三季度平均人数,第三季度人均薪酬,第四季度薪酬,第四季度奖金,第四季度总收入,第四季度平均人数,第四季度人均薪酬,年度薪酬,年度奖金,年度总收入,年度人数,年度人均薪酬";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public java.math.BigDecimal getOneAverage() {
		return this.__one_average;
	}

	public void setOneAverage( java.math.BigDecimal value ) {
		this.__one_average = value;
	}

	public java.math.BigDecimal getOneAverageNum() {
		return this.__one_average_num;
	}

	public void setOneAverageNum( java.math.BigDecimal value ) {
		this.__one_average_num = value;
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

	public java.math.BigDecimal getTwoAverage() {
		return this.__two_average;
	}

	public void setTwoAverage( java.math.BigDecimal value ) {
		this.__two_average = value;
	}

	public java.math.BigDecimal getTwoAverageNum() {
		return this.__two_average_num;
	}

	public void setTwoAverageNum( java.math.BigDecimal value ) {
		this.__two_average_num = value;
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

	public java.math.BigDecimal getThreeAverage() {
		return this.__three_average;
	}

	public void setThreeAverage( java.math.BigDecimal value ) {
		this.__three_average = value;
	}

	public java.math.BigDecimal getThreeAverageNum() {
		return this.__three_average_num;
	}

	public void setThreeAverageNum( java.math.BigDecimal value ) {
		this.__three_average_num = value;
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

	public java.math.BigDecimal getFourAverage() {
		return this.__four_average;
	}

	public void setFourAverage( java.math.BigDecimal value ) {
		this.__four_average = value;
	}

	public java.math.BigDecimal getFourAverageNum() {
		return this.__four_average_num;
	}

	public void setFourAverageNum( java.math.BigDecimal value ) {
		this.__four_average_num = value;
	}

	public java.math.BigDecimal getTotalQuarter() {
		return this.__total_quarter;
	}

	public void setTotalQuarter( java.math.BigDecimal value ) {
		this.__total_quarter = value;
	}

	public java.math.BigDecimal getTotalPayQuarter() {
		return this.__total_pay_quarter;
	}

	public void setTotalPayQuarter( java.math.BigDecimal value ) {
		this.__total_pay_quarter = value;
	}

	public java.math.BigDecimal getFive() {
		return this.__five;
	}

	public void setFive( java.math.BigDecimal value ) {
		this.__five = value;
	}

	public java.math.BigDecimal getFiveAverage() {
		return this.__five_average;
	}

	public void setFiveAverage( java.math.BigDecimal value ) {
		this.__five_average = value;
	}

	public java.math.BigDecimal getFiveAverageNum() {
		return this.__five_average_num;
	}

	public void setFiveAverageNum( java.math.BigDecimal value ) {
		this.__five_average_num = value;
	}

	public void cloneCopy(BasePerCapitaSalaryAnalysis __bean){
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setFirstQuarter(getFirstQuarter());
		__bean.setFirstPayIntegral(getFirstPayIntegral());
		__bean.setOne(getOne());
		__bean.setOneAverage(getOneAverage());
		__bean.setOneAverageNum(getOneAverageNum());
		__bean.setSecondQuarter(getSecondQuarter());
		__bean.setSecondPayIntegral(getSecondPayIntegral());
		__bean.setTwo(getTwo());
		__bean.setTwoAverage(getTwoAverage());
		__bean.setTwoAverageNum(getTwoAverageNum());
		__bean.setThirdQuarter(getThirdQuarter());
		__bean.setThirdPayIntegral(getThirdPayIntegral());
		__bean.setThree(getThree());
		__bean.setThreeAverage(getThreeAverage());
		__bean.setThreeAverageNum(getThreeAverageNum());
		__bean.setFourthQuarter(getFourthQuarter());
		__bean.setFourthPayIntegral(getFourthPayIntegral());
		__bean.setFour(getFour());
		__bean.setFourAverage(getFourAverage());
		__bean.setFourAverageNum(getFourAverageNum());
		__bean.setTotalQuarter(getTotalQuarter());
		__bean.setTotalPayQuarter(getTotalPayQuarter());
		__bean.setFive(getFive());
		__bean.setFiveAverage(getFiveAverage());
		__bean.setFiveAverageNum(getFiveAverageNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strBusinessLine = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strBusinessLine == null ? "" : strBusinessLine);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getFirstQuarter() == null ? "" : getFirstQuarter().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getFirstPayIntegral() == null ? "" : getFirstPayIntegral().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getOne() == null ? "" : getOne().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getOneAverage() == null ? "" : getOneAverage().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getOneAverageNum() == null ? "" : getOneAverageNum().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getSecondQuarter() == null ? "" : getSecondQuarter().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getSecondPayIntegral() == null ? "" : getSecondPayIntegral().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getTwo() == null ? "" : getTwo().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getTwoAverage() == null ? "" : getTwoAverage().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getTwoAverageNum() == null ? "" : getTwoAverageNum().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getThirdQuarter() == null ? "" : getThirdQuarter().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getThirdPayIntegral() == null ? "" : getThirdPayIntegral().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getThree() == null ? "" : getThree().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getThreeAverage() == null ? "" : getThreeAverage().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getThreeAverageNum() == null ? "" : getThreeAverageNum().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getFourthQuarter() == null ? "" : getFourthQuarter().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getFourthPayIntegral() == null ? "" : getFourthPayIntegral().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getFour() == null ? "" : getFour().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getFourAverage() == null ? "" : getFourAverage().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getFourAverageNum() == null ? "" : getFourAverageNum().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getTotalQuarter() == null ? "" : getTotalQuarter().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getTotalPayQuarter() == null ? "" : getTotalPayQuarter().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getFive() == null ? "" : getFive().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getFiveAverage() == null ? "" : getFiveAverage().setScale(2, BigDecimal.ROUND_DOWN));
		sb.append(",");
		sb.append(getFiveAverageNum() == null ? "" : getFiveAverageNum().setScale(2, BigDecimal.ROUND_DOWN));
		return sb.toString();
	}

	@Override
	public int compareTo(BasePerCapitaSalaryAnalysis o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__first_quarter);
		hash = 97 * hash + Objects.hashCode(this.__first_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__one);
		hash = 97 * hash + Objects.hashCode(this.__one_average);
		hash = 97 * hash + Objects.hashCode(this.__one_average_num);
		hash = 97 * hash + Objects.hashCode(this.__second_quarter);
		hash = 97 * hash + Objects.hashCode(this.__second_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__two);
		hash = 97 * hash + Objects.hashCode(this.__two_average);
		hash = 97 * hash + Objects.hashCode(this.__two_average_num);
		hash = 97 * hash + Objects.hashCode(this.__third_quarter);
		hash = 97 * hash + Objects.hashCode(this.__third_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__three);
		hash = 97 * hash + Objects.hashCode(this.__three_average);
		hash = 97 * hash + Objects.hashCode(this.__three_average_num);
		hash = 97 * hash + Objects.hashCode(this.__fourth_quarter);
		hash = 97 * hash + Objects.hashCode(this.__fourth_pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__four);
		hash = 97 * hash + Objects.hashCode(this.__four_average);
		hash = 97 * hash + Objects.hashCode(this.__four_average_num);
		hash = 97 * hash + Objects.hashCode(this.__total_quarter);
		hash = 97 * hash + Objects.hashCode(this.__total_pay_quarter);
		hash = 97 * hash + Objects.hashCode(this.__five);
		hash = 97 * hash + Objects.hashCode(this.__five_average);
		hash = 97 * hash + Objects.hashCode(this.__five_average_num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePerCapitaSalaryAnalysis o = (BasePerCapitaSalaryAnalysis)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__first_quarter, o.getFirstQuarter())) return false;
		if(!Objects.equals(this.__first_pay_integral, o.getFirstPayIntegral())) return false;
		if(!Objects.equals(this.__one, o.getOne())) return false;
		if(!Objects.equals(this.__one_average, o.getOneAverage())) return false;
		if(!Objects.equals(this.__one_average_num, o.getOneAverageNum())) return false;
		if(!Objects.equals(this.__second_quarter, o.getSecondQuarter())) return false;
		if(!Objects.equals(this.__second_pay_integral, o.getSecondPayIntegral())) return false;
		if(!Objects.equals(this.__two, o.getTwo())) return false;
		if(!Objects.equals(this.__two_average, o.getTwoAverage())) return false;
		if(!Objects.equals(this.__two_average_num, o.getTwoAverageNum())) return false;
		if(!Objects.equals(this.__third_quarter, o.getThirdQuarter())) return false;
		if(!Objects.equals(this.__third_pay_integral, o.getThirdPayIntegral())) return false;
		if(!Objects.equals(this.__three, o.getThree())) return false;
		if(!Objects.equals(this.__three_average, o.getThreeAverage())) return false;
		if(!Objects.equals(this.__three_average_num, o.getThreeAverageNum())) return false;
		if(!Objects.equals(this.__fourth_quarter, o.getFourthQuarter())) return false;
		if(!Objects.equals(this.__fourth_pay_integral, o.getFourthPayIntegral())) return false;
		if(!Objects.equals(this.__four, o.getFour())) return false;
		if(!Objects.equals(this.__four_average, o.getFourAverage())) return false;
		if(!Objects.equals(this.__four_average_num, o.getFourAverageNum())) return false;
		if(!Objects.equals(this.__total_quarter, o.getTotalQuarter())) return false;
		if(!Objects.equals(this.__total_pay_quarter, o.getTotalPayQuarter())) return false;
		if(!Objects.equals(this.__five, o.getFive())) return false;
		if(!Objects.equals(this.__five_average, o.getFiveAverage())) return false;
		if(!Objects.equals(this.__five_average_num, o.getFiveAverageNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getFirstQuarter() != null) sb.append(__wrapDecimal(count++, "firstQuarter", getFirstQuarter()));
		if(getFirstPayIntegral() != null) sb.append(__wrapDecimal(count++, "firstPayIntegral", getFirstPayIntegral()));
		if(getOne() != null) sb.append(__wrapDecimal(count++, "one", getOne()));
		if(getOneAverage() != null) sb.append(__wrapDecimal(count++, "oneAverage", getOneAverage()));
		if(getOneAverageNum() != null) sb.append(__wrapDecimal(count++, "oneAverageNum", getOneAverageNum()));
		if(getSecondQuarter() != null) sb.append(__wrapDecimal(count++, "secondQuarter", getSecondQuarter()));
		if(getSecondPayIntegral() != null) sb.append(__wrapDecimal(count++, "secondPayIntegral", getSecondPayIntegral()));
		if(getTwo() != null) sb.append(__wrapDecimal(count++, "two", getTwo()));
		if(getTwoAverage() != null) sb.append(__wrapDecimal(count++, "twoAverage", getTwoAverage()));
		if(getTwoAverageNum() != null) sb.append(__wrapDecimal(count++, "twoAverageNum", getTwoAverageNum()));
		if(getThirdQuarter() != null) sb.append(__wrapDecimal(count++, "thirdQuarter", getThirdQuarter()));
		if(getThirdPayIntegral() != null) sb.append(__wrapDecimal(count++, "thirdPayIntegral", getThirdPayIntegral()));
		if(getThree() != null) sb.append(__wrapDecimal(count++, "three", getThree()));
		if(getThreeAverage() != null) sb.append(__wrapDecimal(count++, "threeAverage", getThreeAverage()));
		if(getThreeAverageNum() != null) sb.append(__wrapDecimal(count++, "threeAverageNum", getThreeAverageNum()));
		if(getFourthQuarter() != null) sb.append(__wrapDecimal(count++, "fourthQuarter", getFourthQuarter()));
		if(getFourthPayIntegral() != null) sb.append(__wrapDecimal(count++, "fourthPayIntegral", getFourthPayIntegral()));
		if(getFour() != null) sb.append(__wrapDecimal(count++, "four", getFour()));
		if(getFourAverage() != null) sb.append(__wrapDecimal(count++, "fourAverage", getFourAverage()));
		if(getFourAverageNum() != null) sb.append(__wrapDecimal(count++, "fourAverageNum", getFourAverageNum()));
		if(getTotalQuarter() != null) sb.append(__wrapDecimal(count++, "totalQuarter", getTotalQuarter()));
		if(getTotalPayQuarter() != null) sb.append(__wrapDecimal(count++, "totalPayQuarter", getTotalPayQuarter()));
		if(getFive() != null) sb.append(__wrapDecimal(count++, "five", getFive()));
		if(getFiveAverage() != null) sb.append(__wrapDecimal(count++, "fiveAverage", getFiveAverage()));
		if(getFiveAverageNum() != null) sb.append(__wrapDecimal(count++, "fiveAverageNum", getFiveAverageNum()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getYear() != null) res.put("year", getYear());
		if(getFirstQuarter() != null) res.put("firstQuarter", getFirstQuarter());
		if(getFirstPayIntegral() != null) res.put("firstPayIntegral", getFirstPayIntegral());
		if(getOne() != null) res.put("one", getOne());
		if(getOneAverage() != null) res.put("oneAverage", getOneAverage());
		if(getOneAverageNum() != null) res.put("oneAverageNum", getOneAverageNum());
		if(getSecondQuarter() != null) res.put("secondQuarter", getSecondQuarter());
		if(getSecondPayIntegral() != null) res.put("secondPayIntegral", getSecondPayIntegral());
		if(getTwo() != null) res.put("two", getTwo());
		if(getTwoAverage() != null) res.put("twoAverage", getTwoAverage());
		if(getTwoAverageNum() != null) res.put("twoAverageNum", getTwoAverageNum());
		if(getThirdQuarter() != null) res.put("thirdQuarter", getThirdQuarter());
		if(getThirdPayIntegral() != null) res.put("thirdPayIntegral", getThirdPayIntegral());
		if(getThree() != null) res.put("three", getThree());
		if(getThreeAverage() != null) res.put("threeAverage", getThreeAverage());
		if(getThreeAverageNum() != null) res.put("threeAverageNum", getThreeAverageNum());
		if(getFourthQuarter() != null) res.put("fourthQuarter", getFourthQuarter());
		if(getFourthPayIntegral() != null) res.put("fourthPayIntegral", getFourthPayIntegral());
		if(getFour() != null) res.put("four", getFour());
		if(getFourAverage() != null) res.put("fourAverage", getFourAverage());
		if(getFourAverageNum() != null) res.put("fourAverageNum", getFourAverageNum());
		if(getTotalQuarter() != null) res.put("totalQuarter", getTotalQuarter());
		if(getTotalPayQuarter() != null) res.put("totalPayQuarter", getTotalPayQuarter());
		if(getFive() != null) res.put("five", getFive());
		if(getFiveAverage() != null) res.put("fiveAverage", getFiveAverage());
		if(getFiveAverageNum() != null) res.put("fiveAverageNum", getFiveAverageNum());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("firstQuarter")) != null) setFirstQuarter(__getDecimal(val));  
		if((val = values.get("firstPayIntegral")) != null) setFirstPayIntegral(__getDecimal(val));  
		if((val = values.get("one")) != null) setOne(__getDecimal(val));  
		if((val = values.get("oneAverage")) != null) setOneAverage(__getDecimal(val));  
		if((val = values.get("oneAverageNum")) != null) setOneAverageNum(__getDecimal(val));  
		if((val = values.get("secondQuarter")) != null) setSecondQuarter(__getDecimal(val));  
		if((val = values.get("secondPayIntegral")) != null) setSecondPayIntegral(__getDecimal(val));  
		if((val = values.get("two")) != null) setTwo(__getDecimal(val));  
		if((val = values.get("twoAverage")) != null) setTwoAverage(__getDecimal(val));  
		if((val = values.get("twoAverageNum")) != null) setTwoAverageNum(__getDecimal(val));  
		if((val = values.get("thirdQuarter")) != null) setThirdQuarter(__getDecimal(val));  
		if((val = values.get("thirdPayIntegral")) != null) setThirdPayIntegral(__getDecimal(val));  
		if((val = values.get("three")) != null) setThree(__getDecimal(val));  
		if((val = values.get("threeAverage")) != null) setThreeAverage(__getDecimal(val));  
		if((val = values.get("threeAverageNum")) != null) setThreeAverageNum(__getDecimal(val));  
		if((val = values.get("fourthQuarter")) != null) setFourthQuarter(__getDecimal(val));  
		if((val = values.get("fourthPayIntegral")) != null) setFourthPayIntegral(__getDecimal(val));  
		if((val = values.get("four")) != null) setFour(__getDecimal(val));  
		if((val = values.get("fourAverage")) != null) setFourAverage(__getDecimal(val));  
		if((val = values.get("fourAverageNum")) != null) setFourAverageNum(__getDecimal(val));  
		if((val = values.get("totalQuarter")) != null) setTotalQuarter(__getDecimal(val));  
		if((val = values.get("totalPayQuarter")) != null) setTotalPayQuarter(__getDecimal(val));  
		if((val = values.get("five")) != null) setFive(__getDecimal(val));  
		if((val = values.get("fiveAverage")) != null) setFiveAverage(__getDecimal(val));  
		if((val = values.get("fiveAverageNum")) != null) setFiveAverageNum(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __first_quarter ;
	protected java.math.BigDecimal  __first_pay_integral ;
	protected java.math.BigDecimal  __one ;
	protected java.math.BigDecimal  __one_average ;
	protected java.math.BigDecimal  __one_average_num ;
	protected java.math.BigDecimal  __second_quarter ;
	protected java.math.BigDecimal  __second_pay_integral ;
	protected java.math.BigDecimal  __two ;
	protected java.math.BigDecimal  __two_average ;
	protected java.math.BigDecimal  __two_average_num ;
	protected java.math.BigDecimal  __third_quarter ;
	protected java.math.BigDecimal  __third_pay_integral ;
	protected java.math.BigDecimal  __three ;
	protected java.math.BigDecimal  __three_average ;
	protected java.math.BigDecimal  __three_average_num ;
	protected java.math.BigDecimal  __fourth_quarter ;
	protected java.math.BigDecimal  __fourth_pay_integral ;
	protected java.math.BigDecimal  __four ;
	protected java.math.BigDecimal  __four_average ;
	protected java.math.BigDecimal  __four_average_num ;
	protected java.math.BigDecimal  __total_quarter ;
	protected java.math.BigDecimal  __total_pay_quarter ;
	protected java.math.BigDecimal  __five ;
	protected java.math.BigDecimal  __five_average ;
	protected java.math.BigDecimal  __five_average_num ;
}
