package com.pomplatform.client.report.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.*;

public class DSWorkingHourReportManage extends DBDataSource {

    public static DSWorkingHourReportManage instance = null;

    public static DSWorkingHourReportManage getInstance() {
        if(instance == null) {
            instance = new DSWorkingHourReportManage("DSWorkingHourReportManage");
        }
        return instance;
    }

    private final DataSourceTextField projectCodeField;
    private final DataSourceTextField projectNameField;
    private final DataSourceFloatField workHourField;
    private final DataSourceDateField workDateField;


    public DSWorkingHourReportManage(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("WorkingHourManage");


        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(false);
        projectCodeField.setHidden(false);


        projectNameField = new DataSourceTextField("projectName", "项目名称");
        projectNameField.setLength(512);
        projectNameField.setRequired(false);
        projectNameField.setHidden(false);



        workDateField = new DataSourceDateField("workDate", "日期");
        workDateField.setRequired(false);
        workDateField.setHidden(false);

        workHourField = new DataSourceFloatField("workHour", "工时");
        workHourField.setLength(10);
        workHourField.setDecimalPad(1);
        workHourField.setFormat("###,###,##0.0");
        workHourField.setRequired(false);
        workHourField.setHidden(false);

        setFields(projectCodeField, projectNameField, workDateField,workHourField);
    }



}
