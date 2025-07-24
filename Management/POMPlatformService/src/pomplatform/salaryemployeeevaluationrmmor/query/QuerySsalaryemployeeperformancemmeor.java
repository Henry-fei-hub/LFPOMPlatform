package pomplatform.salaryemployeeevaluationrmmor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salaryemployeeevaluationrmmor.bean.BaseSsalaryemployeeperformancemmeor;
import pomplatform.salaryemployeeevaluationrmmor.bean.ConditionSsalaryemployeeperformancemmeor;

public class QuerySsalaryemployeeperformancemmeor extends AbstractQuery<BaseSsalaryemployeeperformancemmeor, ConditionSsalaryemployeeperformancemmeor>
{

	private static final Logger __logger = Logger.getLogger(QuerySsalaryemployeeperformancemmeor.class);

	public QuerySsalaryemployeeperformancemmeor() throws java.sql.SQLException 
	{
		setParameterNumber(17);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sep.salary_employee_performance_id");
	}

	@Override
	public BaseCollection<BaseSsalaryemployeeperformancemmeor> executeQuery( KeyValuePair[] replacements, ConditionSsalaryemployeeperformancemmeor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinHappenDate(), 
				condition.getMaxHappenDate(), 
				condition.getEmployeeNo(), 
				condition.getSalaryEmployeePerformanceId(), 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getCompanyId(), 
				condition.getStatus(), 
				condition.getShouldDays(), 
				condition.getFactDays(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getGrade(), 
				condition.getProportion(), 
				condition.getWorkingCoefficient(), 
				condition.getActualPerformancePay()
			);
	}

	@Override
	public BaseSsalaryemployeeperformancemmeor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSsalaryemployeeperformancemmeor __base = new BaseSsalaryemployeeperformancemmeor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSalaryEmployeePerformanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBasicProportionStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBasicProportion(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthPerformancePay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setGrade(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProportion(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWorkingCoefficient(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setActualPerformancePay(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[9]));
		if(args[10] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[14]));
		if(args[15] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[15]));
		if(args[16] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[16]));
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

	private final static String __SQLText = "select sep.salary_employee_performance_id, sep.employee_no, sep.employee_id, sep.plate_id, sep.department_id, sep.company_id, sep.status, CAST((convert_from(decrypt(CAST(sep.month_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') ) as NUMERIC) as month_pay, sep.basic_proportion_str, sep.basic_proportion, CAST((convert_from(decrypt(CAST(sep.month_basic_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') ) as NUMERIC) as month_basic_pay, CAST((convert_from(decrypt(CAST(sep.month_performance_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') ) as NUMERIC) as month_performance_pay, sep.should_days, sep.fact_days, sep.year, sep.month, sep.happen_date, sep.create_time, sep.grade, sep.proportion, sep.working_coefficient, sep.actual_performance_pay from salary_employee_performance sep where sep.happen_date between ? and ? and sep.employee_no like ? and sep.salary_employee_performance_id = ? and sep.employee_id = ? and sep.plate_id = ? and sep.department_id = ? and sep.company_id = ? and sep.status = ? and sep.should_days = ? and sep.fact_days = ? and sep.year = ? and sep.month = ? and sep.grade = ? and sep.proportion = ? and sep.working_coefficient = ? and sep.actual_performance_pay = ?" ;
	private final static String RESULTSETFIELDLIST = "salary_employee_performance_id,employee_no,employee_id,plate_id,department_id,company_id,status,month_pay,basic_proportion_str,basic_proportion,month_basic_pay,month_performance_pay,should_days,fact_days,year,month,happen_date,create_time,grade,proportion,working_coefficient,actual_performance_pay";
	private final static String[] fieldNames = { "min_happen_date", "max_happen_date", "employee_no", "salary_employee_performance_id", "employee_id", "plate_id", "department_id", "company_id", "status", "should_days", "fact_days", "year", "month", "grade", "proportion", "working_coefficient", "actual_performance_pay"};
}
