package pomplatform.workflow.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BasePayMoneyPoolOfWorkflow;
import pomplatform.workflow.bean.ConditionPayMoneyPoolOfWorkflow;

public class QueryPayMoneyPoolOfWorkflow extends AbstractQuery<BasePayMoneyPoolOfWorkflow, ConditionPayMoneyPoolOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryPayMoneyPoolOfWorkflow.class);

	public QueryPayMoneyPoolOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sppt.process_pooled_task_id");
	}

	@Override
	public BaseCollection<BasePayMoneyPoolOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionPayMoneyPoolOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getCode(),
				condition.getDrafter()
			);
	}

	@Override
	public BasePayMoneyPoolOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BasePayMoneyPoolOfWorkflow __base = new BasePayMoneyPoolOfWorkflow();
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
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceiveStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
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

	private final static String __SQLText = "select sppt.process_pooled_task_id, sppt.business_id, sppt.business_name, sppt.process_activity_id, sppt.process_id , sppt.process_instance_id, sppt.back_view_name, sppt.activity_type, sppt.node_type, sppt.activity_id, sppt.instance_activity_create_time , sppt.instance_activity_start_time, sppt.status , sppt.process_type,pmm.code,pmm.employee_id,pmm.department_id,pmm.pay_amount,pmm.company_id,sppt.operate_time, sppt.process_comment, fib.receive_status, pmm.reason from system_process_pooled_tasks sppt left join pay_money_manages pmm on sppt.business_id = pmm.pay_money_manage_id LEFT JOIN finance_receive_bills fib ON fib.code = pmm.code where sppt.status = ? and sppt.process_type=7 and sppt.employee_id = ? and pmm.company_id = ? and pmm.code like ? and sppt.delete_flag = 0 and pmm.employee_id = ? order by sppt.instance_activity_create_time desc" ;
	private final static String RESULTSETFIELDLIST = "process_pooled_task_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,activity_type,node_type,activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,code,employee_id,department_id,pay_amount,company_id,operate_time,process_comment,receive_status,reason";
	private final static String[] fieldNames = { "status", "employee_id", "company_id", "code", "drafter"};
}
