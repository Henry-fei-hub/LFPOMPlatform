package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadMonthDataOfAccount extends GenericBase implements BaseFactory<BaseOnLoadMonthDataOfAccount>, Comparable<BaseOnLoadMonthDataOfAccount> 
{


	public static BaseOnLoadMonthDataOfAccount newInstance(){
		return new BaseOnLoadMonthDataOfAccount();
	}

	@Override
	public BaseOnLoadMonthDataOfAccount make(){
		BaseOnLoadMonthDataOfAccount b = new BaseOnLoadMonthDataOfAccount();
		return b;
	}

	public final static java.lang.String CS_ACCOUNT_TYPE_ID = "account_type_id" ;
	public final static java.lang.String CS_ACCOUNT_ID = "account_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE_ID = "business_type_id" ;
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral" ;
	public final static java.lang.String CS_PAY_INTEGRAL = "pay_integral" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;

	public final static java.lang.String ALL_CAPTIONS = "账户类型,账户编码(即对象编码),业务功能类型,收入积分,支出积分,年份,月份";

	public java.lang.Integer getAccountTypeId() {
		return this.__account_type_id;
	}

	public void setAccountTypeId( java.lang.Integer value ) {
		this.__account_type_id = value;
	}

	public java.lang.Integer getAccountId() {
		return this.__account_id;
	}

	public void setAccountId( java.lang.Integer value ) {
		this.__account_id = value;
	}

	public java.lang.Integer getBusinessTypeId() {
		return this.__business_type_id;
	}

	public void setBusinessTypeId( java.lang.Integer value ) {
		this.__business_type_id = value;
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral( java.math.BigDecimal value ) {
		this.__achieve_integral = value;
	}

	public java.math.BigDecimal getPayIntegral() {
		return this.__pay_integral;
	}

	public void setPayIntegral( java.math.BigDecimal value ) {
		this.__pay_integral = value;
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

	public void cloneCopy(BaseOnLoadMonthDataOfAccount __bean){
		__bean.setAccountTypeId(getAccountTypeId());
		__bean.setAccountId(getAccountId());
		__bean.setBusinessTypeId(getBusinessTypeId());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setPayIntegral(getPayIntegral());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAccountTypeId() == null ? "" : getAccountTypeId());
		sb.append(",");
		sb.append(getAccountId() == null ? "" : getAccountId());
		sb.append(",");
		sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getPayIntegral() == null ? "" : getPayIntegral());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadMonthDataOfAccount o) {
		return __account_type_id == null ? -1 : __account_type_id.compareTo(o.getAccountTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__account_type_id);
		hash = 97 * hash + Objects.hashCode(this.__account_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type_id);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__pay_integral);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadMonthDataOfAccount o = (BaseOnLoadMonthDataOfAccount)obj;
		if(!Objects.equals(this.__account_type_id, o.getAccountTypeId())) return false;
		if(!Objects.equals(this.__account_id, o.getAccountId())) return false;
		if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
		if(!Objects.equals(this.__achieve_integral, o.getAchieveIntegral())) return false;
		if(!Objects.equals(this.__pay_integral, o.getPayIntegral())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAccountTypeId() != null) sb.append(__wrapNumber(count++, "accountTypeId", getAccountTypeId()));
		if(getAccountId() != null) sb.append(__wrapNumber(count++, "accountId", getAccountId()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
		if(getAchieveIntegral() != null) sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if(getPayIntegral() != null) sb.append(__wrapDecimal(count++, "payIntegral", getPayIntegral()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("accountTypeId")) != null) setAccountTypeId(__getInt(val)); 
		if((val = values.get("accountId")) != null) setAccountId(__getInt(val)); 
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val)); 
		if((val = values.get("achieveIntegral")) != null) setAchieveIntegral(__getDecimal(val));  
		if((val = values.get("payIntegral")) != null) setPayIntegral(__getDecimal(val));  
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
	}

	protected java.lang.Integer  __account_type_id ;
	protected java.lang.Integer  __account_id ;
	protected java.lang.Integer  __business_type_id ;
	protected java.math.BigDecimal  __achieve_integral ;
	protected java.math.BigDecimal  __pay_integral ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
}
