package com.pomplatform.client.mainprojectinfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadApplyListOfBidPaySheetProject extends DataSource
{


	public static CDOnLoadApplyListOfBidPaySheetProject instance = null;

	public static CDOnLoadApplyListOfBidPaySheetProject getInstance() {
		if(instance == null) {
			instance = new CDOnLoadApplyListOfBidPaySheetProject("CDOnLoadApplyListOfBidPaySheetProject");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField employeeIdField;

	public CDOnLoadApplyListOfBidPaySheetProject(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(255);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(255);
		projectNameField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "关联表编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "工号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(32);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "计划安排");
		contractNameField.setRequired(false);
		contractNameField.setLength(1024);
		contractNameField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

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


		setFields(projectIdField, projectCodeField, projectNameField, contractIdField, contractCodeField, contractNameField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

