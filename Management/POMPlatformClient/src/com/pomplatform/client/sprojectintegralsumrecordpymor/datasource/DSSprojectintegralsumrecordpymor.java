package com.pomplatform.client.sprojectintegralsumrecordpymor.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectintegralsumrecordpymor extends DBDataSource {

    public static DSSprojectintegralsumrecordpymor instance = null;

    public static DSSprojectintegralsumrecordpymor getInstance() {
        if (instance == null) {
            instance = new DSSprojectintegralsumrecordpymor("DSSprojectintegralsumrecordpymor");
        }
        return instance;
    }

    private final DataSourceTextField subContractCodeField;
    private final DataSourceTextField subContractNameField;
    private final DataSourceIntegerField projectIntegralSumRecordIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField yearField;
    private final DataSourceIntegerField monthField;
    private final DataSourceFloatField projectIntegralSumField;
    private final DataSourceFloatField reserveIntegralField;
    private final DataSourceFloatField projectIntegralField;
    private final DataSourceFloatField undistributedProjectIntegralField;
    private final DataSourceFloatField distributedProjectIntegralField;
    private final DataSourceFloatField unsureIntegralField;
    private final DataSourceFloatField sureIntegralField;
    private final DataSourceFloatField settlementIntegralField;
    private final DataSourceFloatField projectCostField;
    private final DataSourceFloatField settledProjectCostField;
    private final DataSourceFloatField unsettledProjectCostField;
    private final DataSourceIntegerField isLockField;
    private final DataSourceDateTimeField createTimeField;
    private final DataSourceDateTimeField updateTimeField;
    private final DataSourceTextField projectCodeField;

    public DSSprojectintegralsumrecordpymor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sprojectintegralsumrecordpymor");

        subContractCodeField = new DataSourceTextField("subContractCode", "子合同编号");
        subContractCodeField.setLength(64);
        subContractCodeField.setRequired(false);
        subContractCodeField.setHidden(false);
//        subContractCodeField.setValueMap(KeyValueManager.getValueMap("sub_contracts"));
        KeyValueManager.loadValueMap("sub_contracts",subContractCodeField);
        subContractNameField = new DataSourceTextField("subContractName", "子合同名称");
        subContractNameField.setLength(64);
        subContractNameField.setRequired(false);
        subContractNameField.setHidden(false);

        projectIntegralSumRecordIdField = new DataSourceIntegerField("projectIntegralSumRecordId", "主键编码");
        projectIntegralSumRecordIdField.setLength(11);
        projectIntegralSumRecordIdField.setPrimaryKey(true);
        projectIntegralSumRecordIdField.setRequired(true);
        projectIntegralSumRecordIdField.setHidden(true);

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(false);
        KeyValueManager.loadValueMap("projects",projectIdField);
        projectIdField.setHidden(true);

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(true);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        yearField = new DataSourceIntegerField("year", "年份");
        yearField.setLength(11);
        yearField.setRequired(false);
        yearField.setHidden(false);

        monthField = new DataSourceIntegerField("month", "月份");
        monthField.setLength(11);
        monthField.setRequired(false);
        monthField.setHidden(false);

        projectIntegralSumField = new DataSourceFloatField("projectIntegralSum", "项目总积分");
        projectIntegralSumField.setLength(15);
        projectIntegralSumField.setDecimalPad(2);
        projectIntegralSumField.setFormat("#,###,###,###,##0.00");
        projectIntegralSumField.setRequired(false);
        projectIntegralSumField.setHidden(false);

        reserveIntegralField = new DataSourceFloatField("reserveIntegral", "预留积分");
        reserveIntegralField.setLength(15);
        reserveIntegralField.setDecimalPad(2);
        reserveIntegralField.setFormat("#,###,###,###,##0.00");
        reserveIntegralField.setRequired(false);
        reserveIntegralField.setHidden(false);

        projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
        projectIntegralField.setLength(15);
        projectIntegralField.setDecimalPad(2);
        projectIntegralField.setFormat("#,###,###,###,##0.00");
        projectIntegralField.setRequired(false);
        projectIntegralField.setHidden(false);

        undistributedProjectIntegralField = new DataSourceFloatField("undistributedProjectIntegral", "未分配项目积分");
        undistributedProjectIntegralField.setLength(15);
        undistributedProjectIntegralField.setDecimalPad(2);
        undistributedProjectIntegralField.setFormat("#,###,###,###,##0.00");
        undistributedProjectIntegralField.setRequired(false);
        undistributedProjectIntegralField.setHidden(false);

        distributedProjectIntegralField = new DataSourceFloatField("distributedProjectIntegral", "已分配项目积分");
        distributedProjectIntegralField.setLength(15);
        distributedProjectIntegralField.setDecimalPad(2);
        distributedProjectIntegralField.setFormat("#,###,###,###,##0.00");
        distributedProjectIntegralField.setRequired(false);
        distributedProjectIntegralField.setHidden(false);

        unsureIntegralField = new DataSourceFloatField("unsureIntegral", "未确认积分");
        unsureIntegralField.setLength(15);
        unsureIntegralField.setDecimalPad(2);
        unsureIntegralField.setFormat("#,###,###,###,##0.00");
        unsureIntegralField.setRequired(false);
        unsureIntegralField.setHidden(false);

        sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
        sureIntegralField.setLength(15);
        sureIntegralField.setDecimalPad(2);
        sureIntegralField.setFormat("#,###,###,###,##0.00");
        sureIntegralField.setRequired(false);
        sureIntegralField.setHidden(false);

        settlementIntegralField = new DataSourceFloatField("settlementIntegral", "结算积分");
        settlementIntegralField.setLength(15);
        settlementIntegralField.setDecimalPad(2);
        settlementIntegralField.setFormat("#,###,###,###,##0.00");
        settlementIntegralField.setRequired(false);
        settlementIntegralField.setHidden(false);

        projectCostField = new DataSourceFloatField("projectCost", "项目成本");
        projectCostField.setLength(15);
        projectCostField.setDecimalPad(2);
        projectCostField.setFormat("#,###,###,###,##0.00");
        projectCostField.setRequired(false);
        projectCostField.setHidden(false);

        settledProjectCostField = new DataSourceFloatField("settledProjectCost", "已结算项目成本");
        settledProjectCostField.setLength(15);
        settledProjectCostField.setDecimalPad(2);
        settledProjectCostField.setFormat("#,###,###,###,##0.00");
        settledProjectCostField.setRequired(false);
        settledProjectCostField.setHidden(false);

        unsettledProjectCostField = new DataSourceFloatField("unsettledProjectCost", "未结算项目成本");
        unsettledProjectCostField.setLength(15);
        unsettledProjectCostField.setDecimalPad(2);
        unsettledProjectCostField.setFormat("#,###,###,###,##0.00");
        unsettledProjectCostField.setRequired(false);
        unsettledProjectCostField.setHidden(false);

        isLockField = new DataSourceIntegerField("isLock", "是否锁定");
        isLockField.setLength(11);
        isLockField.setRequired(false);
        isLockField.setHidden(true);

        java.util.Map<String, String> isLockValues = new java.util.HashMap<String, String>();
        isLockValues.put("0", "未锁定");
        isLockValues.put("1", "已锁定");
        isLockField.setValueMap(isLockValues);

        createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
        createTimeField.setRequired(false);
        createTimeField.setHidden(true);

        updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
        updateTimeField.setRequired(false);
        updateTimeField.setHidden(true);

        projectCodeField = new DataSourceTextField("projectCode", "项目编号");
        projectCodeField.setLength(64);
        projectCodeField.setRequired(false);
        projectCodeField.setHidden(true);
//        projectCodeField.setValueMap(KeyValueManager.getValueMap("main_projects"));

        KeyValueManager.loadValueMap("main_projects",projectCodeField);
        setFields(projectIntegralSumRecordIdField, subContractCodeField, subContractNameField, projectIdField, plateIdField, yearField, monthField, projectIntegralSumField, reserveIntegralField, projectIntegralField, undistributedProjectIntegralField, distributedProjectIntegralField, unsureIntegralField, sureIntegralField, settlementIntegralField, projectCostField, settledProjectCostField, unsettledProjectCostField, isLockField, createTimeField, updateTimeField, projectCodeField);
    }

}
