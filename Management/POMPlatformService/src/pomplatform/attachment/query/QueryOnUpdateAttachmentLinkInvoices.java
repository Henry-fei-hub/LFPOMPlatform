package pomplatform.attachment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachment.bean.BaseOnUpdateAttachmentLinkInvoices;
import pomplatform.attachment.bean.ConditionOnUpdateAttachmentLinkInvoices;

public class QueryOnUpdateAttachmentLinkInvoices extends AbstractQuery<BaseOnUpdateAttachmentLinkInvoices, ConditionOnUpdateAttachmentLinkInvoices>
{

	private static final Logger __logger = Logger.getLogger(QueryOnUpdateAttachmentLinkInvoices.class);

	public QueryOnUpdateAttachmentLinkInvoices() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.invoice_id");
	}

	@Override
	public BaseCollection<BaseOnUpdateAttachmentLinkInvoices> executeQuery( KeyValuePair[] replacements, ConditionOnUpdateAttachmentLinkInvoices condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAttachmentManageId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseOnUpdateAttachmentLinkInvoices generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnUpdateAttachmentLinkInvoices __base = new BaseOnUpdateAttachmentLinkInvoices();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInvoiceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTicketingCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNoTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOutputTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setFlagType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSign(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBindAmount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setForAmount(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.invoice_id, a.invoice_type, a.invoice_code, a.invoice_number, a.ticketing_company, a.customer_id, a.invoice_amount, a.tax_rate, a.no_tax_amount, a.output_tax, a.invoice_date, CASE WHEN ( SELECT COUNT (*) AS COUNT FROM attachment_link_invoices WHERE invoice_id = a.invoice_id AND attachment_manage_id = ? ) > 0 THEN 2 ELSE 1 END AS flag_type, a.sign, b.bind_amount, CASE WHEN cc.for_amount > 0 THEN 1 ELSE 0 END AS for_amount FROM invoices A LEFT JOIN ( SELECT ali.invoice_id, COUNT (1) AS bind_amount FROM attachment_link_invoices ali LEFT JOIN system_process_instances spi ON spi.business_id = ali.personnel_business_id AND spi.process_type = 27 WHERE spi.process_status IN (0, 1, 3) GROUP BY ali.invoice_id ) b ON b.invoice_id = a.invoice_id LEFT JOIN ( SELECT primary_invoice_code, primary_invoice_number, COUNT (1) AS for_amount FROM invoices GROUP BY primary_invoice_code, primary_invoice_number ) cc ON cc.primary_invoice_code = a.invoice_code AND cc.primary_invoice_number = a.invoice_number WHERE a.contract_id = ? ORDER BY a.invoice_date" ;
	private final static String RESULTSETFIELDLIST = "invoice_id,invoice_type,invoice_code,invoice_number,ticketing_company,customer_id,invoice_amount,tax_rate,no_tax_amount,output_tax,invoice_date,flag_type,sign,bind_amount,for_amount";
	private final static String[] fieldNames = { "attachment_manage_id", "contract_id"};
}
