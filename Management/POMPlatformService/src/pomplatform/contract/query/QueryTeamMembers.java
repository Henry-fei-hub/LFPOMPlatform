package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseTeamMembers;
import pomplatform.contract.bean.ConditionTeamMembers;

public class QueryTeamMembers extends AbstractQuery<BaseTeamMembers, ConditionTeamMembers>
{

	private static final Logger __logger = Logger.getLogger(QueryTeamMembers.class);

	public QueryTeamMembers() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.*");
	}

	@Override
	public BaseCollection<BaseTeamMembers> executeQuery( KeyValuePair[] replacements, ConditionTeamMembers condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId(), 
				condition.getEmployeeName()
			);
	}

	@Override
	public BaseTeamMembers generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTeamMembers __base = new BaseTeamMembers();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeePassword(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQq(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setResignationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUsableStatus(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsDepartment(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAutograph(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAge(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBirth(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUserAcct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameEn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEducation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDegree(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNationality(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMarriedStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHealth(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRegisteredAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOaId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOaDepart(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsHeadcount(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsCheck(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDirectLeader(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsManager(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPoliticalFace(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBirthplace(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCountry(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAccountLocation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLanguages(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartWorkDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSocialComputerNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFundAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPositiveDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTryTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setContractEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOwnedCompany(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setJobs(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPersonalBusinessRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfIntroduction(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLaborAttachments(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmergencyContactPerson(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmergencyContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHomePhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNowAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTryTimePay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPositivePay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBankCardNum(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFileNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHouseholdRegistration(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setForeman(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCardAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTechnicalAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEducationProof(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDegreeProof(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeShift(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCardAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAnnualPerformance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAnnualBonus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyWeixin(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEcmcUserId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkYearType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsbusy(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setForeignerIdCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRealBirthdate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWorkYear(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setShenzhenHouse(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTransHouseholdDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProfessionalDirection(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecruitmentSources(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWechatNum(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAutoSignYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setResumeAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSignatureAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSocialAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFundAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpareAttachment1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpareAttachment2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpareAttachment3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsLongSickLeave(GenericBase.__getBoolean(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = "SELECT e.* FROM employees e LEFT JOIN departments d ON e.department_id = d.department_id WHERE d.parent_id in (select department_id from departments where parent_id = 9) and e.status = 0 and e.department_id = ? and e.employee_name like ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,role_id,grade_id,employee_password,mobile,phone,qq,email,onboard_date,resignation_date,status,usable_status,is_department,photo,gender,autograph,age,birth,card,address,alternate_field1,alternate_field2,alternate_field3,locked,plate_id,duty_id,user_acct,employee_name_en,education,degree,nationality,married_status,health,work_address,registered_address,oa_id,oa_depart,is_headcount,is_check,direct_leader,is_manager,political_face,birthplace,country,account_location,languages,start_work_date,social_computer_number,fund_account,positive_date,try_time,contract_start_date,contract_end_date,owned_company,jobs,personal_business_remark,self_introduction,labor_attachments,emergency_contact_person,emergency_contact_phone,home_phone,now_address,try_time_pay,positive_pay,apply_employee_id,bank_card_num,file_number,household_registration,foreman,card_attachment,technical_attachment,education_proof,degree_proof,employee_shift,card_address,annual_performance,annual_bonus,company_weixin,company_email,company_id,ecmc_user_id,onboard_status,attachment_remark,work_year_type,isbusy,foreigner_id_card,real_birthdate,work_year,shenzhen_house,trans_household_date,professional_direction,recruitment_sources,wechat_num,auto_sign_year,resume_attachment,signature_attachment,social_attachment,fund_attachment,spare_attachment1,spare_attachment2,spare_attachment3,employee_type,is_long_sick_leave";
	private final static String[] fieldNames = { "department_id", "employee_name"};
}
