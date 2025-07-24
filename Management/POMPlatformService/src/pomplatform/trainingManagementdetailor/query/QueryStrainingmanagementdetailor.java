package pomplatform.trainingManagementdetailor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.trainingManagementdetailor.bean.BaseStrainingmanagementdetailor;
import pomplatform.trainingManagementdetailor.bean.ConditionStrainingmanagementdetailor;

public class QueryStrainingmanagementdetailor extends AbstractQuery<BaseStrainingmanagementdetailor, ConditionStrainingmanagementdetailor>
{

	private static final Logger __logger = Logger.getLogger(QueryStrainingmanagementdetailor.class);

	public QueryStrainingmanagementdetailor() throws java.sql.SQLException 
	{
		setParameterNumber(13);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}

	@Override
	public BaseCollection<BaseStrainingmanagementdetailor> executeQuery( KeyValuePair[] replacements, ConditionStrainingmanagementdetailor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTrainingManagementDetailId(), 
				condition.getTrainingManagementId(), 
				condition.getSignOutFlag(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNumber(), 
				condition.getDepartmentId(), 
				condition.getTrainingContent(), 
				condition.getTrainingMethod(), 
				condition.getTrainingFrequency(), 
				condition.getTrainingPeriod(), 
				condition.getSpareTimeTraining(), 
				condition.getCourseEvaluation(), 
				condition.getGuidingFunction()
			);
	}

	@Override
	public BaseStrainingmanagementdetailor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseStrainingmanagementdetailor __base = new BaseStrainingmanagementdetailor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setTrainingManagementDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTrainingManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignInTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSignOutTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSignOutFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTrainingContent(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTrainingMethod(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTrainingFrequency(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTrainingPeriod(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpareTimeTraining(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSuggest(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCourseEvaluation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGuidingFunction(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
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

	private final static String __SQLText = "SELECT * from training_management_details where training_management_detail_id = ? and training_management_id = ? and sign_out_flag = ? and employee_id = ? and employee_number = ? and department_id = ? and training_content > ? and training_method > ? and training_frequency = ? and training_period = ? and spare_time_training = ? and course_evaluation > ? and guiding_function > ?" ;
	private final static String RESULTSETFIELDLIST = "training_management_detail_id,training_management_id,sign_in_time,sign_out_time,sign_out_flag,employee_id,employee_number,department_id,training_content,training_method,training_frequency,training_period,spare_time_training,suggest,course_evaluation,guiding_function";
	private final static String[] fieldNames = { "training_management_detail_id", "training_management_id", "sign_out_flag", "employee_id", "employee_number", "department_id", "training_content", "training_method", "training_frequency", "training_period", "spare_time_training", "course_evaluation", "guiding_function"};
}
