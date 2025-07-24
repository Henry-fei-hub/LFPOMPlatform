package pomplatform.checking.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.checking.bean.BaseSemployeecheckinoutupdatetimeor;
import pomplatform.checking.bean.ConditionSemployeecheckinoutupdatetimeor;

public class QuerySemployeecheckinoutupdatetimeor extends AbstractQuery<BaseSemployeecheckinoutupdatetimeor, ConditionSemployeecheckinoutupdatetimeor>
{

	private static final Logger __logger = Logger.getLogger(QuerySemployeecheckinoutupdatetimeor.class);

	public QuerySemployeecheckinoutupdatetimeor() throws java.sql.SQLException 
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("max(update_time) as new_time");
	}

	@Override
	public BaseCollection<BaseSemployeecheckinoutupdatetimeor> executeQuery( KeyValuePair[] replacements, ConditionSemployeecheckinoutupdatetimeor condition ) throws java.sql.SQLException {
		return executeQuery(replacements
			);
	}

	@Override
	public BaseSemployeecheckinoutupdatetimeor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSemployeecheckinoutupdatetimeor __base = new BaseSemployeecheckinoutupdatetimeor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setNewTime(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT to_char(max(update_time), 'yyyy-MM-dd hh24:MI:ss') as new_time FROM employee_checkinout_updatetime" ;
	private final static String RESULTSETFIELDLIST = "new_time";
	private final static String[] fieldNames = { };
}
