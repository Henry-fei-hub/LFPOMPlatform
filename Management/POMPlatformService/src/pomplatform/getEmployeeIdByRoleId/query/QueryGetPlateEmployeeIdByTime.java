package pomplatform.getEmployeeIdByRoleId.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.getEmployeeIdByRoleId.bean.BaseGetPlateEmployeeIdByTime;
import pomplatform.getEmployeeIdByRoleId.bean.ConditionGetPlateEmployeeIdByTime;

public class QueryGetPlateEmployeeIdByTime extends AbstractQuery<BaseGetPlateEmployeeIdByTime, ConditionGetPlateEmployeeIdByTime>
{

	private static final Logger __logger = Logger.getLogger(QueryGetPlateEmployeeIdByTime.class);

	public QueryGetPlateEmployeeIdByTime() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseGetPlateEmployeeIdByTime> executeQuery( KeyValuePair[] replacements, ConditionGetPlateEmployeeIdByTime condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseGetPlateEmployeeIdByTime generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetPlateEmployeeIdByTime __base = new BaseGetPlateEmployeeIdByTime();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setChangePlateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
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

	private final static String __SQLText = "SELECT a.employee_id, a.change_plate_date, b.employee_no , b.employee_name from employee_change_plate_records a LEFT JOIN employees b on a.employee_id = b.employee_id WHERE a.change_plate_date >= ? and a.change_plate_date <= ? and a.plate_id = ? and b.status != 0" ;
	private final static String RESULTSETFIELDLIST = "employee_id,change_plate_date,employee_no,employee_name";
	private final static String[] fieldNames = { "start_date", "end_date", "plate_id"};
}
