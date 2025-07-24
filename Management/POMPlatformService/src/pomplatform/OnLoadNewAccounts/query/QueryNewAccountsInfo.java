package pomplatform.OnLoadNewAccounts.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnLoadNewAccounts.bean.BaseNewAccountsInfo;
import pomplatform.OnLoadNewAccounts.bean.ConditionNewAccountsInfo;

public class QueryNewAccountsInfo extends AbstractQuery<BaseNewAccountsInfo, ConditionNewAccountsInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryNewAccountsInfo.class);

	public QueryNewAccountsInfo() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("na.account_id");
	}

	@Override
	public BaseCollection<BaseNewAccountsInfo> executeQuery( KeyValuePair[] replacements, ConditionNewAccountsInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAccountId(), 
				condition.getAccountType(), 
				condition.getAccountCode(), 
				condition.getAccountName(), 
				condition.getOwnerId(), 
				condition.getStatus(), 
				condition.getBalance(), 
				condition.getFreezingBalance(), 
				condition.getOperator(), 
				condition.getCreateTime(), 
				condition.getOrderId()
			);
	}

	@Override
	public BaseNewAccountsInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseNewAccountsInfo __base = new BaseNewAccountsInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAccountId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccountName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOwnerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBalance(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setFreezingBalance(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOrderId(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[6]));
		if(args[7] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
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

	private final static String __SQLText = "select na.account_id, na.account_type, na.account_code, na.account_name, na.owner_id, na.status, na.balance, na.freezing_balance, na.operator, na.create_time, na.order_id from new_accounts na where na.account_id = ? and na.account_type = ? and na.account_code = ? and na.account_name = ? and na.owner_id = ? and na.status = ? and na.balance = ? and na.freezing_balance = ? and na.operator = ? and na.create_time = ? and na.order_id = ?" ;
	private final static String RESULTSETFIELDLIST = "account_id,account_type,account_code,account_name,owner_id,status,balance,freezing_balance,operator,create_time,order_id";
	private final static String[] fieldNames = { "account_id", "account_type", "account_code", "account_name", "owner_id", "status", "balance", "freezing_balance", "operator", "create_time", "order_id"};
}
