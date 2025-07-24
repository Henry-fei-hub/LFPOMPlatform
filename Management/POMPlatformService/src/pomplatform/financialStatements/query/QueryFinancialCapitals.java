package pomplatform.financialStatements.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialStatements.bean.BaseFinancialCapitals;
import pomplatform.financialStatements.bean.ConditionFinancialCapitals;

public class QueryFinancialCapitals extends AbstractQuery<BaseFinancialCapitals, ConditionFinancialCapitals>
{

	private static final Logger __logger = Logger.getLogger(QueryFinancialCapitals.class);

	public QueryFinancialCapitals() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cp.self_name");
	}

	@Override
	public BaseCollection<BaseFinancialCapitals> executeQuery( KeyValuePair[] replacements, ConditionFinancialCapitals condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSelfName(), 
				condition.getMinHappenDate(), 
				condition.getMaxHappenDate()
			);
	}

	@Override
	public BaseFinancialCapitals generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFinancialCapitals __base = new BaseFinancialCapitals();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSelfName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT cp.self_name, cp.money_attribute, SUM(cp.borrow_money) AS amount FROM capitals cp WHERE cp.capital_type = 1 AND cp.self_name in (replace) AND cp.self_name = ? AND cp.happen_date BETWEEN ? AND ? GROUP BY cp.self_name, cp.money_attribute ORDER BY cp.self_name, cp.money_attribute" ;
	private final static String RESULTSETFIELDLIST = "self_name,money_attribute,amount";
	private final static String[] fieldNames = { "self_name", "min_happen_date", "max_happen_date"};
}
