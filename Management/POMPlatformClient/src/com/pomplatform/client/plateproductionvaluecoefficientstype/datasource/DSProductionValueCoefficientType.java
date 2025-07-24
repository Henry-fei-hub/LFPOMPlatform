package com.pomplatform.client.plateproductionvaluecoefficientstype.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProductionValueCoefficientType extends DBDataSource
{
	public static DSProductionValueCoefficientType instance = null;

	public static DSProductionValueCoefficientType getInstance() {
		if(instance == null) {
			instance = new DSProductionValueCoefficientType("DSProductionValueCoefficientType");
		}
		return instance;
	}

	private final DataSourceIntegerField productionValueCoefficientTypeIdField;
	private final DataSourceTextField coefficientTypeField;

	public DSProductionValueCoefficientType(String dataSourceID) {
		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProductionValueCoefficientType");

		productionValueCoefficientTypeIdField = new DataSourceIntegerField("productionValueCoefficientTypeId", "主键id");
		productionValueCoefficientTypeIdField.setLength(11);
		productionValueCoefficientTypeIdField.setPrimaryKey(true);
		productionValueCoefficientTypeIdField.setRequired(true);
		productionValueCoefficientTypeIdField.setHidden(true);

		coefficientTypeField = new DataSourceTextField("coefficientType", "产值类型");
		coefficientTypeField.setLength(255);
		coefficientTypeField.setRequired(true);
		coefficientTypeField.setHidden(false);

		setFields(productionValueCoefficientTypeIdField, coefficientTypeField);
	}
}

