package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectIntegralTransferRecord extends GenericBase implements BaseFactory<BaseProjectIntegralTransferRecord>, Comparable<BaseProjectIntegralTransferRecord> 
{


	public static BaseProjectIntegralTransferRecord newInstance(){
		return new BaseProjectIntegralTransferRecord();
	}

	@Override
	public BaseProjectIntegralTransferRecord make(){
		BaseProjectIntegralTransferRecord b = new BaseProjectIntegralTransferRecord();
		return b;
	}

	public final static java.lang.String CS_PROJECT_INTEGRAL_TRANSFER_RECORD_ID = "project_integral_transfer_record_id" ;
	public final static java.lang.String CS_FROM_PROJECT_ID = "from_project_id" ;
	public final static java.lang.String CS_TO_PROJECT_ID = "to_project_id" ;
	public final static java.lang.String CS_TRANSFER_INTEGRAL = "transfer_integral" ;
	public final static java.lang.String CS_TRANSFER_DATE = "transfer_date" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PLATE_EMPLOYEE_ID = "plate_employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,目标项目,归属项目,转移积分,转移日期,板块,板块负责人,备注";

	public java.lang.Integer getProjectIntegralTransferRecordId() {
		return this.__project_integral_transfer_record_id;
	}

	public void setProjectIntegralTransferRecordId( java.lang.Integer value ) {
		this.__project_integral_transfer_record_id = value;
	}

	public java.lang.Integer getFromProjectId() {
		return this.__from_project_id;
	}

	public void setFromProjectId( java.lang.Integer value ) {
		this.__from_project_id = value;
	}

	public java.lang.Integer getToProjectId() {
		return this.__to_project_id;
	}

	public void setToProjectId( java.lang.Integer value ) {
		this.__to_project_id = value;
	}

	public java.math.BigDecimal getTransferIntegral() {
		return this.__transfer_integral;
	}

	public void setTransferIntegral( java.math.BigDecimal value ) {
		this.__transfer_integral = value;
	}

	public java.util.Date getTransferDate() {
		return this.__transfer_date;
	}

	public void setTransferDate( java.util.Date value ) {
		this.__transfer_date = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getPlateEmployeeId() {
		return this.__plate_employee_id;
	}

	public void setPlateEmployeeId( java.lang.Integer value ) {
		this.__plate_employee_id = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseProjectIntegralTransferRecord __bean){
		__bean.setProjectIntegralTransferRecordId(getProjectIntegralTransferRecordId());
		__bean.setFromProjectId(getFromProjectId());
		__bean.setToProjectId(getToProjectId());
		__bean.setTransferIntegral(getTransferIntegral());
		__bean.setTransferDate(getTransferDate());
		__bean.setPlateId(getPlateId());
		__bean.setPlateEmployeeId(getPlateEmployeeId());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectIntegralTransferRecordId() == null ? "" : getProjectIntegralTransferRecordId());
		sb.append(",");
		sb.append(getFromProjectId() == null ? "" : getFromProjectId());
		sb.append(",");
		sb.append(getToProjectId() == null ? "" : getToProjectId());
		sb.append(",");
		sb.append(getTransferIntegral() == null ? "" : getTransferIntegral());
		sb.append(",");
		sb.append(getTransferDate() == null ? "" : sdf.format(getTransferDate()));
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getPlateEmployeeId() == null ? "" : getPlateEmployeeId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectIntegralTransferRecord o) {
		return __project_integral_transfer_record_id == null ? -1 : __project_integral_transfer_record_id.compareTo(o.getProjectIntegralTransferRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_integral_transfer_record_id);
		hash = 97 * hash + Objects.hashCode(this.__from_project_id);
		hash = 97 * hash + Objects.hashCode(this.__to_project_id);
		hash = 97 * hash + Objects.hashCode(this.__transfer_integral);
		hash = 97 * hash + Objects.hashCode(this.__transfer_date);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectIntegralTransferRecord o = (BaseProjectIntegralTransferRecord)obj;
		if(!Objects.equals(this.__project_integral_transfer_record_id, o.getProjectIntegralTransferRecordId())) return false;
		if(!Objects.equals(this.__from_project_id, o.getFromProjectId())) return false;
		if(!Objects.equals(this.__to_project_id, o.getToProjectId())) return false;
		if(!Objects.equals(this.__transfer_integral, o.getTransferIntegral())) return false;
		if(!Objects.equals(this.__transfer_date, o.getTransferDate())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__plate_employee_id, o.getPlateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectIntegralTransferRecordId() != null) sb.append(__wrapNumber(count++, "projectIntegralTransferRecordId", getProjectIntegralTransferRecordId()));
		if(getFromProjectId() != null) sb.append(__wrapNumber(count++, "fromProjectId", getFromProjectId()));
		if(getToProjectId() != null) sb.append(__wrapNumber(count++, "toProjectId", getToProjectId()));
		if(getTransferIntegral() != null) sb.append(__wrapDecimal(count++, "transferIntegral", getTransferIntegral()));
		if(getTransferDate() != null) sb.append(__wrapDate(count++, "transferDate", getTransferDate()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPlateEmployeeId() != null) sb.append(__wrapNumber(count++, "plateEmployeeId", getPlateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectIntegralTransferRecordId")) != null) setProjectIntegralTransferRecordId(__getInt(val)); 
		if((val = values.get("fromProjectId")) != null) setFromProjectId(__getInt(val)); 
		if((val = values.get("toProjectId")) != null) setToProjectId(__getInt(val)); 
		if((val = values.get("transferIntegral")) != null) setTransferIntegral(__getDecimal(val));  
		if((val = values.get("transferDate")) != null) setTransferDate(__getDate(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateEmployeeId")) != null) setPlateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_integral_transfer_record_id ;
	protected java.lang.Integer  __from_project_id ;
	protected java.lang.Integer  __to_project_id ;
	protected java.math.BigDecimal  __transfer_integral ;
	protected java.util.Date  __transfer_date ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __plate_employee_id ;
	protected java.lang.String  __remark ;
}
