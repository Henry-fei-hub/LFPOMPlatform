package pomplatform.account.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadPerformanceIntegralOfEmployee;
import pomplatform.account.bean.ConditionOnLoadPerformanceIntegralOfEmployee;

public class QueryOnLoadPerformanceIntegralOfEmployee extends AbstractQuery<BaseOnLoadPerformanceIntegralOfEmployee, ConditionOnLoadPerformanceIntegralOfEmployee>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadPerformanceIntegralOfEmployee.class);

	public QueryOnLoadPerformanceIntegralOfEmployee() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadPerformanceIntegralOfEmployee> executeQuery( KeyValuePair[] replacements, ConditionOnLoadPerformanceIntegralOfEmployee condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getEmployeeId(), 
				condition.getBusinessTypeId()
			);
	}

	@Override
	public BaseOnLoadPerformanceIntegralOfEmployee generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadPerformanceIntegralOfEmployee __base = new BaseOnLoadPerformanceIntegralOfEmployee();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "select a.employee_id,b.employee_no,b.employee_name,a.integral,e.contract_code,e.contract_name,a.operate_employee_id,a.operate_time,a.remark from employee_account_records a left join employees b on a.employee_id = b.employee_id LEFT JOIN employee_day_plate_records C ON A .employee_id = C .employee_id AND A.record_date = C.record_date left join project_performances d on a.business_id = d.project_performance_id left join contracts e on d.contract_id = e.contract_id where EXTRACT(YEAR from a.record_date)=? and EXTRACT(MONTH from a.record_date)=? and c.plate_id =? and a.employee_id =? and a.business_type_id =? ORDER BY d.contract_id,a.integral desc" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,integral,contract_code,contract_name,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "year", "month", "plate_id", "employee_id", "business_type_id"};
}
