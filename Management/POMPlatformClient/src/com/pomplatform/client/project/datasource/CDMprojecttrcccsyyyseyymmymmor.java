package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMprojecttrcccsyyyseyymmymmor extends DataSource
{


	public static CDMprojecttrcccsyyyseyymmymmor instance = null;

	public static CDMprojecttrcccsyyyseyymmymmor getInstance() {
		if(instance == null) {
			instance = new CDMprojecttrcccsyyyseyymmymmor("CDMprojecttrcccsyyyseyymmymmor");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField startMonthField;
	private final DataSourceIntegerField endMonthField;
	private final DataSourceTextField yearStrField;
	private final DataSourceTextField monthStartStrField;
	private final DataSourceTextField monthEndStrField;

	public CDMprojecttrcccsyyyseyymmymmor(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		startMonthField = new DataSourceIntegerField("startMonth", "开始月份");
		startMonthField.setRequired(false);
		startMonthField.setLength(11);
		startMonthField.setHidden(false);

		endMonthField = new DataSourceIntegerField("endMonth", "结束月份");
		endMonthField.setRequired(false);
		endMonthField.setLength(11);
		endMonthField.setHidden(false);

		yearStrField = new DataSourceTextField("yearStr", "年份str");
		yearStrField.setRequired(true);
		yearStrField.setLength(0);
		yearStrField.setHidden(false);

		monthStartStrField = new DataSourceTextField("monthStartStr", "开始月份str");
		monthStartStrField.setRequired(true);
		monthStartStrField.setLength(0);
		monthStartStrField.setHidden(false);

		monthEndStrField = new DataSourceTextField("monthEndStr", "结束月份str");
		monthEndStrField.setRequired(true);
		monthEndStrField.setLength(0);
		monthEndStrField.setHidden(false);

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


		setFields(yearField, startMonthField, endMonthField, yearStrField, monthStartStrField, monthEndStrField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

