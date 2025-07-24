package pomplatform.OnLoadNewAccounts.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnLoadNewAccounts.bean.BaseOneNewAccountsTransationsInfo;
import pomplatform.OnLoadNewAccounts.bean.ConditionOneNewAccountsTransationsInfo;

public class QueryOneNewAccountsTransationsInfo extends AbstractQuery<BaseOneNewAccountsTransationsInfo, ConditionOneNewAccountsTransationsInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryOneNewAccountsTransationsInfo.class);

	public QueryOneNewAccountsTransationsInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("na.account_name");
	}

	@Override
	public BaseCollection<BaseOneNewAccountsTransationsInfo> executeQuery( KeyValuePair[] replacements, ConditionOneNewAccountsTransationsInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAccountId()
			);
	}

	@Override
	public BaseOneNewAccountsTransationsInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOneNewAccountsTransationsInfo __base = new BaseOneNewAccountsTransationsInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAccountName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccountTransactionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOriginalCurrencyDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOriginalCurrencyLoan(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStandardMoneyDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStandardMoneyLoan(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT na.account_name,nat.account_transaction_id, nat.account_id, nat.original_currency_debit, nat.original_currency_loan, nat.exchange_rate, nat.standard_money_debit, nat.standard_money_loan, nat.item_category, nat.main_project_code, nat.contract_id, nat.department_id, nat.plate_id, nat.employee_id, nat.record_date, nat.affiliation_date, nat.remark, nat.account_code, nat.running_account FROM new_account_transations nat LEFT JOIN new_accounts na ON nat.account_id=na.account_id WHERE nat.account_id=?" ;
	private final static String RESULTSETFIELDLIST = "account_name,account_transaction_id,account_id,original_currency_debit,original_currency_loan,exchange_rate,standard_money_debit,standard_money_loan,item_category,main_project_code,contract_id,department_id,plate_id,employee_id,record_date,affiliation_date,remark,account_code,running_account";
	private final static String[] fieldNames = { "account_id"};
}
