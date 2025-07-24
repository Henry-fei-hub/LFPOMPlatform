package pomplatform.inputtaxinvoiceabpor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.inputtaxinvoiceabpor.bean.BaseMinputtaxinvoicelinkfinancesippciiymssor;
import pomplatform.inputtaxinvoiceabpor.bean.ConditionMinputtaxinvoicelinkfinancesippciiymssor;

public class QueryMinputtaxinvoicelinkfinancesippciiymssor extends AbstractQuery<BaseMinputtaxinvoicelinkfinancesippciiymssor, ConditionMinputtaxinvoicelinkfinancesippciiymssor>
{

	private static final Logger __logger = Logger.getLogger(QueryMinputtaxinvoicelinkfinancesippciiymssor.class);

	public QueryMinputtaxinvoicelinkfinancesippciiymssor() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT	iti.input_tax_invoice_id");
	}

	@Override
	public BaseCollection<BaseMinputtaxinvoicelinkfinancesippciiymssor> executeQuery( KeyValuePair[] replacements, ConditionMinputtaxinvoicelinkfinancesippciiymssor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessStatus(), 
				condition.getProcessStatus(), 
				condition.getCompanyId(), 
				condition.getInvoiceCode(), 
				condition.getInvoiceNumber(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getSalesCode(), 
				condition.getSalesName(), 
				condition.getCode()
			);
	}

	@Override
	public BaseMinputtaxinvoicelinkfinancesippciiymssor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMinputtaxinvoicelinkfinancesippciiymssor __base = new BaseMinputtaxinvoicelinkfinancesippciiymssor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalesCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalesName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHaveCheck(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRcode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTaxAmountCl(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmountCl(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsComplete(GenericBase.__getBoolean(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
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

	private final static String __SQLText = "SELECT DISTINCT iti.input_tax_invoice_id, iti.invoice_type, iti.invoice_code, iti.invoice_number, iti.invoice_date, iti.invoice_amount, iti.tax_rate, iti.operator, iti.create_time, iti.remark, iti.other_remark, iti.sales_code, iti.tax_amount, iti.sales_name, iti.year, iti.month, iti.have_check, array_to_string( ARRAY ( SELECT code FROM input_tax_invoice_link_finances itilf LEFT JOIN system_process_instances spi ON itilf.process_type = spi.process_type AND itilf.business_id = spi.business_id WHERE itilf.invoice_number = iti.invoice_number AND itilf.invoice_code = iti.invoice_code AND (itilf.process_type ISNULL OR (spi.delete_flag = 0 AND spi.process_status = ?)) ORDER BY itilf.input_tax_invoice_link_finance_id ), ',' ) AS rcode, itic.company_id, itic.tax_amount_cl, itic.invoice_amount_cl, CASE WHEN itic.tax_amount_cl = iti.tax_amount THEN TRUE ELSE FALSE END AS is_complete FROM input_tax_invoices iti LEFT JOIN ( SELECT i.company_id, i.invoice_code, i.invoice_number, SUM (tax_amount) AS tax_amount_cl, SUM (invoice_amount) AS invoice_amount_cl FROM input_tax_invoice_link_finances i LEFT JOIN system_process_instances spi ON i.process_type = spi.process_type AND i.business_id = spi.business_id WHERE (i.process_type ISNULL OR (spi.delete_flag = 0 AND spi.process_status = ?)) GROUP BY i.company_id, i.invoice_code, i.invoice_number ) itic ON iti.invoice_number = itic.invoice_number AND iti.invoice_code = itic.invoice_code LEFT JOIN input_tax_invoice_link_finances iticcl ON iticcl.invoice_code = iti.invoice_code AND iticcl.invoice_number = iti.invoice_number WHERE itic.company_id = ? AND iti.invoice_code LIKE ? AND iti.invoice_number LIKE ? AND iti.year = ? AND iti.month = ? AND iti.sales_code LIKE ? AND iti.sales_name LIKE ? AND iticcl.code = ?" ;
	private final static String RESULTSETFIELDLIST = "input_tax_invoice_id,invoice_type,invoice_code,invoice_number,invoice_date,invoice_amount,tax_rate,operator,create_time,remark,other_remark,sales_code,tax_amount,sales_name,year,month,have_check,rcode,company_id,tax_amount_cl,invoice_amount_cl,is_complete";
	private final static String[] fieldNames = { "process_status", "process_status", "company_id", "invoice_code", "invoice_number", "year", "month", "sales_code", "sales_name", "code"};
}
