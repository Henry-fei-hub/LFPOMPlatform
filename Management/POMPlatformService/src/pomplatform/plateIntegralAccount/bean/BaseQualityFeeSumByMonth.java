package pomplatform.plateIntegralAccount.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseQualityFeeSumByMonth extends GenericBase implements BaseFactory<BaseQualityFeeSumByMonth>, Comparable<BaseQualityFeeSumByMonth> 
{


	public static BaseQualityFeeSumByMonth newInstance(){
		return new BaseQualityFeeSumByMonth();
	}

	@Override
	public BaseQualityFeeSumByMonth make(){
		BaseQualityFeeSumByMonth b = new BaseQualityFeeSumByMonth();
		return b;
	}

	public final static java.lang.String CS_SEND_YEAR = "send_year" ;
	public final static java.lang.String CS_SEND_MONTH = "send_month" ;
	public final static java.lang.String CS_SEND_INTEGRAL = "send_integral" ;

	public final static java.lang.String ALL_CAPTIONS = "年份,月份,发放积分";

	public java.lang.Integer getSendYear() {
		return this.__send_year;
	}

	public void setSendYear( java.lang.Integer value ) {
		this.__send_year = value;
	}

	public java.lang.Integer getSendMonth() {
		return this.__send_month;
	}

	public void setSendMonth( java.lang.Integer value ) {
		this.__send_month = value;
	}

	public java.math.BigDecimal getSendIntegral() {
		return this.__send_integral;
	}

	public void setSendIntegral( java.math.BigDecimal value ) {
		this.__send_integral = value;
	}

	public void cloneCopy(BaseQualityFeeSumByMonth __bean){
		__bean.setSendYear(getSendYear());
		__bean.setSendMonth(getSendMonth());
		__bean.setSendIntegral(getSendIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSendYear() == null ? "" : getSendYear());
		sb.append(",");
		sb.append(getSendMonth() == null ? "" : getSendMonth());
		sb.append(",");
		sb.append(getSendIntegral() == null ? "" : getSendIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseQualityFeeSumByMonth o) {
		return __send_year == null ? -1 : __send_year.compareTo(o.getSendYear());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__send_year);
		hash = 97 * hash + Objects.hashCode(this.__send_month);
		hash = 97 * hash + Objects.hashCode(this.__send_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseQualityFeeSumByMonth o = (BaseQualityFeeSumByMonth)obj;
		if(!Objects.equals(this.__send_year, o.getSendYear())) return false;
		if(!Objects.equals(this.__send_month, o.getSendMonth())) return false;
		if(!Objects.equals(this.__send_integral, o.getSendIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSendYear() != null) sb.append(__wrapNumber(count++, "sendYear", getSendYear()));
		if(getSendMonth() != null) sb.append(__wrapNumber(count++, "sendMonth", getSendMonth()));
		if(getSendIntegral() != null) sb.append(__wrapDecimal(count++, "sendIntegral", getSendIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("sendYear")) != null) setSendYear(__getInt(val)); 
		if((val = values.get("sendMonth")) != null) setSendMonth(__getInt(val)); 
		if((val = values.get("sendIntegral")) != null) setSendIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __send_year ;
	protected java.lang.Integer  __send_month ;
	protected java.math.BigDecimal  __send_integral ;
}
