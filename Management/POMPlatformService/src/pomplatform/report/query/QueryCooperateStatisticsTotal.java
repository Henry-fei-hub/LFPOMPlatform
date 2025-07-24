package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseCooperateStatisticsTotal;
import pomplatform.report.bean.ConditionCooperateStatisticsTotal;

public class QueryCooperateStatisticsTotal extends AbstractQuery<BaseCooperateStatisticsTotal, ConditionCooperateStatisticsTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryCooperateStatisticsTotal.class);

	public QueryCooperateStatisticsTotal() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pb.project_id");
	}

	@Override
	public BaseCollection<BaseCooperateStatisticsTotal> executeQuery( KeyValuePair[] replacements, ConditionCooperateStatisticsTotal condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getDepartmentId(), 
				condition.getType()
			);
	}

	public BaseCollection<BaseCooperateStatisticsTotal> runQuery( KeyValuePair[] replacements, ConditionCooperateStatisticsTotal condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getDepartmentId(), 
				condition.getType()
			);
	}

	public BaseCollection<BaseCooperateStatisticsTotal> execute( KeyValuePair[] replacements, ConditionCooperateStatisticsTotal condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getDepartmentId(), 
				condition.getType()
			);
	}

	@Override
	public BaseCooperateStatisticsTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCooperateStatisticsTotal __base = new BaseCooperateStatisticsTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSettlementIntegral(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "SELECT pb.project_id, pb.project_code, pb.project_name, pb.drafter, pb.department_id, pb.type, pb.project_type, pb.sub_type, ( SELECT SUM ( CAST ( P.sub_type AS INTEGER )) FROM personnel_business P LEFT JOIN system_process_instances spi ON spi.business_id = P.personnel_business_id AND spi.process_type = P.process_type WHERE P.process_type = 82 AND spi.process_status = 3 AND P.delete_flag = 0 AND P.Project_id = pb.project_id ) AS settlement_integral, pb.start_date FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.business_id = pb.personnel_business_id AND spi.process_type = pb.process_type WHERE pb.process_type = 81 and spi.process_status = 3 and pb.delete_flag = 0 and pb.project_code like ? and pb.project_name like ? and pb.department_id = ? and pb.type = ? order by start_date" ;
	private final static String __originalSQL = "SELECT pb.project_id, pb.project_code, pb.project_name, pb.drafter, pb.department_id, pb.type, pb.project_type, pb.sub_type, ( SELECT SUM ( CAST ( P.sub_type AS INTEGER )) FROM personnel_business P LEFT JOIN system_process_instances spi ON spi.business_id = P.personnel_business_id AND spi.process_type = P.process_type WHERE P.process_type = 82 AND spi.process_status = 3 AND P.delete_flag = 0 AND P.Project_id = pb.project_id ) AS settlement_integral, pb.start_date FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.business_id = pb.personnel_business_id AND spi.process_type = pb.process_type WHERE pb.process_type = 81 AND spi.process_status = 3 AND pb.delete_flag = 0 AND pb.project_code like :project_code AND pb.project_name like :project_name AND pb.department_id =:department_id AND pb.type =:type order by start_date";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"pb.process_type = 81 AND spi.process_status = 3 AND pb.delete_flag = 0 AND pb.project_code like :project_code AND pb.project_name like :project_name AND pb.department_id =:department_id AND pb.type =:type\",\"startIndex\": 625,\"stopIndex\":828,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"pb.process_type = 81\",\"nextToken\":\"and\",\"startIndex\": 625,\"stopIndex\":644,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status = 3\",\"nextToken\":\"and\",\"startIndex\": 650,\"stopIndex\":671,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 677,\"stopIndex\":694,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.project_code like :project_code\",\"fullFieldName\":\"pb.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"nextToken\":\"and\",\"startIndex\": 700,\"stopIndex\":733,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.project_name like :project_name\",\"fullFieldName\":\"pb.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"nextToken\":\"and\",\"startIndex\": 739,\"stopIndex\":772,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.department_id =:department_id\",\"fullFieldName\":\"pb.department_id\",\"operationName\":\"=\",\"variableName\":\"departmentId\",\"nextToken\":\"and\",\"startIndex\": 778,\"stopIndex\":809,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pb.type =:type\",\"fullFieldName\":\"pb.type\",\"operationName\":\"=\",\"variableName\":\"type\",\"startIndex\": 815,\"stopIndex\":828,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_id,project_code,project_name,drafter,department_id,type,project_type,sub_type,settlement_integral,start_date";
	private final static String[] fieldNames = { "project_code", "project_name", "department_id", "type"};
}
