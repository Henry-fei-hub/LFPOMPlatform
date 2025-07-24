package pomplatform.EmployeeAchieveIntegralReturnRecordByProject.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.EmployeeAchieveIntegralReturnRecordByProject.bean.BaseEmployeeAchieveIntegralReturnRecordByProject;
import pomplatform.EmployeeAchieveIntegralReturnRecordByProject.bean.ConditionEmployeeAchieveIntegralReturnRecordByProject;

public class QueryEmployeeAchieveIntegralReturnRecordByProject extends AbstractQuery<BaseEmployeeAchieveIntegralReturnRecordByProject, ConditionEmployeeAchieveIntegralReturnRecordByProject>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeAchieveIntegralReturnRecordByProject.class);

	public QueryEmployeeAchieveIntegralReturnRecordByProject() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("plate_id");
	}

	@Override
	public BaseCollection<BaseEmployeeAchieveIntegralReturnRecordByProject> executeQuery( KeyValuePair[] replacements, ConditionEmployeeAchieveIntegralReturnRecordByProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getRecordYear(), 
				condition.getRecordMonth(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseEmployeeAchieveIntegralReturnRecordByProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeAchieveIntegralReturnRecordByProject __base = new BaseEmployeeAchieveIntegralReturnRecordByProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select plate_id,project_id,sum(achieve_integral) as achieve_integral from employee_achieve_integral_return_records where plate_id = ? and extract(year from record_date) = ? and extract(month from record_date) = ? and employee_id = ? group by plate_id,project_id order by achieve_integral desc" ;
	private final static String RESULTSETFIELDLIST = "plate_id,project_id,achieve_integral";
	private final static String[] fieldNames = { "plate_id", "record_year", "record_month", "employee_id"};
}
