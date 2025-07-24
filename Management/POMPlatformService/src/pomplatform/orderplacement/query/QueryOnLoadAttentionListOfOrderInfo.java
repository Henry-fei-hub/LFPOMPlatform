package pomplatform.orderplacement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.orderplacement.bean.BaseOnLoadAttentionListOfOrderInfo;
import pomplatform.orderplacement.bean.ConditionOnLoadAttentionListOfOrderInfo;

public class QueryOnLoadAttentionListOfOrderInfo extends AbstractQuery<BaseOnLoadAttentionListOfOrderInfo, ConditionOnLoadAttentionListOfOrderInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttentionListOfOrderInfo.class);

	public QueryOnLoadAttentionListOfOrderInfo() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAttentionListOfOrderInfo> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfOrderInfo condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getInfoCode(), 
				condition.getContractName()
			);
	}

	public BaseCollection<BaseOnLoadAttentionListOfOrderInfo> runQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfOrderInfo condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getInfoCode(), 
				condition.getContractName()
			);
	}

	public BaseCollection<BaseOnLoadAttentionListOfOrderInfo> execute( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfOrderInfo condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getInfoCode(), 
				condition.getContractName()
			);
	}

	@Override
	public BaseOnLoadAttentionListOfOrderInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttentionListOfOrderInfo __base = new BaseOnLoadAttentionListOfOrderInfo();
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
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, spa.employee_id, oi.contract_id, oi.contract_code, oi.info_code, oi.contract_name FROM system_process_attentions spa LEFT JOIN order_info oi ON spa.business_id = oi.order_info_id WHERE spa.status = ? and spa.process_type = ? and spa.employee_id = ? and oi.order_info_id > 0 and oi.contract_id = ? and oi.contract_code = ? and oi.info_code = ? and oi.contract_name like ? ORDER BY spa.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, spa.employee_id, oi.contract_id, oi.contract_code, oi.info_code, oi.contract_name FROM system_process_attentions spa LEFT JOIN order_info oi ON spa.business_id = oi.order_info_id WHERE spa.status =:status AND spa.process_type =:process_type AND spa.employee_id =:employee_id AND oi.order_info_id > 0 AND oi.contract_id =:contract_id AND oi.contract_code =:contract_code AND oi.info_code =:info_code AND oi.contract_name LIKE :contract_name ORDER BY spa.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spa.status =:status AND spa.process_type =:process_type AND spa.employee_id =:employee_id AND oi.order_info_id > 0 AND oi.contract_id =:contract_id AND oi.contract_code =:contract_code AND oi.info_code =:info_code AND oi.contract_name LIKE :contract_name\",\"startIndex\": 493,\"stopIndex\":746,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spa.status =:status\",\"fullFieldName\":\"spa.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"nextToken\":\"and\",\"startIndex\": 493,\"stopIndex\":511,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.process_type =:process_type\",\"fullFieldName\":\"spa.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 517,\"stopIndex\":547,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.employee_id =:employee_id\",\"fullFieldName\":\"spa.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 553,\"stopIndex\":581,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.order_info_id > 0\",\"nextToken\":\"and\",\"startIndex\": 587,\"stopIndex\":606,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.contract_id =:contract_id\",\"fullFieldName\":\"oi.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"nextToken\":\"and\",\"startIndex\": 612,\"stopIndex\":639,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.contract_code =:contract_code\",\"fullFieldName\":\"oi.contract_code\",\"operationName\":\"=\",\"variableName\":\"contractCode\",\"nextToken\":\"and\",\"startIndex\": 645,\"stopIndex\":676,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.info_code =:info_code\",\"fullFieldName\":\"oi.info_code\",\"operationName\":\"=\",\"variableName\":\"infoCode\",\"nextToken\":\"and\",\"startIndex\": 682,\"stopIndex\":705,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.contract_name LIKE :contract_name\",\"fullFieldName\":\"oi.contract_name\",\"operationName\":\"like\",\"variableName\":\"contractName\",\"startIndex\": 711,\"stopIndex\":746,\"variableNum\": 6,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,operate_time,process_comment,employee_id,contract_id,contract_code,info_code,contract_name";
	private final static String[] fieldNames = { "status", "process_type", "employee_id", "contract_id", "contract_code", "info_code", "contract_name"};
}
