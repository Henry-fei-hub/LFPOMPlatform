package com.pomplatform.client.workflow.reimbursement.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;

public class DSReimbursementDetail extends DBDataSource {

    public static DSReimbursementDetail instance = null;

    public static DSReimbursementDetail getInstance() {
        if (instance == null) {
            instance = new DSReimbursementDetail("DSReimbursementDetail");
        }
        return instance;
    }

    private final DataSourceIntegerField reimbursementDetailIdField;
    private final DataSourceIntegerField reimbursementIdField;
    private final DataSourceIntegerField itemIdField;
    private final DataSourceFloatField amountField;
    private final DataSourceDateField happenDateField;
    private final DataSourceTextField remarkField;

    public DSReimbursementDetail(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_TABLE);
        setActionName("ReimbursementDetail");

        reimbursementDetailIdField = new DataSourceIntegerField("reimbursementDetailId", "明细代码");
        reimbursementDetailIdField.setLength(11);
        reimbursementDetailIdField.setPrimaryKey(true);
        reimbursementDetailIdField.setRequired(true);
        reimbursementDetailIdField.setHidden(true);

        reimbursementIdField = new DataSourceIntegerField("reimbursementId", "报销代码");
        reimbursementIdField.setLength(11);
        reimbursementIdField.setRequired(true);
        reimbursementIdField.setHidden(true);

        itemIdField = new DataSourceIntegerField("itemId", "所属项目");
        itemIdField.setLength(11);
        itemIdField.setRequired(false);
        itemIdField.setHidden(false);

        amountField = new DataSourceFloatField("amount", "金额");
        amountField.setLength(18);
        amountField.setDecimalPad(2);
        amountField.setFormat("#,###,###,###,###,##0.00");
        amountField.setRequired(false);
        amountField.setHidden(false);

        happenDateField = new DataSourceDateField("happenDate", "发生日期");
        happenDateField.setRequired(false);
        happenDateField.setHidden(false);

        remarkField = new DataSourceTextField("remark", "费用说明");
        remarkField.setLength(256);
        remarkField.setRequired(false);
        remarkField.setHidden(false);

        setFields(reimbursementDetailIdField, reimbursementIdField, itemIdField, amountField, happenDateField, remarkField);
    }

}
