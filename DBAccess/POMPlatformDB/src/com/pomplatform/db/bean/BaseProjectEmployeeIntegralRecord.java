package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseProjectEmployeeIntegralRecord extends GenericBase implements BaseFactory<BaseProjectEmployeeIntegralRecord>, Comparable<BaseProjectEmployeeIntegralRecord> 
{


	public static BaseProjectEmployeeIntegralRecord newInstance(){
		return new BaseProjectEmployeeIntegralRecord();
	}

	@Override
	public BaseProjectEmployeeIntegralRecord make(){
		BaseProjectEmployeeIntegralRecord b = new BaseProjectEmployeeIntegralRecord();
		return b;
	}

	public final static java.lang.String CS_PROJECT_EMPLOYEE_INTEGRAL_RECORD_ID = "project_employee_integral_record_id" ;
	public final static java.lang.String CS_PROJECT_ID = "project_id" ;
	public final static java.lang.String CS_STAGE_ID = "stage_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SURE_INTEGRAL = "sure_integral" ;
	public final static java.lang.String CS_INPUT_SURE_INTEGRAL = "input_sure_integral" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_SURE_DATE = "sure_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,项目,项目阶段,项目成员,确认的确认积分,输入的确认积分,结算状态,确认日期,备注";

	public java.lang.Integer getProjectEmployeeIntegralRecordId() {
		return this.__project_employee_integral_record_id;
	}

	public void setProjectEmployeeIntegralRecordId( java.lang.Integer value ) {
		this.__project_employee_integral_record_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.math.BigDecimal getSureIntegral() {
		return this.__sure_integral;
	}

	public void setSureIntegral( java.math.BigDecimal value ) {
		this.__sure_integral = value;
	}

	public java.math.BigDecimal getInputSureIntegral() {
		return this.__input_sure_integral;
	}

	public void setInputSureIntegral( java.math.BigDecimal value ) {
		this.__input_sure_integral = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.util.Date getSureDate() {
		return this.__sure_date;
	}

	public void setSureDate( java.util.Date value ) {
		this.__sure_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseProjectEmployeeIntegralRecord __bean){
		__bean.setProjectEmployeeIntegralRecordId(getProjectEmployeeIntegralRecordId());
		__bean.setProjectId(getProjectId());
		__bean.setStageId(getStageId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setSureIntegral(getSureIntegral());
		__bean.setInputSureIntegral(getInputSureIntegral());
		__bean.setStatus(getStatus());
		__bean.setSureDate(getSureDate());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProjectEmployeeIntegralRecordId() == null ? "" : getProjectEmployeeIntegralRecordId());
		sb.append(",");
		sb.append(getProjectId() == null ? "" : getProjectId());
		sb.append(",");
		sb.append(getStageId() == null ? "" : getStageId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getSureIntegral() == null ? "" : getSureIntegral());
		sb.append(",");
		sb.append(getInputSureIntegral() == null ? "" : getInputSureIntegral());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getSureDate() == null ? "" : sdf.format(getSureDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseProjectEmployeeIntegralRecord o) {
		return __project_employee_integral_record_id == null ? -1 : __project_employee_integral_record_id.compareTo(o.getProjectEmployeeIntegralRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__project_employee_integral_record_id);
		hash = 97 * hash + Objects.hashCode(this.__project_id);
		hash = 97 * hash + Objects.hashCode(this.__stage_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__input_sure_integral);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__sure_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseProjectEmployeeIntegralRecord o = (BaseProjectEmployeeIntegralRecord)obj;
		if(!Objects.equals(this.__project_employee_integral_record_id, o.getProjectEmployeeIntegralRecordId())) return false;
		if(!Objects.equals(this.__project_id, o.getProjectId())) return false;
		if(!Objects.equals(this.__stage_id, o.getStageId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__sure_integral, o.getSureIntegral())) return false;
		if(!Objects.equals(this.__input_sure_integral, o.getInputSureIntegral())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__sure_date, o.getSureDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProjectEmployeeIntegralRecordId() != null) sb.append(__wrapNumber(count++, "projectEmployeeIntegralRecordId", getProjectEmployeeIntegralRecordId()));
		if(getProjectId() != null) sb.append(__wrapNumber(count++, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(count++, "stageId", getStageId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getSureIntegral() != null) sb.append(__wrapDecimal(count++, "sureIntegral", getSureIntegral()));
		if(getInputSureIntegral() != null) sb.append(__wrapDecimal(count++, "inputSureIntegral", getInputSureIntegral()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getSureDate() != null) sb.append(__wrapDate(count++, "sureDate", getSureDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("projectEmployeeIntegralRecordId")) != null) setProjectEmployeeIntegralRecordId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("sureIntegral")) != null) setSureIntegral(__getDecimal(val));  
		if((val = values.get("inputSureIntegral")) != null) setInputSureIntegral(__getDecimal(val));  
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("sureDate")) != null) setSureDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __project_employee_integral_record_id ;
	protected java.lang.Integer  __project_id ;
	protected java.lang.Integer  __stage_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.math.BigDecimal  __sure_integral ;
	protected java.math.BigDecimal  __input_sure_integral ;
	protected java.lang.Integer  __status ;
	protected java.util.Date  __sure_date ;
	protected java.lang.String  __remark ;
}
