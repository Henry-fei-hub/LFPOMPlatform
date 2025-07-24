package pomplatform.financialStatements.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialStatements.bean.BaseFinancialBankAccountPayment;
import pomplatform.financialStatements.bean.ConditionFinancialBankAccountPayment;

public class QueryFinancialBankAccountPayment extends AbstractQuery<BaseFinancialBankAccountPayment, ConditionFinancialBankAccountPayment>
{

	private static final Logger __logger = Logger.getLogger(QueryFinancialBankAccountPayment.class);

	public QueryFinancialBankAccountPayment() throws java.sql.SQLException 
	{
		setParameterNumber(18);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pbl.other_name");
	}

	@Override
	public BaseCollection<BaseFinancialBankAccountPayment> executeQuery( KeyValuePair[] replacements, ConditionFinancialBankAccountPayment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getMinUpdateTime(), 
				condition.getMaxUpdateTime(), 
				condition.getCompanyId(), 
				condition.getMinUpdateTime(), 
				condition.getMaxUpdateTime(), 
				condition.getCompanyId(), 
				condition.getMinUpdateTime(), 
				condition.getMaxUpdateTime(), 
				condition.getCompanyId(), 
				condition.getMinUpdateTime(), 
				condition.getMaxUpdateTime(), 
				condition.getCompanyId(), 
				condition.getMinUpdateTime(), 
				condition.getMaxUpdateTime(), 
				condition.getCompanyId(), 
				condition.getMinUpdateTime(), 
				condition.getMaxUpdateTime()
			);
	}

	@Override
	public BaseFinancialBankAccountPayment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFinancialBankAccountPayment __base = new BaseFinancialBankAccountPayment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOtherName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[10]));
		if(args[11] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[16]));
		if(args[17] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[17]));
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

	private final static String __SQLText = "SELECT pbl.other_name, pbl.other_bank_account, SUM(pay_money) AS amount, 1 as type FROM process_bill_list pbl WHERE pbl.process_bill_list_id IN ( SELECT DISTINCT rpd.process_bill_list_id FROM reimbursement_package_details rpd LEFT JOIN reimbursement_packages rp ON rp.reimbursement_package_id = rpd.reimbursement_package_id LEFT JOIN project_normal_reimbursements pnr ON pnr.project_normal_reimbursement_id = rpd.business_id WHERE rpd.process_type_id IN (2, 8) AND pnr.company_id = ? AND rp.update_time BETWEEN ? AND ? AND rp.is_completed = TRUE UNION ALL SELECT DISTINCT rpd.process_bill_list_id FROM reimbursement_package_details rpd LEFT JOIN reimbursement_packages rp ON rp.reimbursement_package_id = rpd.reimbursement_package_id LEFT JOIN travel_reimbursements tr ON tr.travel_reimbursement_id = rpd.business_id WHERE rpd.process_type_id IN (4, 9) AND tr.company_id = ? AND rp.update_time BETWEEN ? AND ? AND rp.is_completed = TRUE ) GROUP BY pbl.other_name,pbl.other_bank_account UNION ALL SELECT pbl.other_name, pbl.other_bank_account, SUM(pay_money) AS amount, 2 as type FROM process_bill_list pbl WHERE pbl.process_bill_list_id IN ( SELECT DISTINCT rpd.process_bill_list_id FROM reimbursement_package_details rpd LEFT JOIN reimbursement_packages rp ON rp.reimbursement_package_id = rpd.reimbursement_package_id LEFT JOIN employee_money_manages emm ON emm.employee_money_manage_id = rpd.business_id WHERE rpd.process_type_id = 6 AND emm.company_id = ? AND rp.update_time BETWEEN ? AND ? AND rp.is_completed = TRUE ) GROUP BY pbl.other_name,pbl.other_bank_account UNION ALL SELECT pbl.other_name, pbl.other_bank_account, SUM(pay_money) AS amount, 3 as type FROM process_bill_list pbl WHERE pbl.process_bill_list_id IN ( SELECT DISTINCT rpd.process_bill_list_id FROM reimbursement_package_details rpd LEFT JOIN reimbursement_packages rp ON rp.reimbursement_package_id = rpd.reimbursement_package_id LEFT JOIN pay_money_manages pmm ON pmm.pay_money_manage_id = rpd.business_id WHERE rpd.process_type_id = 7 AND pmm.company_id = ? AND rp.update_time BETWEEN ? AND ? AND rp.is_completed = TRUE ) GROUP BY pbl.other_name,pbl.other_bank_account UNION ALL SELECT pbl.other_name, pbl.other_bank_account, SUM(pay_money) AS amount, 4 as type FROM process_bill_list pbl WHERE pbl.process_bill_list_id IN ( SELECT DISTINCT rpd.process_bill_list_id FROM reimbursement_package_details rpd LEFT JOIN reimbursement_packages rp ON rp.reimbursement_package_id = rpd.reimbursement_package_id LEFT JOIN project_normal_reimbursements pnr ON pnr.project_normal_reimbursement_id = rpd.business_id WHERE rpd.process_type_id IN (3, 10) AND pnr.company_id = ? AND rp.update_time BETWEEN ? AND ? AND rp.is_completed = TRUE UNION ALL SELECT DISTINCT rpd.process_bill_list_id FROM reimbursement_package_details rpd LEFT JOIN reimbursement_packages rp ON rp.reimbursement_package_id = rpd.reimbursement_package_id LEFT JOIN travel_reimbursements tr ON tr.travel_reimbursement_id = rpd.business_id WHERE rpd.process_type_id IN (5) AND tr.company_id = ? AND rp.update_time BETWEEN ? AND ? AND rp.is_completed = TRUE ) GROUP BY pbl.other_name,pbl.other_bank_account" ;
	private final static String RESULTSETFIELDLIST = "other_name,other_bank_account,amount,type";
	private final static String[] fieldNames = { "company_id", "min_update_time", "max_update_time", "company_id", "min_update_time", "max_update_time", "company_id", "min_update_time", "max_update_time", "company_id", "min_update_time", "max_update_time", "company_id", "min_update_time", "max_update_time", "company_id", "min_update_time", "max_update_time"};
}
