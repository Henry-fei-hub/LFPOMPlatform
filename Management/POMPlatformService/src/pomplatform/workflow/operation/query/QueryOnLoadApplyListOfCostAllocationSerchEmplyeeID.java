package pomplatform.workflow.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.operation.bean.BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID;
import pomplatform.workflow.operation.bean.ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID;

public class QueryOnLoadApplyListOfCostAllocationSerchEmplyeeID extends AbstractQuery<BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID, ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfCostAllocationSerchEmplyeeID.class);

	public QueryOnLoadApplyListOfCostAllocationSerchEmplyeeID() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType()
			);
	}

	@Override
	public BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID __base = new BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT spi.employee_id FROM system_process_instances spi WHERE spi.process_type=?" ;
	private final static String RESULTSETFIELDLIST = "employee_id";
	private final static String[] fieldNames = { "process_type"};
}
