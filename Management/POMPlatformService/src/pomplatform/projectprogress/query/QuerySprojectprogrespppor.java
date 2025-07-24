package pomplatform.projectprogress.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectprogress.bean.BaseSprojectprogrespppor;
import pomplatform.projectprogress.bean.ConditionSprojectprogrespppor;

public class QuerySprojectprogrespppor extends AbstractQuery<BaseSprojectprogrespppor, ConditionSprojectprogrespppor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectprogrespppor.class);

	public QuerySprojectprogrespppor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pp.project_progress_id");
	}

	@Override
	public BaseCollection<BaseSprojectprogrespppor> executeQuery( KeyValuePair[] replacements, ConditionSprojectprogrespppor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectProgressId(), 
				condition.getProjectId(), 
				condition.getProjectManageId(), 
				condition.getDesignPhase()
			);
	}

	@Override
	public BaseSprojectprogrespppor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectprogrespppor __base = new BaseSprojectprogrespppor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectProgressId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDesignPhase(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFinishDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, (java.lang.Integer)args[2]);
		if(args[3] != null) __statement.setInt(count++, (java.lang.Integer)args[3]);
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

	private final static String __SQLText = "select pp.project_progress_id, pp.project_id, pp.project_manage_id, pp.design_phase, pp.finish_date, pp.alternate_field1, pp.alternate_field2, pp.alternate_field3, pp.status from project_progress pp where pp.project_progress_id = ? and pp.project_id = ? and pp.project_manage_id = ? and pp.design_phase = ?" ;
	private final static String RESULTSETFIELDLIST = "project_progress_id,project_id,project_manage_id,design_phase,finish_date,alternate_field1,alternate_field2,alternate_field3,status";
	private final static String[] fieldNames = { "project_progress_id", "project_id", "project_manage_id", "design_phase"};
}
