package com.pomplatform.client.manageproject.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSManageProject extends DBDataSource {

	public static DSManageProject instance = null;

	public static DSManageProject getInstance() {
		if (instance == null) {
			instance = new DSManageProject("DSManageProject");
		}
		return instance;
	}

	private final DataSourceIntegerField manageProjectIdField;
	private final DataSourceTextField manageProjectNameField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField remarkField;

	public DSManageProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ManageProject");

		manageProjectIdField = new DataSourceIntegerField("manageProjectId", "主键编码");
		manageProjectIdField.setLength(11);
		manageProjectIdField.setPrimaryKey(true);
		manageProjectIdField.setRequired(true);
		manageProjectIdField.setHidden(true);

		manageProjectNameField = new DataSourceTextField("manageProjectName", "项目名称");
		manageProjectNameField.setLength(64);
		manageProjectNameField.setRequired(false);
		manageProjectNameField.setHidden(false);

		totalIntegralField = new DataSourceFloatField("totalIntegral", "项目总积分");
		totalIntegralField.setLength(10);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("##,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(false);
		
		leftIntegralField = new DataSourceFloatField("leftIntegral", "剩余积分");
		leftIntegralField.setLength(10);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("##,###,##0.00");
		leftIntegralField.setRequired(false);
		leftIntegralField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		setFields(manageProjectIdField, manageProjectNameField, totalIntegralField, leftIntegralField,plateIdField, remarkField);
	}

}
