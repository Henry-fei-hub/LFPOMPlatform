package pomplatform.plateCostRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateCostRecord.bean.BaseReimbursementCost;
import pomplatform.plateCostRecord.bean.ConditionReimbursementCost;

public class QueryReimbursementCost extends AbstractQuery<BaseReimbursementCost, ConditionReimbursementCost>
{

	private static final Logger __logger = Logger.getLogger(QueryReimbursementCost.class);

	public QueryReimbursementCost() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.process_id");
	}

	@Override
	public BaseCollection<BaseReimbursementCost> executeQuery( KeyValuePair[] replacements, ConditionReimbursementCost condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getProcessType(), 
				condition.getBusinessId()
			);
	}

	@Override
	public BaseReimbursementCost generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReimbursementCost __base = new BaseReimbursementCost();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLinkedId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "(select b.process_id, b.process_instance_id, b.process_type, b.business_id, b.employee_id, b.complete_time as cost_date, b.business_name as remark, a.project_id as linked_id, a.final_amount as cost from normal_reimbursement_link_projects a LEFT JOIN system_process_instances b on a.project_normal_reimbursement_id = b.business_id and b.process_type = 2 where b.process_type = ? and b.business_id = ?) UNION (SELECT b.process_id, b.process_instance_id, b.process_type, b.business_id, b.employee_id, b.complete_time as cost_date, b.business_name as remark, a.project_id as linked_id, a.final_amount as cost from travel_reimbursement_link_projects a LEFT JOIN system_process_instances b on a.travel_reimbursement_id = b.business_id and b.process_type = ? where b.process_type = 4 and b.business_id = ?) UNION (SELECT b.process_id, b.process_instance_id, b.process_type, b.business_id, b.employee_id, b.complete_time as cost_date, b.business_name as remark, c.plate_id as linked_id, a.final_amount as cost from normal_reimbursement_link_departments a LEFT JOIN system_process_instances b on a.project_normal_reimbursement_id = b.business_id and b.process_type in (3,10) LEFT JOIN departments c on a.department_id = c.department_id where b.process_type = ? and b.business_id =?) UNION (SELECT b.process_id, b.process_instance_id, b.process_type, b.business_id, b.employee_id, b.complete_time as cost_date, b.business_name as remark, c.plate_id as linked_id, a.final_amount as cost from travel_reimbursement_link_departments a LEFT JOIN system_process_instances b on a.travel_reimbursement_id = b.business_id and b.process_type = 5 LEFT JOIN departments c on a.department_id = c.department_id where b.process_type =? and b.business_id =? )" ;
	private final static String RESULTSETFIELDLIST = "process_id,process_instance_id,process_type,business_id,employee_id,cost_date,remark,linked_id,cost";
	private final static String[] fieldNames = { "process_type", "business_id", "process_type", "business_id", "process_type", "business_id", "process_type", "business_id"};
}
