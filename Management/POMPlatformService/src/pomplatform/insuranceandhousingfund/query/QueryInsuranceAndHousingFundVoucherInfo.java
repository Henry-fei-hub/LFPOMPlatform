package pomplatform.insuranceandhousingfund.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.insuranceandhousingfund.bean.BaseInsuranceAndHousingFundVoucherInfo;
import pomplatform.insuranceandhousingfund.bean.ConditionInsuranceAndHousingFundVoucherInfo;

public class QueryInsuranceAndHousingFundVoucherInfo extends AbstractQuery<BaseInsuranceAndHousingFundVoucherInfo, ConditionInsuranceAndHousingFundVoucherInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryInsuranceAndHousingFundVoucherInfo.class);

	public QueryInsuranceAndHousingFundVoucherInfo() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.company_id");
	}

	@Override
	public BaseCollection<BaseInsuranceAndHousingFundVoucherInfo> executeQuery( KeyValuePair[] replacements, ConditionInsuranceAndHousingFundVoucherInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseInsuranceAndHousingFundVoucherInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseInsuranceAndHousingFundVoucherInfo __base = new BaseInsuranceAndHousingFundVoucherInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUnitPension(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitLargeMedicalInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitInjuryInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitUnemploymentInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitGiveBirthInsurance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnitTotalFund(GenericBase.__getDecimal(val));
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
	
	private final static String __SQLText = "SELECT a.company_id, b.plate_voucher_type as department_type, sum(a.unit_pension) as unit_pension, sum(a.unit_medical_insurance) as unit_medical_insurance, sum(unit_large_medical_insurance) as unit_large_medical_insurance, sum(unit_injury_insurance) as unit_injury_insurance, sum(unit_unemployment_insurance) as unit_unemployment_insurance, sum(unit_give_birth_insurance) as unit_give_birth_insurance, sum(unit_total_fund) as unit_total_fund from five_insurance_one_golds a left join plate_records b on a.plate_id = b.plate_id where a.company_id = ? and a.year = ? and a.month = ? group by a.company_id, b.plate_voucher_type order by a.company_id, b.plate_voucher_type" ;
	private final static String RESULTSETFIELDLIST = "company_id, department_type,unit_pension,unit_medical_insurance,unit_large_medical_insurance,unit_injury_insurance,unit_unemployment_insurance,unit_give_birth_insurance,unit_total_fund";
	private final static String[] fieldNames = { "company_id", "year", "month"};
}
