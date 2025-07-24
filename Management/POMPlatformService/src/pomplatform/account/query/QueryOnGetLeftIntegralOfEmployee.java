package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnGetLeftIntegralOfEmployee;
import pomplatform.account.bean.ConditionOnGetLeftIntegralOfEmployee;

public class QueryOnGetLeftIntegralOfEmployee extends AbstractQuery<BaseOnGetLeftIntegralOfEmployee, ConditionOnGetLeftIntegralOfEmployee>
{

	private static final Logger __logger = Logger.getLogger(QueryOnGetLeftIntegralOfEmployee.class);

	public QueryOnGetLeftIntegralOfEmployee() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.employee_id");
	}

	@Override
	public BaseCollection<BaseOnGetLeftIntegralOfEmployee> executeQuery( KeyValuePair[] replacements, ConditionOnGetLeftIntegralOfEmployee condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnGetLeftIntegralOfEmployee generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnGetLeftIntegralOfEmployee __base = new BaseOnGetLeftIntegralOfEmployee();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select abc.employee_id,sum(abc.integral) as integral from ( select a.employee_id,a.business_type_id,case when b.parent_id = -1 then -(sum(a.integral)) else sum(a.integral) end as integral,b.dic_type_value from employee_account_records a left join system_dictionary b on b.dic_type_id = 66 and a.business_type_id = b.dic_type_value_id where a.employee_id = ? GROUP BY a.employee_id,a.business_type_id,b.parent_id,b.dic_type_value ) as abc GROUP BY abc.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,integral";
	private final static String[] fieldNames = { "employee_id"};
}
