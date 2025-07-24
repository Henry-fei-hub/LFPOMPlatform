package com.pomplatform.client.client.workflow.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSpecialDeductionInformation extends DBDataSource
{


	public static DSSpecialDeductionInformation instance = null;

	public static DSSpecialDeductionInformation getInstance() {
		if(instance == null) {
			instance = new DSSpecialDeductionInformation("DSSpecialDeductionInformation");
		}
		return instance;
	}

	private final DataSourceIntegerField specialDeductionRecordIdField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceDateTimeField createDateField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField specialDeductionDetailIdField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField schoolingField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceDateTimeField endTimeField;
	private final DataSourceFloatField deductionPercentageField;
	private final DataSourceFloatField amountField;
	private final DataSourceIntegerField numField;
	private final DataSourceIntegerField educationTypeField;
	private final DataSourceIntegerField educationStageField;
	private final DataSourceIntegerField houseFirstField;
	private final DataSourceIntegerField singleChildField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField cityField;
	private final DataSourceIntegerField specialDeductionTypeIdField;
	private final DataSourceTextField specialDeductionTypeNameField;

	public DSSpecialDeductionInformation(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SpecialDeductionInformation");


		specialDeductionRecordIdField = new DataSourceIntegerField("specialDeductionRecordId", "id");
		specialDeductionRecordIdField.setLength(11);
		specialDeductionRecordIdField.setPrimaryKey(true);
		specialDeductionRecordIdField.setRequired(true);
		specialDeductionRecordIdField.setHidden(true);


		employeIdField = new DataSourceIntegerField("employeId", "纳税人申请人");
		employeIdField.setLength(11);
		employeIdField.setRequired(true);
		employeIdField.setHidden(false);
		employeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		startDateField = new DataSourceDateField("startDate", "有效开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(true);


		endDateField = new DataSourceDateField("endDate", "有效结束时间");
		endDateField.setRequired(false);
		endDateField.setHidden(true);


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

		createDateField = new DataSourceDateTimeField("createDate", "创建时间");
		createDateField.setRequired(false);
		createDateField.setHidden(false);


		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);
		
		
		employeeNameField = new DataSourceTextField("employeeName", "扣除年度");
		employeeNameField.setLength(512);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);


		specialDeductionDetailIdField = new DataSourceIntegerField("specialDeductionDetailId", "id");
		specialDeductionDetailIdField.setLength(11);
		specialDeductionDetailIdField.setPrimaryKey(true);
		specialDeductionDetailIdField.setRequired(true);
		specialDeductionDetailIdField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "父id");
		parentIdField.setLength(11);
		parentIdField.setRequired(true);
		parentIdField.setHidden(true);


		schoolingField = new DataSourceIntegerField("schooling", "当前受教育阶段");
		schoolingField.setLength(11);
		schoolingField.setRequired(false);
		schoolingField.setHidden(true);


		startTimeField = new DataSourceDateTimeField("startTime", "startTime");
		startTimeField.setRequired(true);
		startTimeField.setHidden(true);


		endTimeField = new DataSourceDateTimeField("endTime", "endTime");
		endTimeField.setRequired(true);
		endTimeField.setHidden(true);


		deductionPercentageField = new DataSourceFloatField("deductionPercentage", "本人扣除比例");
		deductionPercentageField.setLength(10);
		deductionPercentageField.setDecimalPad(2);
		deductionPercentageField.setFormat("##,###,##0.00");
		deductionPercentageField.setRequired(false);
		deductionPercentageField.setHidden(true);


		amountField = new DataSourceFloatField("amount", "金额(基数)");
		amountField.setLength(10);
		amountField.setDecimalPad(2);
		amountField.setFormat("##,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(true);


		numField = new DataSourceIntegerField("num", "个数");
		numField.setLength(11);
		numField.setRequired(false);
		numField.setHidden(true);


		educationTypeField = new DataSourceIntegerField("educationType", "继续教育类型");
		educationTypeField.setLength(11);
		educationTypeField.setRequired(false);
		educationTypeField.setHidden(true);


		educationStageField = new DataSourceIntegerField("educationStage", "教育阶段");
		educationStageField.setLength(11);
		educationStageField.setRequired(false);
		educationStageField.setHidden(true);


		houseFirstField = new DataSourceIntegerField("houseFirst", "是否婚前各自首套贷款且婚后分别扣除50%");
		houseFirstField.setLength(11);
		houseFirstField.setRequired(false);
		houseFirstField.setHidden(true);


		singleChildField = new DataSourceIntegerField("singleChild", "是否独生");
		singleChildField.setLength(11);
		singleChildField.setRequired(false);
		singleChildField.setHidden(true);


		yearField = new DataSourceTextField("year", "扣除年度");
		yearField.setLength(32);
		yearField.setRequired(false);
		yearField.setHidden(true);


		cityField = new DataSourceTextField("city", "租房城市");
		cityField.setLength(64);
		cityField.setRequired(false);
		cityField.setHidden(true);


		specialDeductionTypeIdField = new DataSourceIntegerField("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdField.setLength(11);
		specialDeductionTypeIdField.setRequired(false);
		specialDeductionTypeIdField.setHidden(true);


		specialDeductionTypeNameField = new DataSourceTextField("specialDeductionTypeName", "专项扣款类型名称");
		specialDeductionTypeNameField.setLength(64);
		specialDeductionTypeNameField.setRequired(true);
		specialDeductionTypeNameField.setHidden(true);


		setFields(specialDeductionRecordIdField, specialDeductionDetailIdField, employeIdField,employeeNameField, startDateField, endDateField, plateIdField, companyIdField, createDateField, isEnableField, remarkField, parentIdField, schoolingField, startTimeField, endTimeField, deductionPercentageField, amountField, numField, educationTypeField, educationStageField, houseFirstField, singleChildField, yearField, cityField, specialDeductionTypeIdField, specialDeductionTypeNameField);
	}


}

