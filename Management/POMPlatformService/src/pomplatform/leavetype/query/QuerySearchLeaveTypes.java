package pomplatform.leavetype.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.leavetype.bean.BaseSearchLeaveTypes;
import pomplatform.leavetype.bean.ConditionSearchLeaveTypes;

public class QuerySearchLeaveTypes extends AbstractQuery<BaseSearchLeaveTypes, ConditionSearchLeaveTypes>
{

	private static final Logger __logger = Logger.getLogger(QuerySearchLeaveTypes.class);

	public QuerySearchLeaveTypes() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.leave_type_id");
	}

	@Override
	public BaseCollection<BaseSearchLeaveTypes> executeQuery( KeyValuePair[] replacements, ConditionSearchLeaveTypes condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAreaId(), 
				condition.getGender(), 
				condition.getParentId()
			);
	}

	@Override
	public BaseSearchLeaveTypes generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSearchLeaveTypes __base = new BaseSearchLeaveTypes();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setLeaveTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeaveTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDays(GenericBase.__getDecimal(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT a.leave_type_id, a.leave_type_name, b.days from leave_types a LEFT JOIN leave_type_link_areas b on a.leave_type_id = b.leave_type_id where (b.area_id = ? or b.area_id is null) and (a.gender = ? or a.gender = 0) and b.is_enable = true and a.is_enable = true and a.parent_id = ?;" ;
	private final static String RESULTSETFIELDLIST = "leave_type_id,leave_type_name,days";
	private final static String[] fieldNames = { "province_id", "gender", "parent_id"};
}
