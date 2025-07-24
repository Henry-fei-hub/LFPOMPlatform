package pomplatform.sProjectAdvanceRecordEachMonth.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sProjectAdvanceRecordEachMonth.bean.BaseSProjectAdvanceRecordEachMonth;
import pomplatform.sProjectAdvanceRecordEachMonth.bean.ConditionSProjectAdvanceRecordEachMonth;

public class QuerySProjectAdvanceRecordEachMonth extends AbstractQuery<BaseSProjectAdvanceRecordEachMonth, ConditionSProjectAdvanceRecordEachMonth>
{

	private static final Logger __logger = Logger.getLogger(QuerySProjectAdvanceRecordEachMonth.class);

	public QuerySProjectAdvanceRecordEachMonth() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseSProjectAdvanceRecordEachMonth> executeQuery( KeyValuePair[] replacements, ConditionSProjectAdvanceRecordEachMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseSProjectAdvanceRecordEachMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSProjectAdvanceRecordEachMonth __base = new BaseSProjectAdvanceRecordEachMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAdvanceYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAdvanceMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.plate_id, extract(year from a.advance_date) as advance_year, extract(month from a.advance_date) as advance_month, SUM(a.advance_integral) as advance_integral, SUM(a.left_integral) as left_integral FROM project_advance_records a WHERE a.plate_id = ? AND a.advance_date >= ? AND a.advance_date <= ? GROUP BY a.plate_id, advance_year, advance_month ORDER BY a.plate_id, advance_year, advance_month" ;
	private final static String RESULTSETFIELDLIST = "plate_id,advance_year,advance_month,advance_integral,left_integral";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date"};
}
