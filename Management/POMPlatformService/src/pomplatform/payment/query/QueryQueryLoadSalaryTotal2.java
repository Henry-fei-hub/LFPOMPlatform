package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseQueryLoadSalaryTotal2;
import pomplatform.payment.bean.ConditionQueryLoadSalaryTotal2;

public class QueryQueryLoadSalaryTotal2 extends AbstractQuery<BaseQueryLoadSalaryTotal2, ConditionQueryLoadSalaryTotal2>
{

	private static final Logger __logger = Logger.getLogger(QueryQueryLoadSalaryTotal2.class);

	public QueryQueryLoadSalaryTotal2() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("salary_total_id");
	}

	@Override
	public BaseCollection<BaseQueryLoadSalaryTotal2> executeQuery( KeyValuePair[] replacements, ConditionQueryLoadSalaryTotal2 condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseQueryLoadSalaryTotal2 generateBase(Object[] __data) throws java.sql.SQLException {
		BaseQueryLoadSalaryTotal2 __base = new BaseQueryLoadSalaryTotal2();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSalaryTotalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialAdditionalDuduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTaxAchieve(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT salary_total_id, employee_id, special_additional_duduct, COALESCE ( convert_from( decrypt ( CAST ( should_tax_achieve AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS should_tax_achieve, COALESCE ( convert_from( decrypt ( CAST ( total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS total_fund, COALESCE ( convert_from( decrypt ( CAST ( total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS total_insurance FROM salary_totals WHERE employee_id =? AND YEAR =? AND MONTH =?" ;
	private final static String RESULTSETFIELDLIST = "salary_total_id,employee_id,special_additional_duduct,should_tax_achieve,total_fund,total_insurance";
	private final static String[] fieldNames = { "employee_id", "YEAR", "MONTH"};
}
