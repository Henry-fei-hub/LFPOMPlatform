package pomplatform.workflow.professional.query;

import org.apache.log4j.Logger;
import java.util.Map;
import java.util.List;
import delicacy.common.CommonUtils;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.professional.bean.BaseOnLoadAuditListOfProfessionalApproval;
import pomplatform.workflow.professional.bean.ConditionOnLoadAuditListOfProfessionalApproval;

public class QueryOnLoadAuditListOfProfessionalApproval extends AbstractQuery<BaseOnLoadAuditListOfProfessionalApproval, ConditionOnLoadAuditListOfProfessionalApproval>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAuditListOfProfessionalApproval.class);

	public QueryOnLoadAuditListOfProfessionalApproval() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("process_type_name");
	}

	public static BaseCollection<BaseOnLoadAuditListOfProfessionalApproval> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseOnLoadAuditListOfProfessionalApproval> select(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionOnLoadAuditListOfProfessionalApproval c = new ConditionOnLoadAuditListOfProfessionalApproval();
		c.setDataFromMap(params);
		QueryOnLoadAuditListOfProfessionalApproval dao = new QueryOnLoadAuditListOfProfessionalApproval();
		return dao.runQuery(replacements, c);
	}


	public static List<BaseOnLoadAuditListOfProfessionalApproval> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseOnLoadAuditListOfProfessionalApproval> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionOnLoadAuditListOfProfessionalApproval c = new ConditionOnLoadAuditListOfProfessionalApproval();
		c.setDataFromMap(params);
		QueryOnLoadAuditListOfProfessionalApproval dao = new QueryOnLoadAuditListOfProfessionalApproval();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseOnLoadAuditListOfProfessionalApproval> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAuditListOfProfessionalApproval condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus()
			);
	}

	public BaseCollection<BaseOnLoadAuditListOfProfessionalApproval> runQuery( KeyValuePair[] replacements, ConditionOnLoadAuditListOfProfessionalApproval condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProcessType(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus()
			);
	}

	public BaseCollection<BaseOnLoadAuditListOfProfessionalApproval> execute( KeyValuePair[] replacements, ConditionOnLoadAuditListOfProfessionalApproval condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProcessType(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseOnLoadAuditListOfProfessionalApproval generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAuditListOfProfessionalApproval __base = new BaseOnLoadAuditListOfProfessionalApproval();
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
		if((val = __data[count++]) != null) __base.setProfessionalApproval_id(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectManageDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCommonArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLogisticsArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCadArea(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEmpStatus(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "SELECT spt.process_type_name,sppt.process_pooled_task_id,CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag,spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, A.professional_approval__id, A.employee_id, A.employee_no, A.start_date, A.delete_flag, A.project_id, A.project_code, A.project_name, A.contract_id, A.contract_code, A.contract_name, A.plate_id, A.design_type, A.project_type, A.plate_manager_id, A.project_level, A.department_manager_id, A.project_manage_id, A.project_manage_name, A.project_manage_department_id, A.common_area, A.logistics_area, A.cad_area, A.total_integral, A.project_integral, A.reserve_integral, A.percentage, b.status AS emp_status FROM system_process_instance_activities spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id LEFT JOIN professional_approval A ON spia.business_id = A.professional_approval__id LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spia.process_type = ? and A.delete_flag = 0 and spi.delete_flag = 0 and spia.activity_type IN ( 2, 3 ) and b.employee_name like ? and A.employee_no like ? and A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) and ((sppt.process_pooled_task_id IS NULL and spia.employee_id = ? and 1 = 1 and spia.status = ?) or (sppt.process_pooled_task_id > 0 and (sppt.employee_id = ?) and 2 = 2 and sppt.status = ?)) ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT spt.process_type_name,sppt.process_pooled_task_id,CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag,spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, A.professional_approval__id, A.employee_id, A.employee_no, A.start_date, A.delete_flag, A.project_id, A.project_code, A.project_name, A.contract_id, A.contract_code, A.contract_name, A.plate_id, A.design_type, A.project_type, A.plate_manager_id, A.project_level, A.department_manager_id, A.project_manage_id, A.project_manage_name, A.project_manage_department_id, A.common_area, A.logistics_area, A.cad_area, A.total_integral, A.project_integral, A.reserve_integral, A.percentage, b.status AS emp_status FROM system_process_instance_activities spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id LEFT JOIN professional_approval A ON spia.business_id = A.professional_approval__id LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spia.process_type = :process_type and A.delete_flag = 0 and spi.delete_flag = 0 and spia.activity_type IN ( 2, 3 ) and b.employee_name like :employee_name and A.employee_no like :employee_no and A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) and ((sppt.process_pooled_task_id IS NULL and spia.employee_id = :employee_id and 1 = 1 and spia.status = :status) or (sppt.process_pooled_task_id > 0 and (sppt.employee_id = :employee_id) and 2 = 2 and sppt.status = :status)) ORDER BY spia.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spia.process_type = :process_type and A.delete_flag = 0 and spi.delete_flag = 0 and spia.activity_type IN ( 2, 3 ) and b.employee_name like :employee_name and A.employee_no like :employee_no and A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) and ((sppt.process_pooled_task_id IS NULL and spia.employee_id = :employee_id and 1 = 1 and spia.status = :status) or (sppt.process_pooled_task_id > 0 and (sppt.employee_id = :employee_id) and 2 = 2 and sppt.status = :status))\",\"startIndex\": 1547,\"stopIndex\":2078,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": processType,employeeName,employeeNo,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.process_type = :process_type\",\"fullFieldName\":\"spia.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 1547,\"stopIndex\":1579,\"variableNum\": 0,\"includeStaticCondition\": False,\"conditionNames\": processType,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 1585,\"stopIndex\":1601,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 1607,\"stopIndex\":1625,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.activity_type IN ( 2, 3 )\",\"nextToken\":\"and\",\"startIndex\": 1631,\"stopIndex\":1660,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_name like :employee_name\",\"fullFieldName\":\"b.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 1666,\"stopIndex\":1700,\"variableNum\": 1,\"includeStaticCondition\": False,\"conditionNames\": employeeName,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.employee_no like :employee_no\",\"fullFieldName\":\"A.employee_no\",\"operationName\":\"like\",\"variableName\":\"employeeNo\",\"nextToken\":\"and\",\"startIndex\": 1706,\"stopIndex\":1736,\"variableNum\": 2,\"includeStaticCondition\": False,\"conditionNames\": employeeNo,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id )\",\"nextToken\":\"and\",\"startIndex\": 1742,\"stopIndex\":1851,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"startIndex\": 1820,\"stopIndex\":1849,\"variableNum\": 0,\"includeStaticCondition\": False,\"conditionNames\": departmentId,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"fullFieldName\":\"department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"startIndex\": 1820,\"stopIndex\":1849,\"variableNum\": 3,\"includeStaticCondition\": False,\"conditionNames\": departmentId,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"((sppt.process_pooled_task_id IS NULL and spia.employee_id = :employee_id and 1 = 1 and spia.status = :status) or (sppt.process_pooled_task_id > 0 and (sppt.employee_id = :employee_id) and 2 = 2 and sppt.status = :status))\",\"startIndex\": 1857,\"stopIndex\":2078,\"variableNum\": 0,\"includeStaticCondition\": False,\"conditionNames\": ,\"variableCount\": 0,\"isor\":true,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"(sppt.process_pooled_task_id IS NULL and spia.employee_id = :employee_id and 1 = 1 and spia.status = :status)\",\"nextToken\":\"or\",\"startIndex\": 1858,\"stopIndex\":1966,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": employeeId,status,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"sppt.process_pooled_task_id IS NULL\",\"nextToken\":\"and\",\"startIndex\": 1859,\"stopIndex\":1893,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.employee_id = :employee_id\",\"fullFieldName\":\"spia.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1899,\"stopIndex\":1929,\"variableNum\": 4,\"includeStaticCondition\": False,\"conditionNames\": employeeId,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"1 = 1\",\"nextToken\":\"and\",\"startIndex\": 1935,\"stopIndex\":1939,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.status = :status\",\"fullFieldName\":\"spia.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1945,\"stopIndex\":1965,\"variableNum\": 5,\"includeStaticCondition\": False,\"conditionNames\": status,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"(sppt.process_pooled_task_id > 0 and (sppt.employee_id = :employee_id) and 2 = 2 and sppt.status = :status)\",\"startIndex\": 1971,\"stopIndex\":2077,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": status,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"sppt.process_pooled_task_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1972,\"stopIndex\":2002,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"(sppt.employee_id = :employee_id)\",\"nextToken\":\"and\",\"startIndex\": 2008,\"stopIndex\":2040,\"variableNum\": 0,\"includeStaticCondition\": False,\"conditionNames\": employeeId,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"sppt.employee_id = :employee_id\",\"fullFieldName\":\"sppt.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 2009,\"stopIndex\":2039,\"variableNum\": 6,\"includeStaticCondition\": False,\"conditionNames\": employeeId,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"2 = 2\",\"nextToken\":\"and\",\"startIndex\": 2046,\"stopIndex\":2050,\"variableNum\": 0,\"includeStaticCondition\": True,\"conditionNames\": ,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.status = :status\",\"fullFieldName\":\"sppt.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 2056,\"stopIndex\":2076,\"variableNum\": 7,\"includeStaticCondition\": False,\"conditionNames\": status,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_type_name,process_pooled_task_id,type_flag,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,professional_approval__id,employee_id,employee_no,start_date,delete_flag,project_id,project_code,project_name,contract_id,contract_code,contract_name,plate_id,design_type,project_type,plate_manager_id,project_level,department_manager_id,project_manage_id,project_manage_name,project_manage_department_id,common_area,logistics_area,cad_area,total_integral,project_integral,reserve_integral,percentage,emp_status";
	private final static String[] fieldNames = { "process_type", "employee_name", "employee_no", "department_id", "employee_id", "status", "employee_id", "status"};
}
