package pomplatform.projectSettlement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectSettlement.bean.BaseOnLoadApplyListOfProjectSettlement;
import pomplatform.projectSettlement.bean.ConditionOnLoadApplyListOfProjectSettlement;

public class QueryOnLoadApplyListOfProjectSettlement extends AbstractQuery<BaseOnLoadApplyListOfProjectSettlement, ConditionOnLoadApplyListOfProjectSettlement>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfProjectSettlement.class);

	public QueryOnLoadApplyListOfProjectSettlement() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfProjectSettlement> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProjectSettlement condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadApplyListOfProjectSettlement> runQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProjectSettlement condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadApplyListOfProjectSettlement> execute( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProjectSettlement condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	@Override
	public BaseOnLoadApplyListOfProjectSettlement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfProjectSettlement __base = new BaseOnLoadApplyListOfProjectSettlement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.process_type, ps.settlement_id, ps.project_id, ps.employee_id as project_manage_id, ps.remark, ps.settlement_date, ps.total_amount, ps.total_cost, ps.project_amount, ps.left_amount, ps.status, ps.stage_id, ps.settlement_status, ps.FLAG, P.project_code, P.project_name FROM system_process_instances spi left join project_settlements ps on spi.business_id = ps.settlement_id LEFT JOIN projects P ON P.project_id = ps.project_id WHERE spi.process_type = 80 and spi.process_status IN ( 0, 1 ) and spi.employee_id = ? and P.project_name like ? and P.project_code like ? ORDER BY spi.create_time DESC" ;
	private final static String __originalSQL = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.process_type, ps.settlement_id, ps.project_id, ps.employee_id as project_manage_id, ps.remark, ps.settlement_date, ps.total_amount, ps.total_cost, ps.project_amount, ps.left_amount, ps.status, ps.stage_id, ps.settlement_status, ps.FLAG, P.project_code, P.project_name FROM system_process_instances spi left join project_settlements ps on spi.business_id = ps.settlement_id LEFT JOIN projects P ON P.project_id = ps.project_id WHERE spi.process_type = 80 AND spi.process_status IN ( 0, 1 ) AND spi.employee_id =:employee_id AND P.project_name LIKE :project_name AND P.project_code LIKE :project_code ORDER BY spi.create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spi.process_type = 80 AND spi.process_status IN ( 0, 1 ) AND spi.employee_id =:employee_id AND P.project_name LIKE :project_name AND P.project_code LIKE :project_code\",\"startIndex\": 610,\"stopIndex\":775,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type = 80\",\"startIndex\": 610,\"stopIndex\":630,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status IN ( 0, 1 )\",\"startIndex\": 636,\"stopIndex\":665,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.employee_id =:employee_id\",\"fullFieldName\":\"spi.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 671,\"stopIndex\":699,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_name LIKE :project_name\",\"fullFieldName\":\"P.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 705,\"stopIndex\":737,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_code LIKE :project_code\",\"fullFieldName\":\"P.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 743,\"stopIndex\":775,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,process_type,settlement_id,project_id,project_manage_id,remark,settlement_date,total_amount,total_cost,project_amount,left_amount,status,stage_id,settlement_status,flag,project_code,project_name";
	private final static String[] fieldNames = { "employee_id", "project_name", "project_code"};
}
