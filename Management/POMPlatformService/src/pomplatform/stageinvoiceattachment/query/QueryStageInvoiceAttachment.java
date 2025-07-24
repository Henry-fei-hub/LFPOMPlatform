package pomplatform.stageinvoiceattachment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stageinvoiceattachment.bean.BaseStageInvoiceAttachment;
import pomplatform.stageinvoiceattachment.bean.ConditionStageInvoiceAttachment;

public class QueryStageInvoiceAttachment extends AbstractQuery<BaseStageInvoiceAttachment, ConditionStageInvoiceAttachment>
{

	private static final Logger __logger = Logger.getLogger(QueryStageInvoiceAttachment.class);

	public QueryStageInvoiceAttachment() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.invoice_amount");
	}

	@Override
	public BaseCollection<BaseStageInvoiceAttachment> executeQuery( KeyValuePair[] replacements, ConditionStageInvoiceAttachment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAttachmentManageId()
			);
	}

	@Override
	public BaseStageInvoiceAttachment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseStageInvoiceAttachment __base = new BaseStageInvoiceAttachment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNoTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInvoiceDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSign(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.invoice_amount,a.tax_rate,a.no_tax_amount,a.invoice_date,a.sign FROM attachment_link_invoices ai LEFT JOIN invoices a ON ai.invoice_id=a.invoice_id WHERE ai.attachment_manage_id=?" ;
	private final static String RESULTSETFIELDLIST = "invoice_amount,tax_rate,no_tax_amount,invoice_date,sign";
	private final static String[] fieldNames = { "attachment_manage_id"};
}
