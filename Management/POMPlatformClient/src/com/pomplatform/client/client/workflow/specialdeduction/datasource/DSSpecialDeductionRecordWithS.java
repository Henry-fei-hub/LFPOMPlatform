package com.pomplatform.client.client.workflow.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSpecialDeductionRecordWithS extends DBDataSource
{


	public static DSSpecialDeductionRecordWithS instance = null;

	public static DSSpecialDeductionRecordWithS getInstance() {
		if(instance == null) {
			instance = new DSSpecialDeductionRecordWithS("DSSpecialDeductionRecordWithS");
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
	private final DataSourceDateTimeField createDateField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceTextField remarkField;
	private final DataSourceField detailSpecialDeductionDetail;

	public DSSpecialDeductionRecordWithS(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SpecialDeductionRecordWithS");


		specialDeductionRecordIdField = new DataSourceIntegerField("specialDeductionRecordId", "id");
		specialDeductionRecordIdField.setLength(11);
		specialDeductionRecordIdField.setPrimaryKey(true);
		specialDeductionRecordIdField.setRequired(true);
		specialDeductionRecordIdField.setHidden(false);


		employeIdField = new DataSourceIntegerField("employeId", "纳税人id");
		employeIdField.setLength(11);
		employeIdField.setRequired(true);
		employeIdField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "纳税人名字");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);


		startDateField = new DataSourceDateField("startDate", "有效开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "有效结束时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);


		deparmentIdField = new DataSourceIntegerField("deparmentId", "部门");
		deparmentIdField.setLength(11);
		deparmentIdField.setRequired(false);
		deparmentIdField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);


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

		detailSpecialDeductionDetail = new DataSourceField("detailSpecialDeductionDetail", FieldType.ANY);
		detailSpecialDeductionDetail.setChildrenProperty(true);
		detailSpecialDeductionDetail.setChildTagName("SpecialDeductionDetail");
		detailSpecialDeductionDetail.setRequired(false);
		detailSpecialDeductionDetail.setHidden(true);

		setFields(specialDeductionRecordIdField, employeIdField, employeeNameField, startDateField, endDateField, processTypeField, deparmentIdField, plateIdField, companyIdField, createDateField, isEnableField, remarkField, detailSpecialDeductionDetail);
	}


}

