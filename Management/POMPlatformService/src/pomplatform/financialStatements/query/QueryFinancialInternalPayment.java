package pomplatform.financialStatements.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialStatements.bean.BaseFinancialInternalPayment;
import pomplatform.financialStatements.bean.ConditionFinancialInternalPayment;

public class QueryFinancialInternalPayment extends AbstractQuery<BaseFinancialInternalPayment, ConditionFinancialInternalPayment>
{

	private static final Logger __logger = Logger.getLogger(QueryFinancialInternalPayment.class);

	public QueryFinancialInternalPayment() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cpd.dic_type_value_id");
	}

	@Override
	public BaseCollection<BaseFinancialInternalPayment> executeQuery( KeyValuePair[] replacements, ConditionFinancialInternalPayment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompnayId(), 
				condition.getMinHappenDate(), 
				condition.getMaxHappenDate()
			);
	}

	@Override
	public BaseFinancialInternalPayment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFinancialInternalPayment __base = new BaseFinancialInternalPayment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDicTypeValueId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT cpd.dic_type_value_id, SUM(cpd.borrow_money) AS amount FROM ( SELECT sd.dic_type_value_id, cp.borrow_money FROM capitals cp, ( SELECT dic_type_value_id, dic_type_value FROM system_dictionary WHERE dic_type_id = 26 ) sd WHERE sd.dic_type_value = cp.other_name AND cp.borrow_money <> 0 AND cp.borrow_money NOTNULL AND cp.capital_type = 1 AND cp.money_attribute = 6 AND sd.dic_type_value_id = ? AND sd.dic_type_value_id in (replace) AND cp.happen_date BETWEEN ? AND ? ) cpd GROUP BY cpd.dic_type_value_id" ;
	private final static String RESULTSETFIELDLIST = "dic_type_value_id,amount";
	private final static String[] fieldNames = { "compnay_id", "min_happen_date", "max_happen_date"};
}
