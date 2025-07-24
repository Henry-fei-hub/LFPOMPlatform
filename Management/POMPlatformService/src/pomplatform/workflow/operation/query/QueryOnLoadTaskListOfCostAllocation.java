package pomplatform.workflow.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.operation.bean.BaseOnLoadTaskListOfCostAllocation;
import pomplatform.workflow.operation.bean.ConditionOnLoadTaskListOfCostAllocation;

public class QueryOnLoadTaskListOfCostAllocation extends AbstractQuery<BaseOnLoadTaskListOfCostAllocation, ConditionOnLoadTaskListOfCostAllocation>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadTaskListOfCostAllocation.class);

	public QueryOnLoadTaskListOfCostAllocation() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sppt.process_pooled_task_id");
	}

	@Override
	public BaseCollection<BaseOnLoadTaskListOfCostAllocation> executeQuery( KeyValuePair[] replacements, ConditionOnLoadTaskListOfCostAllocation condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getCostType(), 
				condition.getCost(), 
				condition.getCode(), 
				condition.getName()
			);
	}

	@Override
	public BaseOnLoadTaskListOfCostAllocation generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadTaskListOfCostAllocation __base = new BaseOnLoadTaskListOfCostAllocation();
		int count = 0;
		Object val;
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
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "select sppt.process_pooled_task_id, sppt.business_id, sppt.business_name, sppt.process_activity_id, sppt.process_id , sppt.process_instance_id, sppt.back_view_name, sppt.activity_type, sppt.node_type, sppt.activity_id, sppt.instance_activity_create_time , sppt.instance_activity_start_time, sppt.status , sppt.process_type, rc.drafter, rc.cost_type, rc.code, rc.name, rc.cost, rc.reason, sppt.operate_time, sppt.process_comment FROM system_process_pooled_tasks sppt LEFT JOIN reset_costs rc on sppt.business_id = rc.reset_cost_id WHERE sppt.status = ? and sppt.process_type = ? and sppt.employee_id = ? and sppt.delete_flag = 0 and rc.cost_type =? and rc.cost = ? and rc.code like ? and rc.name like ? ORDER BY sppt.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_pooled_task_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,activity_type,node_type,activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,drafter,cost_type,code,name,cost,reason,operate_time,process_comment";
	private final static String[] fieldNames = { "status", "process_type", "employee_id", "cost_type", "cost", "code", "name"};
}
