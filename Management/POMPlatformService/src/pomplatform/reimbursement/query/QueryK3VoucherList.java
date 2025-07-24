package pomplatform.reimbursement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursement.bean.BaseK3VoucherList;
import pomplatform.reimbursement.bean.ConditionK3VoucherList;

public class QueryK3VoucherList extends AbstractQuery<BaseK3VoucherList, ConditionK3VoucherList>
{

	private static final Logger __logger = Logger.getLogger(QueryK3VoucherList.class);

	public QueryK3VoucherList() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("kv.k3_voucher_id");
	}

	@Override
	public BaseCollection<BaseK3VoucherList> executeQuery( KeyValuePair[] replacements, ConditionK3VoucherList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getReimbursementPackageCode(), 
				condition.getLocked(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getNeedToChange(), 
				condition.getSecondaryCode(), 
				condition.getCode(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseK3VoucherList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseK3VoucherList __base = new BaseK3VoucherList();
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
		if((val = __data[count++]) != null) __base.setInputTaxRebate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNeedToChange(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setVestingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLockedTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "select kv.k3_voucher_id, kv.project_id, kv.company_id, kv.sequence_number, kv.internal_sequence_number, kv.code_type, kv.code_id, kv.code, kv.name, kv.secondary_code_type, kv.secondary_code_id, kv.secondary_code, kv.secondary_name, kv.remark, kv.simplify_remark, kv.debit_side, kv.credit_side, kv.reimbursement_package_code, kv.amount_of_reimbursement, kv.input_tax, kv.input_tax_rebate, kv.self_bank_account, kv.other_bank_account, kv.need_to_change, kv.vesting_date, kv.locked, kv.create_time, kv.update_time, kv.locked_time, kv.process_id, kv.process_instance_id, kv.process_type, kv.business_id from k3_vouchers kv where kv.reimbursement_package_code like ? and kv.locked = ? and kv.vesting_date <= ? and kv.vesting_date >= ? and kv.need_to_change = ? and kv.secondary_code like ? and kv.code like ? and kv.company_id = ? order by kv.sequence_number desc, kv.internal_sequence_number" ;
	private final static String RESULTSETFIELDLIST = "k3_voucher_id,project_id,company_id,sequence_number,internal_sequence_number,code_type,code_id,code,name,secondary_code_type,secondary_code_id,secondary_code,secondary_name,remark,simplify_remark,debit_side,credit_side,reimbursement_package_code,amount_of_reimbursement,input_tax,input_tax_rebate,self_bank_account,other_bank_account,need_to_change,vesting_date,locked,create_time,update_time,locked_time,process_id,process_instance_id,process_type,business_id";
	private final static String[] fieldNames = { "reimbursement_package_code", "locked", "end_date", "start_date", "need_to_change", "secondary_code", "code", "company_id"};
}
