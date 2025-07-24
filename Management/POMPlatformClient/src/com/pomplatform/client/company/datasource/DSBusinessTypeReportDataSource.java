package com.pomplatform.client.company.datasource;

import java.util.logging.Logger;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSBusinessTypeReportDataSource extends DBDataSource {
	private final Logger __logger = Logger.getLogger("");
    public static DSBusinessTypeReportDataSource instance = null;

    public static DSBusinessTypeReportDataSource getInstance() {
        if (instance == null) {
            instance = new DSBusinessTypeReportDataSource("DSBusinessTypeReport");
        }
        return instance;
    }

    private final DataSourceTextField businessTypeField;
    private final DataSourceTextField projectTypeField;
    private final DataSourceTextField plateIdField;
    private final DataSourceFloatField sheetTotalIntegralField;

    public DSBusinessTypeReportDataSource(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("BusinessTypeReport");

        businessTypeField = new DataSourceTextField("businessType", "业务类别");
        businessTypeField.setLength(64);
        businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
        
        projectTypeField = new DataSourceTextField("projectType", "项目类别");
        projectTypeField.setLength(64);
        projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
        
        plateIdField = new DataSourceTextField("departmentId", "承接部门");
        plateIdField.setLength(64);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        
        sheetTotalIntegralField = new DataSourceFloatField("sheetTotalIntegral", "订单总积分");
        sheetTotalIntegralField.setLength(64);
        
        setFields(businessTypeField,projectTypeField,plateIdField,sheetTotalIntegralField);
    }

}
