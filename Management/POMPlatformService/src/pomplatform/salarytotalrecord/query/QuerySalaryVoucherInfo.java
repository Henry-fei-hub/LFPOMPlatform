package pomplatform.salarytotalrecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.salarytotalrecord.bean.BaseSalaryVoucherInfo;
import pomplatform.salarytotalrecord.bean.ConditionSalaryVoucherInfo;

public class QuerySalaryVoucherInfo extends AbstractQuery<BaseSalaryVoucherInfo, ConditionSalaryVoucherInfo>
{

	private static final Logger __logger = Logger.getLogger(QuerySalaryVoucherInfo.class);

	public QuerySalaryVoucherInfo() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sum(a.should_salary) as should_salary");
	}

	@Override
	public BaseCollection<BaseSalaryVoucherInfo> executeQuery( KeyValuePair[] replacements, ConditionSalaryVoucherInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getType()
			);
	}

	@Override
	public BaseSalaryVoucherInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSalaryVoucherInfo __base = new BaseSalaryVoucherInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setShouldSalary(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeaveAdvance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setShouldTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalPension(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalHeating(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDepartmentType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT sum(a.should_salary) as should_salary, sum(a.leave_advance) as leave_advance, sum(a.should_tax) as should_tax, sum(a.total_insurance) as total_insurance, sum(a.personal_pension) as personal_pension, sum(a.personal_medical_insurance) as personal_medical_insurance, sum(a.personal_unemployment_insurance) as personal_unemployment_insurance, sum(a.personal_large_medical_insurance) as personal_large_medical_insurance, sum(a.personal_heating) as personal_heating, sum(a.total_fund) as total_fund, b.plate_voucher_type as department_type, a.company_id, a.type from salary_total_records a  left join plate_records b on a.plate_id = b.plate_id where a.company_id = ? and a.year = ? and a.month = ? and a.type = ? group by b.plate_voucher_type, a.company_id, a.type ORDER BY a.company_id, b.plate_voucher_type, a.type" ;
	private final static String RESULTSETFIELDLIST = "should_salary,leave_advance,should_tax,total_insurance,personal_pension,personal_medical_insurance,personal_unemployment_insurance,personal_large_medical_insurance,personal_heating,total_fund,department_type,company_id,type";
	private final static String[] fieldNames = { "company_id", "year", "month", "type"};
}
