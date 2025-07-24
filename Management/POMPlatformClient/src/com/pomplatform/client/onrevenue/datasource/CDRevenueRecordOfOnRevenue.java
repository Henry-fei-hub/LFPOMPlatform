package com.pomplatform.client.onrevenue.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDRevenueRecordOfOnRevenue extends DataSource
{


	public static CDRevenueRecordOfOnRevenue instance = null;

	public static CDRevenueRecordOfOnRevenue getInstance() {
		if(instance == null) {
			instance = new CDRevenueRecordOfOnRevenue("CDRevenueRecordOfOnRevenue");
		}
		return instance;
	}

	private final DataSourceIntegerField signingCompanyField;
	private final DataSourceTextField nameField;

	public CDRevenueRecordOfOnRevenue(String dataSourceID) {

		setID(dataSourceID);
		signingCompanyField = new DataSourceIntegerField("signingCompany", "签约公司");
		signingCompanyField.setRequired(false);
		signingCompanyField.setLength(11);
		signingCompanyField.setHidden(false);
		signingCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		nameField = new DataSourceTextField("name", "名称");
		nameField.setRequired(false);
		nameField.setLength(512);
		nameField.setHidden(false);

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


		setFields(signingCompanyField, nameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

