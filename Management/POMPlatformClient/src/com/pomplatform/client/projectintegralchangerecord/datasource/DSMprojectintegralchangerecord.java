package com.pomplatform.client.projectintegralchangerecord.datasource;

import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;
import com.pomplatform.client.data.RoleDefinition;

public class DSMprojectintegralchangerecord extends DBDataSource {

    public static DSMprojectintegralchangerecord instance = null;

    public static DSMprojectintegralchangerecord getInstance() {
        if (instance == null) {
            instance = new DSMprojectintegralchangerecord("DSMprojectintegralchangerecord");
        }
        return instance;
    }

    private final DataSourceImageField photoField;
    private final DataSourceIntegerField projectIntegralChangeRecordIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceFloatField beforeProjectIntegralField;
    private final DataSourceFloatField afterProjectIntegralField;
    private final DataSourceFloatField beforeReserveIntegralField;
    private final DataSourceFloatField afterReserveIntegralField;
    private final DataSourceFloatField transferIntegralField;
    private final DataSourceDateField transferDateField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField plateEmployeeIdField;
    private final DataSourceTextField remarkField;

    public DSMprojectintegralchangerecord(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Mprojectintegralchangerecord");

        photoField = new DataSourceImageField("photo", "头像");
        photoField.setImageHeight(60);
        photoField.setImageWidth(60);
        photoField.setRequired(false);
        photoField.setHidden(false);

        projectIntegralChangeRecordIdField = new DataSourceIntegerField("projectIntegralChangeRecordId", "主键编码");
        projectIntegralChangeRecordIdField.setLength(11);
        projectIntegralChangeRecordIdField.setPrimaryKey(true);
        projectIntegralChangeRecordIdField.setRequired(true);
        projectIntegralChangeRecordIdField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(false);
        KeyValueManager.loadValueMap("projects",projectIdField);

        beforeProjectIntegralField = new DataSourceFloatField("beforeProjectIntegral", "调整前项目积分");
        beforeProjectIntegralField.setLength(10);
        beforeProjectIntegralField.setDecimalPad(2);
        beforeProjectIntegralField.setFormat("##,###,##0.00");
        beforeProjectIntegralField.setRequired(false);
        beforeProjectIntegralField.setHidden(false);

        afterProjectIntegralField = new DataSourceFloatField("afterProjectIntegral", "调整后项目积分");
        afterProjectIntegralField.setLength(10);
        afterProjectIntegralField.setDecimalPad(2);
        afterProjectIntegralField.setFormat("##,###,##0.00");
        afterProjectIntegralField.setRequired(false);
        afterProjectIntegralField.setHidden(false);

        beforeReserveIntegralField = new DataSourceFloatField("beforeReserveIntegral", "调整前预留积分");
        beforeReserveIntegralField.setLength(10);
        beforeReserveIntegralField.setDecimalPad(2);
        beforeReserveIntegralField.setFormat("##,###,##0.00");
        beforeReserveIntegralField.setRequired(false);
        beforeReserveIntegralField.setHidden(true);

        afterReserveIntegralField = new DataSourceFloatField("afterReserveIntegral", "调整后预留积分");
        afterReserveIntegralField.setLength(10);
        afterReserveIntegralField.setDecimalPad(2);
        afterReserveIntegralField.setFormat("##,###,##0.00");
        afterReserveIntegralField.setRequired(false);
        afterReserveIntegralField.setHidden(true);

        transferIntegralField = new DataSourceFloatField("transferIntegral", "调整积分");
        transferIntegralField.setLength(10);
        transferIntegralField.setDecimalPad(2);
        transferIntegralField.setFormat("##,###,##0.00");
        transferIntegralField.setRequired(false);
        transferIntegralField.setHidden(false);

        transferDateField = new DataSourceDateField("transferDate", "转移日期");
        transferDateField.setRequired(false);
        transferDateField.setHidden(false);

        plateIdField = new DataSourceIntegerField("plateId", "板块");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        plateEmployeeIdField = new DataSourceIntegerField("plateEmployeeId", "板块负责人");
        plateEmployeeIdField.setLength(11);
        plateEmployeeIdField.setRequired(false);
        plateEmployeeIdField.setHidden(false);
        plateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

        remarkField = new DataSourceTextField("remark", "备注");
        remarkField.setLength(512);
        remarkField.setRequired(false);
        remarkField.setHidden(false);
        
        int roleID = ClientUtil.getRoleId();
        //只允许高管和板块负责人看预留积分
        if(roleID == RoleDefinition.ROLE_MANAGEMENT_TEAM || roleID == RoleDefinition.ROLE_DEPARTMENT_DIRECTOR){
            beforeReserveIntegralField.setHidden(false);
            afterReserveIntegralField.setHidden(false);
        }

        setFields(projectIntegralChangeRecordIdField, photoField,plateEmployeeIdField, plateIdField, projectIdField, beforeProjectIntegralField, afterProjectIntegralField, beforeReserveIntegralField, afterReserveIntegralField, transferIntegralField, transferDateField, remarkField);
    }

}
