package com.pomplatform.client.sprojectintegralsumrecordpysor.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectintegralsumrecordpysor extends DBDataSource {

    public static DSSprojectintegralsumrecordpysor instance = null;

    public static DSSprojectintegralsumrecordpysor getInstance() {
        if (instance == null) {
            instance = new DSSprojectintegralsumrecordpysor("DSSprojectintegralsumrecordpysor");
        }
        return instance;
    }

    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField projectIdField;
    private final DataSourceFloatField projectIntegralSumField;
    private final DataSourceFloatField reserveIntegralField;
    private final DataSourceFloatField projectIntegralField;
    private final DataSourceFloatField distributedProjectIntegralField;
    private final DataSourceFloatField undistributedProjectIntegralField;
    private final DataSourceFloatField sureIntegralField;
    private final DataSourceFloatField unsureIntegralField;
    private final DataSourceFloatField projectCostField;
    private final DataSourceFloatField settledProjectCostField;
    private final DataSourceFloatField unsettledProjectCostField;
    private final DataSourceTextField settlementIntegralField;

    public DSSprojectintegralsumrecordpysor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("Sprojectintegralsumrecordpysor");

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        projectIdField = new DataSourceIntegerField("projectId", "项目名称");
        projectIdField.setLength(11);
        projectIdField.setRequired(false);
        projectIdField.setHidden(false);
        KeyValueManager.loadValueMap("projects",projectIdField);

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

        distributedProjectIntegralField = new DataSourceFloatField("distributedProjectIntegral", "已分配项目积分");
        distributedProjectIntegralField.setLength(15);
        distributedProjectIntegralField.setDecimalPad(2);
        distributedProjectIntegralField.setFormat("#,###,###,###,##0.00");
        distributedProjectIntegralField.setRequired(false);
        distributedProjectIntegralField.setHidden(false);

        undistributedProjectIntegralField = new DataSourceFloatField("undistributedProjectIntegral", "未分配项目积分");
        undistributedProjectIntegralField.setLength(15);
        undistributedProjectIntegralField.setDecimalPad(2);
        undistributedProjectIntegralField.setFormat("#,###,###,###,##0.00");
        undistributedProjectIntegralField.setRequired(false);
        undistributedProjectIntegralField.setHidden(false);

        sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
        sureIntegralField.setLength(15);
        sureIntegralField.setDecimalPad(2);
        sureIntegralField.setFormat("#,###,###,###,##0.00");
        sureIntegralField.setRequired(false);
        sureIntegralField.setHidden(false);

        unsureIntegralField = new DataSourceFloatField("unsureIntegral", "未确认积分");
        unsureIntegralField.setLength(15);
        unsureIntegralField.setDecimalPad(2);
        unsureIntegralField.setFormat("#,###,###,###,##0.00");
        unsureIntegralField.setRequired(false);
        unsureIntegralField.setHidden(false);

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

        settlementIntegralField = new DataSourceTextField("settlementIntegral", "结算积分");
        settlementIntegralField.setLength(15);
        settlementIntegralField.setDecimalPad(2);
        settlementIntegralField.setFormat("#,###,###,###,##0.00");
        settlementIntegralField.setRequired(false);
        settlementIntegralField.setHidden(false);

        setFields(plateIdField, projectIdField, projectIntegralSumField, reserveIntegralField, projectIntegralField, distributedProjectIntegralField, undistributedProjectIntegralField, sureIntegralField, unsureIntegralField, projectCostField, settledProjectCostField, unsettledProjectCostField, settlementIntegralField);
    }

}
