package pomplatform.attachmentapprovalapply.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachmentapprovalapply.bean.BaseAttachmentApprovalApply;
import pomplatform.attachmentapprovalapply.bean.ConditionAttachmentApprovalApply;

public class QueryAttachmentApprovalApply extends AbstractQuery<BaseAttachmentApprovalApply, ConditionAttachmentApprovalApply>
{

	private static final Logger __logger = Logger.getLogger(QueryAttachmentApprovalApply.class);

	public QueryAttachmentApprovalApply() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseAttachmentApprovalApply> executeQuery( KeyValuePair[] replacements, ConditionAttachmentApprovalApply condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getCreateTime(), 
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
	public BaseAttachmentApprovalApply generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttachmentApprovalApply __base = new BaseAttachmentApprovalApply();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayPercent(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.complete_time, spi.process_type, B.file_url, CAST ( A.budget_contract_amount_use / A.budget_contract_amount * 100 AS DECIMAL (18, 2) ) || '%' AS pay_percent, A .* FROM system_process_instances spi LEFT JOIN budget_attachment A ON spi.business_id = A.budget_attachment_id LEFT JOIN file_manages B ON A.file_id = B.file_id WHERE spi.process_type =? AND spi.process_status IN (0, 1) AND spi.create_time=? AND spi.employee_id=? AND A.budget_management_id=? AND A.attachment_name =? AND A.upload_employee_id =? AND A.upload_time =? AND A.upload_remark=? AND A.project_id=? AND A.bdd_type=? AND A.is_approval=? AND A.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) AND spi.delete_flag = 0 ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,complete_time,process_type,file_url,pay_percent,budget_attachment_id,budget_management_id,file_id,attachment_name,upload_employee_id,department_id,upload_time,upload_remark,budget_contract_amount,budget_contract_amount_use,budget_contract_amount_rest,receive_unit_manage_id,project_id,input_tax_invoice_id,bdd_type,is_approval";
	private final static String[] fieldNames = { "process_type", "create_time", "employee_id", "budget_management_id", "attachment_name", "upload_employee_id", "upload_time", "upload_remark", "project_id", "bdd_type", "is_approval", "department_id"};
}
