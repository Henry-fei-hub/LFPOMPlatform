package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseFiveInsuranceOneGoldsPaymentBase;
import pomplatform.payment.bean.ConditionFiveInsuranceOneGoldsPaymentBase;

public class QueryFiveInsuranceOneGoldsPaymentBase extends AbstractQuery<BaseFiveInsuranceOneGoldsPaymentBase, ConditionFiveInsuranceOneGoldsPaymentBase>
{

	private static final Logger __logger = Logger.getLogger(QueryFiveInsuranceOneGoldsPaymentBase.class);

	public QueryFiveInsuranceOneGoldsPaymentBase() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("f.five_insurance_one_gold_id");
	}

	@Override
	public BaseCollection<BaseFiveInsuranceOneGoldsPaymentBase> executeQuery( KeyValuePair[] replacements, ConditionFiveInsuranceOneGoldsPaymentBase condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getYear(), 
				condition.getStartMonth(), 
				condition.getEndMonth()
			);
	}

	@Override
	public BaseFiveInsuranceOneGoldsPaymentBase generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFiveInsuranceOneGoldsPaymentBase __base = new BaseFiveInsuranceOneGoldsPaymentBase();
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
		if((val = __data[count++]) != null) __base.setAccumulationFundGolePaymentBase(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAccumulationFundGoleCompanyPaymentRatio(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAccumulationFundGoleIndividualPaymentRatio(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitPensionPaymentBase(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitPensionPaymentRatio(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalPensionPaymentRatio(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitMedicalInsurancePaymentBase(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitMedicalInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalMedicalInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitUnemploymentInsurancePaymentBase(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitUnemploymentInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPersonalUnemploymentInsurancePaymentRatio(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitInjuryInsuranceBase(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitInjuryInsuranceRatio(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitGiveBirthInsurancePaymentBase(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitGiveBirthInsurancePaymentRatio(GenericBase.__getDecimal(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "SELECT f.five_insurance_one_gold_id, f.employee_no, f.employee_id, f.company_id, f.department_id, f.plate_id, f.YEAR, f.MONTH, f.accumulation_fund_gole_payment_base, f.accumulation_fund_gole_company_payment_ratio, f.accumulation_fund_gole_individual_payment_ratio, f.unit_pension_payment_base, f.unit_pension_payment_ratio, f.personal_pension_payment_ratio, f.unit_medical_insurance_payment_base, f.unit_medical_insurance_payment_ratio, f.personal_medical_insurance_payment_ratio, f.unit_unemployment_insurance_payment_base, f.unit_unemployment_insurance_payment_ratio, f.personal_unemployment_insurance_payment_ratio, f.unit_injury_insurance_base, f.unit_injury_insurance_ratio, f.unit_give_birth_insurance_payment_base, f.unit_give_birth_insurance_payment_ratio FROM five_insurance_one_golds f WHERE f.employee_no LIKE ? AND f.employee_id = ? AND f.company_id = ? AND f.YEAR = ? AND f.MONTH >= ? AND f.MONTH <= ?" ;
	private final static String RESULTSETFIELDLIST = "five_insurance_one_gold_id,employee_no,employee_id,company_id,department_id,plate_id,year,month,accumulation_fund_gole_payment_base,accumulation_fund_gole_company_payment_ratio,accumulation_fund_gole_individual_payment_ratio,unit_pension_payment_base,unit_pension_payment_ratio,personal_pension_payment_ratio,unit_medical_insurance_payment_base,unit_medical_insurance_payment_ratio,personal_medical_insurance_payment_ratio,unit_unemployment_insurance_payment_base,unit_unemployment_insurance_payment_ratio,personal_unemployment_insurance_payment_ratio,unit_injury_insurance_base,unit_injury_insurance_ratio,unit_give_birth_insurance_payment_base,unit_give_birth_insurance_payment_ratio";
	private final static String[] fieldNames = { "employee_no", "employee_id", "company_id", "year", "start_month", "end_month"};
}
