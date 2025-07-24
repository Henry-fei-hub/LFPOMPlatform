package pomplatform.employeerescord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeerescord.bean.BaseOnJobEmployees;
import pomplatform.employeerescord.bean.ConditionOnJobEmployees;

public class QueryOnJobEmployees extends AbstractQuery<BaseOnJobEmployees, ConditionOnJobEmployees>
{

	private static final Logger __logger = Logger.getLogger(QueryOnJobEmployees.class);

	public QueryOnJobEmployees() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseOnJobEmployees> executeQuery( KeyValuePair[] replacements, ConditionOnJobEmployees condition ) throws java.sql.SQLException {
		if(__queryConditions != null && __queryConditions.length > 0) return execute(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements
			);
	}

	public BaseCollection<BaseOnJobEmployees> runQuery( KeyValuePair[] replacements, ConditionOnJobEmployees condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements
			);
	}

	public BaseCollection<BaseOnJobEmployees> execute( KeyValuePair[] replacements, ConditionOnJobEmployees condition ) throws java.sql.SQLException {
		if(__queryConditions == null || __queryConditions.length == 0) return executeQuery(replacements, condition);
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements
			);
	}

	@Override
	public BaseOnJobEmployees generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnJobEmployees __base = new BaseOnJobEmployees();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select employee_id, employee_no, employee_name,department_id,plate_id from employees where status = 0" ;
	private final static String __originalSQL = "select employee_id, employee_no, employee_name,department_id,plate_id from employees where status = 0";
	private final static String[] __queryConditions = new String[0];
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,plate_id";
	private final static String[] fieldNames = { };
}
