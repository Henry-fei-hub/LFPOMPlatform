package com.pomplatform.client.projectcost.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectcostpcor extends DBDataSource {

    public static DSSprojectcostpcor instance = null;

    public static DSSprojectcostpcor getInstance() {
        if (instance == null) {
            instance = new DSSprojectcostpcor("DSSprojectcostpcor");
        }
        return instance;
    }

    private final DataSourceIntegerField projectCostIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceFloatField costMoneyField;
    private final DataSourceIntegerField costTypeField;
    private final DataSourceDateField costDateField;

    public DSSprojectcostpcor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sprojectcostpcor");

        projectCostIdField = new DataSourceIntegerField("projectCostId", "项目费用编码");
        projectCostIdField.setLength(11);
        projectCostIdField.setPrimaryKey(true);
        projectCostIdField.setRequired(true);
        projectCostIdField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(128);
        projectIdField.setRequired(false);
        projectIdField.setHidden(false);
//        KeyValueManager.loadValueMap("projects",projectIdField);
        KeyValueManager.loadValueMap("projects", projectIdField);

        employeeIdField = new DataSourceIntegerField("employeeId", "报销人");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        costMoneyField = new DataSourceFloatField("costMoney", "金额");
        costMoneyField.setLength(18);
        costMoneyField.setDecimalPad(2);
        costMoneyField.setFormat("#,###,###,###,###,##0.00");
        costMoneyField.setRequired(false);
        costMoneyField.setHidden(false);

        costTypeField = new DataSourceIntegerField("costType", "费用类型");
        costTypeField.setLength(11);
        costTypeField.setRequired(false);
        costTypeField.setHidden(false);
        costTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_9"));

        costDateField = new DataSourceDateField("costDate", "消费日期");
        costDateField.setRequired(false);
        costDateField.setHidden(false);

        setFields(projectCostIdField, projectIdField, employeeIdField, costTypeField, costDateField, costMoneyField);
    }

}
