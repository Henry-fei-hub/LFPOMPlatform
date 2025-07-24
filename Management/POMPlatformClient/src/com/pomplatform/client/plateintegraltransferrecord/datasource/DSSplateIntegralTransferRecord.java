package com.pomplatform.client.plateintegraltransferrecord.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSplateIntegralTransferRecord extends DBDataSource {

    public static DSSplateIntegralTransferRecord instance = null;

    public static DSSplateIntegralTransferRecord getInstance() {
        if (instance == null) {
            instance = new DSSplateIntegralTransferRecord("DSSplateIntegralTransferRecord");
        }
        return instance;
    }

    private final DataSourceIntegerField plateIntegralTransferRecordIdField;
    private final DataSourceIntegerField fromPlateIdField;
    private final DataSourceIntegerField toPlateIdField;
    private final DataSourceFloatField transferIntegralField;
    private final DataSourceDateField transferDateField;
    private final DataSourceIntegerField plateEmployeeIdField;
    private final DataSourceTextField remarkField;

    public DSSplateIntegralTransferRecord(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SplateIntegralTransferRecord");

        plateIntegralTransferRecordIdField = new DataSourceIntegerField("plateIntegralTransferRecordId", "主键编码");
        plateIntegralTransferRecordIdField.setLength(11);
        plateIntegralTransferRecordIdField.setPrimaryKey(true);
        plateIntegralTransferRecordIdField.setRequired(true);
        plateIntegralTransferRecordIdField.setHidden(true);

        fromPlateIdField = new DataSourceIntegerField("fromPlateId", "积分提取部门");
        fromPlateIdField.setLength(11);
        fromPlateIdField.setRequired(false);
        fromPlateIdField.setHidden(false);
        fromPlateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        toPlateIdField = new DataSourceIntegerField("toPlateId", "积分追加部门");
        toPlateIdField.setLength(11);
        toPlateIdField.setRequired(false);
        toPlateIdField.setHidden(false);
        toPlateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        transferIntegralField = new DataSourceFloatField("transferIntegral", "转移积分");
        transferIntegralField.setLength(10);
        transferIntegralField.setDecimalPad(2);
        transferIntegralField.setFormat("##,###,##0.00");
        transferIntegralField.setRequired(false);
        transferIntegralField.setHidden(false);

        transferDateField = new DataSourceDateField("transferDate", "转移日期");
        transferDateField.setRequired(false);
        transferDateField.setHidden(false);

        plateEmployeeIdField = new DataSourceIntegerField("plateEmployeeId", "事业部负责人");
        plateEmployeeIdField.setLength(11);
        plateEmployeeIdField.setRequired(false);
        plateEmployeeIdField.setHidden(false);
        plateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        remarkField = new DataSourceTextField("remark", "备注");
        remarkField.setLength(512);
        remarkField.setRequired(false);
        remarkField.setHidden(false);

        setFields(plateIntegralTransferRecordIdField, fromPlateIdField, toPlateIdField, transferIntegralField, transferDateField, plateEmployeeIdField, remarkField);
    }

}
