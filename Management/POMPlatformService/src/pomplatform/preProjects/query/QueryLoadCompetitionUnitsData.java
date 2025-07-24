package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseLoadCompetitionUnitsData;
import pomplatform.preProjects.bean.ConditionLoadCompetitionUnitsData;

public class QueryLoadCompetitionUnitsData extends AbstractQuery<BaseLoadCompetitionUnitsData, ConditionLoadCompetitionUnitsData>
{

	private static final Logger __logger = Logger.getLogger(QueryLoadCompetitionUnitsData.class);

	public QueryLoadCompetitionUnitsData() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .main_project_competition_unit_id");
	}

	@Override
	public BaseCollection<BaseLoadCompetitionUnitsData> executeQuery( KeyValuePair[] replacements, ConditionLoadCompetitionUnitsData condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getPreProjectId(), 
				condition.getMainProjectId()
			);
	}

	public BaseCollection<BaseLoadCompetitionUnitsData> runQuery( KeyValuePair[] replacements, ConditionLoadCompetitionUnitsData condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getPreProjectId(), 
				condition.getMainProjectId()
			);
	}

	public BaseCollection<BaseLoadCompetitionUnitsData> execute( KeyValuePair[] replacements, ConditionLoadCompetitionUnitsData condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getPreProjectId(), 
				condition.getMainProjectId()
			);
	}

	@Override
	public BaseLoadCompetitionUnitsData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseLoadCompetitionUnitsData __base = new BaseLoadCompetitionUnitsData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMainProjectCompetitionUnitId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompetitionUnitId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBiddingInformation(GenericBase.__getString(val));
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
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "SELECT A .main_project_competition_unit_id, A.main_project_id, A.competition_unit_id, b.NAME, b.address, A.pre_project_id, A.bidding_information FROM main_project_competition_units A LEFT JOIN competition_units b ON A.competition_unit_id = b.competition_unit_id WHERE A.pre_project_id = ? and A.main_project_id = ?" ;
	private final static String __originalSQL = "SELECT A .main_project_competition_unit_id, A.main_project_id, A.competition_unit_id, b.NAME, b.address, A.pre_project_id, A.bidding_information FROM main_project_competition_units A LEFT JOIN competition_units b ON A.competition_unit_id = b.competition_unit_id WHERE A.pre_project_id =:pre_project_id and A.main_project_id =:main_project_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.pre_project_id =:pre_project_id and A.main_project_id =:main_project_id\",\"startIndex\": 268,\"stopIndex\":340,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.pre_project_id =:pre_project_id\",\"fullFieldName\":\"A.pre_project_id\",\"operationName\":\"=\",\"variableName\":\"preProjectId\",\"startIndex\": 268,\"stopIndex\":300,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.main_project_id =:main_project_id\",\"fullFieldName\":\"A.main_project_id\",\"operationName\":\"=\",\"variableName\":\"mainProjectId\",\"startIndex\": 306,\"stopIndex\":340,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "main_project_competition_unit_id,main_project_id,competition_unit_id,name,address,pre_project_id,bidding_information";
	private final static String[] fieldNames = { "pre_project_id", "main_project_id"};
}
