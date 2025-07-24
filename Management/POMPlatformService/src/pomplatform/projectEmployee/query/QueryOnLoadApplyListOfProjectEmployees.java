package pomplatform.projectEmployee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectEmployee.bean.BaseOnLoadApplyListOfProjectEmployees;
import pomplatform.projectEmployee.bean.ConditionOnLoadApplyListOfProjectEmployees;

public class QueryOnLoadApplyListOfProjectEmployees extends AbstractQuery<BaseOnLoadApplyListOfProjectEmployees, ConditionOnLoadApplyListOfProjectEmployees>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfProjectEmployees.class);

	public QueryOnLoadApplyListOfProjectEmployees() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfProjectEmployees> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProjectEmployees condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadApplyListOfProjectEmployees> runQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProjectEmployees condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadApplyListOfProjectEmployees> execute( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProjectEmployees condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	@Override
	public BaseOnLoadApplyListOfProjectEmployees generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfProjectEmployees __base = new BaseOnLoadApplyListOfProjectEmployees();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.process_type, pb.personnel_business_id, pb.employee_id, pb.project_id, p.project_code, p.project_name, p.total_amount, p.project_integral, p.reserve_integral FROM system_process_instances spi LEFT JOIN personnel_business pb ON spi.business_id = pb.personnel_business_id left join projects p on p.project_id = pb.project_id WHERE spi.process_type = 79 and spi.process_status IN ( 0, 1 ) and spi.employee_id = ? and p.project_name like ? and p.project_code like ? ORDER BY spi.create_time DESC" ;
	private final static String __originalSQL = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.process_type, pb.personnel_business_id, pb.employee_id, pb.project_id, p.project_code, p.project_name, p.total_amount, p.project_integral, p.reserve_integral FROM system_process_instances spi LEFT JOIN personnel_business pb ON spi.business_id = pb.personnel_business_id left join projects p on p.project_id = pb.project_id WHERE spi.process_type = 79 AND spi.process_status IN ( 0, 1 ) AND spi.employee_id =:employee_id AND p.project_name LIKE :project_name AND p.project_code LIKE :project_code ORDER BY spi.create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spi.process_type = 79 AND spi.process_status IN ( 0, 1 ) AND spi.employee_id =:employee_id AND p.project_name LIKE :project_name AND p.project_code LIKE :project_code\",\"startIndex\": 507,\"stopIndex\":672,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type = 79\",\"startIndex\": 507,\"stopIndex\":527,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status IN ( 0, 1 )\",\"startIndex\": 533,\"stopIndex\":562,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.employee_id =:employee_id\",\"fullFieldName\":\"spi.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 568,\"stopIndex\":596,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.project_name LIKE :project_name\",\"fullFieldName\":\"p.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 602,\"stopIndex\":634,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.project_code LIKE :project_code\",\"fullFieldName\":\"p.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 640,\"stopIndex\":672,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,process_type,personnel_business_id,employee_id,project_id,project_code,project_name,total_amount,project_integral,reserve_integral";
	private final static String[] fieldNames = { "employee_id", "project_name", "project_code"};
}
