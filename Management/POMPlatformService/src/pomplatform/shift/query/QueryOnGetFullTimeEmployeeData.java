package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnGetFullTimeEmployeeData;
import pomplatform.shift.bean.ConditionOnGetFullTimeEmployeeData;

public class QueryOnGetFullTimeEmployeeData extends AbstractQuery<BaseOnGetFullTimeEmployeeData, ConditionOnGetFullTimeEmployeeData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnGetFullTimeEmployeeData.class);

	public QueryOnGetFullTimeEmployeeData() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .employee_id");
	}

	@Override
	public BaseCollection<BaseOnGetFullTimeEmployeeData> executeQuery( KeyValuePair[] replacements, ConditionOnGetFullTimeEmployeeData condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getYear()
			);
	}

	public BaseCollection<BaseOnGetFullTimeEmployeeData> runQuery( KeyValuePair[] replacements, ConditionOnGetFullTimeEmployeeData condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getYear()
			);
	}

	public BaseCollection<BaseOnGetFullTimeEmployeeData> execute( KeyValuePair[] replacements, ConditionOnGetFullTimeEmployeeData condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getYear()
			);
	}

	@Override
	public BaseOnGetFullTimeEmployeeData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnGetFullTimeEmployeeData __base = new BaseOnGetFullTimeEmployeeData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFullTimeNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFullTimeMonths(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT A .employee_id, A.YEAR, e.employee_no, e.employee_name, d.department_name, COUNT ( A.employee_id ) AS full_time_num, array_to_string( ARRAY_AGG ( A.MONTH ORDER BY A.MONTH ), '、' ) AS full_time_months FROM employee_month_checks A LEFT JOIN employees e ON A.employee_id = e.employee_id LEFT JOIN departments d ON e.department_id = d.department_id WHERE YEAR = ? and is_full_time = TRUE GROUP BY A.employee_id, A.YEAR, e.employee_no, e.employee_name, d.department_name ORDER BY A.employee_id" ;
	private final static String __originalSQL = "SELECT A .employee_id, A.YEAR, e.employee_no, e.employee_name, d.department_name, COUNT ( A.employee_id ) AS full_time_num, array_to_string( ARRAY_AGG ( A.MONTH ORDER BY A.MONTH ), '、' ) AS full_time_months FROM employee_month_checks A LEFT JOIN employees e ON A.employee_id = e.employee_id LEFT JOIN departments d ON e.department_id = d.department_id WHERE YEAR = :year AND is_full_time = TRUE GROUP BY A.employee_id, A.YEAR, e.employee_no, e.employee_name, d.department_name ORDER BY A.employee_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"YEAR = :year AND is_full_time = TRUE\",\"startIndex\": 358,\"stopIndex\":393,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"YEAR = :year\",\"fullFieldName\":\"YEAR\",\"operationName\":\"=\",\"variableName\":\"year\",\"nextToken\":\"and\",\"startIndex\": 358,\"stopIndex\":369,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"is_full_time = TRUE\",\"startIndex\": 375,\"stopIndex\":393,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,year,employee_no,employee_name,department_name,full_time_num,full_time_months";
	private final static String[] fieldNames = { "year"};
}
