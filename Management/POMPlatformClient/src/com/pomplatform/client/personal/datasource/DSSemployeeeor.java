package com.pomplatform.client.personal.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSemployeeeor extends DBDataSource {

    public static DSSemployeeeor instance = null;

    public static DSSemployeeeor getInstance() {
        if (instance == null) {
            instance = new DSSemployeeeor("DSSemployeeeor");
        }
        return instance;
    }

    private final DataSourceIntegerField employeeIdField;
    private final DataSourceTextField employeeNoField;
    private final DataSourceTextField employeeNameField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceIntegerField roleIdField;
    private final DataSourceIntegerField gradeIdField;
    private final DataSourceTextField mobileField;
    private final DataSourceTextField phoneField;
    private final DataSourceTextField qqField;
    private final DataSourceTextField emailField;
    private final DataSourceTextField photoField;
    private final DataSourceTextField addressField;
    private final DataSourceIntegerField plateIdField;

    public DSSemployeeeor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Semployeeeor");

        employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
        employeeIdField.setLength(11);
        employeeIdField.setPrimaryKey(true);
        employeeIdField.setRequired(true);
        employeeIdField.setHidden(false);

        employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
        employeeNoField.setLength(64);
        employeeNoField.setRequired(true);
        employeeNoField.setHidden(false);

        employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
        employeeNameField.setLength(64);
        employeeNameField.setRequired(true);
        employeeNameField.setHidden(false);

        departmentIdField = new DataSourceIntegerField("departmentId", "角色编码");
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

        roleIdField = new DataSourceIntegerField("roleId", "部门编码");
        roleIdField.setLength(11);
        roleIdField.setRequired(false);
        roleIdField.setHidden(false);
//        roleIdField.setValueMap(KeyValueManager.getValueMap("roles"));
        KeyValueManager.loadValueMap("roles",roleIdField);
        gradeIdField = new DataSourceIntegerField("gradeId", "等级");
        gradeIdField.setLength(11);
        gradeIdField.setRequired(false);
        gradeIdField.setHidden(false);
        gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));

        mobileField = new DataSourceTextField("mobile", "手机");
        mobileField.setLength(64);
        mobileField.setRequired(false);
        mobileField.setHidden(false);

        phoneField = new DataSourceTextField("phone", "电话");
        phoneField.setLength(64);
        phoneField.setRequired(false);
        phoneField.setHidden(false);

        qqField = new DataSourceTextField("qq", "QQ");
        qqField.setLength(64);
        qqField.setRequired(false);
        qqField.setHidden(false);

        emailField = new DataSourceTextField("email", "邮箱");
        emailField.setLength(64);
        emailField.setRequired(false);
        emailField.setHidden(false);

        photoField = new DataSourceTextField("photo", "头像");
        photoField.setLength(512);
        photoField.setRequired(false);
        photoField.setHidden(false);

        addressField = new DataSourceTextField("address", "家庭地址");
        addressField.setLength(512);
        addressField.setRequired(false);
        addressField.setHidden(false);

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        setFields(employeeIdField, employeeNoField, employeeNameField, departmentIdField, roleIdField, gradeIdField, mobileField, phoneField, qqField, emailField, photoField, addressField, plateIdField);
    }

}
