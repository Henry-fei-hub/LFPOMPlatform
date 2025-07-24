package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSumSalaryAndInsuranceCost extends GenericBase implements BaseFactory<BaseSumSalaryAndInsuranceCost>, Comparable<BaseSumSalaryAndInsuranceCost> 
{


	public static BaseSumSalaryAndInsuranceCost newInstance(){
		return new BaseSumSalaryAndInsuranceCost();
	}

	@Override
	public BaseSumSalaryAndInsuranceCost make(){
		BaseSumSalaryAndInsuranceCost b = new BaseSumSalaryAndInsuranceCost();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_THIS_PAY = "this_pay" ;
	public final static java.lang.String CS_LAST_PAY = "last_pay" ;
	public final static java.lang.String CS_PAY_RAISE = "pay_raise" ;
	public final static java.lang.String CS_THIS_INSURANCE = "this_insurance" ;
	public final static java.lang.String CS_LAST_INSURANCE = "last_insurance" ;
	public final static java.lang.String CS_INSURANCE_RAISE = "insurance_raise" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,月份,本月应付工资,上月应付工资,工资涨幅,本月社保公积金,上月社保公积金,社保公积金涨幅";

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

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.math.BigDecimal getThisPay() {
		return this.__this_pay;
	}

	public void setThisPay( java.math.BigDecimal value ) {
		this.__this_pay = value;
	}

	public java.math.BigDecimal getLastPay() {
		return this.__last_pay;
	}

	public void setLastPay( java.math.BigDecimal value ) {
		this.__last_pay = value;
	}

	public java.lang.String getPayRaise() {
		return this.__pay_raise;
	}

	public void setPayRaise( java.lang.String value ) {
		this.__pay_raise = value;
	}

	public java.math.BigDecimal getThisInsurance() {
		return this.__this_insurance;
	}

	public void setThisInsurance( java.math.BigDecimal value ) {
		this.__this_insurance = value;
	}

	public java.math.BigDecimal getLastInsurance() {
		return this.__last_insurance;
	}

	public void setLastInsurance( java.math.BigDecimal value ) {
		this.__last_insurance = value;
	}

	public java.lang.String getInsuranceRaise() {
		return this.__insurance_raise;
	}

	public void setInsuranceRaise( java.lang.String value ) {
		this.__insurance_raise = value;
	}

	public void cloneCopy(BaseSumSalaryAndInsuranceCost __bean){
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setThisPay(getThisPay());
		__bean.setLastPay(getLastPay());
		__bean.setPayRaise(getPayRaise());
		__bean.setThisInsurance(getThisInsurance());
		__bean.setLastInsurance(getLastInsurance());
		__bean.setInsuranceRaise(getInsuranceRaise());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getThisPay() == null ? "" : getThisPay());
		sb.append(",");
		sb.append(getLastPay() == null ? "" : getLastPay());
		sb.append(",");
		sb.append(getPayRaise() == null ? "" : getPayRaise());
		sb.append(",");
		sb.append(getThisInsurance() == null ? "" : getThisInsurance());
		sb.append(",");
		sb.append(getLastInsurance() == null ? "" : getLastInsurance());
		sb.append(",");
		sb.append(getInsuranceRaise() == null ? "" : getInsuranceRaise());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSumSalaryAndInsuranceCost o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__this_pay);
		hash = 97 * hash + Objects.hashCode(this.__last_pay);
		hash = 97 * hash + Objects.hashCode(this.__pay_raise);
		hash = 97 * hash + Objects.hashCode(this.__this_insurance);
		hash = 97 * hash + Objects.hashCode(this.__last_insurance);
		hash = 97 * hash + Objects.hashCode(this.__insurance_raise);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSumSalaryAndInsuranceCost o = (BaseSumSalaryAndInsuranceCost)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__this_pay, o.getThisPay())) return false;
		if(!Objects.equals(this.__last_pay, o.getLastPay())) return false;
		if(!Objects.equals(this.__pay_raise, o.getPayRaise())) return false;
		if(!Objects.equals(this.__this_insurance, o.getThisInsurance())) return false;
		if(!Objects.equals(this.__last_insurance, o.getLastInsurance())) return false;
		if(!Objects.equals(this.__insurance_raise, o.getInsuranceRaise())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getThisPay() != null) sb.append(__wrapDecimal(count++, "thisPay", getThisPay()));
		if(getLastPay() != null) sb.append(__wrapDecimal(count++, "lastPay", getLastPay()));
		if(getPayRaise() != null) sb.append(__wrapString(count++, "payRaise", getPayRaise()));
		if(getThisInsurance() != null) sb.append(__wrapDecimal(count++, "thisInsurance", getThisInsurance()));
		if(getLastInsurance() != null) sb.append(__wrapDecimal(count++, "lastInsurance", getLastInsurance()));
		if(getInsuranceRaise() != null) sb.append(__wrapString(count++, "insuranceRaise", getInsuranceRaise()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("thisPay")) != null) setThisPay(__getDecimal(val));  
		if((val = values.get("lastPay")) != null) setLastPay(__getDecimal(val));  
		if((val = values.get("payRaise")) != null) setPayRaise(__getString(val));
		if((val = values.get("thisInsurance")) != null) setThisInsurance(__getDecimal(val));  
		if((val = values.get("lastInsurance")) != null) setLastInsurance(__getDecimal(val));  
		if((val = values.get("insuranceRaise")) != null) setInsuranceRaise(__getString(val));
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __this_pay ;
	protected java.math.BigDecimal  __last_pay ;
	protected java.lang.String  __pay_raise ;
	protected java.math.BigDecimal  __this_insurance ;
	protected java.math.BigDecimal  __last_insurance ;
	protected java.lang.String  __insurance_raise ;
}
