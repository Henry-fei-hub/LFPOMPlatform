package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCheckWorkHandover extends DataSource
{


	public static CDCheckWorkHandover instance = null;

	public static CDCheckWorkHandover getInstance() {
		if(instance == null) {
			instance = new CDCheckWorkHandover("CDCheckWorkHandover");
		}
		return instance;
	}

	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceIntegerField fromEmployeeIdField;
	private final DataSourceIntegerField toEmployeeIdField;

	public CDCheckWorkHandover(String dataSourceID) {

		setID(dataSourceID);
		typeField = new DataSourceIntegerField("type", "工作交接类型  1离职   2转岗");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);

		linkIdField = new DataSourceIntegerField("linkId", "关联编码");
		linkIdField.setRequired(false);
		linkIdField.setLength(11);
		linkIdField.setHidden(false);

		fromEmployeeIdField = new DataSourceIntegerField("fromEmployeeId", "交接者");
		fromEmployeeIdField.setRequired(false);
		fromEmployeeIdField.setLength(11);
		fromEmployeeIdField.setHidden(false);

		toEmployeeIdField = new DataSourceIntegerField("toEmployeeId", "被交接者");
		toEmployeeIdField.setRequired(false);
		toEmployeeIdField.setLength(11);
		toEmployeeIdField.setHidden(false);

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


		setFields(typeField, linkIdField, fromEmployeeIdField, toEmployeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

