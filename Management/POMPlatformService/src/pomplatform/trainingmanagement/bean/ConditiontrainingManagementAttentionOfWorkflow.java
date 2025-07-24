package pomplatform.trainingmanagement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditiontrainingManagementAttentionOfWorkflow extends GenericCondition{

	public ConditiontrainingManagementAttentionOfWorkflow(){
		setParameterCount(12);
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getTrainingManagementId() {
		return this.__training_management_id;
	}

	public void setTrainingManagementId( java.lang.Integer value ) {
		this.__training_management_id = value;
	}

	public java.lang.String getSubject() {
		return this.__subject == null ? null : (this.__subject.indexOf("%") >= 0 ? this.__subject : "%"+this.__subject+"%");
	}

	public void setSubject( java.lang.String value ) {
		this.__subject = value;
	}

	public java.lang.Integer getCompereType() {
		return this.__compere_type;
	}

	public void setCompereType( java.lang.Integer value ) {
		this.__compere_type = value;
	}

	public java.lang.String getCompere() {
		return this.__compere == null ? null : (this.__compere.indexOf("%") >= 0 ? this.__compere : "%"+this.__compere+"%");
	}

	public void setCompere( java.lang.String value ) {
		this.__compere = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getSite() {
		return this.__site;
	}

	public void setSite( java.lang.String value ) {
		this.__site = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getIsSite() {
		return this.__is_site;
	}

	public void setIsSite( java.lang.Integer value ) {
		this.__is_site = value;
	}

	public java.lang.Integer getTrainingType() {
		return this.__training_type;
	}

	public void setTrainingType( java.lang.Integer value ) {
		this.__training_type = value;
	}

	public java.lang.Integer getIsSend() {
		return this.__is_send;
	}

	public void setIsSend( java.lang.Integer value ) {
		this.__is_send = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getTrainingManagementId() != null) sb.append(__wrapNumber(1, "trainingManagementId", getTrainingManagementId()));
		if(getSubject() != null) sb.append(__wrapString(1, "subject", getSubject()));
		if(getCompereType() != null) sb.append(__wrapNumber(1, "compereType", getCompereType()));
		if(getCompere() != null) sb.append(__wrapString(1, "compere", getCompere()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getSite() != null) sb.append(__wrapString(1, "site", getSite()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getIsSite() != null) sb.append(__wrapNumber(1, "isSite", getIsSite()));
		if(getTrainingType() != null) sb.append(__wrapNumber(1, "trainingType", getTrainingType()));
		if(getIsSend() != null) sb.append(__wrapNumber(1, "isSend", getIsSend()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("trainingManagementId")) != null) setTrainingManagementId(__getInt(val)); 
		if((val = values.get("subject")) != null) setSubject(__getString(val));
		if((val = values.get("compereType")) != null) setCompereType(__getInt(val)); 
		if((val = values.get("compere")) != null) setCompere(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("site")) != null) setSite(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("isSite")) != null) setIsSite(__getInt(val)); 
		if((val = values.get("trainingType")) != null) setTrainingType(__getInt(val)); 
		if((val = values.get("isSend")) != null) setIsSend(__getInt(val)); 
	}

	private java.lang.Integer __status = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __training_management_id = null;
	private java.lang.String __subject = null;
	private java.lang.Integer __compere_type = null;
	private java.lang.String __compere = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __site = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __is_site = null;
	private java.lang.Integer __training_type = null;
	private java.lang.Integer __is_send = null;
}

