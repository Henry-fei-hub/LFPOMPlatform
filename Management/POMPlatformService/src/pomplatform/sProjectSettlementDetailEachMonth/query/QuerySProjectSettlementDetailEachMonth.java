package pomplatform.sProjectSettlementDetailEachMonth.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sProjectSettlementDetailEachMonth.bean.BaseSProjectSettlementDetailEachMonth;
import pomplatform.sProjectSettlementDetailEachMonth.bean.ConditionSProjectSettlementDetailEachMonth;

public class QuerySProjectSettlementDetailEachMonth extends AbstractQuery<BaseSProjectSettlementDetailEachMonth, ConditionSProjectSettlementDetailEachMonth>
{

	private static final Logger __logger = Logger.getLogger(QuerySProjectSettlementDetailEachMonth.class);

	public QuerySProjectSettlementDetailEachMonth() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseSProjectSettlementDetailEachMonth> executeQuery( KeyValuePair[] replacements, ConditionSProjectSettlementDetailEachMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseSProjectSettlementDetailEachMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSProjectSettlementDetailEachMonth __base = new BaseSProjectSettlementDetailEachMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRealAmount(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
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

	private final static String __SQLText = "select a.employee_id, extract(year from a.settlement_date) as settlement_year, extract(month from a.settlement_date) as settlement_month, sum(a.real_amount) as real_amount from project_settlement_details a where a.real_amount <> 0 and a.settlement_date >= ? and a.settlement_date <= ? and a.employee_id = ? group by a.employee_id, settlement_year, settlement_month order by a.employee_id, settlement_year, settlement_month" ;
	private final static String RESULTSETFIELDLIST = "employee_id,settlement_year,settlement_month,real_amount";
	private final static String[] fieldNames = { "start_date", "end_date", "employee_id"};
}
