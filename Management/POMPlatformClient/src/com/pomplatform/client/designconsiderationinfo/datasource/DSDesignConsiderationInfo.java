package com.pomplatform.client.designconsiderationinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSDesignConsiderationInfo extends DBDataSource {

    public static DSDesignConsiderationInfo instance = null;

    public static DSDesignConsiderationInfo getInstance() {
        if (instance == null) {
            instance = new DSDesignConsiderationInfo("DSDesignConsiderationInfo");
        }
        return instance;
    }

    private final DataSourceIntegerField designConsiderationIdField;
    private final DataSourceTextField mainDesignAreaNameField;
    private final DataSourceTextField subDesignAreaNameField;
    private final DataSourceIntegerField decorationStatusField;
    private final DataSourceFloatField designAreaField;
    private final DataSourceFloatField designUnitPriceField;
    private final DataSourceFloatField moneySumField;
    private final DataSourceIntegerField subContractIdField;

    public DSDesignConsiderationInfo(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("DesignConsiderationInfo");

        designConsiderationIdField = new DataSourceIntegerField("designConsiderationId", "设计要素编码");
        designConsiderationIdField.setLength(11);
        designConsiderationIdField.setPrimaryKey(true);
        designConsiderationIdField.setRequired(true);
        designConsiderationIdField.setHidden(true);

        mainDesignAreaNameField = new DataSourceTextField("mainDesignAreaName", "主设计区域");
        mainDesignAreaNameField.setLength(64);
        mainDesignAreaNameField.setRequired(false);
        mainDesignAreaNameField.setHidden(false);

        subDesignAreaNameField = new DataSourceTextField("subDesignAreaName", "子设计区域");
        subDesignAreaNameField.setLength(64);
        subDesignAreaNameField.setRequired(false);
        subDesignAreaNameField.setHidden(false);

        decorationStatusField = new DataSourceIntegerField("decorationStatus", "精简装状态");
        decorationStatusField.setLength(11);
        decorationStatusField.setRequired(false);
        decorationStatusField.setHidden(false);
        decorationStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_30"));

        designAreaField = new DataSourceFloatField("designArea", "设计面积");
        designAreaField.setLength(16);
        designAreaField.setDecimalPad(2);
        designAreaField.setFormat("##,###,###,###,##0.00");
        designAreaField.setRequired(false);
        designAreaField.setHidden(false);

        designUnitPriceField = new DataSourceFloatField("designUnitPrice", "设计单价");
        designUnitPriceField.setLength(16);
        designUnitPriceField.setDecimalPad(2);
        designUnitPriceField.setFormat("##,###,###,###,##0.00");
        designUnitPriceField.setRequired(false);
        designUnitPriceField.setHidden(false);

        moneySumField = new DataSourceFloatField("moneySum", "小计");
        moneySumField.setLength(16);
        moneySumField.setDecimalPad(2);
        moneySumField.setFormat("##,###,###,###,##0.00");
        moneySumField.setRequired(false);
        moneySumField.setHidden(false);

        subContractIdField = new DataSourceIntegerField("subContractId", "子合同编码");
        subContractIdField.setLength(11);
        subContractIdField.setRequired(false);
        subContractIdField.setHidden(true);

        setFields(designConsiderationIdField, mainDesignAreaNameField, subDesignAreaNameField, decorationStatusField, designAreaField, designUnitPriceField, moneySumField, subContractIdField);
    }

}
