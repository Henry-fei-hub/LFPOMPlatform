package pomplatform.attachment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachment.bean.BaseOnLoadAttachmentDataOfAttachment;
import pomplatform.attachment.bean.ConditionOnLoadAttachmentDataOfAttachment;

public class QueryOnLoadAttachmentDataOfAttachment extends AbstractQuery<BaseOnLoadAttachmentDataOfAttachment, ConditionOnLoadAttachmentDataOfAttachment>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttachmentDataOfAttachment.class);

	public QueryOnLoadAttachmentDataOfAttachment() throws java.sql.SQLException
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.attachment_manage_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAttachmentDataOfAttachment> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttachmentDataOfAttachment condition ) throws java.sql.SQLException {
		return executeQuery(replacements,
				condition.getContractId(),
				condition.getContractCode(),
				condition.getContractName(),
				condition.getEmployeeId()
		);
	}

	@Override
	public BaseOnLoadAttachmentDataOfAttachment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttachmentDataOfAttachment __base = new BaseOnLoadAttachmentDataOfAttachment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAttachmentManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPerfessionRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReturnAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPaymentSure(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPaymentGradeDescription(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSerialNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setConfirmationLetter(GenericBase.__getBoolean(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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
	private final static String __SQLText = "SELECT A.attachment_manage_id, A.contract_id, A.attachment_code, A.attachment_name, CASE WHEN fm.file_url IS NULL THEN A.attachment_address ELSE fm.file_url END AS attachment_address, A.perfession_remark, A.amount, A.return_amount, A.payment_sure, A.payment_grade_description, A.serial_number, A.record_date, A.operate_employee_id, A.operate_time, A.remark, A.delete_flag, '合同编号:' || b.contract_code || ' 合同名称:' || b.contract_name || ' 合同金额:' || b.signing_money_sum AS contract_name, COALESCE ( C.invoice_amount, 0 ) AS invoice_amount, A.have_voucher, A.confirmation_letter FROM attachment_manages A LEFT JOIN personnel_business pb ON A.personnel_business_id = pb.personnel_business_id LEFT JOIN file_manages fm ON pb.number_of_baby = fm.file_id LEFT JOIN contracts b ON A.contract_id = b.contract_id LEFT JOIN ( SELECT aa.attachment_manage_id, SUM ( aa.invoice_amount ) AS invoice_amount FROM ( SELECT ali.attachment_manage_id, i.invoice_amount FROM attachment_link_invoices ali LEFT JOIN invoices i ON i.invoice_id = ali.invoice_id ) aa GROUP BY aa.attachment_manage_id ) C ON C.attachment_manage_id = A.attachment_manage_id WHERE b.contract_id = ? and b.contract_code like ? and b.contract_name like ? and a.operate_employee_id =?  AND replce11  AND replce12  and a.delete_flag = 0  AND a.contract_id IN (SELECT contract_id FROM projects WHERE project_manage_id in (replace)) ORDER BY a.contract_id,a.serial_number" ;
	private final static String RESULTSETFIELDLIST = "attachment_manage_id,contract_id,attachment_code,attachment_name,attachment_address,perfession_remark,amount,return_amount,payment_sure,payment_grade_description,serial_number,record_date,operate_employee_id,operate_time,remark,delete_flag,contract_name,invoice_amount,have_voucher";
	private final static String[] fieldNames = { "contract_id", "contract_code", "contract_name", "employee_id"};
}
