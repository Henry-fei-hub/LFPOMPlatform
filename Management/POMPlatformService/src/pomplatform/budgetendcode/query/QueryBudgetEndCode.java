package pomplatform.budgetendcode.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.budgetendcode.bean.BaseBudgetEndCode;
import pomplatform.budgetendcode.bean.ConditionBudgetEndCode;

public class QueryBudgetEndCode extends AbstractQuery<BaseBudgetEndCode, ConditionBudgetEndCode>
{

	private static final Logger __logger = Logger.getLogger(QueryBudgetEndCode.class);

	public QueryBudgetEndCode() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("count(day) as end_number FROM ( SELECT date_part('year'");
	}

	@Override
	public BaseCollection<BaseBudgetEndCode> executeQuery( KeyValuePair[] replacements, ConditionBudgetEndCode condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseBudgetEndCode generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBudgetEndCode __base = new BaseBudgetEndCode();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEndNumber(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT count(day) as end_number FROM ( SELECT date_part('year', bd_apply_time) as year, date_part('month', bd_apply_time) as MONTH, date_part('day', bd_apply_time) as day FROM budget_management ) as a WHERE a.YEAR=? AND a.MONTH=?" ;
	private final static String RESULTSETFIELDLIST = "end_number";
	private final static String[] fieldNames = { "YEAR", "MONTH"};
}
