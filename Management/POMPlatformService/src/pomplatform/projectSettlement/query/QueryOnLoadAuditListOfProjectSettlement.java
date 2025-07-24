package pomplatform.projectSettlement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectSettlement.bean.BaseOnLoadAuditListOfProjectSettlement;
import pomplatform.projectSettlement.bean.ConditionOnLoadAuditListOfProjectSettlement;

public class QueryOnLoadAuditListOfProjectSettlement extends AbstractQuery<BaseOnLoadAuditListOfProjectSettlement, ConditionOnLoadAuditListOfProjectSettlement>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAuditListOfProjectSettlement.class);

	public QueryOnLoadAuditListOfProjectSettlement() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sppt.process_pooled_task_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAuditListOfProjectSettlement> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAuditListOfProjectSettlement condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadAuditListOfProjectSettlement> runQuery( KeyValuePair[] replacements, ConditionOnLoadAuditListOfProjectSettlement condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadAuditListOfProjectSettlement> execute( KeyValuePair[] replacements, ConditionOnLoadAuditListOfProjectSettlement condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	@Override
	public BaseOnLoadAuditListOfProjectSettlement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAuditListOfProjectSettlement __base = new BaseOnLoadAuditListOfProjectSettlement();
		int count = 0;
		Object val;
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
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
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

	private final static String __SQLText = "SELECT sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, spia.process_type, ps.settlement_id, ps.project_id, ps.employee_id AS project_manage_id, ps.remark, ps.settlement_date, ps.total_amount, ps.total_cost, ps.project_amount, ps.left_amount, ps.stage_id, ps.settlement_status, ps.FLAG, P.project_code, P.project_name FROM system_process_instance_activities spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN project_settlements ps ON spia.business_id = ps.settlement_id LEFT JOIN projects P ON P.project_id = ps.project_id WHERE spia.activity_type IN ( 2, 3 ) and spi.delete_flag = 0 and ((spia.employee_id > 0 and sppt.process_pooled_task_id IS NULL and spia.employee_id = ? and spia.status = ?) or (spia.employee_id > 0 and sppt.process_pooled_task_id > 0 and spia.employee_id = ? and sppt.employee_id = ? and sppt.status = ?) or (spia.employee_id IS NULL and sppt.employee_id = ? and sppt.status = ?)) and spia.process_type = 80 and P.project_name like ? and P.project_code like ? ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, spia.process_type, ps.settlement_id, ps.project_id, ps.employee_id AS project_manage_id, ps.remark, ps.settlement_date, ps.total_amount, ps.total_cost, ps.project_amount, ps.left_amount, ps.stage_id, ps.settlement_status, ps.FLAG, P.project_code, P.project_name FROM system_process_instance_activities spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN project_settlements ps ON spia.business_id = ps.settlement_id LEFT JOIN projects P ON P.project_id = ps.project_id WHERE spia.activity_type IN ( 2, 3 ) AND spi.delete_flag = 0 AND ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) OR ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) AND spia.process_type = 80 AND P.project_name LIKE :project_name AND P.project_code LIKE :project_code ORDER BY spia.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spia.activity_type IN ( 2, 3 ) AND spi.delete_flag = 0 AND ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) OR ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) AND spia.process_type = 80 AND P.project_name LIKE :project_name AND P.project_code LIKE :project_code\",\"startIndex\": 1193,\"stopIndex\":1733,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.activity_type IN ( 2, 3 )\",\"startIndex\": 1193,\"stopIndex\":1222,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.delete_flag = 0\",\"startIndex\": 1228,\"stopIndex\":1246,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) OR ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) )\",\"startIndex\": 1252,\"stopIndex\":1630,\"variableNum\": 0,\"variableCount\": 0,\"isor\":true,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status )\",\"startIndex\": 1254,\"stopIndex\":1377,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"spia.employee_id > 0\",\"startIndex\": 1256,\"stopIndex\":1275,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.process_pooled_task_id IS NULL\",\"startIndex\": 1281,\"stopIndex\":1315,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.employee_id =:employee_id\",\"fullFieldName\":\"spia.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 1321,\"stopIndex\":1350,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.status =:status\",\"fullFieldName\":\"spia.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1356,\"stopIndex\":1375,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status )\",\"startIndex\": 1382,\"stopIndex\":1536,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"spia.employee_id > 0\",\"startIndex\": 1384,\"stopIndex\":1403,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.process_pooled_task_id > 0\",\"startIndex\": 1409,\"stopIndex\":1439,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.employee_id =:employee_id\",\"fullFieldName\":\"spia.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 1445,\"stopIndex\":1474,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.employee_id =:employee_id\",\"fullFieldName\":\"sppt.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 1480,\"stopIndex\":1509,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.status =:status\",\"fullFieldName\":\"sppt.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1515,\"stopIndex\":1534,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status )\",\"startIndex\": 1541,\"stopIndex\":1628,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"spia.employee_id IS NULL\",\"startIndex\": 1543,\"stopIndex\":1566,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.employee_id =:employee_id\",\"fullFieldName\":\"sppt.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 1572,\"stopIndex\":1601,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.status =:status\",\"fullFieldName\":\"sppt.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1607,\"stopIndex\":1626,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"spia.process_type = 80\",\"startIndex\": 1636,\"stopIndex\":1657,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_name LIKE :project_name\",\"fullFieldName\":\"P.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 1663,\"stopIndex\":1695,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_code LIKE :project_code\",\"fullFieldName\":\"P.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 1701,\"stopIndex\":1733,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_pooled_task_id,type_flag,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,process_type,settlement_id,project_id,project_manage_id,remark,settlement_date,total_amount,total_cost,project_amount,left_amount,stage_id,settlement_status,flag,project_code,project_name";
	private final static String[] fieldNames = { "employee_id", "status", "employee_id", "employee_id", "status", "employee_id", "status", "project_name", "project_code"};
}
