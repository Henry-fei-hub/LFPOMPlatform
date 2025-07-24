package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCollectionrevenueanalysis extends DataSource
{


	public static CDCollectionrevenueanalysis instance = null;

	public static CDCollectionrevenueanalysis getInstance() {
		if(instance == null) {
			instance = new CDCollectionrevenueanalysis("CDCollectionrevenueanalysis");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceTextField yearStrField;

	public CDCollectionrevenueanalysis(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务布恩");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		yearStrField = new DataSourceTextField("yearStr", "年份");
		yearStrField.setRequired(true);
		yearStrField.setLength(0);
		yearStrField.setHidden(false);

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


		setFields(plateIdField, yearField, yearStrField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

