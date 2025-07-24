package com.pomplatform.client.company.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSheetTotalByProjectTypeDataSource extends DBDataSource {

    public static DSSheetTotalByProjectTypeDataSource instance = null;

    public static DSSheetTotalByProjectTypeDataSource getInstance() {
        if (instance == null) {
            instance = new DSSheetTotalByProjectTypeDataSource("DSBusinessTypeReport");
        }
        return instance;
    }

    private final DataSourceTextField projectTypeField;
    private final DataSourceFloatField sheetTotalIntegralField;

    public DSSheetTotalByProjectTypeDataSource(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("BusinessTypeReport");
        
        projectTypeField = new DataSourceTextField("projectType", "项目类别类别");
        projectTypeField.setLength(64);
        projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
        
        sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral", "订单总积分");
        sheetTotalIntegralField.setLength(64);
        
        setFields(projectTypeField,sheetTotalIntegralField);
    }

}
