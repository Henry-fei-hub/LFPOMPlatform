package com.pomplatform.client.subcontractinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSubContractCustomOpenInfo extends DBDataSource {

    public static DSSubContractCustomOpenInfo instance = null;

    public static DSSubContractCustomOpenInfo getInstance() {
        if (instance == null) {
            instance = new DSSubContractCustomOpenInfo("DSSubContractCustomOpenInfo");
        }
        return instance;
    }

    private final DataSourceIntegerField subContractIdField;
    private final DataSourceIntegerField parentIdField;
    private final DataSourceTextField subContractCodeField;
    private final DataSourceTextField projectCodeField;
    private final DataSourceIntegerField businessTypeField;
    private final DataSourceIntegerField projectTypeField;
    private final DataSourceIntegerField departmentIdField;
    private final DataSourceFloatField commonAreaField;
    private final DataSourceFloatField logisticsAreaField;
    private final DataSourceFloatField moneySumField;
    private final DataSourceDateTimeField createTimeField;
    private final DataSourceTextField subContractNameField;
    private final DataSourceDateTimeField updateTimeField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceFloatField designAreaField;
    private final DataSourceFloatField projectIntegralField;

    public DSSubContractCustomOpenInfo(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SubContractInfo");

        subContractIdField = new DataSourceIntegerField("subContractId", "子合同编码");
        subContractIdField.setLength(11);
        subContractIdField.setPrimaryKey(true);
        subContractIdField.setRequired(true);
        subContractIdField.setHidden(true);

        parentIdField = new DataSourceIntegerField("parentId", "主合同");
        parentIdField.setLength(11);
        parentIdField.setRequired(false);
        parentIdField.setHidden(false);
        parentIdField.setForeignKey("DSContractCustomOpenInfo.contractId");
//        parentIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
        KeyValueManager.loadValueMap("contracts_1", parentIdField);

        subContractCodeField = new DataSourceTextField("subContractCode", "子合同编号");
        subContractCodeField.setLength(64);
        subContractCodeField.setRequired(false);
        subContractCodeField.setHidden(false);

        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(false);
        projectCodeField.setHidden(false);

        businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
        businessTypeField.setLength(11);
        businessTypeField.setRequired(false);
        businessTypeField.setHidden(false);
        businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

        projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
        projectTypeField.setLength(11);
        projectTypeField.setRequired(false);
        projectTypeField.setHidden(false);
        projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));

        departmentIdField = new DataSourceIntegerField("departmentId", "承接部门");
        departmentIdField.setLength(11);
        departmentIdField.setRequired(false);
        departmentIdField.setHidden(false);
        departmentIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_34"));

        commonAreaField = new DataSourceFloatField("commonArea", "公区面积");
        commonAreaField.setLength(10);
        commonAreaField.setDecimalPad(2);
        commonAreaField.setFormat("##,###,##0.00");
        commonAreaField.setRequired(false);
        commonAreaField.setHidden(false);

        logisticsAreaField = new DataSourceFloatField("logisticsArea", "后勤面积");
        logisticsAreaField.setLength(10);
        logisticsAreaField.setDecimalPad(2);
        logisticsAreaField.setFormat("##,###,##0.00");
        logisticsAreaField.setRequired(false);
        logisticsAreaField.setHidden(false);

        moneySumField = new DataSourceFloatField("moneySum", "小计");
        moneySumField.setLength(10);
        moneySumField.setDecimalPad(2);
        moneySumField.setFormat("##,###,##0.00");
        moneySumField.setRequired(false);
        moneySumField.setHidden(false);

        createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
        createTimeField.setRequired(false);
        createTimeField.setHidden(false);

        subContractNameField = new DataSourceTextField("subContractName", "子合同名称");
        subContractNameField.setLength(64);
        subContractNameField.setRequired(false);
        subContractNameField.setHidden(false);

        updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
        updateTimeField.setRequired(false);
        updateTimeField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目编码");
        projectIdField.setLength(11);
        projectIdField.setPrimaryKey(true);
        projectIdField.setRequired(true);
        projectIdField.setHidden(true);
        
        projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
        projectIntegralField.setLength(10);
        projectIntegralField.setDecimalPad(2);
        projectIntegralField.setFormat("##,###,##0.00");
        projectIntegralField.setRequired(false);
        projectIntegralField.setHidden(false);
        
        designAreaField = new DataSourceFloatField("designArea", "设计面积");
        designAreaField.setLength(10);
        designAreaField.setDecimalPad(2);
        designAreaField.setFormat("##,###,##0.00");
        designAreaField.setRequired(false);
        designAreaField.setHidden(false);
        setFields(subContractIdField, projectIdField, subContractCodeField, subContractNameField, businessTypeField, projectTypeField, departmentIdField, commonAreaField, logisticsAreaField, moneySumField, projectCodeField, parentIdField, createTimeField, updateTimeField, projectIntegralField, designAreaField);
    }

}
