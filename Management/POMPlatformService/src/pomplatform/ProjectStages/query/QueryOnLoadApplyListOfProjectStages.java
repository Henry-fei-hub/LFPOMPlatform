package pomplatform.ProjectStages.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ProjectStages.bean.BaseOnLoadApplyListOfProjectStages;
import pomplatform.ProjectStages.bean.ConditionOnLoadApplyListOfProjectStages;

public class QueryOnLoadApplyListOfProjectStages extends AbstractQuery<BaseOnLoadApplyListOfProjectStages, ConditionOnLoadApplyListOfProjectStages>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfProjectStages.class);

	public QueryOnLoadApplyListOfProjectStages() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfProjectStages> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProjectStages condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadApplyListOfProjectStages> runQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProjectStages condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	public BaseCollection<BaseOnLoadApplyListOfProjectStages> execute( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProjectStages condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getEmployeeId(), 
				condition.getProjectName(), 
				condition.getProjectCode()
			);
	}

	@Override
	public BaseOnLoadApplyListOfProjectStages generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfProjectStages __base = new BaseOnLoadApplyListOfProjectStages();
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.process_type, pspr.project_stage_process_record_id, pspr.contract_id, pspr.main_project_id, pspr.project_name, pspr.project_code, pspr.project_amount_sum, pspr.apply_amount, pspr.file_id, pspr.file_url, pspr.remark FROM system_process_instances spi LEFT JOIN project_stage_process_records pspr ON spi.business_id = pspr.project_stage_process_record_id WHERE spi.process_type = 76 and spi.process_status IN ( 0, 1 ) and spi.employee_id = ? and pspr.project_name like ? and pspr.project_code like ? ORDER BY spi.create_time DESC" ;
	private final static String __originalSQL = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.process_type, pspr.project_stage_process_record_id, pspr.contract_id, pspr.main_project_id, pspr.project_name, pspr.project_code, pspr.project_amount_sum, pspr.apply_amount, pspr.file_id, pspr.file_url, pspr.remark FROM system_process_instances spi LEFT JOIN project_stage_process_records pspr ON spi.business_id = pspr.project_stage_process_record_id WHERE spi.process_type = 76 AND spi.process_status IN ( 0, 1 ) AND spi.employee_id =:employee_id AND pspr.project_name like :project_name AND pspr.project_code like :project_code ORDER BY spi.create_time DESC";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spi.process_type = 76 AND spi.process_status IN ( 0, 1 ) AND spi.employee_id =:employee_id AND pspr.project_name like :project_name AND pspr.project_code like :project_code\",\"startIndex\": 536,\"stopIndex\":707,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type = 76\",\"startIndex\": 536,\"stopIndex\":556,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status IN ( 0, 1 )\",\"startIndex\": 562,\"stopIndex\":591,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.employee_id =:employee_id\",\"fullFieldName\":\"spi.employee_id\",\"operationName\":\"=\",\"variableName\":\"employeeId\",\"startIndex\": 597,\"stopIndex\":625,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pspr.project_name like :project_name\",\"fullFieldName\":\"pspr.project_name\",\"operationName\":\"like\",\"variableName\":\"projectName\",\"startIndex\": 631,\"stopIndex\":666,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pspr.project_code like :project_code\",\"fullFieldName\":\"pspr.project_code\",\"operationName\":\"like\",\"variableName\":\"projectCode\",\"startIndex\": 672,\"stopIndex\":707,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,process_type,project_stage_process_record_id,contract_id,main_project_id,project_name,project_code,project_amount_sum,apply_amount,file_id,file_url,remark";
	private final static String[] fieldNames = { "employee_id", "project_name", "project_code"};
}
