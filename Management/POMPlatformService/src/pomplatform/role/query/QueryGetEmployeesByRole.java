package pomplatform.role.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.role.bean.BaseGetEmployeesByRole;
import pomplatform.role.bean.ConditionGetEmployeesByRole;

public class QueryGetEmployeesByRole extends AbstractQuery<BaseGetEmployeesByRole, ConditionGetEmployeesByRole>
{

	private static final Logger __logger = Logger.getLogger(QueryGetEmployeesByRole.class);

	public QueryGetEmployeesByRole() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id as idd");
	}

	@Override
	public BaseCollection<BaseGetEmployeesByRole> executeQuery( KeyValuePair[] replacements, ConditionGetEmployeesByRole condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getRoleId(),
				condition.getPlateId()
			);
	}

	@Override
	public BaseGetEmployeesByRole generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetEmployeesByRole __base = new BaseGetEmployeesByRole();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setIdd(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setVal(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
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

	private final static String __SQLText = "select e.employee_id as idd, e.employee_name as val from employees e left join employee_roles er on e.employee_id = er.employee_id LEFT JOIN departments c on er.department_id = c.department_id where er.role_id = ? and c.plate_id = ? and e.status = 0" ;
	private final static String RESULTSETFIELDLIST = "idd,val";
	private final static String[] fieldNames = { "role_id","plate_id"};
}
