package pomplatform.salary.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salary.bean.BaseSalaryOfShouldBonus;
import pomplatform.salary.bean.ConditionSalaryOfShouldBonus;

public class QuerySalaryOfShouldBonus extends AbstractQuery<BaseSalaryOfShouldBonus, ConditionSalaryOfShouldBonus>
{

	private static final Logger __logger = Logger.getLogger(QuerySalaryOfShouldBonus.class);

	public QuerySalaryOfShouldBonus() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sob.salary_of_bonus_id");
	}

	@Override
	public BaseCollection<BaseSalaryOfShouldBonus> executeQuery( KeyValuePair[] replacements, ConditionSalaryOfShouldBonus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseSalaryOfShouldBonus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSalaryOfShouldBonus __base = new BaseSalaryOfShouldBonus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSalaryOfBonusId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsSended(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT sob.salary_of_bonus_id,sob.employee_id,e.employee_no,e.employee_name,sob.company_id,sob.plate_id,sob.department_id,e.onboard_status,sob.record_date,convert_from(decrypt(CAST(sob.should_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as should_bonus,sob.flag,sob.is_sended,sob.year,sob.month FROM salary_of_bonus sob LEFT JOIN employees e ON sob.employee_id = e.employee_id WHERE e.employee_id > 0 AND e.employee_no LIKE ? AND e.employee_id = ? AND e.department_id in (select child_id from department_ids where department_id = ?) AND sob.year = ? and sob.month = ? and sob.flag = 1" ;
	private final static String RESULTSETFIELDLIST = "salary_of_bonus_id,employee_id,employee_no,employee_name,company_id,plate_id,department_id,onboard_status,record_date,should_bonus,flag,is_sended,year,month";
	private final static String[] fieldNames = { "employee_no", "employee_id", "department_id", "year", "month"};
}
