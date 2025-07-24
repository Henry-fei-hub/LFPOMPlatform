package com.pomplatform.client.plateproductionvaluecoefficients.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CDSproductionvaluecoefficienttypepcor extends DataSource
{


	public static CDSproductionvaluecoefficienttypepcor instance = null;

	public static CDSproductionvaluecoefficienttypepcor getInstance() {
		if(instance == null) {
			instance = new CDSproductionvaluecoefficienttypepcor("CDSproductionvaluecoefficienttypepcor");
		}
		return instance;
	}

	private final DataSourceIntegerField productionValueCoefficientTypeIdField;
	private final DataSourceTextField coefficientTypeField;

	public CDSproductionvaluecoefficienttypepcor(String dataSourceID) {

		setID(dataSourceID);
		productionValueCoefficientTypeIdField = new DataSourceIntegerField("productionValueCoefficientTypeId", "类型");
		productionValueCoefficientTypeIdField.setRequired(true);
		productionValueCoefficientTypeIdField.setLength(11);
		productionValueCoefficientTypeIdField.setHidden(false);

		coefficientTypeField = new DataSourceTextField("coefficientType", "产值类型");
		coefficientTypeField.setRequired(true);
		coefficientTypeField.setLength(255);
		coefficientTypeField.setHidden(false);

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


		setFields(productionValueCoefficientTypeIdField, coefficientTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

