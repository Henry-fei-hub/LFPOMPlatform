package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnLoadAttendanceTotal;
import pomplatform.shift.bean.ConditionOnLoadAttendanceTotal;

public class QueryOnLoadAttendanceTotal extends AbstractQuery<BaseOnLoadAttendanceTotal, ConditionOnLoadAttendanceTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttendanceTotal.class);

	public QueryOnLoadAttendanceTotal() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.plate_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAttendanceTotal> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttendanceTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseOnLoadAttendanceTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttendanceTotal __base = new BaseOnLoadAttendanceTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeaveNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAbsenceNum(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select aa.plate_id,aa.total_num,bb.leave_num,cc.absence_num from (select plate_id,count(*) as total_num from employees where status = 0 and company_id != 8 GROUP BY plate_id) as aa LEFT JOIN (select c.plate_id,count(*) as leave_num from personnel_business a LEFT JOIN system_process_instances b on a.personnel_business_id = b.business_id and a.process_type = b.process_type LEFT JOIN employees c on a.employee_id = c.employee_id where a.process_type = 13 and a.end_date >= ? and a.start_date <= ? and b.process_status != 5 GROUP BY c.plate_id ) as bb on aa.plate_id = bb.plate_id LEFT JOIN (select b.plate_id,count(*) as absence_num from employee_day_checks a LEFT JOIN employees b on a.employee_id = b.employee_id where a.record_date >= ? and a.record_date <= ? and a.status = 4 GROUP BY b.plate_id ) as cc on aa.plate_id = cc.plate_id where aa.plate_id = ? ORDER BY aa.plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,total_num,leave_num,absence_num";
	private final static String[] fieldNames = { "start_date", "end_date", "start_date", "end_date", "plate_id"};
}
