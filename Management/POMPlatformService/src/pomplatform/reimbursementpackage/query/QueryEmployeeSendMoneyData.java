package pomplatform.reimbursementpackage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursementpackage.bean.BaseEmployeeSendMoneyData;
import pomplatform.reimbursementpackage.bean.ConditionEmployeeSendMoneyData;

public class QueryEmployeeSendMoneyData extends AbstractQuery<BaseEmployeeSendMoneyData, ConditionEmployeeSendMoneyData>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeSendMoneyData.class);

	public QueryEmployeeSendMoneyData() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeSendMoneyData> executeQuery( KeyValuePair[] replacements, ConditionEmployeeSendMoneyData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeFundIssuanceId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseEmployeeSendMoneyData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeSendMoneyData __base = new BaseEmployeeSendMoneyData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFactSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
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

	private final static String __SQLText = "select a.employee_id, a.employee_no, em.employee_name, a.year, a.month, a.issue_money AS fact_salary, cm.bank_account, cm.bank_id, cm.bank_address, bk.bank_name FROM employee_fund_issuance_details a left join employees em on a.employee_id = em.employee_id left join card_manages cm on cm.object_id = A.employee_id AND cm.object_type = 1 AND cm.default_card = TRUE AND cm.enabled = TRUE LEFT JOIN banks bk ON bk.bank_id = cm.bank_id WHERE a.employee_fund_issuance_id =? and a.employee_id =? ORDER BY a.employee_id asc" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,year,month,fact_salary,bank_account,bank_id,bank_address,bank_name";
	private final static String[] fieldNames = { "employee_fund_issuance_id", "employee_id"};
}
