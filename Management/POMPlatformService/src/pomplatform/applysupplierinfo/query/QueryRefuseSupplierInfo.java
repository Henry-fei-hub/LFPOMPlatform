package pomplatform.applysupplierinfo.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.applysupplierinfo.bean.BaseRefuseSupplierInfo;
import pomplatform.applysupplierinfo.bean.ConditionRefuseSupplierInfo;

public class QueryRefuseSupplierInfo extends AbstractQuery<BaseRefuseSupplierInfo, ConditionRefuseSupplierInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryRefuseSupplierInfo.class);

	public QueryRefuseSupplierInfo() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseRefuseSupplierInfo> executeQuery( KeyValuePair[] replacements, ConditionRefuseSupplierInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getProcessStatus(), 
				condition.getSupplierName(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd(), 
				condition.getEmployeeId(), 
				condition.getOperateEmployeeId(), 
				condition.getAreasExpertise()
			);
	}

	@Override
	public BaseRefuseSupplierInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRefuseSupplierInfo __base = new BaseRefuseSupplierInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.employee_id, s.supplier_id, s.supplier_name, s.supplier_contact, s.supplier_phone, s.supplier_email, s.supplier_type, s.supplier_main_business_type, s.supplier_scope_supply, s.social_credit_code, s.supplier__province, s.supplier__city, s.supplier_bank_address, s.supplier_address, s.production_cycle, s.logistics_cycle, s.supplier_boss, s.contract_signing_time, s.contract_scope_time, s.contract_scope_time_start, s.contract_scope_time_end, s.operate_employee_id, s.operate_time, s.supplier_origin, s.supplier_status, s.is_use, s.receive_unit_manage_id, s.agreement_type, s.agreement_sign_time, s.agreement_sign_address, s.file_id, s.team_size, s.areas_expertise, f.file_name, f.file_url FROM system_process_instances spi LEFT JOIN supplier s ON spi.business_id = s.supplier_id LEFT JOIN file_manages f ON s.file_id = f.file_id WHERE spi.process_type =? AND spi.process_status =? AND spi.delete_flag = 0 AND s.supplier_name LIKE ? AND spi.create_time BETWEEN ? AND ? AND spi.employee_id =? AND s.operate_employee_id =? AND s.areas_expertise =? ORDER BY spi.create_time desc" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,employee_id,supplier_id,supplier_name,supplier_contact,supplier_phone,supplier_email,supplier_type,supplier_main_business_type,supplier_scope_supply,social_credit_code,supplier__province,supplier__city,supplier_bank_address,supplier_address,production_cycle,logistics_cycle,supplier_boss,contract_signing_time,contract_scope_time,contract_scope_time_start,contract_scope_time_end,operate_employee_id,operate_time,supplier_origin,supplier_status,is_use,receive_unit_manage_id,agreement_type,agreement_sign_time,agreement_sign_address,file_id,team_size,areas_expertise,file_name,file_url";
	private final static String[] fieldNames = { "process_type", "process_status", "supplier_name", "create_time_start", "create_time_end", "employee_id", "operate_employee_id", "areas_expertise"};
}
