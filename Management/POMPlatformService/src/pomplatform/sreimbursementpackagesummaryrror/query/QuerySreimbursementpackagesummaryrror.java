package pomplatform.sreimbursementpackagesummaryrror.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sreimbursementpackagesummaryrror.bean.BaseSreimbursementpackagesummaryrror;
import pomplatform.sreimbursementpackagesummaryrror.bean.ConditionSreimbursementpackagesummaryrror;

public class QuerySreimbursementpackagesummaryrror extends AbstractQuery<BaseSreimbursementpackagesummaryrror, ConditionSreimbursementpackagesummaryrror>
{

	private static final Logger __logger = Logger.getLogger(QuerySreimbursementpackagesummaryrror.class);

	public QuerySreimbursementpackagesummaryrror() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rps.reimbursement_package_summary_id");
	}

	@Override
	public BaseCollection<BaseSreimbursementpackagesummaryrror> executeQuery( KeyValuePair[] replacements, ConditionSreimbursementpackagesummaryrror condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getReimbursementPackageSummaryId(), 
				condition.getReimbursementPackageId()
			);
	}

	@Override
	public BaseSreimbursementpackagesummaryrror generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSreimbursementpackagesummaryrror __base = new BaseSreimbursementpackagesummaryrror();
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

	private final static String __SQLText = "select rps.reimbursement_package_summary_id, rps.reimbursement_package_id, rps.money_attribute, rps.pay_for, rps.employee_or_company_id, rps.payee_name, rps.self_bank_name, rps.self_bank_account, rps.other_name, rps.other_bank_name, rps.other_bank_account, rps.amount, rps.payment_amount, rps.strike_a_balance_amount, rps.create_time, rps.update_time, rps.is_completed from reimbursement_package_summarys rps where rps.reimbursement_package_summary_id = ? and rps.reimbursement_package_id = ?" ;
	private final static String RESULTSETFIELDLIST = "reimbursement_package_summary_id,reimbursement_package_id,money_attribute,pay_for,employee_or_company_id,payee_name,self_bank_name,self_bank_account,other_name,other_bank_name,other_bank_account,amount,payment_amount,strike_a_balance_amount,create_time,update_time,is_completed";
	private final static String[] fieldNames = { "reimbursement_package_summary_id", "reimbursement_package_id"};
}
