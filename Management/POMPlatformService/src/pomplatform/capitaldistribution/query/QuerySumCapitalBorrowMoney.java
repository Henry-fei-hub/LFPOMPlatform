package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseSumCapitalBorrowMoney;
import pomplatform.capitaldistribution.bean.ConditionSumCapitalBorrowMoney;

public class QuerySumCapitalBorrowMoney extends AbstractQuery<BaseSumCapitalBorrowMoney, ConditionSumCapitalBorrowMoney>
{

	private static final Logger __logger = Logger.getLogger(QuerySumCapitalBorrowMoney.class);

	public QuerySumCapitalBorrowMoney() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sum(borrow_money) as amount");
	}

	@Override
	public BaseCollection<BaseSumCapitalBorrowMoney> executeQuery( KeyValuePair[] replacements, ConditionSumCapitalBorrowMoney condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMoneyAttribute(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseSumCapitalBorrowMoney generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSumCapitalBorrowMoney __base = new BaseSumCapitalBorrowMoney();
		int count = 0;
		Object val;
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

	private final static String __SQLText = "SELECT sum(borrow_money) as amount from capitals where money_attribute = ? and happen_date >= ? and happen_date < ?" ;
	private final static String RESULTSETFIELDLIST = "amount";
	private final static String[] fieldNames = { "money_attribute", "start_date", "end_date"};
}
