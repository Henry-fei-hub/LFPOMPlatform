package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryReportByPlate;
import pomplatform.payment.bean.ConditionOnSalaryReportByPlate;

public class QueryOnSalaryReportByPlate extends AbstractQuery<BaseOnSalaryReportByPlate, ConditionOnSalaryReportByPlate>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryReportByPlate.class);

	public QueryOnSalaryReportByPlate() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryReportByPlate> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryReportByPlate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnSalaryReportByPlate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryReportByPlate __base = new BaseOnSalaryReportByPlate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setSuspendBonus(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select a.plate_id,a.year,a.month,a.should_salary,(a.leave_no_deduct_tax+a.leave_deduct_tax) as leave_advance,a.should_bonus ,(a.should_salary+a.leave_no_deduct_tax+a.leave_deduct_tax+a.should_bonus+A.suspend_bonus) as should_total,a.should_tax,a.total_insurance,a.total_fund,a.instead_deduct,a.instead_deduct_ill , a.fact_salary as fact_salary ,a.num,a.unit_total_insurance,a.unit_total_fund,a.replacement_tax,a.suspend_bonus from (select count(plate_id) as num,plate_id,year,month,sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as should_salary,sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as leave_no_deduct_tax ,sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as leave_deduct_tax,sum(CAST(convert_from(decrypt(CAST(should_bonus as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as should_bonus,sum(CAST(convert_from(decrypt(CAST(should_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as should_tax ,sum(CAST(convert_from(decrypt(CAST(total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as total_insurance,sum(CAST(convert_from(decrypt(CAST(total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as total_fund ,sum(CAST(convert_from(decrypt(CAST(instead_deduct as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as instead_deduct,sum(CAST(convert_from(decrypt(CAST(instead_deduct_ill as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as instead_deduct_ill ,sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as unit_total_insurance,sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric)) as unit_total_fund ,sum(CAST (convert_from ( decrypt ( CAST ( replacement_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS NUMERIC )) AS replacement_tax ,SUM (CAST (convert_from(decrypt ( CAST ( fact_salary AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS NUMERIC )) AS fact_salary ,SUM (CAST (convert_from(decrypt ( CAST ( suspend_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ),'SQL_ASCII' ) AS NUMERIC )) AS suspend_bonus from salary_totals where company_id = ? GROUP BY plate_id,year,month ) as a where a.plate_id = ? and a.year = ? and a.month = ? ORDER BY a.plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,month,should_salary,leave_advance,should_bonus,should_total,should_tax,total_insurance,total_fund,instead_deduct,instead_deduct_ill,fact_salary,num,unit_total_insurance,unit_total_fund,replacement_tax,suspend_bonus";
	private final static String[] fieldNames = { "company_id", "plate_id", "year", "month"};
}
