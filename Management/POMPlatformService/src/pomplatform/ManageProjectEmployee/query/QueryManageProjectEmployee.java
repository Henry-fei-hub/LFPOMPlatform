package pomplatform.ManageProjectEmployee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ManageProjectEmployee.bean.BaseManageProjectEmployee;
import pomplatform.ManageProjectEmployee.bean.ConditionManageProjectEmployee;

public class QueryManageProjectEmployee extends AbstractQuery<BaseManageProjectEmployee, ConditionManageProjectEmployee>
{

	private static final Logger __logger = Logger.getLogger(QueryManageProjectEmployee.class);

	public QueryManageProjectEmployee() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("manage_project_id");
	}

	@Override
	public BaseCollection<BaseManageProjectEmployee> executeQuery( KeyValuePair[] replacements, ConditionManageProjectEmployee condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getManageProjectId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseManageProjectEmployee generateBase(Object[] __data) throws java.sql.SQLException {
		BaseManageProjectEmployee __base = new BaseManageProjectEmployee();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setManageProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAssignIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAssignedIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select manage_project_id,employee_id,sum(assign_integral) as assign_integral,sum(assigned_integral) as assigned_integral from manage_project_employee_records where manage_project_id = ? and employee_id = ? group by manage_project_id,employee_id" ;
	private final static String RESULTSETFIELDLIST = "manage_project_id,employee_id,assign_integral,assigned_integral";
	private final static String[] fieldNames = { "manage_project_id", "employee_id"};
}
