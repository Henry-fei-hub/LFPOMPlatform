package delicacy.oa.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import delicacy.oa.bean.BaseMclasstypecior;
import delicacy.oa.bean.ConditionMclasstypecior;

public class QueryMclasstypecior extends AbstractQuery<BaseMclasstypecior, ConditionMclasstypecior>
{

	private static final Logger __logger = Logger.getLogger(QueryMclasstypecior.class);

	public QueryMclasstypecior() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.id");
	}

	@Override
	public BaseCollection<BaseMclasstypecior> executeQuery( KeyValuePair[] replacements, ConditionMclasstypecior condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getId()
			);
	}

	@Override
	public BaseMclasstypecior generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMclasstypecior __base = new BaseMclasstypecior();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setId(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOndate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCyclenumber(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setCycleunit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOrderid(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSunday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setMonday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setTuesday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setWednesday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setThursday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setFriday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setSaturday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setTimeparagraphid(GenericBase.__getLong(val));
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
		if(args[0] != null) __statement.setLong(count++, GenericBase.__getLong(args[0]));
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

	private final static String __SQLText = "select c.id, c.name, c.onDate, c.cycleNumber, c.cycleUnit , c0.orderId, c0.sunday, c0.monday, c0.tuesday, c0.wednesday, c0.thursday, c0.friday, c0.saturday, c0.timeParagraphId from ClassType c left join ClassTypeItem c0 on c0.classTypeId = c.id where c.id = ?" ;
	private final static String RESULTSETFIELDLIST = "id,name,onDate,cycleNumber,cycleUnit,orderId,sunday,monday,tuesday,wednesday,thursday,friday,saturday,timeParagraphId";
	private final static String[] fieldNames = { "id"};
}
