package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseOnLoadFlowAuditListOfPreProjectReportBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowAuditListOfPreProjectReportBuisnessData;

public class QueryOnLoadFlowAuditListOfPreProjectReportBuisnessData extends AbstractQuery<BaseOnLoadFlowAuditListOfPreProjectReportBuisnessData, ConditionOnLoadFlowAuditListOfPreProjectReportBuisnessData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadFlowAuditListOfPreProjectReportBuisnessData.class);

	public QueryOnLoadFlowAuditListOfPreProjectReportBuisnessData() throws java.sql.SQLException
	{
		setParameterNumber(20);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spt.process_type_name");
	}

	@Override
	public BaseCollection<BaseOnLoadFlowAuditListOfPreProjectReportBuisnessData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadFlowAuditListOfPreProjectReportBuisnessData condition ) throws java.sql.SQLException {
		return executeQuery(replacements,
				condition.getProcessStatus(),
				condition.getEmployeeId(),
				condition.getStatus(),
				condition.getEmployeeId(),
				condition.getEmployeeId(),
				condition.getStatus(),
				condition.getEmployeeId(),
				condition.getStatus(),
				condition.getProcessType(),
				condition.getProjectName(),
				condition.getProjectType(),
				condition.getProjectSalesTeam(),
				condition.getCustomerName(),
				condition.getProvince(),
				condition.getCity(),
				condition.getProjectOrigination(),
				condition.getIsOperationDepartment(),
				condition.getApplyEmployeeId(),
				condition.getCreateTimeStart(),
				condition.getCreateTimeEnd()
		);
	}

	@Override
	public BaseOnLoadFlowAuditListOfPreProjectReportBuisnessData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadFlowAuditListOfPreProjectReportBuisnessData __base = new BaseOnLoadFlowAuditListOfPreProjectReportBuisnessData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessPooledTaskId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTypeFlag(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectNameOne(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsWarehous(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsApplyQuote(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
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
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[18]));
		if(args[19] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[19]));
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

	private final static String __SQLText = "SELECT spt.process_type_name, sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, mp.project_name, case when mp.project_name=mp.project_name_one then '' else mp.project_name_one end project_name_one, mp.province, mp.city, mp.project_type, mp.customer_name, mp.project_origination, mp.contact_name, mp.contact_phone, mp.detail_address, mp.total_building_areas, mp.apply_employee_id, C.customer_type, C.is_warehous, C.is_apply_quote, mp.info_code, mp.customer_contact_id, spia.process_type FROM system_process_instance_activities AS spia LEFT JOIN pre_projects mp ON spia.business_id = mp.pre_project_id LEFT JOIN customers C ON mp.client_id = C.customer_id LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id WHERE spia.activity_type IN ( 2, 3 ) AND spi.process_status = ? AND spi.delete_flag = 0 AND spt.parent_process_type_id = 38 AND (( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id = ? AND spia.status =? ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =? AND sppt.employee_id =? AND sppt.status =? ) OR ( spia.employee_id IS NULL AND sppt.employee_id =? AND sppt.status =? )) AND spia.process_type =? AND mp.project_name LIKE ? AND mp.project_type = ? AND mp.project_sales_team =? AND mp.customer_name LIKE ? AND mp.province =? AND mp.city =? AND mp.project_origination =? AND mp.is_operation_department =? AND mp.apply_employee_id =? AND mp.create_time BETWEEN ? AND ? ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_type_name,process_pooled_task_id,type_flag,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,project_name,project_name_one,province,city,project_type,customer_name,project_origination,contact_name,contact_phone,detail_address,total_building_areas,apply_employee_id,customer_type,is_warehous,is_apply_quote,info_code,customer_contact_id,process_type";
	private final static String[] fieldNames = { "process_status", "employee_id", "status", "employee_id", "employee_id", "status", "employee_id", "status", "process_type", "project_name", "project_type", "project_sales_team", "customer_name", "province", "city", "project_origination", "is_operation_department", "apply_employee_id", "create_time_start", "create_time_end"};
}
