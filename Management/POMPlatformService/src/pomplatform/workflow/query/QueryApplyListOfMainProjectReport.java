package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseApplyListOfMainProjectReport;
import pomplatform.workflow.bean.ConditionApplyListOfMainProjectReport;

public class QueryApplyListOfMainProjectReport extends AbstractQuery<BaseApplyListOfMainProjectReport, ConditionApplyListOfMainProjectReport>
{

	private static final Logger __logger = Logger.getLogger(QueryApplyListOfMainProjectReport.class);

	public QueryApplyListOfMainProjectReport() throws java.sql.SQLException 
	{
		setParameterNumber(15);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseApplyListOfMainProjectReport> executeQuery( KeyValuePair[] replacements, ConditionApplyListOfMainProjectReport condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getProjectName(), 
				condition.getProjectType(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getProcessStatus(), 
				condition.getProjectSalesTeam(), 
				condition.getCustomerName(), 
				condition.getProvince(), 
				condition.getCity(), 
				condition.getProjectOrigination(), 
				condition.getIsOperationDepartment(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd()
			);
	}

	public BaseCollection<BaseApplyListOfMainProjectReport> runQuery( KeyValuePair[] replacements, ConditionApplyListOfMainProjectReport condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProcessType(), 
				condition.getProjectName(), 
				condition.getProjectType(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getProcessStatus(), 
				condition.getProjectSalesTeam(), 
				condition.getCustomerName(), 
				condition.getProvince(), 
				condition.getCity(), 
				condition.getProjectOrigination(), 
				condition.getIsOperationDepartment(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd()
			);
	}

	public BaseCollection<BaseApplyListOfMainProjectReport> execute( KeyValuePair[] replacements, ConditionApplyListOfMainProjectReport condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProcessType(), 
				condition.getProjectName(), 
				condition.getProjectType(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getProcessStatus(), 
				condition.getProjectSalesTeam(), 
				condition.getCustomerName(), 
				condition.getProvince(), 
				condition.getCity(), 
				condition.getProjectOrigination(), 
				condition.getIsOperationDepartment(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd()
			);
	}

	@Override
	public BaseApplyListOfMainProjectReport generateBase(Object[] __data) throws java.sql.SQLException {
		BaseApplyListOfMainProjectReport __base = new BaseApplyListOfMainProjectReport();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsWarehous(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsApplyQuote(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsModifyProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.employee_id, p.project_name, p.province, p.city, p.project_type, p.customer_name, p.project_origination, p.contact_name, p.contact_phone, p.detail_address, p.total_building_areas, p.client_id, C.customer_type, C.is_warehous, C.is_apply_quote, p.info_code, p.customer_contact_id, p.main_project_id, p.main_project_stage_id, p.is_modify_project, p.project_code FROM system_process_instances spi LEFT JOIN main_projects p ON spi.business_id = p.main_project_id LEFT JOIN pre_projects mp on mp.info_code = p.info_code LEFT JOIN customers C ON p.client_id = C.customer_id WHERE spi.process_type = ? and spi.process_status IN ( 0, 1 ) and p.project_name like ? and p.project_type = ? and spi.create_time between ? and ? and spi.employee_id = ? and spi.process_status = ? and p.project_sales_team = ? and p.customer_name like ? and p.province = ? and p.city = ? and p.project_origination = ? and mp.is_operation_department = ? and spi.create_time between ? and ? ORDER BY spi.create_time" ;
	private final static String __originalSQL = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.employee_id, p.project_name, p.province, p.city, p.project_type, p.customer_name, p.project_origination, p.contact_name, p.contact_phone, p.detail_address, p.total_building_areas, p.client_id, C.customer_type, C.is_warehous, C.is_apply_quote, p.info_code, p.customer_contact_id, p.main_project_id, p.main_project_stage_id, p.is_modify_project, p.project_code FROM system_process_instances spi LEFT JOIN main_projects p ON spi.business_id = p.main_project_id LEFT JOIN pre_projects mp on mp.info_code = p.info_code LEFT JOIN customers C ON p.client_id = C.customer_id WHERE spi.process_type =:process_type AND spi.process_status IN ( 0, 1 ) AND p.project_name LIKE :project_name AND p.project_type =:project_type AND spi.create_time BETWEEN :start_date AND :end_date AND spi.employee_id =:employee_id AND spi.process_status =:process_status AND p.project_sales_team =:project_sales_team AND p.customer_name LIKE :customer_name AND p.province =:province AND p.city =:city AND p.project_origination =:project_origination AND mp.is_operation_department =:is_operation_department AND spi.create_time BETWEEN :create_time_start AND :create_time_end ORDER BY spi.create_time";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spi.process_type =:process_type AND spi.process_status IN ( 0, 1 ) AND p.project_name LIKE :project_name AND p.project_type =:project_type AND spi.create_time BETWEEN :start_date AND :end_date AND spi.employee_id =:employee_id AND spi.process_status =:process_status AND p.project_sales_team =:project_sales_team AND p.customer_name LIKE :customer_name AND p.province =:province AND p.city =:city AND p.project_origination =:project_origination AND mp.is_operation_department =:is_operation_department AND spi.create_time BETWEEN :create_time_start AND :create_time_end\",\"startIndex\": 769,\"stopIndex\":1337,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type =:process_type\",\"fullFieldName\":\"spi.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"startIndex\": 769,\"stopIndex\":799,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status IN ( 0, 1 )\",\"startIndex\": 805,\"stopIndex\":834,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.project_name LIKE :project_name\",\"fullFieldName\":\"p.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 840,\"stopIndex\":872,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.project_type =:project_type\",\"fullFieldName\":\"p.project_type\",\"operationName\":\"=\",\"variableName\":\"projectType\",\"startIndex\": 878,\"stopIndex\":906,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.create_time BETWEEN :start_date AND :end_date\",\"fullFieldName\":\"spi.create_time\",\"operationName\":\"between\",\"variableName\":\"startDate\",\"secondName\":\"endDate\",\"startIndex\": 912,\"stopIndex\":960,\"variableNum\": 3,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.employee_id =:employee_id\",\"fullFieldName\":\"spi.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 966,\"stopIndex\":994,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status =:process_status\",\"fullFieldName\":\"spi.process_status\",\"operationName\":\"=\",\"variableName\":\"processStatus\",\"startIndex\": 1000,\"stopIndex\":1034,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.project_sales_team =:project_sales_team\",\"fullFieldName\":\"p.project_sales_team\",\"operationName\":\"=\",\"variableName\":\"projectSalesTeam\",\"startIndex\": 1040,\"stopIndex\":1080,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.customer_name LIKE :customer_name\",\"fullFieldName\":\"p.customer_name\",\"operationName\":\"like\",\"variableName\":\"customerName\",\"startIndex\": 1086,\"stopIndex\":1120,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.province =:province\",\"fullFieldName\":\"p.province\",\"operationName\":\"=\",\"variableName\":\"province\",\"startIndex\": 1126,\"stopIndex\":1146,\"variableNum\": 9,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.city =:city\",\"fullFieldName\":\"p.city\",\"operationName\":\"=\",\"variableName\":\"city\",\"startIndex\": 1152,\"stopIndex\":1164,\"variableNum\": 10,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.project_origination =:project_origination\",\"fullFieldName\":\"p.project_origination\",\"operationName\":\"=\",\"variableName\":\"projectOrigination\",\"startIndex\": 1170,\"stopIndex\":1212,\"variableNum\": 11,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.is_operation_department =:is_operation_department\",\"fullFieldName\":\"mp.is_operation_department\",\"operationName\":\"=\",\"variableName\":\"isOperationDepartment\",\"startIndex\": 1218,\"stopIndex\":1269,\"variableNum\": 12,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.create_time BETWEEN :create_time_start AND :create_time_end\",\"fullFieldName\":\"spi.create_time\",\"operationName\":\"between\",\"variableName\":\"createTimeStart\",\"secondName\":\"createTimeEnd\",\"startIndex\": 1275,\"stopIndex\":1337,\"variableNum\": 13,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,employee_id,project_name,province,city,project_type,customer_name,project_origination,contact_name,contact_phone,detail_address,total_building_areas,client_id,customer_type,is_warehous,is_apply_quote,info_code,customer_contact_id,main_project_id,main_project_stage_id,is_modify_project,project_code";
	private final static String[] fieldNames = { "process_type", "project_name", "project_type", "start_date", "end_date", "employee_id", "process_status", "project_sales_team", "customer_name", "province", "city", "project_origination", "is_operation_department", "create_time_start", "create_time_end"};
}
