package com.pomplatform.client.function.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;

public class DSSfunctionffor extends DBDataSource {

    public static DSSfunctionffor instance = null;

    public static DSSfunctionffor getInstance() {
        if (instance == null) {
            instance = new DSSfunctionffor("DSSfunctionffor");
        }
        return instance;
    }

    private final DataSourceIntegerField functionIdField;
    private final DataSourceTextField functionCodeField;
    private final DataSourceIntegerField parentIdField;
    private final DataSourceTextField functionNameField;
    private final DataSourceIntegerField applicationIdField;
    private final DataSourceIntegerField functionTypeField;
    private final DataSourceIntegerField privilegeTypeField;
    private final DataSourceBooleanField enabledField;

    public DSSfunctionffor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sfunctionffor");

        functionIdField = new DataSourceIntegerField("functionId", "功能编码");
        functionIdField.setLength(11);
        functionIdField.setPrimaryKey(true);
        functionIdField.setRequired(true);
        functionIdField.setHidden(false);

        functionCodeField = new DataSourceTextField("functionCode", "功能编号");
        functionCodeField.setLength(64);
        functionCodeField.setRequired(false);
        functionCodeField.setHidden(false);

        parentIdField = new DataSourceIntegerField("parentId", "上级功能");
        parentIdField.setLength(11);
        parentIdField.setRequired(false);
        parentIdField.setHidden(true);

        functionNameField = new DataSourceTextField("functionName", "功能名称");
        functionNameField.setLength(64);
        functionNameField.setRequired(false);
        functionNameField.setHidden(false);

        applicationIdField = new DataSourceIntegerField("applicationId", "应用系统代码");
        applicationIdField.setLength(11);
        applicationIdField.setRequired(false);
        applicationIdField.setHidden(true);

        functionTypeField = new DataSourceIntegerField("functionType", "功能类型");
        functionTypeField.setLength(11);
        functionTypeField.setRequired(false);
        functionTypeField.setHidden(true);

        privilegeTypeField = new DataSourceIntegerField("privilegeType", "数据权限类型");
        privilegeTypeField.setLength(11);
        privilegeTypeField.setRequired(false);
        privilegeTypeField.setHidden(true);

        enabledField = new DataSourceBooleanField("enabled", "是否有效");
        enabledField.setRequired(false);
        enabledField.setHidden(false);

        setFields(functionIdField, functionCodeField, parentIdField, functionNameField, applicationIdField, functionTypeField, privilegeTypeField, enabledField);
    }

}
