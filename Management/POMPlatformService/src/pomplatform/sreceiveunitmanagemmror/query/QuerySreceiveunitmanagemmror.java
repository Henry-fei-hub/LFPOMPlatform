package pomplatform.sreceiveunitmanagemmror.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sreceiveunitmanagemmror.bean.BaseSreceiveunitmanagemmror;
import pomplatform.sreceiveunitmanagemmror.bean.ConditionSreceiveunitmanagemmror;

public class QuerySreceiveunitmanagemmror extends AbstractQuery<BaseSreceiveunitmanagemmror, ConditionSreceiveunitmanagemmror>
{

	private static final Logger __logger = Logger.getLogger(QuerySreceiveunitmanagemmror.class);

	public QuerySreceiveunitmanagemmror() throws java.sql.SQLException 
	{
		setParameterNumber(18);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rum.receive_unit_manage_id");
	}

	@Override
	public BaseCollection<BaseSreceiveunitmanagemmror> executeQuery( KeyValuePair[] replacements, ConditionSreceiveunitmanagemmror condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getOperateEmployeeId(), 
				condition.getReceiveUnit(), 
				condition.getBankAccount(), 
				condition.getBankName(), 
				condition.getReceiveUnitAddress(), 
				condition.getBankAddress(), 
				condition.getReceiveUnitPhone(), 
				condition.getSwiftCode(), 
				condition.getMinOperateTime(), 
				condition.getMaxOperateTime(), 
				condition.getReceiveUnitManageId(), 
				condition.getOrigin(), 
				condition.getCompanyId(), 
				condition.getProvince(), 
				condition.getCity(), 
				condition.getBankId(), 
				condition.getAccountType(),
				condition.getVoucherType()
			);
	}

	@Override
	public BaseSreceiveunitmanagemmror generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSreceiveunitmanagemmror __base = new BaseSreceiveunitmanagemmror();
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
		if((val = __data[count++]) != null) __base.setVoucherType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierType(GenericBase.__getInt(val));
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
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
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

	private final static String __SQLText = "select rum.receive_unit_manage_id, rum.receive_unit, rum.bank_account, rum.bank_name, rum.receive_unit_address, rum.operate_employee_id, rum.operate_time, rum.origin, rum.receive_unit_type, rum.company_id, rum.salary_type, rum.province, rum.city, rum.bank_address, rum.receive_unit_phone, rum.swift_code, rum.country_id, rum.country_code, rum.passport, rum.bank_id, rum.account_type, rum.voucher_type, rum.supplier_type from receive_unit_manages rum where rum.operate_employee_id = ? and rum.receive_unit like ? and rum.bank_account like ? and rum.bank_name like ? and rum.receive_unit_address like ?_address and rum.bank_address like ? and rum.receive_unit_phone like ?_phone and rum.swift_code like ? and rum.operate_time between ? and ? and rum.receive_unit_manage_id = ?_manage_id and rum.origin = ? and rum.company_id = ? and rum.province = ? and rum.city = ? and rum.bank_id = ? and rum.account_type = ? and rum.voucher_type = ? ORDER BY rum.receive_unit_manage_id DESC" ;
	private final static String RESULTSETFIELDLIST = "receive_unit_manage_id,receive_unit,bank_account,bank_name,receive_unit_address,operate_employee_id,operate_time,origin,receive_unit_type,company_id,salary_type,province,city,bank_address,receive_unit_phone,swift_code,country_id,country_code,passport,bank_id,account_type,voucher_type,supplier_type";
	private final static String[] fieldNames = { "operate_employee_id", "receive_unit", "bank_account", "bank_name", "receive_unit_address", "bank_address", "receive_unit_phone", "swift_code", "min_operate_time", "max_operate_time", "receive_unit_manage_id", "origin", "company_id", "province", "city", "bank_id", "account_type","voucher_type"};
}
