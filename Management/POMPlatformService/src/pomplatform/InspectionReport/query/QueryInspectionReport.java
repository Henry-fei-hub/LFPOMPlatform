package pomplatform.InspectionReport.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.InspectionReport.bean.BaseInspectionReport;
import pomplatform.InspectionReport.bean.ConditionInspectionReport;

public class QueryInspectionReport extends AbstractQuery<BaseInspectionReport, ConditionInspectionReport>
{

	private static final Logger __logger = Logger.getLogger(QueryInspectionReport.class);

	public QueryInspectionReport() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("t.* from (select a.business_id");
	}

	@Override
	public BaseCollection<BaseInspectionReport> executeQuery( KeyValuePair[] replacements, ConditionInspectionReport condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCode(), 
				condition.getCode(), 
				condition.getCode(), 
				condition.getCode(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseInspectionReport generateBase(Object[] __data) throws java.sql.SQLException {
		BaseInspectionReport __base = new BaseInspectionReport();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "select t.* from (select a.business_id,a.code,a.process_type,a.process_id,a.process_status,a.process_instance_id, b.process_instance_activity_id, b.business_name, b.process_activity_id, b.back_view_name, b.activity_type, b.node_type, b.activity_id, b.next_activity_id, b.main_activity_id, 0 as instance_activity_id, b.instance_activity_create_time, b.instance_activity_start_time, b.employee_id, b.operate_time, b.process_comment, b.status, 0 as type, b.delete_flag from ( select a1.travel_reimbursement_id as business_id,a1.code,spi.process_type,spi.process_id,spi.process_status,spi.process_instance_id from travel_reimbursements a1 LEFT JOIN system_process_instances spi on spi.business_id = a1.travel_reimbursement_id where a1.code = ? and spi.process_type in (4,5,9) and a1.delete_flag=0 UNION all select a1.project_normal_reimbursement_id as business_id,a1.code,spi.process_type,spi.process_id,spi.process_status,spi.process_instance_id from project_normal_reimbursements a1 LEFT JOIN system_process_instances spi on spi.business_id = a1.project_normal_reimbursement_id where a1.code = ? and spi.process_type in (2,3,8,10) and a1.delete_flag=0 UNION all select a1.pay_money_manage_id as business_id,a1.code,spi.process_type,spi.process_id,spi.process_status,spi.process_instance_id from pay_money_manages a1 LEFT JOIN system_process_instances spi on spi.business_id = a1.pay_money_manage_id where a1.code = ? and spi.process_type=7 and a1.delete_flag=0 UNION all select a1.employee_money_manage_id as business_id,a1.code,spi.process_type,spi.process_id,spi.process_status,spi.process_instance_id from employee_money_manages a1 LEFT JOIN system_process_instances spi on spi.business_id = a1.employee_money_manage_id where a1.code = ? and spi.process_type=6 and a1.delete_flag=0 ) a LEFT JOIN system_process_instance_activities b on a.process_type = b.process_type and a.business_id = b.business_id and (b.employee_id = ? or b.employee_id is null) left join system_process_pooled_tasks c on b.process_instance_activity_id = c.instance_activity_id where b.status=1 and (b.employee_id = ? or (b.employee_id is null and c.employee_id = ?))) t,system_processes p where t.process_id=p.process_id" ;
	private final static String RESULTSETFIELDLIST = "business_id,code,process_type,process_id,process_status,process_instance_id,process_instance_activity_id,business_name,process_activity_id,back_view_name,activity_type,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_id,instance_activity_create_time,instance_activity_start_time,employee_id,operate_time,process_comment,status,type,delete_flag";
	private final static String[] fieldNames = { "code", "code", "code", "code", "employee_id", "employee_id", "employee_id"};
}
