package pomplatform.capatialandinvoice.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capatialandinvoice.bean.BaseCapitalAndInvoiceOne;
import pomplatform.capatialandinvoice.bean.ConditionCapitalAndInvoiceOne;

public class QueryCapitalAndInvoiceOne extends AbstractQuery<BaseCapitalAndInvoiceOne, ConditionCapitalAndInvoiceOne>
{

	private static final Logger __logger = Logger.getLogger(QueryCapitalAndInvoiceOne.class);

	public QueryCapitalAndInvoiceOne() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("C.capital_id");
	}

	@Override
	public BaseCollection<BaseCapitalAndInvoiceOne> executeQuery( KeyValuePair[] replacements, ConditionCapitalAndInvoiceOne condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId()
			);
	}

	@Override
	public BaseCapitalAndInvoiceOne generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCapitalAndInvoiceOne __base = new BaseCapitalAndInvoiceOne();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHasInvoices(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasContractReceivable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setHasDistributionCollection(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsHavingInvoice(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT C.capital_id, C.info_code, C.project_code, C.contract_id, C.contract_code, C.borrow_money, C.OPERATOR, C.has_invoices, C.has_contract_receivable, C.has_distribution_collection, C.process_status, C.capital_distribution_id, C.is_having_invoice, C.happen_date FROM capitals C WHERE C.contract_id =? AND C.capital_type = 1 ORDER BY C.happen_date" ;
	private final static String RESULTSETFIELDLIST = "capital_id,info_code,project_code,contract_id,contract_code,borrow_money,operator,has_invoices,has_contract_receivable,has_distribution_collection,process_status,capital_distribution_id,is_having_invoice,happen_date";
	private final static String[] fieldNames = { "contract_id"};
}
