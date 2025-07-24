package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseLoadSalaryTotal3;
import pomplatform.payment.bean.ConditionLoadSalaryTotal3;

public class QueryLoadSalaryTotal3 extends AbstractQuery<BaseLoadSalaryTotal3, ConditionLoadSalaryTotal3>
{

	private static final Logger __logger = Logger.getLogger(QueryLoadSalaryTotal3.class);

	public QueryLoadSalaryTotal3() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("salary_total_id");
	}

	@Override
	public BaseCollection<BaseLoadSalaryTotal3> executeQuery( KeyValuePair[] replacements, ConditionLoadSalaryTotal3 condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseLoadSalaryTotal3 generateBase(Object[] __data) throws java.sql.SQLException {
		BaseLoadSalaryTotal3 __base = new BaseLoadSalaryTotal3();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSalaryTotalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialAdditionalDuduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxBegin(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTaxAchieve(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldTotal(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlreadyBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeaveDeductTax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInsteadDeductIll(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShouldTaxAchieveSum(GenericBase.__getString(val));
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

	private final static String __SQLText = " SELECT salary_total_id, employee_id, special_additional_duduct, tax_begin, COALESCE ( convert_from( decrypt ( CAST ( should_tax_achieve AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS should_tax_achieve, COALESCE ( convert_from( decrypt ( CAST ( should_total AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS should_total, COALESCE ( convert_from( decrypt ( CAST ( already_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS already_bonus , COALESCE ( convert_from( decrypt ( CAST ( other_bonus AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS other_bonus , COALESCE ( convert_from( decrypt ( CAST ( leave_deduct_tax AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS leave_deduct_tax , COALESCE ( convert_from( decrypt ( CAST ( total_insurance AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS total_insurance , COALESCE ( convert_from( decrypt ( CAST ( total_fund AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS total_fund , COALESCE ( convert_from( decrypt ( CAST ( instead_deduct_ill AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS instead_deduct_ill , COALESCE ( convert_from( decrypt ( CAST ( should_tax_achieve_sum AS bytea ), CAST (( SELECT image_path FROM system_config WHERE system_config_id = 2 ) AS bytea ), 'aes' ), 'SQL_ASCII' ), '0' ) AS should_tax_achieve_sum FROM salary_totals WHERE employee_id =? AND YEAR =? AND MONTH =?" ;
	private final static String RESULTSETFIELDLIST = "salary_total_id,employee_id,special_additional_duduct,tax_begin,should_tax_achieve,should_total,already_bonus,other_bonus,leave_deduct_tax,total_insurance,total_fund,instead_deduct_ill,should_tax_achieve_sum";
	private final static String[] fieldNames = { "employee_id", "YEAR", "MONTH"};
}
