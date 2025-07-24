package pomplatform.awaitingapproval.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.awaitingapproval.bean.BaseAwaitingapproval;
import pomplatform.awaitingapproval.bean.ConditionAwaitingapproval;

public class QueryAwaitingapproval extends AbstractQuery<BaseAwaitingapproval, ConditionAwaitingapproval> {

	private static final Logger __logger = Logger.getLogger(QueryAwaitingapproval.class);

	public QueryAwaitingapproval() throws java.sql.SQLException {
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT 	spia.employee_id");
	}

	@Override
	public BaseCollection<BaseAwaitingapproval> executeQuery(KeyValuePair[] replacements,
			ConditionAwaitingapproval condition) throws java.sql.SQLException {
		return executeQuery(replacements);
	}

	@Override
	public BaseAwaitingapproval generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAwaitingapproval __base = new BaseAwaitingapproval();
		int count = 0;
		Object val;
		if ((val = __data[count++]) != null)
			__base.setEmployeeId(GenericBase.__getInt(val));
		if ((val = __data[count++]) != null)
			__base.setId(GenericBase.__getInt(val));
		if ((val = __data[count++]) != null)
			__base.setProcessType(GenericBase.__getInt(val));
		if ((val = __data[count++]) != null)
			__base.setBusinessName(GenericBase.__getString(val));
		if ((val = __data[count++]) != null)
			__base.setProcessTypeName(GenericBase.__getString(val));
		if ((val = __data[count++]) != null)
			__base.setTimeOutAction(GenericBase.__getInt(val));
		if ((val = __data[count++]) != null)
			__base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if ((val = __data[count++]) != null)
			__base.setIdType(GenericBase.__getInt(val));
		if ((val = __data[count++]) != null)
			__base.setBackViewName(GenericBase.__getString(val));
		if ((val = __data[count++]) != null)
			__base.setCompanyWeixin(GenericBase.__getString(val));
		if ((val = __data[count++]) != null)
			__base.setCompanyEmail(GenericBase.__getString(val));
		if ((val = __data[count++]) != null)
			__base.setBusinessId(GenericBase.__getInt(val));
		if ((val = __data[count++]) != null)
			__base.setProcessInstanceId(GenericBase.__getInt(val));
		if ((val = __data[count++]) != null)
			__base.setActivityType(GenericBase.__getInt(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, java.lang.Object... args) throws java.sql.SQLException {

		int index = 0;
		for (int ii = 0; ii < args.length; ii++) {
			if (args[ii] == null)
				continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if (index > 0)
			__logger.info("=================================================");
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList() {
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "SELECT DISTINCT spia.employee_id, spia.process_instance_activity_id AS id, spia.process_type, spia.business_name, spt.process_type_name, spa.time_out_action, spia.instance_activity_start_time, 1 as id_type, spia.back_view_name, e.company_weixin, e.company_email, spia.business_id, spia.process_instance_id, spia.activity_type FROM system_process_instance_activities spia LEFT JOIN system_process_types spt ON spt.process_type_id = spia.process_type LEFT JOIN system_process_activities spa ON spa.process_activity_id = spia.process_activity_id LEFT JOIN employees e ON e.employee_id = spia.employee_id WHERE spia.status = 1 AND spia.activity_type NOT IN (0,1) AND spia.employee_id > 0 AND spia.delete_flag = 0 AND spia.message_status = 0 AND spia.process_instance_id IN ( SELECT sp.process_instance_id FROM system_process_instances sp WHERE sp.delete_flag = 0 AND sp.process_status in (0, 1) ) AND ( back_view_name NOT LIKE '%财务%' OR back_view_name IS NULL ) UNION ALL SELECT DISTINCT sppt.employee_id, sppt.process_pooled_task_id AS id, sppt.process_type, sppt.business_name, spt.process_type_name, spa.time_out_action, sppt.instance_activity_start_time, 2 AS id_type, sppt.back_view_name, e.company_weixin, e.company_email, sppt.business_id, sppt.process_instance_id, sppt.activity_type FROM system_process_pooled_tasks sppt LEFT JOIN system_process_types spt ON spt.process_type_id = sppt.process_type LEFT JOIN system_process_activities spa ON spa.process_activity_id = sppt.process_activity_id LEFT JOIN employees e ON e.employee_id = sppt.employee_id WHERE sppt.status = 1 AND sppt.employee_id > 0 AND sppt.delete_flag = 0 AND sppt.message_status = 0 AND sppt.process_instance_id IN ( SELECT sp.process_instance_id FROM system_process_instances sp WHERE sp.delete_flag = 0 AND sp.process_status in (0, 1) ) AND ( back_view_name NOT LIKE '%财务%' OR back_view_name IS NULL )";
	private final static String RESULTSETFIELDLIST = "employee_id,id,process_type,business_name,process_type_name,time_out_action,instance_activity_start_time,id_type,back_view_name,company_weixin,company_email,business_id,process_instance_id,activity_type";
	private final static String[] fieldNames = {};
}
