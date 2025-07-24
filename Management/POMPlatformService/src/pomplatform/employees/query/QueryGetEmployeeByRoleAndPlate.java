package pomplatform.employees.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employees.bean.BaseGetEmployeeByRoleAndPlate;
import pomplatform.employees.bean.ConditionGetEmployeeByRoleAndPlate;

public class QueryGetEmployeeByRoleAndPlate extends AbstractQuery<BaseGetEmployeeByRoleAndPlate, ConditionGetEmployeeByRoleAndPlate>
{

	private static final Logger __logger = Logger.getLogger(QueryGetEmployeeByRoleAndPlate.class);

	public QueryGetEmployeeByRoleAndPlate() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	@Override
	public BaseCollection<BaseGetEmployeeByRoleAndPlate> executeQuery( KeyValuePair[] replacements, ConditionGetEmployeeByRoleAndPlate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getRoleId(), 
				condition.getPlateId(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseGetEmployeeByRoleAndPlate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetEmployeeByRoleAndPlate __base = new BaseGetEmployeeByRoleAndPlate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyWeixin(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT d.employee_id, e.company_weixin, d.plate_id from (SELECT DISTINCT(a.employee_id),  b.plate_id from employee_roles a LEFT JOIN departments b on a.department_id = b.department_id  where a.role_id = ? and a.department_id in (select department_id from departments where plate_id = ?) group by a.employee_id, b.plate_id) d LEFT JOIN employees e on d.employee_id = e.employee_id where e.status = ? order by d.plate_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,company_weixin,plate_id";
	private final static String[] fieldNames = { "role_id", "plate_id", "status"};
}
