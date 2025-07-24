package pomplatform.shift.query;

import org.apache.log4j.Logger;
import java.util.Map;
import java.util.List;
import delicacy.common.CommonUtils;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseAttendanceCheckinoutData;
import pomplatform.shift.bean.ConditionAttendanceCheckinoutData;

public class QueryAttendanceCheckinoutData extends AbstractQuery<BaseAttendanceCheckinoutData, ConditionAttendanceCheckinoutData>
{

	private static final Logger __logger = Logger.getLogger(QueryAttendanceCheckinoutData.class);

	public QueryAttendanceCheckinoutData() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_id");
	}

	public static BaseAttendanceCheckinoutData selectOne(Map params) throws java.sql.SQLException {

		params.put(GenericBase.NAME_CURRENT_PAGE, 1);
		params.put(GenericBase.NAME_PAGE_LINES, 1);
		BaseCollection<BaseAttendanceCheckinoutData> res = select(params, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseAttendanceCheckinoutData selectOne(ConditionAttendanceCheckinoutData c) throws java.sql.SQLException {

		c.setCurrentPage(1);
		c.setPageLines(1);
		BaseCollection<BaseAttendanceCheckinoutData> res = select(c, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCollection<BaseAttendanceCheckinoutData> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseAttendanceCheckinoutData> select(Map params, Map replaces) throws java.sql.SQLException {

		return select(params, replaces, true);
	}


	public static BaseCollection<BaseAttendanceCheckinoutData> select(Map params, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionAttendanceCheckinoutData c = new ConditionAttendanceCheckinoutData();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryAttendanceCheckinoutData dao = new QueryAttendanceCheckinoutData();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static BaseCollection<BaseAttendanceCheckinoutData> select(ConditionAttendanceCheckinoutData c, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		QueryAttendanceCheckinoutData dao = new QueryAttendanceCheckinoutData();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static List<BaseAttendanceCheckinoutData> query() throws java.sql.SQLException {

		return query(new java.util.HashMap(), null);
	}


	public static List<BaseAttendanceCheckinoutData> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseAttendanceCheckinoutData> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionAttendanceCheckinoutData c = new ConditionAttendanceCheckinoutData();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryAttendanceCheckinoutData dao = new QueryAttendanceCheckinoutData();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseAttendanceCheckinoutData> executeQuery( KeyValuePair[] replacements, ConditionAttendanceCheckinoutData condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseAttendanceCheckinoutData> runQuery( KeyValuePair[] replacements, ConditionAttendanceCheckinoutData condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseAttendanceCheckinoutData> execute( KeyValuePair[] replacements, ConditionAttendanceCheckinoutData condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseAttendanceCheckinoutData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttendanceCheckinoutData __base = new BaseAttendanceCheckinoutData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCheckDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckinTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckoutTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLastCheckoutTime(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		return count;
	}

	@Override
	public String getSQLText() {
		return __SQLText;
	}

	@Override
	public String getOriginalSQLText() {
		return __originalSQL;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	@Override
	public String[] getConditionNames(){
		return fieldNames;
	}

	public final static String __SQLText = "SELECT employee_id, check_date, MIN(check_time) AS checkin_time, MAX(check_time) AS checkout_time, MAX ( CASE WHEN check_time <= DATE ( to_char( check_date, 'YYYY-MM-DD' ) ) + TIME'06:00' THEN check_time END ) AS last_checkout_time FROM employee_checkinout_details WHERE check_date between ? and ? and employee_id = ? GROUP BY employee_id, check_date ORDER BY employee_id" ;
	public final static String __originalSQL = "SELECT employee_id, check_date, MIN(check_time) AS checkin_time, MAX(check_time) AS checkout_time, MAX ( CASE WHEN check_time <= DATE ( to_char( check_date, 'YYYY-MM-DD' ) ) + TIME'06:00' THEN check_time END ) AS last_checkout_time FROM employee_checkinout_details WHERE check_date BETWEEN :start_date AND :end_date AND employee_id = :employee_id GROUP BY employee_id, check_date ORDER BY employee_id";
	private final static String RESULTSETFIELDLIST = "employee_id,check_date,checkin_time,checkout_time,last_checkout_time";
	private final static String[] fieldNames = { "start_date", "end_date", "employee_id"};
}
