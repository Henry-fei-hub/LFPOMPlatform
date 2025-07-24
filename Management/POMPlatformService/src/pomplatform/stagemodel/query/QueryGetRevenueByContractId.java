package pomplatform.stagemodel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stagemodel.bean.BaseGetRevenueByContractId;
import pomplatform.stagemodel.bean.ConditionGetRevenueByContractId;

public class QueryGetRevenueByContractId extends AbstractQuery<BaseGetRevenueByContractId, ConditionGetRevenueByContractId>
{

	private static final Logger __logger = Logger.getLogger(QueryGetRevenueByContractId.class);

	public QueryGetRevenueByContractId() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("COALESCE(sum(current_revenue)");
	}

	@Override
	public BaseCollection<BaseGetRevenueByContractId> executeQuery( KeyValuePair[] replacements, ConditionGetRevenueByContractId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId()
			);
	}

	@Override
	public BaseGetRevenueByContractId generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetRevenueByContractId __base = new BaseGetRevenueByContractId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setRevenue(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select COALESCE(sum(current_revenue), 0) as revenue from revenue_statistical_records a LEFT JOIN projects b on a.project_id = b.project_id where b.contract_id = ? group by b.contract_id" ;
	private final static String RESULTSETFIELDLIST = "revenue";
	private final static String[] fieldNames = { "contract_id"};
}
