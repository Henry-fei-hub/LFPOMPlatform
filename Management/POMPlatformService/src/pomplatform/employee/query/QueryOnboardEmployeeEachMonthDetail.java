package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseOnboardEmployeeEachMonthDetail;
import pomplatform.employee.bean.ConditionOnboardEmployeeEachMonthDetail;

public class QueryOnboardEmployeeEachMonthDetail extends AbstractQuery<BaseOnboardEmployeeEachMonthDetail, ConditionOnboardEmployeeEachMonthDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryOnboardEmployeeEachMonthDetail.class);

	public QueryOnboardEmployeeEachMonthDetail() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseOnboardEmployeeEachMonthDetail> executeQuery( KeyValuePair[] replacements, ConditionOnboardEmployeeEachMonthDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth(),
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnboardEmployeeEachMonthDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnboardEmployeeEachMonthDetail __base = new BaseOnboardEmployeeEachMonthDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPositiveDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT e.employee_id,e.employee_name,e.employee_no,e.plate_id,e.department_id,e.onboard_date,e.positive_date,e.duty_id,spi.process_id,spi.business_id,spi.process_type,spi.process_instance_id FROM plate_departments pd LEFT JOIN employees e on pd.department_id = e.department_id LEFT JOIN system_process_instances spi ON e.employee_id = spi.business_id AND spi.process_type = 24 WHERE pd.plate_id = ? AND EXTRACT(YEAR FROM e.onboard_date) = ? AND EXTRACT(MONTH FROM e.onboard_date) = ? AND e.employee_id > 0 AND pd.department_id = ? ORDER BY employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_name,employee_no,plate_id,department_id,onboard_date,positive_date,duty_id,process_id,business_id,process_type,process_instance_id";
	private final static String[] fieldNames = { "plate_id", "year", "month","department_id"};
}
