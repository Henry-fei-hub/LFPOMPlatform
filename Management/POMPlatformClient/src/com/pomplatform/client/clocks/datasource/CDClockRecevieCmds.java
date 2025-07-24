package com.pomplatform.client.clocks.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDClockRecevieCmds extends DataSource
{


	public static CDClockRecevieCmds instance = null;

	public static CDClockRecevieCmds getInstance() {
		if(instance == null) {
			instance = new CDClockRecevieCmds("CDClockRecevieCmds");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceTextField deviceNameField;

	public CDClockRecevieCmds(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "执行状态");
		statusField.setRequired(false);
		statusField.setLength(5);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		deviceNameField = new DataSourceTextField("deviceName", "设备名称");
		deviceNameField.setRequired(false);
		deviceNameField.setLength(64);
		deviceNameField.setHidden(false);

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


		setFields(statusField, startDateField, endDateField, deviceNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

