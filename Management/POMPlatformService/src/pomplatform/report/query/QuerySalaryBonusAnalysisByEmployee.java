package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseSalaryBonusAnalysisByEmployee;
import pomplatform.report.bean.ConditionSalaryBonusAnalysisByEmployee;

public class QuerySalaryBonusAnalysisByEmployee extends AbstractQuery<BaseSalaryBonusAnalysisByEmployee, ConditionSalaryBonusAnalysisByEmployee>
{

	private static final Logger __logger = Logger.getLogger(QuerySalaryBonusAnalysisByEmployee.class);

	public QuerySalaryBonusAnalysisByEmployee() throws java.sql.SQLException 
	{
		setParameterNumber(17);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sal.employee_id");
	}

	@Override
	public BaseCollection<BaseSalaryBonusAnalysisByEmployee> executeQuery( KeyValuePair[] replacements, ConditionSalaryBonusAnalysisByEmployee condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getFirstStart(), 
				condition.getFirstEnd(), 
				condition.getDepartmentId(), 
				condition.getSecondStart(), 
				condition.getSecondEnd(), 
				condition.getDepartmentId(), 
				condition.getThirdStart(), 
				condition.getThirdEnd(), 
				condition.getDepartmentId(), 
				condition.getFourthStart(), 
				condition.getFourthEnd(), 
				condition.getDepartmentId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseSalaryBonusAnalysisByEmployee generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSalaryBonusAnalysisByEmployee __base = new BaseSalaryBonusAnalysisByEmployee();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFirstQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFirstPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOne(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSecondQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSecondPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTwo(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThirdQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThirdPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setThree(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourthQuarter(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFourthPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFour(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
		if(args[10] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
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

	private final static String __SQLText = "SELECT sal.employee_id, sal.YEAR, sal.first_quarter,bonus.first_pay_integral,CASE WHEN sal.first_quarter = 0 THEN 0 ELSE bonus.first_pay_integral / sal.first_quarter END AS one,sal.second_quarter,bonus.second_pay_integral,CASE WHEN sal.second_quarter = 0 THEN 0 ELSE bonus.second_pay_integral / sal.second_quarter END AS two,sal.third_quarter,bonus.third_pay_integral,CASE WHEN sal.third_quarter = 0 THEN 0 ELSE bonus.third_pay_integral / sal.third_quarter END AS three,sal.fourth_quarter,bonus.fourth_pay_integral,CASE WHEN sal.fourth_quarter = 0 THEN 0 ELSE bonus.fourth_pay_integral / sal.fourth_quarter END AS four FROM ( SELECT aa.employee_id, aa.YEAR, ( SUM ( aa.january ) + SUM ( aa.february ) + SUM ( aa.march )) AS first_quarter, ( SUM ( aa.april ) + SUM ( aa.may ) + SUM ( aa.june ) ) AS second_quarter, ( SUM ( aa.july ) + SUM ( aa.august ) + SUM ( aa.september )) AS third_quarter, ( SUM ( aa.october ) + SUM ( aa.november ) + SUM ( aa.december )) AS fourth_quarter FROM ( SELECT A .employee_id, YEAR, CASE WHEN MONTH = 1 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS january, CASE WHEN MONTH = 2 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS february, CASE WHEN MONTH = 3 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS march, CASE WHEN MONTH = 4 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS april, CASE WHEN MONTH = 5 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS may, CASE WHEN MONTH = 6 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS june, CASE WHEN MONTH = 7 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS july, CASE WHEN MONTH = 8 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS august, CASE WHEN MONTH = 9 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS september, CASE WHEN MONTH = 10 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS october, CASE WHEN MONTH = 11 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS november, CASE WHEN MONTH = 12 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS december FROM salary_totals A LEFT JOIN employees es on es.employee_id = A.employee_id WHERE A.department_id =? GROUP BY A.employee_id, YEAR, MONTH ORDER BY A.employee_id, YEAR, MONTH ) AS aa WHERE aa.employee_id =? AND aa.YEAR =? GROUP BY aa.employee_id, aa.YEAR ) AS sal LEFT JOIN ( SELECT AAA.*, '0' AS YEAR FROM ( SELECT AA.employee_id, SUM ( AA.first_pay_integral ) AS first_pay_integral, SUM ( AA.second_pay_integral ) AS second_pay_integral, SUM ( AA.third_pay_integral ) AS third_pay_integral, SUM ( AA.fourth_pay_integral ) AS fourth_pay_integral, SUM ( AA.first_pay_integral + AA.second_pay_integral + AA.third_pay_integral + AA.fourth_pay_integral ) AS total_pay_integral FROM ( SELECT pd.employee_id, CASE WHEN A.pay_integral ISNULL THEN 0 ELSE A.pay_integral END AS first_pay_integral, CASE WHEN B.pay_integral ISNULL THEN 0 ELSE B.pay_integral END AS second_pay_integral, CASE WHEN C.pay_integral ISNULL THEN 0 ELSE C.pay_integral END AS third_pay_integral, CASE WHEN D.pay_integral ISNULL THEN 0 ELSE D.pay_integral END AS fourth_pay_integral FROM employees pd LEFT JOIN ( SELECT bpd.employee_id, SUM ( bpd.pay_integral ) AS pay_integral FROM bonus_payment_details bpd WHERE bpd.STATE = 1 AND bpd.pay_date >=? AND bpd.pay_date <=? AND bpd.department_id =? GROUP BY bpd.employee_id ) AS A ON pd.employee_id = A.employee_id LEFT JOIN ( SELECT bpd.employee_id, SUM ( bpd.pay_integral ) AS pay_integral FROM bonus_payment_details bpd WHERE bpd.STATE = 1 AND bpd.pay_date >=? AND bpd.pay_date <=? AND bpd.department_id =? GROUP BY bpd.employee_id ) AS B ON pd.employee_id = B.employee_id LEFT JOIN ( SELECT bpd.employee_id, SUM ( bpd.pay_integral ) AS pay_integral FROM bonus_payment_details bpd WHERE bpd.STATE = 1 AND bpd.pay_date >=? AND bpd.pay_date <=? AND bpd.department_id =? GROUP BY bpd.employee_id ) AS C ON pd.employee_id = C.employee_id LEFT JOIN ( SELECT bpd.employee_id, SUM ( bpd.pay_integral ) AS pay_integral FROM bonus_payment_details bpd WHERE bpd.STATE = 1 AND bpd.pay_date >=? AND bpd.pay_date <=? AND bpd.department_id =? GROUP BY bpd.employee_id ) AS D ON pd.employee_id = D.employee_id where pd.department_id =? ) AS AA WHERE AA.employee_id =? GROUP BY AA.employee_id ORDER BY employee_id ) AS AAA ) AS bonus ON sal.employee_id = bonus.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,year,first_quarter,first_pay_integral,one,second_quarter,second_pay_integral,two,third_quarter,third_pay_integral,three,fourth_quarter,fourth_pay_integral,four";
	private final static String[] fieldNames = { "department_id", "employee_id", "YEAR", "first_start", "first_end", "department_id", "second_start", "second_end", "department_id", "third_start", "third_end", "department_id", "fourth_start", "fourth_end", "department_id", "department_id", "employee_id"};
}
