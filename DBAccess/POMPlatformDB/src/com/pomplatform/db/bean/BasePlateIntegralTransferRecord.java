package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateIntegralTransferRecord extends GenericBase implements BaseFactory<BasePlateIntegralTransferRecord>, Comparable<BasePlateIntegralTransferRecord> 
{


	public static BasePlateIntegralTransferRecord newInstance(){
		return new BasePlateIntegralTransferRecord();
	}

	@Override
	public BasePlateIntegralTransferRecord make(){
		BasePlateIntegralTransferRecord b = new BasePlateIntegralTransferRecord();
		return b;
	}

	public final static java.lang.String CS_PLATE_INTEGRAL_TRANSFER_RECORD_ID = "plate_integral_transfer_record_id" ;
	public final static java.lang.String CS_FROM_PLATE_ID = "from_plate_id" ;
	public final static java.lang.String CS_TO_PLATE_ID = "to_plate_id" ;
	public final static java.lang.String CS_TRANSFER_INTEGRAL = "transfer_integral" ;
	public final static java.lang.String CS_TRANSFER_DATE = "transfer_date" ;
	public final static java.lang.String CS_PLATE_EMPLOYEE_ID = "plate_employee_id" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,积分提取部门,积分追加部门,转移积分,转移日期,事业部负责人,备注";

	public java.lang.Integer getPlateIntegralTransferRecordId() {
		return this.__plate_integral_transfer_record_id;
	}

	public void setPlateIntegralTransferRecordId( java.lang.Integer value ) {
		this.__plate_integral_transfer_record_id = value;
	}

	public java.lang.Integer getFromPlateId() {
		return this.__from_plate_id;
	}

	public void setFromPlateId( java.lang.Integer value ) {
		this.__from_plate_id = value;
	}

	public java.lang.Integer getToPlateId() {
		return this.__to_plate_id;
	}

	public void setToPlateId( java.lang.Integer value ) {
		this.__to_plate_id = value;
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

	public void cloneCopy(BasePlateIntegralTransferRecord __bean){
		__bean.setPlateIntegralTransferRecordId(getPlateIntegralTransferRecordId());
		__bean.setFromPlateId(getFromPlateId());
		__bean.setToPlateId(getToPlateId());
		__bean.setTransferIntegral(getTransferIntegral());
		__bean.setTransferDate(getTransferDate());
		__bean.setPlateEmployeeId(getPlateEmployeeId());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateIntegralTransferRecordId() == null ? "" : getPlateIntegralTransferRecordId());
		sb.append(",");
		sb.append(getFromPlateId() == null ? "" : getFromPlateId());
		sb.append(",");
		sb.append(getToPlateId() == null ? "" : getToPlateId());
		sb.append(",");
		sb.append(getTransferIntegral() == null ? "" : getTransferIntegral());
		sb.append(",");
		sb.append(getTransferDate() == null ? "" : sdf.format(getTransferDate()));
		sb.append(",");
		sb.append(getPlateEmployeeId() == null ? "" : getPlateEmployeeId());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateIntegralTransferRecord o) {
		return __plate_integral_transfer_record_id == null ? -1 : __plate_integral_transfer_record_id.compareTo(o.getPlateIntegralTransferRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_integral_transfer_record_id);
		hash = 97 * hash + Objects.hashCode(this.__from_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__to_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__transfer_integral);
		hash = 97 * hash + Objects.hashCode(this.__transfer_date);
		hash = 97 * hash + Objects.hashCode(this.__plate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateIntegralTransferRecord o = (BasePlateIntegralTransferRecord)obj;
		if(!Objects.equals(this.__plate_integral_transfer_record_id, o.getPlateIntegralTransferRecordId())) return false;
		if(!Objects.equals(this.__from_plate_id, o.getFromPlateId())) return false;
		if(!Objects.equals(this.__to_plate_id, o.getToPlateId())) return false;
		if(!Objects.equals(this.__transfer_integral, o.getTransferIntegral())) return false;
		if(!Objects.equals(this.__transfer_date, o.getTransferDate())) return false;
		if(!Objects.equals(this.__plate_employee_id, o.getPlateEmployeeId())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateIntegralTransferRecordId() != null) sb.append(__wrapNumber(count++, "plateIntegralTransferRecordId", getPlateIntegralTransferRecordId()));
		if(getFromPlateId() != null) sb.append(__wrapNumber(count++, "fromPlateId", getFromPlateId()));
		if(getToPlateId() != null) sb.append(__wrapNumber(count++, "toPlateId", getToPlateId()));
		if(getTransferIntegral() != null) sb.append(__wrapDecimal(count++, "transferIntegral", getTransferIntegral()));
		if(getTransferDate() != null) sb.append(__wrapDate(count++, "transferDate", getTransferDate()));
		if(getPlateEmployeeId() != null) sb.append(__wrapNumber(count++, "plateEmployeeId", getPlateEmployeeId()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateIntegralTransferRecordId")) != null) setPlateIntegralTransferRecordId(__getInt(val)); 
		if((val = values.get("fromPlateId")) != null) setFromPlateId(__getInt(val)); 
		if((val = values.get("toPlateId")) != null) setToPlateId(__getInt(val)); 
		if((val = values.get("transferIntegral")) != null) setTransferIntegral(__getDecimal(val));  
		if((val = values.get("transferDate")) != null) setTransferDate(__getDate(val)); 
		if((val = values.get("plateEmployeeId")) != null) setPlateEmployeeId(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __plate_integral_transfer_record_id ;
	protected java.lang.Integer  __from_plate_id ;
	protected java.lang.Integer  __to_plate_id ;
	protected java.math.BigDecimal  __transfer_integral ;
	protected java.util.Date  __transfer_date ;
	protected java.lang.Integer  __plate_employee_id ;
	protected java.lang.String  __remark ;
}
