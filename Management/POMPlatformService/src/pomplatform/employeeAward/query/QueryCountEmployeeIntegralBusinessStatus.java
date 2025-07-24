package pomplatform.employeeAward.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeAward.bean.BaseCountEmployeeIntegralBusinessStatus;
import pomplatform.employeeAward.bean.ConditionCountEmployeeIntegralBusinessStatus;

public class QueryCountEmployeeIntegralBusinessStatus extends AbstractQuery<BaseCountEmployeeIntegralBusinessStatus, ConditionCountEmployeeIntegralBusinessStatus>
{

	private static final Logger __logger = Logger.getLogger(QueryCountEmployeeIntegralBusinessStatus.class);

	public QueryCountEmployeeIntegralBusinessStatus() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("status");
	}

	@Override
	public BaseCollection<BaseCountEmployeeIntegralBusinessStatus> executeQuery( KeyValuePair[] replacements, ConditionCountEmployeeIntegralBusinessStatus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseCountEmployeeIntegralBusinessStatus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCountEmployeeIntegralBusinessStatus __base = new BaseCountEmployeeIntegralBusinessStatus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCountNum(GenericBase.__getLong(val));
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

	private final static String __SQLText = "SELECT status,count(status) as count_num FROM employee_integral_business WHERE employee_id = ? GROUP BY status ORDER BY status ASC" ;
	private final static String RESULTSETFIELDLIST = "status,count_num";
	private final static String[] fieldNames = { "employee_id"};
}
