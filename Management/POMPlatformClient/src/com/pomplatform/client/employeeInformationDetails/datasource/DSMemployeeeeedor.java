package com.pomplatform.client.employeeInformationDetails.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMemployeeeeedor extends DBDataSource
{


	public static DSMemployeeeeedor instance = null;

	public static DSMemployeeeeedor getInstance() {
		if(instance == null) {
			instance = new DSMemployeeeeedor("DSMemployeeeeedor");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField employeeNameEnField;
	private final DataSourceTextField fileNumberField;
	private final DataSourceTextField cardField;
	private final DataSourceIntegerField genderField;
	private final DataSourceTextField mobileField;
	private final DataSourceTextField countryField;
	private final DataSourceTextField birthplaceField;
	private final DataSourceTextField accountLocationField;
	private final DataSourceIntegerField householdRegistrationField;
	private final DataSourceTextField nationalityField;
	private final DataSourceTextField marriedStatusField;
	private final DataSourceIntegerField politicalFaceField;
	private final DataSourceTextField educationProofField;
	private final DataSourceTextField degreeProofField;
	private final DataSourceDateField startWorkDateField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceDateField positiveDateField;
	private final DataSourceTextField personalBusinessRemarkField;
	private final DataSourceDateField contractStartDateField;
	private final DataSourceDateField contractEndDateField;
	private final DataSourceTextField ownedCompanyField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceTextField socialComputerNumberField;
	private final DataSourceTextField fundAccountField;
	private final DataSourceTextField bankCardNumField;
	private final DataSourceIntegerField workYearTypeField;
	private final DataSourceTextField emergencyContactPersonField;
	private final DataSourceTextField emergencyContactPhoneField;
	private final DataSourceTextField cardAddressField;
	private final DataSourceTextField graduatedSchoolField;
	private final DataSourceTextField specialtyField;
	private final DataSourceIntegerField learningWayField;
	private final DataSourceTextField cardAttachmentField;
	private final DataSourceIntegerField educationProofIdField;
	private final DataSourceIntegerField degreeProofIdField;
	private final DataSourceTextField laborAttachmentsField;

	public DSMemployeeeeedor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Memployeeeeedor");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工工号");
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
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		genderField = new DataSourceIntegerField("gender", "性别");
		genderField.setLength(11);
		genderField.setRequired(false);
		genderField.setHidden(false);

		employeeNameEnField = new DataSourceTextField("employeeNameEn", "英文名");
		employeeNameEnField.setLength(64);
		employeeNameEnField.setRequired(false);
		employeeNameEnField.setHidden(false);


		fileNumberField = new DataSourceTextField("fileNumber", "档案号");
		fileNumberField.setLength(64);
		fileNumberField.setRequired(false);
		fileNumberField.setHidden(false);


		cardField = new DataSourceTextField("card", "身份证号");
		cardField.setLength(64);
		cardField.setRequired(false);
		cardField.setHidden(false);



		mobileField = new DataSourceTextField("mobile", "手机");
		mobileField.setLength(64);
		mobileField.setRequired(false);
		mobileField.setHidden(false);


		countryField = new DataSourceTextField("country", "国籍");
		countryField.setLength(64);
		countryField.setRequired(false);
		countryField.setHidden(false);


		birthplaceField = new DataSourceTextField("birthplace", "籍贯");
		birthplaceField.setLength(64);
		birthplaceField.setRequired(false);
		birthplaceField.setHidden(false);


		accountLocationField = new DataSourceTextField("accountLocation", "户口所在地");
		accountLocationField.setLength(64);
		accountLocationField.setRequired(false);
		accountLocationField.setHidden(false);


		householdRegistrationField = new DataSourceIntegerField("householdRegistration", "户籍");
		householdRegistrationField.setLength(11);
		householdRegistrationField.setRequired(false);
		householdRegistrationField.setHidden(false);


		nationalityField = new DataSourceTextField("nationality", "名族");
		nationalityField.setLength(64);
		nationalityField.setRequired(false);
		nationalityField.setHidden(false);


		marriedStatusField = new DataSourceTextField("marriedStatus", "婚姻状况");
		marriedStatusField.setLength(64);
		marriedStatusField.setRequired(false);
		marriedStatusField.setHidden(false);


		politicalFaceField = new DataSourceIntegerField("politicalFace", "政治面貌");
		politicalFaceField.setLength(11);
		politicalFaceField.setRequired(false);
		politicalFaceField.setHidden(false);


		educationProofField = new DataSourceTextField("educationProof", "学历证");
		educationProofField.setLength(128);
		educationProofField.setRequired(false);
		educationProofField.setHidden(false);


		degreeProofField = new DataSourceTextField("degreeProof", "学位证");
		degreeProofField.setLength(128);
		degreeProofField.setRequired(false);
		degreeProofField.setHidden(false);


		startWorkDateField = new DataSourceDateField("startWorkDate", "参加工作时间");
		startWorkDateField.setRequired(false);
		startWorkDateField.setHidden(false);


		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		positiveDateField = new DataSourceDateField("positiveDate", "转正日期");
		positiveDateField.setRequired(false);
		positiveDateField.setHidden(false);


		personalBusinessRemarkField = new DataSourceTextField("personalBusinessRemark", "人事备注");
		personalBusinessRemarkField.setLength(64);
		personalBusinessRemarkField.setRequired(false);
		personalBusinessRemarkField.setHidden(false);


		contractStartDateField = new DataSourceDateField("contractStartDate", "劳动合同开始时间");
		contractStartDateField.setRequired(false);
		contractStartDateField.setHidden(false);


		contractEndDateField = new DataSourceDateField("contractEndDate", "劳动合同到期时间");
		contractEndDateField.setRequired(false);
		contractEndDateField.setHidden(false);


		ownedCompanyField = new DataSourceTextField("ownedCompany", "所属公司");
		ownedCompanyField.setLength(64);
		ownedCompanyField.setRequired(false);
		ownedCompanyField.setHidden(false);


		dutyIdField = new DataSourceIntegerField("dutyId", "职位名称");
		dutyIdField.setLength(11);
		dutyIdField.setRequired(false);
		dutyIdField.setHidden(false);


		socialComputerNumberField = new DataSourceTextField("socialComputerNumber", "社保电脑号");
		socialComputerNumberField.setLength(64);
		socialComputerNumberField.setRequired(false);
		socialComputerNumberField.setHidden(false);


		fundAccountField = new DataSourceTextField("fundAccount", "公积金账号");
		fundAccountField.setLength(64);
		fundAccountField.setRequired(false);
		fundAccountField.setHidden(false);


		bankCardNumField = new DataSourceTextField("bankCardNum", "银行卡号");
		bankCardNumField.setLength(64);
		bankCardNumField.setRequired(false);
		bankCardNumField.setHidden(false);


		workYearTypeField = new DataSourceIntegerField("workYearType", "工龄工资状态");
		workYearTypeField.setLength(11);
		workYearTypeField.setRequired(false);
		workYearTypeField.setHidden(false);


		emergencyContactPersonField = new DataSourceTextField("emergencyContactPerson", "紧急联系人");
		emergencyContactPersonField.setLength(64);
		emergencyContactPersonField.setRequired(false);
		emergencyContactPersonField.setHidden(false);


		emergencyContactPhoneField = new DataSourceTextField("emergencyContactPhone", "紧急联系人电话");
		emergencyContactPhoneField.setLength(64);
		emergencyContactPhoneField.setRequired(false);
		emergencyContactPhoneField.setHidden(false);


		cardAddressField = new DataSourceTextField("cardAddress", "身份证地址");
		cardAddressField.setLength(128);
		cardAddressField.setRequired(false);
		cardAddressField.setHidden(false);


		graduatedSchoolField = new DataSourceTextField("graduatedSchool", "毕业院校");
		graduatedSchoolField.setLength(64);
		graduatedSchoolField.setRequired(false);
		graduatedSchoolField.setHidden(false);


		specialtyField = new DataSourceTextField("specialty", "所学专业");
		specialtyField.setLength(64);
		specialtyField.setRequired(false);
		specialtyField.setHidden(false);


		learningWayField = new DataSourceIntegerField("learningWay", "学习形式");
		learningWayField.setLength(11);
		learningWayField.setRequired(false);
		learningWayField.setHidden(false);


		cardAttachmentField = new DataSourceTextField("cardAttachment", "身份证附件");
		cardAttachmentField.setLength(128);
		cardAttachmentField.setRequired(false);
		cardAttachmentField.setHidden(false);


		educationProofIdField = new DataSourceIntegerField("educationProofId", "学历证编码");
		educationProofIdField.setLength(11);
		educationProofIdField.setRequired(false);
		educationProofIdField.setHidden(false);


		degreeProofIdField = new DataSourceIntegerField("degreeProofId", "学位证编码");
		degreeProofIdField.setLength(11);
		degreeProofIdField.setRequired(false);
		degreeProofIdField.setHidden(false);


		laborAttachmentsField = new DataSourceTextField("laborAttachments", "劳动合同附件");
		laborAttachmentsField.setLength(128);
		laborAttachmentsField.setRequired(false);
		laborAttachmentsField.setHidden(false);


		setFields(employeeIdField, employeeNoField, employeeNameField, departmentIdField,genderField, employeeNameEnField, fileNumberField, cardField, mobileField, countryField, birthplaceField, accountLocationField, householdRegistrationField, nationalityField, marriedStatusField, politicalFaceField, educationProofField, degreeProofField, startWorkDateField, onboardDateField, positiveDateField, personalBusinessRemarkField, contractStartDateField, contractEndDateField, ownedCompanyField, dutyIdField, socialComputerNumberField, fundAccountField, bankCardNumField, workYearTypeField, emergencyContactPersonField, emergencyContactPhoneField, cardAddressField, graduatedSchoolField, specialtyField, learningWayField, cardAttachmentField, educationProofIdField, degreeProofIdField, laborAttachmentsField);
	}


}

