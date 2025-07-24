package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseGetRunningReimbursementAmountByContract;
import pomplatform.project.bean.ConditionGetRunningReimbursementAmountByContract;

public class QueryGetRunningReimbursementAmountByContract extends AbstractQuery<BaseGetRunningReimbursementAmountByContract, ConditionGetRunningReimbursementAmountByContract>
{

	private static final Logger __logger = Logger.getLogger(QueryGetRunningReimbursementAmountByContract.class);

	public QueryGetRunningReimbursementAmountByContract() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("count(*) as amount from system_process_instances where delete_flag = 0 and process_status in (0");
	}

	@Override
	public BaseCollection<BaseGetRunningReimbursementAmountByContract> executeQuery( KeyValuePair[] replacements, ConditionGetRunningReimbursementAmountByContract condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseGetRunningReimbursementAmountByContract generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetRunningReimbursementAmountByContract __base = new BaseGetRunningReimbursementAmountByContract();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT count(*) as amount from system_process_instances where delete_flag = 0 and process_status in (0, 1) and ((process_type in (2,3) and business_id in (SELECT DISTINCT project_normal_reimbursement_id from normal_reimbursement_link_projects where project_id in (SELECT project_id from projects where contract_id = ?))) or (process_type in (4,5) and business_id in (SELECT DISTINCT travel_reimbursement_id from travel_reimbursement_link_projects where project_id in (SELECT project_id from projects where contract_id = ?))))" ;
	private final static String RESULTSETFIELDLIST = "amount";
	private final static String[] fieldNames = { "contract_id", "contract_id"};
}
