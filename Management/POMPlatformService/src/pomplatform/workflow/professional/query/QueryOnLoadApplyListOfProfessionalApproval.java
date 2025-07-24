package pomplatform.workflow.professional.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.professional.bean.BaseOnLoadApplyListOfProfessionalApproval;
import pomplatform.workflow.professional.bean.ConditionOnLoadApplyListOfProfessionalApproval;

public class QueryOnLoadApplyListOfProfessionalApproval extends AbstractQuery<BaseOnLoadApplyListOfProfessionalApproval, ConditionOnLoadApplyListOfProfessionalApproval>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfProfessionalApproval.class);

	public QueryOnLoadApplyListOfProfessionalApproval() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfProfessionalApproval> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProfessionalApproval condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getEmployeeName(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	public BaseCollection<BaseOnLoadApplyListOfProfessionalApproval> runQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProfessionalApproval condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProcessType(), 
				condition.getEmployeeName(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	public BaseCollection<BaseOnLoadApplyListOfProfessionalApproval> execute( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProfessionalApproval condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProcessType(), 
				condition.getEmployeeName(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnLoadApplyListOfProfessionalApproval generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfProfessionalApproval __base = new BaseOnLoadApplyListOfProfessionalApproval();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.complete_time, A.professional_approval__id, A.employee_id, A.employee_no, A.start_date, A.delete_flag, A.project_id, A.project_code, A.project_name, A.contract_id, A.contract_code, A.contract_name, A.plate_id, A.design_type, A.project_type, A.plate_manager_id, A.project_level, A.department_manager_id, A.project_manage_id, A.project_manage_name, A.project_manage_department_id, A.common_area, A.logistics_area, A.cad_area, A.total_integral, A.project_integral, A.reserve_integral, A.percentage FROM system_process_instances spi LEFT JOIN professional_approval A ON spi.business_id = A.professional_approval__id LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spi.process_type = ? and b.employee_name like ? and A.employee_id = ? and A.employee_no like ? and A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) and A.delete_flag = 0 and spi.delete_flag = 0 ORDER BY spi.create_time DESC" ;
	private final static String __originalSQL = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.complete_time, A.professional_approval__id, A.employee_id, A.employee_no, A.start_date, A.delete_flag, A.project_id, A.project_code, A.project_name, A.contract_id, A.contract_code, A.contract_name, A.plate_id, A.design_type, A.project_type, A.plate_manager_id, A.project_level, A.department_manager_id, A.project_manage_id, A.project_manage_name, A.project_manage_department_id, A.common_area, A.logistics_area, A.cad_area, A.total_integral, A.project_integral, A.reserve_integral, A.percentage FROM system_process_instances spi LEFT JOIN professional_approval A ON spi.business_id = A.professional_approval__id LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spi.process_type = :process_type AND b.employee_name LIKE :employee_name AND A.employee_id = :employee_id AND A.employee_no LIKE :employee_no AND A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id =:department_id ) AND A.delete_flag = 0 AND spi.delete_flag = 0 ORDER BY spi.create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spi.process_type = :process_type AND b.employee_name LIKE :employee_name AND A.employee_id = :employee_id AND A.employee_no LIKE :employee_no AND A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id =:department_id ) AND A.delete_flag = 0 AND spi.delete_flag = 0\",\"startIndex\": 815,\"stopIndex\":1115,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type = :process_type\",\"fullFieldName\":\"spi.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 815,\"stopIndex\":846,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_name LIKE :employee_name\",\"fullFieldName\":\"b.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"nextToken\":\"and\",\"startIndex\": 852,\"stopIndex\":886,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.employee_id = :employee_id\",\"fullFieldName\":\"A.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 892,\"stopIndex\":919,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.employee_no LIKE :employee_no\",\"fullFieldName\":\"A.employee_no\",\"operationName\":\"like\",\"variableName\":\"employeeNo\",\"nextToken\":\"and\",\"startIndex\": 925,\"stopIndex\":955,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.project_manage_department_id IN ( SELECT child_id FROM department_ids WHERE department_id =:department_id )\",\"nextToken\":\"and\",\"startIndex\": 961,\"stopIndex\":1069,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"department_id =:department_id\",\"startIndex\": 1039,\"stopIndex\":1067,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"department_id =:department_id\",\"fullFieldName\":\"department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"startIndex\": 1039,\"stopIndex\":1067,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"A.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 1075,\"stopIndex\":1091,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.delete_flag = 0\",\"startIndex\": 1097,\"stopIndex\":1115,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,complete_time,professional_approval__id,employee_id,employee_no,start_date,delete_flag,project_id,project_code,project_name,contract_id,contract_code,contract_name,plate_id,design_type,project_type,plate_manager_id,project_level,department_manager_id,project_manage_id,project_manage_name,project_manage_department_id,common_area,logistics_area,cad_area,total_integral,project_integral,reserve_integral,percentage";
	private final static String[] fieldNames = { "process_type", "employee_name", "employee_id", "employee_no", "department_id"};
}
