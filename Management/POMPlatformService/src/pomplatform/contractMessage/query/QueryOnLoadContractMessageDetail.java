package pomplatform.contractMessage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractMessage.bean.BaseOnLoadContractMessageDetail;
import pomplatform.contractMessage.bean.ConditionOnLoadContractMessageDetail;

public class QueryOnLoadContractMessageDetail extends AbstractQuery<BaseOnLoadContractMessageDetail, ConditionOnLoadContractMessageDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadContractMessageDetail.class);

	public QueryOnLoadContractMessageDetail() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cmd.contract_message_detail_id");
	}

	@Override
	public BaseCollection<BaseOnLoadContractMessageDetail> executeQuery( KeyValuePair[] replacements, ConditionOnLoadContractMessageDetail condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getRemark(), 
				condition.getContractMessageDetailId(), 
				condition.getContractMessageId(), 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseOnLoadContractMessageDetail> runQuery( KeyValuePair[] replacements, ConditionOnLoadContractMessageDetail condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getRemark(), 
				condition.getContractMessageDetailId(), 
				condition.getContractMessageId(), 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseOnLoadContractMessageDetail> execute( KeyValuePair[] replacements, ConditionOnLoadContractMessageDetail condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getRemark(), 
				condition.getContractMessageDetailId(), 
				condition.getContractMessageId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseOnLoadContractMessageDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadContractMessageDetail __base = new BaseOnLoadContractMessageDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractMessageDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractMessageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select cmd.contract_message_detail_id, cmd.contract_message_id, cmd.contract_id, cmd.operator, cmd.create_time, cmd.remark from contract_message_details cmd where cmd.remark like ? and cmd.contract_message_detail_id = ? and cmd.contract_message_id = ? and cmd.contract_id = ?" ;
	private final static String __originalSQL = "select cmd.contract_message_detail_id, cmd.contract_message_id, cmd.contract_id, cmd.operator, cmd.create_time, cmd.remark from contract_message_details cmd where cmd.remark like :remark and cmd.contract_message_detail_id = :contract_message_detail_id and cmd.contract_message_id = :contract_message_id and cmd.contract_id = :contract_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"cmd.remark like :remark and cmd.contract_message_detail_id = :contract_message_detail_id and cmd.contract_message_id = :contract_message_id and cmd.contract_id = :contract_id\",\"startIndex\": 163,\"stopIndex\":336,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"cmd.remark like :remark\",\"fullFieldName\":\"cmd.remark\",\"operationName\":\"like\",\"variableName\":\"remark\",\"startIndex\": 163,\"stopIndex\":185,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"cmd.contract_message_detail_id = :contract_message_detail_id\",\"fullFieldName\":\"cmd.contract_message_detail_id\",\"operationName\":\"=\",\"variableName\":\"contractMessageDetailId\",\"startIndex\": 191,\"stopIndex\":250,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"cmd.contract_message_id = :contract_message_id\",\"fullFieldName\":\"cmd.contract_message_id\",\"operationName\":\"=\",\"variableName\":\"contractMessageId\",\"startIndex\": 256,\"stopIndex\":301,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"cmd.contract_id = :contract_id\",\"fullFieldName\":\"cmd.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"startIndex\": 307,\"stopIndex\":336,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "contract_message_detail_id,contract_message_id,contract_id,operator,create_time,remark";
	private final static String[] fieldNames = { "remark", "contract_message_detail_id", "contract_message_id", "contract_id"};
}
