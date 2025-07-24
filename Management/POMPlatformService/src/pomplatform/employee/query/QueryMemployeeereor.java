package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseMemployeeereor;
import pomplatform.employee.bean.ConditionMemployeeereor;

public class QueryMemployeeereor extends AbstractQuery<BaseMemployeeereor, ConditionMemployeeereor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeeereor.class);

	public QueryMemployeeereor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("distinct f.function_code");
	}

	@Override
	public BaseCollection<BaseMemployeeereor> executeQuery( KeyValuePair[] replacements, ConditionMemployeeereor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseMemployeeereor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeeereor __base = new BaseMemployeeereor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFunctionCode(GenericBase.__getString(val));
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

	private final static String __SQLText = "select distinct f.function_code from employees e left join employee_roles er on e.employee_id = er.employee_id left join role_functions rf on er.role_id = rf.role_id left join functions f on f.function_id = rf.function_id where e.employee_id = ? and e.status = 0 and f.application_id = 1" ;
	private final static String RESULTSETFIELDLIST = "function_code";
	private final static String[] fieldNames = { "employee_id"};
}
