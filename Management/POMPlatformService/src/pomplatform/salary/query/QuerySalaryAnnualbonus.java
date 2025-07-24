package pomplatform.salary.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salary.bean.BaseSalaryAnnualbonus;
import pomplatform.salary.bean.ConditionSalaryAnnualbonus;

public class QuerySalaryAnnualbonus extends AbstractQuery<BaseSalaryAnnualbonus, ConditionSalaryAnnualbonus>
{

	private static final Logger __logger = Logger.getLogger(QuerySalaryAnnualbonus.class);

	public QuerySalaryAnnualbonus() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sab.bank_account");
	}

	@Override
	public BaseCollection<BaseSalaryAnnualbonus> executeQuery( KeyValuePair[] replacements, ConditionSalaryAnnualbonus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getYear(), 
				condition.getCompanyId(), 
				condition.getPlateId(), 
				condition.getPersonnelBusinessId(), 
				condition.getFlowStatus(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseSalaryAnnualbonus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSalaryAnnualbonus __base = new BaseSalaryAnnualbonus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPositiveDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTotalPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYearShouldWorkDay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYearFactWorkDay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYearServiceNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYearTestLevel(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTestNum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThirteenBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYearPerformanceBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProgramBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTransferAccountMoney(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldTotal(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFactBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsSended(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDepositDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalaryDiffDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReimbursementDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlreadyBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldTaxAchieve(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOneToThreeRest(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHousingSubsidy(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeductPerformanceBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlowStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSendTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInsteadDeduct(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
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

	private final static String __SQLText = "SELECT sab.bank_account,sab.employee_no,sab.employee_id,sab.employee_name,sab.year,sab.company_id,sab.plate_id,sab.department_id,e.onboard_status,e.onboard_date , e.positive_date,convert_from(decrypt(CAST(sab.total_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as total_pay,sab.year_should_work_day, sab.year_fact_work_day,sab.year_service_num,sab.year_test_level,sab.test_num,convert_from(decrypt(CAST(sab.thirteen_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as thirteen_bonus,convert_from(decrypt(CAST(sab.year_performance_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as year_performance_bonus,convert_from(decrypt(CAST(sab.program_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as program_bonus, convert_from(decrypt(CAST(sab.transfer_account_money as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as transfer_account_money,convert_from(decrypt(CAST(sab.should_total as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as should_total,convert_from(decrypt(CAST(sab.should_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as should_tax ,convert_from(decrypt(CAST(sab.fact_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as fact_bonus,sab.is_sended ,convert_from(decrypt(CAST(sab.deposit_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as deposit_deduct ,convert_from(decrypt(CAST(sab.salary_diff_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as salary_diff_deduct ,convert_from(decrypt(CAST(sab.reimbursement_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as reimbursement_deduct ,convert_from(decrypt(CAST(sab.other_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as other_deduct ,convert_from(decrypt(CAST(sab.already_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as already_bonus ,convert_from(decrypt(CAST(sab.should_tax_achieve as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as should_tax_achieve ,convert_from( decrypt ( CAST ( sab.one_to_three_rest AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS one_to_three_rest, convert_from( decrypt ( CAST ( sab.housing_subsidy AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS housing_subsidy, convert_from( decrypt ( CAST ( sab.deduct_performance_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS deduct_performance_bonus,sab.personnel_business_id,sab.flow_status,sab.remark,sab.send_time,e.card,e.mobile ,convert_from(decrypt ( CAST ( sab.instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS instead_deduct  FROM salary_annual_bonus sab LEFT JOIN employees e ON sab.employee_id = e.employee_id WHERE sab.employee_no LIKE ? AND sab.employee_id = ? AND sab.department_id in (select child_id from department_ids where department_id = ?) AND sab.year = ? and sab.company_id = ? and sab.plate_id = ? and sab.personnel_business_id =? and sab.flow_status =? AND sab.send_time BETWEEN ? AND ? order by sab.employee_id" ;
	private final static String RESULTSETFIELDLIST = "bank_account,employee_no,employee_id,employee_name,year,company_id,plate_id,department_id,onboard_status,onboard_date,positive_date,total_pay,year_should_work_day,year_fact_work_day,year_service_num,year_test_level,test_num,thirteen_bonus,year_performance_bonus,program_bonus,transfer_account_money,should_total,should_tax,fact_bonus,is_sended,deposit_deduct,salary_diff_deduct,reimbursement_deduct,other_deduct,already_bonus,should_tax_achieve,one_to_three_rest,housing_subsidy,deduct_performance_bonus,personnel_business_id,flow_status,remark,send_time,card,mobile,instead_deduct";
	private final static String[] fieldNames = { "employee_no", "employee_id", "department_id", "year", "company_id", "plate_id", "personnel_business_id", "flow_status", "start_time", "end_time"};
}
