package pomplatform.oa.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.oa.bean.BaseScheckinfoseor;
import pomplatform.oa.bean.ConditionScheckinfoseor;

public class QueryScheckinfoseor extends AbstractQuery<BaseScheckinfoseor, ConditionScheckinfoseor>
{

	private static final Logger __logger = Logger.getLogger(QueryScheckinfoseor.class);

	public QueryScheckinfoseor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.userid");
	}

	@Override
	public BaseCollection<BaseScheckinfoseor> executeQuery( KeyValuePair[] replacements, ConditionScheckinfoseor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinLogindate(), 
				condition.getMaxLogindate()
			);
	}

	@Override
	public BaseScheckinfoseor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseScheckinfoseor __base = new BaseScheckinfoseor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setUserid(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCheckdate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckin(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckout(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
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

	private final static String __SQLText = "select c.userid, dateadd (dd, day(c.logindate) - 1, dateadd(mm, month(c.logindate) - 1, dateadd(yy, year(c.logindate) - 1900, 0))) as checkdate, min(c.logindate) as checkin, max(c.logindate) as checkout from CheckInfo c where c.loginDate between ? and ? group by c.userid, dateadd (dd, day(c.logindate) - 1, dateadd(mm, month(c.logindate) - 1, dateadd(yy, year(c.logindate) - 1900, 0)))" ;
	private final static String RESULTSETFIELDLIST = "userId,checkdate,checkin,checkout";
	private final static String[] fieldNames = { "min_logindate", "max_logindate"};
}
