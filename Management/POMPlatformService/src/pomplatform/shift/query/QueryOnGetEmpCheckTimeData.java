package pomplatform.shift.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.shift.bean.BaseOnGetEmpCheckTimeData;
import pomplatform.shift.bean.ConditionOnGetEmpCheckTimeData;

public class QueryOnGetEmpCheckTimeData extends AbstractQuery<BaseOnGetEmpCheckTimeData, ConditionOnGetEmpCheckTimeData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnGetEmpCheckTimeData.class);

	public QueryOnGetEmpCheckTimeData() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.*");
	}

	@Override
	public BaseCollection<BaseOnGetEmpCheckTimeData> executeQuery( KeyValuePair[] replacements, ConditionOnGetEmpCheckTimeData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnGetEmpCheckTimeData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnGetEmpCheckTimeData __base = new BaseOnGetEmpCheckTimeData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCheckDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckin(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckout(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCheckNum(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setAcrossCheckTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT aa.*,bb.across_check_time FROM ( SELECT a.employee_id,a.check_date,MIN(a.check_time) AS checkin,MAX(a.check_time) AS checkout,COUNT(*) AS check_num FROM employee_checkinout_details a WHERE extract(YEAR FROM a.check_date) = ? AND extract(MONTH FROM a.check_date) = ? AND a.employee_id = ? AND CAST(extract(HOUR FROM a.check_time) AS INTEGER) > 5 GROUP BY a.employee_id,a.check_date) AS aa LEFT JOIN (SELECT employee_id,check_date,MIN(check_time) AS across_check_time FROM employee_checkinout_details WHERE CAST(extract(HOUR FROM check_time) AS INTEGER) <= 5 GROUP BY employee_id,check_date) bb ON aa.employee_id = bb.employee_id AND (aa.check_date + interval '1 D') = bb.check_date ORDER BY aa.employee_id,aa.check_date" ;
	private final static String RESULTSETFIELDLIST = "employee_id,check_date,checkin,checkout,check_num,across_check_time";
	private final static String[] fieldNames = { "year", "month", "employee_id"};
}
