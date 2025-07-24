package com.pomplatform.client.company.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCompanyIntegralAnalyzeDataSource extends DBDataSource {

    public static DSCompanyIntegralAnalyzeDataSource instance = null;

    public static DSCompanyIntegralAnalyzeDataSource getInstance() {
        if (instance == null) {
            instance = new DSCompanyIntegralAnalyzeDataSource("DSCompanyIntegralAchieve");
        }
        return instance;
    }

    private final DataSourceTextField nameField;
    private final DataSourceTextField resultField;

    public DSCompanyIntegralAnalyzeDataSource(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("CompanyIntegralAchieve");
        
        nameField = new DataSourceTextField("name", "分析栏");
        nameField.setLength(64);
        
        resultField = new DataSourceTextField("result", "结果集");
        resultField.setLength(64);
        
        setFields(nameField,resultField);
    }

}
