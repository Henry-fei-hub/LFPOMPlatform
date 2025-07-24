package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLoadSalaryPaymentByCompany;
import pomplatform.payment.bean.ConditionOnLoadSalaryPaymentByCompany;

public class QueryOnLoadSalaryPaymentByCompany extends AbstractQuery<BaseOnLoadSalaryPaymentByCompany, ConditionOnLoadSalaryPaymentByCompany>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadSalaryPaymentByCompany.class);

	public QueryOnLoadSalaryPaymentByCompany() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("company_id");
	}

	@Override
	public BaseCollection<BaseOnLoadSalaryPaymentByCompany> executeQuery( KeyValuePair[] replacements, ConditionOnLoadSalaryPaymentByCompany condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getType()
			);
	}

	@Override
	public BaseOnLoadSalaryPaymentByCompany generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadSalaryPaymentByCompany __base = new BaseOnLoadSalaryPaymentByCompany();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select company_id,year,month,sum(should_salary) as should_salary,sum(leave_advance) as leave_advance,sum(should_bonus) as should_bonus ,sum(should_total) as should_total,sum(should_tax) as should_tax,sum(total_insurance) as total_insurance,sum(personal_pension) as personal_pension ,sum(personal_medical_insurance) as personal_medical_insurance,sum(personal_unemployment_insurance) as personal_unemployment_insurance ,sum(personal_large_medical_insurance) as personal_large_medical_insurance,sum(personal_heating) as personal_heating,sum(total_fund) as total_fund ,sum(instead_deduct) as instead_deduct,sum(instead_deduct_ill) as instead_deduct_ill,sum(fact_salary) as fact_salary,sum(num) as num,type from salary_total_records where company_id = ? and year =? and month =? and type =? GROUP BY company_id,year,MONTH,type ORDER BY company_id,year,MONTH" ;
	private final static String RESULTSETFIELDLIST = "company_id,year,month,should_salary,leave_advance,should_bonus,should_total,should_tax,total_insurance,personal_pension,personal_medical_insurance,personal_unemployment_insurance,personal_large_medical_insurance,personal_heating,total_fund,instead_deduct,instead_deduct_ill,fact_salary,num,type";
	private final static String[] fieldNames = { "company_id", "year", "month", "type"};
}
