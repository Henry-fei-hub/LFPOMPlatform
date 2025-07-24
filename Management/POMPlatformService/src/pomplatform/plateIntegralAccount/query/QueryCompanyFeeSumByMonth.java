package pomplatform.plateIntegralAccount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateIntegralAccount.bean.BaseQualityFeeSumByMonth;
import pomplatform.plateIntegralAccount.bean.ConditionQualityFeeSumByMonth;

public class QueryCompanyFeeSumByMonth extends AbstractQuery<BaseQualityFeeSumByMonth, ConditionQualityFeeSumByMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryCompanyFeeSumByMonth.class);

	public QueryCompanyFeeSumByMonth() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
	}

	@Override
	public BaseCollection<BaseQualityFeeSumByMonth> executeQuery( KeyValuePair[] replacements, ConditionQualityFeeSumByMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseQualityFeeSumByMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseQualityFeeSumByMonth __base = new BaseQualityFeeSumByMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSendYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSendMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSendIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT extract(year from a.send_date) as send_year, extract(month from a.send_date) as send_month, SUM(a.send_integral) as send_integral FROM plate_integral_achieves a WHERE a.from_plate_id = ? AND a.send_date >= ? AND a.send_date <= ? and a.to_plate_id = 0 GROUP BY send_year, send_month ORDER BY send_year, send_month" ;
	private final static String RESULTSETFIELDLIST = "send_year,send_month,send_integral";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date"};
}
