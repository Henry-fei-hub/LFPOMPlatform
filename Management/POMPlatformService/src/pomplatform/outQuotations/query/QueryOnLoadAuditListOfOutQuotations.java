package pomplatform.outQuotations.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.outQuotations.bean.BaseOnLoadAuditListOfOutQuotations;
import pomplatform.outQuotations.bean.ConditionOnLoadAuditListOfOutQuotations;

public class QueryOnLoadAuditListOfOutQuotations extends AbstractQuery<BaseOnLoadAuditListOfOutQuotations, ConditionOnLoadAuditListOfOutQuotations>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAuditListOfOutQuotations.class);

	public QueryOnLoadAuditListOfOutQuotations() throws java.sql.SQLException 
	{
		setParameterNumber(13);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sppt.process_pooled_task_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAuditListOfOutQuotations> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAuditListOfOutQuotations condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getOutQuotationId(), 
				condition.getQuotationNumber(), 
				condition.getQuotationName(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getQuotationStatus()
			);
	}

	public BaseCollection<BaseOnLoadAuditListOfOutQuotations> runQuery( KeyValuePair[] replacements, ConditionOnLoadAuditListOfOutQuotations condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getOutQuotationId(), 
				condition.getQuotationNumber(), 
				condition.getQuotationName(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getQuotationStatus()
			);
	}

	public BaseCollection<BaseOnLoadAuditListOfOutQuotations> execute( KeyValuePair[] replacements, ConditionOnLoadAuditListOfOutQuotations condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getStatus(), 
				condition.getOutQuotationId(), 
				condition.getQuotationNumber(), 
				condition.getQuotationName(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getQuotationStatus()
			);
	}

	@Override
	public BaseOnLoadAuditListOfOutQuotations generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAuditListOfOutQuotations __base = new BaseOnLoadAuditListOfOutQuotations();
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
		if((val = __data[count++]) != null) __base.setOutQuotationId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQuotationNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQuotationName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQuotationFiles(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQuotationStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDisableType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setNewCreateQuotationName(GenericBase.__getString(val));
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
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
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

	private final static String __SQLText = "SELECT sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, spia.process_type, oq.out_quotation_id, oq.quotation_number, oq.quotation_name, oq.money_sum, oq.create_time AS start_time, oq.info_code, oq.project_code, oq.project_code AS project_name, oq.business_type, oq.project_type, oq.quotation_files, oq.quotation_status, oq.disable_type, oq.employee_id, oq.contract_id, oq.update_time, a.new_create_quotation_name FROM system_process_instance_activities spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN out_quotations oq ON spia.business_id = oq.out_quotation_id left join (select DISTINCT out_quotation_id,new_create_quotation_name from out_design_considerations order by out_quotation_id desc ) as a ON spi.business_id = a.out_quotation_id WHERE spia.activity_type IN ( 2, 3 ) and spi.delete_flag = 0 and ( (( (( (( (spia.employee_id > 0 and sppt.process_pooled_task_id IS NULL and spia.employee_id = ? and spia.status = ?) )) ) or ( (( (spia.employee_id > 0 and sppt.process_pooled_task_id > 0 and spia.employee_id = ? and sppt.employee_id = ? and sppt.status = ?) )) ) or ( (( (spia.employee_id IS NULL and sppt.employee_id = ? and sppt.status = ?) )) )) )) ) and spia.process_type = 75 and oq.out_quotation_id = ? and oq.quotation_number like ? and oq.quotation_name like ? and oq.info_code like ? and oq.project_code like ? and oq.quotation_status = ? ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, spia.process_type, oq.out_quotation_id, oq.quotation_number, oq.quotation_name, oq.money_sum, oq.create_time AS start_time, oq.info_code, oq.project_code, oq.project_code AS project_name, oq.business_type, oq.project_type, oq.quotation_files, oq.quotation_status, oq.disable_type, oq.employee_id, oq.contract_id, oq.update_time, a.new_create_quotation_name FROM system_process_instance_activities spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN out_quotations oq ON spia.business_id = oq.out_quotation_id left join (select DISTINCT out_quotation_id,new_create_quotation_name from out_design_considerations order by out_quotation_id desc ) as a ON spi.business_id = a.out_quotation_id WHERE spia.activity_type IN ( 2, 3 ) AND spi.delete_flag = 0 AND ( ( ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) ) OR ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) OR ( ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) ) ) AND spia.process_type = 75 AND oq.out_quotation_id =:out_quotation_id AND oq.quotation_number LIKE :quotation_number AND oq.quotation_name LIKE :quotation_name AND oq.info_code LIKE :info_code AND oq.project_code LIKE :project_code AND oq.quotation_status =:quotation_status ORDER BY spia.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spia.activity_type IN ( 2, 3 ) AND spi.delete_flag = 0 AND ( ( ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) ) OR ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) OR ( ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) ) ) AND spia.process_type = 75 AND oq.out_quotation_id =:out_quotation_id AND oq.quotation_number LIKE :quotation_number AND oq.quotation_name LIKE :quotation_name AND oq.info_code LIKE :info_code AND oq.project_code LIKE :project_code AND oq.quotation_status =:quotation_status\",\"startIndex\": 1412,\"stopIndex\":2140,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.activity_type IN ( 2, 3 )\",\"nextToken\":\"and\",\"startIndex\": 1412,\"stopIndex\":1441,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 1447,\"stopIndex\":1465,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"( ( ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) ) OR ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) OR ( ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) ) )\",\"nextToken\":\"and\",\"startIndex\": 1471,\"stopIndex\":1865,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"( ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) ) OR ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) OR ( ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) ) )\",\"startIndex\": 1473,\"stopIndex\":1863,\"variableNum\": 0,\"variableCount\": 0,\"isor\":true,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status ) )\",\"nextToken\":\"or\",\"startIndex\": 1475,\"stopIndex\":1602,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =:employee_id AND spia.status =:status )\",\"startIndex\": 1477,\"stopIndex\":1600,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.employee_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1479,\"stopIndex\":1498,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"sppt.process_pooled_task_id IS NULL\",\"nextToken\":\"and\",\"startIndex\": 1504,\"stopIndex\":1538,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.employee_id =:employee_id\",\"fullFieldName\":\"spia.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1544,\"stopIndex\":1573,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.status =:status\",\"fullFieldName\":\"spia.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1579,\"stopIndex\":1598,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"( ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status ) )\",\"nextToken\":\"or\",\"startIndex\": 1607,\"stopIndex\":1765,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =:employee_id AND sppt.employee_id =:employee_id AND sppt.status =:status )\",\"startIndex\": 1609,\"stopIndex\":1763,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.employee_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1611,\"stopIndex\":1630,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"sppt.process_pooled_task_id > 0\",\"nextToken\":\"and\",\"startIndex\": 1636,\"stopIndex\":1666,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.employee_id =:employee_id\",\"fullFieldName\":\"spia.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1672,\"stopIndex\":1701,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.employee_id =:employee_id\",\"fullFieldName\":\"sppt.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1707,\"stopIndex\":1736,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.status =:status\",\"fullFieldName\":\"sppt.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1742,\"stopIndex\":1761,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]},{\"fullCondition\": \"( ( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status ) )\",\"startIndex\": 1770,\"stopIndex\":1861,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":false,\"children\": [{\"fullCondition\": \"( spia.employee_id IS NULL AND sppt.employee_id =:employee_id AND sppt.status =:status )\",\"startIndex\": 1772,\"stopIndex\":1859,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":true,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.employee_id IS NULL\",\"nextToken\":\"and\",\"startIndex\": 1774,\"stopIndex\":1797,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": []},{\"fullCondition\": \"sppt.employee_id =:employee_id\",\"fullFieldName\":\"sppt.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1803,\"stopIndex\":1832,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"sppt.status =:status\",\"fullFieldName\":\"sppt.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 1838,\"stopIndex\":1857,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]}]}]},{\"fullCondition\": \"spia.process_type = 75\",\"nextToken\":\"and\",\"startIndex\": 1871,\"stopIndex\":1892,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.out_quotation_id =:out_quotation_id\",\"fullFieldName\":\"oq.out_quotation_id\",\"operationName\":\"=\",\"variableName\":\"outQuotationId\",\"nextToken\":\"and\",\"startIndex\": 1898,\"stopIndex\":1935,\"variableNum\": 7,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.quotation_number LIKE :quotation_number\",\"fullFieldName\":\"oq.quotation_number\",\"operationName\":\"like\",\"variableName\":\"quotationNumber\",\"nextToken\":\"and\",\"startIndex\": 1941,\"stopIndex\":1982,\"variableNum\": 8,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.quotation_name LIKE :quotation_name\",\"fullFieldName\":\"oq.quotation_name\",\"operationName\":\"like\",\"variableName\":\"quotationName\",\"nextToken\":\"and\",\"startIndex\": 1988,\"stopIndex\":2025,\"variableNum\": 9,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.info_code LIKE :info_code\",\"fullFieldName\":\"oq.info_code\",\"operationName\":\"like\",\"variableName\":\"infoCode\",\"nextToken\":\"and\",\"startIndex\": 2031,\"stopIndex\":2058,\"variableNum\": 10,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.project_code LIKE :project_code\",\"fullFieldName\":\"oq.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 2064,\"stopIndex\":2097,\"variableNum\": 11,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oq.quotation_status =:quotation_status\",\"fullFieldName\":\"oq.quotation_status\",\"operationName\":\"=\",\"variableName\":\"quotationStatus\",\"startIndex\": 2103,\"stopIndex\":2140,\"variableNum\": 12,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_pooled_task_id,type_flag,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,process_type,out_quotation_id,quotation_number,quotation_name,money_sum,start_time,info_code,project_code,project_name,business_type,project_type,quotation_files,quotation_status,disable_type,employee_id,contract_id,update_time,new_create_quotation_name";
	private final static String[] fieldNames = { "employee_id", "status", "employee_id", "employee_id", "status", "employee_id", "status", "out_quotation_id", "quotation_number", "quotation_name", "info_code", "project_code", "quotation_status"};
}
