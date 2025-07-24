package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseGetProjectAndSettlementIntegralByContract;
import pomplatform.project.bean.ConditionGetProjectAndSettlementIntegralByContract;

public class QueryGetProjectAndSettlementIntegralByContract extends AbstractQuery<BaseGetProjectAndSettlementIntegralByContract, ConditionGetProjectAndSettlementIntegralByContract>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjectAndSettlementIntegralByContract.class);

	public QueryGetProjectAndSettlementIntegralByContract() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.project_id");
	}

	@Override
	public BaseCollection<BaseGetProjectAndSettlementIntegralByContract> executeQuery( KeyValuePair[] replacements, ConditionGetProjectAndSettlementIntegralByContract condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId()
			);
	}

	@Override
	public BaseGetProjectAndSettlementIntegralByContract generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjectAndSettlementIntegralByContract __base = new BaseGetProjectAndSettlementIntegralByContract();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlementIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT p.project_id, p.project_integral, sum(ps.total_amount) as settlement_integral from projects p LEFT JOIN project_settlements ps on p.project_id = ps.project_id where p.project_id in (SELECT project_id from projects where contract_id = ?) GROUP BY p.project_id, p.project_integral" ;
	private final static String RESULTSETFIELDLIST = "project_id,project_integral,settlement_integral";
	private final static String[] fieldNames = { "contract_id"};
}
