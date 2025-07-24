package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDShiftmanageDetail extends DataSource
{


	public static CDShiftmanageDetail instance = null;

	public static CDShiftmanageDetail getInstance() {
		if(instance == null) {
			instance = new CDShiftmanageDetail("CDShiftmanageDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField shiftManageIdField;

	public CDShiftmanageDetail(String dataSourceID) {

		setID(dataSourceID);
		shiftManageIdField = new DataSourceIntegerField("shiftManageId", "班次id");
		shiftManageIdField.setRequired(true);
		shiftManageIdField.setLength(11);
		shiftManageIdField.setPrimaryKey(true);
		shiftManageIdField.setHidden(true);

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


		setFields(shiftManageIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

