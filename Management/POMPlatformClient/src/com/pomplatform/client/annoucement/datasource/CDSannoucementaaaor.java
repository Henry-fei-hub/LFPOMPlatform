package com.pomplatform.client.annoucement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSannoucementaaaor extends DataSource
{


	public static CDSannoucementaaaor instance = null;

	public static CDSannoucementaaaor getInstance() {
		if(instance == null) {
			instance = new CDSannoucementaaaor("CDSannoucementaaaor");
		}
		return instance;
	}

	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField annoucementTimeField;
	private final DataSourceTextField annoucementTitleField;
	private final DataSourceTextField annoucementContentField;

	public CDSannoucementaaaor(String dataSourceID) {

		setID(dataSourceID);
		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "发起人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

		annoucementTimeField = new DataSourceDateTimeField("annoucementTime", "公告时间");
		annoucementTimeField.setRequired(false);
		annoucementTimeField.setHidden(false);

		annoucementTitleField = new DataSourceTextField("annoucementTitle", "公告主题");
		annoucementTitleField.setRequired(false);
		annoucementTitleField.setLength(128);
		annoucementTitleField.setHidden(false);

		annoucementContentField = new DataSourceTextField("annoucementContent", "公告内容");
		annoucementContentField.setRequired(false);
		annoucementContentField.setLength(20480);
		annoucementContentField.setHidden(false);

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


		setFields(operateEmployeeIdField, annoucementTimeField, annoucementTitleField, annoucementContentField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

