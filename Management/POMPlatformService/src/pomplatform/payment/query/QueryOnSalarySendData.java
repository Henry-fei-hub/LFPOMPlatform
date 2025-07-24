package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalarySendData;
import pomplatform.payment.bean.ConditionOnSalarySendData;

public class QueryOnSalarySendData extends AbstractQuery<BaseOnSalarySendData, ConditionOnSalarySendData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalarySendData.class);

	public QueryOnSalarySendData() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .company_id");
	}

	@Override
	public BaseCollection<BaseOnSalarySendData> executeQuery( KeyValuePair[] replacements, ConditionOnSalarySendData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getCompanyId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName()
			);
	}

	@Override
	public BaseOnSalarySendData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalarySendData __base = new BaseOnSalarySendData();
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
		if((val = __data[count++]) != null) __base.setSalaryissue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLoanissue(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBalance(GenericBase.__getDecimal(val));
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
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
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

	private final static String __SQLText = "SELECT A .company_id, A.employee_id, A.employee_no, A.employee_name, cm.bank_account, A.year, A.month, A.fact_salary AS fact_salary, B.issue_money AS salaryIssue, C.issue_money AS loanIssue, A.fact_salary - B.issue_money - C.issue_money AS balance FROM ( SELECT company_id, employee_id, employee_no, employee_name, bank_account, year, month, CAST ( convert_from( decrypt ( CAST ( fact_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ) AS fact_salary FROM salary_totals ) AS A LEFT JOIN card_manages cm ON cm.object_id = A.employee_id  AND cm.object_type = 1 AND cm.default_card = TRUE  AND cm.enabled = TRUE LEFT JOIN system_dictionary sd ON sd.dic_type_value_id = cm.bank_id  AND sd.dic_type_id = 68  LEFT JOIN ( SELECT employee_id, employee_no, SUM ( issue_money ) AS issue_money, year, month, process_status FROM employee_fund_issuance_details WHERE year =? AND month =? AND process_status != 0 AND fund_type = 1 GROUP BY employee_id, employee_no, year, month, process_status ) AS B ON A.employee_id = B.employee_id AND A.year = B.year AND A.month = B.month LEFT JOIN( SELECT employee_id, employee_no, SUM ( issue_money ) AS issue_money, year, month, process_status FROM employee_fund_issuance_details WHERE year =? AND month =? AND fund_type = 4 AND process_status != 0 GROUP BY employee_id, employee_no, year, month, process_status ) AS C on A.employee_id = C.employee_id AND A.year = C.year AND A.month = C.month WHERE A.year =? AND A.month =? AND A.company_id =? AND A.employee_no LIKE ? AND A.employee_name LIKE ? ORDER BY A.company_id, A.employee_id" ;
	private final static String RESULTSETFIELDLIST = "company_id,employee_id,employee_no,employee_name,bank_account,year,month,fact_salary,salaryissue,loanissue,balance";
	private final static String[] fieldNames = { "year", "month", "year", "month", "year", "month", "company_id", "employee_no", "employee_name"};
}
