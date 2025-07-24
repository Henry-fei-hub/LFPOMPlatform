package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseSearchProjectType16Data;
import pomplatform.project.bean.ConditionSearchProjectType16Data;

public class QuerySearchProjectType16Data extends AbstractQuery<BaseSearchProjectType16Data, ConditionSearchProjectType16Data>
{

	private static final Logger __logger = Logger.getLogger(QuerySearchProjectType16Data.class);

	public QuerySearchProjectType16Data() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.project_id");
	}

	@Override
	public BaseCollection<BaseSearchProjectType16Data> executeQuery( KeyValuePair[] replacements, ConditionSearchProjectType16Data condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseSearchProjectType16Data> runQuery( KeyValuePair[] replacements, ConditionSearchProjectType16Data condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseSearchProjectType16Data> execute( KeyValuePair[] replacements, ConditionSearchProjectType16Data condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectCode()
			);
	}

	@Override
	public BaseSearchProjectType16Data generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSearchProjectType16Data __base = new BaseSearchProjectType16Data();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "select p.project_id,p.project_manage_id,e.employee_name,e.employee_no,e.plate_id,p.project_code,p.contract_code,p.project_name from projects as p left join employees as e on p.project_manage_id = e.employee_id where p.project_code like ? and p.project_type = 16" ;
	private final static String __originalSQL = "select p.project_id,p.project_manage_id,e.employee_name,e.employee_no,e.plate_id,p.project_code,p.contract_code,p.project_name from projects as p left join employees as e on p.project_manage_id = e.employee_id where p.project_code like :project_code and p.project_type = 16";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"p.project_code like :project_code and p.project_type = 16\",\"startIndex\": 216,\"stopIndex\":272,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"p.project_code like :project_code\",\"fullFieldName\":\"p.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 216,\"stopIndex\":248,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"p.project_type = 16\",\"startIndex\": 254,\"stopIndex\":272,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_id,project_manage_id,employee_name,employee_no,plate_id,project_code,contract_code,project_name";
	private final static String[] fieldNames = { "project_code"};
}
