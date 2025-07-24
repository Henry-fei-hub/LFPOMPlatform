package com.pomplatform.client.employeeawardtotal.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMemployeeAwardTotal extends DBDataSource {

    public static DSMemployeeAwardTotal instance = null;

    public static DSMemployeeAwardTotal getInstance() {
        if (instance == null) {
            instance = new DSMemployeeAwardTotal("DSMemployeeAwardTotal");
        }
        return instance;
    }

    private final DataSourceImageField photoField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceTextField employeeNameField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceFloatField planIntegralField;
    private final DataSourceFloatField sureIntegralField;
    private final DataSourceFloatField projectCostField;
    private final DataSourceFloatField achieveIntegralField;
    private final DataSourceFloatField achieveAwardField;
    private final DataSourceFloatField baseSalaryField;

    public DSMemployeeAwardTotal(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MemployeeAwardTotal");

        photoField = new DataSourceImageField("photo", "头像");
        photoField.setImageHeight(60);
        photoField.setImageWidth(60);
        photoField.setRequired(false);
        photoField.setHidden(false);

        employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(true);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
        employeeNameField.setLength(64);
        employeeNameField.setRequired(true);
        employeeNameField.setHidden(false);

        departmentIdField = new DataSourceIntegerField("departmentId", "部门");
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


        planIntegralField = new DataSourceFloatField("planIntegral", "预分配积分");
        planIntegralField.setLength(0);
        planIntegralField.setDecimalPad(0);
        planIntegralField.setFormat("");
        planIntegralField.setRequired(false);
        planIntegralField.setHidden(false);

        sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
        sureIntegralField.setLength(18);
        sureIntegralField.setDecimalPad(2);
        sureIntegralField.setFormat("#,###,###,###,###,##0.00");
        sureIntegralField.setRequired(true);
        sureIntegralField.setHidden(false);

        projectCostField = new DataSourceFloatField("projectCost", "项目成本");
        projectCostField.setLength(18);
        projectCostField.setDecimalPad(2);
        projectCostField.setFormat("#,###,###,###,###,##0.00");
        projectCostField.setRequired(false);
        projectCostField.setHidden(false);

        achieveIntegralField = new DataSourceFloatField("achieveIntegral", "结算积分");
        achieveIntegralField.setLength(18);
        achieveIntegralField.setDecimalPad(2);
        achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
        achieveIntegralField.setRequired(true);
        achieveIntegralField.setHidden(false);

        achieveAwardField = new DataSourceFloatField("achieveAward", "价值积分");
        achieveAwardField.setLength(18);
        achieveAwardField.setDecimalPad(2);
        achieveAwardField.setFormat("#,###,###,###,###,##0.00");
        achieveAwardField.setRequired(true);
        achieveAwardField.setHidden(false);

        baseSalaryField = new DataSourceFloatField("baseSalary", "人工成本");
        baseSalaryField.setLength(18);
        baseSalaryField.setDecimalPad(2);
        baseSalaryField.setFormat("#,###,###,###,###,##0.00");
        baseSalaryField.setRequired(true);
        baseSalaryField.setHidden(true);

        setFields(photoField, employeeIdField, employeeNameField, departmentIdField, planIntegralField, sureIntegralField, projectCostField, achieveIntegralField, achieveAwardField, baseSalaryField);
    }

}
