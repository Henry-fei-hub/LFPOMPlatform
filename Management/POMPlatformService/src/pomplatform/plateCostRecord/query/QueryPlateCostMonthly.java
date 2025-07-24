package pomplatform.plateCostRecord.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.plateCostRecord.bean.BasePlateCostMonthly;
import pomplatform.plateCostRecord.bean.ConditionPlateCostMonthly;

public class QueryPlateCostMonthly extends AbstractQuery<BasePlateCostMonthly, ConditionPlateCostMonthly>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateCostMonthly.class);

	public QueryPlateCostMonthly() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BasePlateCostMonthly> executeQuery( KeyValuePair[] replacements, ConditionPlateCostMonthly condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BasePlateCostMonthly generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateCostMonthly __base = new BasePlateCostMonthly();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordMonth(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.plate_id, extract(year from record_date) as record_year, extract(month from record_date) as record_month, sum(a.integral) as integral from plate_account_records a where a.business_type_id = 7 and a.plate_id = ? and a.record_date >= ? and a.record_date <= ? GROUP BY a.plate_id,record_year,record_month ORDER BY record_year,record_month" ;
	private final static String RESULTSETFIELDLIST = "plate_id,record_year,record_month,integral";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date"};
}
