package pomplatform.workflow.contractstatus.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.contractstatus.bean.BaseContractWithoutSureIntegral;
import pomplatform.workflow.contractstatus.bean.ConditionContractWithoutSureIntegral;

public class QueryContractWithoutSureIntegral extends AbstractQuery<BaseContractWithoutSureIntegral, ConditionContractWithoutSureIntegral>
{

	private static final Logger __logger = Logger.getLogger(QueryContractWithoutSureIntegral.class);

	public QueryContractWithoutSureIntegral() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("m.contract_id from (select a.contract_id");
	}

	@Override
	public BaseCollection<BaseContractWithoutSureIntegral> executeQuery( KeyValuePair[] replacements, ConditionContractWithoutSureIntegral condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractStatus(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseContractWithoutSureIntegral generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractWithoutSureIntegral __base = new BaseContractWithoutSureIntegral();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select m.contract_id from (select a.contract_id, sum(c.total_amount) as sure_integral from contracts a LEFT JOIN projects b on a.contract_id = b.contract_id LEFT JOIN project_settlements c on b.project_id = c.project_id where a.contract_status = ? and c.settlement_date BETWEEN ? AND ? group by a.contract_id) m where m.sure_integral = 0" ;
	private final static String RESULTSETFIELDLIST = "contract_id";
	private final static String[] fieldNames = { "contract_status", "start_date", "end_date"};
}
