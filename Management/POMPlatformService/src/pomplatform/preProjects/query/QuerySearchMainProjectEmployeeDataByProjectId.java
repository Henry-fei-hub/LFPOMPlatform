package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseSearchMainProjectEmployeeDataByProjectId;
import pomplatform.preProjects.bean.ConditionSearchMainProjectEmployeeDataByProjectId;

public class QuerySearchMainProjectEmployeeDataByProjectId extends AbstractQuery<BaseSearchMainProjectEmployeeDataByProjectId, ConditionSearchMainProjectEmployeeDataByProjectId>
{

	private static final Logger __logger = Logger.getLogger(QuerySearchMainProjectEmployeeDataByProjectId.class);

	public QuerySearchMainProjectEmployeeDataByProjectId() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .main_project_employee_id");
	}

	@Override
	public BaseCollection<BaseSearchMainProjectEmployeeDataByProjectId> executeQuery( KeyValuePair[] replacements, ConditionSearchMainProjectEmployeeDataByProjectId condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getPreProjectId(), 
				condition.getRelation(), 
				condition.getMainProjectId()
			);
	}

	public BaseCollection<BaseSearchMainProjectEmployeeDataByProjectId> runQuery( KeyValuePair[] replacements, ConditionSearchMainProjectEmployeeDataByProjectId condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectId(), 
				condition.getPreProjectId(), 
				condition.getRelation(), 
				condition.getMainProjectId()
			);
	}

	public BaseCollection<BaseSearchMainProjectEmployeeDataByProjectId> execute( KeyValuePair[] replacements, ConditionSearchMainProjectEmployeeDataByProjectId condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectId(), 
				condition.getPreProjectId(), 
				condition.getRelation(), 
				condition.getMainProjectId()
			);
	}

	@Override
	public BaseSearchMainProjectEmployeeDataByProjectId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSearchMainProjectEmployeeDataByProjectId __base = new BaseSearchMainProjectEmployeeDataByProjectId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMainProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRelation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainAndAssistance(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsPlateManager(GenericBase.__getBoolean(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT A .main_project_employee_id, A.main_project_id, A.employee_id, A.relation, e.employee_no, e.employee_name, e.plate_id, A.main_and_assistance, A.is_plate_manager FROM (select DISTINCT main_project_id from projects as b left join main_projects as c on b.project_code = c.project_code where b.project_id = ? ) as bb left join main_project_employees A on a.main_project_id = bb.main_project_id LEFT JOIN employees e ON A.employee_id = e.employee_id WHERE A.pre_project_id = ? and A.relation = ? and A.main_project_id = ?" ;
	private final static String __originalSQL = "SELECT A .main_project_employee_id, A.main_project_id, A.employee_id, A.relation, e.employee_no, e.employee_name, e.plate_id, A.main_and_assistance, A.is_plate_manager FROM (select DISTINCT main_project_id from projects as b left join main_projects as c on b.project_code = c.project_code where b.project_id =:project_id ) as bb left join main_project_employees A on a.main_project_id = bb.main_project_id LEFT JOIN employees e ON A.employee_id = e.employee_id WHERE A.pre_project_id =:pre_project_id AND A.relation =:relation AND A.main_project_id =:main_project_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"b.project_id =:project_id\",\"startIndex\": 295,\"stopIndex\":319,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"b.project_id =:project_id\",\"fullFieldName\":\"b.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"startIndex\": 295,\"stopIndex\":319,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]},{\"fullCondition\": \"A.pre_project_id =:pre_project_id AND A.relation =:relation AND A.main_project_id =:main_project_id\",\"startIndex\": 467,\"stopIndex\":565,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.pre_project_id =:pre_project_id\",\"fullFieldName\":\"A.pre_project_id\",\"operationName\":\"=\",\"variableName\":\"preProjectId\",\"startIndex\": 467,\"stopIndex\":499,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.relation =:relation\",\"fullFieldName\":\"A.relation\",\"operationName\":\"=\",\"variableName\":\"relation\",\"startIndex\": 505,\"stopIndex\":525,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.main_project_id =:main_project_id\",\"fullFieldName\":\"A.main_project_id\",\"operationName\":\"=\",\"variableName\":\"mainProjectId\",\"startIndex\": 531,\"stopIndex\":565,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "main_project_employee_id,main_project_id,employee_id,relation,employee_no,employee_name,plate_id,main_and_assistance,is_plate_manager";
	private final static String[] fieldNames = { "project_id", "pre_project_id", "relation", "main_project_id"};
}
