package pomplatform.ProjectStages.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ProjectStages.bean.BaseOnLoadProjectStageInProcess;
import pomplatform.ProjectStages.bean.ConditionOnLoadProjectStageInProcess;

public class QueryOnLoadProjectStageInProcess extends AbstractQuery<BaseOnLoadProjectStageInProcess, ConditionOnLoadProjectStageInProcess>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectStageInProcess.class);

	public QueryOnLoadProjectStageInProcess() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pspr.project_stage_process_record_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectStageInProcess> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectStageInProcess condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseOnLoadProjectStageInProcess> runQuery( KeyValuePair[] replacements, ConditionOnLoadProjectStageInProcess condition ) throws java.sql.SQLException {
		return runQuery(replacements, 
				condition.getProcessType(), 
				condition.getContractId()
			);
	}

	public BaseCollection<BaseOnLoadProjectStageInProcess> execute( KeyValuePair[] replacements, ConditionOnLoadProjectStageInProcess condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements, 
				condition.getProcessType(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseOnLoadProjectStageInProcess generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectStageInProcess __base = new BaseOnLoadProjectStageInProcess();
		int count = 0;
		Object val;
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

	private final static String __SQLText = "SELECT pspr.project_stage_process_record_id, pspr.contract_id, pspr.main_project_id, pspr.project_name, pspr.project_code, pspr.project_amount_sum, pspr.apply_amount, pspr.file_id, pspr.file_url, pspr.remark FROM system_process_instances spi LEFT JOIN project_stage_process_records pspr ON spi.business_id = pspr.project_stage_process_record_id WHERE spi.process_type = ? and pspr.contract_id = ? and spi.process_status = 0" ;
	private final static String __originalSQL = "SELECT pspr.project_stage_process_record_id, pspr.contract_id, pspr.main_project_id, pspr.project_name, pspr.project_code, pspr.project_amount_sum, pspr.apply_amount, pspr.file_id, pspr.file_url, pspr.remark FROM system_process_instances spi LEFT JOIN project_stage_process_records pspr ON spi.business_id = pspr.project_stage_process_record_id WHERE spi.process_type =:process_type AND pspr.contract_id =:contract_id AND spi.process_status = 1";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spi.process_type =:process_type AND pspr.contract_id =:contract_id AND spi.process_status = 0\",\"startIndex\": 351,\"stopIndex\":443,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spi.process_type =:process_type\",\"fullFieldName\":\"spi.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"startIndex\": 351,\"stopIndex\":381,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"pspr.contract_id =:contract_id\",\"fullFieldName\":\"pspr.contract_id\",\"operationName\":\"=\",\"variableName\":\"contractId\",\"startIndex\": 387,\"stopIndex\":416,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spi.process_status = 0\",\"startIndex\": 422,\"stopIndex\":443,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "project_stage_process_record_id,contract_id,main_project_id,project_name,project_code,project_amount_sum,apply_amount,file_id,file_url,remark";
	private final static String[] fieldNames = { "process_type", "contract_id"};
}
