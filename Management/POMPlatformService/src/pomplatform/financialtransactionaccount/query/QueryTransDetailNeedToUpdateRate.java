package pomplatform.financialtransactionaccount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialtransactionaccount.bean.BaseTransDetailNeedToUpdateRate;
import pomplatform.financialtransactionaccount.bean.ConditionTransDetailNeedToUpdateRate;

public class QueryTransDetailNeedToUpdateRate extends AbstractQuery<BaseTransDetailNeedToUpdateRate, ConditionTransDetailNeedToUpdateRate>
{

	private static final Logger __logger = Logger.getLogger(QueryTransDetailNeedToUpdateRate.class);

	public QueryTransDetailNeedToUpdateRate() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.financial_transaction_detail_id");
	}

	@Override
	public BaseCollection<BaseTransDetailNeedToUpdateRate> executeQuery( KeyValuePair[] replacements, ConditionTransDetailNeedToUpdateRate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getIsCompleted(), 
				condition.getProcessStatus(), 
				condition.getDeleteFlag()
			);
	}

	@Override
	public BaseTransDetailNeedToUpdateRate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTransDetailNeedToUpdateRate __base = new BaseTransDetailNeedToUpdateRate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFinancialTransactionDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOriginalDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOriginalCredit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCurrencyType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
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

	private final static String __SQLText = "select a.financial_transaction_detail_id, a.original_debit, a.original_credit, a.currency_type, b.complete_time from financial_transaction_details a LEFT JOIN system_process_instances b on a.process_instance_id = b.process_instance_id where a.is_completed = ? and b.process_status = ? and a.delete_flag = ?" ;
	private final static String RESULTSETFIELDLIST = "financial_transaction_detail_id,original_debit,original_credit,currency_type,complete_time";
	private final static String[] fieldNames = { "is_completed", "process_status", "delete_flag"};
}
