package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseFiveinsuranceSummaryPlate;
import pomplatform.payment.bean.ConditionFiveinsuranceSummaryPlate;

public class QueryFiveinsuranceSummaryPlate extends AbstractQuery<BaseFiveinsuranceSummaryPlate, ConditionFiveinsuranceSummaryPlate>
{

	private static final Logger __logger = Logger.getLogger(QueryFiveinsuranceSummaryPlate.class);

	public QueryFiveinsuranceSummaryPlate() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("fiog.plate_id");
	}

	@Override
	public BaseCollection<BaseFiveinsuranceSummaryPlate> executeQuery( KeyValuePair[] replacements, ConditionFiveinsuranceSummaryPlate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getStartMonth(), 
				condition.getEndMonth(), 
				condition.getYear(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseFiveinsuranceSummaryPlate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseFiveinsuranceSummaryPlate __base = new BaseFiveinsuranceSummaryPlate();
		int count = 0;
		Object val;
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

	private final static String __SQLText = "select fiog.plate_id, fiog.year, fiog.month, sum(fiog.total_fund) as total_fund, sum(fiog.unit_total_fund) as unit_total_fund, sum(fiog.personal_total_fund) as personal_total_fund, sum(fiog.total_insurance) as total_insurance, sum(fiog.unit_total_insurance) as unit_total_insurance, sum(fiog.personal_total_insurance) as personal_total_insurance, sum(fiog.unit_pension) as unit_pension, sum(fiog.unit_medical_insurance) as unit_medical_insurance, sum(fiog.unit_large_medical_insurance) as unit_large_medical_insurance, sum(fiog.unit_injury_insurance) as unit_injury_insurance, sum(fiog.unit_unemployment_insurance) as unit_unemployment_insurance, sum(fiog.unit_give_birth_insurance) as unit_give_birth_insurance, sum(fiog.personal_pension) as personal_pension, sum(fiog.personal_medical_insurance) as personal_medical_insurance, sum(fiog.personal_large_medical_insurance) as personal_large_medical_insurance, sum(fiog.personal_serious_ill_insurance) as personal_serious_ill_insurance, sum(fiog.personal_unemployment_insurance) as personal_unemployment_insurance, sum(fiog.personal_heating) as personal_heating from five_insurance_one_golds fiog WHERE fiog.company_id = ? and fiog.month between ? and ? and fiog.year = ? and fiog.plate_id = ? GROUP BY fiog.plate_id,fiog.year,fiog.month ORDER BY fiog.plate_id,fiog.year,fiog.month" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,month,total_fund,unit_total_fund,personal_total_fund,total_insurance,unit_total_insurance,personal_total_insurance,unit_pension,unit_medical_insurance,unit_large_medical_insurance,unit_injury_insurance,unit_unemployment_insurance,unit_give_birth_insurance,personal_pension,personal_medical_insurance,personal_large_medical_insurance,personal_serious_ill_insurance,personal_unemployment_insurance,personal_heating";
	private final static String[] fieldNames = { "company_id", "start_month", "end_month", "year", "plate_id"};
}
