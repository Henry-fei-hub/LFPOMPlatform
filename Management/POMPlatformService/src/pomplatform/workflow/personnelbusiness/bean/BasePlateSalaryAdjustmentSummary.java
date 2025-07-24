package pomplatform.workflow.personnelbusiness.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BasePlateSalaryAdjustmentSummary extends GenericBase implements BaseFactory<BasePlateSalaryAdjustmentSummary>, Comparable<BasePlateSalaryAdjustmentSummary> 
{


	public static BasePlateSalaryAdjustmentSummary newInstance(){
		return new BasePlateSalaryAdjustmentSummary();
	}

	@Override
	public BasePlateSalaryAdjustmentSummary make(){
		BasePlateSalaryAdjustmentSummary b = new BasePlateSalaryAdjustmentSummary();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_ORIGINAL_PAY = "original_pay" ;
	public final static java.lang.String CS_CHANGE_PAY = "change_pay" ;
	public final static java.lang.String CS_MONTH_PAY = "month_pay" ;
	public final static java.lang.String CS_PERCENT = "percent" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,现薪资,调整金额,调整后薪资总额,调薪比例";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getOriginalPay() {
		return this.__original_pay;
	}

	public void setOriginalPay( java.math.BigDecimal value ) {
		this.__original_pay = value;
	}

	public java.math.BigDecimal getChangePay() {
		return this.__change_pay;
	}

	public void setChangePay( java.math.BigDecimal value ) {
		this.__change_pay = value;
	}

	public java.math.BigDecimal getMonthPay() {
		return this.__month_pay;
	}

	public void setMonthPay( java.math.BigDecimal value ) {
		this.__month_pay = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public void cloneCopy(BasePlateSalaryAdjustmentSummary __bean){
		__bean.setPlateId(getPlateId());
		__bean.setOriginalPay(getOriginalPay());
		__bean.setChangePay(getChangePay());
		__bean.setMonthPay(getMonthPay());
		__bean.setPercent(getPercent());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getOriginalPay() == null ? "" : getOriginalPay());
		sb.append(",");
		sb.append(getChangePay() == null ? "" : getChangePay());
		sb.append(",");
		sb.append(getMonthPay() == null ? "" : getMonthPay());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateSalaryAdjustmentSummary o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__original_pay);
		hash = 97 * hash + Objects.hashCode(this.__change_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_pay);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateSalaryAdjustmentSummary o = (BasePlateSalaryAdjustmentSummary)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__original_pay, o.getOriginalPay())) return false;
		if(!Objects.equals(this.__change_pay, o.getChangePay())) return false;
		if(!Objects.equals(this.__month_pay, o.getMonthPay())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getOriginalPay() != null) sb.append(__wrapDecimal(count++, "originalPay", getOriginalPay()));
		if(getChangePay() != null) sb.append(__wrapDecimal(count++, "changePay", getChangePay()));
		if(getMonthPay() != null) sb.append(__wrapDecimal(count++, "monthPay", getMonthPay()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("originalPay")) != null) setOriginalPay(__getDecimal(val));  
		if((val = values.get("changePay")) != null) setChangePay(__getDecimal(val));  
		if((val = values.get("monthPay")) != null) setMonthPay(__getDecimal(val));  
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __original_pay ;
	protected java.math.BigDecimal  __change_pay ;
	protected java.math.BigDecimal  __month_pay ;
	protected java.math.BigDecimal  __percent ;
}
