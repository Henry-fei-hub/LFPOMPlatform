package pomplatform.employeeSalaryReturnRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeSalaryReturnRecord.bean.BaseEmployeeSalaryReturnRecord;
import pomplatform.employeeSalaryReturnRecord.bean.ConditionEmployeeSalaryReturnRecord;

public class QueryEmployeeSalaryReturnRecord extends AbstractQuery<BaseEmployeeSalaryReturnRecord, ConditionEmployeeSalaryReturnRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeSalaryReturnRecord.class);

	public QueryEmployeeSalaryReturnRecord() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("esrr.employee_salary_return_record_id");
	}

	@Override
	public BaseCollection<BaseEmployeeSalaryReturnRecord> executeQuery( KeyValuePair[] replacements, ConditionEmployeeSalaryReturnRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getRecordYear(), 
				condition.getRecordMonth(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseEmployeeSalaryReturnRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeSalaryReturnRecord __base = new BaseEmployeeSalaryReturnRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeSalaryReturnRecordId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT esrr.employee_salary_return_record_id, esrr.plate_id, esrr.employee_id, esrr.employee_no, esrr.employee_name, esrr.salary_return, esrr.record_date from employee_salary_return_records esrr WHERE esrr.plate_id = ? AND extract(year from esrr.record_date) = ? AND extract(month from esrr.record_date) = ? AND esrr.employee_no like ? AND esrr.employee_id = ? ORDER BY esrr.record_date DESC, esrr.employee_salary_return_record_id DESC, esrr.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_salary_return_record_id,plate_id,employee_id,employee_no,employee_name,salary_return,record_date";
	private final static String[] fieldNames = { "plate_id", "record_year", "record_month", "employee_no", "employee_id"};
}
