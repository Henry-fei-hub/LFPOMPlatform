package com.pomplatform.client.projectcostlist.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectCostList extends DBDataSource {

    public static DSProjectCostList instance = null;

    public static DSProjectCostList getInstance() {
        if (instance == null) {
            instance = new DSProjectCostList("DSProjectCostList");
        }
        return instance;
    }

    private final DataSourceIntegerField projectCostIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceIntegerField costTypeField;
    private final DataSourceDateField costDateField;
    private final DataSourceIntegerField settlementIdField;
    private final DataSourceIntegerField statusField;
    private final DataSourceFloatField amountField;

    public DSProjectCostList(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("ProjectCostList");

        projectCostIdField = new DataSourceIntegerField("projectCostId", "项目费用编码");
        projectCostIdField.setLength(11);
        projectCostIdField.setPrimaryKey(true);
        projectCostIdField.setRequired(true);
        projectCostIdField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(false);
//        KeyValueManager.loadValueMap("projects",projectIdField);
        KeyValueManager.loadValueMap("projects",projectIdField);

        employeeIdField = new DataSourceIntegerField("employeeId", "报销人");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        costTypeField = new DataSourceIntegerField("costType", "费用类型");
        costTypeField.setLength(11);
        costTypeField.setRequired(false);
        costTypeField.setHidden(false);
        costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_9"));

        costDateField = new DataSourceDateField("costDate", "消费日期");
        costDateField.setRequired(false);
        costDateField.setHidden(false);

        settlementIdField = new DataSourceIntegerField("settlementId", "结算代码");
        settlementIdField.setLength(11);
        settlementIdField.setRequired(false);
        settlementIdField.setHidden(true);

        statusField = new DataSourceIntegerField("status", "结算状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(false);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));

        amountField = new DataSourceFloatField("amount", "金额");
        amountField.setLength(18);
        amountField.setDecimalPad(2);
        amountField.setFormat("#,###,###,###,###,##0.00");
        amountField.setRequired(false);
        amountField.setHidden(false);

        setFields(projectCostIdField, projectIdField, employeeIdField, costTypeField, costDateField, settlementIdField, amountField, statusField);
    }

}
