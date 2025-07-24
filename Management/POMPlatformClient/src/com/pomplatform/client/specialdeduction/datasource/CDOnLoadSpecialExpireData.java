package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadSpecialExpireData extends DataSource
{


	public static CDOnLoadSpecialExpireData instance = null;

	public static CDOnLoadSpecialExpireData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadSpecialExpireData("CDOnLoadSpecialExpireData");
		}
		return instance;
	}

	private final DataSourceTextField yearField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceTextField monthField;

	public CDOnLoadSpecialExpireData(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceTextField("year", "扣除年度");
		yearField.setRequired(false);
		yearField.setLength(64);
		yearField.setHidden(false);

		employeIdField = new DataSourceIntegerField("employeId", "纳税人id");
		employeIdField.setRequired(true);
		employeIdField.setLength(11);
		employeIdField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		monthField = new DataSourceTextField("month", "月份");
		monthField.setRequired(true);
		monthField.setLength(0);
		monthField.setHidden(false);

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


		setFields(yearField, employeIdField, processStatusField, monthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

