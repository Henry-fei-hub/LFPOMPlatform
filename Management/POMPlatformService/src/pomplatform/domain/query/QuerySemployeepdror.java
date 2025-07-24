package pomplatform.domain.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.domain.bean.BaseSemployeepdror;
import pomplatform.domain.bean.ConditionSemployeepdror;

public class QuerySemployeepdror extends AbstractQuery<BaseSemployeepdror, ConditionSemployeepdror>
{

	private static final Logger __logger = Logger.getLogger(QuerySemployeepdror.class);

	public QuerySemployeepdror() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id as idd");
	}

	@Override
	public BaseCollection<BaseSemployeepdror> executeQuery( KeyValuePair[] replacements, ConditionSemployeepdror condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getRoleId(), 
				condition.getEmployeeName()
			);
	}

	@Override
	public BaseSemployeepdror generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSemployeepdror __base = new BaseSemployeepdror();
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
		if(args[2] != null) __statement.setInt(count++, (java.lang.Integer)args[2]);
		if(args[3] != null) __statement.setString(count++, (java.lang.String)args[3]);
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

	private final static String __SQLText = "select e.employee_id as idd, e.employee_name as val from employees e,employee_roles er where e.plate_id = ? and e.department_id in (select child_id from department_ids where department_id = ? ) and e.employee_id = er.employee_id and er.role_id = ? and e.employee_name = ? and e.status = 0" ;
	private final static String RESULTSETFIELDLIST = "idd,val";
	private final static String[] fieldNames = { "plate_id", "department_id", "role_id", "employee_name"};
}
