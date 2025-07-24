package pomplatform.company.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.company.bean.BaseJobManagement;
import pomplatform.company.bean.ConditionJobManagement;

public class QueryJobManagement extends AbstractQuery<BaseJobManagement, ConditionJobManagement>
{

	private static final Logger __logger = Logger.getLogger(QueryJobManagement.class);

	public QueryJobManagement() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("duty_id");
	}

	@Override
	public BaseCollection<BaseJobManagement> executeQuery( KeyValuePair[] replacements, ConditionJobManagement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDutyName()
			);
	}

	@Override
	public BaseJobManagement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseJobManagement __base = new BaseJobManagement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDutyName(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "select duty_id , duty_name from duties where duty_name like ? ORDER BY duty_id" ;
	private final static String RESULTSETFIELDLIST = "duty_id,duty_name";
	private final static String[] fieldNames = { "duty_name"};
}
