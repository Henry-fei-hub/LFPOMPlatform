package pomplatform.sEmployeeSalaryReturnEachMonthRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sEmployeeSalaryReturnEachMonthRecord.bean.BaseSEmployeeSalaryReturnEachMonthRecord;
import pomplatform.sEmployeeSalaryReturnEachMonthRecord.bean.ConditionSEmployeeSalaryReturnEachMonthRecord;

public class QuerySEmployeeSalaryReturnEachMonthRecord extends AbstractQuery<BaseSEmployeeSalaryReturnEachMonthRecord, ConditionSEmployeeSalaryReturnEachMonthRecord>
{

	private static final Logger __logger = Logger.getLogger(QuerySEmployeeSalaryReturnEachMonthRecord.class);

	public QuerySEmployeeSalaryReturnEachMonthRecord() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("esrr.plate_id");
	}

	@Override
	public BaseCollection<BaseSEmployeeSalaryReturnEachMonthRecord> executeQuery( KeyValuePair[] replacements, ConditionSEmployeeSalaryReturnEachMonthRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseSEmployeeSalaryReturnEachMonthRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSEmployeeSalaryReturnEachMonthRecord __base = new BaseSEmployeeSalaryReturnEachMonthRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSalaryReturn(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT esrr.plate_id, extract(year from esrr.record_date) as record_year, extract(month from esrr.record_date) as record_month, sum(esrr.salary_return) as salary_return from employee_salary_return_records esrr WHERE esrr.plate_id = ? AND esrr.record_date >= ? AND esrr.record_date <= ? GROUP BY esrr.plate_id, record_year, record_month ORDER BY record_year, record_month" ;
	private final static String RESULTSETFIELDLIST = "plate_id,record_year,record_month,salary_return";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date"};
}
