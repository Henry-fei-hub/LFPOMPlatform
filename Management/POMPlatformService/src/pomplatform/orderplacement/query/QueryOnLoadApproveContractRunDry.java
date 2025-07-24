package pomplatform.orderplacement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.orderplacement.bean.BaseOnLoadApproveContractRunDry;
import pomplatform.orderplacement.bean.ConditionOnLoadApproveContractRunDry;

public class QueryOnLoadApproveContractRunDry extends AbstractQuery<BaseOnLoadApproveContractRunDry, ConditionOnLoadApproveContractRunDry>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApproveContractRunDry.class);

	public QueryOnLoadApproveContractRunDry() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sppt.process_pooled_task_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApproveContractRunDry> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApproveContractRunDry condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getInfoCode(), 
				condition.getContractName(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus()
			);
	}

	public BaseCollection<BaseOnLoadApproveContractRunDry> runQuery( KeyValuePair[] replacements, ConditionOnLoadApproveContractRunDry condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProcessType(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getInfoCode(), 
				condition.getContractName(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus()
			);
	}

	public BaseCollection<BaseOnLoadApproveContractRunDry> execute( KeyValuePair[] replacements, ConditionOnLoadApproveContractRunDry condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProcessType(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getInfoCode(), 
				condition.getContractName(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseOnLoadApproveContractRunDry generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApproveContractRunDry __base = new BaseOnLoadApproveContractRunDry();
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
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOrderInfoId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileName(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
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

	private final static String __SQLText = "SELECT sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, spia.process_type, oi.contract_id, oi.contract_code, oi.info_code, oi.order_info_id, oi.project_code, oi.contract_name, oi.file_id, oi.file_url, oi.file_name FROM system_process_instance_activities spia LEFT JOIN order_info oi ON spia.business_id = oi.order_info_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id WHERE spia.process_type = ? and spia.activity_type IN ( 2, 3 ) and oi.order_info_id > 0 and oi.contract_id = ? and oi.contract_code = ? and oi.info_code = ? and oi.contract_name like ? and spi.delete_flag = 0 and ((( (spia.employee_id > 0 and sppt.process_pooled_task_id IS NULL and spia.employee_id = ? and spia.status = ?) ) or ( (spia.employee_id > 0 and sppt.process_pooled_task_id > 0 and spia.employee_id = ? and sppt.employee_id = ? and sppt.status = ?) ) or ( (spia.employee_id IS NULL and sppt.employee_id = ? and sppt.status = ?) ))) ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, spia.process_type, oi.contract_id, oi.contract_code, oi.info_code, oi.order_info_id, oi.project_code, oi.contract_name, oi.file_id, oi.file_url, oi.file_name FROM system_process_instance_activities spia LEFT JOIN order_info oi ON spia.business_id = oi.order_info_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id WHERE spia.process_type =:process_type AND spia.activity_type IN ( 2, 3 ) AND oi.order_info_id > 0 AND oi.contract_id =:contract_id AND oi.contract_code =:contract_code AND oi.info_code =:info_code AND oi.contract_name LIKE :contract_name AND spi.delete_flag = 0 AND (( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) OR ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status )) ORDER BY spia.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spia.process_type =:process_type AND spia.activity_type IN ( 2, 3 ) AND oi.order_info_id > 0 AND oi.contract_id =:contract_id AND oi.contract_code =:contract_code AND oi.info_code =:info_code AND oi.contract_name LIKE :contract_name AND spi.delete_flag = 0 AND (( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) OR ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ))\",\"startIndex\": 1027,\"stopIndex\":1664,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.process_type =:process_type\",\"fullFieldName\":\"spia.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 1027,\"stopIndex\":1058,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.activity_type IN ( 2, 3 )\",\"nextToken\":\"and\",\"startIndex\": 1064,\"stopIndex\":1093,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.order_info_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1099,\"stopIndex\":1118,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.contract_id =:contract_id\",\"fullFieldName\":\"oi.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"nextToken\":\"and\",\"startIndex\": 1124,\"stopIndex\":1151,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.contract_code =:contract_code\",\"fullFieldName\":\"oi.contract_code\",\"operationName\":\"=\",\"variableName\":\"contractCode\",\"nextToken\":\"and\",\"startIndex\": 1157,\"stopIndex\":1188,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.info_code =:info_code\",\"fullFieldName\":\"oi.info_code\",\"operationName\":\"=\",\"variableName\":\"infoCode\",\"nextToken\":\"and\",\"startIndex\": 1194,\"stopIndex\":1217,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.contract_name LIKE :contract_name\",\"fullFieldName\":\"oi.contract_name\",\"operationName\":\"like\",\"variableName\":\"contractName\",\"nextToken\":\"and\",\"startIndex\": 1223,\"stopIndex\":1258,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 1264,\"stopIndex\":1282,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"(( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) OR ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ))\",\"startIndex\": 1288,\"stopIndex\":1664,\"variableNum\": 0,\"variableCount\": 0,\"isor\":true,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status )\",\"nextToken\":\"or\",\"startIndex\": 1289,\"stopIndex\":1412,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.employee_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1291,\"stopIndex\":1310,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"sppt.process_pooled_task_id IS NULL\",\"nextToken\":\"and\",\"startIndex\": 1316,\"stopIndex\":1350,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.employee_id =:employee_id\",\"fullFieldName\":\"spia.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1356,\"stopIndex\":1385,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.status =:status\",\"fullFieldName\":\"spia.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1391,\"stopIndex\":1410,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status )\",\"nextToken\":\"or\",\"startIndex\": 1417,\"stopIndex\":1571,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"spia.employee_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1419,\"stopIndex\":1438,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"sppt.process_pooled_task_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1444,\"stopIndex\":1474,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.employee_id =:employee_id\",\"fullFieldName\":\"spia.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1480,\"stopIndex\":1509,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.employee_id =:employee_id\",\"fullFieldName\":\"sppt.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1515,\"stopIndex\":1544,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.status =:status\",\"fullFieldName\":\"sppt.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1550,\"stopIndex\":1569,\"variableNum\": 9,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status )\",\"startIndex\": 1576,\"stopIndex\":1663,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"spia.employee_id IS NULL\",\"nextToken\":\"and\",\"startIndex\": 1578,\"stopIndex\":1601,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"sppt.employee_id =:employee_id\",\"fullFieldName\":\"sppt.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1607,\"stopIndex\":1636,\"variableNum\": 10,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.status =:status\",\"fullFieldName\":\"sppt.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1642,\"stopIndex\":1661,\"variableNum\": 11,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_pooled_task_id,type_flag,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,process_type,contract_id,contract_code,info_code,order_info_id,project_code,contract_name,file_id,file_url,file_name";
	private final static String[] fieldNames = { "process_type", "contract_id", "contract_code", "info_code", "contract_name", "employee_id", "status", "employee_id", "employee_id", "status", "employee_id", "status"};
}
