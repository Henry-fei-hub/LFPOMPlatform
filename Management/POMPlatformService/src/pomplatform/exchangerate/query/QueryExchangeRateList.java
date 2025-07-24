package pomplatform.exchangerate.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.exchangerate.bean.BaseExchangeRateList;
import pomplatform.exchangerate.bean.ConditionExchangeRateList;

public class QueryExchangeRateList extends AbstractQuery<BaseExchangeRateList, ConditionExchangeRateList>
{

	private static final Logger __logger = Logger.getLogger(QueryExchangeRateList.class);

	public QueryExchangeRateList() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("er.exchange_rate_id");
	}

	@Override
	public BaseCollection<BaseExchangeRateList> executeQuery( KeyValuePair[] replacements, ConditionExchangeRateList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCurrencyId(), 
				condition.getExchangeDate()
			);
	}

	@Override
	public BaseExchangeRateList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseExchangeRateList __base = new BaseExchangeRateList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setExchangeRateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCurrencyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setExchangeDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select er.exchange_rate_id, er.currency_id, er.exchange_rate, er.exchange_date from exchange_rate er where er.currency_id = ? and er.exchange_date = ? order by er.exchange_date, er.currency_id" ;
	private final static String RESULTSETFIELDLIST = "exchange_rate_id,currency_id,exchange_rate,exchange_date";
	private final static String[] fieldNames = { "currency_id", "exchange_date"};
}
