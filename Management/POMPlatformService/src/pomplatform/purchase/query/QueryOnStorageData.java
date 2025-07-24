package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseOnStorageData;
import pomplatform.purchase.bean.ConditionOnStorageData;

public class QueryOnStorageData extends AbstractQuery<BaseOnStorageData, ConditionOnStorageData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnStorageData.class);

	public QueryOnStorageData() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("storage_id");
	}

	@Override
	public BaseCollection<BaseOnStorageData> executeQuery( KeyValuePair[] replacements, ConditionOnStorageData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStorageCode(), 
				condition.getStorageName(), 
				condition.getStorageType(), 
				condition.getStorageAreaId(), 
				condition.getCountry(), 
				condition.getProvince(), 
				condition.getCity()
			);
	}

	@Override
	public BaseOnStorageData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnStorageData __base = new BaseOnStorageData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setStorageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStorageCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStorageName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStorageType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStorageAreaId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCountry(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT storage_id,storage_code,storage_name,storage_type,storage_area_id ,country,province,city,address,contact_employee_id,contact_phone,parent_id,create_employee_id,create_time,is_enabled,remark FROM storages WHERE storage_code like ? AND storage_name like ? AND storage_type = ? AND storage_area_id = ? AND country = ? AND province = ? AND city = ? ORDER BY storage_id desc" ;
	private final static String RESULTSETFIELDLIST = "storage_id,storage_code,storage_name,storage_type,storage_area_id,country,province,city,address,contact_employee_id,contact_phone,parent_id,create_employee_id,create_time,is_enabled,remark";
	private final static String[] fieldNames = { "storage_code", "storage_name", "storage_type", "storage_area_id", "country", "province", "city"};
}
