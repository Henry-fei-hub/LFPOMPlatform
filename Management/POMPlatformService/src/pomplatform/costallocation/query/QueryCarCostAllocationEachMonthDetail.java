package pomplatform.costallocation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.costallocation.bean.BaseCarCostAllocationEachMonthDetail;
import pomplatform.costallocation.bean.ConditionCarCostAllocationEachMonthDetail;

public class QueryCarCostAllocationEachMonthDetail extends AbstractQuery<BaseCarCostAllocationEachMonthDetail, ConditionCarCostAllocationEachMonthDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryCarCostAllocationEachMonthDetail.class);

	public QueryCarCostAllocationEachMonthDetail() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.drafter");
	}

	@Override
	public BaseCollection<BaseCarCostAllocationEachMonthDetail> executeQuery( KeyValuePair[] replacements, ConditionCarCostAllocationEachMonthDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCostType(), 
				condition.getStartTime(), 
				condition.getEndTime(),
				condition.getId()
			);
	}

	@Override
	public BaseCarCostAllocationEachMonthDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCarCostAllocationEachMonthDetail __base = new BaseCarCostAllocationEachMonthDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCostAllocation(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.drafter, a.project_code, a.start_date_detail, b.id, b.code, b.name, c.complete_time, b.cost_allocation, c.process_id, c.process_instance_id, c.process_type, c.business_id from personnel_business a LEFT JOIN car_cost_allocations b on a.personnel_business_id = b.personnel_business_id LEFT JOIN system_process_instances c on a.personnel_business_id = c.business_id and a.process_type = c.process_type where c.process_status = 3 and c.delete_flag = 0 and a.is_remote_city = true and a.process_type = 33 and a.start_date_detail = ? and c.complete_time >= ? and c.complete_time < ? and b.id = ? ORDER by c.complete_time, a.start_date_detail" ;
	private final static String RESULTSETFIELDLIST = "drafter,project_code,start_date_detail,id,code,name,complete_time,cost_allocation,process_id,process_instance_id,process_type,business_id";
	private final static String[] fieldNames = { "cost_type", "start_time", "end_time", "id"};
}
