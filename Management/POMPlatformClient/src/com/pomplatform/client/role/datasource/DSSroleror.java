package com.pomplatform.client.role.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;

public class DSSroleror extends DBDataSource {

    public static DSSroleror instance = null;

    public static DSSroleror getInstance() {
        if (instance == null) {
            instance = new DSSroleror("DSSroleror");
        }
        return instance;
    }

    private final DataSourceIntegerField roleIdField;
    private final DataSourceTextField roleNameField;
    private final DataSourceIntegerField applicationIdField;
    private final DataSourceIntegerField roleTypeField;
    private final DataSourceBooleanField enabledField;
    private final DataSourceField detailRoleFunction;

    public DSSroleror(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sroleror");

        roleIdField = new DataSourceIntegerField("roleId", "角色编码");
        roleIdField.setLength(11);
        roleIdField.setPrimaryKey(true);
        roleIdField.setRequired(true);
        roleIdField.setHidden(true);

        roleNameField = new DataSourceTextField("roleName", "角色名称");
        roleNameField.setLength(11);
        roleNameField.setRequired(false);
        roleNameField.setHidden(false);

        applicationIdField = new DataSourceIntegerField("applicationId", "应用系统代码");
        applicationIdField.setLength(11);
        applicationIdField.setRequired(false);
        applicationIdField.setHidden(true);

        roleTypeField = new DataSourceIntegerField("roleType", "角色类型");
        roleTypeField.setLength(11);
        roleTypeField.setRequired(false);
        roleTypeField.setHidden(false);
        roleTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_10"));

        enabledField = new DataSourceBooleanField("enabled", "是否有效");
        enabledField.setRequired(false);
        enabledField.setHidden(true);

        detailRoleFunction = new DataSourceField("detailRoleFunction", FieldType.ANY);
        detailRoleFunction.setChildrenProperty(true);
        detailRoleFunction.setChildTagName("RoleFunction");
        detailRoleFunction.setRequired(false);
        detailRoleFunction.setHidden(true);

        setFields(roleIdField, roleNameField, applicationIdField, roleTypeField, enabledField, detailRoleFunction);
    }

}
