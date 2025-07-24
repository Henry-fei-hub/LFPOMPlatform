package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadProjectStage;
import pomplatform.project.bean.ConditionOnLoadProjectStage;

public class QueryOnLoadProjectStage extends AbstractQuery<BaseOnLoadProjectStage, ConditionOnLoadProjectStage>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectStage.class);

	public QueryOnLoadProjectStage() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT stage_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectStage> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectStage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getCheckEmployeeId()
			);
	}

	@Override
	public BaseOnLoadProjectStage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectStage __base = new BaseOnLoadProjectStage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select DISTINCT stage_id from project_employee_audit_records where project_id =? and check_employee_id =? and stage_id >=0" ;
	private final static String RESULTSETFIELDLIST = "stage_id";
	private final static String[] fieldNames = { "project_id", "check_employee_id"};
}
