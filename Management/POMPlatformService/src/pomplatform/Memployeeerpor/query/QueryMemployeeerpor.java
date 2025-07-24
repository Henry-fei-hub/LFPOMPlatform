package pomplatform.Memployeeerpor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.Memployeeerpor.bean.BaseMemployeeerpor;
import pomplatform.Memployeeerpor.bean.ConditionMemployeeerpor;

public class QueryMemployeeerpor extends AbstractQuery<BaseMemployeeerpor, ConditionMemployeeerpor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeeerpor.class);

	public QueryMemployeeerpor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT e.employee_name");
	}

	@Override
	public BaseCollection<BaseMemployeeerpor> executeQuery( KeyValuePair[] replacements, ConditionMemployeeerpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getRoleId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseMemployeeerpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeeerpor __base = new BaseMemployeeerpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRoleId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select DISTINCT e.employee_name,e.employee_id,e.employee_no, e.role_id,e.plate_id from employees e,employee_roles er WHERE e.employee_id=er.employee_id and er.role_id=? and e.plate_id=? and e.status=0" ;
	private final static String RESULTSETFIELDLIST = "employee_name,employee_id,employee_no,role_id,plate_id";
	private final static String[] fieldNames = { "role_id", "plate_id"};
}
