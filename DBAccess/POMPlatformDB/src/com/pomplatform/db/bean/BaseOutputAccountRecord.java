package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOutputAccountRecord extends GenericBase implements BaseFactory<BaseOutputAccountRecord>, Comparable<BaseOutputAccountRecord> 
{


	public static BaseOutputAccountRecord newInstance(){
		return new BaseOutputAccountRecord();
	}

	@Override
	public BaseOutputAccountRecord make(){
		BaseOutputAccountRecord b = new BaseOutputAccountRecord();
		return b;
	}

	public final static java.lang.String CS_OUTPUT_ACCOUNT_RECORD_ID = "output_account_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEP_ACCOUNT_INTEGRAL = "dep_account_integral" ;
	public final static java.lang.String CS_EMP_ACCOUNT_INTEGRAL = "emp_account_integral" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_ACCOUNT_DATE = "account_date" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_IS_YEAR_FINAL_ACCOUNT = "is_year_final_account" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,部门结算总积分,成员结算总积分,开始日期,结束日期,结算日期,结算年份,结算月份,是否是年度最后一次结算,操作时间,操作人,备注";

	public java.lang.Integer getOutputAccountRecordId() {
		return this.__output_account_record_id;
	}

	public void setOutputAccountRecordId( java.lang.Integer value ) {
		this.__output_account_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getDepAccountIntegral() {
		return this.__dep_account_integral;
	}

	public void setDepAccountIntegral( java.math.BigDecimal value ) {
		this.__dep_account_integral = value;
	}

	public java.math.BigDecimal getEmpAccountIntegral() {
		return this.__emp_account_integral;
	}

	public void setEmpAccountIntegral( java.math.BigDecimal value ) {
		this.__emp_account_integral = value;
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

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseOutputAccountRecord __bean){
		__bean.setOutputAccountRecordId(getOutputAccountRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setDepAccountIntegral(getDepAccountIntegral());
		__bean.setEmpAccountIntegral(getEmpAccountIntegral());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setAccountDate(getAccountDate());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setIsYearFinalAccount(getIsYearFinalAccount());
		__bean.setOperateTime(getOperateTime());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getOutputAccountRecordId() == null ? "" : getOutputAccountRecordId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDepAccountIntegral() == null ? "" : getDepAccountIntegral());
		sb.append(",");
		sb.append(getEmpAccountIntegral() == null ? "" : getEmpAccountIntegral());
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
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOutputAccountRecord o) {
		return __output_account_record_id == null ? -1 : __output_account_record_id.compareTo(o.getOutputAccountRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__output_account_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__dep_account_integral);
		hash = 97 * hash + Objects.hashCode(this.__emp_account_integral);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__account_date);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__is_year_final_account);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOutputAccountRecord o = (BaseOutputAccountRecord)obj;
		if(!Objects.equals(this.__output_account_record_id, o.getOutputAccountRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__dep_account_integral, o.getDepAccountIntegral())) return false;
		if(!Objects.equals(this.__emp_account_integral, o.getEmpAccountIntegral())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__account_date, o.getAccountDate())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__is_year_final_account, o.getIsYearFinalAccount())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getOutputAccountRecordId() != null) sb.append(__wrapNumber(count++, "outputAccountRecordId", getOutputAccountRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepAccountIntegral() != null) sb.append(__wrapDecimal(count++, "depAccountIntegral", getDepAccountIntegral()));
		if(getEmpAccountIntegral() != null) sb.append(__wrapDecimal(count++, "empAccountIntegral", getEmpAccountIntegral()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getAccountDate() != null) sb.append(__wrapDate(count++, "accountDate", getAccountDate()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getIsYearFinalAccount() != null) sb.append(__wrapBoolean(count++, "isYearFinalAccount", getIsYearFinalAccount()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getOutputAccountRecordId() != null) res.put("outputAccountRecordId", getOutputAccountRecordId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getDepAccountIntegral() != null) res.put("depAccountIntegral", getDepAccountIntegral());
		if(getEmpAccountIntegral() != null) res.put("empAccountIntegral", getEmpAccountIntegral());
		if(getStartDate() != null) res.put("startDate", getStartDate());
		if(getEndDate() != null) res.put("endDate", getEndDate());
		if(getAccountDate() != null) res.put("accountDate", getAccountDate());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getIsYearFinalAccount() != null) res.put("isYearFinalAccount", getIsYearFinalAccount());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getRemark() != null) res.put("remark", getRemark());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("outputAccountRecordId")) != null) setOutputAccountRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("depAccountIntegral")) != null) setDepAccountIntegral(__getDecimal(val));  
		if((val = values.get("empAccountIntegral")) != null) setEmpAccountIntegral(__getDecimal(val));  
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("accountDate")) != null) setAccountDate(__getDate(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("isYearFinalAccount")) != null) setIsYearFinalAccount(__getBoolean(val));
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __output_account_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __dep_account_integral ;
	protected java.math.BigDecimal  __emp_account_integral ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.util.Date  __account_date ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Boolean  __is_year_final_account ;
	protected java.util.Date  __operate_time ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.lang.String  __remark ;
}
