package com.pomplatform.client.plateintegralassignrecord.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSplateIntegralAssignRecord extends DBDataSource {

    public static DSSplateIntegralAssignRecord instance = null;

    public static DSSplateIntegralAssignRecord getInstance() {
        if (instance == null) {
            instance = new DSSplateIntegralAssignRecord("DSSplateIntegralAssignRecord");
        }
        return instance;
    }

    private final DataSourceIntegerField plateIntegralAssignRecordIdField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceFloatField assignIntegralField;
    private final DataSourceDateField assignDateField;
    private final DataSourceIntegerField plateEmployeeIdField;
    private final DataSourceTextField remarkField;

    public DSSplateIntegralAssignRecord(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SplateIntegralAssignRecord");

        plateIntegralAssignRecordIdField = new DataSourceIntegerField("plateIntegralAssignRecordId", "主键编码");
        plateIntegralAssignRecordIdField.setLength(11);
        plateIntegralAssignRecordIdField.setPrimaryKey(true);
        plateIntegralAssignRecordIdField.setRequired(true);
        plateIntegralAssignRecordIdField.setHidden(true);

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        employeeIdField = new DataSourceIntegerField("employeeId", "发放人员");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        assignIntegralField = new DataSourceFloatField("assignIntegral", "发放积分");
        assignIntegralField.setLength(10);
        assignIntegralField.setDecimalPad(2);
        assignIntegralField.setFormat("##,###,##0.00");
        assignIntegralField.setRequired(false);
        assignIntegralField.setHidden(false);

        assignDateField = new DataSourceDateField("assignDate", "发放日期");
        assignDateField.setRequired(false);
        assignDateField.setHidden(false);

        plateEmployeeIdField = new DataSourceIntegerField("plateEmployeeId", "部门负责人");
        plateEmployeeIdField.setLength(11);
        plateEmployeeIdField.setRequired(false);
        plateEmployeeIdField.setHidden(false);
        plateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        remarkField = new DataSourceTextField("remark", "备注");
        remarkField.setLength(512);
        remarkField.setRequired(false);
        remarkField.setHidden(false);

        setFields(plateIntegralAssignRecordIdField, plateIdField, employeeIdField, assignIntegralField, assignDateField, plateEmployeeIdField, remarkField);
    }

}
