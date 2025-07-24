package pomplatform.ManageProjectByProject.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ManageProjectByProject.bean.BaseManageProjectByProject;
import pomplatform.ManageProjectByProject.bean.ConditionManageProjectByProject;

public class QueryManageProjectByProject extends AbstractQuery<BaseManageProjectByProject, ConditionManageProjectByProject>
{

	private static final Logger __logger = Logger.getLogger(QueryManageProjectByProject.class);

	public QueryManageProjectByProject() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("plate_id");
	}

	@Override
	public BaseCollection<BaseManageProjectByProject> executeQuery( KeyValuePair[] replacements, ConditionManageProjectByProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getRecordYear(), 
				condition.getRecordMonth(), 
				condition.getManageProjectName()
			);
	}

	@Override
	public BaseManageProjectByProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseManageProjectByProject __base = new BaseManageProjectByProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setManageProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setManageProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "select plate_id,manage_project_id,manage_project_name,total_integral,left_integral,project_date,remark from manage_projects where plate_id = ? and extract(year from project_date) = ? and extract(month from project_date) = ? and manage_project_name like ? order by total_integral desc" ;
	private final static String RESULTSETFIELDLIST = "plate_id,manage_project_id,manage_project_name,total_integral,left_integral,project_date,remark";
	private final static String[] fieldNames = { "plate_id", "record_year", "record_month", "manage_project_name"};
}
