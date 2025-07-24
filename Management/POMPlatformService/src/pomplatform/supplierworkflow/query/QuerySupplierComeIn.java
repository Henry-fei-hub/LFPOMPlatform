package pomplatform.supplierworkflow.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.supplierworkflow.bean.BaseSupplierComeIn;
import pomplatform.supplierworkflow.bean.ConditionSupplierComeIn;

public class QuerySupplierComeIn extends AbstractQuery<BaseSupplierComeIn, ConditionSupplierComeIn>
{

	private static final Logger __logger = Logger.getLogger(QuerySupplierComeIn.class);

	public QuerySupplierComeIn() throws java.sql.SQLException 
	{
		setParameterNumber(32);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("s.supplier_id");
	}

	@Override
	public BaseCollection<BaseSupplierComeIn> executeQuery( KeyValuePair[] replacements, ConditionSupplierComeIn condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSupplierId(), 
				condition.getSupplierName(), 
				condition.getSupplierContact(), 
				condition.getSupplierPhone(), 
				condition.getSupplierEmail(), 
				condition.getSupplierType(), 
				condition.getSupplierMainBusinessType(), 
				condition.getSupplierScopeSupply(), 
				condition.getSocialCreditCode(), 
				condition.getSupplier_province(), 
				condition.getSupplier_city(), 
				condition.getSupplierBankAddress(), 
				condition.getSupplierAddress(), 
				condition.getProductionCycle(), 
				condition.getLogisticsCycle(), 
				condition.getSupplierBoss(), 
				condition.getContractSigningTime(), 
				condition.getContractScopeTime(), 
				condition.getContractScopeTimeStart(), 
				condition.getContractScopeTimeEnd(), 
				condition.getOperateEmployeeId(), 
				condition.getOperateTime(), 
				condition.getSupplierOrigin(), 
				condition.getSupplierStatus(), 
				condition.getIsUse(), 
				condition.getReceiveUnitManageId(), 
				condition.getAgreementType(), 
				condition.getAgreementSignTime(), 
				condition.getAgreementSignAddress(), 
				condition.getFileId(), 
				condition.getTeamSize(), 
				condition.getAreasExpertise()
			);
	}

	@Override
	public BaseSupplierComeIn generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSupplierComeIn __base = new BaseSupplierComeIn();
		int count = 0;
		Object val;
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[18]));
		if(args[19] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[19]));
		if(args[20] != null) __statement.setInt(count++, GenericBase.__getInt(args[20]));
		if(args[21] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[21]));
		if(args[22] != null) __statement.setString(count++, GenericBase.__getString(args[22]));
		if(args[23] != null) __statement.setInt(count++, GenericBase.__getInt(args[23]));
		if(args[24] != null) __statement.setInt(count++, GenericBase.__getInt(args[24]));
		if(args[25] != null) __statement.setInt(count++, GenericBase.__getInt(args[25]));
		if(args[26] != null) __statement.setInt(count++, GenericBase.__getInt(args[26]));
		if(args[27] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[27]));
		if(args[28] != null) __statement.setString(count++, GenericBase.__getString(args[28]));
		if(args[29] != null) __statement.setInt(count++, GenericBase.__getInt(args[29]));
		if(args[30] != null) __statement.setInt(count++, GenericBase.__getInt(args[30]));
		if(args[31] != null) __statement.setInt(count++, GenericBase.__getInt(args[31]));
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

	private final static String __SQLText = "select s.supplier_id, s.supplier_name, s.supplier_contact, s.supplier_phone, s.supplier_email, s.supplier_type, s.supplier_main_business_type, s.supplier_scope_supply, s.social_credit_code, s.supplier__province, s.supplier__city, s.supplier_bank_address, s.supplier_address, s.production_cycle, s.logistics_cycle, s.supplier_boss, s.contract_signing_time, s.contract_scope_time, s.contract_scope_time_start, s.contract_scope_time_end, s.operate_employee_id, s.operate_time, s.supplier_origin, s.supplier_status, s.is_use, s.receive_unit_manage_id, s.agreement_type, s.agreement_sign_time, s.agreement_sign_address, s.file_id, s.team_size, s.areas_expertise from supplier s where s.supplier_id = ? and s.supplier_name = ? and s.supplier_contact = ? and s.supplier_phone = ? and s.supplier_email = ? and s.supplier_type = ? and s.supplier_main_business_type = ? and s.supplier_scope_supply = ? and s.social_credit_code = ? and s.supplier__province = ? and s.supplier__city = ? and s.supplier_bank_address = ? and s.supplier_address = ? and s.production_cycle = ? and s.logistics_cycle = ? and s.supplier_boss = ? and s.contract_signing_time = ? and s.contract_scope_time = ? and s.contract_scope_time_start = ?_start and s.contract_scope_time_end = ?_end and s.operate_employee_id = ? and s.operate_time = ? and s.supplier_origin = ? and s.supplier_status = ? and s.is_use = ? and s.receive_unit_manage_id = ? and s.agreement_type = ? and s.agreement_sign_time = ? and s.agreement_sign_address = ? and s.file_id = ? and s.team_size = ? and s.areas_expertise = ?" ;
	private final static String RESULTSETFIELDLIST = "supplier_id,supplier_name,supplier_contact,supplier_phone,supplier_email,supplier_type,supplier_main_business_type,supplier_scope_supply,social_credit_code,supplier__province,supplier__city,supplier_bank_address,supplier_address,production_cycle,logistics_cycle,supplier_boss,contract_signing_time,contract_scope_time,contract_scope_time_start,contract_scope_time_end,operate_employee_id,operate_time,supplier_origin,supplier_status,is_use,receive_unit_manage_id,agreement_type,agreement_sign_time,agreement_sign_address,file_id,team_size,areas_expertise";
	private final static String[] fieldNames = { "supplier_id", "supplier_name", "supplier_contact", "supplier_phone", "supplier_email", "supplier_type", "supplier_main_business_type", "supplier_scope_supply", "social_credit_code", "supplier__province", "supplier__city", "supplier_bank_address", "supplier_address", "production_cycle", "logistics_cycle", "supplier_boss", "contract_signing_time", "contract_scope_time", "contract_scope_time_start", "contract_scope_time_end", "operate_employee_id", "operate_time", "supplier_origin", "supplier_status", "is_use", "receive_unit_manage_id", "agreement_type", "agreement_sign_time", "agreement_sign_address", "file_id", "team_size", "areas_expertise"};
}
