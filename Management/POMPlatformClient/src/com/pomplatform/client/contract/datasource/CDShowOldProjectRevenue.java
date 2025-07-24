package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDShowOldProjectRevenue extends DataSource
{


	public static CDShowOldProjectRevenue instance = null;

	public static CDShowOldProjectRevenue getInstance() {
		if(instance == null) {
			instance = new CDShowOldProjectRevenue("CDShowOldProjectRevenue");
		}
		return instance;
	}

	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField palteIdField;

	public CDShowOldProjectRevenue(String dataSourceID) {

		setID(dataSourceID);
		projectCodeField = new DataSourceTextField("projectCode", "订单编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(32);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "订单名");
		projectNameField.setRequired(false);
		projectNameField.setLength(32);
		projectNameField.setHidden(false);

		palteIdField = new DataSourceIntegerField("palteId", "归属的部门Id");
		palteIdField.setRequired(false);
		palteIdField.setLength(11);
		palteIdField.setHidden(false);

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


		setFields(projectCodeField, projectNameField, palteIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

