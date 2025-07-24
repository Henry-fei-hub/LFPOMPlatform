package pomplatform.cost.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cost.bean.BaseSprojectcostpor;
import pomplatform.cost.bean.ConditionSprojectcostpor;

public class QuerySprojectcostpor extends AbstractQuery<BaseSprojectcostpor, ConditionSprojectcostpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectcostpor.class);

	public QuerySprojectcostpor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sum(to_number(pc.cost_money");
	}

	@Override
	public BaseCollection<BaseSprojectcostpor> executeQuery( KeyValuePair[] replacements, ConditionSprojectcostpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseSprojectcostpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectcostpor __base = new BaseSprojectcostpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCostMoney(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
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

	private final static String __SQLText = "select sum(pc.amount) as cost_money from project_cost pc where pc.project_id = ? and status = 0" ;
	private final static String RESULTSETFIELDLIST = "cost_money";
	private final static String[] fieldNames = { "project_id"};
}
