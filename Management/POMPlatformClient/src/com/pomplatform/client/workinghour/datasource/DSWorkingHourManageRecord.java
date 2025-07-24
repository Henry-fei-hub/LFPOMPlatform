package com.pomplatform.client.workinghour.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.*;

public class DSWorkingHourManageRecord extends DBDataSource
{


	public static DSWorkingHourManageRecord instance = null;

	public static DSWorkingHourManageRecord getInstance() {
		if(instance == null) {
			instance = new DSWorkingHourManageRecord("DSWorkingHourManageRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceFloatField workHourField;
	private final DataSourceDateField workDateField;

	public DSWorkingHourManageRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("WorkingHourManage");



		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);










		workHourField = new DataSourceFloatField("workHour", "工时");
		workHourField.setLength(10);
		workHourField.setDecimalPad(1);
		workHourField.setFormat("###,###,##0.0");
		workHourField.setRequired(false);
		workHourField.setHidden(false);


		workDateField = new DataSourceDateField("workDate", "日期");
		workDateField.setRequired(false);
		workDateField.setHidden(false);








		setFields( projectIdField, projectCodeField, projectNameField,       workHourField, workDateField);
	}


}

