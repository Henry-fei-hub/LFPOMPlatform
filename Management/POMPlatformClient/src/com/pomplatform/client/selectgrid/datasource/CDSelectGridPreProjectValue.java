package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSelectGridPreProjectValue extends DataSource
{


	public static CDSelectGridPreProjectValue instance = null;

	public static CDSelectGridPreProjectValue getInstance() {
		if(instance == null) {
			instance = new CDSelectGridPreProjectValue("CDSelectGridPreProjectValue");
		}
		return instance;
	}

	private final DataSourceTextField projectNameField;
	private final DataSourceTextField customNumberField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField preProjectReimbursementNumberIdField;

	public CDSelectGridPreProjectValue(String dataSourceID) {

		setID(dataSourceID);
		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		customNumberField = new DataSourceTextField("customNumber", "前期项目信息编号");
		customNumberField.setRequired(false);
		customNumberField.setLength(32);
		customNumberField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(512);
		remarkField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		preProjectReimbursementNumberIdField = new DataSourceIntegerField("preProjectReimbursementNumberId", "主键编码");
		preProjectReimbursementNumberIdField.setRequired(true);
		preProjectReimbursementNumberIdField.setLength(11);
		preProjectReimbursementNumberIdField.setPrimaryKey(true);
		preProjectReimbursementNumberIdField.setHidden(true);

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


		setFields(projectNameField, customNumberField, remarkField, plateIdField, preProjectReimbursementNumberIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

