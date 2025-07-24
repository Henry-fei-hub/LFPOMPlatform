package pomplatform.financialtransactionaccount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialtransactionaccount.bean.BaseTransDetail;
import pomplatform.financialtransactionaccount.bean.ConditionTransDetail;

public class QueryTransDetail extends AbstractQuery<BaseTransDetail, ConditionTransDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryTransDetail.class);

	public QueryTransDetail() throws java.sql.SQLException 
	{
		setParameterNumber(24);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("k.financial_transaction_account_id");
	}

	@Override
	public BaseCollection<BaseTransDetail> executeQuery( KeyValuePair[] replacements, ConditionTransDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAccountType(), 
				condition.getFinanceNo(), 
				condition.getAccountName(), 
				condition.getAccountStatus(), 
				condition.getFinancialTransactionAccountId(), 
				condition.getInitDeleteFlag(), 
				condition.getCompanyId(),
				condition.getAccountType(), 
				condition.getFinanceNo(), 
				condition.getAccountName(), 
				condition.getAccountStatus(), 
				condition.getFinancialTransactionAccountId(), 
				condition.getInitEndDate(), 
				condition.getDetailDeleteFlag(), 
				condition.getCompanyId(),
				condition.getAccountType(), 
				condition.getFinanceNo(), 
				condition.getAccountName(), 
				condition.getAccountStatus(), 
				condition.getFinancialTransactionAccountId(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getDetailDeleteFlag(),
				condition.getCompanyId()
			);
	}

	@Override
	public BaseTransDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTransDetail __base = new BaseTransDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFinancialTransactionAccountId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFinanceNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccountName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsHumanAdd(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setAccountStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSummary(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFinancialTransactionDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOrderNo(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setStandardDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStandardCredit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setInt(count++, GenericBase.__getInt(args[19]));
		if(args[20] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[20]));
		if(args[21] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[21]));
		if(args[22] != null) __statement.setInt(count++, GenericBase.__getInt(args[22]));
		if(args[23] != null) __statement.setInt(count++, GenericBase.__getInt(args[23]));
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

	private final static String __SQLText = "select k.financial_transaction_account_id, k.account_type, k.finance_no, k.account_name, false as is_human_add, k.account_status, null as record_date, '期初余额' as summary, 0 as financial_transaction_detail_id, 0 as order_no, true as is_completed, case when (sum(k.standard_debit) > sum(k.standard_credit) ) then sum(k.standard_debit) - sum(k.standard_credit) else 0 end as standard_debit, case when (sum(k.standard_debit) < sum(k.standard_credit) ) then sum(k.standard_credit) - sum(k.standard_debit) else 0 end as standard_credit, k.company_id, 0 as process_instance_id, 0 as process_type, 0 as process_id from ( (select a.financial_transaction_account_id, a.account_type, a.finance_no, a.account_name, a.account_status, b.standard_debit, b.standard_credit, b.company_id from financial_transaction_accounts a LEFT JOIN financial_account_init_amount b on a.financial_transaction_account_id = b.financial_transaction_account_id where a.account_type = ? and a.finance_no like ? and a.account_name like ? and a.account_status = ? and a.financial_transaction_account_id = ? and b.delete_flag = ? and b.company_id = ? ) union all ( select a.financial_transaction_account_id, a.account_type, a.finance_no, a.account_name, a.account_status, b.standard_debit, b.standard_credit, b.company_id from financial_transaction_accounts a LEFT JOIN financial_transaction_details b on a.financial_transaction_account_id = b.financial_transaction_account_id where a.account_type = ? and a.finance_no like ? and a.account_name like ? and a.account_status = ? and a.financial_transaction_account_id = ? and b.record_date < ? and b.delete_flag = ? and b.company_id = ?) ) k group by k.financial_transaction_account_id, k.company_id, k.account_type, k.finance_no, k.account_name, k.account_status union all ( select a.financial_transaction_account_id, a.account_type, a.finance_no, a.account_name, b.is_human_add, a.account_status, b.record_date, b.summary, b.financial_transaction_detail_id, 1 as order_no, b.is_completed, b.standard_debit, b.standard_credit, b.company_id, b.process_instance_id, b.process_type, c.process_id from financial_transaction_details b LEFT JOIN financial_transaction_accounts a on b.financial_transaction_account_id = a.financial_transaction_account_id left join system_process_instances c on b.process_instance_id = c.process_instance_id where a.account_type = ? and a.finance_no like ? and a.account_name like ? and a.account_status = ? and a.financial_transaction_account_id = ? and b.record_date >= ? and b.record_date <= ? and b.delete_flag = ? and b.company_id = ?) order by financial_transaction_account_id, account_type, order_no, record_date, summary, standard_debit desc" ;
	private final static String RESULTSETFIELDLIST = "financial_transaction_account_id,account_type,finance_no,account_name,is_human_add,account_status,record_date,summary,financial_transaction_detail_id,order_no,is_completed,standard_debit,standard_credit,company_id,process_instance_id,process_type,process_id";
	private final static String[] fieldNames = { "account_type", "finance_no", "account_name", "account_status", "financial_transaction_account_id", "init_delete_flag", "company_id", "account_type", "finance_no", "account_name", "account_status", "financial_transaction_account_id", "init_end_date", "detail_delete_flag", "company_id", "account_type", "finance_no", "account_name", "account_status", "financial_transaction_account_id", "start_date", "end_date", "detail_delete_flag", "company_id"};
}
