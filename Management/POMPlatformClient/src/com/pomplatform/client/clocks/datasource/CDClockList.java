package com.pomplatform.client.clocks.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDClockList extends DataSource
{


	public static CDClockList instance = null;

	public static CDClockList getInstance() {
		if(instance == null) {
			instance = new CDClockList("CDClockList");
		}
		return instance;
	}

	private final DataSourceTextField deviceNameField;
	private final DataSourceTextField aliasField;
	private final DataSourceIntegerField clockTypeIdField;
	private final DataSourceTextField snField;
	private final DataSourceIntegerField isEnableField;

	public CDClockList(String dataSourceID) {

		setID(dataSourceID);
		deviceNameField = new DataSourceTextField("deviceName", "设备名称");
		deviceNameField.setRequired(false);
		deviceNameField.setLength(64);
		deviceNameField.setHidden(false);

		aliasField = new DataSourceTextField("alias", "设备别名");
		aliasField.setRequired(false);
		aliasField.setLength(64);
		aliasField.setHidden(false);

		clockTypeIdField = new DataSourceIntegerField("clockTypeId", "设备类型");
		clockTypeIdField.setRequired(true);
		clockTypeIdField.setLength(11);
		clockTypeIdField.setHidden(false);

		snField = new DataSourceTextField("sn", "序列号");
		snField.setRequired(false);
		snField.setLength(32);
		snField.setHidden(false);
		
		isEnableField = new DataSourceIntegerField("isEnable", "机器是否可用  0 不可用   1 可用");
		isEnableField.setRequired(false);
		isEnableField.setLength(11);
		isEnableField.setHidden(false);

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


		setFields(deviceNameField, aliasField, clockTypeIdField, snField,isEnableField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

