package pomplatform.workflow.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseEmployeeStuff;
import pomplatform.workflow.bean.ConditionEmployeeStuff;

public class QueryEmployeeStuff extends AbstractQuery<BaseEmployeeStuff, ConditionEmployeeStuff>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeStuff.class);

	public QueryEmployeeStuff() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("case when a.display_type = 1 and a.status = 0 then 1   when a.display_type = 1 and a.status = 1 then 2  when a.display_type = 1 and a.status = 2 then 3  when a.display_type = 2 and a.status = 1 then 4  when a.display_type = 2 and a.status = 2 then 7  when a.display_type = 3 and a.status = 1 then 5  when a.display_type = 3 and a.status = 2 then 8  when a.display_type = 4 and a.status = 1 then 6  when a.display_type = 4 and a.status = 2 then 9 end as activity_type");
	}

	@Override
	public BaseCollection<BaseEmployeeStuff> executeQuery( KeyValuePair[] replacements, ConditionEmployeeStuff condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(),
				condition.getParentProcessTypeId()
			);
	}

	@Override
	public BaseEmployeeStuff generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeStuff __base = new BaseEmployeeStuff();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT a.activity_type,process_type, b.process_type_name||'('||sum(a.num)||')' as business_name from (select case when a.display_type = 1 and a.status = 0 then 1 when a.display_type = 1 and a.status = 1 then 2 when a.display_type = 1 and a.status = 2 then 3 when a.display_type = 2 and a.status = 1 then 4 when a.display_type = 2 and (a.status = 2 or a.status = 3 or a.status = 6) then 7 when a.display_type = 3 and a.status = 1 then 5 when a.display_type = 3 and a.status = 2 then 8 when a.display_type = 4 and a.status = 1 then 6 when a.display_type = 4 and a.status = 2 then 9 end as activity_type, a.process_type, a.num from (select 1 as display_type, process_type, case when process_status = 0 or process_status = 1 then 0 when process_status = 5 then 1 when process_status = 3 then 2 end as status, count(1) as num from system_process_instances where delete_flag = 0 and employee_id = ? group by 1, process_type, case when process_status = 0 or process_status = 1 then 0 when process_status = 5 then 1 when process_status = 3 then 2 end union select 2 as display_type, process_type, status, count(1) as num from (select process_type, process_instance_id, status, count(1) from system_process_instance_activities where activity_type in (2,3) and status in (1,2,3,6) and delete_flag = 0 and employee_id = ? group by process_type, process_instance_id, status) as AAA group by 2, process_type, status union select 3 as display_type, process_type, status, count(1) as num from (select process_type, process_instance_id, status, count(1) from system_process_attentions where status in (1,2) and delete_flag = 0 and employee_id = ? group by process_type, process_instance_id, status) as AAA group by 2, process_type, status union select 4 as display_type, process_type, status, count(1) as num from (select process_type, process_instance_id, status, count(1) from system_process_pooled_tasks where status in (1,2) and delete_flag = 0 and employee_id = ? group by process_type, process_instance_id, status) as AAA group by 2, process_type, status) as a ) a left join system_process_types b on a.process_type = b.process_type_id where b.parent_process_type_id = ? GROUP BY a.activity_type, a.process_type, b.process_type_name ORDER BY a.activity_type, a.process_type" ;
	private final static String RESULTSETFIELDLIST = "activity_type,process_type,business_name";
	private final static String[] fieldNames = { "employee_id", "employee_id", "employee_id", "employee_id","parent_process_type_id"};
}
