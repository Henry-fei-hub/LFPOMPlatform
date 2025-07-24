package pomplatform.capitaldistribution.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSearchProjectCapitalDistribution extends GenericBase implements BaseFactory<BaseSearchProjectCapitalDistribution>, Comparable<BaseSearchProjectCapitalDistribution> 
{


	public static BaseSearchProjectCapitalDistribution newInstance(){
		return new BaseSearchProjectCapitalDistribution();
	}

	@Override
	public BaseSearchProjectCapitalDistribution make(){
		BaseSearchProjectCapitalDistribution b = new BaseSearchProjectCapitalDistribution();
		return b;
	}

	public final static java.lang.String CS_ID = "id" ;
	public final static java.lang.String CS_CAPITAL_ID = "capital_id" ;
	public final static java.lang.String CS_DISTRIBUTION_AMOUNT = "distribution_amount" ;
	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;

	public final static java.lang.String ALL_CAPTIONS = "部门或者订单编码,回款编码,回款分配金额,发生日期";

	public java.lang.Integer getId() {
		return this.__id;
	}

	public void setId( java.lang.Integer value ) {
		this.__id = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.math.BigDecimal getDistributionAmount() {
		return this.__distribution_amount;
	}

	public void setDistributionAmount( java.math.BigDecimal value ) {
		this.__distribution_amount = value;
	}

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public void cloneCopy(BaseSearchProjectCapitalDistribution __bean){
		__bean.setId(getId());
		__bean.setCapitalId(getCapitalId());
		__bean.setDistributionAmount(getDistributionAmount());
		__bean.setHappenDate(getHappenDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strId = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getId()));
		sb.append(strId == null ? "" : strId);
		sb.append(",");
		sb.append(getCapitalId() == null ? "" : getCapitalId());
		sb.append(",");
		sb.append(getDistributionAmount() == null ? "" : getDistributionAmount());
		sb.append(",");
		sb.append(getHappenDate() == null ? "" : sdf.format(getHappenDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSearchProjectCapitalDistribution o) {
		return __id == null ? -1 : __id.compareTo(o.getId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__id);
		hash = 97 * hash + Objects.hashCode(this.__capital_id);
		hash = 97 * hash + Objects.hashCode(this.__distribution_amount);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSearchProjectCapitalDistribution o = (BaseSearchProjectCapitalDistribution)obj;
		if(!Objects.equals(this.__id, o.getId())) return false;
		if(!Objects.equals(this.__capital_id, o.getCapitalId())) return false;
		if(!Objects.equals(this.__distribution_amount, o.getDistributionAmount())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getId() != null) sb.append(__wrapNumber(count++, "id", getId()));
		if(getCapitalId() != null) sb.append(__wrapNumber(count++, "capitalId", getCapitalId()));
		if(getDistributionAmount() != null) sb.append(__wrapDecimal(count++, "distributionAmount", getDistributionAmount()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("id")) != null) setId(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("distributionAmount")) != null) setDistributionAmount(__getDecimal(val));  
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
	}

	protected java.lang.Integer  __id ;
	protected java.lang.Integer  __capital_id ;
	protected java.math.BigDecimal  __distribution_amount ;
	protected java.util.Date  __happen_date ;
}
