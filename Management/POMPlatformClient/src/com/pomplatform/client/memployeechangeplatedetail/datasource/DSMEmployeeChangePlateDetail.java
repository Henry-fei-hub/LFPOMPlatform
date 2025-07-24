package com.pomplatform.client.memployeechangeplatedetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMEmployeeChangePlateDetail extends DBDataSource {

    public static DSMEmployeeChangePlateDetail instance = null;

    public static DSMEmployeeChangePlateDetail getInstance() {
        if (instance == null) {
            instance = new DSMEmployeeChangePlateDetail("DSMEmployeeChangePlateDetail");
        }
        return instance;
    }

    private final DataSourceIntegerField employeeChangePlateDetailIdField;
    private final DataSourceTextField employeeNoField;
    private final DataSourceIntegerField employeeIdField;
    private final DataSourceIntegerField yearField;
    private final DataSourceIntegerField monthField;
    private final DataSourceIntegerField outPlateIdField;
    private final DataSourceIntegerField inPlateIdField;
    private final DataSourceTextField remarkField;
    private final DataSourceDateTimeField createTimeField;
    private final DataSourceDateTimeField updateTimeField;

    public DSMEmployeeChangePlateDetail(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MEmployeeChangePlateDetail");

        employeeChangePlateDetailIdField = new DataSourceIntegerField("employeeChangePlateDetailId", "编码");
        employeeChangePlateDetailIdField.setLength(11);
        employeeChangePlateDetailIdField.setPrimaryKey(true);
        employeeChangePlateDetailIdField.setRequired(true);
        employeeChangePlateDetailIdField.setHidden(true);

        employeeNoField = new DataSourceTextField("employeeNo", "工号");
        employeeNoField.setLength(64);
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

        outPlateIdField = new DataSourceIntegerField("outPlateId", "转出业务部门");
        outPlateIdField.setLength(11);
        outPlateIdField.setRequired(false);
        outPlateIdField.setHidden(false);
        outPlateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        inPlateIdField = new DataSourceIntegerField("inPlateId", "转入业务部门");
        inPlateIdField.setLength(11);
        inPlateIdField.setRequired(false);
        inPlateIdField.setHidden(false);
        inPlateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        remarkField = new DataSourceTextField("remark", "转岗原因");
        remarkField.setLength(400);
        remarkField.setRequired(false);
        remarkField.setHidden(false);

        createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
        createTimeField.setRequired(false);
        createTimeField.setHidden(false);

        updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
        updateTimeField.setRequired(false);
        updateTimeField.setHidden(false);

        setFields(employeeChangePlateDetailIdField, employeeNoField, employeeIdField, yearField, monthField, outPlateIdField, inPlateIdField, remarkField, createTimeField, updateTimeField);
    }

}
