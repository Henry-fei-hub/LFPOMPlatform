package pomplatform.capatialandinvoice.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capatialandinvoice.bean.BaseInvoiceReport;
import pomplatform.capatialandinvoice.bean.ConditionInvoiceReport;

public class QueryInvoiceReport extends AbstractQuery<BaseInvoiceReport, ConditionInvoiceReport>
{

	private static final Logger __logger = Logger.getLogger(QueryInvoiceReport.class);

	public QueryInvoiceReport() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.plate_id");
	}

	@Override
	public BaseCollection<BaseInvoiceReport> executeQuery( KeyValuePair[] replacements, ConditionInvoiceReport condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectManagerId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseInvoiceReport generateBase(Object[] __data) throws java.sql.SQLException {
		BaseInvoiceReport __base = new BaseInvoiceReport();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOne(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwo(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTree(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFour(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFive(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSix(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotal(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT e.plate_id,project_manager_id, SUM ( CASE WHEN ( CURRENT_DATE :: DATE ) :: DATE - ( invoice_date :: TIMESTAMP ) :: DATE <= 30 THEN invoice_amount ELSE 0.0 END ) one, SUM ( CASE WHEN ( CURRENT_DATE :: TIMESTAMP ) :: DATE - ( invoice_date :: TIMESTAMP ) :: DATE <= 60 AND ( CURRENT_DATE :: TIMESTAMP ) :: DATE - ( invoice_date :: TIMESTAMP ) :: DATE > 30 THEN invoice_amount ELSE 0.0 END ) two, SUM ( CASE WHEN ( CURRENT_DATE :: TIMESTAMP ) :: DATE - ( invoice_date :: TIMESTAMP ) :: DATE <= 90 AND ( CURRENT_DATE :: TIMESTAMP ) :: DATE - ( invoice_date :: TIMESTAMP ) :: DATE > 60 THEN invoice_amount ELSE 0.0 END ) tree, SUM ( CASE WHEN ( CURRENT_DATE :: TIMESTAMP ) :: DATE - ( invoice_date :: TIMESTAMP ) :: DATE <= 180 AND ( CURRENT_DATE :: TIMESTAMP ) :: DATE - ( invoice_date :: TIMESTAMP ) :: DATE > 90 THEN invoice_amount ELSE 0.0 END ) four, SUM ( CASE WHEN ( CURRENT_DATE :: TIMESTAMP ) :: DATE - ( invoice_date :: TIMESTAMP ) :: DATE <= 365 AND ( CURRENT_DATE :: TIMESTAMP ) :: DATE - ( invoice_date :: TIMESTAMP ) :: DATE > 180 THEN invoice_amount ELSE 0.0 END ) five, SUM ( CASE WHEN ( CURRENT_DATE :: TIMESTAMP ) :: DATE - ( invoice_date :: TIMESTAMP ) :: DATE > 365 THEN invoice_amount ELSE 0.0 END ) six, SUM ( invoice_amount ) total FROM invoices i LEFT JOIN employees e ON i.project_manager_id = e.employee_id WHERE project_manager_id =? AND e.plate_id =? AND ( is_capital IS NULL OR is_capital IN ( 2, 3 )) AND sign IN ( 1, 2 ) GROUP BY e.plate_id,project_manager_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,project_manager_id,one,two,tree,four,five,six,total";
	private final static String[] fieldNames = { "project_manager_id", "plate_id"};
}
