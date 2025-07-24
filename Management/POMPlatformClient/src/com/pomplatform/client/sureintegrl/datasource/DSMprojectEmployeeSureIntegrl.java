package com.pomplatform.client.sureintegrl.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMprojectEmployeeSureIntegrl extends DBDataSource {

    public static DSMprojectEmployeeSureIntegrl instance = null;

    public static DSMprojectEmployeeSureIntegrl getInstance() {
        if (instance == null) {
            instance = new DSMprojectEmployeeSureIntegrl("DSMprojectEmployeeSureIntegrl");
        }
        return instance;
    }

    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceFloatField planIntegralField;
    private final DataSourceIntegerField assignSureIntegralField;
    private final DataSourceFloatField stageSureIntegralField;
    private final DataSourceTextField sureIntegralField;

    public DSMprojectEmployeeSureIntegrl(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MprojectEmployeeSureIntegrl");

        projectIdField = new DataSourceIntegerField("projectId", "项目");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(true);
        KeyValueManager.loadValueMap("projects",projectIdField);

        employeeIdField = new DataSourceIntegerField("employeeId", "项目成员");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
        employeeIdField.setCanEdit(false);
//        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
        KeyValueManager.loadValueMap("employees",employeeIdField);

        planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
        planIntegralField.setLength(0);
        planIntegralField.setDecimalPad(0);
        planIntegralField.setFormat("");
        planIntegralField.setRequired(false);
        planIntegralField.setHidden(false);
        planIntegralField.setCanEdit(false);

        assignSureIntegralField = new DataSourceIntegerField("assignSureIntegral", "分配确认积分");
        assignSureIntegralField.setLength(11);
        assignSureIntegralField.setRequired(true);
        assignSureIntegralField.setHidden(false);

        stageSureIntegralField = new DataSourceFloatField("stageSureIntegral", "阶段已确认积分");
        stageSureIntegralField.setLength(10);
        stageSureIntegralField.setDecimalPad(2);
        stageSureIntegralField.setFormat("##,###,##0.00");
        stageSureIntegralField.setRequired(false);
        stageSureIntegralField.setHidden(false);
        stageSureIntegralField.setCanEdit(false);
        
        sureIntegralField = new DataSourceTextField("sureIntegral", "项目已确认积分");
        sureIntegralField.setLength(10);
        sureIntegralField.setDecimalPad(2);
        sureIntegralField.setFormat("##,###,##0.00");
        sureIntegralField.setRequired(false);
        sureIntegralField.setHidden(false);
        sureIntegralField.setCanEdit(false);

        setFields(projectIdField, employeeIdField, planIntegralField, assignSureIntegralField,stageSureIntegralField, sureIntegralField);
    }

}
