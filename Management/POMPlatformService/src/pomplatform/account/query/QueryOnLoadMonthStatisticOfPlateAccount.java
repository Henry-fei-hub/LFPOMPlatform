package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadMonthStatisticOfPlateAccount;
import pomplatform.account.bean.ConditionOnLoadMonthStatisticOfPlateAccount;

public class QueryOnLoadMonthStatisticOfPlateAccount extends AbstractQuery<BaseOnLoadMonthStatisticOfPlateAccount, ConditionOnLoadMonthStatisticOfPlateAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadMonthStatisticOfPlateAccount.class);

	public QueryOnLoadMonthStatisticOfPlateAccount() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("plate_id");
	}

	@Override
	public BaseCollection<BaseOnLoadMonthStatisticOfPlateAccount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadMonthStatisticOfPlateAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getBusinessTypeId()
			);
	}

	@Override
	public BaseOnLoadMonthStatisticOfPlateAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadMonthStatisticOfPlateAccount __base = new BaseOnLoadMonthStatisticOfPlateAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select abc.plate_id,abc.business_type_id,sum(abc.integral) as integral,EXTRACT(YEAR from abc.record_date) as year,EXTRACT(MONTH from abc.record_date) as month FROM ( select a.plate_id,b.business_type_id,b.integral,b.record_date from plate_records a LEFT JOIN plate_account_records b on b.plate_id = a.plate_id where a.plate_id = ? and b.record_date BETWEEN ? AND ? and b.business_type_id = ? ) as abc GROUP BY abc.plate_id,abc.business_type_id,EXTRACT(YEAR from abc.record_date),EXTRACT(MONTH from abc.record_date) ORDER BY EXTRACT(YEAR from abc.record_date),EXTRACT(MONTH from abc.record_date)" ;
	private final static String RESULTSETFIELDLIST = "plate_id,business_type_id,integral,year,month";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date", "business_type_id"};
}
