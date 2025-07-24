package pomplatform.financialtransactionaccount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialtransactionaccount.bean.BaseTransDetailSummary;
import pomplatform.financialtransactionaccount.bean.ConditionTransDetailSummary;

public class QueryTransDetailSummary extends AbstractQuery<BaseTransDetailSummary, ConditionTransDetailSummary>
{

	private static final Logger __logger = Logger.getLogger(QueryTransDetailSummary.class);

	public QueryTransDetailSummary() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("k.financial_transaction_account_id");
	}

	@Override
	public BaseCollection<BaseTransDetailSummary> executeQuery( KeyValuePair[] replacements, ConditionTransDetailSummary condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDeleteFlag(), 
				condition.getInitEndDate(),
				condition.getDeleteFlag(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getDeleteFlag(), 
				condition.getAccountType(), 
				condition.getFinanceNo(), 
				condition.getAccountName(), 
				condition.getAccountStatus(),
				condition.getCompanyId()
			);
	}

	@Override
	public BaseTransDetailSummary generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTransDetailSummary __base = new BaseTransDetailSummary();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFinanceNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccountName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReimbursable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setAccountStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInitStandardDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInitStandardCredit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStandardDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStandardCredit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEndingStandardDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEndingStandardCredit(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
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

	private final static String __SQLText = "select k.financial_transaction_account_id, k.company_id, k.account_type, k.finance_no, k.account_name, k.reimbursable, k.account_status, case when k.init_balance > 0 then k.init_balance else 0 end as init_standard_debit, case when k.init_balance < 0 then abs(k.init_balance) else 0 end as init_standard_credit, k.standard_debit, k.standard_credit, case when k.ending_balance > 0 then k.ending_balance else 0 end as ending_standard_debit, case when k.ending_balance < 0 then abs(k.ending_balance) else 0 end as ending_standard_credit from (select a.financial_transaction_account_id, a.account_type, a.finance_no, a.account_name, a.reimbursable, a.account_status, b.company_id, sum(COALESCE(b.init_standard_debit, 0)) - sum(COALESCE(b.init_standard_credit, 0)) as init_balance, sum(COALESCE(b.standard_debit, 0)) as standard_debit, sum(COALESCE(b.standard_credit, 0)) as standard_credit, sum(COALESCE(b.init_standard_debit, 0)) + sum(COALESCE(b.standard_debit, 0)) - sum(COALESCE(b.init_standard_credit, 0)) - sum(COALESCE(b.standard_credit, 0)) as ending_balance from financial_transaction_accounts a LEFT JOIN ( (select financial_transaction_account_id, company_id, sum(standard_debit) as init_standard_debit, sum(standard_credit) as init_standard_credit, 0 as standard_debit, 0 as standard_credit from financial_account_init_amount where delete_flag = ? group by financial_transaction_account_id, company_id) union all ( select financial_transaction_account_id, company_id, sum(standard_debit) as init_standard_debit, sum(standard_credit) as init_standard_credit, 0 as standard_debit, 0 as standard_credit from financial_transaction_details where record_date < ? and delete_flag = ? group by financial_transaction_account_id, company_id) union all ( select financial_transaction_account_id, company_id, 0 as init_standard_debit, 0 as init_standard_credit, sum(standard_debit) as standard_debit, sum(standard_credit) as standard_credit from financial_transaction_details where record_date >= ? and record_date <= ? and delete_flag = ? group by financial_transaction_account_id, company_id) ) b on a.financial_transaction_account_id = b.financial_transaction_account_id where a.account_type = ? and a.finance_no like ? and a.account_name like ? and a.account_status = ? and b.company_id = ? and a.account_name not like '%税务局%' and a.account_name not like '%住房公积金%' and a.account_name not like '%社保局%' and a.account_name not like '%银行手续费%' and a.account_name not like '%代发业务%' and a.account_name not like '%代缴%' and a.account_name not like '%社保基金缴费%' and a.account_name not like '%个税%' and a.account_name not like '%所得税%' and a.account_name not in (select company_name from company_records) group by a.financial_transaction_account_id, a.account_type, a.finance_no, a.account_name, a.reimbursable, a.account_status, b.company_id ) k where k.init_balance != 0 or k.standard_debit != 0 or k.standard_credit != 0 or k.ending_balance != 0 order by k.account_type" ;
	private final static String RESULTSETFIELDLIST = "financial_transaction_account_id,company_id,account_type,finance_no,account_name,reimbursable,account_status,init_standard_debit,init_standard_credit,standard_debit,standard_credit,ending_standard_debit,ending_standard_credit";
	private final static String[] fieldNames = { "delete_flag", "init_end_date", "delete_flag", "start_date", "end_date", "delete_flag", "account_type", "finance_no", "account_name", "account_status", "company_id"};
}
