package pomplatform.k3voucher.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3voucher.bean.BaseAllVoucherDetail;
import pomplatform.k3voucher.bean.ConditionAllVoucherDetail;

public class QueryAllVoucherDetail extends AbstractQuery<BaseAllVoucherDetail, ConditionAllVoucherDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryAllVoucherDetail.class);

	public QueryAllVoucherDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("k3_voucher_id");
	}

	@Override
	public BaseCollection<BaseAllVoucherDetail> executeQuery( KeyValuePair[] replacements, ConditionAllVoucherDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getVoucherYear(), 
				condition.getVoucherMonth(), 
				condition.getVoucherType(), 
				condition.getSequenceNumber(), 
				condition.getVestingDate()
			);
	}

	@Override
	public BaseAllVoucherDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAllVoucherDetail __base = new BaseAllVoucherDetail();
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
		if((val = __data[count++]) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmountOfReimbursement(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInputTaxRebate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNeedToChange(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setVestingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setVoucherType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLinkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAdditionalLinkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setVoucherYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setVoucherMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "select k3_voucher_id, project_id, company_id, sequence_number, internal_sequence_number, code_type, code_id, code, name, secondary_code_type, secondary_code_id, secondary_code, secondary_name, remark, simplify_remark, debit_side, credit_side, reimbursement_package_code, reimbursement_package_id, amount_of_reimbursement, input_tax, input_tax_rebate, self_bank_account, other_bank_account, need_to_change, vesting_date, locked, voucher_type, link_id, additional_link_id, voucher_year, voucher_month, process_type, process_id, process_instance_id, business_id from k3_vouchers where voucher_year = ? and voucher_month = ? and voucher_type = ? and sequence_number = ? and vesting_date = ? order by sequence_number, internal_sequence_number" ;
	private final static String RESULTSETFIELDLIST = "k3_voucher_id,project_id,company_id,sequence_number,internal_sequence_number,code_type,code_id,code,name,secondary_code_type,secondary_code_id,secondary_code,secondary_name,remark,simplify_remark,debit_side,credit_side,reimbursement_package_code,reimbursement_package_id,amount_of_reimbursement,input_tax,input_tax_rebate,self_bank_account,other_bank_account,need_to_change,vesting_date,locked,voucher_type,link_id,additional_link_id,voucher_year,voucher_month,process_type,process_id,process_instance_id,business_id";
	private final static String[] fieldNames = { "voucher_year", "voucher_month", "voucher_type", "sequence_number", "vesting_date"};
}
