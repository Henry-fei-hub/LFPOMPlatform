package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseSspecialdeductionsepor;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductionsepor;

public class QuerySspecialdeductionsepor extends AbstractQuery<BaseSspecialdeductionsepor, ConditionSspecialdeductionsepor>
{

	private static final Logger __logger = Logger.getLogger(QuerySspecialdeductionsepor.class);

	public QuerySspecialdeductionsepor() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sd.special_deduction_id");
	}

	@Override
	public BaseCollection<BaseSspecialdeductionsepor> executeQuery( KeyValuePair[] replacements, ConditionSspecialdeductionsepor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSpecialDeductionId(), 
				condition.getEmployeId(), 
				condition.getPlateId(), 
				condition.getCompanyId(), 
				condition.getDocumentType(), 
				condition.getSpouseDocumentType(), 
				condition.getIsEnable()
			);
	}

	@Override
	public BaseSspecialdeductionsepor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSspecialdeductionsepor __base = new BaseSspecialdeductionsepor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSpecialDeductionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDocumentType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIdentificationNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTaxpayerRegistrationNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWithholdName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWithholdRegistrationNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpouseSituation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpouseName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpouseDocumentType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpouseIdentificationNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[6]));
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

	private final static String __SQLText = "select sd.special_deduction_id, sd.employe_id, sd.plate_id, sd.company_id, sd.document_type, sd.identification_number, sd.phone, sd.taxpayer_registration_number, sd.address, sd.email, sd.withhold_name, sd.withhold_registration_number, sd.spouse_situation, sd.spouse_name, sd.spouse_document_type, sd.spouse_identification_number, sd.create_date, sd.is_enable, sd.remark from special_deductions sd where sd.special_deduction_id = ? and sd.employe_id = ? and sd.plate_id = ? and sd.company_id = ? and sd.document_type = ? and sd.spouse_document_type = ? and sd.is_enable = ?" ;
	private final static String RESULTSETFIELDLIST = "special_deduction_id,employe_id,plate_id,company_id,document_type,identification_number,phone,taxpayer_registration_number,address,email,withhold_name,withhold_registration_number,spouse_situation,spouse_name,spouse_document_type,spouse_identification_number,create_date,is_enable,remark";
	private final static String[] fieldNames = { "special_deduction_id", "employe_id", "plate_id", "company_id", "document_type", "spouse_document_type", "is_enable"};
}
