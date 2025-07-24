package pomplatform.employee.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseGetPlateIdByRole;
import pomplatform.employee.bean.ConditionGetPlateIdByRole;

public class QueryGetPlateIdByRole extends AbstractQuery<BaseGetPlateIdByRole, ConditionGetPlateIdByRole>
{

	private static final Logger __logger = Logger.getLogger(QueryGetPlateIdByRole.class);

	public QueryGetPlateIdByRole() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("d.plate_id");
	}

	@Override
	public BaseCollection<BaseGetPlateIdByRole> executeQuery( KeyValuePair[] replacements, ConditionGetPlateIdByRole condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getRoleId()
			);
	}

	@Override
	public BaseGetPlateIdByRole generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetPlateIdByRole __base = new BaseGetPlateIdByRole();
		int count = 0;
		Object val;
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

	private final static String __SQLText = "SELECT d.plate_id FROM departments d LEFT JOIN employee_roles e on d.department_id = e.department_id WHERE e.employee_id= ? AND e.role_id = ? AND e.department_id !=0 AND d.plate_id !=0 AND d.plate_id IS NOT NULL;" ;
	private final static String RESULTSETFIELDLIST = "plate_id";
	private final static String[] fieldNames = { "employee_id", "role_id"};
}
