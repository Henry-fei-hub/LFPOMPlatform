package pomplatform.report.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseDepartmentIncomeReport;
import pomplatform.report.bean.ConditionDepartmentIncomeReport;

public class QueryDepartmentIncomeReport extends AbstractQuery<BaseDepartmentIncomeReport, ConditionDepartmentIncomeReport>
{

	private static final Logger __logger = Logger.getLogger(QueryDepartmentIncomeReport.class);

	public QueryDepartmentIncomeReport() throws java.sql.SQLException 
	{
		setParameterNumber(24);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("one.plate_income_and_expenditure_id");
	}

	@Override
	public BaseCollection<BaseDepartmentIncomeReport> executeQuery(KeyValuePair[] replacements, ConditionDepartmentIncomeReport condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseDepartmentIncomeReport generateBase(Object[] __data) throws java.sql.SQLException {
		BaseDepartmentIncomeReport __base = new BaseDepartmentIncomeReport();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateIncomeAndExpenditureId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setJanuary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebruary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarch(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApril(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJune(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJuly(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAguest(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctober(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotal(GenericBase.__getDecimal(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setInt(count++, GenericBase.__getInt(args[19]));
		if(args[20] != null) __statement.setInt(count++, GenericBase.__getInt(args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
		if(args[22] != null) __statement.setInt(count++, GenericBase.__getInt(args[22]));
		if(args[23] != null) __statement.setInt(count++, GenericBase.__getInt(args[23]));
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

	private final static String __SQLText = "select one.plate_income_and_expenditure_id, one.plate_id, one.year, one.month, one.balance as January, two.balance as February, three.balance as March, four.balance as April, five.balance as May, six.balance as June, seven.balance as July, eight.balance as Aguest, nine.balance as September, ten.balance as October, eleven.balance as November, twelve.balance as December, (case when one.balance is null then 0 ELSE one.balance end + case when two.balance is null then 0 ELSE two.balance end + case when three.balance is null then 0 ELSE three.balance end + case when four.balance is null then 0 ELSE four.balance end + case when five.balance is null then 0 ELSE five.balance end + case when six.balance is null then 0 ELSE six.balance end + case when seven.balance is null then 0 ELSE seven.balance end + case when eight.balance is null then 0 ELSE eight.balance end + case when nine.balance is null then 0 ELSE nine.balance end + case when ten.balance is null then 0 ELSE ten.balance end + case when eleven.balance is null then 0 ELSE eleven.balance end + case when twelve.balance is null then 0 ELSE twelve.balance end) as total from ( (SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) AS balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 1 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost ) AS one LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 2 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost ) AS two on one.plate_id = two.plate_id LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 3 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost )As three on three.plate_id = one.plate_id LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 4 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost )As four on four.plate_id = one.plate_id LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 5 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost )As five on five.plate_id = one.plate_id LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 6 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost )As six on six.plate_id = one.plate_id LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 7 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost )As seven on seven.plate_id = one.plate_id LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 8 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost )As eight on eight.plate_id = one.plate_id LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 9 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost )As nine on nine.plate_id = one.plate_id LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 10 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost )As ten on ten.plate_id = one.plate_id LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 11 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost )As eleven on eleven.plate_id = one.plate_id LEFT JOIN ( SELECT plate_income_and_expenditure_id, plate_id, YEAR, MONTH , ( department_confirmation_points + employee_confirmation_points - employee_cost - project_cost - plate_cost ) As balance FROM plate_income_and_expenditures WHERE YEAR =? and plate_id =? and month = 12 GROUP BY plate_id, YEAR, MONTH, department_confirmation_points, employee_confirmation_points, employee_cost, project_cost, plate_income_and_expenditure_id, plate_cost )As twelve on twelve.plate_id = one.plate_id )" ;
	private final static String RESULTSETFIELDLIST = "plate_income_and_expenditure_id,plate_id,year,month,january,february,march,april,may,june,july,aguest,september,october,november,december,total";
	private final static String[] fieldNames = { "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id", "year", "plate_id"};
}
