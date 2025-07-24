package pomplatform.capatialandinvoice.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capatialandinvoice.bean.BaseCapitalAndInvoiceTwo;
import pomplatform.capatialandinvoice.bean.ConditionCapitalAndInvoiceTwo;

public class QueryCapitalAndInvoiceTwo extends AbstractQuery<BaseCapitalAndInvoiceTwo, ConditionCapitalAndInvoiceTwo>
{

	private static final Logger __logger = Logger.getLogger(QueryCapitalAndInvoiceTwo.class);

	public QueryCapitalAndInvoiceTwo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("i.invoice_id");
	}

	@Override
	public BaseCollection<BaseCapitalAndInvoiceTwo> executeQuery( KeyValuePair[] replacements, ConditionCapitalAndInvoiceTwo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId()
			);
	}

	@Override
	public BaseCapitalAndInvoiceTwo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCapitalAndInvoiceTwo __base = new BaseCapitalAndInvoiceTwo();
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
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBillingOperation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRegistrationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSign(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAcknowledgeLetterId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsCapital(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT i.invoice_id, i.ticketing_company, i.invoice_type, i.invoice_code, i.invoice_number, i.in_stock_date, i.invalid_remark, i.is_invalid_operator, i.storage_operator, i.info_code, i.project_code, i.contract_id, i.contract_code, i.customer_id, i.invoice_amount, i.billing_operation, i.invoice_date, i.registration_date, i.sign, i.contract_receivable_id, i.acknowledge_letter_id, i.have_voucher, i.is_capital,i.capital_amount FROM invoices i where i.contract_id =? and i.sign in (1 , 2) ORDER BY i.invoice_date" ;
	private final static String RESULTSETFIELDLIST = "invoice_id,ticketing_company,invoice_type,invoice_code,invoice_number,in_stock_date,invalid_remark,is_invalid_operator,storage_operator,info_code,project_code,contract_id,contract_code,customer_id,invoice_amount,billing_operation,invoice_date,registration_date,sign,contract_receivable_id,acknowledge_letter_id,have_voucher,is_capital,capital_amount";
	private final static String[] fieldNames = { "contract_id"};
}
