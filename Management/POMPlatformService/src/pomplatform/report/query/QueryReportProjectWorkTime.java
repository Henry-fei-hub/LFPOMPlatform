package pomplatform.report.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportProjectWorkTime;
import pomplatform.report.bean.ConditionReportProjectWorkTime;

public class QueryReportProjectWorkTime extends AbstractQuery<BaseReportProjectWorkTime, ConditionReportProjectWorkTime>
{

	private static final Logger __logger = Logger.getLogger(QueryReportProjectWorkTime.class);

	public QueryReportProjectWorkTime() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("wh.project_id");
	}

	@Override
	public BaseCollection<BaseReportProjectWorkTime> executeQuery( KeyValuePair[] replacements, ConditionReportProjectWorkTime condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName()
			);
	}

	public BaseCollection<BaseReportProjectWorkTime> runQuery( KeyValuePair[] replacements, ConditionReportProjectWorkTime condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName()
			);
	}

	public BaseCollection<BaseReportProjectWorkTime> execute( KeyValuePair[] replacements, ConditionReportProjectWorkTime condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectCode(), 
				condition.getProjectName()
			);
	}

	@Override
	public BaseReportProjectWorkTime generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportProjectWorkTime __base = new BaseReportProjectWorkTime();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkHour(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectStatisticalWorkHour(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setParticipantNumber(GenericBase.__getLong(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		return count;
	}

	@Override
	public String getSQLText() {
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "SELECT wh.project_id, wh.project_code, wh.project_name, SUM ( work_hour ) work_hour, ( SELECT SUM (( work_hour * coefficient )) AS statistical_work_hour FROM ( SELECT whs.employee_id, SUM ( work_hour ) AS work_hour, ( SELECT coefficient FROM rank_factor_maintenances WHERE rank_id = ( SELECT grade_id FROM employees WHERE employee_id = whs.employee_id )) AS coefficient, COUNT ( DISTINCT ( whs.project_id )) AS project_number FROM working_hours whs WHERE project_id = wh.project_id GROUP BY whs.employee_id ) AS A ) AS project_statistical_work_hour, COUNT ( DISTINCT employee_id ) participant_number FROM working_hours wh WHERE wh.project_code like ? and wh.project_name like ? GROUP BY wh.project_id, wh.project_code, wh.project_name" ;
	private final static String __originalSQL = "SELECT wh.project_id, wh.project_code, wh.project_name, SUM ( work_hour ) work_hour, ( SELECT SUM (( work_hour * coefficient )) AS statistical_work_hour FROM ( SELECT whs.employee_id, SUM ( work_hour ) AS work_hour, ( SELECT coefficient FROM rank_factor_maintenances WHERE rank_id = ( SELECT grade_id FROM employees WHERE employee_id = whs.employee_id )) AS coefficient, COUNT ( DISTINCT ( whs.project_id )) AS project_number FROM working_hours whs WHERE project_id = wh.project_id GROUP BY whs.employee_id ) AS A ) AS project_statistical_work_hour, COUNT ( DISTINCT employee_id ) participant_number FROM working_hours wh WHERE wh.project_code like :project_code AND wh.project_name like :project_name GROUP BY wh.project_id, wh.project_code, wh.project_name";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"wh.project_code like :project_code AND wh.project_name like :project_name\",\"startIndex\": 628,\"stopIndex\":700,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"wh.project_code like :project_code\",\"fullFieldName\":\"wh.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 628,\"stopIndex\":661,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"wh.project_name like :project_name\",\"fullFieldName\":\"wh.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 667,\"stopIndex\":700,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_id,project_code,project_name,work_hour,project_statistical_work_hour,participant_number";
	private final static String[] fieldNames = { "project_code", "project_name"};
}
