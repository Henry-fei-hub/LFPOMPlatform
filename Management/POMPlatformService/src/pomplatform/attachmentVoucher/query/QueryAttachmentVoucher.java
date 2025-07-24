package pomplatform.attachmentVoucher.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachmentVoucher.bean.BaseAttachmentVoucher;
import pomplatform.attachmentVoucher.bean.ConditionAttachmentVoucher;

public class QueryAttachmentVoucher extends AbstractQuery<BaseAttachmentVoucher, ConditionAttachmentVoucher>
{

	private static final Logger __logger = Logger.getLogger(QueryAttachmentVoucher.class);

	public QueryAttachmentVoucher() throws java.sql.SQLException 
	{
		setParameterNumber(23);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("kv.k3_voucher_id");
	}

	@Override
	public BaseCollection<BaseAttachmentVoucher> executeQuery( KeyValuePair[] replacements, ConditionAttachmentVoucher condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinVestingDate(), 
				condition.getMaxVestingDate(), 
				condition.getMinCreateTime(), 
				condition.getMaxCreateTime(), 
				condition.getCode(), 
				condition.getName(), 
				condition.getRemark(), 
				condition.getSimplifyRemark(), 
				condition.getK3VoucherId(), 
				condition.getProjectId(), 
				condition.getCompanyId(), 
				condition.getSequenceNumber(), 
				condition.getInternalSequenceNumber(), 
				condition.getCodeType(), 
				condition.getCodeId(), 
				condition.getLinkId(), 
				condition.getVoucherType(), 
				condition.getAdditionalLinkId(), 
				condition.getLocked(), 
				condition.getDebitSide(), 
				condition.getCreditSide(), 
				condition.getAttachmentName(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseAttachmentVoucher generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttachmentVoucher __base = new BaseAttachmentVoucher();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setK3VoucherId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSequenceNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInternalSequenceNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSecondaryCodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSecondaryCodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSecondaryCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSecondaryName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSimplifyRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDebitSide(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreditSide(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReimbursementPackageCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmountOfReimbursement(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNeedToChange(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setVestingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLockedTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLinkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setVoucherType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAdditionalLinkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentCode(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[18]));
		if(args[19] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[19]));
		if(args[20] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[20]));
		if(args[21] != null) __statement.setString(count++, GenericBase.__getString(args[21]));
		if(args[22] != null) __statement.setInt(count++, GenericBase.__getInt(args[22]));
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

	private final static String __SQLText = "SELECT kv.k3_voucher_id, kv.project_id, kv.company_id, kv.sequence_number, kv.internal_sequence_number, kv.code_type, kv.code_id, kv.code, kv.name, kv.secondary_code_type, kv.secondary_code_id, kv.secondary_code, kv.secondary_name, kv.remark, kv.simplify_remark, kv.debit_side, kv.credit_side, kv.reimbursement_package_code, kv.amount_of_reimbursement, kv.input_tax, kv.self_bank_account, kv.other_bank_account, kv.need_to_change, kv.vesting_date, kv.locked, kv.create_time, kv.update_time, kv.locked_time, kv.link_id, kv.voucher_type, kv.additional_link_id, am.attachment_name, am.attachment_manage_id, am.attachment_code FROM k3_vouchers kv LEFT JOIN attachment_manages am ON kv.link_id = am.attachment_manage_id WHERE kv.vesting_date BETWEEN ? AND ? AND kv.create_time BETWEEN ? AND ? AND kv.code LIKE ? AND kv.name LIKE ? AND kv.remark LIKE ? AND kv.simplify_remark LIKE ? AND kv.k3_voucher_id = ? AND kv.project_id = ? AND kv.company_id = ? AND kv.sequence_number = ? AND kv.internal_sequence_number = ? AND kv.code_type = ?_type AND kv.code_id = ?_id AND kv.link_id = ? AND kv.voucher_type = ? AND kv.additional_link_id = ? AND kv.locked = ? AND kv.debit_side = ? AND kv.credit_side = ? AND am.attachment_name LIKE ? AND am.contract_id = ? ORDER BY kv.sequence_number desc, kv.internal_sequence_number" ;
	private final static String RESULTSETFIELDLIST = "k3_voucher_id,project_id,company_id,sequence_number,internal_sequence_number,code_type,code_id,code,name,secondary_code_type,secondary_code_id,secondary_code,secondary_name,remark,simplify_remark,debit_side,credit_side,reimbursement_package_code,amount_of_reimbursement,input_tax,self_bank_account,other_bank_account,need_to_change,vesting_date,locked,create_time,update_time,locked_time,link_id,voucher_type,additional_link_id,attachment_name,attachment_manage_id,attachment_code";
	private final static String[] fieldNames = { "min_vesting_date", "max_vesting_date", "min_create_time", "max_create_time", "code", "name", "remark", "simplify_remark", "k3_voucher_id", "project_id", "company_id", "sequence_number", "internal_sequence_number", "code_type", "code_id", "link_id", "voucher_type", "additional_link_id", "locked", "debit_side", "credit_side", "attachment_name", "contract_id"};
}
