package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseUpdateActivityEmployee;
import pomplatform.workflow.bean.ConditionUpdateActivityEmployee;

public class QueryUpdateActivityEmployee extends AbstractQuery<BaseUpdateActivityEmployee, ConditionUpdateActivityEmployee>
{

	private static final Logger __logger = Logger.getLogger(QueryUpdateActivityEmployee.class);

	public QueryUpdateActivityEmployee() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.process_type");
	}

	@Override
	public BaseCollection<BaseUpdateActivityEmployee> executeQuery( KeyValuePair[] replacements, ConditionUpdateActivityEmployee condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getDrafter(), 
				condition.getEmployeeId(), 
				condition.getBusinessName(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd(), 
				condition.getProcessType(), 
				condition.getDrafter(), 
				condition.getEmployeeId(), 
				condition.getBusinessName(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd()
			);
	}

	public BaseCollection<BaseUpdateActivityEmployee> runQuery( KeyValuePair[] replacements, ConditionUpdateActivityEmployee condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProcessType(), 
				condition.getDrafter(), 
				condition.getEmployeeId(), 
				condition.getBusinessName(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd(), 
				condition.getProcessType(), 
				condition.getDrafter(), 
				condition.getEmployeeId(), 
				condition.getBusinessName(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd()
			);
	}

	public BaseCollection<BaseUpdateActivityEmployee> execute( KeyValuePair[] replacements, ConditionUpdateActivityEmployee condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProcessType(), 
				condition.getDrafter(), 
				condition.getEmployeeId(), 
				condition.getBusinessName(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd(), 
				condition.getProcessType(), 
				condition.getDrafter(), 
				condition.getEmployeeId(), 
				condition.getBusinessName(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd()
			);
	}

	@Override
	public BaseUpdateActivityEmployee generateBase(Object[] __data) throws java.sql.SQLException {
		BaseUpdateActivityEmployee __base = new BaseUpdateActivityEmployee();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[10]));
		if(args[11] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[11]));
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

	private final static String __SQLText = "(select b.process_type, b.process_id, b.process_instance_id, b.business_id, b.employee_id as drafter, a.employee_id, b.business_name, b.create_time, a.status, a.process_instance_activity_id as node_id, 1 as node_type from system_process_instance_activities a LEFT JOIN system_process_instances b on a.process_instance_id = b.process_instance_id where a.employee_id is not null and b.process_type = ? and b.employee_id = ? and a.employee_id = ? and b.business_name like ? and b.create_time >= ? and b.create_time <= ? and b.process_status in (0, 1) and b.delete_flag = 0 and a.status in (0, 1)) union all (select b.process_type, b.process_id, b.process_instance_id, b.business_id, b.employee_id as drafter, a.employee_id, b.business_name, b.create_time, a.status, a.process_pooled_task_id as node_id, 2 as node_type from system_process_pooled_tasks a LEFT JOIN system_process_instances b on a.process_instance_id = b.process_instance_id where b.process_type = ? and b.employee_id = ? and a.employee_id = ? and b.business_name like ? and b.create_time >= ? and b.create_time <= ? and b.process_status in (0, 1) and b.delete_flag = 0 and a.status in (0, 1)) order by process_type, employee_id, create_time" ;
	private final static String __originalSQL = "(select b.process_type, b.process_id, b.process_instance_id, b.business_id, b.employee_id as drafter, a.employee_id, b.business_name, b.create_time, a.status, a.process_instance_activity_id as node_id, 1 as node_type from system_process_instance_activities a LEFT JOIN system_process_instances b on a.process_instance_id = b.process_instance_id where a.employee_id is not null and b.process_type = :process_type and b.employee_id = :drafter and a.employee_id = :employee_id and b.business_name like :business_name and b.create_time >= :create_time_start and b.create_time <= :create_time_end and b.process_status in (0, 1) and b.delete_flag = 0 and a.status in (0, 1)) union all (select b.process_type, b.process_id, b.process_instance_id, b.business_id, b.employee_id as drafter, a.employee_id, b.business_name, b.create_time, a.status, a.process_pooled_task_id as node_id, 2 as node_type from system_process_pooled_tasks a LEFT JOIN system_process_instances b on a.process_instance_id = b.process_instance_id where b.process_type = :process_type and b.employee_id = :drafter and a.employee_id = :employee_id and b.business_name like :business_name and b.create_time >= :create_time_start and b.create_time <= :create_time_end and b.process_status in (0, 1) and b.delete_flag = 0 and a.status in (0, 1)) order by process_type, employee_id, create_time";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"a.employee_id is not null and b.process_type = :process_type and b.employee_id = :drafter and a.employee_id = :employee_id and b.business_name like :business_name and b.create_time >= :create_time_start and b.create_time <= :create_time_end and b.process_status in (0, 1) and b.delete_flag = 0 and a.status in (0, 1)\",\"startIndex\": 351,\"stopIndex\":666,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"a.employee_id is not null\",\"nextToken\":\"and\",\"startIndex\": 351,\"stopIndex\":375,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.process_type = :process_type\",\"fullFieldName\":\"b.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 381,\"stopIndex\":410,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_id = :drafter\",\"fullFieldName\":\"b.employee_id\",\"operationName\":\"=\",\"variableName\":\"drafter\",\"nextToken\":\"and\",\"startIndex\": 416,\"stopIndex\":439,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.employee_id = :employee_id\",\"fullFieldName\":\"a.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 445,\"stopIndex\":472,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.business_name like :business_name\",\"fullFieldName\":\"b.business_name\",\"operationName\":\"like\",\"variableName\":\"businessName\",\"nextToken\":\"and\",\"startIndex\": 478,\"stopIndex\":512,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.create_time >= :create_time_start\",\"fullFieldName\":\"b.create_time\",\"operationName\":\">=\",\"variableName\":\"createTimeStart\",\"nextToken\":\"and\",\"startIndex\": 518,\"stopIndex\":552,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.create_time <= :create_time_end\",\"fullFieldName\":\"b.create_time\",\"operationName\":\"<=\",\"variableName\":\"createTimeEnd\",\"nextToken\":\"and\",\"startIndex\": 558,\"stopIndex\":590,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.process_status in (0, 1)\",\"nextToken\":\"and\",\"startIndex\": 596,\"stopIndex\":621,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 627,\"stopIndex\":643,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.status in (0, 1)\",\"startIndex\": 649,\"stopIndex\":666,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"b.process_type = :process_type and b.employee_id = :drafter and a.employee_id = :employee_id and b.business_name like :business_name and b.create_time >= :create_time_start and b.create_time <= :create_time_end and b.process_status in (0, 1) and b.delete_flag = 0 and a.status in (0, 1)\",\"startIndex\": 1017,\"stopIndex\":1302,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"b.process_type = :process_type\",\"fullFieldName\":\"b.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 1017,\"stopIndex\":1046,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_id = :drafter\",\"fullFieldName\":\"b.employee_id\",\"operationName\":\"=\",\"variableName\":\"drafter\",\"nextToken\":\"and\",\"startIndex\": 1052,\"stopIndex\":1075,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.employee_id = :employee_id\",\"fullFieldName\":\"a.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1081,\"stopIndex\":1108,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.business_name like :business_name\",\"fullFieldName\":\"b.business_name\",\"operationName\":\"like\",\"variableName\":\"businessName\",\"nextToken\":\"and\",\"startIndex\": 1114,\"stopIndex\":1148,\"variableNum\": 9,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.create_time >= :create_time_start\",\"fullFieldName\":\"b.create_time\",\"operationName\":\">=\",\"variableName\":\"createTimeStart\",\"nextToken\":\"and\",\"startIndex\": 1154,\"stopIndex\":1188,\"variableNum\": 10,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.create_time <= :create_time_end\",\"fullFieldName\":\"b.create_time\",\"operationName\":\"<=\",\"variableName\":\"createTimeEnd\",\"nextToken\":\"and\",\"startIndex\": 1194,\"stopIndex\":1226,\"variableNum\": 11,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.process_status in (0, 1)\",\"nextToken\":\"and\",\"startIndex\": 1232,\"stopIndex\":1257,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 1263,\"stopIndex\":1279,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"a.status in (0, 1)\",\"startIndex\": 1285,\"stopIndex\":1302,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_type,process_id,process_instance_id,business_id,drafter,employee_id,business_name,create_time,status,node_id,node_type";
	private final static String[] fieldNames = { "process_type", "drafter", "employee_id", "business_name", "create_time_start", "create_time_end", "process_type", "drafter", "employee_id", "business_name", "create_time_start", "create_time_end"};
}
