package com.pomplatform.client.projectview.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;

public class DSProjectCost extends DBDataSource {

    public static DSProjectCost instance = null;

    public static DSProjectCost getInstance() {
        if (instance == null) {
            instance = new DSProjectCost("DSProjectCost");
        }
        return instance;
    }

    private final DataSourceIntegerField projectCostIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceFloatField costMoneyField;
    private final DataSourceIntegerField costTypeField;
    private final DataSourceDateField costDateField;

    public DSProjectCost(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_TABLE);
        setActionName("ProjectCost");

        projectCostIdField = new DataSourceIntegerField("projectCostId", "项目费用编码");
        projectCostIdField.setLength(11);
        projectCostIdField.setPrimaryKey(true);
        projectCostIdField.setRequired(true);
        projectCostIdField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(128);
        projectIdField.setRequired(false);
        projectIdField.setHidden(true);
//        KeyValueManager.loadValueMap("projects",projectIdField);
        KeyValueManager.loadValueMap("projects", projectIdField);

        employeeIdField = new DataSourceIntegerField("employeeId", "经办人");
        employeeIdField.setLength(64);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        costMoneyField = new DataSourceFloatField("amount", "金额");
        costMoneyField.setLength(18);
		costMoneyField.setDecimalPad(2);
		costMoneyField.setFormat("#,###,###,###,###,##0.00");
        costMoneyField.setRequired(false);
        costMoneyField.setHidden(false);

        costTypeField = new DataSourceIntegerField("costType", "费用类型");
        costTypeField.setLength(64);
        costTypeField.setRequired(false);
        costTypeField.setHidden(false);
        costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_9"));

        costDateField = new DataSourceDateField("costDate", "日期");
        costDateField.setRequired(false);
        costDateField.setHidden(false);

        setFields(projectCostIdField, projectIdField, employeeIdField, costMoneyField, costTypeField, costDateField);
    }

}
