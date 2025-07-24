package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseShiftmanageDetail;
import pomplatform.shift.bean.ConditionShiftmanageDetail;

public class QueryShiftmanageDetail extends AbstractQuery<BaseShiftmanageDetail, ConditionShiftmanageDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryShiftmanageDetail.class);

	public QueryShiftmanageDetail() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sm.shift_manage_id");
	}

	@Override
	public BaseCollection<BaseShiftmanageDetail> executeQuery( KeyValuePair[] replacements, ConditionShiftmanageDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getShiftManageId()
			);
	}

	@Override
	public BaseShiftmanageDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseShiftmanageDetail __base = new BaseShiftmanageDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setShiftManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShiftName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMonday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setTuesday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setWednesday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setThursday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setFriday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setSaturday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setSunday(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShiftTimeManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShiftTimeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignInTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignOffTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTimeOfShiftManageId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT sm.shift_manage_id,sm.shift_name,sm.start_date,sm.end_date,tosm.monday,tosm.tuesday,tosm.wednesday,tosm.thursday,tosm.friday,tosm.saturday,tosm.sunday,sm.is_enable,sm.remark, tosm.shift_time_manage_id, stm.shift_time_name,stm.sign_in_time,stm.sign_off_time,tosm.time_of_shift_manage_id FROM shift_manages sm LEFT JOIN time_of_shift_manages tosm ON sm.shift_manage_id = tosm.shift_manage_id LEFT JOIN shift_time_manages stm ON tosm.shift_time_manage_id = stm.shift_time_manage_id where sm.shift_manage_id = ?" ;
	private final static String RESULTSETFIELDLIST = "shift_manage_id,shift_name,start_date,end_date,monday,tuesday,wednesday,thursday,friday,saturday,sunday,is_enable,remark,shift_time_manage_id,shift_time_name,sign_in_time,sign_off_time,tosm.time_of_shift_manage_id";
	private final static String[] fieldNames = { "shift_manage_id"};
}
