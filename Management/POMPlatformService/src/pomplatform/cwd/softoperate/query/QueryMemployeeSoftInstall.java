package pomplatform.cwd.softoperate.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cwd.softoperate.bean.BaseMemployeeSoftInstall;
import pomplatform.cwd.softoperate.bean.ConditionMemployeeSoftInstall;

public class QueryMemployeeSoftInstall extends AbstractQuery<BaseMemployeeSoftInstall, ConditionMemployeeSoftInstall>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeeSoftInstall.class);

	public QueryMemployeeSoftInstall() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("em.* from ( SELECT em.employee_id");
	}

	@Override
	public BaseCollection<BaseMemployeeSoftInstall> executeQuery( KeyValuePair[] replacements, ConditionMemployeeSoftInstall condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseMemployeeSoftInstall generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeeSoftInstall __base = new BaseMemployeeSoftInstall();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select em.* from ( SELECT em.employee_id, em.employee_name, em.employee_no, em.department_id, CASE WHEN cuc.employee_id ISNULL THEN 1 ELSE 2 END AS status FROM employees em LEFT JOIN ( SELECT employee_id FROM cwd_user_configs GROUP BY employee_id ) cuc ON em.employee_id = cuc.employee_id WHERE em.status = 0 ) em WHERE em.employee_no like ? and em.employee_name like ? and em.department_id = ? and em.status = ? ORDER BY em.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_name,employee_no,department_id,status";
	private final static String[] fieldNames = { "employee_no", "employee_name", "department_id", "status"};
}
