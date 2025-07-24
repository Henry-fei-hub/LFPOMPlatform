package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseLoadSalaryTotal;
import pomplatform.payment.bean.ConditionLoadSalaryTotal;

public class QueryLoadSalaryTotal extends AbstractQuery<BaseLoadSalaryTotal, ConditionLoadSalaryTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryLoadSalaryTotal.class);

	public QueryLoadSalaryTotal() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("salary_total_id");
	}

	@Override
	public BaseCollection<BaseLoadSalaryTotal> executeQuery( KeyValuePair[] replacements, ConditionLoadSalaryTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseLoadSalaryTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseLoadSalaryTotal __base = new BaseLoadSalaryTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSalaryTotalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialAdditionalDuduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTaxAchieve(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldTaxAchieveSum(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIndividualIncomeTaxSum(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInsuranceFundSum(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialDuductSum(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT salary_total_id, employee_id, special_additional_duduct, COALESCE ( convert_from( decrypt ( CAST ( should_tax_achieve AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS should_tax_achieve, COALESCE ( convert_from( decrypt ( CAST ( total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS total_fund, COALESCE ( convert_from( decrypt ( CAST ( total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS total_insurance, COALESCE ( convert_from( decrypt ( CAST ( should_tax_achieve_sum AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS should_tax_achieve_sum, COALESCE ( convert_from( decrypt ( CAST ( individual_income_tax_sum AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS individual_income_tax_sum, COALESCE ( convert_from( decrypt ( CAST ( insurance_fund_sum AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS insurance_fund_sum, special_duduct_sum FROM salary_totals WHERE YEAR =? AND MONTH =? AND employee_id =?" ;
	private final static String RESULTSETFIELDLIST = "salary_total_id,employee_id,special_additional_duduct,should_tax_achieve,total_fund,total_insurance,should_tax_achieve_sum,individual_income_tax_sum,insurance_fund_sum,special_duduct_sum";
	private final static String[] fieldNames = { "YEAR", "MONTH", "employee_id"};
}
