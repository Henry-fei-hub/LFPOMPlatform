package com.pomplatform.client.projectintegralassign.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectIntegralAssign extends DBDataSource {

    public static DSSprojectIntegralAssign instance = null;

    public static DSSprojectIntegralAssign getInstance() {
        if (instance == null) {
            instance = new DSSprojectIntegralAssign("DSSprojectIntegralAssign");
        }
        return instance;
    }

    private final DataSourceIntegerField projectIntegralAssignRecordIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceFloatField beforeReserveIntegralField;
    private final DataSourceFloatField afterReserveIntegralField;
    private final DataSourceFloatField assignIntegralField;
    private final DataSourceDateField assignDateField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField plateEmployeeIdField;
    private final DataSourceTextField remarkField;

    public DSSprojectIntegralAssign(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SprojectIntegralAssign");

        projectIntegralAssignRecordIdField = new DataSourceIntegerField("projectIntegralAssignRecordId", "ID");
        projectIntegralAssignRecordIdField.setLength(11);
        projectIntegralAssignRecordIdField.setRequired(true);
        projectIntegralAssignRecordIdField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "积分提取项目");
        projectIdField.setLength(11);
        projectIdField.setRequired(true);
        projectIdField.setHidden(false);
//        KeyValueManager.loadValueMap("projects",projectIdField);
        KeyValueManager.loadValueMap("projects", projectIdField);

        employeeIdField = new DataSourceIntegerField("employeeId", "发放人员");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(true);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        beforeReserveIntegralField = new DataSourceFloatField("beforeReserveIntegral", "发放前预留积分");
        beforeReserveIntegralField.setLength(15);
        beforeReserveIntegralField.setDecimalPad(2);
        beforeReserveIntegralField.setFormat("#,###,###,###,##0.00");
        beforeReserveIntegralField.setRequired(true);
        beforeReserveIntegralField.setHidden(false);

        afterReserveIntegralField = new DataSourceFloatField("afterReserveIntegral", "发放后预留积分");
        afterReserveIntegralField.setLength(15);
        afterReserveIntegralField.setDecimalPad(2);
        afterReserveIntegralField.setFormat("#,###,###,###,##0.00");
        afterReserveIntegralField.setRequired(true);
        afterReserveIntegralField.setHidden(false);

        assignIntegralField = new DataSourceFloatField("assignIntegral", "发放积分");
        assignIntegralField.setLength(15);
        assignIntegralField.setDecimalPad(2);
        assignIntegralField.setFormat("#,###,###,###,##0.00");
        assignIntegralField.setRequired(true);
        assignIntegralField.setHidden(false);

        assignDateField = new DataSourceDateField("assignDate", "发放日期");
        assignDateField.setRequired(true);
        assignDateField.setHidden(false);

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(true);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        plateEmployeeIdField = new DataSourceIntegerField("plateEmployeeId", "事业部负责人");
        plateEmployeeIdField.setLength(11);
        plateEmployeeIdField.setRequired(true);
        plateEmployeeIdField.setHidden(false);
        plateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        remarkField = new DataSourceTextField("remark", "备注");
        remarkField.setLength(512);
        remarkField.setRequired(false);
        remarkField.setHidden(false);

        setFields(projectIntegralAssignRecordIdField,plateEmployeeIdField,plateIdField,  projectIdField, employeeIdField, beforeReserveIntegralField, afterReserveIntegralField, assignIntegralField, assignDateField,  remarkField);
    }

}
