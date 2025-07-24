package pomplatform.addProjectEmpSalary.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.addProjectEmpSalary.bean.BaseMaddProjectEmpSalary;
import pomplatform.addProjectEmpSalary.bean.ConditionMaddProjectEmpSalary;

public class QueryMaddProjectEmpSalary extends AbstractQuery<BaseMaddProjectEmpSalary, ConditionMaddProjectEmpSalary>
{

	private static final Logger __logger = Logger.getLogger(QueryMaddProjectEmpSalary.class);

	public QueryMaddProjectEmpSalary() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("distinct a.plate_id");
	}

	@Override
	public BaseCollection<BaseMaddProjectEmpSalary> executeQuery( KeyValuePair[] replacements, ConditionMaddProjectEmpSalary condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getSalaryYear(), 
				condition.getSalaryMonth()
			);
	}

	@Override
	public BaseMaddProjectEmpSalary generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMaddProjectEmpSalary __base = new BaseMaddProjectEmpSalary();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSalaryMonth(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBasicSalary(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
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

	private final static String __SQLText = "select distinct e.plate_id,e.employee_id,c.salary_month,c.basic_salary from projects a left join project_employees b on a.project_id = b.project_id left join employee_salary_details c on b.employee_id = c.employee_id left join employee_change_plate_records e on c.employee_id = e.employee_id and cast(c.salary_year as int) = e.year and cast(c.salary_month as int) = e.month left join employees d on b.employee_id = d.employee_id where e.plate_id = ? and cast(e.year as varchar)= ? and cast(e.month as varchar) = ?" ;
	private final static String RESULTSETFIELDLIST = "plate_id,employee_id,salary_month,basic_salary";
	private final static String[] fieldNames = { "plate_id", "salary_year", "salary_month"};
}
