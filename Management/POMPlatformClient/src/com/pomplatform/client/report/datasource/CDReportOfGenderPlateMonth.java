package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDReportOfGenderPlateMonth extends DataSource
{


	public static CDReportOfGenderPlateMonth instance = null;

	public static CDReportOfGenderPlateMonth getInstance() {
		if(instance == null) {
			instance = new CDReportOfGenderPlateMonth("CDReportOfGenderPlateMonth");
		}
		return instance;
	}

	private final DataSourceDateField theDateField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public CDReportOfGenderPlateMonth(String dataSourceID) {

		setID(dataSourceID);
		theDateField = new DataSourceDateField("theDate", "日期");
		theDateField.setRequired(false);
		theDateField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(true);
		monthField.setLength(11);
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


		setFields(theDateField, yearField, monthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

