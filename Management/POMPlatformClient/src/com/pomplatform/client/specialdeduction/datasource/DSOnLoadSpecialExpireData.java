package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadSpecialExpireData extends DBDataSource
{


	public static DSOnLoadSpecialExpireData instance = null;

	public static DSOnLoadSpecialExpireData getInstance() {
		if(instance == null) {
			instance = new DSOnLoadSpecialExpireData("DSOnLoadSpecialExpireData");
		}
		return instance;
	}

	private final DataSourceIntegerField specialDeductionRecordIdField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceIntegerField deparmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField yearField;
	private final DataSourceIntegerField specialDeductionTypeIdField;
	private final DataSourceTextField specialDeductionTypeNameField;
	private final DataSourceDateTimeField createDateField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField processStatusField;

	public DSOnLoadSpecialExpireData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadSpecialExpireData");


		specialDeductionRecordIdField = new DataSourceIntegerField("specialDeductionRecordId", "id");
		specialDeductionRecordIdField.setLength(11);
		specialDeductionRecordIdField.setPrimaryKey(true);
		specialDeductionRecordIdField.setRequired(true);
		specialDeductionRecordIdField.setHidden(false);


		employeIdField = new DataSourceIntegerField("employeId", "纳税人id");
		employeIdField.setLength(11);
		employeIdField.setRequired(true);
		employeIdField.setHidden(false);


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


		yearField = new DataSourceTextField("year", "扣除年度");
		yearField.setLength(32);
		yearField.setRequired(false);
		yearField.setHidden(false);


		specialDeductionTypeIdField = new DataSourceIntegerField("specialDeductionTypeId", "专项类型");
		specialDeductionTypeIdField.setLength(11);
		specialDeductionTypeIdField.setRequired(false);
		specialDeductionTypeIdField.setHidden(false);


		specialDeductionTypeNameField = new DataSourceTextField("specialDeductionTypeName", "专项扣款类型名称");
		specialDeductionTypeNameField.setLength(64);
		specialDeductionTypeNameField.setRequired(true);
		specialDeductionTypeNameField.setHidden(false);


		createDateField = new DataSourceDateTimeField("createDate", "创建时间");
		createDateField.setRequired(false);
		createDateField.setHidden(false);


		startDateField = new DataSourceDateField("startDate", "有效开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "有效结束时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);


		setFields(specialDeductionRecordIdField, employeIdField, deparmentIdField, plateIdField, companyIdField, yearField, specialDeductionTypeIdField, specialDeductionTypeNameField, createDateField, startDateField, endDateField, processStatusField);
	}


}

