package pomplatform.aboutreimbursementpayseq.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.aboutreimbursementpayseq.bean.BaseAboutReimbursementPayseq;
import pomplatform.aboutreimbursementpayseq.bean.ConditionAboutReimbursementPayseq;

public class QueryAboutReimbursementPayseq extends AbstractQuery<BaseAboutReimbursementPayseq, ConditionAboutReimbursementPayseq>
{

	private static final Logger __logger = Logger.getLogger(QueryAboutReimbursementPayseq.class);

	public QueryAboutReimbursementPayseq() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.budget_attachment_id");
	}

	@Override
	public BaseCollection<BaseAboutReimbursementPayseq> executeQuery( KeyValuePair[] replacements, ConditionAboutReimbursementPayseq condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBudgetManagementId(), 
				condition.getBudgetAttachmentId(), 
				condition.getPaymentSequenceId()
			);
	}

	@Override
	public BaseAboutReimbursementPayseq generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAboutReimbursementPayseq __base = new BaseAboutReimbursementPayseq();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUploadEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUploadRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReimbursementAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReverseAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReturnAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmountUse(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmountRest(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBddType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayPercent(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT p.budget_attachment_id, p.budget_management_id, b.file_id, b.attachment_name, upload_employee_id, upload_time, upload_remark, p.pay_amount, P.reimbursement_amount,p.reverse_amount,p.return_amount,budget_contract_amount, budget_contract_amount_use, budget_contract_amount_rest, b.receive_unit_manage_id, f.file_url, bdd_type, bm.project_id, case WHEN budget_contract_amount<=0 OR budget_contract_amount IS NULL then '0.00%' ELSE CAST ( budget_contract_amount_use / budget_contract_amount * 100 AS DECIMAL ( 18, 2 )) || '%' END AS pay_percent FROM payment_sequence p LEFT JOIN budget_attachment b ON p.budget_attachment_id=b.budget_attachment_id and p.budget_management_id=b.budget_management_id LEFT JOIN budget_management bm on p.budget_management_id=bm.budget_management_id LEFT JOIN file_manages f ON b.file_id = f.file_id WHERE p.budget_management_id=? AND p.budget_attachment_id=? AND p.payment_sequence_id=? ORDER BY budget_attachment_id" ;
	private final static String RESULTSETFIELDLIST = "budget_attachment_id,budget_management_id,file_id,attachment_name,upload_employee_id,upload_time,upload_remark,pay_amount,reimbursement_amount,reverse_amount,return_amount,budget_contract_amount,budget_contract_amount_use,budget_contract_amount_rest,receive_unit_manage_id,file_url,bdd_type,project_id,pay_percent";
	private final static String[] fieldNames = { "budget_management_id", "budget_attachment_id", "payment_sequence_id"};
}
