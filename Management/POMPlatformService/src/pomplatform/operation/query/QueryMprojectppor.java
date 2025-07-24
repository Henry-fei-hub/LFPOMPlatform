package pomplatform.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operation.bean.BaseMprojectppor;
import pomplatform.operation.bean.ConditionMprojectppor;

public class QueryMprojectppor extends AbstractQuery<BaseMprojectppor, ConditionMprojectppor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectppor.class);

	public QueryMprojectppor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.project_id");
	}

	@Override
	public BaseCollection<BaseMprojectppor> executeQuery( KeyValuePair[] replacements, ConditionMprojectppor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseMprojectppor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectppor __base = new BaseMprojectppor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalcount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select p.project_id, p.project_integral, sum(COALESCE(ps.total_amount,0.0)) as total_amount, sum(COALESCE(ps.total_cost,0.0)) as total_cost,count(ps.total_amount) as totalcount, p.project_integral-sum(COALESCE(ps.total_amount,0.0))-sum(COALESCE(ps.total_cost,0.0))-sum(COALESCE((select sum(amount) from project_cost where project_id = p.project_id and status = 0),0.0)) as left_amount  from projects p left join project_settlements ps on p.project_id = ps.project_id where p.project_id = ? group by p.project_id, p.project_integral" ;
	private final static String RESULTSETFIELDLIST = "project_id,project_integral,total_amount,total_cost,totalcount,left_amount";
	private final static String[] fieldNames = { "project_id"};
}
