package pomplatform.projectteambuild.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectteambuild.bean.BaseMprojectEmployeeGrades;
import pomplatform.projectteambuild.bean.ConditionMprojectEmployeeGrades;

public class QueryMprojectEmployeeGrades extends AbstractQuery<BaseMprojectEmployeeGrades, ConditionMprojectEmployeeGrades>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectEmployeeGrades.class);

	public QueryMprojectEmployeeGrades() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT pe.employee_id");
	}

	@Override
	public BaseCollection<BaseMprojectEmployeeGrades> executeQuery( KeyValuePair[] replacements, ConditionMprojectEmployeeGrades condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseMprojectEmployeeGrades generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectEmployeeGrades __base = new BaseMprojectEmployeeGrades();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
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

	private final static String __SQLText = "SELECT DISTINCT pe.employee_id,e.employee_no,e.employee_name,e.department_id,e.grade_id,e.status FROM project_employees pe LEFT JOIN employees e on pe.employee_id = e.employee_id WHERE pe.project_id = ? and e.status = 0" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,grade_id,status";
	private final static String[] fieldNames = { "project_id"};
}
