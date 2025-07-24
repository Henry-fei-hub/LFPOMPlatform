package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseSumDepartmentCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionSumDepartmentCapitalDistribution;

public class QuerySumDepartmentCapitalDistribution extends AbstractQuery<BaseSumDepartmentCapitalDistribution, ConditionSumDepartmentCapitalDistribution>
{

	private static final Logger __logger = Logger.getLogger(QuerySumDepartmentCapitalDistribution.class);

	public QuerySumDepartmentCapitalDistribution() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sum(distribution_amount) as amount");
	}

	@Override
	public BaseCollection<BaseSumDepartmentCapitalDistribution> executeQuery( KeyValuePair[] replacements, ConditionSumDepartmentCapitalDistribution condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseSumDepartmentCapitalDistribution generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSumDepartmentCapitalDistribution __base = new BaseSumDepartmentCapitalDistribution();
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
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

	private final static String __SQLText = "SELECT sum(distribution_amount) as amount from capital_distributions where capital_id in (SELECT capital_id from capitals where money_attribute in (1, 11, 13) and happen_date >= ? and happen_date < ?) and delete_flag = 0" ;
	private final static String RESULTSETFIELDLIST = "amount";
	private final static String[] fieldNames = { "start_date", "end_date"};
}
