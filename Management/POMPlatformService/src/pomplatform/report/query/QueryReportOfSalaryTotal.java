package pomplatform.report.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.report.bean.BaseReportOfSalaryTotal;
import pomplatform.report.bean.ConditionReportOfSalaryTotal;

public class QueryReportOfSalaryTotal extends AbstractQuery<BaseReportOfSalaryTotal, ConditionReportOfSalaryTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryReportOfSalaryTotal.class);

	public QueryReportOfSalaryTotal() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.plate_id");
	}

	@Override
	public BaseCollection<BaseReportOfSalaryTotal> executeQuery( KeyValuePair[] replacements, ConditionReportOfSalaryTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear()
			);
	}

	@Override
	public BaseReportOfSalaryTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReportOfSalaryTotal __base = new BaseReportOfSalaryTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT aa.plate_id,aa.year,sum(aa.january) as january,sum(aa.february) as february,sum(aa.march) as march,sum(aa.april) as april,sum(aa.may) as may,sum(aa.june) as june,sum(aa.july) as july,sum(aa.august) as august,sum(aa.september) as september,sum(aa.october) as october,sum(aa.november) as november,sum(aa.december) as december,(sum(aa.january)+sum(aa.february)+sum(aa.march)+sum(aa.april)+sum(aa.may)+sum(aa.june)+sum(aa.july)+sum(aa.august)+sum(aa.september)+sum(aa.october)+sum(aa.november)+sum(aa.december)) as total FROM (SELECT b.plate_id,year, CASE WHEN month = 1 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as january,CASE WHEN month = 2 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as february,CASE WHEN month = 3 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as march,CASE WHEN month = 4 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as april,CASE WHEN month = 5 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as may,CASE WHEN month = 6 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as june,CASE WHEN month = 7 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as july,CASE WHEN month = 8 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as august,CASE WHEN month = 9 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as september,CASE WHEN month = 10 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as october,CASE WHEN month = 11 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as november,CASE WHEN month = 12 THEN (sum(CAST(convert_from(decrypt(CAST(should_salary as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_no_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(leave_deduct_tax as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_insurance as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))+sum(CAST(convert_from(decrypt(CAST(unit_total_fund as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric))) else 0 END as december FROM salary_totals a LEFT JOIN plate_departments b ON a.department_id = b.department_id GROUP BY b.plate_id,year,month ORDER BY b.plate_id,year,month) as aa left join plate_records pr on aa.plate_id =pr.plate_id  WHERE aa.plate_id >= 0 and aa.plate_id = ? AND aa.year = ? GROUP BY aa.plate_id,aa.year" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,january,february,march,april,may,june,july,august,september,october,november,december,total";
	private final static String[] fieldNames = { "plate_id", "year"};
}
