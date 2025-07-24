package com.pomplatform.client.systeminitloglstor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSsysteminitloglstor extends DataSource
{


	public static CDSsysteminitloglstor instance = null;

	public static CDSsysteminitloglstor getInstance() {
		if(instance == null) {
			instance = new CDSsysteminitloglstor("CDSsysteminitloglstor");
		}
		return instance;
	}

	private final DataSourceTextField logMsgField;
	private final DataSourceIntegerField systemInitLogIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField flagField;

	public CDSsysteminitloglstor(String dataSourceID) {

		setID(dataSourceID);
		logMsgField = new DataSourceTextField("logMsg", "日志信息");
		logMsgField.setRequired(false);
		logMsgField.setLength(255);
		logMsgField.setHidden(false);

		systemInitLogIdField = new DataSourceIntegerField("systemInitLogId", "主键");
		systemInitLogIdField.setRequired(true);
		systemInitLogIdField.setLength(11);
		systemInitLogIdField.setPrimaryKey(true);
		systemInitLogIdField.setHidden(true);

		typeField = new DataSourceIntegerField("type", "导入类型  1基础数据 2历史数据");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);

		flagField = new DataSourceIntegerField("flag", "1成功  2失败");
		flagField.setRequired(false);
		flagField.setLength(11);
		flagField.setHidden(false);

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


		setFields(logMsgField, systemInitLogIdField, typeField, flagField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

