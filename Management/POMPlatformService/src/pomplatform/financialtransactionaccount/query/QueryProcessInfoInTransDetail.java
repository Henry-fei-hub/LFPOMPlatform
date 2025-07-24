package pomplatform.financialtransactionaccount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialtransactionaccount.bean.BaseProcessInfoInTransDetail;
import pomplatform.financialtransactionaccount.bean.ConditionProcessInfoInTransDetail;

public class QueryProcessInfoInTransDetail extends AbstractQuery<BaseProcessInfoInTransDetail, ConditionProcessInfoInTransDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryProcessInfoInTransDetail.class);

	public QueryProcessInfoInTransDetail() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT process_type");
	}

	@Override
	public BaseCollection<BaseProcessInfoInTransDetail> executeQuery( KeyValuePair[] replacements, ConditionProcessInfoInTransDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDeleteFlag(), 
				condition.getIsCompleted()
			);
	}

	@Override
	public BaseProcessInfoInTransDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProcessInfoInTransDetail __base = new BaseProcessInfoInTransDetail();
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
		if(args[1] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[1]));
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

	private final static String __SQLText = "select DISTINCT process_type, business_id from financial_transaction_details where delete_flag = ? and is_completed = ?" ;
	private final static String RESULTSETFIELDLIST = "process_type,business_id";
	private final static String[] fieldNames = { "delete_flag", "is_completed"};
}
