package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseRevenueCapitals extends GenericBase implements BaseFactory<BaseRevenueCapitals>, Comparable<BaseRevenueCapitals> 
{


	public static BaseRevenueCapitals newInstance(){
		return new BaseRevenueCapitals();
	}

	@Override
	public BaseRevenueCapitals make(){
		BaseRevenueCapitals b = new BaseRevenueCapitals();
		return b;
	}

	public final static java.lang.String CS_REVENUE_CAPITALS_ID = "revenue_capitals_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_CAPITAL_AMOUNT = "capital_amount" ;
	public final static java.lang.String CS_REVENUE_AMOUNT = "revenue_amount" ;
	public final static java.lang.String CS_IS_TRUE = "is_true" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;

	public final static java.lang.String ALL_CAPTIONS = "营收回款表编码,年,月,,回款金额,营收金额,是否定稿,操作人,操作时间";

	public java.lang.Integer getRevenueCapitalsId() {
		return this.__revenue_capitals_id;
	}

	public void setRevenueCapitalsId( java.lang.Integer value ) {
		this.__revenue_capitals_id = value;
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

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.math.BigDecimal getCapitalAmount() {
		return this.__capital_amount;
	}

	public void setCapitalAmount( java.math.BigDecimal value ) {
		this.__capital_amount = value;
	}

	public java.math.BigDecimal getRevenueAmount() {
		return this.__revenue_amount;
	}

	public void setRevenueAmount( java.math.BigDecimal value ) {
		this.__revenue_amount = value;
	}

	public java.lang.Boolean getIsTrue() {
		return this.__is_true;
	}

	public void setIsTrue( java.lang.Boolean value ) {
		this.__is_true = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public void cloneCopy(BaseRevenueCapitals __bean){
		__bean.setRevenueCapitalsId(getRevenueCapitalsId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setContractId(getContractId());
		__bean.setCapitalAmount(getCapitalAmount());
		__bean.setRevenueAmount(getRevenueAmount());
		__bean.setIsTrue(getIsTrue());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getRevenueCapitalsId() == null ? "" : getRevenueCapitalsId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		sb.append(getCapitalAmount() == null ? "" : getCapitalAmount());
		sb.append(",");
		sb.append(getRevenueAmount() == null ? "" : getRevenueAmount());
		sb.append(",");
		sb.append(getIsTrue() == null ? "" : getIsTrue());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRevenueCapitals o) {
		return __revenue_capitals_id == null ? -1 : __revenue_capitals_id.compareTo(o.getRevenueCapitalsId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__revenue_capitals_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__capital_amount);
		hash = 97 * hash + Objects.hashCode(this.__revenue_amount);
		hash = 97 * hash + Objects.hashCode(this.__is_true);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRevenueCapitals o = (BaseRevenueCapitals)obj;
		if(!Objects.equals(this.__revenue_capitals_id, o.getRevenueCapitalsId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__capital_amount, o.getCapitalAmount())) return false;
		if(!Objects.equals(this.__revenue_amount, o.getRevenueAmount())) return false;
		if(!Objects.equals(this.__is_true, o.getIsTrue())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getRevenueCapitalsId() != null) sb.append(__wrapNumber(count++, "revenueCapitalsId", getRevenueCapitalsId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getCapitalAmount() != null) sb.append(__wrapDecimal(count++, "capitalAmount", getCapitalAmount()));
		if(getRevenueAmount() != null) sb.append(__wrapDecimal(count++, "revenueAmount", getRevenueAmount()));
		if(getIsTrue() != null) sb.append(__wrapBoolean(count++, "isTrue", getIsTrue()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("revenueCapitalsId")) != null) setRevenueCapitalsId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("capitalAmount")) != null) setCapitalAmount(__getDecimal(val));  
		if((val = values.get("revenueAmount")) != null) setRevenueAmount(__getDecimal(val));  
		if((val = values.get("isTrue")) != null) setIsTrue(__getBoolean(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __revenue_capitals_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __contract_id ;
	protected java.math.BigDecimal  __capital_amount ;
	protected java.math.BigDecimal  __revenue_amount ;
	protected java.lang.Boolean  __is_true ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
}
