package com.pomplatform.client.manageprojectbyproject.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSManageProjectByProject extends DBDataSource
{


	public static DSManageProjectByProject instance = null;

	public static DSManageProjectByProject getInstance() {
		if(instance == null) {
			instance = new DSManageProjectByProject("DSManageProjectByProject");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField manageProjectIdField;
	private final DataSourceTextField manageProjectNameField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceDateField projectDateField;
	private final DataSourceTextField remarkField;

	public DSManageProjectByProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ManageProjectByProject");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		manageProjectIdField = new DataSourceIntegerField("manageProjectId", "主键编码");
		manageProjectIdField.setLength(11);
		manageProjectIdField.setPrimaryKey(true);
		manageProjectIdField.setRequired(true);
		manageProjectIdField.setHidden(true);
//		manageProjectIdField.setValueMap(KeyValueManager.getValueMap("manage_projects"));
		KeyValueManager.loadValueMap("manage_projects", manageProjectIdField);

		manageProjectNameField = new DataSourceTextField("manageProjectName", "项目名称");
		manageProjectNameField.setLength(512);
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


		projectDateField = new DataSourceDateField("projectDate", "日期");
		projectDateField.setRequired(false);
		projectDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(manageProjectIdField, plateIdField, manageProjectNameField, totalIntegralField, leftIntegralField, projectDateField, remarkField);
	}


}

