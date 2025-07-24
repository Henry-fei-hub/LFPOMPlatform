package com.pomplatform.client.plateIntegralAccount.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDQualityFeeSumByMonth extends DataSource
{


	public static CDQualityFeeSumByMonth instance = null;

	public static CDQualityFeeSumByMonth getInstance() {
		if(instance == null) {
			instance = new CDQualityFeeSumByMonth("CDQualityFeeSumByMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;

	public CDQualityFeeSumByMonth(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "积分提取部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		startDateField = new DataSourceDateField("startDate", "发放日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "发放日期");
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


		setFields(plateIdField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

