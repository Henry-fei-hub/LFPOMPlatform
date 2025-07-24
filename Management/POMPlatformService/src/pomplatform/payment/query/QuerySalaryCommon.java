package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseSalaryCommon;
import pomplatform.payment.bean.ConditionSalaryCommon;

public class QuerySalaryCommon extends AbstractQuery<BaseSalaryCommon, ConditionSalaryCommon>
{

	private static final Logger __logger = Logger.getLogger(QuerySalaryCommon.class);

	public QuerySalaryCommon() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("s.employee_id");
	}

	@Override
	public BaseCollection<BaseSalaryCommon> executeQuery( KeyValuePair[] replacements, ConditionSalaryCommon condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getCompanyId(), 
				condition.getSalaryType(), 
				condition.getFundraisingProjectType(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseSalaryCommon generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSalaryCommon __base = new BaseSalaryCommon();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkMoney(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFillSendDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setJobSubsidy(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttendanceDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPerformancePay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTotal(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlreadyBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTaxAchieve(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTaxTotal(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeaveDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInsteadDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInsteadDeductIll(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUnitTotalInsurance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUnitTotalFund(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReplacementTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFactSalary(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeaveNoDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalaryType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFundraisingProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFundraisingProjectRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT s.employee_id, s.employee_no, s.employee_name, s.company_id, s.plate_id, s.department_id, s.YEAR, s.MONTH, convert_from( decrypt ( CAST ( s.month_basic_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS month_basic_pay, convert_from( decrypt ( CAST ( s.work_money AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS work_money, convert_from( decrypt ( CAST ( s.fill_send_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS fill_send_deduct, convert_from( decrypt ( CAST ( s.job_subsidy AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS job_subsidy, convert_from( decrypt ( CAST ( s.attendance_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS attendance_deduct, convert_from( decrypt ( CAST ( s.performance_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS performance_pay, convert_from( decrypt ( CAST ( s.should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_bonus, convert_from( decrypt ( CAST ( s.should_total AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_total, convert_from( decrypt ( CAST ( s.already_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS already_bonus, convert_from( decrypt ( CAST ( s.other_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS other_bonus, convert_from( decrypt ( CAST ( s.should_tax_achieve AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_tax_achieve, convert_from( decrypt ( CAST ( s.tax_total AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS tax_total, convert_from( decrypt ( CAST ( s.deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS deduct_tax, convert_from( decrypt ( CAST ( s.total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS total_insurance, convert_from( decrypt ( CAST ( s.total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS total_fund, convert_from( decrypt ( CAST ( s.leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS leave_deduct_tax, convert_from( decrypt ( CAST ( s.instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS instead_deduct, convert_from( decrypt ( CAST ( s.instead_deduct_ill AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS instead_deduct_ill, convert_from( decrypt ( CAST ( s.unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS unit_total_insurance, convert_from( decrypt ( CAST ( s.unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS unit_total_fund, convert_from( decrypt ( CAST ( s.replacement_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS replacement_tax, convert_from( decrypt ( CAST ( s.fact_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS fact_salary, convert_from( decrypt ( CAST ( s.leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS leave_no_deduct_tax, es.salary_type, es.fundraising_project_type, es.fundraising_project_rate, 0 as personnel_business_id FROM salary_totals s LEFT JOIN employee_salary_types es ON s.employee_id = es.employee_id WHERE s.employee_id =? AND s.plate_id =? AND s.company_id =? AND es.salary_type =? AND es.fundraising_project_type =? AND s.YEAR =? AND s.MONTH =? AND s.is_sended = FALSE" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,company_id,plate_id,department_id,year,month,month_basic_pay,work_money,fill_send_deduct,job_subsidy,attendance_deduct,performance_pay,should_bonus,should_total,already_bonus,other_bonus,should_tax_achieve,tax_total,deduct_tax,total_insurance,total_fund,leave_deduct_tax,instead_deduct,instead_deduct_ill,unit_total_insurance,unit_total_fund,replacement_tax,fact_salary,leave_no_deduct_tax,salary_type,fundraising_project_type,fundraising_project_rate,personnel_business_id";
	private final static String[] fieldNames = { "employee_id", "plate_id", "company_id", "salary_type", "fundraising_project_type", "year", "month"};
}
