package pomplatform.contractincome.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractincome.bean.BaseGetContractStageByInvoice;
import pomplatform.contractincome.bean.ConditionGetContractStageByInvoice;

public class QueryGetContractStageByInvoice extends AbstractQuery<BaseGetContractStageByInvoice, ConditionGetContractStageByInvoice>
{

	private static final Logger __logger = Logger.getLogger(QueryGetContractStageByInvoice.class);

	public QueryGetContractStageByInvoice() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("contract_receivable_id");
	}

	@Override
	public BaseCollection<BaseGetContractStageByInvoice> executeQuery( KeyValuePair[] replacements, ConditionGetContractStageByInvoice condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInvoiceId()
			);
	}

	@Override
	public BaseGetContractStageByInvoice generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetContractStageByInvoice __base = new BaseGetContractStageByInvoice();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractReceivableId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceivableName(GenericBase.__getString(val));
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

	private final static String __SQLText = "WITH RECURSIVE r AS ( SELECT contract_receivable_id, parent_id, receivable_name FROM contract_receivables WHERE contract_receivable_id in ( select c.contract_receivable_id from attachment_link_invoices a LEFT JOIN attachment_link_contract_receivables b on a.attachment_manage_id = b.attachment_manage_id and a.attachment_manage_id > 0 LEFT JOIN contract_receivables c on b.contract_receivable_id = c.contract_receivable_id where a.invoice_id = ? ) union SELECT cr.contract_receivable_id, cr.parent_id, cr.receivable_name FROM contract_receivables cr, r WHERE cr.contract_receivable_id = r.parent_id ) SELECT r.* FROM r ORDER BY r.contract_receivable_id, r.receivable_name" ;
	private final static String RESULTSETFIELDLIST = "contract_receivable_id,parent_id,receivable_name";
	private final static String[] fieldNames = { "invoice_id"};
}
