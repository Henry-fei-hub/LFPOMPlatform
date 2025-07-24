package com.pomplatform.client.duty.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSemployeeDuty extends DBDataSource {

    public static DSSemployeeDuty instance = null;

    public static DSSemployeeDuty getInstance() {
        if (instance == null) {
            instance = new DSSemployeeDuty("DSSemployeeDuty");
        }
        return instance;
    }

    private final DataSourceIntegerField dutyIdField;
    private final DataSourceTextField dutyNameField;
    private final DataSourceTextField descriptionField;
    private final DataSourceIntegerField parentDutyIdField;

    public DSSemployeeDuty(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SemployeeDuty");

        dutyIdField = new DataSourceIntegerField("dutyId", "职位");
        dutyIdField.setLength(11);
        dutyIdField.setPrimaryKey(true);
        dutyIdField.setRequired(true);
        dutyIdField.setHidden(true);

        dutyNameField = new DataSourceTextField("dutyName", "职位名称");
        dutyNameField.setLength(64);
        dutyNameField.setRequired(false);
        dutyNameField.setHidden(false);

        descriptionField = new DataSourceTextField("description", "职位描述");
        descriptionField.setLength(64);
        descriptionField.setRequired(false);
        descriptionField.setHidden(false);

        parentDutyIdField = new DataSourceIntegerField("parentDutyId", "上级职位");
        parentDutyIdField.setLength(11);
        parentDutyIdField.setRequired(false);
        parentDutyIdField.setHidden(false);
        parentDutyIdField.setValueMap(KeyValueManager.getValueMap("duties"));

        setFields(dutyIdField, dutyNameField, descriptionField, parentDutyIdField);
    }

}
