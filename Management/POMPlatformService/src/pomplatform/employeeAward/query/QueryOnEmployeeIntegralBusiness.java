package pomplatform.employeeAward.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeAward.bean.BaseOnEmployeeIntegralBusiness;
import pomplatform.employeeAward.bean.ConditionOnEmployeeIntegralBusiness;

public class QueryOnEmployeeIntegralBusiness extends AbstractQuery<BaseOnEmployeeIntegralBusiness, ConditionOnEmployeeIntegralBusiness>
{

	private static final Logger __logger = Logger.getLogger(QueryOnEmployeeIntegralBusiness.class);

	public QueryOnEmployeeIntegralBusiness() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("eib.employee_integral_business_id");
	}

	@Override
	public BaseCollection<BaseOnEmployeeIntegralBusiness> executeQuery( KeyValuePair[] replacements, ConditionOnEmployeeIntegralBusiness condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getStatus(), 
				condition.getBusinessTypeName(),
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnEmployeeIntegralBusiness generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnEmployeeIntegralBusiness __base = new BaseOnEmployeeIntegralBusiness();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeIntegralBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "select eib.employee_integral_business_id, eib.business_type_id, eib.business_type_name, eib.employee_id, eib.integral, eib.record_date, eib.status, eib.operate_time, eib.operate_employee_id, eib.remark,eib.business_id from employee_integral_business eib where eib.record_date between ? and ? and eib.status = ? and eib.business_type_name like ? and employee_id = ? order by eib.employee_id,record_date,employee_integral_business_id" ;
	private final static String RESULTSETFIELDLIST = "employee_integral_business_id,business_type_id,business_type_name,employee_id,integral,record_date,status,operate_time,operate_employee_id,remark,business_id";
	private final static String[] fieldNames = { "start_date", "end_date", "status", "business_type_name","employee_id"};
}
