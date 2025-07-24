package pomplatform.trainingManagementdetailor.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseStrainingmanagementdetailor extends GenericBase implements BaseFactory<BaseStrainingmanagementdetailor>, Comparable<BaseStrainingmanagementdetailor> 
{


	public static BaseStrainingmanagementdetailor newInstance(){
		return new BaseStrainingmanagementdetailor();
	}

	@Override
	public BaseStrainingmanagementdetailor make(){
		BaseStrainingmanagementdetailor b = new BaseStrainingmanagementdetailor();
		return b;
	}

	public final static java.lang.String CS_TRAINING_MANAGEMENT_DETAIL_ID = "training_management_detail_id" ;
	public final static java.lang.String CS_TRAINING_MANAGEMENT_ID = "training_management_id" ;
	public final static java.lang.String CS_SIGN_IN_TIME = "sign_in_time" ;
	public final static java.lang.String CS_SIGN_OUT_TIME = "sign_out_time" ;
	public final static java.lang.String CS_SIGN_OUT_FLAG = "sign_out_flag" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NUMBER = "employee_number" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_TRAINING_CONTENT = "training_content" ;
	public final static java.lang.String CS_TRAINING_METHOD = "training_method" ;
	public final static java.lang.String CS_TRAINING_FREQUENCY = "training_frequency" ;
	public final static java.lang.String CS_TRAINING_PERIOD = "training_period" ;
	public final static java.lang.String CS_SPARE_TIME_TRAINING = "spare_time_training" ;
	public final static java.lang.String CS_SUGGEST = "suggest" ;
	public final static java.lang.String CS_COURSE_EVALUATION = "course_evaluation" ;
	public final static java.lang.String CS_GUIDING_FUNCTION = "guiding_function" ;

	public final static java.lang.String ALL_CAPTIONS = "签到时间,签退时间,是否签退(0签退2没有签退),签到人,部门编码,培训内容得分,培训方式得分,培训频率选择(1每月2每季3半年4每年),培训时长(1半个小时21到2个小时33到4个小时4一天),是否接受业余时间培训(1是2否3看课程),建议,课程评价,指导作用";

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

	public java.util.Date getSignInTime() {
		return this.__sign_in_time;
	}

	public void setSignInTime( java.util.Date value ) {
		this.__sign_in_time = value;
	}

	public java.util.Date getSignOutTime() {
		return this.__sign_out_time;
	}

	public void setSignOutTime( java.util.Date value ) {
		this.__sign_out_time = value;
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

	public java.lang.String getSuggest() {
		return this.__suggest;
	}

	public void setSuggest( java.lang.String value ) {
		this.__suggest = value;
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

	public void cloneCopy(BaseStrainingmanagementdetailor __bean){
		__bean.setTrainingManagementDetailId(getTrainingManagementDetailId());
		__bean.setTrainingManagementId(getTrainingManagementId());
		__bean.setSignInTime(getSignInTime());
		__bean.setSignOutTime(getSignOutTime());
		__bean.setSignOutFlag(getSignOutFlag());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNumber(getEmployeeNumber());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setTrainingContent(getTrainingContent());
		__bean.setTrainingMethod(getTrainingMethod());
		__bean.setTrainingFrequency(getTrainingFrequency());
		__bean.setTrainingPeriod(getTrainingPeriod());
		__bean.setSpareTimeTraining(getSpareTimeTraining());
		__bean.setSuggest(getSuggest());
		__bean.setCourseEvaluation(getCourseEvaluation());
		__bean.setGuidingFunction(getGuidingFunction());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
//		sb.append(getTrainingManagementDetailId() == null ? "" : getTrainingManagementDetailId());
//		sb.append(",");
//		sb.append(getTrainingManagementId() == null ? "" : getTrainingManagementId());
//		sb.append(",");
		sb.append(getSignInTime() == null ? "" : sdf.format(getSignInTime()));
		sb.append(",");
		sb.append(getSignOutTime() == null ? "" : sdf.format(getSignOutTime()));
		sb.append(",");
		sb.append(getSignOutFlag() == 0 ? "签到" : "未签到");
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
//		sb.append(getEmployeeNumber() == null ? "" : getEmployeeNumber());
//		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getTrainingContent() == null ? "" : getTrainingContent());
		sb.append(",");
		sb.append(getTrainingMethod() == null ? "" : getTrainingMethod());
		sb.append(",");
		sb.append(getTrainingFrequency() == null ? "" : getTrainingFrequency());
		sb.append(",");
		sb.append(getTrainingPeriod() == null ? "" : getTrainingPeriod());
		sb.append(",");
		sb.append(getSpareTimeTraining() == null ? "" : getSpareTimeTraining());
		sb.append(",");
		sb.append(getSuggest() == null ? "" : getSuggest());
		sb.append(",");
		sb.append(getCourseEvaluation() == null ? "" : getCourseEvaluation());
		sb.append(",");
		sb.append(getGuidingFunction() == null ? "" : getGuidingFunction());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStrainingmanagementdetailor o) {
		return __training_management_detail_id == null ? -1 : __training_management_detail_id.compareTo(o.getTrainingManagementDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__training_management_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__training_management_id);
		hash = 97 * hash + Objects.hashCode(this.__sign_in_time);
		hash = 97 * hash + Objects.hashCode(this.__sign_out_time);
		hash = 97 * hash + Objects.hashCode(this.__sign_out_flag);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_number);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__training_content);
		hash = 97 * hash + Objects.hashCode(this.__training_method);
		hash = 97 * hash + Objects.hashCode(this.__training_frequency);
		hash = 97 * hash + Objects.hashCode(this.__training_period);
		hash = 97 * hash + Objects.hashCode(this.__spare_time_training);
		hash = 97 * hash + Objects.hashCode(this.__suggest);
		hash = 97 * hash + Objects.hashCode(this.__course_evaluation);
		hash = 97 * hash + Objects.hashCode(this.__guiding_function);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStrainingmanagementdetailor o = (BaseStrainingmanagementdetailor)obj;
		if(!Objects.equals(this.__training_management_detail_id, o.getTrainingManagementDetailId())) return false;
		if(!Objects.equals(this.__training_management_id, o.getTrainingManagementId())) return false;
		if(!Objects.equals(this.__sign_in_time, o.getSignInTime())) return false;
		if(!Objects.equals(this.__sign_out_time, o.getSignOutTime())) return false;
		if(!Objects.equals(this.__sign_out_flag, o.getSignOutFlag())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_number, o.getEmployeeNumber())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__training_content, o.getTrainingContent())) return false;
		if(!Objects.equals(this.__training_method, o.getTrainingMethod())) return false;
		if(!Objects.equals(this.__training_frequency, o.getTrainingFrequency())) return false;
		if(!Objects.equals(this.__training_period, o.getTrainingPeriod())) return false;
		if(!Objects.equals(this.__spare_time_training, o.getSpareTimeTraining())) return false;
		if(!Objects.equals(this.__suggest, o.getSuggest())) return false;
		if(!Objects.equals(this.__course_evaluation, o.getCourseEvaluation())) return false;
		if(!Objects.equals(this.__guiding_function, o.getGuidingFunction())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTrainingManagementDetailId() != null) sb.append(__wrapNumber(count++, "trainingManagementDetailId", getTrainingManagementDetailId()));
		if(getTrainingManagementId() != null) sb.append(__wrapNumber(count++, "trainingManagementId", getTrainingManagementId()));
		if(getSignInTime() != null) sb.append(__wrapDate(count++, "signInTime", getSignInTime()));
		if(getSignOutTime() != null) sb.append(__wrapDate(count++, "signOutTime", getSignOutTime()));
		if(getSignOutFlag() != null) sb.append(__wrapNumber(count++, "signOutFlag", getSignOutFlag()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNumber() != null) sb.append(__wrapString(count++, "employeeNumber", getEmployeeNumber()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getTrainingContent() != null) sb.append(__wrapNumber(count++, "trainingContent", getTrainingContent()));
		if(getTrainingMethod() != null) sb.append(__wrapNumber(count++, "trainingMethod", getTrainingMethod()));
		if(getTrainingFrequency() != null) sb.append(__wrapNumber(count++, "trainingFrequency", getTrainingFrequency()));
		if(getTrainingPeriod() != null) sb.append(__wrapNumber(count++, "trainingPeriod", getTrainingPeriod()));
		if(getSpareTimeTraining() != null) sb.append(__wrapNumber(count++, "spareTimeTraining", getSpareTimeTraining()));
		if(getSuggest() != null) sb.append(__wrapString(count++, "suggest", getSuggest()));
		if(getCourseEvaluation() != null) sb.append(__wrapNumber(count++, "courseEvaluation", getCourseEvaluation()));
		if(getGuidingFunction() != null) sb.append(__wrapNumber(count++, "guidingFunction", getGuidingFunction()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("trainingManagementDetailId")) != null) setTrainingManagementDetailId(__getInt(val)); 
		if((val = values.get("trainingManagementId")) != null) setTrainingManagementId(__getInt(val)); 
		if((val = values.get("signInTime")) != null) setSignInTime(__getDate(val)); 
		if((val = values.get("signOutTime")) != null) setSignOutTime(__getDate(val)); 
		if((val = values.get("signOutFlag")) != null) setSignOutFlag(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNumber")) != null) setEmployeeNumber(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("trainingContent")) != null) setTrainingContent(__getInt(val)); 
		if((val = values.get("trainingMethod")) != null) setTrainingMethod(__getInt(val)); 
		if((val = values.get("trainingFrequency")) != null) setTrainingFrequency(__getInt(val)); 
		if((val = values.get("trainingPeriod")) != null) setTrainingPeriod(__getInt(val)); 
		if((val = values.get("spareTimeTraining")) != null) setSpareTimeTraining(__getInt(val)); 
		if((val = values.get("suggest")) != null) setSuggest(__getString(val));
		if((val = values.get("courseEvaluation")) != null) setCourseEvaluation(__getInt(val)); 
		if((val = values.get("guidingFunction")) != null) setGuidingFunction(__getInt(val)); 
	}

	protected java.lang.Integer  __training_management_detail_id ;
	protected java.lang.Integer  __training_management_id ;
	protected java.util.Date  __sign_in_time ;
	protected java.util.Date  __sign_out_time ;
	protected java.lang.Integer  __sign_out_flag ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_number ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __training_content ;
	protected java.lang.Integer  __training_method ;
	protected java.lang.Integer  __training_frequency ;
	protected java.lang.Integer  __training_period ;
	protected java.lang.Integer  __spare_time_training ;
	protected java.lang.String  __suggest ;
	protected java.lang.Integer  __course_evaluation ;
	protected java.lang.Integer  __guiding_function ;
}
