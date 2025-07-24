package com.pomplatform.client.plateproductionvaluecoefficientstype.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class CDProductionValueCoefficientType extends DataSource
{


	public static CDProductionValueCoefficientType instance = null;

	public static CDProductionValueCoefficientType getInstance() {
		if(instance == null) {
			instance = new CDProductionValueCoefficientType("CDProductionValueCoefficientType");
		}
		return instance;
	}


	public CDProductionValueCoefficientType(String dataSourceID) {

		setID(dataSourceID);
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


		setFields(currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

