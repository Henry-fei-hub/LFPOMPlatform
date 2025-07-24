package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectManagePerformanceRecord extends GenericBase implements BaseFactory<BaseProjectManagePerformanceRecord>, Comparable<BaseProjectManagePerformanceRecord> 
{


	public static BaseProjectManagePerformanceRecord newInstance(){
		return new BaseProjectManagePerformanceRecord();
	}

	@Override
	public BaseProjectManagePerformanceRecord make(){
		BaseProjectManagePerformanceRecord b = new BaseProjectManagePerformanceRecord();
		return b;
	}

	public final static java.lang.String CS_PROJECT_MANAGE_PERFORMANCE_RECORD_ID = "project_manage_performance_record_id" ;
	public final static java.lang.String CS_PROJECT_MANAGE_PERFORMANCE_TOTAL_ID = "project_manage_performance_total_id" ;
	public final static java.lang.String CS_OBJECT_ID = "object_id" ;
	public final static java.lang.String CS_OBJECT_NO = "object_no" ;
	public final static java.lang.String CS_OBJECT_NAME = "object_name" ;
	public final static java.lang.String CS_OBJECT_TYPE = "object_type" ;
	public final static java.lang.String CS_PERFORMANCE_MONEY = "performance_money" ;
	public final static java.lang.String CS_PERFORMANCE_STATUS = "performance_status" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_BUSINESS_NAME = "business_name" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_RECORD_TIME = "record_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,总表Id,对象编码,编号,名称,对象类型（1人员；2部门）,绩效金额,2支出),业务模块（1报价单；2拆分价；3订单下单；4确认积分）,业务名称,记录日期,记录时间,备注";

	public java.lang.Integer getProjectManagePerformanceRecordId() {
		return this.__project_manage_performance_record_id;
	}

	public void setProjectManagePerformanceRecordId( java.lang.Integer value ) {
		this.__project_manage_performance_record_id = value;
	}

	public java.lang.Integer getProjectManagePerformanceTotalId() {
		return this.__project_manage_performance_total_id;
	}

	public void setProjectManagePerformanceTotalId( java.lang.Integer value ) {
		this.__project_manage_performance_total_id = value;
	}

	public java.lang.Integer getObjectId() {
		return this.__object_id;
	}

	public void setObjectId( java.lang.Integer value ) {
		this.__object_id = value;
	}

	public java.lang.String getObjectNo() {
		return this.__object_no;
	}

	public void setObjectNo( java.lang.String value ) {
		this.__object_no = value;
	}

	public java.lang.String getObjectName() {
		return this.__object_name;
	}

	public void setObjectName( java.lang.String value ) {
		this.__object_name = value;
	}

	public java.lang.Integer getObjectType() {
		return this.__object_type;
	}

	public void setObjectType( java.lang.Integer value ) {
		this.__object_type = value;
	}

	public java.math.BigDecimal getPerformanceMoney() {
		return this.__performance_money;
	}

	public void setPerformanceMoney( java.math.BigDecimal value ) {
		this.__performance_money = value;
	}

	public java.lang.Integer getPerformanceStatus() {
		return this.__performance_status;
	}

	public void setPerformanceStatus( java.lang.Integer value ) {
		this.__performance_status = value;
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

	public void cloneCopy(BaseProjectManagePerformanceRecord __bean){
		__bean.setProjectManagePerformanceRecordId(getProjectManagePerformanceRecordId());
		__bean.setProjectManagePerformanceTotalId(getProjectManagePerformanceTotalId());
		__bean.setObjectId(getObjectId());
		__bean.setObjectNo(getObjectNo());
		__bean.setObjectName(getObjectName());
		__bean.setObjectType(getObjectType());
		__bean.setPerformanceMoney(getPerformanceMoney());
		__bean.setPerformanceStatus(getPerformanceStatus());
		__bean.setBusinessType(getBusinessType());
		__bean.setBusinessName(getBusinessName());
		__bean.setRecordDate(getRecordDate());
		__bean.setRecordTime(getRecordTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectManagePerformanceRecordId() == null ? "" : getProjectManagePerformanceRecordId());
		sb.append(",");
		sb.append(getProjectManagePerformanceTotalId() == null ? "" : getProjectManagePerformanceTotalId());
		sb.append(",");
		sb.append(getObjectId() == null ? "" : getObjectId());
		sb.append(",");
		sb.append(getObjectNo() == null ? "" : getObjectNo());
		sb.append(",");
		sb.append(getObjectName() == null ? "" : getObjectName());
		sb.append(",");
		sb.append(getObjectType() == null ? "" : getObjectType());
		sb.append(",");
		sb.append(getPerformanceMoney() == null ? "" : getPerformanceMoney());
		sb.append(",");
		sb.append(getPerformanceStatus() == null ? "" : getPerformanceStatus());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		sb.append(getBusinessName() == null ? "" : getBusinessName());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getRecordTime() == null ? "" : sdf.format(getRecordTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectManagePerformanceRecord o) {
		return __project_manage_performance_record_id == null ? -1 : __project_manage_performance_record_id.compareTo(o.getProjectManagePerformanceRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_manage_performance_record_id);
		hash = 97 * hash + Objects.hashCode(this.__project_manage_performance_total_id);
		hash = 97 * hash + Objects.hashCode(this.__object_id);
		hash = 97 * hash + Objects.hashCode(this.__object_no);
		hash = 97 * hash + Objects.hashCode(this.__object_name);
		hash = 97 * hash + Objects.hashCode(this.__object_type);
		hash = 97 * hash + Objects.hashCode(this.__performance_money);
		hash = 97 * hash + Objects.hashCode(this.__performance_status);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__business_name);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__record_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectManagePerformanceRecord o = (BaseProjectManagePerformanceRecord)obj;
		if(!Objects.equals(this.__project_manage_performance_record_id, o.getProjectManagePerformanceRecordId())) return false;
		if(!Objects.equals(this.__project_manage_performance_total_id, o.getProjectManagePerformanceTotalId())) return false;
		if(!Objects.equals(this.__object_id, o.getObjectId())) return false;
		if(!Objects.equals(this.__object_no, o.getObjectNo())) return false;
		if(!Objects.equals(this.__object_name, o.getObjectName())) return false;
		if(!Objects.equals(this.__object_type, o.getObjectType())) return false;
		if(!Objects.equals(this.__performance_money, o.getPerformanceMoney())) return false;
		if(!Objects.equals(this.__performance_status, o.getPerformanceStatus())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__business_name, o.getBusinessName())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__record_time, o.getRecordTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectManagePerformanceRecordId() != null) sb.append(__wrapNumber(count++, "projectManagePerformanceRecordId", getProjectManagePerformanceRecordId()));
		if(getProjectManagePerformanceTotalId() != null) sb.append(__wrapNumber(count++, "projectManagePerformanceTotalId", getProjectManagePerformanceTotalId()));
		if(getObjectId() != null) sb.append(__wrapNumber(count++, "objectId", getObjectId()));
		if(getObjectNo() != null) sb.append(__wrapString(count++, "objectNo", getObjectNo()));
		if(getObjectName() != null) sb.append(__wrapString(count++, "objectName", getObjectName()));
		if(getObjectType() != null) sb.append(__wrapNumber(count++, "objectType", getObjectType()));
		if(getPerformanceMoney() != null) sb.append(__wrapDecimal(count++, "performanceMoney", getPerformanceMoney()));
		if(getPerformanceStatus() != null) sb.append(__wrapNumber(count++, "performanceStatus", getPerformanceStatus()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getBusinessName() != null) sb.append(__wrapString(count++, "businessName", getBusinessName()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getRecordTime() != null) sb.append(__wrapDate(count++, "recordTime", getRecordTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectManagePerformanceRecordId")) != null) setProjectManagePerformanceRecordId(__getInt(val)); 
		if((val = values.get("projectManagePerformanceTotalId")) != null) setProjectManagePerformanceTotalId(__getInt(val)); 
		if((val = values.get("objectId")) != null) setObjectId(__getInt(val)); 
		if((val = values.get("objectNo")) != null) setObjectNo(__getString(val));
		if((val = values.get("objectName")) != null) setObjectName(__getString(val));
		if((val = values.get("objectType")) != null) setObjectType(__getInt(val)); 
		if((val = values.get("performanceMoney")) != null) setPerformanceMoney(__getDecimal(val));  
		if((val = values.get("performanceStatus")) != null) setPerformanceStatus(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("businessName")) != null) setBusinessName(__getString(val));
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("recordTime")) != null) setRecordTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_manage_performance_record_id ;
	protected java.lang.Integer  __project_manage_performance_total_id ;
	protected java.lang.Integer  __object_id ;
	protected java.lang.String  __object_no ;
	protected java.lang.String  __object_name ;
	protected java.lang.Integer  __object_type ;
	protected java.math.BigDecimal  __performance_money ;
	protected java.lang.Integer  __performance_status ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.String  __business_name ;
	protected java.util.Date  __record_date ;
	protected java.util.Date  __record_time ;
	protected java.lang.String  __remark ;
}
