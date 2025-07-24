package pomplatform.employeeReportRecordDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeReportRecordDetail.bean.BaseEmployeeReportRecordDetail;
import pomplatform.employeeReportRecordDetail.bean.ConditionEmployeeReportRecordDetail;

public class QueryEmployeeReportRecordDetail extends AbstractQuery<BaseEmployeeReportRecordDetail, ConditionEmployeeReportRecordDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeReportRecordDetail.class);

	public QueryEmployeeReportRecordDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("err.plate_id");
	}

	@Override
	public BaseCollection<BaseEmployeeReportRecordDetail> executeQuery( KeyValuePair[] replacements, ConditionEmployeeReportRecordDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName()
			);
	}

	@Override
	public BaseEmployeeReportRecordDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeReportRecordDetail __base = new BaseEmployeeReportRecordDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setManagerProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalaryAdvance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalaryReturn(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAdvance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBonusPayment(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIntegralReturn(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setViolationCharges(GenericBase.__getDecimal(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "SELECT err.plate_id, err.employee_id, err.employee_name, err.employee_no, SUM(CASE WHEN err.achieve_integral IS NULL THEN 0 ELSE err.achieve_integral END) AS achieve_integral, SUM(CASE WHEN err.sure_integral IS NULL THEN 0 ELSE err.sure_integral END) AS sure_integral, SUM(CASE WHEN err.manager_project_integral IS NULL THEN 0 ELSE err.manager_project_integral END) AS manager_project_integral, SUM(CASE WHEN err.salary_advance IS NULL THEN 0 ELSE err.salary_advance END) AS salary_advance, SUM(CASE WHEN err.salary_return IS NULL THEN 0 ELSE err.salary_return END) AS salary_return, SUM(CASE WHEN err.salary IS NULL THEN 0 ELSE err.salary END) AS salary, SUM(CASE WHEN err.project_cost IS NULL THEN 0 ELSE err.project_cost END) AS project_cost, SUM(CASE WHEN err.project_advance IS NULL THEN 0 ELSE err.project_advance END) AS project_advance,e.status,SUM(CASE WHEN err.bonus_payment IS NULL THEN 0 ELSE err.bonus_payment END) AS bonus_payment, SUM(CASE WHEN err.integral_return IS NULL THEN 0 ELSE err.integral_return END) AS integral_return, SUM(CASE WHEN err.violation_charges IS NULL THEN 0 ELSE err.violation_charges END) AS violation_charges FROM employee_report_records err left join employees e on err.employee_id = e.employee_id WHERE err.plate_id = ? AND err.record_date >= ? AND err.record_date <= ? AND err.employee_no like ? AND err.employee_name like ? AND err.employee_id != 0 GROUP BY err.plate_id, err.employee_id, err.employee_name, err.employee_no,e.status ORDER BY err.plate_id, err.employee_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,employee_id,employee_name,employee_no,achieve_integral,sure_integral,manager_project_integral,salary_advance,salary_return,salary,project_cost,project_advance,status,bonus_payment,integral_return,violation_charges";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date", "employee_no", "employee_name"};
}
