package com.pomplatform.client.plateintegraltotal.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMplateIntegralTotal extends DBDataSource {

    public static DSMplateIntegralTotal instance = null;

    public static DSMplateIntegralTotal getInstance() {
        if (instance == null) {
            instance = new DSMplateIntegralTotal("DSMplateIntegralTotal");
        }
        return instance;
    }

    private final DataSourceTextField plateIdField;
    private final DataSourceIntegerField reserveIntegralField;
    private final DataSourceIntegerField sureIntegralField;
    private final DataSourceIntegerField costIntegralField;
    private final DataSourceIntegerField salaryIntegralField;
    private final DataSourceIntegerField achieveIntegralField;

    public DSMplateIntegralTotal(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("MplateIntegralTotal");

        plateIdField = new DataSourceTextField("plateId", "业务部门");
        plateIdField.setLength(20);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
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

        setFields(plateIdField, achieveIntegralField, reserveIntegralField, sureIntegralField, costIntegralField, salaryIntegralField);
    }

}
