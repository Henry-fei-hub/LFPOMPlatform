package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseEmployeeShouldCheckinPersonNum;
import pomplatform.checking.bean.ConditionEmployeeShouldCheckinPersonNum;

public class QueryEmployeeShouldCheckinPersonNum extends AbstractQuery<BaseEmployeeShouldCheckinPersonNum, ConditionEmployeeShouldCheckinPersonNum>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeShouldCheckinPersonNum.class);

	public QueryEmployeeShouldCheckinPersonNum() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("child_id");
	}

	@Override
	public BaseCollection<BaseEmployeeShouldCheckinPersonNum> executeQuery( KeyValuePair[] replacements, ConditionEmployeeShouldCheckinPersonNum condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseEmployeeShouldCheckinPersonNum generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeShouldCheckinPersonNum __base = new BaseEmployeeShouldCheckinPersonNum();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setShouldCheckinPerson(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT count(employee_id) as should_checkin_person FROM employees WHERE is_check = true and status = 0 and employee_id > 0 and department_id in (select child_id from department_ids where department_id = ?)" ;
	private final static String RESULTSETFIELDLIST = "should_checkin_person";
	private final static String[] fieldNames = { "department_id"};
}
