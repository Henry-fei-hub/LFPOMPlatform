package com.pomplatform.client.workflow.personnel.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSApplicationForFiling extends DBDataSource
{


	public static DSApplicationForFiling instance = null;

	public static DSApplicationForFiling getInstance() {
		if(instance == null) {
			instance = new DSApplicationForFiling("DSApplicationForFiling");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceDateField birthField;
	private final DataSourceIntegerField ageField;
	private final DataSourceDateField startWorkDateField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceTextField graduatedSchoolField;
	private final DataSourceTextField specialtyField;
	private final DataSourceTextField cardAttachmentField;
	private final DataSourceTextField technicalAttachmentField;
	private final DataSourceTextField educationProofField;

	public DSApplicationForFiling(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ApplicationForFiling");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工工号");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		birthField = new DataSourceDateField("birth", "出生日期");
		birthField.setRequired(false);
		birthField.setHidden(false);


		ageField = new DataSourceIntegerField("age", "年龄");
		ageField.setLength(11);
		ageField.setRequired(false);
		ageField.setHidden(false);


		startWorkDateField = new DataSourceDateField("startWorkDate", "参加工作时间");
		startWorkDateField.setRequired(false);
		startWorkDateField.setHidden(false);


		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		graduatedSchoolField = new DataSourceTextField("graduatedSchool", "毕业院校");
		graduatedSchoolField.setLength(64);
		graduatedSchoolField.setRequired(false);
		graduatedSchoolField.setHidden(false);


		specialtyField = new DataSourceTextField("specialty", "所学专业");
		specialtyField.setLength(64);
		specialtyField.setRequired(false);
		specialtyField.setHidden(false);


		cardAttachmentField = new DataSourceTextField("cardAttachment", "身份证附件");
		cardAttachmentField.setLength(128);
		cardAttachmentField.setRequired(false);
		cardAttachmentField.setHidden(false);
		cardAttachmentField.setCanEdit(true);



		technicalAttachmentField = new DataSourceTextField("technicalAttachment", "职称证明附件");
		technicalAttachmentField.setLength(128);
		technicalAttachmentField.setRequired(false);
		technicalAttachmentField.setHidden(false);


		educationProofField = new DataSourceTextField("educationProof", "学历证附件");
		educationProofField.setLength(128);
		educationProofField.setRequired(false);
		educationProofField.setHidden(false);


		setFields(employeeIdField, employeeNameField, birthField, ageField, startWorkDateField, onboardDateField, graduatedSchoolField, specialtyField, cardAttachmentField, technicalAttachmentField, educationProofField);
	}


}

