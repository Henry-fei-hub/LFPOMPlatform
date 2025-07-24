package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseNormalReimbursementsAttentionOfWorkflow;
import pomplatform.workflow.bean.ConditionNormalReimbursementsAttentionOfWorkflow;

public class QueryNormalReimbursementsAttentionOfWorkflow extends AbstractQuery<BaseNormalReimbursementsAttentionOfWorkflow, ConditionNormalReimbursementsAttentionOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryNormalReimbursementsAttentionOfWorkflow.class);

	public QueryNormalReimbursementsAttentionOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseNormalReimbursementsAttentionOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionNormalReimbursementsAttentionOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getCode(),
				condition.getDrafter()
			);
	}

	@Override
	public BaseNormalReimbursementsAttentionOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseNormalReimbursementsAttentionOfWorkflow __base = new BaseNormalReimbursementsAttentionOfWorkflow();
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
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTitle(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "select spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id , spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status , spa.process_type,nr.code,nr.employee_id,nr.department_id,nr.amount,nr.company_id, spa.operate_time, spa.process_comment, nr.reimbursement_name as title, nr.remark from system_process_attentions spa left join project_normal_reimbursements nr on spa.business_id = nr.project_normal_reimbursement_id where spa.status = ? and process_type= ? and spa.employee_id = ? and nr.company_id = ? and nr.department_id in(select child_id from department_ids where department_id = ?) and nr.code like ? and spa.delete_flag = 0 and nr.apply_employee_id = ? order by spa.instance_activity_create_time desc" ;
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,code,employee_id,department_id,amount,company_id,operate_time,process_comment,title,remark";
	private final static String[] fieldNames = { "status", "process_type", "employee_id", "company_id", "department_id", "code", "drafter"};
}
