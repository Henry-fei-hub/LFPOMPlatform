package com.pomplatform.client.receivables.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDIncomeMoneyForWeek extends DataSource
{


	public static CDIncomeMoneyForWeek instance = null;

	public static CDIncomeMoneyForWeek getInstance() {
		if(instance == null) {
			instance = new CDIncomeMoneyForWeek("CDIncomeMoneyForWeek");
		}
		return instance;
	}

	private final DataSourceTextField contractNameField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;

	public CDIncomeMoneyForWeek(String dataSourceID) {

		setID(dataSourceID);
		contractNameField = new DataSourceTextField("contractName", "收款项目");
		contractNameField.setRequired(true);
		contractNameField.setLength(0);
		contractNameField.setHidden(false);

		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "截止日期");
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


		setFields(contractNameField, startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

