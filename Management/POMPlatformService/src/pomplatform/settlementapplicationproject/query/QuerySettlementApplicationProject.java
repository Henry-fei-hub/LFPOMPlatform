package pomplatform.settlementapplicationproject.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.settlementapplicationproject.bean.BaseSettlementApplicationProject;
import pomplatform.settlementapplicationproject.bean.ConditionSettlementApplicationProject;

public class QuerySettlementApplicationProject extends AbstractQuery<BaseSettlementApplicationProject, ConditionSettlementApplicationProject>
{

	private static final Logger __logger = Logger.getLogger(QuerySettlementApplicationProject.class);

	public QuerySettlementApplicationProject() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pb.project_id");
	}

	@Override
	public BaseCollection<BaseSettlementApplicationProject> executeQuery( KeyValuePair[] replacements, ConditionSettlementApplicationProject condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getType()
			);
	}

	public BaseCollection<BaseSettlementApplicationProject> runQuery( KeyValuePair[] replacements, ConditionSettlementApplicationProject condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getType()
			);
	}

	public BaseCollection<BaseSettlementApplicationProject> execute( KeyValuePair[] replacements, ConditionSettlementApplicationProject condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getType()
			);
	}

	@Override
	public BaseSettlementApplicationProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSettlementApplicationProject __base = new BaseSettlementApplicationProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSettlementIntegral(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT pb.project_id, pb.project_code, pb.project_name, pb.type, pb.sub_type, ( SELECT SUM ( CAST ( P.sub_type AS INTEGER )) FROM personnel_business P LEFT JOIN system_process_instances spi ON spi.business_id = P.personnel_business_id AND spi.process_type = P.process_type WHERE P.process_type = 82 AND spi.process_status = 3 AND P.delete_flag = 0 AND P.project_id = pb.project_id ) AS settlement_integral FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.business_id = pb.personnel_business_id AND spi.process_type = pb.process_type WHERE pb.process_type = 81 and spi.process_status = 3 and pb.delete_flag = 0 and pb.type = ?" ;
	private final static String __originalSQL = "SELECT pb.project_id, pb.project_code, pb.project_name, pb.type, pb.sub_type, ( SELECT SUM ( CAST ( P.sub_type AS INTEGER )) FROM personnel_business P LEFT JOIN system_process_instances spi ON spi.business_id = P.personnel_business_id AND spi.process_type = P.process_type WHERE P.process_type = 82 AND spi.process_status = 3 AND P.delete_flag = 0 AND P.project_id = pb.project_id ) AS settlement_integral FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.business_id = pb.personnel_business_id AND spi.process_type = pb.process_type WHERE pb.process_type = 81 AND spi.process_status = 3 AND pb.delete_flag = 0 AND pb.type = :type";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"pb.process_type = 81 AND spi.process_status = 3 AND pb.delete_flag = 0 AND pb.type = :type\",\"startIndex\": 563,\"stopIndex\":652,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"pb.process_type = 81\",\"nextToken\":\"and\",\"startIndex\": 563,\"stopIndex\":582,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status = 3\",\"nextToken\":\"and\",\"startIndex\": 588,\"stopIndex\":609,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 615,\"stopIndex\":632,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.type = :type\",\"fullFieldName\":\"pb.type\",\"operationName\":\"=\",\"variableName\":\"type\",\"startIndex\": 638,\"stopIndex\":652,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_id,project_code,project_name,type,sub_type,settlement_integral";
	private final static String[] fieldNames = { "type"};
}
