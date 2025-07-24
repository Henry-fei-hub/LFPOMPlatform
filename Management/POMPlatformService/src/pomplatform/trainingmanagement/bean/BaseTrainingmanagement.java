package pomplatform.trainingmanagement.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseTrainingmanagement extends GenericBase implements BaseFactory<BaseTrainingmanagement>, Comparable<BaseTrainingmanagement> 
{


	public static BaseTrainingmanagement newInstance(){
		return new BaseTrainingmanagement();
	}

	@Override
	public BaseTrainingmanagement make(){
		BaseTrainingmanagement b = new BaseTrainingmanagement();
		return b;
	}

	public final static java.lang.String CS_TRAINING_MANAGEMENT_ID = "training_management_id" ;
	public final static java.lang.String CS_SUBJECT = "subject" ;
	public final static java.lang.String CS_COMPERE_TYPE = "compere_type" ;
	public final static java.lang.String CS_COMPERE = "compere" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_START_TIME = "start_time" ;
	public final static java.lang.String CS_END_TIME = "end_time" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COURSE_SCORE = "course_score" ;
	public final static java.lang.String CS_CREATE_PERSON_ID = "create_person_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_FILE_MANAGE_ID = "file_manage_id" ;
	public final static java.lang.String CS_AVG_SCORE = "avg_score" ;
	public final static java.lang.String CS_SIGN_IN_COUNT = "sign_in_count" ;
	public final static java.lang.String CS_SIGN_OUT_COUNT = "sign_out_count" ;
	public final static java.lang.String CS_TRAINING_FREQUENCY_ONE = "training_frequency_one" ;
	public final static java.lang.String CS_TRAINING_FREQUENCY_TWO = "training_frequency_two" ;
	public final static java.lang.String CS_TRAINING_FREQUENCY_THREE = "training_frequency_three" ;
	public final static java.lang.String CS_TRAINING_FREQUENCY_FOUR = "training_frequency_four" ;
	public final static java.lang.String CS_TRAINING_PERIOD_ONE = "training_period_one" ;
	public final static java.lang.String CS_TRAINING_PERIOD_TWO = "training_period_two" ;
	public final static java.lang.String CS_TRAINING_PERIOD_THREE = "training_period_three" ;
	public final static java.lang.String CS_TRAINING_PERIOD_FOUR = "training_period_four" ;
	public final static java.lang.String CS_SPARE_TIME_TRAINING_ONE = "spare_time_training_one" ;
	public final static java.lang.String CS_SPARE_TIME_TRAINING_TWO = "spare_time_training_two" ;
	public final static java.lang.String CS_SPARE_TIME_TRAINING_THREE = "spare_time_training_three" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;

	public final static java.lang.String ALL_CAPTIONS = "主题,主持人,开始时间,结束时间,部门,课程分数,评价分数,签到人数,退签人数,每月培训频率,每季培训频率,每半年培训频率,每年培训频率,培训时长半小时,培训时长2小时内,培训时长4小时内,培训时长1天,接受业余时间培训,不接受业余时间培训,接受业余时间培训(看课程)";

	public java.lang.Integer getTrainingManagementId() {
		return this.__training_management_id;
	}

	public void setTrainingManagementId( java.lang.Integer value ) {
		this.__training_management_id = value;
	}

	public java.lang.String getSubject() {
		return this.__subject;
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
		return this.__compere;
	}

	public void setCompere( java.lang.String value ) {
		this.__compere = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getStartTime() {
		return this.__start_time;
	}

	public void setStartTime( java.util.Date value ) {
		this.__start_time = value;
	}

	public java.util.Date getEndTime() {
		return this.__end_time;
	}

	public void setEndTime( java.util.Date value ) {
		this.__end_time = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getCourseScore() {
		return this.__course_score;
	}

	public void setCourseScore( java.lang.Integer value ) {
		this.__course_score = value;
	}

	public java.lang.Integer getCreatePersonId() {
		return this.__create_person_id;
	}

	public void setCreatePersonId( java.lang.Integer value ) {
		this.__create_person_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getFileManageId() {
		return this.__file_manage_id;
	}

	public void setFileManageId( java.lang.Integer value ) {
		this.__file_manage_id = value;
	}

	public java.math.BigDecimal getAvgScore() {
		return this.__avg_score;
	}

	public void setAvgScore( java.math.BigDecimal value ) {
		this.__avg_score = value;
	}

	public java.lang.Long getSignInCount() {
		return this.__sign_in_count;
	}

	public void setSignInCount( java.lang.Long value ) {
		this.__sign_in_count = value;
	}

	public java.lang.Long getSignOutCount() {
		return this.__sign_out_count;
	}

	public void setSignOutCount( java.lang.Long value ) {
		this.__sign_out_count = value;
	}

	public java.lang.Long getTrainingFrequencyOne() {
		return this.__training_frequency_one;
	}

	public void setTrainingFrequencyOne( java.lang.Long value ) {
		this.__training_frequency_one = value;
	}

	public java.lang.Long getTrainingFrequencyTwo() {
		return this.__training_frequency_two;
	}

	public void setTrainingFrequencyTwo( java.lang.Long value ) {
		this.__training_frequency_two = value;
	}

	public java.lang.Long getTrainingFrequencyThree() {
		return this.__training_frequency_three;
	}

	public void setTrainingFrequencyThree( java.lang.Long value ) {
		this.__training_frequency_three = value;
	}

	public java.lang.Long getTrainingFrequencyFour() {
		return this.__training_frequency_four;
	}

	public void setTrainingFrequencyFour( java.lang.Long value ) {
		this.__training_frequency_four = value;
	}

	public java.lang.Long getTrainingPeriodOne() {
		return this.__training_period_one;
	}

	public void setTrainingPeriodOne( java.lang.Long value ) {
		this.__training_period_one = value;
	}

	public java.lang.Long getTrainingPeriodTwo() {
		return this.__training_period_two;
	}

	public void setTrainingPeriodTwo( java.lang.Long value ) {
		this.__training_period_two = value;
	}

	public java.lang.Long getTrainingPeriodThree() {
		return this.__training_period_three;
	}

	public void setTrainingPeriodThree( java.lang.Long value ) {
		this.__training_period_three = value;
	}

	public java.lang.Long getTrainingPeriodFour() {
		return this.__training_period_four;
	}

	public void setTrainingPeriodFour( java.lang.Long value ) {
		this.__training_period_four = value;
	}

	public java.lang.Long getSpareTimeTrainingOne() {
		return this.__spare_time_training_one;
	}

	public void setSpareTimeTrainingOne( java.lang.Long value ) {
		this.__spare_time_training_one = value;
	}

	public java.lang.Long getSpareTimeTrainingTwo() {
		return this.__spare_time_training_two;
	}

	public void setSpareTimeTrainingTwo( java.lang.Long value ) {
		this.__spare_time_training_two = value;
	}

	public java.lang.Long getSpareTimeTrainingThree() {
		return this.__spare_time_training_three;
	}

	public void setSpareTimeTrainingThree( java.lang.Long value ) {
		this.__spare_time_training_three = value;
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

	public void cloneCopy(BaseTrainingmanagement __bean){
		__bean.setTrainingManagementId(getTrainingManagementId());
		__bean.setSubject(getSubject());
		__bean.setCompereType(getCompereType());
		__bean.setCompere(getCompere());
		__bean.setCreateTime(getCreateTime());
		__bean.setStartTime(getStartTime());
		__bean.setEndTime(getEndTime());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCourseScore(getCourseScore());
		__bean.setCreatePersonId(getCreatePersonId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setFileManageId(getFileManageId());
		__bean.setAvgScore(getAvgScore());
		__bean.setSignInCount(getSignInCount());
		__bean.setSignOutCount(getSignOutCount());
		__bean.setTrainingFrequencyOne(getTrainingFrequencyOne());
		__bean.setTrainingFrequencyTwo(getTrainingFrequencyTwo());
		__bean.setTrainingFrequencyThree(getTrainingFrequencyThree());
		__bean.setTrainingFrequencyFour(getTrainingFrequencyFour());
		__bean.setTrainingPeriodOne(getTrainingPeriodOne());
		__bean.setTrainingPeriodTwo(getTrainingPeriodTwo());
		__bean.setTrainingPeriodThree(getTrainingPeriodThree());
		__bean.setTrainingPeriodFour(getTrainingPeriodFour());
		__bean.setSpareTimeTrainingOne(getSpareTimeTrainingOne());
		__bean.setSpareTimeTrainingTwo(getSpareTimeTrainingTwo());
		__bean.setSpareTimeTrainingThree(getSpareTimeTrainingThree());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
//		sb.append(getTrainingManagementId() == null ? "" : getTrainingManagementId());
//		sb.append(",");
		sb.append(getSubject() == null ? "" : getSubject());
		sb.append(",");
//		String strCompereType = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getCompereType()));
//		sb.append(strCompereType == null ? "" : strCompereType);
//		sb.append(",");
		sb.append(getCompere() == null ? "" : getCompere());
		sb.append(",");
//		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
//		sb.append(",");
		sb.append(getStartTime() == null ? "" : sdf.format(getStartTime()));
		sb.append(",");
		sb.append(getEndTime() == null ? "" : sdf.format(getEndTime()));
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getCourseScore() == null ? "" : getCourseScore());
		sb.append(",");
//		String strCreatePersonId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getCreatePersonId()));
//		sb.append(strCreatePersonId == null ? "" : strCreatePersonId);
//		sb.append(",");
//		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
//		sb.append(strEmployeeId == null ? "" : strEmployeeId);
//		sb.append(",");
//		sb.append(getFileManageId() == null ? "" : getFileManageId());
//		sb.append(",");
		sb.append(getAvgScore() == null ? "" : getAvgScore());
		sb.append(",");
		sb.append(getSignInCount() == null ? "" : getSignInCount());
		sb.append(",");
		sb.append(getSignOutCount() == null ? "" : getSignOutCount());
		sb.append(",");
		sb.append(getTrainingFrequencyOne() == null ? "" : getTrainingFrequencyOne());
		sb.append(",");
		sb.append(getTrainingFrequencyTwo() == null ? "" : getTrainingFrequencyTwo());
		sb.append(",");
		sb.append(getTrainingFrequencyThree() == null ? "" : getTrainingFrequencyThree());
		sb.append(",");
		sb.append(getTrainingFrequencyFour() == null ? "" : getTrainingFrequencyFour());
		sb.append(",");
		sb.append(getTrainingPeriodOne() == null ? "" : getTrainingPeriodOne());
		sb.append(",");
		sb.append(getTrainingPeriodTwo() == null ? "" : getTrainingPeriodTwo());
		sb.append(",");
		sb.append(getTrainingPeriodThree() == null ? "" : getTrainingPeriodThree());
		sb.append(",");
		sb.append(getTrainingPeriodFour() == null ? "" : getTrainingPeriodFour());
		sb.append(",");
		sb.append(getSpareTimeTrainingOne() == null ? "" : getSpareTimeTrainingOne());
		sb.append(",");
		sb.append(getSpareTimeTrainingTwo() == null ? "" : getSpareTimeTrainingTwo());
		sb.append(",");
		sb.append(getSpareTimeTrainingThree() == null ? "" : getSpareTimeTrainingThree());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseTrainingmanagement o) {
		return __training_management_id == null ? -1 : __training_management_id.compareTo(o.getTrainingManagementId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__training_management_id);
		hash = 97 * hash + Objects.hashCode(this.__subject);
		hash = 97 * hash + Objects.hashCode(this.__compere_type);
		hash = 97 * hash + Objects.hashCode(this.__compere);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__start_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__course_score);
		hash = 97 * hash + Objects.hashCode(this.__create_person_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__file_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__avg_score);
		hash = 97 * hash + Objects.hashCode(this.__sign_in_count);
		hash = 97 * hash + Objects.hashCode(this.__sign_out_count);
		hash = 97 * hash + Objects.hashCode(this.__training_frequency_one);
		hash = 97 * hash + Objects.hashCode(this.__training_frequency_two);
		hash = 97 * hash + Objects.hashCode(this.__training_frequency_three);
		hash = 97 * hash + Objects.hashCode(this.__training_frequency_four);
		hash = 97 * hash + Objects.hashCode(this.__training_period_one);
		hash = 97 * hash + Objects.hashCode(this.__training_period_two);
		hash = 97 * hash + Objects.hashCode(this.__training_period_three);
		hash = 97 * hash + Objects.hashCode(this.__training_period_four);
		hash = 97 * hash + Objects.hashCode(this.__spare_time_training_one);
		hash = 97 * hash + Objects.hashCode(this.__spare_time_training_two);
		hash = 97 * hash + Objects.hashCode(this.__spare_time_training_three);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseTrainingmanagement o = (BaseTrainingmanagement)obj;
		if(!Objects.equals(this.__training_management_id, o.getTrainingManagementId())) return false;
		if(!Objects.equals(this.__subject, o.getSubject())) return false;
		if(!Objects.equals(this.__compere_type, o.getCompereType())) return false;
		if(!Objects.equals(this.__compere, o.getCompere())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__start_time, o.getStartTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__course_score, o.getCourseScore())) return false;
		if(!Objects.equals(this.__create_person_id, o.getCreatePersonId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__file_manage_id, o.getFileManageId())) return false;
		if(!Objects.equals(this.__avg_score, o.getAvgScore())) return false;
		if(!Objects.equals(this.__sign_in_count, o.getSignInCount())) return false;
		if(!Objects.equals(this.__sign_out_count, o.getSignOutCount())) return false;
		if(!Objects.equals(this.__training_frequency_one, o.getTrainingFrequencyOne())) return false;
		if(!Objects.equals(this.__training_frequency_two, o.getTrainingFrequencyTwo())) return false;
		if(!Objects.equals(this.__training_frequency_three, o.getTrainingFrequencyThree())) return false;
		if(!Objects.equals(this.__training_frequency_four, o.getTrainingFrequencyFour())) return false;
		if(!Objects.equals(this.__training_period_one, o.getTrainingPeriodOne())) return false;
		if(!Objects.equals(this.__training_period_two, o.getTrainingPeriodTwo())) return false;
		if(!Objects.equals(this.__training_period_three, o.getTrainingPeriodThree())) return false;
		if(!Objects.equals(this.__training_period_four, o.getTrainingPeriodFour())) return false;
		if(!Objects.equals(this.__spare_time_training_one, o.getSpareTimeTrainingOne())) return false;
		if(!Objects.equals(this.__spare_time_training_two, o.getSpareTimeTrainingTwo())) return false;
		if(!Objects.equals(this.__spare_time_training_three, o.getSpareTimeTrainingThree())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTrainingManagementId() != null) sb.append(__wrapNumber(count++, "trainingManagementId", getTrainingManagementId()));
		if(getSubject() != null) sb.append(__wrapString(count++, "subject", getSubject()));
		if(getCompereType() != null) sb.append(__wrapNumber(count++, "compereType", getCompereType()));
		if(getCompere() != null) sb.append(__wrapString(count++, "compere", getCompere()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getStartTime() != null) sb.append(__wrapDate(count++, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(count++, "endTime", getEndTime()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCourseScore() != null) sb.append(__wrapNumber(count++, "courseScore", getCourseScore()));
		if(getCreatePersonId() != null) sb.append(__wrapNumber(count++, "createPersonId", getCreatePersonId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getFileManageId() != null) sb.append(__wrapNumber(count++, "fileManageId", getFileManageId()));
		if(getAvgScore() != null) sb.append(__wrapDecimal(count++, "avgScore", getAvgScore()));
		if(getSignInCount() != null) sb.append(__wrapNumber(count++, "signInCount", getSignInCount()));
		if(getSignOutCount() != null) sb.append(__wrapNumber(count++, "signOutCount", getSignOutCount()));
		if(getTrainingFrequencyOne() != null) sb.append(__wrapNumber(count++, "trainingFrequencyOne", getTrainingFrequencyOne()));
		if(getTrainingFrequencyTwo() != null) sb.append(__wrapNumber(count++, "trainingFrequencyTwo", getTrainingFrequencyTwo()));
		if(getTrainingFrequencyThree() != null) sb.append(__wrapNumber(count++, "trainingFrequencyThree", getTrainingFrequencyThree()));
		if(getTrainingFrequencyFour() != null) sb.append(__wrapNumber(count++, "trainingFrequencyFour", getTrainingFrequencyFour()));
		if(getTrainingPeriodOne() != null) sb.append(__wrapNumber(count++, "trainingPeriodOne", getTrainingPeriodOne()));
		if(getTrainingPeriodTwo() != null) sb.append(__wrapNumber(count++, "trainingPeriodTwo", getTrainingPeriodTwo()));
		if(getTrainingPeriodThree() != null) sb.append(__wrapNumber(count++, "trainingPeriodThree", getTrainingPeriodThree()));
		if(getTrainingPeriodFour() != null) sb.append(__wrapNumber(count++, "trainingPeriodFour", getTrainingPeriodFour()));
		if(getSpareTimeTrainingOne() != null) sb.append(__wrapNumber(count++, "spareTimeTrainingOne", getSpareTimeTrainingOne()));
		if(getSpareTimeTrainingTwo() != null) sb.append(__wrapNumber(count++, "spareTimeTrainingTwo", getSpareTimeTrainingTwo()));
		if(getSpareTimeTrainingThree() != null) sb.append(__wrapNumber(count++, "spareTimeTrainingThree", getSpareTimeTrainingThree()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("trainingManagementId")) != null) setTrainingManagementId(__getInt(val)); 
		if((val = values.get("subject")) != null) setSubject(__getString(val));
		if((val = values.get("compereType")) != null) setCompereType(__getInt(val)); 
		if((val = values.get("compere")) != null) setCompere(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("courseScore")) != null) setCourseScore(__getInt(val)); 
		if((val = values.get("createPersonId")) != null) setCreatePersonId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("fileManageId")) != null) setFileManageId(__getInt(val)); 
		if((val = values.get("avgScore")) != null) setAvgScore(__getDecimal(val));  
		if((val = values.get("signInCount")) != null) setSignInCount(__getLong(val)); 
		if((val = values.get("signOutCount")) != null) setSignOutCount(__getLong(val)); 
		if((val = values.get("trainingFrequencyOne")) != null) setTrainingFrequencyOne(__getLong(val)); 
		if((val = values.get("trainingFrequencyTwo")) != null) setTrainingFrequencyTwo(__getLong(val)); 
		if((val = values.get("trainingFrequencyThree")) != null) setTrainingFrequencyThree(__getLong(val)); 
		if((val = values.get("trainingFrequencyFour")) != null) setTrainingFrequencyFour(__getLong(val)); 
		if((val = values.get("trainingPeriodOne")) != null) setTrainingPeriodOne(__getLong(val)); 
		if((val = values.get("trainingPeriodTwo")) != null) setTrainingPeriodTwo(__getLong(val)); 
		if((val = values.get("trainingPeriodThree")) != null) setTrainingPeriodThree(__getLong(val)); 
		if((val = values.get("trainingPeriodFour")) != null) setTrainingPeriodFour(__getLong(val)); 
		if((val = values.get("spareTimeTrainingOne")) != null) setSpareTimeTrainingOne(__getLong(val)); 
		if((val = values.get("spareTimeTrainingTwo")) != null) setSpareTimeTrainingTwo(__getLong(val)); 
		if((val = values.get("spareTimeTrainingThree")) != null) setSpareTimeTrainingThree(__getLong(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val));
	}

	protected java.lang.Integer  __training_management_id ;
	protected java.lang.String  __subject ;
	protected java.lang.Integer  __compere_type ;
	protected java.lang.String  __compere ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __start_time ;
	protected java.util.Date  __end_time ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __course_score ;
	protected java.lang.Integer  __create_person_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __file_manage_id ;
	protected java.math.BigDecimal  __avg_score ;
	protected java.lang.Long  __sign_in_count ;
	protected java.lang.Long  __sign_out_count ;
	protected java.lang.Long  __training_frequency_one ;
	protected java.lang.Long  __training_frequency_two ;
	protected java.lang.Long  __training_frequency_three ;
	protected java.lang.Long  __training_frequency_four ;
	protected java.lang.Long  __training_period_one ;
	protected java.lang.Long  __training_period_two ;
	protected java.lang.Long  __training_period_three ;
	protected java.lang.Long  __training_period_four ;
	protected java.lang.Long  __spare_time_training_one ;
	protected java.lang.Long  __spare_time_training_two ;
	protected java.lang.Long  __spare_time_training_three ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
}
