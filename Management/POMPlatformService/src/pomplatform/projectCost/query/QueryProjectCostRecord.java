package pomplatform.projectCost.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectCost.bean.BaseProjectCostRecord;
import pomplatform.projectCost.bean.ConditionProjectCostRecord;

public class QueryProjectCostRecord extends AbstractQuery<BaseProjectCostRecord, ConditionProjectCostRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectCostRecord.class);

	public QueryProjectCostRecord() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .project_cost_id");
	}

	@Override
	public BaseCollection<BaseProjectCostRecord> executeQuery( KeyValuePair[] replacements, ConditionProjectCostRecord condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getDesignTeam(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId()
			);
	}

	public BaseCollection<BaseProjectCostRecord> runQuery( KeyValuePair[] replacements, ConditionProjectCostRecord condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getDesignTeam(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId()
			);
	}

	public BaseCollection<BaseProjectCostRecord> execute( KeyValuePair[] replacements, ConditionProjectCostRecord condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getDesignTeam(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseProjectCostRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectCostRecord __base = new BaseProjectCostRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectCostId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDesignTeam(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameToString(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT A .project_cost_id, A.project_id, A.cost_type, A.cost_date, A.settlement_id, A.amount, A.status, A.process_type, A.business_id, A.process_id, A.process_instance_id, mp.project_code, mp.project_name, mp.design_team, mp.main_project_stage_id , spi.complete_time, aa.employee_name_to_string, A.employee_id, e.department_id FROM project_cost A LEFT JOIN main_projects mp ON A.project_id = mp.main_project_id LEFT JOIN system_process_instances spi on spi.process_instance_id=A.process_instance_id LEFT JOIN (SELECT A .main_project_id, array_to_string( ARRAY_AGG ( A.employee_name ), '、' ) AS employee_name_to_string FROM ( SELECT mmp.main_project_id, e.employee_name FROM main_projects mmp LEFT JOIN main_project_employees mpe on mpe.main_project_id = mmp.main_project_id LEFT JOIN employees e on e.employee_id = mpe.employee_id where mpe.relation=3) A GROUP BY A.main_project_id ) aa on aa.main_project_id = mp.main_project_id LEFT JOIN employees e on e.employee_id = A.employee_id WHERE mp.design_team = ? and mp.project_code like ? and mp.project_name like ? and spi.complete_time between ? and ? and A.employee_id = ? and e.department_id = ? ORDER BY A.cost_date DESC, cost_type" ;
	private final static String __originalSQL = "SELECT A .project_cost_id, A.project_id, A.cost_type, A.cost_date, A.settlement_id, A.amount, A.status, A.process_type, A.business_id, A.process_id, A.process_instance_id, mp.project_code, mp.project_name, mp.design_team, mp.main_project_stage_id , spi.complete_time, aa.employee_name_to_string, A.employee_id, e.department_id FROM project_cost A LEFT JOIN main_projects mp ON A.project_id = mp.main_project_id LEFT JOIN system_process_instances spi on spi.process_instance_id=A.process_instance_id LEFT JOIN (SELECT A .main_project_id, array_to_string( ARRAY_AGG ( A.employee_name ), '、' ) AS employee_name_to_string FROM ( SELECT mmp.main_project_id, e.employee_name FROM main_projects mmp LEFT JOIN main_project_employees mpe on mpe.main_project_id = mmp.main_project_id LEFT JOIN employees e on e.employee_id = mpe.employee_id where mpe.relation=3) A GROUP BY A.main_project_id ) aa on aa.main_project_id = mp.main_project_id LEFT JOIN employees e on e.employee_id = A.employee_id WHERE mp.design_team = :design_team and mp.project_code like :project_code and mp.project_name like :project_name AND spi.complete_time BETWEEN :start_date AND :end_date and A.employee_id=:employee_id and e.department_id=:department_id ORDER BY A.cost_date DESC, cost_type";
	private final static String[] __queryConditions = {
			"[{\"fullCondition\": \"mp.design_team = :design_team and mp.project_code like :project_code and mp.project_name like :project_name AND spi.complete_time BETWEEN :start_date AND :end_date and A.employee_id=:employee_id and e.department_id=:department_id\",\"startIndex\": 991,\"stopIndex\":1219,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"mp.design_team = :design_team\",\"fullFieldName\":\"mp.design_team\",\"operationName\":\"=\",\"variableName\":\"designTeam\",\"nextToken\":\"and\",\"startIndex\": 991,\"stopIndex\":1019,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_code like :project_code\",\"fullFieldName\":\"mp.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 1025,\"stopIndex\":1058,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"mp.project_name like :project_name\",\"fullFieldName\":\"mp.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"nextToken\":\"and\",\"startIndex\": 1064,\"stopIndex\":1097,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.complete_time BETWEEN :start_date AND :end_date\",\"fullFieldName\":\"spi.complete_time\",\"operationName\":\"between\",\"variableName\":\"startDate\",\"secondName\":\"endDate\",\"nextToken\":\"and\",\"startIndex\": 1103,\"stopIndex\":1153,\"variableNum\": 3,\"variableCount\": 2,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.employee_id=:employee_id\",\"fullFieldName\":\"A.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1159,\"stopIndex\":1184,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"e.department_id=:department_id\",\"fullFieldName\":\"e.department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"startIndex\": 1190,\"stopIndex\":1219,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_cost_id,project_id,cost_type,cost_date,settlement_id,amount,status,process_type,business_id,process_id,process_instance_id,project_code,project_name,design_team,main_project_stage_id,complete_time,employee_name_to_string,employee_id,department_id";
	private final static String[] fieldNames = { "design_team", "project_code", "project_name", "start_date", "end_date", "employee_id", "department_id"};
}
