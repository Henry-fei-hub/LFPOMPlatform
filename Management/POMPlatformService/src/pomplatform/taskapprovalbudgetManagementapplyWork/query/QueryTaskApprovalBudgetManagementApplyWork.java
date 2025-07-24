package pomplatform.taskapprovalbudgetManagementapplyWork.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.taskapprovalbudgetManagementapplyWork.bean.BaseTaskApprovalBudgetManagementApplyWork;
import pomplatform.taskapprovalbudgetManagementapplyWork.bean.ConditionTaskApprovalBudgetManagementApplyWork;

public class QueryTaskApprovalBudgetManagementApplyWork extends AbstractQuery<BaseTaskApprovalBudgetManagementApplyWork, ConditionTaskApprovalBudgetManagementApplyWork>
{

	private static final Logger __logger = Logger.getLogger(QueryTaskApprovalBudgetManagementApplyWork.class);

	public QueryTaskApprovalBudgetManagementApplyWork() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sppt.process_pooled_task_id");
	}

	@Override
	public BaseCollection<BaseTaskApprovalBudgetManagementApplyWork> executeQuery( KeyValuePair[] replacements, ConditionTaskApprovalBudgetManagementApplyWork condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getType(), 
				condition.getCode(), 
				condition.getCompanyId(), 
				condition.getBdApplyEmployeeId(), 
				condition.getBdApplyTime(), 
				condition.getProjectId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseTaskApprovalBudgetManagementApplyWork generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTaskApprovalBudgetManagementApplyWork __base = new BaseTaskApprovalBudgetManagementApplyWork();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessPooledTaskId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBdType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBdUseAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBdRestAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBdApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBdEstimatecloseTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBdStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostBearIng(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
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
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "SELECT sppt.process_pooled_task_id, sppt.business_id, sppt.business_name, sppt.process_activity_id, sppt.process_id, sppt.process_instance_id, sppt.back_view_name, sppt.node_type, sppt.activity_id, sppt.instance_activity_create_time, sppt.instance_activity_start_time, sppt.status, sppt.operate_time, sppt.process_comment, A.*, sppt.activity_type FROM system_process_pooled_tasks sppt LEFT JOIN budget_management A ON sppt.business_id = A.budget_management_id WHERE sppt.status =? AND sppt.process_type =? AND sppt.employee_id =? AND A.bd_type =? AND A.bd_code =? AND A.company_id =? AND A.bd_apply_employee_id =? AND A.bd_apply_time =? AND A.project_id =? AND A.department_id IN ( SELECT plate_id FROM plate_records WHERE plate_id=? ) ORDER BY sppt.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_pooled_task_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,node_type,activity_id,instance_activity_create_time,instance_activity_start_time,status,operate_time,process_comment,budget_management_id,bd_code,bd_type,bd_total_amount,bd_use_amount,bd_rest_amount,bd_apply_employee_id,bd_apply_time,bd_estimateclose_time,bd_status,project_id,bd_remark,input_tax_invoice_id,department_id,company_id,cost_bearing,activity_type";
	private final static String[] fieldNames = { "status", "process_type", "employee_id", "type", "code", "company_id", "bd_apply_employee_id", "bd_apply_time", "project_id", "plate_id"};
}
