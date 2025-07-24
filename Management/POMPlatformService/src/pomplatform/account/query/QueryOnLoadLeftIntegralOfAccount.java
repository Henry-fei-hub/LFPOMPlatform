package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadLeftIntegralOfAccount;
import pomplatform.account.bean.ConditionOnLoadLeftIntegralOfAccount;

public class QueryOnLoadLeftIntegralOfAccount extends AbstractQuery<BaseOnLoadLeftIntegralOfAccount, ConditionOnLoadLeftIntegralOfAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadLeftIntegralOfAccount.class);

	public QueryOnLoadLeftIntegralOfAccount() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sum(achieve_integral)-sum(pay_integral) as left_integral");
	}

	@Override
	public BaseCollection<BaseOnLoadLeftIntegralOfAccount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadLeftIntegralOfAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAccountTypeId(), 
				condition.getAccountId()
			);
	}

	@Override
	public BaseOnLoadLeftIntegralOfAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadLeftIntegralOfAccount __base = new BaseOnLoadLeftIntegralOfAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select sum(achieve_integral)-sum(pay_integral) as left_integral from account_records where account_type_id = ? and account_id = ? GROUP BY account_id" ;
	private final static String RESULTSETFIELDLIST = "left_integral";
	private final static String[] fieldNames = { "account_type_id", "account_id"};
}
