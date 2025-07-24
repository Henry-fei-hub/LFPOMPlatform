package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOutputAccountDetail extends GenericBase implements BaseFactory<BaseOutputAccountDetail>, Comparable<BaseOutputAccountDetail> 
{


	public static BaseOutputAccountDetail newInstance(){
		return new BaseOutputAccountDetail();
	}

	@Override
	public BaseOutputAccountDetail make(){
		BaseOutputAccountDetail b = new BaseOutputAccountDetail();
		return b;
	}

	public final static java.lang.String CS_OUTPUT_ACCOUNT_DETAIL_ID = "output_account_detail_id" ;
	public final static java.lang.String CS_OUTPUT_ACCOUNT_RECORD_ID = "output_account_record_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ACCOUNT_INTEGRAL = "account_integral" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_ACCOUNT_DATE = "account_date" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_IS_YEAR_FINAL_ACCOUNT = "is_year_final_account" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,总表id,结算成员,结算积分,开始日期,结束日期,结算日期,结算年份,结算月份,是否是年度最后一次结算";

	public java.lang.Integer getOutputAccountDetailId() {
		return this.__output_account_detail_id;
	}

	public void setOutputAccountDetailId( java.lang.Integer value ) {
		this.__output_account_detail_id = value;
	}

	public java.lang.Integer getOutputAccountRecordId() {
		return this.__output_account_record_id;
	}

	public void setOutputAccountRecordId( java.lang.Integer value ) {
		this.__output_account_record_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getAccountIntegral() {
		return this.__account_integral;
	}

	public void setAccountIntegral( java.math.BigDecimal value ) {
		this.__account_integral = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.util.Date getAccountDate() {
		return this.__account_date;
	}

	public void setAccountDate( java.util.Date value ) {
		this.__account_date = value;
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

	public java.lang.Boolean getIsYearFinalAccount() {
		return this.__is_year_final_account;
	}

	public void setIsYearFinalAccount( java.lang.Boolean value ) {
		this.__is_year_final_account = value;
	}

	public void cloneCopy(BaseOutputAccountDetail __bean){
		__bean.setOutputAccountDetailId(getOutputAccountDetailId());
		__bean.setOutputAccountRecordId(getOutputAccountRecordId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAccountIntegral(getAccountIntegral());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setAccountDate(getAccountDate());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setIsYearFinalAccount(getIsYearFinalAccount());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOutputAccountDetailId() == null ? "" : getOutputAccountDetailId());
		sb.append(",");
		sb.append(getOutputAccountRecordId() == null ? "" : getOutputAccountRecordId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getAccountIntegral() == null ? "" : getAccountIntegral());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getAccountDate() == null ? "" : sdf.format(getAccountDate()));
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getIsYearFinalAccount() == null ? "" : getIsYearFinalAccount());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOutputAccountDetail o) {
		return __output_account_detail_id == null ? -1 : __output_account_detail_id.compareTo(o.getOutputAccountDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__output_account_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__output_account_record_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__account_integral);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__account_date);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__is_year_final_account);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOutputAccountDetail o = (BaseOutputAccountDetail)obj;
		if(!Objects.equals(this.__output_account_detail_id, o.getOutputAccountDetailId())) return false;
		if(!Objects.equals(this.__output_account_record_id, o.getOutputAccountRecordId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__account_integral, o.getAccountIntegral())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__account_date, o.getAccountDate())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__is_year_final_account, o.getIsYearFinalAccount())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOutputAccountDetailId() != null) sb.append(__wrapNumber(count++, "outputAccountDetailId", getOutputAccountDetailId()));
		if(getOutputAccountRecordId() != null) sb.append(__wrapNumber(count++, "outputAccountRecordId", getOutputAccountRecordId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getAccountIntegral() != null) sb.append(__wrapDecimal(count++, "accountIntegral", getAccountIntegral()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getAccountDate() != null) sb.append(__wrapDate(count++, "accountDate", getAccountDate()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getIsYearFinalAccount() != null) sb.append(__wrapBoolean(count++, "isYearFinalAccount", getIsYearFinalAccount()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getOutputAccountDetailId() != null) res.put("outputAccountDetailId", getOutputAccountDetailId());
		if(getOutputAccountRecordId() != null) res.put("outputAccountRecordId", getOutputAccountRecordId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getAccountIntegral() != null) res.put("accountIntegral", getAccountIntegral());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getAccountDate() != null) res.put("accountDate", getAccountDate());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getIsYearFinalAccount() != null) res.put("isYearFinalAccount", getIsYearFinalAccount());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("outputAccountDetailId")) != null) setOutputAccountDetailId(__getInt(val)); 
		if((val = values.get("outputAccountRecordId")) != null) setOutputAccountRecordId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("accountIntegral")) != null) setAccountIntegral(__getDecimal(val));  
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("accountDate")) != null) setAccountDate(__getDate(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("isYearFinalAccount")) != null) setIsYearFinalAccount(__getBoolean(val));
	}

	protected java.lang.Integer  __output_account_detail_id ;
	protected java.lang.Integer  __output_account_record_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __account_integral ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.util.Date  __account_date ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Boolean  __is_year_final_account ;
}
