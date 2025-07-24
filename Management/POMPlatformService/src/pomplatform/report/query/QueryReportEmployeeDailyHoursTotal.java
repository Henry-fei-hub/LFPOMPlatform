package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportEmployeeDailyHoursTotal;
import pomplatform.report.bean.ConditionReportEmployeeDailyHoursTotal;

public class QueryReportEmployeeDailyHoursTotal extends AbstractQuery<BaseReportEmployeeDailyHoursTotal, ConditionReportEmployeeDailyHoursTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryReportEmployeeDailyHoursTotal.class);

	public QueryReportEmployeeDailyHoursTotal() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .employee_id");
	}

	@Override
	public BaseCollection<BaseReportEmployeeDailyHoursTotal> executeQuery( KeyValuePair[] replacements, ConditionReportEmployeeDailyHoursTotal condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getStartWorkDate(), 
				condition.getEndWorkDate()
			);
	}

	public BaseCollection<BaseReportEmployeeDailyHoursTotal> runQuery( KeyValuePair[] replacements, ConditionReportEmployeeDailyHoursTotal condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getStartWorkDate(), 
				condition.getEndWorkDate()
			);
	}

	public BaseCollection<BaseReportEmployeeDailyHoursTotal> execute( KeyValuePair[] replacements, ConditionReportEmployeeDailyHoursTotal condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getStartWorkDate(), 
				condition.getEndWorkDate()
			);
	}

	@Override
	public BaseReportEmployeeDailyHoursTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportEmployeeDailyHoursTotal __base = new BaseReportEmployeeDailyHoursTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWorkHour(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCoefficient(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatisticalWorkHour(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectNumber(GenericBase.__getLong(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
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

	private final static String __SQLText = "SELECT A .employee_id, A.employee_no, A.employee_name, A.plate_id, A.work_date, A.work_hour, A.coefficient, ( work_hour * coefficient ) AS statistical_work_hour, A.project_number FROM ( SELECT wh.employee_id, wh.employee_no, wh.employee_name, wh.plate_id, wh.work_date, SUM ( work_hour ) AS work_hour, ( SELECT coefficient FROM rank_factor_maintenances WHERE rank_id = ( SELECT grade_id FROM employees WHERE employee_id = wh.employee_id )) AS coefficient, COUNT ( DISTINCT ( wh.project_id )) AS project_number FROM working_hours wh GROUP BY wh.employee_id, wh.employee_no, wh.employee_name, wh.plate_id, wh.work_date ORDER BY wh.work_date DESC ) AS A WHERE A.employee_no = ? and A.employee_name = ? and A.work_date between ? and ? GROUP BY A.employee_id, A.employee_no, A.employee_name, A.plate_id, A.work_date, A.work_hour, A.coefficient, A.project_number" ;
	private final static String __originalSQL = "SELECT A .employee_id, A.employee_no, A.employee_name, A.plate_id, A.work_date, A.work_hour, A.coefficient, ( work_hour * coefficient ) AS statistical_work_hour, A.project_number FROM ( SELECT wh.employee_id, wh.employee_no, wh.employee_name, wh.plate_id, wh.work_date, SUM ( work_hour ) AS work_hour, ( SELECT coefficient FROM rank_factor_maintenances WHERE rank_id = ( SELECT grade_id FROM employees WHERE employee_id = wh.employee_id )) AS coefficient, COUNT ( DISTINCT ( wh.project_id )) AS project_number FROM working_hours wh GROUP BY wh.employee_id, wh.employee_no, wh.employee_name, wh.plate_id, wh.work_date ORDER BY wh.work_date DESC ) AS A WHERE A.employee_no =:employee_no AND A.employee_name =:employee_name AND A.work_date BETWEEN :start_work_date AND :end_work_date GROUP BY A.employee_id, A.employee_no, A.employee_name, A.plate_id, A.work_date, A.work_hour, A.coefficient, A.project_number";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.employee_no =:employee_no AND A.employee_name =:employee_name AND A.work_date BETWEEN :start_work_date AND :end_work_date\",\"startIndex\": 657,\"stopIndex\":779,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.employee_no =:employee_no\",\"fullFieldName\":\"A.employee_no\",\"operationName\":\"=\",\"variableName\":\"employeeNo\",\"nextToken\":\"and\",\"startIndex\": 657,\"stopIndex\":683,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.employee_name =:employee_name\",\"fullFieldName\":\"A.employee_name\",\"operationName\":\"=\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 689,\"stopIndex\":719,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.work_date BETWEEN :start_work_date AND :end_work_date\",\"fullFieldName\":\"A.work_date\",\"operationName\":\"between\",\"variableName\":\"startWorkDate\",\"secondName\":\"endWorkDate\",\"startIndex\": 725,\"stopIndex\":779,\"variableNum\": 2,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,plate_id,work_date,work_hour,coefficient,statistical_work_hour,project_number";
	private final static String[] fieldNames = { "employee_no", "employee_name", "start_work_date", "end_work_date"};
}
