package com.pomplatform.client.department.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSdepartmentdor extends DBDataSource {

    public static DSSdepartmentdor instance = null;

    public static DSSdepartmentdor getInstance() {
        if (instance == null) {
            instance = new DSSdepartmentdor("DSSdepartmentdor");
        }
        return instance;
    }

    private final DataSourceIntegerField departmentIdField;
    private final DataSourceTextField departmentNameField;
    private final DataSourceTextField abbreviationField;
    private final DataSourceIntegerField managerIdField;
    private final DataSourceTextField managerNameField;
    private final DataSourceIntegerField parentIdField;
    private final DataSourceBooleanField enabledField;

    public DSSdepartmentdor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sdepartmentdor");

        departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
        departmentIdField.setLength(11);
        departmentIdField.setPrimaryKey(true);
        departmentIdField.setRequired(true);
        departmentIdField.setHidden(true);

        departmentNameField = new DataSourceTextField("departmentName", "部门名称");
        departmentNameField.setLength(64);
        departmentNameField.setRequired(true);
        departmentNameField.setHidden(false);

        abbreviationField = new DataSourceTextField("abbreviation", "部门名称缩写");
        abbreviationField.setLength(64);
        abbreviationField.setRequired(false);
        abbreviationField.setHidden(false);

        managerIdField = new DataSourceIntegerField("managerId", "部门负责人");
        managerIdField.setLength(11);
        managerIdField.setRequired(false);
        managerIdField.setHidden(false);
        managerIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        managerNameField = new DataSourceTextField("managerName", "部门负责人");
        managerNameField.setLength(64);
        managerNameField.setRequired(false);
        managerNameField.setHidden(true);

        parentIdField = new DataSourceIntegerField("parentId", "上级部门");
        parentIdField.setLength(11);
        parentIdField.setRequired(false);
        parentIdField.setHidden(false);
        parentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

        enabledField = new DataSourceBooleanField("enabled", "是否有效");
        enabledField.setRequired(false);
        enabledField.setHidden(true);

        setFields(departmentIdField, departmentNameField, abbreviationField, managerIdField, managerNameField, parentIdField, enabledField);
    }

}
