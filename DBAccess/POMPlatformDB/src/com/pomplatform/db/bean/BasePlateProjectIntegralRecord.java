package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateProjectIntegralRecord extends GenericBase implements BaseFactory<BasePlateProjectIntegralRecord>, Comparable<BasePlateProjectIntegralRecord> 
{


	public static BasePlateProjectIntegralRecord newInstance(){
		return new BasePlateProjectIntegralRecord();
	}

	@Override
	public BasePlateProjectIntegralRecord make(){
		BasePlateProjectIntegralRecord b = new BasePlateProjectIntegralRecord();
		return b;
	}

	public final static java.lang.String CS_PLATE_PROJECT_INTEGRAL_RECORD_ID = "plate_project_integral_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_SEND_INTEGRAL = "send_integral" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_SEND_DATE = "send_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,补贴积分,项目,日期,备注";

	public java.lang.Integer getPlateProjectIntegralRecordId() {
		return this.__plate_project_integral_record_id;
	}

	public void setPlateProjectIntegralRecordId( java.lang.Integer value ) {
		this.__plate_project_integral_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getSendIntegral() {
		return this.__send_integral;
	}

	public void setSendIntegral( java.math.BigDecimal value ) {
		this.__send_integral = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.util.Date getSendDate() {
		return this.__send_date;
	}

	public void setSendDate( java.util.Date value ) {
		this.__send_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BasePlateProjectIntegralRecord __bean){
		__bean.setPlateProjectIntegralRecordId(getPlateProjectIntegralRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setSendIntegral(getSendIntegral());
		__bean.setProjectId(getProjectId());
		__bean.setSendDate(getSendDate());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateProjectIntegralRecordId() == null ? "" : getPlateProjectIntegralRecordId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getSendIntegral() == null ? "" : getSendIntegral());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getSendDate() == null ? "" : sdf.format(getSendDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateProjectIntegralRecord o) {
		return __plate_project_integral_record_id == null ? -1 : __plate_project_integral_record_id.compareTo(o.getPlateProjectIntegralRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_project_integral_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__send_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__send_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateProjectIntegralRecord o = (BasePlateProjectIntegralRecord)obj;
		if(!Objects.equals(this.__plate_project_integral_record_id, o.getPlateProjectIntegralRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__send_integral, o.getSendIntegral())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__send_date, o.getSendDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateProjectIntegralRecordId() != null) sb.append(__wrapNumber(count++, "plateProjectIntegralRecordId", getPlateProjectIntegralRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getSendIntegral() != null) sb.append(__wrapDecimal(count++, "sendIntegral", getSendIntegral()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getSendDate() != null) sb.append(__wrapDate(count++, "sendDate", getSendDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateProjectIntegralRecordId")) != null) setPlateProjectIntegralRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("sendIntegral")) != null) setSendIntegral(__getDecimal(val));  
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("sendDate")) != null) setSendDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __plate_project_integral_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __send_integral ;
	protected java.lang.Integer  __project_id ;
	protected java.util.Date  __send_date ;
	protected java.lang.String  __remark ;
}
