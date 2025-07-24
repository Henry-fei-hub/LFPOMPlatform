package pomplatform.account.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadMonthReportData;
import pomplatform.account.bean.ConditionOnLoadMonthReportData;

public class QueryOnLoadMonthReportData extends AbstractQuery<BaseOnLoadMonthReportData, ConditionOnLoadMonthReportData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadMonthReportData.class);

	public QueryOnLoadMonthReportData() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.business_type_id");
	}

	@Override
	public BaseCollection<BaseOnLoadMonthReportData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadMonthReportData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getPlateId(), 
				condition.getEmployeeId(), 
				condition.getBusinessTypeId()
			);
	}

	@Override
	public BaseOnLoadMonthReportData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadMonthReportData __base = new BaseOnLoadMonthReportData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select a.business_type_id,a.employee_id,b.employee_no,b.employee_name,EXTRACT(YEAR from a.record_date) as year,EXTRACT(MONTH from a.record_date) as month,sum(a.integral) as integral from employee_account_records a left join employees b on a.employee_id = b.employee_id LEFT JOIN employee_day_plate_records C ON A .employee_id = C .employee_id AND A.record_date = C.record_date where a.record_date BETWEEN ? and ? and c.plate_id =? and a.employee_id =? and a.business_type_id = ? GROUP BY a.employee_id,b.employee_no,b.employee_name,a.business_type_id,EXTRACT(YEAR from a.record_date),EXTRACT(MONTH from a.record_date)" ;
	private final static String RESULTSETFIELDLIST = "business_type_id,employee_id,employee_no,employee_name,year,month,integral";
	private final static String[] fieldNames = { "start_date", "end_date", "plate_id", "employee_id", "business_type_id"};
}
