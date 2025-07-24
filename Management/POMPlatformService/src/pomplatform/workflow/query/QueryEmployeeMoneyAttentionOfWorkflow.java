package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseEmployeeMoneyAttentionOfWorkflow;
import pomplatform.workflow.bean.ConditionEmployeeMoneyAttentionOfWorkflow;

public class QueryEmployeeMoneyAttentionOfWorkflow extends AbstractQuery<BaseEmployeeMoneyAttentionOfWorkflow, ConditionEmployeeMoneyAttentionOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeMoneyAttentionOfWorkflow.class);

	public QueryEmployeeMoneyAttentionOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseEmployeeMoneyAttentionOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionEmployeeMoneyAttentionOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getCode(),
				condition.getDrafter()
			);
	}

	@Override
	public BaseEmployeeMoneyAttentionOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeMoneyAttentionOfWorkflow __base = new BaseEmployeeMoneyAttentionOfWorkflow();
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
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "select spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id , spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status , spa.process_type, emm.code,emm.employee_id,emm.department_id,emm.borrow_money,emm.company_id, spa.operate_time, spa.process_comment, emm.title_name as title,emm.reason as remark from system_process_attentions spa left join employee_money_manages emm on spa.business_id = emm.employee_money_manage_id where spa.status = ? and process_type=6 and spa.employee_id = ? and emm.company_id = ? and emm.department_id in(select child_id from department_ids where department_id = ?) and emm.code like ? and spa.delete_flag = 0 and emm.employee_id = ? order by spa.instance_activity_create_time desc" ;
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,code,employee_id,department_id,borrow_money,company_id,operate_time,process_comment,title,remark";
	private final static String[] fieldNames = { "status", "employee_id", "company_id", "department_id", "code", "drafter"};
}
