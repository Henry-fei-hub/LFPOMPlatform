package pomplatform.plateIntegralAssignRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateIntegralAssignRecord.bean.BasePlateIntegralAssignRecord;
import pomplatform.plateIntegralAssignRecord.bean.ConditionPlateIntegralAssignRecord;

public class QueryPlateIntegralAssignRecord extends AbstractQuery<BasePlateIntegralAssignRecord, ConditionPlateIntegralAssignRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateIntegralAssignRecord.class);

	public QueryPlateIntegralAssignRecord() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("piar.plate_integral_assign_record_id");
	}

	@Override
	public BaseCollection<BasePlateIntegralAssignRecord> executeQuery( KeyValuePair[] replacements, ConditionPlateIntegralAssignRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BasePlateIntegralAssignRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateIntegralAssignRecord __base = new BasePlateIntegralAssignRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateIntegralAssignRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAssignIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAssignDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT piar.plate_integral_assign_record_id,piar.plate_id,e.employee_no, piar.employee_id,piar.assign_integral,piar.assign_date,piar.plate_employee_id,piar.remark from plate_integral_assign_records piar LEFT JOIN employees e ON piar.employee_id = e.employee_id WHERE piar.plate_id = ? AND piar.assign_date >= ? AND piar.assign_date <= ? AND e.employee_no LIKE ? AND piar.employee_id = ? ORDER BY piar.assign_date DESC, piar.plate_integral_assign_record_id DESC, piar.employee_id" ;
	private final static String RESULTSETFIELDLIST = "plate_integral_assign_record_id,plate_id,employee_no,employee_id,assign_integral,assign_date,plate_employee_id,remark";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date", "employee_no", "employee_id"};
}
