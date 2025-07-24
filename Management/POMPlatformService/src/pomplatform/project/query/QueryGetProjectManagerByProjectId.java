package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseGetProjectManagerByProjectId;
import pomplatform.project.bean.ConditionGetProjectManagerByProjectId;

public class QueryGetProjectManagerByProjectId extends AbstractQuery<BaseGetProjectManagerByProjectId, ConditionGetProjectManagerByProjectId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjectManagerByProjectId.class);

	public QueryGetProjectManagerByProjectId() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("project_manage_id");
	}

	@Override
	public BaseCollection<BaseGetProjectManagerByProjectId> executeQuery( KeyValuePair[] replacements, ConditionGetProjectManagerByProjectId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseGetProjectManagerByProjectId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjectManagerByProjectId __base = new BaseGetProjectManagerByProjectId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT project_manage_id from projects a LEFT JOIN employees b on a.project_manage_id = b.employee_id where project_id = ? and b.status = 0" ;
	private final static String RESULTSETFIELDLIST = "project_manage_id";
	private final static String[] fieldNames = { "project_id"};
}
