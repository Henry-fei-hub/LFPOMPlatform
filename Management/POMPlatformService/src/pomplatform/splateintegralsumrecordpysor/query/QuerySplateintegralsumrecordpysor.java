package pomplatform.splateintegralsumrecordpysor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.splateintegralsumrecordpysor.bean.BaseSplateintegralsumrecordpysor;
import pomplatform.splateintegralsumrecordpysor.bean.ConditionSplateintegralsumrecordpysor;

public class QuerySplateintegralsumrecordpysor extends AbstractQuery<BaseSplateintegralsumrecordpysor, ConditionSplateintegralsumrecordpysor>
{

	private static final Logger __logger = Logger.getLogger(QuerySplateintegralsumrecordpysor.class);

	public QuerySplateintegralsumrecordpysor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("plate_id");
	}

	@Override
	public BaseCollection<BaseSplateintegralsumrecordpysor> executeQuery( KeyValuePair[] replacements, ConditionSplateintegralsumrecordpysor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getStartMonth(), 
				condition.getEndMonth()
			);
	}

	@Override
	public BaseSplateintegralsumrecordpysor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSplateintegralsumrecordpysor __base = new BaseSplateintegralsumrecordpysor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegralSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCostIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlementIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalaryIntegral(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select plate_id,sum(achieve_integral) as achieve_integral,project_integral_sum,project_integral,reserve_integral, sum(sure_integral) as sure_integral,sum(cost_integral) as cost_integral,sum(settlement_integral) as settlement_integral,sum(salary_integral) as salary_integral from plate_integral_sum_records where plate_id = ? and year = ? and month >= ? and month <= ? group by plate_id,project_integral_sum,project_integral,reserve_integral order by plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,achieve_integral,project_integral_sum,project_integral,reserve_integral,sure_integral,cost_integral,settlement_integral,salary_integral";
	private final static String[] fieldNames = { "plate_id", "year", "start_month", "end_month"};
}
