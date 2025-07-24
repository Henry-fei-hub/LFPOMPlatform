package pomplatform.workflow.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.operation.bean.BaseOnLoadRefuseListOfCostAllocationPanelNewThree;
import pomplatform.workflow.operation.bean.ConditionOnLoadRefuseListOfCostAllocationPanelNewThree;

public class QueryOnLoadRefuseListOfCostAllocationPanelNewThree extends AbstractQuery<BaseOnLoadRefuseListOfCostAllocationPanelNewThree, ConditionOnLoadRefuseListOfCostAllocationPanelNewThree>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadRefuseListOfCostAllocationPanelNewThree.class);

	public QueryOnLoadRefuseListOfCostAllocationPanelNewThree() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("P .customer_name");
	}

	@Override
	public BaseCollection<BaseOnLoadRefuseListOfCostAllocationPanelNewThree> executeQuery( KeyValuePair[] replacements, ConditionOnLoadRefuseListOfCostAllocationPanelNewThree condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getStatus(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadRefuseListOfCostAllocationPanelNewThree generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadRefuseListOfCostAllocationPanelNewThree __base = new BaseOnLoadRefuseListOfCostAllocationPanelNewThree();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
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
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT P .customer_name, P .project_name, P .province, P .city, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.status, spia.process_type, spia.process_comment, spia.activity_type, spia.back_view_name, ppr.employee_id, ppr.transfer_employee_id, ppr.pre_project_id, ppr.pre_project_transfer_record_id,ppr.operate_time FROM system_process_instance_activities spia LEFT JOIN pre_project_transfer_records ppr ON spia.business_id = ppr.pre_project_transfer_record_id LEFT JOIN pre_projects P ON P .pre_project_id = ppr.pre_project_id WHERE spia.process_type =? AND spia.status = ? AND spia.employee_id =? AND spia.activity_type IN (2, 3) AND spia.delete_flag = 0 ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "customer_name,project_name,province,city,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,process_comment,activity_type,back_view_name,employee_id,transfer_employee_id,pre_project_id,pre_project_transfer_record_id,operate_time";
	private final static String[] fieldNames = { "process_type", "status", "employee_id"};
}
