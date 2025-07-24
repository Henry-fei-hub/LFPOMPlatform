package pomplatform.sumDesignconsideration.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sumDesignconsideration.bean.BaseSumDesignconsideration;
import pomplatform.sumDesignconsideration.bean.ConditionSumDesignconsideration;

public class QuerySumDesignconsideration extends AbstractQuery<BaseSumDesignconsideration, ConditionSumDesignconsideration>
{

	private static final Logger __logger = Logger.getLogger(QuerySumDesignconsideration.class);

	public QuerySumDesignconsideration() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sum(money_sum) as money_sum");
	}

	@Override
	public BaseCollection<BaseSumDesignconsideration> executeQuery( KeyValuePair[] replacements, ConditionSumDesignconsideration condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInfoCode()
			);
	}

	@Override
	public BaseSumDesignconsideration generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSumDesignconsideration __base = new BaseSumDesignconsideration();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInteriorMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSplitPrice(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = " select sum(money_sum) as money_sum,sum(interior_money_sum) as interior_money_sum,sum(split_price) as split_price from design_considerations where info_code = ?" ;
	private final static String RESULTSETFIELDLIST = "money_sum,interior_money_sum,split_price";
	private final static String[] fieldNames = { "info_code"};
}
