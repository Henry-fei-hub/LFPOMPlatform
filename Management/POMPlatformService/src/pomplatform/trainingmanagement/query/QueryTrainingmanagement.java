package pomplatform.trainingmanagement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.trainingmanagement.bean.BaseTrainingmanagement;
import pomplatform.trainingmanagement.bean.ConditionTrainingmanagement;

public class QueryTrainingmanagement extends AbstractQuery<BaseTrainingmanagement, ConditionTrainingmanagement>
{

	private static final Logger __logger = Logger.getLogger(QueryTrainingmanagement.class);

	public QueryTrainingmanagement() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("tm.training_management_id");
	}

	@Override
	public BaseCollection<BaseTrainingmanagement> executeQuery( KeyValuePair[] replacements, ConditionTrainingmanagement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTrainingManagementId(), 
				condition.getSubject(), 
				condition.getCreateTime(), 
				condition.getDepartmentId(), 
				condition.getCreatePersonId(), 
				condition.getEmployeeId(), 
				condition.getCourseScore(), 
				condition.getCompere(),
				condition.getYear(), 
				condition.getMonth(),
				condition.getStartTime(),
				condition.getEndTime()

			);
	}

	@Override
	public BaseTrainingmanagement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTrainingmanagement __base = new BaseTrainingmanagement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setTrainingManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubject(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompereType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompere(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCourseScore(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreatePersonId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAvgScore(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSignInCount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSignOutCount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTrainingFrequencyOne(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTrainingFrequencyTwo(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTrainingFrequencyThree(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTrainingFrequencyFour(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTrainingPeriodOne(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTrainingPeriodTwo(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTrainingPeriodThree(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTrainingPeriodFour(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSpareTimeTrainingOne(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSpareTimeTrainingTwo(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSpareTimeTrainingThree(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, java.lang.Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[10]));
		if(args[11] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[11]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "SELECT tm.training_management_id, tm.subject, tm.compere_type, tm.compere, tm.create_time, tm.start_time, tm.end_time, tm.department_id, tm.course_score, tm.create_person_id, tm.employee_id, tm.file_manage_id, avg_score, sign_in_count, sign_out_count, training_frequency_one, training_frequency_two, training_frequency_three, training_frequency_four, training_period_one, training_period_two, training_period_three, training_period_four, spare_time_training_one, spare_time_training_two, COALESCE(spare_time_training_three, 0) AS spare_time_training_three, date_part('year', tm.start_time) as year , date_part('month', tm.start_time) as month FROM training_managements tm LEFT JOIN ( SELECT training_management_id, ((avg(tmd.training_content)+avg(tmd.training_method)+avg(tmd.course_evaluation)+avg(tmd.guiding_function)))/4 As avg_score, COUNT(1) As sign_in_count, COUNT(tmd.sign_out_flag = 0 OR NULL) As sign_out_count, COUNT(tmd.training_frequency = 1 OR NULL) AS training_frequency_one, COUNT(tmd.training_frequency = 2 OR NULL) AS training_frequency_two, COUNT(tmd.training_frequency = 3 OR NULL) As training_frequency_three, COUNT(tmd.training_frequency = 4 OR NULL) As training_frequency_four, COUNT(tmd.training_period = 1 OR NULL) As training_period_one, COUNT(tmd.training_period = 2 OR NULL) As training_period_two, COUNT(tmd.training_period = 3 OR NULL) As training_period_three, COUNT(tmd.training_period = 4 OR NULL) As training_period_four, COUNT(tmd.spare_time_training = 1 OR NULL) As spare_time_training_one, COUNT(tmd.spare_time_training = 2 OR NULL) As spare_time_training_two, COUNT(tmd.spare_time_training = 3 OR NULL) As spare_time_training_three FROM training_management_details tmd GROUP BY training_management_id ) tmd on tm.training_management_id = tmd.training_management_id where tm.training_management_id = ? and tm.subject like ? and tm.create_time > ? and tm.department_id = ? and tm.create_person_id = ? and tm.employee_id = ? and tm.course_score > ? and tm.compere like ? and date_part('year', tm.start_time)=? and date_part('month', tm.start_time)=? and tm.start_time>=? and tm.start_time<=?  order by tm.training_management_id asc" ;
	private final static String RESULTSETFIELDLIST = "training_management_id,subject,compere_type,compere,create_time,start_time,end_time,department_id,course_score,create_person_id,employee_id,file_manage_id,avg_score,sign_in_count,sign_out_count,training_frequency_one,training_frequency_two,training_frequency_three,training_frequency_four,training_period_one,training_period_two,training_period_three,training_period_four,spare_time_training_one,spare_time_training_two,spare_time_training_three,year,month";
	private final static String[] fieldNames = { "training_management_id", "subject", "create_time", "department_id", "create_person_id", "employee_id", "course_score", "compere","year", "month","start_time","end_time"};
}
