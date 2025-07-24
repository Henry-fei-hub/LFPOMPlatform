package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSshiftmanagesor extends DataSource
{


	public static CDSshiftmanagesor instance = null;

	public static CDSshiftmanagesor getInstance() {
		if(instance == null) {
			instance = new CDSshiftmanagesor("CDSshiftmanagesor");
		}
		return instance;
	}

	private final DataSourceTextField shiftNameField;

	public CDSshiftmanagesor(String dataSourceID) {

		setID(dataSourceID);
		shiftNameField = new DataSourceTextField("shiftName", "班次名称");
		shiftNameField.setRequired(false);
		shiftNameField.setLength(64);
		shiftNameField.setHidden(false);

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


		setFields(shiftNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

