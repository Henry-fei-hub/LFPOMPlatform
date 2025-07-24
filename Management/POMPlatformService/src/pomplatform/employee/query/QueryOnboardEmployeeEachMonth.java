package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseOnboardEmployeeEachMonth;
import pomplatform.employee.bean.ConditionOnboardEmployeeEachMonth;

public class QueryOnboardEmployeeEachMonth extends AbstractQuery<BaseOnboardEmployeeEachMonth, ConditionOnboardEmployeeEachMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryOnboardEmployeeEachMonth.class);

	public QueryOnboardEmployeeEachMonth() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pd.plate_id");
	}

	@Override
	public BaseCollection<BaseOnboardEmployeeEachMonth> executeQuery( KeyValuePair[] replacements, ConditionOnboardEmployeeEachMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseOnboardEmployeeEachMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnboardEmployeeEachMonth __base = new BaseOnboardEmployeeEachMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT pd.plate_id, pd.department_id, EXTRACT ( YEAR FROM e.onboard_date ) AS YEAR, EXTRACT ( MONTH FROM e.onboard_date ) AS MONTH, COUNT ( e.employee_id ) AS num FROM plate_departments pd LEFT JOIN employees e on pd.department_id = e.department_id WHERE e.onboard_date IS NOT NULL AND EXTRACT ( YEAR FROM e.onboard_date ) =? AND pd.plate_id =? AND e.onboard_date BETWEEN ? AND ? GROUP BY pd.plate_id, pd.department_id, YEAR, MONTH ORDER BY pd.plate_id, pd.department_id, YEAR, MONTH" ;
	private final static String RESULTSETFIELDLIST = "plate_id,department_id,year,month,num";
	private final static String[] fieldNames = { "year", "plate_id", "start_date", "end_date"};
}
