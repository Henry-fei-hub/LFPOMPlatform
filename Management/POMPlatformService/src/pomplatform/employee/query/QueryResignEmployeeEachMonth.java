package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseResignEmployeeEachMonth;
import pomplatform.employee.bean.ConditionResignEmployeeEachMonth;

public class QueryResignEmployeeEachMonth extends AbstractQuery<BaseResignEmployeeEachMonth, ConditionResignEmployeeEachMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryResignEmployeeEachMonth.class);

	public QueryResignEmployeeEachMonth() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("d.department_id");
	}

	@Override
	public BaseCollection<BaseResignEmployeeEachMonth> executeQuery( KeyValuePair[] replacements, ConditionResignEmployeeEachMonth condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getParentId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getYear()
			);
	}

	public BaseCollection<BaseResignEmployeeEachMonth> runQuery( KeyValuePair[] replacements, ConditionResignEmployeeEachMonth condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getParentId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getYear()
			);
	}

	public BaseCollection<BaseResignEmployeeEachMonth> execute( KeyValuePair[] replacements, ConditionResignEmployeeEachMonth condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getParentId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getYear()
			);
	}

	@Override
	public BaseResignEmployeeEachMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseResignEmployeeEachMonth __base = new BaseResignEmployeeEachMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getLong(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setDouble(count++, GenericBase.__getDouble(args[3]));
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

	private final static String __SQLText = "SELECT d.department_id, CASE WHEN b.end_date IS NULL THEN ( CASE WHEN A.resignation_date IS NULL THEN 0 ELSE EXTRACT ( YEAR FROM A.resignation_date ) END ) ELSE EXTRACT ( YEAR FROM b.end_date ) END AS YEAR, CASE WHEN b.end_date IS NULL THEN ( CASE WHEN A.resignation_date IS NULL THEN 0 ELSE EXTRACT ( MONTH FROM A.resignation_date ) END ) ELSE EXTRACT ( MONTH FROM b.end_date ) END AS MONTH, COUNT ( A.employee_id ) AS amount FROM departments d LEFT JOIN employees A ON d.department_id = A.department_id LEFT JOIN personnel_business b ON A.employee_id = b.employee_id AND b.process_type = 25 AND b.delete_flag = 0 AND b.is_completed = TRUE LEFT JOIN system_process_instances C ON b.personnel_business_id = C.business_id AND b.process_type = C.process_type AND C.delete_flag = 0 AND C.process_status = 3 WHERE A.status = 1 and d.parent_id = ? and A.resignation_date >= ? and A.resignation_date <= ? and EXTRACT ( YEAR FROM A.resignation_date ) >= ? GROUP BY d.department_id, YEAR, MONTH ORDER BY YEAR DESC, MONTH" ;
	private final static String __originalSQL = "SELECT d.department_id, CASE WHEN b.end_date IS NULL THEN ( CASE WHEN A.resignation_date IS NULL THEN 0 ELSE EXTRACT ( YEAR FROM A.resignation_date ) END ) ELSE EXTRACT ( YEAR FROM b.end_date ) END AS YEAR, CASE WHEN b.end_date IS NULL THEN ( CASE WHEN A.resignation_date IS NULL THEN 0 ELSE EXTRACT ( MONTH FROM A.resignation_date ) END ) ELSE EXTRACT ( MONTH FROM b.end_date ) END AS MONTH, COUNT ( A.employee_id ) AS amount FROM departments d LEFT JOIN employees A ON d.department_id = A.department_id LEFT JOIN personnel_business b ON A.employee_id = b.employee_id AND b.process_type = 25 AND b.delete_flag = 0 AND b.is_completed = TRUE LEFT JOIN system_process_instances C ON b.personnel_business_id = C.business_id AND b.process_type = C.process_type AND C.delete_flag = 0 AND C.process_status = 3 WHERE A.status = 1 AND d.parent_id =:parent_id AND A.resignation_date >=:start_date AND A.resignation_date <=:end_date AND EXTRACT ( YEAR FROM A.resignation_date ) >=:year GROUP BY d.department_id, YEAR, MONTH ORDER BY YEAR DESC, MONTH";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.status = 1 AND d.parent_id =:parent_id AND A.resignation_date >=:start_date AND A.resignation_date <=:end_date AND EXTRACT ( YEAR FROM A.resignation_date ) >=:year\",\"startIndex\": 810,\"stopIndex\":974,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.status = 1\",\"nextToken\":\"and\",\"startIndex\": 810,\"stopIndex\":821,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"d.parent_id =:parent_id\",\"fullFieldName\":\"d.parent_id\",\"operationName\":\"=\",\"variableName\":\"parentId\",\"nextToken\":\"and\",\"startIndex\": 827,\"stopIndex\":849,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.resignation_date >=:start_date\",\"fullFieldName\":\"A.resignation_date\",\"operationName\":\">=\",\"variableName\":\"startDate\",\"nextToken\":\"and\",\"startIndex\": 855,\"stopIndex\":886,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.resignation_date <=:end_date\",\"fullFieldName\":\"A.resignation_date\",\"operationName\":\"<=\",\"variableName\":\"endDate\",\"nextToken\":\"and\",\"startIndex\": 892,\"stopIndex\":921,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"EXTRACT ( YEAR FROM A.resignation_date ) >=:year\",\"fullFieldName\":\"EXTRACT ( YEAR FROM A.resignation_date )\",\"operationName\":\">=\",\"variableName\":\"year\",\"startIndex\": 927,\"stopIndex\":974,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "department_id,year,month,amount";
	private final static String[] fieldNames = { "parent_id", "start_date", "end_date", "year"};
}
