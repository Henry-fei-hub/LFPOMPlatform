package pomplatform.sinvoiceitior.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sinvoiceitior.bean.BaseMinvoicettorunusecount;
import pomplatform.sinvoiceitior.bean.ConditionMinvoicettorunusecount;

public class QueryMinvoicettorunusecount extends AbstractQuery<BaseMinvoicettorunusecount, ConditionMinvoicettorunusecount>
{

	private static final Logger __logger = Logger.getLogger(QueryMinvoicettorunusecount.class);

	public QueryMinvoicettorunusecount() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ticketing_company");
	}

	@Override
	public BaseCollection<BaseMinvoicettorunusecount> executeQuery( KeyValuePair[] replacements, ConditionMinvoicettorunusecount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTicketingCompany(),
				condition.getTicketingCompany()
			);
	}

	@Override
	public BaseMinvoicettorunusecount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMinvoicettorunusecount __base = new BaseMinvoicettorunusecount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setTicketingCompany(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAllVal(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT ticketing_company, array_to_string( ARRAY ( SELECT count_value FROM ( SELECT ticketing_company, concat ( CASE WHEN invoice_type = 1 THEN '专票' WHEN invoice_type = 2 THEN '普票' WHEN invoice_type = 3 THEN '代开' END || ':' || COUNT (1) ) AS count_value FROM invoices WHERE sign = 0 AND ticketing_company = ? GROUP BY invoice_type, ticketing_company ORDER BY invoice_type) t2 WHERE t2.ticketing_company = t1.ticketing_company ), '   ' ) AS all_val FROM invoices t1 WHERE sign = 0 AND ticketing_company = ? GROUP BY ticketing_company " ;
	private final static String RESULTSETFIELDLIST = "ticketing_company,all_val";
	private final static String[] fieldNames = { "ticketing_company", "ticketing_company"};
}
