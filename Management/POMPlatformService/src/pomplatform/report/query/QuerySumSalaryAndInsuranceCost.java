package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseSumSalaryAndInsuranceCost;
import pomplatform.report.bean.ConditionSumSalaryAndInsuranceCost;

public class QuerySumSalaryAndInsuranceCost extends AbstractQuery<BaseSumSalaryAndInsuranceCost, ConditionSumSalaryAndInsuranceCost>
{

	private static final Logger __logger = Logger.getLogger(QuerySumSalaryAndInsuranceCost.class);

	public QuerySumSalaryAndInsuranceCost() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseSumSalaryAndInsuranceCost> executeQuery( KeyValuePair[] replacements, ConditionSumSalaryAndInsuranceCost condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getLastMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getLastMonth()
			);
	}

	@Override
	public BaseSumSalaryAndInsuranceCost generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSumSalaryAndInsuranceCost __base = new BaseSumSalaryAndInsuranceCost();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setThisPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayRaise(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setThisInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLastInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInsuranceRaise(GenericBase.__getString(val));
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
	
	private final static String __SQLText = "SELECT A .plate_id, A.YEAR, A.MONTH, A.this_pay, b.last_pay, round(( A.this_pay - b.last_pay ) / b.last_pay * 100, 2 ) || '%' AS pay_raise, C.this_insurance, d.last_insurance, round(( C.this_insurance - d.last_insurance ) / d.last_insurance * 100, 2 ) || '%' AS insurance_raise FROM ( SELECT pd.plate_id, st.YEAR, st.MONTH, SUM ( CAST (( convert_from( decrypt ( CAST ( st.should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )) AS DECIMAL )) + SUM ( CAST (( convert_from( decrypt ( CAST ( st.leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )) AS DECIMAL )) + SUM ( CAST (( convert_from( decrypt ( CAST ( st.leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )) AS DECIMAL )) AS this_pay FROM salary_totals st LEFT JOIN plate_departments pd ON st.department_id = pd.department_id WHERE st.YEAR =? AND st.MONTH =? GROUP BY pd.plate_id, st.YEAR, st.MONTH ) A LEFT JOIN ( SELECT pd.plate_id, SUM ( CAST (( convert_from( decrypt ( CAST ( st.should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )) AS DECIMAL )) + SUM ( CAST (( convert_from( decrypt ( CAST ( st.leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )) AS DECIMAL )) + SUM ( CAST (( convert_from( decrypt ( CAST ( st.leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' )) AS DECIMAL )) AS last_pay FROM salary_totals st LEFT JOIN plate_departments pd ON st.department_id = pd.department_id WHERE st.YEAR =? AND st.MONTH =? GROUP BY pd.plate_id ) b ON A.plate_id = b.plate_id LEFT JOIN ( SELECT pd.plate_id, SUM ( personal_total_insurance ) + SUM ( personal_total_fund ) AS this_insurance FROM five_insurance_one_golds fiog LEFT JOIN plate_departments pd ON fiog.department_id = pd.department_id WHERE fiog.YEAR =? AND MONTH =? GROUP BY pd.plate_id ) C ON A.plate_id = C.plate_id LEFT JOIN ( SELECT pd.plate_id, SUM ( personal_total_insurance ) + SUM ( personal_total_fund ) AS last_insurance FROM five_insurance_one_golds fiog LEFT JOIN plate_departments pd ON fiog.department_id = pd.department_id WHERE fiog.YEAR =? AND MONTH =? GROUP BY pd.plate_id ) d ON A.plate_id = d.plate_id WHERE A.plate_id >= 0 ORDER BY A.plate_id, A.YEAR, A.MONTH" ;
//	private final static String __SQLText = "SELECT a.plate_id,a.year,a.month,a.this_pay,b.last_pay,round((a.this_pay-b.last_pay)/b.last_pay*100,2)||'%' as pay_raise, c.this_insurance,d.last_insurance,round((c.this_insurance-d.last_insurance)/d.last_insurance*100,2)||'%' as insurance_raise FROM (SELECT st.plate_id,st.year,st.month,sum(CAST((convert_from(decrypt(CAST(st.should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')) AS decimal))+sum(CAST((convert_from(decrypt(CAST(st.leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')) AS decimal))+sum(CAST((convert_from(decrypt(CAST(st.leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')) AS decimal)) as this_pay FROM salary_totals st WHERE st.year = ? AND st.month = ? GROUP BY st.plate_id,st.year,st.month) a LEFT JOIN (SELECT st.plate_id,sum(CAST((convert_from(decrypt(CAST(st.should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')) AS decimal))+sum(CAST((convert_from(decrypt(CAST(st.leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')) AS decimal))+sum(CAST((convert_from(decrypt(CAST(st.leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII')) AS decimal)) as last_pay FROM salary_totals st WHERE st.year = ? AND st.month = ? GROUP BY st.plate_id) b ON a.plate_id = b.plate_id LEFT JOIN (SELECT fiog.plate_id,sum(personal_total_insurance)+sum(personal_total_fund) as this_insurance FROM five_insurance_one_golds fiog WHERE fiog.year = ? AND month = ? GROUP BY fiog.plate_id) c ON a.plate_id = c.plate_id LEFT JOIN (SELECT fiog.plate_id,sum(personal_total_insurance)+sum(personal_total_fund) as last_insurance FROM five_insurance_one_golds fiog WHERE fiog.year = ? AND month = ? GROUP BY fiog.plate_id) d ON a.plate_id = d.plate_id ORDER BY a.plate_id,a.year,a.month" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,month,this_pay,last_pay,pay_raise,this_insurance,last_insurance,insurance_raise";
	private final static String[] fieldNames = { "year", "month", "year", "last_month", "year", "month", "year", "last_month"};
}
