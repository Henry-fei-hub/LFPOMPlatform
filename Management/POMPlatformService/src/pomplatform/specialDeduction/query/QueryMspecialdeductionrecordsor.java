package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseMspecialdeductionrecordsor;
import pomplatform.specialDeduction.bean.ConditionMspecialdeductionrecordsor;

public class QueryMspecialdeductionrecordsor extends AbstractQuery<BaseMspecialdeductionrecordsor, ConditionMspecialdeductionrecordsor>
{

	private static final Logger __logger = Logger.getLogger(QueryMspecialdeductionrecordsor.class);

	public QueryMspecialdeductionrecordsor() throws java.sql.SQLException 
	{
		setParameterNumber(17);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sdr.special_deduction_record_id");
	}

	@Override
	public BaseCollection<BaseMspecialdeductionrecordsor> executeQuery( KeyValuePair[] replacements, ConditionMspecialdeductionrecordsor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getEmployeId(), 
				condition.getDocumentType(), 
				condition.getSpouseSituation(), 
				condition.getName(), 
				condition.getSpecialDeductionTypeId(), 
				condition.getEducationType(), 
				condition.getEducationStage(), 
				condition.getHouseBorrower(), 
				condition.getHouseType(), 
				condition.getHouseFirst(), 
				condition.getLoanType(), 
				condition.getSingleChild(), 
				condition.getChangeType(), 
				condition.getProcessStatus(), 
				condition.getPlateId(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseMspecialdeductionrecordsor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMspecialdeductionrecordsor __base = new BaseMspecialdeductionrecordsor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSpecialDeductionRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeparmentId(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFid(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFurl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherDocumentType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOtherIdentificationNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBrithdate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setNationalityRegion(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSchooling(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSchoolingTerminationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSchoolingRegion(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSchool(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeductionPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEducationType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEducationStage(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIssueDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCredential(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCredentialNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIssuingAuthority(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHouseAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHouseBorrower(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHouseType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHouseNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHouseFirst(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLoanType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreditorBank(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreditorContractNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRepaymentFirstDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRepayment(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHouseAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeaseType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLeaseAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeaseContractNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSingleChild(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAllocationWay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAllocationAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setChangeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHospitalizationTotalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHospitalizationPersonalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRelationship(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
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

	private final static String __SQLText = "select sdr.special_deduction_record_id, sdr.employe_id, sdr.deparment_id, sdr.plate_id, sdr.company_id, sdr.document_type, sdr.identification_number, sdr.phone, sdr.taxpayer_registration_number, sdr.address, sdr.email, sdr.withhold_name, sdr.withhold_registration_number, sdr.spouse_situation, sdr.spouse_name, sdr.spouse_document_type, sdr.spouse_identification_number, sdr.is_enable, sdr.remark, sdr.file_id as fid, sdr.file_url as furl, sdd.special_deduction_detail_id, sdd.parent_id, sdd.NAME, sdd.other_document_type, sdd.other_identification_number, sdd.brithdate, sdd.nationality_region, sdd.schooling, sdd.start_date, sdd.end_date, sdd.schooling_termination_date, sdd.schooling_region, sdd.school, sdd.deduction_percentage, sdd.amount, sdd.num, sdd.education_type, sdd.education_stage, sdd.issue_date, sdd.credential, sdd.credential_number, sdd.issuing_authority, sdd.house_address, sdd.house_borrower, sdd.house_type, sdd.house_number, sdd.house_first, sdd.loan_type, sdd.creditor_bank, sdd.creditor_contract_number, sdd.repayment_first_date, sdd.repayment, sdd.house_amount, sdd.province, sdd.city, sdd.lease_type, sdd.lease_address, sdd.lease_contract_number, sdd.single_child, sdd.allocation_way, sdd.allocation_amount, sdd.change_type, sdd.hospitalization_total_cost, sdd.hospitalization_personal_cost, sdd.relationship, sdd.file_id, sdd.file_url, sdd.YEAR, sdd.special_deduction_type_id, sdd.create_date, sdd.alternate_field1, sdd.alternate_field2, spi.process_status,spi.process_instance_id from special_deduction_records sdr left join special_deduction_details sdd on sdr.special_deduction_record_id = sdd.parent_id left join system_process_instances spi on spi.business_id = sdr.special_deduction_record_id where spi.process_type =58 and sdr.employee_name=? and sdr.employe_id=? and sdr.document_type=? and sdr.spouse_situation =? and sdd.name like ? and sdd.special_deduction_type_id =? and sdd.education_type =? and sdd.education_stage =? and sdd.house_borrower =? and sdd.house_type =? and sdd.house_first =? and sdd.loan_type =? and sdd.single_child =? and sdd.change_type =? and spi.process_status =? and sdr.plate_id =? and sdr.company_id=?" ;
	private final static String RESULTSETFIELDLIST = "special_deduction_record_id,employe_id,deparment_id,plate_id,company_id,document_type,identification_number,phone,taxpayer_registration_number,address,email,withhold_name,withhold_registration_number,spouse_situation,spouse_name,spouse_document_type,spouse_identification_number,is_enable,remark,fid,furl,special_deduction_detail_id,parent_id,name,other_document_type,other_identification_number,brithdate,nationality_region,schooling,start_date,end_date,schooling_termination_date,schooling_region,school,deduction_percentage,amount,num,education_type,education_stage,issue_date,credential,credential_number,issuing_authority,house_address,house_borrower,house_type,house_number,house_first,loan_type,creditor_bank,creditor_contract_number,repayment_first_date,repayment,house_amount,province,city,lease_type,lease_address,lease_contract_number,single_child,allocation_way,allocation_amount,change_type,hospitalization_total_cost,hospitalization_personal_cost,relationship,file_id,file_url,year,special_deduction_type_id,create_date,alternate_field1,alternate_field2,process_status,process_instance_id";
	private final static String[] fieldNames = { "year", "employe_id", "document_type", "spouse_situation", "name", "special_deduction_type_id", "education_type", "education_stage", "house_borrower", "house_type", "house_first", "loan_type", "single_child", "change_type", "process_status", "plate_id", "company_id"};
}
