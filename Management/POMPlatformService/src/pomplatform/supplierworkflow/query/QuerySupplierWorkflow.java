package pomplatform.supplierworkflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.supplierworkflow.bean.BaseSupplierWorkflow;
import pomplatform.supplierworkflow.bean.ConditionSupplierWorkflow;

public class QuerySupplierWorkflow extends AbstractQuery<BaseSupplierWorkflow, ConditionSupplierWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QuerySupplierWorkflow.class);

	public QuerySupplierWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(21);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rum.receive_unit_manage_id");
	}

	@Override
	public BaseCollection<BaseSupplierWorkflow> executeQuery( KeyValuePair[] replacements, ConditionSupplierWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getReceiveUnit(), 
				condition.getBankAccount(), 
				condition.getBankName(), 
				condition.getReceiveUnitAddress(), 
				condition.getOperateEmployeeId(), 
				condition.getOperateTime(), 
				condition.getOrigin(), 
				condition.getReceiveUnitType(), 
				condition.getCompanyId(), 
				condition.getSalaryType(), 
				condition.getProvince(), 
				condition.getCity(), 
				condition.getBankAddress(), 
				condition.getReceiveUnitPhone(), 
				condition.getSwiftCode(), 
				condition.getCountryId(), 
				condition.getCountryCode(), 
				condition.getPassport(), 
				condition.getBankId(), 
				condition.getAccountType(), 
				condition.getIsUse()
			);
	}

	@Override
	public BaseSupplierWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSupplierWorkflow __base = new BaseSupplierWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setReceiveUnitManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceiveUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOrigin(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalaryType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceiveUnitPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSwiftCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCountryId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCountryCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPassport(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsUse(GenericBase.__getInt(val));
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
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setInt(count++, GenericBase.__getInt(args[19]));
		if(args[20] != null) __statement.setInt(count++, GenericBase.__getInt(args[20]));
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

	private final static String __SQLText = "select rum.receive_unit_manage_id, rum.receive_unit, rum.bank_account, rum.bank_name, rum.receive_unit_address, rum.operate_employee_id, rum.operate_time, rum.origin, rum.receive_unit_type, rum.company_id, rum.salary_type, rum.province, rum.city, rum.bank_address, rum.receive_unit_phone, rum.swift_code, rum.country_id, rum.country_code, rum.passport, rum.bank_id, rum.account_type, rum.is_use from receive_unit_manages rum where rum.receive_unit = ? and rum.bank_account = ? and rum.bank_name = ? and rum.receive_unit_address = ?_address and rum.operate_employee_id = ? and rum.operate_time = ? and rum.origin = ? and rum.receive_unit_type = ?_type and rum.company_id = ? and rum.salary_type = ? and rum.province = ? and rum.city = ? and rum.bank_address = ? and rum.receive_unit_phone = ?_phone and rum.swift_code = ? and rum.country_id = ? and rum.country_code = ? and rum.passport = ? and rum.bank_id = ? and rum.account_type = ? and rum.is_use = ?" ;
	private final static String RESULTSETFIELDLIST = "receive_unit_manage_id,receive_unit,bank_account,bank_name,receive_unit_address,operate_employee_id,operate_time,origin,receive_unit_type,company_id,salary_type,province,city,bank_address,receive_unit_phone,swift_code,country_id,country_code,passport,bank_id,account_type,is_use";
	private final static String[] fieldNames = { "receive_unit", "bank_account", "bank_name", "receive_unit_address", "operate_employee_id", "operate_time", "origin", "receive_unit_type", "company_id", "salary_type", "province", "city", "bank_address", "receive_unit_phone", "swift_code", "country_id", "country_code", "passport", "bank_id", "account_type", "is_use"};
}
