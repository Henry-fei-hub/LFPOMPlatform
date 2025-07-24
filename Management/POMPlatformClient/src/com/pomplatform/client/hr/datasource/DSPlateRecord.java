package com.pomplatform.client.hr.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateRecord extends DBDataSource {

    public static DSPlateRecord instance = null;

    public static DSPlateRecord getInstance() {
        if (instance == null) {
            instance = new DSPlateRecord("DSPlateRecord");
        }
        return instance;
    }

    private final DataSourceIntegerField plateRecordIdField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceTextField plateNameField;
    private final DataSourceTextField plateCodeField;
    private final DataSourceTextField hrCodeField;
    private final DataSourceIntegerField plateTypeField;
    private final DataSourceIntegerField plateManagerIdField;
    private final DataSourceIntegerField parentIdField;
    private final DataSourceBooleanField enabledField;

    public DSPlateRecord(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_TABLE);
        setActionName("PlateRecord");

        plateRecordIdField = new DataSourceIntegerField("plateRecordId", "主键Id");
        plateRecordIdField.setLength(11);
        plateRecordIdField.setPrimaryKey(true);
        plateRecordIdField.setRequired(true);
        plateRecordIdField.setHidden(true);
        
        plateIdField = new DataSourceIntegerField("plateId", "业务板块ID");
        plateIdField.setLength(11);
        plateIdField.setHidden(true);

        plateNameField = new DataSourceTextField("plateName", "业务板块名称");
        plateNameField.setLength(64);
        plateNameField.setRequired(true);
        plateNameField.setHidden(false);

        plateCodeField = new DataSourceTextField("plateCode", "业务板块编码");
        plateCodeField.setLength(64);
        plateCodeField.setRequired(false);
        plateCodeField.setHidden(false);
        
        hrCodeField = new DataSourceTextField("hrCode", "人事编码");
        hrCodeField.setLength(64);
        hrCodeField.setRequired(false);
        hrCodeField.setHidden(false);

        plateTypeField = new DataSourceIntegerField("plateType", "部门类型");
        plateTypeField.setLength(11);
        plateTypeField.setRequired(false);
        plateTypeField.setHidden(false);
        plateTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_164"));
        
        plateManagerIdField = new DataSourceIntegerField("plateManagerId", "板块负责人");
        plateManagerIdField.setLength(11);
        plateManagerIdField.setRequired(false);
        plateManagerIdField.setHidden(true);
//        plateManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));
        KeyValueManager.loadValueMap("employees",plateManagerIdField);

        parentIdField = new DataSourceIntegerField("parentId", "上级板块");
        parentIdField.setLength(11);
        parentIdField.setRequired(false);
        parentIdField.setForeignKey(dataSourceID + ".plateRecordId");
        parentIdField.setRootValue("0");
        parentIdField.setHidden(false);

        enabledField = new DataSourceBooleanField("enabled", "是否有效");
        enabledField.setRequired(false);
        enabledField.setHidden(true);

        setFields(plateRecordIdField, plateIdField,plateNameField, plateCodeField,hrCodeField,plateTypeField, plateManagerIdField, parentIdField, enabledField);
    }

}
