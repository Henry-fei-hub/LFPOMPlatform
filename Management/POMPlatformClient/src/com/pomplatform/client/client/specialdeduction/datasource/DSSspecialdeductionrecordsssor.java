package com.pomplatform.client.client.specialdeduction.datasource;

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
	private final DataSourceTextField specialDeductionRecordNameField;
	private final DataSourceFloatField amountField;
	private final DataSourceIntegerField numField;
	private final DataSourceIntegerField specialDeductionTypeField;
	private final DataSourceTextField specialDeductionTimeField;
	private final DataSourceIntegerField specialDeductionEducationField;
	private final DataSourceFloatField educationAmountField;
	private final DataSourceIntegerField specialDeductionSupOldField;
	private final DataSourceFloatField supOldAmountField;
	private final DataSourceIntegerField specialDeductionIdField;
	private final DataSourceTextField specialDeductionFileUrlField;
	private final DataSourceTextField alternateField1Field;
	private final DataSourceTextField alternateField2Field;
	private final DataSourceTextField alternateField3Field;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceDateTimeField createDateField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField deparmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField reasonField;
	private final DataSourceTextField remarkField;

	public DSSspecialdeductionrecordsssor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sspecialdeductionrecordsssor");


		specialDeductionRecordIdField = new DataSourceIntegerField("specialDeductionRecordId", "编码");
		specialDeductionRecordIdField.setLength(11);
		specialDeductionRecordIdField.setPrimaryKey(true);
		specialDeductionRecordIdField.setRequired(true);
		specialDeductionRecordIdField.setHidden(true);


		specialDeductionRecordNameField = new DataSourceTextField("specialDeductionRecordName", "名字");
		specialDeductionRecordNameField.setLength(64);
		specialDeductionRecordNameField.setRequired(true);
		specialDeductionRecordNameField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "基数");
		amountField.setLength(10);
		amountField.setDecimalPad(2);
		amountField.setFormat("##,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		numField = new DataSourceIntegerField("num", "个数");
		numField.setLength(11);
		numField.setRequired(false);
		numField.setHidden(true);


		specialDeductionTypeField = new DataSourceIntegerField("specialDeductionType", "类型");
		specialDeductionTypeField.setLength(11);
		specialDeductionTypeField.setRequired(false);
		specialDeductionTypeField.setHidden(false);
		specialDeductionTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_215"));

		specialDeductionTimeField = new DataSourceTextField("specialDeductionTime", "最长时间跨度");
		specialDeductionTimeField.setLength(64);
		specialDeductionTimeField.setRequired(false);
		specialDeductionTimeField.setHidden(true);


		specialDeductionEducationField = new DataSourceIntegerField("specialDeductionEducation", "教育类型");
		specialDeductionEducationField.setLength(11);
		specialDeductionEducationField.setRequired(false);
		specialDeductionEducationField.setHidden(false);
		specialDeductionEducationField.setValueMap(KeyValueManager.getValueMap("system_dictionary_216"));


		educationAmountField = new DataSourceFloatField("educationAmount", "教育金额");
		educationAmountField.setLength(10);
		educationAmountField.setDecimalPad(2);
		educationAmountField.setFormat("##,###,##0.00");
		educationAmountField.setRequired(false);
		educationAmountField.setHidden(false);


		specialDeductionSupOldField = new DataSourceIntegerField("specialDeductionSupOld", "是否独生");
		specialDeductionSupOldField.setLength(11);
		specialDeductionSupOldField.setRequired(false);
		specialDeductionSupOldField.setHidden(false);
		specialDeductionSupOldField.setValueMap(KeyValueManager.getValueMap("system_dictionary_200"));


		supOldAmountField = new DataSourceFloatField("supOldAmount", "赡养分摊金额");
		supOldAmountField.setLength(10);
		supOldAmountField.setDecimalPad(2);
		supOldAmountField.setFormat("##,###,##0.00");
		supOldAmountField.setRequired(false);
		supOldAmountField.setHidden(false);


		specialDeductionIdField = new DataSourceIntegerField("specialDeductionId", "file编码");
		specialDeductionIdField.setLength(11);
		specialDeductionIdField.setRequired(false);
		specialDeductionIdField.setHidden(true);


		specialDeductionFileUrlField = new DataSourceTextField("specialDeductionFileUrl", "fileurl");
		specialDeductionFileUrlField.setLength(64);
		specialDeductionFileUrlField.setRequired(false);
		specialDeductionFileUrlField.setHidden(true);


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


		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);
		
		startDateField = new DataSourceDateField("startDate", "有效开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "有效结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		createDateField = new DataSourceDateTimeField("createDate", "创建日期");
		createDateField.setRequired(false);
		createDateField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		employeIdField = new DataSourceIntegerField("employeId", "申请人");
		employeIdField.setLength(11);
		employeIdField.setRequired(false);
		employeIdField.setHidden(false);
		employeIdField.setCanEdit(false);
		employeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);


		deparmentIdField = new DataSourceIntegerField("deparmentId", "部门");
		deparmentIdField.setLength(11);
		deparmentIdField.setRequired(false);
		deparmentIdField.setHidden(false);
		deparmentIdField.setCanEdit(false);
		deparmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setCanEdit(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		reasonField = new DataSourceTextField("reason", "原因");
		reasonField.setLength(512);
		reasonField.setRequired(false);
		reasonField.setHidden(false);
		reasonField.setCanEdit(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		remarkField.setCanEdit(false);

		setFields(specialDeductionRecordIdField, specialDeductionRecordNameField, amountField, numField, specialDeductionTypeField, specialDeductionTimeField, specialDeductionEducationField, educationAmountField, specialDeductionSupOldField, supOldAmountField, specialDeductionIdField, specialDeductionFileUrlField, alternateField1Field, alternateField2Field, alternateField3Field, startDateField, endDateField ,createDateField, processTypeField, employeIdField, employeeNoField, deparmentIdField, companyIdField, reasonField, remarkField, isEnableField);
	}


}

