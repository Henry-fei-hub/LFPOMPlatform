package pomplatform.cwd .query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cwd .bean.BaseSoftwareUpdateVersionWithS;
import pomplatform.cwd .bean.ConditionSoftwareUpdateVersionWithS;

public class QuerySoftwareUpdateVersionWithS extends AbstractQuery<BaseSoftwareUpdateVersionWithS, ConditionSoftwareUpdateVersionWithS>
{

	private static final Logger __logger = Logger.getLogger(QuerySoftwareUpdateVersionWithS.class);

	public QuerySoftwareUpdateVersionWithS() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("suv.software_update_version_id");
	}

	@Override
	public BaseCollection<BaseSoftwareUpdateVersionWithS> executeQuery( KeyValuePair[] replacements, ConditionSoftwareUpdateVersionWithS condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTitle(), 
				condition.getRemark(), 
				condition.getSqlScript(), 
				condition.getSoftwareUpdateVersionId(), 
				condition.getVersionNo(), 
				condition.getSoftwareType(), 
				condition.getEmployeeId(), 
				condition.getIsReboot()
			);
	}

	@Override
	public BaseSoftwareUpdateVersionWithS generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSoftwareUpdateVersionWithS __base = new BaseSoftwareUpdateVersionWithS();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSoftwareUpdateVersionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setVersionNo(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSoftwareType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSqlScript(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsReboot(GenericBase.__getBoolean(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[7]));
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

	private final static String __SQLText = "select suv.software_update_version_id, suv.version_no, suv.title, suv.remark, suv.software_type, suv.employee_id, suv.create_time, suv.sql_script, suv.is_reboot from software_update_versions suv where suv.title like ? and suv.remark like ? and suv.sql_script like ? and suv.software_update_version_id = ? and suv.version_no = ? and suv.software_type = ? and suv.employee_id = ? and suv.is_reboot = ?" ;
	private final static String RESULTSETFIELDLIST = "software_update_version_id,version_no,title,remark,software_type,employee_id,create_time,sql_script,is_reboot";
	private final static String[] fieldNames = { "title", "remark", "sql_script", "software_update_version_id", "version_no", "software_type", "employee_id", "is_reboot"};
}
