package com.pomplatform.client.duty.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSemployeeDuty extends DataSource
{


	public static CDSemployeeDuty instance = null;

	public static CDSemployeeDuty getInstance() {
		if(instance == null) {
			instance = new CDSemployeeDuty("CDSemployeeDuty");
		}
		return instance;
	}

	private final DataSourceTextField dutyNameField;
	private final DataSourceIntegerField dutyIdField;

	public CDSemployeeDuty(String dataSourceID) {

		setID(dataSourceID);
		dutyNameField = new DataSourceTextField("dutyName", "职位名称");
		dutyNameField.setRequired(false);
		dutyNameField.setLength(128);
		dutyNameField.setHidden(false);

		dutyIdField = new DataSourceIntegerField("dutyId", "职位");
		dutyIdField.setRequired(true);
		dutyIdField.setLength(11);
		dutyIdField.setPrimaryKey(true);
		dutyIdField.setHidden(true);

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


		setFields(dutyNameField, dutyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

