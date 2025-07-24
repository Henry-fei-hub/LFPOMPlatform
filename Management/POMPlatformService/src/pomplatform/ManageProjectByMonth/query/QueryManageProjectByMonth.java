package pomplatform.ManageProjectByMonth.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.ManageProjectByMonth.bean.BaseManageProjectByMonth;
import pomplatform.ManageProjectByMonth.bean.ConditionManageProjectByMonth;

public class QueryManageProjectByMonth extends AbstractQuery<BaseManageProjectByMonth, ConditionManageProjectByMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryManageProjectByMonth.class);

	public QueryManageProjectByMonth() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("plate_id");
	}

	@Override
	public BaseCollection<BaseManageProjectByMonth> executeQuery( KeyValuePair[] replacements, ConditionManageProjectByMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseManageProjectByMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseManageProjectByMonth __base = new BaseManageProjectByMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select plate_id,extract(year from project_date) as record_year, extract(month from project_date) as record_month, sum(total_integral) as total_integral,sum(left_integral) as left_integral from manage_projects where plate_id = ? and project_date >= ? and project_date <= ? GROUP BY plate_id, record_year, record_month ORDER BY record_year, record_month" ;
	private final static String RESULTSETFIELDLIST = "plate_id,record_year,record_month,total_integral,left_integral";
	private final static String[] fieldNames = { "plate_id", "start_date", "end_date"};
}
