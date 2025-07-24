package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseOnPayMoneyManageBusiness;
import pomplatform.workflow.bean.ConditionOnPayMoneyManageBusiness;

public class QueryOnPayMoneyManageBusiness extends AbstractQuery<BaseOnPayMoneyManageBusiness, ConditionOnPayMoneyManageBusiness>
{

	private static final Logger __logger = Logger.getLogger(QueryOnPayMoneyManageBusiness.class);

	public QueryOnPayMoneyManageBusiness() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT receive_unit as idd");
	}

	@Override
	public BaseCollection<BaseOnPayMoneyManageBusiness> executeQuery( KeyValuePair[] replacements, ConditionOnPayMoneyManageBusiness condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getIdd(), 
				condition.getVal(), 
				condition.getBankAccount(), 
				condition.getBankName()
			);
	}

	@Override
	public BaseOnPayMoneyManageBusiness generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnPayMoneyManageBusiness __base = new BaseOnPayMoneyManageBusiness();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setIdd(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setVal(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "select DISTINCT receive_unit as idd,receive_unit as val,bank_account,bank_name from receive_unit_manages where receive_unit = ? and receive_unit like ? and bank_account = ? and bank_name = ? ORDER BY receive_unit" ;
	private final static String RESULTSETFIELDLIST = "idd,val,bank_account,bank_name";
	private final static String[] fieldNames = { "idd", "val", "bank_account", "bank_name"};
}
