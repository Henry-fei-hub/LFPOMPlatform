package pomplatform.auditsupplierinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.auditsupplierinfo.bean.BaseAuditSupplierInfo;
import pomplatform.auditsupplierinfo.bean.ConditionAuditSupplierInfo;

public class QueryAuditSupplierInfo extends AbstractQuery<BaseAuditSupplierInfo, ConditionAuditSupplierInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryAuditSupplierInfo.class);

	public QueryAuditSupplierInfo() throws java.sql.SQLException 
	{
		setParameterNumber(14);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spt.process_type_name");
	}

	@Override
	public BaseCollection<BaseAuditSupplierInfo> executeQuery( KeyValuePair[] replacements, ConditionAuditSupplierInfo condition ) throws java.sql.SQLException {
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
				condition.getSupplierName(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd(), 
				condition.getOperateEmployeeId(), 
				condition.getAreasExpertise()
			);
	}

	@Override
	public BaseAuditSupplierInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAuditSupplierInfo __base = new BaseAuditSupplierInfo();
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
		if((val = __data[count++]) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierContact(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierMainBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierScopeSupply(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSocialCreditCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplier_province(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplier_city(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierBankAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductionCycle(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLogisticsCycle(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierBoss(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractSigningTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setContractScopeTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractScopeTimeStart(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setContractScopeTimeEnd(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSupplierOrigin(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsUse(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAgreementType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAgreementSignTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAgreementSignAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTeamSize(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAreasExpertise(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[10] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[10]));
		if(args[11] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
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

	private final static String __SQLText = "SELECT spt.process_type_name, sppt.process_pooled_task_id, CASE WHEN sppt.process_pooled_task_id > 0 THEN 2 ELSE 1 END AS type_flag, spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, s.supplier_id, s.supplier_name, s.supplier_contact, s.supplier_phone, s.supplier_email, s.supplier_type, s.supplier_main_business_type, s.supplier_scope_supply, s.social_credit_code, s.supplier__province, s.supplier__city, s.supplier_bank_address, s.supplier_address, s.production_cycle, s.logistics_cycle, s.supplier_boss, s.contract_signing_time, s.contract_scope_time, s.contract_scope_time_start, s.contract_scope_time_end, s.operate_employee_id, s.operate_time, s.supplier_origin, s.supplier_status, s.is_use, s.receive_unit_manage_id, s.agreement_type, s.agreement_sign_time, s.agreement_sign_address, s.file_id, s.team_size, s.areas_expertise, f.file_name, f.file_url,spi.employee_id,spi.create_time FROM system_process_instance_activities AS spia LEFT JOIN system_process_pooled_tasks sppt ON spia.process_instance_id = sppt.process_instance_id AND spia.process_instance_activity_id = sppt.instance_activity_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id LEFT JOIN system_process_types spt ON spia.process_type = spt.process_type_id LEFT JOIN supplier s ON spia.business_id = s.supplier_id LEFT JOIN file_manages f ON s.file_id = f.file_id WHERE spia.activity_type IN ( 2, 3 ) AND spi.process_status =? AND spi.delete_flag = 0 AND spt.parent_process_type_id = 38 AND ( ( spia.employee_id > 0 AND sppt.process_pooled_task_id IS NULL AND spia.employee_id =? AND spia.status =? ) OR ( spia.employee_id > 0 AND sppt.process_pooled_task_id > 0 AND spia.employee_id =? AND sppt.employee_id =? AND sppt.status =? ) OR ( spia.employee_id IS NULL AND sppt.employee_id =? AND sppt.status =? ) ) AND spia.process_type =? AND s.supplier_name LIKE ? AND spi.create_time BETWEEN ? and ? AND s.operate_employee_id =? AND s.areas_expertise =? ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_type_name,process_pooled_task_id,type_flag,process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,process_comment,status,activity_type,back_view_name,supplier_id,supplier_name,supplier_contact,supplier_phone,supplier_email,supplier_type,supplier_main_business_type,supplier_scope_supply,social_credit_code,supplier__province,supplier__city,supplier_bank_address,supplier_address,production_cycle,logistics_cycle,supplier_boss,contract_signing_time,contract_scope_time,contract_scope_time_start,contract_scope_time_end,operate_employee_id,operate_time,supplier_origin,supplier_status,is_use,receive_unit_manage_id,agreement_type,agreement_sign_time,agreement_sign_address,file_id,team_size,areas_expertise,file_name,file_url,employee_id,create_time";
	private final static String[] fieldNames = { "process_status", "employee_id", "status", "employee_id", "employee_id", "status", "employee_id", "status", "process_type", "supplier_name", "create_time_start", "create_time_end", "operate_employee_id", "areas_expertise"};
}
