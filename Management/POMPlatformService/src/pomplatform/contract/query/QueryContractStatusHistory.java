package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseContractStatusHistory;
import pomplatform.contract.bean.ConditionContractStatusHistory;

public class QueryContractStatusHistory extends AbstractQuery<BaseContractStatusHistory, ConditionContractStatusHistory>
{

	private static final Logger __logger = Logger.getLogger(QueryContractStatusHistory.class);

	public QueryContractStatusHistory() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_id");
	}

	@Override
	public BaseCollection<BaseContractStatusHistory> executeQuery( KeyValuePair[] replacements, ConditionContractStatusHistory condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartTime(), 
				condition.getEndTime(), 
				condition.getContractStatus(),
				condition.getContractCode(),
				condition.getContractName()
			);
	}

	@Override
	public BaseContractStatusHistory generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractStatusHistory __base = new BaseContractStatusHistory();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSigningCompanyName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "SELECT a.contract_id, b.contract_code, b.contract_name, b.customer_name, b.signing_money_sum, b.signing_company_name, case when a.new_status = 3 and b.contract_status != 3 then b.contract_status else a.new_status end as contract_status, a.operate_time from contract_logs a LEFT JOIN contracts b on a.contract_id = b.contract_id where (a.process_status = 3 or a.process_status is null) and a.operate_time >= ? and a.operate_time < ? and a.delete_flag = 0 and a.new_status = ? and not exists(select 1 from contract_logs c where c.contract_id=a.contract_id and c.operate_time>a.operate_time) and b.contract_code like ? and b.contract_name like ?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,signing_money_sum,signing_company_name,contract_status,operate_time";
	private final static String[] fieldNames = { "start_time", "end_time", "contract_status", "contract_code", "contract_name"};
}
