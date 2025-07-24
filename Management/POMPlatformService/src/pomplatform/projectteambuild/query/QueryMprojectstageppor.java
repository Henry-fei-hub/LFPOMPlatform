package pomplatform.projectteambuild.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectteambuild.bean.BaseMprojectstageppor;
import pomplatform.projectteambuild.bean.ConditionMprojectstageppor;

public class QueryMprojectstageppor extends AbstractQuery<BaseMprojectstageppor, ConditionMprojectstageppor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectstageppor.class);

	public QueryMprojectstageppor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ps.project_stage_id");
	}

	@Override
	public BaseCollection<BaseMprojectstageppor> executeQuery( KeyValuePair[] replacements, ConditionMprojectstageppor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseMprojectstageppor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectstageppor __base = new BaseMprojectstageppor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStageName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT ps.project_stage_id,ps.project_id,ps.stage_id,ps.percent,ps.project_amount,ps.stage_name,CASE WHEN ps.project_amount-a.total is null THEN ps.project_amount ELSE ps.project_amount-a.total END as left_integral FROM project_stages ps LEFT JOIN (SELECT project_id,stage_id,CASE WHEN sum(plan_integral) is null THEN 0 ELSE sum(plan_integral) END as total FROM project_employees GROUP BY stage_id,project_id ORDER BY stage_id) a ON ps.project_id = a.project_id AND ps.stage_id = a.stage_id WHERE ps.project_id = ? ORDER BY ps.stage_id;" ;
	private final static String RESULTSETFIELDLIST = "project_stage_id,project_id,stage_id,percent,project_amount,stage_name,left_integral";
	private final static String[] fieldNames = { "project_id"};
}
