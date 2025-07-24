package pomplatform.contract.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseScontractccor;
import pomplatform.contract.bean.ConditionScontractccor;

public class QueryScontractccor extends AbstractQuery<BaseScontractccor, ConditionScontractccor>
{

	private static final Logger __logger = Logger.getLogger(QueryScontractccor.class);

	public QueryScontractccor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.contract_id");
	}

	@Override
	public BaseCollection<BaseScontractccor> executeQuery( KeyValuePair[] replacements, ConditionScontractccor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractName(), 
				condition.getContractCode()
			);
	}

	@Override
	public BaseScontractccor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScontractccor __base = new BaseScontractccor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, (java.lang.String)args[0]);
		if(args[1] != null) __statement.setString(count++, (java.lang.String)args[1]);
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

	private final static String __SQLText = "select c.contract_id, c.contract_code, c.contract_name, c.customer_name, c.start_date, c.end_date,c.status from contracts c where c.contract_name like ? and c.contract_code = ?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,start_date,end_date,status";
	private final static String[] fieldNames = { "contract_name", "contract_code"};
}
