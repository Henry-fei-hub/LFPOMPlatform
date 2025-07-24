package pomplatform.reimbursement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursement.bean.BaseGetReimbursementCost;
import pomplatform.reimbursement.bean.ConditionGetReimbursementCost;

public class QueryGetReimbursementCost extends AbstractQuery<BaseGetReimbursementCost, ConditionGetReimbursementCost>
{

	private static final Logger __logger = Logger.getLogger(QueryGetReimbursementCost.class);

	public QueryGetReimbursementCost() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.process_id");
	}

	@Override
	public BaseCollection<BaseGetReimbursementCost> executeQuery( KeyValuePair[] replacements, ConditionGetReimbursementCost condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getProcessType(), 
				condition.getBusinessId(), 
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
	public BaseGetReimbursementCost generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetReimbursementCost __base = new BaseGetReimbursementCost();
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
		if((val = __data[count++]) != null) __base.setCurrency(GenericBase.__getInt(val));
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
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
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

	private final static String __SQLText = "(SELECT a.process_id, a.process_instance_id, a.process_type, a.business_id, a.employee_id, a.complete_time as cost_date, a.business_name as remark, c.project_id as linked_id, c.final_amount as cost, b.currency from system_process_instances a LEFT JOIN project_normal_reimbursements b on a.business_id = b.project_normal_reimbursement_id LEFT JOIN normal_reimbursement_link_projects c on b.project_normal_reimbursement_id = c.project_normal_reimbursement_id where a.process_type = 2 and a.process_type = ? and a.business_id = ?) UNION ALL (SELECT a.process_id, a.process_instance_id, a.process_type, a.business_id, a.employee_id, a.complete_time as cost_date, a.business_name as remark, c.project_id as linked_id, c.final_amount as cost, b.currency from system_process_instances a LEFT JOIN travel_reimbursements b on a.business_id = b.travel_reimbursement_id LEFT JOIN travel_reimbursement_link_projects c on b.travel_reimbursement_id = c.travel_reimbursement_id where a.process_type = 4 and a.process_type = ? and a.business_id = ?) UNION ALL (SELECT a.process_id, a.process_instance_id, a.process_type, a.business_id, a.employee_id, a.complete_time as cost_date, a.business_name as remark, c.plate_id as linked_id, d.final_amount as cost, b.currency from system_process_instances a LEFT JOIN project_normal_reimbursements b on a.business_id = b.project_normal_reimbursement_id LEFT JOIN normal_reimbursement_link_departments d on b.project_normal_reimbursement_id = d.project_normal_reimbursement_id LEFT JOIN departments c on d.department_id = c.department_id where a.process_type in (3,10) and a.process_type = ? and a.business_id =?)UNION ALL (SELECT a.process_id, a.process_instance_id, a.process_type, a.business_id, a.employee_id, a.complete_time as cost_date, a.business_name as remark, c.plate_id as linked_id, d.final_amount as cost, b.currency from system_process_instances a LEFT JOIN travel_reimbursements b on a.business_id = b.travel_reimbursement_id LEFT JOIN travel_reimbursement_link_departments d on b.travel_reimbursement_id = d.travel_reimbursement_id LEFT JOIN departments c on d.department_id = c.department_id where a.process_type =5 and a.process_type =? and a.business_id =? ) UNION ALL (SELECT A.process_id, A.process_instance_id, A.process_type, A.business_id, A.employee_id, A.complete_time AS cost_date, A.business_name AS remark, d.plate_id AS linked_id, d.final_amount AS COST, b.currency FROM system_process_instances A LEFT JOIN travel_reimbursements b ON A.business_id = b.travel_reimbursement_id LEFT JOIN travel_reimbursement_link_main_projects d ON b.travel_reimbursement_id = d.travel_reimbursement_id WHERE A.process_type = 9  AND A.process_type =? AND A.business_id =? )  UNION ALL (SELECT A.process_id, A.process_instance_id, A.process_type, A.business_id, A.employee_id, A.complete_time AS cost_date, A.business_name AS remark, d.plate_id AS linked_id, d.final_amount AS COST, b.currency FROM system_process_instances A LEFT JOIN project_normal_reimbursements b ON A.business_id = b.project_normal_reimbursement_id LEFT JOIN normal_reimbursement_link_main_projects d ON b.project_normal_reimbursement_id = d.project_normal_reimbursement_id WHERE A.process_type = 8  AND A.process_type = ?  AND A.business_id =?  )" ;
	private final static String RESULTSETFIELDLIST = "process_id,process_instance_id,process_type,business_id,employee_id,cost_date,remark,linked_id,cost,currency";
	private final static String[] fieldNames = { "process_type", "business_id", "process_type", "business_id", "process_type", "business_id", "process_type", "business_id", "process_type", "business_id", "process_type", "business_id"};
}
