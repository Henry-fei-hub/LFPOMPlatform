package pomplatform.attentionsupplierinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attentionsupplierinfo.bean.BaseAttentionSupplierInfo;
import pomplatform.attentionsupplierinfo.bean.ConditionAttentionSupplierInfo;

public class QueryAttentionSupplierInfo extends AbstractQuery<BaseAttentionSupplierInfo, ConditionAttentionSupplierInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryAttentionSupplierInfo.class);

	public QueryAttentionSupplierInfo() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseAttentionSupplierInfo> executeQuery( KeyValuePair[] replacements, ConditionAttentionSupplierInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getSupplierName(), 
				condition.getOperateEmployeeId(), 
				condition.getOperateTimeStart(), 
				condition.getOperateTimeEnd(), 
				condition.getAreasExpertise()
			);
	}

	@Override
	public BaseAttentionSupplierInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttentionSupplierInfo __base = new BaseAttentionSupplierInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSystemProcessAttentionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
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
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
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

	private final static String __SQLText = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.process_type, spa.process_comment, s.supplier_id, s.supplier_name, s.supplier_contact, s.supplier_phone, s.supplier_email, s.supplier_type, s.supplier_main_business_type, s.supplier_scope_supply, s.social_credit_code, s.supplier__province, s.supplier__city, s.supplier_bank_address, s.supplier_address, s.production_cycle, s.logistics_cycle, s.supplier_boss, s.contract_signing_time, s.contract_scope_time, s.contract_scope_time_start, s.contract_scope_time_end, s.operate_employee_id, s.operate_time, s.supplier_origin, s.supplier_status, s.is_use, s.receive_unit_manage_id, s.agreement_type, s.agreement_sign_time, s.agreement_sign_address, s.file_id, s.team_size, s.areas_expertise, f.file_name, f.file_url FROM system_process_attentions spa LEFT JOIN supplier s ON spa.business_id = s.supplier_id LEFT JOIN file_manages f ON s.file_id = f.file_id WHERE spa.status =? AND spa.process_type =? AND spa.employee_id =? AND spa.delete_flag = 0 AND s.supplier_name LIKE ? AND s.operate_employee_id =? AND s.operate_time BETWEEN ? and ? AND s.areas_expertise =? ORDER BY spa.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,process_comment,supplier_id,supplier_name,supplier_contact,supplier_phone,supplier_email,supplier_type,supplier_main_business_type,supplier_scope_supply,social_credit_code,supplier__province,supplier__city,supplier_bank_address,supplier_address,production_cycle,logistics_cycle,supplier_boss,contract_signing_time,contract_scope_time,contract_scope_time_start,contract_scope_time_end,operate_employee_id,operate_time,supplier_origin,supplier_status,is_use,receive_unit_manage_id,agreement_type,agreement_sign_time,agreement_sign_address,file_id,team_size,areas_expertise,file_name,file_url";
	private final static String[] fieldNames = { "status", "process_type", "employee_id", "supplier_name", "operate_employee_id", "operate_time_start", "operate_time_end", "areas_expertise"};
}
