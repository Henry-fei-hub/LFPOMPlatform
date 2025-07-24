package com.pomplatform.client.company.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSsheetTotalByPlateIdDataSource extends DBDataSource {

    public static DSsheetTotalByPlateIdDataSource instance = null;

    public static DSsheetTotalByPlateIdDataSource getInstance() {
        if (instance == null) {
            instance = new DSsheetTotalByPlateIdDataSource("DSBusinessTypeReport");
        }
        return instance;
    }

    private final DataSourceTextField plateIdField;
    private final DataSourceFloatField sheetTotalIntegralField;

    public DSsheetTotalByPlateIdDataSource(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("BusinessTypeReport");

        plateIdField = new DataSourceTextField("departmentId", "承接部门");
        plateIdField.setLength(64);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        
        sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral", "订单总积分");
        sheetTotalIntegralField.setLength(64);
        
        setFields(plateIdField,sheetTotalIntegralField);
    }

}
