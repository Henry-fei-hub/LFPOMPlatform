package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnLoadEmployeeCheckTime;
import pomplatform.shift.bean.ConditionOnLoadEmployeeCheckTime;

public class QueryOnLoadEmployeeCheckTime extends AbstractQuery<BaseOnLoadEmployeeCheckTime, ConditionOnLoadEmployeeCheckTime>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadEmployeeCheckTime.class);

	public QueryOnLoadEmployeeCheckTime() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadEmployeeCheckTime> executeQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeeCheckTime condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getRecordDate(), 
				condition.getEmployeeId(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	public BaseCollection<BaseOnLoadEmployeeCheckTime> runQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeeCheckTime condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getRecordDate(), 
				condition.getEmployeeId(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	public BaseCollection<BaseOnLoadEmployeeCheckTime> execute( KeyValuePair[] replacements, ConditionOnLoadEmployeeCheckTime condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getRecordDate(), 
				condition.getEmployeeId(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseOnLoadEmployeeCheckTime generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadEmployeeCheckTime __base = new BaseOnLoadEmployeeCheckTime();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCheckinTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckoutTime(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
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

	private final static String __SQLText = "SELECT employee_id, MIN ( check_time ) AS checkin_time, MAX ( check_time ) AS checkout_time FROM employee_checkinout_details WHERE check_date = ? and employee_id = ? and check_time between ? and ? GROUP BY employee_id ORDER BY employee_id" ;
	private final static String __originalSQL = "SELECT employee_id, MIN ( check_time ) AS checkin_time, MAX ( check_time ) AS checkout_time FROM employee_checkinout_details WHERE check_date = :record_date AND employee_id = :employee_id AND check_time BETWEEN :start_time AND :end_time GROUP BY employee_id ORDER BY employee_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"check_date = :record_date AND employee_id = :employee_id AND check_time BETWEEN :start_time AND :end_time\",\"startIndex\": 131,\"stopIndex\":235,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"check_date = :record_date\",\"fullFieldName\":\"check_date\",\"operationName\":\"=\",\"variableName\":\"recordDate\",\"nextToken\":\"and\",\"startIndex\": 131,\"stopIndex\":155,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"employee_id = :employee_id\",\"fullFieldName\":\"employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 161,\"stopIndex\":186,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"check_time BETWEEN :start_time AND :end_time\",\"fullFieldName\":\"check_time\",\"operationName\":\"between\",\"variableName\":\"startTime\",\"secondName\":\"endTime\",\"startIndex\": 192,\"stopIndex\":235,\"variableNum\": 2,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,checkin_time,checkout_time";
	private final static String[] fieldNames = { "record_date", "employee_id", "start_time", "end_time"};
}
