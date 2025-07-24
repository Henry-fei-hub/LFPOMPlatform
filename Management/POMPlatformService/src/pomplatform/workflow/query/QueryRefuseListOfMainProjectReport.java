package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseRefuseListOfMainProjectReport;
import pomplatform.workflow.bean.ConditionRefuseListOfMainProjectReport;

public class QueryRefuseListOfMainProjectReport extends AbstractQuery<BaseRefuseListOfMainProjectReport, ConditionRefuseListOfMainProjectReport>
{

	private static final Logger __logger = Logger.getLogger(QueryRefuseListOfMainProjectReport.class);

	public QueryRefuseListOfMainProjectReport() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseRefuseListOfMainProjectReport> executeQuery( KeyValuePair[] replacements, ConditionRefuseListOfMainProjectReport condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getProcessStatus(), 
				condition.getProjectName(), 
				condition.getProjectType(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseRefuseListOfMainProjectReport> runQuery( KeyValuePair[] replacements, ConditionRefuseListOfMainProjectReport condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProcessType(), 
				condition.getProcessStatus(), 
				condition.getProjectName(), 
				condition.getProjectType(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseRefuseListOfMainProjectReport> execute( KeyValuePair[] replacements, ConditionRefuseListOfMainProjectReport condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProcessType(), 
				condition.getProcessStatus(), 
				condition.getProjectName(), 
				condition.getProjectType(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseRefuseListOfMainProjectReport generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRefuseListOfMainProjectReport __base = new BaseRefuseListOfMainProjectReport();
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
		if((val = __data[count++]) != null) __base.setProjectNameOne(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsWarehous(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsApplyQuote(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsModifyProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setMainProjectStageId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.employee_id, P.project_name, CASE WHEN mp.project_name = mp.project_name_one THEN '' ELSE mp.project_name_one END project_name_one, P.province, P.city, P.project_type, P.customer_name, P.project_origination, P.contact_name, P.contact_phone, P.detail_address, P.total_building_areas, C.customer_type, C.is_warehous, C.is_apply_quote, P.info_code, P.main_project_id, P.is_modify_project, P.main_project_stage_id, P.project_code FROM system_process_instances spi LEFT JOIN main_projects P ON spi.business_id = P.main_project_id LEFT JOIN pre_projects mp ON P.info_code = mp.info_code LEFT JOIN customers C ON P.client_id = C.customer_id WHERE spi.process_type = ? and spi.process_status = ? and spi.process_status in (3,5) and spi.delete_flag = 0 and P.project_name like ? and P.project_type = ? and spi.create_time between ? and ? and spi.employee_id = ? ORDER BY spi.create_time desc" ;
	private final static String __originalSQL = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.employee_id, P.project_name, CASE WHEN mp.project_name = mp.project_name_one THEN '' ELSE mp.project_name_one END project_name_one, P.province, P.city, P.project_type, P.customer_name, P.project_origination, P.contact_name, P.contact_phone, P.detail_address, P.total_building_areas, C.customer_type, C.is_warehous, C.is_apply_quote, P.info_code, P.main_project_id, P.is_modify_project, P.main_project_stage_id, P.project_code FROM system_process_instances spi LEFT JOIN main_projects P ON spi.business_id = P.main_project_id LEFT JOIN pre_projects mp ON P.info_code = mp.info_code LEFT JOIN customers C ON P.client_id = C.customer_id WHERE spi.process_type =:process_type AND spi.process_status =:process_status AND spi.process_status in (3,5) AND spi.delete_flag = 0 AND P.project_name LIKE :project_name AND P.project_type =:project_type AND spi.create_time BETWEEN :start_date AND :end_date AND spi.employee_id =:employee_id ORDER BY spi.create_time desc";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spi.process_type =:process_type AND spi.process_status =:process_status AND spi.process_status in (3,5) AND spi.delete_flag = 0 AND P.project_name LIKE :project_name AND P.project_type =:project_type AND spi.create_time BETWEEN :start_date AND :end_date AND spi.employee_id =:employee_id\",\"startIndex\": 836,\"stopIndex\":1122,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type =:process_type\",\"fullFieldName\":\"spi.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"startIndex\": 836,\"stopIndex\":866,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status =:process_status\",\"fullFieldName\":\"spi.process_status\",\"operationName\":\"=\",\"variableName\":\"processStatus\",\"startIndex\": 872,\"stopIndex\":906,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status in (3,5)\",\"startIndex\": 912,\"stopIndex\":938,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.delete_flag = 0\",\"startIndex\": 944,\"stopIndex\":962,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_name LIKE :project_name\",\"fullFieldName\":\"P.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 968,\"stopIndex\":1000,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_type =:project_type\",\"fullFieldName\":\"P.project_type\",\"operationName\":\"=\",\"variableName\":\"projectType\",\"startIndex\": 1006,\"stopIndex\":1034,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.create_time BETWEEN :start_date AND :end_date\",\"fullFieldName\":\"spi.create_time\",\"operationName\":\"between\",\"variableName\":\"startDate\",\"secondName\":\"endDate\",\"startIndex\": 1040,\"stopIndex\":1088,\"variableNum\": 4,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.employee_id =:employee_id\",\"fullFieldName\":\"spi.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 1094,\"stopIndex\":1122,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,employee_id,project_name,project_name_one,province,city,project_type,customer_name,project_origination,contact_name,contact_phone,detail_address,total_building_areas,customer_type,is_warehous,is_apply_quote,info_code,main_project_id,is_modify_project,main_project_stage_id,project_code";
	private final static String[] fieldNames = { "process_type", "process_status", "project_name", "project_type", "start_date", "end_date", "employee_id"};
//	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.employee_id, p.project_name, CASE WHEN mp.project_name = mp.project_name_one THEN '' ELSE mp.project_name_one END project_name_one, p.province, p.city, p.project_type, p.customer_name, p.project_origination, p.contact_name, p.contact_phone, p.detail_address, p.total_building_areas, C.customer_type, C.is_warehous, C.is_apply_quote, p.info_code, p.main_project_id, p.is_modify_project, p.main_project_stage_id, p.project_code FROM system_process_instances spi LEFT JOIN main_projects p ON spi.business_id = p.main_project_id LEFT JOIN pre_projects mp ON p.info_code = mp.info_code LEFT JOIN customers C ON p.client_id = C.customer_id WHERE spi.process_type = ? and spi.process_status = ? and spi.process_status IN ( 3, 5 ) and spi.delete_flag = 0 and p.project_name like ? and p.project_type = ? and spi.create_time between ? and ? and spi.employee_id = ? ORDER BY spi.create_time" ;
//	private final static String __originalSQL = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.employee_id, p.project_name, CASE WHEN mp.project_name = mp.project_name_one THEN '' ELSE mp.project_name_one END project_name_one, p.province, p.city, p.project_type, p.customer_name, p.project_origination, p.contact_name, p.contact_phone, p.detail_address, p.total_building_areas, C.customer_type, C.is_warehous, C.is_apply_quote, p.info_code, p.main_project_id, p.is_modify_project, p.main_project_stage_id, p.project_code FROM system_process_instances spi LEFT JOIN main_projects p ON spi.business_id = p.main_project_id LEFT JOIN pre_projects mp ON p.info_code = mp.info_code LEFT JOIN customers C ON p.client_id = C.customer_id WHERE spi.process_type =:process_type AND spi.process_status =:process_status AND spi.process_status IN ( 3, 5 ) AND spi.delete_flag = 0 AND p.project_name LIKE :project_name AND p.project_type =:project_type AND spi.create_time BETWEEN :start_date AND :end_date AND spi.employee_id =:employee_id ORDER BY spi.create_time";
//	private final static String[] __queryConditions = {
//		"[{\"fullCondition\": \"spi.process_type =:process_type AND spi.process_status =:process_status AND spi.delete_flag = 0 AND p.project_name LIKE :project_name AND p.project_type =:project_type AND spi.create_time BETWEEN :start_date AND :end_date AND spi.employee_id =:employee_id\",\"startIndex\": 836,\"stopIndex\":1090,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type =:process_type\",\"fullFieldName\":\"spi.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"startIndex\": 836,\"stopIndex\":866,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status =:process_status\",\"fullFieldName\":\"spi.process_status\",\"operationName\":\"=\",\"variableName\":\"processStatus\",\"startIndex\": 872,\"stopIndex\":906,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.delete_flag = 0\",\"startIndex\": 912,\"stopIndex\":930,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.project_name LIKE :project_name\",\"fullFieldName\":\"p.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 936,\"stopIndex\":968,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.project_type =:project_type\",\"fullFieldName\":\"p.project_type\",\"operationName\":\"=\",\"variableName\":\"projectType\",\"startIndex\": 974,\"stopIndex\":1002,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.create_time BETWEEN :start_date AND :end_date\",\"fullFieldName\":\"spi.create_time\",\"operationName\":\"between\",\"variableName\":\"startDate\",\"secondName\":\"endDate\",\"startIndex\": 1008,\"stopIndex\":1056,\"variableNum\": 4,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.employee_id =:employee_id\",\"fullFieldName\":\"spi.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 1062,\"stopIndex\":1090,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
//	};
//	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,employee_id,project_name,project_name_one,province,city,project_type,customer_name,project_origination,contact_name,contact_phone,detail_address,total_building_areas,customer_type,is_warehous,is_apply_quote,info_code,main_project_id,is_modify_project,main_project_stage_id,project_code";
//	private final static String[] fieldNames = { "process_type", "process_status", "project_name", "project_type", "start_date", "end_date", "employee_id"};
}
