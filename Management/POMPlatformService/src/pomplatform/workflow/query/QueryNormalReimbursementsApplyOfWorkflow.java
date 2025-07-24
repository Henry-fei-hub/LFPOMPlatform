package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseNormalReimbursementsApplyOfWorkflow;
import pomplatform.workflow.bean.ConditionNormalReimbursementsApplyOfWorkflow;

public class QueryNormalReimbursementsApplyOfWorkflow extends AbstractQuery<BaseNormalReimbursementsApplyOfWorkflow, ConditionNormalReimbursementsApplyOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryNormalReimbursementsApplyOfWorkflow.class);

	public QueryNormalReimbursementsApplyOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseNormalReimbursementsApplyOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionNormalReimbursementsApplyOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getIsProject(), 
				condition.getDepartmentId(), 
				condition.getCode(),
				condition.getReimbursementName()
			);
	}

	@Override
	public BaseNormalReimbursementsApplyOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseNormalReimbursementsApplyOfWorkflow __base = new BaseNormalReimbursementsApplyOfWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTitle(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "select spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id ,spi.process_status, spi.create_time, spi.complete_time,a.department_id,a.employee_id,a.amount,a.code,a.company_id, a.reimbursement_name as title from system_process_instances spi left join project_normal_reimbursements a on spi.business_id = a.project_normal_reimbursement_id where process_type= ? and spi.process_status in(0,1) and spi.delete_flag = 0 and a.employee_id = ? and a.company_id = ? and a.is_project = ? and a.department_id in(select child_id from department_ids where department_id = ?) and a.code like ? AND A.reimbursement_name like ? order by create_time desc" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,department_id,employee_id,amount,code,company_id,title";
	private final static String[] fieldNames = { "process_type", "employee_id", "company_id", "is_project", "department_id", "code" , "reimbursementNameItem"};
}
