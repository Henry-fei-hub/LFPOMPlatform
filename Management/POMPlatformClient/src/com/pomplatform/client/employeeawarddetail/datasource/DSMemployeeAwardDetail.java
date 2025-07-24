package com.pomplatform.client.employeeawarddetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMemployeeAwardDetail extends DBDataSource {

    public static DSMemployeeAwardDetail instance = null;

    public static DSMemployeeAwardDetail getInstance() {
        if (instance == null) {
            instance = new DSMemployeeAwardDetail("DSMemployeeAwardDetail");
        }
        return instance;
    }

    private final DataSourceImageField photoField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceTextField employeeNameField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField yearsField;
    private final DataSourceIntegerField monthsField;
    private final DataSourceFloatField planIntegralField;
    private final DataSourceFloatField sureIntegralField;
    private final DataSourceFloatField projectCostField;
    private final DataSourceFloatField achieveIntegralField;
    private final DataSourceFloatField achieveAwardField;
    private final DataSourceFloatField baseSalaryField;

    public DSMemployeeAwardDetail(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MemployeeAwardDetail");

        photoField = new DataSourceImageField("photo", "头像");
        photoField.setImageHeight(60);
        photoField.setImageWidth(60);
        photoField.setRequired(false);
        photoField.setHidden(false);

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(false);
        KeyValueManager.loadValueMap("projects",projectIdField);

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

        plateIdField = new DataSourceIntegerField("plateId", "板块");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        yearsField = new DataSourceIntegerField("years", "年份");
        yearsField.setLength(11);
        yearsField.setRequired(true);
        yearsField.setHidden(false);
        yearsField.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));

        monthsField = new DataSourceIntegerField("months", "月份");
        monthsField.setLength(11);
        monthsField.setRequired(true);
        monthsField.setHidden(false);
        monthsField.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));

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
        achieveAwardField.setHidden(true);

        baseSalaryField = new DataSourceFloatField("baseSalary", "人工成本");
        baseSalaryField.setLength(18);
        baseSalaryField.setDecimalPad(2);
        baseSalaryField.setFormat("#,###,###,###,###,##0.00");
        baseSalaryField.setRequired(true);
        baseSalaryField.setHidden(true);

        setFields(photoField, employeeIdField, employeeNameField,projectIdField, departmentIdField, plateIdField, yearsField, monthsField, planIntegralField, sureIntegralField, projectCostField, achieveIntegralField, achieveAwardField, baseSalaryField);
    }

}
