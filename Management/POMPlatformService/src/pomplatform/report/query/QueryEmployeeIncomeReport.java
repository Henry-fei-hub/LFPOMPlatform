package pomplatform.report.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseEmployeeIncomeReport;
import pomplatform.report.bean.ConditionEmployeeIncomeReport;

public class QueryEmployeeIncomeReport extends AbstractQuery<BaseEmployeeIncomeReport, ConditionEmployeeIncomeReport>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeIncomeReport.class);

	public QueryEmployeeIncomeReport() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("EXTRACT ( YEAR FROM ea.record_date ) AS YEAR");
	}

	@Override
	public BaseCollection<BaseEmployeeIncomeReport> executeQuery(KeyValuePair[] replacements, ConditionEmployeeIncomeReport condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseEmployeeIncomeReport generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeIncomeReport __base = new BaseEmployeeIncomeReport();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT EXTRACT ( YEAR FROM ea.record_date ) AS YEAR, EXTRACT ( MONTH FROM ea.record_date ) AS MONTH, ea.business_type_id, SUM ( ea.integral ) AS integral FROM employee_account_records ea LEFT JOIN employee_day_plate_records ed ON ed.employee_id = ea.employee_id and ea.record_date = ed.record_date where ed.year =? and ed.month =? and ed.plate_id =? and ea.business_type_id in (1, 6) GROUP BY EXTRACT ( YEAR FROM ea.record_date ), EXTRACT ( MONTH FROM ea.record_date ), ea.business_type_id" ;
	private final static String RESULTSETFIELDLIST = "year,month,business_type_id,integral";
	private final static String[] fieldNames = { "year", "month", "plate_id"};
}
