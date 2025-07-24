package pomplatform.contractincome.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractincome.bean.BaseGetInvoiceContactsInfo;
import pomplatform.contractincome.bean.ConditionGetInvoiceContactsInfo;

public class QueryGetInvoiceContactsInfo extends AbstractQuery<BaseGetInvoiceContactsInfo, ConditionGetInvoiceContactsInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryGetInvoiceContactsInfo.class);

	public QueryGetInvoiceContactsInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.customer_name");
	}

	@Override
	public BaseCollection<BaseGetInvoiceContactsInfo> executeQuery( KeyValuePair[] replacements, ConditionGetInvoiceContactsInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInvoiceId()
			);
	}

	@Override
	public BaseGetInvoiceContactsInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetInvoiceContactsInfo __base = new BaseGetInvoiceContactsInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLandline(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFax(GenericBase.__getString(val));
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

	private final static String __SQLText = "select c.customer_name, c.customer_phone, c.email, c.landline, c.fax from attachment_link_invoices a LEFT JOIN attachment_link_invoice_applys b on a.attachment_manage_id = b.attachment_manage_id LEFT JOIN invoice_apply c on b.invoice_apply_id = c.invoice_apply_id where a.invoice_id = ? and a.attachment_manage_id > 0" ;
	private final static String RESULTSETFIELDLIST = "customer_name,customer_phone,email,landline,fax";
	private final static String[] fieldNames = { "invoice_id"};
}
