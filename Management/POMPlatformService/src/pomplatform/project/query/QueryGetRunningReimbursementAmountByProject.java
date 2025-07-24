package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseGetRunningReimbursementAmountByProject;
import pomplatform.project.bean.ConditionGetRunningReimbursementAmountByProject;

public class QueryGetRunningReimbursementAmountByProject extends AbstractQuery<BaseGetRunningReimbursementAmountByProject, ConditionGetRunningReimbursementAmountByProject>
{

	private static final Logger __logger = Logger.getLogger(QueryGetRunningReimbursementAmountByProject.class);

	public QueryGetRunningReimbursementAmountByProject() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("count(*) as amount from system_process_instances where delete_flag = 0 and process_status in (0");
	}

	@Override
	public BaseCollection<BaseGetRunningReimbursementAmountByProject> executeQuery( KeyValuePair[] replacements, ConditionGetRunningReimbursementAmountByProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getProjectId()
			);
	}

	@Override
	public BaseGetRunningReimbursementAmountByProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetRunningReimbursementAmountByProject __base = new BaseGetRunningReimbursementAmountByProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT count(*) as amount from system_process_instances where delete_flag = 0 and process_status in (0, 1) and ((process_type in (2,3) and business_id in (SELECT DISTINCT project_normal_reimbursement_id from normal_reimbursement_link_projects where project_id = ?)) or (process_type in (4,5) and business_id in (SELECT DISTINCT travel_reimbursement_id from travel_reimbursement_link_projects where project_id = ?)))" ;
	private final static String RESULTSETFIELDLIST = "amount";
	private final static String[] fieldNames = { "project_id", "project_id"};
}
