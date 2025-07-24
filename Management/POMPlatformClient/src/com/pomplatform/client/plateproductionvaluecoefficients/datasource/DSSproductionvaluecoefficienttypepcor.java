package com.pomplatform.client.plateproductionvaluecoefficients.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DSSproductionvaluecoefficienttypepcor extends DBDataSource
{


	public static DSSproductionvaluecoefficienttypepcor instance = null;

	public static DSSproductionvaluecoefficienttypepcor getInstance() {
		if(instance == null) {
			instance = new DSSproductionvaluecoefficienttypepcor("DSSproductionvaluecoefficienttypepcor");
		}
		return instance;
	}

	private final DataSourceIntegerField productionValueCoefficientTypeIdField;
	private final DataSourceTextField coefficientTypeField;
	private final DataSourceField detailProductionValueCoefficient;

	public DSSproductionvaluecoefficienttypepcor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sproductionvaluecoefficienttypepcor");


		productionValueCoefficientTypeIdField = new DataSourceIntegerField("productionValueCoefficientTypeId", "主键id");
		productionValueCoefficientTypeIdField.setLength(11);
		productionValueCoefficientTypeIdField.setPrimaryKey(true);
		productionValueCoefficientTypeIdField.setRequired(true);
		productionValueCoefficientTypeIdField.setHidden(false);


		coefficientTypeField = new DataSourceTextField("coefficientType", "产值类型");
		coefficientTypeField.setLength(255);
		coefficientTypeField.setRequired(true);
		coefficientTypeField.setHidden(false);

		detailProductionValueCoefficient = new DataSourceField("detailProductionValueCoefficient", FieldType.ANY);
		detailProductionValueCoefficient.setChildrenProperty(true);
		detailProductionValueCoefficient.setChildTagName("ProductionValueCoefficient");
		detailProductionValueCoefficient.setRequired(false);
		detailProductionValueCoefficient.setHidden(true);

		setFields(productionValueCoefficientTypeIdField, coefficientTypeField, detailProductionValueCoefficient);
	}


}

