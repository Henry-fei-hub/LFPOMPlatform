package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseApplicationInForFilingListOf;
import pomplatform.workflow.bean.ConditionApplicationInForFilingListOf;


public class QueryApplicationInForFilingListOf extends AbstractQuery<BaseApplicationInForFilingListOf, ConditionApplicationInForFilingListOf>
{

	private static final Logger __logger = Logger.getLogger(QueryApplicationInForFilingListOf.class);

	public QueryApplicationInForFilingListOf() throws java.sql.SQLException
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spia.process_instance_activity_id");
	}

	@Override
	public BaseCollection<BaseApplicationInForFilingListOf> executeQuery( KeyValuePair[] replacements, ConditionApplicationInForFilingListOf condition ) throws java.sql.SQLException {
		return executeQuery(replacements,
				condition.getEmployeeName(),
				condition.getEmployeeNo(),
				condition.getEmployeeId(),
				condition.getStatus(),
				condition.getEmployeeId(),
				condition.getEmployeeId(),
				condition.getStatus(),
				condition.getEmployeeId(),
				condition.getStatus()
		);
	}

	@Override
	public BaseApplicationInForFilingListOf generateBase(Object[] __data) throws java.sql.SQLException {
		BaseApplicationInForFilingListOf __base = new BaseApplicationInForFilingListOf();
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
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalary1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalary2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUnit(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
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

	private final static String __SQLText = "SELECT spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, A.personnel_business_id, A.process_type, A.employee_id, A.employee_no, A.department_id, A.company_id, A.attachment, A.salary_1, A.salary_2, A.unit FROM system_process_instance_activities AS spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id LEFT JOIN personnel_business A ON spia.business_id = A.personnel_business_id LEFT JOIN employees b ON A.employee_id = b.employee_id AND spia.process_type = A.process_type WHERE spia.activity_type IN ( 2, 3 ) AND spi.delete_flag = 0 AND spt.parent_process_type_id = 12 AND b.employee_name LIKE ? AND A.employee_no LIKE ? AND (( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =? AND spia.status =? ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =? AND sppt.employee_id =? AND sppt.status =? ) OR ( spia.employee_id IS NULL AND sppt.employee_id =? AND sppt.status =? )) AND spia.process_type = 72 ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,personnel_business_id,process_type,employee_id,employee_no,department_id,company_id,attachment,salary_1,salary_2,unit";
	private final static String[] fieldNames = { "employee_name", "employee_no", "employee_id", "status", "employee_id", "employee_id", "status", "employee_id", "status"};
}