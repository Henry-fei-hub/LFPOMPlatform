package com.pomplatform.client.client.workflow.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSpecialDeductionDetail extends DBDataSource
{


	public static DSSpecialDeductionDetail instance = null;

	public static DSSpecialDeductionDetail getInstance() {
		if(instance == null) {
			instance = new DSSpecialDeductionDetail("DSSpecialDeductionDetail");
		}
		return instance;
	}

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
	private final DataSourceTextField yearField;
	private final DataSourceIntegerField specialDeductionTypeIdField;
	private final DataSourceDateTimeField createDateField;
	private final DataSourceTextField cityField;

	public DSSpecialDeductionDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("SpecialDeductionDetail");


		specialDeductionDetailIdField = new DataSourceIntegerField("specialDeductionDetailId", "id");
		specialDeductionDetailIdField.setLength(11);
		specialDeductionDetailIdField.setPrimaryKey(true);
		specialDeductionDetailIdField.setRequired(true);
		specialDeductionDetailIdField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父id");
		parentIdField.setLength(11);
		parentIdField.setRequired(true);
		parentIdField.setHidden(false);


		schoolingField = new DataSourceIntegerField("schooling", "当前受教育阶段");
		schoolingField.setLength(11);
		schoolingField.setRequired(false);
		schoolingField.setHidden(false);


		startDateField = new DataSourceDateField("startDate", "起始时间");
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


		amountField = new DataSourceFloatField("amount", "金额(基数)");
		amountField.setLength(10);
		amountField.setDecimalPad(2);
		amountField.setFormat("##,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		numField = new DataSourceIntegerField("num", "个数");
		numField.setLength(11);
		numField.setRequired(false);
		numField.setHidden(false);


		educationTypeField = new DataSourceIntegerField("educationType", "继续教育类型");
		educationTypeField.setLength(11);
		educationTypeField.setRequired(false);
		educationTypeField.setHidden(false);


		educationStageField = new DataSourceIntegerField("educationStage", "教育阶段");
		educationStageField.setLength(11);
		educationStageField.setRequired(false);
		educationStageField.setHidden(false);


		houseFirstField = new DataSourceIntegerField("houseFirst", "是否婚前各自首套贷款且婚后分别扣除50%");
		houseFirstField.setLength(11);
		houseFirstField.setRequired(false);
		houseFirstField.setHidden(false);


		singleChildField = new DataSourceIntegerField("singleChild", "是否独生");
		singleChildField.setLength(11);
		singleChildField.setRequired(false);
		singleChildField.setHidden(false);


		yearField = new DataSourceTextField("year", "扣除年度");
		yearField.setLength(32);
		yearField.setRequired(false);
		yearField.setHidden(false);


		specialDeductionTypeIdField = new DataSourceIntegerField("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdField.setLength(11);
		specialDeductionTypeIdField.setRequired(false);
		specialDeductionTypeIdField.setHidden(false);


		createDateField = new DataSourceDateTimeField("createDate", "创建时间");
		createDateField.setRequired(false);
		createDateField.setHidden(false);


		cityField = new DataSourceTextField("city", "租房城市");
		cityField.setLength(64);
		cityField.setRequired(false);
		cityField.setHidden(true);


		setFields(specialDeductionDetailIdField, parentIdField, schoolingField, startDateField, endDateField, deductionPercentageField, amountField, numField, educationTypeField, educationStageField, houseFirstField, singleChildField, yearField, specialDeductionTypeIdField, createDateField, cityField);
	}


}

