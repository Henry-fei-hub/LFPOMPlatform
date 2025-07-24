package pomplatform.reimbursementpackage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursementpackage.bean.BaseSalarySendDataPay;
import pomplatform.reimbursementpackage.bean.ConditionSalarySendDataPay;

public class QuerySalarySendDataPay extends AbstractQuery<BaseSalarySendDataPay, ConditionSalarySendDataPay>
{

	private static final Logger __logger = Logger.getLogger(QuerySalarySendDataPay.class);

	public QuerySalarySendDataPay() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.company_id");
	}

	@Override
	public BaseCollection<BaseSalarySendDataPay> executeQuery( KeyValuePair[] replacements, ConditionSalarySendDataPay condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getCompanyId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName()
			);
	}

	@Override
	public BaseSalarySendDataPay generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSalarySendDataPay __base = new BaseSalarySendDataPay();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFactSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTruePayment(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT a.company_id, a.employee_id, a.employee_no, a.employee_name, a.year, a.month, a.fact_salary, cm.bank_account, cm.bank_id, cm.bank_address, cm.true_payment, sd.dic_type_value as bank_name FROM ( SELECT company_id, employee_id, employee_no, employee_name, bank_account, YEAR, MONTH, CAST ( convert_from( decrypt ( CAST (should_salary AS bytea), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS should_salary, CAST ( convert_from( decrypt ( CAST (leave_no_deduct_tax AS bytea), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS leave_no_deduct_tax, CAST ( convert_from( decrypt ( CAST (leave_deduct_tax AS bytea), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS leave_deduct_tax, CAST ( convert_from( decrypt ( CAST (should_bonus AS bytea), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS should_bonus, CAST ( convert_from( decrypt ( CAST (should_tax AS bytea), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS should_tax, CAST ( convert_from( decrypt ( CAST (total_insurance AS bytea), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS total_insurance, CAST ( convert_from( decrypt ( CAST (total_fund AS bytea), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS total_fund, CAST ( convert_from( decrypt ( CAST (instead_deduct AS bytea), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS instead_deduct, CAST ( convert_from( decrypt ( CAST (instead_deduct_ill AS bytea), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS instead_deduct_ill, CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS unit_total_insurance, CAST ( convert_from( decrypt ( CAST (unit_total_fund AS bytea), CAST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS unit_total_fund, CAST (convert_from(decrypt ( CAST ( fact_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS NUMERIC ) AS fact_salary FROM salary_totals ) AS a LEFT JOIN card_manages cm ON cm.object_id = a.employee_id and cm.object_type = 1 AND cm.default_card = true AND cm.enabled = true LEFT JOIN system_dictionary sd ON sd. dic_type_value_id = cm.bank_id AND sd.dic_type_id = 68 WHERE a.year = ? AND a.month = ? AND a.company_id = ? AND a.employee_no LIKE ? AND a.employee_name LIKE ? ORDER BY a.employee_id" ;
	private final static String RESULTSETFIELDLIST = "company_id,employee_id,employee_no,employee_name,year,month,fact_salary,bank_account,bank_id,bank_address,true_payment,bank_name";
	private final static String[] fieldNames = { "year", "month", "company_id", "employee_no", "employee_name"};
}
