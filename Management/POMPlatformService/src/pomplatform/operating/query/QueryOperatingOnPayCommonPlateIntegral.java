package pomplatform.operating.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operating.bean.BaseOperatingOnPayCommonPlateIntegral;
import pomplatform.operating.bean.ConditionOperatingOnPayCommonPlateIntegral;

public class QueryOperatingOnPayCommonPlateIntegral extends AbstractQuery<BaseOperatingOnPayCommonPlateIntegral, ConditionOperatingOnPayCommonPlateIntegral>
{

	private static final Logger __logger = Logger.getLogger(QueryOperatingOnPayCommonPlateIntegral.class);

	public QueryOperatingOnPayCommonPlateIntegral() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.plate_id as own_plate_id");
	}

	@Override
	public BaseCollection<BaseOperatingOnPayCommonPlateIntegral> executeQuery( KeyValuePair[] replacements, ConditionOperatingOnPayCommonPlateIntegral condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseOperatingOnPayCommonPlateIntegral generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOperatingOnPayCommonPlateIntegral __base = new BaseOperatingOnPayCommonPlateIntegral();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOwnPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setManageProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAssignedIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAssignDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select c.plate_id as own_plate_id,a.manage_project_id,a.employee_id,a.assigned_integral,a.assign_date,b.year,b.month,b.plate_id from manage_project_employee_records a left join employee_change_plate_records b on a.employee_id = b.employee_id and extract(year from a.assign_date) = year and extract(month from a.assign_date) = month left join manage_projects c on a.manage_project_id = c.manage_project_id where c.plate_id = ? and b.plate_id <> ? and a.assign_date >= ? and a.assign_date < ?" ;
	private final static String RESULTSETFIELDLIST = "own_plate_id,manage_project_id,employee_id,assigned_integral,assign_date,year,month,plate_id";
	private final static String[] fieldNames = { "plate_id", "plate_id", "start_date", "end_date"};
}
