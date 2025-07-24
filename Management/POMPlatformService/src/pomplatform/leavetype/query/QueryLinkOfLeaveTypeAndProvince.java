package pomplatform.leavetype.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.leavetype.bean.BaseLinkOfLeaveTypeAndProvince;
import pomplatform.leavetype.bean.ConditionLinkOfLeaveTypeAndProvince;

public class QueryLinkOfLeaveTypeAndProvince extends AbstractQuery<BaseLinkOfLeaveTypeAndProvince, ConditionLinkOfLeaveTypeAndProvince>
{

	private static final Logger __logger = Logger.getLogger(QueryLinkOfLeaveTypeAndProvince.class);

	public QueryLinkOfLeaveTypeAndProvince() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ltlp.leave_type_link_province_id");
	}

	@Override
	public BaseCollection<BaseLinkOfLeaveTypeAndProvince> executeQuery( KeyValuePair[] replacements, ConditionLinkOfLeaveTypeAndProvince condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getLeaveTypeId()
			);
	}

	@Override
	public BaseLinkOfLeaveTypeAndProvince generateBase(Object[] __data) throws java.sql.SQLException {
		BaseLinkOfLeaveTypeAndProvince __base = new BaseLinkOfLeaveTypeAndProvince();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setLeaveTypeLinkProvinceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeaveTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProvinceId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select ltlp.leave_type_link_province_id, ltlp.leave_type_id, ltlp.province_id, ltlp.days, ltlp.remark, ltlp.is_enable from leave_type_link_provinces ltlp where ltlp.leave_type_id = ?" ;
	private final static String RESULTSETFIELDLIST = "leave_type_link_province_id,leave_type_id,province_id,days,remark,is_enable";
	private final static String[] fieldNames = { "leave_type_id"};
}
