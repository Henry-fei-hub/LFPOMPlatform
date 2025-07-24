package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeChangePlateDetail extends GenericBase implements BaseFactory<BaseEmployeeChangePlateDetail>, Comparable<BaseEmployeeChangePlateDetail> 
{


	public static BaseEmployeeChangePlateDetail newInstance(){
		return new BaseEmployeeChangePlateDetail();
	}

	@Override
	public BaseEmployeeChangePlateDetail make(){
		BaseEmployeeChangePlateDetail b = new BaseEmployeeChangePlateDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_CHANGE_PLATE_DETAIL_ID = "employee_change_plate_detail_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_OUT_PLATE_ID = "out_plate_id" ;
	public final static java.lang.String CS_IN_PLATE_ID = "in_plate_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;
	public final static java.lang.String CS_CHANGE_PLATE_DATE = "change_plate_date" ;

	public final static java.lang.String ALL_CAPTIONS = "编码,员工编码,年份,月份,转出业务部门,转入业务部门,转岗原因,创建时间,修改时间,转岗日期（主要用于排序）";

	public java.lang.Integer getEmployeeChangePlateDetailId() {
		return this.__employee_change_plate_detail_id;
	}

	public void setEmployeeChangePlateDetailId( java.lang.Integer value ) {
		this.__employee_change_plate_detail_id = value;
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

	public java.lang.Integer getOutPlateId() {
		return this.__out_plate_id;
	}

	public void setOutPlateId( java.lang.Integer value ) {
		this.__out_plate_id = value;
	}

	public java.lang.Integer getInPlateId() {
		return this.__in_plate_id;
	}

	public void setInPlateId( java.lang.Integer value ) {
		this.__in_plate_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public java.util.Date getChangePlateDate() {
		return this.__change_plate_date;
	}

	public void setChangePlateDate( java.util.Date value ) {
		this.__change_plate_date = value;
	}

	public void cloneCopy(BaseEmployeeChangePlateDetail __bean){
		__bean.setEmployeeChangePlateDetailId(getEmployeeChangePlateDetailId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setOutPlateId(getOutPlateId());
		__bean.setInPlateId(getInPlateId());
		__bean.setRemark(getRemark());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
		__bean.setChangePlateDate(getChangePlateDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeChangePlateDetailId() == null ? "" : getEmployeeChangePlateDetailId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strYear = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_18", String.valueOf(getYear()));
		sb.append(strYear == null ? "" : strYear);
		sb.append(",");
		String strMonth = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_19", String.valueOf(getMonth()));
		sb.append(strMonth == null ? "" : strMonth);
		sb.append(",");
		String strOutPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getOutPlateId()));
		sb.append(strOutPlateId == null ? "" : strOutPlateId);
		sb.append(",");
		String strInPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getInPlateId()));
		sb.append(strInPlateId == null ? "" : strInPlateId);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		sb.append(",");
		sb.append(getChangePlateDate() == null ? "" : sdf.format(getChangePlateDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeChangePlateDetail o) {
		return __employee_change_plate_detail_id == null ? -1 : __employee_change_plate_detail_id.compareTo(o.getEmployeeChangePlateDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_change_plate_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__out_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__in_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		hash = 97 * hash + Objects.hashCode(this.__change_plate_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeChangePlateDetail o = (BaseEmployeeChangePlateDetail)obj;
		if(!Objects.equals(this.__employee_change_plate_detail_id, o.getEmployeeChangePlateDetailId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__out_plate_id, o.getOutPlateId())) return false;
		if(!Objects.equals(this.__in_plate_id, o.getInPlateId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		if(!Objects.equals(this.__change_plate_date, o.getChangePlateDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeChangePlateDetailId() != null) sb.append(__wrapNumber(count++, "employeeChangePlateDetailId", getEmployeeChangePlateDetailId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getOutPlateId() != null) sb.append(__wrapNumber(count++, "outPlateId", getOutPlateId()));
		if(getInPlateId() != null) sb.append(__wrapNumber(count++, "inPlateId", getInPlateId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		if(getChangePlateDate() != null) sb.append(__wrapDate(count++, "changePlateDate", getChangePlateDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeChangePlateDetailId")) != null) setEmployeeChangePlateDetailId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("outPlateId")) != null) setOutPlateId(__getInt(val)); 
		if((val = values.get("inPlateId")) != null) setInPlateId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
		if((val = values.get("changePlateDate")) != null) setChangePlateDate(__getDate(val)); 
	}

	protected java.lang.Integer  __employee_change_plate_detail_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __out_plate_id ;
	protected java.lang.Integer  __in_plate_id ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
	protected java.util.Date  __change_plate_date ;
}
