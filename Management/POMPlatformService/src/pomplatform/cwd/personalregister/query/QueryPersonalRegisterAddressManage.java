package pomplatform.cwd.personalregister.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cwd.personalregister.bean.BasePersonalRegisterAddressManage;
import pomplatform.cwd.personalregister.bean.ConditionPersonalRegisterAddressManage;

public class QueryPersonalRegisterAddressManage extends AbstractQuery<BasePersonalRegisterAddressManage, ConditionPersonalRegisterAddressManage>
{

	private static final Logger __logger = Logger.getLogger(QueryPersonalRegisterAddressManage.class);

	public QueryPersonalRegisterAddressManage() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.personal_register_address_id");
	}

	@Override
	public BaseCollection<BasePersonalRegisterAddressManage> executeQuery( KeyValuePair[] replacements, ConditionPersonalRegisterAddressManage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getIpAddress(), 
				condition.getMacAddress(), 
				condition.getWorkplaceName()
			);
	}

	@Override
	public BasePersonalRegisterAddressManage generateBase(Object[] __data) throws java.sql.SQLException {
		BasePersonalRegisterAddressManage __base = new BasePersonalRegisterAddressManage();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPersonalRegisterAddressId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIpAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMacAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkplaceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkplaceName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRegisterTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setActive(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "select a.personal_register_address_id, a.employee_id, a.ip_address, a.mac_address, a.workplace_id, b.workplace_name, a.register_time, a.active from personal_register_addresses a LEFT JOIN company_workplaces b on a.workplace_id = b.company_workplace_id WHERE a.employee_id = ? and a.ip_address like ? and a.mac_address like ? and b.workplace_name like ? order by register_time desc" ;
	private final static String RESULTSETFIELDLIST = "personal_register_address_id,employee_id,ip_address,mac_address,workplace_id,workplace_name,register_time,active";
	private final static String[] fieldNames = { "employee_id", "ip_address", "mac_address", "workplace_name"};
}
