package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseOnLoadFlowAuditListOfMainProjectBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowAuditListOfMainProjectBuisnessData;

public class QueryOnLoadFlowAuditListOfMainProjectBuisnessData extends AbstractQuery<BaseOnLoadFlowAuditListOfMainProjectBuisnessData, ConditionOnLoadFlowAuditListOfMainProjectBuisnessData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadFlowAuditListOfMainProjectBuisnessData.class);

	public QueryOnLoadFlowAuditListOfMainProjectBuisnessData() throws java.sql.SQLException 
	{
		setParameterNumber(20);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spt.process_type_name");
	}

	@Override
	public BaseCollection<BaseOnLoadFlowAuditListOfMainProjectBuisnessData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadFlowAuditListOfMainProjectBuisnessData condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProcessStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getProjectName(), 
				condition.getProjectType(), 
				condition.getProjectSalesTeam(), 
				condition.getCustomerName(), 
				condition.getProvince(), 
				condition.getCity(), 
				condition.getProjectOrigination(), 
				condition.getIsOperationDepartment(), 
				condition.getApplyEmployeeId(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd()
			);
	}

	public BaseCollection<BaseOnLoadFlowAuditListOfMainProjectBuisnessData> runQuery( KeyValuePair[] replacements, ConditionOnLoadFlowAuditListOfMainProjectBuisnessData condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProcessStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getProjectName(), 
				condition.getProjectType(), 
				condition.getProjectSalesTeam(), 
				condition.getCustomerName(), 
				condition.getProvince(), 
				condition.getCity(), 
				condition.getProjectOrigination(), 
				condition.getIsOperationDepartment(), 
				condition.getApplyEmployeeId(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd()
			);
	}

	public BaseCollection<BaseOnLoadFlowAuditListOfMainProjectBuisnessData> execute( KeyValuePair[] replacements, ConditionOnLoadFlowAuditListOfMainProjectBuisnessData condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProcessStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getProjectName(), 
				condition.getProjectType(), 
				condition.getProjectSalesTeam(), 
				condition.getCustomerName(), 
				condition.getProvince(), 
				condition.getCity(), 
				condition.getProjectOrigination(), 
				condition.getIsOperationDepartment(), 
				condition.getApplyEmployeeId(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd()
			);
	}

	@Override
	public BaseOnLoadFlowAuditListOfMainProjectBuisnessData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadFlowAuditListOfMainProjectBuisnessData __base = new BaseOnLoadFlowAuditListOfMainProjectBuisnessData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessPooledTaskId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTypeFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectNameOne(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsWarehous(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsApplyQuote(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsModifyProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[18]));
		if(args[19] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[19]));
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

	private final static String __SQLText = "SELECT spt.process_type_name, sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, P.project_name, CASE WHEN P.project_name = mp.project_name_one THEN '' ELSE mp.project_name_one END project_name_one, mp.province, mp.city, mp.project_type, mp.customer_name, mp.project_origination, mp.contact_name, mp.contact_phone, mp.detail_address, mp.total_building_areas, spi.employee_id as apply_employee_id, C.customer_type, C.is_warehous, C.is_apply_quote, mp.info_code, mp.customer_contact_id, spia.process_type, P.main_project_id, P.main_project_stage_id, P.is_modify_project, P.project_code FROM system_process_instance_activities AS spia LEFT JOIN main_projects P ON spia.business_id = P.main_project_id LEFT JOIN pre_projects mp ON mp.info_code = P.info_code LEFT JOIN customers C ON mp.client_id = C.customer_id LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id WHERE spia.activity_type IN ( 2, 3 ) and spi.process_status = ? and spi.delete_flag = 0 and spt.parent_process_type_id = 38 and ( (( (( (( (spia.employee_id > 0 and sppt.process_pooled_task_id IS NULL and spia.employee_id = ? and spia.status = ?) )) ) or ( (( (spia.employee_id > 0 and sppt.process_pooled_task_id > 0 and spia.employee_id = ? and sppt.employee_id = ? and sppt.status = ?) )) ) or ( (( (spia.employee_id IS NULL and sppt.employee_id = ? and sppt.status = ?) )) )) )) ) and spia.process_type = ? and mp.project_name like ? and mp.project_type = ? and mp.project_sales_team = ? and mp.customer_name like ? and mp.province = ? and mp.city = ? and mp.project_origination = ? and mp.is_operation_department = ? and mp.apply_employee_id = ? and mp.create_time between ? and ? ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT spt.process_type_name, sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, P.project_name, CASE WHEN P.project_name = mp.project_name_one THEN '' ELSE mp.project_name_one END project_name_one, mp.province, mp.city, mp.project_type, mp.customer_name, mp.project_origination, mp.contact_name, mp.contact_phone, mp.detail_address, mp.total_building_areas, spi.employee_id as apply_employee_id, C.customer_type, C.is_warehous, C.is_apply_quote, mp.info_code, mp.customer_contact_id, spia.process_type, P.main_project_id, P.main_project_stage_id, P.is_modify_project, P.project_code FROM system_process_instance_activities AS spia LEFT JOIN main_projects P ON spia.business_id = P.main_project_id LEFT JOIN pre_projects mp ON mp.info_code = P.info_code LEFT JOIN customers C ON mp.client_id = C.customer_id LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id WHERE spia.activity_type IN ( 2, 3 ) AND spi.process_status =:process_status AND spi.delete_flag = 0 AND spt.parent_process_type_id = 38 AND ( ( ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) ) OR ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) OR ( ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) ) ) AND spia.process_type =:process_type AND mp.project_name LIKE :project_name AND mp.project_type =:project_type AND mp.project_sales_team =:project_sales_team AND mp.customer_name LIKE :customer_name AND mp.province =:province AND mp.city =:city AND mp.project_origination =:project_origination AND mp.is_operation_department =:is_operation_department AND mp.apply_employee_id =:apply_employee_id AND mp.create_time BETWEEN :create_time_start AND :create_time_end ORDER BY spia.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spia.activity_type IN ( 2, 3 ) AND spi.process_status =:process_status AND spi.delete_flag = 0 AND spt.parent_process_type_id = 38 AND ( ( ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) ) OR ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) OR ( ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) ) ) AND spia.process_type =:process_type AND mp.project_name LIKE :project_name AND mp.project_type =:project_type AND mp.project_sales_team =:project_sales_team AND mp.customer_name LIKE :customer_name AND mp.province =:province AND mp.city =:city AND mp.project_origination =:project_origination AND mp.is_operation_department =:is_operation_department AND mp.apply_employee_id =:apply_employee_id AND mp.create_time BETWEEN :create_time_start AND :create_time_end\",\"startIndex\": 1589,\"stopIndex\":2581,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.activity_type IN ( 2, 3 )\",\"nextToken\":\"and\",\"startIndex\": 1589,\"stopIndex\":1618,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status =:process_status\",\"fullFieldName\":\"spi.process_status\",\"operationName\":\"=\",\"variableName\":\"processStatus\",\"nextToken\":\"and\",\"startIndex\": 1624,\"stopIndex\":1658,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 1664,\"stopIndex\":1682,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spt.parent_process_type_id = 38\",\"nextToken\":\"and\",\"startIndex\": 1688,\"stopIndex\":1718,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"( ( ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) ) OR ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) OR ( ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) ) )\",\"nextToken\":\"and\",\"startIndex\": 1724,\"stopIndex\":2118,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"( ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) ) OR ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) OR ( ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) )\",\"startIndex\": 1726,\"stopIndex\":2116,\"variableNum\": 0,\"variableCount\": 0,\"isor\":true,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) )\",\"nextToken\":\"or\",\"startIndex\": 1728,\"stopIndex\":1855,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status )\",\"startIndex\": 1730,\"stopIndex\":1853,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.employee_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1732,\"stopIndex\":1751,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"sppt.process_pooled_task_id IS NULL\",\"nextToken\":\"and\",\"startIndex\": 1757,\"stopIndex\":1791,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.employee_id =:employee_id\",\"fullFieldName\":\"spia.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1797,\"stopIndex\":1826,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.status =:status\",\"fullFieldName\":\"spia.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1832,\"stopIndex\":1851,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"( ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) )\",\"nextToken\":\"or\",\"startIndex\": 1860,\"stopIndex\":2018,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status )\",\"startIndex\": 1862,\"stopIndex\":2016,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.employee_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1864,\"stopIndex\":1883,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"sppt.process_pooled_task_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1889,\"stopIndex\":1919,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.employee_id =:employee_id\",\"fullFieldName\":\"spia.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1925,\"stopIndex\":1954,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.employee_id =:employee_id\",\"fullFieldName\":\"sppt.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1960,\"stopIndex\":1989,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.status =:status\",\"fullFieldName\":\"sppt.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1995,\"stopIndex\":2014,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"( ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) )\",\"startIndex\": 2023,\"stopIndex\":2114,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status )\",\"startIndex\": 2025,\"stopIndex\":2112,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.employee_id IS NULL\",\"nextToken\":\"and\",\"startIndex\": 2027,\"stopIndex\":2050,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"sppt.employee_id =:employee_id\",\"fullFieldName\":\"sppt.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 2056,\"stopIndex\":2085,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.status =:status\",\"fullFieldName\":\"sppt.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 2091,\"stopIndex\":2110,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]}]}]},{\"fullCondition\": \"spia.process_type =:process_type\",\"fullFieldName\":\"spia.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 2124,\"stopIndex\":2155,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_name LIKE :project_name\",\"fullFieldName\":\"mp.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"nextToken\":\"and\",\"startIndex\": 2161,\"stopIndex\":2194,\"variableNum\": 9,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_type =:project_type\",\"fullFieldName\":\"mp.project_type\",\"operationName\":\"=\",\"variableName\":\"projectType\",\"nextToken\":\"and\",\"startIndex\": 2200,\"stopIndex\":2229,\"variableNum\": 10,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_sales_team =:project_sales_team\",\"fullFieldName\":\"mp.project_sales_team\",\"operationName\":\"=\",\"variableName\":\"projectSalesTeam\",\"nextToken\":\"and\",\"startIndex\": 2235,\"stopIndex\":2276,\"variableNum\": 11,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.customer_name LIKE :customer_name\",\"fullFieldName\":\"mp.customer_name\",\"operationName\":\"like\",\"variableName\":\"customerName\",\"nextToken\":\"and\",\"startIndex\": 2282,\"stopIndex\":2317,\"variableNum\": 12,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.province =:province\",\"fullFieldName\":\"mp.province\",\"operationName\":\"=\",\"variableName\":\"province\",\"nextToken\":\"and\",\"startIndex\": 2323,\"stopIndex\":2344,\"variableNum\": 13,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.city =:city\",\"fullFieldName\":\"mp.city\",\"operationName\":\"=\",\"variableName\":\"city\",\"nextToken\":\"and\",\"startIndex\": 2350,\"stopIndex\":2363,\"variableNum\": 14,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_origination =:project_origination\",\"fullFieldName\":\"mp.project_origination\",\"operationName\":\"=\",\"variableName\":\"projectOrigination\",\"nextToken\":\"and\",\"startIndex\": 2369,\"stopIndex\":2412,\"variableNum\": 15,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.is_operation_department =:is_operation_department\",\"fullFieldName\":\"mp.is_operation_department\",\"operationName\":\"=\",\"variableName\":\"isOperationDepartment\",\"nextToken\":\"and\",\"startIndex\": 2418,\"stopIndex\":2469,\"variableNum\": 16,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.apply_employee_id =:apply_employee_id\",\"fullFieldName\":\"mp.apply_employee_id\",\"operationName\":\"=\",\"variableName\":\"applyEmployeeId\",\"nextToken\":\"and\",\"startIndex\": 2475,\"stopIndex\":2514,\"variableNum\": 17,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.create_time BETWEEN :create_time_start AND :create_time_end\",\"fullFieldName\":\"mp.create_time\",\"operationName\":\"between\",\"variableName\":\"createTimeStart\",\"secondName\":\"createTimeEnd\",\"startIndex\": 2520,\"stopIndex\":2581,\"variableNum\": 18,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_type_name,process_pooled_task_id,type_flag,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,project_name,project_name_one,province,city,project_type,customer_name,project_origination,contact_name,contact_phone,detail_address,total_building_areas,apply_employee_id,customer_type,is_warehous,is_apply_quote,info_code,customer_contact_id,process_type,main_project_id,main_project_stage_id,is_modify_project,project_code";
	private final static String[] fieldNames = { "process_status", "employee_id", "status", "employee_id", "employee_id", "status", "employee_id", "status", "process_type", "project_name", "project_type", "project_sales_team", "customer_name", "province", "city", "project_origination", "is_operation_department", "apply_employee_id", "create_time_start", "create_time_end"};
}
