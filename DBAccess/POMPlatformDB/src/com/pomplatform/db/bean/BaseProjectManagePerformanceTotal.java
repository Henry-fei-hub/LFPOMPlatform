package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectManagePerformanceTotal extends GenericBase implements BaseFactory<BaseProjectManagePerformanceTotal>, Comparable<BaseProjectManagePerformanceTotal> 
{


	public static BaseProjectManagePerformanceTotal newInstance(){
		return new BaseProjectManagePerformanceTotal();
	}

	@Override
	public BaseProjectManagePerformanceTotal make(){
		BaseProjectManagePerformanceTotal b = new BaseProjectManagePerformanceTotal();
		return b;
	}

	public final static java.lang.String CS_PROJECT_MANAGE_PERFORMANCE_TOTAL_ID = "project_manage_performance_total_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_PERFORMANCE_MONEY = "performance_money" ;
	public final static java.lang.String CS_MAIN_PROJECT_ID = "main_project_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_RECORD_TIME = "record_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务模块（1报价单；2拆分价；3订单下单；4确认积分）,业务名称,绩效总金额,项目编码,人员编码,记录日期,记录时间,备注";

	public java.lang.Integer getProjectManagePerformanceTotalId() {
		return this.__project_manage_performance_total_id;
	}

	public void setProjectManagePerformanceTotalId( java.lang.Integer value ) {
		this.__project_manage_performance_total_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	public java.lang.String getBusinessName() {
		return this.__business_name;
	}

	public void setBusinessName( java.lang.String value ) {
		this.__business_name = value;
	}

	public java.math.BigDecimal getPerformanceMoney() {
		return this.__performance_money;
	}

	public void setPerformanceMoney( java.math.BigDecimal value ) {
		this.__performance_money = value;
	}

	public java.lang.Integer getMainProjectId() {
		return this.__main_project_id;
	}

	public void setMainProjectId( java.lang.Integer value ) {
		this.__main_project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.util.Date getRecordTime() {
		return this.__record_time;
	}

	public void setRecordTime( java.util.Date value ) {
		this.__record_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseProjectManagePerformanceTotal __bean){
		__bean.setProjectManagePerformanceTotalId(getProjectManagePerformanceTotalId());
		__bean.setBusinessType(getBusinessType());
		__bean.setBusinessName(getBusinessName());
		__bean.setPerformanceMoney(getPerformanceMoney());
		__bean.setMainProjectId(getMainProjectId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setRecordDate(getRecordDate());
		__bean.setRecordTime(getRecordTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectManagePerformanceTotalId() == null ? "" : getProjectManagePerformanceTotalId());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getPerformanceMoney() == null ? "" : getPerformanceMoney());
		sb.append(",");
		sb.append(getMainProjectId() == null ? "" : getMainProjectId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getRecordTime() == null ? "" : sdf.format(getRecordTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectManagePerformanceTotal o) {
		return __project_manage_performance_total_id == null ? -1 : __project_manage_performance_total_id.compareTo(o.getProjectManagePerformanceTotalId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_manage_performance_total_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__performance_money);
		hash = 97 * hash + Objects.hashCode(this.__main_project_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__record_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectManagePerformanceTotal o = (BaseProjectManagePerformanceTotal)obj;
		if(!Objects.equals(this.__project_manage_performance_total_id, o.getProjectManagePerformanceTotalId())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__performance_money, o.getPerformanceMoney())) return false;
		if(!Objects.equals(this.__main_project_id, o.getMainProjectId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__record_time, o.getRecordTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectManagePerformanceTotalId() != null) sb.append(__wrapNumber(count++, "projectManagePerformanceTotalId", getProjectManagePerformanceTotalId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getPerformanceMoney() != null) sb.append(__wrapDecimal(count++, "performanceMoney", getPerformanceMoney()));
		if(getMainProjectId() != null) sb.append(__wrapNumber(count++, "mainProjectId", getMainProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getRecordTime() != null) sb.append(__wrapDate(count++, "recordTime", getRecordTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectManagePerformanceTotalId")) != null) setProjectManagePerformanceTotalId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("performanceMoney")) != null) setPerformanceMoney(__getDecimal(val));  
		if((val = values.get("mainProjectId")) != null) setMainProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("recordTime")) != null) setRecordTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_manage_performance_total_id ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.String  __business_name ;
	protected java.math.BigDecimal  __performance_money ;
	protected java.lang.Integer  __main_project_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __record_date ;
	protected java.util.Date  __record_time ;
	protected java.lang.String  __remark ;
}
