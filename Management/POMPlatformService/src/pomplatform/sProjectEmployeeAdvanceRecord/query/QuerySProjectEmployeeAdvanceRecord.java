package pomplatform.sProjectEmployeeAdvanceRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sProjectEmployeeAdvanceRecord.bean.BaseSProjectEmployeeAdvanceRecord;
import pomplatform.sProjectEmployeeAdvanceRecord.bean.ConditionSProjectEmployeeAdvanceRecord;

public class QuerySProjectEmployeeAdvanceRecord extends AbstractQuery<BaseSProjectEmployeeAdvanceRecord, ConditionSProjectEmployeeAdvanceRecord>
{

	private static final Logger __logger = Logger.getLogger(QuerySProjectEmployeeAdvanceRecord.class);

	public QuerySProjectEmployeeAdvanceRecord() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseSProjectEmployeeAdvanceRecord> executeQuery( KeyValuePair[] replacements, ConditionSProjectEmployeeAdvanceRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseSProjectEmployeeAdvanceRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSProjectEmployeeAdvanceRecord __base = new BaseSProjectEmployeeAdvanceRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAdvanceYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAdvanceMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.employee_id, extract(year from a.advance_date) as advance_year, extract(month from a.advance_date) as advance_month, sum(a.advanced_integral) as advance_integral from project_employee_advance_records a WHERE a.employee_id = ? AND a.advance_date >= ? AND a.advance_date <= ? GROUP BY a.employee_id, advance_year, advance_month ORDER BY advance_year, advance_month" ;
	private final static String RESULTSETFIELDLIST = "employee_id,advance_year,advance_month,advance_integral";
	private final static String[] fieldNames = { "employee_id", "start_date", "end_date"};
}
