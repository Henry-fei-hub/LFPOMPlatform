package pomplatform.EmployeeDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.EmployeeDetail.bean.BaseSalaryAdvanceDetail;
import pomplatform.EmployeeDetail.bean.ConditionSalaryAdvanceDetail;

public class QuerySalaryAdvanceDetail extends AbstractQuery<BaseSalaryAdvanceDetail, ConditionSalaryAdvanceDetail>
{

	private static final Logger __logger = Logger.getLogger(QuerySalaryAdvanceDetail.class);

	public QuerySalaryAdvanceDetail() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseSalaryAdvanceDetail> executeQuery( KeyValuePair[] replacements, ConditionSalaryAdvanceDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseSalaryAdvanceDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSalaryAdvanceDetail __base = new BaseSalaryAdvanceDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalaryReturn(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select employee_id,employee_no,salary_return,plate_id,record_date from plate_salary_advance_records where record_date >= ? and record_date <= ? and employee_id = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,salary_return,plate_id,record_date";
	private final static String[] fieldNames = { "start_date", "end_date", "employee_id"};
}
