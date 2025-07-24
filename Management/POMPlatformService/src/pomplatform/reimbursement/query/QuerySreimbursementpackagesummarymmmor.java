package pomplatform.reimbursement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursement.bean.BaseSreimbursementpackagesummarymmmor;
import pomplatform.reimbursement.bean.ConditionSreimbursementpackagesummarymmmor;

public class QuerySreimbursementpackagesummarymmmor extends AbstractQuery<BaseSreimbursementpackagesummarymmmor, ConditionSreimbursementpackagesummarymmmor>
{

	private static final Logger __logger = Logger.getLogger(QuerySreimbursementpackagesummarymmmor.class);

	public QuerySreimbursementpackagesummarymmmor() throws java.sql.SQLException 
	{
		setParameterNumber(19);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rps.reimbursement_package_summary_id");
	}

	@Override
	public BaseCollection<BaseSreimbursementpackagesummarymmmor> executeQuery( KeyValuePair[] replacements, ConditionSreimbursementpackagesummarymmmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinCreateTime(), 
				condition.getMaxCreateTime(), 
				condition.getMinUpdateTime(), 
				condition.getMaxUpdateTime(), 
				condition.getOtherName(), 
				condition.getAmount(), 
				condition.getPaymentAmount(), 
				condition.getStrikeABalanceAmount(), 
				condition.getIsCompleted(), 
				condition.getPayeeName(), 
				condition.getSelfBankName(), 
				condition.getSelfBankAccount(), 
				condition.getOtherBankName(), 
				condition.getOtherBankAccount(), 
				condition.getReimbursementPackageSummaryId(), 
				condition.getReimbursementPackageId(), 
				condition.getMoneyAttribute(), 
				condition.getPayFor(), 
				condition.getEmployeeOrCompanyId()
			);
	}

	@Override
	public BaseSreimbursementpackagesummarymmmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSreimbursementpackagesummarymmmor __base = new BaseSreimbursementpackagesummarymmmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setReimbursementPackageSummaryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayFor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeOrCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOtherBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPaymentAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStrikeABalanceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[5]));
		if(args[6] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[6]));
		if(args[7] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[7]));
		if(args[8] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
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

	private final static String __SQLText = "select rps.reimbursement_package_summary_id, rps.reimbursement_package_id, rps.money_attribute, rps.pay_for, rps.employee_or_company_id, rps.payee_name, rps.self_bank_name, rps.self_bank_account, rps.other_name, rps.other_bank_name, rps.other_bank_account, rps.amount, rps.payment_amount, rps.strike_a_balance_amount, rps.create_time, rps.update_time, rps.is_completed from reimbursement_package_summarys rps where rps.create_time between ? and ? and rps.update_time between ? and ? and rps.other_name = ? and rps.amount = ? and rps.payment_amount = ? and rps.strike_a_balance_amount = ? and rps.is_completed = ? and rps.payee_name like ? and rps.self_bank_name like ? and rps.self_bank_account like ? and rps.other_bank_name like ? and rps.other_bank_account like ? and rps.reimbursement_package_summary_id = ? and rps.reimbursement_package_id = ? and rps.money_attribute = ? and rps.pay_for = ? and rps.employee_or_company_id = ? ORDER BY rps.update_time" ;
	private final static String RESULTSETFIELDLIST = "reimbursement_package_summary_id,reimbursement_package_id,money_attribute,pay_for,employee_or_company_id,payee_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,amount,payment_amount,strike_a_balance_amount,create_time,update_time,is_completed";
	private final static String[] fieldNames = { "min_create_time", "max_create_time", "min_update_time", "max_update_time", "other_name", "amount", "payment_amount", "strike_a_balance_amount", "is_completed", "payee_name", "self_bank_name", "self_bank_account", "other_bank_name", "other_bank_account", "reimbursement_package_summary_id", "reimbursement_package_id", "money_attribute", "pay_for", "employee_or_company_id"};
}
