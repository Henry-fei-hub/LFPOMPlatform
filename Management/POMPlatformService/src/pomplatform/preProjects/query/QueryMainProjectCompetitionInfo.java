package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseMainProjectCompetitionInfo;
import pomplatform.preProjects.bean.ConditionMainProjectCompetitionInfo;

public class QueryMainProjectCompetitionInfo extends AbstractQuery<BaseMainProjectCompetitionInfo, ConditionMainProjectCompetitionInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryMainProjectCompetitionInfo.class);

	public QueryMainProjectCompetitionInfo() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.name");
	}

	@Override
	public BaseCollection<BaseMainProjectCompetitionInfo> executeQuery( KeyValuePair[] replacements, ConditionMainProjectCompetitionInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMainProjectId(), 
				condition.getPreProjectId()
			);
	}

	@Override
	public BaseMainProjectCompetitionInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMainProjectCompetitionInfo __base = new BaseMainProjectCompetitionInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT b.name, b.address from main_project_competition_units a LEFT JOIN competition_units b on a.competition_unit_id = b.competition_unit_id where a.main_project_id = ? and a.pre_project_id = ?" ;
	private final static String RESULTSETFIELDLIST = "name,address";
	private final static String[] fieldNames = { "main_project_id", "pre_project_id"};
}
