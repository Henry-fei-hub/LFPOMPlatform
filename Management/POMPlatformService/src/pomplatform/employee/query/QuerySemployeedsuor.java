package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseSemployeedsuor;
import pomplatform.employee.bean.ConditionSemployeedsuor;

public class QuerySemployeedsuor extends AbstractQuery<BaseSemployeedsuor, ConditionSemployeedsuor>
{

	private static final Logger __logger = Logger.getLogger(QuerySemployeedsuor.class);

	public QuerySemployeedsuor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseSemployeedsuor> executeQuery( KeyValuePair[] replacements, ConditionSemployeedsuor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getStatus(), 
				condition.getUsableStatus(), 
				condition.getIsDepartment(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo()
			);
	}

	@Override
	public BaseSemployeedsuor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSemployeedsuor __base = new BaseSemployeedsuor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeePassword(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setResignationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setUsableStatus(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsDepartment(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
		if(args[1] != null) __statement.setBoolean(count++, (java.lang.Boolean)args[1]);
		if(args[2] != null) __statement.setBoolean(count++, (java.lang.Boolean)args[2]);
		if(args[3] != null) __statement.setBoolean(count++, (java.lang.Boolean)args[3]);
		if(args[4] != null) __statement.setString(count++, (java.lang.String)args[4]);
		if(args[5] != null) __statement.setString(count++, (java.lang.String)args[5]);
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

	private final static String __SQLText = "select e.employee_id, e.employee_no, e.employee_name, e.department_id, e.employee_password, e.mobile, e.email, e.onboard_date, e.resignation_date, e.status, e.usable_status, e.is_department, e.locked from employees e where e.department_id = ? and e.status = ? and e.usable_status = ? and e.is_department in (select child_id from department_ids where department_id = ? ) and e.employee_name like ? and e.employee_no = ? and e.status = 0" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,employee_password,mobile,email,onboard_date,resignation_date,status,usable_status,is_department,locked";
	private final static String[] fieldNames = { "department_id", "status", "usable_status", "is_department", "employee_name", "employee_no"};
}
