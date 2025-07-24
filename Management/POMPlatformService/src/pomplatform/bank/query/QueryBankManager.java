package pomplatform.bank.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bank.bean.BaseBankManager;
import pomplatform.bank.bean.ConditionBankManager;

public class QueryBankManager extends AbstractQuery<BaseBankManager, ConditionBankManager>
{

	private static final Logger __logger = Logger.getLogger(QueryBankManager.class);

	public QueryBankManager() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.bank_id");
	}

	@Override
	public BaseCollection<BaseBankManager> executeQuery( KeyValuePair[] replacements, ConditionBankManager condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBankName()
			);
	}

	@Override
	public BaseBankManager generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBankManager __base = new BaseBankManager();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBankId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOrderNum(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select b.bank_id, b.bank_name, b.order_num, b.create_time from banks b where bank_name like ?" ;
	private final static String RESULTSETFIELDLIST = "bank_id,bank_name,order_num,create_time";
	private final static String[] fieldNames = { "bank_name"};
}
