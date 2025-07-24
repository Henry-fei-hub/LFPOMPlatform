package pomplatform.tmpcapitalsListItem.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.tmpcapitalsListItem.bean.BaseTmpcapitalstoinvoicecior;
import pomplatform.tmpcapitalsListItem.bean.ConditionTmpcapitalstoinvoicecior;

public class QueryTmpcapitalstoinvoicecior extends AbstractQuery<BaseTmpcapitalstoinvoicecior, ConditionTmpcapitalstoinvoicecior>
{

	private static final Logger __logger = Logger.getLogger(QueryTmpcapitalstoinvoicecior.class);

	public QueryTmpcapitalstoinvoicecior() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.happen_date");
	}

	@Override
	public BaseCollection<BaseTmpcapitalstoinvoicecior> executeQuery( KeyValuePair[] replacements, ConditionTmpcapitalstoinvoicecior condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInvoiceId()
			);
	}

	@Override
	public BaseTmpcapitalstoinvoicecior generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTmpcapitalstoinvoicecior __base = new BaseTmpcapitalstoinvoicecior();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStagePercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStageSumMoney(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select c.happen_date,cti.stage_percentage,cti.stage_sum_money from capitals_to_invoices cti,capitals c where c.capital_id=cti.capital_id and cti.invoice_id = ? ORDER BY c.happen_date" ;
	private final static String RESULTSETFIELDLIST = "happen_date,stage_percentage,stage_sum_money";
	private final static String[] fieldNames = { "invoice_id"};
}
