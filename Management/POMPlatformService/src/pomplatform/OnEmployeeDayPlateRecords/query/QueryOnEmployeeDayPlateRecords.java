package pomplatform.OnEmployeeDayPlateRecords.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnEmployeeDayPlateRecords.bean.BaseOnEmployeeDayPlateRecords;
import pomplatform.OnEmployeeDayPlateRecords.bean.ConditionOnEmployeeDayPlateRecords;

public class QueryOnEmployeeDayPlateRecords extends AbstractQuery<BaseOnEmployeeDayPlateRecords, ConditionOnEmployeeDayPlateRecords>
{

	private static final Logger __logger = Logger.getLogger(QueryOnEmployeeDayPlateRecords.class);

	public QueryOnEmployeeDayPlateRecords() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_day_plate_record_id");
	}

	@Override
	public BaseCollection<BaseOnEmployeeDayPlateRecords> executeQuery( KeyValuePair[] replacements, ConditionOnEmployeeDayPlateRecords condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getRecordDate(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnEmployeeDayPlateRecords generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnEmployeeDayPlateRecords __base = new BaseOnEmployeeDayPlateRecords();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeDayPlateRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardStatus(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT employee_day_plate_record_id,employee_id,employee_no,employee_name,record_date,year,month,company_id,plate_id,department_id,onboard_status FROM employee_day_plate_records WHERE employee_no like ? AND employee_id = ? AND plate_id = ? AND record_date = ? AND year = ? and month = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_day_plate_record_id,employee_id,employee_no,employee_name,record_date,year,month,company_id,plate_id,department_id,onboard_status";
	private final static String[] fieldNames = { "employee_no", "employee_id", "plate_id", "record_date", "year", "month"};
}
