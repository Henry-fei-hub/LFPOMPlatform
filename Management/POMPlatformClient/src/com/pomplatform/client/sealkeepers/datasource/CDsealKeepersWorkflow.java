package com.pomplatform.client.sealkeepers.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDsealKeepersWorkflow extends DataSource
{


	public static CDsealKeepersWorkflow instance = null;

	public static CDsealKeepersWorkflow getInstance() {
		if(instance == null) {
			instance = new CDsealKeepersWorkflow("CDsealKeepersWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField sealNameField;
	private final DataSourceIntegerField employeeIdField;

	public CDsealKeepersWorkflow(String dataSourceID) {

		setID(dataSourceID);
		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		sealNameField = new DataSourceTextField("sealName", "印章名称");
		sealNameField.setRequired(true);
		sealNameField.setLength(128);
		sealNameField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "保管员");
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


		setFields(companyIdField, sealNameField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

