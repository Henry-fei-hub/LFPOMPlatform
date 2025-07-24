package pomplatform.employeeInformationDetails.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericBase;

import delicacy.connection.ThreadConnection;
import pomplatform.employeeInformationDetails.bean.BaseMemployeeeeedor;
import pomplatform.employeeInformationDetails.bean.ConditionMemployeeeeedor;


public class QueryMemployeeeeedor extends AbstractQuery<BaseMemployeeeeedor, ConditionMemployeeeeedor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeeeeedor.class);

	public QueryMemployeeeeedor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT e.employee_id");
	}

	@Override
	public BaseCollection<BaseMemployeeeeedor> executeQuery(KeyValuePair[] replacements, ConditionMemployeeeeedor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseMemployeeeeedor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeeeeedor __base = new BaseMemployeeeeedor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameEn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCountry(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBirthplace(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccountLocation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHouseholdRegistration(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNationality(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMarriedStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPoliticalFace(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEducationProof(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDegreeProof(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartWorkDate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPositiveDate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPersonalBusinessRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractStartDate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractEndDate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOwnedCompany(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSocialComputerNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFundAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankCardNum(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkYearType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmergencyContactPerson(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmergencyContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCardAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGraduatedSchool(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialty(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLearningWay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCardAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEducationProofId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDegreeProofId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLaborAttachments(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "SELECT DISTINCT e.employee_id, e.employee_no, e.employee_name, CASE WHEN e.department_id is null THEN 0 ELSE e.department_id END AS department_id, CASE WHEN e.employee_name_en is null THEN '×' ELSE '√' END AS employee_name_en, CASE WHEN e.file_number is null THEN '×' ELSE '√' END AS file_number, CASE WHEN e.card is null THEN '×' ELSE '√' END AS card, CASE e.gender WHEN '1' THEN '男' ELSE '女' END as gender, CASE WHEN e.mobile is null THEN '×' ELSE '√' END AS mobile, CASE e.country WHEN 'NULL' THEN '×' ELSE '√' END AS country, CASE WHEN e.birthplace is null THEN '×' ELSE '√' END AS birthplace, CASE WHEN e.account_location is null THEN '×' ELSE '√' END AS account_location, CASE WHEN e.household_registration is null THEN '×' ELSE '√' END AS household_registration, CASE WHEN e.nationality is null THEN '×' ELSE '√' END AS nationality, CASE WHEN e.married_status is null THEN '×' ELSE '√' END AS married_status, CASE WHEN e.political_face is null THEN '×' ELSE '√' END AS political_face, CASE WHEN e.education_proof is null THEN '×' ELSE '√' END AS education_proof, CASE WHEN e.degree_proof is null THEN '×' ELSE '√' END AS degree_proof, CASE WHEN e.start_work_date is null THEN '×' ELSE '√' END AS start_work_date, CASE WHEN e.onboard_date is null THEN '×' ELSE '√' END AS onboard_date, CASE WHEN e.positive_date is null THEN '×' ELSE '√' END AS positive_date, CASE WHEN e.personal_business_remark is null THEN '×' ELSE '√' END AS personal_business_remark, CASE WHEN e.contract_start_date is null THEN '×' ELSE '√' END AS contract_start_date, CASE WHEN e.contract_end_date is null THEN '×' ELSE '√' END AS contract_end_date, CASE WHEN e.owned_company is null THEN '×' ELSE '√' END AS owned_company, CASE WHEN e.duty_id is null THEN '×' ELSE '√' END AS duty_id, CASE WHEN e.social_computer_number is null THEN '×' ELSE '√' END AS social_computer_number, CASE WHEN e.fund_account is null THEN '×' ELSE '√' END AS fund_account, CASE WHEN e.bank_card_num is null THEN '×' ELSE '√' END AS bank_card_num, CASE WHEN e.work_year_type is null THEN '×' ELSE '√' END AS work_year_type, CASE WHEN e.emergency_contact_person is null THEN '×' ELSE '√' END AS emergency_contact_person, CASE WHEN e.emergency_contact_phone is null THEN '×' ELSE '√' END AS emergency_contact_phone, CASE WHEN e.card_address is null THEN '×' ELSE '√' END AS card_address, CASE WHEN ed.graduated_school is null THEN '×' ELSE '√' END AS graduated_school, CASE WHEN ed.specialty is null THEN '×' ELSE '√' END AS specialty, CASE WHEN ed.learning_way is null THEN '×' ELSE '√' END AS learning_way, CASE WHEN e.card_attachment is null THEN '×' ELSE '√' END AS card_attachment, CASE WHEN e.education_proof_id is null THEN '×' ELSE '√' END AS education_proof_id, CASE WHEN e.degree_proof_id is null THEN '×' ELSE '√' END AS degree_proof_id, CASE WHEN e.labor_attachments is null THEN '×' ELSE '√' END AS labor_attachments FROM employees e LEFT JOIN employee_education_informations ed ON ed.employee_id = e.employee_id where e.employee_name LIKE ? AND e.employee_no =? AND e.department_id =? and e.status =0 and  e.employee_no !='admin' ORDER BY e.employee_id ASC" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,employee_name_en,file_number,card,gender,mobile,country,birthplace,account_location,household_registration,nationality,married_status,political_face,education_proof,degree_proof,start_work_date,onboard_date,positive_date,personal_business_remark,contract_start_date,contract_end_date,owned_company,duty_id,social_computer_number,fund_account,bank_card_num,work_year_type,emergency_contact_person,emergency_contact_phone,card_address,graduated_school,specialty,learning_way,card_attachment,education_proof_id,degree_proof_id,labor_attachments";
	private final static String[] fieldNames = { "employee_name", "employee_no", "department_id"};
}
