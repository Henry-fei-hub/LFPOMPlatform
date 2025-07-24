package pomplatform.hr.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.hr.bean.BaseForEmpManageExportData;
import pomplatform.hr.bean.ConditionForEmpManageExportData;

public class QueryForEmpManageExportData extends AbstractQuery<BaseForEmpManageExportData, ConditionForEmpManageExportData>
{

	private static final Logger __logger = Logger.getLogger(QueryForEmpManageExportData.class);

	public QueryForEmpManageExportData() throws java.sql.SQLException 
	{
		setParameterNumber(16);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseForEmpManageExportData> executeQuery( KeyValuePair[] replacements, ConditionForEmpManageExportData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getRoleId(), 
				condition.getGradeId(), 
				condition.getStatus(), 
				condition.getIsDepartment(), 
				condition.getGender(), 
				condition.getDuty(), 
				condition.getOnboardYear(), 
				condition.getOnboardMonth(), 
				condition.getResiYear(), 
				condition.getResiMonth(), 
				condition.getBirthMonth(), 
				condition.getIsCheck()
			);
	}

	@Override
	public BaseForEmpManageExportData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseForEmpManageExportData __base = new BaseForEmpManageExportData();
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[15]));
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


	private final static String __SQLText = "select e.employee_id, e.employee_no, e.employee_name, e.department_id, e.role_id, e.grade_id, e.employee_password, e.mobile, e.phone, e.qq, e.email, e.onboard_date, e.resignation_date, e.status, e.usable_status, e.is_department, e.photo, e.gender, e.autograph, e.age, e.birth, e.card, e.address, e.alternate_field1, e.alternate_field2, e.alternate_field3, e.locked, e.plate_id, e.duty_id, e.user_acct, e.employee_name_en, e.education, e.degree, e.nationality, e.married_status, e.health, e.work_address, e.registered_address, e.oa_id, e.oa_depart, e.is_headcount, e.is_check, e.direct_leader, e.is_manager, e.political_face, e.birthplace, e.country, e.account_location, e.languages, e.start_work_date, e.social_computer_number, e.fund_account, e.positive_date, e.try_time, e.contract_start_date, e.contract_end_date, e.owned_company, e.jobs, e.personal_business_remark, e.self_introduction, e.labor_attachments, e.emergency_contact_person, e.emergency_contact_phone, e.home_phone, e.now_address, e.try_time_pay, e.positive_pay, e.apply_employee_id, e.bank_card_num, e.file_number, e.household_registration, e.foreman, e.card_attachment, e.technical_attachment, e.education_proof, e.degree_proof, e.employee_shift, e.card_address, e.annual_performance, e.annual_bonus, e.company_weixin, e.company_email, e.company_id, e.ecmc_user_id, e.onboard_status, e.attachment_remark, e.work_year_type from employees e where e.is_manager = false and e.plate_id = ? and e.employee_no like ? and e.employee_name like ? and e.department_id in(select child_id from department_ids where department_id = ?) and e.employee_id in(select employee_id from employee_roles where role_id = ?) and e.grade_id = ? and e.status = ? and e.is_department = ? and e.gender = ? and e.duty_id = ? and ( EXTRACT ( YEAR FROM onboard_date )) = ? and ( EXTRACT ( MONTH FROM onboard_date )) = ? and ( EXTRACT ( YEAR FROM resignation_date )) = ? and ( EXTRACT ( MONTH FROM resignation_date )) = ? and ( EXTRACT ( MONTH FROM birth )) = ? and e.is_check = ? order by e.plate_id asc,e.department_id asc" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,role_id,grade_id,employee_password,mobile,phone,qq,email,onboard_date,resignation_date,status,usable_status,is_department,photo,gender,autograph,age,birth,card,address,alternate_field1,alternate_field2,alternate_field3,locked,plate_id,duty_id,user_acct,employee_name_en,education,degree,nationality,married_status,health,work_address,registered_address,oa_id,oa_depart,is_headcount,is_check,direct_leader,is_manager,political_face,birthplace,country,account_location,languages,start_work_date,social_computer_number,fund_account,positive_date,try_time,contract_start_date,contract_end_date,owned_company,jobs,personal_business_remark,self_introduction,labor_attachments,emergency_contact_person,emergency_contact_phone,home_phone,now_address,try_time_pay,positive_pay,apply_employee_id,bank_card_num,file_number,household_registration,foreman,card_attachment,technical_attachment,education_proof,degree_proof,employee_shift,card_address,annual_performance,annual_bonus,company_weixin,company_email,company_id,ecmc_user_id,onboard_status,attachment_remark,work_year_type";
	private final static String[] fieldNames = { "plate_id", "employee_no", "employee_name", "department_id", "role_id", "grade_id", "status", "is_department", "gender", "duty", "onboard_year", "onboard_month", "resi_year", "resi_month", "birth_month","is_check"};
}
