package pomplatform.contractchange.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.contractchange.bean.BaseContractChangeList;
import pomplatform.contractchange.bean.ConditionContractChangeList;

public class QueryContractChangeList extends AbstractQuery<BaseContractChangeList, ConditionContractChangeList>
{

	private static final Logger __logger = Logger.getLogger(QueryContractChangeList.class);

	public QueryContractChangeList() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_id");
	}

	@Override
	public BaseCollection<BaseContractChangeList> executeQuery( KeyValuePair[] replacements, ConditionContractChangeList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getFlag(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseContractChangeList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractChangeList __base = new BaseContractChangeList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractChangeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "SELECT a.contract_change_id, a.contract_id, b.contract_code, b.contract_name, b.customer_name, b.signing_money_sum, a.flag,a.operate_time from contract_changes a LEFT JOIN contracts b on a.contract_id = b.contract_id where a.flag = ? and a.contract_id = ? and b.contract_code like ? and a.operate_time >= ? and a.operate_time < ?" ;
	private final static String RESULTSETFIELDLIST = "contract_change_id,contract_id,contract_code,contract_name,customer_name,signing_money_sum,flag,operate_time";
	private final static String[] fieldNames = { "flag", "contract_id", "contract_code", "start_time", "end_time"};
}
