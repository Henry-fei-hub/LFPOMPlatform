package pomplatform.sinvoiceitior.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sinvoiceitior.bean.BaseSinvoiceitior;
import pomplatform.sinvoiceitior.bean.ConditionSinvoiceitior;

public class QuerySinvoiceitior extends AbstractQuery<BaseSinvoiceitior, ConditionSinvoiceitior>
{

	private static final Logger __logger = Logger.getLogger(QuerySinvoiceitior.class);

	public QuerySinvoiceitior() throws java.sql.SQLException 
	{
		setParameterNumber(19);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("invoice_id");
	}

	@Override
	public BaseCollection<BaseSinvoiceitior> executeQuery( KeyValuePair[] replacements, ConditionSinvoiceitior condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
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
				condition.getContractId()
			);
	}

	@Override
	public BaseSinvoiceitior generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSinvoiceitior __base = new BaseSinvoiceitior();
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[15]));
		if(args[16] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[16]));
		if(args[17] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
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

	private final static String __SQLText = "SELECT invoice_id, ticketing_company, invoice_type, invoice_code, invoice_number, in_stock_date, invalid_remark, is_invalid_operator, storage_operator, info_code, project_code, contract_code, customer_id, invoice_amount, tax_rate, no_tax_amount, output_tax, billing_operation, invoice_date, registration_date, sign, primary_invoice_code, primary_invoice_number, contract_receivable_id, invoice_express_id, disable_type, contract_id FROM invoices WHERE invoice_id = ? AND ticketing_company = ? AND info_code = ? AND project_code = ? AND contract_code = ? AND invoice_type = ? AND disable_type = ? AND invoice_express_id = ? AND sign = ? AND customer_id = ? AND invoice_code LIKE ? AND invoice_number LIKE ? AND in_stock_date between ? and ? AND invoice_date between ? and ? AND invoice_amount between ? and ? AND contract_id = ?" ;
	private final static String RESULTSETFIELDLIST = "invoice_id,ticketing_company,invoice_type,invoice_code,invoice_number,in_stock_date,invalid_remark,is_invalid_operator,storage_operator,info_code,project_code,contract_code,customer_id,invoice_amount,tax_rate,no_tax_amount,output_tax,billing_operation,invoice_date,registration_date,sign,primary_invoice_code,primary_invoice_number,contract_receivable_id,invoice_express_id,disable_type,contract_id";
	private final static String[] fieldNames = { "invoice_id", "ticketing_company", "info_code", "project_code", "contract_code", "invoice_type", "disable_type", "invoice_express_id", "sign", "customer_id", "invoice_code", "invoice_number", "min_in_stock_date", "max_in_stock_date", "min_invoice_date", "max_invoice_date", "min_invoice_amount", "max_invoice_amount", "contract_id"};
}
