package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryReportByDepartment;
import pomplatform.payment.bean.ConditionOnSalaryReportByDepartment;

public class QueryOnSalaryReportByDepartment extends AbstractQuery<BaseOnSalaryReportByDepartment, ConditionOnSalaryReportByDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryReportByDepartment.class);

	public QueryOnSalaryReportByDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.department_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryReportByDepartment> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryReportByDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnSalaryReportByDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryReportByDepartment __base = new BaseOnSalaryReportByDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShouldSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeaveAdvance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInsteadDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInsteadDeductIll(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReplacementTax(GenericBase.__getDecimal(val));
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
	private final static String __SQLText = "SELECT A .department_id, A.YEAR, A.MONTH, A.should_salary, ( A.leave_no_deduct_tax + A.leave_deduct_tax ) AS leave_advance, A.should_bonus, ( A.should_salary + A.leave_no_deduct_tax + A.leave_deduct_tax + A.should_bonus ) AS should_total, A.should_tax, A.total_insurance, A.total_fund, A.instead_deduct, A.instead_deduct_ill,  A.fact_salary AS fact_salary, A.num, A.unit_total_insurance, A.unit_total_fund, A.replacement_tax FROM ( SELECT COUNT ( department_id ) AS num, department_id, YEAR, MONTH, SUM ( CAST ( convert_from( decrypt ( CAST ( should_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS should_salary, SUM ( CAST ( convert_from( decrypt ( CAST ( leave_no_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS leave_no_deduct_tax, SUM ( CAST ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS leave_deduct_tax, SUM ( CAST ( convert_from( decrypt ( CAST ( should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS should_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( should_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS should_tax, SUM ( CAST ( convert_from( decrypt ( CAST ( total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS total_insurance, SUM ( CAST ( convert_from( decrypt ( CAST ( total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS total_fund, SUM ( CAST ( convert_from( decrypt ( CAST ( instead_deduct AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS instead_deduct, SUM ( CAST ( convert_from( decrypt ( CAST ( instead_deduct_ill AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS instead_deduct_ill, SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS unit_total_insurance, SUM ( CAST ( convert_from( decrypt ( CAST ( unit_total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS unit_total_fund ,SUM (CAST (convert_from(decrypt ( CAST ( replacement_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS NUMERIC )) AS replacement_tax ,SUM (CAST (convert_from(decrypt ( CAST ( fact_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS NUMERIC )) AS fact_salary FROM salary_totals WHERE company_id =? AND plate_id =? GROUP BY department_id, YEAR, MONTH ) AS A WHERE A.department_id =? AND A.YEAR =? AND A.MONTH =? ORDER BY A.department_id" ;
//	private final static String __SQLText = "select a.department_id,a.year,a.month,a.should_salary,(a.leave_no_deduct_tax+a.leave_deduct_tax) as leave_advance,a.should_bonus ,(a.should_salary+a.leave_no_deduct_tax+a.leave_deduct_tax+a.should_bonus) as should_total,a.should_tax,a.total_insurance,a.total_fund,a.instead_deduct,a.instead_deduct_ill ,(a.should_salary+a.leave_no_deduct_tax+a.leave_deduct_tax+a.should_bonus-a.should_tax-a.total_insurance-a.total_fund+a.instead_deduct-a.instead_deduct_ill) as fact_salary ,a.num,a.unit_total_insurance,a.unit_total_fund,a.replacement_tax from (select count(department_id) as num,department_id,year,month,sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as should_salary,sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as leave_no_deduct_tax ,sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as leave_deduct_tax,sum(CAST(convert_from(decrypt(CAST(should_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as should_bonus,sum(CAST(convert_from(decrypt(CAST(should_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as should_tax ,sum(CAST(convert_from(decrypt(CAST(total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as total_insurance,sum(CAST(convert_from(decrypt(CAST(total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as total_fund ,sum(CAST(convert_from(decrypt(CAST(instead_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as instead_deduct,sum(CAST(convert_from(decrypt(CAST(instead_deduct_ill as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as instead_deduct_ill ,sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as unit_total_insurance,sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as unit_total_fund 		,SUM (CAST (convert_from(decrypt ( CAST ( replacement_tax AS bytea ) ,SUM (CAST (convert_from(decrypt ( CAST ( replacement_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS NUMERIC )) AS replacement_tax  from salary_totals where company_id = ? and plate_id = ? GROUP BY department_id,year,month ) as a where a.department_id = ? and a.year = ? and a.month = ? ORDER BY a.department_id" ;
	private final static String RESULTSETFIELDLIST = "department_id,year,month,should_salary,leave_advance,should_bonus,should_total,should_tax,total_insurance,total_fund,instead_deduct,instead_deduct_ill,fact_salary,num,unit_total_insurance,unit_total_fund,replacement_tax";
	private final static String[] fieldNames = { "company_id", "plate_id", "department_id", "year", "month"};
}
