package pomplatform.workflow.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.operation.bean.BaseOnLoadRefuseListOfCostAllocationPanelNewFive;
import pomplatform.workflow.operation.bean.ConditionOnLoadRefuseListOfCostAllocationPanelNewFive;

public class QueryOnLoadRefuseListOfCostAllocationPanelNewFive extends AbstractQuery<BaseOnLoadRefuseListOfCostAllocationPanelNewFive, ConditionOnLoadRefuseListOfCostAllocationPanelNewFive>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadRefuseListOfCostAllocationPanelNewFive.class);

	public QueryOnLoadRefuseListOfCostAllocationPanelNewFive() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("P .customer_name");
	}

	@Override
	public BaseCollection<BaseOnLoadRefuseListOfCostAllocationPanelNewFive> executeQuery( KeyValuePair[] replacements, ConditionOnLoadRefuseListOfCostAllocationPanelNewFive condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadRefuseListOfCostAllocationPanelNewFive generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadRefuseListOfCostAllocationPanelNewFive __base = new BaseOnLoadRefuseListOfCostAllocationPanelNewFive();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessPooledTaskId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTransferEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreProjectTransferRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT P .customer_name, P .project_name, P .province, P .city, sppt.process_pooled_task_id, sppt.business_id, sppt.business_name, sppt.process_activity_id, sppt.process_id, sppt.process_instance_id, sppt.back_view_name, sppt.activity_type, sppt.node_type, sppt.activity_id, sppt.instance_activity_create_time, sppt.instance_activity_start_time, sppt.status, sppt.process_type, sppt.process_comment, ppr.employee_id, ppr.transfer_employee_id, ppr.pre_project_id, ppr.pre_project_transfer_record_id, ppr.operate_time FROM system_process_pooled_tasks sppt LEFT JOIN pre_project_transfer_records ppr ON sppt.business_id = ppr.pre_project_transfer_record_id LEFT JOIN pre_projects P ON P .pre_project_id = ppr.pre_project_id WHERE sppt.status = ? AND sppt.process_type = ? AND sppt.employee_id = ? AND sppt.delete_flag = 0 ORDER BY sppt.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "customer_name,project_name,province,city,process_pooled_task_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,activity_type,node_type,activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,process_comment,employee_id,transfer_employee_id,pre_project_id,pre_project_transfer_record_id,operate_time";
	private final static String[] fieldNames = { "status", "process_type", "employee_id"};
}
