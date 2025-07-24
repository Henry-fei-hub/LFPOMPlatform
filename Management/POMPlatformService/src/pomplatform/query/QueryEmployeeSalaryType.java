package pomplatform.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bean.BaseEmployeeSalaryType;
import pomplatform.bean.ConditionEmployeeSalaryType;

public class QueryEmployeeSalaryType extends AbstractQuery<BaseEmployeeSalaryType, ConditionEmployeeSalaryType>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeSalaryType.class);

	public QueryEmployeeSalaryType() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("employee_salary_type_id");
	}

	@Override
	public BaseCollection<BaseEmployeeSalaryType> executeQuery( KeyValuePair[] replacements, ConditionEmployeeSalaryType condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeSalaryTypeId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getSalaryType(), 
				condition.getFundraisingProjectType(), 
				condition.getFundraisingProjectRate()
			);
	}

	@Override
	public BaseEmployeeSalaryType generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeSalaryType __base = new BaseEmployeeSalaryType();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeSalaryTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSalaryType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFundraisingProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFundraisingProjectRate(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[9]));
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

	private final static String __SQLText = "SELECT employee_salary_type_id, employee_id, employee_name, employee_no, plate_id, YEAR, MONTH, salary_type, fundraising_project_type, fundraising_project_rate FROM employee_salary_types WHERE employee_salary_type_id =? AND employee_id =? AND employee_name like ? AND employee_no =? AND plate_id =? AND YEAR =? AND MONTH =? AND salary_type =? AND fundraising_project_type =? AND fundraising_project_rate =?" ;
	private final static String RESULTSETFIELDLIST = "employee_salary_type_id,employee_id,employee_name,employee_no,plate_id,year,month,salary_type,fundraising_project_type,fundraising_project_rate";
	private final static String[] fieldNames = { "employee_salary_type_id", "employee_id", "employee_name", "employee_no", "plate_id", "YEAR", "MONTH", "salary_type", "fundraising_project_type", "fundraising_project_rate"};
}
