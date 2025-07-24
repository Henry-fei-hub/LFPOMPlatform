package pomplatform.getEmployeeIdByRoleId.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeIdByRoleId;

public class QuerygetEmployeeIdByRoleId extends AbstractQuery<BasegetEmployeeIdByRoleId, ConditiongetEmployeeIdByRoleId>
{

	private static final Logger __logger = Logger.getLogger(QuerygetEmployeeIdByRoleId.class);

	public QuerygetEmployeeIdByRoleId() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BasegetEmployeeIdByRoleId> executeQuery( KeyValuePair[] replacements, ConditiongetEmployeeIdByRoleId condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getRoleId(), 
				condition.getPlateId(),
				condition.getChangePlateDate(),
				condition.getPlateId()
			);
	}

	@Override
	public BasegetEmployeeIdByRoleId generateBase(Object[] __data) throws java.sql.SQLException {
		BasegetEmployeeIdByRoleId __base = new BasegetEmployeeIdByRoleId();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT a.employee_id, b.employee_no, b.employee_name from employee_roles a left join employees b on a.employee_id = b.employee_id LEFT JOIN employee_change_plate_records c on a.employee_id = c.employee_id WHERE a.role_id= ? and a.department_id in (SELECT child_id from department_ids WHERE department_id in (SELECT department_id from departments WHERE parent_id = 1 and plate_id = ?)) and c.change_plate_date = ? and c.plate_id = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name";
	private final static String[] fieldNames = { "role_id", "plate_id", "change_plate_date", "plate_id"};
}
