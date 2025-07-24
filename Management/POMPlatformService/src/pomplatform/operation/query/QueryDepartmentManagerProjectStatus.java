package pomplatform.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operation.bean.BaseDepartmentManagerProjectStatus;
import pomplatform.operation.bean.ConditionDepartmentManagerProjectStatus;

public class QueryDepartmentManagerProjectStatus extends AbstractQuery<BaseDepartmentManagerProjectStatus, ConditionDepartmentManagerProjectStatus>
{

	private static final Logger __logger = Logger.getLogger(QueryDepartmentManagerProjectStatus.class);

	public QueryDepartmentManagerProjectStatus() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spia.process_instance_activity_id");
	}

	@Override
	public BaseCollection<BaseDepartmentManagerProjectStatus> executeQuery( KeyValuePair[] replacements, ConditionDepartmentManagerProjectStatus condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getContractId(), 
				condition.getContractCode()
			);
	}

	public BaseCollection<BaseDepartmentManagerProjectStatus> runQuery( KeyValuePair[] replacements, ConditionDepartmentManagerProjectStatus condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProjectId(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getContractId(), 
				condition.getContractCode()
			);
	}

	public BaseCollection<BaseDepartmentManagerProjectStatus> execute( KeyValuePair[] replacements, ConditionDepartmentManagerProjectStatus condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProjectId(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getContractId(), 
				condition.getContractCode()
			);
	}

	@Override
	public BaseDepartmentManagerProjectStatus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseDepartmentManagerProjectStatus __base = new BaseDepartmentManagerProjectStatus();
		int count = 0;
		Object val;
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "SELECT spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, A.professional_approval__id, A.employee_id, A.employee_no, A.start_date, A.delete_flag, A.project_id, A.project_code, A.project_name, A.contract_id, A.contract_code, A.contract_name, A.plate_id, A.design_type, A.project_type, A.plate_manager_id, A.project_level, A.department_manager_id, A.project_manage_id, A.project_manage_name, A.project_manage_department_id, A.common_area, A.logistics_area, A.cad_area, A.total_integral, A.project_integral, A.reserve_integral, A.percentage FROM system_process_instance_activities spia LEFT JOIN professional_approval A ON spia.business_id = A.professional_approval__id WHERE spia.process_type = 85 and spia.status =1 and spia.activity_type IN ( 2, 3 ) and A.project_id = ? and A.project_code = ? and A.project_name like ? and A.contract_id = ? and A.contract_code = ? and A.delete_flag = 0 ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, A.professional_approval__id, A.employee_id, A.employee_no, A.start_date, A.delete_flag, A.project_id, A.project_code, A.project_name, A.contract_id, A.contract_code, A.contract_name, A.plate_id, A.design_type, A.project_type, A.plate_manager_id, A.project_level, A.department_manager_id, A.project_manage_id, A.project_manage_name, A.project_manage_department_id, A.common_area, A.logistics_area, A.cad_area, A.total_integral, A.project_integral, A.reserve_integral, A.percentage FROM system_process_instance_activities spia LEFT JOIN professional_approval A ON spia.business_id = A.professional_approval__id WHERE spia.process_type = 85 AND spia.status =1 AND spia.activity_type IN ( 2, 3 ) AND A.project_id = :project_id AND A.project_code = :project_code AND A.project_name LIKE :project_name AND A.contract_id = :contract_id AND A.contract_code = :contract_code AND A.delete_flag = 0 ORDER BY spia.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spia.process_type = 85 AND spia.status =1 AND spia.activity_type IN ( 2, 3 ) AND A.project_id = :project_id AND A.project_code = :project_code AND A.project_name LIKE :project_name AND A.contract_id = :contract_id AND A.contract_code = :contract_code AND A.delete_flag = 0\",\"startIndex\": 1010,\"stopIndex\":1281,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.process_type = 85\",\"nextToken\":\"and\",\"startIndex\": 1010,\"stopIndex\":1031,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.status =1\",\"nextToken\":\"and\",\"startIndex\": 1037,\"stopIndex\":1050,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.activity_type IN ( 2, 3 )\",\"nextToken\":\"and\",\"startIndex\": 1056,\"stopIndex\":1085,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.project_id = :project_id\",\"fullFieldName\":\"A.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"nextToken\":\"and\",\"startIndex\": 1091,\"stopIndex\":1116,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.project_code = :project_code\",\"fullFieldName\":\"A.project_code\",\"operationName\":\"=\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 1122,\"stopIndex\":1151,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.project_name LIKE :project_name\",\"fullFieldName\":\"A.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"nextToken\":\"and\",\"startIndex\": 1157,\"stopIndex\":1189,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.contract_id = :contract_id\",\"fullFieldName\":\"A.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"nextToken\":\"and\",\"startIndex\": 1195,\"stopIndex\":1222,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.contract_code = :contract_code\",\"fullFieldName\":\"A.contract_code\",\"operationName\":\"=\",\"variableName\":\"contractCode\",\"nextToken\":\"and\",\"startIndex\": 1228,\"stopIndex\":1259,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.delete_flag = 0\",\"startIndex\": 1265,\"stopIndex\":1281,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,professional_approval__id,employee_id,employee_no,start_date,delete_flag,project_id,project_code,project_name,contract_id,contract_code,contract_name,plate_id,design_type,project_type,plate_manager_id,project_level,department_manager_id,project_manage_id,project_manage_name,project_manage_department_id,common_area,logistics_area,cad_area,total_integral,project_integral,reserve_integral,percentage";
	private final static String[] fieldNames = { "project_id", "project_code", "project_name", "contract_id", "contract_code"};
}
