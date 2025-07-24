package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseBillingInfo;
import pomplatform.report.bean.ConditionBillingInfo;

public class QueryBillingInfo extends AbstractQuery<BaseBillingInfo, ConditionBillingInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryBillingInfo.class);

	public QueryBillingInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pb.project_code");
	}

	@Override
	public BaseCollection<BaseBillingInfo> executeQuery( KeyValuePair[] replacements, ConditionBillingInfo condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	public BaseCollection<BaseBillingInfo> runQuery( KeyValuePair[] replacements, ConditionBillingInfo condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProjectId()
			);
	}

	public BaseCollection<BaseBillingInfo> execute( KeyValuePair[] replacements, ConditionBillingInfo condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseBillingInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBillingInfo __base = new BaseBillingInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

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

	private final static String __SQLText = "SELECT pb.project_code, pb.project_name, pb.drafter, pb.department_id, pb.sub_type, pb.create_time FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.business_id = pb.personnel_business_id AND spi.process_type = pb.process_type WHERE pb.process_type = 82 and spi.process_status = 3 and pb.delete_flag = 0 and pb.project_id = ?" ;
	private final static String __originalSQL = "SELECT pb.project_code, pb.project_name, pb.drafter, pb.department_id, pb.sub_type, pb.create_time FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.business_id = pb.personnel_business_id AND spi.process_type = pb.process_type WHERE pb.process_type = 82 AND spi.process_status = 3 AND pb.delete_flag = 0 AND pb.project_id =:project_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"pb.process_type = 82 AND spi.process_status = 3 AND pb.delete_flag = 0 AND pb.project_id =:project_id\",\"startIndex\": 256,\"stopIndex\":356,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"pb.process_type = 82\",\"nextToken\":\"and\",\"startIndex\": 256,\"stopIndex\":275,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status = 3\",\"nextToken\":\"and\",\"startIndex\": 281,\"stopIndex\":302,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 308,\"stopIndex\":325,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.project_id =:project_id\",\"fullFieldName\":\"pb.project_id\",\"operationName\":\"=\",\"variableName\":\"projectId\",\"startIndex\": 331,\"stopIndex\":356,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_code,project_name,drafter,department_id,sub_type,create_time";
	private final static String[] fieldNames = { "project_id"};
}
