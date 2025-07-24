package com.pomplatform.client.plateproductionvaluecoefficients.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DSSproductionvaluecoefficienttypepor extends DBDataSource {


    public static DSSproductionvaluecoefficienttypepor instance = null;

    public static DSSproductionvaluecoefficienttypepor getInstance() {
        if (instance == null) {
            instance = new DSSproductionvaluecoefficienttypepor("DSSproductionvaluecoefficienttypepor");
        }
        return instance;
    }

    private final DataSourceIntegerField productionValueCoefficientTypeIdField;
    private final DataSourceTextField coefficientTypeField;
    private final DataSourceField detailProductionValueCoefficient;

    public DSSproductionvaluecoefficienttypepor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sproductionvaluecoefficienttypepor");


        productionValueCoefficientTypeIdField = new DataSourceIntegerField("productionValueCoefficientTypeId", "主键id");
        productionValueCoefficientTypeIdField.setLength(11);
        productionValueCoefficientTypeIdField.setPrimaryKey(true);
        productionValueCoefficientTypeIdField.setRequired(true);
        productionValueCoefficientTypeIdField.setHidden(true);
        productionValueCoefficientTypeIdField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

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

