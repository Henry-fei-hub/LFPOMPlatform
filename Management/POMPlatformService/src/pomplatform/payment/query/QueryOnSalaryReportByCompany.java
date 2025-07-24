package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryReportByCompany;
import pomplatform.payment.bean.ConditionOnSalaryReportByCompany;

public class QueryOnSalaryReportByCompany extends AbstractQuery<BaseOnSalaryReportByCompany, ConditionOnSalaryReportByCompany>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryReportByCompany.class);

	public QueryOnSalaryReportByCompany() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.company_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryReportByCompany> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryReportByCompany condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnSalaryReportByCompany generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryReportByCompany __base = new BaseOnSalaryReportByCompany();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShouldSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeaveAdvance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInsteadDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInsteadDeductIll(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReplacementTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSuspendBonus(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT A .company_id, A.YEAR, A.MONTH, A.should_salary, ( A.leave_no_deduct_tax + A.leave_deduct_tax ) AS leave_advance, A.should_bonus, ( A.should_salary + A.leave_no_deduct_tax + A.leave_deduct_tax + A.should_bonus+A.suspend_bonus ) AS should_total, A.should_tax, A.total_insurance, A.total_fund, A.instead_deduct, A.instead_deduct_ill, A.fact_salary AS fact_salary, A.num, A.unit_total_insurance, A.unit_total_fund, A.replacement_tax, A.suspend_bonus FROM ( SELECT COUNT ( company_id ) AS num, company_id, YEAR, MONTH, SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS should_salary, SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS leave_no_deduct_tax, SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS leave_deduct_tax, SUM ( CAST ( convert_from( decrypt ( CAST ( should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS should_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( should_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS should_tax, SUM ( CAST ( convert_from( decrypt ( CAST ( total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS total_insurance, SUM ( CAST ( convert_from( decrypt ( CAST ( total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS total_fund, SUM ( CAST ( convert_from( decrypt ( CAST ( instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS instead_deduct, SUM ( CAST ( convert_from( decrypt ( CAST ( instead_deduct_ill AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS instead_deduct_ill, SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS unit_total_insurance, SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS unit_total_fund, SUM ( CAST ( convert_from( decrypt ( CAST ( replacement_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS replacement_tax, SUM ( CAST ( convert_from( decrypt ( CAST ( fact_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS fact_salary , SUM ( CAST ( convert_from( decrypt ( CAST ( suspend_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS suspend_bonus FROM salary_totals GROUP BY company_id, YEAR, MONTH ) AS A WHERE A.company_id =? AND A.YEAR =? AND A.MONTH =? ORDER BY A.company_id" ;
	private final static String RESULTSETFIELDLIST = "company_id,year,month,should_salary,leave_advance,should_bonus,should_total,should_tax,total_insurance,total_fund,instead_deduct,instead_deduct_ill,fact_salary,num,unit_total_insurance,unit_total_fund,replacement_tax,suspend_bonus";
	private final static String[] fieldNames = { "company_id", "year", "month"};
}
