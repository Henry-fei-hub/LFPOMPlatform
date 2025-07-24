package pomplatform.workflow.professional.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.professional.bean.BaseOnLoadAttentionListOfProfessionalApproval;
import pomplatform.workflow.professional.bean.ConditionOnLoadAttentionListOfProfessionalApproval;

public class QueryOnLoadAttentionListOfProfessionalApproval extends AbstractQuery<BaseOnLoadAttentionListOfProfessionalApproval, ConditionOnLoadAttentionListOfProfessionalApproval>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttentionListOfProfessionalApproval.class);

	public QueryOnLoadAttentionListOfProfessionalApproval() throws java.sql.SQLException
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAttentionListOfProfessionalApproval> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfProfessionalApproval condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements,
				condition.getStatus(),
				condition.getProcessType(),
				condition.getEmployeeId(),
				condition.getEmployeeName(),
				condition.getDepartmentId()
		);
	}

	public BaseCollection<BaseOnLoadAttentionListOfProfessionalApproval> runQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfProfessionalApproval condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements,
				condition.getStatus(),
				condition.getProcessType(),
				condition.getEmployeeId(),
				condition.getEmployeeName(),
				condition.getDepartmentId()
		);
	}

	public BaseCollection<BaseOnLoadAttentionListOfProfessionalApproval> execute( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfProfessionalApproval condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements,
				condition.getStatus(),
				condition.getProcessType(),
				condition.getEmployeeId(),
				condition.getEmployeeName(),
				condition.getDepartmentId()
		);
	}

	@Override
	public BaseOnLoadAttentionListOfProfessionalApproval generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttentionListOfProfessionalApproval __base = new BaseOnLoadAttentionListOfProfessionalApproval();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSystemProcessAttentionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, A.professional_approval__id, A.employee_id, A.employee_no, A.start_date, A.delete_flag, A.project_id, A.project_code, A.project_name, A.contract_id, A.contract_code, A.contract_name, A.plate_id, A.design_type, A.project_type, A.plate_manager_id, A.project_level, A.department_manager_id, A.project_manage_id, A.project_manage_name, A.project_manage_department_id, A.common_area, A.logistics_area, A.cad_area, A.total_integral, A.project_integral, A.reserve_integral, A.percentage, b.status AS emp_status FROM system_process_attentions spa LEFT JOIN professional_approval A ON spa.business_id = A.professional_approval__id LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spa.status = ? and spa.process_type = ? and spa.employee_id = ? and b.employee_name like ? and A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) and A.delete_flag = 0 ORDER BY spa.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, A.professional_approval__id, A.employee_id, A.employee_no, A.start_date, A.delete_flag, A.project_id, A.project_code, A.project_name, A.contract_id, A.contract_code, A.contract_name, A.plate_id, A.design_type, A.project_type, A.plate_manager_id, A.project_level, A.department_manager_id, A.project_manage_id, A.project_manage_name, A.project_manage_department_id, A.common_area, A.logistics_area, A.cad_area, A.total_integral, A.project_integral, A.reserve_integral, A.percentage, b.status AS emp_status FROM system_process_attentions spa LEFT JOIN professional_approval A ON spa.business_id = A.professional_approval__id LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spa.status = :status AND spa.process_type = :process_type AND spa.employee_id = :employee_id AND b.employee_name LIKE :employee_name AND A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) AND A.delete_flag = 0 ORDER BY spa.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
			"[{\"fullCondition\": \"spa.status = :status AND spa.process_type = :process_type AND spa.employee_id = :employee_id AND b.employee_name LIKE :employee_name AND A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id ) AND A.delete_flag = 0\",\"startIndex\": 991,\"stopIndex\":1259,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spa.status = :status\",\"fullFieldName\":\"spa.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"nextToken\":\"and\",\"startIndex\": 991,\"stopIndex\":1010,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.process_type = :process_type\",\"fullFieldName\":\"spa.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 1016,\"stopIndex\":1047,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.employee_id = :employee_id\",\"fullFieldName\":\"spa.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1053,\"stopIndex\":1082,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_name LIKE :employee_name\",\"fullFieldName\":\"b.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 1088,\"stopIndex\":1122,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id = :department_id )\",\"nextToken\":\"and\",\"startIndex\": 1128,\"stopIndex\":1237,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"startIndex\": 1206,\"stopIndex\":1235,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"department_id = :department_id\",\"fullFieldName\":\"department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"startIndex\": 1206,\"stopIndex\":1235,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"A.delete_flag = 0\",\"startIndex\": 1243,\"stopIndex\":1259,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,operate_time,process_comment,professional_approval__id,employee_id,employee_no,start_date,delete_flag,project_id,project_code,project_name,contract_id,contract_code,contract_name,plate_id,design_type,project_type,plate_manager_id,project_level,department_manager_id,project_manage_id,project_manage_name,project_manage_department_id,common_area,logistics_area,cad_area,total_integral,project_integral,reserve_integral,percentage,emp_status";
	private final static String[] fieldNames = { "status", "process_type", "employee_id", "employee_name", "department_id"};
}
