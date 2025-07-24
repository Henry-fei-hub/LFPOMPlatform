package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSspecialdeductionrecordsssor extends DBDataSource
{


	public static DSSspecialdeductionrecordsssor instance = null;

	public static DSSspecialdeductionrecordsssor getInstance() {
		if(instance == null) {
			instance = new DSSspecialdeductionrecordsssor("DSSspecialdeductionrecordsssor");
		}
		return instance;
	}

	private final DataSourceIntegerField specialDeductionRecordIdField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField deparmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField documentTypeField;
	private final DataSourceTextField identificationNumberField;
	private final DataSourceTextField phoneField;
	private final DataSourceTextField taxpayerRegistrationNumberField;
	private final DataSourceTextField addressField;
	private final DataSourceTextField emailField;
	private final DataSourceIntegerField withholdIdField;
	private final DataSourceTextField withholdNameField;
	private final DataSourceTextField withholdRegistrationNumberField;
	private final DataSourceIntegerField spouseSituationField;
	private final DataSourceTextField spouseNameField;
	private final DataSourceIntegerField spouseDocumentTypeField;
	private final DataSourceTextField spouseIdentificationNumberField;
	private final DataSourceDateTimeField createDateField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceTextField remarkField;

	public DSSspecialdeductionrecordsssor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sspecialdeductionrecordsssor");


		specialDeductionRecordIdField = new DataSourceIntegerField("specialDeductionRecordId", "id");
		specialDeductionRecordIdField.setLength(11);
		specialDeductionRecordIdField.setPrimaryKey(true);
		specialDeductionRecordIdField.setRequired(true);
		specialDeductionRecordIdField.setHidden(true);


		employeIdField = new DataSourceIntegerField("employeId", "纳税人");
		employeIdField.setLength(11);
		employeIdField.setRequired(true);
		employeIdField.setHidden(false);
		employeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNameField = new DataSourceTextField("employeeName", "纳税人名字");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(true);


		startDateField = new DataSourceDateField("startDate", "有效开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		endDateField = new DataSourceDateField("endDate", "有效结束时间");
		endDateField.setRequired(false);
		endDateField.setHidden(true);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		deparmentIdField = new DataSourceIntegerField("deparmentId", "部门");
		deparmentIdField.setLength(11);
		deparmentIdField.setRequired(false);
		deparmentIdField.setHidden(false);
		deparmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));
		
		documentTypeField = new DataSourceIntegerField("documentType", "身份证件类型");
		documentTypeField.setLength(11);
		documentTypeField.setRequired(true);
		documentTypeField.setHidden(false);
		documentTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));
		

		identificationNumberField = new DataSourceTextField("identificationNumber", "纳税人身份证件号码");
		identificationNumberField.setLength(64);
		identificationNumberField.setRequired(true);
		identificationNumberField.setHidden(false);

		phoneField = new DataSourceTextField("phone", "手机号码");
		phoneField.setLength(11);
		phoneField.setRequired(true);
		phoneField.setHidden(false);


		taxpayerRegistrationNumberField = new DataSourceTextField("taxpayerRegistrationNumber", "纳税人识别号");
		taxpayerRegistrationNumberField.setLength(64);
		taxpayerRegistrationNumberField.setRequired(false);
		taxpayerRegistrationNumberField.setHidden(false);


		addressField = new DataSourceTextField("address", "联系地址");
		addressField.setLength(64);
		addressField.setRequired(false);
		addressField.setHidden(false);


		emailField = new DataSourceTextField("email", "邮箱");
		emailField.setLength(64);
		emailField.setRequired(false);
		emailField.setHidden(false);


		withholdIdField = new DataSourceIntegerField("withholdId", "扣缴义务人id");
		withholdIdField.setLength(11);
		withholdIdField.setRequired(false);
		withholdIdField.setHidden(true);


		withholdNameField = new DataSourceTextField("withholdName", "扣缴义务人名称");
		withholdNameField.setLength(64);
		withholdNameField.setRequired(false);
		withholdNameField.setHidden(false);


		withholdRegistrationNumberField = new DataSourceTextField("withholdRegistrationNumber", "扣缴义务人纳税人识别号");
		withholdRegistrationNumberField.setLength(64);
		withholdRegistrationNumberField.setRequired(false);
		withholdRegistrationNumberField.setHidden(false);


		spouseSituationField = new DataSourceIntegerField("spouseSituation", "配偶情况");
		spouseSituationField.setLength(11);
		spouseSituationField.setRequired(false);
		spouseSituationField.setHidden(false);
		spouseSituationField.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));

		spouseNameField = new DataSourceTextField("spouseName", "配偶名称");
		spouseNameField.setLength(64);
		spouseNameField.setRequired(false);
		spouseNameField.setHidden(false);


		spouseDocumentTypeField = new DataSourceIntegerField("spouseDocumentType", "配偶身份证件类型");
		spouseDocumentTypeField.setLength(11);
		spouseDocumentTypeField.setRequired(false);
		spouseDocumentTypeField.setHidden(false);
		spouseDocumentTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_222"));
		

		spouseIdentificationNumberField = new DataSourceTextField("spouseIdentificationNumber", "配偶身份证件号码");
		spouseIdentificationNumberField.setLength(64);
		spouseIdentificationNumberField.setRequired(false);
		spouseIdentificationNumberField.setHidden(false);


		createDateField = new DataSourceDateTimeField("createDate", "创建时间");
		createDateField.setRequired(false);
		createDateField.setHidden(false);


		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(specialDeductionRecordIdField, employeIdField, employeeNameField, startDateField, endDateField, processTypeField, deparmentIdField, plateIdField, companyIdField, documentTypeField, identificationNumberField, phoneField, taxpayerRegistrationNumberField, addressField, emailField, withholdIdField, withholdNameField, withholdRegistrationNumberField, spouseSituationField, spouseNameField, spouseDocumentTypeField, spouseIdentificationNumberField, createDateField, isEnableField, remarkField);
	}


}

