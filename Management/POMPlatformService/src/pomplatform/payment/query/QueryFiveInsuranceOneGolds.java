package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseFiveInsuranceOneGolds;
import pomplatform.payment.bean.ConditionFiveInsuranceOneGolds;

public class QueryFiveInsuranceOneGolds extends AbstractQuery<BaseFiveInsuranceOneGolds, ConditionFiveInsuranceOneGolds>
{

	private static final Logger __logger = Logger.getLogger(QueryFiveInsuranceOneGolds.class);

	public QueryFiveInsuranceOneGolds() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("fiog.five_insurance_one_gold_id");
	}

	@Override
	public BaseCollection<BaseFiveInsuranceOneGolds> executeQuery( KeyValuePair[] replacements, ConditionFiveInsuranceOneGolds condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartMonth(), 
				condition.getEndMonth(), 
				condition.getYear(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseFiveInsuranceOneGolds generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFiveInsuranceOneGolds __base = new BaseFiveInsuranceOneGolds();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFiveInsuranceOneGoldId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalTotalFund(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalTotalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitPension(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitInjuryInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitGiveBirthInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalPension(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalSeriousIllInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalHeating(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUnitDisabilityInsurance(GenericBase.__getDecimal(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
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

	private final static String __SQLText = "select fiog.five_insurance_one_gold_id,fiog.employee_no, fiog.employee_id,fiog.company_id,fiog.department_id,fiog.plate_id, fiog.year, fiog.month, fiog.total_fund, fiog.unit_total_fund, fiog.personal_total_fund, fiog.total_insurance, fiog.unit_total_insurance, fiog.personal_total_insurance, fiog.unit_pension, fiog.unit_medical_insurance, fiog.unit_large_medical_insurance, fiog.unit_injury_insurance, fiog.unit_unemployment_insurance, fiog.unit_give_birth_insurance, fiog.personal_pension, fiog.personal_medical_insurance, fiog.personal_large_medical_insurance, fiog.personal_serious_ill_insurance, fiog.personal_unemployment_insurance, fiog.personal_heating, fiog.operate_employee_id, fiog.operate_time, fiog.remark,fiog.unit_disability_insurance from five_insurance_one_golds fiog WHERE fiog.month between ? and ? and fiog.year = ? and fiog.employee_id = ? and fiog.employee_no LIKE ? AND fiog.company_id = ?" ;
	private final static String RESULTSETFIELDLIST = "five_insurance_one_gold_id,employee_no,employee_id,company_id,department_id,plate_id,year,month,total_fund,unit_total_fund,personal_total_fund,total_insurance,unit_total_insurance,personal_total_insurance,unit_pension,unit_medical_insurance,unit_large_medical_insurance,unit_injury_insurance,unit_unemployment_insurance,unit_give_birth_insurance,personal_pension,personal_medical_insurance,personal_large_medical_insurance,personal_serious_ill_insurance,personal_unemployment_insurance,personal_heating,operate_employee_id,operate_time,remark,unit_disability_insurance";
	private final static String[] fieldNames = { "start_month", "end_month", "year", "employee_id", "employee_no", "company_id"};
}
