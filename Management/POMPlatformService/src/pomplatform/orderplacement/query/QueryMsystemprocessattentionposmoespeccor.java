package pomplatform.orderplacement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.orderplacement.bean.BaseMsystemprocessattentionposmoespeccor;
import pomplatform.orderplacement.bean.ConditionMsystemprocessattentionposmoespeccor;

public class QueryMsystemprocessattentionposmoespeccor extends AbstractQuery<BaseMsystemprocessattentionposmoespeccor, ConditionMsystemprocessattentionposmoespeccor>
{

	private static final Logger __logger = Logger.getLogger(QueryMsystemprocessattentionposmoespeccor.class);

	public QueryMsystemprocessattentionposmoespeccor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseMsystemprocessattentionposmoespeccor> executeQuery( KeyValuePair[] replacements, ConditionMsystemprocessattentionposmoespeccor condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getInfoCode()
			);
	}

	public BaseCollection<BaseMsystemprocessattentionposmoespeccor> runQuery( KeyValuePair[] replacements, ConditionMsystemprocessattentionposmoespeccor condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProcessType(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getInfoCode()
			);
	}

	public BaseCollection<BaseMsystemprocessattentionposmoespeccor> execute( KeyValuePair[] replacements, ConditionMsystemprocessattentionposmoespeccor condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProcessType(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getInfoCode()
			);
	}

	@Override
	public BaseMsystemprocessattentionposmoespeccor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMsystemprocessattentionposmoespeccor __base = new BaseMsystemprocessattentionposmoespeccor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.employee_id, spi.complete_time, spi.create_time, oi.contract_id, oi.contract_code, oi.info_code, oi.contract_name FROM system_process_instances spi LEFT JOIN order_info oi ON spi.business_id = oi.order_info_id WHERE spi.process_type = ? and oi.order_info_id>0 and oi.contract_id = ? and oi.contract_code = ? and oi.info_code = ? ORDER BY spi.create_time DESC" ;
	private final static String __originalSQL = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.employee_id, spi.complete_time, spi.create_time, oi.contract_id, oi.contract_code, oi.info_code, oi.contract_name FROM system_process_instances spi LEFT JOIN order_info oi ON spi.business_id = oi.order_info_id WHERE spi.process_type =:process_type AND oi.order_info_id>0 AND oi.contract_id =:contract_id AND oi.contract_code =:contract_code AND oi.info_code =:info_code ORDER BY spi.create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spi.process_type =:process_type AND oi.order_info_id>0 AND oi.contract_id =:contract_id AND oi.contract_code =:contract_code AND oi.info_code =:info_code\",\"startIndex\": 358,\"stopIndex\":510,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type =:process_type\",\"fullFieldName\":\"spi.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 358,\"stopIndex\":388,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.order_info_id>0\",\"nextToken\":\"and\",\"startIndex\": 394,\"stopIndex\":411,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.contract_id =:contract_id\",\"fullFieldName\":\"oi.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"nextToken\":\"and\",\"startIndex\": 417,\"stopIndex\":444,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.contract_code =:contract_code\",\"fullFieldName\":\"oi.contract_code\",\"operationName\":\"=\",\"variableName\":\"contractCode\",\"nextToken\":\"and\",\"startIndex\": 450,\"stopIndex\":481,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"oi.info_code =:info_code\",\"fullFieldName\":\"oi.info_code\",\"operationName\":\"=\",\"variableName\":\"infoCode\",\"startIndex\": 487,\"stopIndex\":510,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,employee_id,complete_time,create_time,contract_id,contract_code,info_code,contract_name";
	private final static String[] fieldNames = { "process_type", "contract_id", "contract_code", "info_code"};
}
