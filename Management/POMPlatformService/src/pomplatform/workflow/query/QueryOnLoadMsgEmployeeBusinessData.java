package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseOnLoadMsgEmployeeBusinessData;
import pomplatform.workflow.bean.ConditionOnLoadMsgEmployeeBusinessData;

public class QueryOnLoadMsgEmployeeBusinessData extends AbstractQuery<BaseOnLoadMsgEmployeeBusinessData, ConditionOnLoadMsgEmployeeBusinessData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadMsgEmployeeBusinessData.class);

	public QueryOnLoadMsgEmployeeBusinessData() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spt.process_type_name");
	}

	@Override
	public BaseCollection<BaseOnLoadMsgEmployeeBusinessData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadMsgEmployeeBusinessData condition ) throws java.sql.SQLException {
		return executeQuery(replacements
			);
	}

	@Override
	public BaseOnLoadMsgEmployeeBusinessData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadMsgEmployeeBusinessData __base = new BaseOnLoadMsgEmployeeBusinessData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessPooledTaskId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTypeFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployee1(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployee2(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyWeixin(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActivityName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTimeOutAction(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMessage1(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMessage2(GenericBase.__getInt(val));
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
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "select spt.process_type_name, sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, spia.employee_id as employee_1, sppt.employee_id as employee_2, e.status as employee_status, e.company_weixin, spa.activity_name, spa.time_out_action, spia.time_out_message_status as message_1, sppt.time_out_message_status as message_2 FROM system_process_instance_activities AS spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id LEFT JOIN system_process_activities spa ON spa.process_id = spia.process_id and spa.process_activity_id =spia.process_activity_id and spia.activity_type = spa.activity_type LEFT JOIN employees e on (e.employee_id = spia.employee_id or e.employee_id = sppt.employee_id) WHERE spi.delete_flag = 0 AND spa.activity_name NOT like '%财务%' and e.status NOTNULL and e.status =0 and spa.is_enable = true and spa.time_out_action NOTNULL and spa.time_out_action>0 AND (( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.status =1 ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND sppt.status =1 ) OR ( spia.employee_id IS NULL AND sppt.status =1 ))" ;
	private final static String RESULTSETFIELDLIST = "process_type_name,process_pooled_task_id,type_flag,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,employee_1,employee_2,employee_status,company_weixin,activity_name,time_out_action,message_1,message_2";
	private final static String[] fieldNames = { };
}
