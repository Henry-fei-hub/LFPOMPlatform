package pomplatform.projectSettlement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectSettlement.bean.BaseOnLoadAttentionListOfProjectSettlement;
import pomplatform.projectSettlement.bean.ConditionOnLoadAttentionListOfProjectSettlement;

public class QueryOnLoadAttentionListOfProjectSettlement extends AbstractQuery<BaseOnLoadAttentionListOfProjectSettlement, ConditionOnLoadAttentionListOfProjectSettlement>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttentionListOfProjectSettlement.class);

	public QueryOnLoadAttentionListOfProjectSettlement() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAttentionListOfProjectSettlement> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfProjectSettlement condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadAttentionListOfProjectSettlement> runQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfProjectSettlement condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadAttentionListOfProjectSettlement> execute( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfProjectSettlement condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	@Override
	public BaseOnLoadAttentionListOfProjectSettlement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttentionListOfProjectSettlement __base = new BaseOnLoadAttentionListOfProjectSettlement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSystemProcessAttentionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, spa.process_type, ps.settlement_id, ps.project_id, ps.employee_id as project_manage_id, ps.remark, ps.settlement_date, ps.total_amount, ps.total_cost, ps.project_amount, ps.left_amount, ps.stage_id, ps.settlement_status, ps.FLAG, P.project_code, P.project_name FROM system_process_attentions spa left join project_settlements ps on spa.business_id = ps.settlement_id LEFT JOIN projects P ON P.project_id = ps.project_id LEFT JOIN employees b ON b.employee_id = spa.employee_id WHERE spa.status = ? and spa.process_type = 80 and spa.employee_id = ? and b.employee_name like ? and b.employee_no like ? and P.project_name like ? and P.project_code like ? ORDER BY spa.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, spa.process_type, ps.settlement_id, ps.project_id, ps.employee_id as project_manage_id, ps.remark, ps.settlement_date, ps.total_amount, ps.total_cost, ps.project_amount, ps.left_amount, ps.stage_id, ps.settlement_status, ps.FLAG, P.project_code, P.project_name FROM system_process_attentions spa left join project_settlements ps on spa.business_id = ps.settlement_id LEFT JOIN projects P ON P.project_id = ps.project_id LEFT JOIN employees b ON b.employee_id = spa.employee_id WHERE spa.status =:status AND spa.process_type = 80 AND spa.employee_id =:employee_id AND b.employee_name LIKE :employee_name AND b.employee_no LIKE :employee_no AND P.project_name LIKE :project_name AND P.project_code LIKE :project_code ORDER BY spa.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spa.status =:status AND spa.process_type = 80 AND spa.employee_id =:employee_id AND b.employee_name LIKE :employee_name AND b.employee_no LIKE :employee_no AND P.project_name LIKE :project_name AND P.project_code LIKE :project_code\",\"startIndex\": 791,\"stopIndex\":1021,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spa.status =:status\",\"fullFieldName\":\"spa.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 791,\"stopIndex\":809,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.process_type = 80\",\"startIndex\": 815,\"stopIndex\":835,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.employee_id =:employee_id\",\"fullFieldName\":\"spa.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 841,\"stopIndex\":869,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_name LIKE :employee_name\",\"fullFieldName\":\"b.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"startIndex\": 875,\"stopIndex\":909,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_no LIKE :employee_no\",\"fullFieldName\":\"b.employee_no\",\"operationName\":\"like\",\"variableName\":\"employeeNo\",\"startIndex\": 915,\"stopIndex\":945,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_name LIKE :project_name\",\"fullFieldName\":\"P.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 951,\"stopIndex\":983,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_code LIKE :project_code\",\"fullFieldName\":\"P.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 989,\"stopIndex\":1021,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,operate_time,process_comment,process_type,settlement_id,project_id,project_manage_id,remark,settlement_date,total_amount,total_cost,project_amount,left_amount,stage_id,settlement_status,flag,project_code,project_name";
	private final static String[] fieldNames = { "status", "employee_id", "employee_name", "employee_no", "project_name", "project_code"};
}
