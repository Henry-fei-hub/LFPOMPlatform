package pomplatform.reimbursement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursement.bean.BaseK3VoucherSummary;
import pomplatform.reimbursement.bean.ConditionK3VoucherSummary;

public class QueryK3VoucherSummary extends AbstractQuery<BaseK3VoucherSummary, ConditionK3VoucherSummary>
{

	private static final Logger __logger = Logger.getLogger(QueryK3VoucherSummary.class);

	public QueryK3VoucherSummary() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("kv.reimbursement_package_code");
	}

	@Override
	public BaseCollection<BaseK3VoucherSummary> executeQuery( KeyValuePair[] replacements, ConditionK3VoucherSummary condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getReimbursementPackageCode(), 
				condition.getCompanyId(), 
				condition.getCode(), 
				condition.getSecondaryCode(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getNeedToChange(), 
				condition.getLocked()
			);
	}

	@Override
	public BaseK3VoucherSummary generateBase(Object[] __data) throws java.sql.SQLException {
		BaseK3VoucherSummary __base = new BaseK3VoucherSummary();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setReimbursementPackageCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDebitSide(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreditSide(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setVestingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[6]));
		if(args[7] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[7]));
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

	private final static String __SQLText = "SELECT kv.reimbursement_package_code, kv.company_id, sum(kv.debit_side) as debit_side, sum(kv.credit_side) as credit_side, kv.vesting_date, kv.locked from k3_vouchers kv where kv.reimbursement_package_code like ? and kv.company_id = ? and kv.code like ? and kv.secondary_code like ? and kv.vesting_date >= ? and kv.vesting_date <= ? and kv.need_to_change = ? and kv.locked = ? and kv.voucher_type = 1 GROUP BY kv.reimbursement_package_code, kv.company_id, kv.voucher_year, kv.voucher_month, kv.sequence_number, kv.vesting_date, kv.locked ORDER BY kv.voucher_year desc, kv.voucher_month desc, kv.sequence_number" ;
	private final static String RESULTSETFIELDLIST = "reimbursement_package_code,company_id,debit_side,credit_side,vesting_date";
	private final static String[] fieldNames = { "reimbursement_package_code", "company_id", "code", "secondary_code", "start_date", "end_date", "need_to_change", "locked"};
}
