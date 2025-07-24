package pomplatform.updatedata.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.updatedata.bean.BaseProjectSettlement;
import pomplatform.updatedata.bean.ConditionProjectSettlement;

public class QueryProjectSettlement extends AbstractQuery<BaseProjectSettlement, ConditionProjectSettlement>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectSettlement.class);

	public QueryProjectSettlement() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("* from ( select sum(a.total_amount) as settlement");
	}

	@Override
	public BaseCollection<BaseProjectSettlement> executeQuery( KeyValuePair[] replacements, ConditionProjectSettlement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId()
			);
	}

	@Override
	public BaseProjectSettlement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectSettlement __base = new BaseProjectSettlement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSettlement(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlementDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT * from ( select sum(a.total_amount) as settlement, a.settlement_date from project_settlements a LEFT JOIN projects b on a.project_id = b.project_id where b.contract_id = ? group by a.settlement_date) a where a.settlement > 0 order by settlement_date" ;
	private final static String RESULTSETFIELDLIST = "settlement,settlement_date";
	private final static String[] fieldNames = { "contract_id"};
}
