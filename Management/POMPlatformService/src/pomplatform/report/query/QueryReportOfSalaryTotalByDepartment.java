package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOfSalaryTotalByDepartment;
import pomplatform.report.bean.ConditionReportOfSalaryTotalByDepartment;

public class QueryReportOfSalaryTotalByDepartment extends AbstractQuery<BaseReportOfSalaryTotalByDepartment, ConditionReportOfSalaryTotalByDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOfSalaryTotalByDepartment.class);

	public QueryReportOfSalaryTotalByDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.department_id");
	}

	@Override
	public BaseCollection<BaseReportOfSalaryTotalByDepartment> executeQuery( KeyValuePair[] replacements, ConditionReportOfSalaryTotalByDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getYear()
			);
	}

	@Override
	public BaseReportOfSalaryTotalByDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOfSalaryTotalByDepartment __base = new BaseReportOfSalaryTotalByDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setJanuary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebruary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarch(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setApril(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJune(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJuly(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAugust(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctober(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecember(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotal(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT aa.department_id, aa.YEAR, SUM ( aa.january ) AS january, SUM ( aa.february ) AS february, SUM ( aa.march ) AS march, SUM ( aa.april ) AS april, SUM ( aa.may ) AS may, SUM ( aa.june ) AS june, SUM ( aa.july ) AS july, SUM ( aa.august ) AS august, SUM ( aa.september ) AS september, SUM ( aa.october ) AS october, SUM ( aa.november ) AS november, SUM ( aa.december ) AS december, ( SUM ( aa.january ) + SUM ( aa.february ) + SUM ( aa.march ) + SUM ( aa.april ) + SUM ( aa.may ) + SUM ( aa.june ) + SUM ( aa.july ) + SUM ( aa.august ) + SUM ( aa.september ) + SUM ( aa.october ) + SUM ( aa.november ) + SUM ( aa.december )) AS total FROM ( SELECT a.department_id, YEAR, CASE WHEN MONTH = 1 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS january, CASE WHEN MONTH = 2 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS february, CASE WHEN MONTH = 3 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS march, CASE WHEN MONTH = 4 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS april, CASE WHEN MONTH = 5 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS may, CASE WHEN MONTH = 6 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS june, CASE WHEN MONTH = 7 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS july, CASE WHEN MONTH = 8 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS august, CASE WHEN MONTH = 9 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS september, CASE WHEN MONTH = 10 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS october, CASE WHEN MONTH = 11 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS november, CASE WHEN MONTH = 12 THEN ( SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) + SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC ))) ELSE 0 END AS december FROM salary_totals a LEFT JOIN plate_departments b ON a.department_id = b.department_id  LEFT JOIN plate_records pr on pr.plate_id = b.plate_id WHERE a.company_id =? AND b.plate_id =? GROUP BY a.department_id, YEAR, MONTH ORDER BY a.department_id, YEAR, MONTH ) AS aa WHERE aa.department_id =? AND aa.YEAR =? GROUP BY aa.department_id, aa.YEAR" ;
	private final static String RESULTSETFIELDLIST = "department_id,year,january,february,march,april,may,june,july,august,september,october,november,december,total";
	private final static String[] fieldNames = { "company_id", "plate_id", "department_id", "year"};
}
