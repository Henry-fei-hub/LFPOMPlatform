package pomplatform.trainingManagementdetailor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionStrainingmanagementdetailor extends GenericCondition{

	public ConditionStrainingmanagementdetailor(){
		setParameterCount(13);
	}

	public java.lang.Integer getTrainingManagementDetailId() {
		return this.__training_management_detail_id;
	}

	public void setTrainingManagementDetailId( java.lang.Integer value ) {
		this.__training_management_detail_id = value;
	}

	public java.lang.Integer getTrainingManagementId() {
		return this.__training_management_id;
	}

	public void setTrainingManagementId( java.lang.Integer value ) {
		this.__training_management_id = value;
	}

	public java.lang.Integer getSignOutFlag() {
		return this.__sign_out_flag;
	}

	public void setSignOutFlag( java.lang.Integer value ) {
		this.__sign_out_flag = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNumber() {
		return this.__employee_number;
	}

	public void setEmployeeNumber( java.lang.String value ) {
		this.__employee_number = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getTrainingContent() {
		return this.__training_content;
	}

	public void setTrainingContent( java.lang.Integer value ) {
		this.__training_content = value;
	}

	public java.lang.Integer getTrainingMethod() {
		return this.__training_method;
	}

	public void setTrainingMethod( java.lang.Integer value ) {
		this.__training_method = value;
	}

	public java.lang.Integer getTrainingFrequency() {
		return this.__training_frequency;
	}

	public void setTrainingFrequency( java.lang.Integer value ) {
		this.__training_frequency = value;
	}

	public java.lang.Integer getTrainingPeriod() {
		return this.__training_period;
	}

	public void setTrainingPeriod( java.lang.Integer value ) {
		this.__training_period = value;
	}

	public java.lang.Integer getSpareTimeTraining() {
		return this.__spare_time_training;
	}

	public void setSpareTimeTraining( java.lang.Integer value ) {
		this.__spare_time_training = value;
	}

	public java.lang.Integer getCourseEvaluation() {
		return this.__course_evaluation;
	}

	public void setCourseEvaluation( java.lang.Integer value ) {
		this.__course_evaluation = value;
	}

	public java.lang.Integer getGuidingFunction() {
		return this.__guiding_function;
	}

	public void setGuidingFunction( java.lang.Integer value ) {
		this.__guiding_function = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTrainingManagementDetailId() != null) sb.append(__wrapNumber(1, "trainingManagementDetailId", getTrainingManagementDetailId()));
		if(getTrainingManagementId() != null) sb.append(__wrapNumber(1, "trainingManagementId", getTrainingManagementId()));
		if(getSignOutFlag() != null) sb.append(__wrapNumber(1, "signOutFlag", getSignOutFlag()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEmployeeNumber() != null) sb.append(__wrapString(1, "employeeNumber", getEmployeeNumber()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getTrainingContent() != null) sb.append(__wrapNumber(1, "trainingContent", getTrainingContent()));
		if(getTrainingMethod() != null) sb.append(__wrapNumber(1, "trainingMethod", getTrainingMethod()));
		if(getTrainingFrequency() != null) sb.append(__wrapNumber(1, "trainingFrequency", getTrainingFrequency()));
		if(getTrainingPeriod() != null) sb.append(__wrapNumber(1, "trainingPeriod", getTrainingPeriod()));
		if(getSpareTimeTraining() != null) sb.append(__wrapNumber(1, "spareTimeTraining", getSpareTimeTraining()));
		if(getCourseEvaluation() != null) sb.append(__wrapNumber(1, "courseEvaluation", getCourseEvaluation()));
		if(getGuidingFunction() != null) sb.append(__wrapNumber(1, "guidingFunction", getGuidingFunction()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("trainingManagementDetailId")) != null) setTrainingManagementDetailId(__getInt(val)); 
		if((val = values.get("trainingManagementId")) != null) setTrainingManagementId(__getInt(val)); 
		if((val = values.get("signOutFlag")) != null) setSignOutFlag(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNumber")) != null) setEmployeeNumber(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("trainingContent")) != null) setTrainingContent(__getInt(val)); 
		if((val = values.get("trainingMethod")) != null) setTrainingMethod(__getInt(val)); 
		if((val = values.get("trainingFrequency")) != null) setTrainingFrequency(__getInt(val)); 
		if((val = values.get("trainingPeriod")) != null) setTrainingPeriod(__getInt(val)); 
		if((val = values.get("spareTimeTraining")) != null) setSpareTimeTraining(__getInt(val)); 
		if((val = values.get("courseEvaluation")) != null) setCourseEvaluation(__getInt(val)); 
		if((val = values.get("guidingFunction")) != null) setGuidingFunction(__getInt(val)); 
	}

	private java.lang.Integer __training_management_detail_id = null;
	private java.lang.Integer __training_management_id = null;
	private java.lang.Integer __sign_out_flag = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __employee_number = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __training_content = null;
	private java.lang.Integer __training_method = null;
	private java.lang.Integer __training_frequency = null;
	private java.lang.Integer __training_period = null;
	private java.lang.Integer __spare_time_training = null;
	private java.lang.Integer __course_evaluation = null;
	private java.lang.Integer __guiding_function = null;
}

