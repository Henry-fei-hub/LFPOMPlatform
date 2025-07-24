package pomplatform.Sprojectintegralsumrecordpysor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.Sprojectintegralsumrecordpysor.bean.BaseSprojectintegralsumrecordpysor;
import pomplatform.Sprojectintegralsumrecordpysor.bean.ConditionSprojectintegralsumrecordpysor;

public class QuerySprojectintegralsumrecordpysor extends AbstractQuery<BaseSprojectintegralsumrecordpysor, ConditionSprojectintegralsumrecordpysor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectintegralsumrecordpysor.class);

	public QuerySprojectintegralsumrecordpysor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("plate_id");
	}

	@Override
	public BaseCollection<BaseSprojectintegralsumrecordpysor> executeQuery( KeyValuePair[] replacements, ConditionSprojectintegralsumrecordpysor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getStartMonth(), 
				condition.getEndMonth()
			);
	}

	@Override
	public BaseSprojectintegralsumrecordpysor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectintegralsumrecordpysor __base = new BaseSprojectintegralsumrecordpysor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectIntegralSum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDistributedProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUndistributedProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnsureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettledProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnsettledProjectCost(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = " select plate_id,project_id,project_integral_sum,reserve_integral,project_integral,distributed_project_integral,undistributed_project_integral, sum(sure_integral) as sure_integral,unsure_integral,project_cost,sum(settled_project_cost) as settled_project_cost,unsettled_project_cost,sum(settlement_integral) as settlement_integral from project_integral_sum_records where plate_id = ? and year = ? and month >= ? and month <= ? group by plate_id,project_id,project_integral_sum,project_integral,reserve_integral,distributed_project_integral,undistributed_project_integral,unsure_integral,project_cost,unsettled_project_cost order by plate_id asc,project_id asc" ;
	private final static String RESULTSETFIELDLIST = "plate_id,project_id,project_integral_sum,reserve_integral,project_integral,distributed_project_integral,undistributed_project_integral,sure_integral,unsure_integral,project_cost,settled_project_cost,unsettled_project_cost,settlement_integral";
	private final static String[] fieldNames = { "plate_id", "year", "start_month", "end_month"};
}
