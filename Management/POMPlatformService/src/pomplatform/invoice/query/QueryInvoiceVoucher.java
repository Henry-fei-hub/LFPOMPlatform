package pomplatform.invoice.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.invoice.bean.BaseInvoiceVoucher;
import pomplatform.invoice.bean.ConditionInvoiceVoucher;

public class QueryInvoiceVoucher extends AbstractQuery<BaseInvoiceVoucher, ConditionInvoiceVoucher>
{

	private static final Logger __logger = Logger.getLogger(QueryInvoiceVoucher.class);

	public QueryInvoiceVoucher() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.invoice_id");
	}

	@Override
	public BaseCollection<BaseInvoiceVoucher> executeQuery( KeyValuePair[] replacements, ConditionInvoiceVoucher condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInvoiceId()
			);
	}

	@Override
	public BaseInvoiceVoucher generateBase(Object[] __data) throws java.sql.SQLException {
		BaseInvoiceVoucher __base = new BaseInvoiceVoucher();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInvoiceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNoTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOutputTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInvalidRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT a.invoice_id, b.contract_name, a.customer_id, c.customer_name, a.invoice_amount, a.tax_rate, a.no_tax_amount, a.output_tax, a.invoice_date, a.invalid_remark, a.ticketing_company as company_id, a.invoice_number from invoices a LEFT JOIN contracts b on a.contract_id = b.contract_id LEFT JOIN customers c on a.customer_id = c.customer_id where a.invoice_id = ? and a.sign in (1,2)" ;
	private final static String RESULTSETFIELDLIST = "invoice_id,contract_name,customer_id,customer_name,invoice_amount,tax_rate,no_tax_amount,output_tax,invoice_date,invalid_remark,company_id,invoice_number";
	private final static String[] fieldNames = { "invoice_id"};
}
