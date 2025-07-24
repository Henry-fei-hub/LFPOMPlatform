package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryAnnualBonusByCompany;
import pomplatform.payment.bean.ConditionOnSalaryAnnualBonusByCompany;

public class QueryOnSalaryAnnualBonusByCompany extends AbstractQuery<BaseOnSalaryAnnualBonusByCompany, ConditionOnSalaryAnnualBonusByCompany>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryAnnualBonusByCompany.class);

	public QueryOnSalaryAnnualBonusByCompany() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("company_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryAnnualBonusByCompany> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryAnnualBonusByCompany condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getCompanyId(), 
				condition.getPersonnelBusinessId(), 
				condition.getFlowStatus(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseOnSalaryAnnualBonusByCompany generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryAnnualBonusByCompany __base = new BaseOnSalaryAnnualBonusByCompany();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThirteenBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYearPerformanceBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProgramBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTransferAccountMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDepositDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalaryDiffDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReimbursementDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlowStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSendTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInsteadDeduct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOneToThreeRest(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
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

	private final static String __SQLText = "SELECT company_id,year ,sum(CAST(convert_from(decrypt(CAST(thirteen_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as thirteen_bonus ,sum(CAST(convert_from(decrypt(CAST(year_performance_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as year_performance_bonus ,sum(CAST(convert_from(decrypt(CAST(program_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as program_bonus ,sum(CAST(convert_from(decrypt(CAST(transfer_account_money as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as transfer_account_money ,sum(CAST(convert_from(decrypt(CAST(deposit_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as deposit_deduct ,sum(CAST(convert_from(decrypt(CAST(should_total as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as should_total ,sum(CAST(convert_from(decrypt(CAST(should_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as should_tax ,sum(CAST(convert_from(decrypt(CAST(fact_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as fact_bonus ,sum(CAST(convert_from(decrypt(CAST(total_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as total_pay ,sum(CAST(convert_from(decrypt(CAST(salary_diff_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as salary_diff_deduct ,sum(CAST(convert_from(decrypt(CAST(reimbursement_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as reimbursement_deduct ,sum(CAST(convert_from(decrypt(CAST(other_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as other_deduct ,array_to_string(array(select remark from salary_annual_bonus t2 where t1.company_id = t2.company_id), ',') as remark ,personnel_business_id,flow_status,send_time	,SUM (CAST (convert_from(decrypt ( CAST ( instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS NUMERIC )) AS instead_deduct  	,SUM (CAST (convert_from(decrypt ( CAST ( one_to_three_rest AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS NUMERIC )) AS one_to_three_rest   FROM salary_annual_bonus t1 WHERE year = ? and company_id = ? AND personnel_business_id =? AND flow_status =? AND send_time BETWEEN ? AND ? GROUP BY company_id,year,personnel_business_id,flow_status,send_time ORDER BY company_id,year" ;
	private final static String RESULTSETFIELDLIST = "company_id,year,thirteen_bonus,year_performance_bonus,program_bonus,transfer_account_money,deposit_deduct,should_total,should_tax,fact_bonus,total_pay,salary_diff_deduct,reimbursement_deduct,other_deduct,remark,personnel_business_id,flow_status,send_time,instead_deduct,one_to_three_rest";
	private final static String[] fieldNames = { "year", "company_id", "personnel_business_id", "flow_status", "start_time", "end_time"};
}
