package pomplatform.auditprojectquotetemplate.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.auditprojectquotetemplate.bean.BaseAuditProjectQuoteTemplate;
import pomplatform.auditprojectquotetemplate.bean.ConditionAuditProjectQuoteTemplate;

public class QueryAuditProjectQuoteTemplate extends AbstractQuery<BaseAuditProjectQuoteTemplate, ConditionAuditProjectQuoteTemplate>
{

	private static final Logger __logger = Logger.getLogger(QueryAuditProjectQuoteTemplate.class);

	public QueryAuditProjectQuoteTemplate() throws java.sql.SQLException 
	{
		setParameterNumber(13);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spt.process_type_name");
	}

	@Override
	public BaseCollection<BaseAuditProjectQuoteTemplate> executeQuery( KeyValuePair[] replacements, ConditionAuditProjectQuoteTemplate condition ) throws java.sql.SQLException {
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
				condition.getOperateEmployeeId(), 
				condition.getBusinessType()
			);
	}

	@Override
	public BaseAuditProjectQuoteTemplate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAuditProjectQuoteTemplate __base = new BaseAuditProjectQuoteTemplate();
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
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectQuoteId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQuoteStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBasicAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUpAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUpPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPreferentialAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPerferentialPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
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
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
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

	private final static String __SQLText = "SELECT spt.process_type_name, sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, mp.project_name, mp.province, mp.city, mp.project_type, mp.customer_name, mp.project_origination, mp.contact_name, mp.contact_phone, mp.detail_address, mp.total_building_areas, mp.apply_employee_id, mp.info_code, mp.customer_contact_id, pq.project_quote_id, pq.project_id, pq.quote_status, pq.basic_amount, pq.total_amount, pq.up_amount, pq.up_percent, pq.preferential_amount, pq.perferential_percent, pq.tax_amount, pq.other_tax_amount, pq.final_amount, pq.final_percent, pq.tax_final_amount, pq.operate_employee_id, pq.operate_time, pq.remark, pq.business_type FROM system_process_instance_activities AS spia LEFT JOIN project_quotes pq ON spia.business_id = pq.project_quote_id LEFT JOIN pre_projects mp ON mp.pre_project_id = pq.project_id LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id WHERE spia.activity_type IN (2, 3) AND spi.process_status =? AND spi.delete_flag = 0 AND spt.parent_process_type_id = 38 AND ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =? AND spia.status =? ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =? AND sppt.employee_id =? AND sppt.status =? ) OR ( spia.employee_id IS NULL AND sppt.employee_id =? AND sppt.status =? ) ) AND spia.process_type =? AND mp.project_name LIKE ? AND mp.project_type = ? AND pq.operate_employee_id =? AND pq.business_type =? ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_type_name,process_pooled_task_id,type_flag,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,process_comment,status,activity_type,back_view_name,project_name,province,city,project_type,customer_name,project_origination,contact_name,contact_phone,detail_address,total_building_areas,apply_employee_id,info_code,customer_contact_id,project_quote_id,project_id,quote_status,basic_amount,total_amount,up_amount,up_percent,preferential_amount,perferential_percent,tax_amount,other_tax_amount,final_amount,final_percent,tax_final_amount,operate_employee_id,operate_time,remark,business_type";
	private final static String[] fieldNames = { "process_status", "employee_id", "status", "employee_id", "employee_id", "status", "employee_id", "status", "process_type", "project_name", "project_type", "operate_employee_id", "business_type"};
}
