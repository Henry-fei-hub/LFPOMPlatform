package pomplatform.employeeInformationDetails.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeeeeedor extends GenericBase implements BaseFactory<BaseMemployeeeeedor>, Comparable<BaseMemployeeeeedor> 
{


	public static BaseMemployeeeeedor newInstance(){
		return new BaseMemployeeeeedor();
	}

	@Override
	public BaseMemployeeeeedor make(){
		BaseMemployeeeeedor b = new BaseMemployeeeeedor();
		return b;
	}

	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_EMPLOYEE_NO = "employee_no" ;
	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_EMPLOYEE_NAME_EN = "employee_name_en" ;
	public final static String CS_FILE_NUMBER = "file_number" ;
	public final static String CS_CARD = "card" ;
	public final static String CS_GENDER = "gender" ;
	public final static String CS_MOBILE = "mobile" ;
	public final static String CS_COUNTRY = "country" ;
	public final static String CS_BIRTHPLACE = "birthplace" ;
	public final static String CS_ACCOUNT_LOCATION = "account_location" ;
	public final static String CS_HOUSEHOLD_REGISTRATION = "household_registration" ;
	public final static String CS_NATIONALITY = "nationality" ;
	public final static String CS_MARRIED_STATUS = "married_status" ;
	public final static String CS_POLITICAL_FACE = "political_face" ;
	public final static String CS_EDUCATION_PROOF = "education_proof" ;
	public final static String CS_DEGREE_PROOF = "degree_proof" ;
	public final static String CS_START_WORK_DATE = "start_work_date" ;
	public final static String CS_ONBOARD_DATE = "onboard_date" ;
	public final static String CS_POSITIVE_DATE = "positive_date" ;
	public final static String CS_PERSONAL_BUSINESS_REMARK = "personal_business_remark" ;
	public final static String CS_CONTRACT_START_DATE = "contract_start_date" ;
	public final static String CS_CONTRACT_END_DATE = "contract_end_date" ;
	public final static String CS_OWNED_COMPANY = "owned_company" ;
	public final static String CS_DUTY_ID = "duty_id" ;
	public final static String CS_SOCIAL_COMPUTER_NUMBER = "social_computer_number" ;
	public final static String CS_FUND_ACCOUNT = "fund_account" ;
	public final static String CS_BANK_CARD_NUM = "bank_card_num" ;
	public final static String CS_WORK_YEAR_TYPE = "work_year_type" ;
	public final static String CS_EMERGENCY_CONTACT_PERSON = "emergency_contact_person" ;
	public final static String CS_EMERGENCY_CONTACT_PHONE = "emergency_contact_phone" ;
	public final static String CS_CARD_ADDRESS = "card_address" ;
	public final static String CS_GRADUATED_SCHOOL = "graduated_school" ;
	public final static String CS_SPECIALTY = "specialty" ;
	public final static String CS_LEARNING_WAY = "learning_way" ;
	public final static String CS_CARD_ATTACHMENT = "card_attachment" ;
	public final static String CS_EDUCATION_PROOF_ID = "education_proof_id" ;
	public final static String CS_DEGREE_PROOF_ID = "degree_proof_id" ;
	public final static String CS_LABOR_ATTACHMENTS = "labor_attachments" ;

	public final static String ALL_CAPTIONS = "员工编码,员工编号,员工姓名,部门,英文名,档案号,身份证号,性别,手机,国籍,籍贯,户口所在地,户籍,名族,婚姻状况,政治面貌,学历证,学位证,参加工作时间,入职日期,转正日期,人事备注,劳动合同开始时间,劳动合同到期时间,所属公司,职位名称,社保电脑号,公积金账号,银行卡号,工龄工资状态(对应字典表115),紧急联系人,紧急联系人电话,身份证地址,毕业院校,所学专业,学习形式,身份证附件,学历证附件,学位证附件,劳动合同附件";

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( String value ) {
		this.__employee_no = value;
	}

	public String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( Integer value ) {
		this.__department_id = value;
	}

	public String getEmployeeNameEn() {
		return this.__employee_name_en;
	}

	public void setEmployeeNameEn( String value ) {
		this.__employee_name_en = value;
	}

	public String getFileNumber() {
		return this.__file_number;
	}

	public void setFileNumber( String value ) {
		this.__file_number = value;
	}

	public String getCard() {
		return this.__card;
	}

	public void setCard( String value ) {
		this.__card = value;
	}

	public String getGender() {
		return this.__gender;
	}

	public void setGender( String value ) {
		this.__gender = value;
	}

	public String getMobile() {
		return this.__mobile;
	}

	public void setMobile( String value ) {
		this.__mobile = value;
	}

	public String getCountry() {
		return this.__country;
	}

	public void setCountry( String value ) {
		this.__country = value;
	}

	public String getBirthplace() {
		return this.__birthplace;
	}

	public void setBirthplace( String value ) {
		this.__birthplace = value;
	}

	public String getAccountLocation() {
		return this.__account_location;
	}

	public void setAccountLocation( String value ) {
		this.__account_location = value;
	}

	public String getHouseholdRegistration() {
		return this.__household_registration;
	}

	public void setHouseholdRegistration( String value ) {
		this.__household_registration = value;
	}

	public String getNationality() {
		return this.__nationality;
	}

	public void setNationality( String value ) {
		this.__nationality = value;
	}

	public String getMarriedStatus() {
		return this.__married_status;
	}

	public void setMarriedStatus( String value ) {
		this.__married_status = value;
	}

	public String getPoliticalFace() {
		return this.__political_face;
	}

	public void setPoliticalFace( String value ) {
		this.__political_face = value;
	}

	public String getEducationProof() {
		return this.__education_proof;
	}

	public void setEducationProof( String value ) {
		this.__education_proof = value;
	}

	public String getDegreeProof() {
		return this.__degree_proof;
	}

	public void setDegreeProof( String value ) {
		this.__degree_proof = value;
	}

	public String getStartWorkDate() {
		return this.__start_work_date;
	}

	public void setStartWorkDate( String value ) {
		this.__start_work_date = value;
	}

	public String getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( String value ) {
		this.__onboard_date = value;
	}

	public String getPositiveDate() {
		return this.__positive_date;
	}

	public void setPositiveDate( String value ) {
		this.__positive_date = value;
	}

	public String getPersonalBusinessRemark() {
		return this.__personal_business_remark;
	}

	public void setPersonalBusinessRemark( String value ) {
		this.__personal_business_remark = value;
	}

	public String getContractStartDate() {
		return this.__contract_start_date;
	}

	public void setContractStartDate( String value ) {
		this.__contract_start_date = value;
	}

	public String getContractEndDate() {
		return this.__contract_end_date;
	}

	public void setContractEndDate( String value ) {
		this.__contract_end_date = value;
	}

	public String getOwnedCompany() {
		return this.__owned_company;
	}

	public void setOwnedCompany( String value ) {
		this.__owned_company = value;
	}

	public String getDutyId() {
		return this.__duty_id;
	}

	public void setDutyId( String value ) {
		this.__duty_id = value;
	}

	public String getSocialComputerNumber() {
		return this.__social_computer_number;
	}

	public void setSocialComputerNumber( String value ) {
		this.__social_computer_number = value;
	}

	public String getFundAccount() {
		return this.__fund_account;
	}

	public void setFundAccount( String value ) {
		this.__fund_account = value;
	}

	public String getBankCardNum() {
		return this.__bank_card_num;
	}

	public void setBankCardNum( String value ) {
		this.__bank_card_num = value;
	}

	public String getWorkYearType() {
		return this.__work_year_type;
	}

	public void setWorkYearType( String value ) {
		this.__work_year_type = value;
	}

	public String getEmergencyContactPerson() {
		return this.__emergency_contact_person;
	}

	public void setEmergencyContactPerson( String value ) {
		this.__emergency_contact_person = value;
	}

	public String getEmergencyContactPhone() {
		return this.__emergency_contact_phone;
	}

	public void setEmergencyContactPhone( String value ) {
		this.__emergency_contact_phone = value;
	}

	public String getCardAddress() {
		return this.__card_address;
	}

	public void setCardAddress( String value ) {
		this.__card_address = value;
	}

	public String getGraduatedSchool() {
		return this.__graduated_school;
	}

	public void setGraduatedSchool( String value ) {
		this.__graduated_school = value;
	}

	public String getSpecialty() {
		return this.__specialty;
	}

	public void setSpecialty( String value ) {
		this.__specialty = value;
	}

	public String getLearningWay() {
		return this.__learning_way;
	}

	public void setLearningWay( String value ) {
		this.__learning_way = value;
	}

	public String getCardAttachment() {
		return this.__card_attachment;
	}

	public void setCardAttachment( String value ) {
		this.__card_attachment = value;
	}

	public String getEducationProofId() {
		return this.__education_proof_id;
	}

	public void setEducationProofId( String value ) {
		this.__education_proof_id = value;
	}

	public String getDegreeProofId() {
		return this.__degree_proof_id;
	}

	public void setDegreeProofId( String value ) {
		this.__degree_proof_id = value;
	}

	public String getLaborAttachments() {
		return this.__labor_attachments;
	}

	public void setLaborAttachments( String value ) {
		this.__labor_attachments = value;
	}

	public void cloneCopy(BaseMemployeeeeedor __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setEmployeeNameEn(getEmployeeNameEn());
		__bean.setFileNumber(getFileNumber());
		__bean.setCard(getCard());
		__bean.setGender(getGender());
		__bean.setMobile(getMobile());
		__bean.setCountry(getCountry());
		__bean.setBirthplace(getBirthplace());
		__bean.setAccountLocation(getAccountLocation());
		__bean.setHouseholdRegistration(getHouseholdRegistration());
		__bean.setNationality(getNationality());
		__bean.setMarriedStatus(getMarriedStatus());
		__bean.setPoliticalFace(getPoliticalFace());
		__bean.setEducationProof(getEducationProof());
		__bean.setDegreeProof(getDegreeProof());
		__bean.setStartWorkDate(getStartWorkDate());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setPositiveDate(getPositiveDate());
		__bean.setPersonalBusinessRemark(getPersonalBusinessRemark());
		__bean.setContractStartDate(getContractStartDate());
		__bean.setContractEndDate(getContractEndDate());
		__bean.setOwnedCompany(getOwnedCompany());
		__bean.setDutyId(getDutyId());
		__bean.setSocialComputerNumber(getSocialComputerNumber());
		__bean.setFundAccount(getFundAccount());
		__bean.setBankCardNum(getBankCardNum());
		__bean.setWorkYearType(getWorkYearType());
		__bean.setEmergencyContactPerson(getEmergencyContactPerson());
		__bean.setEmergencyContactPhone(getEmergencyContactPhone());
		__bean.setCardAddress(getCardAddress());
		__bean.setGraduatedSchool(getGraduatedSchool());
		__bean.setSpecialty(getSpecialty());
		__bean.setLearningWay(getLearningWay());
		__bean.setCardAttachment(getCardAttachment());
		__bean.setEducationProofId(getEducationProofId());
		__bean.setDegreeProofId(getDegreeProofId());
		__bean.setLaborAttachments(getLaborAttachments());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getGender() == null ? "" : getGender());
		sb.append(",");
		sb.append(getEmployeeNameEn() == null ? "" : getEmployeeNameEn());
		sb.append(",");
		sb.append(getFileNumber() == null ? "" : getFileNumber());
		sb.append(",");
		sb.append(getCard() == null ? "" : getCard());
		sb.append(",");
		sb.append(getMobile() == null ? "" : getMobile());
		sb.append(",");
		sb.append(getCountry() == null ? "" : getCountry());
		sb.append(",");
		sb.append(getBirthplace() == null ? "" : getBirthplace());
		sb.append(",");
		sb.append(getAccountLocation() == null ? "" : getAccountLocation());
		sb.append(",");
		sb.append(getHouseholdRegistration() == null ? "" : getHouseholdRegistration());
		sb.append(",");
		sb.append(getNationality() == null ? "" : getNationality());
		sb.append(",");
		sb.append(getMarriedStatus() == null ? "" : getMarriedStatus());
		sb.append(",");
		sb.append(getPoliticalFace() == null ? "" : getPoliticalFace());
		sb.append(",");
		sb.append(getEducationProof() == null ? "" : getEducationProof());
		sb.append(",");
		sb.append(getDegreeProof() == null ? "" : getDegreeProof());
		sb.append(",");
		sb.append(getStartWorkDate() == null ? "" : getStartWorkDate());
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : getOnboardDate());
		sb.append(",");
		sb.append(getPositiveDate() == null ? "" : getPositiveDate());
		sb.append(",");
		sb.append(getPersonalBusinessRemark() == null ? "" : getPersonalBusinessRemark());
		sb.append(",");
		sb.append(getContractStartDate() == null ? "" : getContractStartDate());
		sb.append(",");
		sb.append(getContractEndDate() == null ? "" : getContractEndDate());
		sb.append(",");
		sb.append(getOwnedCompany() == null ? "" : getOwnedCompany());
		sb.append(",");
		sb.append(getDutyId() == null ? "" : getDutyId());
		sb.append(",");
		sb.append(getSocialComputerNumber() == null ? "" : getSocialComputerNumber());
		sb.append(",");
		sb.append(getFundAccount() == null ? "" : getFundAccount());
		sb.append(",");
		sb.append(getBankCardNum() == null ? "" : getBankCardNum());
		sb.append(",");
		sb.append(getWorkYearType() == null ? "" : getWorkYearType());
		sb.append(",");
		sb.append(getEmergencyContactPerson() == null ? "" : getEmergencyContactPerson());
		sb.append(",");
		sb.append(getEmergencyContactPhone() == null ? "" : getEmergencyContactPhone());
		sb.append(",");
		sb.append(getCardAddress() == null ? "" : getCardAddress());
		sb.append(",");
		sb.append(getGraduatedSchool() == null ? "" : getGraduatedSchool());
		sb.append(",");
		sb.append(getSpecialty() == null ? "" : getSpecialty());
		sb.append(",");
		sb.append(getLearningWay() == null ? "" : getLearningWay());
		sb.append(",");
		sb.append(getCardAttachment() == null ? "" : getCardAttachment());
		sb.append(",");
		sb.append(getEducationProofId() == null ? "" : getEducationProofId());
		sb.append(",");
		sb.append(getDegreeProofId() == null ? "" : getDegreeProofId());
		sb.append(",");
		sb.append(getLaborAttachments() == null ? "" : getLaborAttachments());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeeeeedor o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name_en);
		hash = 97 * hash + Objects.hashCode(this.__file_number);
		hash = 97 * hash + Objects.hashCode(this.__card);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		hash = 97 * hash + Objects.hashCode(this.__mobile);
		hash = 97 * hash + Objects.hashCode(this.__country);
		hash = 97 * hash + Objects.hashCode(this.__birthplace);
		hash = 97 * hash + Objects.hashCode(this.__account_location);
		hash = 97 * hash + Objects.hashCode(this.__household_registration);
		hash = 97 * hash + Objects.hashCode(this.__nationality);
		hash = 97 * hash + Objects.hashCode(this.__married_status);
		hash = 97 * hash + Objects.hashCode(this.__political_face);
		hash = 97 * hash + Objects.hashCode(this.__education_proof);
		hash = 97 * hash + Objects.hashCode(this.__degree_proof);
		hash = 97 * hash + Objects.hashCode(this.__start_work_date);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__positive_date);
		hash = 97 * hash + Objects.hashCode(this.__personal_business_remark);
		hash = 97 * hash + Objects.hashCode(this.__contract_start_date);
		hash = 97 * hash + Objects.hashCode(this.__contract_end_date);
		hash = 97 * hash + Objects.hashCode(this.__owned_company);
		hash = 97 * hash + Objects.hashCode(this.__duty_id);
		hash = 97 * hash + Objects.hashCode(this.__social_computer_number);
		hash = 97 * hash + Objects.hashCode(this.__fund_account);
		hash = 97 * hash + Objects.hashCode(this.__bank_card_num);
		hash = 97 * hash + Objects.hashCode(this.__work_year_type);
		hash = 97 * hash + Objects.hashCode(this.__emergency_contact_person);
		hash = 97 * hash + Objects.hashCode(this.__emergency_contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__card_address);
		hash = 97 * hash + Objects.hashCode(this.__graduated_school);
		hash = 97 * hash + Objects.hashCode(this.__specialty);
		hash = 97 * hash + Objects.hashCode(this.__learning_way);
		hash = 97 * hash + Objects.hashCode(this.__card_attachment);
		hash = 97 * hash + Objects.hashCode(this.__education_proof_id);
		hash = 97 * hash + Objects.hashCode(this.__degree_proof_id);
		hash = 97 * hash + Objects.hashCode(this.__labor_attachments);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeeeeedor o = (BaseMemployeeeeedor)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__employee_name_en, o.getEmployeeNameEn())) return false;
		if(!Objects.equals(this.__file_number, o.getFileNumber())) return false;
		if(!Objects.equals(this.__card, o.getCard())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		if(!Objects.equals(this.__mobile, o.getMobile())) return false;
		if(!Objects.equals(this.__country, o.getCountry())) return false;
		if(!Objects.equals(this.__birthplace, o.getBirthplace())) return false;
		if(!Objects.equals(this.__account_location, o.getAccountLocation())) return false;
		if(!Objects.equals(this.__household_registration, o.getHouseholdRegistration())) return false;
		if(!Objects.equals(this.__nationality, o.getNationality())) return false;
		if(!Objects.equals(this.__married_status, o.getMarriedStatus())) return false;
		if(!Objects.equals(this.__political_face, o.getPoliticalFace())) return false;
		if(!Objects.equals(this.__education_proof, o.getEducationProof())) return false;
		if(!Objects.equals(this.__degree_proof, o.getDegreeProof())) return false;
		if(!Objects.equals(this.__start_work_date, o.getStartWorkDate())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__positive_date, o.getPositiveDate())) return false;
		if(!Objects.equals(this.__personal_business_remark, o.getPersonalBusinessRemark())) return false;
		if(!Objects.equals(this.__contract_start_date, o.getContractStartDate())) return false;
		if(!Objects.equals(this.__contract_end_date, o.getContractEndDate())) return false;
		if(!Objects.equals(this.__owned_company, o.getOwnedCompany())) return false;
		if(!Objects.equals(this.__duty_id, o.getDutyId())) return false;
		if(!Objects.equals(this.__social_computer_number, o.getSocialComputerNumber())) return false;
		if(!Objects.equals(this.__fund_account, o.getFundAccount())) return false;
		if(!Objects.equals(this.__bank_card_num, o.getBankCardNum())) return false;
		if(!Objects.equals(this.__work_year_type, o.getWorkYearType())) return false;
		if(!Objects.equals(this.__emergency_contact_person, o.getEmergencyContactPerson())) return false;
		if(!Objects.equals(this.__emergency_contact_phone, o.getEmergencyContactPhone())) return false;
		if(!Objects.equals(this.__card_address, o.getCardAddress())) return false;
		if(!Objects.equals(this.__graduated_school, o.getGraduatedSchool())) return false;
		if(!Objects.equals(this.__specialty, o.getSpecialty())) return false;
		if(!Objects.equals(this.__learning_way, o.getLearningWay())) return false;
		if(!Objects.equals(this.__card_attachment, o.getCardAttachment())) return false;
		if(!Objects.equals(this.__education_proof_id, o.getEducationProofId())) return false;
		if(!Objects.equals(this.__degree_proof_id, o.getDegreeProofId())) return false;
		if(!Objects.equals(this.__labor_attachments, o.getLaborAttachments())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getEmployeeNameEn() != null) sb.append(__wrapString(count++, "employeeNameEn", getEmployeeNameEn()));
		if(getFileNumber() != null) sb.append(__wrapString(count++, "fileNumber", getFileNumber()));
		if(getCard() != null) sb.append(__wrapString(count++, "card", getCard()));
		if(getGender() != null) sb.append(__wrapString(count++, "gender", getGender()));
		if(getMobile() != null) sb.append(__wrapString(count++, "mobile", getMobile()));
		if(getCountry() != null) sb.append(__wrapString(count++, "country", getCountry()));
		if(getBirthplace() != null) sb.append(__wrapString(count++, "birthplace", getBirthplace()));
		if(getAccountLocation() != null) sb.append(__wrapString(count++, "accountLocation", getAccountLocation()));
		if(getHouseholdRegistration() != null) sb.append(__wrapString(count++, "householdRegistration", getHouseholdRegistration()));
		if(getNationality() != null) sb.append(__wrapString(count++, "nationality", getNationality()));
		if(getMarriedStatus() != null) sb.append(__wrapString(count++, "marriedStatus", getMarriedStatus()));
		if(getPoliticalFace() != null) sb.append(__wrapString(count++, "politicalFace", getPoliticalFace()));
		if(getEducationProof() != null) sb.append(__wrapString(count++, "educationProof", getEducationProof()));
		if(getDegreeProof() != null) sb.append(__wrapString(count++, "degreeProof", getDegreeProof()));
		if(getStartWorkDate() != null) sb.append(__wrapString(count++, "startWorkDate", getStartWorkDate()));
		if(getOnboardDate() != null) sb.append(__wrapString(count++, "onboardDate", getOnboardDate()));
		if(getPositiveDate() != null) sb.append(__wrapString(count++, "positiveDate", getPositiveDate()));
		if(getPersonalBusinessRemark() != null) sb.append(__wrapString(count++, "personalBusinessRemark", getPersonalBusinessRemark()));
		if(getContractStartDate() != null) sb.append(__wrapString(count++, "contractStartDate", getContractStartDate()));
		if(getContractEndDate() != null) sb.append(__wrapString(count++, "contractEndDate", getContractEndDate()));
		if(getOwnedCompany() != null) sb.append(__wrapString(count++, "ownedCompany", getOwnedCompany()));
		if(getDutyId() != null) sb.append(__wrapString(count++, "dutyId", getDutyId()));
		if(getSocialComputerNumber() != null) sb.append(__wrapString(count++, "socialComputerNumber", getSocialComputerNumber()));
		if(getFundAccount() != null) sb.append(__wrapString(count++, "fundAccount", getFundAccount()));
		if(getBankCardNum() != null) sb.append(__wrapString(count++, "bankCardNum", getBankCardNum()));
		if(getWorkYearType() != null) sb.append(__wrapString(count++, "workYearType", getWorkYearType()));
		if(getEmergencyContactPerson() != null) sb.append(__wrapString(count++, "emergencyContactPerson", getEmergencyContactPerson()));
		if(getEmergencyContactPhone() != null) sb.append(__wrapString(count++, "emergencyContactPhone", getEmergencyContactPhone()));
		if(getCardAddress() != null) sb.append(__wrapString(count++, "cardAddress", getCardAddress()));
		if(getGraduatedSchool() != null) sb.append(__wrapString(count++, "graduatedSchool", getGraduatedSchool()));
		if(getSpecialty() != null) sb.append(__wrapString(count++, "specialty", getSpecialty()));
		if(getLearningWay() != null) sb.append(__wrapString(count++, "learningWay", getLearningWay()));
		if(getCardAttachment() != null) sb.append(__wrapString(count++, "cardAttachment", getCardAttachment()));
		if(getEducationProofId() != null) sb.append(__wrapString(count++, "educationProofId", getEducationProofId()));
		if(getDegreeProofId() != null) sb.append(__wrapString(count++, "degreeProofId", getDegreeProofId()));
		if(getLaborAttachments() != null) sb.append(__wrapString(count++, "laborAttachments", getLaborAttachments()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getEmployeeNameEn() != null) res.put("employeeNameEn", getEmployeeNameEn());
		if(getFileNumber() != null) res.put("fileNumber", getFileNumber());
		if(getCard() != null) res.put("card", getCard());
		if(getGender() != null) res.put("gender", getGender());
		if(getMobile() != null) res.put("mobile", getMobile());
		if(getCountry() != null) res.put("country", getCountry());
		if(getBirthplace() != null) res.put("birthplace", getBirthplace());
		if(getAccountLocation() != null) res.put("accountLocation", getAccountLocation());
		if(getHouseholdRegistration() != null) res.put("householdRegistration", getHouseholdRegistration());
		if(getNationality() != null) res.put("nationality", getNationality());
		if(getMarriedStatus() != null) res.put("marriedStatus", getMarriedStatus());
		if(getPoliticalFace() != null) res.put("politicalFace", getPoliticalFace());
		if(getEducationProof() != null) res.put("educationProof", getEducationProof());
		if(getDegreeProof() != null) res.put("degreeProof", getDegreeProof());
		if(getStartWorkDate() != null) res.put("startWorkDate", getStartWorkDate());
		if(getOnboardDate() != null) res.put("onboardDate", getOnboardDate());
		if(getPositiveDate() != null) res.put("positiveDate", getPositiveDate());
		if(getPersonalBusinessRemark() != null) res.put("personalBusinessRemark", getPersonalBusinessRemark());
		if(getContractStartDate() != null) res.put("contractStartDate", getContractStartDate());
		if(getContractEndDate() != null) res.put("contractEndDate", getContractEndDate());
		if(getOwnedCompany() != null) res.put("ownedCompany", getOwnedCompany());
		if(getDutyId() != null) res.put("dutyId", getDutyId());
		if(getSocialComputerNumber() != null) res.put("socialComputerNumber", getSocialComputerNumber());
		if(getFundAccount() != null) res.put("fundAccount", getFundAccount());
		if(getBankCardNum() != null) res.put("bankCardNum", getBankCardNum());
		if(getWorkYearType() != null) res.put("workYearType", getWorkYearType());
		if(getEmergencyContactPerson() != null) res.put("emergencyContactPerson", getEmergencyContactPerson());
		if(getEmergencyContactPhone() != null) res.put("emergencyContactPhone", getEmergencyContactPhone());
		if(getCardAddress() != null) res.put("cardAddress", getCardAddress());
		if(getGraduatedSchool() != null) res.put("graduatedSchool", getGraduatedSchool());
		if(getSpecialty() != null) res.put("specialty", getSpecialty());
		if(getLearningWay() != null) res.put("learningWay", getLearningWay());
		if(getCardAttachment() != null) res.put("cardAttachment", getCardAttachment());
		if(getEducationProofId() != null) res.put("educationProofId", getEducationProofId());
		if(getDegreeProofId() != null) res.put("degreeProofId", getDegreeProofId());
		if(getLaborAttachments() != null) res.put("laborAttachments", getLaborAttachments());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeNameEn")) != null) setEmployeeNameEn(__getString(val));
		if((val = values.get("fileNumber")) != null) setFileNumber(__getString(val));
		if((val = values.get("card")) != null) setCard(__getString(val));
		if((val = values.get("gender")) != null) setGender(__getString(val));
		if((val = values.get("mobile")) != null) setMobile(__getString(val));
		if((val = values.get("country")) != null) setCountry(__getString(val));
		if((val = values.get("birthplace")) != null) setBirthplace(__getString(val));
		if((val = values.get("accountLocation")) != null) setAccountLocation(__getString(val));
		if((val = values.get("householdRegistration")) != null) setHouseholdRegistration(__getString(val));
		if((val = values.get("nationality")) != null) setNationality(__getString(val));
		if((val = values.get("marriedStatus")) != null) setMarriedStatus(__getString(val));
		if((val = values.get("politicalFace")) != null) setPoliticalFace(__getString(val));
		if((val = values.get("educationProof")) != null) setEducationProof(__getString(val));
		if((val = values.get("degreeProof")) != null) setDegreeProof(__getString(val));
		if((val = values.get("startWorkDate")) != null) setStartWorkDate(__getString(val));
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getString(val));
		if((val = values.get("positiveDate")) != null) setPositiveDate(__getString(val));
		if((val = values.get("personalBusinessRemark")) != null) setPersonalBusinessRemark(__getString(val));
		if((val = values.get("contractStartDate")) != null) setContractStartDate(__getString(val));
		if((val = values.get("contractEndDate")) != null) setContractEndDate(__getString(val));
		if((val = values.get("ownedCompany")) != null) setOwnedCompany(__getString(val));
		if((val = values.get("dutyId")) != null) setDutyId(__getString(val));
		if((val = values.get("socialComputerNumber")) != null) setSocialComputerNumber(__getString(val));
		if((val = values.get("fundAccount")) != null) setFundAccount(__getString(val));
		if((val = values.get("bankCardNum")) != null) setBankCardNum(__getString(val));
		if((val = values.get("workYearType")) != null) setWorkYearType(__getString(val));
		if((val = values.get("emergencyContactPerson")) != null) setEmergencyContactPerson(__getString(val));
		if((val = values.get("emergencyContactPhone")) != null) setEmergencyContactPhone(__getString(val));
		if((val = values.get("cardAddress")) != null) setCardAddress(__getString(val));
		if((val = values.get("graduatedSchool")) != null) setGraduatedSchool(__getString(val));
		if((val = values.get("specialty")) != null) setSpecialty(__getString(val));
		if((val = values.get("learningWay")) != null) setLearningWay(__getString(val));
		if((val = values.get("cardAttachment")) != null) setCardAttachment(__getString(val));
		if((val = values.get("educationProofId")) != null) setEducationProofId(__getString(val));
		if((val = values.get("degreeProofId")) != null) setDegreeProofId(__getString(val));
		if((val = values.get("laborAttachments")) != null) setLaborAttachments(__getString(val));
	}

	protected Integer  __employee_id ;
	protected String  __employee_no ;
	protected String  __employee_name ;
	protected Integer  __department_id ;
	protected String  __employee_name_en ;
	protected String  __file_number ;
	protected String  __card ;
	protected String  __gender ;
	protected String  __mobile ;
	protected String  __country ;
	protected String  __birthplace ;
	protected String  __account_location ;
	protected String  __household_registration ;
	protected String  __nationality ;
	protected String  __married_status ;
	protected String  __political_face ;
	protected String  __education_proof ;
	protected String  __degree_proof ;
	protected String  __start_work_date ;
	protected String  __onboard_date ;
	protected String  __positive_date ;
	protected String  __personal_business_remark ;
	protected String  __contract_start_date ;
	protected String  __contract_end_date ;
	protected String  __owned_company ;
	protected String  __duty_id ;
	protected String  __social_computer_number ;
	protected String  __fund_account ;
	protected String  __bank_card_num ;
	protected String  __work_year_type ;
	protected String  __emergency_contact_person ;
	protected String  __emergency_contact_phone ;
	protected String  __card_address ;
	protected String  __graduated_school ;
	protected String  __specialty ;
	protected String  __learning_way ;
	protected String  __card_attachment ;
	protected String  __education_proof_id ;
	protected String  __degree_proof_id ;
	protected String  __labor_attachments ;
}
