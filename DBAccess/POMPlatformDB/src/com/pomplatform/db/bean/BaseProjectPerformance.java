package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectPerformance extends GenericBase implements BaseFactory<BaseProjectPerformance>, Comparable<BaseProjectPerformance> 
{


	public static BaseProjectPerformance newInstance(){
		return new BaseProjectPerformance();
	}

	@Override
	public BaseProjectPerformance make(){
		BaseProjectPerformance b = new BaseProjectPerformance();
		return b;
	}

	public final static java.lang.String CS_PROJECT_PERFORMANCE_ID = "project_performance_id" ;
	public final static java.lang.String CS_CONTRACT_ID = "contract_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;
	public final static java.lang.String CS_PERCENT = "percent" ;
	public final static java.lang.String CS_PERFORMANCE_INTEGRAL = "performance_integral" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_CLIENT_COMPLAINT = "client_complaint" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_IS_SUBMIT = "is_submit" ;
	public final static java.lang.String CS_PERFORMANCE_FLAG = "performance_flag" ;
	public final static java.lang.String CS_BUSINESS_TYPE = "business_type" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_IS_SETTLEMENT = "is_settlement" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,合同编码,项目编码,积分,比例,扣除/奖励积分,职员,日期,客户投诉,原因,是否提交,2奖励,2项目绩效,操作人,操作时间,备注,类型 0比例增减  1积分增减,是否结算";

	public java.lang.Integer getProjectPerformanceId() {
		return this.__project_performance_id;
	}

	public void setProjectPerformanceId( java.lang.Integer value ) {
		this.__project_performance_id = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public java.math.BigDecimal getPerformanceIntegral() {
		return this.__performance_integral;
	}

	public void setPerformanceIntegral( java.math.BigDecimal value ) {
		this.__performance_integral = value;
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

	public java.lang.String getClientComplaint() {
		return this.__client_complaint;
	}

	public void setClientComplaint( java.lang.String value ) {
		this.__client_complaint = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.lang.Boolean getIsSubmit() {
		return this.__is_submit;
	}

	public void setIsSubmit( java.lang.Boolean value ) {
		this.__is_submit = value;
	}

	public java.lang.Integer getPerformanceFlag() {
		return this.__performance_flag;
	}

	public void setPerformanceFlag( java.lang.Integer value ) {
		this.__performance_flag = value;
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
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

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Boolean getIsSettlement() {
		return this.__is_settlement;
	}

	public void setIsSettlement( java.lang.Boolean value ) {
		this.__is_settlement = value;
	}

	public void cloneCopy(BaseProjectPerformance __bean){
		__bean.setProjectPerformanceId(getProjectPerformanceId());
		__bean.setContractId(getContractId());
		__bean.setProjectId(getProjectId());
		__bean.setIntegral(getIntegral());
		__bean.setPercent(getPercent());
		__bean.setPerformanceIntegral(getPerformanceIntegral());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setRecordDate(getRecordDate());
		__bean.setClientComplaint(getClientComplaint());
		__bean.setReason(getReason());
		__bean.setIsSubmit(getIsSubmit());
		__bean.setPerformanceFlag(getPerformanceFlag());
		__bean.setBusinessType(getBusinessType());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setType(getType());
		__bean.setIsSettlement(getIsSettlement());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectPerformanceId() == null ? "" : getProjectPerformanceId());
		sb.append(",");
		sb.append(getContractId() == null ? "" : getContractId());
		sb.append(",");
		String strProjectId = delicacy.system.executor.SelectValueCache.getSelectValue("projects", String.valueOf(getProjectId()));
		sb.append(strProjectId == null ? "" : strProjectId);
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		sb.append(",");
		sb.append(getPerformanceIntegral() == null ? "" : getPerformanceIntegral());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getClientComplaint() == null ? "" : getClientComplaint());
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getIsSubmit() == null ? "" : getIsSubmit());
		sb.append(",");
		sb.append(getPerformanceFlag() == null ? "" : getPerformanceFlag());
		sb.append(",");
		sb.append(getBusinessType() == null ? "" : getBusinessType());
		sb.append(",");
		String strOperateEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getOperateEmployeeId()));
		sb.append(strOperateEmployeeId == null ? "" : strOperateEmployeeId);
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getIsSettlement() == null ? "" : getIsSettlement());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectPerformance o) {
		return __project_performance_id == null ? -1 : __project_performance_id.compareTo(o.getProjectPerformanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_performance_id);
		hash = 97 * hash + Objects.hashCode(this.__contract_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		hash = 97 * hash + Objects.hashCode(this.__performance_integral);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__client_complaint);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__is_submit);
		hash = 97 * hash + Objects.hashCode(this.__performance_flag);
		hash = 97 * hash + Objects.hashCode(this.__business_type);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__is_settlement);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectPerformance o = (BaseProjectPerformance)obj;
		if(!Objects.equals(this.__project_performance_id, o.getProjectPerformanceId())) return false;
		if(!Objects.equals(this.__contract_id, o.getContractId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		if(!Objects.equals(this.__performance_integral, o.getPerformanceIntegral())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__client_complaint, o.getClientComplaint())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__is_submit, o.getIsSubmit())) return false;
		if(!Objects.equals(this.__performance_flag, o.getPerformanceFlag())) return false;
		if(!Objects.equals(this.__business_type, o.getBusinessType())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__is_settlement, o.getIsSettlement())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectPerformanceId() != null) sb.append(__wrapNumber(count++, "projectPerformanceId", getProjectPerformanceId()));
		if(getContractId() != null) sb.append(__wrapNumber(count++, "contractId", getContractId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		if(getPerformanceIntegral() != null) sb.append(__wrapDecimal(count++, "performanceIntegral", getPerformanceIntegral()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getClientComplaint() != null) sb.append(__wrapString(count++, "clientComplaint", getClientComplaint()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getIsSubmit() != null) sb.append(__wrapBoolean(count++, "isSubmit", getIsSubmit()));
		if(getPerformanceFlag() != null) sb.append(__wrapNumber(count++, "performanceFlag", getPerformanceFlag()));
		if(getBusinessType() != null) sb.append(__wrapNumber(count++, "businessType", getBusinessType()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getIsSettlement() != null) sb.append(__wrapBoolean(count++, "isSettlement", getIsSettlement()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectPerformanceId")) != null) setProjectPerformanceId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
		if((val = values.get("performanceIntegral")) != null) setPerformanceIntegral(__getDecimal(val));  
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("clientComplaint")) != null) setClientComplaint(__getString(val));
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("isSubmit")) != null) setIsSubmit(__getBoolean(val));
		if((val = values.get("performanceFlag")) != null) setPerformanceFlag(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("isSettlement")) != null) setIsSettlement(__getBoolean(val));
	}

	protected java.lang.Integer  __project_performance_id ;
	protected java.lang.Integer  __contract_id ;
	protected java.lang.Integer  __project_id ;
	protected java.math.BigDecimal  __integral ;
	protected java.math.BigDecimal  __percent ;
	protected java.math.BigDecimal  __performance_integral ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __client_complaint ;
	protected java.lang.String  __reason ;
	protected java.lang.Boolean  __is_submit ;
	protected java.lang.Integer  __performance_flag ;
	protected java.lang.Integer  __business_type ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __type ;
	protected java.lang.Boolean  __is_settlement ;
}
