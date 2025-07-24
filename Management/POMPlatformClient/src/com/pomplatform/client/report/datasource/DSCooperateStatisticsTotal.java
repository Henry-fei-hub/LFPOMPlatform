package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCooperateStatisticsTotal extends DBDataSource
{


	public static DSCooperateStatisticsTotal instance = null;

	public static DSCooperateStatisticsTotal getInstance() {
		if(instance == null) {
			instance = new DSCooperateStatisticsTotal("DSCooperateStatisticsTotal");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceTextField subTypeField;
	private final DataSourceIntegerField settlementIntegralField;
	private final DataSourceDateTimeField startDateField;

	public DSCooperateStatisticsTotal(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CooperateStatisticsTotal");


		projectIdField = new DataSourceIntegerField("projectId", "项目主键");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(255);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		drafterField = new DataSourceIntegerField("drafter", "申请人");
		drafterField.setLength(11);
		drafterField.setRequired(false);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		typeField = new DataSourceIntegerField("type", "配合部门");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("departments"));


		projectTypeField = new DataSourceIntegerField("projectType", "专业");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("pm_specials"));

		subTypeField = new DataSourceTextField("subType", "产值");
		subTypeField.setLength(255);
		subTypeField.setRequired(false);
		subTypeField.setHidden(false);


		settlementIntegralField = new DataSourceIntegerField("settlementIntegral", "已结算配合产值");
		settlementIntegralField.setLength(11);
		settlementIntegralField.setRequired(true);
		settlementIntegralField.setHidden(false);


		startDateField = new DataSourceDateTimeField("startDate", "提交时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);


		setFields(projectIdField, projectCodeField, projectNameField, drafterField, departmentIdField, typeField, projectTypeField, subTypeField, settlementIntegralField, startDateField);
	}


}

