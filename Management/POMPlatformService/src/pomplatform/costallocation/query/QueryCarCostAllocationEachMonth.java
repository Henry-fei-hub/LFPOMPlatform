package pomplatform.costallocation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.costallocation.bean.BaseCarCostAllocationEachMonth;
import pomplatform.costallocation.bean.ConditionCarCostAllocationEachMonth;

public class QueryCarCostAllocationEachMonth extends AbstractQuery<BaseCarCostAllocationEachMonth, ConditionCarCostAllocationEachMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryCarCostAllocationEachMonth.class);

	public QueryCarCostAllocationEachMonth() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("1 as year");
	}

	@Override
	public BaseCollection<BaseCarCostAllocationEachMonth> executeQuery( KeyValuePair[] replacements, ConditionCarCostAllocationEachMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCostType(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseCarCostAllocationEachMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCarCostAllocationEachMonth __base = new BaseCarCostAllocationEachMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT extract( year from c.complete_time) as year, extract(month from c.complete_time) as month, a.start_date_detail, b.id, b.code, b.name, sum(b.cost_allocation) as cost from personnel_business a LEFT JOIN car_cost_allocations b on a.personnel_business_id = b.personnel_business_id LEFT JOIN system_process_instances c on a.personnel_business_id = c.business_id and a.process_type = c.process_type where c.process_status = 3 and c.delete_flag = 0 and a.is_remote_city = true and a.process_type = 33 and a.start_date_detail = ? and c.complete_time >= ? and c.complete_time < ? group by year, month, a.start_date_detail, b.id, b.code, b.name" ;
	private final static String RESULTSETFIELDLIST = "year,month,start_date_detail,id,code,name,cost";
	private final static String[] fieldNames = { "cost_type", "start_time", "end_time"};
}
