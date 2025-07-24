package com.pomplatform.client.company.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCompanyIntegralAchieveDataSource extends DBDataSource {

    public static DSCompanyIntegralAchieveDataSource instance = null;

    public static DSCompanyIntegralAchieveDataSource getInstance() {
        if (instance == null) {
            instance = new DSCompanyIntegralAchieveDataSource("DSCompanyIntegralAchieve");
        }
        return instance;
    }

    private final DataSourceTextField nameField;
    private final DataSourceFloatField integralField;

    public DSCompanyIntegralAchieveDataSource(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("CompanyIntegralAchieve");
        
        nameField = new DataSourceTextField("name", "收入");
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
