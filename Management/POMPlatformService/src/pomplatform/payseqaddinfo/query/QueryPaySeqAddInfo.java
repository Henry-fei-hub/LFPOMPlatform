package pomplatform.payseqaddinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payseqaddinfo.bean.BasePaySeqAddInfo;
import pomplatform.payseqaddinfo.bean.ConditionPaySeqAddInfo;

public class QueryPaySeqAddInfo extends AbstractQuery<BasePaySeqAddInfo, ConditionPaySeqAddInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryPaySeqAddInfo.class);

	public QueryPaySeqAddInfo() throws java.sql.SQLException 
	{
		setParameterNumber(21);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ps.payment_sequence_id");
	}

	@Override
	public BaseCollection<BasePaySeqAddInfo> executeQuery( KeyValuePair[] replacements, ConditionPaySeqAddInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBudgetManagementId(), 
				condition.getBudgetAttachmentId(), 
				condition.getPayAmount(), 
				condition.getPayDate(), 
				condition.getPayStatus(), 
				condition.getPsRemark(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getReceiveUnitManageId(), 
				condition.getProcessBillListId(), 
				condition.getProjectId(), 
				condition.getBindStatus(), 
				condition.getPayType(), 
				condition.getIsLock(), 
				condition.getReimbursementAmount(), 
				condition.getReverseAmount(), 
				condition.getApplyPayDate(), 
				condition.getReturnAmount(), 
				condition.getPayFor(), 
				condition.getPayName(), 
				condition.getReimbursementCode()
			);
	}

	@Override
	public BasePaySeqAddInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BasePaySeqAddInfo __base = new BasePaySeqAddInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPaymentSequenceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPayStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPsRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessBillListId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBindStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsLock(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setReimbursementAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReverseAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApplyPayDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setReturnAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayFor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPayName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReimbursementCode(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[13]));
		if(args[14] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[14]));
		if(args[15] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[15]));
		if(args[16] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[16]));
		if(args[17] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setString(count++, GenericBase.__getString(args[19]));
		if(args[20] != null) __statement.setString(count++, GenericBase.__getString(args[20]));
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

	private final static String __SQLText = "select ps.payment_sequence_id, ps.budget_management_id, ps.budget_attachment_id, ps.pay_amount, ps.pay_date, ps.pay_status, ps.ps_remark, ps.year, ps.month, ps.receive_unit_manage_id, ps.process_bill_list_id, ps.project_id, ps.bind_status, ps.pay_type, ps.is_lock, ps.reimbursement_amount, ps.reverse_amount, ps.apply_pay_date, ps.return_amount,ps.pay_for,ps.pay_name,ps.reimbursement_code from payment_sequence ps where ps.budget_management_id = ? and ps.budget_attachment_id = ? and ps.pay_amount = ? and ps.pay_date = ? and ps.pay_status = ? and ps.ps_remark = ? and ps.year = ? and ps.month = ? and ps.receive_unit_manage_id = ? and ps.process_bill_list_id = ? and ps.project_id = ? and ps.bind_status = ? and ps.pay_type = ? and ps.is_lock = ? and ps.reimbursement_amount = ? and ps.reverse_amount = ? and ps.apply_pay_date = ? and ps.return_amount = ? AND ps.pay_for=? AND ps.pay_name=? AND ps.reimbursement_code=? order by ps.payment_sequence_id desc" ;
	private final static String RESULTSETFIELDLIST = "payment_sequence_id,budget_management_id,budget_attachment_id,pay_amount,pay_date,pay_status,ps_remark,year,month,receive_unit_manage_id,process_bill_list_id,project_id,bind_status,pay_type,is_lock,reimbursement_amount,reverse_amount,apply_pay_date,return_amount,pay_for,pay_name,reimbursement_code";
	private final static String[] fieldNames = { "budget_management_id", "budget_attachment_id", "pay_amount", "pay_date", "pay_status", "ps_remark", "year", "month", "receive_unit_manage_id", "process_bill_list_id", "project_id", "bind_status", "pay_type", "is_lock", "reimbursement_amount", "reverse_amount", "apply_pay_date", "return_amount", "pay_for", "pay_name", "reimbursement_code"};
}
