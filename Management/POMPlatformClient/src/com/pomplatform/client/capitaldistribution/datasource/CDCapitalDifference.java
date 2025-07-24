package com.pomplatform.client.capitaldistribution.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCapitalDifference extends DataSource
{


	public static CDCapitalDifference instance = null;

	public static CDCapitalDifference getInstance() {
		if(instance == null) {
			instance = new CDCapitalDifference("CDCapitalDifference");
		}
		return instance;
	}

	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;

	public CDCapitalDifference(String dataSourceID) {

		setID(dataSourceID);
		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setLength(11);
		moneyAttributeField.setHidden(false);

		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

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


		setFields(moneyAttributeField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

