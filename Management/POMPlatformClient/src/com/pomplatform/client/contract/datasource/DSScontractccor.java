package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;

public class DSScontractccor extends DBDataSource {

    public static DSScontractccor instance = null;

    public static DSScontractccor getInstance() {
        if (instance == null) {
            instance = new DSScontractccor("DSScontractccor");
        }
        return instance;
    }

    private final DataSourceIntegerField contractIdField;
    private final DataSourceTextField contractCodeField;
    private final DataSourceTextField contractNameField;
    private final DataSourceTextField customerNameField;
    private final DataSourceDateField startDateField;
    private final DataSourceDateField endDateField;
    private final DataSourceTextField alternateField1Field;
    private final DataSourceTextField alternateField2Field;
    private final DataSourceTextField alternateField3Field;
    private final DataSourceIntegerField statusField;

    public DSScontractccor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Scontractccor");

        contractIdField = new DataSourceIntegerField("contractId", "合同编码");
        contractIdField.setLength(11);
        contractIdField.setPrimaryKey(true);
        contractIdField.setRequired(true);
        contractIdField.setHidden(true);

        contractCodeField = new DataSourceTextField("contractCode", "合同编号");
        contractCodeField.setLength(64);
        contractCodeField.setRequired(false);
        contractCodeField.setHidden(false);

        contractNameField = new DataSourceTextField("contractName", "合同名称");
        contractNameField.setLength(512);
        contractNameField.setRequired(false);
        contractNameField.setHidden(false);

        customerNameField = new DataSourceTextField("customerName", "客户名称");
        customerNameField.setLength(512);
        customerNameField.setRequired(false);
        customerNameField.setHidden(false);

        startDateField = new DataSourceDateField("startDate", "项目下达日期");
        startDateField.setRequired(false);
        startDateField.setHidden(false);

        endDateField = new DataSourceDateField("endDate", "合同签订日期");
        endDateField.setRequired(false);
        endDateField.setHidden(false);

        alternateField1Field = new DataSourceTextField("alternateField1", "备用字段1");
        alternateField1Field.setLength(512);
        alternateField1Field.setRequired(false);
        alternateField1Field.setHidden(true);

        alternateField2Field = new DataSourceTextField("alternateField2", "备用字段2");
        alternateField2Field.setLength(512);
        alternateField2Field.setRequired(false);
        alternateField2Field.setHidden(true);

        alternateField3Field = new DataSourceTextField("alternateField3", "备用字段3");
        alternateField3Field.setLength(512);
        alternateField3Field.setRequired(false);
        alternateField3Field.setHidden(true);

        statusField = new DataSourceIntegerField("status", "状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(true);

        setFields(contractIdField, contractCodeField, contractNameField, customerNameField, startDateField, endDateField, alternateField1Field, alternateField2Field, alternateField3Field, statusField);
    }

}
