package com.pomplatform.client.employeechangeplaterecord.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMemployeechangeplaterecordeeepyseor extends DBDataSource {

    public static DSMemployeechangeplaterecordeeepyseor instance = null;

    public static DSMemployeechangeplaterecordeeepyseor getInstance() {
        if (instance == null) {
            instance = new DSMemployeechangeplaterecordeeepyseor("DSMemployeechangeplaterecordeeepyseor");
        }
        return instance;
    }

    private final DataSourceIntegerField employeeChangePlateRecordIdField;
    private final DataSourceTextField employeeNoField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceIntegerField yearField;
    private final DataSourceIntegerField monthField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceDateTimeField createTimeField;
    private final DataSourceDateTimeField updateTimeField;

    public DSMemployeechangeplaterecordeeepyseor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Memployeechangeplaterecordeeepyseor");

        employeeChangePlateRecordIdField = new DataSourceIntegerField("employeeChangePlateRecordId", "编码");
        employeeChangePlateRecordIdField.setLength(11);
        employeeChangePlateRecordIdField.setPrimaryKey(true);
        employeeChangePlateRecordIdField.setRequired(true);
        employeeChangePlateRecordIdField.setHidden(true);

        employeeNoField = new DataSourceTextField("employeeNo", "工号");
        employeeNoField.setLength(14);
        employeeNoField.setRequired(true);
        employeeNoField.setHidden(false);

        employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
        employeeIdField.setLength(11);
        employeeIdField.setRequired(false);
        employeeIdField.setHidden(false);
        employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        yearField = new DataSourceIntegerField("year", "年份");
        yearField.setLength(11);
        yearField.setRequired(false);
        yearField.setHidden(false);
        yearField.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));

        monthField = new DataSourceIntegerField("month", "月份");
        monthField.setLength(11);
        monthField.setRequired(false);
        monthField.setHidden(false);
        monthField.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setAttribute("width", 80);
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
        
        
        
        departmentIdField = new DataSourceIntegerField("departmentId", "当前归属部门");
        departmentIdField.setAttribute("width", 80);
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
        

        createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
        createTimeField.setRequired(false);
        createTimeField.setHidden(false);

        updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
        updateTimeField.setRequired(false);
        updateTimeField.setHidden(false);

        setFields(employeeChangePlateRecordIdField, employeeNoField, employeeIdField, yearField, monthField, plateIdField,departmentIdField, createTimeField, updateTimeField);
    }

}
