package com.pomplatform.client.company.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCompanyIntegralSourceDataSource extends DBDataSource {

    public static DSCompanyIntegralSourceDataSource instance = null;

    public static DSCompanyIntegralSourceDataSource getInstance() {
        if (instance == null) {
            instance = new DSCompanyIntegralSourceDataSource("DSCompanyIntegralAchieve");
        }
        return instance;
    }

    private final DataSourceTextField nameField;
    private final DataSourceFloatField integralField;

    public DSCompanyIntegralSourceDataSource(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("CompanyIntegralAchieve");
        
        nameField = new DataSourceTextField("name", "印钞机");
        nameField.setLength(64);
        
        integralField = new DataSourceFloatField("integral", "积分");
        integralField.setLength(18);
        integralField.setDecimalPad(2);
        integralField.setFormat("#,###,###,###,###,##0.00");
        integralField.setRequired(false);
        integralField.setHidden(false);
        
        setFields(nameField,integralField);
    }

}
