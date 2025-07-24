package com.pomplatform.client.preprojectmyrecords.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPreProjectMyRecords extends DataSource
{


	public static CDPreProjectMyRecords instance = null;

	public static CDPreProjectMyRecords getInstance() {
		if(instance == null) {
			instance = new CDPreProjectMyRecords("CDPreProjectMyRecords");
		}
		return instance;
	}

	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField projectStatusField;
	private final DataSourceIntegerField projectBaseOnField;
	private final DataSourceTextField relevantEmployeesField;

	public CDPreProjectMyRecords(String dataSourceID) {

		setID(dataSourceID);
		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "项目营销团队");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "立项/关闭的流程状态(1立项进行中，2已立项，5立项失败，4关闭进行中，5已关闭，6关闭失败)");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		projectStatusField = new DataSourceTextField("projectStatus", "项目状态");
		projectStatusField.setRequired(false);
		projectStatusField.setLength(64);
		projectStatusField.setHidden(false);

		projectBaseOnField = new DataSourceIntegerField("projectBaseOn", "立项依据");
		projectBaseOnField.setRequired(false);
		projectBaseOnField.setLength(11);
		projectBaseOnField.setHidden(false);

		relevantEmployeesField = new DataSourceTextField("relevantEmployees", "项目秘书");
		relevantEmployeesField.setRequired(false);
		relevantEmployeesField.setLength(1024);
		relevantEmployeesField.setHidden(false);

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


		setFields(applyEmployeeIdField, departmentIdField, statusField, projectStatusField, projectBaseOnField, relevantEmployeesField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

