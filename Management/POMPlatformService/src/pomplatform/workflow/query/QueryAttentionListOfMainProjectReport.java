package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseAttentionListOfMainProjectReport;
import pomplatform.workflow.bean.ConditionAttentionListOfMainProjectReport;

public class QueryAttentionListOfMainProjectReport extends AbstractQuery<BaseAttentionListOfMainProjectReport, ConditionAttentionListOfMainProjectReport>
{

	private static final Logger __logger = Logger.getLogger(QueryAttentionListOfMainProjectReport.class);

	public QueryAttentionListOfMainProjectReport() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseAttentionListOfMainProjectReport> executeQuery( KeyValuePair[] replacements, ConditionAttentionListOfMainProjectReport condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectType()
			);
	}

	public BaseCollection<BaseAttentionListOfMainProjectReport> runQuery( KeyValuePair[] replacements, ConditionAttentionListOfMainProjectReport condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectType()
			);
	}

	public BaseCollection<BaseAttentionListOfMainProjectReport> execute( KeyValuePair[] replacements, ConditionAttentionListOfMainProjectReport condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectType()
			);
	}

	@Override
	public BaseAttentionListOfMainProjectReport generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttentionListOfMainProjectReport __base = new BaseAttentionListOfMainProjectReport();
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
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsWarehous(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsApplyQuote(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectNameOne(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsModifyProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setMainProjectStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.process_type, spa.operate_time, spa.process_comment, P.project_name, P.province, P.city, P.project_type, P.customer_name, P.project_origination, P.contact_name, P.contact_phone, P.detail_address, P.total_building_areas, spi.employee_id as apply_employee_id, C.customer_type, C.is_warehous, C.is_apply_quote, P.info_code, CASE WHEN mp.project_name = mp.project_name_one THEN '' ELSE mp.project_name_one END project_name_one, P.main_project_id, P.is_modify_project, P.main_project_stage_id, P.project_code FROM system_process_attentions spa left join system_process_instances as spi on spi.process_instance_id = spa.process_instance_id LEFT JOIN main_projects P ON spa.business_id = P.main_project_id LEFT JOIN pre_projects mp ON P.info_code = mp.info_code LEFT JOIN customers C ON mp.client_id = C.customer_id WHERE spa.status = ? and spa.process_type = ? and spa.employee_id = ? and spa.delete_flag = 0 and P.project_name like ? and P.project_type = ? ORDER BY spa.instance_activity_create_time DESC" ;
	private final static String __originalSQL = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.process_type, spa.operate_time, spa.process_comment, P.project_name, P.province, P.city, P.project_type, P.customer_name, P.project_origination, P.contact_name, P.contact_phone, P.detail_address, P.total_building_areas, spi.employee_id as apply_employee_id, C.customer_type, C.is_warehous, C.is_apply_quote, P.info_code, CASE WHEN mp.project_name = mp.project_name_one THEN '' ELSE mp.project_name_one END project_name_one, P.main_project_id, P.is_modify_project, P.main_project_stage_id, P.project_code FROM system_process_attentions spa left join system_process_instances as spi on spi.process_instance_id = spa.process_instance_id LEFT JOIN main_projects P ON spa.business_id = P.main_project_id LEFT JOIN pre_projects mp ON P.info_code = mp.info_code LEFT JOIN customers C ON mp.client_id = C.customer_id WHERE spa.status =:status AND spa.process_type =:process_type AND spa.employee_id =:employee_id AND spa.delete_flag = 0 AND P.project_name LIKE :project_name AND P.project_type =:project_type ORDER BY spa.instance_activity_create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spa.status =:status AND spa.process_type =:process_type AND spa.employee_id =:employee_id AND spa.delete_flag = 0 AND P.project_name LIKE :project_name AND P.project_type =:project_type\",\"startIndex\": 1088,\"stopIndex\":1272,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spa.status =:status\",\"fullFieldName\":\"spa.status\",\"operationName\":\"=\",\"variableName\":\"status\",\"nextToken\":\"and\",\"startIndex\": 1088,\"stopIndex\":1106,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.process_type =:process_type\",\"fullFieldName\":\"spa.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 1112,\"stopIndex\":1142,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.employee_id =:employee_id\",\"fullFieldName\":\"spa.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"nextToken\":\"and\",\"startIndex\": 1148,\"stopIndex\":1176,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spa.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 1182,\"stopIndex\":1200,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_name LIKE :project_name\",\"fullFieldName\":\"P.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"nextToken\":\"and\",\"startIndex\": 1206,\"stopIndex\":1238,\"variableNum\": 3,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"P.project_type =:project_type\",\"fullFieldName\":\"P.project_type\",\"operationName\":\"=\",\"variableName\":\"projectType\",\"startIndex\": 1244,\"stopIndex\":1272,\"variableNum\": 4,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,operate_time,process_comment,project_name,province,city,project_type,customer_name,project_origination,contact_name,contact_phone,detail_address,total_building_areas,apply_employee_id,customer_type,is_warehous,is_apply_quote,info_code,project_name_one,main_project_id,is_modify_project,main_project_stage_id,project_code";
	private final static String[] fieldNames = { "status", "process_type", "employee_id", "project_name", "project_type"};
}
