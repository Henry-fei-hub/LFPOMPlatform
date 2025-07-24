package pomplatform.workflow.personnel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnel.bean.BaseTaskOfEmployeeOnboard;
import pomplatform.workflow.personnel.bean.ConditionTaskOfEmployeeOnboard;

public class QueryTaskOfEmployeeOnboard extends AbstractQuery<BaseTaskOfEmployeeOnboard, ConditionTaskOfEmployeeOnboard>
{

	private static final Logger __logger = Logger.getLogger(QueryTaskOfEmployeeOnboard.class);

	public QueryTaskOfEmployeeOnboard() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sppt.process_pooled_task_id");
	}

	@Override
	public BaseCollection<BaseTaskOfEmployeeOnboard> executeQuery( KeyValuePair[] replacements, ConditionTaskOfEmployeeOnboard condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getOwnedCompany(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseTaskOfEmployeeOnboard generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTaskOfEmployeeOnboard __base = new BaseTaskOfEmployeeOnboard();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessPooledTaskId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOwnedCompany(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmpStatus(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT sppt.process_pooled_task_id,sppt.business_id,sppt.business_name,sppt.process_activity_id,sppt.process_id,sppt.process_instance_id,sppt.process_type, sppt.back_view_name,sppt.node_type,sppt.activity_id,sppt.instance_activity_create_time,sppt.instance_activity_start_time,sppt.status, sppt.operate_time,sppt.process_comment,A.department_id,A.employee_no,A.employee_name,A.onboard_date,A.owned_company,A.duty_id,A.apply_employee_id,A.status AS emp_status FROM system_process_pooled_tasks sppt LEFT JOIN employees A ON sppt.business_id = A.employee_id WHERE sppt.status = ? AND sppt.process_type =? AND sppt.employee_id = ? AND A.owned_company = ? AND A.employee_name LIKE ? AND A.employee_no LIKE ? AND A.department_id IN (SELECT child_id FROM department_ids WHERE department_id = ?) ORDER BY sppt.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_pooled_task_id,business_id,business_name,process_activity_id,process_id,process_instance_id,process_type,back_view_name,node_type,activity_id,instance_activity_create_time,instance_activity_start_time,status,operate_time,process_comment,department_id,employee_no,employee_name,onboard_date,owned_company,duty_id,apply_employee_id,emp_status";
	private final static String[] fieldNames = { "status", "process_type", "employee_id", "owned_company", "employee_name", "employee_no", "department_id"};
}
