package com.pomplatform.client.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSspecialdeductionrecordsssor extends DataSource
{


	public static CDSspecialdeductionrecordsssor instance = null;

	public static CDSspecialdeductionrecordsssor getInstance() {
		if(instance == null) {
			instance = new CDSspecialdeductionrecordsssor("CDSspecialdeductionrecordsssor");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField reasonField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceIntegerField deparmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField specialDeductionRecordIdField;
	private final DataSourceTextField specialDeductionRecordNameField;
	private final DataSourceIntegerField specialDeductionTypeField;
	private final DataSourceIntegerField specialDeductionEducationField;
	private final DataSourceIntegerField specialDeductionSupOldField;
	private final DataSourceIntegerField specialDeductionIdField;
	private final DataSourceTextField alternateField1Field;
	private final DataSourceTextField alternateField2Field;
	private final DataSourceTextField alternateField3Field;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;

	public CDSspecialdeductionrecordsssor(String dataSourceID) {

		setID(dataSourceID);
		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		reasonField = new DataSourceTextField("reason", "原因");
		reasonField.setRequired(false);
		reasonField.setLength(512);
		reasonField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(512);
		remarkField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		employeIdField = new DataSourceIntegerField("employeId", "申请人");
		employeIdField.setRequired(false);
		employeIdField.setLength(11);
		employeIdField.setHidden(false);

		deparmentIdField = new DataSourceIntegerField("deparmentId", "部门");
		deparmentIdField.setRequired(false);
		deparmentIdField.setLength(11);
		deparmentIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		specialDeductionRecordIdField = new DataSourceIntegerField("specialDeductionRecordId", "编码");
		specialDeductionRecordIdField.setRequired(true);
		specialDeductionRecordIdField.setLength(11);
		specialDeductionRecordIdField.setPrimaryKey(true);
		specialDeductionRecordIdField.setHidden(true);

		specialDeductionRecordNameField = new DataSourceTextField("specialDeductionRecordName", "名字");
		specialDeductionRecordNameField.setRequired(true);
		specialDeductionRecordNameField.setLength(64);
		specialDeductionRecordNameField.setHidden(false);

		specialDeductionTypeField = new DataSourceIntegerField("specialDeductionType", "类型");
		specialDeductionTypeField.setRequired(false);
		specialDeductionTypeField.setLength(11);
		specialDeductionTypeField.setHidden(false);

		specialDeductionEducationField = new DataSourceIntegerField("specialDeductionEducation", "教育类型");
		specialDeductionEducationField.setRequired(false);
		specialDeductionEducationField.setLength(11);
		specialDeductionEducationField.setHidden(false);

		specialDeductionSupOldField = new DataSourceIntegerField("specialDeductionSupOld", "是否独生");
		specialDeductionSupOldField.setRequired(false);
		specialDeductionSupOldField.setLength(11);
		specialDeductionSupOldField.setHidden(false);

		specialDeductionIdField = new DataSourceIntegerField("specialDeductionId", "file编码");
		specialDeductionIdField.setRequired(false);
		specialDeductionIdField.setLength(11);
		specialDeductionIdField.setHidden(false);

		alternateField1Field = new DataSourceTextField("alternateField1", "备用字段1");
		alternateField1Field.setRequired(false);
		alternateField1Field.setLength(512);
		alternateField1Field.setHidden(false);

		alternateField2Field = new DataSourceTextField("alternateField2", "备用字段2");
		alternateField2Field.setRequired(false);
		alternateField2Field.setLength(512);
		alternateField2Field.setHidden(false);

		alternateField3Field = new DataSourceTextField("alternateField3", "备用字段3");
		alternateField3Field.setRequired(false);
		alternateField3Field.setLength(512);
		alternateField3Field.setHidden(false);

		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "开始时间");
		startDateField.setRequired(true);
		startDateField.setLength(0);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "结束时间");
		endDateField.setRequired(true);
		endDateField.setLength(0);
		endDateField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(employeeNoField, reasonField, remarkField, processTypeField, employeIdField, deparmentIdField, companyIdField, specialDeductionRecordIdField, specialDeductionRecordNameField, specialDeductionTypeField, specialDeductionEducationField, specialDeductionSupOldField, specialDeductionIdField, alternateField1Field, alternateField2Field, alternateField3Field, isEnableField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

