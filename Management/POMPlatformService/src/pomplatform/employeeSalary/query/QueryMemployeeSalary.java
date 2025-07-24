package pomplatform.employeeSalary.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeeSalary.bean.BaseMemployeeSalary;
import pomplatform.employeeSalary.bean.ConditionMemployeeSalary;

public class QueryMemployeeSalary extends AbstractQuery<BaseMemployeeSalary, ConditionMemployeeSalary>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeeSalary.class);

	public QueryMemployeeSalary() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseMemployeeSalary> executeQuery( KeyValuePair[] replacements, ConditionMemployeeSalary condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeName(), 
				condition.getYears(), 
				condition.getStartMonth(), 
				condition.getEndMonth(), 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseMemployeeSalary generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeeSalary __base = new BaseMemployeeSalary();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSalaryYear(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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
//and b.department_id in (select child_id from department_ids where department_id = ? )
	private final static String __SQLText = "select a.employee_id,concat(s.image_path,case when c.photo is null then 'photo_view.png' else c.photo end) as photo,c.employee_no ,c.employee_name,b.department_id,b.plate_id,a.salary_year,a.salary_month,a.basic_salary from employee_salary_details a left join employee_change_plate_records b on a.employee_id = b.employee_id and cast(a.salary_year as int) = b.year and cast(a.salary_month as int) = b.month left join employees c on a.employee_id = c.employee_id and c.is_manager = false left join system_config s on s.system_config_id = 1 where c.employee_name like ? and a.salary_year = ? and a.salary_month >= ? and a.salary_month <= ? and a.employee_id = ? and b.plate_id = ? and b.department_id in (select child_id from department_ids where department_id = ? ) order by a.salary_year desc,a.salary_month desc" ;
	private final static String RESULTSETFIELDLIST = "employee_id,photo,employee_no,employee_name,department_id,plate_id,salary_year,salary_month,basic_salary";
	private final static String[] fieldNames = { "employee_name", "years", "start_month", "end_month", "employee_id", "plate_id", "department_id"};
}
