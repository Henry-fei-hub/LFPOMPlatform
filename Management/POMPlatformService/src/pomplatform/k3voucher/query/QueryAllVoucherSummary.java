package pomplatform.k3voucher.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3voucher.bean.BaseAllVoucherSummary;
import pomplatform.k3voucher.bean.ConditionAllVoucherSummary;

public class QueryAllVoucherSummary extends AbstractQuery<BaseAllVoucherSummary, ConditionAllVoucherSummary>
{

	private static final Logger __logger = Logger.getLogger(QueryAllVoucherSummary.class);

	public QueryAllVoucherSummary() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("voucher_type");
	}

	@Override
	public BaseCollection<BaseAllVoucherSummary> executeQuery( KeyValuePair[] replacements, ConditionAllVoucherSummary condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getVoucherType(), 
				condition.getVoucherYear(), 
				condition.getVoucherMonth(), 
				condition.getCompanyId(),
				condition.getSequenceNumber(),
				condition.getReimbursementPackageCode()
			);
	}

	@Override
	public BaseAllVoucherSummary generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAllVoucherSummary __base = new BaseAllVoucherSummary();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setVoucherType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReimbursementPackageCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReimbursementPackageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setVestingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSequenceNumber(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
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

	private final static String __SQLText = "select voucher_type, reimbursement_package_code, reimbursement_package_id, vesting_date, sequence_number, locked from k3_vouchers where voucher_type = ? and voucher_year = ? and voucher_month = ? and company_id = ? and sequence_number = ? and reimbursement_package_code like ? group by voucher_type, reimbursement_package_code, reimbursement_package_id, vesting_date, sequence_number, locked order by sequence_number" ;
	private final static String RESULTSETFIELDLIST = "voucher_type,reimbursement_package_code,reimbursement_package_id,vesting_date,sequence_number,locked";
	private final static String[] fieldNames = { "voucher_type", "voucher_year", "voucher_month", "company_id", "sequence_number", "reimbursement_package_code"};
}
