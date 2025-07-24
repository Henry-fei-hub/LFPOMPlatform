package pomplatform.EmployeeAchieveIntegralReturnRecordByEmoloyee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.EmployeeAchieveIntegralReturnRecordByEmoloyee.bean.BaseEmployeeAchieveIntegralReturnRecordByEmoloyee;
import pomplatform.EmployeeAchieveIntegralReturnRecordByEmoloyee.bean.ConditionEmployeeAchieveIntegralReturnRecordByEmoloyee;

public class QueryEmployeeAchieveIntegralReturnRecordByEmoloyee extends AbstractQuery<BaseEmployeeAchieveIntegralReturnRecordByEmoloyee, ConditionEmployeeAchieveIntegralReturnRecordByEmoloyee>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeAchieveIntegralReturnRecordByEmoloyee.class);

	public QueryEmployeeAchieveIntegralReturnRecordByEmoloyee() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("plate_id");
	}

	@Override
	public BaseCollection<BaseEmployeeAchieveIntegralReturnRecordByEmoloyee> executeQuery( KeyValuePair[] replacements, ConditionEmployeeAchieveIntegralReturnRecordByEmoloyee condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getRecordYear(), 
				condition.getRecordMonth(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(),
				condition.getStatus()
			);
	}

	@Override
	public BaseEmployeeAchieveIntegralReturnRecordByEmoloyee generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeAchieveIntegralReturnRecordByEmoloyee __base = new BaseEmployeeAchieveIntegralReturnRecordByEmoloyee();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "select plate_id,employee_id,employee_no,employee_name,sum(achieve_integral) as achieve_integral,status from employee_achieve_integral_return_records where plate_id = ? and extract(year from record_date) = ? and extract(month from record_date) = ? and employee_no like ? and employee_name like ? and status = ? group by plate_id,employee_id,employee_no,employee_name,status order by achieve_integral desc" ;
	private final static String RESULTSETFIELDLIST = "plate_id,employee_id,employee_no,employee_name,achieve_integral,status";
	private final static String[] fieldNames = { "plate_id", "record_year", "record_month", "employee_no", "employee_name","status"};
}
