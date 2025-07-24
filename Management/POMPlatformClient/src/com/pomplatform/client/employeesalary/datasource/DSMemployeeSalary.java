package com.pomplatform.client.employeesalary.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMemployeeSalary extends DBDataSource {

    public static DSMemployeeSalary instance = null;

    public static DSMemployeeSalary getInstance() {
        if (instance == null) {
            instance = new DSMemployeeSalary("DSMemployeeSalary");
        }
        return instance;
    }

    private final DataSourceIntegerField employeeIdField;
    private final DataSourceImageField photoField;
    private final DataSourceTextField employeeNameField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceTextField salaryYearField;
    private final DataSourceTextField salaryMonthField;
    private final DataSourceTextField basicSalaryField;

    public DSMemployeeSalary(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MemployeeSalary");

        employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(true);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        photoField = new DataSourceImageField("photo", "头像");
        photoField.setImageHeight(60);
        photoField.setImageWidth(60);
        photoField.setRequired(false);
        photoField.setHidden(false);

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

        salaryYearField = new DataSourceTextField("salaryYear", "年份");
        salaryYearField.setLength(64);
        salaryYearField.setRequired(false);
        salaryYearField.setHidden(false);
        salaryYearField.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));

        salaryMonthField = new DataSourceTextField("salaryMonth", "月份");
        salaryMonthField.setLength(64);
        salaryMonthField.setRequired(false);
        salaryMonthField.setHidden(false);
        salaryMonthField.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));

        basicSalaryField = new DataSourceTextField("basicSalary", "基本工资");
        basicSalaryField.setLength(64);
        basicSalaryField.setRequired(false);
        basicSalaryField.setHidden(false);

        setFields(employeeIdField, photoField, employeeNameField, departmentIdField, plateIdField, salaryYearField, salaryMonthField, basicSalaryField);
    }

}
