package pomplatform.employeeWorkClassType.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeWorkClassType.bean.BaseEmployeeWorkClassType;
import pomplatform.employeeWorkClassType.bean.ConditionEmployeeWorkClassType;

public class QueryEmployeeWorkClassType extends AbstractQuery<BaseEmployeeWorkClassType, ConditionEmployeeWorkClassType>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeWorkClassType.class);

	public QueryEmployeeWorkClassType() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.userId");
	}

	@Override
	public BaseCollection<BaseEmployeeWorkClassType> executeQuery( KeyValuePair[] replacements, ConditionEmployeeWorkClassType condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getUserid(), 
				condition.getCheckdate(), 
				condition.getCheckdate()
			);
	}

	@Override
	public BaseEmployeeWorkClassType generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeWorkClassType __base = new BaseEmployeeWorkClassType();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setUserid(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClasstypeid(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOndate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStopdate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOntime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOfftime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMonday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setTuesday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setWednesday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setThursday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setFriday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setSaturday(GenericBase.__getByte(val));
		if((val = __data[count++]) != null) __base.setSunday(GenericBase.__getByte(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
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

	private final static String __SQLText = "select a.userId,b.classTypeId,b.onDate,b.stopDate,d.onTime,d.offTime,c.monday,c.tuesday,c.wednesday,c.thursday,c.friday,c.saturday,c.sunday from EmployeeWork a left join EmployeeWorkItem b on a.id = b.employeeWorkId left join ClassTypeItem c on b.classTypeId = c.classTypeId left join TimeParagraph d on c.timeParagraphId = d.id where a.userId = ? and b.onDate <= ? and b.stopDate >= ?" ;
	private final static String RESULTSETFIELDLIST = "userId,classTypeId,onDate,stopDate,onTime,offTime,monday,tuesday,wednesday,thursday,friday,saturday,sunday";
	private final static String[] fieldNames = { "userId", "checkDate", "checkDate"};
}
