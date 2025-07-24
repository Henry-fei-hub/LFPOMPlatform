package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportPayChangeOnboardEmp;
import pomplatform.report.bean.ConditionReportPayChangeOnboardEmp;

public class QueryReportPayChangeOnboardEmp extends AbstractQuery<BaseReportPayChangeOnboardEmp, ConditionReportPayChangeOnboardEmp>
{

	private static final Logger __logger = Logger.getLogger(QueryReportPayChangeOnboardEmp.class);

	public QueryReportPayChangeOnboardEmp() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseReportPayChangeOnboardEmp> executeQuery( KeyValuePair[] replacements, ConditionReportPayChangeOnboardEmp condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseReportPayChangeOnboardEmp generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportPayChangeOnboardEmp __base = new BaseReportPayChangeOnboardEmp();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTryTimePay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEducation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonalTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.employee_id,a.employee_no,a.employee_name,a.plate_id,a.department_id,a.onboard_date,a.try_time_pay,a.education , CASE WHEN b.personal_total_fund is null THEN 0 ELSE b.personal_total_fund END, CASE WHEN b.personal_total_insurance is NULL THEN 0 ELSE b.personal_total_insurance END,a.gender FROM (SELECT e.employee_id,e.employee_no,e.employee_name,e.plate_id,e.department_id,e.onboard_date,e.try_time_pay,e.education,e.gender FROM employees e WHERE EXTRACT(YEAR FROM onboard_date) = ? AND EXTRACT(MONTH FROM onboard_date) = ?) a LEFT JOIN (SELECT e.employee_id,fiog.personal_total_fund,fiog.personal_total_insurance FROM employees e LEFT JOIN five_insurance_one_golds fiog ON e.employee_id = fiog.employee_id WHERE fiog.year = ? AND fiog.month = ?) b ON a.employee_id = b.employee_id WHERE a.plate_id = ? ORDER BY a.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,plate_id,department_id,onboard_date,try_time_pay,education,personal_total_fund,personal_total_insurance,gender";
	private final static String[] fieldNames = { "year", "month", "year", "month", "plate_id"};
}
