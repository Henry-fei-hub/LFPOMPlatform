package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseDownloadResignEmployees;
import pomplatform.employee.bean.ConditionDownloadResignEmployees;

public class QueryDownloadResignEmployees extends AbstractQuery<BaseDownloadResignEmployees, ConditionDownloadResignEmployees>
{

	private static final Logger __logger = Logger.getLogger(QueryDownloadResignEmployees.class);

	public QueryDownloadResignEmployees() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("d.parent_id");
	}

	@Override
	public BaseCollection<BaseDownloadResignEmployees> executeQuery( KeyValuePair[] replacements, ConditionDownloadResignEmployees condition ) throws java.sql.SQLException {
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

	public BaseCollection<BaseDownloadResignEmployees> runQuery( KeyValuePair[] replacements, ConditionDownloadResignEmployees condition ) throws java.sql.SQLException {
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

	public BaseCollection<BaseDownloadResignEmployees> execute( KeyValuePair[] replacements, ConditionDownloadResignEmployees condition ) throws java.sql.SQLException {
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
	public BaseDownloadResignEmployees generateBase(Object[] __data) throws java.sql.SQLException {
		BaseDownloadResignEmployees __base = new BaseDownloadResignEmployees();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setResignDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT d.parent_id, A.employee_id, CASE WHEN b.end_date IS NULL THEN A.resignation_date ELSE b.end_date END AS resign_date, b.reason, A.department_id, A.duty_id FROM departments d LEFT JOIN employees A ON d.department_id = A.department_id LEFT JOIN personnel_business b ON A.employee_id = b.employee_id AND b.process_type = 25 AND b.delete_flag = 0 AND b.is_completed = TRUE LEFT JOIN system_process_instances C ON b.personnel_business_id = C.business_id AND b.process_type = C.process_type AND C.delete_flag = 0 AND C.process_status = 3 WHERE A.status = 1 and d.parent_id = ? and A.resignation_date >= ? and A.resignation_date <= ? and EXTRACT ( YEAR FROM A.resignation_date ) >= ? ORDER BY resign_date, d.parent_id" ;
	private final static String __originalSQL = "SELECT d.parent_id, A.employee_id, CASE WHEN b.end_date IS NULL THEN A.resignation_date ELSE b.end_date END AS resign_date, b.reason, A.department_id, A.duty_id FROM departments d LEFT JOIN employees A ON d.department_id = A.department_id LEFT JOIN personnel_business b ON A.employee_id = b.employee_id AND b.process_type = 25 AND b.delete_flag = 0 AND b.is_completed = TRUE LEFT JOIN system_process_instances C ON b.personnel_business_id = C.business_id AND b.process_type = C.process_type AND C.delete_flag = 0 AND C.process_status = 3 WHERE A.status = 1 AND d.parent_id =:parent_id AND A.resignation_date >=:start_date AND A.resignation_date <=:end_date AND EXTRACT ( YEAR FROM A.resignation_date ) >=:year ORDER BY resign_date, d.parent_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.status = 1 AND d.parent_id =:parent_id AND A.resignation_date >=:start_date AND A.resignation_date <=:end_date AND EXTRACT ( YEAR FROM A.resignation_date ) >=:year\",\"startIndex\": 544,\"stopIndex\":708,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.status = 1\",\"nextToken\":\"and\",\"startIndex\": 544,\"stopIndex\":555,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"d.parent_id =:parent_id\",\"fullFieldName\":\"d.parent_id\",\"operationName\":\"=\",\"variableName\":\"parentId\",\"nextToken\":\"and\",\"startIndex\": 561,\"stopIndex\":583,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.resignation_date >=:start_date\",\"fullFieldName\":\"A.resignation_date\",\"operationName\":\">=\",\"variableName\":\"startDate\",\"nextToken\":\"and\",\"startIndex\": 589,\"stopIndex\":620,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.resignation_date <=:end_date\",\"fullFieldName\":\"A.resignation_date\",\"operationName\":\"<=\",\"variableName\":\"endDate\",\"nextToken\":\"and\",\"startIndex\": 626,\"stopIndex\":655,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"EXTRACT ( YEAR FROM A.resignation_date ) >=:year\",\"fullFieldName\":\"EXTRACT ( YEAR FROM A.resignation_date )\",\"operationName\":\">=\",\"variableName\":\"year\",\"startIndex\": 661,\"stopIndex\":708,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "parent_id,employee_id,resign_date,reason,department_id,duty_id";
	private final static String[] fieldNames = { "parent_id", "start_date", "end_date", "year"};
}
