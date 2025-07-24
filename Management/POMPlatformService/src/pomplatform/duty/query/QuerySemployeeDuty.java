package pomplatform.duty.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.duty.bean.BaseSemployeeDuty;
import pomplatform.duty.bean.ConditionSemployeeDuty;

public class QuerySemployeeDuty extends AbstractQuery<BaseSemployeeDuty, ConditionSemployeeDuty>
{

	private static final Logger __logger = Logger.getLogger(QuerySemployeeDuty.class);

	public QuerySemployeeDuty() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("d.duty_id");
	}

	@Override
	public BaseCollection<BaseSemployeeDuty> executeQuery( KeyValuePair[] replacements, ConditionSemployeeDuty condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDutyName(), 
				condition.getDutyId()
			);
	}

	@Override
	public BaseSemployeeDuty generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSemployeeDuty __base = new BaseSemployeeDuty();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDutyName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDescription(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentDutyId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, (java.lang.String)args[0]);
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
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

	private final static String __SQLText = "select d.duty_id, d.duty_name, d.description, d.parent_duty_id from duties d where d.duty_name like ? and d.duty_id = ?" ;
	private final static String RESULTSETFIELDLIST = "duty_id,duty_name,description,parent_duty_id";
	private final static String[] fieldNames = { "duty_name", "duty_id"};
}
