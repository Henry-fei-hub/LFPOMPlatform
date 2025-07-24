package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryAnnualBonusByPlate;
import pomplatform.payment.bean.ConditionOnSalaryAnnualBonusByPlate;

public class QueryOnSalaryAnnualBonusByPlate extends AbstractQuery<BaseOnSalaryAnnualBonusByPlate, ConditionOnSalaryAnnualBonusByPlate>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryAnnualBonusByPlate.class);

	public QueryOnSalaryAnnualBonusByPlate() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("plate_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryAnnualBonusByPlate> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryAnnualBonusByPlate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPersonnelBusinessId(), 
				condition.getFlowStatus(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseOnSalaryAnnualBonusByPlate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryAnnualBonusByPlate __base = new BaseOnSalaryAnnualBonusByPlate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setOneToThreeRest(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHousingSubsidy(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDeductPerformanceBonus(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
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

	private final static String __SQLText = "SELECT plate_id, YEAR, SUM ( CAST ( convert_from( decrypt ( CAST ( thirteen_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS thirteen_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( year_performance_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS year_performance_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( program_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS program_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( transfer_account_money AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS transfer_account_money, SUM ( CAST ( convert_from( decrypt ( CAST ( deposit_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS deposit_deduct, SUM ( CAST ( convert_from( decrypt ( CAST ( should_total AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS should_total, SUM ( CAST ( convert_from( decrypt ( CAST ( should_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS should_tax, SUM ( CAST ( convert_from( decrypt ( CAST ( fact_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS fact_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( total_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS total_pay, SUM ( CAST ( convert_from( decrypt ( CAST ( salary_diff_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS salary_diff_deduct, SUM ( CAST ( convert_from( decrypt ( CAST ( reimbursement_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS reimbursement_deduct, SUM ( CAST ( convert_from( decrypt ( CAST ( other_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS other_deduct, array_to_string( ARRAY ( SELECT remark FROM salary_annual_bonus t2 WHERE t1.plate_id = t2.plate_id ), ',' ) AS remark, personnel_business_id, flow_status, send_time, SUM ( CAST ( convert_from( decrypt ( CAST ( one_to_three_rest AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS one_to_three_rest, SUM ( CAST ( convert_from( decrypt ( CAST ( housing_subsidy AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS housing_subsidy, SUM ( CAST ( convert_from( decrypt ( CAST ( deduct_performance_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS deduct_performance_bonus ,SUM (CAST (convert_from(decrypt ( CAST ( instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS NUMERIC )) AS instead_deduct   FROM salary_annual_bonus t1 WHERE company_id = ? and plate_id = ? and year = ? AND personnel_business_id =? AND flow_status =? AND send_time BETWEEN ? AND ? and 1=1 GROUP BY plate_id,year,personnel_business_id,flow_status,send_time ORDER BY plate_id,year" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,thirteen_bonus,year_performance_bonus,program_bonus,transfer_account_money,deposit_deduct,should_total,should_tax,fact_bonus,total_pay,salary_diff_deduct,reimbursement_deduct,other_deduct,remark,personnel_business_id,flow_status,send_time,one_to_three_rest,housing_subsidy,deduct_performance_bonus,instead_deduct";
	private final static String[] fieldNames = { "company_id", "plate_id", "year", "personnel_business_id", "flow_status", "start_time", "end_time"};
}
