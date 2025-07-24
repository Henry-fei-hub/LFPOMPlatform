package com.pomplatform.client.contractinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContractCustomInfo extends DBDataSource {

    public static DSContractCustomInfo instance = null;

    public static DSContractCustomInfo getInstance() {
        if (instance == null) {
            instance = new DSContractCustomInfo("DSContractCustomInfo");
        }
        return instance;
    }

    private final DataSourceIntegerField contractIdField;
    private final DataSourceIntegerField parentIdField;
    private final DataSourceTextField contractCodeField;
    private final DataSourceTextField contractNameField;
    private final DataSourceTextField customerNameField;
    private final DataSourceDateField startDateField;
    private final DataSourceDateField endDateField;
    private final DataSourceIntegerField statusField;
    private final DataSourceTextField projectCodeField;
    private final DataSourceIntegerField contractTypeField;
    private final DataSourceTextField businessTypeField;
    private final DataSourceIntegerField projectLevelField;
    private final DataSourceIntegerField totalProjectTimeField;
    private final DataSourceFloatField signingMoneySumField;
    private final DataSourceFloatField designAreasField;
    private final DataSourceFloatField contractPriceField;
    private final DataSourceTextField projectAddressField;
    private final DataSourceIntegerField contractFollowerField;
    private final DataSourceTextField remarkField;
    private final DataSourceDateField contractDateField;
    private final DataSourceIntegerField signingCompanyNameField;
    private final DataSourceIntegerField flowStatusField;
    private final DataSourceDateTimeField createTimeField;
    private final DataSourceDateTimeField updateTimeField;

    public DSContractCustomInfo(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("CustomMainContractHandler");
        
        parentIdField = new DataSourceIntegerField("parentId", "主订单编码");
        parentIdField.setLength(11);
        parentIdField.setPrimaryKey(true);
        parentIdField.setRequired(true);
        parentIdField.setHidden(true);

        contractIdField = new DataSourceIntegerField("contractId", "合同编码");
        contractIdField.setLength(11);
        contractIdField.setPrimaryKey(true);
        contractIdField.setRequired(true);
        contractIdField.setHidden(true);
        contractIdField.setRootValue("root");  
        contractIdField.setForeignKey("DSContractCustomInfo.contractId");  

        contractCodeField = new DataSourceTextField("contractCode", "合同编号");
        contractCodeField.setLength(64);
        contractCodeField.setRequired(false);
        contractCodeField.setHidden(false);

        contractNameField = new DataSourceTextField("contractName", "合同名称");
        contractNameField.setLength(512);
        contractNameField.setRequired(false);
        contractNameField.setHidden(false);

        customerNameField = new DataSourceTextField("customerName", "客户名称");
        customerNameField.setLength(512);
        customerNameField.setRequired(false);
        customerNameField.setHidden(false);

        startDateField = new DataSourceDateField("startDate", "开始日期");
        startDateField.setRequired(false);
        startDateField.setHidden(true);

        endDateField = new DataSourceDateField("endDate", "结束日期");
        endDateField.setRequired(false);
        endDateField.setHidden(true);

        statusField = new DataSourceIntegerField("status", "结算状态");
        statusField.setLength(11);
        statusField.setRequired(false);
        statusField.setHidden(true);
        statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));

        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(true);
        projectCodeField.setHidden(false);

        contractTypeField = new DataSourceIntegerField("contractType", "订单类别");
        contractTypeField.setLength(11);
        contractTypeField.setRequired(false);
        contractTypeField.setHidden(false);
        contractTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_27"));

        businessTypeField = new DataSourceTextField("businessType", "业务类别");
        businessTypeField.setLength(120);
        businessTypeField.setRequired(false);
        businessTypeField.setHidden(false);

        projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
        projectLevelField.setLength(11);
        projectLevelField.setRequired(false);
        projectLevelField.setHidden(false);
        projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));

        totalProjectTimeField = new DataSourceIntegerField("totalProjectTime", "项目总工期");
        totalProjectTimeField.setLength(11);
        totalProjectTimeField.setRequired(false);
        totalProjectTimeField.setHidden(false);

        signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
        signingMoneySumField.setLength(10);
        signingMoneySumField.setDecimalPad(2);
        signingMoneySumField.setFormat("##,###,##0.00");
        signingMoneySumField.setRequired(false);
        signingMoneySumField.setHidden(false);

        designAreasField = new DataSourceFloatField("designAreas", "总设计面积");
        designAreasField.setLength(10);
        designAreasField.setDecimalPad(2);
        designAreasField.setFormat("##,###,##0.00");
        designAreasField.setRequired(false);
        designAreasField.setHidden(false);

        contractPriceField = new DataSourceFloatField("contractPrice", "订单单价");
        contractPriceField.setLength(10);
        contractPriceField.setDecimalPad(2);
        contractPriceField.setFormat("##,###,##0.00");
        contractPriceField.setRequired(false);
        contractPriceField.setHidden(true);

        projectAddressField = new DataSourceTextField("projectAddress", "项目地点");
        projectAddressField.setLength(200);
        projectAddressField.setRequired(true);
        projectAddressField.setHidden(true);

        contractFollowerField = new DataSourceIntegerField("contractFollower", "订单跟进人");
        contractFollowerField.setLength(11);
        contractFollowerField.setRequired(false);
        contractFollowerField.setHidden(true);
        contractFollowerField.setValueMap(KeyValueManager.getValueMap("employees"));

        remarkField = new DataSourceTextField("remark", "备注");
        remarkField.setLength(512);
        remarkField.setRequired(true);
        remarkField.setHidden(true);

        contractDateField = new DataSourceDateField("contractDate", "订单签订日期");
        contractDateField.setRequired(false);
        contractDateField.setHidden(true);

        signingCompanyNameField = new DataSourceIntegerField("signingCompanyName", "我方签约公司名称");
        signingCompanyNameField.setLength(11);
        signingCompanyNameField.setRequired(false);
        signingCompanyNameField.setHidden(true);
        signingCompanyNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

        flowStatusField = new DataSourceIntegerField("flowStatus", "审核状态");
        flowStatusField.setLength(11);
        flowStatusField.setRequired(false);
        flowStatusField.setHidden(true);
        flowStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_33"));

        createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
        createTimeField.setRequired(false);
        createTimeField.setHidden(true);

        updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
        updateTimeField.setRequired(false);
        updateTimeField.setHidden(true);

        setFields(parentIdField, contractIdField, contractCodeField, contractNameField, customerNameField, businessTypeField, projectLevelField, totalProjectTimeField, signingMoneySumField, designAreasField, contractPriceField, projectAddressField, contractFollowerField, statusField, projectCodeField, contractTypeField, remarkField, contractDateField, signingCompanyNameField, flowStatusField, startDateField, endDateField, createTimeField, updateTimeField);
    }

}
