package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnSalaryPlateBonusByCompany;
import pomplatform.payment.bean.ConditionOnSalaryPlateBonusByCompany;

public class QueryOnSalaryPlateBonusByCompany extends AbstractQuery<BaseOnSalaryPlateBonusByCompany, ConditionOnSalaryPlateBonusByCompany>
{

	private static final Logger __logger = Logger.getLogger(QueryOnSalaryPlateBonusByCompany.class);

	public QueryOnSalaryPlateBonusByCompany() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pd .plate_id");
	}

	@Override
	public BaseCollection<BaseOnSalaryPlateBonusByCompany> executeQuery( KeyValuePair[] replacements, ConditionOnSalaryPlateBonusByCompany condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getPersonnelBusinessId(), 
				condition.getFlowStatus(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseOnSalaryPlateBonusByCompany generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnSalaryPlateBonusByCompany __base = new BaseOnSalaryPlateBonusByCompany();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectBonus(GenericBase.__getDecimal(val));
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
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
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

	private final static String __SQLText = "SELECT pd .plate_id, A.YEAR, A.MONTH, COALESCE ( SUM ( CAST ( convert_from( decrypt ( CAST ( A.should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )), 0 ) + COALESCE ( SUM ( CAST ( convert_from( decrypt ( CAST ( A.other_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )), 0 ) AS should_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( A.should_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS should_tax, SUM ( CAST ( convert_from( decrypt ( CAST ( A.fact_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS fact_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( A.other_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS other_bonus, SUM ( CAST ( convert_from( decrypt ( CAST ( A.should_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ) AS NUMERIC )) AS project_bonus FROM salary_of_bonus A LEFT JOIN employees e ON A.employee_id = e.employee_id LEFT JOIN plate_departments pd on pd.department_id = A.department_id WHERE FLAG IN ( 2, 3 ) AND A.company_id =? AND A.YEAR =? AND A.MONTH =? AND pd.plate_id =? AND personnel_business_id =? AND flow_status =? AND send_time BETWEEN ? AND ? AND 1 = 1 GROUP BY pd.plate_id, A.YEAR, A.MONTH ORDER BY pd.plate_id, A.YEAR, A.MONTH" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,month,should_bonus,should_tax,fact_bonus,other_bonus,project_bonus";
	private final static String[] fieldNames = { "company_id", "year", "month", "plate_id", "personnel_business_id", "flow_status", "start_time", "end_time"};
}
