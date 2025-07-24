package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseGetProjectECMCEmployeeInfo;
import pomplatform.preProjects.bean.ConditionGetProjectECMCEmployeeInfo;

public class QueryGetProjectECMCEmployeeInfo extends AbstractQuery<BaseGetProjectECMCEmployeeInfo, ConditionGetProjectECMCEmployeeInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjectECMCEmployeeInfo.class);

	public QueryGetProjectECMCEmployeeInfo() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.relation");
	}

	@Override
	public BaseCollection<BaseGetProjectECMCEmployeeInfo> executeQuery( KeyValuePair[] replacements, ConditionGetProjectECMCEmployeeInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMainProjectId(), 
				condition.getPreProjectId(), 
				condition.getRelation()
			);
	}

	@Override
	public BaseGetProjectECMCEmployeeInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjectECMCEmployeeInfo __base = new BaseGetProjectECMCEmployeeInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setRelation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEcmcUserId(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT a.relation, array_to_string(ARRAY(SELECT unnest(array_agg(b.employee_name))), ',') as employee_name, array_to_string(ARRAY(SELECT unnest(array_agg(b.ecmc_user_id))), ',') as ecmc_user_id from main_project_employees a LEFT JOIN employees b on a.employee_id = b.employee_id where a.main_project_id = ? and a.pre_project_id = ? and a.relation = ? GROUP BY a.relation" ;
	private final static String RESULTSETFIELDLIST = "relation,employee_name,ecmc_user_id";
	private final static String[] fieldNames = { "main_project_id", "pre_project_id", "relation"};
}
