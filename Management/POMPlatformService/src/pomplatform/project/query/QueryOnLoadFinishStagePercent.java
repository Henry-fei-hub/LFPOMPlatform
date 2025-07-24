package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadFinishStagePercent;
import pomplatform.project.bean.ConditionOnLoadFinishStagePercent;

public class QueryOnLoadFinishStagePercent extends AbstractQuery<BaseOnLoadFinishStagePercent, ConditionOnLoadFinishStagePercent>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadFinishStagePercent.class);

	public QueryOnLoadFinishStagePercent() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseOnLoadFinishStagePercent> executeQuery( KeyValuePair[] replacements, ConditionOnLoadFinishStagePercent condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseOnLoadFinishStagePercent generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadFinishStagePercent __base = new BaseOnLoadFinishStagePercent();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select a.project_id,sum(b.percent) as percent from (select project_id,stage_id,min(upload_time) as upload_time from project_attachments GROUP BY project_id,stage_id ) as a left join project_stages b on a.project_id = b.project_id and a.stage_id = b.stage_id where a.project_id=? and upload_time <= ? GROUP BY a.project_id" ;
	private final static String RESULTSETFIELDLIST = "project_id,percent";
	private final static String[] fieldNames = { "project_id", "end_date"};
}
