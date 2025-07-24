package com.pomplatform.client.projectsuredaterecord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectSureDateRecord extends DataSource
{


	public static CDProjectSureDateRecord instance = null;

	public static CDProjectSureDateRecord getInstance() {
		if(instance == null) {
			instance = new CDProjectSureDateRecord("CDProjectSureDateRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;

	public CDProjectSureDateRecord(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(true);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "结束日期");
		endDateField.setRequired(true);
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


		setFields(plateIdField, projectNameField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

