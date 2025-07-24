package com.pomplatform.client.report.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.*;

public class DSWorkingProjectReportManage extends DBDataSource {

    public static DSWorkingProjectReportManage instance = null;

    public static DSWorkingProjectReportManage getInstance() {
        if(instance == null) {
            instance = new DSWorkingProjectReportManage("DSWorkingProjectReportManage");
        }
        return instance;
    }

    private final DataSourceTextField employeeNoField;
    private final DataSourceTextField employeeIdField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceDateField workDateField;
    private final DataSourceFloatField workHourField;
    private final DataSourceFloatField coefficientField;
    private final DataSourceFloatField statisticalWorkHourField;

    public DSWorkingProjectReportManage(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("ReportEmployeeDailyHoursTotal");

        employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
        employeeNoField.setLength(64);
        employeeNoField.setRequired(true);
        employeeNoField.setHidden(false);

        employeeIdField = new DataSourceTextField("employeeId", "员工姓名");
        employeeIdField.setRequired(true);
        employeeIdField.setLength(11);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


        plateIdField = new DataSourceIntegerField("plateId", "部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
        plateIdField.setHidden(false);


        workDateField = new DataSourceDateField("workDate", "日期");
        workDateField.setRequired(false);
        workDateField.setHidden(false);


        workHourField = new DataSourceFloatField("workHour", "填报工时");
        workHourField.setLength(10);
        workHourField.setDecimalPad(1);
        workHourField.setFormat("###,###,##0.0");
        workHourField.setRequired(false);
        workHourField.setHidden(false);


        coefficientField = new DataSourceFloatField("coefficient", "职级系数");
        coefficientField.setLength(32);
        coefficientField.setDecimalPad(2);
        coefficientField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
        coefficientField.setRequired(false);
        coefficientField.setHidden(false);


        statisticalWorkHourField = new DataSourceFloatField("statisticalWorkHour", "统计工时");
        statisticalWorkHourField.setLength(18);
        statisticalWorkHourField.setDecimalPad(2);
        statisticalWorkHourField.setFormat("#,###,###,###,###,##0.00");
        statisticalWorkHourField.setRequired(true);
        statisticalWorkHourField.setHidden(false);


        setFields(employeeNoField, employeeIdField, plateIdField, workDateField, workHourField, coefficientField, statisticalWorkHourField);
    }

}
