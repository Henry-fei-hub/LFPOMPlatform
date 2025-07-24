package pomplatform.attachmentapprovalalready.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachmentapprovalalready.bean.BaseAttachmentApprovalAlready;
import pomplatform.attachmentapprovalalready.bean.ConditionAttachmentApprovalAlready;

public class QueryAttachmentApprovalAlready extends AbstractQuery<BaseAttachmentApprovalAlready, ConditionAttachmentApprovalAlready>
{

	private static final Logger __logger = Logger.getLogger(QueryAttachmentApprovalAlready.class);

	public QueryAttachmentApprovalAlready() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spia.process_instance_activity_id");
	}

	@Override
	public BaseCollection<BaseAttachmentApprovalAlready> executeQuery( KeyValuePair[] replacements, ConditionAttachmentApprovalAlready condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getBudgetManagementId(), 
				condition.getAttachmentName(), 
				condition.getUploadEmployeeId(), 
				condition.getUploadTime(), 
				condition.getUploadRemark(), 
				condition.getProjectId(), 
				condition.getBddType(), 
				condition.getIsApproval(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseAttachmentApprovalAlready generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttachmentApprovalAlready __base = new BaseAttachmentApprovalAlready();
		int count = 0;
		Object val;
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
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUploadEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUploadRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmountUse(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmountRest(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBddType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsApproval(GenericBase.__getInt(val));
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
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
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

	private final static String __SQLText = "SELECT spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, B.file_url, A .* FROM system_process_instance_activities spia LEFT JOIN budget_attachment A ON spia.business_id = A .budget_attachment_id LEFT JOIN file_manages B ON A.file_id = B.file_id WHERE spia.process_type =? AND spia.status IN (2, 3, 6) AND spia.status =? AND spia.employee_id =? AND spia.activity_type IN (2, 3) AND A.budget_management_id=? AND A.attachment_name =? AND A.upload_employee_id =? AND A.upload_time =? AND A.upload_remark=? AND A.project_id=? AND A.bdd_type=? AND A.is_approval=? AND A .department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,file_url,budget_attachment_id,budget_management_id,file_id,attachment_name,upload_employee_id,department_id,upload_time,upload_remark,budget_contract_amount,budget_contract_amount_use,budget_contract_amount_rest,receive_unit_manage_id,project_id,input_tax_invoice_id,bdd_type,is_approval";
	private final static String[] fieldNames = { "process_type", "status", "employee_id", "budget_management_id", "attachment_name", "upload_employee_id", "upload_time", "upload_remark", "project_id", "bdd_type", "is_approval", "department_id"};
}
