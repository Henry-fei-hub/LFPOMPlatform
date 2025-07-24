package com.pomplatform.client.projectlog.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;

public class DSSprojectlogppoor extends DBDataSource {

    public static DSSprojectlogppoor instance = null;

    public static DSSprojectlogppoor getInstance() {
        if (instance == null) {
            instance = new DSSprojectlogppoor("DSSprojectlogppoor");
        }
        return instance;
    }

    private final DataSourceIntegerField projectLogIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField operateIdField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceIntegerField managerIdField;
    private final DataSourceIntegerField designPhaseField;
    private final DataSourceDateTimeField operateTimeField;
    private final DataSourceIntegerField logTypeField;
    private final DataSourceTextField logContentField;
    private final DataSourceTextField alternateField1Field;
    private final DataSourceTextField alternateField2Field;
    private final DataSourceTextField alternateField3Field;
    private final DataSourceIntegerField statusField;

    public DSSprojectlogppoor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sprojectlogppoor");

        projectLogIdField = new DataSourceIntegerField("projectLogId", "项目日志编码");
        projectLogIdField.setLength(11);
        projectLogIdField.setPrimaryKey(true);
        projectLogIdField.setRequired(true);
        projectLogIdField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(false);
        KeyValueManager.loadValueMap("projects",projectIdField);

        operateIdField = new DataSourceIntegerField("operateId", "操作人");
        operateIdField.setLength(11);
        operateIdField.setRequired(false);
        operateIdField.setHidden(false);
        operateIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

        managerIdField = new DataSourceIntegerField("managerId", "板块负责人");
        managerIdField.setLength(11);
        managerIdField.setRequired(false);
        managerIdField.setHidden(false);
        managerIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
        designPhaseField.setLength(11);
        designPhaseField.setRequired(false);
        designPhaseField.setHidden(false);
        designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

        operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
        operateTimeField.setRequired(false);
        operateTimeField.setHidden(false);

        logTypeField = new DataSourceIntegerField("logType", "日志类型");
        logTypeField.setLength(11);
        logTypeField.setRequired(false);
        logTypeField.setHidden(true);

        logContentField = new DataSourceTextField("logContent", "日志内容");
        logContentField.setLength(512);
        logContentField.setRequired(false);
        logContentField.setHidden(false);

        alternateField1Field = new DataSourceTextField("alternateField1", "备用字段1");
        alternateField1Field.setLength(512);
        alternateField1Field.setRequired(false);
        alternateField1Field.setHidden(true);

        alternateField2Field = new DataSourceTextField("alternateField2", "备用字段2");
        alternateField2Field.setLength(512);
        alternateField2Field.setRequired(false);
        alternateField2Field.setHidden(true);

        alternateField3Field = new DataSourceTextField("alternateField3", "备用字段3");
        alternateField3Field.setLength(512);
        alternateField3Field.setRequired(false);
        alternateField3Field.setHidden(true);

        statusField = new DataSourceIntegerField("status", "状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(true);

        setFields(projectLogIdField, projectIdField, operateIdField, departmentIdField, managerIdField, designPhaseField, operateTimeField, logTypeField, logContentField, alternateField1Field, alternateField2Field, alternateField3Field, statusField);
    }

}
