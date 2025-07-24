package com.pomplatform.client.projectintegraltransferrecord.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMprojectintegraltransferrecord extends DBDataSource {

    public static DSMprojectintegraltransferrecord instance = null;

    public static DSMprojectintegraltransferrecord getInstance() {
        if (instance == null) {
            instance = new DSMprojectintegraltransferrecord("DSMprojectintegraltransferrecord");
        }
        return instance;
    }

    private final DataSourceImageField photoField;
    private final DataSourceIntegerField projectIntegralTransferRecordIdField;
    private final DataSourceIntegerField fromProjectIdField;
    private final DataSourceIntegerField toProjectIdField;
    private final DataSourceFloatField transferIntegralField;
    private final DataSourceDateField transferDateField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField plateEmployeeIdField;
    private final DataSourceTextField remarkField;

    public DSMprojectintegraltransferrecord(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Mprojectintegraltransferrecord");
        
        projectIntegralTransferRecordIdField = new DataSourceIntegerField("projectIntegralTransferRecordId", "主键编码");
        projectIntegralTransferRecordIdField.setLength(11);
        projectIntegralTransferRecordIdField.setPrimaryKey(true);
        projectIntegralTransferRecordIdField.setRequired(true);
        projectIntegralTransferRecordIdField.setHidden(true);

        photoField = new DataSourceImageField("photo", "头像");
        photoField.setImageHeight(60);
        photoField.setImageWidth(60);
        photoField.setRequired(false);
        photoField.setHidden(false);
        
        plateEmployeeIdField = new DataSourceIntegerField("plateEmployeeId", "事业部负责人");
        plateEmployeeIdField.setLength(11);
        plateEmployeeIdField.setRequired(false);
        plateEmployeeIdField.setHidden(false);
        plateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
        
        plateIdField = new DataSourceIntegerField("plateId", "板块");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        fromProjectIdField = new DataSourceIntegerField("fromProjectId", "积分提取项目");
        fromProjectIdField.setLength(11);
        fromProjectIdField.setRequired(false);
        fromProjectIdField.setHidden(false);
//        fromProjectIdField.setValueMap(KeyValueManager.getValueMap("projects"));
        KeyValueManager.loadValueMap("projects",fromProjectIdField);

        toProjectIdField = new DataSourceIntegerField("toProjectId", "积分追加项目");
        toProjectIdField.setLength(11);
        toProjectIdField.setRequired(false);
        toProjectIdField.setHidden(false);
//        toProjectIdField.setValueMap(KeyValueManager.getValueMap("projects"));
        KeyValueManager.loadValueMap("projects",toProjectIdField);

        transferIntegralField = new DataSourceFloatField("transferIntegral", "转移积分");
        transferIntegralField.setLength(10);
        transferIntegralField.setDecimalPad(2);
        transferIntegralField.setFormat("##,###,##0.00");
        transferIntegralField.setRequired(false);
        transferIntegralField.setHidden(false);

        transferDateField = new DataSourceDateField("transferDate", "转移日期");
        transferDateField.setRequired(false);
        transferDateField.setHidden(false);

        remarkField = new DataSourceTextField("remark", "备注");
        remarkField.setLength(512);
        remarkField.setRequired(false);
        remarkField.setHidden(false);

        setFields(projectIntegralTransferRecordIdField, photoField, plateEmployeeIdField,plateIdField,fromProjectIdField, toProjectIdField, transferIntegralField, transferDateField, remarkField);
    }

}
