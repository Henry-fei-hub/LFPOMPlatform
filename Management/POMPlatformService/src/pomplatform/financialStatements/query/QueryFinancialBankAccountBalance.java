package pomplatform.financialStatements.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialStatements.bean.BaseFinancialBankAccountBalance;
import pomplatform.financialStatements.bean.ConditionFinancialBankAccountBalance;

public class QueryFinancialBankAccountBalance extends AbstractQuery<BaseFinancialBankAccountBalance, ConditionFinancialBankAccountBalance>
{

	private static final Logger __logger = Logger.getLogger(QueryFinancialBankAccountBalance.class);

	public QueryFinancialBankAccountBalance() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("COALESCE (SUM(borrow_money)");
	}

	@Override
	public BaseCollection<BaseFinancialBankAccountBalance> executeQuery( KeyValuePair[] replacements, ConditionFinancialBankAccountBalance condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinHappenDate(), 
				condition.getSelfName()
			);
	}

	@Override
	public BaseFinancialBankAccountBalance generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFinancialBankAccountBalance __base = new BaseFinancialBankAccountBalance();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBeforeMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSelfName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT COALESCE (SUM(borrow_money), 0) - COALESCE (SUM(loan_money), 0) AS before_money, cp.self_name, cp.self_bank_account FROM capitals cp WHERE cp.happen_date < ? AND cp.self_name = ? GROUP BY cp.self_name, cp.self_bank_account" ;
	private final static String RESULTSETFIELDLIST = "before_money,self_name,self_bank_account";
	private final static String[] fieldNames = { "min_happen_date", "self_name"};
}
