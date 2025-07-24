package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlatePerformanceBonusDetail extends GenericBase implements BaseFactory<BasePlatePerformanceBonusDetail>, Comparable<BasePlatePerformanceBonusDetail> 
{


	public static BasePlatePerformanceBonusDetail newInstance(){
		return new BasePlatePerformanceBonusDetail();
	}

	@Override
	public BasePlatePerformanceBonusDetail make(){
		BasePlatePerformanceBonusDetail b = new BasePlatePerformanceBonusDetail();
		return b;
	}

	public final static java.lang.String CS_PLATE_PERFORMANCE_BONUS_DETAIL_ID = "plate_performance_bonus_detail_id" ;
	public final static java.lang.String CS_PLATE_PERFORMANCE_BONUS_ID = "plate_performance_bonus_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SEND_INTEGRAL = "send_integral" ;
	public final static java.lang.String CS_SENDED_INTEGRAL = "sended_integral" ;
	public final static java.lang.String CS_SEND_DATE = "send_date" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = ",绩效奖金总表编码,业务部门,发放成员,发放积分,已发放积分,发放日期,操作人,操作时间,备注";

	public java.lang.Integer getPlatePerformanceBonusDetailId() {
		return this.__plate_performance_bonus_detail_id;
	}

	public void setPlatePerformanceBonusDetailId( java.lang.Integer value ) {
		this.__plate_performance_bonus_detail_id = value;
	}

	public java.lang.Integer getPlatePerformanceBonusId() {
		return this.__plate_performance_bonus_id;
	}

	public void setPlatePerformanceBonusId( java.lang.Integer value ) {
		this.__plate_performance_bonus_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getSendIntegral() {
		return this.__send_integral;
	}

	public void setSendIntegral( java.math.BigDecimal value ) {
		this.__send_integral = value;
	}

	public java.math.BigDecimal getSendedIntegral() {
		return this.__sended_integral;
	}

	public void setSendedIntegral( java.math.BigDecimal value ) {
		this.__sended_integral = value;
	}

	public java.util.Date getSendDate() {
		return this.__send_date;
	}

	public void setSendDate( java.util.Date value ) {
		this.__send_date = value;
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

	public void cloneCopy(BasePlatePerformanceBonusDetail __bean){
		__bean.setPlatePerformanceBonusDetailId(getPlatePerformanceBonusDetailId());
		__bean.setPlatePerformanceBonusId(getPlatePerformanceBonusId());
		__bean.setPlateId(getPlateId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSendIntegral(getSendIntegral());
		__bean.setSendedIntegral(getSendedIntegral());
		__bean.setSendDate(getSendDate());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlatePerformanceBonusDetailId() == null ? "" : getPlatePerformanceBonusDetailId());
		sb.append(",");
		sb.append(getPlatePerformanceBonusId() == null ? "" : getPlatePerformanceBonusId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getSendIntegral() == null ? "" : getSendIntegral());
		sb.append(",");
		sb.append(getSendedIntegral() == null ? "" : getSendedIntegral());
		sb.append(",");
		sb.append(getSendDate() == null ? "" : sdf.format(getSendDate()));
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
	public int compareTo(BasePlatePerformanceBonusDetail o) {
		return __plate_performance_bonus_detail_id == null ? -1 : __plate_performance_bonus_detail_id.compareTo(o.getPlatePerformanceBonusDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_performance_bonus_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_performance_bonus_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__send_integral);
		hash = 97 * hash + Objects.hashCode(this.__sended_integral);
		hash = 97 * hash + Objects.hashCode(this.__send_date);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlatePerformanceBonusDetail o = (BasePlatePerformanceBonusDetail)obj;
		if(!Objects.equals(this.__plate_performance_bonus_detail_id, o.getPlatePerformanceBonusDetailId())) return false;
		if(!Objects.equals(this.__plate_performance_bonus_id, o.getPlatePerformanceBonusId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__send_integral, o.getSendIntegral())) return false;
		if(!Objects.equals(this.__sended_integral, o.getSendedIntegral())) return false;
		if(!Objects.equals(this.__send_date, o.getSendDate())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlatePerformanceBonusDetailId() != null) sb.append(__wrapNumber(count++, "platePerformanceBonusDetailId", getPlatePerformanceBonusDetailId()));
		if(getPlatePerformanceBonusId() != null) sb.append(__wrapNumber(count++, "platePerformanceBonusId", getPlatePerformanceBonusId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSendIntegral() != null) sb.append(__wrapDecimal(count++, "sendIntegral", getSendIntegral()));
		if(getSendedIntegral() != null) sb.append(__wrapDecimal(count++, "sendedIntegral", getSendedIntegral()));
		if(getSendDate() != null) sb.append(__wrapDate(count++, "sendDate", getSendDate()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("platePerformanceBonusDetailId")) != null) setPlatePerformanceBonusDetailId(__getInt(val)); 
		if((val = values.get("platePerformanceBonusId")) != null) setPlatePerformanceBonusId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("sendIntegral")) != null) setSendIntegral(__getDecimal(val));  
		if((val = values.get("sendedIntegral")) != null) setSendedIntegral(__getDecimal(val));  
		if((val = values.get("sendDate")) != null) setSendDate(__getDate(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __plate_performance_bonus_detail_id ;
	protected java.lang.Integer  __plate_performance_bonus_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __send_integral ;
	protected java.math.BigDecimal  __sended_integral ;
	protected java.util.Date  __send_date ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
