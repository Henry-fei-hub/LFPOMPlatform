package pomplatform.contractMessage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractMessage.bean.BaseOnLoadContractMessageRecord;
import pomplatform.contractMessage.bean.ConditionOnLoadContractMessageRecord;

public class QueryOnLoadContractMessageRecord extends AbstractQuery<BaseOnLoadContractMessageRecord, ConditionOnLoadContractMessageRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadContractMessageRecord.class);

	public QueryOnLoadContractMessageRecord() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cm.contract_message_id");
	}

	@Override
	public BaseCollection<BaseOnLoadContractMessageRecord> executeQuery( KeyValuePair[] replacements, ConditionOnLoadContractMessageRecord condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getMsgStatus()
			);
	}

	public BaseCollection<BaseOnLoadContractMessageRecord> runQuery( KeyValuePair[] replacements, ConditionOnLoadContractMessageRecord condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getMsgStatus()
			);
	}

	public BaseCollection<BaseOnLoadContractMessageRecord> execute( KeyValuePair[] replacements, ConditionOnLoadContractMessageRecord condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getMsgStatus()
			);
	}

	@Override
	public BaseOnLoadContractMessageRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadContractMessageRecord __base = new BaseOnLoadContractMessageRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractMessageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMsgCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMsgStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT cm.contract_message_id, cm.contract_id, c.contract_code, c.contract_name, cm.business_id, cm.msg_count, cm.msg_status, cm.OPERATOR, cm.create_time, cm.remark FROM contract_messages cm LEFT JOIN contracts AS c ON cm.contract_id = c.contract_id where c.contract_code like ? and c.contract_name like ? and cm.msg_status = ? order by cm.create_time desc" ;
	private final static String __originalSQL = "SELECT cm.contract_message_id, cm.contract_id, c.contract_code, c.contract_name, cm.business_id, cm.msg_count, cm.msg_status, cm.OPERATOR, cm.create_time, cm.remark FROM contract_messages cm LEFT JOIN contracts AS c ON cm.contract_id = c.contract_id where c.contract_code like :contract_code and c.contract_name like :contract_name and cm.msg_status =:msg_status order by cm.create_time desc";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"c.contract_code like :contract_code and c.contract_name like :contract_name and cm.msg_status =:msg_status\",\"startIndex\": 256,\"stopIndex\":361,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"c.contract_code like :contract_code\",\"fullFieldName\":\"c.contract_code\",\"operationName\":\"like\",\"variableName\":\"contractCode\",\"startIndex\": 256,\"stopIndex\":290,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"c.contract_name like :contract_name\",\"fullFieldName\":\"c.contract_name\",\"operationName\":\"like\",\"variableName\":\"contractName\",\"startIndex\": 296,\"stopIndex\":330,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"cm.msg_status =:msg_status\",\"fullFieldName\":\"cm.msg_status\",\"operationName\":\"=\",\"variableName\":\"msgStatus\",\"startIndex\": 336,\"stopIndex\":361,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_message_id,contract_id,contract_code,contract_name,business_id,msg_count,msg_status,operator,create_time,remark";
	private final static String[] fieldNames = { "contract_code", "contract_name", "msg_status"};
}
