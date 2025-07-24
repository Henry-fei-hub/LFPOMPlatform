package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSalaryFillSendDeduct extends GenericBase implements BaseFactory<BaseSalaryFillSendDeduct>, Comparable<BaseSalaryFillSendDeduct> 
{


	public static BaseSalaryFillSendDeduct newInstance(){
		return new BaseSalaryFillSendDeduct();
	}

	@Override
	public BaseSalaryFillSendDeduct make(){
		BaseSalaryFillSendDeduct b = new BaseSalaryFillSendDeduct();
		return b;
	}

	public final static java.lang.String CS_SALARY_FILL_SEND_DEDUCT_ID = "salary_fill_send_deduct_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_FILL_FIVE_INSURANCE_ONE_GOLDS = "fill_five_insurance_one_golds" ;
	public final static java.lang.String CS_MORE_DEDUCT_TAX = "more_deduct_tax" ;
	public final static java.lang.String CS_FILL_TAX = "fill_tax" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,年份,月份,,填平五险一金,,填平个税,合计,是否发放,操作人,操作时间,备注";

	public java.lang.Integer getSalaryFillSendDeductId() {
		return this.__salary_fill_send_deduct_id;
	}

	public void setSalaryFillSendDeductId( java.lang.Integer value ) {
		this.__salary_fill_send_deduct_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.String getFillFiveInsuranceOneGolds() {
		return this.__fill_five_insurance_one_golds;
	}

	public void setFillFiveInsuranceOneGolds( java.lang.String value ) {
		this.__fill_five_insurance_one_golds = value;
	}

	public java.lang.String getMoreDeductTax() {
		return this.__more_deduct_tax;
	}

	public void setMoreDeductTax( java.lang.String value ) {
		this.__more_deduct_tax = value;
	}

	public java.lang.String getFillTax() {
		return this.__fill_tax;
	}

	public void setFillTax( java.lang.String value ) {
		this.__fill_tax = value;
	}

	public java.lang.String getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.lang.String value ) {
		this.__total_amount = value;
	}

	public java.lang.Boolean getIsSended() {
		return this.__is_sended;
	}

	public void setIsSended( java.lang.Boolean value ) {
		this.__is_sended = value;
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

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseSalaryFillSendDeduct __bean){
		__bean.setSalaryFillSendDeductId(getSalaryFillSendDeductId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setRecordDate(getRecordDate());
		__bean.setFillFiveInsuranceOneGolds(getFillFiveInsuranceOneGolds());
		__bean.setMoreDeductTax(getMoreDeductTax());
		__bean.setFillTax(getFillTax());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setIsSended(getIsSended());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryFillSendDeductId() == null ? "" : getSalaryFillSendDeductId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getFillFiveInsuranceOneGolds() == null ? "" : getFillFiveInsuranceOneGolds());
		sb.append(",");
		sb.append(getMoreDeductTax() == null ? "" : getMoreDeductTax());
		sb.append(",");
		sb.append(getFillTax() == null ? "" : getFillTax());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		sb.append(",");
		String strOperateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperateEmployeeId()));
		sb.append(strOperateEmployeeId == null ? "" : strOperateEmployeeId);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryFillSendDeduct o) {
		return __salary_fill_send_deduct_id == null ? -1 : __salary_fill_send_deduct_id.compareTo(o.getSalaryFillSendDeductId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_fill_send_deduct_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__fill_five_insurance_one_golds);
		hash = 97 * hash + Objects.hashCode(this.__more_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__fill_tax);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryFillSendDeduct o = (BaseSalaryFillSendDeduct)obj;
		if(!Objects.equals(this.__salary_fill_send_deduct_id, o.getSalaryFillSendDeductId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__fill_five_insurance_one_golds, o.getFillFiveInsuranceOneGolds())) return false;
		if(!Objects.equals(this.__more_deduct_tax, o.getMoreDeductTax())) return false;
		if(!Objects.equals(this.__fill_tax, o.getFillTax())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryFillSendDeductId() != null) sb.append(__wrapNumber(count++, "salaryFillSendDeductId", getSalaryFillSendDeductId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getFillFiveInsuranceOneGolds() != null) sb.append(__wrapString(count++, "fillFiveInsuranceOneGolds", getFillFiveInsuranceOneGolds()));
		if(getMoreDeductTax() != null) sb.append(__wrapString(count++, "moreDeductTax", getMoreDeductTax()));
		if(getFillTax() != null) sb.append(__wrapString(count++, "fillTax", getFillTax()));
		if(getTotalAmount() != null) sb.append(__wrapString(count++, "totalAmount", getTotalAmount()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryFillSendDeductId")) != null) setSalaryFillSendDeductId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("fillFiveInsuranceOneGolds")) != null) setFillFiveInsuranceOneGolds(__getString(val));
		if((val = values.get("moreDeductTax")) != null) setMoreDeductTax(__getString(val));
		if((val = values.get("fillTax")) != null) setFillTax(__getString(val));
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getString(val));
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __salary_fill_send_deduct_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __fill_five_insurance_one_golds ;
	protected java.lang.String  __more_deduct_tax ;
	protected java.lang.String  __fill_tax ;
	protected java.lang.String  __total_amount ;
	protected java.lang.Boolean  __is_sended ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
