package com.pomplatform.client.preprojectreimbursementnumber.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPreProjectReimbursementNumbers extends DataSource
{


	public static CDPreProjectReimbursementNumbers instance = null;

	public static CDPreProjectReimbursementNumbers getInstance() {
		if(instance == null) {
			instance = new CDPreProjectReimbursementNumbers("CDPreProjectReimbursementNumbers");
		}
		return instance;
	}

	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceTextField customNumberField;
	private final DataSourceTextField remarkField;

	public CDPreProjectReimbursementNumbers(String dataSourceID) {

		setID(dataSourceID);
		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);

		customNumberField = new DataSourceTextField("customNumber", "前期项目信息编号");
		customNumberField.setRequired(false);
		customNumberField.setLength(32);
		customNumberField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(512);
		remarkField.setHidden(false);

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


		setFields(projectNameField, operatorField, customNumberField, remarkField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

