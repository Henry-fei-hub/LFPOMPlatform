package delicacy.oa.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.oa.bean.BaseMemployeeworkor;
import delicacy.oa.bean.ConditionMemployeeworkor;

public class QueryMemployeeworkor extends AbstractQuery<BaseMemployeeworkor, ConditionMemployeeworkor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeeworkor.class);

	public QueryMemployeeworkor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.userName");
	}

	@Override
	public BaseCollection<BaseMemployeeworkor> executeQuery( KeyValuePair[] replacements, ConditionMemployeeworkor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getUserid(), 
				condition.getUsername(), 
				condition.getStartdate(), 
				condition.getEnddate(), 
				condition.getStartdate(), 
				condition.getEnddate()
			);
	}

	@Override
	public BaseMemployeeworkor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeeworkor __base = new BaseMemployeeworkor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setUsername(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUserid(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClasstypename(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setChecktype(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkname(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOndate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStopdate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setClasstypeid(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setEmployeeworkid(GenericBase.__getLong(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
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

	private final static String __SQLText = "select e.userName, e.userId, e.classTypeName, e.checkType, e.workName , e0.onDate, e0.stopDate, e0.classTypeId, e0.employeeWorkId, e0.orderId , c.sunday, c.monday, c.tuesday, c.wednesday, c.thursday, c.friday, c.saturday, c.timeParagraphId from EmployeeWork e left join EmployeeWorkItem e0 on e0.employeeWorkId = e.id left join ClassTypeItem c on c.classTypeId = e0.classTypeId where c.classTypeId >= c.timeParagraphId and e.userId = ? and e.userName = ? and (( e0.onDate >= ? and e0.stopDate <= ? ) or ( e0.onDate <= ? and e0.stopDate >= ? ))" ;
	private final static String RESULTSETFIELDLIST = "userName,userId,classTypeName,checkType,workName,onDate,stopDate,classTypeId,employeeWorkId,orderId,sunday,monday,tuesday,wednesday,thursday,friday,saturday,timeParagraphId";
	private final static String[] fieldNames = { "userId", "userName", "startDate", "endDate", "startDate", "endDate"};
}
