package pomplatform.leavetype.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.leavetype.bean.BasePersonalLeaveType;
import pomplatform.leavetype.bean.ConditionPersonalLeaveType;

public class QueryPersonalLeaveType extends AbstractQuery<BasePersonalLeaveType, ConditionPersonalLeaveType>
{

	private static final Logger __logger = Logger.getLogger(QueryPersonalLeaveType.class);

	public QueryPersonalLeaveType() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.leave_type_id");
	}

	@Override
	public BaseCollection<BasePersonalLeaveType> executeQuery( KeyValuePair[] replacements, ConditionPersonalLeaveType condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getAreaId()
			);
	}

	@Override
	public BasePersonalLeaveType generateBase(Object[] __data) throws java.sql.SQLException {
		BasePersonalLeaveType __base = new BasePersonalLeaveType();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setLeaveTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeaveTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAreaId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAreaName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDays(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT a.leave_type_id, a.leave_type_name, b.area_id, case when b.area_id is null then '全国通用' else c.area_name end, case when b.days = 0 then '' else cast(b.days as varchar) end, b.remark, a.parent_id from leave_types a LEFT JOIN leave_type_link_areas b on a.leave_type_id = b.leave_type_id LEFT JOIN areas c on b.area_id = c.area_id where (a.gender = (SELECT gender from employees where employee_id = ?) or a.gender = 0) and (b.area_id = ? or b.area_id is null) and a.is_enable = true and b.is_enable = true ORDER BY a.leave_type_id;" ;
	private final static String RESULTSETFIELDLIST = "leave_type_id,leave_type_name,area_id,area_name,days,remark,parent_id";
	private final static String[] fieldNames = { "employee_id", "area_id"};
}
