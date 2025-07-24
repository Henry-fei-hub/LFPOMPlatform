package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateIntegralSend extends GenericBase implements BaseFactory<BasePlateIntegralSend>, Comparable<BasePlateIntegralSend> 
{


	public static BasePlateIntegralSend newInstance(){
		return new BasePlateIntegralSend();
	}

	@Override
	public BasePlateIntegralSend make(){
		BasePlateIntegralSend b = new BasePlateIntegralSend();
		return b;
	}

	public final static java.lang.String CS_PLATE_INTEGRAL_SEND_ID = "plate_integral_send_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_SEND_INTEGRAL = "send_integral" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SEND_DATE = "send_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,补贴积分,操作人,补贴日期,备注";

	public java.lang.Integer getPlateIntegralSendId() {
		return this.__plate_integral_send_id;
	}

	public void setPlateIntegralSendId( java.lang.Integer value ) {
		this.__plate_integral_send_id = value;
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

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public void cloneCopy(BasePlateIntegralSend __bean){
		__bean.setPlateIntegralSendId(getPlateIntegralSendId());
		__bean.setPlateId(getPlateId());
		__bean.setSendIntegral(getSendIntegral());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSendDate(getSendDate());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateIntegralSendId() == null ? "" : getPlateIntegralSendId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getSendIntegral() == null ? "" : getSendIntegral());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getSendDate() == null ? "" : sdf.format(getSendDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateIntegralSend o) {
		return __plate_integral_send_id == null ? -1 : __plate_integral_send_id.compareTo(o.getPlateIntegralSendId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_integral_send_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__send_integral);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__send_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateIntegralSend o = (BasePlateIntegralSend)obj;
		if(!Objects.equals(this.__plate_integral_send_id, o.getPlateIntegralSendId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__send_integral, o.getSendIntegral())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__send_date, o.getSendDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateIntegralSendId() != null) sb.append(__wrapNumber(count++, "plateIntegralSendId", getPlateIntegralSendId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getSendIntegral() != null) sb.append(__wrapDecimal(count++, "sendIntegral", getSendIntegral()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSendDate() != null) sb.append(__wrapDate(count++, "sendDate", getSendDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateIntegralSendId")) != null) setPlateIntegralSendId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("sendIntegral")) != null) setSendIntegral(__getDecimal(val));  
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("sendDate")) != null) setSendDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __plate_integral_send_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __send_integral ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __send_date ;
	protected java.lang.String  __remark ;
}
