package pomplatform.project.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseOnLoadProjectChangeEmployee;
import pomplatform.project.bean.ConditionOnLoadProjectChangeEmployee;

public class QueryOnLoadProjectChangeEmployee extends AbstractQuery<BaseOnLoadProjectChangeEmployee, ConditionOnLoadProjectChangeEmployee>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectChangeEmployee.class);

	public QueryOnLoadProjectChangeEmployee() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectChangeEmployee> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectChangeEmployee condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseOnLoadProjectChangeEmployee generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectChangeEmployee __base = new BaseOnLoadProjectChangeEmployee();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select distinct a.project_id,a.employee_id,b.employee_no,b.employee_name,b.plate_id,b.grade_id,b.status,0.0 as integral from project_employees a left join employees b on a.employee_id = b.employee_id where a.project_id = ? and b.status = ? " ;
	private final static String RESULTSETFIELDLIST = "project_id,employee_id,employee_no,employee_name,plate_id,grade_id,status,integral";
	private final static String[] fieldNames = { "project_id", "status"};
}
