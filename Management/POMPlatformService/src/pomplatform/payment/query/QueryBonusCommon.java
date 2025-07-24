package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseBonusCommon;
import pomplatform.payment.bean.ConditionBonusCommon;

public class QueryBonusCommon extends AbstractQuery<BaseBonusCommon, ConditionBonusCommon>
{

	private static final Logger __logger = Logger.getLogger(QueryBonusCommon.class);

	public QueryBonusCommon() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A.employee_id");
	}

	@Override
	public BaseCollection<BaseBonusCommon> executeQuery( KeyValuePair[] replacements, ConditionBonusCommon condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPersonnelBusinessId(), 
				condition.getSalaryType(), 
				condition.getFundraisingProjectType()
			);
	}

	@Override
	public BaseBonusCommon generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBonusCommon __base = new BaseBonusCommon();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalaryType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFundraisingProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFundraisingProjectRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT A.employee_id, b.employee_no, A.plate_id, A.YEAR, A.MONTH, COALESCE ( SUM ( CAST ( convert_from( decrypt ( CAST ( A.should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )), 0 ) + COALESCE ( SUM ( CAST ( convert_from( decrypt ( CAST ( A.other_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )), 0 ) AS should_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( A.should_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS should_tax, SUM ( CAST ( convert_from( decrypt ( CAST ( A.fact_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS fact_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( A.other_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS other_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( A.should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS project_bonus, es.salary_type, es.fundraising_project_type, es.fundraising_project_rate, A.personnel_business_id, A.company_id FROM salary_of_bonus A LEFT JOIN employees b ON A.employee_id = b.employee_id LEFT JOIN employee_salary_types es on es.employee_id = A.employee_id WHERE A.FLAG IN ( 2, 3 ) AND A.company_id =? AND A.YEAR =? AND A.MONTH =? AND A.personnel_business_id =? AND es.salary_type =? AND es.fundraising_project_type =? GROUP BY A.employee_id, A.plate_id, A.company_id, b.employee_no, A.YEAR, A.MONTH, es.salary_type, es.fundraising_project_type, es.fundraising_project_rate, A.personnel_business_id ORDER BY A.company_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,plate_id,year,month,should_bonus,should_tax,fact_bonus,other_bonus,project_bonus,salary_type,fundraising_project_type,fundraising_project_rate,personnel_business_id,company_id";
	private final static String[] fieldNames = { "company_id", "year", "month", "personnel_business_id", "salary_type", "fundraising_project_type"};
}
