package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseResidualwageData;
import pomplatform.payment.bean.ConditionResidualwageData;

public class QueryResidualwageData extends AbstractQuery<BaseResidualwageData, ConditionResidualwageData>
{

	private static final Logger __logger = Logger.getLogger(QueryResidualwageData.class);

	public QueryResidualwageData() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .company_id");
	}

	@Override
	public BaseCollection<BaseResidualwageData> executeQuery( KeyValuePair[] replacements, ConditionResidualwageData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getCompanyid(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName()
			);
	}

	@Override
	public BaseResidualwageData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseResidualwageData __base = new BaseResidualwageData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFactSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIssueMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBalance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRatio(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT A .company_id, A.employee_id, A.employee_no, A.employee_name, A.bank_account, A.YEAR, A.MONTH, A.fact_salary AS fact_salary, B.issue_money, A.fact_salary - B.issue_money AS balance ,0.0 as ratio FROM ( SELECT company_id, employee_id, employee_no, employee_name, bank_account, YEAR, MONTH, CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS should_salary, CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS leave_no_deduct_tax, CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS leave_deduct_tax, CAST ( convert_from( decrypt ( CAST ( should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS should_bonus, CAST ( convert_from( decrypt ( CAST ( should_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS should_tax, CAST ( convert_from( decrypt ( CAST ( total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS total_insurance, CAST ( convert_from( decrypt ( CAST ( total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS total_fund, CAST ( convert_from( decrypt ( CAST ( instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS instead_deduct, CAST ( convert_from( decrypt ( CAST ( instead_deduct_ill AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS instead_deduct_ill, CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS unit_total_insurance, CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS unit_total_fund, CAST ( convert_from( decrypt ( CAST ( fact_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS fact_salary FROM salary_totals ) AS A LEFT JOIN ( SELECT employee_id, employee_no, SUM ( issue_money ) AS issue_money, YEAR, MONTH FROM employee_fund_issuance_details where process_status != 0 and year =? and month =? GROUP BY employee_id, employee_no, YEAR, MONTH ) AS B ON A.employee_id = B.employee_id AND A.YEAR = B.YEAR AND A.MONTH = B.MONTH WHERE A.fact_salary - B.issue_money != 0 AND A.year =? AND A.month =? AND A.company_id =? AND A.employee_no LIKE ? AND A.employee_name LIKE ? ORDER BY A.company_id, A.employee_id" ;
	private final static String RESULTSETFIELDLIST = "company_id,employee_id,employee_no,employee_name,bank_account,year,month,fact_salary,issue_money,balance,ratio";
	private final static String[] fieldNames = { "year", "month", "year", "month", "companyId", "employee_no", "employee_name"};
}
