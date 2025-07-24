package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseUsedVacationLeave;
import pomplatform.workflow.personnelbusiness.bean.ConditionUsedVacationLeave;

public class QueryUsedVacationLeave extends AbstractQuery<BaseUsedVacationLeave, ConditionUsedVacationLeave>
{

	private static final Logger __logger = Logger.getLogger(QueryUsedVacationLeave.class);

	public QueryUsedVacationLeave() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.personnel_business_id");
	}

	@Override
	public BaseCollection<BaseUsedVacationLeave> executeQuery( KeyValuePair[] replacements, ConditionUsedVacationLeave condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStartYear(), 
				condition.getStartMonth(), 
				condition.getEndMonth()
			);
	}

	public BaseCollection<BaseUsedVacationLeave> runQuery( KeyValuePair[] replacements, ConditionUsedVacationLeave condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStartYear(), 
				condition.getStartMonth(), 
				condition.getEndMonth()
			);
	}

	public BaseCollection<BaseUsedVacationLeave> execute( KeyValuePair[] replacements, ConditionUsedVacationLeave condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getEmployeeId(), 
				condition.getStartYear(), 
				condition.getStartMonth(), 
				condition.getEndMonth()
			);
	}

	@Override
	public BaseUsedVacationLeave generateBase(Object[] __data) throws java.sql.SQLException {
		BaseUsedVacationLeave __base = new BaseUsedVacationLeave();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUsed(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select a.personnel_business_id,a.employee_id,a.used from (SELECT personnel_business_id, employee_id, sum(days * 7) + sum(hours) as used FROM personnel_business WHERE employee_id = ? and process_type = 13 and type = 21 and delete_flag = 0 and EXTRACT(YEAR from start_date) = ? and EXTRACT(MONTH from start_date) >= ? and EXTRACT(MONTH from start_date) <= ? GROUP BY employee_id,personnel_business_id) as a left join system_process_instances spi on spi.business_id = a.personnel_business_id and spi.process_type = 13 where spi.process_status in (0,1,3,4)" ;
	private final static String __originalSQL = "select a.personnel_business_id,a.employee_id,a.used from (SELECT personnel_business_id, employee_id, sum(days * 7) + sum(hours) as used FROM personnel_business WHERE employee_id =:employee_id and process_type = 13 and type = 21 and delete_flag = 0 and EXTRACT(YEAR from start_date) = :start_year and EXTRACT(MONTH from start_date) >= :start_month and EXTRACT(MONTH from start_date) <= :end_month GROUP BY employee_id,personnel_business_id) as a left join system_process_instances spi on spi.business_id = a.personnel_business_id and spi.process_type = 13 where spi.process_status in (0,1,3,4)";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"employee_id =:employee_id and process_type = 13 and type = 21 and delete_flag = 0 and EXTRACT(YEAR from start_date) = :start_year and EXTRACT(MONTH from start_date) >= :start_month and EXTRACT(MONTH from start_date) <= :end_month\",\"startIndex\": 166,\"stopIndex\":394,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"employee_id =:employee_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 166,\"stopIndex\":190,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"process_type = 13\",\"nextToken\":\"and\",\"startIndex\": 196,\"stopIndex\":212,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"type = 21\",\"nextToken\":\"and\",\"startIndex\": 218,\"stopIndex\":226,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 232,\"stopIndex\":246,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"EXTRACT(YEAR from start_date) = :start_year\",\"fullFieldName\":\"EXTRACT(YEAR from start_date)\",\"operationName\":\"=\",\"variableName\":\"startYear\",\"nextToken\":\"and\",\"startIndex\": 252,\"stopIndex\":294,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"EXTRACT(MONTH from start_date) >= :start_month\",\"fullFieldName\":\"EXTRACT(MONTH from start_date)\",\"operationName\":\">=\",\"variableName\":\"startMonth\",\"nextToken\":\"and\",\"startIndex\": 300,\"stopIndex\":345,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"EXTRACT(MONTH from start_date) <= :end_month\",\"fullFieldName\":\"EXTRACT(MONTH from start_date)\",\"operationName\":\"<=\",\"variableName\":\"endMonth\",\"startIndex\": 351,\"stopIndex\":394,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "personnel_business_id,employee_id,used";
	private final static String[] fieldNames = { "employee_id", "start_year", "start_month", "end_month"};
}
