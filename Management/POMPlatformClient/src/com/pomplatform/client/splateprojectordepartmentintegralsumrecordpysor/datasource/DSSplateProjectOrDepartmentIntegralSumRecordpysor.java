package com.pomplatform.client.splateprojectordepartmentintegralsumrecordpysor.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSplateProjectOrDepartmentIntegralSumRecordpysor extends DBDataSource {

    public static DSSplateProjectOrDepartmentIntegralSumRecordpysor instance = null;

    public static DSSplateProjectOrDepartmentIntegralSumRecordpysor getInstance() {
        if (instance == null) {
            instance = new DSSplateProjectOrDepartmentIntegralSumRecordpysor("DSSplateProjectOrDepartmentIntegralSumRecordpysor");
        }
        return instance;
    }

    private final DataSourceIntegerField plateIdField;
    private final DataSourceTextField typeFlagNameField;
    private final DataSourceFloatField achieveIntegralField;
    private final DataSourceFloatField projectIntegralSumField;
    private final DataSourceFloatField projectIntegralField;
    private final DataSourceFloatField reserveIntegralField;
    private final DataSourceFloatField sureIntegralField;
    private final DataSourceFloatField costIntegralField;
    private final DataSourceFloatField settlementIntegralField;
    private final DataSourceFloatField salaryIntegralField;

    public DSSplateProjectOrDepartmentIntegralSumRecordpysor(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SplateProjectOrDepartmentIntegralSumRecordpysor");

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        typeFlagNameField = new DataSourceTextField("typeFlagName", "分类");
        typeFlagNameField.setLength(-1);
        typeFlagNameField.setRequired(true);
        typeFlagNameField.setHidden(false);

        achieveIntegralField = new DataSourceFloatField("achieveIntegral", "价值积分");
        achieveIntegralField.setLength(15);
        achieveIntegralField.setDecimalPad(2);
        achieveIntegralField.setFormat("#,###,###,###,##0.00");
        achieveIntegralField.setRequired(false);
        achieveIntegralField.setHidden(false);

        projectIntegralSumField = new DataSourceFloatField("projectIntegralSum", "项目总积分");
        projectIntegralSumField.setLength(15);
        projectIntegralSumField.setDecimalPad(2);
        projectIntegralSumField.setFormat("#,###,###,###,##0.00");
        projectIntegralSumField.setRequired(false);
        projectIntegralSumField.setHidden(false);

        projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
        projectIntegralField.setLength(15);
        projectIntegralField.setDecimalPad(2);
        projectIntegralField.setFormat("#,###,###,###,##0.00");
        projectIntegralField.setRequired(false);
        projectIntegralField.setHidden(false);

        reserveIntegralField = new DataSourceFloatField("reserveIntegral", "预留积分");
        reserveIntegralField.setLength(15);
        reserveIntegralField.setDecimalPad(2);
        reserveIntegralField.setFormat("#,###,###,###,##0.00");
        reserveIntegralField.setRequired(false);
        reserveIntegralField.setHidden(false);

        sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
        sureIntegralField.setLength(15);
        sureIntegralField.setDecimalPad(2);
        sureIntegralField.setFormat("#,###,###,###,##0.00");
        sureIntegralField.setRequired(false);
        sureIntegralField.setHidden(false);

        costIntegralField = new DataSourceFloatField("costIntegral", "成本积分");
        costIntegralField.setLength(15);
        costIntegralField.setDecimalPad(2);
        costIntegralField.setFormat("#,###,###,###,##0.00");
        costIntegralField.setRequired(false);
        costIntegralField.setHidden(false);

        settlementIntegralField = new DataSourceFloatField("settlementIntegral", "结算积分");
        settlementIntegralField.setLength(15);
        settlementIntegralField.setDecimalPad(2);
        settlementIntegralField.setFormat("#,###,###,###,##0.00");
        settlementIntegralField.setRequired(false);
        settlementIntegralField.setHidden(false);

        salaryIntegralField = new DataSourceFloatField("salaryIntegral", "人工成本");
        salaryIntegralField.setLength(15);
        salaryIntegralField.setDecimalPad(2);
        salaryIntegralField.setFormat("#,###,###,###,##0.00");
        salaryIntegralField.setRequired(false);
        salaryIntegralField.setHidden(false);

        setFields(plateIdField, typeFlagNameField, achieveIntegralField, projectIntegralSumField, projectIntegralField, reserveIntegralField, sureIntegralField, costIntegralField, settlementIntegralField, salaryIntegralField);
    }

}
