package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnGetLeftIntegralOfPlate;
import pomplatform.account.bean.ConditionOnGetLeftIntegralOfPlate;

public class QueryOnGetLeftIntegralOfPlate extends AbstractQuery<BaseOnGetLeftIntegralOfPlate, ConditionOnGetLeftIntegralOfPlate>
{

	private static final Logger __logger = Logger.getLogger(QueryOnGetLeftIntegralOfPlate.class);

	public QueryOnGetLeftIntegralOfPlate() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.plate_id");
	}

	@Override
	public BaseCollection<BaseOnGetLeftIntegralOfPlate> executeQuery( KeyValuePair[] replacements, ConditionOnGetLeftIntegralOfPlate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseOnGetLeftIntegralOfPlate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnGetLeftIntegralOfPlate __base = new BaseOnGetLeftIntegralOfPlate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select abc.plate_id,sum(abc.integral) as integral from ( select a.plate_id,b.business_type_id,case when c.parent_id = -1 then -(sum(b.integral)) else sum(b.integral) end as integral,c.dic_type_value from plate_records a LEFT JOIN plate_account_records b on b.plate_id = a.plate_id LEFT JOIN system_dictionary c on c.dic_type_id = 65 and b.business_type_id = c.dic_type_value_id  where a.plate_id = ? AND record_date BETWEEN ? AND ? GROUP BY a.plate_id,b.business_type_id,c.parent_id,c.dic_type_value ) as abc GROUP BY abc.plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,integral";
	private final static String[] fieldNames = { "plate_id","start_date","end_date"};
}
