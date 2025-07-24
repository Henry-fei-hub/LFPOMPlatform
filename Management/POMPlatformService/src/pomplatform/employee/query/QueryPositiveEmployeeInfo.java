package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BasePositiveEmployeeInfo;
import pomplatform.employee.bean.ConditionPositiveEmployeeInfo;

public class QueryPositiveEmployeeInfo extends AbstractQuery<BasePositiveEmployeeInfo, ConditionPositiveEmployeeInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryPositiveEmployeeInfo.class);

	public QueryPositiveEmployeeInfo() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BasePositiveEmployeeInfo> executeQuery( KeyValuePair[] replacements, ConditionPositiveEmployeeInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(),
				condition.getEmployeeId()
			);
	}

	@Override
	public BasePositiveEmployeeInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BasePositiveEmployeeInfo __base = new BasePositiveEmployeeInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPositiveDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTryTimePay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPositivePay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAnnualPerformance(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT a.employee_id, a.employee_no, a.employee_name, a.department_id, a.onboard_date, a.duty_id, a.company_id, a.positive_date, a.grade_id, a.try_time_pay, a.positive_pay, a.annual_performance from (select e.employee_id, e.employee_no, e.employee_name, e.department_id, e.onboard_date, e.duty_id, e.company_id, e.positive_date, e.grade_id, e.try_time_pay, e.positive_pay, e.annual_performance, count(c.process_instance_id) as num  from employees e left JOIN personnel_business b on e.employee_id = b.employee_id and b.process_type = 29 and b.delete_flag = 0 LEFT JOIN system_process_instances c on b.process_type = c.process_type and b.personnel_business_id = c.business_id and c.process_status in (0,1,3) where extract(year from e.positive_date) = ? and extract(month from e.positive_date) = ? and e.employee_id = ? and e.onboard_status = 1 and e.status = 0 GROUP BY e.employee_id, e.employee_no, e.employee_name, e.department_id, e.onboard_date, e.duty_id, e.company_id, e.positive_date, e.grade_id, e.try_time_pay, e.positive_pay, e.annual_performance) a where a.num = 0 order by a.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,onboard_date,duty_id,company_id,positive_date,grade_id,try_time_pay,positive_pay, annual_performance";
	private final static String[] fieldNames = { "year", "month", "employee_id"};
}
