package pomplatform.employeeRole.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeRole.bean.BaseGetRole93Employees;
import pomplatform.employeeRole.bean.ConditionGetRole93Employees;

public class QueryGetRole93Employees extends AbstractQuery<BaseGetRole93Employees, ConditionGetRole93Employees>
{

	private static final Logger __logger = Logger.getLogger(QueryGetRole93Employees.class);

	public QueryGetRole93Employees() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT er.employee_id");
	}

	@Override
	public BaseCollection<BaseGetRole93Employees> executeQuery( KeyValuePair[] replacements, ConditionGetRole93Employees condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		return executeQuery(replacements
			);
	}

	public BaseCollection<BaseGetRole93Employees> runQuery( KeyValuePair[] replacements, ConditionGetRole93Employees condition ) throws java.sql.SQLException {
		return runQuery(replacements
			);
	}

	public BaseCollection<BaseGetRole93Employees> execute( KeyValuePair[] replacements, ConditionGetRole93Employees condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		return execute(condition, replacements
			);
	}

	@Override
	public BaseGetRole93Employees generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetRole93Employees __base = new BaseGetRole93Employees();
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
		return count;
	}

	@Override
	public String getSQLText() {
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String[] getQueryStringArray()  {
		return __queryConditions;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	private final static String __SQLText = "select DISTINCT er.employee_id,e.employee_no,e.employee_name from employee_roles as er left join employees as e on e.employee_id = er.employee_id where er.role_id = 93 and er.employee_id >0 and e.status = 0" ;
	private final static String __originalSQL = "select DISTINCT er.employee_id,e.employee_no,e.employee_name from employee_roles as er left join employees as e on e.employee_id = er.employee_id where er.role_id = 93 and er.employee_id >0 and e.status = 0";
	private final static String[] __queryConditions = new String[0];
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name";
	private final static String[] fieldNames = { };
}
