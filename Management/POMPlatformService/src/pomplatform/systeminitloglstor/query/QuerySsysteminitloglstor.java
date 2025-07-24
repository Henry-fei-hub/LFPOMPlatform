package pomplatform.systeminitloglstor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.systeminitloglstor.bean.BaseSsysteminitloglstor;
import pomplatform.systeminitloglstor.bean.ConditionSsysteminitloglstor;

public class QuerySsysteminitloglstor extends AbstractQuery<BaseSsysteminitloglstor, ConditionSsysteminitloglstor>
{

	private static final Logger __logger = Logger.getLogger(QuerySsysteminitloglstor.class);

	public QuerySsysteminitloglstor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sil.system_init_log_id");
	}

	@Override
	public BaseCollection<BaseSsysteminitloglstor> executeQuery( KeyValuePair[] replacements, ConditionSsysteminitloglstor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getLogMsg(), 
				condition.getSystemInitLogId(), 
				condition.getType(), 
				condition.getFlag()
			);
	}

	@Override
	public BaseSsysteminitloglstor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSsysteminitloglstor __base = new BaseSsysteminitloglstor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSystemInitLogId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLogMsg(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select sil.system_init_log_id, sil.type, sil.log_msg, sil.create_time, sil.flag from system_init_logs sil where sil.log_msg like ? and sil.system_init_log_id = ? and sil.type = ? and sil.flag = ?" ;
	private final static String RESULTSETFIELDLIST = "system_init_log_id,type,log_msg,create_time,flag";
	private final static String[] fieldNames = { "log_msg", "system_init_log_id", "type", "flag"};
}
