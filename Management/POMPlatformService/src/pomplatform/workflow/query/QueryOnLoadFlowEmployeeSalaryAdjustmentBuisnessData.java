package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData;

public class QueryOnLoadFlowEmployeeSalaryAdjustmentBuisnessData extends AbstractQuery<BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData, ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadFlowEmployeeSalaryAdjustmentBuisnessData.class);

	public QueryOnLoadFlowEmployeeSalaryAdjustmentBuisnessData() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spt.process_type_name");
	}

	@Override
	public BaseCollection<BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getTargetProvince(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData __base = new BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessPooledTaskId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTypeFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTargetProvince(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setFee(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOriginalPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSeverance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMessageStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setDouble(count++, GenericBase.__getDouble(args[0]));
		if(args[1] != null) __statement.setDouble(count++, GenericBase.__getDouble(args[1]));
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

	private final static String __SQLText = "SELECT spt.process_type_name, sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, A.employee_id, A.employee_no, A.target_province, A.department_id, A.start_date, A.end_date, A.fee, convert_from( decrypt ( CAST ( A.original_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS original_pay, A.severance, convert_from( decrypt ( CAST ( A.month_pay AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS month_pay, A.sub_type, A.personnel_business_id, spia.process_type, spia.process_id, spia.process_instance_id, spia.business_id, spia.process_instance_activity_id, spia.process_activity_id, spia.activity_type, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.status, spia.delete_flag, spia.message_status, spia.business_name, spia.back_view_name, spia.instance_activity_create_time, spia.instance_activity_start_time, A.remark FROM system_process_instance_activities AS spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id LEFT JOIN personnel_business A ON spia.business_id = A.personnel_business_id AND spia.process_type = A.process_type LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE A.delete_flag = 0 AND spia.activity_type IN ( 2, 3 ) AND ( EXTRACT ( YEAR FROM A.end_date )) =? AND ( EXTRACT ( MONTH FROM A.end_date )) =? AND A.target_province =? AND ((spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =? AND spia.status = 1) OR (spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =? AND sppt.employee_id =? AND sppt.status = 1) OR (spia.employee_id IS NULL AND sppt.employee_id =? AND sppt.status = 1)) AND spia.process_type = 30 AND A.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_type_name,process_pooled_task_id,type_flag,employee_id,employee_no,target_province,department_id,start_date,end_date,fee,original_pay,severance,month_pay,sub_type,personnel_business_id,process_type,process_id,process_instance_id,business_id,process_instance_activity_id,process_activity_id,activity_type,node_type,activity_id,next_activity_id,main_activity_id,status,delete_flag,message_status,business_name,back_view_name,instance_activity_create_time,instance_activity_start_time,remark";
	private final static String[] fieldNames = { "year", "month", "target_province", "employee_id", "employee_id", "employee_id", "employee_id", "department_id"};
}
