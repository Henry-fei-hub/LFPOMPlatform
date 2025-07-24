package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseOnLoadFlowNormalReimbursementsBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowNormalReimbursementsBuisnessData;

public class QueryOnLoadFlowNormalReimbursementsBuisnessData extends AbstractQuery<BaseOnLoadFlowNormalReimbursementsBuisnessData, ConditionOnLoadFlowNormalReimbursementsBuisnessData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadFlowNormalReimbursementsBuisnessData.class);

	public QueryOnLoadFlowNormalReimbursementsBuisnessData() throws java.sql.SQLException 
	{
		setParameterNumber(18);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spt.process_type_name");
	}

	@Override
	public BaseCollection<BaseOnLoadFlowNormalReimbursementsBuisnessData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadFlowNormalReimbursementsBuisnessData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getProcessType(), 
				condition.getStatus(), 
				condition.getCompanyId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId(), 
				condition.getCode(), 
				condition.getApplyEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getProcessType(), 
				condition.getStatus(), 
				condition.getCompanyId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId(), 
				condition.getCode(), 
				condition.getApplyEmployeeId()
			);
	}

	@Override
	public BaseOnLoadFlowNormalReimbursementsBuisnessData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadFlowNormalReimbursementsBuisnessData __base = new BaseOnLoadFlowNormalReimbursementsBuisnessData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceiveStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTitle(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
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

	private final static String __SQLText = "( SELECT spt.process_type_name, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.back_view_name, spia.activity_type, spia.node_type, spia.activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.status, spia.process_type, nr.code, nr.employee_id, nr.department_id, nr.amount, nr.company_id, spia.operate_time, spia.process_comment, fib.receive_status, nr.reimbursement_name AS title from system_process_instance_activities spia LEFT JOIN project_normal_reimbursements nr ON spia.business_id = nr.project_normal_reimbursement_id LEFT JOIN finance_receive_bills fib ON fib.code = nr.code LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id LEFT JOIN personnel_business A ON spia.business_id = A.personnel_business_id AND spia.process_type = A.process_type LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spia.activity_type IN ( 2, 3 ) AND spi.delete_flag = 0 AND spt.parent_process_type_id = 1 AND spia.employee_id =? AND spia.process_type =? AND spia.status =? AND nr.company_id =? AND b.employee_name LIKE ? AND A.employee_no LIKE ? AND nr.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) AND nr.code LIKE ? AND nr.apply_employee_id =? ORDER BY spia.instance_activity_create_time DESC ) UNION All ( SELECT spt.process_type_name, sppt.business_id, sppt.business_name, sppt.process_activity_id, sppt.process_id, sppt.process_instance_id, sppt.back_view_name, sppt.activity_type, sppt.node_type, sppt.activity_id, sppt.instance_activity_create_time, sppt.instance_activity_start_time, sppt.status, sppt.process_type, nr.code, nr.employee_id, nr.department_id, nr.amount, nr.company_id, sppt.operate_time, sppt.process_comment, fib.receive_status, nr.reimbursement_name AS title from system_process_pooled_tasks sppt LEFT JOIN project_normal_reimbursements nr ON sppt.business_id = nr.project_normal_reimbursement_id LEFT JOIN finance_receive_bills fib ON fib.code = nr.code LEFT JOIN system_process_instances spi ON sppt.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON sppt.process_type = spt.process_type_id LEFT JOIN personnel_business A ON sppt.business_id = A.personnel_business_id AND sppt.process_type = A.process_type LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE sppt.activity_type IN ( 2, 3 ) AND spi.delete_flag = 0 AND spt.parent_process_type_id = 1 AND sppt.employee_id = ? AND sppt.process_type = ? AND sppt.status = ? AND nr.company_id = ? AND b.employee_name LIKE ? AND A.employee_no LIKE ? AND nr.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) AND nr.code LIKE ? AND nr.apply_employee_id =? ORDER BY sppt.instance_activity_create_time DESC )" ;
	private final static String RESULTSETFIELDLIST = "process_type_name,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,activity_type,node_type,activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,code,employee_id,department_id,amount,company_id,operate_time,process_comment,receive_status,title";
	private final static String[] fieldNames = { "employee_id", "process_type", "status", "company_id", "employee_name", "employee_no", "department_id", "code", "apply_employee_id", "employee_id", "process_type", "status", "company_id", "employee_name", "employee_no", "department_id", "code", "apply_employee_id"};
}
