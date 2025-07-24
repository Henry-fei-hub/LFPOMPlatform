package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryTotalData;
import pomplatform.payment.bean.ConditionOnSalaryTotalData;

public class QueryOnSalaryTotalData extends AbstractQuery<BaseOnSalaryTotalData, ConditionOnSalaryTotalData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryTotalData.class);

	public QueryOnSalaryTotalData() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.salary_total_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryTotalData> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryTotalData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnSalaryTotalData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryTotalData __base = new BaseOnSalaryTotalData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSalaryTotalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkMoney(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFillSendDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setJobSubsidy(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttendanceDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPerformancePay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldSalary(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldTotal(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlreadyBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTaxBegin(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTaxAchieve(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTaxTotal(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUnitTotalInsurance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUnitTotalFund(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeaveNoDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeaveDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFactSalary(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAffiliated(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInsteadDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInsteadDeductIll(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setVoteProject(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setVotePercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsSended(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCostAttribution(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDevelopmentProject(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPersonalPension(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalHeating(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalSeriousIllInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalaryTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialAdditionalDuduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct6(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuductSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTaxAchieveSum(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIndividualIncomeTaxSum(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInsuranceFundSum(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWithholdingTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReplacementTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSuspendBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherDeduction(GenericBase.__getString(val));
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
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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
	private final static String __SQLText = "SELECT A .salary_total_id, A.employee_id, A.employee_no, A.employee_name, A.company_id, A.plate_id, A.department_id, b.mobile, b.onboard_status, b.onboard_date, b.positive_date, b.resignation_date, b.gender, A.YEAR, A.MONTH, A.bank_account, convert_from( decrypt ( CAST ( A.month_basic_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS month_basic_pay, convert_from( decrypt ( CAST ( A.work_money AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS work_money, convert_from( decrypt ( CAST ( A.fill_send_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS fill_send_deduct, convert_from( decrypt ( CAST ( A.job_subsidy AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS job_subsidy, convert_from( decrypt ( CAST ( A.attendance_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS attendance_deduct, convert_from( decrypt ( CAST ( A.performance_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS performance_pay, convert_from( decrypt ( CAST ( A.should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_salary, convert_from( decrypt ( CAST ( A.should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_bonus, convert_from( decrypt ( CAST ( A.should_total AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_total, convert_from( decrypt ( CAST ( A.already_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS already_bonus, convert_from( decrypt ( CAST ( A.other_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS other_bonus, A.tax_begin, convert_from( decrypt ( CAST ( A.should_tax_achieve AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_tax_achieve, convert_from( decrypt ( CAST ( A.tax_total AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS tax_total, convert_from( decrypt ( CAST ( A.deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS deduct_tax, convert_from( decrypt ( CAST ( A.should_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_tax, convert_from( decrypt ( CAST ( A.total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS total_insurance, convert_from( decrypt ( CAST ( A.total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS total_fund, convert_from( decrypt ( CAST ( A.unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS unit_total_insurance, convert_from( decrypt ( CAST ( A.unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS unit_total_fund, convert_from( decrypt ( CAST ( A.leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS leave_no_deduct_tax, convert_from( decrypt ( CAST ( A.leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS leave_deduct_tax, convert_from( decrypt ( CAST ( A.fact_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS fact_salary, A.affiliated, convert_from( decrypt ( CAST ( A.instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS instead_deduct, convert_from( decrypt ( CAST ( A.instead_deduct_ill AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS instead_deduct_ill, A.vote_project, A.vote_percent, A.is_sended, A.cost_attribution, A.development_project, b.card, A.personal_pension, A.personal_medical_insurance, A.personal_large_medical_insurance, A.personal_unemployment_insurance, A.personal_heating, A.personal_serious_ill_insurance, A.salary_type_name, A.special_additional_duduct, A.special_duduct_1, A.special_duduct_2, A.special_duduct_3, A.special_duduct_4, A.special_duduct_5, A.special_duduct_6, A.special_duduct_sum, convert_from( decrypt ( CAST ( A.should_tax_achieve_sum AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_tax_achieve_sum, convert_from( decrypt ( CAST ( A.individual_income_tax_sum AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS individual_income_tax_sum, convert_from( decrypt ( CAST ( A.insurance_fund_sum AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS insurance_fund_sum, convert_from( decrypt ( CAST ( A.withholding_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS withholding_tax, convert_from( decrypt ( CAST ( A.replacement_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS replacement_tax ,convert_from( decrypt ( CAST ( A.suspend_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS suspend_bonus , convert_from( decrypt ( CAST ( A.other_deduction AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS other_deduction   FROM salary_totals A LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE A.employee_id =? AND A.YEAR =? AND A.MONTH =? AND A.employee_no LIKE ? AND A.employee_name LIKE ? AND A.company_id =? AND A.department_id =? AND A.plate_id =? ORDER BY A.department_id, A.employee_id, A.YEAR, A.MONTH DESC" ;
//	private final static String __SQLText = "SELECT A .salary_total_id, A.employee_id, A.employee_no, A.employee_name, A.company_id, A.plate_id, A.department_id, b.mobile, b.onboard_status, b.onboard_date, b.positive_date, b.resignation_date, b.gender, A.YEAR, A.MONTH, A.bank_account, convert_from( decrypt ( CAST ( A.month_basic_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS month_basic_pay, convert_from( decrypt ( CAST ( A.work_money AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS work_money, convert_from( decrypt ( CAST ( A.fill_send_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS fill_send_deduct, convert_from( decrypt ( CAST ( A.job_subsidy AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS job_subsidy, convert_from( decrypt ( CAST ( A.attendance_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS attendance_deduct, convert_from( decrypt ( CAST ( A.performance_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS performance_pay, convert_from( decrypt ( CAST ( A.should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_salary, convert_from( decrypt ( CAST ( A.should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_bonus, convert_from( decrypt ( CAST ( A.should_total AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_total, convert_from( decrypt ( CAST ( A.already_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS already_bonus, convert_from( decrypt ( CAST ( A.other_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS other_bonus, A.tax_begin, convert_from( decrypt ( CAST ( A.should_tax_achieve AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_tax_achieve, convert_from( decrypt ( CAST ( A.tax_total AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS tax_total, convert_from( decrypt ( CAST ( A.deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS deduct_tax, convert_from( decrypt ( CAST ( A.should_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS should_tax, convert_from( decrypt ( CAST ( A.total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS total_insurance, convert_from( decrypt ( CAST ( A.total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS total_fund, convert_from( decrypt ( CAST ( A.unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS unit_total_insurance, convert_from( decrypt ( CAST ( A.unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS unit_total_fund, convert_from( decrypt ( CAST ( A.leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS leave_no_deduct_tax, convert_from( decrypt ( CAST ( A.leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS leave_deduct_tax, convert_from( decrypt ( CAST ( A.fact_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS fact_salary, A.affiliated, convert_from( decrypt ( CAST ( A.instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS instead_deduct, convert_from( decrypt ( CAST ( A.instead_deduct_ill AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS instead_deduct_ill, A.vote_project, A.vote_percent, A.is_sended, A.cost_attribution, A.development_project, b.card, A.personal_pension, A.personal_medical_insurance, A.personal_large_medical_insurance, A.personal_unemployment_insurance, A.personal_heating, A.personal_serious_ill_insurance, A.salary_type_name, A.special_additional_duduct, A.special_duduct_1, A.special_duduct_2, A.special_duduct_3, A.special_duduct_4, A.special_duduct_5, A.special_duduct_6 , A.special_duduct_sum FROM salary_totals A LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE A.employee_id =? AND A.YEAR =? AND A.MONTH =? AND A.employee_no LIKE ? AND A.employee_name LIKE ? AND A.company_id =? AND A.department_id =? AND A.plate_id =? ORDER BY A.department_id, A.employee_id, A.YEAR, A.MONTH DESC" ;
//	private final static String __SQLText = "select a.salary_total_id,a.employee_id,a.employee_no,a.employee_name,a.company_id,a.plate_id,a.department_id,b.mobile ,b.onboard_status,b.onboard_date,b.positive_date,b.resignation_date,a.year,a.month,a.bank_account ,convert_from(decrypt(CAST(a.month_basic_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_basic_pay,convert_from(decrypt(CAST(a.work_money as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as work_money,convert_from(decrypt(CAST(a.fill_send_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as fill_send_deduct,convert_from(decrypt(CAST(a.job_subsidy as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as job_subsidy,convert_from(decrypt(CAST(a.attendance_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as attendance_deduct,convert_from(decrypt(CAST(a.performance_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as performance_pay,convert_from(decrypt(CAST(a.should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as should_salary ,convert_from(decrypt(CAST(a.should_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as should_bonus,convert_from(decrypt(CAST(a.should_total as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as should_total,convert_from(decrypt(CAST(a.already_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as already_bonus,convert_from(decrypt(CAST(a.other_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as other_bonus,a.tax_begin,convert_from(decrypt(CAST(a.should_tax_achieve as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as should_tax_achieve,convert_from(decrypt(CAST(a.tax_total as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as tax_total,convert_from(decrypt(CAST(a.deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as deduct_tax,convert_from(decrypt(CAST(a.should_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as should_tax,convert_from(decrypt(CAST(a.total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as total_insurance,convert_from(decrypt(CAST(a.total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as total_fund,convert_from(decrypt(CAST(a.unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as unit_total_insurance,convert_from(decrypt(CAST(a.unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as unit_total_fund,convert_from(decrypt(CAST(a.leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as leave_no_deduct_tax,convert_from(decrypt(CAST(a.leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as leave_deduct_tax,convert_from(decrypt(CAST(a.fact_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as fact_salary,a.affiliated,convert_from(decrypt(CAST(a.instead_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as instead_deduct,convert_from(decrypt(CAST(a.instead_deduct_ill as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as instead_deduct_ill,a.vote_project,a.vote_percent,a.is_sended,a.cost_attribution,a.development_project,b.card,a.personal_pension,a.personal_medical_insurance,a.personal_large_medical_insurance,a.personal_unemployment_insurance,a.personal_heating,a.personal_serious_ill_insurance,salary_type_name,special_additional_duduct from salary_totals a left join employees b on a.employee_id = b.employee_id where a.employee_id = ? and a.year = ? and a.month = ? and a.employee_no like ? and a.employee_name like ? and a.company_id = ? and a.department_id = ? and a.plate_id = ? ORDER BY a.department_id,a.employee_id,a.year,a.month desc" ;
	private final static String RESULTSETFIELDLIST = "salary_total_id,employee_id,employee_no,employee_name,company_id,plate_id,department_id,mobile,onboard_status,onboard_date,positive_date,resignation_date,gender,year,month,bank_account,month_basic_pay,work_money,fill_send_deduct,job_subsidy,attendance_deduct,performance_pay,should_salary,should_bonus,should_total,already_bonus,other_bonus,tax_begin,should_tax_achieve,tax_total,deduct_tax,should_tax,total_insurance,total_fund,unit_total_insurance,unit_total_fund,leave_no_deduct_tax,leave_deduct_tax,fact_salary,affiliated,instead_deduct,instead_deduct_ill,vote_project,vote_percent,is_sended,cost_attribution,development_project,card,personal_pension,personal_medical_insurance,personal_large_medical_insurance,personal_unemployment_insurance,personal_heating,personal_serious_ill_insurance,salary_type_name,special_additional_duduct,special_duduct_1,special_duduct_2,special_duduct_3,special_duduct_4,special_duduct_5,special_duduct_6,special_duduct_sum,suspend_bonus,other_deduction";
	private final static String[] fieldNames = { "employee_id", "year", "month", "employee_no", "employee_name", "company_id", "department_id", "plate_id"};
}
