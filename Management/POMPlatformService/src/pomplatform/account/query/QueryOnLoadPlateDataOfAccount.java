package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadPlateDataOfAccount;
import pomplatform.account.bean.ConditionOnLoadPlateDataOfAccount;

public class QueryOnLoadPlateDataOfAccount extends AbstractQuery<BaseOnLoadPlateDataOfAccount, ConditionOnLoadPlateDataOfAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadPlateDataOfAccount.class);

	public QueryOnLoadPlateDataOfAccount() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseOnLoadPlateDataOfAccount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadPlateDataOfAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseOnLoadPlateDataOfAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadPlateDataOfAccount __base = new BaseOnLoadPlateDataOfAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDicTypeValue(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select a.plate_id,a.business_type_id,b.dic_type_value,sum(a.integral) as integral from plate_account_records a left join system_dictionary b on a.business_type_id = b.dic_type_value_id and b.dic_type_id = 65 where a.plate_id = ? and a.record_date BETWEEN ? AND ? GROUP BY a.plate_id,a.business_type_id,b.parent_id,b.dic_type_value ORDER BY a.plate_id,a.business_type_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,business_type_id,dic_type_value,integral";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date"};
}
