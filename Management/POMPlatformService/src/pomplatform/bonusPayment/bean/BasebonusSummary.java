package pomplatform.bonusPayment.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasebonusSummary extends GenericBase implements BaseFactory<BasebonusSummary>, Comparable<BasebonusSummary> 
{


	public static BasebonusSummary newInstance(){
		return new BasebonusSummary();
	}

	@Override
	public BasebonusSummary make(){
		BasebonusSummary b = new BasebonusSummary();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PLATE_NAME = "plate_name" ;
	public final static java.lang.String CS_FIRST_PAY_INTEGRAL = "first_pay_integral" ;
	public final static java.lang.String CS_SECOND_PAY_INTEGRAL = "second_pay_integral" ;
	public final static java.lang.String CS_THIRD_PAY_INTEGRAL = "third_pay_integral" ;
	public final static java.lang.String CS_FOURTH_PAY_INTEGRAL = "fourth_pay_integral" ;
	public final static java.lang.String CS_TOTAL_PAY_INTEGRAL = "total_pay_integral" ;
	public final static java.lang.String CS_YEAR = "year" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,第一季度,第二季度,第三季度,第四季度,合计";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getPlateName() {
		return this.__plate_name;
	}

	public void setPlateName( java.lang.String value ) {
		this.__plate_name = value;
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

	public void cloneCopy(BasebonusSummary __bean){
		__bean.setPlateId(getPlateId());
		__bean.setPlateName(getPlateName());
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
		/*sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");*/
		sb.append(getPlateName() == null ? "" : getPlateName());
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
	public int compareTo(BasebonusSummary o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_name);
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
		final BasebonusSummary o = (BasebonusSummary)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__plate_name, o.getPlateName())) return false;
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
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPlateName() != null) sb.append(__wrapString(count++, "plateName", getPlateName()));
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
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getPlateName() != null) res.put("plateName", getPlateName());
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
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateName")) != null) setPlateName(__getString(val));
		if((val = values.get("firstPayIntegral")) != null) setFirstPayIntegral(__getDecimal(val));  
		if((val = values.get("secondPayIntegral")) != null) setSecondPayIntegral(__getDecimal(val));  
		if((val = values.get("thirdPayIntegral")) != null) setThirdPayIntegral(__getDecimal(val));  
		if((val = values.get("fourthPayIntegral")) != null) setFourthPayIntegral(__getDecimal(val));  
		if((val = values.get("totalPayIntegral")) != null) setTotalPayIntegral(__getDecimal(val));  
		if((val = values.get("year")) != null) setYear(__getString(val));
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __plate_name ;
	protected java.math.BigDecimal  __first_pay_integral ;
	protected java.math.BigDecimal  __second_pay_integral ;
	protected java.math.BigDecimal  __third_pay_integral ;
	protected java.math.BigDecimal  __fourth_pay_integral ;
	protected java.math.BigDecimal  __total_pay_integral ;
	protected java.lang.String  __year ;
}
