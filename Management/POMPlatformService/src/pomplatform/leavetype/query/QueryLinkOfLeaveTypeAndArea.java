package pomplatform.leavetype.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.leavetype.bean.BaseLinkOfLeaveTypeAndArea;
import pomplatform.leavetype.bean.ConditionLinkOfLeaveTypeAndArea;

public class QueryLinkOfLeaveTypeAndArea extends AbstractQuery<BaseLinkOfLeaveTypeAndArea, ConditionLinkOfLeaveTypeAndArea>
{

	private static final Logger __logger = Logger.getLogger(QueryLinkOfLeaveTypeAndArea.class);

	public QueryLinkOfLeaveTypeAndArea() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ltlp.leave_type_link_area_id");
	}

	@Override
	public BaseCollection<BaseLinkOfLeaveTypeAndArea> executeQuery( KeyValuePair[] replacements, ConditionLinkOfLeaveTypeAndArea condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getLeaveTypeId()
			);
	}

	@Override
	public BaseLinkOfLeaveTypeAndArea generateBase(Object[] __data) throws java.sql.SQLException {
		BaseLinkOfLeaveTypeAndArea __base = new BaseLinkOfLeaveTypeAndArea();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setLeaveTypeLinkAreaId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeaveTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAreaId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "select ltlp.leave_type_link_area_id, ltlp.leave_type_id, ltlp.area_id, ltlp.days, ltlp.remark, ltlp.is_enable from leave_type_link_areas ltlp where ltlp.leave_type_id = ?" ;
	private final static String RESULTSETFIELDLIST = "leave_type_link_area_id,leave_type_id,area_id,days,remark,is_enable";
	private final static String[] fieldNames = { "leave_type_id"};
}
