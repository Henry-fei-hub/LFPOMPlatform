package pomplatform.workflow.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseOnLoadFlowProcessTypeNum;
import pomplatform.workflow.bean.ConditionOnLoadFlowProcessTypeNum;

public class QueryOnLoadFlowProcessTypeNum extends AbstractQuery<BaseOnLoadFlowProcessTypeNum, ConditionOnLoadFlowProcessTypeNum>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadFlowProcessTypeNum.class);

	public QueryOnLoadFlowProcessTypeNum() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.*");
	}

	@Override
	public BaseCollection<BaseOnLoadFlowProcessTypeNum> executeQuery( KeyValuePair[] replacements, ConditionOnLoadFlowProcessTypeNum condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getParentProcessTypeId()
			);
	}

	@Override
	public BaseOnLoadFlowProcessTypeNum generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadFlowProcessTypeNum __base = new BaseOnLoadFlowProcessTypeNum();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRunCount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setFinishCount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setBackCount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setTypeFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT a.*,c.process_type_name FROM ( (SELECT a.process_type,COUNT(a.process_status = 0 or a.process_status = 1 OR NULL) AS run_count ,COUNT(a.process_status = 3 OR A.process_status = 7 OR NULL) AS finish_count ,COUNT(a.process_status = 5 OR NULL) AS back_count,1 AS type_flag FROM system_process_instances a WHERE a.delete_flag = 0 AND a.employee_id = ? GROUP BY a.process_type) UNION ALL (SELECT a.process_type ,COUNT(a.status = 1 OR NULL) run_count,COUNT(a.status > 1 OR NULL) finish_count,0 AS back_count ,2 AS type_flag FROM (SELECT a.process_type,a.process_instance_id,a.employee_id,a.status,a.delete_flag,a.activity_type FROM system_process_instance_activities a LEFT JOIN system_process_pooled_tasks b ON a.process_instance_id = b.process_instance_id AND a.process_instance_activity_id = b.instance_activity_id WHERE b.process_pooled_task_id IS NULL UNION ALL SELECT a.process_type,a.process_instance_id,a.employee_id,a.status,a.delete_flag,a.activity_type FROM system_process_pooled_tasks a LEFT JOIN system_process_instance_activities b on a.process_instance_id = b.process_instance_id AND a.instance_activity_id = b.process_instance_activity_id WHERE (a.employee_id = b.employee_id OR b.employee_id is NULL) ) a LEFT JOIN system_process_instances b ON a.process_instance_id = b.process_instance_id WHERE a.delete_flag = 0 AND a.activity_type in(2,3) AND b.delete_flag = 0 AND a.employee_id = ? GROUP BY a.process_type) UNION ALL (SELECT a.process_type ,COUNT(a.status = 1 OR NULL) run_count,COUNT(a.status = 2 OR NULL) finish_count,0 AS back_count,3 AS type_flag FROM system_process_attentions a LEFT JOIN system_process_instances b ON a.process_instance_id = b.process_instance_id WHERE a.delete_flag = 0 AND b.delete_flag = 0 AND a.employee_id = ? GROUP BY a.process_type) ) a LEFT JOIN system_process_types c ON a.process_type = c.process_type_id WHERE c.parent_process_type_id = ?" ;
	private final static String RESULTSETFIELDLIST = "process_type,run_count,finish_count,back_count,type_flag,process_type_name";
	private final static String[] fieldNames = { "employee_id", "employee_id", "employee_id", "parent_process_type_id"};
}
