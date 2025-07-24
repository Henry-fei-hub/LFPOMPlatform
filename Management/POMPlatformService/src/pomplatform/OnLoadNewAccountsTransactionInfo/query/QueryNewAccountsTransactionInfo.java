package pomplatform.OnLoadNewAccountsTransactionInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnLoadNewAccountsTransactionInfo.bean.BaseNewAccountsTransactionInfo;
import pomplatform.OnLoadNewAccountsTransactionInfo.bean.ConditionNewAccountsTransactionInfo;

public class QueryNewAccountsTransactionInfo extends AbstractQuery<BaseNewAccountsTransactionInfo, ConditionNewAccountsTransactionInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryNewAccountsTransactionInfo.class);

	public QueryNewAccountsTransactionInfo() throws java.sql.SQLException 
	{
		setParameterNumber(17);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("nat.account_transaction_id");
	}

	@Override
	public BaseCollection<BaseNewAccountsTransactionInfo> executeQuery( KeyValuePair[] replacements, ConditionNewAccountsTransactionInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAccountTransactionId(), 
				condition.getAccountId(), 
				condition.getOriginalCurrencyDebit(), 
				condition.getOriginalCurrencyLoan(), 
				condition.getExchangeRate(), 
				condition.getStandardMoneyDebit(), 
				condition.getStandardMoneyLoan(), 
				condition.getItemCategory(), 
				condition.getMainProjectCode(), 
				condition.getContractId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getRecordDate(), 
				condition.getAffiliationDate(), 
				condition.getRemark(), 
				condition.getAccountCode(), 
				condition.getRunningAccount()
			);
	}

	@Override
	public BaseNewAccountsTransactionInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseNewAccountsTransactionInfo __base = new BaseNewAccountsTransactionInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAccountTransactionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOriginalCurrencyDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOriginalCurrencyLoan(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setExchangeRate(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setStandardMoneyDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStandardMoneyLoan(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setItemCategory(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAffiliationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccountCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRunningAccount(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[2]));
		if(args[3] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[3]));
		if(args[4] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[4]));
		if(args[5] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[5]));
		if(args[6] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
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

	private final static String __SQLText = "select nat.account_transaction_id, nat.account_id, nat.original_currency_debit, nat.original_currency_loan, nat.exchange_rate, nat.standard_money_debit, nat.standard_money_loan, nat.item_category, nat.main_project_code, nat.contract_id, nat.department_id, nat.plate_id, nat.employee_id, nat.record_date, nat.affiliation_date, nat.remark, nat.account_code, nat.running_account from new_account_transations nat where nat.account_transaction_id = ? and nat.account_id = ? and nat.original_currency_debit = ? and nat.original_currency_loan = ? and nat.exchange_rate = ? and nat.standard_money_debit = ? and nat.standard_money_loan = ? and nat.item_category = ? and nat.main_project_code = ? and nat.contract_id = ? and nat.department_id = ? and nat.employee_id = ? and nat.record_date = ? and nat.affiliation_date = ? and nat.remark = ? and nat.account_code = ? and nat.running_account = ?" ;
	private final static String RESULTSETFIELDLIST = "account_transaction_id,account_id,original_currency_debit,original_currency_loan,exchange_rate,standard_money_debit,standard_money_loan,item_category,main_project_code,contract_id,department_id,plate_id,employee_id,record_date,affiliation_date,remark,account_code,running_account";
	private final static String[] fieldNames = { "account_transaction_id", "account_id", "original_currency_debit", "original_currency_loan", "exchange_rate", "standard_money_debit", "standard_money_loan", "item_category", "main_project_code", "contract_id", "department_id", "employee_id", "record_date", "affiliation_date", "remark", "account_code", "running_account"};
}
