package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseSspecialdeductiondetailor;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductiondetailor;

public class QuerySspecialdeductiondetailor extends AbstractQuery<BaseSspecialdeductiondetailor, ConditionSspecialdeductiondetailor>
{

	private static final Logger __logger = Logger.getLogger(QuerySspecialdeductiondetailor.class);

	public QuerySspecialdeductiondetailor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sdd.special_deduction_detail_id");
	}

	@Override
	public BaseCollection<BaseSspecialdeductiondetailor> executeQuery( KeyValuePair[] replacements, ConditionSspecialdeductiondetailor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getParentId(), 
				condition.getYear(), 
				condition.getSpecialDeductionTypeId()
			);
	}

	@Override
	public BaseSspecialdeductiondetailor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSspecialdeductiondetailor __base = new BaseSspecialdeductiondetailor();
		int count = 0;
		Object val;
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

	private final static String __SQLText = "select sdd.special_deduction_detail_id, sdd.parent_id, sdd.name, sdd.other_document_type, sdd.other_identification_number, sdd.brithdate, sdd.nationality_region, sdd.schooling, sdd.start_date, sdd.end_date, sdd.schooling_termination_date, sdd.schooling_region, sdd.school, sdd.deduction_percentage, sdd.amount, sdd.num, sdd.education_type, sdd.education_stage, sdd.issue_date, sdd.credential, sdd.credential_number, sdd.issuing_authority, sdd.house_address, sdd.house_borrower, sdd.house_type, sdd.house_number, sdd.house_first, sdd.loan_type, sdd.creditor_bank, sdd.creditor_contract_number, sdd.repayment_first_date, sdd.repayment, sdd.house_amount, sdd.province, sdd.city, sdd.lease_type, sdd.lease_address, sdd.lease_contract_number, sdd.single_child, sdd.allocation_way, sdd.allocation_amount, sdd.change_type, sdd.hospitalization_total_cost, sdd.hospitalization_personal_cost, sdd.relationship, sdd.file_id, sdd.file_url, sdd.year, sdd.special_deduction_type_id, sdd.create_date, sdd.alternate_field1, sdd.alternate_field2 from special_deduction_details sdd where sdd.parent_id = ? and sdd.year = ? and sdd.special_deduction_type_id = ? order by year desc" ;
	private final static String RESULTSETFIELDLIST = "special_deduction_detail_id,parent_id,name,other_document_type,other_identification_number,brithdate,nationality_region,schooling,start_date,end_date,schooling_termination_date,schooling_region,school,deduction_percentage,amount,num,education_type,education_stage,issue_date,credential,credential_number,issuing_authority,house_address,house_borrower,house_type,house_number,house_first,loan_type,creditor_bank,creditor_contract_number,repayment_first_date,repayment,house_amount,province,city,lease_type,lease_address,lease_contract_number,single_child,allocation_way,allocation_amount,change_type,hospitalization_total_cost,hospitalization_personal_cost,relationship,file_id,file_url,year,special_deduction_type_id,create_date,alternate_field1,alternate_field2";
	private final static String[] fieldNames = { "parent_id", "year", "special_deduction_type_id"};
}
