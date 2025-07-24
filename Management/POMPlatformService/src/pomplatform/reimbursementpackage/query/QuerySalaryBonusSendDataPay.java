package pomplatform.reimbursementpackage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursementpackage.bean.BaseSalaryBonusSendDataPay;
import pomplatform.reimbursementpackage.bean.ConditionSalaryBonusSendDataPay;

public class QuerySalaryBonusSendDataPay extends AbstractQuery<BaseSalaryBonusSendDataPay, ConditionSalaryBonusSendDataPay>
{

	private static final Logger __logger = Logger.getLogger(QuerySalaryBonusSendDataPay.class);

	public QuerySalaryBonusSendDataPay() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.company_id");
	}

	@Override
	public BaseCollection<BaseSalaryBonusSendDataPay> executeQuery( KeyValuePair[] replacements, ConditionSalaryBonusSendDataPay condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(),
				condition.getPersonnelBusinessId()
			);
	}

	@Override
	public BaseSalaryBonusSendDataPay generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSalaryBonusSendDataPay __base = new BaseSalaryBonusSendDataPay();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFactBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBankId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankAddress(GenericBase.__getString(val));
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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT b.company_id, a.employee_id, b.employee_no, b.employee_name, cm.bank_account, a.year, a.month, cast ( convert_from( decrypt ( CaST (a.fact_bonus aS bytea), CaST ( ( SELECT image_path FROM system_config WHERE system_config_id = 2 ) aS bytea ), 'aes' ), 'SQL_aSCII' ) aS NUMERIC ) aS fact_bonus,cm.bank_id, cm.bank_address,sd.dic_type_value as bank_name FROM salary_of_bonus a LEFT JOIN employees b ON a.employee_id = b.employee_id LEFT JOIN card_manages cm ON a.employee_id = cm.object_id and cm.object_type = 1 and cm.enabled = TRUE and cm.default_card = TRUE LEFT JOIN system_dictionary sd ON sd.dic_type_value_id = cm.bank_id AND sd.dic_type_id = 68 WHERE a.flag = 2 and a.company_id = ? and a.year = ? and a.month = ? and b.employee_no LIKE ? and b.employee_name LIKE ? AND personnel_business_id =? ORDER BY a.employee_id" ;
	private final static String RESULTSETFIELDLIST = "company_id,employee_id,employee_no,employee_name,bank_account,year,month,fact_bonus,bank_id,bank_address,bank_name";
	private final static String[] fieldNames = { "company_id", "year", "month", "employee_no", "employee_name", "personnel_business_id"};
}
