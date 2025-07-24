package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseSystemProcessInstanceActivities;
import pomplatform.report.bean.ConditionSystemProcessInstanceActivities;

public class QuerySystemProcessInstanceActivities extends AbstractQuery<BaseSystemProcessInstanceActivities, ConditionSystemProcessInstanceActivities>
{

	private static final Logger __logger = Logger.getLogger(QuerySystemProcessInstanceActivities.class);

	public QuerySystemProcessInstanceActivities() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT spia.process_instance_activity_id");
	}

	@Override
	public BaseCollection<BaseSystemProcessInstanceActivities> executeQuery( KeyValuePair[] replacements, ConditionSystemProcessInstanceActivities condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getProcessInstanceId()
			);
	}

	public BaseCollection<BaseSystemProcessInstanceActivities> runQuery( KeyValuePair[] replacements, ConditionSystemProcessInstanceActivities condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getProcessInstanceId()
			);
	}

	public BaseCollection<BaseSystemProcessInstanceActivities> execute( KeyValuePair[] replacements, ConditionSystemProcessInstanceActivities condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getProcessInstanceId()
			);
	}

	@Override
	public BaseSystemProcessInstanceActivities generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSystemProcessInstanceActivities __base = new BaseSystemProcessInstanceActivities();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTimeOutAction(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIdType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyWeixin(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT DISTINCT spia.process_instance_activity_id, spia.employee_id, spia.process_instance_activity_id AS ID, spia.process_type, spia.business_name, spt.process_type_name, spa.time_out_action, spia.instance_activity_start_time, 1 AS id_type, spia.back_view_name, e.company_weixin, e.company_email, spia.business_id, spia.process_instance_id, spia.activity_type FROM system_process_instance_activities spia LEFT JOIN system_process_types spt ON spt.process_type_id = spia.process_type LEFT JOIN system_process_activities spa ON spa.process_activity_id = spia.process_activity_id LEFT JOIN employees e ON e.employee_id = spia.employee_id WHERE spia.status = 1 and spia.activity_type NOT IN ( 0, 1 ) and spia.employee_id > 0 and spia.delete_flag = 0 and spia.message_status = 0 and spia.process_instance_id IN ( SELECT sp.process_instance_id FROM system_process_instances sp WHERE sp.delete_flag = 0 AND sp.process_status IN ( 0, 1 ) ) and spia.process_type = ? and spia.business_id = ? and spia.process_instance_id = ?" ;
	private final static String __originalSQL = "SELECT DISTINCT spia.process_instance_activity_id, spia.employee_id, spia.process_instance_activity_id AS ID, spia.process_type, spia.business_name, spt.process_type_name, spa.time_out_action, spia.instance_activity_start_time, 1 AS id_type, spia.back_view_name, e.company_weixin, e.company_email, spia.business_id, spia.process_instance_id, spia.activity_type FROM system_process_instance_activities spia LEFT JOIN system_process_types spt ON spt.process_type_id = spia.process_type LEFT JOIN system_process_activities spa ON spa.process_activity_id = spia.process_activity_id LEFT JOIN employees e ON e.employee_id = spia.employee_id WHERE spia.status = 1 AND spia.activity_type NOT IN ( 0, 1 ) AND spia.employee_id > 0 AND spia.delete_flag = 0 AND spia.message_status = 0 AND spia.process_instance_id IN ( SELECT sp.process_instance_id FROM system_process_instances sp WHERE sp.delete_flag = 0 AND sp.process_status IN ( 0, 1 ) ) AND spia.process_type = :process_type AND spia.business_id = :business_id AND spia.process_instance_id = :process_instance_id";
	private final static String[] __queryConditions = {
		"[{\"fullCondition\": \"spia.status = 1 AND spia.activity_type NOT IN ( 0, 1 ) AND spia.employee_id > 0 AND spia.delete_flag = 0 AND spia.message_status = 0 AND spia.process_instance_id IN ( SELECT sp.process_instance_id FROM system_process_instances sp WHERE sp.delete_flag = 0 AND sp.process_status IN ( 0, 1 ) ) AND spia.process_type = :process_type AND spia.business_id = :business_id AND spia.process_instance_id = :process_instance_id\",\"startIndex\": 642,\"stopIndex\":1057,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":true,\"children\": [{\"fullCondition\": \"spia.status = 1\",\"nextToken\":\"and\",\"startIndex\": 642,\"stopIndex\":656,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.activity_type NOT IN ( 0, 1 )\",\"nextToken\":\"and\",\"startIndex\": 662,\"stopIndex\":695,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.employee_id > 0\",\"nextToken\":\"and\",\"startIndex\": 701,\"stopIndex\":720,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.delete_flag = 0\",\"nextToken\":\"and\",\"startIndex\": 726,\"stopIndex\":745,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.message_status = 0\",\"nextToken\":\"and\",\"startIndex\": 751,\"stopIndex\":773,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.process_instance_id IN ( SELECT sp.process_instance_id FROM system_process_instances sp WHERE sp.delete_flag = 0 AND sp.process_status IN ( 0, 1 ) )\",\"nextToken\":\"and\",\"startIndex\": 779,\"stopIndex\":931,\"variableNum\": 0,\"variableCount\": 0,\"isor\":false,\"hasVariable\":false,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.process_type = :process_type\",\"fullFieldName\":\"spia.process_type\",\"operationName\":\"=\",\"variableName\":\"processType\",\"nextToken\":\"and\",\"startIndex\": 937,\"stopIndex\":969,\"variableNum\": 0,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.business_id = :business_id\",\"fullFieldName\":\"spia.business_id\",\"operationName\":\"=\",\"variableName\":\"businessId\",\"nextToken\":\"and\",\"startIndex\": 975,\"stopIndex\":1005,\"variableNum\": 1,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []},{\"fullCondition\": \"spia.process_instance_id = :process_instance_id\",\"fullFieldName\":\"spia.process_instance_id\",\"operationName\":\"=\",\"variableName\":\"processInstanceId\",\"startIndex\": 1011,\"stopIndex\":1057,\"variableNum\": 2,\"variableCount\": 1,\"isor\":false,\"hasVariable\":true,\"hasBracket\":false,\"isVariableFirst\":false,\"topLevel\":false,\"children\": []}]}]"
	};
	private final static String RESULTSETFIELDLIST = "process_instance_activity_id,employee_id,id,process_type,business_name,process_type_name,time_out_action,instance_activity_start_time,id_type,back_view_name,company_weixin,company_email,business_id,process_instance_id,activity_type";
	private final static String[] fieldNames = { "process_type", "business_id", "process_instance_id"};
}
