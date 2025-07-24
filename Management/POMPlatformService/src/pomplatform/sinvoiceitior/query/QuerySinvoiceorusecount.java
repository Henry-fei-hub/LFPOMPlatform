package pomplatform.sinvoiceitior.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sinvoiceitior.bean.BaseSinvoiceorusecount;
import pomplatform.sinvoiceitior.bean.ConditionSinvoiceorusecount;

public class QuerySinvoiceorusecount extends AbstractQuery<BaseSinvoiceorusecount, ConditionSinvoiceorusecount>
{

	private static final Logger __logger = Logger.getLogger(QuerySinvoiceorusecount.class);

	public QuerySinvoiceorusecount() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("'' AS in_name");
	}

	@Override
	public BaseCollection<BaseSinvoiceorusecount> executeQuery( KeyValuePair[] replacements, ConditionSinvoiceorusecount condition ) throws java.sql.SQLException {
		return executeQuery(replacements
			);
	}

	@Override
	public BaseSinvoiceorusecount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSinvoiceorusecount __base = new BaseSinvoiceorusecount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAllSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeventeen(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSix(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFive(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOther(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveOne(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveTwo(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveThree(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT '' AS in_name, invoice_amount AS all_sum, invoice_amount AS seventeen, invoice_amount AS six, invoice_amount AS five, invoice_amount AS other, invoice_amount AS reserve_one, invoice_amount AS reserve_two, '' AS reserve_three FROM invoices" ;
	private final static String RESULTSETFIELDLIST = "in_name,all_sum,seventeen,six,five,other,reserve_one,reserve_two,reserve_three";
	private final static String[] fieldNames = { };
}
