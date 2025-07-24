package pomplatform.costallocation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.costallocation.bean.BaseCostAllocationApply;
import pomplatform.costallocation.bean.ConditionCostAllocationApply;

public class QueryCostAllocationApply extends AbstractQuery<BaseCostAllocationApply, ConditionCostAllocationApply>
{

	private static final Logger __logger = Logger.getLogger(QueryCostAllocationApply.class);

	public QueryCostAllocationApply() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rc.reset_cost_id");
	}

	@Override
	public BaseCollection<BaseCostAllocationApply> executeQuery( KeyValuePair[] replacements, ConditionCostAllocationApply condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getResetCostId()
			);
	}

	@Override
	public BaseCostAllocationApply generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCostAllocationApply __base = new BaseCostAllocationApply();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setResetCostId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLinkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select rc.reset_cost_id, rc.id, rc.code, rc.name, rc.cost, rc.link_id, rc.process_type, rc.business_id, rc.process_id, rc.process_instance_id, rc.drafter, rc.create_time, rc.delete_flag from reset_costs rc where rc.reset_cost_id = ?" ;
	private final static String RESULTSETFIELDLIST = "reset_cost_id,id,code,name,cost,link_id,process_type,business_id,process_id,process_instance_id,drafter,create_time,delete_flag";
	private final static String[] fieldNames = { "reset_cost_id"};
}
