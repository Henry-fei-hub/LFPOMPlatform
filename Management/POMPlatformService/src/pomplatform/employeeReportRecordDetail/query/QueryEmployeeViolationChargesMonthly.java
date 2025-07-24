package pomplatform.employeeReportRecordDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeReportRecordDetail.bean.BaseEmployeeViolationChargesMonthly;
import pomplatform.employeeReportRecordDetail.bean.ConditionEmployeeViolationChargesMonthly;

public class QueryEmployeeViolationChargesMonthly extends AbstractQuery<BaseEmployeeViolationChargesMonthly, ConditionEmployeeViolationChargesMonthly>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeViolationChargesMonthly.class);

	public QueryEmployeeViolationChargesMonthly() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
	}

	@Override
	public BaseCollection<BaseEmployeeViolationChargesMonthly> executeQuery( KeyValuePair[] replacements, ConditionEmployeeViolationChargesMonthly condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getEmployeeId(),
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseEmployeeViolationChargesMonthly generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeViolationChargesMonthly __base = new BaseEmployeeViolationChargesMonthly();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setViolationYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setViolationMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setViolationCharges(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT extract(year from a.violation_date) as violation_year, extract(month from a.violation_date) as violation_month, SUM(a.violation_charges) as violation_charges FROM employee_violation_charges a WHERE a.plate_id = ? AND employee_id = ? AND a.violation_date >= ? AND a.violation_date <= ? GROUP BY violation_year, violation_month ORDER BY violation_year, violation_month" ;
	private final static String RESULTSETFIELDLIST = "violation_year,violation_month,violation_charges";
	private final static String[] fieldNames = { "plate_id", "employee_id", "start_date", "end_date"};
}
