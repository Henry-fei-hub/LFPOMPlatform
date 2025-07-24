package pomplatform.financialtransactionaccount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialtransactionaccount.bean.BaseHandingTransDetailSummary;
import pomplatform.financialtransactionaccount.bean.ConditionHandingTransDetailSummary;

public class QueryHandingTransDetailSummary extends AbstractQuery<BaseHandingTransDetailSummary, ConditionHandingTransDetailSummary>
{

	private static final Logger __logger = Logger.getLogger(QueryHandingTransDetailSummary.class);

	public QueryHandingTransDetailSummary() throws java.sql.SQLException 
	{
		setParameterNumber(54);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("k.financial_transaction_account_id");
	}

	@Override
	public BaseCollection<BaseHandingTransDetailSummary> executeQuery( KeyValuePair[] replacements, ConditionHandingTransDetailSummary condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getFinancialTransactionAccountId(), 
				condition.getCompanyId(),
				condition.getFinanceNo(), 
				condition.getAccountName(), 
				condition.getAccountType(), 
				condition.getAccountStatus(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getFinancialTransactionAccountId(), 
				condition.getCompanyId(),
				condition.getFinanceNo(), 
				condition.getAccountName(), 
				condition.getAccountType(), 
				condition.getAccountStatus(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getCompanyId(),
				condition.getFinancialTransactionAccountId(), 
				condition.getCompanyId(),
				condition.getFinanceNo(), 
				condition.getAccountName(), 
				condition.getAccountType(), 
				condition.getAccountStatus(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getFinancialTransactionAccountId(), 
				condition.getCompanyId(),
				condition.getFinanceNo(), 
				condition.getAccountName(), 
				condition.getAccountType(), 
				condition.getAccountStatus(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getInitEndDate(), 
				condition.getCompanyId(),
				condition.getFinancialTransactionAccountId(), 
				condition.getCompanyId(),
				condition.getFinanceNo(), 
				condition.getAccountName(), 
				condition.getAccountType(), 
				condition.getAccountStatus(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getFinancialTransactionAccountId(), 
				condition.getCompanyId(),
				condition.getFinanceNo(), 
				condition.getAccountName(), 
				condition.getAccountType(), 
				condition.getAccountStatus(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(),
				condition.getCompanyId()
			);
	}

	@Override
	public BaseHandingTransDetailSummary generateBase(Object[] __data) throws java.sql.SQLException {
		BaseHandingTransDetailSummary __base = new BaseHandingTransDetailSummary();
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
		if((val = __data[count++]) != null) __base.setEndStandardDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setEndStandardCredit(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setString(count++, GenericBase.__getString(args[19]));
		if(args[20] != null) __statement.setString(count++, GenericBase.__getString(args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
		if(args[22] != null) __statement.setInt(count++, GenericBase.__getInt(args[22]));
		if(args[23] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[23]));
		if(args[24] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[24]));
		if(args[25] != null) __statement.setInt(count++, GenericBase.__getInt(args[25]));
		if(args[26] != null) __statement.setInt(count++, GenericBase.__getInt(args[26]));
		if(args[27] != null) __statement.setString(count++, GenericBase.__getString(args[27]));
		if(args[28] != null) __statement.setString(count++, GenericBase.__getString(args[28]));
		if(args[29] != null) __statement.setInt(count++, GenericBase.__getInt(args[29]));
		if(args[30] != null) __statement.setInt(count++, GenericBase.__getInt(args[30]));
		if(args[31] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[31]));
		if(args[32] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[32]));
		if(args[33] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[33]));
		if(args[34] != null) __statement.setInt(count++, GenericBase.__getInt(args[34]));
		if(args[35] != null) __statement.setInt(count++, GenericBase.__getInt(args[35]));
		if(args[36] != null) __statement.setInt(count++, GenericBase.__getInt(args[36]));
		if(args[37] != null) __statement.setString(count++, GenericBase.__getString(args[37]));
		if(args[38] != null) __statement.setString(count++, GenericBase.__getString(args[38]));
		if(args[39] != null) __statement.setInt(count++, GenericBase.__getInt(args[39]));
		if(args[40] != null) __statement.setInt(count++, GenericBase.__getInt(args[40]));
		if(args[41] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[41]));
		if(args[42] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[42]));
		if(args[43] != null) __statement.setInt(count++, GenericBase.__getInt(args[43]));
		if(args[44] != null) __statement.setInt(count++, GenericBase.__getInt(args[44]));
		if(args[45] != null) __statement.setString(count++, GenericBase.__getString(args[45]));
		if(args[46] != null) __statement.setString(count++, GenericBase.__getString(args[46]));
		if(args[47] != null) __statement.setInt(count++, GenericBase.__getInt(args[47]));
		if(args[48] != null) __statement.setInt(count++, GenericBase.__getInt(args[48]));
		if(args[49] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[49]));
		if(args[50] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[50]));
		if(args[51] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[51]));
		if(args[52] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[52]));
		if(args[53] != null) __statement.setInt(count++, GenericBase.__getInt(args[53]));
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

	private final static String __SQLText = "select k.financial_transaction_account_id, k.company_id, fta.account_type, fta.finance_no, fta.account_name, fta.reimbursable, fta.account_status, case when sum(k.init_standard_debit) > sum(k.init_standard_credit) then sum(k.init_standard_debit) - sum(k.init_standard_credit) else 0 end as init_standard_debit, case when sum(k.init_standard_debit) < sum(k.init_standard_credit) then sum(k.init_standard_credit) - sum(k.init_standard_debit) else 0 end as init_standard_credit, case when sum(k.standard_debit) > sum(k.standard_credit) then sum(k.standard_debit) - sum(k.standard_credit) else 0 end as standard_debit, case when sum(k.standard_debit) < sum(k.standard_credit) then sum(k.standard_credit) - sum(k.standard_debit) else 0 end as standard_credit, case when sum(k.init_standard_debit) + sum(k.standard_debit) > sum(k.init_standard_credit) + sum(k.standard_credit) then sum(k.init_standard_debit) + sum(k.standard_debit) - sum(k.init_standard_credit) - sum(k.standard_credit) else 0 end as end_standard_debit, case when sum(k.init_standard_debit) + sum(k.standard_debit) < sum(k.init_standard_credit) + sum(k.standard_credit) then sum(k.init_standard_credit) + sum(k.standard_credit) - sum(k.init_standard_debit) - sum(k.standard_debit) else 0 end as end_standard_credit from ( select financial_transaction_account_id, company_id, standard_debit as init_standard_debit, standard_credit as init_standard_credit, 0 as standard_debit, 0 as standard_credit from financial_account_init_amount where financial_transaction_account_id in ( select distinct a.financial_transaction_account_id from financial_transaction_details a LEFT JOIN financial_transaction_accounts b on a.financial_transaction_account_id = b.financial_transaction_account_id where a.financial_transaction_account_id = ? and a.company_id = ? and b.finance_no like ? and b.account_name like ? and b.account_type = ? and b.account_status = ? and a.record_date >= ? and a.record_date <= ? and delete_flag = 0 union select distinct a.financial_transaction_account_id from financial_transaction_details a LEFT JOIN financial_transaction_accounts b on a.operator_account_id = b.financial_transaction_account_id where a.operator_account_id = ? and a.company_id = ? and b.finance_no like ? and b.account_name like ? and b.account_type = ? and b.account_status = ? and a.record_date >= ? and a.record_date <= ? and delete_flag = 0 ) and delete_flag = 0 and company_id = ? union all select g.financial_transaction_account_id, g.company_id, sum(g.standard_debit) as init_standard_debit, sum(g.standard_credit) as init_standard_credit, 0 as standard_debit, 0 as standard_credit from financial_transaction_details g where g.financial_transaction_account_id in ( select distinct a.financial_transaction_account_id from financial_transaction_details a LEFT JOIN financial_transaction_accounts b on a.financial_transaction_account_id = b.financial_transaction_account_id where a.financial_transaction_account_id = ? and a.company_id = ? and b.finance_no like ? and b.account_name like ? and b.account_type = ? and b.account_status = ? and a.record_date >= ? and a.record_date <= ? and delete_flag = 0 union select distinct a.financial_transaction_account_id from financial_transaction_details a LEFT JOIN financial_transaction_accounts b on a.operator_account_id = b.financial_transaction_account_id where a.operator_account_id = ? and a.company_id = ? and b.finance_no like ? and b.account_name like ? and b.account_type = ? and b.account_status = ? and a.record_date >= ? and a.record_date <= ? and delete_flag = 0 ) and g.record_date < ? and g.delete_flag = 0 and g.company_id = ? group by g.financial_transaction_account_id, g.company_id union all select financial_transaction_account_id, company_id, 0 as init_standard_debit, 0 as init_standard_credit, sum(standard_debit) as standard_debit, sum(standard_credit) as standard_credit from financial_transaction_details where financial_transaction_account_id in ( select distinct a.financial_transaction_account_id from financial_transaction_details a LEFT JOIN financial_transaction_accounts b on a.financial_transaction_account_id = b.financial_transaction_account_id where a.financial_transaction_account_id = ? and a.company_id = ? and b.finance_no like ? and b.account_name like ? and b.account_type = ? and b.account_status = ? and a.record_date >= ? and a.record_date <= ? and delete_flag = 0 union select distinct a.financial_transaction_account_id from financial_transaction_details a LEFT JOIN financial_transaction_accounts b on a.operator_account_id = b.financial_transaction_account_id where a.operator_account_id = ? and a.company_id = ? and b.finance_no like ? and b.account_name like ? and b.account_type = ? and b.account_status = ? and a.record_date >= ? and a.record_date <= ? and delete_flag = 0 ) and record_date >= ? and record_date <= ? and delete_flag = 0 and company_id = ? group by financial_transaction_account_id, company_id ) k LEFT JOIN financial_transaction_accounts fta on k.financial_transaction_account_id = fta.financial_transaction_account_id where fta.account_name not like '%税务局%' and fta.account_name not like '%住房公积金%' and fta.account_name not like '%社保局%' and fta.account_name not like '%银行手续费%' and fta.account_name not like '%代发业务%' and fta.account_name not like '%代缴%' and fta.account_name not like '%社保基金缴费%' and fta.account_name not like '%个税%' and fta.account_name not like '%所得税%' and fta.account_name not in (select company_name from company_records) and fta.account_type = 2 group by k.financial_transaction_account_id, k.company_id, fta.account_type, fta.finance_no, fta.account_name, fta.reimbursable, fta.account_status" ;
	private final static String RESULTSETFIELDLIST = "financial_transaction_account_id,company_id,account_type,finance_no,account_name,reimbursable,account_status,init_standard_debit,init_standard_credit,standard_debit,standard_credit,end_standard_debit,end_standard_credit";
	private final static String[] fieldNames = { "financial_transaction_account_id", "company_id", "finance_no", "account_name", "account_type", "account_status", "start_date", "end_date", "financial_transaction_account_id", "company_id", "finance_no", "account_name", "account_type", "account_status", "start_date", "end_date", "company_id", 
			"financial_transaction_account_id", "company_id", "finance_no", "account_name", "account_type", "account_status", "start_date", "end_date", "financial_transaction_account_id", "company_id", "finance_no", "account_name", "account_type", "account_status", "start_date", "end_date", "init_end_date", "company_id", 
			"financial_transaction_account_id", "company_id", "finance_no", "account_name", "account_type", "account_status", "start_date", "end_date", "financial_transaction_account_id", "company_id", "finance_no", "account_name", "account_type", "account_status", "start_date", "end_date", "start_date", "end_date", "company_id"};
}
