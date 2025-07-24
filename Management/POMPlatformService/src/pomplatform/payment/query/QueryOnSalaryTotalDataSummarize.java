package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryTotalDataSummarize;
import pomplatform.payment.bean.ConditionOnSalaryTotalDataSummarize;

public class QueryOnSalaryTotalDataSummarize extends AbstractQuery<BaseOnSalaryTotalDataSummarize, ConditionOnSalaryTotalDataSummarize>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryTotalDataSummarize.class);

	public QueryOnSalaryTotalDataSummarize() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("0 as startyear");
	}

	@Override
	public BaseCollection<BaseOnSalaryTotalDataSummarize> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryTotalDataSummarize condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartyear(), 
				condition.getEndyear(), 
				condition.getStartmonth(), 
				condition.getEndmonth(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnSalaryTotalDataSummarize generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryTotalDataSummarize __base = new BaseOnSalaryTotalDataSummarize();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setStartyear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartmonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndyear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndmonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOnboardStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPositiveDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setResignationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setWorkMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFillSendDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJobSubsidy(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAttendanceDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPerformancePay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAlreadyBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTaxAchieve(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDeductTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeaveNoDeductTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeaveDeductTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInsteadDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInsteadDeductIll(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalPension(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalHeating(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalSeriousIllInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialAdditionalDuduct(GenericBase.__getDecimal(val));
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
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = " select 0 as startyear, 0 as startmonth, 0 as endyear, 0 as endmonth, b.employee_no, b.employee_name, b.company_id, b.plate_id, b.department_id, b.mobile, b.onboard_status, b.onboard_date, b.positive_date, b.resignation_date, b.card , st.* from ( SELECT A.employee_id, SUM ( CAST ( convert_from( decrypt ( CAST ( A.month_basic_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS month_basic_pay, SUM ( CAST (convert_from( decrypt ( CAST ( A.work_money AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS work_money, SUM ( CAST (convert_from( decrypt ( CAST ( A.fill_send_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS fill_send_deduct, SUM ( CAST (convert_from( decrypt ( CAST ( A.job_subsidy AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS job_subsidy, SUM ( CAST (convert_from( decrypt ( CAST ( A.attendance_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS attendance_deduct, SUM ( CAST (convert_from( decrypt ( CAST ( A.performance_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS performance_pay, SUM ( CAST (convert_from( decrypt ( CAST ( A.should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS should_salary, SUM ( CAST (convert_from( decrypt ( CAST ( A.should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS should_bonus, SUM ( CAST (convert_from( decrypt ( CAST ( A.should_total AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS should_total, SUM ( CAST (convert_from( decrypt ( CAST ( A.already_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS already_bonus, SUM ( CAST (convert_from( decrypt ( CAST ( A.other_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))AS other_bonus, SUM ( CAST (convert_from( decrypt ( CAST ( A.should_tax_achieve AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS should_tax_achieve, SUM ( CAST (convert_from( decrypt ( CAST ( A.tax_total AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS tax_total, SUM ( CAST (convert_from( decrypt ( CAST ( A.deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS deduct_tax, SUM ( CAST (convert_from( decrypt ( CAST ( A.should_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS should_tax, SUM ( CAST (convert_from( decrypt ( CAST ( A.total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS total_insurance, SUM ( CAST (convert_from( decrypt ( CAST ( A.total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS total_fund, SUM ( CAST (convert_from( decrypt ( CAST ( A.unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS unit_total_insurance, SUM ( CAST (convert_from( decrypt ( CAST ( A.unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS unit_total_fund, SUM ( CAST (convert_from( decrypt ( CAST ( A.leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS leave_no_deduct_tax, SUM ( CAST (convert_from( decrypt ( CAST ( A.leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS leave_deduct_tax, SUM ( CAST (convert_from( decrypt ( CAST ( A.fact_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS fact_salary, SUM ( CAST (convert_from( decrypt ( CAST ( A.instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS instead_deduct, SUM ( CAST (convert_from( decrypt ( CAST ( A.instead_deduct_ill AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )AS NUMERIC )) AS instead_deduct_ill, sum(A.personal_pension) personal_pension, sum(A.personal_medical_insurance) personal_medical_insurance, sum(A.personal_large_medical_insurance) personal_large_medical_insurance, sum(A.personal_unemployment_insurance) personal_unemployment_insurance, sum(A.personal_heating) personal_heating, sum(A.personal_serious_ill_insurance) personal_serious_ill_insurance, sum(A.special_additional_duduct) special_additional_duduct FROM salary_totals A WHERE A.YEAR >=? AND A.YEAR <=? AND A.MONTH >=? AND A.MONTH <=? AND A.employee_id =? AND A.employee_no LIKE ? AND A.employee_name LIKE ? AND A.company_id =? AND A.department_id =? AND A.plate_id =? GROUP BY A.employee_id ORDER BY A.employee_id DESC ) AS st left join employees b on b.employee_id = st.employee_id" ;
	private final static String RESULTSETFIELDLIST = "startyear,startmonth,endyear,endmonth,employee_no,employee_name,company_id,plate_id,department_id,mobile,onboard_status,onboard_date,positive_date,resignation_date,card,employee_id,month_basic_pay,work_money,fill_send_deduct,job_subsidy,attendance_deduct,performance_pay,should_salary,should_bonus,should_total,already_bonus,other_bonus,should_tax_achieve,tax_total,deduct_tax,should_tax,total_insurance,total_fund,unit_total_insurance,unit_total_fund,leave_no_deduct_tax,leave_deduct_tax,fact_salary,instead_deduct,instead_deduct_ill,personal_pension,personal_medical_insurance,personal_large_medical_insurance,personal_unemployment_insurance,personal_heating,personal_serious_ill_insurance,special_additional_duduct";
	private final static String[] fieldNames = { "startyear", "endyear", "startmonth", "endmonth", "employee_id", "employee_no", "employee_name", "company_id", "department_id", "plate_id"};
}
