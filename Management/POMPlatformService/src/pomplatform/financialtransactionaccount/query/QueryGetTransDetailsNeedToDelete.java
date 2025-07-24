package pomplatform.financialtransactionaccount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialtransactionaccount.bean.BaseGetTransDetailsNeedToDelete;
import pomplatform.financialtransactionaccount.bean.ConditionGetTransDetailsNeedToDelete;

public class QueryGetTransDetailsNeedToDelete extends AbstractQuery<BaseGetTransDetailsNeedToDelete, ConditionGetTransDetailsNeedToDelete>
{

	private static final Logger __logger = Logger.getLogger(QueryGetTransDetailsNeedToDelete.class);

	public QueryGetTransDetailsNeedToDelete() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.financial_transaction_detail_id");
	}

	@Override
	public BaseCollection<BaseGetTransDetailsNeedToDelete> executeQuery( KeyValuePair[] replacements, ConditionGetTransDetailsNeedToDelete condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTransDetailDeleteFlag(), 
				condition.getProcessStatus(), 
				condition.getSpiDeleteFlag()
			);
	}

	@Override
	public BaseGetTransDetailsNeedToDelete generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetTransDetailsNeedToDelete __base = new BaseGetTransDetailsNeedToDelete();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFinancialTransactionDetailId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select a.financial_transaction_detail_id from financial_transaction_details a LEFT JOIN system_process_instances b on a.process_instance_id = b.process_instance_id where a.delete_flag = ? and (b.process_status = ? or b.delete_flag = ?)" ;
	private final static String RESULTSETFIELDLIST = "financial_transaction_detail_id";
	private final static String[] fieldNames = { "trans_detail_delete_flag", "process_status", "spi_delete_flag"};
}
