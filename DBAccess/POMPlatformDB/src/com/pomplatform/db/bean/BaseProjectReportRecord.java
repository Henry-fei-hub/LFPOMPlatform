package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectReportRecord extends GenericBase implements BaseFactory<BaseProjectReportRecord>, Comparable<BaseProjectReportRecord> 
{


	public static BaseProjectReportRecord newInstance(){
		return new BaseProjectReportRecord();
	}

	@Override
	public BaseProjectReportRecord make(){
		BaseProjectReportRecord b = new BaseProjectReportRecord();
		return b;
	}

	public final static java.lang.String CS_PROJECT_REPORT_RECORD_ID = "project_report_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_SUBTRACT_COMPLAINT_INTEGRAL = "subtract_complaint_integral" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_PROJECT_COST = "project_cost" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_IS_LOCK = "is_lock" ;

	public final static java.lang.String ALL_CAPTIONS = "编码,业务部门,项目,扣除的投诉保证金,确认积分,项目成本,记录产生时间,是否锁定";

	public java.lang.Integer getProjectReportRecordId() {
		return this.__project_report_record_id;
	}

	public void setProjectReportRecordId( java.lang.Integer value ) {
		this.__project_report_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getSubtractComplaintIntegral() {
		return this.__subtract_complaint_integral;
	}

	public void setSubtractComplaintIntegral( java.math.BigDecimal value ) {
		this.__subtract_complaint_integral = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getProjectCost() {
		return this.__project_cost;
	}

	public void setProjectCost( java.math.BigDecimal value ) {
		this.__project_cost = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Boolean getIsLock() {
		return this.__is_lock;
	}

	public void setIsLock( java.lang.Boolean value ) {
		this.__is_lock = value;
	}

	public void cloneCopy(BaseProjectReportRecord __bean){
		__bean.setProjectReportRecordId(getProjectReportRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setProjectId(getProjectId());
		__bean.setSubtractComplaintIntegral(getSubtractComplaintIntegral());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setProjectCost(getProjectCost());
		__bean.setRecordDate(getRecordDate());
		__bean.setIsLock(getIsLock());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectReportRecordId() == null ? "" : getProjectReportRecordId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getSubtractComplaintIntegral() == null ? "" : getSubtractComplaintIntegral());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getProjectCost() == null ? "" : getProjectCost());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getIsLock() == null ? "" : getIsLock());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectReportRecord o) {
		return __project_report_record_id == null ? -1 : __project_report_record_id.compareTo(o.getProjectReportRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_report_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__subtract_complaint_integral);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_cost);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__is_lock);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectReportRecord o = (BaseProjectReportRecord)obj;
		if(!Objects.equals(this.__project_report_record_id, o.getProjectReportRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__subtract_complaint_integral, o.getSubtractComplaintIntegral())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__project_cost, o.getProjectCost())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__is_lock, o.getIsLock())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectReportRecordId() != null) sb.append(__wrapNumber(count++, "projectReportRecordId", getProjectReportRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getSubtractComplaintIntegral() != null) sb.append(__wrapDecimal(count++, "subtractComplaintIntegral", getSubtractComplaintIntegral()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getProjectCost() != null) sb.append(__wrapDecimal(count++, "projectCost", getProjectCost()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getIsLock() != null) sb.append(__wrapBoolean(count++, "isLock", getIsLock()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectReportRecordId")) != null) setProjectReportRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("subtractComplaintIntegral")) != null) setSubtractComplaintIntegral(__getDecimal(val));  
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("projectCost")) != null) setProjectCost(__getDecimal(val));  
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("isLock")) != null) setIsLock(__getBoolean(val));
	}

	protected java.lang.Integer  __project_report_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __subtract_complaint_integral ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __project_cost ;
	protected java.util.Date  __record_date ;
	protected java.lang.Boolean  __is_lock ;
}
