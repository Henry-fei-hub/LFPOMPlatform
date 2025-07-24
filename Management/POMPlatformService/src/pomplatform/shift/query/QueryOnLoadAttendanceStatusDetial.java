package pomplatform.shift.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnLoadAttendanceStatusDetial;
import pomplatform.shift.bean.ConditionOnLoadAttendanceStatusDetial;

public class QueryOnLoadAttendanceStatusDetial extends AbstractQuery<BaseOnLoadAttendanceStatusDetial, ConditionOnLoadAttendanceStatusDetial>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttendanceStatusDetial.class);

	public QueryOnLoadAttendanceStatusDetial() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("bbb.*  from ( select aa.* from ( select c.plate_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAttendanceStatusDetial> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttendanceStatusDetial condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId(), 
				condition.getProcessType()
			);
	}

	@Override
	public BaseOnLoadAttendanceStatusDetial generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttendanceStatusDetial __base = new BaseOnLoadAttendanceStatusDetial();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "select bbb.* from ( select aa.* from ( select c.plate_id,a.employee_id,c.employee_no,c.employee_name,a.type,a.reason ,CASE WHEN a.process_type = 13 THEN 13 WHEN a.process_type = 16 THEN 16 ELSE 14 end as process_type from personnel_business a LEFT JOIN system_process_instances b on a.personnel_business_id = b.business_id and a.process_type = b.process_type LEFT JOIN employees c on a.employee_id = c.employee_id where a.process_type in(13,14,16,18,19,20,21,22,23) and a.end_date >= ? and a.start_date <= ? and b.process_status != 5 ) as aa UNION (select b.plate_id,a.employee_id,b.employee_no,b.employee_name,0 as type,a.remark as reason,a.status as process_type from employee_day_checks a LEFT JOIN employees b on a.employee_id = b.employee_id where a.record_date >= ? and a.record_date <= ? and a.status > 1)) as bbb where bbb.plate_id = ? and bbb.process_type = ? ORDER BY bbb.plate_id,bbb.process_type desc" ;
	private final static String RESULTSETFIELDLIST = "plate_id,employee_id,employee_no,employee_name,type,reason,process_type";
	private final static String[] fieldNames = { "start_date", "end_date", "start_date", "end_date", "plate_id", "process_type"};
}
