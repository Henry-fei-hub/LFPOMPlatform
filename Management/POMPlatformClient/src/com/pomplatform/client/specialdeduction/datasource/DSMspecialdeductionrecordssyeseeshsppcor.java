package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMspecialdeductionrecordssyeseeshsppcor extends DBDataSource
{


	public static DSMspecialdeductionrecordssyeseeshsppcor instance = null;

	public static DSMspecialdeductionrecordssyeseeshsppcor getInstance() {
		if(instance == null) {
			instance = new DSMspecialdeductionrecordssyeseeshsppcor("DSMspecialdeductionrecordssyeseeshsppcor");
		}
		return instance;
	}

	private final DataSourceIntegerField specialDeductionRecordIdField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceDateTimeField createDateField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField specialDeductionDetailIdField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField schoolingField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceFloatField deductionPercentageField;
	private final DataSourceFloatField amountField;
	private final DataSourceIntegerField numField;
	private final DataSourceIntegerField educationTypeField;
	private final DataSourceIntegerField educationStageField;
	private final DataSourceIntegerField houseFirstField;
	private final DataSourceIntegerField singleChildField;
	private final DataSourceIntegerField specialDeductionTypeIdField;
	private final DataSourceTextField cityField;
	private final DataSourceIntegerField processStatusField;

	public DSMspecialdeductionrecordssyeseeshsppcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mspecialdeductionrecordssyeseeshsppcor");


		specialDeductionRecordIdField = new DataSourceIntegerField("specialDeductionRecordId", "id");
		specialDeductionRecordIdField.setLength(11);
		specialDeductionRecordIdField.setPrimaryKey(true);
		specialDeductionRecordIdField.setRequired(true);
		specialDeductionRecordIdField.setHidden(true);


		employeIdField = new DataSourceIntegerField("employeId", "纳税申请人");
		employeIdField.setLength(11);
		employeIdField.setRequired(true);
		employeIdField.setHidden(false);
		employeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNameField = new DataSourceTextField("employeeName", "扣除年度");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);


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
		isEnableField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


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
		schoolingField.setHidden(false);
		schoolingField.setValueMap(KeyValueManager.getValueMap("system_dictionary_218"));


		startDateField = new DataSourceDateField("startDate", "开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "结束时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		deductionPercentageField = new DataSourceFloatField("deductionPercentage", "本人扣除比例");
		deductionPercentageField.setLength(10);
		deductionPercentageField.setDecimalPad(2);
		deductionPercentageField.setFormat("##,###,##0.00");
		deductionPercentageField.setRequired(false);
		deductionPercentageField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "抵扣金额");
		amountField.setLength(10);
		amountField.setDecimalPad(2);
		amountField.setFormat("##,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		numField = new DataSourceIntegerField("num", "子女人数/老人人数");
		numField.setLength(11);
		numField.setRequired(false);
		numField.setHidden(false);


		educationTypeField = new DataSourceIntegerField("educationType", "继续教育类型");
		educationTypeField.setLength(11);
		educationTypeField.setRequired(false);
		educationTypeField.setHidden(false);
		educationTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_221"));


		educationStageField = new DataSourceIntegerField("educationStage", "教育阶段");
		educationStageField.setLength(11);
		educationStageField.setRequired(false);
		educationStageField.setHidden(false);
		educationStageField.setValueMap(KeyValueManager.getValueMap("system_dictionary_218"));


		houseFirstField = new DataSourceIntegerField("houseFirst", "是否首套房");
		houseFirstField.setLength(11);
		houseFirstField.setRequired(false);
		houseFirstField.setHidden(false);
		houseFirstField.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));


		singleChildField = new DataSourceIntegerField("singleChild", "是否独生");
		singleChildField.setLength(11);
		singleChildField.setRequired(false);
		singleChildField.setHidden(false);
		singleChildField.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));


		specialDeductionTypeIdField = new DataSourceIntegerField("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdField.setLength(11);
		specialDeductionTypeIdField.setRequired(false);
		specialDeductionTypeIdField.setHidden(false);
		specialDeductionTypeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_223"));
		
		cityField = new DataSourceTextField("city", "租房城市");
		cityField.setLength(64);
		cityField.setRequired(false);
		cityField.setHidden(false);
		cityField.setValueMap(KeyValueManager.getValueMap("system_dictionary_228"));


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));

		setFields(specialDeductionRecordIdField, specialDeductionDetailIdField, employeIdField, employeeNameField, plateIdField, companyIdField, isEnableField, remarkField, parentIdField, schoolingField, startDateField, endDateField, deductionPercentageField, amountField, numField, educationTypeField, educationStageField, houseFirstField, singleChildField, specialDeductionTypeIdField, cityField, processStatusField, createDateField);
	}


}

