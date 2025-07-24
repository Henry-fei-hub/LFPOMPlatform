package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDManageShiftTime extends DataSource
{


	public static CDManageShiftTime instance = null;

	public static CDManageShiftTime getInstance() {
		if(instance == null) {
			instance = new CDManageShiftTime("CDManageShiftTime");
		}
		return instance;
	}

	private final DataSourceTextField shiftTimeNameField;

	public CDManageShiftTime(String dataSourceID) {

		setID(dataSourceID);
		shiftTimeNameField = new DataSourceTextField("shiftTimeName", "时段名称");
		shiftTimeNameField.setRequired(false);
		shiftTimeNameField.setLength(64);
		shiftTimeNameField.setHidden(false);

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


		setFields(shiftTimeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

