package pomplatform.projectCost.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectCost.bean.BaseGetUnsettledProjectCost;
import pomplatform.projectCost.bean.ConditionGetUnsettledProjectCost;

public class QueryGetUnsettledProjectCost extends AbstractQuery<BaseGetUnsettledProjectCost, ConditionGetUnsettledProjectCost>
{

	private static final Logger __logger = Logger.getLogger(QueryGetUnsettledProjectCost.class);

	public QueryGetUnsettledProjectCost() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_cost_id");
	}

	@Override
	public BaseCollection<BaseGetUnsettledProjectCost> executeQuery( KeyValuePair[] replacements, ConditionGetUnsettledProjectCost condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseGetUnsettledProjectCost generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetUnsettledProjectCost __base = new BaseGetUnsettledProjectCost();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectCostId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.project_cost_id, a.amount from project_cost a LEFT JOIN projects b on a.project_id = b.project_id WHERE a.status = 0 and b.plate_id = ? and a.cost_date < ?" ;
	private final static String RESULTSETFIELDLIST = "project_cost_id,amount";
	private final static String[] fieldNames = { "plate_id", "end_date"};
}
