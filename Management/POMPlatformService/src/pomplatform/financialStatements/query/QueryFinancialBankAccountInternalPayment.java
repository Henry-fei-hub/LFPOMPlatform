package pomplatform.financialStatements.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialStatements.bean.BaseFinancialBankAccountInternalPayment;
import pomplatform.financialStatements.bean.ConditionFinancialBankAccountInternalPayment;

public class QueryFinancialBankAccountInternalPayment extends AbstractQuery<BaseFinancialBankAccountInternalPayment, ConditionFinancialBankAccountInternalPayment>
{

	private static final Logger __logger = Logger.getLogger(QueryFinancialBankAccountInternalPayment.class);

	public QueryFinancialBankAccountInternalPayment() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cp.other_bank_account");
	}

	@Override
	public BaseCollection<BaseFinancialBankAccountInternalPayment> executeQuery( KeyValuePair[] replacements, ConditionFinancialBankAccountInternalPayment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getObjectId(), 
				condition.getMinHappenDate(), 
				condition.getMaxHappenDate()
			);
	}

	@Override
	public BaseFinancialBankAccountInternalPayment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFinancialBankAccountInternalPayment __base = new BaseFinancialBankAccountInternalPayment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT cp.other_bank_account, SUM(cp.borrow_money) amount FROM capitals cp WHERE cp.capital_type = 1 AND cp.money_attribute = 6 AND cp.other_bank_account IN(SELECT bank_account FROM card_manages cm WHERE cm.object_id = ? AND cm.object_type = 2) AND cp.happen_date BETWEEN ? AND ? GROUP BY cp.other_bank_account" ;
	private final static String RESULTSETFIELDLIST = "other_bank_account,amount";
	private final static String[] fieldNames = { "object_id", "min_happen_date", "max_happen_date"};
}
