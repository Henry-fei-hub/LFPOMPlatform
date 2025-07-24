package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLoadSalaryPaymentChange;
import pomplatform.payment.bean.ConditionOnLoadSalaryPaymentChange;

public class QueryOnLoadSalaryPaymentChange extends AbstractQuery<BaseOnLoadSalaryPaymentChange, ConditionOnLoadSalaryPaymentChange>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadSalaryPaymentChange.class);

	public QueryOnLoadSalaryPaymentChange() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("company_id");
	}

	@Override
	public BaseCollection<BaseOnLoadSalaryPaymentChange> executeQuery( KeyValuePair[] replacements, ConditionOnLoadSalaryPaymentChange condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnLoadSalaryPaymentChange generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadSalaryPaymentChange __base = new BaseOnLoadSalaryPaymentChange();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setShouldSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeaveAdvance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldBonus(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalPension(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalHeating(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInsteadDeduct(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInsteadDeductIll(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFactSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select company_id,plate_id,year,month ,sum(CASE WHEN type = 1 then -should_salary else should_salary end) as should_salary ,sum(CASE WHEN type = 1 then -leave_advance else leave_advance end) as leave_advance ,sum(CASE WHEN type = 1 then -should_bonus else should_bonus end) as should_bonus ,sum(CASE WHEN type = 1 then -should_total else should_total end) as should_total ,sum(CASE WHEN type = 1 then -should_tax else should_tax end) as should_tax ,sum(CASE WHEN type = 1 then -total_insurance else total_insurance end) as total_insurance ,sum(CASE WHEN type = 1 then -personal_pension else personal_pension end) as personal_pension ,sum(CASE WHEN type = 1 then -personal_medical_insurance else personal_medical_insurance end) as personal_medical_insurance ,sum(CASE WHEN type = 1 then -personal_unemployment_insurance else personal_unemployment_insurance end) as personal_unemployment_insurance ,sum(CASE WHEN type = 1 then -personal_large_medical_insurance else personal_large_medical_insurance end) as personal_large_medical_insurance ,sum(CASE WHEN type = 1 then -personal_heating else personal_heating end) as personal_heating ,sum(CASE WHEN type = 1 then -total_fund else total_fund end) as total_fund ,sum(CASE WHEN type = 1 then -instead_deduct else instead_deduct end) as instead_deduct ,sum(CASE WHEN type = 1 then -instead_deduct_ill else instead_deduct_ill end) as instead_deduct_ill ,sum(CASE WHEN type = 1 then -fact_salary else fact_salary end) as fact_salary ,sum(CASE WHEN type = 1 then -num else num end) as num from salary_total_records where type < 3 and company_id = ? and plate_id = ? and year = ? and month = ? GROUP BY company_id,plate_id,year,month ORDER BY company_id,plate_id,year,month" ;
	private final static String RESULTSETFIELDLIST = "company_id,plate_id,year,month,should_salary,leave_advance,should_bonus,should_total,should_tax,total_insurance,personal_pension,personal_medical_insurance,personal_unemployment_insurance,personal_large_medical_insurance,personal_heating,total_fund,instead_deduct,instead_deduct_ill,fact_salary,num";
	private final static String[] fieldNames = { "company_id", "plate_id", "year", "month"};
}
