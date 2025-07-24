package pomplatform.ProjectStages.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ProjectStages.bean.BaseOnLoadAttentionListOfProjectStages;
import pomplatform.ProjectStages.bean.ConditionOnLoadAttentionListOfProjectStages;

public class QueryOnLoadAttentionListOfProjectStages extends AbstractQuery<BaseOnLoadAttentionListOfProjectStages, ConditionOnLoadAttentionListOfProjectStages>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttentionListOfProjectStages.class);

	public QueryOnLoadAttentionListOfProjectStages() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAttentionListOfProjectStages> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfProjectStages condition ) throws java.sql.SQLException {
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

	public BaseCollection<BaseOnLoadAttentionListOfProjectStages> runQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfProjectStages condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadAttentionListOfProjectStages> execute( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfProjectStages condition ) throws java.sql.SQLException {
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
	public BaseOnLoadAttentionListOfProjectStages generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttentionListOfProjectStages __base = new BaseOnLoadAttentionListOfProjectStages();
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
		if((val = __data[count++]) != null) __base.setProjectStageProcessRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectAmountSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApplyAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, spa.process_type, pspr.project_stage_process_record_id, pspr.contract_id, pspr.main_project_id, pspr.project_name, pspr.project_code, pspr.project_amount_sum, pspr.apply_amount, pspr.file_id, pspr.file_url, pspr.remark FROM system_process_attentions spa LEFT JOIN project_stage_process_records pspr ON spa.business_id = pspr.project_stage_process_record_id LEFT JOIN employees b ON spa.employee_id = b.employee_id WHERE spa.status = ? and spa.process_type = 76 and spa.employee_id = ? and b.employee_name like ? and b.employee_no like ? and pspr.project_name like ? and pspr.project_code like ? ORDER BY spa.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, spa.process_type, pspr.project_stage_process_record_id, pspr.contract_id, pspr.main_project_id, pspr.project_name, pspr.project_code, pspr.project_amount_sum, pspr.apply_amount, pspr.file_id, pspr.file_url, pspr.remark FROM system_process_attentions spa LEFT JOIN project_stage_process_records pspr ON spa.business_id = pspr.project_stage_process_record_id LEFT JOIN employees b ON spa.employee_id = b.employee_id WHERE spa.status =:status AND spa.process_type = 76 AND spa.employee_id =:employee_id AND b.employee_name LIKE :employee_name AND b.employee_no LIKE :employee_no AND pspr.project_name like :project_name AND pspr.project_code like :project_code ORDER BY spa.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spa.status =:status AND spa.process_type = 76 AND spa.employee_id =:employee_id AND b.employee_name LIKE :employee_name AND b.employee_no LIKE :employee_no AND pspr.project_name like :project_name AND pspr.project_code like :project_code\",\"startIndex\": 728,\"stopIndex\":964,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spa.status =:status\",\"fullFieldName\":\"spa.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"startIndex\": 728,\"stopIndex\":746,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.process_type = 76\",\"startIndex\": 752,\"stopIndex\":772,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.employee_id =:employee_id\",\"fullFieldName\":\"spa.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 778,\"stopIndex\":806,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_name LIKE :employee_name\",\"fullFieldName\":\"b.employee_name\",\"operationName\":\"like\",\"variableName\":\"employeeName\",\"startIndex\": 812,\"stopIndex\":846,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"b.employee_no LIKE :employee_no\",\"fullFieldName\":\"b.employee_no\",\"operationName\":\"like\",\"variableName\":\"employeeNo\",\"startIndex\": 852,\"stopIndex\":882,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pspr.project_name like :project_name\",\"fullFieldName\":\"pspr.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 888,\"stopIndex\":923,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pspr.project_code like :project_code\",\"fullFieldName\":\"pspr.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 929,\"stopIndex\":964,\"variableNum\": 5,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,operate_time,process_comment,process_type,project_stage_process_record_id,contract_id,main_project_id,project_name,project_code,project_amount_sum,apply_amount,file_id,file_url,remark";
	private final static String[] fieldNames = { "status", "employee_id", "employee_name", "employee_no", "project_name", "project_code"};
}
