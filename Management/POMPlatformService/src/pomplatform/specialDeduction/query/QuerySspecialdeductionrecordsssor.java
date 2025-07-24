package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseSspecialdeductionrecordsssor;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductionrecordsssor;

public class QuerySspecialdeductionrecordsssor extends AbstractQuery<BaseSspecialdeductionrecordsssor, ConditionSspecialdeductionrecordsssor>
{

	private static final Logger __logger = Logger.getLogger(QuerySspecialdeductionrecordsssor.class);

	public QuerySspecialdeductionrecordsssor() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sdr.special_deduction_record_id");
	}

	@Override
	public BaseCollection<BaseSspecialdeductionrecordsssor> executeQuery( KeyValuePair[] replacements, ConditionSspecialdeductionrecordsssor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeId(), 
				condition.getDeparmentId(), 
				condition.getPlateId(), 
				condition.getCompanyId(), 
				condition.getIsEnable()
			);
	}

	@Override
	public BaseSspecialdeductionrecordsssor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSspecialdeductionrecordsssor __base = new BaseSspecialdeductionrecordsssor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSpecialDeductionRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeparmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDocumentType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIdentificationNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTaxpayerRegistrationNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWithholdId(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[4]));
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

	private final static String __SQLText = "select sdr.special_deduction_record_id, sdr.employe_id, sdr.employee_name, sdr.start_date, sdr.end_date, sdr.process_type, sdr.deparment_id, sdr.plate_id, sdr.company_id, sdr.document_type, sdr.identification_number, sdr.phone, sdr.taxpayer_registration_number, sdr.address, sdr.email, sdr.withhold_id, sdr.withhold_name, sdr.withhold_registration_number, sdr.spouse_situation, sdr.spouse_name, sdr.spouse_document_type, sdr.spouse_identification_number, sdr.create_date, sdr.is_enable, sdr.remark from special_deduction_records sdr where sdr.employe_id = ? and sdr.deparment_id = ? and sdr.plate_id = ? and sdr.company_id = ? and sdr.is_enable = ?" ;
	private final static String RESULTSETFIELDLIST = "special_deduction_record_id,employe_id,employee_name,start_date,end_date,process_type,deparment_id,plate_id,company_id,document_type,identification_number,phone,taxpayer_registration_number,address,email,withhold_id,withhold_name,withhold_registration_number,spouse_situation,spouse_name,spouse_document_type,spouse_identification_number,create_date,is_enable,remark";
	private final static String[] fieldNames = { "employe_id", "deparment_id", "plate_id", "company_id", "is_enable"};
}
