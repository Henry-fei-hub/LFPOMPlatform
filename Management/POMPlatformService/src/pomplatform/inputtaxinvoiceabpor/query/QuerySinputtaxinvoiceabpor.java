package pomplatform.inputtaxinvoiceabpor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.inputtaxinvoiceabpor.bean.BaseSinputtaxinvoiceabpor;
import pomplatform.inputtaxinvoiceabpor.bean.ConditionSinputtaxinvoiceabpor;

public class QuerySinputtaxinvoiceabpor extends AbstractQuery<BaseSinputtaxinvoiceabpor, ConditionSinputtaxinvoiceabpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySinputtaxinvoiceabpor.class);

	public QuerySinputtaxinvoiceabpor() throws java.sql.SQLException 
	{
		setParameterNumber(13);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("iti.input_tax_invoice_id");
	}

	@Override
	public BaseCollection<BaseSinputtaxinvoiceabpor> executeQuery( KeyValuePair[] replacements, ConditionSinputtaxinvoiceabpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getRemark(), 
				condition.getSalesCode(), 
				condition.getSalesName(), 
				condition.getInputTaxInvoiceId(), 
				condition.getInvoiceType(), 
				condition.getInvoiceCode(), 
				condition.getInvoiceNumber(), 
				condition.getInvoiceAmount(), 
				condition.getTaxRate(), 
				condition.getOperator(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getHaveCheck()
			);
	}

	@Override
	public BaseSinputtaxinvoiceabpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSinputtaxinvoiceabpor __base = new BaseSinputtaxinvoiceabpor();
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[7]));
		if(args[8] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[12]));
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

	private final static String __SQLText = "select iti.input_tax_invoice_id, iti.invoice_type, iti.invoice_code, iti.invoice_number, iti.invoice_date, iti.invoice_amount, iti.tax_rate, iti.operator, iti.create_time, iti.remark, iti.other_remark, iti.sales_code, iti.tax_amount, iti.sales_name, iti.year, iti.month, iti.have_check from input_tax_invoices iti where iti.remark like ? and iti.sales_code like ? and iti.sales_name like ? and iti.input_tax_invoice_id = ? and iti.invoice_type = ? and iti.invoice_code like ? and iti.invoice_number like ? and iti.invoice_amount = ? and iti.tax_rate = ? and iti.operator = ? and iti.year = ? and iti.month = ? and iti.have_check = ? order by iti.invoice_code, iti.invoice_number" ;
	private final static String RESULTSETFIELDLIST = "input_tax_invoice_id,invoice_type,invoice_code,invoice_number,invoice_date,invoice_amount,tax_rate,operator,create_time,remark,other_remark,sales_code,tax_amount,sales_name,year,month,have_check";
	private final static String[] fieldNames = { "remark", "sales_code", "sales_name", "input_tax_invoice_id", "invoice_type", "invoice_code", "invoice_number", "invoice_amount", "tax_rate", "operator", "year", "month", "have_check"};
}
