package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadMonthDataOfAccount;
import pomplatform.account.bean.ConditionOnLoadMonthDataOfAccount;

public class QueryOnLoadMonthDataOfAccount extends AbstractQuery<BaseOnLoadMonthDataOfAccount, ConditionOnLoadMonthDataOfAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadMonthDataOfAccount.class);

	public QueryOnLoadMonthDataOfAccount() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("account_type_id");
	}

	@Override
	public BaseCollection<BaseOnLoadMonthDataOfAccount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadMonthDataOfAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAccountTypeId(), 
				condition.getAccountId(), 
				condition.getBusinessTypeId()
			);
	}

	@Override
	public BaseOnLoadMonthDataOfAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadMonthDataOfAccount __base = new BaseOnLoadMonthDataOfAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAccountTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select account_type_id,account_id,business_type_id,sum(achieve_integral) as achieve_integral,sum(pay_integral) as pay_integral ,EXTRACT(YEAR from record_date) as year,EXTRACT(MONTH from record_date) as month from account_records where account_type_id = ? and account_id = ? and business_type_id = ? GROUP BY account_type_id,account_id,business_type_id,EXTRACT(YEAR from record_date),EXTRACT(MONTH from record_date) ORDER BY EXTRACT(YEAR from record_date),EXTRACT(MONTH from record_date)" ;
	private final static String RESULTSETFIELDLIST = "account_type_id,account_id,business_type_id,achieve_integral,pay_integral,year,month";
	private final static String[] fieldNames = { "account_type_id", "account_id", "business_type_id"};
}
