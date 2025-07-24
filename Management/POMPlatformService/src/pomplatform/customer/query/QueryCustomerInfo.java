package pomplatform.customer.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.customer.bean.BaseCustomerInfo;
import pomplatform.customer.bean.ConditionCustomerInfo;

public class QueryCustomerInfo extends AbstractQuery<BaseCustomerInfo, ConditionCustomerInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryCustomerInfo.class);

	public QueryCustomerInfo() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.customer_id");
	}

	@Override
	public BaseCollection<BaseCustomerInfo> executeQuery( KeyValuePair[] replacements, ConditionCustomerInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCustomerName()
			);
	}

	@Override
	public BaseCustomerInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCustomerInfo __base = new BaseCustomerInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
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

	private final static String __SQLText = "select c.customer_id, c.customer_name, c.create_time from customers c where c.customer_name like ?" ;
	private final static String RESULTSETFIELDLIST = "customer_id,customer_name,create_time";
	private final static String[] fieldNames = { "customer_name"};
}
