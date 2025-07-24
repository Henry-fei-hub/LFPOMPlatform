package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnLoadAttendanceStatus;
import pomplatform.shift.bean.ConditionOnLoadAttendanceStatus;

public class QueryOnLoadAttendanceStatus extends AbstractQuery<BaseOnLoadAttendanceStatus, ConditionOnLoadAttendanceStatus>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttendanceStatus.class);

	public QueryOnLoadAttendanceStatus() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("bbb.*");
	}

	@Override
	public BaseCollection<BaseOnLoadAttendanceStatus> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttendanceStatus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnLoadAttendanceStatus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttendanceStatus __base = new BaseOnLoadAttendanceStatus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTypeName(GenericBase.__getString(val));
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
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "select bbb.*,CASE WHEN bbb.process_type = 16 THEN '外出' WHEN bbb.process_type = 14 THEN '出差' WHEN bbb.process_type=13 THEN '请假' WHEN bbb.process_type = 4 THEN '旷工' WHEN bbb.process_type = 3 THEN '早退' ELSE '迟到' END type_name from ( select aaa.* from (SELECT aa.plate_id,aa.process_type,count(*) as personnel_num from ( select c.plate_id,a.employee_id,CASE WHEN a.process_type = 13 THEN 13 WHEN a.process_type = 16 THEN 16 ELSE 14 end as process_type from personnel_business a LEFT JOIN system_process_instances b on a.personnel_business_id = b.business_id and a.process_type = b.process_type LEFT JOIN employees c on a.employee_id = c.employee_id where a.process_type in(13,14,16,18,19,20,21,22,23) and a.end_date >= ? and a.start_date <= ? and b.process_status != 5 ) as aa GROUP BY aa.plate_id ,aa.process_type) as aaa UNION (select b.plate_id,a.status as process_type,count(*) as personnel_num from employee_day_checks a LEFT JOIN employees b on a.employee_id = b.employee_id where a.record_date >= ? and a.record_date <= ? and a.status > 1 GROUP BY b.plate_id,a.status)) as bbb where bbb.plate_id = ? ORDER BY bbb.plate_id,bbb.process_type desc" ;
	private final static String RESULTSETFIELDLIST = "plate_id,process_type,personnel_num,type_name";
	private final static String[] fieldNames = { "start_date", "end_date", "start_date", "end_date", "plate_id"};
}
