package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseOnboardEmployeeEachYear;
import pomplatform.employee.bean.ConditionOnboardEmployeeEachYear;

public class QueryOnboardEmployeeEachYear extends AbstractQuery<BaseOnboardEmployeeEachYear, ConditionOnboardEmployeeEachYear>
{

	private static final Logger __logger = Logger.getLogger(QueryOnboardEmployeeEachYear.class);

	public QueryOnboardEmployeeEachYear() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.plate_id");
	}

	@Override
	public BaseCollection<BaseOnboardEmployeeEachYear> executeQuery( KeyValuePair[] replacements, ConditionOnboardEmployeeEachYear condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnboardEmployeeEachYear generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnboardEmployeeEachYear __base = new BaseOnboardEmployeeEachYear();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT pd.plate_id,EXTRACT(YEAR FROM e.onboard_date) as year ,count(e.employee_id) as num FROM plate_departments pd LEFT JOIN employees	 e  on pd.department_id = e.department_id WHERE e.onboard_date is not null AND EXTRACT(YEAR FROM e.onboard_date) = ? AND EXTRACT(MONTH FROM e.onboard_date) = ? AND pd.plate_id = ? GROUP BY pd.plate_id ,year ORDER BY pd.plate_id ,year" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,num";
	private final static String[] fieldNames = { "year", "month", "plate_id"};
}
