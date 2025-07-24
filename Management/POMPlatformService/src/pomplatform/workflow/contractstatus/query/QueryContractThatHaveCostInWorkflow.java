package pomplatform.workflow.contractstatus.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.contractstatus.bean.BaseContractThatHaveCostInWorkflow;
import pomplatform.workflow.contractstatus.bean.ConditionContractThatHaveCostInWorkflow;

public class QueryContractThatHaveCostInWorkflow extends AbstractQuery<BaseContractThatHaveCostInWorkflow, ConditionContractThatHaveCostInWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryContractThatHaveCostInWorkflow.class);

	public QueryContractThatHaveCostInWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("l.contract_id from ( select k.contract_id");
	}

	@Override
	public BaseCollection<BaseContractThatHaveCostInWorkflow> executeQuery( KeyValuePair[] replacements, ConditionContractThatHaveCostInWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessTypeProjectNormal(), 
				condition.getDeleteFlag(), 
				condition.getContractId(), 
				condition.getProcessTypeProjectTravel(), 
				condition.getDeleteFlag(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseContractThatHaveCostInWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractThatHaveCostInWorkflow __base = new BaseContractThatHaveCostInWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "select l.contract_id from ( select k.contract_id, sum(num) as num from( (select a.contract_id, count(d.process_instance_id) as num from contracts a LEFT JOIN projects b on a.contract_id = b.contract_id LEFT JOIN normal_reimbursement_link_projects c on b.project_id = c.project_id LEFT JOIN system_process_instances d on d.process_type = ? and c.project_normal_reimbursement_id = d.business_id and d.delete_flag = ? and d.process_status in (0, 1) where a.contract_id = ? group by a.contract_id ) union all ( select a.contract_id, count(d.process_instance_id) as num from contracts a LEFT JOIN projects b on a.contract_id = b.contract_id LEFT JOIN travel_reimbursement_link_projects c on b.project_id = c.project_id LEFT JOIN system_process_instances d on d.process_type = ? and c.travel_reimbursement_id = d.business_id and d.delete_flag = ? and d.process_status in (0, 1) where a.contract_id = ? group by a.contract_id )) k group by k.contract_id) l where l.num > 0" ;
	private final static String RESULTSETFIELDLIST = "contract_id";
	private final static String[] fieldNames = { "process_type_project_normal", "delete_flag", "contract_id", "process_type_project_travel", "delete_flag", "contract_id"};
}
