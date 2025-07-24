package pomplatform.mcapitalcmmssmssbor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mcapitalcmmssmssbor.bean.BaseMcapitalcmmssmssbor;
import pomplatform.mcapitalcmmssmssbor.bean.ConditionMcapitalcmmssmssbor;

public class QueryMcapitalcmmssmssbor extends AbstractQuery<BaseMcapitalcmmssmssbor, ConditionMcapitalcmmssmssbor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcapitalcmmssmssbor.class);

	public QueryMcapitalcmmssmssbor() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.self_name");
	}

	@Override
	public BaseCollection<BaseMcapitalcmmssmssbor> executeQuery( KeyValuePair[] replacements, ConditionMcapitalcmmssmssbor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinHappenDate(), 
				condition.getMaxHappenDate(), 
				condition.getSelfName(), 
				condition.getSelfBankAccount(), 
				condition.getMinHappenDate(), 
				condition.getSelfName(), 
				condition.getSelfBankAccount(), 
				condition.getBankAddress(),
				condition.getSelfName()
			);
	}

	@Override
	public BaseMcapitalcmmssmssbor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcapitalcmmssmssbor __base = new BaseMcapitalcmmssmssbor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSelfName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBeforeMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLoanMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBalance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrencyType(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
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

	private final static String __SQLText = "SELECT cm.object_id, cm.bank_address, cc.self_bank_account, COALESCE(bb.before_money, 0) AS before_money, COALESCE (aa.borrow_money, 0) AS borrow_money, COALESCE (aa.loan_money, 0) AS loan_money, (COALESCE(bb.before_money, 0) + COALESCE(aa.borrow_money, 0) - COALESCE(aa.loan_money, 0)) AS balance, cm.currency_type FROM (SELECT DISTINCT self_bank_account FROM capitals) cc LEFT JOIN ( SELECT ca.self_name, ca.self_bank_account, COALESCE(SUM (original_currency), 0) AS borrow_money, COALESCE(SUM (loan_money), 0) AS loan_money FROM capitals ca WHERE ca.happen_date BETWEEN ? AND ? AND ca.self_name = ? AND ca.self_bank_account LIKE ? GROUP BY ca.self_bank_account, ca.self_name ) aa ON aa.self_bank_account = cc.self_bank_account LEFT JOIN ( SELECT COALESCE(SUM (original_currency), 0) - COALESCE(SUM (loan_money), 0) AS before_money, self_bank_account, self_name FROM capitals WHERE happen_date < ? AND self_name = ? AND self_bank_account LIKE ? GROUP BY self_bank_account, self_name ) bb ON cc.self_bank_account = bb.self_bank_account LEFT JOIN card_manages cm ON cc.self_bank_account = cm.bank_account AND cm.object_type = 2 where cm.bank_address LIKE ? AND aa.self_name = ?" ;
	private final static String RESULTSETFIELDLIST = "self_name,bank_address,self_bank_account,before_money,borrow_money,loan_money,balance";
	private final static String[] fieldNames = { "min_happen_date", "max_happen_date", "self_name", "self_bank_account", "min_happen_date", "self_name", "self_bank_account", "bank_address", "self_name",};
}
