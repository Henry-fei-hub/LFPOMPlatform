package pomplatform.salary.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salary.bean.BaseSalaryOfWorkYears;
import pomplatform.salary.bean.ConditionSalaryOfWorkYears;

public class QuerySalaryOfWorkYears extends AbstractQuery<BaseSalaryOfWorkYears, ConditionSalaryOfWorkYears>
{

	private static final Logger __logger = Logger.getLogger(QuerySalaryOfWorkYears.class);

	public QuerySalaryOfWorkYears() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseSalaryOfWorkYears> executeQuery( KeyValuePair[] replacements, ConditionSalaryOfWorkYears condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseSalaryOfWorkYears generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSalaryOfWorkYears __base = new BaseSalaryOfWorkYears();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPositiveDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setJanuary(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setFebruary(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setMarch(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setApril(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setMay(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setJune(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setJuly(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setAugust(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSeptember(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setOctober(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setNovember(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setDecember(GenericBase.__getLong(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT e.employee_id,e.employee_no,e.employee_name,e.plate_id,e.department_id,e.onboard_status,e.onboard_date,e.positive_date, salary.* FROM employees e LEFT JOIN (SELECT employee_id,year,sum(CAST((case WHEN month = 1 THEN work_money else '0' end) AS INTEGER)) as january, sum(CAST((case WHEN month = 2 THEN work_money else '0' end) AS INTEGER)) as february, sum(CAST((case WHEN month = 3 THEN work_money else '0' end) AS INTEGER)) as march, sum(CAST((case WHEN month = 4 THEN work_money else '0' end) AS INTEGER)) as april, sum(CAST((case WHEN month = 5 THEN work_money else '0' end) AS INTEGER)) as may, sum(CAST((case WHEN month = 6 THEN work_money else '0' end) AS INTEGER)) as june, sum(CAST((case WHEN month = 7 THEN work_money else '0' end) AS INTEGER)) as july, sum(CAST((case WHEN month = 8 THEN work_money else '0' end) AS INTEGER)) as august, sum(CAST((case WHEN month = 9 THEN work_money else '0' end) AS INTEGER)) as september, sum(CAST((case WHEN month = 10 THEN work_money else '0' end) AS INTEGER)) as october, sum(CAST((case WHEN month = 11 THEN work_money else '0' end) AS INTEGER)) as november, sum(CAST((case WHEN month = 12 THEN work_money else '0' end) AS INTEGER)) as december FROM salary_of_work_years WHERE year = ? GROUP BY employee_id,year) salary ON e.employee_id = salary.employee_id WHERE e.employee_id = ? AND e.employee_no LIKE ? AND e.department_id in (select child_id from department_ids where department_id = ?) AND (e.status = 0 or ( e.status = 1 and EXTRACT(YEAR from e.resignation_date) > 2016)) and e.employee_id > 0 ORDER BY e.employee_id ASC" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,plate_id,department_id,onboard_status,onboard_date,positive_date,employee_id,year,january,february,march,april,may,june,july,august,september,october,november,december";
	private final static String[] fieldNames = { "year", "employee_id", "employee_no", "department_id"};
}
