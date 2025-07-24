package pomplatform.PooledInspectionReport.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.PooledInspectionReport.bean.BasePooledInspectionReport;
import pomplatform.PooledInspectionReport.bean.ConditionPooledInspectionReport;

public class QueryPooledInspectionReport extends AbstractQuery<BasePooledInspectionReport, ConditionPooledInspectionReport>
{

	private static final Logger __logger = Logger.getLogger(QueryPooledInspectionReport.class);

	public QueryPooledInspectionReport() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("t.* from (select a.business_id");
	}

	@Override
	public BaseCollection<BasePooledInspectionReport> executeQuery( KeyValuePair[] replacements, ConditionPooledInspectionReport condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCode(), 
				condition.getCode(), 
				condition.getCode(), 
				condition.getCode(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BasePooledInspectionReport generateBase(Object[] __data) throws java.sql.SQLException {
		BasePooledInspectionReport __base = new BasePooledInspectionReport();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessPooledTaskId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "select t.* from (select a.business_id,a.code,a.process_type,a.process_id,a.process_status,a.process_instance_id, task.process_pooled_task_id, task.business_name, task.process_activity_id, task.back_view_name, task.activity_type, task.node_type, task.activity_id, 0 as next_activity_id, 0 as main_activity_id, task.instance_activity_id, task.instance_activity_create_time, task.instance_activity_start_time, task.employee_id, task.operate_time, task.process_comment, task.status, 1 as type, task.delete_flag from ( select a1.travel_reimbursement_id as business_id,a1.code,spi.process_type,spi.process_id,spi.process_status,spi.process_instance_id from travel_reimbursements a1 LEFT JOIN system_process_instances spi on spi.business_id = a1.travel_reimbursement_id where a1.code = ? and spi.process_type in (4,5,9) and a1.delete_flag=0 UNION all select a1.project_normal_reimbursement_id as business_id,a1.code,spi.process_type,spi.process_id,spi.process_status,spi.process_instance_id from project_normal_reimbursements a1 LEFT JOIN system_process_instances spi on spi.business_id = a1.project_normal_reimbursement_id where a1.code = ? and spi.process_type in (2,3,8,10) and a1.delete_flag=0 UNION all select a1.pay_money_manage_id as business_id,a1.code,spi.process_type,spi.process_id,spi.process_status,spi.process_instance_id from pay_money_manages a1 LEFT JOIN system_process_instances spi on spi.business_id = a1.pay_money_manage_id where a1.code = ? and spi.process_type=7 and a1.delete_flag=0 UNION all select a1.employee_money_manage_id as business_id,a1.code,spi.process_type,spi.process_id,spi.process_status,spi.process_instance_id from employee_money_manages a1 LEFT JOIN system_process_instances spi on spi.business_id = a1.employee_money_manage_id where a1.code = ? and spi.process_type=6 and a1.delete_flag=0 ) a LEFT JOIN system_process_pooled_tasks task on a.process_type = task.process_type and a.business_id = task.business_id and task.employee_id = ? where task.status=1) t,system_processes p where t.process_id=p.process_id" ;
	private final static String RESULTSETFIELDLIST = "business_id,code,process_type,process_id,process_status,process_instance_id,process_pooled_task_id,business_name,process_activity_id,back_view_name,activity_type,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_id,instance_activity_create_time,instance_activity_start_time,employee_id,operate_time,process_comment,status,type,delete_flag";
	private final static String[] fieldNames = { "code", "code", "code", "code", "employee_id"};
}
