package pomplatform.workflow.contractstatus.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.contractstatus.bean.BaseSelectContracts;
import pomplatform.workflow.contractstatus.bean.ConditionSelectContracts;

public class QuerySelectContracts extends AbstractQuery<BaseSelectContracts, ConditionSelectContracts>
{

	private static final Logger __logger = Logger.getLogger(QuerySelectContracts.class);

	public QuerySelectContracts() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("contract_id");
	}

	@Override
	public BaseCollection<BaseSelectContracts> executeQuery( KeyValuePair[] replacements, ConditionSelectContracts condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractStatus(), 
				condition.getContractSigningStatus(), 
				condition.getSendingDate()
			);
	}

	@Override
	public BaseSelectContracts generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSelectContracts __base = new BaseSelectContracts();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
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

	private final static String __SQLText = "select contract_id, contract_code, contract_name, contract_status from contracts where contract_status = ? and contract_signing_status = ? and sending_date <= ?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,contract_status";
	private final static String[] fieldNames = { "contract_status", "contract_signing_status", "sending_date"};
}
