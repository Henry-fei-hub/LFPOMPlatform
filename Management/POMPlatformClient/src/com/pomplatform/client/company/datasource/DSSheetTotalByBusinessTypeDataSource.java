package com.pomplatform.client.company.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSheetTotalByBusinessTypeDataSource extends DBDataSource {

    public static DSSheetTotalByBusinessTypeDataSource instance = null;

    public static DSSheetTotalByBusinessTypeDataSource getInstance() {
        if (instance == null) {
            instance = new DSSheetTotalByBusinessTypeDataSource("DSBusinessTypeReport");
        }
        return instance;
    }

    private final DataSourceTextField businessTypeField;
    private final DataSourceFloatField sheetTotalIntegralField;

    public DSSheetTotalByBusinessTypeDataSource(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("BusinessTypeReport");

        businessTypeField = new DataSourceTextField("businessType", "业务类别");
        businessTypeField.setLength(64);
        businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
        
        sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral", "订单总积分");
        sheetTotalIntegralField.setLength(64);
        
        setFields(businessTypeField,sheetTotalIntegralField);
    }

}
