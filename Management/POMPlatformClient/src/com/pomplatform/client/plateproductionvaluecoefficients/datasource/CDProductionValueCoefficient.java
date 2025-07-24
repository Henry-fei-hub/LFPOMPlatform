package com.pomplatform.client.plateproductionvaluecoefficients.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class CDProductionValueCoefficient extends DataSource
{


	public static CDProductionValueCoefficient instance = null;

	public static CDProductionValueCoefficient getInstance() {
		if(instance == null) {
			instance = new CDProductionValueCoefficient("CDProductionValueCoefficient");
		}
		return instance;
	}

	private final DataSourceIntegerField productionValueCoefficientTypeIdField;

	public CDProductionValueCoefficient(String dataSourceID) {

		setID(dataSourceID);
		productionValueCoefficientTypeIdField = new DataSourceIntegerField("productionValueCoefficientTypeId", "类型");
		productionValueCoefficientTypeIdField.setRequired(true);
		productionValueCoefficientTypeIdField.setLength(11);
		productionValueCoefficientTypeIdField.setHidden(false);

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


		setFields(productionValueCoefficientTypeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

