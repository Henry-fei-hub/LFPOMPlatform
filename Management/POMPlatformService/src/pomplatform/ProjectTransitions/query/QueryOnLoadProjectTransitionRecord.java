package pomplatform.ProjectTransitions.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ProjectTransitions.bean.BaseOnLoadProjectTransitionRecord;
import pomplatform.ProjectTransitions.bean.ConditionOnLoadProjectTransitionRecord;

public class QueryOnLoadProjectTransitionRecord extends AbstractQuery<BaseOnLoadProjectTransitionRecord, ConditionOnLoadProjectTransitionRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectTransitionRecord.class);

	public QueryOnLoadProjectTransitionRecord() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .project_transition_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectTransitionRecord> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectTransitionRecord condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getInitiateDesign(), 
				condition.getOperator(), 
				condition.getStatus(), 
				condition.getContractCode()
			);
	}

	public BaseCollection<BaseOnLoadProjectTransitionRecord> runQuery( KeyValuePair[] replacements, ConditionOnLoadProjectTransitionRecord condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getInitiateDesign(), 
				condition.getOperator(), 
				condition.getStatus(), 
				condition.getContractCode()
			);
	}

	public BaseCollection<BaseOnLoadProjectTransitionRecord> execute( KeyValuePair[] replacements, ConditionOnLoadProjectTransitionRecord condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getInitiateDesign(), 
				condition.getOperator(), 
				condition.getStatus(), 
				condition.getContractCode()
			);
	}

	@Override
	public BaseOnLoadProjectTransitionRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectTransitionRecord __base = new BaseOnLoadProjectTransitionRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectTransitionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNewProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOldNewProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNewPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOldPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInitiateDesign(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMsgCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMsgStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
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

	private final static String __SQLText = "SELECT A .project_transition_id, A.project_id, b.project_code, b.project_name, A.project_manage_id AS new_project_manage_id, b.project_manage_id AS old_new_project_manage_id, A.percent AS new_percentage, b.percentage AS old_percentage, A.initiate_design, A.status, A.OPERATOR, A.create_time, CASE WHEN C.msg_count ISNULL THEN 0 ELSE C.msg_count END AS msg_count, CASE WHEN C.msg_status ISNULL THEN 0 ELSE C.msg_status END AS msg_status , b.contract_code FROM project_transitions AS A LEFT JOIN projects AS b ON A.project_id = b.project_id LEFT JOIN ( SELECT * FROM contract_messages cm WHERE cm.create_time IN ( SELECT MAX ( b.create_time ) FROM contract_messages b WHERE b.msg_status = 1 GROUP BY b.contract_id ) ) AS C ON B.contract_id = C.contract_id WHERE A.project_id > 0 and b.project_code like ? and b.project_name like ? and A.initiate_design = ? and A.OPERATOR = ? and A.status = ? and b.contract_code like ?" ;
	private final static String __originalSQL = "SELECT A .project_transition_id, A.project_id, b.project_code, b.project_name, A.project_manage_id AS new_project_manage_id, b.project_manage_id AS old_new_project_manage_id, A.percent AS new_percentage, b.percentage AS old_percentage, A.initiate_design, A.status, A.OPERATOR, A.create_time, CASE WHEN C.msg_count ISNULL THEN 0 ELSE C.msg_count END AS msg_count, CASE WHEN C.msg_status ISNULL THEN 0 ELSE C.msg_status END AS msg_status , b.contract_code FROM project_transitions AS A LEFT JOIN projects AS b ON A.project_id = b.project_id LEFT JOIN ( SELECT * FROM contract_messages cm WHERE cm.create_time IN ( SELECT MAX ( b.create_time ) FROM contract_messages b WHERE b.msg_status = 1 GROUP BY b.contract_id ) ) AS C ON B.contract_id = C.contract_id WHERE A.project_id > 0 AND b.project_code LIKE :project_code AND b.project_name LIKE :project_name AND A.initiate_design =:initiate_design AND A.OPERATOR =:OPERATOR AND A.status =:status AND b.contract_code like :contract_code";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"A.project_id > 0 AND b.project_code LIKE :project_code AND b.project_name LIKE :project_name AND A.initiate_design =:initiate_design AND A.OPERATOR =:OPERATOR AND A.status =:status AND b.contract_code like :contract_code\",\"startIndex\": 760,\"stopIndex\":979,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"A.project_id > 0\",\"startIndex\": 760,\"stopIndex\":775,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.project_code LIKE :project_code\",\"fullFieldName\":\"b.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 781,\"stopIndex\":813,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.project_name LIKE :project_name\",\"fullFieldName\":\"b.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 819,\"stopIndex\":851,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.initiate_design =:initiate_design\",\"fullFieldName\":\"A.initiate_design\",\"operationName\":\"=\",\"variableName\":\"initiateDesign\",\"startIndex\": 857,\"stopIndex\":891,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.OPERATOR =:OPERATOR\",\"fullFieldName\":\"A.OPERATOR\",\"operationName\":\"=\",\"variableName\":\"operator\",\"startIndex\": 897,\"stopIndex\":917,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"A.status =:status\",\"fullFieldName\":\"A.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 923,\"stopIndex\":939,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.contract_code like :contract_code\",\"fullFieldName\":\"b.contract_code\",\"operationName\":\"like\",\"variableName\":\"contractCode\",\"startIndex\": 945,\"stopIndex\":979,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_transition_id,project_id,project_code,project_name,new_project_manage_id,old_new_project_manage_id,new_percentage,old_percentage,initiate_design,status,operator,create_time,msg_count,msg_status,contract_code";
	private final static String[] fieldNames = { "project_code", "project_name", "initiate_design", "operator", "status", "contract_code"};
}
