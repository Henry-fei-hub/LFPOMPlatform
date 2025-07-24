package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLoadSalaryTotalMonthData;
import pomplatform.payment.bean.ConditionOnLoadSalaryTotalMonthData;

public class QueryOnLoadSalaryTotalMonthData extends AbstractQuery<BaseOnLoadSalaryTotalMonthData, ConditionOnLoadSalaryTotalMonthData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadSalaryTotalMonthData.class);

	public QueryOnLoadSalaryTotalMonthData() throws java.sql.SQLException 
	{
		setParameterNumber(29);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadSalaryTotalMonthData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadSalaryTotalMonthData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadSalaryTotalMonthData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadSalaryTotalMonthData __base = new BaseOnLoadSalaryTotalMonthData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkMoney(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFillSendDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setJobSubsidy(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttendanceDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPerformancePay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlreadyBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeaveNoDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeaveDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInsteadDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInsteadDeductIll(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCostAttribution(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonalPension(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalHeating(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalSeriousIllInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setResignationDate(GenericBase.__getDateFromSQL(val));
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
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setInt(count++, GenericBase.__getInt(args[19]));
		if(args[20] != null) __statement.setInt(count++, GenericBase.__getInt(args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
		if(args[22] != null) __statement.setInt(count++, GenericBase.__getInt(args[22]));
		if(args[23] != null) __statement.setInt(count++, GenericBase.__getInt(args[23]));
		if(args[24] != null) __statement.setInt(count++, GenericBase.__getInt(args[24]));
		if(args[25] != null) __statement.setInt(count++, GenericBase.__getInt(args[25]));
		if(args[26] != null) __statement.setInt(count++, GenericBase.__getInt(args[26]));
		if(args[27] != null) __statement.setInt(count++, GenericBase.__getInt(args[27]));
		if(args[28] != null) __statement.setInt(count++, GenericBase.__getInt(args[28]));
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

	private final static String __SQLText = "SELECT A .employee_id, A.employee_no, A.employee_name, A.company_id, A.plate_id, A.department_id, b.bank_account, COALESCE (( SELECT convert_from( decrypt ( CAST ( e.month_basic_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )), '0' ) AS month_basic_pay, COALESCE (( SELECT work_money FROM salary_of_work_years WHERE YEAR =? AND MONTH =? AND employee_id = A.employee_id ), '0' ) AS work_money, COALESCE (( SELECT convert_from( decrypt ( CAST ( total_amount AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) FROM salary_fill_send_deducts WHERE YEAR =? AND MONTH =? AND employee_id = A.employee_id ), '0' ) AS fill_send_deduct, COALESCE (( SELECT convert_from( decrypt ( CAST ( total_amount AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) FROM salary_job_subsidys WHERE YEAR =? AND MONTH =? AND employee_id = A.employee_id ), '0' ) AS job_subsidy, COALESCE (( SELECT SUM ( deduct_total ) FROM employee_payment_details WHERE EXTRACT ( YEAR FROM detail_date ) =? AND EXTRACT ( MONTH FROM detail_date ) =? AND employee_id = A.employee_id GROUP BY EXTRACT ( YEAR FROM detail_date ), EXTRACT ( MONTH FROM detail_date ), employee_id ), 0 ) AS attendance_deduct, COALESCE (( SELECT actual_performance_pay FROM salary_employee_performance WHERE YEAR =? AND MONTH =? AND employee_id = A.employee_id ), '0' ) AS performance_pay, COALESCE (( SELECT convert_from( decrypt ( CAST ( should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) FROM salary_of_bonus WHERE FLAG = 1 AND YEAR =? AND MONTH =? AND employee_id = A.employee_id ), '0' ) AS should_bonus, COALESCE (( SELECT convert_from( decrypt ( CAST ( should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) FROM salary_of_bonus WHERE FLAG = 2 AND YEAR =? AND MONTH =? AND employee_id = A.employee_id ), '0' ) AS already_bonus, COALESCE (( SELECT convert_from( decrypt ( CAST ( other_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) FROM salary_of_bonus WHERE FLAG = 3 AND YEAR =? AND MONTH =? AND employee_id = A.employee_id ), '0' ) AS other_bonus, COALESCE (( SELECT convert_from( decrypt ( CAST ( should_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) FROM salary_of_bonus WHERE FLAG = 2 AND YEAR =? AND MONTH =? AND employee_id = A.employee_id ), '0' ) AS deduct_tax, COALESCE ( C.personal_total_fund, 0 ) AS total_fund, COALESCE ( C.personal_total_insurance, 0 ) AS total_insurance, COALESCE ( C.unit_total_fund, 0 ) AS unit_total_fund, COALESCE ( C.unit_total_insurance, 0 ) AS unit_total_insurance, COALESCE ( convert_from( decrypt ( CAST ( d.no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS leave_no_deduct_tax, COALESCE ( convert_from( decrypt ( CAST ( d.deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS leave_deduct_tax, COALESCE (( SELECT convert_from( decrypt ( CAST ( instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) FROM salary_instead_deducts WHERE YEAR =? AND MONTH =? AND employee_id = A.employee_id ), '0' ) AS instead_deduct, COALESCE (( SELECT convert_from( decrypt ( CAST ( instead_deduct_ill AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) FROM salary_instead_deduct_ills WHERE YEAR =? AND MONTH =? AND employee_id = A.employee_id ), '0' ) AS instead_deduct_ill, e.cost_attribution, C.personal_pension, C.personal_medical_insurance, C.personal_large_medical_insurance, C.personal_unemployment_insurance, C.personal_heating, C.personal_serious_ill_insurance, A.status, A.onboard_date, A.resignation_date FROM employees A LEFT JOIN card_manages b ON b.object_type = 1 AND b.default_card = TRUE AND b.enabled = TRUE AND A.employee_id = b.object_id LEFT JOIN five_insurance_one_golds C ON A.employee_id = C.employee_id AND C.YEAR =? AND C.MONTH =? LEFT JOIN salary_leave_subsidys d ON A.employee_id = d.employee_id AND d.YEAR =? AND d.MONTH =? RIGHT JOIN employee_payment_month_details e ON A.employee_id = e.employee_id AND e.YEAR =? AND e.MONTH =? WHERE A.employee_id > 0 and A.employee_id=?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,company_id,plate_id,department_id,bank_account,month_basic_pay,work_money,fill_send_deduct,job_subsidy,attendance_deduct,performance_pay,should_bonus,already_bonus,other_bonus,deduct_tax,total_fund,total_insurance,unit_total_fund,unit_total_insurance,leave_no_deduct_tax,leave_deduct_tax,instead_deduct,instead_deduct_ill,cost_attribution,personal_pension,personal_medical_insurance,personal_large_medical_insurance,personal_unemployment_insurance,personal_heating,personal_serious_ill_insurance,status,onboard_date,resignation_date";
	private final static String[] fieldNames = { "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "YEAR", "MONTH", "employee_id"};
}
