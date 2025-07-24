package pomplatform.plateSalaryAdvanceRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateSalaryAdvanceRecord.bean.BasePlateSalaryAdvanceRecord;
import pomplatform.plateSalaryAdvanceRecord.bean.ConditionPlateSalaryAdvanceRecord;

public class QueryPlateSalaryAdvanceRecord extends AbstractQuery<BasePlateSalaryAdvanceRecord, ConditionPlateSalaryAdvanceRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateSalaryAdvanceRecord.class);

	public QueryPlateSalaryAdvanceRecord() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("psar.plate_salary_advance_record_id");
	}

	@Override
	public BaseCollection<BasePlateSalaryAdvanceRecord> executeQuery( KeyValuePair[] replacements, ConditionPlateSalaryAdvanceRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getRecordYear(), 
				condition.getRecordMonth(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BasePlateSalaryAdvanceRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateSalaryAdvanceRecord __base = new BasePlateSalaryAdvanceRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateSalaryAdvanceRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalaryReturn(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT psar.plate_salary_advance_record_id, psar.plate_id, psar.employee_id, psar.employee_no, psar.employee_name, psar.salary_return, psar.record_date FROM plate_salary_advance_records psar WHERE psar.plate_id = ? AND extract(year from psar.record_date) = ? AND extract(month from psar.record_date) = ? AND psar.employee_no LIKE ? AND psar.employee_id = ? ORDER BY psar.record_date DESC, psar.plate_salary_advance_record_id DESC, psar.employee_id" ;
	private final static String RESULTSETFIELDLIST = "plate_salary_advance_record_id,plate_id,employee_id,employee_no,employee_name,salary_return,record_date";
	private final static String[] fieldNames = { "plate_id", "recordYear", "recordMonth", "employee_no", "employee_id"};
}
