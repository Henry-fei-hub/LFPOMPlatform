package pomplatform.k3voucher.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3voucher.bean.BaseIncomeVoucher;
import pomplatform.k3voucher.bean.ConditionIncomeVoucher;

public class QueryIncomeVoucher extends AbstractQuery<BaseIncomeVoucher, ConditionIncomeVoucher>
{

	private static final Logger __logger = Logger.getLogger(QueryIncomeVoucher.class);

	public QueryIncomeVoucher() throws java.sql.SQLException 
	{
		setParameterNumber(24);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.k3_voucher_id");
	}

	@Override
	public BaseCollection<BaseIncomeVoucher> executeQuery( KeyValuePair[] replacements, ConditionIncomeVoucher condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getInvoiceNumber(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getCode(), 
				condition.getName(), 
				condition.getDebitSide(), 
				condition.getCreditSide(), 
				condition.getCustomerId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getLocked(),
				condition.getCompanyId(), 
				condition.getInvoiceNumber(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getCode(), 
				condition.getName(), 
				condition.getDebitSide(), 
				condition.getCreditSide(), 
				condition.getCustomerId(), 
				condition.getContractCode(), 
				condition.getContractName(),
				condition.getLocked()
			);
	}

	@Override
	public BaseIncomeVoucher generateBase(Object[] __data) throws java.sql.SQLException {
		BaseIncomeVoucher __base = new BaseIncomeVoucher();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setK3VoucherId(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setVestingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setVoucherType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLinkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractArea(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[6]));
		if(args[7] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[18]));
		if(args[19] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[19]));
		if(args[20] != null) __statement.setInt(count++, GenericBase.__getInt(args[20]));
		if(args[21] != null) __statement.setString(count++, GenericBase.__getString(args[21]));
		if(args[22] != null) __statement.setString(count++, GenericBase.__getString(args[22]));
		if(args[23] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[23]));
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

	private final static String __SQLText = "select a.* from ((SELECT a.k3_voucher_id, a.company_id, a.sequence_number, a.internal_sequence_number, a.code_type, a.code_id, a.code, a.name, a.secondary_code_type, a.secondary_code_id, a.secondary_code, a.secondary_name, a.remark, a.simplify_remark, a.debit_side, a.credit_side, a.vesting_date, a.locked, a.voucher_type, a.link_id, a.reimbursement_package_code as invoice_number, c.contract_id, c.contract_code, c.contract_name, c.contract_area, c.customer_id from k3_vouchers a LEFT JOIN invoices b on a.link_id = b.invoice_id LEFT JOIN contracts c on b.contract_id = c.contract_id where a.voucher_type = 2 and a.company_id = ? and a.reimbursement_package_code like ? and a.vesting_date >= ? and a.vesting_date <= ? and a.code like ? and a.name like ? and a.debit_side = ? and a.credit_side = ? and c.customer_id = ? and c.contract_code like ? and c.contract_name like ? and a.locked = ?) Union all (SELECT a.k3_voucher_id, a.company_id, a.sequence_number, a.internal_sequence_number, a.code_type, a.code_id, a.code, a.name, a.secondary_code_type, a.secondary_code_id, a.secondary_code, a.secondary_name, a.remark, a.simplify_remark, a.debit_side, a.credit_side, a.vesting_date, a.locked, a.voucher_type, a.link_id, a.reimbursement_package_code as invoice_number, c.contract_id, c.contract_code, c.contract_name, c.contract_area, c.customer_id from k3_vouchers a LEFT JOIN capitals b on a.link_id = b.capital_id LEFT JOIN contracts c on b.contract_id = c.contract_id where a.voucher_type = 3 and a.company_id = ? and a.reimbursement_package_code like ? and a.vesting_date >= ? and a.vesting_date <= ? and a.code like ? and a.name like ? and a.debit_side = ? and a.credit_side = ? and c.customer_id = ? and c.contract_code like ? and c.contract_name like ? and a.locked = ?)) as a order by a.vesting_date, a.sequence_number, a.internal_sequence_number" ;
	private final static String RESULTSETFIELDLIST = "k3_voucher_id,company_id,sequence_number,internal_sequence_number,code_type,code_id,code,name,secondary_code_type,secondary_code_id,secondary_code,secondary_name,remark,simplify_remark,debit_side,credit_side,vesting_date,locked,voucher_type,link_id,invoice_number,contract_id,contract_code,contract_name,contract_area,customer_id";
	private final static String[] fieldNames = { "company_id", "invoice_number", "start_date", "end_date", "code", "name", "debit_side", "credit_side", "customer_id", "contract_code", "contract_name", "locked", "company_id", "invoice_number", "start_date", "end_date", "code", "name", "debit_side", "credit_side", "customer_id", "contract_code", "contract_name", "locked"};
}
