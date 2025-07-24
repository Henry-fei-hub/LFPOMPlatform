package pomplatform.workflow.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.operation.bean.BaseOnLoadApplyListOfCostAllocation;
import pomplatform.workflow.operation.bean.ConditionOnLoadApplyListOfCostAllocation;

public class QueryOnLoadApplyListOfCostAllocation extends AbstractQuery<BaseOnLoadApplyListOfCostAllocation, ConditionOnLoadApplyListOfCostAllocation>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfCostAllocation.class);

	public QueryOnLoadApplyListOfCostAllocation() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfCostAllocation> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfCostAllocation condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getDrafter(), 
				condition.getCode(), 
				condition.getName(), 
				condition.getCost(), 
				condition.getCostType()
			);
	}

	@Override
	public BaseOnLoadApplyListOfCostAllocation generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfCostAllocation __base = new BaseOnLoadApplyListOfCostAllocation();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCostType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, rc.cost_type, rc.code, rc.name, rc.cost, rc.drafter,rc.reason FROM system_process_instances spi LEFT JOIN reset_costs rc on spi.business_id = rc.reset_cost_id WHERE spi.process_type = ? and spi.process_status in (0,1) and spi.delete_flag = 0 and rc.drafter = ? and rc.code like ? and rc.name like ? and rc.cost = ? and rc.cost_type =? order by spi.create_time" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,cost_type,code,name,cost,drafter,reason";
	private final static String[] fieldNames = { "process_type", "drafter", "code", "name", "cost", "cost_type"};
}
