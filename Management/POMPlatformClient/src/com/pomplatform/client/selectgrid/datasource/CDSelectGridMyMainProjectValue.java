package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSelectGridMyMainProjectValue extends DataSource
{


	public static CDSelectGridMyMainProjectValue instance = null;

	public static CDSelectGridMyMainProjectValue getInstance() {
		if(instance == null) {
			instance = new CDSelectGridMyMainProjectValue("CDSelectGridMyMainProjectValue");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;

	public CDSelectGridMyMainProjectValue(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
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


		setFields(employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

