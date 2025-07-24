package pomplatform.clocks.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.clocks.bean.BaseEmployeeFingers;
import pomplatform.clocks.bean.ConditionEmployeeFingers;

public class QueryEmployeeFingers extends AbstractQuery<BaseEmployeeFingers, ConditionEmployeeFingers>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeFingers.class);

	public QueryEmployeeFingers() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("hef.*");
	}

	@Override
	public BaseCollection<BaseEmployeeFingers> executeQuery( KeyValuePair[] replacements, ConditionEmployeeFingers condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseEmployeeFingers generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeFingers __base = new BaseEmployeeFingers();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setHrEmpFingerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmpCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTemplate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFpversion(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFingerType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSize(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setValid(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsActive(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFid(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUtime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT hef.*,e.employee_no,e.employee_name,e.department_id FROM hr_emp_fingers hef LEFT JOIN employees e ON hef.employee_id = e.employee_id WHERE e.employee_no like ? AND e.employee_id =? AND e.department_id in (select child_id from department_ids where department_id = ?)" ;
	private final static String RESULTSETFIELDLIST = "hr_emp_finger_id,employee_id,sn,emp_code,template,fpversion,finger_type,size,valid,is_active,fid,utime,employee_no,employee_name,department_id";
	private final static String[] fieldNames = { "employee_no", "employee_id", "department_id"};
}
