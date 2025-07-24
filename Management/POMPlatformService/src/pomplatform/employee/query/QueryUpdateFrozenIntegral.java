package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseUpdateFrozenIntegral;
import pomplatform.employee.bean.ConditionUpdateFrozenIntegral;

public class QueryUpdateFrozenIntegral extends AbstractQuery<BaseUpdateFrozenIntegral, ConditionUpdateFrozenIntegral>
{

	private static final Logger __logger = Logger.getLogger(QueryUpdateFrozenIntegral.class);

	public QueryUpdateFrozenIntegral() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.personnel_business_id");
	}

	@Override
	public BaseCollection<BaseUpdateFrozenIntegral> executeQuery( KeyValuePair[] replacements, ConditionUpdateFrozenIntegral condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseUpdateFrozenIntegral generateBase(Object[] __data) throws java.sql.SQLException {
		BaseUpdateFrozenIntegral __base = new BaseUpdateFrozenIntegral();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLivingExpenses(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHousingFinance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFee(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "select a.personnel_business_id, a.employee_id, b.plate_id, a.department_id, a.employee_no, b.employee_name, a.end_date, a.living_expenses, a.housing_finance, a.fee from personnel_business a LEFT JOIN employees b on a.employee_id = b.employee_id LEFT JOIN system_process_instances c on a.process_type = c.process_type and a.personnel_business_id = c.business_id where a.process_type = 25 and a.delete_flag = 0 and c.process_status in (1,3) and a.employee_no like ? and b.employee_name like ? and b.plate_id = ? and extract(year from a.end_date) = ? and extract(month from a.end_date) = ? order by b.plate_id" ;
	private final static String RESULTSETFIELDLIST = "personnel_business_id,employee_id,plate_id,department_id,employee_no,employee_name,end_date,living_expenses,housing_finance,fee";
	private final static String[] fieldNames = { "employee_no", "employee_name", "plate_id", "year", "month"};
}
