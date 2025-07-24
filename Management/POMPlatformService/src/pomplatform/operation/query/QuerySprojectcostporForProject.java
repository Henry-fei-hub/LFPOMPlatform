package pomplatform.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operation.bean.BaseSprojectcostporForProject;
import pomplatform.operation.bean.ConditionSprojectcostporForProject;

public class QuerySprojectcostporForProject extends AbstractQuery<BaseSprojectcostporForProject, ConditionSprojectcostporForProject>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectcostporForProject.class);

	public QuerySprojectcostporForProject() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pc.project_cost_id");
	}

	@Override
	public BaseCollection<BaseSprojectcostporForProject> executeQuery( KeyValuePair[] replacements, ConditionSprojectcostporForProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseSprojectcostporForProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectcostporForProject __base = new BaseSprojectcostporForProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectCostId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCostType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select pc.project_cost_id, pc.project_id, pc.employee_id, pc.amount, pc.cost_type, pc.cost_date, pc.settlement_id, pc.status, pc.process_type, pc.business_id, pc.process_id, pc.process_instance_id from project_cost pc where pc.project_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_cost_id,project_id,employee_id,amount,cost_type,cost_date,settlement_id,status,process_type,business_id,process_id,process_instance_id";
	private final static String[] fieldNames = { "project_id"};
}
