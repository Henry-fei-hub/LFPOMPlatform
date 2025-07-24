package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadBusinessTypeDataOfAccount;
import pomplatform.account.bean.ConditionOnLoadBusinessTypeDataOfAccount;

public class QueryOnLoadBusinessTypeDataOfAccount extends AbstractQuery<BaseOnLoadBusinessTypeDataOfAccount, ConditionOnLoadBusinessTypeDataOfAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadBusinessTypeDataOfAccount.class);

	public QueryOnLoadBusinessTypeDataOfAccount() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.account_type_id");
	}

	@Override
	public BaseCollection<BaseOnLoadBusinessTypeDataOfAccount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadBusinessTypeDataOfAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAccountTypeId(), 
				condition.getAccountId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseOnLoadBusinessTypeDataOfAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadBusinessTypeDataOfAccount __base = new BaseOnLoadBusinessTypeDataOfAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAccountTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
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

	private final static String __SQLText = "select a.account_type_id,a.account_id,a.business_type_id,b.dic_type_value as business_type_name ,sum(achieve_integral) as achieve_integral,sum(pay_integral) as pay_integral from account_records a left join system_dictionary b on b.dic_type_id = 85 and a.business_type_id = b.dic_type_value_id where a.account_type_id = ? and a.account_id = ? and a.record_date BETWEEN ? AND ? GROUP BY a.account_type_id,a.account_id,a.business_type_id,b.dic_type_value ORDER BY a.account_id,a.business_type_id" ;
	private final static String RESULTSETFIELDLIST = "account_type_id,account_id,business_type_id,business_type_name,achieve_integral,pay_integral";
	private final static String[] fieldNames = { "account_type_id", "account_id", "start_date", "end_date"};
}
