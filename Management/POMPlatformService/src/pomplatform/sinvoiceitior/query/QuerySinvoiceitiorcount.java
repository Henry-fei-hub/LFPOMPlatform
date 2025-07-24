package pomplatform.sinvoiceitior.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sinvoiceitior.bean.BaseSinvoiceitiorcount;
import pomplatform.sinvoiceitior.bean.ConditionSinvoiceitiorcount;

public class QuerySinvoiceitiorcount extends AbstractQuery<BaseSinvoiceitiorcount, ConditionSinvoiceitiorcount>
{

	private static final Logger __logger = Logger.getLogger(QuerySinvoiceitiorcount.class);

	public QuerySinvoiceitiorcount() throws java.sql.SQLException 
	{
		setParameterNumber(23);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("i.invoice_id");
	}

	@Override
	public BaseCollection<BaseSinvoiceitiorcount> executeQuery( KeyValuePair[] replacements, ConditionSinvoiceitiorcount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinSign(), 
				condition.getMaxSign(), 
				condition.getInvoiceId(), 
				condition.getTicketingCompany(), 
				condition.getInfoCode(), 
				condition.getProjectCode(), 
				condition.getContractCode(), 
				condition.getInvoiceType(), 
				condition.getDisableType(), 
				condition.getInvoiceExpressId(), 
				condition.getSign(), 
				condition.getCustomerId(), 
				condition.getInvoiceCode(), 
				condition.getInvoiceNumber(), 
				condition.getMinInStockDate(), 
				condition.getMaxInStockDate(), 
				condition.getMinInvoiceDate(), 
				condition.getMaxInvoiceDate(), 
				condition.getMinInvoiceAmount(), 
				condition.getMaxInvoiceAmount(), 
				condition.getContractId(), 
				condition.getContractName(),
				condition.getHaveVoucher()
			);
	}

	@Override
	public BaseSinvoiceitiorcount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSinvoiceitiorcount __base = new BaseSinvoiceitiorcount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInvoiceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTicketingCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInStockDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInvalidRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsInvalidOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStorageOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNoTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOutputTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBillingOperation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRegistrationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSign(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPrimaryInvoiceCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPrimaryInvoiceNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceExpressId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDisableType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[15]));
		if(args[16] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[16]));
		if(args[17] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[17]));
		if(args[18] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[18]));
		if(args[19] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[19]));
		if(args[20] != null) __statement.setInt(count++, GenericBase.__getInt(args[20]));
		if(args[21] != null) __statement.setString(count++, GenericBase.__getString(args[21]));
		if(args[22] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[22]));
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

	private final static String __SQLText = "SELECT i.invoice_id, i.ticketing_company, i.invoice_type, i.invoice_code, i.invoice_number, i.in_stock_date, i.invalid_remark, i.is_invalid_operator, i.storage_operator, ct.info_code, ct.project_code, CONCAT(CASE WHEN i.contract_id > 0 THEN ct.contract_code ELSE CASE WHEN i.contract_code ISNULL OR i.contract_code = '' THEN '无关联合同编号' ELSE i.contract_code END END )AS contract_code, i.customer_id, invoice_amount, tax_rate, no_tax_amount, output_tax, billing_operation, invoice_date, registration_date, sign, primary_invoice_code, primary_invoice_number, contract_receivable_id, invoice_express_id, disable_type, ct.contract_id, CONCAT(CASE WHEN i.contract_id > 0 THEN ct.contract_name ELSE '无关联' END) AS contract_name, CASE WHEN kv.link_id IS NULL THEN false ELSE true END AS have_voucher FROM invoices i LEFT JOIN contracts ct ON ct.contract_id = i.contract_id LEFT JOIN k3_vouchers kv on i.invoice_id = kv.link_id and kv.voucher_type = 2 WHERE i.sign BETWEEN ? AND ? AND i.invoice_id = ? AND ticketing_company = ? AND ct.info_code = ? AND ct.project_code = ? AND ct.contract_code = ? AND invoice_type = ? AND disable_type = ? AND invoice_express_id = ? AND sign = ? AND i.customer_id = ? AND invoice_code LIKE ? AND invoice_number LIKE ? AND in_stock_date BETWEEN ? AND ? AND invoice_date >= ? AND invoice_date < ? AND invoice_amount BETWEEN ? AND ? AND ct.contract_id = ? AND ct.contract_name LIKE ? group by i.invoice_id, i.ticketing_company, i.invoice_type, i.invoice_code, i.invoice_number, i.in_stock_date, i.invalid_remark, i.is_invalid_operator, i.storage_operator, ct.info_code, ct.project_code, ct.contract_code, ct.contract_id, kv.link_id HAVING i.have_voucher = ? ORDER BY ticketing_company,i.customer_id,sign,contract_code" ;
	private final static String RESULTSETFIELDLIST = "invoice_id,ticketing_company,invoice_type,invoice_code,invoice_number,in_stock_date,invalid_remark,is_invalid_operator,storage_operator,info_code,project_code,contract_code,customer_id,invoice_amount,tax_rate,no_tax_amount,output_tax,billing_operation,invoice_date,registration_date,sign,primary_invoice_code,primary_invoice_number,contract_receivable_id,invoice_express_id,disable_type,contract_id,contract_name,have_voucher";
	private final static String[] fieldNames = { "min_sign", "max_sign", "invoice_id", "ticketing_company", "info_code", "project_code", "contract_code", "invoice_type", "disable_type", "invoice_express_id", "sign", "customer_id", "invoice_code", "invoice_number", "min_in_stock_date", "max_in_stock_date", "min_invoice_date", "max_invoice_date", "min_invoice_amount", "max_invoice_amount", "contract_id", "contract_name", "have_voucher"};
}
