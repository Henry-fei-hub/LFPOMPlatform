package pomplatform.employeeReportRecordDetail.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeReportRecordDetail.bean.BaseEmployeeMonthlyAchieveIntegral;
import pomplatform.employeeReportRecordDetail.bean.ConditionEmployeeMonthlyAchieveIntegral;

public class QueryEmployeeMonthlyAchieveIntegral extends AbstractQuery<BaseEmployeeMonthlyAchieveIntegral, ConditionEmployeeMonthlyAchieveIntegral>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeMonthlyAchieveIntegral.class);

	public QueryEmployeeMonthlyAchieveIntegral() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseEmployeeMonthlyAchieveIntegral> executeQuery( KeyValuePair[] replacements, ConditionEmployeeMonthlyAchieveIntegral condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getRecordDate()
			);
	}

	@Override
	public BaseEmployeeMonthlyAchieveIntegral generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeMonthlyAchieveIntegral __base = new BaseEmployeeMonthlyAchieveIntegral();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select aa.plate_id, aa.employee_id, aa.employee_name, aa.employee_no,sum(aa.achieve_integral) as achieve_integral from (SELECT b.plate_id, a.employee_id, b.employee_name, b.employee_no,a.business_type_id,case when d.parent_id = -1 then -(sum(a.integral)) else sum(a.integral) end as achieve_integral from employee_account_records a LEFT JOIN employees b on a.employee_id = b.employee_id left join employee_day_plate_records c on a.employee_id = c.employee_id and a.record_date = c.record_date left join system_dictionary d on dic_type_id = 66 and a.business_type_id = d.dic_type_value_id WHERE c.plate_id = ? and a.record_date = ? and b.status = 0 and a.employee_id != 0 GROUP BY b.plate_id,a.business_type_id, a.employee_id, b.employee_name, b.employee_no,d.parent_id ORDER BY b.plate_id, a.employee_id,a.business_type_id,achieve_integral desc ) as aa GROUP BY aa.plate_id, aa.employee_id, aa.employee_name, aa.employee_no" ;
	private final static String RESULTSETFIELDLIST = "plate_id,employee_id,employee_name,employee_no,achieve_integral";
	private final static String[] fieldNames = { "plate_id", "record_date"};
}
