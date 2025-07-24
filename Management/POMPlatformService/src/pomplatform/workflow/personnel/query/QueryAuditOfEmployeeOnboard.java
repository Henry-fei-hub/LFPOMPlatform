package pomplatform.workflow.personnel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnel.bean.BaseAuditOfEmployeeOnboard;
import pomplatform.workflow.personnel.bean.ConditionAuditOfEmployeeOnboard;

public class QueryAuditOfEmployeeOnboard extends AbstractQuery<BaseAuditOfEmployeeOnboard, ConditionAuditOfEmployeeOnboard>
{

	private static final Logger __logger = Logger.getLogger(QueryAuditOfEmployeeOnboard.class);

	public QueryAuditOfEmployeeOnboard() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spia.process_instance_activity_id");
	}

	@Override
	public BaseCollection<BaseAuditOfEmployeeOnboard> executeQuery( KeyValuePair[] replacements, ConditionAuditOfEmployeeOnboard condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getOwnedCompany(), 
				condition.getDepartmentId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo()
			);
	}

	@Override
	public BaseAuditOfEmployeeOnboard generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAuditOfEmployeeOnboard __base = new BaseAuditOfEmployeeOnboard();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOwnedCompany(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "SELECT spia.process_instance_activity_id,spia.business_id,spia.business_name, spia.process_activity_id,spia.process_id,spia.process_instance_id,spia.node_type,spia.activity_id,spia.next_activity_id,spia.main_activity_id, spia.instance_activity_create_time,spia.instance_activity_start_time,spia.status, spia.process_type,A.department_id,A.employee_no,A.employee_name,A.onboard_date, A.owned_company,A.duty_id,A.apply_employee_id,spia.operate_time,spia.process_comment,spia.activity_type, spia.back_view_name FROM system_process_instance_activities spia LEFT JOIN employees A ON spia.business_id = A.employee_id WHERE process_type = ? AND spia.status = ? AND spia.employee_id = ? And spia.activity_type IN (2, 3) AND spia.delete_flag = 0 AND A.owned_company = ? AND A .department_id IN (SELECT child_id FROM department_ids WHERE department_id = ?) AND A.employee_name like ? and A.employee_no = ? ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,department_id,employee_no,employee_name,onboard_date,owned_company,duty_id,apply_employee_id,operate_time,process_comment,activity_type,back_view_name";
	private final static String[] fieldNames = { "process_type", "status", "employee_id", "owned_company", "department_id", "employee_name", "employee_no"};
}
