package com.pomplatform.client.report.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSReportEmployeeDailyHoursDetailTotal extends DBDataSource
{


    public static DSReportEmployeeDailyHoursDetailTotal instance = null;

    public static DSReportEmployeeDailyHoursDetailTotal getInstance() {
        if(instance == null) {
            instance = new DSReportEmployeeDailyHoursDetailTotal("DSReportEmployeeDailyHoursDetailTotal");
        }
        return instance;
    }

    private final DataSourceIntegerField employeeIdField;
    private final DataSourceTextField employeeNoField;
    private final DataSourceTextField employeeNameField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceDateField workDateField;
    private final DataSourceFloatField workHourField;
    private final DataSourceIntegerField projectNumberField;

    public DSReportEmployeeDailyHoursDetailTotal(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("ReportEmployeeDailyHoursTotal");


        employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
        employeeNoField.setLength(64);
        employeeNoField.setRequired(true);
        employeeNoField.setHidden(false);
        employeeNoField.setValueMap(KeyValueManager.getValueMap(""));

        employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
        employeeIdField.setLength(11);
        employeeIdField.setPrimaryKey(true);
        employeeIdField.setRequired(true);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


        employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
        employeeNameField.setLength(64);
        employeeNameField.setRequired(true);
        employeeNameField.setHidden(true);

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
        plateIdField.setHidden(false);


        workDateField = new DataSourceDateField("workDate", "日期");
        workDateField.setRequired(false);
        workDateField.setHidden(false);


        workHourField = new DataSourceFloatField("workHour", "工时");
        workHourField.setLength(10);
        workHourField.setDecimalPad(1);
        workHourField.setFormat("###,###,##0.0");
        workHourField.setRequired(false);
        workHourField.setHidden(false);


        projectNumberField = new DataSourceIntegerField("projectNumber", "项目数");
        projectNumberField.setLength(-1);
        projectNumberField.setRequired(true);
        projectNumberField.setHidden(false);


        setFields(employeeIdField, employeeNoField, employeeNameField, plateIdField, workDateField, workHourField, projectNumberField);
    }


}
