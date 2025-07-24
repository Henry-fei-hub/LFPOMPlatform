package com.pomplatform.client.activitympcor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSactivityMpcor extends DataSource
{


	public static CDSactivityMpcor instance = null;

	public static CDSactivityMpcor getInstance() {
		if(instance == null) {
			instance = new CDSactivityMpcor("CDSactivityMpcor");
		}
		return instance;
	}

	private final DataSourceDateTimeField meetTimeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceIntegerField meetTypeField;
	private final DataSourceTextField meetTitleField;
	private final DataSourceIntegerField departmentIdField;

	public CDSactivityMpcor(String dataSourceID) {

		setID(dataSourceID);
		meetTimeField = new DataSourceDateTimeField("meetTime", "会议时间");
		meetTimeField.setRequired(false);
		meetTimeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(128);
		projectNameField.setHidden(false);

		contactNameField = new DataSourceTextField("contactName", "联系人");
		contactNameField.setRequired(false);
		contactNameField.setLength(128);
		contactNameField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(128);
		customerNameField.setHidden(false);

		meetTypeField = new DataSourceIntegerField("meetType", "会议类型");
		meetTypeField.setRequired(false);
		meetTypeField.setLength(11);
		meetTypeField.setHidden(false);

		meetTitleField = new DataSourceTextField("meetTitle", "会议主题");
		meetTitleField.setRequired(false);
		meetTitleField.setLength(128);
		meetTitleField.setHidden(false);
		
		departmentIdField = new DataSourceIntegerField("departmentId", "营销团队");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);

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


		setFields(meetTimeField, projectNameField, contactNameField, customerNameField, meetTypeField, meetTitleField,departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

