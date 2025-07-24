package pomplatform.abountpaymentsequenceinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.abountpaymentsequenceinfo.bean.BaseAbountPaymentSequenceinfo;
import pomplatform.abountpaymentsequenceinfo.bean.ConditionAbountPaymentSequenceinfo;

public class QueryAbountPaymentSequenceinfo extends AbstractQuery<BaseAbountPaymentSequenceinfo, ConditionAbountPaymentSequenceinfo>
{

	private static final Logger __logger = Logger.getLogger(QueryAbountPaymentSequenceinfo.class);

	public QueryAbountPaymentSequenceinfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ps.budget_management_id");
	}

	@Override
	public BaseCollection<BaseAbountPaymentSequenceinfo> executeQuery( KeyValuePair[] replacements, ConditionAbountPaymentSequenceinfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBudgetManagementId()
			);
	}

	@Override
	public BaseAbountPaymentSequenceinfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAbountPaymentSequenceinfo __base = new BaseAbountPaymentSequenceinfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReimbursementAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReverseAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPsRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplyPayDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmountUse(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBudgetContractAmountRest(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayFor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPaymentSequenceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.SetReturnAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT ps.budget_management_id, ba.attachment_name, f.file_url, ps.pay_amount, ps.reimbursement_amount, ps.reverse_amount, ps.pay_date, ba.receive_unit_manage_id, ps.pay_type, ps.ps_remark, ps.pay_status, ps.apply_pay_date, ba.budget_contract_amount, ba.budget_contract_amount_use, ba.budget_contract_amount_rest, case WHEN budget_contract_amount<=0 OR budget_contract_amount IS NULL then '0.00%' ELSE CAST ( budget_contract_amount_use / budget_contract_amount * 100 AS DECIMAL ( 18, 2 )) || '%' END AS pay_percent, bm.project_id,ps.pay_for,ps.pay_name,ps.payment_sequence_id,ps.budget_attachment_id,ps.process_type,ps.process_id,ps.return_amount FROM payment_sequence ps LEFT JOIN budget_attachment ba ON ps.budget_attachment_id = ba.budget_attachment_id LEFT JOIN budget_management bm ON ps.budget_management_id = bm.budget_management_id LEFT JOIN file_manages f ON ba.file_id = f.file_id WHERE ps.budget_management_id=? ORDER BY ps.apply_pay_date desc" ;
	private final static String RESULTSETFIELDLIST = "budget_management_id,attachment_name,file_url,pay_amount,reimbursement_amount,reverse_amount,pay_date,receive_unit_manage_id,pay_type,ps_remark,pay_status,apply_pay_date,budget_contract_amount,budget_contract_amount_use,budget_contract_amount_rest,pay_percent,project_id,pay_for,pay_name,payment_sequence_id,budget_attachment_id,process_type,process_id,return_amount";
	private final static String[] fieldNames = { "budget_management_id"};
}
