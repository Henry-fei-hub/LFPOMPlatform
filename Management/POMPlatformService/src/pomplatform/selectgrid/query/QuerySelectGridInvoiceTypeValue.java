package pomplatform.selectgrid.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.selectgrid.bean.BaseSelectGridInvoiceTypeValue;
import pomplatform.selectgrid.bean.ConditionSelectGridInvoiceTypeValue;

public class QuerySelectGridInvoiceTypeValue extends AbstractQuery<BaseSelectGridInvoiceTypeValue, ConditionSelectGridInvoiceTypeValue>
{

	private static final Logger __logger = Logger.getLogger(QuerySelectGridInvoiceTypeValue.class);

	public QuerySelectGridInvoiceTypeValue() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("it.invoice_type_id");
	}

	@Override
	public BaseCollection<BaseSelectGridInvoiceTypeValue> executeQuery( KeyValuePair[] replacements, ConditionSelectGridInvoiceTypeValue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTypeName(), 
				condition.getSubtractRemark(), 
				condition.getInvoiceTypeId()
			);
	}

	@Override
	public BaseSelectGridInvoiceTypeValue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSelectGridInvoiceTypeValue __base = new BaseSelectGridInvoiceTypeValue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInvoiceTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubtractRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTaxRate(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "select it.invoice_type_id, it.type_name, it.subtract_remark, it.tax_rate, it.creator, it.create_time from invoice_types it where it.type_name like ? and it.subtract_remark like ? and it.invoice_type_id = ?" ;
	private final static String RESULTSETFIELDLIST = "invoice_type_id,type_name,subtract_remark,tax_rate,creator,create_time";
	private final static String[] fieldNames = { "type_name", "subtract_remark", "invoice_type_id"};
}
