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
import pomplatform.shift.bean.BaseAttendancePersonnelData;
import pomplatform.shift.bean.ConditionAttendancePersonnelData;

public class QueryAttendancePersonnelData extends AbstractQuery<BaseAttendancePersonnelData, ConditionAttendancePersonnelData>
{

	private static final Logger __logger = Logger.getLogger(QueryAttendancePersonnelData.class);

	public QueryAttendancePersonnelData() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("personnel_business_id");
	}

	public static BaseAttendancePersonnelData selectOne(Map params) throws java.sql.SQLException {

		params.put(GenericBase.NAME_CURRENT_PAGE, 1);
		params.put(GenericBase.NAME_PAGE_LINES, 1);
		BaseCollection<BaseAttendancePersonnelData> res = select(params, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseAttendancePersonnelData selectOne(ConditionAttendancePersonnelData c) throws java.sql.SQLException {

		c.setCurrentPage(1);
		c.setPageLines(1);
		BaseCollection<BaseAttendancePersonnelData> res = select(c, null, false);
		if(res.getCollections().size() > 0) return res.getCollections().get(0);
		return null;
	}


	public static BaseCollection<BaseAttendancePersonnelData> select(Map params) throws java.sql.SQLException {

		return select(params, null);
	}


	public static BaseCollection<BaseAttendancePersonnelData> select(Map params, Map replaces) throws java.sql.SQLException {

		return select(params, replaces, true);
	}


	public static BaseCollection<BaseAttendancePersonnelData> select(Map params, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionAttendancePersonnelData c = new ConditionAttendancePersonnelData();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryAttendancePersonnelData dao = new QueryAttendancePersonnelData();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static BaseCollection<BaseAttendancePersonnelData> select(ConditionAttendancePersonnelData c, Map replaces, boolean loadTotalPages) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		QueryAttendancePersonnelData dao = new QueryAttendancePersonnelData();
		if(!loadTotalPages) dao.setLoadTotalPages(loadTotalPages);
		return dao.runQuery(replacements, c);
	}


	public static List<BaseAttendancePersonnelData> query() throws java.sql.SQLException {

		return query(new java.util.HashMap(), null);
	}


	public static List<BaseAttendancePersonnelData> query(Map params) throws java.sql.SQLException {

		return query(params, null);
	}


	public static List<BaseAttendancePersonnelData> query(Map params, Map replaces) throws java.sql.SQLException {

		KeyValuePair[] replacements = replaces == null || replaces.isEmpty() ? null : CommonUtils.generateReplacement(replaces);
		ConditionAttendancePersonnelData c = new ConditionAttendancePersonnelData();
		c.setDataFromMap(CommonUtils.preprocess(params));
		QueryAttendancePersonnelData dao = new QueryAttendancePersonnelData();
		return dao.runQuery(replacements, c).getCollections();
	}


	@Override
	public BaseCollection<BaseAttendancePersonnelData> executeQuery( KeyValuePair[] replacements, ConditionAttendancePersonnelData condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return executeQuery(replacements, 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseAttendancePersonnelData> runQuery( KeyValuePair[] replacements, ConditionAttendancePersonnelData condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return runQuery(replacements, 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	public BaseCollection<BaseAttendancePersonnelData> execute( KeyValuePair[] replacements, ConditionAttendancePersonnelData condition ) throws java.sql.SQLException {
		if(condition.getCurrentPage() > 0) {
			setCurrentPage(condition.getCurrentPage());
			setPageLines(condition.getPageLines());
		}
		return execute(condition, replacements, 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseAttendancePersonnelData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAttendancePersonnelData __base = new BaseAttendancePersonnelData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	public final static String __SQLText = "SELECT A.personnel_business_id, A.process_type, A.employee_id, A.department_id, A.start_date, A.start_date_detail, A.end_date, A.end_date_detail, A.TYPE, pt.process_type_name, A.duty_id, pi.process_status FROM personnel_business AS A LEFT JOIN system_process_types AS pt ON A.process_type = pt.process_type_id LEFT JOIN system_process_instances AS pi ON pi.business_id = A.personnel_business_id AND pi.process_type = A.process_type WHERE ((A.start_date <= ? and A.end_date >= ?) or a.start_date between ? and ?) and pt.is_attendance = TRUE and A.delete_flag = 0 and pi.delete_flag = 0 and pi.process_status <> 5 and A.employee_id = ? ORDER BY a.start_date DESC" ;
	public final static String __originalSQL = "SELECT A.personnel_business_id, A.process_type, A.employee_id, A.department_id, A.start_date, A.start_date_detail, A.end_date, A.end_date_detail, A.TYPE, pt.process_type_name, A.duty_id, pi.process_status FROM personnel_business AS A LEFT JOIN system_process_types AS pt ON A.process_type = pt.process_type_id LEFT JOIN system_process_instances AS pi ON pi.business_id = A.personnel_business_id AND pi.process_type = A.process_type WHERE ((A.start_date <= :end_date AND A.end_date >= :start_date) OR a.start_date BETWEEN :start_date AND :end_date) AND pt.is_attendance = TRUE AND A.delete_flag = 0 AND pi.delete_flag = 0 AND pi.process_status <> 5 AND A.employee_id = :employee_id ORDER BY a.start_date DESC";
	private final static String RESULTSETFIELDLIST = "personnel_business_id,process_type,employee_id,department_id,start_date,start_date_detail,end_date,end_date_detail,type,process_type_name,duty_id,process_status";
	private final static String[] fieldNames = { "end_date", "start_date", "start_date", "end_date", "employee_id"};
}
