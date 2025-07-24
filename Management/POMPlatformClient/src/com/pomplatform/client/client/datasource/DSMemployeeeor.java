package com.pomplatform.client.client.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMemployeeeor extends DBDataSource
{


	public static DSMemployeeeor instance = null;

	public static DSMemployeeeor getInstance() {
		if(instance == null) {
			instance = new DSMemployeeeor("DSMemployeeeor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField roleIdField;
	private final DataSourceIntegerField gradeIdField;
	private final DataSourceTextField employeePasswordField;
	private final DataSourceTextField mobileField;
	private final DataSourceTextField phoneField;
	private final DataSourceTextField qqField;
	private final DataSourceTextField emailField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceDateField resignationDateField;
	private final DataSourceIntegerField statusField;
	private final DataSourceBooleanField usableStatusField;
	private final DataSourceBooleanField isDepartmentField;
	private final DataSourceTextField photoField;
	private final DataSourceIntegerField genderField;
	private final DataSourceTextField autographField;
	private final DataSourceIntegerField ageField;
	private final DataSourceDateField birthField;
	private final DataSourceTextField cardField;
	private final DataSourceTextField addressField;
	private final DataSourceTextField alternateField1Field;
	private final DataSourceTextField alternateField2Field;
	private final DataSourceTextField alternateField3Field;
	private final DataSourceBooleanField lockedField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceTextField userAcctField;
	private final DataSourceTextField employeeNameEnField;
	private final DataSourceTextField educationField;
	private final DataSourceTextField degreeField;
	private final DataSourceTextField nationalityField;
	private final DataSourceTextField marriedStatusField;
	private final DataSourceTextField healthField;
	private final DataSourceTextField workAddressField;
	private final DataSourceTextField registeredAddressField;
	private final DataSourceIntegerField oaIdField;
	private final DataSourceIntegerField oaDepartField;
	private final DataSourceBooleanField isHeadcountField;
	private final DataSourceBooleanField isCheckField;
	private final DataSourceIntegerField directLeaderField;
	private final DataSourceBooleanField isManagerField;
	private final DataSourceIntegerField politicalFaceField;
	private final DataSourceTextField birthplaceField;
	private final DataSourceTextField countryField;
	private final DataSourceTextField accountLocationField;
	private final DataSourceTextField languagesField;
	private final DataSourceDateField startWorkDateField;
	private final DataSourceTextField socialComputerNumberField;
	private final DataSourceTextField fundAccountField;
	private final DataSourceDateField positiveDateField;
	private final DataSourceTextField tryTimeField;
	private final DataSourceDateField contractStartDateField;
	private final DataSourceDateField contractEndDateField;
	private final DataSourceTextField ownedCompanyField;
	private final DataSourceTextField jobsField;
	private final DataSourceTextField personalBusinessRemarkField;
	private final DataSourceTextField selfIntroductionField;
	private final DataSourceTextField laborAttachmentsField;
	private final DataSourceTextField emergencyContactPersonField;
	private final DataSourceTextField emergencyContactPhoneField;
	private final DataSourceTextField homePhoneField;
	private final DataSourceTextField nowAddressField;
	private final DataSourceTextField tryTimePayField;
	private final DataSourceTextField positivePayField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceTextField bankCardNumField;
	private final DataSourceTextField fileNumberField;
	private final DataSourceIntegerField householdRegistrationField;
	private final DataSourceTextField foremanField;
	private final DataSourceTextField cardAttachmentField;
	private final DataSourceTextField technicalAttachmentField;
	private final DataSourceTextField educationProofField;
	private final DataSourceTextField degreeProofField;
	private final DataSourceIntegerField employeeShiftField;
	private final DataSourceTextField cardAddressField;
	private final DataSourceTextField annualPerformanceField;
	private final DataSourceTextField annualBonusField;
	private final DataSourceTextField companyWeixinField;
	private final DataSourceTextField companyEmailField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField ecmcUserIdField;
	private final DataSourceIntegerField onboardStatusField;
	private final DataSourceTextField attachmentRemarkField;
	private final DataSourceIntegerField workYearTypeField;
	private final DataSourceIntegerField isbusyField;
	private final DataSourceTextField foreignerIdCardField;
	private final DataSourceDateField realBirthdateField;
	private final DataSourceTextField workYearField;
	private final DataSourceIntegerField shenzhenHouseField;
	private final DataSourceDateField transHouseholdDateField;
	private final DataSourceIntegerField professionalDirectionField;
	private final DataSourceIntegerField recruitmentSourcesField;
	private final DataSourceTextField wechatNumField;
	private final DataSourceIntegerField autoSignYearField;
	private final DataSourceTextField resumeAttachmentField;
	private final DataSourceTextField signatureAttachmentField;
	private final DataSourceTextField socialAttachmentField;
	private final DataSourceTextField fundAttachmentField;
	private final DataSourceTextField spareAttachment1Field;
	private final DataSourceTextField spareAttachment2Field;
	private final DataSourceTextField spareAttachment3Field;
	private final DataSourceIntegerField employeeTypeField;
	private final DataSourceBooleanField isLongSickLeaveField;
	private final DataSourceIntegerField basicSalaryField;
	private final DataSourceIntegerField jobTitleAllowanceField;
	private final DataSourceIntegerField postAllowanceField;
	private final DataSourceIntegerField otherField;
	private final DataSourceIntegerField communicationSubsidyField;
	private final DataSourceIntegerField subtotalMonthlyWageField;
	private final DataSourceIntegerField monthlyPreissuedBonusField;
	private final DataSourceIntegerField totalMonthlyRemunerationField;
	private final DataSourceIntegerField photoIdField;
	private final DataSourceIntegerField laborAttachmentIdField;
	private final DataSourceIntegerField cardAttachmentIdField;
	private final DataSourceIntegerField technicalAttachmentIdField;
	private final DataSourceIntegerField educationProofIdField;
	private final DataSourceIntegerField degreeProofIdField;
	private final DataSourceTextField bankCardAttachmentField;
	private final DataSourceIntegerField bankCardAttachmentIdField;
	private final DataSourceIntegerField roleField;

	public DSMemployeeeor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Memployeeeor");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(false);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		roleIdField = new DataSourceIntegerField("roleId", "角色");
		roleIdField.setLength(11);
		roleIdField.setRequired(false);
		roleIdField.setHidden(false);


		gradeIdField = new DataSourceIntegerField("gradeId", "等级");
		gradeIdField.setLength(11);
		gradeIdField.setRequired(false);
		gradeIdField.setHidden(false);


		employeePasswordField = new DataSourceTextField("employeePassword", "密码");
		employeePasswordField.setLength(64);
		employeePasswordField.setRequired(false);
		employeePasswordField.setHidden(false);


		mobileField = new DataSourceTextField("mobile", "手机");
		mobileField.setLength(64);
		mobileField.setRequired(false);
		mobileField.setHidden(false);


		phoneField = new DataSourceTextField("phone", "电话");
		phoneField.setLength(64);
		phoneField.setRequired(false);
		phoneField.setHidden(false);


		qqField = new DataSourceTextField("qq", "QQ");
		qqField.setLength(64);
		qqField.setRequired(false);
		qqField.setHidden(false);


		emailField = new DataSourceTextField("email", "邮箱");
		emailField.setLength(64);
		emailField.setRequired(false);
		emailField.setHidden(false);


		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		resignationDateField = new DataSourceDateField("resignationDate", "离职日期");
		resignationDateField.setRequired(false);
		resignationDateField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "4删除)");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);


		usableStatusField = new DataSourceBooleanField("usableStatus", "是否可用");
		usableStatusField.setRequired(false);
		usableStatusField.setHidden(false);


		isDepartmentField = new DataSourceBooleanField("isDepartment", "是否为部门负责人");
		isDepartmentField.setRequired(false);
		isDepartmentField.setHidden(true);


		photoField = new DataSourceTextField("photo", "头像");
		photoField.setLength(512);
		photoField.setRequired(false);
		photoField.setHidden(true);


		genderField = new DataSourceIntegerField("gender", "性别");
		genderField.setLength(11);
		genderField.setRequired(false);
		genderField.setHidden(true);


		autographField = new DataSourceTextField("autograph", "我的签名");
		autographField.setLength(512);
		autographField.setRequired(false);
		autographField.setHidden(true);


		ageField = new DataSourceIntegerField("age", "age");
		ageField.setLength(11);
		ageField.setRequired(false);
		ageField.setHidden(true);


		birthField = new DataSourceDateField("birth", "出生日期");
		birthField.setRequired(false);
		birthField.setHidden(true);


		cardField = new DataSourceTextField("card", "身份证号");
		cardField.setLength(64);
		cardField.setRequired(false);
		cardField.setHidden(true);


		addressField = new DataSourceTextField("address", "家庭地址");
		addressField.setLength(512);
		addressField.setRequired(false);
		addressField.setHidden(true);


		alternateField1Field = new DataSourceTextField("alternateField1", "备用字段1");
		alternateField1Field.setLength(512);
		alternateField1Field.setRequired(false);
		alternateField1Field.setHidden(true);


		alternateField2Field = new DataSourceTextField("alternateField2", "备用字段2");
		alternateField2Field.setLength(512);
		alternateField2Field.setRequired(false);
		alternateField2Field.setHidden(true);


		alternateField3Field = new DataSourceTextField("alternateField3", "备用字段3");
		alternateField3Field.setLength(512);
		alternateField3Field.setRequired(false);
		alternateField3Field.setHidden(true);


		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		dutyIdField = new DataSourceIntegerField("dutyId", "职位名称");
		dutyIdField.setLength(11);
		dutyIdField.setRequired(false);
		dutyIdField.setHidden(true);


		userAcctField = new DataSourceTextField("userAcct", "上级领导");
		userAcctField.setLength(64);
		userAcctField.setRequired(false);
		userAcctField.setHidden(true);


		employeeNameEnField = new DataSourceTextField("employeeNameEn", "英文名");
		employeeNameEnField.setLength(64);
		employeeNameEnField.setRequired(false);
		employeeNameEnField.setHidden(true);


		educationField = new DataSourceTextField("education", "学历");
		educationField.setLength(64);
		educationField.setRequired(false);
		educationField.setHidden(true);


		degreeField = new DataSourceTextField("degree", "学位");
		degreeField.setLength(64);
		degreeField.setRequired(false);
		degreeField.setHidden(true);


		nationalityField = new DataSourceTextField("nationality", "名族");
		nationalityField.setLength(64);
		nationalityField.setRequired(false);
		nationalityField.setHidden(true);


		marriedStatusField = new DataSourceTextField("marriedStatus", "婚姻状况");
		marriedStatusField.setLength(64);
		marriedStatusField.setRequired(false);
		marriedStatusField.setHidden(true);


		healthField = new DataSourceTextField("health", "身体状况");
		healthField.setLength(64);
		healthField.setRequired(false);
		healthField.setHidden(true);


		workAddressField = new DataSourceTextField("workAddress", "工作地");
		workAddressField.setLength(128);
		workAddressField.setRequired(false);
		workAddressField.setHidden(true);


		registeredAddressField = new DataSourceTextField("registeredAddress", "注册地");
		registeredAddressField.setLength(128);
		registeredAddressField.setRequired(false);
		registeredAddressField.setHidden(true);


		oaIdField = new DataSourceIntegerField("oaId", "OA编码");
		oaIdField.setLength(11);
		oaIdField.setRequired(false);
		oaIdField.setHidden(true);


		oaDepartField = new DataSourceIntegerField("oaDepart", "OA部门");
		oaDepartField.setLength(11);
		oaDepartField.setRequired(false);
		oaDepartField.setHidden(true);


		isHeadcountField = new DataSourceBooleanField("isHeadcount", "总部员工");
		isHeadcountField.setRequired(false);
		isHeadcountField.setHidden(true);


		isCheckField = new DataSourceBooleanField("isCheck", "参与考勤");
		isCheckField.setRequired(false);
		isCheckField.setHidden(true);


		directLeaderField = new DataSourceIntegerField("directLeader", "直接领导");
		directLeaderField.setLength(11);
		directLeaderField.setRequired(false);
		directLeaderField.setHidden(true);


		isManagerField = new DataSourceBooleanField("isManager", "是否为超级管理员");
		isManagerField.setRequired(false);
		isManagerField.setHidden(true);


		politicalFaceField = new DataSourceIntegerField("politicalFace", "政治面貌");
		politicalFaceField.setLength(11);
		politicalFaceField.setRequired(false);
		politicalFaceField.setHidden(true);


		birthplaceField = new DataSourceTextField("birthplace", "籍贯");
		birthplaceField.setLength(64);
		birthplaceField.setRequired(false);
		birthplaceField.setHidden(true);


		countryField = new DataSourceTextField("country", "国籍");
		countryField.setLength(64);
		countryField.setRequired(false);
		countryField.setHidden(true);


		accountLocationField = new DataSourceTextField("accountLocation", "户口所在地");
		accountLocationField.setLength(64);
		accountLocationField.setRequired(false);
		accountLocationField.setHidden(true);


		languagesField = new DataSourceTextField("languages", "外语语种");
		languagesField.setLength(64);
		languagesField.setRequired(false);
		languagesField.setHidden(true);


		startWorkDateField = new DataSourceDateField("startWorkDate", "参加工作时间");
		startWorkDateField.setRequired(false);
		startWorkDateField.setHidden(true);


		socialComputerNumberField = new DataSourceTextField("socialComputerNumber", "社保电脑号");
		socialComputerNumberField.setLength(64);
		socialComputerNumberField.setRequired(false);
		socialComputerNumberField.setHidden(true);


		fundAccountField = new DataSourceTextField("fundAccount", "公积金账号");
		fundAccountField.setLength(64);
		fundAccountField.setRequired(false);
		fundAccountField.setHidden(true);


		positiveDateField = new DataSourceDateField("positiveDate", "转正日期");
		positiveDateField.setRequired(false);
		positiveDateField.setHidden(true);


		tryTimeField = new DataSourceTextField("tryTime", "试用期");
		tryTimeField.setLength(64);
		tryTimeField.setRequired(false);
		tryTimeField.setHidden(true);


		contractStartDateField = new DataSourceDateField("contractStartDate", "劳动合同开始时间");
		contractStartDateField.setRequired(false);
		contractStartDateField.setHidden(true);


		contractEndDateField = new DataSourceDateField("contractEndDate", "劳动合同到期时间");
		contractEndDateField.setRequired(false);
		contractEndDateField.setHidden(true);


		ownedCompanyField = new DataSourceTextField("ownedCompany", "所属公司");
		ownedCompanyField.setLength(64);
		ownedCompanyField.setRequired(false);
		ownedCompanyField.setHidden(true);


		jobsField = new DataSourceTextField("jobs", "职务");
		jobsField.setLength(64);
		jobsField.setRequired(false);
		jobsField.setHidden(true);


		personalBusinessRemarkField = new DataSourceTextField("personalBusinessRemark", "人事备注");
		personalBusinessRemarkField.setLength(64);
		personalBusinessRemarkField.setRequired(false);
		personalBusinessRemarkField.setHidden(true);


		selfIntroductionField = new DataSourceTextField("selfIntroduction", "个人介绍");
		selfIntroductionField.setLength(512);
		selfIntroductionField.setRequired(false);
		selfIntroductionField.setHidden(true);


		laborAttachmentsField = new DataSourceTextField("laborAttachments", "劳动合同附件");
		laborAttachmentsField.setLength(128);
		laborAttachmentsField.setRequired(false);
		laborAttachmentsField.setHidden(true);


		emergencyContactPersonField = new DataSourceTextField("emergencyContactPerson", "紧急联系人");
		emergencyContactPersonField.setLength(64);
		emergencyContactPersonField.setRequired(false);
		emergencyContactPersonField.setHidden(true);


		emergencyContactPhoneField = new DataSourceTextField("emergencyContactPhone", "紧急联系人电话");
		emergencyContactPhoneField.setLength(64);
		emergencyContactPhoneField.setRequired(false);
		emergencyContactPhoneField.setHidden(true);


		homePhoneField = new DataSourceTextField("homePhone", "家庭电话");
		homePhoneField.setLength(64);
		homePhoneField.setRequired(false);
		homePhoneField.setHidden(true);


		nowAddressField = new DataSourceTextField("nowAddress", "现住地址");
		nowAddressField.setLength(512);
		nowAddressField.setRequired(false);
		nowAddressField.setHidden(true);


		tryTimePayField = new DataSourceTextField("tryTimePay", "试用期工资");
		tryTimePayField.setLength(64);
		tryTimePayField.setRequired(false);
		tryTimePayField.setHidden(true);


		positivePayField = new DataSourceTextField("positivePay", "转正工资");
		positivePayField.setLength(64);
		positivePayField.setRequired(false);
		positivePayField.setHidden(true);


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "发起人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(true);


		bankCardNumField = new DataSourceTextField("bankCardNum", "银行卡号");
		bankCardNumField.setLength(64);
		bankCardNumField.setRequired(false);
		bankCardNumField.setHidden(true);


		fileNumberField = new DataSourceTextField("fileNumber", "档案号");
		fileNumberField.setLength(64);
		fileNumberField.setRequired(false);
		fileNumberField.setHidden(true);


		householdRegistrationField = new DataSourceIntegerField("householdRegistration", "户籍");
		householdRegistrationField.setLength(11);
		householdRegistrationField.setRequired(false);
		householdRegistrationField.setHidden(true);


		foremanField = new DataSourceTextField("foreman", "司龄");
		foremanField.setLength(128);
		foremanField.setRequired(false);
		foremanField.setHidden(true);


		cardAttachmentField = new DataSourceTextField("cardAttachment", "身份证附件");
		cardAttachmentField.setLength(128);
		cardAttachmentField.setRequired(false);
		cardAttachmentField.setHidden(true);


		technicalAttachmentField = new DataSourceTextField("technicalAttachment", "职称证明");
		technicalAttachmentField.setLength(128);
		technicalAttachmentField.setRequired(false);
		technicalAttachmentField.setHidden(true);


		educationProofField = new DataSourceTextField("educationProof", "学历证");
		educationProofField.setLength(128);
		educationProofField.setRequired(false);
		educationProofField.setHidden(true);


		degreeProofField = new DataSourceTextField("degreeProof", "学位证");
		degreeProofField.setLength(128);
		degreeProofField.setRequired(false);
		degreeProofField.setHidden(true);


		employeeShiftField = new DataSourceIntegerField("employeeShift", "员工排班");
		employeeShiftField.setLength(11);
		employeeShiftField.setRequired(false);
		employeeShiftField.setHidden(true);


		cardAddressField = new DataSourceTextField("cardAddress", "身份证地址");
		cardAddressField.setLength(128);
		cardAddressField.setRequired(false);
		cardAddressField.setHidden(true);


		annualPerformanceField = new DataSourceTextField("annualPerformance", "年度绩效");
		annualPerformanceField.setLength(64);
		annualPerformanceField.setRequired(false);
		annualPerformanceField.setHidden(true);


		annualBonusField = new DataSourceTextField("annualBonus", "年度奖金");
		annualBonusField.setLength(64);
		annualBonusField.setRequired(false);
		annualBonusField.setHidden(true);


		companyWeixinField = new DataSourceTextField("companyWeixin", "企业微信账号");
		companyWeixinField.setLength(255);
		companyWeixinField.setRequired(false);
		companyWeixinField.setHidden(true);


		companyEmailField = new DataSourceTextField("companyEmail", "企业邮箱");
		companyEmailField.setLength(255);
		companyEmailField.setRequired(false);
		companyEmailField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);


		ecmcUserIdField = new DataSourceIntegerField("ecmcUserId", "ECMC用户编码");
		ecmcUserIdField.setLength(11);
		ecmcUserIdField.setRequired(false);
		ecmcUserIdField.setHidden(true);


		onboardStatusField = new DataSourceIntegerField("onboardStatus", "入职职员状态(0实习生，1试用期，2正式员工)");
		onboardStatusField.setLength(11);
		onboardStatusField.setRequired(false);
		onboardStatusField.setHidden(true);


		attachmentRemarkField = new DataSourceTextField("attachmentRemark", "附件备注");
		attachmentRemarkField.setLength(128);
		attachmentRemarkField.setRequired(false);
		attachmentRemarkField.setHidden(true);


		workYearTypeField = new DataSourceIntegerField("workYearType", "工龄工资状态(对应字典表115)");
		workYearTypeField.setLength(11);
		workYearTypeField.setRequired(false);
		workYearTypeField.setHidden(true);


		isbusyField = new DataSourceIntegerField("isbusy", "是否忙碌状态（1空闲，2忙碌）");
		isbusyField.setLength(11);
		isbusyField.setRequired(false);
		isbusyField.setHidden(true);


		foreignerIdCardField = new DataSourceTextField("foreignerIdCard", "外籍人士身份号");
		foreignerIdCardField.setLength(64);
		foreignerIdCardField.setRequired(false);
		foreignerIdCardField.setHidden(true);


		realBirthdateField = new DataSourceDateField("realBirthdate", "实际生日");
		realBirthdateField.setRequired(false);
		realBirthdateField.setHidden(true);


		workYearField = new DataSourceTextField("workYear", "工龄");
		workYearField.setLength(32);
		workYearField.setRequired(false);
		workYearField.setHidden(true);


		shenzhenHouseField = new DataSourceIntegerField("shenzhenHouse", "自有深圳房产(1有,2无)");
		shenzhenHouseField.setLength(11);
		shenzhenHouseField.setRequired(false);
		shenzhenHouseField.setHidden(true);


		transHouseholdDateField = new DataSourceDateField("transHouseholdDate", "调户补贴首发日期");
		transHouseholdDateField.setRequired(false);
		transHouseholdDateField.setHidden(true);


		professionalDirectionField = new DataSourceIntegerField("professionalDirection", "专业方向");
		professionalDirectionField.setLength(11);
		professionalDirectionField.setRequired(false);
		professionalDirectionField.setHidden(true);


		recruitmentSourcesField = new DataSourceIntegerField("recruitmentSources", "招聘来源");
		recruitmentSourcesField.setLength(11);
		recruitmentSourcesField.setRequired(false);
		recruitmentSourcesField.setHidden(true);


		wechatNumField = new DataSourceTextField("wechatNum", "微信号");
		wechatNumField.setLength(64);
		wechatNumField.setRequired(false);
		wechatNumField.setHidden(true);


		autoSignYearField = new DataSourceIntegerField("autoSignYear", "自动续签年限");
		autoSignYearField.setLength(11);
		autoSignYearField.setRequired(false);
		autoSignYearField.setHidden(true);


		resumeAttachmentField = new DataSourceTextField("resumeAttachment", "入职简历附件");
		resumeAttachmentField.setLength(512);
		resumeAttachmentField.setRequired(false);
		resumeAttachmentField.setHidden(true);


		signatureAttachmentField = new DataSourceTextField("signatureAttachment", "电子签名附件");
		signatureAttachmentField.setLength(512);
		signatureAttachmentField.setRequired(false);
		signatureAttachmentField.setHidden(true);


		socialAttachmentField = new DataSourceTextField("socialAttachment", "社保卡附件");
		socialAttachmentField.setLength(512);
		socialAttachmentField.setRequired(false);
		socialAttachmentField.setHidden(true);


		fundAttachmentField = new DataSourceTextField("fundAttachment", "公积金卡附件");
		fundAttachmentField.setLength(512);
		fundAttachmentField.setRequired(false);
		fundAttachmentField.setHidden(true);


		spareAttachment1Field = new DataSourceTextField("spareAttachment1", "上传其他附件1");
		spareAttachment1Field.setLength(512);
		spareAttachment1Field.setRequired(false);
		spareAttachment1Field.setHidden(true);


		spareAttachment2Field = new DataSourceTextField("spareAttachment2", "上传其他附件2");
		spareAttachment2Field.setLength(512);
		spareAttachment2Field.setRequired(false);
		spareAttachment2Field.setHidden(true);


		spareAttachment3Field = new DataSourceTextField("spareAttachment3", "上传其他附件3");
		spareAttachment3Field.setLength(512);
		spareAttachment3Field.setRequired(false);
		spareAttachment3Field.setHidden(true);


		employeeTypeField = new DataSourceIntegerField("employeeType", "员工类型");
		employeeTypeField.setLength(11);
		employeeTypeField.setRequired(false);
		employeeTypeField.setHidden(true);


		isLongSickLeaveField = new DataSourceBooleanField("isLongSickLeave", "是否是长病假");
		isLongSickLeaveField.setRequired(false);
		isLongSickLeaveField.setHidden(true);


		basicSalaryField = new DataSourceIntegerField("basicSalary", "basicSalary");
		basicSalaryField.setLength(32);
		basicSalaryField.setRequired(true);
		basicSalaryField.setHidden(true);


		jobTitleAllowanceField = new DataSourceIntegerField("jobTitleAllowance", "jobTitleAllowance");
		jobTitleAllowanceField.setLength(32);
		jobTitleAllowanceField.setRequired(true);
		jobTitleAllowanceField.setHidden(true);


		postAllowanceField = new DataSourceIntegerField("postAllowance", "postAllowance");
		postAllowanceField.setLength(32);
		postAllowanceField.setRequired(true);
		postAllowanceField.setHidden(true);


		otherField = new DataSourceIntegerField("other", "other");
		otherField.setLength(32);
		otherField.setRequired(true);
		otherField.setHidden(true);


		communicationSubsidyField = new DataSourceIntegerField("communicationSubsidy", "communicationSubsidy");
		communicationSubsidyField.setLength(32);
		communicationSubsidyField.setRequired(true);
		communicationSubsidyField.setHidden(true);


		subtotalMonthlyWageField = new DataSourceIntegerField("subtotalMonthlyWage", "subtotalMonthlyWage");
		subtotalMonthlyWageField.setLength(32);
		subtotalMonthlyWageField.setRequired(true);
		subtotalMonthlyWageField.setHidden(true);


		monthlyPreissuedBonusField = new DataSourceIntegerField("monthlyPreissuedBonus", "monthlyPreissuedBonus");
		monthlyPreissuedBonusField.setLength(32);
		monthlyPreissuedBonusField.setRequired(true);
		monthlyPreissuedBonusField.setHidden(true);


		totalMonthlyRemunerationField = new DataSourceIntegerField("totalMonthlyRemuneration", "totalMonthlyRemuneration");
		totalMonthlyRemunerationField.setLength(32);
		totalMonthlyRemunerationField.setRequired(true);
		totalMonthlyRemunerationField.setHidden(true);


		photoIdField = new DataSourceIntegerField("photoId", "头像编码");
		photoIdField.setLength(11);
		photoIdField.setRequired(false);
		photoIdField.setHidden(true);


		laborAttachmentIdField = new DataSourceIntegerField("laborAttachmentId", "劳动合同附件编码");
		laborAttachmentIdField.setLength(11);
		laborAttachmentIdField.setRequired(false);
		laborAttachmentIdField.setHidden(true);


		cardAttachmentIdField = new DataSourceIntegerField("cardAttachmentId", "身份证附件编码");
		cardAttachmentIdField.setLength(11);
		cardAttachmentIdField.setRequired(false);
		cardAttachmentIdField.setHidden(true);


		technicalAttachmentIdField = new DataSourceIntegerField("technicalAttachmentId", "职称证明编码");
		technicalAttachmentIdField.setLength(11);
		technicalAttachmentIdField.setRequired(false);
		technicalAttachmentIdField.setHidden(true);


		educationProofIdField = new DataSourceIntegerField("educationProofId", "学历证编码");
		educationProofIdField.setLength(11);
		educationProofIdField.setRequired(false);
		educationProofIdField.setHidden(true);


		degreeProofIdField = new DataSourceIntegerField("degreeProofId", "学位证编码");
		degreeProofIdField.setLength(11);
		degreeProofIdField.setRequired(false);
		degreeProofIdField.setHidden(true);


		bankCardAttachmentField = new DataSourceTextField("bankCardAttachment", "银行卡附件");
		bankCardAttachmentField.setLength(512);
		bankCardAttachmentField.setRequired(false);
		bankCardAttachmentField.setHidden(true);


		bankCardAttachmentIdField = new DataSourceIntegerField("bankCardAttachmentId", "银行卡附件编码");
		bankCardAttachmentIdField.setLength(11);
		bankCardAttachmentIdField.setRequired(false);
		bankCardAttachmentIdField.setHidden(true);


		roleField = new DataSourceIntegerField("role", "role");
		roleField.setLength(11);
		roleField.setRequired(true);
		roleField.setHidden(true);


		setFields(employeeIdField, employeeNoField, employeeNameField, departmentIdField, roleIdField, gradeIdField, employeePasswordField, mobileField, phoneField, qqField, emailField, onboardDateField, resignationDateField, statusField, usableStatusField, isDepartmentField, photoField, genderField, autographField, ageField, birthField, cardField, addressField, alternateField1Field, alternateField2Field, alternateField3Field, lockedField, plateIdField, dutyIdField, userAcctField, employeeNameEnField, educationField, degreeField, nationalityField, marriedStatusField, healthField, workAddressField, registeredAddressField, oaIdField, oaDepartField, isHeadcountField, isCheckField, directLeaderField, isManagerField, politicalFaceField, birthplaceField, countryField, accountLocationField, languagesField, startWorkDateField, socialComputerNumberField, fundAccountField, positiveDateField, tryTimeField, contractStartDateField, contractEndDateField, ownedCompanyField, jobsField, personalBusinessRemarkField, selfIntroductionField, laborAttachmentsField, emergencyContactPersonField, emergencyContactPhoneField, homePhoneField, nowAddressField, tryTimePayField, positivePayField, applyEmployeeIdField, bankCardNumField, fileNumberField, householdRegistrationField, foremanField, cardAttachmentField, technicalAttachmentField, educationProofField, degreeProofField, employeeShiftField, cardAddressField, annualPerformanceField, annualBonusField, companyWeixinField, companyEmailField, companyIdField, ecmcUserIdField, onboardStatusField, attachmentRemarkField, workYearTypeField, isbusyField, foreignerIdCardField, realBirthdateField, workYearField, shenzhenHouseField, transHouseholdDateField, professionalDirectionField, recruitmentSourcesField, wechatNumField, autoSignYearField, resumeAttachmentField, signatureAttachmentField, socialAttachmentField, fundAttachmentField, spareAttachment1Field, spareAttachment2Field, spareAttachment3Field, employeeTypeField, isLongSickLeaveField, basicSalaryField, jobTitleAllowanceField, postAllowanceField, otherField, communicationSubsidyField, subtotalMonthlyWageField, monthlyPreissuedBonusField, totalMonthlyRemunerationField, photoIdField, laborAttachmentIdField, cardAttachmentIdField, technicalAttachmentIdField, educationProofIdField, degreeProofIdField, bankCardAttachmentField, bankCardAttachmentIdField, roleField);
	}


}

