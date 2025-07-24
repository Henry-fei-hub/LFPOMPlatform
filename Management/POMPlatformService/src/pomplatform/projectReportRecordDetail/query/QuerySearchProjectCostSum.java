package pomplatform.projectReportRecordDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectReportRecordDetail.bean.BaseSearchProjectCostSum;
import pomplatform.projectReportRecordDetail.bean.ConditionSearchProjectCostSum;

public class QuerySearchProjectCostSum extends AbstractQuery<BaseSearchProjectCostSum, ConditionSearchProjectCostSum>
{

	private static final Logger __logger = Logger.getLogger(QuerySearchProjectCostSum.class);

	public QuerySearchProjectCostSum() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseSearchProjectCostSum> executeQuery( KeyValuePair[] replacements, ConditionSearchProjectCostSum condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseSearchProjectCostSum generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSearchProjectCostSum __base = new BaseSearchProjectCostSum();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCostType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT employee_id,sum(amount) as amount,cost_type,cost_date,process_type,business_id,process_id,process_instance_id FROM project_cost WHERE project_id = ? GROUP BY process_instance_id,employee_id,cost_type,cost_date,process_type,business_id,process_id,process_instance_id ORDER BY cost_date" ;
	private final static String RESULTSETFIELDLIST = "employee_id,amount,cost_type,cost_date,process_type,business_id,process_id,process_instance_id";
	private final static String[] fieldNames = { "project_id"};
}
