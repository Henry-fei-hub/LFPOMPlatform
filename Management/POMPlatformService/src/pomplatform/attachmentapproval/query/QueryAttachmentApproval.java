package pomplatform.attachmentapproval.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachmentapproval.bean.BaseAttachmentApproval;
import pomplatform.attachmentapproval.bean.ConditionAttachmentApproval;

public class QueryAttachmentApproval extends AbstractQuery<BaseAttachmentApproval, ConditionAttachmentApproval>
{

	private static final Logger __logger = Logger.getLogger(QueryAttachmentApproval.class);

	public QueryAttachmentApproval() throws java.sql.SQLException 
	{
		setParameterNumber(15);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ba.budget_attachment_id");
	}

	@Override
	public BaseCollection<BaseAttachmentApproval> executeQuery( KeyValuePair[] replacements, ConditionAttachmentApproval condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBudgetManagementId(), 
				condition.getFileId(), 
				condition.getAttachmentName(), 
				condition.getUploadEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getUploadTime(), 
				condition.getUploadRemark(), 
				condition.getBudgetContractAmount(), 
				condition.getBudgetContractAmountUse(), 
				condition.getBudgetContractAmountRest(), 
				condition.getReceiveUnitManageId(), 
				condition.getProjectId(), 
				condition.getInputTaxInvoiceId(), 
				condition.getBddType(), 
				condition.getIsApproval()
			);
	}

	@Override
	public BaseAttachmentApproval generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttachmentApproval __base = new BaseAttachmentApproval();
		int count = 0;
		Object val;
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[7]));
		if(args[8] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[8]));
		if(args[9] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
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

	private final static String __SQLText = "select ba.budget_attachment_id, ba.budget_management_id, ba.file_id, ba.attachment_name, ba.upload_employee_id, ba.department_id, ba.upload_time, ba.upload_remark, ba.budget_contract_amount, ba.budget_contract_amount_use, ba.budget_contract_amount_rest, ba.receive_unit_manage_id, ba.project_id, ba.input_tax_invoice_id, ba.bdd_type, ba.is_approval from budget_attachment ba where ba.budget_management_id = ? and ba.file_id = ? and ba.attachment_name = ? and ba.upload_employee_id = ? and ba.department_id = ? and ba.upload_time = ? and ba.upload_remark = ? and ba.budget_contract_amount = ? and ba.budget_contract_amount_use = ?_use and ba.budget_contract_amount_rest = ?_rest and ba.receive_unit_manage_id = ? and ba.project_id = ? and ba.input_tax_invoice_id = ? and ba.bdd_type = ? and ba.is_approval = ?" ;
	private final static String RESULTSETFIELDLIST = "budget_attachment_id,budget_management_id,file_id,attachment_name,upload_employee_id,department_id,upload_time,upload_remark,budget_contract_amount,budget_contract_amount_use,budget_contract_amount_rest,receive_unit_manage_id,project_id,input_tax_invoice_id,bdd_type,is_approval";
	private final static String[] fieldNames = { "budget_management_id", "file_id", "attachment_name", "upload_employee_id", "department_id", "upload_time", "upload_remark", "budget_contract_amount", "budget_contract_amount_use", "budget_contract_amount_rest", "receive_unit_manage_id", "project_id", "input_tax_invoice_id", "bdd_type", "is_approval"};
}
