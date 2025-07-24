package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateRateRecord extends GenericBase implements BaseFactory<BasePlateRateRecord>, Comparable<BasePlateRateRecord> 
{


	public static BasePlateRateRecord newInstance(){
		return new BasePlateRateRecord();
	}

	@Override
	public BasePlateRateRecord make(){
		BasePlateRateRecord b = new BasePlateRateRecord();
		return b;
	}

	public final static java.lang.String CS_PLATE_RATE_RECORD_ID = "plate_rate_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_MODIFY_RATE_PERCENT = "modify_rate_percent" ;
	public final static java.lang.String CS_RATE_PERCENT = "rate_percent" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,可修改税率百分比,税率百分比,操作人,操作时间,备注";

	public java.lang.Integer getPlateRateRecordId() {
		return this.__plate_rate_record_id;
	}

	public void setPlateRateRecordId( java.lang.Integer value ) {
		this.__plate_rate_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getModifyRatePercent() {
		return this.__modify_rate_percent;
	}

	public void setModifyRatePercent( java.math.BigDecimal value ) {
		this.__modify_rate_percent = value;
	}

	public java.math.BigDecimal getRatePercent() {
		return this.__rate_percent;
	}

	public void setRatePercent( java.math.BigDecimal value ) {
		this.__rate_percent = value;
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

	public void cloneCopy(BasePlateRateRecord __bean){
		__bean.setPlateRateRecordId(getPlateRateRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setModifyRatePercent(getModifyRatePercent());
		__bean.setRatePercent(getRatePercent());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateRateRecordId() == null ? "" : getPlateRateRecordId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getModifyRatePercent() == null ? "" : getModifyRatePercent());
		sb.append(",");
		sb.append(getRatePercent() == null ? "" : getRatePercent());
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
	public int compareTo(BasePlateRateRecord o) {
		return __plate_rate_record_id == null ? -1 : __plate_rate_record_id.compareTo(o.getPlateRateRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_rate_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__modify_rate_percent);
		hash = 97 * hash + Objects.hashCode(this.__rate_percent);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateRateRecord o = (BasePlateRateRecord)obj;
		if(!Objects.equals(this.__plate_rate_record_id, o.getPlateRateRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__modify_rate_percent, o.getModifyRatePercent())) return false;
		if(!Objects.equals(this.__rate_percent, o.getRatePercent())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateRateRecordId() != null) sb.append(__wrapNumber(count++, "plateRateRecordId", getPlateRateRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getModifyRatePercent() != null) sb.append(__wrapDecimal(count++, "modifyRatePercent", getModifyRatePercent()));
		if(getRatePercent() != null) sb.append(__wrapDecimal(count++, "ratePercent", getRatePercent()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateRateRecordId")) != null) setPlateRateRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("modifyRatePercent")) != null) setModifyRatePercent(__getDecimal(val));  
		if((val = values.get("ratePercent")) != null) setRatePercent(__getDecimal(val));  
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __plate_rate_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __modify_rate_percent ;
	protected java.math.BigDecimal  __rate_percent ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
