package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadEmployeeAccountByBusinessTypeData;
import pomplatform.account.bean.ConditionOnLoadEmployeeAccountByBusinessTypeData;

public class QueryOnLoadEmployeeAccountByBusinessTypeData extends AbstractQuery<BaseOnLoadEmployeeAccountByBusinessTypeData, ConditionOnLoadEmployeeAccountByBusinessTypeData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadEmployeeAccountByBusinessTypeData.class);

	public QueryOnLoadEmployeeAccountByBusinessTypeData() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadEmployeeAccountByBusinessTypeData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeeAccountByBusinessTypeData condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId(), 
				condition.getPlateId()
			);
	}

	public BaseCollection<BaseOnLoadEmployeeAccountByBusinessTypeData> runQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeeAccountByBusinessTypeData condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId(), 
				condition.getPlateId()
			);
	}

	public BaseCollection<BaseOnLoadEmployeeAccountByBusinessTypeData> execute( KeyValuePair[] replacements, ConditionOnLoadEmployeeAccountByBusinessTypeData condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnLoadEmployeeAccountByBusinessTypeData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadEmployeeAccountByBusinessTypeData __base = new BaseOnLoadEmployeeAccountByBusinessTypeData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountIntegral(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
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

	private final static String __SQLText = "SELECT b.employee_id,b.employee_no,b.employee_name,b.plate_id,b.duty_id,b.gender,A.business_type_id,d.parent_id,SUM(A.integral) AS account_integral FROM employees b LEFT JOIN employee_account_records A ON b.employee_id = A.employee_id and A.record_date between ? and ? LEFT JOIN employee_day_plate_records C ON b.employee_id = C.employee_id AND A.record_date = C.record_date LEFT JOIN system_dictionary d ON dic_type_id = 66 AND A.business_type_id = d.dic_type_value_id WHERE b.plate_id = ? and C.plate_id = ? GROUP BY b.employee_id,b.employee_no,b.employee_name,b.plate_id,b.duty_id,b.gender,A.business_type_id,d.parent_id" ;
	private final static String __originalSQL = "SELECT b.employee_id,b.employee_no,b.employee_name,b.plate_id,b.duty_id,b.gender,A.business_type_id,d.parent_id,SUM(A.integral) AS account_integral FROM employees b LEFT JOIN employee_account_records A ON b.employee_id = A.employee_id AND A.record_date BETWEEN :start_date AND :end_date LEFT JOIN employee_day_plate_records C ON b.employee_id = C.employee_id AND A.record_date = C.record_date LEFT JOIN system_dictionary d ON dic_type_id = 66 AND A.business_type_id = d.dic_type_value_id WHERE b.plate_id = :plate_id AND C.plate_id = :plate_id GROUP BY b.employee_id,b.employee_no,b.employee_name,b.plate_id,b.duty_id,b.gender,A.business_type_id,d.parent_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"b.employee_id = A.employee_id AND A.record_date BETWEEN :start_date AND :end_date\",\"startIndex\": 205,\"stopIndex\":285,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"b.employee_id = A.employee_id\",\"nextToken\":\"and\",\"startIndex\": 205,\"stopIndex\":233,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.record_date BETWEEN :start_date AND :end_date\",\"fullFieldName\":\"A.record_date\",\"operationName\":\"between\",\"variableName\":\"startDate\",\"secondName\":\"endDate\",\"startIndex\": 239,\"stopIndex\":285,\"variableNum\": 0,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"b.plate_id = :plate_id AND C.plate_id = :plate_id\",\"startIndex\": 494,\"stopIndex\":542,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"b.plate_id = :plate_id\",\"fullFieldName\":\"b.plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"nextToken\":\"and\",\"startIndex\": 494,\"stopIndex\":515,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"C.plate_id = :plate_id\",\"fullFieldName\":\"C.plate_id\",\"operationName\":\"=\",\"variableName\":\"plateId\",\"startIndex\": 521,\"stopIndex\":542,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,plate_id,duty_id,gender,business_type_id,parent_id,account_integral";
	private final static String[] fieldNames = { "start_date", "end_date", "plate_id", "plate_id"};
}
