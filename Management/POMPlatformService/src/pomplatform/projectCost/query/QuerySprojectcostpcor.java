package pomplatform.projectCost.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectCost.bean.BaseSprojectcostpcor;
import pomplatform.projectCost.bean.ConditionSprojectcostpcor;

public class QuerySprojectcostpcor extends AbstractQuery<BaseSprojectcostpcor, ConditionSprojectcostpcor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectcostpcor.class);

	public QuerySprojectcostpcor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pc.project_cost_id");
	}

	@Override
	public BaseCollection<BaseSprojectcostpcor> executeQuery( KeyValuePair[] replacements, ConditionSprojectcostpcor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getCostType()
			);
	}

	@Override
	public BaseSprojectcostpcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectcostpcor __base = new BaseSprojectcostpcor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectCostId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostMoney(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCostType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostDate(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
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

	private final static String __SQLText = "select pc.project_cost_id, pc.project_id, pc.employee_id, pc.amount, pc.cost_type, pc.cost_date from project_cost pc where pc.project_id = ? and pc.cost_type = ?" ;
	private final static String RESULTSETFIELDLIST = "project_cost_id,project_id,employee_id,cost_money,cost_type,cost_date";
	private final static String[] fieldNames = { "project_id", "cost_type"};
}
