package com.pomplatform.client.plateintegraldetail.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMplateIntegralDetail extends DBDataSource {

    public static DSMplateIntegralDetail instance = null;

    public static DSMplateIntegralDetail getInstance() {
        if (instance == null) {
            instance = new DSMplateIntegralDetail("DSMplateIntegralDetail");
        }
        return instance;
    }

    private final DataSourceTextField nameField;
    private final DataSourceIntegerField flagField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField reserveIntegralField;
    private final DataSourceIntegerField sureIntegralField;
    private final DataSourceIntegerField costIntegralField;
    private final DataSourceIntegerField salaryIntegralField;
    private final DataSourceIntegerField achieveIntegralField;

    public DSMplateIntegralDetail(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MplateIntegralDetail");

        nameField = new DataSourceTextField("name", "分类");
        nameField.setLength(64);
        nameField.setRequired(true);
        nameField.setHidden(false);

        flagField = new DataSourceIntegerField("flag", "标示");
        flagField.setLength(11);
        flagField.setRequired(true);
        flagField.setHidden(true);
        flagField.setValueMap(KeyValueManager.getValueMap("system_dictionary_34"));

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(true);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        reserveIntegralField = new DataSourceIntegerField("reserveIntegral", "预留积分");
        reserveIntegralField.setLength(64);
        reserveIntegralField.setRequired(false);
        reserveIntegralField.setHidden(false);

        sureIntegralField = new DataSourceIntegerField("sureIntegral", "确认积分");
        sureIntegralField.setLength(64);
        sureIntegralField.setRequired(true);
        sureIntegralField.setHidden(false);

        costIntegralField = new DataSourceIntegerField("costIntegral", "成本积分");
        costIntegralField.setLength(64);
        costIntegralField.setRequired(false);
        costIntegralField.setHidden(false);

        salaryIntegralField = new DataSourceIntegerField("salaryIntegral", "人工成本");
        salaryIntegralField.setLength(64);
        salaryIntegralField.setRequired(false);
        salaryIntegralField.setHidden(false);

        achieveIntegralField = new DataSourceIntegerField("achieveIntegral", "价值积分");
        achieveIntegralField.setLength(64);
        achieveIntegralField.setRequired(true);
        achieveIntegralField.setHidden(false);

        setFields(nameField, flagField, plateIdField, achieveIntegralField, reserveIntegralField, sureIntegralField, costIntegralField, salaryIntegralField);
    }

}
