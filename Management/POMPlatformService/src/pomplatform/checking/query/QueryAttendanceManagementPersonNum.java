package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseAttendanceManagementPersonNum;
import pomplatform.checking.bean.ConditionAttendanceManagementPersonNum;

public class QueryAttendanceManagementPersonNum extends AbstractQuery<BaseAttendanceManagementPersonNum, ConditionAttendanceManagementPersonNum>
{

	private static final Logger __logger = Logger.getLogger(QueryAttendanceManagementPersonNum.class);

	public QueryAttendanceManagementPersonNum() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.all");
	}

	@Override
	public BaseCollection<BaseAttendanceManagementPersonNum> executeQuery( KeyValuePair[] replacements, ConditionAttendanceManagementPersonNum condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseAttendanceManagementPersonNum generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttendanceManagementPersonNum __base = new BaseAttendanceManagementPersonNum();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAll(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setShould(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT a.all,b.should FROM (SELECT count(employee_id) as all FROM employees WHERE employee_id > 0 AND status = 0 AND department_id in (select child_id from department_ids where department_id = ?)) a,(SELECT COUNT(employee_id) as should FROM employees WHERE employee_id > 0 AND status = 0 AND is_check = true AND department_id in (select child_id from department_ids where department_id = ?)) b" ;
	private final static String RESULTSETFIELDLIST = "all,should";
	private final static String[] fieldNames = { "department_id", "department_id"};
}
