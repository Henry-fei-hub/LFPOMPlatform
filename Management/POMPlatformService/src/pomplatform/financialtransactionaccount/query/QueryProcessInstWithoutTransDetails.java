package pomplatform.financialtransactionaccount.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.financialtransactionaccount.bean.BaseProcessInstWithoutTransDetails;
import pomplatform.financialtransactionaccount.bean.ConditionProcessInstWithoutTransDetails;

public class QueryProcessInstWithoutTransDetails extends AbstractQuery<BaseProcessInstWithoutTransDetails, ConditionProcessInstWithoutTransDetails>
{

	private static final Logger __logger = Logger.getLogger(QueryProcessInstWithoutTransDetails.class);

	public QueryProcessInstWithoutTransDetails() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("process_type");
	}

	@Override
	public BaseCollection<BaseProcessInstWithoutTransDetails> executeQuery( KeyValuePair[] replacements, ConditionProcessInstWithoutTransDetails condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getStartTime()
			);
	}

	@Override
	public BaseProcessInstWithoutTransDetails generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProcessInstWithoutTransDetails __base = new BaseProcessInstWithoutTransDetails();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
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

	private final static String __SQLText = "select process_type, business_id from system_process_instances where process_instance_id not in (select DISTINCT process_instance_id from financial_transaction_details) and process_status in (0,1,3) and delete_flag = 0 and process_type = ? and create_time >= ?" ;
	private final static String RESULTSETFIELDLIST = "process_type,business_id";
	private final static String[] fieldNames = { "process_type", "start_time"};
}
